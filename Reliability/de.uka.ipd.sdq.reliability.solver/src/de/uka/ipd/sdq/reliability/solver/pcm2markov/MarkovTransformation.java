package de.uka.ipd.sdq.reliability.solver.pcm2markov;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.markov.MarkovChain;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.runconfig.PCMSolverWorkflowRunConfiguration;
import de.uka.ipd.sdq.pcmsolver.visitors.UsageModelVisitor;
import de.uka.ipd.sdq.reliability.core.MarkovEvaluationType;
import de.uka.ipd.sdq.reliability.core.MarkovFailureType;
import de.uka.ipd.sdq.reliability.core.helper.MarkovFailureTypeHelper;
import de.uka.ipd.sdq.reliability.solver.MarkovSolver;
import de.uka.ipd.sdq.reliability.solver.sensitivity.MarkovSensitivity;

/**
 * This class has the functionality to perform a complete PCM2Markov transformation.
 * 
 * @author brosch
 * 
 */
public class MarkovTransformation {

    /**
     * A LOGGER to give detailed information about the PCM instance transformation.
     */
    private static final Logger LOGGER = Logger.getLogger(MarkovTransformation.class.getName());

    /**
     * Provides functionality to manage failure types.
     */
    private final MarkovFailureTypeHelper helper = new MarkovFailureTypeHelper();

    /**
     * Checks whether there exists a next permutation based on the current one (which is given by
     * the resources' current states). Generates the next permutation, if it exists, according to
     * Narayana Pandita's method of systematically generating all permutations, and sets the
     * resources' states accordingly.
     * 
     * @param descriptors
     *            a list containing the processing resource descriptors
     * @return true, if a new permutation was generated; false otherwise
     */
    private boolean createNextPermutation(final List<ProcessingResourceDescriptor> descriptors) {
        int size = descriptors.size();

        int k = -1; // used for step 1 (see below)
        int l; // used for step 2 (see below)
        MarkovResourceState tmp; // used for step 4 (see below)
        int left; // used for step 4 (see below)
        int right; // used for step 4 (see below)

        /*
         * Systematic generation of all permutations according to Narayana Pandita.
         */

        // 1. Find the largest index k such that a[k] < a[k + 1]. If no such
        // index exists the permutation
        // is the last permutation. [wikipedia]
        for (int i = 0; i < size - 1; i++) {
            if (descriptors.get(i).getCurrentState() == MarkovResourceState.NA
                    && descriptors.get(i + 1).getCurrentState() == MarkovResourceState.OK) {
                k = i;
            }
        }
        if (k == -1) {
            return false; // no such index exists (i.e., there is no next
            // permutation) - return false
        }

        // 2. Find the largest index l such that a[k] < a[l]. Since k + 1 is
        // such an index, l is
        // well defined and satisfies k < l. [wikipedia]
        // Situation so far: a[k] = N/A, a[k+1] = OK.
        // Now look for an l such that l > (k+1), and a[l] = OK.
        l = k + 1; // a[k+1] is definitely OK. We may find another one, though:
        for (int i = k + 2; i < size; i++) {
            if (descriptors.get(i).getCurrentState() == MarkovResourceState.OK) {
                l = i; // new such index found, update l
            }
        }

        // 3. Swap a[k] with a[l] [wikipedia]
        // I.e., switch their states.
        descriptors.get(k).switchState();
        descriptors.get(l).switchState();

        // 4. Reverse the sequence from a[k + 1] up to and including the final
        // element a[n]. [wikipedia]
        for (left = k + 1, right = size - 1; left < right; left++, right--) {
            // swap right and left
            tmp = descriptors.get(left).getCurrentState();
            descriptors.get(left).setCurrentState(descriptors.get(right).getCurrentState());
            descriptors.get(right).setCurrentState(tmp);
        }

        return true; // next permutation successfully generated - return true
    }

    /**
     * Retrieves the failure types evaluation mode from a given analysis configuration.
     * 
     * @param configuration
     *            the analysis configuration
     * @return the evaluation mode
     */
    private MarkovEvaluationType getEvaluationMode(PCMSolverWorkflowRunConfiguration configuration) {
        return MarkovEvaluationType.valueOf(configuration.getMarkovEvaluationMode());
    }

    /**
     * Sets the leftmost <i>m</i> resources in the descriptors list to N/A.
     * 
     * @param descriptors
     *            a list containing the processing resource descriptors
     * @param m
     *            the number of leftmost resources that will be set to N/A
     */
    private void initializeResourceStates(final List<ProcessingResourceDescriptor> descriptors, final int m) {
        int size = descriptors.size();
        // set m leftmost resources to N/A
        for (int i = 0; i < m; i++) {
            descriptors.get(i).setCurrentState(MarkovResourceState.NA);
        }
        // set remaining (n-m) resources to OK
        for (int i = m; i < size; i++) {
            descriptors.get(i).setCurrentState(MarkovResourceState.OK);
        }
    }

    /**
     * Checks whether a termination condition - possibly specified by the user - holds.
     * 
     * @param configuration
     *            configuration properties for the reliability solver workflow
     * @param markovResult
     *            results of the PCM2MarkovTransformation
     * @param startTimeMs
     *            indicates when the process started. This needs to be a value in milliseconds
     *            determined by having called System.currentTimeMillis().
     * @return true, if a termination condition holds; false otherwise
     */
    private boolean isStopConditionReached(final PCMSolverWorkflowRunConfiguration configuration,
            final MarkovTransformationResult markovResult, final long startTimeMs) {

        // check solving time limit
        if (configuration.isSolvingTimeLimitEnabled()) {
            // solving time limit reached?
            if (System.currentTimeMillis() - startTimeMs >= configuration.getSolvingTimeLimit() * 1000) {
                // yes, stop condition holds - return true
                LOGGER.info("Maximal solving time (" + configuration.getSolvingTimeLimit()
                        + " seconds) reached - stopping!");
                return true;
            }
        }

        // check limit for the number of evaluated physical system states
        if (configuration.isNumberOfEvaluatedSystemStatesEnabled()) {
            // maximum number of system states to be evaluated reached?
            if (markovResult.getPhysicalStateEvaluationCount() == configuration.getNumberOfEvaluatedSystemStates()) {
                // yes, stop condition holds - return true
                LOGGER.info("Maximal number of evaluated system states ("
                        + configuration.getNumberOfEvaluatedSystemStates() + ") reached - stopping!");
                return true;
            }
        }

        // check limit for the number of exact decimal places
        if (configuration.isNumberOfExactDecimalPlacesEnabled()) {
            // required number of exact decimal places reached?
            if (markovResult.hasRequiredAccuracy(configuration.getNumberOfExactDecimalPlaces())) {
                // yes, stop condition holds - return true
                LOGGER.info("Required number of exact decimal places (" + configuration.getNumberOfExactDecimalPlaces()
                        + ") reached - stopping!");
                return true;
            }
        }

        // no stop condition holds - return false
        return false;
    }

    /**
     * Solves all parametric dependencies within a given PCM instance.
     * 
     * @param markovSource
     *            state information required during the PCM2MarkovTransformation
     * @param scenario
     *            the usage scenario to evaluate
     */
    private void runDSolver(final UsageScenario scenario, final MarkovTransformationSource markovSource) {

        LOGGER.debug("Resolving parametric dependencies.");
        // Record the time consumed for solving parametric dependencies:
        long startTime = System.nanoTime();

        // The parametric dependencies are solved by using a visitor:
        UsageModelVisitor visitor = new UsageModelVisitor(markovSource.getModel());

        // Solve the PCM instance using the visitor:
        visitor.doSwitch(scenario.getScenarioBehaviour_UsageScenario());

        // Let the user know about the time consumed:
        long stopTime = System.nanoTime();
        long duration = TimeUnit.NANOSECONDS.toMillis(stopTime - startTime);
        LOGGER.info("Solved parametric dependencies: " + duration + " ms");
    }

    /**
     * Transforms the given PCM instance into a Markov Chain instance. The PCM instance is assumed
     * to have all parametric dependencies solved.
     * 
     * @param configuration
     *            configuration properties for the reliability solver workflow
     * @param scenario
     *            the UsageScenario to evaluate
     * @param markovSource
     *            state information required during the PCM2MarkovTransformation
     * @param markovResult
     *            results of the PCM2MarkovTransformation
     * @return true if the transformation has stopped before completion, such that the result has to
     *         be approximated
     */
    private boolean runPcm2Markov(final PCMSolverWorkflowRunConfiguration configuration, final UsageScenario scenario,
            final MarkovTransformationSource markovSource, final MarkovTransformationResult markovResult) {

        LOGGER.debug("Transforming PCM model into analysis model.");

        // Declare the result variable:
        boolean approximate = false;

        // Record the time consumed for creating the Markov Chain instance:
        long startTime = System.nanoTime();

        // Check for the requested state handling strategy:
        if (!configuration.isIterationOverPhysicalSystemStatesEnabled()) {
            // Run a single Markov transformation according to the
            // "always ask" strategy:
            runPcm2MarkovSingle(configuration, scenario, markovSource, markovResult);
        } else {
            // Repeat the transformation for all physical system states:
            approximate = runPcm2MarkovIteratively(configuration, scenario, markovSource, markovResult);
        }

        // Let the user know about the time consumed:
        long stopTime = System.nanoTime();
        long duration = TimeUnit.NANOSECONDS.toMillis(stopTime - startTime);
        LOGGER.info("Finished Markov transformation: " + duration + " ms");
        if (configuration.isIterationOverPhysicalSystemStatesEnabled()) {
            LOGGER.info("Number of evaluated physical system states: " + markovResult.getPhysicalStateEvaluationCount()
                    + " out of " + markovResult.getNumberOfPhysicalSystemStates());
        }

        // Return the result:
        return approximate;
    }

    /**
     * Runs the PCM 2 Markov transformation for all possible classes, or until at least one of the
     * possible termination conditions holds.
     * 
     * @param configuration
     *            configuration properties for the reliability solver workflow
     * @param scenario
     *            the UsageScenario to evaluate
     * @param markovSource
     *            state information required during the PCM2MarkovTransformation
     * @param markovResult
     *            results of the PCM2MarkovTransformation
     * @return true if the transformation has stopped before completion, such that the result has to
     *         be approximated
     */
    private boolean runPcm2MarkovIteratively(final PCMSolverWorkflowRunConfiguration configuration,
            final UsageScenario scenario, final MarkovTransformationSource markovSource,
            final MarkovTransformationResult markovResult) {

        // Remember the start time of the transformation:
        long startTimeMs = System.currentTimeMillis();

        // Some short notations:
        List<ProcessingResourceDescriptor> descriptors = markovSource.getUnreliableResourceDescriptors();
        final int size = descriptors.size();

        /*
         * Now, for all n resources: Let m out of n (for m in 0..(n-1)) resources fail in an
         * iteration, considering first the resources that are most likely to fail, moving on to
         * resources that are less likely to fail, finally considering the resources that are least
         * likely to fail.
         */
        for (int permutationClass = 0; permutationClass <= size; permutationClass++) {

            /*
             * Consider the current permutation first, where the m leftmost resources are set to
             * N/A, while the remaining ones are OK.
             */

            // set m leftmost out of n resources total to N/A state
            initializeResourceStates(descriptors, permutationClass);

            // markovSource.printCurrentResourceStates();

            // Evaluate the physical system state:
            runPcm2MarkovSingle(configuration, scenario, markovSource, markovResult);

            // Check if any of the stop conditions is reached:
            if (isStopConditionReached(configuration, markovResult, startTimeMs)) {
                return true;
            }

            /*
             * Now generate all other permutations where m out of n ("n choose m") resources are
             * N/A.
             */
            for (;;) {

                // see if there's a next permutation
                if (!createNextPermutation(descriptors)) {
                    break; // there's no new permutation - leave inner for loop
                }

                // markovSource.printCurrentResourceStates();

                /*
                 * At this point, we have a new permutation, i.e. system state. It was generated via
                 * the createNextPermutation(descriptors) call above.
                 */

                // Evaluate the physical system state:
                runPcm2MarkovSingle(configuration, scenario, markovSource, markovResult);

                // Check if any of the stop conditions is reached:
                if (isStopConditionReached(configuration, markovResult, startTimeMs)) {
                    return true;
                }
            } // end for: generation of all "n choose m" permutations
        } // end for: m out of n resources N/A

        // The whole transformation has been performed without reaching any stop
        // conditions:
        return false;
    }

    /**
     * Evaluates a single physical system state.
     * 
     * @param configuration
     *            configuration properties for the reliability solver workflow
     * @param scenario
     *            the UsageScenario to evaluate
     * @param markovSource
     *            state information required during the PCM2MarkovTransformation
     * @param markovResult
     *            results of the PCM2MarkovTransformation
     */
    private void runPcm2MarkovSingle(final PCMSolverWorkflowRunConfiguration configuration,
            final UsageScenario scenario, final MarkovTransformationSource markovSource,
            final MarkovTransformationResult markovResult) {

        // Retrieve the MarkovSolver singleton instance:
        MarkovSolver solver = MarkovSolver.getSingletonInstance();

        // If Markov statistics printing is switched on, do the first physical
        // state evaluation without Markov chain reduction, and count the number
        // of resulting Markov states:
        boolean countStates = configuration.isPrintMarkovStatistics()
                && (markovResult.getPhysicalStateEvaluationCount() == 0);

        // calculate current state probability
        double physicalStateProbability = 1.0;
        if (configuration.isIterationOverPhysicalSystemStatesEnabled()) {
            for (ProcessingResourceDescriptor descriptor : markovSource.getUnreliableResourceDescriptors()) {
                physicalStateProbability *= descriptor.getStateProbability(descriptor.getCurrentState());
            }
        }

        // The Markov Chain instance is created by using a visitor:
        // MarkovUsageModelVisitor visitor = new MarkovUsageModelVisitor(
        // markovSource, !countStates);
        MarkovUsageModelVisitor visitor = new MarkovUsageModelVisitor(markovSource, getEvaluationMode(configuration),
                !configuration.isIterationOverPhysicalSystemStatesEnabled(),
                configuration.isMarkovModelReductionEnabled(), configuration.isMarkovModelTracesEnabled());

        // Create the Markov Chain instance using the visitor:
        MarkovChain resultChain = visitor.doSwitch(scenario.getScenarioBehaviour_UsageScenario());

        // Display information to the user:
        if (countStates) {
            LOGGER.info("Number of Markov states per evaluated physical system state:\t"
                    + resultChain.getStates().size());
            LOGGER.info("Number of Markov transitions per evaluated physical system state:\t"
                    + resultChain.getTransitions().size());
        }

        // Solve the Markov Chain, and add the result to the overall success
        // probability, weighted by the probability of the current resource
        // state combination:
        double[][] markovProbabilityMatrix = solver.solve(resultChain);

        // Add the results of this evaluation:
        markovResult.addPhysicalStateResults(resultChain, markovProbabilityMatrix, physicalStateProbability);
    }

    /**
     * Transforms a PCM instance into a Markov Chain instance.
     * 
     * The transformation is performed in two steps. In the first step, parametric dependencies
     * within the PCM instance are solved using the dependency solver. The resulting PCM instance is
     * then transformed into a Markov Chain.
     * 
     * @param model
     *            the input PCM instance
     * @param configuration
     *            configuration properties for the reliability solver workflow
     * @param scenario
     *            the usage scenario to transform
     * @return the transformation results
     */
    private MarkovTransformationResult runScenarioTransform(final PCMInstance model,
            final PCMSolverWorkflowRunConfiguration configuration, final UsageScenario scenario) {

        // Initialize failure type information:
        List<MarkovFailureType> failureTypes = helper.getFailureTypes(getEvaluationMode(configuration),
                model.getRepositories(), model.getResourceEnvironment(), model.getSystem());

        // Initialize state information:
        MarkovTransformationSource markovSource = new MarkovTransformationSource(model, true);
        MarkovTransformationResult markovResult = new MarkovTransformationResult(configuration, markovSource, scenario,
                failureTypes);
        boolean approximate = false;

        // As a first step, solve parametric dependencies of the PCM instance:
        try {
            runDSolver(scenario, markovSource);
        } catch (RuntimeException e) {

            // The parametric dependencies could not be solved:
            LOGGER.error("Solving of parametric dependencies caused exception: " + e.getMessage() + " [" + e.getClass()
                    + "]");
            e.printStackTrace();

            throw e;
        }

        // Second, the PCM instance is transformed into a Markov Chain instance
        // and solved for determining system reliability:
        try {
            approximate = runPcm2Markov(configuration, scenario, markovSource, markovResult);
        } catch (Exception e) {
            LOGGER.error("PCM 2 Markov transformation caused exception: " + e.getMessage() + " [" + e.getClass() + "]");
            e.printStackTrace();
        }

        markovResult.setApproximate(approximate);

        // Return the transformation results:
        return markovResult;
    }

    /**
     * Performs a PCM2Markov transformation.
     * 
     * @param model
     *            the input PCM instance
     * @param configuration
     *            configuration properties for the reliability solver workflow
     * @param sensitivity
     *            sensitivity analysis configuration
     * @return the transformation results
     */
    public List<MarkovTransformationResult> runTransform(final PCMInstance model,
            final PCMSolverWorkflowRunConfiguration configuration, final MarkovSensitivity sensitivity) {
        if (sensitivity != null) {
            return runTransformIteratively(model, configuration, sensitivity);
        } else {
            return runTransformSingle(model, configuration);
        }
    }

    /**
     * Transforms a PCM instance into a Markov Chain instance.
     * 
     * The transformation is repeated to enable sensitivity analysis.
     * 
     * @param model
     *            the PCM instance
     * @param configuration
     *            configuration properties for the reliability solver workflow
     * @param sensitivity
     *            sensitivity analysis configuration
     * @return the transformation results (only the results of the last step in the sensitivity
     *         analysis are returned)
     */
    private List<MarkovTransformationResult> runTransformIteratively(final PCMInstance model,
            final PCMSolverWorkflowRunConfiguration configuration, final MarkovSensitivity sensitivity) {
        int sensitivityStepCount = 0;
        List<MarkovTransformationResult> markovResults = null;
        sensitivity.initialize(model);
        PCMInstance step = sensitivity.getNextModel();
        while (step != null) {
            sensitivityStepCount++;
            LOGGER.info("Starting sensitivity analysis step " + sensitivityStepCount + "...");
            markovResults = runTransformSingle(step, configuration);
            sensitivity.logResults(markovResults);
            LOGGER.info("Sensitivity analysis step " + sensitivityStepCount + " completed");
            step = sensitivity.getNextModel();
        }
        sensitivity.finalize();
        return markovResults;
    }

    /**
     * Transforms a PCM instance into a Markov Chain instance.
     * 
     * The transformation is performed in two steps. In the first step, parametric dependencies
     * within the PCM instance are solved using the dependency solver. The resulting PCM instance is
     * then transformed into a Markov Chain.
     * 
     * @param model
     *            the input PCM instance
     * @param configuration
     *            configuration properties for the reliability solver workflow
     * @return the transformation results
     */
    private List<MarkovTransformationResult> runTransformSingle(final PCMInstance model,
            final PCMSolverWorkflowRunConfiguration configuration) {

        // Declare result list:
        ArrayList<MarkovTransformationResult> resultList = new ArrayList<MarkovTransformationResult>();

        // Transform all usage scenarios individually:
        for (UsageScenario scenario : model.getUsageModel().getUsageScenario_UsageModel()) {
            resultList.add(runScenarioTransform(model, configuration, scenario));
        }

        // Return all transformation results:
        return resultList;
    }
}
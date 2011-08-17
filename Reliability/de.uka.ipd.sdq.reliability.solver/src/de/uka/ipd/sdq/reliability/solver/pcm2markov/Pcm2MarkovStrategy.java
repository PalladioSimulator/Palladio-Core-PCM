package de.uka.ipd.sdq.reliability.solver.pcm2markov;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.markov.MarkovChain;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.runconfig.PCMSolverWorkflowRunConfiguration;
import de.uka.ipd.sdq.pcmsolver.transformations.EMFHelper;
import de.uka.ipd.sdq.pcmsolver.transformations.SolverStrategy;
import de.uka.ipd.sdq.pcmsolver.visitors.UsageModelVisitor;
import de.uka.ipd.sdq.reliability.solver.MarkovSolver;
import de.uka.ipd.sdq.reliability.solver.sensitivity.ComponentSensitivity;
import de.uka.ipd.sdq.reliability.solver.sensitivity.InternalActionSensitivity;
import de.uka.ipd.sdq.reliability.solver.sensitivity.MarkovSensitivity;
import de.uka.ipd.sdq.reliability.solver.sensitivity.MultiSensitivity;
import de.uka.ipd.sdq.reliability.solver.sensitivity.ProbabilisticBranchSensitivity;
import de.uka.ipd.sdq.reliability.solver.sensitivity.ResourceMTTFSensitivity;
import de.uka.ipd.sdq.reliability.solver.sensitivity.SystemCallSensitivity;
import de.uka.ipd.sdq.reliability.solver.sensitivity.UsageBranchSensitivity;

/**
 * This class performs a transformation from a PCM instance to a Markov Chain
 * instance, and solves the resulting Markov Chain instance.
 * 
 * @author brosch
 * 
 */
public class Pcm2MarkovStrategy implements SolverStrategy {

	/**
	 * A logger to give detailed information about the PCM instance
	 * transformation.
	 */
	private static Logger logger = Logger.getLogger(Pcm2MarkovStrategy.class
			.getName());

	/**
	 * Indicates if the transformation has stopped before completion, such that
	 * the result has to be approximated.
	 */
	private boolean approximate;

	/**
	 * Configuration properties for the reliability solver workflow.
	 */
	private PCMSolverWorkflowRunConfiguration configuration;

	/**
	 * The solving value of the resulting Markov Chain instance.
	 */
	private MarkovTransformationResult markovResult;

	/**
	 * Holds state information required during the PCM2MarkovTransformation.
	 */
	private MarkovTransformationSource markovSource;

	/**
	 * Captures a configuration for sensitivity analysis (temporary).
	 */
	private MarkovSensitivity sensitivity = null;

	/**
	 * The constructor.
	 * 
	 * @param configuration
	 *            launch configuration parameters
	 */
	public Pcm2MarkovStrategy(
			final PCMSolverWorkflowRunConfiguration configuration) {
		this.configuration = configuration;
		initSensitivityAnalysis();
	}

	/**
	 * Retrieves the value that results from solving the Markov Chain instance.
	 * 
	 * @return the resulting value
	 */
	public MarkovTransformationResult getSolvedValue() {
		return markovResult;
	}

	/**
	 * Loads an already existing Markov Chain from a given XMI file. Not yet
	 * implemented.
	 * 
	 * @param fileName
	 *            the name of the XMI file
	 */
	public void loadTransformedModel(final String fileName) {
		// TODO: throw exception here
	}

	/**
	 * Solves the Markov Chain which has been created as a result of the
	 * transformation or has been loaded from an XMI file.
	 */
	public void solve() {

		// Solving of Markov Chain has already taken place during the
		// transformation.

		// // Temporary: print longest Markov state trace:
		// MarkovChain chain = markovResult.getResultChain();
		// ArrayList<String> maxTrace = new ArrayList<String>();
		// for (State state : chain.getStates()) {
		// if (state.getTraces().size() > maxTrace.size()) {
		// maxTrace.clear();
		// maxTrace.addAll(state.getTraces());
		// }
		// }
		// for (String segment : maxTrace) {
		// logger.warn(segment);
		// }

		// // Temporary: print comparison between Markov chains:
		// MarkovComparator comparator = new MarkovComparator();
		// comparator
		// .compare(
		// "C:\\Eclipse\\Galileo_RAW\\workspacePCMSource_TARGET\\BasicModel\\results\\result.markov",
		// "C:\\Eclipse\\Galileo_RAW\\workspacePCMSource_TARGET\\BasicModel\\results\\result2.markov");
	}

	/**
	 * Saves the Markov Chain resulting from the transformation into an XMI
	 * file. Not yet implemented.
	 * 
	 * @param fileName
	 *            the name of the XMI file to create
	 */
	public void storeTransformedModel(final String fileName) {
		EMFHelper.saveToXMIFile(markovResult.getResultChain(), fileName);
	}

	/**
	 * Transforms a PCM instance into a Markov Chain instance.
	 * 
	 * The transformation is performed either as a single transformation, or as
	 * a repeated transformation to perform sensitivity analysis.
	 * 
	 * @param model
	 *            the input PCM instance
	 */
	public void transform(final PCMInstance model) {
		if (sensitivity != null) {
			runTransformIteratively(model);
		} else {
			runTransformSingle(model);
		}
	}

	/**
	 * Checks whether there exists a next permutation based on the current one
	 * (which is given by the resources' current states). Generates the next
	 * permutation, if it exists, according to Narayana Pandita's method of
	 * systematically generating all permutations, and sets the resources'
	 * states accordingly.
	 * 
	 * @param descriptors
	 *            a list containing the processing resource descriptors
	 * @return true, if a new permutation was generated; false otherwise
	 */
	private boolean createNextPermutation(
			final List<ProcessingResourceDescriptor> descriptors) {
		int size = descriptors.size();

		int k = -1; // used for step 1 (see below)
		int l; // used for step 2 (see below)
		MarkovResourceState tmp; // used for step 4 (see below)
		int left; // used for step 4 (see below)
		int right; // used for step 4 (see below)

		/*
		 * Systematic generation of all permutations according to Narayana
		 * Pandita.
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
			descriptors.get(left).setCurrentState(
					descriptors.get(right).getCurrentState());
			descriptors.get(right).setCurrentState(tmp);
		}

		return true; // next permutation successfully generated - return true
	}

	/**
	 * Sets the leftmost <i>m</i> resources in the descriptors list to N/A.
	 * 
	 * @param descriptors
	 *            a list containing the processing resource descriptors
	 * @param m
	 *            the number of leftmost resources that will be set to N/A
	 */
	private void initializeResourceStates(
			final List<ProcessingResourceDescriptor> descriptors, final int m) {
		int size = descriptors.size();
		// set m leftmost resources to N/A
		for (int i = 0; i < m; i++) {
			descriptors.get(i)
					.setCurrentState(MarkovResourceState.NA);
		}
		// set remaining (n-m) resources to OK
		for (int i = m; i < size; i++) {
			descriptors.get(i)
					.setCurrentState(MarkovResourceState.OK);
		}
	}

	/**
	 * Initializes sensitivity analysis parameters.
	 */
	private void initSensitivityAnalysis() {
//		MarkovSensitivity s1 = new SystemCallSensitivity("SystemCallSensitivity", // (name)
//				"_EZvVAM7XEd-OdIcEWHGVTQ", // ProcessOnlineReportCall
//				"requestedEntries", // (parameter name)
//				"VALUE", // (parameter characterisation)
//				Arrays.asList(new String[] { "0", "100", "200" }), // (specification list)
//				"C://temp//SystemCallSensitivityResult.txt"); // log file
//		MarkovSensitivity s2 = new ResourceMTTFSensitivity(
//				"MTTFSensitivity", // (name)
//				"_U2Nv4dpAEdyxgfK4Hy_RFA", // DatabaseServer
//				"_BIjHoQ3KEdyouMqirZIhzQ", // HDD
//				Arrays.asList(new Double[]{
//						    315360.0,	// 0.01 years = 3.65 days
//						   3153600.0,   // 0.1 years = 1.2 months
//						  31536000.0,   // 1 year
//						 315360000.0}), // 10 years
//				"C://temp//Sensitivity_DatabaseServerHDD.txt"); // log file
//		MarkovSensitivity s3 = new InternalActionSensitivity(
//				"CachedDataActionSensitivity", // (name)
//				"_7MxF8No-EdyxgfK4Hy_RFA", // DatabaseAccess.GetCachedDataAction
//				"_PA6Rp-GnEd-L__Kieridkg", // DatabaseAccessFailure
//				Arrays.asList(new Double[]{0.00003,0.0003,0.003,0.03}), // (values)
//				"C://temp//InternalActionSensitivityResult.txt"); // log file
//		MarkovSensitivity s5 = new ProbabilisticBranchSensitivity(
//				"CacheHitSensitivity", // (name)
//				"_LhqfcOXMEd-pdM5ofkw-dQ", // branch transition id
//				1.0, // first value
//				0.0, // last value
//				3, // number of steps
//				null); // log file
//		MarkovSensitivity s6 = new ProbabilisticBranchSensitivity(
//				"CacheMissSensitivity", // (name)
//				"_OMBz8OXMEd-pdM5ofkw-dQ", // branch transition id
//				0.0, // first value
//				1.0, // last value
//				3, // number of steps
//				null); // log file
//		MarkovSensitivity s7 = new MultiSensitivity(
//				"CacheSensitivity", // (name)
//				Arrays.asList(new MarkovSensitivity[]{s5,s6}), // sensitivity params
//				false, // isCombinatory
//				"C://temp//BranchSensitivityResult.txt"); // log file	
//		MarkovSensitivity s4 = new ComponentSensitivity(
//				"ComponentSensitivity", // (name)
//				"_NeaygFhGEd6UHd_VhJH9SQ", // component id
//				0.0, // first value
//				0.1, // last value
//				11, // number of steps
//				"C://temp//SensitivityResult.txt");
//		MarkovSensitivity s1 = new UsageBranchSensitivity(
//				"UsageProfileSensitivity", // (name)
//				"_ipvW4eA9Ed-tiKYOyx3hUQ", // branch id
//				"_nD2xwOA9Ed-tiKYOyx3hUQ", // behaviour id
//				Arrays.asList(new Double[]{0.9998, 0.0001, 0.0001, 0.7}), // (values)
//				"C://temp//BranchSensitivity.txt");
//		MarkovSensitivity s2 = new UsageBranchSensitivity(
//				"UsageProfileSensitivity", // (name)
//				"_ipvW4eA9Ed-tiKYOyx3hUQ", // branch id
//				"_sZ5pYOA9Ed-tiKYOyx3hUQ", // behaviour id
//				Arrays.asList(new Double[]{0.0001, 0.9998, 0.0001, 0.2}), // (values)
//				"C://temp//BranchSensitivity.txt");
//		MarkovSensitivity s3 = new UsageBranchSensitivity(
//				"UsageProfileSensitivity", // (name)
//				"_ipvW4eA9Ed-tiKYOyx3hUQ", // branch id
//				"_u_jdAOA9Ed-tiKYOyx3hUQ", // behaviour id
//				Arrays.asList(new Double[]{0.0001, 0.0001, 0.9998, 0.1}), // (values)
//				"C://temp//BranchSensitivity.txt");
//		MarkovSensitivity s4 = new MultiSensitivity(
//				"TripleSensitivity", // (name)
//				Arrays.asList(new MarkovSensitivity[]{s1,s2,s3}), // sensitivity params
//				false, // isCombinatory
//				"C://temp//UsageSensitivity.txt"); // log file
//		MarkovSensitivity s5 = new ResourceMTTFSensitivity(
//				"MTTFSensitivity", // (name)
//				"_U2Nv4dpAEdyxgfK4Hy_RFA", // DatabaseServer
//				"_oro4gG3fEdy4YaaT-RYrLQ", // CPU
//				Arrays.asList(new Double[]{
//						 315360000.0,   // 10 years
//						  31536000.0,   // 1 year
//						   3153600.0}), // 0.1 years = 1.2 months
//				"C://temp//MTTFSensitivity.txt"); // log file
//		MarkovSensitivity s6 = new ResourceMTTFSensitivity(
//				"MTTFSensitivity", // (name)
//				"_U2Nv4dpAEdyxgfK4Hy_RFA", // DatabaseServer
//				"_BIjHoQ3KEdyouMqirZIhzQ", // HDD
//				Arrays.asList(new Double[]{
//						 315360000.0,   // 10 years
//						  31536000.0,   // 1 year
//						   3153600.0}), // 0.1 years = 1.2 months
//				"C://temp//MTTFSensitivity.txt"); // log file
//		MarkovSensitivity s7 = new MultiSensitivity(
//				"TripleSensitivity", // (name)
//				Arrays.asList(new MarkovSensitivity[]{s5,s6}), // sensitivity params
//				false, // isCombinatory
//				"C://temp//UsageSensitivity.txt"); // log file
//		sensitivity = new MultiSensitivity(
//				"CombinedSensitivity", // (name)
//				Arrays.asList(new MarkovSensitivity[]{s4,s7}), // sensitivity params
//				true, // isCombinatory
//				"C://temp//DatabaseServer.txt"); // log file
	}

	/**
	 * Checks whether a termination condition - possibly specified by the user -
	 * holds.
	 * 
	 * @param startTimeMs
	 *            indicates when the process started. This needs to be a value
	 *            in milliseconds determined by having called
	 *            System.currentTimeMillis().
	 * @return true, if a termination condition holds; false otherwise
	 */
	private boolean isStopConditionReached(final long startTimeMs) {

		// check solving time limit
		if (configuration.isSolvingTimeLimitEnabled()) {
			// solving time limit reached?
			if (System.currentTimeMillis() - startTimeMs >= configuration
					.getSolvingTimeLimit() * 1000) {
				// yes, stop condition holds - return true
				logger.info("Maximal solving time ("
						+ configuration.getSolvingTimeLimit()
						+ " seconds) reached - stopping!");
				return true;
			}
		}

		// check limit for the number of evaluated physical system states
		if (configuration.isNumberOfEvaluatedSystemStatesEnabled()) {
			// maximum number of system states to be evaluated reached?
			if (markovResult.getPhysicalStateEvaluationCount() == configuration
					.getNumberOfEvaluatedSystemStates()) {
				// yes, stop condition holds - return true
				logger.info("Maximal number of evaluated system states ("
						+ configuration.getNumberOfEvaluatedSystemStates()
						+ ") reached - stopping!");
				return true;
			}
		}

		// check limit for the number of exact decimal places
		if (configuration.isNumberOfExactDecimalPlacesEnabled()) {
			// required number of exact decimal places reached?
			if (markovResult.hasRequiredAccuracy(configuration
					.getNumberOfExactDecimalPlaces())) {
				// yes, stop condition holds - return true
				logger.info("Required number of exact decimal places ("
						+ configuration.getNumberOfExactDecimalPlaces()
						+ ") reached - stopping!");
				return true;
			}
		}

		// no stop condition holds - return false
		return false;
	}

	/**
	 * Solves all parametric dependencies within a given PCM instance.
	 */
	private void runDSolver() {

		logger.debug("Resolving parametric dependencies.");
		// Record the time consumed for solving parametric dependencies:
		long startTime = System.nanoTime();

		// The parametric dependencies are solved by using a visitor:
		UsageModelVisitor visitor = new UsageModelVisitor(markovSource
				.getModel());

		// The dependency solver supports only solving a single
		// usage scenario (08-2008):
		UsageScenario us = (UsageScenario) markovSource.getModel()
				.getUsageModel().getUsageScenario_UsageModel().get(0);

		// Solve the PCM instance using the visitor:
		visitor.doSwitch(us.getScenarioBehaviour_UsageScenario());

		// Let the user know about the time consumed:
		long stopTime = System.nanoTime();
		long duration = TimeUnit.NANOSECONDS.toMillis(stopTime - startTime);
		logger.info("Solved parametric dependencies: " + duration + " ms");
	}

	/**
	 * Transforms the given PCM instance into a Markov Chain instance. The PCM
	 * instance is assumed to have all parametric dependencies solved.
	 */
	private void runPcm2Markov() {

		logger.debug("Transforming PCM model into analysis model.");

		// Record the time consumed for creating the Markov Chain instance:
		long startTime = System.nanoTime();

		// Check for the requested state handling strategy:
		if (!configuration.isIterationOverPhysicalSystemStatesEnabled()) {
			// Run a single Markov transformation according to the
			// "always ask" strategy:
			runPcm2MarkovSingle();
		} else {
			// Repeat the transformation for all physical system states:
			runPcm2MarkovIteratively();
		}

		// Let the user know about the time consumed:
		long stopTime = System.nanoTime();
		long duration = TimeUnit.NANOSECONDS.toMillis(stopTime - startTime);
		logger.info("Finished Markov transformation: " + duration + " ms");
		if (configuration.isIterationOverPhysicalSystemStatesEnabled()) {
			logger.info("Number of evaluated physical system states: "
					+ markovResult.getPhysicalStateEvaluationCount()
					+ " out of "
					+ markovResult.getNumberOfPhysicalSystemStates());
		}
	}

	/**
	 * Runs the PCM 2 Markov transformation for all possible classes, or until
	 * at least one of the possible termination conditions holds.
	 */
	private void runPcm2MarkovIteratively() {

		// Remember the start time of the transformation:
		long startTimeMs = System.currentTimeMillis();

		// Some short notations:
		List<ProcessingResourceDescriptor> descriptors = markovSource
				.getUnreliableResourceDescriptors();
		final int size = descriptors.size();

		/*
		 * Now, for all n resources: Let m out of n (for m in 0..(n-1))
		 * resources fail in an iteration, considering first the resources that
		 * are most likely to fail, moving on to resources that are less likely
		 * to fail, finally considering the resources that are least likely to
		 * fail.
		 */
		for (int permutationClass = 0; permutationClass <= size; permutationClass++) {

			/*
			 * Consider the current permutation first, where the m leftmost
			 * resources are set to N/A, while the remaining ones are OK.
			 */

			// set m leftmost out of n resources total to N/A state
			initializeResourceStates(descriptors, permutationClass);

			// markovSource.printCurrentResourceStates();

			// Evaluate the physical system state:
			runPcm2MarkovSingle();

			// Check if any of the stop conditions is reached:
			if (isStopConditionReached(startTimeMs)) {
				approximate = true;
				return;
			}

			/*
			 * Now generate all other permutations where m out of n
			 * ("n choose m") resources are N/A.
			 */
			for (;;) {

				// see if there's a next permutation
				if (!createNextPermutation(descriptors)) {
					break; // there's no new permutation - leave inner for loop
				}

				// markovSource.printCurrentResourceStates();

				/*
				 * At this point, we have a new permutation, i.e. system state.
				 * It was generated via the createNextPermutation(descriptors)
				 * call above.
				 */

				// Evaluate the physical system state:
				runPcm2MarkovSingle();

				// Check if any of the stop conditions is reached:
				if (isStopConditionReached(startTimeMs)) {
					approximate = true;
					return;
				}
			} // end for: generation of all "n choose m" permutations
		} // end for: m out of n resources N/A
	} // end method

	/**
	 * Evaluates a single physical system state.
	 */
	private void runPcm2MarkovSingle() {

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
			for (ProcessingResourceDescriptor descriptor : markovSource
					.getUnreliableResourceDescriptors()) {
				physicalStateProbability *= descriptor
						.getStateProbability(descriptor.getCurrentState());
			}
		}

		// The Markov Chain instance is created by using a visitor:
		// MarkovUsageModelVisitor visitor = new MarkovUsageModelVisitor(
		// markovSource, !countStates);
		MarkovUsageModelVisitor visitor = new MarkovUsageModelVisitor(
				markovSource, !configuration
						.isIterationOverPhysicalSystemStatesEnabled(),
				configuration.isMarkovModelReductionEnabled(), configuration
						.isMarkovModelTracesEnabled());

		// The transformation supports only solving a single
		// usage scenario (08-2008):
		UsageScenario scenario = (UsageScenario) markovSource.getModel()
				.getUsageModel().getUsageScenario_UsageModel().get(0);

		// Create the Markov Chain instance using the visitor:
		MarkovChain resultChain = (MarkovChain) visitor.doSwitch(scenario
				.getScenarioBehaviour_UsageScenario());

		// Display information to the user:
		if (countStates) {
			logger
					.info("Number of Markov states per evaluated physical system state:\t"
							+ resultChain.getStates().size());
			logger
					.info("Number of Markov transitions per evaluated physical system state:\t"
							+ resultChain.getTransitions().size());
		}

		// Solve the Markov Chain, and add the result to the overall success
		// probability, weighted by the probability of the current resource
		// state combination:
		double[][] markovProbabilityMatrix = solver.solve(resultChain);

		// Add the results of this evaluation:
		markovResult.addPhysicalStateResults(resultChain,
				markovProbabilityMatrix, physicalStateProbability);
	}

	/**
	 * Transforms a PCM instance into a Markov Chain instance.
	 * 
	 * The transformation is repeated to enable sensitivity analysis.
	 * 
	 * @param model
	 *            the PCM instance
	 */
	private void runTransformIteratively(final PCMInstance model) {
		sensitivity.initialize(model);
		PCMInstance step = sensitivity.getNextModel();
		while (step != null) {
			sensitivity.logResults(runTransformSingle(step));
			step = sensitivity.getNextModel();
		}
		sensitivity.finalize();
	}

	/**
	 * Transforms a PCM instance into a Markov Chain instance.
	 * 
	 * The transformation is performed in two steps. In the first step,
	 * parametric dependencies within the PCM instance are solved using the
	 * dependency solver. The resulting PCM instance is then transformed into a
	 * Markov Chain.
	 * 
	 * @param model
	 *            the input PCM instance
	 * @return the resulting success probability
	 */
	private double runTransformSingle(final PCMInstance model) {

		// Initialize state information:
		markovSource = new MarkovTransformationSource(model, true);
		markovResult = new MarkovTransformationResult(configuration,
				markovSource);
		approximate = false;

		// As a first step, solve parametric dependencies of the PCM instance:
		try {
			runDSolver();
		} catch (Exception e) {

			// The parametric dependencies could not be solved:
			logger
					.error("Solving of parametric dependencies caused exception: "
							+ e.getMessage() + " [" + e.getClass() + "]");
			e.printStackTrace();

			return 0.0;
		}

		// Second, the PCM instance is transformed into a Markov Chain instance
		// and solved for determining system reliability:
		try {
			runPcm2Markov();
		} catch (Exception e) {
			logger.error("PCM 2 Markov transformation caused exception: "
					+ e.getMessage() + " [" + e.getClass() + "]");
			e.printStackTrace();
		}

		// Store the transformed model:
		if (configuration.isMarkovModelStorageEnabled()) {
			storeTransformedModel(configuration.getMarkovModelFile());
		}

		// Let the user know about the result:
		markovResult.print(approximate);

		// Return the resulting success probability:
		return markovResult.getSuccessProbability();
	}
}

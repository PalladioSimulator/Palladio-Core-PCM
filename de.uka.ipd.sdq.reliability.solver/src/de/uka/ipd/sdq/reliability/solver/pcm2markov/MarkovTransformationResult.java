package de.uka.ipd.sdq.reliability.solver.pcm2markov;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.FileLocator;

import de.uka.ipd.sdq.markov.MarkovChain;
import de.uka.ipd.sdq.markov.State;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcmsolver.runconfig.PCMSolverWorkflowRunConfiguration;
import de.uka.ipd.sdq.reliability.core.MarkovFailureType;

/**
 * Aggregates the results of a PCM2MarkovTransformation.
 * 
 * @author brosch
 * 
 */
public class MarkovTransformationResult {

    /**
     * A logger to give detailed information about the PCM instance transformation.
     */
    private static Logger logger = Logger.getLogger(MarkovTransformationResult.class.getName());

    /**
     * Indicates if an approximation scheme shall be used for printing of probabilities.
     */
    private boolean approximate;

    /**
     * Configuration options of the transformation.
     */
    private PCMSolverWorkflowRunConfiguration configuration;

    /**
     * Overall failure type probabilities, accumulated over all considered physical system states.
     */
    private Map<MarkovFailureType, Double> cumulatedFailureTypeProbabilities = new HashMap<MarkovFailureType, Double>();

    /**
     * Overall physical state probability, accumulated over all considered physical system states.
     */
    private double cumulatedPhysicalStateProbability;

    /**
     * Overall success probability, accumulated over all considered physical system states.
     */
    private double cumulatedSuccessProbability;

    /**
     * The list of potential failure types.
     */
    private List<MarkovFailureType> failureTypes;

    /**
     * A helper class providing functionality for Markov chains.
     */
    private MarkovBuilder markovBuilder;

    /**
     * Holds state information required during the PCM2MarkovTransformation.
     */
    private MarkovTransformationSource markovSource;

    /**
     * Indicates the number of physical system states (which is n^2 for n resources).
     */
    private long numberOfPhysicalSystemStates;

    /**
     * Counts the evaluated physical system states.
     */
    private long physicalStateEvaluationCount;

    /**
     * Holds the Makov chain that results from the transformation.
     */
    private MarkovChain resultChain;

    /**
     * The usage scenario which has been evaluated.
     */
    private UsageScenario scenario;

    /**
     * Creates a new Markov results aggregator.
     * 
     * @param configuration
     *            configuration options of the transformation
     * @param markovSource
     *            the Markov state holder
     * @param scenario
     *            the usage scenario to evaluate
     * @param failureTypes
     *            the list of potential failure types
     */
    public MarkovTransformationResult(final PCMSolverWorkflowRunConfiguration configuration,
            final MarkovTransformationSource markovSource, final UsageScenario scenario,
            final List<MarkovFailureType> failureTypes) {
        this.configuration = configuration;
        this.cumulatedPhysicalStateProbability = 0.0;
        this.cumulatedSuccessProbability = 0.0;
        this.markovBuilder = new MarkovBuilder(false);
        this.markovSource = markovSource;
        this.physicalStateEvaluationCount = 0;
        this.numberOfPhysicalSystemStates = (long) Math.pow(2, markovSource.getUnreliableResourceDescriptors().size());
        this.resultChain = null;
        this.scenario = scenario;
        this.failureTypes = failureTypes;
    }

    /**
     * Adds the results of the evaluation of a single physical system state during the PCM2Markov
     * transformation.
     * 
     * @param resultChain
     *            the Markov chain resulting from the evaluation of the physical system state
     * @param markovProbabilityMatrix
     *            the matrix with the probabilities to get from state i to state j in the Markov
     *            chain
     * @param physicalStateProbability
     *            the probability of the evaluated physical system state to occur
     */
    public void addPhysicalStateResults(final MarkovChain resultChain, final double[][] markovProbabilityMatrix,
            final double physicalStateProbability) {

        // Check plausibility of input parameters:
        if (physicalStateProbability < 0.0 || physicalStateProbability > 1.0) {
            throw new MarkovException("Illegal physical state probability (" + physicalStateProbability
                    + "). The value must be in [0,1].");
        }

        // Store the first resulting Markov Chain:
        if (physicalStateEvaluationCount == 0) {
            this.resultChain = resultChain;
        }

        // Get the indices of the Start and Success States:
        int indexStart = markovBuilder.indexOf(resultChain, markovBuilder.getStartState(resultChain));
        int indexSuccess = markovBuilder.indexOf(resultChain, markovBuilder.getSuccessState(resultChain));

        // Check plausibility of Markov probabilities:
        double successProbability = markovProbabilityMatrix[indexStart][indexSuccess];
        if (successProbability < 0.0 || successProbability > 1.0) {
            // It should never happen that the success probability is outside
            // [0,1].
            // The only feasible explanation is a rounding error (which has been
            // observed for certain sample PCM instances):
            double correctedSuccessProbability = (successProbability < 0.5) ? 0.0 : 1.0;
            logger.warn("Illegal success probability " + successProbability
                    + " outside [0,1]. Assuming a rounding error. " + "Setting success probability to "
                    + correctedSuccessProbability);
            successProbability = correctedSuccessProbability;
        }

        // Accumulate results:
        cumulatedPhysicalStateProbability += physicalStateProbability;
        cumulatedSuccessProbability += physicalStateProbability * successProbability;

        // Consider also the failure type probabilities:
        List<State> failureStates = markovBuilder.getFailureStates(resultChain);
        for (int i = 0; i < failureStates.size(); i++) {

            // Check plausibility of Markov probabilities:
            double failureTypeProbability = markovProbabilityMatrix[indexStart][markovBuilder.indexOf(resultChain,
                    failureStates.get(i))];
            if (failureTypeProbability < 0.0 || failureTypeProbability > 1.0) {
                throw new MarkovException("Illegal failure type probability (" + failureTypeProbability
                        + "). The value must be in [0,1].");
            }

            // Determine the failure type probability for this physical system
            // state:
            double failureTypeProbabilityDelta = physicalStateProbability * failureTypeProbability;

            // Add the failure type probability to the already existing value:
            String failureTypeId = markovBuilder.getFailureTypeId(failureStates.get(i));
            MarkovFailureType failureType = getFailureType(failureTypeId);

            Double failureProbability = cumulatedFailureTypeProbabilities.get(failureType);
            cumulatedFailureTypeProbabilities.put(failureType,
                    ((failureProbability == null) ? 0.0 : failureProbability) + failureTypeProbabilityDelta);
        }

        // Increase the counter of evaluated physical system states:
        physicalStateEvaluationCount++;

        // Do the logging:
        if (configuration.isPrintMarkovSingleResults()) {
            // yes - write output to log file
            BufferedWriter out = null;
            String filePath = resolveFile(configuration.getLogFile());
            try {
                if (physicalStateEvaluationCount == 1) {
                    File f = new File(filePath);
                    // if the file exists, we will delete it and create a new,
                    // empty one
                    // (i.e., overwrite the existing file) once, and then
                    // repeatedly append
                    // to this file
                    if (f.exists()) {
                        f.delete(); // delete current ("old") file
                        f.createNewFile(); // create a new, empty file
                    }
                    out = new BufferedWriter(new FileWriter(filePath, true));
                    logger.info("Logging results of all Markov transformation runs to: " + filePath);
                    out.append(getLogHeadings() + System.getProperty("line.separator"));
                    out.flush();
                    out.close();
                }
                out = new BufferedWriter(new FileWriter(filePath, true));
                out.append(getLogSingleResults(successProbability, physicalStateProbability)
                        + System.getProperty("line.separator"));
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (out != null) {
                        out.flush();
                        out.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Gets the overall failure type probabilities, accumulated over all considered physical system
     * states.
     * 
     * @return the overall failure type probabilities
     */
    public Map<MarkovFailureType, Double> getCumulatedFailureTypeProbabilities() {
        return cumulatedFailureTypeProbabilities;
    }

    /**
     * Gets the overall physical state probability, accumulated over all considered physical system
     * states.
     * 
     * @return the overall physical state probability
     */
    public double getCumulatedPhysicalStateProbability() {
        return cumulatedPhysicalStateProbability;
    }

    /**
     * Retrieves the failure type with the given id.
     * 
     * @param failureTypeId
     *            the failure type id
     * @return the failure type
     */
    private MarkovFailureType getFailureType(String failureTypeId) {
        for (MarkovFailureType failureType : failureTypes) {
            if (failureType.getId().equals(failureTypeId)) {
                return failureType;
            }
        }
        throw new IllegalArgumentException("MarkovTransformationResult: Failure type with ID \"" + failureTypeId
                + "\" not found!");
    }

    /**
     * Builds the headings string for Markov transformation logging.
     * 
     * @return the log headings string
     */
    private String getLogHeadings() {

        // Build a result string:
        StringBuilder resultString = new StringBuilder();

        // Append state number heading:
        resultString.append("physical system state number;");

        // Append resource state headings:
        for (ProcessingResourceDescriptor descriptor : markovSource.getUnreliableResourceDescriptors()) {
            resultString.append(descriptor.getResourceContainerName() + " - " + descriptor.getType().getName() + ";");
        }

        // Append success probability heading:
        resultString.append("success probability;");

        // Append state probability heading:
        resultString.append("physical state probability");

        // Return the result:
        return resultString.toString();
    }

    /**
     * Builds the results string for Markov transformation logging.
     * 
     * @param successProbability
     *            success probability of the current physical system state
     * @param physicalStateProbability
     *            occurrence probability of the current physical system state
     * @return the results string
     */
    private String getLogSingleResults(final double successProbability, final double physicalStateProbability) {

        // Build a result string:
        StringBuilder resultString = new StringBuilder();

        // Append state number:
        resultString.append(physicalStateEvaluationCount + ";");

        // Append resource states:
        for (ProcessingResourceDescriptor descriptor : markovSource.getUnreliableResourceDescriptors()) {
            resultString.append(descriptor.getCurrentState().name() + ";");
        }

        // Append success probability:
        resultString.append(successProbability + ";");

        // Append state probability:
        resultString.append(physicalStateProbability);

        // Return the result:
        return resultString.toString();
    }

    /**
     * Retrieves the number of physical system states.
     * 
     * @return the number of physical system states
     */
    public long getNumberOfPhysicalSystemStates() {
        return numberOfPhysicalSystemStates;
    }

    /**
     * Retrieves the current number of evaluated physical system states.
     * 
     * @return the current number of evaluated physical system states
     */
    public long getPhysicalStateEvaluationCount() {
        return physicalStateEvaluationCount;
    }

    /**
     * Retrieves the Markov chain that results from the transformation.
     * 
     * @return the Markov chain that results from the transformation
     */
    public MarkovChain getResultChain() {
        return resultChain;
    }

    /**
     * Gets the usage scenario which has been evaluated
     * 
     * @return the usage scenario
     */
    public UsageScenario getScenario() {
        return scenario;
    }

    /**
     * Retrieves the overall success probability.
     * 
     * @return the success probability
     */
    public double getSuccessProbability() {
        return cumulatedSuccessProbability;
    }

    /**
     * Determines if the calculated success probability conforms to a given required accuracy.
     * 
     * @param requiredAccuracy
     *            the required accuracy in decimal places
     * @return true if the required accuracy has been reached
     */
    public boolean hasRequiredAccuracy(final int requiredAccuracy) {

        // Create an approximation for the accumulated success probability:
        MarkovResultApproximation approximation = new MarkovResultApproximation(cumulatedSuccessProbability,
                cumulatedSuccessProbability + (1.0 - cumulatedPhysicalStateProbability));

        // Check for the required accuracy:
        return approximation.hasRequiredAccuracy(requiredAccuracy);
    }

    /**
     * Indicates if an approximation scheme shall be used for printing of probabilities.
     * 
     * @return <code>true</code>, if an approximation scheme shall be used for printing
     *         probabilities, <code>false</code> otherwise.
     */
    public boolean isDoApproximate() {
        return (configuration.isIterationOverPhysicalSystemStatesEnabled()) && approximate
                && (physicalStateEvaluationCount < Math.pow(markovSource.getUnreliableResourceDescriptors().size(), 2));
    }

    /**
     * Resolves a file's path in case it starts with "platform:/" and returns the entire absolute
     * path to the file, including the file's name.
     * 
     * @param fileURL
     *            the path to a file, including the file's name (and its extension)
     * @return the absolute path to the file, including the file's name
     */
    private String resolveFile(String fileURL) {
        // if this is a platform URL, first resolve it to an absolute path
        if (fileURL.startsWith("platform:")) {
            try {
                URL solvedURL = FileLocator.resolve(new URL(fileURL));
                fileURL = solvedURL.getPath();
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        return fileURL;
    }

    /**
     * Method for setting a value responsible for telling if an approximation scheme shall be used
     * for printing probabilities.
     * 
     * @param approximate
     *            the value indicating if an approximation scheme shall be used for printing
     *            probabilities
     */
    public void setApproximate(boolean approximate) {
        this.approximate = approximate;
    }
}

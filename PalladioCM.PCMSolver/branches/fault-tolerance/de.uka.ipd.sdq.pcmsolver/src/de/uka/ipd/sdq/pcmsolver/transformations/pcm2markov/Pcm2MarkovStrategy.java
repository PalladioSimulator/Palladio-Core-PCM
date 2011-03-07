package de.uka.ipd.sdq.pcmsolver.transformations.pcm2markov;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.console.MessageConsoleStream;

import de.uka.ipd.sdq.markov.MarkovChain;
import de.uka.ipd.sdq.pcm.seff.FailureOccurrenceDescription;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcmsolver.markovsolver.MarkovSolver;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.runconfig.MessageStrings;
import de.uka.ipd.sdq.pcmsolver.tests.MarkovTestHelper;
import de.uka.ipd.sdq.pcmsolver.transformations.SolverStrategy;
import de.uka.ipd.sdq.pcmsolver.visitors.UsageModelVisitor;
import de.uka.ipd.sdq.workflow.launchconfig.ConstantsContainer;

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
	 * Reference to another EMF utility class.
	 */
	private static MarkovTestHelper markovHelper = new MarkovTestHelper();

	/**
	 * Message stream for printing results in "raw" format.
	 */
	private MessageConsoleStream rawStream;

	/**
	 * References launch configuration parameters.
	 */
	private ILaunchConfiguration configuration;

	/**
	 * The Markov Chain instance that results from the transformation of the PCM
	 * instance.
	 */
	private MarkovChain markovChain;

	/**
	 * The solving value of the resulting Markov Chain instance.
	 */
	private TransformationResults results=new TransformationResults();

	/**
	 * The list of solving values in case of a sensitivity analysis.
	 */
	private ArrayList<TransformationResults> sensitivityResults = new ArrayList<TransformationResults>();

	/**
	 * Counts performed Markov transformation runs.
	 */
	private long transformationRunCount;

	/**
	 * Data for sensitivity analysis.
	 */
	private SensitivityController sensitivityController;

	/**
	 * Sensitivity model data.
	 */
	private Properties props = new Properties();

	/**
	 * The constructor.
	 * 
	 * @param configuration
	 *            launch configuration parameters
	 */
	public Pcm2MarkovStrategy(final ILaunchConfiguration configuration) {

		// Initialize members:
		this.markovChain = new MarkovBuilder().initNewMarkovChain("");
		this.configuration = configuration;
		this.sensitivityController = new SensitivityController(configuration);
		}

	/**
	 * The short constructor maintained for Markov TestCases.
	 * 
	 */
	public Pcm2MarkovStrategy() {
		this(null);
	}

	/**
	 * Retrieves the value that results from solving the Markov Chain instance.
	 * 
	 * @return the resulting value
	 */
	public TransformationResults getSolvedValue() {
		return results;
	}

	/**
	 * Loads an already existing Markov Chain from a given XMI file. Not yet
	 * implemented.
	 * 
	 * @param fileName
	 *            the name of the XMI file
	 */
	public void loadTransformedModel(final String fileName) {
		//TODO: throw exception here
	}

	/**
	 * Solves the Markov Chain which has been created as a result of the
	 * transformation or has been loaded from an XMI file.
	 */
	public void solve() {

		// If a sensitivity analysis is performed, do nothing:
		if (sensitivityController.isSensitivityActive()) {
			return;
		}

		// Solving of Markov Chain has already taken place during the
		// transformation.

		
		// Let the user know about the result:
		logger.info("Reliability Results:\n"+
				getTransformationResultsInfo(results));
	}

	/**
	 * Saves the Markov Chain resulting from the transformation into an XMI
	 * file. Not yet implemented.
	 * 
	 * @param fileName
	 *            the name of the XMI file to create
	 */
	public void storeTransformedModel(final String fileName) {
	}

	/**
	 * Transforms a PCM instance into a Markov Chain instance. If sensitivity
	 * analysis is activated, the process is extended to be repeatedly executed.
	 * 
	 * @param model
	 *            the input PCM instance
	 */
	public void transform(final PCMInstance model) {

		// Without sensitivity analysis, perform the standard transformation:
		if (!sensitivityController.isSensitivityActive()) {
			singleTransform(model);
			return;
		}

		// Prepare sensitivity analysis:
		try {
			prepareSensitivity();
		} catch (Exception e) {

			// The preparation could not be done:
			logger
					.error("Preparation for sensitivity analysis caused exception: "
							+ e.getMessage());
			return;
		}

		// Go through all steps of the sensitivity analysis:
		for (int i = 0; i < sensitivityController.getStepCount(); i++) {

			results=new TransformationResults();
			
			// Perform the transformation:
			singleTransform(createAdjustedModel(i));

			// Let the user know about the result:
			logger.info("Reliability Results:\n"+
					getTransformationResultsInfo(results));

			// Store the result:
			sensitivityResults.add(results);
		}

		// Print sensitivity analysis results:
		printSensitivityAnalysisResults();
	}

	/**
	 * Transforms a PCM instance into a Markov Chain instance. The
	 * transformation is performed in two steps. In the first step, parametric
	 * dependencies within the PCM instance are solved using the dependency
	 * solver. The resulting PCM instance is then transformed into a Markov
	 * Chain.
	 * 
	 * @param model
	 *            the input PCM instance
	 */
	private void singleTransform(final PCMInstance model) {

		// As a first step, solve parametric dependencies of the PCM instance:
		try {
			runDSolver(model);
		} catch (Exception e) {

			// The parametric dependencies could not be solved:
			logger
					.error("Solving of parametric dependencies caused exception: "
							+ e.getMessage());
			e.printStackTrace();
			
			return;
		}

		// Second, the PCM instance is transformed into a Markov Chain instance:
		runPcm2Markov(model);
	}

	/**
	 * Solves all parametric dependencies within a given PCM instance.
	 * 
	 * @param model
	 *            the PCM instance
	 */
	private void runDSolver(final PCMInstance model) {

		logger.debug("Resolving parametric dependencies.");
		// Record the time consumed for solving parametric dependencies:
		long startTime = System.nanoTime();

		// The parametric dependencies are solved by using a visitor:
		UsageModelVisitor visitor = new UsageModelVisitor(model);

		// The dependency solver supports only solving a single
		// usage scenario (08-2008):
		UsageScenario us = (UsageScenario) model.getUsageModel()
				.getUsageScenario_UsageModel().get(0);

		// Solve the PCM instance using the visitor:
		visitor.doSwitch(us.getScenarioBehaviour_UsageScenario());

		// Let the user know about the time consumed:
		long stopTime = System.nanoTime();
		long duration = TimeUnit.NANOSECONDS.toMillis(stopTime - startTime);
		logger.info("Solved parametric dependencies:\t\t" + duration + " ms");
	}

	/**
	 * Transforms the given PCM instance into a Markov Chain instance. The PCM
	 * instance is assumed to have all parametric dependencies solved.
	 * 
	 * @param model
	 *            the PCM instance
	 */
	private void runPcm2Markov(final PCMInstance model) {

		logger.debug("Transforming PCM model into analysis model.");
		// Record the time consumed for creating the Markov Chain instance:
		long startTime = System.nanoTime();

		// Record the number of performed transformation runs:
		transformationRunCount = 0;

		PCMInformationProvider pcmInfoProvider=new PCMInformationProvider(model);


		try {

			// Count the states of the Markov Chain to build:
			if (getConfigurationAttribute(MessageStrings.MARKOV_STATISTICS,
					false)) {
				printMarkovStatistics(pcmInfoProvider);
			}

			// Print headings for transformation run results:
			if (getConfigurationAttribute(MessageStrings.SINGLE_RESULTS, false)) {
				printTransformationRunHeadings(pcmInfoProvider.getResourceDescriptors());
			}

			// Repeatedly run the transformation for all possible state
			// combinations:
			runPcm2MarkovRecursively(pcmInfoProvider, 0, 1.0);

		} catch (Exception e) {
			logger.error("PCM 2 Markov transformation caused exception: "
					+ e.getMessage() + " [" + e.getClass() + "]");
			e.printStackTrace();
		}

		// Let the user know about the time consumed:
		long stopTime = System.nanoTime();
		long duration = TimeUnit.NANOSECONDS.toMillis(stopTime - startTime);
		logger.info("Finished Markov transformation:\t\t" + duration + " ms");
		logger.info("Number of performed transformation runs:\t"
				+ transformationRunCount);
	}

	/**
	 * Performs the Markov Transformation once, just to be able to print some
	 * Markov statistics.
	 * 
	 * @param model
	 *            the model which is to be transformed
	 * @param descriptors
	 *            the resource descriptors
	 */
	private void printMarkovStatistics(final PCMInformationProvider pcmInfoProvider) {

		// The Markov Chain instance is created by using a visitor:
		MarkovUsageModelVisitor umVisit = new MarkovUsageModelVisitor(pcmInfoProvider, false);

		// The transformation supports only solving a single
		// usage scenario (08-2008):
		UsageScenario us = (UsageScenario) pcmInfoProvider.getModel().getUsageModel()
				.getUsageScenario_UsageModel().get(0);

		// Perform the Markov Chain transformation:
		markovChain = (MarkovChain) umVisit.doSwitch(us
				.getScenarioBehaviour_UsageScenario());

		// Display information to the user:
		logger.info("Number of states in Markov Chain:\t"
				+ markovChain.getStates().size());
		logger.info("Number of transitions in Markov Chain:\t"
				+ markovChain.getTransitions().size());
	}

	/**
	 * Runs the PCM 2 Markov transformation for all possible combinations of
	 * states of resources.
	 * 
	 * @param model
	 *            the PCM instance
	 * @param descriptors
	 *            the resource descriptors
	 * @param index
	 *            the current resource state manipulation level
	 * @param currentProbability
	 *            the probability of the current resource state combination
	 */
	private void runPcm2MarkovRecursively(final PCMInformationProvider pcmInfoProvider,
			final int index, final double currentProbability) {

		MarkovSolver solver=new MarkovSolver();

		// Check for the base case:
		if (index == pcmInfoProvider.getResourceDescriptors().size()) {

			// The Markov Chain instance is created by using a visitor:
			MarkovUsageModelVisitor umVisit = new MarkovUsageModelVisitor(pcmInfoProvider);

			// The transformation supports only solving a single
			// usage scenario (08-2008):
			UsageScenario us = (UsageScenario) pcmInfoProvider.getModel().getUsageModel()
					.getUsageScenario_UsageModel().get(0);

			// Create the Markov Chain instance using the visitor:
			markovChain = (MarkovChain) umVisit.doSwitch(us
					.getScenarioBehaviour_UsageScenario());

			// Update the transformation runs counter:
			transformationRunCount++;


			// Solve the Markov Chain, and add the result to the overall success
			// probability, weighted by the probability of the current resource
			// state combination:
			double probabilities[][] = solver.solve(markovChain);
			
			results.addSubChainResults(markovChain, probabilities, currentProbability);
			

			// Print transformation run results:
			if (getConfigurationAttribute(MessageStrings.SINGLE_RESULTS, false)) {
				TransformationResults singleResults=new TransformationResults();
				singleResults.addSubChainResults(markovChain, probabilities, currentProbability);
				printTransformationRunResults(pcmInfoProvider.getResourceDescriptors(), singleResults);
			}

			// Base case finished:
			return;
		}

		List<ProcessingResourceDescriptor> descriptors=pcmInfoProvider.getResourceDescriptors();
		// Consider all possible resource states:
		for (ProcessingResourceState state : ProcessingResourceState.values()) {

			// Get the probability of this state for the resource:
			descriptors.get(index).setCurrentState(state);
			Double newProbability = descriptors.get(index).getStateProbability(
					state);

			// If no MTTF/MTTR have been specified for the resource, assume that
			// the resource never breaks down:
			if ((newProbability == null) || (newProbability.isNaN())) {
				newProbability = (state.equals(ProcessingResourceState.OK)) ? 1.0
						: 0.0;
			}

			// Consider the next resource and its possible states:
			if (newProbability != 0.0) {
				runPcm2MarkovRecursively(pcmInfoProvider, index + 1,
						currentProbability * newProbability);
			}
		}
	}

	/**
	 * Prints headings for transformation run results.
	 * 
	 * @param descriptors
	 *            the resource descriptors
	 */
	private void printTransformationRunHeadings(
			final List<ProcessingResourceDescriptor> descriptors) {

		// Build a result string:
		String resultString = "run number;";

		// Print resource state headings:
		for (ProcessingResourceDescriptor descriptor : descriptors) {
			resultString += descriptor.getResourceContainerName() + " - "
					+ descriptor.getResourceTypeName() + ";";
		}

		// Print result heading:
		resultString += "result;";

		// Print probability heading:
		resultString += "probability";

		// Display information to the user. Use direct console print to omit the
		// prefix:
		if (rawStream != null) {
			rawStream.println(resultString);
		}
	}

	/**
	 * Prints the results of a single transformation run.
	 * 
	 * @param descriptors
	 *            the resource descriptors
	 * @param currentProbability
	 *            the probability of the current resource state combination
	 * @param result
	 *            the Markov result of the transformation
	 */
	private void printTransformationRunResults(
			final List<ProcessingResourceDescriptor> descriptors,
			final TransformationResults results) {
		

		
		// Display information to the user. Use direct console print to omit the
		// prefix:
		if (rawStream != null) {
			rawStream.println(getTransformationRunResults(descriptors, results));
		}
	}

	private String getDescriptorInfo(
			final List<ProcessingResourceDescriptor> descriptors) {

		// Build a result string:
		StringBuilder resultString=new StringBuilder();

		// Print resource states:
		for (ProcessingResourceDescriptor descriptor : descriptors) {
			resultString.append(descriptor.getCurrentState().toString() + ";");
		}

		return resultString.toString();
	}
	private String getTransformationRunResults(
			final List<ProcessingResourceDescriptor> descriptors,
			final TransformationResults results) {
		// Build a result string:
		StringBuilder resultString = new StringBuilder();
		resultString.append(transformationRunCount + ";");

		resultString.append(getDescriptorInfo(descriptors));
		resultString.append(getTransformationResultsInfo(results));
		
		return resultString.toString();
	}
	private String getTransformationResultsInfo(final TransformationResults results) {

		// Build a result string:
		StringBuilder resultString=new StringBuilder();

		// Define a format for double printing:
		DecimalFormat format = new DecimalFormat("0.000000000");
		
		resultString.append(String.format("[Success] %1$-30s %2$.8f %n", "Success Probability:", results.getSuccessProbability()));
		
		for(String failureType : results.getAllFailureTypes()) {
			resultString.append(String.format("[Failure] %1$-30s %2$.8f %n", failureType+":", results.getFailureTypeProbability(failureType)));
		}
		
		return resultString.toString();
	}

	/**
	 * Prints the result of sensitivity analysis.
	 * 
	 */
	private void printSensitivityAnalysisResults() {

		// Assert the stream to exist:
		if (rawStream == null) {
			return;
		}

		// Print result header:
		rawStream.println("run number;failure probability;result");

		// Define a format for double printing:
		DecimalFormat format = new DecimalFormat("0.000000000");

		// Print single results:
		for (int i = 0; i < sensitivityController.getStepCount(); i++) {

			// Build a result string:
			String resultString = (i + 1) + ";";

			// Add the failure probability of this step:
			Double val = sensitivityController.getParameters().get(0)
					.getValues().get(i);
			resultString += format.format(val) + ";";

			// Add the result of this step:
			resultString += format.format(sensitivityResults.get(i));

			// Print the result:
			rawStream.println(resultString);
		}

	}

	

	/**
	 * Prepares the sensitivity analysis.
	 * 
	 * Preparation includes copy of model files into the temporary models
	 * directory and determining the properties for the PCM instances to be
	 * created.
	 * 
	 * @throws CoreException
	 *             if reading the launch configuration fails
	 * @throws IOException
	 *             if file copy to temporary models directory fails
	 */
	private void prepareSensitivity() throws IOException, CoreException {

		// Create the temporary resources for this step:
		createResource(configuration.getAttribute(
				ConstantsContainer.REPOSITORY_FILE, ""), "Filename_Repository");
		createResource(configuration.getAttribute(
				ConstantsContainer.ALLOCATION_FILE, ""), "Filename_AllocationModel");
		createResource(configuration.getAttribute(
				ConstantsContainer.RESOURCEENVIRONMENT_FILE, ""),
				"Filename_ResourceEnvironment");
		createResource(configuration.getAttribute(
				ConstantsContainer.RESOURCETYPEREPOSITORY_FILE, ""),
				"Filename_ResourceType");
		createResource(configuration.getAttribute(
				ConstantsContainer.SYSTEM_FILE, ""), "Filename_System");
		createResource(configuration.getAttribute(
				ConstantsContainer.USAGE_FILE, ""), "Filename_UsageModel");

		// Fill the properties needed for PCM instance creation:
		props.setProperty("Storage_Path", "");
	}

	/**
	 * Creates an adjusted PCM instance in the temporary directory during
	 * sensitivity analysis.
	 * 
	 * @param step
	 *            the current sensitivity analysis step
	 * @return a PCM instance reflecting the current step
	 */
	private PCMInstance createAdjustedModel(final int step) {

		// Load the model from XMI files:
		PCMInstance adjustedModel = new PCMInstance(props);

		// Reference the sensitivity analysis parameter:
		SensitivityParameter parameter = sensitivityController.getParameters()
				.get(0);

		//TODO: That cast is unsafe. Add failure handling here and provide user-friendly error messages. 
		// Adjust the model by changing the failure probability of the
		// InternalAction chosen by sensitivity analysis:
		InternalAction action = 
			(InternalAction) markovHelper.getModelElement(
				adjustedModel.getRepository(), parameter.getElementId());

		FailureOccurrenceDescription occurrenceForType=null;;
		for(FailureOccurrenceDescription occurrence: action.getFailureOccurrenceDescriptions()) {
			if(occurrence.getFailuretype().getEntityName().equals(parameter.getFailureType())) {
				occurrenceForType=occurrence;
			}
		}

		if(occurrenceForType==null)
			throw new MarkovException("Internal action '"+action.getEntityName()+"' does define a failure occurrece for the failure type '"+parameter.getFailureType()+"'.");
		
		occurrenceForType.setFailureProbability(parameter.getValues().get(step));
		
		// It is necessary to store the changes back to the model files
		// because EMF model element proxies won't be resolved to
		// elements already loaded into memory, but to elements newly
		// created out of the model files. The saving has to be done
		// before any proxy resolving takes place:
		adjustedModel.saveToXMIFile(adjustedModel.getRepository(), props
				.getProperty("Filename_Repository"));

		// Create the temporary PCM instance:
		return adjustedModel;
	}

	/**
	 * Creates a temporary resource during sensitivity analysis.
	 * 
	 * @param baseURI
	 *            the base URI of the resource
	 * @param key
	 *            the key for the PCM instance properties
	 * @throws IOException
	 *             if file copy to temporary model directory fails
	 */
	private void createResource(final String baseURI, final String key)
			throws IOException {

		// Assume the resource is a file:
		File baseFile = new File(baseURI);
		File tempFile = new File(sensitivityController.getTemporaryModelDir(),
				"\\" + baseFile.getName());

		// If the resource is a file, then this file has to be copied into the
		// temporary models directory:
		if (baseFile.isFile()) {
			copyFile(baseFile.getAbsolutePath(), tempFile.getAbsolutePath());
		}

		// Set the target properties for the PCM instance. This also depends on
		// the nature of the resource:
		if (baseFile.isFile()) {
			props.setProperty(key, tempFile.getAbsolutePath());
		} else {
			props.setProperty(key, baseURI);
		}
	}

	/**
	 * Retrieves an attribute from the launch configuration.
	 * 
	 * @param attributeName
	 *            the name of the attribute
	 * @param standardValue
	 *            the value to use if the attribute cannot be retrieved
	 * @return the value
	 */
	private boolean getConfigurationAttribute(final String attributeName,
			final boolean standardValue) {

		// Check the launch configuration for being existent:
		if (configuration == null) {
			return standardValue;
		}

		// Try to retrieve the value:
		try {
			return configuration.getAttribute(attributeName,
					standardValue);
		} catch (CoreException exception) {
			return standardValue;
		}
	}

	/**
	 * Helper routine to copy a file from a source path to a target path.
	 * 
	 * @param sourcePath
	 *            the source path - must be an absolute path including file name
	 * @param targetPath
	 *            the target path - must be an absolute path including file name
	 * @throws IOException
	 *             might be thrown during file access
	 */
	private void copyFile(final String sourcePath, final String targetPath)
			throws IOException {

		// Create file objects:
		File inputFile = new File(sourcePath);
		File outputFile = new File(targetPath);

		// Create new directory and file, if not already existent:
		outputFile.getParentFile().mkdir();
		outputFile.createNewFile();

		// Copy contents of original file into new file:
		FileInputStream in = new FileInputStream(inputFile);
		FileOutputStream out = new FileOutputStream(outputFile);
		int c;
		while ((c = in.read()) != -1) {
			out.write(c);
		}

		// It's done:
		in.close();
		out.close();
	}
}

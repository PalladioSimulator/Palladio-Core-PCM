package de.uka.ipd.sdq.simuservice;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.WriterAppender;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComWorkflowConfiguration;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.SimuComJob;
import de.uka.ipd.sdq.sensorframework.SensorFrameworkDataset;
import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;
import de.uka.ipd.sdq.simuservice.types.ISimuService;
import de.uka.ipd.sdq.simuservice.types.SimuServiceParams;
import de.uka.ipd.sdq.simuservice.types.SimuServiceResultStatus;
import de.uka.ipd.sdq.workflow.Workflow;
import de.uka.ipd.sdq.workflow.exceptions.InvalidWorkflowJobConfiguration;
import de.uka.ipd.sdq.workflow.exceptions.WorkflowExceptionHandler;
import de.uka.ipd.sdq.workflow.exceptions.WorkflowFailedException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.ui.UIBasedWorkflow;

/**
 * The SimuService provides an operation to perform a simulation, and thus
 * provides an entry point to simulation that can be published as a web service.
 * 
 * @author brosch, heupel, kuester
 */
@WebService(name = "PCMSimulationService")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class SimuService implements ISimuService {

	private IProject project = null;
	private File simResultsDir = null;
	private SimuServiceSerializerHelper helper = null;
	private PredictionResultHelper resultHelper = PredictionResultHelper
			.getHelper();

	/**
	 * The use of semaphore ensures that the SimuService is not executed more
	 * than once concurrently.
	 */
	private static Semaphore semaphore = new Semaphore(1);

	/**
	 * The simulation operation is provided by the service.
	 * 
	 * @param params
	 *            the input parameters to simulation
	 * @return status information about the simulation run
	 */
	@WebMethod(operationName = "simulate")
	public SimuServiceResultStatus simulate(SimuServiceParams params) {

		// Create a new status object to capture the status of the SimuService
		// execution:
		SimuServiceResultStatus status = new SimuServiceResultStatus();

		// Ensure that the method is not executed more than once concurrently:
		try {
			semaphore.acquire();
		} catch (InterruptedException e) {
			// If the semaphore mechanism does not work, return an error:
			status.setException(e.getMessage());
			status.freeze();
			return status;
		}

		// Create or reopen the simulation project:
		initializeProject(status);

		// Create a serialization helper:
		helper = new SimuServiceSerializerHelper(project, params);

		// Write the model files into the simulation project:
		try {
			helper.deserializeModelFiles();
		} catch (IOException e) {
			status.setException(e.getMessage());
		}

		// Don't simulate if something went wrong:
		if (status.getException() != null && !status.getException().equals("")) {
			System.out.println("Exception occurred " + status.getException());
			semaphore.release();
			return status;
		}

		// Do the actual simulation:
		try {
			performSimulation(status, params);
		} catch (WorkflowFailedException e) {
			status.setException("WorkflowFailedException (" + getRootMessage(e)
					+ ")");
		} catch (Exception e) {
			// If the semaphore mechanism does not work, return an error:
			status.setException(e.getMessage());
			status.freeze();
			return status;
		}

		try {
			// Collect the simulation results:
			resultHelper.buildPredictionResult(status, simResultsDir
					.getAbsolutePath());
		} catch (Exception e) {
			// If the semaphore mechanism does not work, return an error:
			status.setException(e.getMessage());
			status.freeze();
			return status;
		}

		// Return the result:
		status.freeze();
		semaphore.release();
		return status;
	}

	/**
	 * Creates or opens the host project for simulation.
	 * 
	 * @param status
	 */
	private void initializeProject(SimuServiceResultStatus status) {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		project = root.getProject("SimulationProject");
		
		try {
			if (project.exists()) {
				project.delete(true, null);
			}
			project.create(null);
			project.open(null);
		} catch (CoreException e) {
			status.setException(e.getMessage());
			status.freeze();
		}
		simResultsDir = new File(project.getLocation().toFile()
				.getAbsolutePath()
				+ System.getProperty("file.separator")
				+ "simResults");
		simResultsDir.mkdir();
	}

	/**
	 * Performs a simulation run.
	 * 
	 * This method is synchronized so that multiple simulations are not
	 * performed concurrently.
	 * 
	 * @param status
	 *            object for reporting the status of the simulation run
	 * @param params
	 *            the input parameters to simulation
	 * @throws Exception
	 */
	private void performSimulation(final SimuServiceResultStatus status,
			final SimuServiceParams params) throws Exception {

		// Validate the given SimuService parameters:
		String validationString = params.validate();
		if (validationString != null) {
			throw new Exception("SimuService params invalid: "
					+ validationString);
		}

		// The configuration object holds all data necessary for simulation:
		SimuComWorkflowConfiguration workflowConfiguration = createWorkflowConfig(params);

		// Initialize a data set for simulation results:
		SensorFrameworkDataset.singleton().removeAllDataSources();
		SensorFrameworkDataset.singleton().addDataSource(
				new FileDAOFactory(1, simResultsDir.getAbsolutePath()));

		// Initialize logging functionality:
		initializeLogging(params.isVerboseLogging(), params.isClearLogging());

		// Record the status of SimuService execution:
		status.setWorkflowParamsConfigured(true);

		// Create a new workflow that throws exceptions:
		Workflow workflow = null;
		workflow = new UIBasedWorkflow<MDSDBlackboard>(new SimuComJob(
				workflowConfiguration), new NullProgressMonitor(),
				new WorkflowExceptionHandler(true), new MDSDBlackboard());

		// Record the status of SimuService execution:
		status.setWorkflowCreated(true);

		// Execute the workflow:
		workflow.run();

		// Finalize the data source used for prediction (so that sensor data are
		// flushed to the file system and can be retrieved by the client):
		SensorFrameworkDataset.singleton().removeAllDataSources();

		// Record the status of SimuService execution:
		status.setWorkflowSuccessful(true);
	}

	/**
	 * Creates a SimuCom workflow configuration based on the given SimuService
	 * parameters.
	 * 
	 * @param params
	 *            the SimuService parameters.
	 * @return the SimCom workflow configuration
	 * @throws InvalidWorkflowJobConfiguration
	 */
	private SimuComWorkflowConfiguration createWorkflowConfig(
			SimuServiceParams params) throws InvalidWorkflowJobConfiguration {

		// Create the workflow config variable:
		SimuComWorkflowConfiguration workflowConfiguration = new SimuComWorkflowConfiguration();

		// Set config parameters according to params object:
		List<String> allocationFiles = new ArrayList<String>();
		allocationFiles.add(helper.getAllocationFile().getAbsolutePath());
		workflowConfiguration.setAllocationFiles(allocationFiles);
		workflowConfiguration.setUsageModelFile(helper.getUsageFile()
				.getAbsolutePath());

		// Use default values for further config parameters:
		workflowConfiguration
				.setMiddlewareFile("pathmap://PCM_MODELS/Glassfish.repository");
		// workflowConfiguration
		// .setFeatureConfigFile("pathmap://PCM_MODELS/ConnectorConfig.featureconfig");
		workflowConfiguration.setCleanupCode(true);

		// Configure the setting for completions (no completions will be used)
		// Create properties
		Map<String, Object> completionProperties = new HashMap<String, Object>();
		completionProperties.put("de.uka.ipd.sdq.cip.completion",
				new HashMap<String, String>());
		completionProperties.put("de.uka.ipd.sdq.cip.revalidate", false);
		// Create configuration (using the properties) and set it for the
		// workflow
		// CompletionConfiguration completionConfig = new
		// CompletionConfiguration(completionProperties);
		// workflowConfiguration.setCompletionConfig(completionConfig);

		// Create a SimuComConfig out of a hashmap with param / value pairs:
		Map<String, Object> simulationConfiguration = new HashMap<String, Object>();
		simulationConfiguration.put(SimuComConfig.EXPERIMENT_RUN,
				"SLASOISimulationRun");
		simulationConfiguration.put(SimuComConfig.SIMULATION_TIME,
				((Long) params.getMaxSimTime()).toString());
		simulationConfiguration.put(SimuComConfig.MAXIMUM_MEASUREMENT_COUNT,
				((Long) params.getMaxMeasurementsCount()).toString());
		simulationConfiguration.put(SimuComConfig.VERBOSE_LOGGING, params
				.isVerboseLogging());
		simulationConfiguration.put(SimuComConfig.SIMULATE_FAILURES, false);
		simulationConfiguration.put(SimuComConfig.DATASOURCE_ID, 1);
		SimuComConfig simuComConfig = new SimuComConfig(
				simulationConfiguration, 1, false);

		// Add the hashmap to the config:
		workflowConfiguration.setSimuComConfiguration(simuComConfig);

		// Validate the config and fix all values:
		workflowConfiguration.validateAndFreeze();

		// Return the result:
		return workflowConfiguration;
	}

	/**
	 * Initializes the logging functionality.
	 * 
	 * @param verboseLogging
	 *            Indicates if logging should be verbose.
	 * @param clearConsole
	 *            Indicated if the console should be cleared before starting the
	 *            new simulation
	 */
	private void initializeLogging(boolean verboseLogging, boolean clearConsole) {

		// Retrieve a message console for the logging:
		MessageConsole console = createOrReferenceMessageConsole();
		console.activate();
		if (clearConsole == true) {
			console.clearConsole();
		}
		MessageConsoleStream stream = console.newMessageStream();

		// Configure log4j:
		PatternLayout myLayout = new PatternLayout(
				"%d{HH:mm:ss,SSS} [%t] %-5p %c - %m%n");
		WriterAppender writerAppender = new WriterAppender(myLayout, stream);
		BasicConfigurator.resetConfiguration();
		BasicConfigurator.configure(writerAppender);

		// Set logging level:
		if (verboseLogging)
			Logger.getRootLogger().setLevel(Level.ALL);
		else
			Logger.getRootLogger().setLevel(Level.WARN);
	}

	/**
	 * Creates a new message console for the SimuService, or references an
	 * existing one.
	 * 
	 * @return the message console for the SimuService
	 */
	private MessageConsole createOrReferenceMessageConsole() {

		// The name of the console:
		String SimuServiceConsoleName = "SimuService Run";

		// If the console already exists, return a reference to the existing
		// console:
		for (IConsole console : ConsolePlugin.getDefault().getConsoleManager()
				.getConsoles()) {
			if (console.getName().equals(SimuServiceConsoleName)) {
				return (MessageConsole) console;
			}
		}

		// Create a new console:
		MessageConsole console = new MessageConsole(SimuServiceConsoleName,
				null);
		ConsolePlugin.getDefault().getConsoleManager().addConsoles(
				new IConsole[] { console });
		return console;
	}

	/**
	 * Searches for the root message of a throwable object.
	 * 
	 * @param e
	 *            the throwable object
	 * @return the root message
	 */
	private String getRootMessage(Throwable e) {
		Throwable root = e;
		while ((root.getCause() != null) && (root.getCause() != e)) {
			root = root.getCause();
		}
		return root.getMessage();
	}


}
package de.uka.ipd.sdq.simuservice;

import java.util.HashMap;
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
import de.uka.ipd.sdq.workflow.exceptions.WorkflowExceptionHandler;
import de.uka.ipd.sdq.workflow.exceptions.WorkflowFailedException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.ui.UIBasedWorkflow;

/**
 * The SimuService provides an operation to perform a simulation, and thus
 * provides an entry point to simulation that can be published as a web service.
 * 
 * author: brosch, heupel
 */
@WebService(name = "PCMSimulationService")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class SimuService implements ISimuService {

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

		// Perform the simulation run. Catch any exception that might occur:
		try {
			performSimulation(status, params);
		} catch (WorkflowFailedException e) {
			status.setException("WorkflowFailedException (" + getRootMessage(e)
					+ ")");
		} catch (Exception e) {
			status.setException(e.getMessage());
		}

		// Freeze the status object:
		status.freeze();

		// Release the acquired semaphore:
		semaphore.release();

		// Return the result:
		return status;
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
				new FileDAOFactory(1, params.getResultsDirectory()));

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
	 */
	private SimuComWorkflowConfiguration createWorkflowConfig(
			SimuServiceParams params) {

		// Create the workflow config variable:
		SimuComWorkflowConfiguration workflowConfiguration = new SimuComWorkflowConfiguration();

		// Set config parameters according to params object:
		workflowConfiguration.setAllocationFile(params.getAllocationFile());
		workflowConfiguration.setRepositoryFile(params.getRepositoryFile());
		workflowConfiguration.setUsageModelFile(params.getUsageFile());
		workflowConfiguration.setResourceTypeFile(params
				.getResourceEnvironmentFile());
		workflowConfiguration.setSystemFile(params.getSystemFile());

		// Use default values for further config parameters:
		workflowConfiguration
				.setMiddlewareFile("pathmap://PCM_MODELS/Glassfish.repository");
		workflowConfiguration
				.setFeatureConfigFile("pathmap://PCM_MODELS/ConnectorConfig.featureconfig");
		workflowConfiguration.setCleanupCode(true);

		// Create a SimuComConfig out of a hashmap with param / value pairs:
		Map<String, Object> simulationConfiguration = new HashMap<String, Object>();
		simulationConfiguration.put(SimuComConfig.EXPERIMENT_RUN,
				"ServiceTestRun");
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
package de.uka.ipd.sdq.simuservice;

import java.util.HashMap;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;

import de.uka.ipd.sdq.simucomframework.SimuComConfig;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComWorkflowConfiguration;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.SimuComJob;
import de.uka.ipd.sdq.codegen.workflow.Workflow;
import de.uka.ipd.sdq.codegen.workflow.exceptions.WorkflowExceptionHandler;
import de.uka.ipd.sdq.codegen.workflow.ui.UIBasedWorkflow;
import de.uka.ipd.sdq.simuservice.types.ISimuService;
import de.uka.ipd.sdq.simuservice.types.SimuServiceParams;
import de.uka.ipd.sdq.simuservice.types.SimuServiceResultStatus;

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

		// Perform the simulation run. Catch any exception that might occur:
		try {
			performSimulation(status, params);
		} catch (Exception e) {
			//status.setException(e);
		}

		// Freeze the status object:
		status.freeze();

		// Return the result:
		return status;
	}

	/**
	 * Performs a simulation run.
	 * 
	 * @param status
	 *            object for reporting the status of the simulation run
	 * @param params
	 *            the input parameters to simulation
	 * @throws CoreException
	 */
	private void performSimulation(final SimuServiceResultStatus status,
			final SimuServiceParams params) throws CoreException {

		// The configuration object holds all data necessary for simulation:
		SimuComWorkflowConfiguration workflowConfiguration = new SimuComWorkflowConfiguration();

		// TODO: Fill the configuration object with the params and add default
		// values for other parameters:
		
		// Set configuration values received from params object
		workflowConfiguration.setAllocationFile(params.getAllocationFile());
		workflowConfiguration.setRepositoryFile(params.getRepositoryFile());
		workflowConfiguration.setUsageModelFile(params.getUsageFile());
		workflowConfiguration.setResourceTypeFile(params.getResourceEnvironmentFile());
		workflowConfiguration.setSystemFile(params.getSystemFile());
		
		// Set default configuration values
		workflowConfiguration.setMiddlewareFile("pathmap://PCM_MODELS/Glassfish.repository");
		workflowConfiguration.setFeatureConfigFile("pathmap://PCM_MODELS/ConnectorConfig.featureconfig");
		
		// HashMap will contain further configuration information
		Map<String, Object> simulationConfiguration = new HashMap<String, Object>();
		
		simulationConfiguration.put("datasourceID", 1);
		simulationConfiguration.put("maximumMeasurementCount", "10000000");
		simulationConfiguration.put("experimentRun", "ServiceTestRun");
		simulationConfiguration.put("simTime", "120");
		simulationConfiguration.put("verboseLogging", false);
		
		// Create new SimuComConfig and continue configuring workflow
		SimuComConfig simuComConfig = new SimuComConfig(simulationConfiguration, 1, false);
		
		workflowConfiguration.setSimuComConfiguration(simuComConfig);
		

		// Validate the configuration and fix all values:
		workflowConfiguration.validateAndFreeze();

		// Record the success of SimuService execution:
		status.setWorkflowParamsConfigured(true);

		// Create a new workflow:
		Workflow workflow = null;
		workflow = new UIBasedWorkflow<MDSDBlackboard>(new SimuComJob(
				workflowConfiguration), new NullProgressMonitor(),
				new WorkflowExceptionHandler(false), new MDSDBlackboard());

		// Record the success of SimuService execution:
		status.setWorkflowCreated(true);

		// Execute the workflow:
		workflow.run();

		// Record the success of SimuService execution:
		status.setWorkflowExecuted(true);
	}
}
package de.uka.ipd.sdq.simuservice;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComWorkflowConfiguration;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.MDSDBlackboard;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.SimuComJob;
import de.uka.ipd.sdq.codegen.workflow.Workflow;
import de.uka.ipd.sdq.codegen.workflow.exceptions.WorkflowExceptionHandler;
import de.uka.ipd.sdq.codegen.workflow.ui.UIBasedWorkflow;
import de.uka.ipd.sdq.simuservice.types.ISimuService;
import de.uka.ipd.sdq.simuservice.types.SimuServiceParams;

/**
 * The SimuService provides an operation to perform a simulation, and thus
 * provides an entry point to simulation that can be published as a web service.
 * 
 * author: brosch, heupel
 */
public class SimuService implements ISimuService {

	/**
	 * The simulation operation is provided by the service.
	 * 
	 * @param params
	 *            the input parameters to simulation
	 */
	public void simulate(SimuServiceParams params) {

		// The configuration object holds all data necessary for simulation:
		SimuComWorkflowConfiguration workflowConfiguration = new SimuComWorkflowConfiguration();

		// TODO: Fill the configuration object with the params and add default
		// values for other parameters:
		workflowConfiguration.setAllocationFile(params.getAllocationFile());
		// ...

		// Validate the configuration and fix all values:
		workflowConfiguration.validateAndFreeze();
		
		// Create a new workflow:
		Workflow workflow = null;		
		try {
			workflow = new UIBasedWorkflow<MDSDBlackboard>(new SimuComJob(
					workflowConfiguration), new NullProgressMonitor(),
					new WorkflowExceptionHandler(false), new MDSDBlackboard());
		} catch (CoreException e) {
			// This should never happen...
			e.printStackTrace();
		}
		
		// Execute the workflow:
		workflow.run();
	}
}
package de.uka.ipd.sdq.simuservice.impl;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComWorkflowConfiguration;
import de.uka.ipd.sdq.codegen.workflow.Workflow;
import de.uka.ipd.sdq.codegen.workflow.ui.UIBasedWorkflow;
import de.uka.ipd.sdq.simuservice.SimuService;
import de.uka.ipd.sdq.simuservice.SimuServiceParams;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.;

/**
 * The SimuService provides an operation to perform a simulation, and thus
 * provides an entry point to simulation that can be published as a web service.
 * 
 * author: brosch, heupel
 */
public class SimuServiceImpl implements SimuService {

	/**
	 * The simulation operation is provided by the service.
	 * 
	 * @param params
	 *            the input parameters to simulation
	 */
	public void simulate(SimuServiceParams params) {
		SimuComWorkflowConfiguration workflowConfiguration =
			new SimuComWorkflowConfiguration();

		// TODO: configure simucom using the methods of the configuration object

		workflowConfiguration.validateAndFreeze();
		Workflow workflow = new UIBasedWorkflow<MDSDBlackboard>(
					new SimuComJob(config),
					new NullProgressMonitor(),
				        new WorkflowExceptionHandler(false),
					new MDSDBlackboard());
		workflow.run();
	}

}
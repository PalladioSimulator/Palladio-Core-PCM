package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import de.uka.ipd.sdq.workflow.BlackboardBasedWorkflow;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedLaunchConfigurationDelegate;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedRunConfiguration;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

public abstract class AbstractWorkflowBasedMDSDLaunchConfigurationDelegate 
	<WorkflowConfigurationType extends AbstractWorkflowBasedRunConfiguration>
extends
		AbstractWorkflowBasedLaunchConfigurationDelegate
			<WorkflowConfigurationType,BlackboardBasedWorkflow<MDSDBlackboard>> {

	/**
	 * Factory method for the blackboard used in the workflow of this launch
	 * @return The blackboard to be used in the workflow
	 */
	protected abstract MDSDBlackboard createBlackboard();

}

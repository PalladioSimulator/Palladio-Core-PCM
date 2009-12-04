package de.uka.ipd.sdq.workflow.mdsd;

import de.uka.ipd.sdq.workflow.BlackboardBasedWorkflow;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedLaunchConfigurationDelegate;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedRunConfiguration;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ResourceSetPartition;

/**
 * Base class of workflows running as Eclipse run or debug launches which need a blackboard to load, manipulate, and
 * transform EMF models along their job processing. The blackboard configured here is a {@link MDSDBlackboard} containing
 * partitions where each partition is a {@link ResourceSetPartition}.
 * 
 * @author Steffen Becker
 *
 * @param <WorkflowConfigurationType> The type of the workflow configuration which should be used to configure this
 * workflow
 */
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

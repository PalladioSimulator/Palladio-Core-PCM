package de.uka.ipd.sdq.workflow.pcm.configurations;

import de.uka.ipd.sdq.workflow.mdsd.AbstractWorkflowBasedMDSDLaunchConfigurationDelegate;

/**
 * Base class for workflow based launch configurations (i.e., Eclipse Run and Debug tasks) which sets up a blackboard
 * containing PCM and other models (e.g., annotation mark models), a UI based run (i.e., a run which reports errors
 * to its user by the means of Eclipse UI Dialogs), and which configures openArchitectureWare's logging to report
 * to this runs console.
 *
 * @author Steffen Becker
 *
 * @param <WorkflowConfigurationType> The type of the workflow configuration used in this workflow. It has to be a subclass
 * of {@link AbstractPCMWorkflowRunConfiguration} as it needs the names of the PCM model parts involved
 */
public abstract class AbstractPCMLaunchConfigurationDelegate<WorkflowConfigurationType extends AbstractPCMWorkflowRunConfiguration>
extends
	AbstractWorkflowBasedMDSDLaunchConfigurationDelegate<WorkflowConfigurationType> {

	/**
	 * Constructor
	 */
	public AbstractPCMLaunchConfigurationDelegate() {
		super();
	}

}
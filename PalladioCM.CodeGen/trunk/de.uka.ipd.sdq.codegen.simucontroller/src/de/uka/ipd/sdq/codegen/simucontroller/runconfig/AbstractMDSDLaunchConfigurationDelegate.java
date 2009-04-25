package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;

import de.uka.ipd.sdq.codegen.simucontroller.workflow.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.codegen.workflow.ui.UIBasedWorkflow;

public abstract class AbstractMDSDLaunchConfigurationDelegate<T extends AbstractCodeGenerationWorkflowRunConfiguration>
extends
	AbstractWorkflowBasedMDSDLaunchConfigurationDelegate<T> {

	public AbstractMDSDLaunchConfigurationDelegate() {
		super();
	}

	@Override
	protected MDSDBlackboard createBlackboard() {
		return new MDSDBlackboard();
	}

	@Override
	protected UIBasedWorkflow<MDSDBlackboard> createWorkflow(
			T workflowConfiguration, 
			IProgressMonitor monitor,
			ILaunch launch) throws CoreException {
		return new UIBasedWorkflow<MDSDBlackboard>(
				createWorkflowJob(workflowConfiguration, launch), 
				monitor,
				createExcpetionHandler(workflowConfiguration.isInteractive()),
				createBlackboard());
	}	
}
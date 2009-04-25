package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import org.apache.log4j.Level;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;

import de.uka.ipd.sdq.codegen.workflow.ui.UIBasedWorkflow;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

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
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedLaunchConfigurationDelegate#setupLogging(org.apache.log4j.Level)
	 */
	@Override
	protected void setupLogging(Level logLevel) throws CoreException {
		super.setupLogging(logLevel);
		
		// Setup openArchitectureWare Logging
		setupLogger("org.openarchitectureware", logLevel, SHORT_LOG_PATTERN);
	}
}
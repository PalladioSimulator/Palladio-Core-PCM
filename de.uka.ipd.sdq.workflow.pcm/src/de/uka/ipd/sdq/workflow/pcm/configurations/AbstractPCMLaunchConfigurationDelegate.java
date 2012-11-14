package de.uka.ipd.sdq.workflow.pcm.configurations;

import java.util.ArrayList;

import org.apache.log4j.Level;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;

import de.uka.ipd.sdq.workflow.logging.console.LoggerAppenderStruct;
import de.uka.ipd.sdq.workflow.mdsd.AbstractWorkflowBasedMDSDLaunchConfigurationDelegate;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.ui.UIBasedWorkflow;

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

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.mdsd.AbstractWorkflowBasedMDSDLaunchConfigurationDelegate#createBlackboard()
	 */
	@Override
	protected MDSDBlackboard createBlackboard() {
		return new MDSDBlackboard();
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedLaunchConfigurationDelegate#createWorkflow(de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedRunConfiguration, org.eclipse.core.runtime.IProgressMonitor, org.eclipse.debug.core.ILaunch)
	 */
	@Override
	protected UIBasedWorkflow<MDSDBlackboard> createWorkflow(
			WorkflowConfigurationType workflowConfiguration,
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
	protected ArrayList<LoggerAppenderStruct> setupLogging(Level logLevel) throws CoreException {
		ArrayList<LoggerAppenderStruct> loggerList = super.setupLogging(logLevel);

		// Setup openArchitectureWare Logging
		loggerList.add(setupLogger("org.openarchitectureware", logLevel, SHORT_LOG_PATTERN));

		return loggerList;
	}
}
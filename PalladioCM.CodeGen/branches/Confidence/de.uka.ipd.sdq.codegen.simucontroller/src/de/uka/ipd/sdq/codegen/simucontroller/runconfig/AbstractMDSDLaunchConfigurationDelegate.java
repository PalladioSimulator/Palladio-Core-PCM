package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import java.util.ArrayList;

import org.apache.log4j.Level;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;

import de.uka.ipd.sdq.workflow.launchconfig.LoggerAppenderStruct;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.ui.UIBasedWorkflow;

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
	protected ArrayList<LoggerAppenderStruct> setupLogging(Level logLevel) throws CoreException {
		ArrayList<LoggerAppenderStruct> loggerList = super.setupLogging(logLevel);
		
		// Setup openArchitectureWare Logging
		loggerList.add(setupLogger("org.openarchitectureware", logLevel, SHORT_LOG_PATTERN));
		
		return loggerList;
	}
}
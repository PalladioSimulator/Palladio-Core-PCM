package de.uka.ipd.sdq.cip.runtime.runconfig;

import java.util.ArrayList;

import org.apache.log4j.Level;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.cip.runtime.workflow.jobs.CipJob;
import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowConfigurationBuilder;
import de.uka.ipd.sdq.workflow.logging.console.LoggerAppenderStruct;
import de.uka.ipd.sdq.workflow.mdsd.AbstractWorkflowBasedMDSDLaunchConfigurationDelegate;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

public class CipLaunchConfigurationDelegate
		extends
		AbstractWorkflowBasedMDSDLaunchConfigurationDelegate<CipConfiguration>{

	@Override
	protected MDSDBlackboard createBlackboard() {
		return new MDSDBlackboard();
	}

	@Override
	protected IJob createWorkflowJob(CipConfiguration config,
			final ILaunch launch) throws CoreException {
		return new CipJob(config,launch);
	}

	@Override
	protected CipConfiguration deriveConfiguration(
			ILaunchConfiguration configuration, String mode)
			throws CoreException {
		CipConfiguration cipConfiguration = new CipConfiguration();
		
		AbstractWorkflowConfigurationBuilder builder;
		builder = new CipLaunchConfigurationBasedConfigBuilder(configuration,mode);
		builder.fillConfiguration(cipConfiguration);
		
		return cipConfiguration;
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedLaunchConfigurationDelegate#setupLogging(org.apache.log4j.Level)
	 */
	@Override
	protected ArrayList<LoggerAppenderStruct> setupLogging(Level logLevel) throws CoreException {
		ArrayList<LoggerAppenderStruct> loggerList = super.setupLogging(logLevel);
		
		// Setup openArchitectureWare Logging
		loggerList.add(setupLogger("de.uka.ipd.sdq.cip", logLevel, Level.DEBUG == logLevel ? DETAILED_LOG_PATTERN : SHORT_LOG_PATTERN));
		loggerList.add(setupLogger("de.uka.ipd.sdq.workflow.mdsd.emf.qvtr", logLevel, Level.DEBUG == logLevel ? DETAILED_LOG_PATTERN : SHORT_LOG_PATTERN));
		
		return loggerList;
	}

}

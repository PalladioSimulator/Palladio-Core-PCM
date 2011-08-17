package de.uka.ipd.sdq.pcm.pcm2taskmodel.runconfig;

import java.util.ArrayList;

import org.apache.log4j.Level;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.pcmsolver.runconfig.PCMSolverConfigurationBasedConfigBuilder;
import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowConfigurationBuilder;
import de.uka.ipd.sdq.workflow.launchconfig.LoggerAppenderStruct;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractPCMLaunchConfigurationDelegate;
import de.uka.ipd.sdq.workflow.pcm.configurations.PCMWorkflowConfigurationBuilder;

public class PCM2TaskModelLaunchConfigurationDelegate
		extends
		AbstractPCMLaunchConfigurationDelegate<PCM2TaskModelWorkflowRunConfiguration> {

	@Override
	protected IJob createWorkflowJob(PCM2TaskModelWorkflowRunConfiguration config,
			ILaunch launch) throws CoreException {
		return new PCM2TaskModelJob(config, launch);
	}

	@Override
	protected PCM2TaskModelWorkflowRunConfiguration deriveConfiguration(
			ILaunchConfiguration configuration, String mode)
			throws CoreException {
		PCM2TaskModelWorkflowRunConfiguration solverConfiguration = new PCM2TaskModelWorkflowRunConfiguration();

		AbstractWorkflowConfigurationBuilder builder;

		builder = new PCMWorkflowConfigurationBuilder(configuration, mode);
		builder.fillConfiguration(solverConfiguration);

//		builder = new PCMSolverConfigurationBasedConfigBuilder(configuration,
//				mode);
//		builder.fillConfiguration(solverConfiguration);

		return solverConfiguration;
	}

	@Override
	protected ArrayList<LoggerAppenderStruct> setupLogging(Level logLevel)
			throws CoreException {
		ArrayList<LoggerAppenderStruct> loggerList = super
				.setupLogging(logLevel);
		loggerList.add(setupLogger("de.uka.ipd.sdq.pcmsolver", logLevel,
				Level.DEBUG == logLevel ? DETAILED_LOG_PATTERN
						: SHORT_LOG_PATTERN));

		return loggerList;
	}

}

package de.uka.ipd.sdq.pcmsolver.runconfig;

import java.util.ArrayList;

import org.apache.log4j.Level;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowConfigurationBuilder;
import de.uka.ipd.sdq.workflow.launchconfig.LoggerAppenderStruct;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractPCMLaunchConfigurationDelegate;
import de.uka.ipd.sdq.workflow.pcm.configurations.PCMWorkflowConfigurationBuilder;

public class PCMSolverLaunchConfigurationDelegate
		extends
		AbstractPCMLaunchConfigurationDelegate<PCMSolverWorkflowRunConfiguration> {

	@Override
	protected IJob createWorkflowJob(PCMSolverWorkflowRunConfiguration config,
			ILaunch launch) throws CoreException {
		return new PCMSolverJob(config, launch);
	}

	@Override
	protected PCMSolverWorkflowRunConfiguration deriveConfiguration(
			ILaunchConfiguration configuration, String mode)
			throws CoreException {
		PCMSolverWorkflowRunConfiguration solverConfiguration = new PCMSolverWorkflowRunConfiguration();

		AbstractWorkflowConfigurationBuilder builder;

		builder = new PCMWorkflowConfigurationBuilder(configuration, mode);
		builder.fillConfiguration(solverConfiguration);

		builder = new PCMSolverConfigurationBasedConfigBuilder(configuration,
				mode);
		builder.fillConfiguration(solverConfiguration);

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

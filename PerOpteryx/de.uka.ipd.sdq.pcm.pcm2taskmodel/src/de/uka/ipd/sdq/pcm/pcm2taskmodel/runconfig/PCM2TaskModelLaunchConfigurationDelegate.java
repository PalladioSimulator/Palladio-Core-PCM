package de.uka.ipd.sdq.pcm.pcm2taskmodel.runconfig;

import java.util.ArrayList;

import org.apache.log4j.Level;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.dsexplore.launch.DSEConstantsContainer;
import de.uka.ipd.sdq.pcm.pcm2taskmodel.jobs.PCM2TaskModelJob;
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

		// no builder required for just two filenames
		solverConfiguration.setTaskmodelResultFile(configuration.getAttribute(TaskmodelFileNamesInputTab.TASKMODEL_OUTPUT, TaskmodelFileNamesInputTab.TASKMODEL_DEFAULT_OUTPUT));
		solverConfiguration.setDesignDecisionFileName(configuration.getAttribute(DSEConstantsContainer.DESIGN_DECISION_FILE, ""));

		return solverConfiguration;
	}

	@Override
	protected ArrayList<LoggerAppenderStruct> setupLogging(Level logLevel)
			throws CoreException {
		ArrayList<LoggerAppenderStruct> loggerList = super
				.setupLogging(logLevel);
		loggerList.add(setupLogger("de.uka.ipd.sdq.pcm.pcm2taskmodel", logLevel,
				Level.DEBUG == logLevel ? DETAILED_LOG_PATTERN
						: SHORT_LOG_PATTERN));

		return loggerList;
	}

}

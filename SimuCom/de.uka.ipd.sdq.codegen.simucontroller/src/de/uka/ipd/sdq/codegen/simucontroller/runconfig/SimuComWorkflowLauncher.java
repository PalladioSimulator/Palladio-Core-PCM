package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import java.util.ArrayList;

import org.apache.log4j.Level;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.fzi.se.accuracy.jobs.AccuracyInfluenceAnalysisJob;
import de.uka.ipd.sdq.codegen.simucontroller.debug.IDebugListener;
import de.uka.ipd.sdq.codegen.simucontroller.debug.SimulationDebugListener;
import de.uka.ipd.sdq.workflow.jobs.IJob;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowConfigurationBuilder;
import de.uka.ipd.sdq.workflow.logging.console.LoggerAppenderStruct;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractPCMLaunchConfigurationDelegate;
import de.uka.ipd.sdq.workflow.pcm.configurations.PCMWorkflowConfigurationBuilder;

/**
 * The class adapts defined functionality in the AbstractMDSDLaunchConfigurationDelegate for
 * SimuCom Framework.
 *
 */
public class SimuComWorkflowLauncher extends
		AbstractPCMLaunchConfigurationDelegate<SimuComWorkflowConfiguration> {

	/*
	 * (non-Javadoc)
	 *
	 * @seede.uka.ipd.sdq.codegen.runconfig.LaunchConfigurationDelegate#
	 * creataAttributesGetMethods(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	@Override
	protected SimuComWorkflowConfiguration deriveConfiguration(
			ILaunchConfiguration configuration, String mode)
			throws CoreException {
		SimuComWorkflowConfiguration config = new SimuComWorkflowConfiguration(configuration.getAttributes());

		AbstractWorkflowConfigurationBuilder builder;
		builder = new PCMWorkflowConfigurationBuilder(configuration, mode);
		builder.fillConfiguration(config);

		builder = new SimuComLaunchConfigurationBasedConfigBuilder(
				configuration, mode);
		builder.fillConfiguration(config);

		return config;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.simucontroller.runconfig.AbstractMDSDLaunchConfigurationDelegate#setupLogging(org.apache.log4j.Level)
	 */
	@Override
	protected ArrayList<LoggerAppenderStruct> setupLogging(Level logLevel) throws CoreException {
		ArrayList<LoggerAppenderStruct> loggerList = super.setupLogging(logLevel);
		loggerList.add(setupLogger("de.uka.ipd.sdq.codegen", logLevel, Level.DEBUG == logLevel ? DETAILED_LOG_PATTERN : SHORT_LOG_PATTERN));
		loggerList.add(setupLogger("de.uka.ipd.sdq.simucomframework", logLevel, Level.DEBUG == logLevel ? DETAILED_LOG_PATTERN : SHORT_LOG_PATTERN));
		loggerList.add(setupLogger("de.uka.ipd.sdq.workflow.mdsd.emf.qvtr", logLevel, Level.DEBUG == logLevel ? DETAILED_LOG_PATTERN : SHORT_LOG_PATTERN));
		loggerList.add(setupLogger("de.uka.ipd.sdq.statistics", logLevel, Level.DEBUG == logLevel ? DETAILED_LOG_PATTERN : SHORT_LOG_PATTERN));
		loggerList.add(setupLogger("de.uka.ipd.sdq.probespec.framework", logLevel, Level.DEBUG == logLevel ? DETAILED_LOG_PATTERN : SHORT_LOG_PATTERN));
		loggerList.add(setupLogger("de.uka.ipd.sdq.pipesandfilters.framework", logLevel, Level.DEBUG == logLevel ? DETAILED_LOG_PATTERN : SHORT_LOG_PATTERN));
		loggerList.add(setupLogger("de.uka.ipd.sdq.pcm.transformations", logLevel, Level.DEBUG == logLevel ? DETAILED_LOG_PATTERN : SHORT_LOG_PATTERN));
		loggerList.add(setupLogger("de.uka.ipd.sdq.simulation", logLevel, Level.DEBUG == logLevel ? DETAILED_LOG_PATTERN : SHORT_LOG_PATTERN));
		loggerList.add(setupLogger("edu.kit.ipd.sdq.pcm.simulation.scheduler", logLevel, Level.DEBUG == logLevel ? DETAILED_LOG_PATTERN : SHORT_LOG_PATTERN));
		loggerList.add(setupLogger("Scheduler", logLevel, Level.DEBUG == logLevel ? DETAILED_LOG_PATTERN : SHORT_LOG_PATTERN));		
		
		return loggerList;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @seede.uka.ipd.sdq.codegen.runconfig.LaunchConfigurationDelegate#
	 * createRunCompositeJob
	 * (de.uka.ipd.sdq.codegen.runconfig.AttributesGetMethods)
	 */
	@Override
	protected IJob createWorkflowJob(SimuComWorkflowConfiguration config,
			final ILaunch launch) throws CoreException {
		IDebugListener listener = null;

		if (config.isDebug()) {
			listener = new SimulationDebugListener(launch);
		}

		SimuComWorkflowJobBuilder jobBuilder = new SimuComWorkflowJobBuilder(listener);
		return new AccuracyInfluenceAnalysisJob(config, jobBuilder);
	}
}

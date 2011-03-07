package de.uka.ipd.sdq.reliability.solver.runconfig;

import java.util.ArrayList;

import org.apache.log4j.Level;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.pcmsolver.RunPCMAnalysisJob;
import de.uka.ipd.sdq.pcmsolver.runconfig.PCMSolverLaunchConfigurationDelegate;
import de.uka.ipd.sdq.pcmsolver.runconfig.PCMSolverWorkflowRunConfiguration;
import de.uka.ipd.sdq.reliability.solver.pcm2markov.Pcm2MarkovStrategy;
import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.launchconfig.LoggerAppenderStruct;

/**
 * Launches the PCM Solver for Reliability analysis.
 * 
 * The extension point org.eclipse.debug.core.launchConfigurationTypes in the
 * plugin.xml refers to this class. The class inherits from the eclipse-internal
 * launch configuration delegate.
 * 
 * @author anne
 * 
 */
public class PCMSolverReliabilityLaunchConfigurationDelegate extends
		PCMSolverLaunchConfigurationDelegate {

	private Pcm2MarkovStrategy strategy = null;

	@Override
	protected IJob createWorkflowJob(PCMSolverWorkflowRunConfiguration config,
			ILaunch launch) throws CoreException {

		PCMSolverReliabilityJob job = new PCMSolverReliabilityJob(config, launch);
		RunPCMReliabilityAnalysisJob runJob = (RunPCMReliabilityAnalysisJob) job.getLast();
		this.setStrategy((Pcm2MarkovStrategy) runJob.getStrategy());
		return job;

	}

	@Override
	protected PCMSolverWorkflowRunConfiguration deriveConfiguration(
			ILaunchConfiguration configuration, String mode)
			throws CoreException {

		// First derive a configuration with general attributes for the PCM
		// Solver workflow:
		PCMSolverWorkflowRunConfiguration solverConfiguration = super
				.deriveConfiguration(configuration, mode);

		// Then, derive attributes specific to reliability solving:
		PCMSolverReliabilityConfigurationBasedConfigBuilder builder = new PCMSolverReliabilityConfigurationBasedConfigBuilder(
				configuration, mode);
		builder.fillConfiguration(solverConfiguration);

		return solverConfiguration;
	}

	public void setStrategy(Pcm2MarkovStrategy strategy) {
		this.strategy = strategy;
	}

	public Pcm2MarkovStrategy getStrategy() {
		return strategy;
	}


	/**
	 * Sets up the logging for the PCM Reliability Solver.
	 */
	protected ArrayList<LoggerAppenderStruct> setupLogging(Level logLevel)
			throws CoreException {
		ArrayList<LoggerAppenderStruct> loggerList = super
				.setupLogging(logLevel);
		loggerList.add(setupLogger("de.uka.ipd.sdq.reliability.solver", logLevel,
				Level.DEBUG == logLevel ? DETAILED_LOG_PATTERN
						: SHORT_LOG_PATTERN));

		return loggerList;
	}
}

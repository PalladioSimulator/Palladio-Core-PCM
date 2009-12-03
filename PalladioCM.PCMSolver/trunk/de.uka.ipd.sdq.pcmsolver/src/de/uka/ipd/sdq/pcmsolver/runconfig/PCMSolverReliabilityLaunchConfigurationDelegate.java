package de.uka.ipd.sdq.pcmsolver.runconfig;

import java.util.ArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;

import de.uka.ipd.sdq.pcmsolver.RunPCMAnalysisJob;
import de.uka.ipd.sdq.pcmsolver.transformations.pcm2markov.Pcm2MarkovStrategy;
import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
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
public class PCMSolverReliabilityLaunchConfigurationDelegate extends PCMSolverLaunchConfigurationDelegate {

	private Pcm2MarkovStrategy strategy = null;

	@Override
	protected IJob createWorkflowJob(PCMSolverWorkflowRunConfiguration config,
			ILaunch launch) throws CoreException {
		PCMSolverJob job = (PCMSolverJob) super.createWorkflowJob(config,launch);

		RunPCMAnalysisJob runJob = (RunPCMAnalysisJob)job.getLast();

		this.setStrategy((Pcm2MarkovStrategy) runJob.getStrategy());
		
		return job;
		
	}

	@Override
	protected PCMSolverWorkflowRunConfiguration deriveConfiguration(
			ILaunchConfiguration configuration, String mode)
			throws CoreException {
		PCMSolverWorkflowRunConfiguration pcmConfig = super.deriveConfiguration(configuration, mode);
		pcmConfig.setIsReliabilityAnalysis(true);
		
		return pcmConfig;
}

	public void setStrategy(Pcm2MarkovStrategy strategy) {
		this.strategy = strategy;
	}

	public Pcm2MarkovStrategy getStrategy() {
		return strategy;
	}

	
	
}

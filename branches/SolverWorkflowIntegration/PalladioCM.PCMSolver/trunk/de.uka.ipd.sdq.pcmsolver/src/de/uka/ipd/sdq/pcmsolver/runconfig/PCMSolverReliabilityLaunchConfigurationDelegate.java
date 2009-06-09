package de.uka.ipd.sdq.pcmsolver.runconfig;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;

import de.uka.ipd.sdq.pcmsolver.RunPCMAnalysisJob;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;

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

	@Override
	protected PCMSolverWorkflowRunConfiguration deriveConfiguration(
			ILaunchConfiguration configuration, String mode)
			throws CoreException {
		PCMSolverWorkflowRunConfiguration pcmConfig = super.deriveConfiguration(configuration, mode);
		pcmConfig.setIsReliabilityAnalysis(true);
		
		return pcmConfig;
	}
	
	
	
}

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
 * @author brosch
 * 
 */
public class PCMSolverReliabilityLaunchConfigurationDelegate implements
		ILaunchConfigurationDelegate {

	/**
	 * The central routine for launching the PCM Solver.
	 * 
	 * @param configuration
	 *            contains the values entered by the user to configure the
	 *            launch
	 * @param mode
	 *            distinguishes between run and debug modes
	 * @param launch ?
	 * @param monitor
	 *            displays launch progress to the user
	 * @throws CoreException ?
	 * @see org.eclipse.debug.core.model.ILaunchConfigurationDelegate#launch(org.eclipse.debug.core.ILaunchConfiguration,
	 *      java.lang.String, org.eclipse.debug.core.ILaunch,
	 *      org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void launch(final ILaunchConfiguration configuration,
			final String mode, final ILaunch launch,
			final IProgressMonitor monitor) throws CoreException {

		// Create a new PCM Solver:
		RunPCMAnalysisJob solver = new RunPCMAnalysisJob(configuration, true);

		// Start the solver:
		try {
			solver.execute(monitor);
		} catch (JobFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UserCanceledException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

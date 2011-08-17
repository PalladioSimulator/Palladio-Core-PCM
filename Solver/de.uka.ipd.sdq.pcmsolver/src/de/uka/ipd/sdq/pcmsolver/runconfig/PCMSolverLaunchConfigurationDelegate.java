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

//package de.uka.ipd.sdq.pcmsolver.runconfig;
//
//import org.eclipse.core.runtime.CoreException;
//import org.eclipse.core.runtime.IProgressMonitor;
//import org.eclipse.debug.core.ILaunch;
//import org.eclipse.debug.core.ILaunchConfiguration;
//import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
//
//import de.uka.ipd.sdq.pcmsolver.PCMSolver;
//
///**
// * Launches the PCM Solver.
// * 
// * The extension point org.eclipse.debug.core.launchConfigurationTypes in the
// * plugin.xml refers to this class. The class inherits from the eclipse-internal
// * launch configuration delegate.
// * 
// * @author koziolek, brosch
// * 
// */
//public class PCMSolverLaunchConfigurationDelegate implements
//		ILaunchConfigurationDelegate {
//
//	/**
//	 * The central routine for launching the PCM Solver.
//	 * 
//	 * @param configuration
//	 *            contains the values entered by the user to configure the
//	 *            launch
//	 * @param mode
//	 *            distinguishes between run and debug modes
//	 * @param launch ?
//	 * @param monitor
//	 *            displays launch progress to the user
//	 * @throws CoreException ?
//	 * @see org.eclipse.debug.core.model.ILaunchConfigurationDelegate#launch(org.eclipse.debug.core.ILaunchConfiguration,
//	 *      java.lang.String, org.eclipse.debug.core.ILaunch,
//	 *      org.eclipse.core.runtime.IProgressMonitor)
//	 */
//	public void launch(final ILaunchConfiguration configuration,
//			final String mode, final ILaunch launch,
//			final IProgressMonitor monitor) throws CoreException {
//
//		// Create a new PCM Solver:
//		PCMSolver solver = new PCMSolver(configuration, monitor);
//
//		// Start the solver:
//		solver.execute();
//
//	}
//
//}
public class PCMSolverLaunchConfigurationDelegate extends AbstractPCMLaunchConfigurationDelegate<PCMSolverWorkflowRunConfiguration>{

	@Override
	protected IJob createWorkflowJob(PCMSolverWorkflowRunConfiguration config,
			ILaunch launch) throws CoreException {
		return new PCMSolverJob(config,launch);
	}

	@Override
	protected PCMSolverWorkflowRunConfiguration deriveConfiguration(
			ILaunchConfiguration configuration, String mode)
			throws CoreException {
		PCMSolverWorkflowRunConfiguration solverConfiguration = new PCMSolverWorkflowRunConfiguration();

		AbstractWorkflowConfigurationBuilder builder;
		builder = new PCMWorkflowConfigurationBuilder(configuration, mode);
		builder.fillConfiguration(solverConfiguration);

		// TODO: Temporary workaround to integrate old code in PCMSolver
		solverConfiguration.setRawConfig(configuration);
		
		return solverConfiguration;
	}

	@Override
	protected ArrayList<LoggerAppenderStruct> setupLogging(Level logLevel) throws CoreException {
		ArrayList<LoggerAppenderStruct> loggerList = super.setupLogging(logLevel);
		loggerList.add(setupLogger("de.uka.ipd.sdq.pcmsolver", logLevel, Level.DEBUG == logLevel ? DETAILED_LOG_PATTERN : SHORT_LOG_PATTERN));
		
		return loggerList;
}
	

}

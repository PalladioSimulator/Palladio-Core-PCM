package de.uka.ipd.sdq.dsexplore.analysis;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedLaunchConfigurationDelegate;


public class AnalysisLaunch {


	public static void launchDelegate(
			AbstractWorkflowBasedLaunchConfigurationDelegate solverDelegate,
			ILaunchConfiguration config, String mode, ILaunch launch,
			IProgressMonitor monitor) throws CoreException {
		
		solverDelegate.launch(config, mode, launch, monitor);
		
		
	}
	
}

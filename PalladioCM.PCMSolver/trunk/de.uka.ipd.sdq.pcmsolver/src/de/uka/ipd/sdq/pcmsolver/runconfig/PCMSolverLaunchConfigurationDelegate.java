package de.uka.ipd.sdq.pcmsolver.runconfig;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;

import de.uka.ipd.sdq.pcmsolver.PCMSolver;

public class PCMSolverLaunchConfigurationDelegate implements
ILaunchConfigurationDelegate{

	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {
		//DependencySolver dsolver = new DependencySolver(configuration);
		PCMSolver solver = new PCMSolver(configuration, monitor);
		//solver.start();
		solver.start();
		
		
	}

}

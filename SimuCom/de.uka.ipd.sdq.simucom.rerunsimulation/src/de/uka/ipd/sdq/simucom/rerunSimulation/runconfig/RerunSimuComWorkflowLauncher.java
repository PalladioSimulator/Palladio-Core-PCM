package de.uka.ipd.sdq.simucom.rerunSimulation.runconfig;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimulationWorkflowLauncher;

public class RerunSimuComWorkflowLauncher extends SimulationWorkflowLauncher {

    @Override
    public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor)
            throws CoreException {
        new RerunSimulationWorkflowLauncher().launch(configuration, mode, launch, monitor);
    }
}

package de.uka.ipd.sdq.simucom.rerunSimulation.runconfig;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComWorkflowConfiguration;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComWorkflowLauncher;

public class RerunSimulationWorkflowLauncher extends SimuComWorkflowLauncher {

    /*
     * (non-Javadoc)
     * 
     * @seede.uka.ipd.sdq.codegen.runconfig.LaunchConfigurationDelegate#
     * creataAttributesGetMethods(org.eclipse.debug.core.ILaunchConfiguration)
     */
    @Override
    protected SimuComWorkflowConfiguration deriveConfiguration(ILaunchConfiguration configuration, String mode)
            throws CoreException {
        SimuComWorkflowConfiguration config = super.deriveConfiguration(configuration, mode);

        config.setSkipProjectGeneration(true);        
        config.setDeleteTemporaryDataAfterAnalysis(false);
        
        return config;
    }
}

package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;

import de.uka.ipd.sdq.simulation.AbstractSimulationConfig;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractPCMLaunchConfigurationDelegate;

public class SimulationWorkflowLauncher implements ILaunchConfigurationDelegate {

    @Override
    public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor)
            throws CoreException {
        // find simulator extension by its ID as specified in the launch configuration
        String simulatorId = configuration.getAttribute(AbstractSimulationConfig.SIMULATOR_ID,
                AbstractSimulationConfig.DEFAULT_SIMULATOR_ID);
        IConfigurationElement[] simulatorExtensions = Platform.getExtensionRegistry().getConfigurationElementsFor(
                SimulatorExtensionHelper.EXTENSION_POINT_ID);
        IConfigurationElement selectedExtension = null;
        for (IConfigurationElement extension : simulatorExtensions) {
            if (extension.getAttribute("id").equals(simulatorId)) {
                selectedExtension = extension;
            }
        }

        // create launch configuration delegate for the selected simulator
        AbstractPCMLaunchConfigurationDelegate<?> delegate = null;
        try {
            delegate = (AbstractPCMLaunchConfigurationDelegate<?>) selectedExtension
                    .createExecutableExtension("launchDelegate");
        } catch (CoreException e) {
            // TODO throw more detailed exception
            throw e;
        }

        // delegate simulator launch
        delegate.launch(configuration, mode, launch, monitor);
    }

}

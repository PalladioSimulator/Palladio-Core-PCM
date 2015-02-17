package de.uka.ipd.sdq.simucom.rerunsimulation.runconfig;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.codegen.simucontroller.debug.IDebugListener;
import de.uka.ipd.sdq.codegen.simucontroller.debug.SimulationDebugListener;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComLaunchConfigurationBasedConfigBuilder;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComWorkflowConfiguration;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComWorkflowLauncher;
import de.uka.ipd.sdq.simucom.rerunsimulation.jobs.RerunSimulationJob;
import de.uka.ipd.sdq.workflow.jobs.IJob;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowConfigurationBuilder;
import de.uka.ipd.sdq.workflow.pcm.ConstantsContainer;
import de.uka.ipd.sdq.workflow.pcm.configurations.PCMWorkflowConfigurationBuilder;

/**
 * This class creates the RerunSimulationJob which is needed for rerunning the simulation without
 * having to delete the original data
 * 
 * @author Michael
 *
 */
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
        RerunSimuComWorkflowConfiguration config = new RerunSimuComWorkflowConfiguration(configuration.getAttributes());

        AbstractWorkflowConfigurationBuilder builder;
        builder = new PCMWorkflowConfigurationBuilder(configuration, mode);
        builder.fillConfiguration(config);

        builder = new SimuComLaunchConfigurationBasedConfigBuilder(configuration, mode);
        builder.fillConfiguration(config);

        config.setRegenerateAllocation(configuration.getAttribute(ConstantsContainer.REGENERATE_ALLOCATION, false));
        config.setRegenerateUsage(configuration.getAttribute(ConstantsContainer.REGENERATE_USAGE, false));

        return config;
    }

    /*
     * (non-Javadoc)
     * 
     * @seede.uka.ipd.sdq.codegen.runconfig.LaunchConfigurationDelegate# createRunCompositeJob
     * (de.uka.ipd.sdq.codegen.runconfig.AttributesGetMethods)
     */
    @Override
    protected IJob createWorkflowJob(SimuComWorkflowConfiguration config, final ILaunch launch) throws CoreException {
        IDebugListener listener = null;

        if (config.isDebug()) {
            listener = new SimulationDebugListener(launch);
        }

        return new RerunSimulationJob(config, listener);
    }
}

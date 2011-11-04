package de.uka.ipd.sdq.simulation.controller.runconfig;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.AbstractSimulationLaunchConfigurationBasedConfigBuilder;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComLaunchConfigurationBasedConfigBuilder;
import de.uka.ipd.sdq.simulation.EventSimConfig;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedRunConfiguration;

/**
 * This class is based on {@link SimuComLaunchConfigurationBasedConfigBuilder}. Some code has been
 * reused.
 * 
 * @author Philipp Merkle
 * 
 */
public class EventSimLaunchConfigurationBasedConfigBuilder extends
        AbstractSimulationLaunchConfigurationBasedConfigBuilder {

    public EventSimLaunchConfigurationBasedConfigBuilder(ILaunchConfiguration configuration, String mode)
            throws CoreException {
        super(configuration, mode);
    }

    @Override
    public void fillConfiguration(AbstractWorkflowBasedRunConfiguration configuration) throws CoreException {
        super.fillConfiguration(configuration);
        
        EventSimWorkflowConfiguration config = (EventSimWorkflowConfiguration) configuration;

        config.setSimulationConfiguration(new EventSimConfig(properties, config.isDebug()));
    }

}

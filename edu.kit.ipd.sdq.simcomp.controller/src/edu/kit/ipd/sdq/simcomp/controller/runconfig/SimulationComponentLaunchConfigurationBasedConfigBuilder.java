package edu.kit.ipd.sdq.simcomp.controller.runconfig;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.AbstractSimulationLaunchConfigurationBasedConfigBuilder;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedRunConfiguration;
import edu.kit.ipd.sdq.simcomp.middleware.simulation.SimulationConfiguration;

/**
 * Creates a workflow configuration with an embedded simulation configuration
 * for the simulation components.
 * 
 * This class is based on {@link EventSimLaunchConfigurationBasedConfigBuilder}.
 * Some code has been reused.
 * 
 * @author Christoph Föhrdes
 */
public class SimulationComponentLaunchConfigurationBasedConfigBuilder extends AbstractSimulationLaunchConfigurationBasedConfigBuilder {

	public SimulationComponentLaunchConfigurationBasedConfigBuilder(ILaunchConfiguration configuration, String mode) throws CoreException {
		super(configuration, mode);
	}

	@Override
	public void fillConfiguration(AbstractWorkflowBasedRunConfiguration configuration) throws CoreException {
		super.fillConfiguration(configuration);

		SimulationComponentWorkflowConfiguration config = (SimulationComponentWorkflowConfiguration) configuration;

		config.setSimulationConfiguration(new SimulationConfiguration(properties, config.isDebug()));
	}

}

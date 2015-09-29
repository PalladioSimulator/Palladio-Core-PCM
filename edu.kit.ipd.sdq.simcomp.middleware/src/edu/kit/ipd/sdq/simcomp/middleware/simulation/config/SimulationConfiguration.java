package edu.kit.ipd.sdq.simcomp.middleware.simulation.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.palladiosimulator.analyzer.workflow.ConstantsContainer;

import de.uka.ipd.sdq.simulation.AbstractSimulationConfig;
import edu.kit.ipd.sdq.simcomp.component.meta.SimulationComponentImpl;
import edu.kit.ipd.sdq.simcomp.component.meta.SimulationComponentRequiredType;
import edu.kit.ipd.sdq.simcomp.config.ISimulationComponentConfiguration;
import edu.kit.ipd.sdq.simcomp.config.ISimulationConfiguration;
import edu.kit.ipd.sdq.simcomp.config.ISimulatorCompositonRule;

/**
 * A configuration object for a simulation component based advanced simulator
 * configuration.
 * 
 * This objects provides all properties necessary to be able to build a
 * {@link EventSimConfig} base on it.
 * 
 * @author Christoph Föhrdes
 */
public class SimulationConfiguration extends AbstractSimulationConfig implements ISimulationConfiguration {

	public static String SIMULATION_COMPONENT_SIMULATOR_ID = "de.uka.ipd.sdq.codegen.simucontroller.simcomp";

	public static String CONFIG_KEY_SIMULATION_COMPONENTS_CONFIG = "simCompConfig";

	private static final long serialVersionUID = 7117529282079662258L;

	private Map<String, Object> configMap;
	Map<SimulationComponentImpl, ISimulationComponentConfiguration> componentsConfig;
	Map<SimulationComponentRequiredType, SimulationComponentImpl> requiredTypeToSimCompMap;

	private final String usageModelFile;
	private final String allocationModelFile;

	public SimulationConfiguration(Map<String, Object> configuration, boolean debug) {
		super(configuration, debug);
		this.configMap = configuration;
		try {
			this.usageModelFile = (String) configuration.get(ConstantsContainer.USAGE_FILE);
			this.allocationModelFile = (String) configuration.get(ConstantsContainer.ALLOCATION_FILE);
		} catch (final Exception e) {
			throw new RuntimeException("Setting up properties failed, please check launch config (check all tabs).", e);
		}

		componentsConfig = new HashMap<SimulationComponentImpl, ISimulationComponentConfiguration>();
		requiredTypeToSimCompMap = new HashMap<SimulationComponentRequiredType, SimulationComponentImpl>();

		buildRequiredTypeBaseConfiguration();
	}

	private void buildRequiredTypeBaseConfiguration() {
		String serializedConfig = (String) configMap.get(SimulationConfiguration.CONFIG_KEY_SIMULATION_COMPONENTS_CONFIG);
		if (serializedConfig != null && !serializedConfig.isEmpty()) {
			componentsConfig = (HashMap<SimulationComponentImpl, ISimulationComponentConfiguration>) ConfigHelper.deserializeObject(serializedConfig);
		}

		// create map (requiredType -> component) for fast access during simulation run
		for (SimulationComponentImpl component : componentsConfig.keySet()) {
			for (SimulationComponentRequiredType requiredType : component.getRequiredTypes()) {
				requiredTypeToSimCompMap.put(requiredType, component);
			}
		}
	}

	@Override
	public String getUsageModelFile() {
		return this.usageModelFile;
	}

	@Override
	public String getAllocationModelFile() {
		return this.allocationModelFile;
	}

	@Override
	public Map<String, Object> getConfigurationMap() {
		return this.configMap;
	}

	@Override
	public SimulationComponentImpl getDefaultComponentForRequiredType(SimulationComponentRequiredType requiredType) {
		SimulationComponentImpl component = requiredTypeToSimCompMap.get(requiredType);
		ISimulationComponentConfiguration componentConfig = componentsConfig.get(component);

		if (componentConfig == null) {
			return null;
		}

		return componentConfig.getDefaultComponentForRequiredType(requiredType);
	}

	@Override
	public List<ISimulatorCompositonRule> getCompositionRulesForRequiredType(SimulationComponentRequiredType requiredType) {
		SimulationComponentImpl component = requiredTypeToSimCompMap.get(requiredType);
		ISimulationComponentConfiguration componentConfig = componentsConfig.get(component);

		if (componentConfig == null) {
			return new ArrayList<ISimulatorCompositonRule>();
		}

		return componentConfig.getCompositionRulesForRequiredType(requiredType);
	}

	@Override
	public long[] getRandomSeed() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
}

package edu.kit.ipd.sdq.simcomp.middleware.simulation.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.uka.ipd.sdq.simulation.AbstractSimulationConfig;
import de.uka.ipd.sdq.workflow.pcm.ConstantsContainer;
import edu.kit.ipd.sdq.simcomp.component.ISimulationComponent;
import edu.kit.ipd.sdq.simcomp.component.meta.SimulationComponentMetaData;
import edu.kit.ipd.sdq.simcomp.component.meta.SimulationComponentType;
import edu.kit.ipd.sdq.simcomp.config.ISimulationConfiguration;
import edu.kit.ipd.sdq.simcomp.config.ISimulatorCompositonRule;

/**
 * TODO (SimComp): implement it to contain everything we need and check we
 * provide all properties necessary to be able to build a {@link EventSimConfig}
 * base on it
 * 
 * @author Christoph Föhrdes
 */
public class SimulationConfiguration extends AbstractSimulationConfig implements ISimulationConfiguration {

	public static String SIMULATION_COMPONENT_SIMULATOR_ID = "de.uka.ipd.sdq.codegen.simucontroller.simcomp";

	public static String CONFIG_KEY_DEFAULT_COMPONENTS = "simCompdefaultComponens";
	public static String CONFIG_KEY_COMPOSITION_RULES = "simCompConpositionRules";

	private static final long serialVersionUID = 7117529282079662258L;

	private Map<String, Object> configMap;

	private final String usageModelFile;
	private final String allocationModelFile;
	Map<SimulationComponentType, SimulationComponentMetaData> defaultComponentsConfig;
	Map<SimulationComponentType, List<ISimulatorCompositonRule>> compositionRulesConfig;

	public SimulationConfiguration(Map<String, Object> configuration, boolean debug) {
		super(configuration, debug);
		this.configMap = configuration;
		try {
			this.usageModelFile = (String) configuration.get(ConstantsContainer.USAGE_FILE);
			this.allocationModelFile = (String) configuration.get(ConstantsContainer.ALLOCATION_FILE);
		} catch (final Exception e) {
			throw new RuntimeException("Setting up properties failed, please check launch config (check all tabs).", e);
		}
		
		defaultComponentsConfig = new HashMap<SimulationComponentType, SimulationComponentMetaData>();
		compositionRulesConfig = new HashMap<SimulationComponentType, List<ISimulatorCompositonRule>>();

		this.buildSimulatorCompositionRulesFromConfig(configuration);
	}

	@SuppressWarnings("unchecked")
	private void buildSimulatorCompositionRulesFromConfig(Map<String, Object> configuration) {
		// read default component config
		String serializedMap = (String) configuration.get(SimulationConfiguration.CONFIG_KEY_DEFAULT_COMPONENTS);
		if (!serializedMap.isEmpty()) {
			Map<SimulationComponentType, SimulationComponentMetaData> defaultcompCfg = (Map<SimulationComponentType, SimulationComponentMetaData>) ConfigHelper.deserializeObject(serializedMap);
			if (defaultcompCfg != null) {
				this.defaultComponentsConfig = defaultcompCfg;
			}
		}

		// read composition rules
		serializedMap = (String) configuration.get(SimulationConfiguration.CONFIG_KEY_COMPOSITION_RULES);
		if (!serializedMap.isEmpty()) {
			Map<SimulationComponentType, List<ISimulatorCompositonRule>> rulesCfg = (Map<SimulationComponentType, List<ISimulatorCompositonRule>>) ConfigHelper.deserializeObject(serializedMap);
			if (rulesCfg != null) {
				this.compositionRulesConfig = rulesCfg;
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
	public SimulationComponentMetaData getDefaultComponentForComponentType(Class<? extends ISimulationComponent> type) {
		for (SimulationComponentType typeKey : defaultComponentsConfig.keySet()) {
			Class<?> typeClass = null;
			try {
				typeClass = Class.forName(typeKey.getTypeInterface());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			if (typeClass.equals(type)) {
				return defaultComponentsConfig.get(typeKey);
			}
		}

		return null;
	}

	@Override
	public List<ISimulatorCompositonRule> getCompositionRulesForComponentType(Class<? extends ISimulationComponent> type) {
		for (SimulationComponentType typeKey : compositionRulesConfig.keySet()) {
			Class<?> typeClass = null;
			try {
				typeClass = Class.forName(typeKey.getTypeInterface());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			if (typeClass.equals(type)) {
				return compositionRulesConfig.get(typeKey);
			}
		}

		return null;
	}
}

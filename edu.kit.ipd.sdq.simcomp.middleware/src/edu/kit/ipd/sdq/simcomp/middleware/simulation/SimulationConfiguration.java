package edu.kit.ipd.sdq.simcomp.middleware.simulation;

import java.util.Map;

import de.uka.ipd.sdq.simulation.AbstractSimulationConfig;
import de.uka.ipd.sdq.workflow.pcm.ConstantsContainer;
import edu.kit.ipd.sdq.simcomp.component.ISimulationConfiguration;

/**
 * TODO (SimComp): implement it to contain everything we need and check we provide all properties necessary to be able to build a {@link EventSimConfig} base on it
 * 
 * @author Christoph Föhrdes
 */
public class SimulationConfiguration extends AbstractSimulationConfig implements ISimulationConfiguration {
	
	private static final long serialVersionUID = 7117529282079662258L;

	private Map<String, Object> configMap;

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
}

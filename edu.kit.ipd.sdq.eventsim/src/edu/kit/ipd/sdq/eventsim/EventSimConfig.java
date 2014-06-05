package edu.kit.ipd.sdq.eventsim;

import java.util.Map;

import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;
import de.uka.ipd.sdq.probfunction.math.IRandomGenerator;
import de.uka.ipd.sdq.simucomframework.SimuComDefaultRandomNumberGenerator;
import de.uka.ipd.sdq.simulation.AbstractSimulationConfig;
import de.uka.ipd.sdq.workflow.pcm.ConstantsContainer;

/**
 * This class encapsulates the configuration of an EventSim simulation run. The configuration is
 * provided to this class by a key-value map, which is passed to the constructor.
 * 
 * @author Philipp Merkle
 * 
 * @see AbstractSimulationConfig
 */
public class EventSimConfig extends AbstractSimulationConfig {

    private static final long serialVersionUID = -1484769217776789788L;

    private final String usageModelFile;
    private final String allocationModelFile;

    /**
     * Constructs the configuration for the specified key-value map.
     * 
     * @param configuration
     *            the key-value map containing the configuration settings
     * @param debug
     *            true, if the debugging mode should be used; false else
     */
    public EventSimConfig(final Map<String, Object> configuration, final boolean debug) {
        super(configuration, debug);
        try {
            this.usageModelFile = (String) configuration.get(ConstantsContainer.USAGE_FILE);
            this.allocationModelFile = (String) configuration.get(ConstantsContainer.ALLOCATION_FILE);
        } catch (final Exception e) {
            throw new RuntimeException("Setting up properties failed, please check launch config (check all tabs).", e);
        }
    }

    /**
     * Returns the location of the file containing the {@link UsageModel}.
     * 
     * @return the usage model file location
     */
    public String getUsageModelFile() {
        return this.usageModelFile;
    }

    /**
     * Returns the location of the file containing the {@link Allocation}.
     * 
     * @return the allocation file location
     */
    public String getAllocationModelFile() {
        return this.allocationModelFile;
    }

    /**
     * The private constructor prevents this class from being instantiated without passing the
     * configuration.
     */
    private EventSimConfig() {
        // this constructor is not intended to be called.
        super(null, false);
        this.usageModelFile = null;
        this.allocationModelFile = null;
    }

}

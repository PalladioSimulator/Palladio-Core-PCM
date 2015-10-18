package edu.kit.ipd.sdq.eventsim;

import java.util.Map;

import de.uka.ipd.sdq.simulation.AbstractSimulationConfig;
import edu.kit.ipd.sdq.eventsim.middleware.simulation.PCMModel;

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

    private PCMModel model;

    /**
     * Constructs the configuration for the specified key-value map.
     * 
     * @param configuration
     *            the key-value map containing the configuration settings
     * @param debug
     *            true, if the debugging mode should be used; false else
     */
    public EventSimConfig(final Map<String, Object> configuration, final boolean debug, PCMModel model) {
        super(configuration, debug);
        this.model = model;
    }

    /**
     * The private constructor prevents this class from being instantiated without passing the
     * configuration.
     */
    private EventSimConfig() {
        // this constructor is not intended to be called.
        super(null, false);
    }
    
	public PCMModel getModel() {
		return model;
	}

	public void setModel(PCMModel model) {
		this.model = model;
	}

}

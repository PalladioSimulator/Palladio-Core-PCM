package de.uka.ipd.sdq.simucomframework;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import de.uka.ipd.sdq.probespec.framework.BlackboardType;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationConfig;

/**
 * This is the abstract base class for simulation configurations. It encapsulates the configuration
 * elements that are common to all PCM simulators.
 * 
 * @author roman
 * @author Philipp Merkle
 * 
 */
public abstract class AbstractSimulationConfig implements Serializable, ISimulationConfig {

    public static String VERBOSE_LOGGING = "verboseLogging";
    /** the type of the ProbeSpec blackboard */
    public static String BLACKBOARD_TYPE = "blackboardType";

    private boolean verboseLogging;
    private boolean isDebug;
    private BlackboardType blackboardType;
    
    private final List<ISimulationListener> listeners;

    /**
     * @param configuration
     *            a map which maps configuration option IDs to their values. The required keys are
     *            <ul>
     *            <li>SimuComConfig.VERBOSE_LOGGING
     *            </ul>
     */
    public AbstractSimulationConfig(Map<String, Object> configuration, boolean debug) {
        try {
            this.verboseLogging = (Boolean) configuration.get(VERBOSE_LOGGING);
            this.isDebug = debug;

            // set the blackboard type
            try {
                this.blackboardType = BlackboardType.valueOf(asString(configuration, BLACKBOARD_TYPE));
            } catch (IllegalArgumentException e) {
                // this exception is thrown, if no enum name matches the passed String
                this.blackboardType = null;
            }
            if (this.blackboardType == null) {
                // use default blackboard type
                this.blackboardType = BlackboardType.CONCURRENT;
            }
            
            this.listeners = new ArrayList<ISimulationListener>();
        } catch (Exception e) {
            throw new RuntimeException("Setting up properties failed, please check launch config (check all tabs).", e);
        }
    }

    public boolean getVerboseLogging() {
        return verboseLogging || isDebug;
    }

    public boolean isDebug() {
        return this.isDebug;
    }

    public void addListener(ISimulationListener l) {
        listeners.add(l);
    }

    public List<ISimulationListener> getListeners() {
        return listeners;
    }
    
    public BlackboardType getBlackboardType() {
        return blackboardType;
    }

    private String asString(Map<String, Object> configuration, String propertyName) {
        String result = (String) configuration.get(propertyName);
        return result == null ? "" : result;
    }

    /*
     * TODO Move appropriate methods from SimuComConfig to this abstract class.
     */

}

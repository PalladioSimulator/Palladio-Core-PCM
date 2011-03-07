package de.uka.ipd.sdq.simulation;

import java.util.Map;

import de.uka.ipd.sdq.simucomframework.AbstractSimulationConfig;
import de.uka.ipd.sdq.workflow.launchconfig.ConstantsContainer;

/**
 * 
 * @author Philipp Merkle
 * 
 */
public class EventSimConfig extends AbstractSimulationConfig {

    private static final long serialVersionUID = -1484769217776789788L;
    
    public static final String SIMULATION_ENGINE_ID = "simulationEngineId";

    private String simulationEngineId; // TODO
    
    private String usageModelFile;
    private String allocationModelFile;
    
    public String getUsageModelFile() {
        return usageModelFile;
    }

    public String getAllocationModelFile() {
        return allocationModelFile;
    }

    public EventSimConfig(Map<String, Object> configuration, boolean debug) {
        super(configuration, debug);
        
        try {
            simulationEngineId = (String)configuration.get(SIMULATION_ENGINE_ID);
            usageModelFile = (String)configuration.get(ConstantsContainer.USAGE_FILE);
            allocationModelFile = (String)configuration.get(ConstantsContainer.ALLOCATION_FILE);
        } catch(Exception e) {
            throw new RuntimeException("TODO",e);
        }
    }

    private EventSimConfig() {
        super();
    }
    
}

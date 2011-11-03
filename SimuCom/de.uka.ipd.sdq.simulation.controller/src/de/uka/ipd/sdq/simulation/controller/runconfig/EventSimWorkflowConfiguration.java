package de.uka.ipd.sdq.simulation.controller.runconfig;

import java.util.Map;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.AbstractSimulationWorkflowConfiguration;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComWorkflowConfiguration;
import de.uka.ipd.sdq.simucomframework.AbstractSimulationConfig;
import de.uka.ipd.sdq.simulation.EventSimConfig;

/**
 * This class is based on {@link SimuComWorkflowConfiguration}. Some code has been reused.
 * 
 * @author Philipp Merkle
 * 
 */
public class EventSimWorkflowConfiguration extends AbstractSimulationWorkflowConfiguration {

    /** logger for this class. */
    private static final Logger logger = Logger.getLogger(EventSimWorkflowConfiguration.class);

    private EventSimConfig eventSimConfig = null;

    public EventSimWorkflowConfiguration(Map<String, Object> attributes) {
        super(attributes);
    }

    @Override
    public String getErrorMessage() {
        // must be null; otherwise a non-empty error message will result in
        // a workflow config being considered invalid
        return null;
    }

    @Override
    public void setDefaults() {
        throw new RuntimeException("Not implemented. No defaults defined.");
    }

    @Override
    public AbstractSimulationConfig getSimulationConfiguration() {
        return eventSimConfig;
    }

    public void setSimulationConfiguration(EventSimConfig eventSimConfig) {
        this.eventSimConfig = eventSimConfig;
    }

}

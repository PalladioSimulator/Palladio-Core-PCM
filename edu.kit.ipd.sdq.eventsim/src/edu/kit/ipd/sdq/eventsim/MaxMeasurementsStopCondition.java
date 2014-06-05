package edu.kit.ipd.sdq.eventsim;

import de.uka.ipd.sdq.simulation.abstractsimengine.SimCondition;

public class MaxMeasurementsStopCondition implements SimCondition {

    private EventSimModel model;
    private long maxMeasurements;

    public MaxMeasurementsStopCondition(final EventSimModel model) {
        this.model = model;
        this.maxMeasurements = model.getConfiguration().getMaxMeasurementsCount();
    }

    @Override
    public boolean check() {
        return (this.maxMeasurements > 0) && (this.model.getMainMeasurementsCount() >= this.maxMeasurements);
    }
    
}

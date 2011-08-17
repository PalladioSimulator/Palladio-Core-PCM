package de.uka.ipd.sdq.simulation;

import de.uka.ipd.sdq.simulation.abstractSimEngine.SimCondition;

public class MaxMeasurementsStopCondition extends SimCondition<EventSimModel> {

    private long maxMeasurements;

    public MaxMeasurementsStopCondition(final EventSimModel model) {
        super(model, "Maximum Measurements Count Stop Condition");
        this.maxMeasurements = model.getConfiguration().getMaxMeasurementsCount();
    }

    @Override
    public boolean check() {
        return (this.maxMeasurements > 0) && (this.getModel().getMainMeasurementsCount() >= this.maxMeasurements);
    }
    
}

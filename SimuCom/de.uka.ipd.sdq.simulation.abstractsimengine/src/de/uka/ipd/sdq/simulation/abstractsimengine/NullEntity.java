package de.uka.ipd.sdq.simulation.abstractsimengine;

public class NullEntity implements IEntity {
    
    @Override
    public boolean isScheduled() {
        throw new RuntimeException("The null entity cannot be scheduled.");
    }

    @Override
    public void reschedule(double delay) {
        throw new RuntimeException("The null entity cannot be scheduled.");
    }

}

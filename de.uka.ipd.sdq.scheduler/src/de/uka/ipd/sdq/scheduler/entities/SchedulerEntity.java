package de.uka.ipd.sdq.scheduler.entities;

import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEntityDelegator;

/**
 * 
 * @author Philipp Merkle
 *
 */
public class SchedulerEntity extends AbstractSimEntityDelegator {

    private SchedulerModel model;
    
    protected SchedulerEntity(SchedulerModel model, String name) {
        super(model, name);
        this.model = model;
    }

    @Override
    public SchedulerModel getModel() {
        return model;
    }

}

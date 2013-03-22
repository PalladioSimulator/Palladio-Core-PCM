package de.uka.ipd.sdq.simucomframework.entities;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEntityDelegator;

/**
 * 
 * @author Philipp Merkle
 *
 */
public class SimuComEntity extends AbstractSimEntityDelegator {

    private SimuComModel model;
    
    protected SimuComEntity(SimuComModel model, String name) {
        super(model, name);
        this.model = model;
    }

    @Override
    public SimuComModel getModel() {
        return this.model;
    }
    
    
}

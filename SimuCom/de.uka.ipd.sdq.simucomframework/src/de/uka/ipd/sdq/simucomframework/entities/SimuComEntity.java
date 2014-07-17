package de.uka.ipd.sdq.simucomframework.entities;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEntityDelegator;

/**
 *
 * @author Philipp Merkle
 *
 */
public abstract class SimuComEntity extends AbstractSimEntityDelegator {

    private final SimuComModel model;

    protected SimuComEntity(final SimuComModel model, final String name) {
        super(model, name);
        this.model = model;
    }

    @Override
    public SimuComModel getModel() {
        return this.model;
    }
}

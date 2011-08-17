package de.uka.ipd.sdq.simulation.abstractsimengine;

/**
 * @author Steffen Becker (this code has been factored out from SimuCom)
 * @author Philipp Merkle
 * 
 * @param <M>
 *            the type of the simulation model
 * @see IEntity
 */
public abstract class AbstractSimEntity<M extends ISimulationModel<M>> extends SimulationElement<M> implements IEntity {

    /**
     * the delegate has the simulation-library-specific knowledge of how entities are handled.
     */
    protected IEntity delegate;

    protected AbstractSimEntity(M model, String name) {
        super(model, name);
        delegate = model.getSimEngineFactory().createEntity(this, name);
    }

    public boolean isScheduled() {
        return delegate.isScheduled();
    }

    public void reschedule(double d) {
        delegate.reschedule(d);
    }

    public IEntity getEncapsulatedEntity() {
        return delegate;
    }

}

package de.uka.ipd.sdq.simulation.abstractsimengine;

/**
 * @author Steffen Becker (this code has been factored out from SimuCom)
 * @author Philipp Merkle
 * 
 * @see IEntity
 */
public abstract class AbstractSimEntityDelegator extends SimulationElement implements IEntity {

    /**
     * the delegate has the simulation-library-specific knowledge of how entities are handled.
     */
    protected IEntity delegate;

    protected AbstractSimEntityDelegator(ISimulationModel model, String name) {
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

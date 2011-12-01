package de.uka.ipd.sdq.simulation.abstractsimengine.ssj;

import umontreal.iro.lecuyer.simevents.Event;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEntityDelegator;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEventDelegator;
import de.uka.ipd.sdq.simulation.abstractsimengine.IEntity;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimEvent;

/**
 * @author Steffen Becker
 * @author Philipp Merkle
 * 
 * @param <E>
 *            the type of the entity which is modified by this event
 */
public class SSJSimEvent<E extends IEntity> extends Event implements ISimEvent<E> {

    private AbstractSimEventDelegator<E> myAbstractEvent;
    private E who;

    public SSJSimEvent(AbstractSimEventDelegator<E> myEvent, String name) {
        super(((SSJExperiment) myEvent.getModel().getSimulationControl()).getSimulator());
        this.myAbstractEvent = myEvent;
    }

    /**
     * The event handler, which is called by SSJ when an event occurred.
     * <p>
     * {@inheritDoc}
     * 
     * @see Event#actions()
     */
    @SuppressWarnings("unchecked")
    @Override
    public void actions() {
        // Check stop conditions when an event happens...
        // TODO: is this really needed!?
        ((SSJExperiment) myAbstractEvent.getModel().getSimulationControl()).checkStopConditions();

        // TODO try to get rid of manual casts
        AbstractSimEntityDelegator abstractEntity = (AbstractSimEntityDelegator) who;
        SSJEntity ssjEntity = (SSJEntity) abstractEntity.getEncapsulatedEntity();
        ssjEntity.isScheduled = false;
        ssjEntity.nextEventForThisEntity = null;
        myAbstractEvent.eventRoutine((E) ssjEntity.getEncapsulatedEntity());
    }

    @SuppressWarnings("unchecked")
    @Override
    public void schedule(E resource, double delay) {
        who = resource;

        // TODO try to get rid of manual casts
        AbstractSimEntityDelegator abstractEntity = (AbstractSimEntityDelegator) who;
        SSJEntity ssjEntity = (SSJEntity) abstractEntity.getEncapsulatedEntity();
        ssjEntity.isScheduled = true;
        ssjEntity.nextEventForThisEntity = this;
        this.schedule(delay);
    }

    @Override
    public void removeEvent() {
        this.cancel();
    }
    
    @Override
    public double scheduledAtTime() {
        // TODO assure this.eventTime == this.time()!
        return this.time();
    }

}
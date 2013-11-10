package de.uka.ipd.sdq.simulation.abstractsimengine.desmoj;

import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEntityDelegator;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEventDelegator;
import de.uka.ipd.sdq.simulation.abstractsimengine.IEntity;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimEvent;
import desmoj.core.simulator.Event;
import desmoj.core.simulator.TimeSpan;

/**
 * @author Steffen Becker
 * @author Philipp Merkle
 */
public class DesmoJSimEvent<E extends IEntity> extends Event<DesmoJEntity> implements
        ISimEvent<E> {

    private final AbstractSimEventDelegator<E> event;

    public DesmoJSimEvent(final AbstractSimEventDelegator<E> event, final DesmoJModel owner, final String name) {
        super(owner, name, false);
        this.event = event;
    }

    /**
     * The event handler, which is called by DESMO-J when an event occurred.
     * <p>
     * {@inheritDoc}
     * 
     * @see Event#eventRoutine(desmoj.core.simulator.Entity)
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eventRoutine(final DesmoJEntity who) {
        // delegate the event handling to the encapsulated event
        this.event.eventRoutine((E) who.getEncapsulatedEntity());
    }

    @Override
    public void schedule(final E entity, final double delay) {
        final AbstractSimEntityDelegator simEntity = (AbstractSimEntityDelegator) entity;
        final DesmoJEntity desmoJEntity = (DesmoJEntity) simEntity.getEncapsulatedEntity();
        this.schedule(desmoJEntity, new TimeSpan(delay));
    }

    @Override
    public void removeEvent() {
        if (this.isScheduled()) {
            this.cancel();
        }
    }

    @Override
    public double scheduledAtTime() {
        return this.scheduledNext().getTimeAsDouble();
    }
    
}

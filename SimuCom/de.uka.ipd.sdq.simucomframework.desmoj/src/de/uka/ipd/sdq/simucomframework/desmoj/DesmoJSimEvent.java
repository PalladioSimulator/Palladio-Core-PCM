package de.uka.ipd.sdq.simucomframework.desmoj;

import de.uka.ipd.sdq.simulation.abstractSimEngine.AbstractSimEntity;
import de.uka.ipd.sdq.simulation.abstractSimEngine.AbstractSimEvent;
import de.uka.ipd.sdq.simulation.abstractSimEngine.IEntity;
import de.uka.ipd.sdq.simulation.abstractSimEngine.ISimEvent;
import de.uka.ipd.sdq.simulation.abstractSimEngine.ISimulationModel;
import desmoj.core.simulator.Event;
import desmoj.core.simulator.TimeSpan;

public class DesmoJSimEvent<M extends ISimulationModel<M>, E extends IEntity> extends Event<DesmoJEntity<M>> implements
        ISimEvent<E> {

    private AbstractSimEvent<M, E> event;

    public DesmoJSimEvent(AbstractSimEvent<M, E> event, DesmoJModel<M> owner, String name) {
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
    public void eventRoutine(DesmoJEntity<M> who) {
        // delegate the event handling to the encapsulated event
        event.eventRoutine((E) who.getEncapsulatedEntity());
    }

    @SuppressWarnings("unchecked")
    @Override
    public void schedule(E entity, double delay) {
        AbstractSimEntity<M> simEntity = (AbstractSimEntity<M>) entity;
        DesmoJEntity<M> desmoJEntity = (DesmoJEntity<M>) simEntity.getEncapsulatedEntity();
        this.schedule(desmoJEntity, new TimeSpan(delay));
    }

    @Override
    public void removeEvent() {
        if (this.isScheduled()) {
            this.cancel();
        }
    }
    
}

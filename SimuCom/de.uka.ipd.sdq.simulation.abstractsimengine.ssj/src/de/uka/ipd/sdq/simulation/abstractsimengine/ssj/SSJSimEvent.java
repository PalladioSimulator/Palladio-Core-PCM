package de.uka.ipd.sdq.simulation.abstractsimengine.ssj;

import umontreal.iro.lecuyer.simevents.Event;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEntity;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEvent;
import de.uka.ipd.sdq.simulation.abstractsimengine.IEntity;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimEvent;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationModel;

/**
 * @author Steffen Becker
 * @author Philipp Merkle
 * 
 * @param <M>
 *            the type of the simulation model
 * @param <E>
 *            the type of the entity which is modified by this event
 */
public class SSJSimEvent<M extends ISimulationModel<M>, E extends IEntity> extends Event implements ISimEvent<E> {

    private AbstractSimEvent<M, E> myAbstractEvent;
    private E who;

    public SSJSimEvent(AbstractSimEvent<M, E> myEvent, String name) {
        super(((SSJExperiment<M>) myEvent.getModel().getSimulationControl()).getSimulator());
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
        ((SSJExperiment<M>) myAbstractEvent.getModel().getSimulationControl()).checkStopConditions();

        // TODO try to get rid of manual casts
        AbstractSimEntity<M> abstractEntity = (AbstractSimEntity<M>) who;
        SSJEntity<M> ssjEntity = (SSJEntity<M>) abstractEntity.getEncapsulatedEntity();
        ssjEntity.isScheduled = false;
        ssjEntity.nextEventForThisEntity = null;
        myAbstractEvent.eventRoutine((E) ssjEntity.getEncapsulatedEntity());
    }

    @SuppressWarnings("unchecked")
    @Override
    public void schedule(E resource, double delay) {
        who = resource;

        // TODO try to get rid of manual casts
        AbstractSimEntity<M> abstractEntity = (AbstractSimEntity<M>) who;
        SSJEntity<M> ssjEntity = (SSJEntity<M>) abstractEntity.getEncapsulatedEntity();
        ssjEntity.isScheduled = true;
        ssjEntity.nextEventForThisEntity = this;
        this.schedule(delay);
    }

    @Override
    public void removeEvent() {
        this.cancel();
    }

}
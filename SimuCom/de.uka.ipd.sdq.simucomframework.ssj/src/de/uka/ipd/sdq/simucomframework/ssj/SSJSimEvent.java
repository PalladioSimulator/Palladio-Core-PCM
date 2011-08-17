package de.uka.ipd.sdq.simucomframework.ssj;

import umontreal.iro.lecuyer.simevents.Event;
import de.uka.ipd.sdq.simulation.abstractSimEngine.AbstractSimEntity;
import de.uka.ipd.sdq.simulation.abstractSimEngine.AbstractSimEvent;
import de.uka.ipd.sdq.simulation.abstractSimEngine.IEntity;
import de.uka.ipd.sdq.simulation.abstractSimEngine.ISimEvent;
import de.uka.ipd.sdq.simulation.abstractSimEngine.ISimulationModel;

public class SSJSimEvent<T extends ISimulationModel<T>, E extends IEntity> extends Event implements ISimEvent<E> {

    private AbstractSimEvent<T, E> myAbstractEvent;
    private E who;

    public SSJSimEvent(AbstractSimEvent<T, E> myEvent, String name) {
        // super(owner, name, false);
        super(((SSJExperiment<T>) myEvent.getModel().getSimulationControl()).getSimulator());
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
        ((SSJExperiment<T>) myAbstractEvent.getModel().getSimulationControl()).checkStopConditions();

        // TODO improve this
        AbstractSimEntity<T> abstractEntity = (AbstractSimEntity<T>)who;
        
        SSJEntity<T> ssjEntity = (SSJEntity<T>)abstractEntity.getEncapsulatedEntity();
        ssjEntity.isScheduled = false;
        ssjEntity.nextEventForThisEntity = null;
        myAbstractEvent.eventRoutine((E)ssjEntity.getEncapsulatedEntity());
    }

    @SuppressWarnings("unchecked")
    @Override
    public void schedule(E resource, double delay) {
        who = resource;
        
        // TODO improve this
        AbstractSimEntity<T> abstractEntity = (AbstractSimEntity<T>)who;
        
        SSJEntity<T> ssjEntity = (SSJEntity<T>)abstractEntity.getEncapsulatedEntity();
        ssjEntity.isScheduled = true;
        ssjEntity.nextEventForThisEntity = this;
        this.schedule(delay);
    }

    @Override
    public void removeEvent() {
        this.cancel();
    }
}
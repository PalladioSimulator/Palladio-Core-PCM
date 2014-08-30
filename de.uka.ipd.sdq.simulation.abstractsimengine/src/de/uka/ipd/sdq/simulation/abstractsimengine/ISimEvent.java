package de.uka.ipd.sdq.simulation.abstractsimengine;

/**
 * A simulated event, which can be scheduled to occur at a specific point in time in the simulated
 * future. When reaching the specified simulated time instant, the <code>eventRoutine</code> method
 * is being executed. In this way, this class supports the so-called event-scheduling simulation
 * modelling.
 * <p>
 * No simulated time may pass in the <code>eventRoutine</code>. In order to still be able to realise
 * an advance in simulation time, the <code>eventRoutine</code> may schedule one or more other
 * events to occur in the future.
 * 
 * @author Steffen Becker (this code has been factored out from SimuCom)
 * @author Philipp Merkle
 * 
 * @param <E>
 *            the type of the entity which is modified by this event
 */
public interface ISimEvent<E extends IEntity> {

    /**
     * Schedules this event to occur in <code>delay</code> simulated time units.
     * 
     * @param entity
     *            the entity which is associated with this event; null, if the event is not related
     *            to a certain entity.
     * @param delay
     *            the period of simulated time to wait before this event is executed.
     */
    public void schedule(E entity, double delay);

    /**
     * Removes this event from the list of future events.
     */
    public void removeEvent();

    public double scheduledAtTime();

}
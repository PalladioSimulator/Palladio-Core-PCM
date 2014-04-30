package edu.kit.ipd.sdq.eventsim.entities;

/**
 * Implement this listener to get notified when a certain entity is about to enter or has left the
 * system. This listener can be registered with an {@link EventSimEntity}.
 * 
 * @author Philipp Merkle
 * 
 */
public interface IEntityListener {

    /**
     * The entity has entered the system and is about to process its workload.
     */
    public void enteredSystem();

    /**
     * The entity has finished its workload and has left the system.
     */
    public void leftSystem();

}

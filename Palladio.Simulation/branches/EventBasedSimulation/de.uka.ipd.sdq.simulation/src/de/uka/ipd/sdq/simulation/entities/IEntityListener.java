package de.uka.ipd.sdq.simulation.entities;

public interface IEntityListener {

    /**
     * The user has entered the system and is about to process its workload.
     */
    public void enteredSystem();

    /**
     * The user has finished its workload and is about to leave the system.
     */
    public void leftSystem();

}

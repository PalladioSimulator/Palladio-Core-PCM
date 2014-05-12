package edu.kit.ipd.sdq.eventsim.entities.scheduler;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;

/**
 * A process listener observes a {@link SimulatedProcess} for being activated or passivated.
 * 
 * @author Philipp Merkle
 * 
 * @see SimulatedProcess
 */
public interface IProcessListener {

    /**
     * Called when the SimulatedProcess has been activated.
     * 
     * @see ISchedulableProcess#activate()
     */
    public void activated();

    /**
     * Called when the SimulatedProcess has been passivated.
     * 
     * @see ISchedulableProcess#passivate()
     */
    public void passivated();

}

package edu.kit.ipd.sdq.eventsim.resources.listener;

import edu.kit.ipd.sdq.eventsim.entities.scheduler.SimulatedProcess;
import edu.kit.ipd.sdq.eventsim.resources.entities.SimPassiveResource;

/**
 * This listener observes a {@link SimPassiveResource}. It is being notified whenever a
 * {@link SimulatedProcess} requests an arbitrary number of instances of the observed resource, when
 * instances are granted to the requesting process (i.e., the process "acquires" the resource), or
 * when the process releases instances of the resource.
 * <p>
 * Thus, the methods of this listener are invoked in a fixed order as follows.
 * <ol>
 * <li>{@code request}
 * <li>{@code acquire}
 * <li>{@code release}
 * </ol>
 * 
 * @author Philipp Merkle
 * 
 */
public interface IPassiveResourceListener {

    /**
     * The given process has requested {@code num} instances of the passive resource but not yet
     * acquired them.
     */
    public void request(SimulatedProcess process, int num);

    /**
     * The given process has successfully acquired {@code num} instances of the passive resource.
     */
    public void acquire(SimulatedProcess process, int num);

    /**
     * The given process has released {@code num} instances of the passive resource.
     */
    public void release(SimulatedProcess process, int num);

}

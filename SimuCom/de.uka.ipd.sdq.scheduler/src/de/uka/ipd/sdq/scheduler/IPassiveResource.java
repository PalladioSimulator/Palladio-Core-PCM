package de.uka.ipd.sdq.scheduler;

import java.util.Queue;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.scheduler.processes.IWaitingProcess;
import de.uka.ipd.sdq.scheduler.sensors.IPassiveResourceSensor;

/**
 * A passive can be hold by a process for some time. As the number of available instances is limited
 * the process might has to wait until it gets the requested number of instances.
 * 
 * @author jens
 * 
 */
public interface IPassiveResource {

    /**
     * Acquires num instances of the passive resource for the given process. The process is blocked
     * until it successfully receives the requested number of resource instances.
     * 
     * @return True, if the acquisition was successful, otherwise false.
     */
    public abstract boolean acquire(ISchedulableProcess process, long num, boolean timeout, double timeoutValue);

    /**
     * Releases num instances of the passive resource from the given process.
     */
    public abstract void release(ISchedulableProcess process, long num);

    /**
     * Getter for the model element of the passive resource.
     * 
     * @return The passive resource model element.
     */
    public PassiveResource getResource();

    /**
     * Getter for the model element of the assembly context.
     * 
     * @return The assembly context of the passive resource.
     */
    public AssemblyContext getAssemblyContext();

    /**
     * Name of the resource.
     * 
     * @return
     */
    public String getName();

    /**
     * Unique identifier of the resource.
     * 
     * @return
     */
    public String getId();

    /**
     * Returns the maximal number of instances that can be acquired at the same time.
     */
    public long getCapacity();

    /**
     * Returns the number of remaining instances.
     */
    public long getAvailable();

    /**
     * Adds the given observer. Observers get notified when a process acquired or released this
     * resource.
     */
    public void addObserver(IPassiveResourceSensor observer);

    /**
     * Removes the given observer
     */
    public void removeObserver(IPassiveResourceSensor observer);

    /**
     * Returns a queue containing the waiting processes for the passive resource.
     */
    public Queue<IWaitingProcess> getWaitingProcesses();

}

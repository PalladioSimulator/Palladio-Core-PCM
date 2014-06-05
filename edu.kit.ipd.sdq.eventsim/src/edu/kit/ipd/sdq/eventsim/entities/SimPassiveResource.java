package edu.kit.ipd.sdq.eventsim.entities;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.scheduler.IPassiveResource;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.sensors.IPassiveResourceSensor;
import edu.kit.ipd.sdq.eventsim.EventSimModel;
import edu.kit.ipd.sdq.eventsim.entities.scheduler.SimulatedProcess;
import edu.kit.ipd.sdq.eventsim.resources.listener.IPassiveResourceListener;

/**
 * A passive resource is a resource that can be acquired by a simulated process, then be hold for a
 * certain amount of time and is finally released by the process. It has a limited capacity which
 * decreases whenever a process acquires the resource. Conversely, the available capacity increases
 * when a process releases the resource.
 * <p>
 * If a process tries to acquire a resource with no free capacity, the resource gets passivated
 * until the passive resource can serve the acquisition.
 * 
 * @author Philipp Merkle
 * 
 * @see IPassiveResource
 * 
 */
public class SimPassiveResource extends EventSimEntity {

    /** the encapsulated scheduler resource */
    private IPassiveResource schedulerResource;

    private List<IPassiveResourceListener> listeners;

    /**
     * Construct a passive resource that wraps the specified resource.
     * 
     * @param model
     *            the simulation model
     * @param resource
     *            the wrapped scheduler resource
     */
    public SimPassiveResource(EventSimModel model, IPassiveResource resource) {
        super(model, "SimPassiveResource");
        this.schedulerResource = resource;
        this.listeners = new ArrayList<IPassiveResourceListener>();
        
        this.setupListenerAdapter(this.schedulerResource);
    }

    /**
     * Acquires the specified number of instances for the given process. If not enough instances are
     * available, the process is passivated until the instances become available.
     * 
     * @see IPassiveResource#acquire(de.uka.ipd.sdq.scheduler.ISchedulableProcess, int)
     */
    public boolean acquire(SimulatedProcess process, int num, boolean timeout, double timeoutValue) {
        return schedulerResource.acquire(process, num, timeout, timeoutValue);
    }

    /**
     * Releases the specified number of instances.
     * 
     * @see IPassiveResource#release(de.uka.ipd.sdq.scheduler.ISchedulableProcess, int)
     */
    public void release(SimulatedProcess process, int num) {
        schedulerResource.release(process, num);
    }

    /**
     * Returns the number of remaining instances.
     */
    public int getAvailable() {
        return schedulerResource.getAvailable();
    }

    /**
     * Returns the maximal number of instances that can be hold at the same time.
     */
    public int getCapacity() {
        return schedulerResource.getCapacity();
    }

    /**
     * Returns the unique identifier of this resource.
     * 
     * @return the unique identifier
     */
    public String getResourceId() {
        return schedulerResource.getId();
    }

    /**
     * Returns the name of this resouce
     * 
     * @return the resource's name
     */
    public String getResourceName() {
        return schedulerResource.getName();
    }

    public void addListener(final IPassiveResourceListener l) {
        this.listeners.add(l);
    }
    
    public void removeListener(final IPassiveResourceListener l) {
        this.listeners.remove(l);
    }

    protected void fireRequest(SimulatedProcess process, int num) {
        for (IPassiveResourceListener l : listeners) {
            l.request(process, num);
        }
    }

    protected void fireAcquire(SimulatedProcess process, int num) {
        for (IPassiveResourceListener l : listeners) {
            l.acquire(process, num);
        }
    }

    protected void fireRelease(SimulatedProcess process, int num) {
        for (IPassiveResourceListener l : listeners) {
            l.release(process, num);
        }
    }

    /**
     * Translates the {@link IPassiveResourceSensor} listener to the
     * {@link IPassiveResourceListener}. As a result, all {@link IPassiveResourceListener}s of this
     * resource gets notified if the encapsulated scheduler resource fires an
     * {@link IPassiveResourceSensor} event.
     */
    private void setupListenerAdapter(IPassiveResource resource) {
        resource.addObserver(new IPassiveResourceSensor() {

            @Override
            public void request(ISchedulableProcess process, int num) {
                SimPassiveResource.this.fireRequest((SimulatedProcess) process, num);
            }

            @Override
            public void release(ISchedulableProcess process, int num) {
                SimPassiveResource.this.fireRelease((SimulatedProcess) process, num);
            }

            @Override
            public void acquire(ISchedulableProcess process, int num) {
                SimPassiveResource.this.fireAcquire((SimulatedProcess) process, num);
            }

        });
    }
}

package de.uka.ipd.sdq.simulation.resources;

import de.uka.ipd.sdq.scheduler.IPassiveResource;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;

public class SimulatedPassiveResource {

    private IPassiveResource schedulerResource;

    public SimulatedPassiveResource(IPassiveResource resource) {
        this.schedulerResource = resource;
    }
    
    public boolean acquire(ISchedulableProcess process, int num) {
        return schedulerResource.acquire(process, num);
    }
    
    public void release(ISchedulableProcess process, int num) {
        schedulerResource.release(process, num);
    }
    
    public int getAvailable() {
        return schedulerResource.getAvailable();
    }

    public int getCapacity() {
        return schedulerResource.getCapacity();
    }

    public String getId() {
        return schedulerResource.getId();
    }

    public String getName() {
        return schedulerResource.getName();
    }
    
}

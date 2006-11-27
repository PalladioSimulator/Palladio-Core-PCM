package de.uka.ipd.sdq.qnm.simulator.resources;

import java.util.ArrayList;
import java.util.List;

import desmoj.core.simulator.Model;
import desmoj.core.simulator.ProcessQueue;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;

public class SimulatedPassiveResource extends SimProcess {
	
	protected ProcessQueue waitingTasks;
	
	protected ProcessQueue waitingSemaphores;
	
	protected List<SimulatedPassiveResourceReplica> childResources;
	
	public SimulatedPassiveResource(Model owner, String name,
			boolean showInTrace, ProcessQueue taskQueue,
			ProcessQueue semaphoreQueue) {
		super(owner, name, showInTrace);
		this.waitingTasks = taskQueue;
		this.waitingSemaphores = semaphoreQueue;
		this.childResources = new ArrayList<SimulatedPassiveResourceReplica>();
	}

	@Override
	public void lifeCycle() {
		while (true)
		{
			if (waitingSemaphores.isEmpty()) {
				passivate();
			} else {
				SimProcess waitingSemaphore = waitingSemaphores.first();
				waitingSemaphores.remove(waitingSemaphore);
				waitingSemaphore.activateAfter(this);
				passivate();
			}
		}
	}

	public void unlock(SimProcess lockingProcess){
		for(SimulatedPassiveResourceReplica sprr : childResources){
			if (sprr.getLockedBy() == lockingProcess){
				sprr.setLockedBy(null);
				System.out.println("Unlocked "+sprr.getName());
				sprr.activate(new SimTime(SimTime.NOW));
			}
		}
	}
	
	
	public ProcessQueue getWaitingTasks() {
		return waitingTasks;
	}

	public void setWaitingTasks(ProcessQueue waitingTasks) {
		this.waitingTasks = waitingTasks;
	}

	public ProcessQueue getWaitingSemaphores() {
		return waitingSemaphores;
	}

	public void setWaitingSemaphores(ProcessQueue waitingSemaphores) {
		this.waitingSemaphores = waitingSemaphores;
	}

	public void addChildResource(SimulatedPassiveResourceReplica childResource){
		childResources.add(childResource);
	}
	
	public List<SimulatedPassiveResourceReplica> getChildResources() {
		return childResources;
	}

	public void setChildResources(
			List<SimulatedPassiveResourceReplica> childResources) {
		this.childResources = childResources;
	}

}

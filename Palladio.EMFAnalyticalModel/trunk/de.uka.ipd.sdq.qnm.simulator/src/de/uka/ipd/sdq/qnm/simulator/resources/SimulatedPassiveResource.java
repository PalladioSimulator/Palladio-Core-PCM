package de.uka.ipd.sdq.qnm.simulator.resources;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.qnm.simulator.SimuQNModel;
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
		
		SimuQNModel model = (SimuQNModel)owner;
		if (!model.getSensorFactory().hasHistogram("Used "+getName()))
			model.getSensorFactory().createHistogramSensor("Used "+getName());

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
		double blockedCounter=0;
		for(SimulatedPassiveResourceReplica sprr : childResources){
			if(sprr.getLockedBy() != null){
				blockedCounter++;
			}
			
			if (sprr.getLockedBy() == lockingProcess){
				sprr.setLockedBy(null);
				//System.out.println("Unlocked "+sprr.getName());
				sprr.activate(new SimTime(SimTime.NOW));
			}
		}
		
		String histogramID = "Used " + getName();
		SimuQNModel qnModel = (SimuQNModel)this.currentModel();
		qnModel.getSensorFactory().getValueSupplierForSensor(histogramID)
		.newResponseTimeMeasurement(blockedCounter);
		
		
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

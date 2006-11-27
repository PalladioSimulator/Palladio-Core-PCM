package de.uka.ipd.sdq.qnm.simulator.resources;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.qnm.simulator.tasks.SimulatedResourceUsage;
import de.uka.ipd.sdq.qnm.simulator.tasks.SimulatedTask;
import desmoj.core.simulator.Model;
import desmoj.core.simulator.ProcessQueue;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;

public class SimulatedProcessingResource extends SimProcess {

	protected ProcessQueue waitingTasks;
	
	protected ProcessQueue waitingProcessingResources;
	
	protected List<SimulatedProcessingResourceReplica> childResources; 
	
	public SimulatedProcessingResource(Model owner, String name, boolean showInTrace) {
		super(owner, name, showInTrace);
	}

	public SimulatedProcessingResource(Model owner, String name,
			boolean showInTrace, ProcessQueue taskQueue,
			ProcessQueue processorQueue) {
		super(owner, name, showInTrace);
		this.waitingTasks = taskQueue;
		this.waitingProcessingResources = processorQueue;
		this.childResources = new ArrayList<SimulatedProcessingResourceReplica>();
	}
	
	@Override
	public void lifeCycle() {
		while (true){
			if (!waitingProcessingResources.isEmpty()){
				// yes, some processing resources are waiting in the queue
				SimProcess waitingProcess = waitingProcessingResources.first();
				waitingProcessingResources.remove(waitingProcess);
				waitingProcess.activateAfter(this);
				passivate();
			} else {
				// no one waiting in queue, all processing resources busy -> wait
				passivate();
			}
		}
	}

	public ProcessQueue getWaitingTasks() {
		return waitingTasks;
	}

	public void setWaitingTasks(ProcessQueue waitingTasks) {
		this.waitingTasks = waitingTasks;
	}

	public ProcessQueue getWaitingProcessingResources() {
		return waitingProcessingResources;
	}

	public void setWaitingProcessingResources(ProcessQueue waitingProcesses) {
		this.waitingProcessingResources = waitingProcesses;
	}

	public List<SimulatedProcessingResourceReplica> getChildResources() {
		return childResources;
	}

	public void addChildResource(SimulatedProcessingResourceReplica childResource){
		childResources.add(childResource);
	}
	
	public void setChildResources(
			List<SimulatedProcessingResourceReplica> childResources) {
		this.childResources = childResources;
	}

}

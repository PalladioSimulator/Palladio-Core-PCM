package de.uka.ipd.sdq.scheduler.resources.active;

import java.util.Hashtable;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.LoggingWrapper;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.scheduler.entities.SchedulerEntity;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEventDelegator;

public class SimDelayResource extends AbstractActiveResource {

	// Contains all running processes on the resource (key: process ID)
	private final Hashtable<String,ISchedulableProcess> running_processes = new Hashtable<String, ISchedulableProcess>();
	
	public SimDelayResource(SchedulerModel model, String name, String id) {
		super(model, -1l, name, id);
	}


	@Override
	public void start() {
		running_processes.clear();
	}
	
	private class DelayEvent extends AbstractSimEventDelegator<ISchedulableProcess> {

		public DelayEvent(SchedulerModel model) {
			super(model, "DelayEvent");
		}

		@Override
		public void eventRoutine(ISchedulableProcess process) {
			dequeue(process);
		}

	}

	@Override
	protected void dequeue(ISchedulableProcess process) {
		if (!running_processes.containsKey(process.getId())) {
			return;
		}
		running_processes.remove(process.getId());
		fireStateChange((long) running_processes.size(), 0);
		fireDemandCompleted(process);
		process.activate();
	}

	@Override
	protected void doProcessing(ISchedulableProcess process, int resourceServiceId, double demand) {
		LoggingWrapper.log("Delay: " + process + " demands " + demand);
		if (!running_processes.containsKey(process.getId())) {
			enqueue(process);
		}
		new DelayEvent(getModel()).schedule(process, demand);
		process.passivate();
	}
	
	@Override
	public double getRemainingDemand(ISchedulableProcess process) {
		throw new UnsupportedOperationException("getRemainingDemand() not yet supported!");
	}
	
	@Override
	public void updateDemand(ISchedulableProcess process, double demand) {
		throw new UnsupportedOperationException("updateDemand() not yet supported!");
	}
	
	@Override
	protected void enqueue(ISchedulableProcess process) {
		running_processes.put(process.getId(), process);
		fireStateChange((long) running_processes.size(), 0);
	}


	@Override
	public void stop() {
		running_processes.clear();
	}

	@Override
	public void registerProcess(ISchedulableProcess process) {
		
	}
	

	@Override
	public int getQueueLengthFor(SchedulerEntity schedulerEntity) {
		return running_processes.size();
	}


}

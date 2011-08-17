package de.uka.ipd.sdq.scheduler.resources.active;

import de.uka.ipd.sdq.scheduler.IRunningProcess;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.LoggingWrapper;
import de.uka.ipd.sdq.scheduler.events.DelayEvent;

public class SimDelayResource extends AbstractActiveResource {

	int num_running;
	
	public SimDelayResource(String name, String id) {
		super(-1, name, id);
	}


	public void start() {
		this.num_running = 0;
	}

	@Override
	protected void dequeue(ISchedulableProcess process) {
		this.num_running--;
		fireStateChange(num_running, 0);
	}

	@Override
	protected void doProcessing(ISchedulableProcess process, int resourceServiceId, double demand) {
		LoggingWrapper.log("Delay: " + process + " demands " + demand);
		new DelayEvent(process).schedule(demand);
		process.passivate();
	}

	@Override
	protected void enqueue(ISchedulableProcess process) {
		this.num_running++;
		fireStateChange(num_running, 0);
	}


	public void stop() {
		
	}

	public void registerProcess(IRunningProcess runningProcess) {
		
	}
	

	public int getQueueLengthFor(SimResourceInstance simResourceInstance) {
		return this.num_running;
	}


}

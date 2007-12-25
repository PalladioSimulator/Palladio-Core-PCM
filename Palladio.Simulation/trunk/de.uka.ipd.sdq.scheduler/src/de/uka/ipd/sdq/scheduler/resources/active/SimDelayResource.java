package de.uka.ipd.sdq.scheduler.resources.active;

import de.uka.ipd.sdq.scheduler.IRunningProcess;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.LoggingWrapper;
import de.uka.ipd.sdq.scheduler.events.DelayEvent;

public class SimDelayResource extends AbstractActiveResource {

	public SimDelayResource(String name, String id) {
		super(-1, name, id);
	}


	public void start() {
	}

	protected void dequeue(ISchedulableProcess process) {
	}

	protected void doProcessing(ISchedulableProcess process, double demand) {
		LoggingWrapper.log(process + " sleeps for " + demand);
		new DelayEvent(process).schedule(demand);
		process.passivate();
	}

	protected void enqueue(ISchedulableProcess process) {
	}


	public void stop() {
		
	}

	public void registerProcess(IRunningProcess runningProcess) {
		// TODO Auto-generated method stub
		
	}


}

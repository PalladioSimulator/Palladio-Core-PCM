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

	@Override
	protected void dequeue(ISchedulableProcess process) {
	}

	@Override
	protected void doProcessing(ISchedulableProcess process, double demand) {
		LoggingWrapper.log("Delay: " + process + " demands " + demand);
		new DelayEvent(process).schedule(demand);
		process.passivate();
	}

	@Override
	protected void enqueue(ISchedulableProcess process) {
	}


	public void stop() {
		
	}

	public void registerProcess(IRunningProcess runningProcess) {
		
	}


}

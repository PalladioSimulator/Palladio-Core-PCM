package de.uka.ipd.sdq.scheduler.resources.active;

import de.uka.ipd.sdq.scheduler.IRunningProcess;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.LoggingWrapper;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.scheduler.entities.SchedulerEntity;
import de.uka.ipd.sdq.scheduler.events.DelayEvent;

public class SimDelayResource extends AbstractActiveResource {

	int num_running;
	
	public SimDelayResource(SchedulerModel model, String name, String id) {
		super(model, -1, name, id);
	}


	public void start() {
		this.num_running = 0;
	}

	@Override
	protected void dequeue(ISchedulableProcess process) {
		this.num_running--;
		fireStateChange(num_running, 0);
		fireDemandCompleted(process);
	}

	@Override
	protected void doProcessing(ISchedulableProcess process, int resourceServiceId, double demand) {
		LoggingWrapper.log("Delay: " + process + " demands " + demand);
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
		this.num_running++;
		fireStateChange(num_running, 0);
	}


	public void stop() {
		
	}

	public void registerProcess(ISchedulableProcess process) {
		
	}
	

	public int getQueueLengthFor(SchedulerEntity schedulerEntity) {
		return this.num_running;
	}


}

package de.uka.ipd.sdq.scheduler.processes;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.scheduler.entities.SchedulerEntity;

public class SimpleWaitingProcess extends SchedulerEntity implements IWaitingProcess {

	private ISchedulableProcess sched_process;
	private int num_requested;

	public SimpleWaitingProcess(SchedulerModel model, ISchedulableProcess sched_process, int num_requested) {
		super(model, "SimpleWaitingProcess");
		this.sched_process = sched_process;
		this.num_requested = num_requested;
	}

	public ISchedulableProcess getProcess() {
		return sched_process;
	}

	public int getNumRequested() {
		return num_requested;
	}
}

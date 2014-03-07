package de.uka.ipd.sdq.scheduler.processes;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.scheduler.entities.SchedulerEntity;

public class SimpleWaitingProcess extends SchedulerEntity implements IWaitingProcess {

	private final ISchedulableProcess sched_process;
	private final long num_requested;

	public SimpleWaitingProcess(SchedulerModel model, ISchedulableProcess sched_process, long num_requested) {
		super(model, "SimpleWaitingProcess");
		this.sched_process = sched_process;
		this.num_requested = num_requested;
	}

	@Override
	public ISchedulableProcess getProcess() {
		return sched_process;
	}

	@Override
	public long getNumRequested() {
		return num_requested;
	}
}

package de.uka.ipd.sdq.simucomframework.resources;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEntity;

public class SimpleWaitingProcess extends AbstractSimEntity<SimuComModel> {

	private ISchedulableProcess sched_process;
	private int num_requested;

	public SimpleWaitingProcess(SimuComModel model, ISchedulableProcess sched_process, int num_requested) {
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

package de.uka.ipd.sdq.simucomframework.resources;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEntity;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationModel;

public class SimpleWaitingProcess<M extends ISimulationModel<M>> extends AbstractSimEntity<M> {

	private ISchedulableProcess sched_process;
	private int num_requested;

	public SimpleWaitingProcess(M model, ISchedulableProcess sched_process, int num_requested) {
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

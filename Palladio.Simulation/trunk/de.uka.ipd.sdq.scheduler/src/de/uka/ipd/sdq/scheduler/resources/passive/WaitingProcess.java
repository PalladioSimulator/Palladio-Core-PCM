package de.uka.ipd.sdq.scheduler.resources.passive;

import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;

public class WaitingProcess {

	private ActiveProcess process;
	private int num_requested;

	public WaitingProcess(ActiveProcess process, int num_requested) {
		super();
		this.process = process;
		this.num_requested = num_requested;
	}

	public ActiveProcess getProcess() {
		return process;
	}

	public int getNumRequested() {
		return num_requested;
	}
}

package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.resources.passive;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.processes.IWaitingProcess;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.IActiveProcess;

public class WaitingProcess implements IWaitingProcess {

	private IActiveProcess process;
	private int num_requested;

	public WaitingProcess(IActiveProcess process, int num_requested) {
		super();
		this.process = process;
		this.num_requested = num_requested;
	}

	public IActiveProcess getActiveProcess() {
		return process;
	}

	public int getNumRequested() {
		return num_requested;
	}
	
	public ISchedulableProcess getProcess() {
		return process.getSchedulableProcess();
	}
}

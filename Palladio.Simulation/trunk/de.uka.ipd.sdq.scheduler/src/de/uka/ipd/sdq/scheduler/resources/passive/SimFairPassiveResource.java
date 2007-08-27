package de.uka.ipd.sdq.scheduler.resources.passive;

import de.uka.ipd.sdq.scheduler.processes.impl.ActiveProcess;

public class SimFairPassiveResource extends SimPassiveResource {

	public SimFairPassiveResource(int capacity, String name, String id) {
		super(capacity, name, id);
	}

	protected void notifyWaitingProcesses() {
		WaitingProcess waitingProcess = waitingQueue.peek();
		if (waitingProcess != null){
			tryToDequeueProcess(waitingProcess);
		}
	}

	protected boolean canProceed(ActiveProcess process, int num) {
		return waitingQueue.isEmpty() && num <= capacity;
	}
}

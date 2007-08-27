package de.uka.ipd.sdq.scheduler.resources.passive;

import de.uka.ipd.sdq.scheduler.IRunningProcess;

public class SimFairPassiveResource extends SimAbstractPassiveResource {

	public SimFairPassiveResource(int capacity, String name, String id) {
		super(capacity, name, id);
	}

	protected void notifyWaitingProcesses() {
		WaitingProcess waitingProcess = waitingQueue.peek();
		if (waitingProcess != null){
			tryToDequeueProcess(waitingProcess);
		}
	}

	protected boolean canProceed(IRunningProcess process, int num) {
		return waitingQueue.isEmpty() && num <= capacity;
	}
}

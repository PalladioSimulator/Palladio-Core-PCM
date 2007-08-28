package de.uka.ipd.sdq.scheduler.resources.passive;

import de.uka.ipd.sdq.scheduler.IRunningProcess;
import de.uka.ipd.sdq.scheduler.priority.IPriorityBoost;
import de.uka.ipd.sdq.scheduler.resources.active.SimActiveResource;

public class SimFairPassiveResource extends SimAbstractPassiveResource {

	public SimFairPassiveResource(int capacity, String name, String id,
			IPriorityBoost priority_boost, SimActiveResource managing_resource) {
		super(capacity, name, id, priority_boost, managing_resource);
	}

	protected void notifyWaitingProcesses() {
		WaitingProcess waitingProcess = waiting_queue.peek();
		if (waitingProcess != null){
			tryToDequeueProcess(waitingProcess);
		}
	}

	protected boolean canProceed(IRunningProcess process, int num) {
		return waiting_queue.isEmpty() && num <= capacity;
	}
}

package de.uka.ipd.sdq.scheduler.resources.passive;

import de.uka.ipd.sdq.scheduler.IRunningProcess;
import de.uka.ipd.sdq.scheduler.events.IDelayedAction;
import de.uka.ipd.sdq.scheduler.priority.IPriorityBoost;
import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.active.SimActiveResource;

public class SimUnfairPassiveResource extends SimAbstractPassiveResource {

	private double acquisition_demand;

	public SimUnfairPassiveResource(int capacity, String name, String id,
			IPriorityBoost priority_boost, SimActiveResource managing_resource,
			double acquisition_demand) {
		super(capacity, name, id, priority_boost, managing_resource);
		this.acquisition_demand = acquisition_demand;
	}

	@Override
	protected boolean canProceed(IRunningProcess process, int num) {
		return num <= capacity;
	}

	@Override
	protected void notifyWaitingProcesses() {
		WaitingProcess waiting_process = waiting_queue.peek();
		if (waiting_process != null){
			IActiveProcess process = waiting_process.getProcess();
			process.setCurrentDemand(acquisition_demand);
			process.setDelayedAction(new UnfairAccessAction(waiting_process));
			fromWaitingToReady(waiting_process);
		}
	}
	
	private class UnfairAccessAction implements IDelayedAction {
		private WaitingProcess waiting_process;

		public UnfairAccessAction(WaitingProcess waiting_process) {
			super();
			this.waiting_process = waiting_process;
		}

		@Override
		public boolean perform() {
			if ( !tryToDequeueProcess(waiting_process) ){
				fromRunningToWaiting(waiting_process, true);
				return false;
			}
			return true;
		}
	}
}

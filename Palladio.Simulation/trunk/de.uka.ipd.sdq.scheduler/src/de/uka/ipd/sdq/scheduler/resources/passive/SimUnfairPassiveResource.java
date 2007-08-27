package de.uka.ipd.sdq.scheduler.resources.passive;

import de.uka.ipd.sdq.scheduler.processes.impl.ActiveProcess;

public class SimUnfairPassiveResource extends SimPassiveResource {

	private double acquisition_demand;

	public SimUnfairPassiveResource(int capacity, String name, String id, double acquisition_demand) {
		super(capacity, name, id);
		this.acquisition_demand = acquisition_demand;
	}

	@Override
	protected boolean canProceed(ActiveProcess process, int num) {
		return num <= capacity;
	}

	@Override
	protected void notifyWaitingProcesses() {
		WaitingProcess waiting_process = waitingQueue.peek();
		if (waiting_process != null){
			ActiveProcess process = waiting_process.getProcess();
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

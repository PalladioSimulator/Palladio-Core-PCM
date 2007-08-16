package de.uka.ipd.sdq.scheduler.resources.waiting;

import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;


public class UnfairWaiting extends AbstractWaitingPolicy {

	@Override
	public boolean canProceed(ActiveProcess currentProcess) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void notifyWaiting() {
		// TODO Auto-generated method stub
		
	}

}

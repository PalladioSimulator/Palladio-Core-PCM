package de.uka.ipd.sdq.simucomframework.fork;

import desmoj.core.simulator.SimProcess;

public class ForkExecutor {
	private ForkedBehaviourProcess[] forks;
	private SimProcess parent;

	public ForkExecutor(SimProcess parent, ForkedBehaviourProcess[] forks) {
		this.forks = forks;
		this.parent = parent;
	}
	
	public void run() {
		System.out.println("Running parallel operations");
		for(ForkedBehaviourProcess p : forks) 
			p.activateAfter(this.parent);
		while(checkIfRemainingChildrenRun())
			parent.passivate();
		System.out.println("Time: "+parent.getModel().currentTime());
	}

	private boolean checkIfRemainingChildrenRun() {
		for(ForkedBehaviourProcess p : forks) 
			if (!p.isTerminated())
				return true;
		return false;
	}
}

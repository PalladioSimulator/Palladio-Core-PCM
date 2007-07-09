package de.uka.ipd.sdq.simucomframework.fork;

import org.apache.log4j.Logger;

import desmoj.core.simulator.SimProcess;

public class ForkExecutor {
	private ForkedBehaviourProcess[] forks;
	private SimProcess parent;
	private static Logger logger = 
		Logger.getLogger(ForkExecutor.class.getName());

	public ForkExecutor(SimProcess parent, ForkedBehaviourProcess[] forks) {
		this.forks = forks;
		this.parent = parent;
	}
	
	public void run() {
		logger.info("Running parallel operations");
		double start = parent.getModel().currentTime().getTimeValue();
		for(ForkedBehaviourProcess p : forks) 
			p.activateAfter(this.parent);
		while(checkIfRemainingChildrenRun())
			parent.passivate();
		logger.debug("Forks took: "+(parent.getModel().currentTime().getTimeValue()-start));
	}

	private boolean checkIfRemainingChildrenRun() {
		for(ForkedBehaviourProcess p : forks) 
			if (!p.isTerminated())
				return true;
		return false;
	}
}

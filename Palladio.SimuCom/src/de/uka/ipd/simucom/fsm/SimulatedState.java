package de.uka.ipd.simucom.fsm;

import de.uka.ipd.simucom.threads.IThreadActionVisitor;
import de.uka.ipd.simucom.threads.VisitableByThread;
import desmoj.core.dist.RealDistExponential;
import desmoj.core.simulator.Model;

public class SimulatedState 
implements VisitableByThread {
	protected String ID = "<not set>";
	protected RealDistExponential delayDistribution = null;
	
	public SimulatedState(String ID, Model m) {
		delayDistribution = new RealDistExponential(m,"Delay",2,true,true);
		this.ID = ID;
	}

	public void accept(IThreadActionVisitor t) {
		// t.visitSimulatedState(this);
	}
	
	public double getNextDelay() {
		return delayDistribution.sample();
	}
	
	@Override
	public String toString() {
		return "State >"+ID+"<";
	}	
}

/**
 * 
 */
package de.uka.ipd.sdq.capra.simulator.resources;

import de.uka.ipd.sdq.capra.simulator.expressions.SimCapraProcess;
import de.uka.ipd.sdq.probfunction.math.util.MathTools;

public class Job {
	protected SimCapraProcess capraProcess;
	protected double remainingDemand;
	protected double remainingTime;
	
	public Job(SimCapraProcess capraProcess, double demand) {
		super();
		this.capraProcess = capraProcess;
		this.remainingDemand = demand;
		this.remainingTime = -1;
	}
	
	public SimCapraProcess getProcess() {
		return capraProcess;
	}

	public void setProcess(SimCapraProcess process) {
		this.capraProcess = process;
	}

	public double getRemainingDemand() {
		return remainingDemand;
	}

	public void setRemainingDemand(double demand) {
		this.remainingDemand = demand;
	}

	public double getRemainingTime() {
		return remainingTime;
	}

	public void setRemainingTime(double timeToFinish) {
		this.remainingTime = timeToFinish;
	}

	public void subtractFromDemand(double time) {
		remainingDemand -= time;
		if (remainingDemand < 0)
			remainingDemand = 0;
	}
}
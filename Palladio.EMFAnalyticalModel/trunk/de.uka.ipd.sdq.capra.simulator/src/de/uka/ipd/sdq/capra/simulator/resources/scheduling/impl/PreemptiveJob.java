/**
 * 
 */
package de.uka.ipd.sdq.capra.simulator.resources.scheduling.impl;

import de.uka.ipd.sdq.capra.simulator.resources.scheduling.IScheduledJob;
import de.uka.ipd.sdq.probfunction.math.util.MathTools;


public class PreemptiveJob implements IScheduledJob {
	
	protected PreemptiveProcess process;
	
	protected double remainingDemand;
	
	protected double timeToFinish;
		
	public PreemptiveJob(PreemptiveProcess process, double demand) {
		super();
		this.process = process;
		this.remainingDemand = demand;
		this.timeToFinish = -1;
	}
	
	public PreemptiveProcess getProcess() {
		return process;
	}

	public double getRemainingDemand() {
		return remainingDemand;
	}

	public boolean timeSliceFinished() {
		return process.timeSliceFinished();
	}

	public boolean demandProcessed() {
		return remainingDemand < MathTools.EPSILON_ERROR;
	}

	public double getRemainingTimeSlice() {
		return process.getRemainingTimeSlice();
	}

	@Override
	public void passTime(double time) {
		remainingDemand -= time;
		if (remainingDemand < 0)
			remainingDemand = 0;
		process.substractFromRemainingTimeSlice(time);
	}

	@Override
	public double getNextEventTime() {
		return Math.min(process.getRemainingTimeSlice(), remainingDemand);
	}

	@Override
	public boolean isActive() {
		return process.isActive();
	}

}
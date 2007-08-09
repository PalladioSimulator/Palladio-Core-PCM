package de.uka.ipd.sdq.capra.simulator.resources.scheduling.old;

import de.uka.ipd.sdq.capra.simulator.expressions.SimCapraProcess;
import de.uka.ipd.sdq.probfunction.math.util.MathTools;

public class ScheduledProcess {

	protected SimCapraProcess process;
	
	protected double remainingTimeSlice;

	private ISchedulingStrategy strategy;

	public ScheduledProcess(SimCapraProcess capraProcess, ISchedulingStrategy strategy) {
		this.process = capraProcess;
		this.strategy = strategy;
	}

	public SimCapraProcess getProcess() {
		return process;
	}

	public void setProcess(SimCapraProcess process) {
		this.process = process;
	}

	public double getRemainingTimeSlice() {
		return remainingTimeSlice;
	}

	public void setRemainingTimeSlice(double remainingTimeSlice) {
		this.remainingTimeSlice = remainingTimeSlice;
	}
	
	public boolean timeSliceFinished(){
		return MathTools.equalsDouble(remainingTimeSlice, 0);
	}

	public void proceed() {
		process.proceed();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ScheduledProcess) {
			ScheduledProcess schProcess = (ScheduledProcess) obj;
			return this.process.equals(schProcess.process);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.process.hashCode();
	}

	@Override
	public String toString() {
		return this.process.toString();
	}

	public void resetTimeSlice() {
		remainingTimeSlice = strategy.getTimeSliceFor(this);
	}

	public void substractFromTimeSlice(double time) {
		remainingTimeSlice -= time;
		if (remainingTimeSlice <0)
			remainingTimeSlice = 0;
	}

}

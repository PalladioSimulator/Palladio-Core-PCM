package de.uka.ipd.sdq.capra.simulator.resources.scheduling.impl;

import de.uka.ipd.sdq.capra.simulator.expressions.SimCapraProcess;
import de.uka.ipd.sdq.probfunction.math.util.MathTools;

public class PreemptiveProcess {

	protected SimCapraProcess process;
	
	protected double remainingTimeSlice;
	
	protected int dynamicPriorityIncrease = 0;

	private boolean active;

	public PreemptiveProcess(SimCapraProcess capraProcess) {
		this.process = capraProcess;
		this.active = false;
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
		if (obj instanceof PreemptiveProcess) {
			PreemptiveProcess schProcess = (PreemptiveProcess) obj;
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

	public void substractFromRemainingTimeSlice(double time) {
		remainingTimeSlice -= time;
		if (remainingTimeSlice < 0)
			remainingTimeSlice = 0;
	}
	
	public boolean increasePriority(){
		if (dynamicPriorityIncrease == 0) {
			dynamicPriorityIncrease ++;
			return true;
		}
		return false;
	}
	
	public boolean decreasePriority(){
		if (dynamicPriorityIncrease > 0) {
			dynamicPriorityIncrease --;
			return true;
		}
		return false;
	}

	public int getPriority() {
		return dynamicPriorityIncrease;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getName() {
		return this.process.getName();
	}
}

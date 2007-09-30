package de.uka.ipd.sdq.scheduler.processes.impl;

import de.uka.ipd.sdq.probfunction.math.util.MathTools;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.timeslice.ITimeSlice;

public class PreemptiveProcess extends ActiveProcess {

	private ITimeSlice timeslice = null;
	
	public PreemptiveProcess(ISchedulableProcess process) {
		super(process);
	}
	
//	@Override
//	protected void passTimeProcessing(double passedTime) {
//		super.passTimeProcessing(passedTime);
//		timeslice.subTimeProcessing(passedTime);
//	}
//	
//	@Override
//	protected void passTimeScheduling(double passedTime) {
//		super.passTimeScheduling(passedTime);
//		timeslice.subTimeScheduling(passedTime);
//	}
//	
//	@Override
//	public double getTimeUntilNextInterruption() {
//		return timeslice.getTimeUntilNextInterruption();
//	}
	
	public ITimeSlice getTimeslice(){
		return this.timeslice;
	}
	
	public void setTimeSlice(ITimeSlice timeslice) {
		this.timeslice = timeslice;
	}
	
	@Override
	public String toString() {
		return super.toString() + " (" + MathTools.round( timeslice.getRemainingTime(), 0.1) +")";
	}
}

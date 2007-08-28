package de.uka.ipd.sdq.scheduler.processes.impl;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.timeslice.ITimeSlice;

public class PreemptiveProcess extends ActiveProcess {

	private ITimeSlice timeslice = null;
	
	public PreemptiveProcess(ISchedulableProcess process, String name, String id) {
		super(process, name, id);
	}
	
	public boolean timeSlicePartFinished() {
		return timeslice.partFinished();
	}
	
	public boolean timeSliceCompletelyFinished() {
		return timeslice.completelyFinished();
	}

	public void resetTimeSlice() {
		timeslice.reset();
	}

	@Override
	protected void passTime(double passedTime) {
		super.passTime(passedTime);
		timeslice.substractTime(passedTime);
	}
	
	@Override
	public double getTimeUntilNextInterruption() {
		return timeslice.getTimeUntilNextInterruption();
	}
	
	public ITimeSlice getTimeslice(){
		return this.timeslice;
	}
	
	public void setTimeSlice(ITimeSlice timeslice) {
		this.timeslice = timeslice;
	}
}

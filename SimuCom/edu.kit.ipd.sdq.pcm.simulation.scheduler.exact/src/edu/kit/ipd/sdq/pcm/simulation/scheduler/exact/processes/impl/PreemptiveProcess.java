package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.impl;

import de.uka.ipd.sdq.probfunction.math.util.MathTools;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.IActiveProcess;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.timeslice.ITimeSlice;

public class PreemptiveProcess extends ActiveProcess {

	private ITimeSlice timeslice = null;
	
	public PreemptiveProcess(SchedulerModel model, ISchedulableProcess process) {
		super(model, process);
	}
	
	@Override
	protected void passTimeProcessing(double passedTime) {
		super.passTimeProcessing(passedTime);
		timeslice.substractTime(passedTime);
	}
	
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
	
	@Override
	public IActiveProcess createNewInstance(ISchedulableProcess process) {
		PreemptiveProcess p = new PreemptiveProcess(getModel(), process);
		p.timeslice = this.timeslice.clone();
		return p;
	}
}

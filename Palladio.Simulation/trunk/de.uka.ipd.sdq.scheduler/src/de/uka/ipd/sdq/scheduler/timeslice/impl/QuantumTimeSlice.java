package de.uka.ipd.sdq.scheduler.timeslice.impl;

import de.uka.ipd.sdq.probfunction.math.util.MathTools;
import de.uka.ipd.sdq.scheduler.timeslice.ITimeSlice;


public class QuantumTimeSlice implements ITimeSlice {
		
	protected double remaining_time;
	protected double timeslice;
	protected int	 remaining_quanta;
	protected int	 quanta = 6;
	
	protected double part;
	protected double remaining_part;
	
	public QuantumTimeSlice(double timeslice, int granularity) {
		super();
		this.timeslice = timeslice;
		this.part = timeslice / granularity;
		this.remaining_time = 0;
		this.remaining_part = 0;
		this.remaining_quanta = 0;
	}
	
	protected QuantumTimeSlice(){
		this.timeslice = 0;
		this.part = 0;
		this.remaining_time = 0;
		this.remaining_part = 0;
		this.remaining_quanta = 0;
	}

	public double getTimeUntilNextInterruption() {
		return remaining_part;
	}

	
	public boolean completelyFinished() {
		return MathTools.equalsDouble(remaining_time, 0.0);
	}
	
	
	public boolean partFinished() {
		return MathTools.equalsDouble(remaining_part, 0.0);
	}

	public void substractTime(double time) {
		remaining_time -= time;
		remaining_part -= time;
		
		double half = timeslice / 2;
		if (remaining_time <= half && (remaining_time + time) > half){
			remaining_quanta -= (quanta / 2);
			if (MathTools.equalsDouble(remaining_time, 0)){
				remaining_quanta = 0;
			}
		}
		assert MathTools.lessOrEqual(0.0, remaining_time) : "Timeslice exceeded: " + remaining_time;
		assert MathTools.lessOrEqual(0.0, remaining_part) : "Part exceeded: " + remaining_part;
	}

	
	public void reset() {
		remaining_part = part;
		if ( MathTools.equalsDouble( remaining_time, 0.0) ){
			remaining_time = timeslice;
			remaining_quanta = quanta;
		}
		if (remaining_part > remaining_time)
			remaining_time = remaining_part;
	}

	
	public void fullReset() {
		remaining_time = timeslice;
		remaining_part = part;
		remaining_quanta = quanta;
	}

	
	public double getRemainingTime() {
		return remaining_time;
	}

	
	public void punish(int penalty) {
		remaining_quanta--;
	}

	
	public void setExpired() {
		this.remaining_part = 0;
		this.remaining_time = 0;
		this.remaining_quanta = 0;
		
	}
	
	@Override
	public ITimeSlice clone() {
		QuantumTimeSlice cts = new QuantumTimeSlice();
		cts.part = this.part;
		cts.timeslice = this.timeslice;
		cts.quanta = this.quanta;
		cts.remaining_part = this.remaining_part;
		cts.remaining_time = this.remaining_time;
		cts.remaining_quanta = this.remaining_quanta;
		return cts;
	}

	
	public void quantumFinished() {
	}

	public void halfReset() {
		int factor = 0;
		if (remaining_quanta > 4)
			factor = 2;
		else if (remaining_quanta > 1)
			factor = 1;
		remaining_part = part/2 * factor;
		remaining_time = timeslice/2 * factor;
	}

	public void enoughTime() {
		if (remaining_quanta < 2) {
			remaining_part = 0;
			remaining_time = 0;
		}
	}
}

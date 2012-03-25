package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.timeslice.impl;

import de.uka.ipd.sdq.probfunction.math.util.MathTools;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.timeslice.ITimeSlice;


public class QuantumTimeSlice implements ITimeSlice {
		
	protected double remaining_time;
	protected double timeslice;
	protected int	 remaining_quanta;
	protected int	 quanta; 	// Windows default : 6
	protected int min_quanta; 	// Windows default : 2
	
	public QuantumTimeSlice(double timeslice, int quanta, int min_quanta) {
		super();
		
		assert timeslice > 0 : "Timeslice must be larger than 0.";
		assert quanta > 0 : "Quanta must be larger than 0.";
		assert min_quanta > 0 : "Min Quanta must be larger than 0.";
		
		this.timeslice = timeslice;
		this.quanta = quanta;
		this.min_quanta = min_quanta;
		this.remaining_time = 0;
		this.remaining_quanta = 0;
	}
	
	protected QuantumTimeSlice(){
		this.timeslice = 0;
		this.remaining_time = 0;
		this.remaining_quanta = 0;
	}


	public boolean isFinished() {
		return MathTools.equalsDouble(remaining_time, 0.0);
	}
	
	
	public void substractTime(double time) {
		remaining_time -= time;
		
		double half = timeslice / 2;
		if (remaining_time <= half && (remaining_time + time) > half){
			remaining_quanta -= (quanta / 2);
			if (MathTools.equalsDouble(remaining_time, 0)){
				remaining_quanta = 0;
			}
		}
		assert MathTools.lessOrEqual(0.0, remaining_time) : "Timeslice exceeded: " + remaining_time;
	}

	
	public void reset() {
		remaining_time = timeslice;
		remaining_quanta = quanta;
	}

	
	public void fullReset() {
		remaining_time = timeslice;
		remaining_quanta = quanta;
	}

	
	public double getRemainingTime() {
		return remaining_time;
	}

	
	public void punish(int penalty) {
		remaining_quanta--;
	}

	
	public void setExpired() {
		this.remaining_time = 0;
		this.remaining_quanta = 0;
		
	}
	
	@Override
	public ITimeSlice clone() {
		QuantumTimeSlice cts = new QuantumTimeSlice();
		cts.timeslice = this.timeslice;
		cts.quanta = this.quanta;
		cts.remaining_time = this.remaining_time;
		cts.remaining_quanta = this.remaining_quanta;
		return cts;
	}

	
	public void halfReset() {
		int factor = 0;
		if (remaining_quanta > 4)
			factor = 2;
		else if (remaining_quanta > 1)
			factor = 1;
		remaining_time = timeslice/2 * factor;
	}

	public void updateTimeForBoosting() {
		if (remaining_quanta < min_quanta) {
			remaining_time = 0;
		}
	}

	public void updateTimeForScheduling() {
	}
}

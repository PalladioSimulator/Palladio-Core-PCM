package de.uka.ipd.sdq.scheduler.processes.sensors;

import umontreal.iro.lecuyer.simevents.Sim;
import de.uka.ipd.sdq.scheduler.IProcessStateSensor;
import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.processes.impl.PROCESS_STATE;

public class SleepAverageSensor implements IProcessStateSensor {

	private PROCESS_STATE last_state;
	private double lastUpdateTime;
	private double sleep_average;
	private double max_sleep_average;
	
	public SleepAverageSensor(IActiveProcess process, double max_sleep_average){
		this.sleep_average = 0;
		this.lastUpdateTime = 0;
		this.last_state = process.getState();
		this.max_sleep_average = max_sleep_average;
	}
	

	public double getSleepAverage() {
		return sleep_average;
	}
	
	public double getMaxSleepAverage() {
		return max_sleep_average;
	}

	@Override
	public void update(PROCESS_STATE new_state) {
		double currentTime = Sim.time();
		double passedTime = currentTime - lastUpdateTime;
		
		// Process was waiting, but is finished now
		if (last_state == PROCESS_STATE.WAITING &&
			new_state != PROCESS_STATE.WAITING) {
			// sleepAverage cannot exceed its maximum value
			sleep_average = Math.min(max_sleep_average, sleep_average + passedTime);
		}
		
		// Process was running, but is finished now
		if (last_state == PROCESS_STATE.RUNNING &&
			new_state != PROCESS_STATE.RUNNING) {
			// sleepAverage cannot be less than zero.
			sleep_average = Math.max(0, sleep_average - passedTime);
		}
		
		// Process changes into a new measured state (RUNNING or WAITING)
		if ((last_state != PROCESS_STATE.RUNNING &&
			 new_state == PROCESS_STATE.RUNNING) ||
			(last_state != PROCESS_STATE.WAITING &&
			 new_state == PROCESS_STATE.WAITING)){
			lastUpdateTime = currentTime;
		}
		
		last_state = new_state;
	}
}

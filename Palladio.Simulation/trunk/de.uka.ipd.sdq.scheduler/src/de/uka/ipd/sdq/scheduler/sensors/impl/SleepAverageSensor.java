package de.uka.ipd.sdq.scheduler.sensors.impl;

import umontreal.iro.lecuyer.simevents.Simulator;
import de.uka.ipd.sdq.scheduler.factory.SchedulingFactory;
import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.processes.PROCESS_STATE;
import de.uka.ipd.sdq.scheduler.sensors.IProcessStateSensor;

public class SleepAverageSensor implements IProcessStateSensor {

	private PROCESS_STATE last_state;
	private double lastUpdateTime;
	private double sleep_average;
	private double max_sleep_average;
	private Simulator simulator;
	private int max_bonus;
	
	public SleepAverageSensor(IActiveProcess process, double max_sleep_average, int max_bonus){
		this.simulator = SchedulingFactory.getUsedSimulator();
		this.sleep_average = max_sleep_average;
		this.lastUpdateTime = 0;
		this.last_state = process.getState();
		this.max_sleep_average = max_sleep_average;
		this.max_bonus = max_bonus;
	}
	

	public double getSleepAverage() {
		return sleep_average;
	}
	
	public double getMaxSleepAverage() {
		return max_sleep_average;
	}

	public void update(PROCESS_STATE new_state) {
		double currentTime = simulator.time();
		double passedTime = currentTime - lastUpdateTime;
		
		// Process was waiting, but is finished now
		if (last_state == PROCESS_STATE.WAITING &&
			new_state != PROCESS_STATE.WAITING) {
			// sleepAverage cannot exceed its maximum value
			sleep_average = Math.min(max_sleep_average, sleep_average + passedTime); // 8 *
		}
		
		// Process was running, but is finished now
		if (last_state == PROCESS_STATE.RUNNING &&
			new_state != PROCESS_STATE.RUNNING) {
			// corresponds to Linux scheduler code (2.6.22.17)
			// sched.c, line 3622 
			// run_time /= (CURRENT_BONUS(prev) ? : 1);
			int div = getCurrentBonus(); 
			passedTime /= (div > 0 ? div : 1);
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


	public int getCurrentBonus() {
		// corresponds to Linux scheduler code (2.6.22.17)
		// sched.c, line 142
		// #define CURRENT_BONUS(p) \
		// 		(NS_TO_JIFFIES((p)->sleep_avg) * MAX_BONUS / \
		// 		MAX_SLEEP_AVG)

		return (int) Math.round((sleep_average / max_sleep_average) * max_bonus);	
	}
}

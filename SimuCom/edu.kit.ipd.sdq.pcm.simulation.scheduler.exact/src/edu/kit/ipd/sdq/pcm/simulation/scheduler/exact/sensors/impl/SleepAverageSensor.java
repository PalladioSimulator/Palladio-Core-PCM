package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.sensors.impl;

import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.scheduler.processes.PROCESS_STATE;
import de.uka.ipd.sdq.scheduler.sensors.IProcessStateSensor;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.IActiveProcess;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.impl.ProcessWithPriority;

public class SleepAverageSensor implements IProcessStateSensor {

    private SchedulerModel model;
	private PROCESS_STATE last_state;
	private double lastUpdateTime;
	private double sleep_average;
	private double max_sleep_average;
	private int max_bonus;
	private IActiveProcess process;
	private int last_bonus;
	
	private static double FACTOR = 0.5;

	public SleepAverageSensor(SchedulerModel model, IActiveProcess process, double max_sleep_average,
			int max_bonus) {
		this.model = model;
		this.lastUpdateTime = model.getSimulationControl().getCurrentSimulationTime();
		this.last_state = process.getState();
		this.max_sleep_average = max_sleep_average;
		this.max_bonus = max_bonus;
		this.process = process;
		this.last_bonus = (int) Math.ceil(max_bonus * FACTOR);
		this.sleep_average = interactiveSleep((ProcessWithPriority) process);
		this.update(process.getState());
	}

	public double getSleepAverage() {
		update(last_state);
		return sleep_average;
	}

	public double getMaxSleepAverage() {
		return max_sleep_average;
	}

	public void update(PROCESS_STATE new_state) {
		double currentTime = model.getSimulationControl().getCurrentSimulationTime();
		double passedTime = currentTime - lastUpdateTime;

		// Process was waiting
		// Please note that the waiting period lasts
		// until the process starts running, i.e., also
		// its time in the ready queue counts as waiting
		// time.
		if (last_state == PROCESS_STATE.WAITING) {
			// sleepAverage cannot exceed its maximum value
			sleep_average = Math.min(max_sleep_average, sleep_average
					+ Math.floor(passedTime) );
		}

		// Process was running
		if (last_state == PROCESS_STATE.RUNNING) {
			// corresponds to Linux scheduler code (2.6.22)
			// sched.c, line 3622
			// run_time /= (CURRENT_BONUS(prev) ? : 1);
			passedTime /= (last_bonus > 0 ? last_bonus : 1);
			sleep_average = Math.max(0, sleep_average - passedTime);
		}

		lastUpdateTime = currentTime;

		// only remember the new state if we are not in a waiting period
		// otherwise keep the waiting state until the process is running again
		// ... that's the way it is realized in the Linux scheduler. So, don't
		// blame me.
		if (!(last_state == PROCESS_STATE.WAITING && new_state != PROCESS_STATE.RUNNING)) {
			last_state = new_state;
		}
	}

	public int getCurrentBonus() {
		// corresponds to Linux scheduler code (2.6.22)
		// sched.c, line 142
		// #define CURRENT_BONUS(p) \
		// (NS_TO_JIFFIES((p)->sleep_avg) * MAX_BONUS / \
		// MAX_SLEEP_AVG)

		// update the sleep average to get the priorities right...
		update(last_state);

		last_bonus = (int) Math.floor(((double)msToJiffies(sleep_average) * max_bonus) / (double)msToJiffies(max_sleep_average));
		return last_bonus;
	}


	/**
	 * Converts exact simulation time to the linux' scheduler internal time
	 * values called jiffies. A jiffies represent the current time as the number
	 * of scheduler clock ticks, i.e. they are less exact.
	 * 
	 * @param time
	 *            time in milliseconds
	 * @return scheduler time in jiffies
	 */
	public int msToJiffies(double time) {
		// Please note that the divisor depends on the actual HZ rate of the scheduler.
		int jiffies = (int) Math.ceil((time) / 10.0 );
		return jiffies;
	}
	
	public double jiffiesToMs(int jiffies) {
		// Please note that the divisor depends on the actual HZ rate of the scheduler. (1000 / HZ)
		return (double) jiffies * 10;
	}
	
	public double interactiveSleep(ProcessWithPriority p){
		// #define SCALE(v1,v1_max,v2_max) \
		//  	(v1) * (v2_max) / (v1_max)
		// (SCALE(TASK_NICE(p) + 20, 40, MAX_BONUS)
		int scale = ((p.getDynamicPriority().getValue() + 20) * max_bonus) / 40;
		
		// #define DELTA(p) \
		// (SCALE(TASK_NICE(p) + 20, 40, MAX_BONUS) - 20 * MAX_BONUS / 40 + \
		//  	INTERACTIVE_DELTA)
		int delta = scale - (20 * max_bonus) / 40 + 2;

		//(MAX_SLEEP_AVG * (MAX_BONUS / 2 + DELTA((p)) + 1) / MAX_BONUS - 1)
		int result = (msToJiffies(max_sleep_average) * (max_bonus / 2 + delta + 1)) / max_bonus - 1;
		
		//JIFFIES_TO_NS(...)
		return jiffiesToMs(result);
		
		// this would be the simplified variant of the code above.
		// return (int) (max_sleep_average * (3.0d / max_bonus  + 0.5 + p.getStaticPriority().getValue() / 40.0d) - 1.0);
	}
}

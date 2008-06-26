package de.uka.ipd.sdq.scheduler.priority.update;

import de.uka.ipd.sdq.scheduler.priority.IPriorityUpdateStrategy;
import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.processes.impl.ProcessWithPriority;
import de.uka.ipd.sdq.scheduler.sensors.impl.SleepAverageSensor;


public class SleepAverageDependentUpdate implements IPriorityUpdateStrategy {

	private SleepAverageSensor sleepAverageSensor;
	
	// parameters according to the Linux 2.6.22 scheduler.
	private double max_sleep_average;
	private int max_bonus;

	public SleepAverageDependentUpdate(IActiveProcess process, double max_sleep_average, int max_bonus) {
		sleepAverageSensor = new SleepAverageSensor(process, max_sleep_average, max_bonus);
		process.addStateSensor(sleepAverageSensor);
		this.max_bonus = max_bonus;
		this.max_sleep_average = max_sleep_average;
	}

	/**
	 * Implementation according to the current Linux 2.6.18 Scheduler
	 */
	public boolean update(ProcessWithPriority process) {
		int current_bonus =  sleepAverageSensor.getCurrentBonus();
		current_bonus -= max_bonus / 2;
		process.setToStaticPriorityWithBonus(current_bonus);
		if (process.getRunQueue() != null){
			double starvation_limit = max_sleep_average * process.getRunQueue().getCurrentLoad();
			boolean process_starving = process.getRunQueue().processStarving(starvation_limit);
			if (isInteractive(process) 
					&& process.getTimeslice().completelyFinished()
					&& !process_starving){
				process.getTimeslice().reset();
			}
		}
		return true;
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
		int result = (sleepAverageSensor.msToJiffies(max_sleep_average) * (max_bonus / 2 + delta + 1)) / max_bonus - 1;
		
		//JIFFIES_TO_NS(...)
		return sleepAverageSensor.jiffiesToMs(result);
		
		// this would be the simplified variant of the code above.
		// return (int) (max_sleep_average * (3.0d / max_bonus  + 0.5 + p.getStaticPriority().getValue() / 40.0d) - 1.0);
	}
	
	public boolean isInteractive(ProcessWithPriority p){
//		int delta = p.getStaticPriority().getValue() * max_bonus / 40 + 2;
//		IPriority threshold = p.getStaticPriority().addBonus(delta);
//		IPriority prio = p.getDynamicPriority();
//		return threshold.lessOrEqual(prio);
		double sleep = interactiveSleep(p);
		return sleepAverageSensor.getSleepAverage() > sleep;
	}
	
	@Override
	public SleepAverageDependentUpdate cloneFor(ProcessWithPriority process) {
		return new SleepAverageDependentUpdate(process, max_sleep_average, max_bonus);
	}
	
}
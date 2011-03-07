package de.uka.ipd.sdq.scheduler.priority.update;

import de.uka.ipd.sdq.scheduler.priority.IPriority;
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
					&& process.getTimeslice().isFinished()
					&& !process_starving){
				process.getTimeslice().fullReset();
			}
		}
		return true;
	}
	

	
	public boolean isInteractive(ProcessWithPriority p){
//		int delta = p.getStaticPriority().getValue() * max_bonus / 40 + 2;
//		IPriority threshold = p.getStaticPriority().addBonus(delta);
//		IPriority prio = p.getDynamicPriority();
//		return threshold.lessOrEqual(prio);
		double sleep = sleepAverageSensor.interactiveSleep(p);
		return sleepAverageSensor.getSleepAverage() > sleep;
	}
	
	public SleepAverageDependentUpdate cloneFor(ProcessWithPriority process) {
		return new SleepAverageDependentUpdate(process, max_sleep_average, max_bonus);
	}
	
}
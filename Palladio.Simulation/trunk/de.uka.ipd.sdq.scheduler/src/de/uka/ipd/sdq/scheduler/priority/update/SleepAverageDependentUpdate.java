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

	private int threshold;
	
	public SleepAverageDependentUpdate(IActiveProcess process, double max_sleep_average, int max_bonus, int threshold) {
		sleepAverageSensor = new SleepAverageSensor(process, max_sleep_average, max_bonus);
		process.addStateSensor(sleepAverageSensor);
		this.max_bonus = max_bonus;
		this.max_sleep_average = max_sleep_average;
		this.threshold = threshold;
	}

	/**
	 * Implementation according to the current Linux 2.6.18 Scheduler
	 */
	public boolean update(ProcessWithPriority process) {
		int current_bonus =  sleepAverageSensor.getCurrentBonus();
		current_bonus -= max_bonus / 2;
		process.setToStaticPriorityWithBonus(current_bonus);
		if (isInteractive(process) && process.getTimeslice().completelyFinished())
			process.getTimeslice().reset();
		return true;
	}
	
	public int interactiveSleep(ProcessWithPriority p){
		return (int) (max_sleep_average * (3.0d / max_bonus  + 0.5 + p.getStaticPriority().getValue() / 40.0d) - 1.0);
	}
	
	public boolean isInteractive(ProcessWithPriority p){
		int delta = p.getStaticPriority().getValue() * max_bonus / 40 + 2;
		return p.getDynamicPriority().greaterThan(p.getStaticPriority().addBonus(delta));
	}
}
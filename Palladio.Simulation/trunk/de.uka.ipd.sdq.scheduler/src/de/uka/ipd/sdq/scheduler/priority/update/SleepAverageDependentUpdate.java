package de.uka.ipd.sdq.scheduler.priority.update;

import de.uka.ipd.sdq.scheduler.priority.IPriorityUpdateStrategy;
import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.processes.impl.ProcessWithPriority;
import de.uka.ipd.sdq.scheduler.processes.sensors.SleepAverageSensor;


public class SleepAverageDependentUpdate implements IPriorityUpdateStrategy {

	private SleepAverageSensor sleepAverageSensor;
	
	// parameters according to the Linux 2.6.18 scheduler.
	private double max_sleep_average;
	private int max_bonus;
	
	public SleepAverageDependentUpdate(IActiveProcess process, double max_sleep_average, int max_bonus) {
		sleepAverageSensor = new SleepAverageSensor(process, max_sleep_average);
		process.addStateSensor(sleepAverageSensor);
		this.max_bonus = max_bonus;
		this.max_sleep_average = max_sleep_average;
	}

	@Override
	/**
	 * Implementation according to the current Linux 2.6.18 Scheduler
	 */
	public boolean update(ProcessWithPriority process) {
		double sleep_average = sleepAverageSensor.getSleepAverage();
		int current_bonus =  (int) Math.round((sleep_average / max_sleep_average) * max_bonus);
		current_bonus -= max_bonus / 2;
		process.setToStaticPriorityWithBonus(current_bonus);
		return true;
	}
}
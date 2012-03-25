package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.priority.update;

import de.uka.ipd.sdq.scheduler.SchedulerModel;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.priority.IPriorityUpdateStrategy;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.IActiveProcess;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.impl.ProcessWithPriority;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.sensors.impl.SleepAverageSensor;


public class SleepAverageDependentUpdate implements IPriorityUpdateStrategy {

    private SchedulerModel model;
	private SleepAverageSensor sleepAverageSensor;
	
	// parameters according to the Linux 2.6.22 scheduler.
	private double max_sleep_average;
	private int max_bonus;

	public SleepAverageDependentUpdate(SchedulerModel model, IActiveProcess process, double max_sleep_average, int max_bonus) {
		sleepAverageSensor = new SleepAverageSensor(model, process, max_sleep_average, max_bonus);
		process.addStateSensor(sleepAverageSensor);
		this.model = model;
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
		return new SleepAverageDependentUpdate(model, process, max_sleep_average, max_bonus);
	}
	
}
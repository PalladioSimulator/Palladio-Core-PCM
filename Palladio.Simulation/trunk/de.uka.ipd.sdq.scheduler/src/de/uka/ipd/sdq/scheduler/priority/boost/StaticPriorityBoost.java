package de.uka.ipd.sdq.scheduler.priority.boost;

import de.uka.ipd.sdq.scheduler.priority.IPriority;
import de.uka.ipd.sdq.scheduler.priority.IPriorityBoost;
import de.uka.ipd.sdq.scheduler.priority.IPriorityUpdateStrategy;
import de.uka.ipd.sdq.scheduler.processes.impl.ProcessWithPriority;



public class StaticPriorityBoost implements IPriorityBoost {

	private IPriorityUpdateStrategy update_strategy;
	private int bonus;
	private double time_penalty;
	private boolean reset_timeslice;
	
	public StaticPriorityBoost(IPriorityUpdateStrategy update_strategy,
			int bonus, double time_penalty, boolean reset_timeslice) {
		super();
		this.update_strategy = update_strategy;
		this.bonus = bonus;
		this.time_penalty = time_penalty;
		this.reset_timeslice = reset_timeslice;
	}

	@Override
	public void boost(ProcessWithPriority process) {
		if (reset_timeslice && priorityChanges(process)){
			process.getTimeslice().fullReset();
		}
		process.setToStaticPriorityWithBonus(bonus);
		process.setPriorityUpdateStrategy(update_strategy);
	}
	
	@Override
	public void punish(ProcessWithPriority process){
		double penalty = Math.min(time_penalty, process.getTimeslice().getRemainingTime());
		process.getTimeslice().substractTime(penalty);
	}
	
	
	@Override
	public boolean priorityChanges(ProcessWithPriority process){
		IPriority newPrio = process.getStaticPriority().addBonus(bonus);
		return !newPrio.equals(process.getDynamicPriority());
	}
}
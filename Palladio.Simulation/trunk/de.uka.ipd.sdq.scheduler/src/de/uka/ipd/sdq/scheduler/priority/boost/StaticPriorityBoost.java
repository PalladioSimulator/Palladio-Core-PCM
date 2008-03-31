package de.uka.ipd.sdq.scheduler.priority.boost;

import de.uka.ipd.sdq.scheduler.priority.IPriority;
import de.uka.ipd.sdq.scheduler.priority.IPriorityBoost;
import de.uka.ipd.sdq.scheduler.priority.IPriorityUpdateStrategy;
import de.uka.ipd.sdq.scheduler.processes.impl.ProcessWithPriority;



public class StaticPriorityBoost implements IPriorityBoost {

	private IPriorityUpdateStrategy update_strategy;
	private int bonus;
	private int penalty;
	private boolean reset_timeslice;
	
	public StaticPriorityBoost(IPriorityUpdateStrategy update_strategy,
			int bonus, int penalty, boolean reset_timeslice) {
		super();
		this.update_strategy = update_strategy;
		this.bonus = bonus;
		this.penalty = penalty;
		this.reset_timeslice = reset_timeslice;
	}

	
	public void boost(ProcessWithPriority process) {
		//if (reset_timeslice && priorityChanges(process)){
		if (priorityChanges(process) || reset_timeslice){
			if (reset_timeslice){
				process.getTimeslice().halfReset();
			} else {
				process.getTimeslice().enoughTime();
			}
			process.setToStaticPriorityWithBonus(bonus);
			process.setPriorityUpdateStrategy(update_strategy);
		}
	}
	
	
	public void punish(ProcessWithPriority process){
		process.getTimeslice().punish(penalty);
	}
	
	
	
	public boolean priorityChanges(ProcessWithPriority process){
		IPriority newPrio = process.getStaticPriority().addBonus(bonus);
		return !newPrio.equals(process.getDynamicPriority());
	}
}
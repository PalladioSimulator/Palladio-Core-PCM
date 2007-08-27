package de.uka.ipd.sdq.scheduler.priority.boost;

import de.uka.ipd.sdq.scheduler.priority.IPriorityBoost;
import de.uka.ipd.sdq.scheduler.priority.IPriorityUpdateStrategy;
import de.uka.ipd.sdq.scheduler.processes.ProcessWithPriority;



public class StaticPriorityBoost implements IPriorityBoost {

	private IPriorityUpdateStrategy priorityUpdateStrategy;
	private int bonus;
	
	public StaticPriorityBoost(IPriorityUpdateStrategy priorityUpdateStrategy,
			int bonus) {
		super();
		this.priorityUpdateStrategy = priorityUpdateStrategy;
		this.bonus = bonus;
	}

	@Override
	public void boost(ProcessWithPriority process) {
		process.setToStaticPriorityWithBonus(bonus);
		process.setPriorityUpdateStrategy(priorityUpdateStrategy);
	}
}
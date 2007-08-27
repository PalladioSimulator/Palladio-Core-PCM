package de.uka.ipd.sdq.scheduler.priority.update;

import de.uka.ipd.sdq.scheduler.priority.IPriorityUpdateStrategy;
import de.uka.ipd.sdq.scheduler.processes.impl.ProcessWithPriority;


public class SetToBaseUpdate implements IPriorityUpdateStrategy {

	@Override
	public boolean update(ProcessWithPriority process) {
		process.resetDynamicPriority();
		return false;
	}

}

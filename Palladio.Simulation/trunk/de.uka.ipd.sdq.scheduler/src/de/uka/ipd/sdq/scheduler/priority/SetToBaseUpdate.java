package de.uka.ipd.sdq.scheduler.priority;

import de.uka.ipd.sdq.scheduler.processes.ProcessWithPriority;


public class SetToBaseUpdate extends AbstractPriorityUpdate {

	@Override
	public boolean update(ProcessWithPriority process) {
		return false;
	}

}

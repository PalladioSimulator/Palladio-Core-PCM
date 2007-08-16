package de.uka.ipd.sdq.scheduler.priority;

import java.util.Collection;

import de.uka.ipd.sdq.scheduler.processes.ProcessWithPriority;


public abstract class AbstractPriorityUpdate implements IPriorityUpdateStrategy {

	@Override
	public abstract boolean update(ProcessWithPriority process);
}

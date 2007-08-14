package de.uka.ipd.sdq.capra.simulator.resources_new;

import java.util.Collection;


public abstract class AbstractPriorityUpdate implements IPriorityUpdateStrategy {

	@Override
	public abstract boolean update(ProcessWithPriority process);
}

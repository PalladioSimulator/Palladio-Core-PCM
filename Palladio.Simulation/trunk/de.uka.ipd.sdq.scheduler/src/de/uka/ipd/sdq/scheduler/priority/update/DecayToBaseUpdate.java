/**
 * 
 */
package de.uka.ipd.sdq.scheduler.priority.update;

import de.uka.ipd.sdq.scheduler.priority.IPriorityUpdateStrategy;
import de.uka.ipd.sdq.scheduler.processes.impl.ProcessWithPriority;

public class DecayToBaseUpdate implements IPriorityUpdateStrategy {

	public boolean update(ProcessWithPriority process) {
		if (process.hasBonus() && process.getTimeslice().completelyFinished()){
			process.decreasePriority();
			return true;
		}
		return false;
	}
	
	@Override
	public DecayToBaseUpdate cloneFor(ProcessWithPriority process)  {
		return this;
	}
}
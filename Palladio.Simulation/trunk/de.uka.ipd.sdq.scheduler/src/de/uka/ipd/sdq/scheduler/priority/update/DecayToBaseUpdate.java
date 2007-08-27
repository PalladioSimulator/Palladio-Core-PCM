/**
 * 
 */
package de.uka.ipd.sdq.scheduler.priority.update;

import de.uka.ipd.sdq.scheduler.priority.IPriorityUpdateStrategy;
import de.uka.ipd.sdq.scheduler.processes.impl.ProcessWithPriority;

public class DecayToBaseUpdate implements IPriorityUpdateStrategy {

	@Override
	public boolean update(ProcessWithPriority process) {
		if (process.hasBonus()){
			process.decreasePriority();
			return true;
		}
		return false;
	}
}
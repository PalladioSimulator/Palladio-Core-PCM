/**
 * 
 */
package de.uka.ipd.sdq.scheduler.priority;

import de.uka.ipd.sdq.scheduler.processes.ProcessWithPriority;

public class DecayToBaseUpdate extends AbstractPriorityUpdate {

	@Override
	public boolean update(ProcessWithPriority process) {
		return false;
	}

}
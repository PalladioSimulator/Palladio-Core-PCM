/**
 * 
 */
package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.priority.update;

import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.priority.IPriorityUpdateStrategy;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.impl.ProcessWithPriority;

public class DecayToBaseUpdate implements IPriorityUpdateStrategy {

	public boolean update(ProcessWithPriority process) {
		if (process.hasBonus() && process.getTimeslice().isFinished()){
			process.decreasePriority();
			return true;
		}
		return false;
	}
	
	public DecayToBaseUpdate cloneFor(ProcessWithPriority process)  {
		return this;
	}
}
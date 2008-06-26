package de.uka.ipd.sdq.scheduler.priority.update;

import de.uka.ipd.sdq.scheduler.priority.IPriorityUpdateStrategy;
import de.uka.ipd.sdq.scheduler.processes.impl.ProcessWithPriority;


public class SetToBaseUpdate implements IPriorityUpdateStrategy {

	int currentTimeslices = 1;
	int timeslices = 1;
	
	public SetToBaseUpdate(int timeslices) {
		this.timeslices = timeslices;
		this.currentTimeslices = timeslices;
	}

	public boolean update(ProcessWithPriority process) {
		if (process.getTimeslice().completelyFinished()){
			currentTimeslices --;
			if (currentTimeslices <= 0){
				process.resetDynamicPriority();
				return false;
			}
		}
		return true;
	}
	
	@Override
	public SetToBaseUpdate cloneFor(ProcessWithPriority process)  {
		return new SetToBaseUpdate(timeslices);
	}

}

package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.priority.update;

import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.priority.IPriorityUpdateStrategy;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.impl.ProcessWithPriority;


public class SetToBaseUpdate implements IPriorityUpdateStrategy {

	int currentTimeslices = 1;
	int timeslices = 1;
	
	public SetToBaseUpdate(int timeslices) {
		this.timeslices = timeslices;
		this.currentTimeslices = timeslices;
	}

	public boolean update(ProcessWithPriority process) {
		if (process.getTimeslice().isFinished()){
			currentTimeslices --;
			if (currentTimeslices <= 0){
				process.resetDynamicPriority();
				return false;
			}
		}
		return true;
	}
	
	public SetToBaseUpdate cloneFor(ProcessWithPriority process)  {
		return new SetToBaseUpdate(timeslices);
	}

}

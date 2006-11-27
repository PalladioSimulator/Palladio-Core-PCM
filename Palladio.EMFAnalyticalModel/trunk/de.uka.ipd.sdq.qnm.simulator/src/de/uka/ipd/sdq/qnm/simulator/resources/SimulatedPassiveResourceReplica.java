package de.uka.ipd.sdq.qnm.simulator.resources;

import de.uka.ipd.sdq.qnm.simulator.tasks.SimulatedTask;
import desmoj.core.simulator.Model;
import desmoj.core.simulator.ProcessQueue;
import desmoj.core.simulator.SimProcess;

public class SimulatedPassiveResourceReplica extends SimProcess {
	
	protected SimulatedPassiveResource master;
	
	protected SimProcess lockedBy;
	
	public SimulatedPassiveResourceReplica(Model owner, String name, boolean showInTrace, SimulatedPassiveResource master) {
		super(owner, name, showInTrace);
		this.master = master;
		this.lockedBy = null;
	}

	@Override
	public void lifeCycle() {
		
		while (true)
		{
			ProcessQueue waitingTasks = master.getWaitingTasks();
			
			if (lockedBy != null){
				// passive resource is locked by a task -> sleep
				passivate();
			} else if (waitingTasks.isEmpty()) {
				// no tasks waiting to be served -> enter queue of semaphores...
				master.getWaitingSemaphores().insert(this);
				// ... and wait:
				passivate();
			} else {
				// some task wants to get a passive resource 
				// -> get task from queue of tasks
				SimProcess waitingTask = waitingTasks.first();
				waitingTasks.remove(waitingTask);
				SimulatedTask simTask = (SimulatedTask)waitingTask;

				// reactivate the task
				simTask.activateAfter(this);
				
				// and go to sleep
				setLockedBy(simTask);
				
				passivate();
			}
		}
	}

	public SimProcess getLockedBy() {
		return lockedBy;
	}

	public void setLockedBy(SimProcess lockedBy) {
		this.lockedBy = lockedBy;
	}

}

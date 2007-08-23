package de.uka.ipd.sdq.scheduler.resources.balancing;

import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.queueing.IRunQueue;


public interface IProcessSelector {

	ActiveProcess select(IRunQueue runQueue, SimResourceInstance instance);

}

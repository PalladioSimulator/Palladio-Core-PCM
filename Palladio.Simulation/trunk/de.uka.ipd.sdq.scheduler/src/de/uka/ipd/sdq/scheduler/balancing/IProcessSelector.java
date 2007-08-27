package de.uka.ipd.sdq.scheduler.balancing;

import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.queueing.IRunQueue;
import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;


public interface IProcessSelector {

	ActiveProcess select(IRunQueue runQueue, SimResourceInstance instance);

}

package de.uka.ipd.sdq.scheduler.loaddistribution;

import de.uka.ipd.sdq.scheduler.IResourceInstance;
import de.uka.ipd.sdq.scheduler.processes.impl.ActiveProcess;
import de.uka.ipd.sdq.scheduler.queueing.IRunQueue;


public interface IProcessSelector {

	ActiveProcess select(IRunQueue runQueue, IResourceInstance instance);

}

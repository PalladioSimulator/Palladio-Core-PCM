package de.uka.ipd.sdq.scheduler.resources.balancing;

import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;


public interface IProcessSelector {

	ActiveProcess select(SimResourceInstance instance);

}

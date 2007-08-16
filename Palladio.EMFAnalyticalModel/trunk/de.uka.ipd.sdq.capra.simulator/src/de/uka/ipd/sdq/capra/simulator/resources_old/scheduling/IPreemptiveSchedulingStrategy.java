package de.uka.ipd.sdq.capra.simulator.resources_old.scheduling;

import de.uka.ipd.sdq.capra.simulator.resources.scheduling.ProcessRegistry;

public interface IPreemptiveSchedulingStrategy extends ISchedulingStrategy{

	void reschedule();

	int getNumberOfJobs();

	boolean finishSchedulingCycle(IScheduledJob job);

	ProcessRegistry getRegistry();

}

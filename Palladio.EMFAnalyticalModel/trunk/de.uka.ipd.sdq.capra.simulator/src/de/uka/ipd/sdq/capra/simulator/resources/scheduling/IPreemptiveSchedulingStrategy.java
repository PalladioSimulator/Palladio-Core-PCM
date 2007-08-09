package de.uka.ipd.sdq.capra.simulator.resources.scheduling;

import de.uka.ipd.sdq.capra.simulator.resources.scheduling.impl.ProcessRegistry;

public interface IPreemptiveSchedulingStrategy extends ISchedulingStrategy{

	void reschedule();

	int getNumberOfJobs();

	boolean finishSchedulingCycle(IScheduledJob job);

	ProcessRegistry getRegistry();

}

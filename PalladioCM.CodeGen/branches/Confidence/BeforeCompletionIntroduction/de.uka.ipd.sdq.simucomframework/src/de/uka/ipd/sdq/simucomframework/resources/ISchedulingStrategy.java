package de.uka.ipd.sdq.simucomframework.resources;

import de.uka.ipd.sdq.simucomframework.resources.SimulatedActiveResource.JobAndDemandStruct;
import desmoj.core.simulator.Event;
import desmoj.core.simulator.SimTime;

public interface ISchedulingStrategy {

	void processPassedTime(double timePassed);

	void addJob(JobAndDemandStruct demand);

	double getTimeWhenNextJobIsDone();

	JobAndDemandStruct removeFinshedJob();

	boolean hasMoreJobs();

	int getTotalJobCount();

}

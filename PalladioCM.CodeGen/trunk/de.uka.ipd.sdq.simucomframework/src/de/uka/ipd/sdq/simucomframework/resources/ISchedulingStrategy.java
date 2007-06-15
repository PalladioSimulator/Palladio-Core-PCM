package de.uka.ipd.sdq.simucomframework.resources;


public interface ISchedulingStrategy {

	void processPassedTime(double timePassed);

	void addJob(JobAndDemandStruct demand);

	double getTimeWhenNextJobIsDone();

	JobAndDemandStruct removeFinshedJob();

	boolean hasMoreJobs();

	int getTotalJobCount();

}

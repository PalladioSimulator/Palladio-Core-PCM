package de.uka.ipd.sdq.capra.simulator.resources.scheduling;



public interface IJobManager { // extends Iterable<IScheduledJob> {

	void addJob(IScheduledJob job);

	int getNumberOfJobs();

	void removeFinishedJob(IScheduledJob job);

}

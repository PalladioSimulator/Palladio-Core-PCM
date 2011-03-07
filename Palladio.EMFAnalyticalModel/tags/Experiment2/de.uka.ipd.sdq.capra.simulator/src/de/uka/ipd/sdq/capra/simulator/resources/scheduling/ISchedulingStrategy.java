package de.uka.ipd.sdq.capra.simulator.resources.scheduling;

import de.uka.ipd.sdq.capra.simulator.resources.Job;


public interface ISchedulingStrategy {
	
	/**
	 * Determines the next Job that will be finished by the resource.
	 * The Job contains information on the finishing time.
	 * @return
	 */
	Job getNextJobToBeFinished();
	
	/**
	 * Adds Job j to the scheduler queue. This activates a rescheduling of 
	 * the current jobs. 
	 * @param j
	 */
	void addJob(Job j);
	
	/**
	 * Notifies the scheduler that the next job has been finished.
	 * The scheduler checks if the job has actually been processed 
	 * and removes it from the queue.
	 * @param time
	 */
	void jobFinishedCallback(Job j);

	/**
	 * Progresses the scheduler to the current simulation time.
	 */
	void progressInTime();
}

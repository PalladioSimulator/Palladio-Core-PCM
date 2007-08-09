package de.uka.ipd.sdq.capra.simulator.resources.scheduling.old;

import de.uka.ipd.sdq.capra.simulator.expressions.SimCapraProcess;
import de.uka.ipd.sdq.capra.simulator.resources.scheduling.impl.PreemptiveJob;


public interface ISchedulingStrategy {
	
	/**
	 * Determines the next Job that will be finished by the resource.
	 * The Job contains information on the finishing time.
	 * @return
	 */
	PreemptiveJob getNextJobToBeFinishedWithAssertion();
	
	/**
	 * Adds Job j to the scheduler queue. This activates a rescheduling of 
	 * the current jobs. 
	 * @param j
	 */
	void addJob(PreemptiveJob j);
	
	/**
	 * Notifies the scheduler that the next job has been finished.
	 * The scheduler checks if the job has actually been processed 
	 * and removes it from the queue.
	 * @param time
	 */
	void jobFinishedCallback(PreemptiveJob j);

	/**
	 * Progresses the scheduler to the current simulation time.
	 */
	void progressInTime();

	/**
	 * Returns the Scheduling information of a given process.
	 * @param capraProcess
	 * @return
	 */
	ScheduledProcess getScheduledProcess(SimCapraProcess capraProcess);

	double getTimeSliceFor(ScheduledProcess scheduledProcess);
}

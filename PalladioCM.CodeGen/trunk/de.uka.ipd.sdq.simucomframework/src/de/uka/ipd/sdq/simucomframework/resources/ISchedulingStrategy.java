package de.uka.ipd.sdq.simucomframework.resources;

import java.util.List;


/**
 * Interface for Scheduling Strategies
 * @author Steffen Becker
 *
 */
public interface ISchedulingStrategy {

	/**
	 * Informs the scheduler strategy that
	 * a certain amount of time has passed.
	 * Used to update the scheduler internal data structures
	 * @param timePassed The time span elapsed since the last update
	 */
	void processPassedTime(double timePassed);

	/**
	 * Add a new job to the ready queue of this scheduler
	 * @param demand The demand of the job in seconds
	 */
	void addJob(JobAndDemandStruct demand);

	/**
	 * Determines the point in time when the next job is done if no 
	 * other event occurs in the meanwhile
	 * @return The point in time when the next job is fully done on this
	 * resource
	 */
	double getTimeWhenNextJobIsDone();

	/**
	 * Called to remove the job which caused an event to fire saying that
	 * it finished execution
	 * @return The job which is done now
	 */
	JobAndDemandStruct removeFinishedJob();

	/**
	 * @return True if this strategy's scheduler has more jobs in its
	 * ready queue 
	 */
	boolean hasMoreJobs();

	/**
	 * @return The total number of jobs currently in the ready queue of this
	 * processor
	 */
	int getTotalJobCount();
	
	/** Remove all remaining jobs at this resource and return. Called at simulation end.
	 * @return All jobs still waiting at this resource
	 */
	List<JobAndDemandStruct> removeRemainingJobs();

}

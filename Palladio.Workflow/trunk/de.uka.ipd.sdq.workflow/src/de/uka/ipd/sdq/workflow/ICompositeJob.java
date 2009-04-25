package de.uka.ipd.sdq.workflow;

/**
 * Interface for composite jobs.
 * 
 * A composite job is a collection of jobs that form a logical group
 * and are executed together.
 * 
 * @author Philipp Meier
 */

public interface ICompositeJob extends IJob {
	
	/**
	 * Adds a job to the composite job.
	 * 
	 * @param job the job to add
	 */
	public void addJob(IJob job);
}

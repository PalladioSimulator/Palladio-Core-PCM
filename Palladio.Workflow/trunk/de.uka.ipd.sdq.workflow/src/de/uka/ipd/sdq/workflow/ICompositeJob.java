package de.uka.ipd.sdq.workflow;

import java.util.List;

/**
 * Interface for composite jobs.
 * 
 * A composite job is a list of jobs that form a logical group
 * and are executed together in sequence. The order of the list elements determines
 * the order of the Job's execution.
 * 
 * @author Philipp Meier
 */

public interface ICompositeJob extends IJob, List<IJob>  {
	/**
	 * Adds a job to the end of the list of composite jobs.
	 * 
	 * @param job the job to add
	 */
	public void addJob(IJob job);
}

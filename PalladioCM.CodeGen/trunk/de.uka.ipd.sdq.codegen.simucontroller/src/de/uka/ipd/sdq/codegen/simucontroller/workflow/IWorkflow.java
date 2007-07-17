package de.uka.ipd.sdq.codegen.simucontroller.workflow;

/**
 * Interface for workflows that manage the execution
 * and rollback of a number of independent jobs (IJob).
 * A rollback will affect all Jobs which have been executed.
 * 
 * @author Philipp Meier
 */
public interface IWorkflow {
	
	/**
	 * Start the workflow. The jobs will be executed in any
	 * order, possibly even in parallel. They must therefore
	 * be independent of each other.
	 * @throws JobFailedException a job has failed
	 * @throws UserCanceledException the user has cancelled
	 * the workflow or a job
	 */
	public void run() throws JobFailedException, UserCanceledException;

	/**
	 * Trigger a rollback of all jobs which have been executed.
	 * @throws RollbackFailedException the workflow failed
	 */
	public void rollback() throws RollbackFailedException;
	
	/**
	 * adds a job to the workflow
	 * @param job the job to add to the workflow
	 */
	public void addJob(IJob job);
}

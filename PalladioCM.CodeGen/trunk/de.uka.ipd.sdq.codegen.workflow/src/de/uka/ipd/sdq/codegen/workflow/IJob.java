package de.uka.ipd.sdq.codegen.workflow;

import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.codegen.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.codegen.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.codegen.workflow.exceptions.UserCanceledException;

/**
 * Interface for jobs to be added to a workflow (IWorkflow).
 * 
 * If jobs depend on each other (i.e. the execution depends
 * on a certain order) a composite job should be implemented
 * which then manages the child jobs.
 * 
 * @author Philipp Meier
 */
public interface IJob {
	
	/**
	 * Execute the job. In case of an error throw an exception
	 * with a meaningful name which can be understood by a user.
	 * 
	 * @throws JobFailedException the job failed
	 * @throws UserCanceledException the user has chosen
	 * to abort the job
	 */
	public void execute(IProgressMonitor monitor) throws JobFailedException, UserCanceledException;
	
	/**
	 * Return to the state before the execute() method was called.
	 * This method will be called on every simulation run to remove
	 * automatically created files and to leave the environment in a
	 * state in which the simulation run can be started again with
	 * the same results.
	 * 
	 * @throws RollbackFailedException
	 */
	public void rollback(IProgressMonitor monitor) throws RollbackFailedException;
	
	/**
	 * Supply a name of this job. This could be used for
	 * a progress monitor.
	 * 
	 * @return the name of the job
	 */
	public String getName();
}

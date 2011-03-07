package de.uka.ipd.sdq.workflow;

import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;

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
	 * Clean up all temporary side effects of this job. 
	 * This method will always be called after executing this job 
	 * to remove automatically created files and to leave the environment in a
	 * state in which the whole workflow run can be started again with
	 * the same results (i.e. in which executed can be called again).
	 * 
	 * Usually, rollback is called after the whole workflow is completed to allow other 
	 * jobs to use intermediate results. In some cases, rollback can be called earlier. However, 
	 * in those cases, later jobs might not be able to access the intermediate data anymore.  
	 * 
	 * @throws RollbackFailedException Thrown if a critical error occurred during clean up 
	 * so that the whole workflow should abort cleaning up further jobs. 
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

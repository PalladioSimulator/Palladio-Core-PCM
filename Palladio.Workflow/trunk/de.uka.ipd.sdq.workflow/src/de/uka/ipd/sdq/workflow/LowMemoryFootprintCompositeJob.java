package de.uka.ipd.sdq.workflow;

import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;

/**
 * A sequential workflow which may contain jobs which need access to a common blackboard
 * for information exchange.
 * Compared to a OrderPreservingBlackboardCompositeJob, this job
 * has a lower memory footprint. In addition, a rollback of a nested job
 * is being executed immediately after the nested job has completed.
 * 
 * @author Hauck
 * @param <BlackboardType> The type of the blackboard needed by all jobs in the sequential workflow
 */
public class LowMemoryFootprintCompositeJob<BlackboardType extends Blackboard<?>> 
extends OrderPreservingBlackboardCompositeJob<BlackboardType> {

	/**
	 * constructor
	 */
	public LowMemoryFootprintCompositeJob() {
		super();
	}

	/** 
	 * {@inheritDoc}
	 * 
	 * Specialty: Calls rollback after the execution of each nested job and deletes the reference to that nested job. 
	 * Thus, you need to make sure that no later jobs depend on these jobs intermediate results that are deleted during rollback.    
	 */ 
	@SuppressWarnings("unchecked")
	@Override
	public void execute(IProgressMonitor monitor) throws JobFailedException, UserCanceledException {

		IProgressMonitor subProgressMonitor = new ExecutionTimeLoggingProgressMonitor(monitor, 1);
		subProgressMonitor.beginTask("Composite Job Execution", myJobs.size());
		
		int totalNumberOfJobs = myJobs.size();
		for (int i=0; i<totalNumberOfJobs; i++) {
			if (monitor.isCanceled()) {
				throw new UserCanceledException();
			}
			IJob job = myJobs.getFirst();
			if (job instanceof IBlackboardInteractingJob){
				((IBlackboardInteractingJob) job).setBlackboard(this.myBlackboard);
			}
			logger.debug("SDQ Workflow-Engine: Running job "+job.getName());
			subProgressMonitor.subTask(job.getName());
			job.execute(subProgressMonitor);
			subProgressMonitor.worked(1);
			subProgressMonitor.subTask("Cleaning up job " + job.getName());
			try {
				job.rollback(subProgressMonitor);
			} catch (RollbackFailedException e) {
				logger.warn("Failed to cleanup job " + job.getName());
			}
			subProgressMonitor.worked(1);
			myJobs.removeFirst();
			job = null;
		}
		subProgressMonitor.done();
	}
	
	/**
	 * {@inheritDoc}<br><br>
	 * 
	 * Compared to a OrderPreservingBlackboardCompositeJob, this
	 * method does not invoke a rollback on nested jobs.
	 * For every nested job, the rollback method is being called
	 * immediately after the job has completed (in {@link #execute(IProgressMonitor)}). 
	 *  
	 */
	@Override
	public void rollback(IProgressMonitor monitor) throws RollbackFailedException {
		// Do nothing. Rollback for every nested job is being called immediately after the job has been executed.
	}
}

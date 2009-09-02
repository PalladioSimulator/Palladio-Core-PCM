package de.uka.ipd.sdq.workflow;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;

import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;

/**
 * Implementation of a composite job that guarantees
 * the execution of it's jobs in the order they were added.
 * 
 * @author Philipp Meier
 */

public class OrderPreservingCompositeJob extends AbstractCompositeJob implements ICompositeJob {
	
	/**
	 * constructor
	 */
	public OrderPreservingCompositeJob() {
		super();
	}

	/** 
	 * Executes all contained jobs, i.e. call execute() for them. Contained 
	 * jobs can thus re-implement this method with functionality that should 
	 * be executed.
	 */ 
	public void execute(IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
		IProgressMonitor subProgressMonitor = new SubProgressMonitor(monitor, 1);
		subProgressMonitor.beginTask("Composite Job Execution", myJobs.size());
		
		for (IJob job : myJobs) {
			if (monitor.isCanceled())
				throw new UserCanceledException();			
			logger.debug("SDQ Workflow-Engine: Running job "+job.getName());
			myExecutedJobs.push(job);
			job.execute(subProgressMonitor);
			subProgressMonitor.worked(1);
		}
		subProgressMonitor.done();
	}
}

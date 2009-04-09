package de.uka.ipd.sdq.codegen.workflow;

import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.codegen.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.codegen.workflow.exceptions.UserCanceledException;

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
		for (IJob job : myJobs) {
			logger.info("SDQ Workflow-Engine: Running job "+job.getName());
			myExecutedJobs.push(job);
			job.execute(monitor);
		}
	}
}

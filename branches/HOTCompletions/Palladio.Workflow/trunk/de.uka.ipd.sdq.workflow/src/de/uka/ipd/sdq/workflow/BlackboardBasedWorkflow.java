package de.uka.ipd.sdq.workflow;

import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.exceptions.WorkflowExceptionHandler;

/**
 * A workflow implementation which may contain jobs which need to access a blackboard
 * @author Steffen
 *
 * @param <T> The type of the blackboard which the jobs in the workflow can access
 */
public class BlackboardBasedWorkflow<T extends Blackboard<?>> extends Workflow {

	private T myBlackboard;

	public BlackboardBasedWorkflow(IJob job, T blackboard) {
		this(job, null, new WorkflowExceptionHandler(false), blackboard);
	}

	public BlackboardBasedWorkflow(IJob job, WorkflowExceptionHandler handler, T blackboard) {
		this(job, null, new WorkflowExceptionHandler(false),blackboard);
	}

	public BlackboardBasedWorkflow(
			IJob job, 
			IProgressMonitor monitor, 
			WorkflowExceptionHandler handler,
			T blackboard) {
		super(job, monitor, handler);
		this.myBlackboard = blackboard;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.workflow.OrderPreservingCompositeJob#execute(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void execute(IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {
		for (IJob job : this.myJobs){
			if (job instanceof IBlackboardInteractingJob<?>){
				if (logger.isDebugEnabled()) {
					logger.debug("Setting Blackboard of job "+job.getClass().getCanonicalName());
				}
				((IBlackboardInteractingJob<T>) job).setBlackbard(this.myBlackboard);
			}
		}
		super.execute(monitor);
	}
	
	
}

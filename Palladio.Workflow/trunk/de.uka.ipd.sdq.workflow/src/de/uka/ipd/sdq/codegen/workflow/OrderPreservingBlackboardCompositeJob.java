package de.uka.ipd.sdq.codegen.workflow;

import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.codegen.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.codegen.workflow.exceptions.UserCanceledException;

/**
 * A sequential workflow which may contain jobs which need access to a common blackboard
 * for information exchange
 * @author Steffen
 * @param <BlackboardType> The type of the blackboard needed by all jobs in the sequential workflow
 */
public class OrderPreservingBlackboardCompositeJob<BlackboardType extends Blackboard<?>> 
extends OrderPreservingCompositeJob implements ICompositeJob, IBlackboardInteractingJob<BlackboardType> {
	
	protected BlackboardType myBlackboard;

	/**
	 * constructor
	 */
	public OrderPreservingBlackboardCompositeJob() {
		super();
	}

	/** 
	 * Executes all contained jobs, i.e. call execute() for them. Contained 
	 * jobs can thus re-implement this method with functionality that should 
	 * be executed.
	 */ 
	@SuppressWarnings("unchecked")
	@Override
	public void execute(IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
		for (IJob job : this.myJobs){
			if (job instanceof IBlackboardInteractingJob){
				((IBlackboardInteractingJob) job).setBlackbard(this.myBlackboard);
			}
		}
		super.execute(monitor);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.workflow.IBlackboardInteractingJob#setBlackbard(de.uka.ipd.sdq.codegen.workflow.Blackboard)
	 */
	public void setBlackbard(BlackboardType blackboard) {
		this.myBlackboard = blackboard;
	}
}

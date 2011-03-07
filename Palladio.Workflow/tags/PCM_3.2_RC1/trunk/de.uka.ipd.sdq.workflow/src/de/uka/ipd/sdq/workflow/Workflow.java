package de.uka.ipd.sdq.workflow;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.exceptions.WorkflowExceptionHandler;

/**
 * Implementation of a workflow. A workflow is a special composite job which 
 * executes all other jobs while displaying the progress in a progress
 * bar to the user.
 * Additionally, the Workflow has an internal WorkflowExceptionHandler 
 * that handles exception based on the environment (UI available or not).
 * The given Progress Monitor will receive updates before and after a
 * job is executed.
 * 
 * @author Philipp Meier
 * 		   Steffen Becker
 */
public class Workflow 
	extends OrderPreservingCompositeJob
	implements ICompositeJob {
	
	private IProgressMonitor myMonitor;
	protected Logger logger = null;
	protected WorkflowExceptionHandler exceptionHandler = null;

	public Workflow(IJob job) {
		this(job, null, new WorkflowExceptionHandler(false));
	}
	
	public Workflow(IJob job, WorkflowExceptionHandler exceptionHandler) {
		this(job, null, exceptionHandler);
	}
	
	/** 
	 * @param job 
	 * @param monitor the progress monitor to use
	 * @param workflowExceptionHandler 
	 */
	public Workflow(IJob job, IProgressMonitor monitor, WorkflowExceptionHandler workflowExceptionHandler) {
		this.addJob(job);
		this.exceptionHandler  = workflowExceptionHandler;
		if (monitor != null) {
			myMonitor = monitor;
		} else {
			myMonitor = new NullProgressMonitor();
		}
		logger = Logger.getLogger(Workflow.class);
	}

	public void run() {
		logger.info("Creating workflow engine and starting workflow");

		myMonitor.beginTask("Workflow", 1);		
		myMonitor.subTask(this.getName());	
		
		try {
			this.execute(myMonitor);
		} catch (JobFailedException e) {
			logger.error("Workflow job failed, handling failure...");
			logger.error("Failure reason was: ",e);
			this.exceptionHandler.handleJobFailed(e);
		} catch (UserCanceledException e) {
			logger.info("User canceled workflow");
			this.exceptionHandler.handleUserCanceled(e);
		} catch (Exception e) {
			logger.fatal("Workflow terminated unexpectedly",e);
			this.exceptionHandler.handleFatalFailure(e);
		} finally {
			logger.info("Cleaning up...");
			try {
				this.rollback(myMonitor);
			} catch (RollbackFailedException e) {
				logger.error("Critical failure during workflow rollback");
				this.exceptionHandler.handleRollbackFailed(e);
			}
		}
		
		myMonitor.worked(1);		
		myMonitor.done();
		
		logger.info("Workflow engine completed task");
	}
}

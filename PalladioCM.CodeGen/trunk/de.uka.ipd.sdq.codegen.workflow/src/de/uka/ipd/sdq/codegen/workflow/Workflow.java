package de.uka.ipd.sdq.codegen.workflow;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

/**
 * Implementation of a workflow. A workflow is a special composite job which executes all other jobs while displaying the progress in a progress
 * bar to the user.
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
	protected Log logger = null;
	protected WorkflowExceptionHandler exceptionHandler = null;
	
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
	}

	public void run() {
		setupApacheCommonsLogging();
		logger.info("Creating workflow engine and starting workflow");

		myMonitor.beginTask("Workflow", 1);		
		myMonitor.subTask(this.getName());	
		
		try {
			this.execute();
		} catch (JobFailedException e) {
			logger.error("Workflow job failed, handling failure...");
			logger.error("Failure reason was: ",e);
			this.exceptionHandler.handleJobFailed(e);
		} catch (UserCanceledException e) {
			logger.info("User canceled workflow");
			this.exceptionHandler.handleUserCanceled(e);
		} finally {
			logger.info("Cleaning up...");
			try {
				this.rollback();
			} catch (RollbackFailedException e) {
				logger.error("Critical failure during workflow rollback");
				this.exceptionHandler.handleRollbackFailed(e);
			}
		}
		
		myMonitor.worked(1);		
		myMonitor.done();
		
		logger.info("Workflow engine completed task");
	}
	
	protected void setupApacheCommonsLogging() {
		/* Configure Apache Commons Logger for tools supporting this kind of logging
		 * method
		 */
		System.setProperty("org.apache.commons.logging.simplelog.defaultlog","info");
		logger = LogFactory.getLog(Workflow.class);
	}
}

package de.uka.ipd.sdq.codegen.workflow.exceptions;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import de.uka.ipd.sdq.codegen.workflow.WorkflowPlugin;

/**
 * Implementation of a work flow exception handler.
 * Serious failures are logged and presented to the user
 * with an error dialog.
 * 
 * No action is taken if the user cancels the work flow or
 * any of the jobs.
 * 
 * @author Philipp Meier
 */
public class WorkflowExceptionHandler  {
	
	protected boolean myShouldThrowException;
	
	public WorkflowExceptionHandler(boolean shouldThrowException) {
		myShouldThrowException = shouldThrowException;
	}
	
	/**
	 * log the exception through the simucontroller plugin
	 * 
	 * @param e the exception to log
	 */
	private void logException(Exception e) {		
		WorkflowPlugin.log(IStatus.ERROR, e.getMessage());
	}
	
	/**
	 * handle critical exceptions. either throws the exception
	 * or presents it to the user with an error dialog
	 * 
	 * @param e the exception to handle
	 * @throws CoreException
	 */
	protected void handleCriticalException(Exception e) {
		logException(e);

		/**
		 * Enable the ErrorDialog, if SimuComConfig.SHOULD_THROW_EXCEPTION
		 * set of false
		 */
		if (myShouldThrowException)
			throw new WorkflowFailedException("Workflow failed", e);
	}

	/**
	 * handle the case when a job fails
	 * 
	 * @param e the exception containing more information
	 */
	public void handleJobFailed(JobFailedException e) {
		handleCriticalException(e);
	}

	/**
	 * handle the case when a the user chooses to cancel a job
	 * 
	 * @param e the exception containing more information
	 */
	public void handleRollbackFailed(RollbackFailedException e) {
		handleCriticalException(e);
	}

	/**
	 * handle the case when the rollback of a job fails
	 * 
	 * @param e the exception containing more information
	 */
	public void handleUserCanceled(UserCanceledException e) {
		// do nothing
	}

	public void handleFatalFailure(Exception e) {
		handleCriticalException(e);
		throw new RuntimeException("Fatal failure occured at runtime",e);
	}
}

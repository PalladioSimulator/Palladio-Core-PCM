package de.uka.ipd.sdq.workflow.exceptions;

import org.eclipse.core.runtime.CoreException;

/**
 * Implementation of a work flow exception handler. Serious failures are logged
 * and presented to the user with an error dialog.
 * 
 * No action is taken if the user cancels the work flow or any of the jobs.
 * 
 * @author Philipp Meier
 */
public class WorkflowExceptionHandler {

	protected boolean myShouldThrowException;

	/**
	 * Create a UI independent workflow exception handler.
	 * 
	 * @param shouldThrowException
	 *            If true the workflow exception handler does not handle the
	 *            exception but throws a new exception. This is usefull for
	 *            batch runs or test cases.
	 */
	public WorkflowExceptionHandler(boolean shouldThrowException) {
		myShouldThrowException = shouldThrowException;
	}

	/**
	 * log the exception. Can be overriden in subclasses. Default implementation
	 * does nothing here
	 * 
	 * @param e
	 *            the exception to log
	 */
	protected void logException(Exception e) {
	}

	/**
	 * handle critical exceptions. either throws the exception or presents it to
	 * the user with an error dialog
	 * 
	 * @param e
	 *            the exception to handle
	 * @throws CoreException
	 */
	protected void handleCriticalException(Exception e) {
		logException(e);

		// In case of shouldThrowException = true we fail here
		if (myShouldThrowException)
			throw new WorkflowFailedException("Workflow failed", e);
	}

	/**
	 * handle the case when a job fails
	 * 
	 * @param e
	 *            the exception containing more information
	 */
	public void handleJobFailed(JobFailedException e) {
		handleCriticalException(e);
	}

	/**
	 * handle the case when a the user chooses to cancel a job
	 * 
	 * @param e
	 *            the exception containing more information
	 */
	public void handleRollbackFailed(RollbackFailedException e) {
		handleCriticalException(e);
	}

	/**
	 * handle the case when the rollback of a job fails
	 * 
	 * @param e
	 *            the exception containing more information
	 */
	public void handleUserCanceled(UserCanceledException e) {
		// do nothing
	}

	/**
	 * Handles a non-recoverable exception which is not declared in the
	 * interface (e.g., runtime exceptions)
	 * 
	 * @param e
	 *            The exception to handle
	 */
	public void handleFatalFailure(Exception e) {
		handleCriticalException(e);
		throw new RuntimeException("Fatal failure occured at runtime", e);
	}
}

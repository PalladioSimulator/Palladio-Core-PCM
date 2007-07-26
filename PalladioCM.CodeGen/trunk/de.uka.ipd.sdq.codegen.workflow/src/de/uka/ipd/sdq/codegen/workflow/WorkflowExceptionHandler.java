package de.uka.ipd.sdq.codegen.workflow;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.dialogs.error.ErrorDisplayDialog;

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
	
	private boolean myShouldThrowException;
	
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
	private void handleCriticalException(Exception e) throws CoreException {
		logException(e);

		/**
		 * Enable the ErrorDialog, if SimuComConfig.SHOULD_THROW_EXCEPTION
		 * set of false
		 */
		if (myShouldThrowException)
			throw new CoreException(new Status(IStatus.ERROR,
					WorkflowPlugin.PLUGIN_ID, "Simulation failed", e));
		else
			PlatformUI.getWorkbench().getDisplay().syncExec(
					new ErrorDisplayRunner(e));
	}

	/**
	 * handle the case when a job fails
	 * 
	 * @param e the exception containing more information
	 */
	public void handleJobFailed(JobFailedException e) throws CoreException {
		handleCriticalException(e);
	}

	/**
	 * handle the case when a the user chooses to cancel a job
	 * 
	 * @param e the exception containing more information
	 */
	public void handleRollbackFailed(RollbackFailedException e) throws CoreException {
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
	
	/**
	 * Helper class that allows an error display dialog to
	 * appear from a non user interface thread because the
	 * workbench shell is otherwise not accessible.
	 * 
	 * @author Philipp Meier
	 */
	private class ErrorDisplayRunner implements Runnable {
		private Throwable e;

		/**
		 * @param e the throwable to display in the error
		 * display dialog
		 */
		public ErrorDisplayRunner(Throwable e) {
			super();
			this.e = e;
		}

		public void run() {
			new ErrorDisplayDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getShell(), e).open();
		}
	}
}

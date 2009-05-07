package de.uka.ipd.sdq.workflow.ui;

import org.eclipse.ui.PlatformUI;
import de.uka.ipd.sdq.dialogs.error.ErrorDisplayDialog;
import de.uka.ipd.sdq.workflow.exceptions.WorkflowExceptionHandler;

public class UIBasedWorkflowExceptionHandler extends WorkflowExceptionHandler {

	public UIBasedWorkflowExceptionHandler(boolean shouldThrowException) {
		super(shouldThrowException);
	}

	protected void handleCriticalException(Exception e) {
		super.handleCriticalException(e);
		
		PlatformUI.getWorkbench().getDisplay().syncExec(
				new ErrorDisplayRunner(e));
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

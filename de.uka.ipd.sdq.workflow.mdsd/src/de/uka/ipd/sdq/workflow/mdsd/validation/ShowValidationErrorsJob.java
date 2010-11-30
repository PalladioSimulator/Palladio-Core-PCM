package de.uka.ipd.sdq.workflow.mdsd.validation;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.errorhandling.SeverityAndIssue;
import de.uka.ipd.sdq.errorhandling.dialogs.issues.IssuesDialog;
import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedRunConfiguration;

public class ShowValidationErrorsJob 
implements IJob {

	private final ModelValidationJob[] validationJobs;
	private static final Logger logger = Logger.getLogger(ShowValidationErrorsJob.class);
	private final AbstractWorkflowBasedRunConfiguration configuration;
	
	public ShowValidationErrorsJob(AbstractWorkflowBasedRunConfiguration configuration, ModelValidationJob...validationJobs) {
		super();
		this.validationJobs = validationJobs;
		this.configuration = configuration;
	}

	@Override
	public void execute(IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {
		List<SeverityAndIssue> result = new ArrayList<SeverityAndIssue>();
		for (ModelValidationJob validationJob : validationJobs) {
			result.addAll(validationJob.getResult());
		}
		
		if (result.size() > 0) {
			logger.warn("Found validation problems in the models");
			displayValidationErrors(result);
			logger.warn("Continuing workflow, ignoring model validation issues");
		}

	}
	
	@Override
	public String getName() {
		return "Show validation errors";
	}

	@Override
	public void rollback(IProgressMonitor monitor)
			throws RollbackFailedException {
		// TODO Not needed
	}
	

	/** Inner class used to display the dialog containing found validation errors. Needed by Eclipse to
	 * display the dialog in Eclipse's UI thread
	 * 
	 * @author Steffen Becker
	 */
	class ErrorDisplayRunner implements Runnable {
		
		private List<SeverityAndIssue> issues;
		private boolean shouldProceed;

		public boolean shouldProceedAfterErrorDialog() {
			return shouldProceed;
		}

		public ErrorDisplayRunner(List<SeverityAndIssue> overallResult) {
			super();
			this.issues = overallResult;
		}

		public void run() {
			Dialog dialog = new IssuesDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getShell(), issues);
			dialog.open();
			this.shouldProceed = dialog.getReturnCode() == IssuesDialog.IGNORE_BUTTON;
		}

	}
	
	private void displayValidationErrors(
			List<SeverityAndIssue> overallResult)
			throws UserCanceledException {
		ErrorDisplayRunner runner = new ErrorDisplayRunner(overallResult);
	
		/**
		 * Disable the IssuesDialog, if SimuComConfig.SHOULD_THROW_EXCEPTION set
		 * of false
		 */
		if (configuration.isInteractive()) {
			PlatformUI.getWorkbench().getDisplay().syncExec(runner);
			if (!runner.shouldProceedAfterErrorDialog())
				throw new UserCanceledException();
		}
	}
}

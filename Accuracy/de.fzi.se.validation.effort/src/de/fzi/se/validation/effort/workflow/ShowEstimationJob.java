/**
 *
 */
package de.fzi.se.validation.effort.workflow;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.PlatformUI;

import de.fzi.se.validation.effort.IEstimator;
import de.fzi.se.validation.effort.ui.DisplayEstimationsDialog;
import de.fzi.se.validation.effort.ui.EstimationsDialog;
import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;

/**This jobs presents the estimation results to the user using the {@link EstimationsDialog}.
 *
 * @author groenda
 *
 */
public class ShowEstimationJob implements IJob {
	/** Name of this job. */
	public static final String NAME = "Show estimations job";

	/** Estimators which results should be displayed. */
	private List<IEstimator> estimators;
	/** (Launch) configuration of the estimation. */
	private EstimatorConfiguration configuration;

	/**Constructor.
	 * @param configuration Estimation configuration.
	 * @param estimators List of estimators which should be included in the resulting report.
	 */
	public ShowEstimationJob(EstimatorConfiguration configuration, List<IEstimator> estimators) {
		super();
		this.configuration = configuration;
		this.estimators = estimators;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.IJob#execute(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void execute(IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {
		// Disable the IssuesDialog, if job is run in non-interactive mode.
		if (configuration.isInteractive()) {
			DisplayEstimationsDialog runner = new DisplayEstimationsDialog(estimators);
			PlatformUI.getWorkbench().getDisplay().asyncExec(runner);
		} else {
			throw new RuntimeException("Reporting of estimations for non-interactive case is not implemented.");
		}
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.IJob#getName()
	 */
	public String getName() {
		return ShowEstimationJob.NAME;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.IJob#rollback(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void rollback(IProgressMonitor monitor)
			throws RollbackFailedException {
		// nothing to do
	}
}

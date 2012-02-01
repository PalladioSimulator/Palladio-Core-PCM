/**
 *
 */
package de.fzi.se.validation.effort.ui;

import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.ui.PlatformUI;

import de.fzi.se.validation.effort.IEstimator;

/**Wrapper for asynchronous display of {@link EstimationsDialog}.
 * @author groenda
 *
 */
public class DisplayEstimationsDialog implements Runnable {

	/** Estimators with results to display. */
	private final List<IEstimator> estimators;

	public DisplayEstimationsDialog(List<IEstimator> estimators) {
		this.estimators = estimators;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		Dialog dialog = new EstimationsDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), estimators);
		dialog.open();
	}

}

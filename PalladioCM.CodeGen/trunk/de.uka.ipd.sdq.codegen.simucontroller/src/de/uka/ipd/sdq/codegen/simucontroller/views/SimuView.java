package de.uka.ipd.sdq.codegen.simucontroller.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.ui.part.*;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;


/**
 * This sample class demonstrates how to plug-in a new workbench view. The view
 * shows data obtained from the model. The sample creates a dummy model on the
 * fly, but a real implementation would connect to the model available either in
 * this or another plug-in (e.g. the workspace). The view is connected to the
 * model using a content provider.
 * <p>
 * The view uses a label provider to define how model objects should be
 * presented in the view. Each view can present the same model objects using
 * different labels and icons, if needed. Alternatively, a single label provider
 * can be shared between views in order to ensure that objects of the same type
 * are presented in the same way everywhere.
 * <p>
 */

public class SimuView extends ViewPart {

	ProgressBar progressBar = null;
	
	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {

		parent.setLayout(new FormLayout());

		progressBar = new ProgressBar(parent, SWT.NONE);
		final FormData fd_progressBar = new FormData();
		fd_progressBar.bottom = new FormAttachment(0, 79);
		fd_progressBar.right = new FormAttachment(100, -64);
		fd_progressBar.top = new FormAttachment(0, 59);
		fd_progressBar.left = new FormAttachment(0, 65);
		progressBar.setLayoutData(fd_progressBar);
		progressBar.setSelection(40);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		// TODO
	}

	public void updateProgressBar(int percentDone) {
		progressBar.setSelection(percentDone);
	}
}
/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.visualisation.dialogs;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

/**
 * Dialog possible make selection from actions in Menu/Visualasetions are
 * contained.
 * 
 * @author Roman Andrej
 */
public class ActionListSelectionDialog extends ElementListSelectionDialog {

	/** Default dialog size. */
	private int width  = 400;
	private int height = 300;
	
	/**
	 * @param parent
	 *            shell
	 * @param labelProvider for super class
	 */
	public ActionListSelectionDialog(Shell parent, LabelProvider labelProvider) {
		super(parent, labelProvider);
		super.setShellStyle(SWT.NONE);
	}
	
	/**
	 * @param parent
	 *            shell
	 * @param labelProvider
	 *            for super class
	 * @param width
	 *            the x coordinate of the new point
	 * @param height
	 *            the y coordinate of the new point
	 */
	public ActionListSelectionDialog(Shell parent, LabelProvider labelProvider,
			int width, int height) {
		super(parent, labelProvider);
		super.setShellStyle(SWT.NONE);
		this.width = width;
		this.height = height;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.dialogs.SelectionStatusDialog#createButtonBar(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createButtonBar(Composite parent) {
		// Delete OK and CANCEL butons
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.TitleAreaDialog#getInitialSize()
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(width, height);
	}
}

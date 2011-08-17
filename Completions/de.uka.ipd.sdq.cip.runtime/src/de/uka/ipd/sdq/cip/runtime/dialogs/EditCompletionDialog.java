/**
 * 
 */
package de.uka.ipd.sdq.cip.runtime.dialogs;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import de.uka.ipd.sdq.cip.configuration.Transformation;

/**
 * @author thomass
 *
 */
public class EditCompletionDialog extends TitleAreaDialog {
	
	private CompletionConfigurationWidget completionConfigurationWidget = null;
	
	private Transformation transformation = null;

	public EditCompletionDialog(Shell parentShell, Transformation transformation) {
		super(parentShell);
		this.transformation = transformation;
		completionConfigurationWidget = new CompletionConfigurationWidget();
		
		setShellStyle(SWT.DIALOG_TRIM | SWT.RESIZE | SWT.APPLICATION_MODAL);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		
		setTitle("Edit completion");
		setMessage("Edit one completion and change its config");
		
		Composite mainComponent = (Composite) super.createDialogArea(parent);
		
		completionConfigurationWidget.createControl(mainComponent);
		completionConfigurationWidget.setTransformation(transformation);
		return mainComponent;
		
	}
	
	@Override
	protected void okPressed() {
		completionConfigurationWidget.getTransformation(transformation);
		super.okPressed();
	}
}

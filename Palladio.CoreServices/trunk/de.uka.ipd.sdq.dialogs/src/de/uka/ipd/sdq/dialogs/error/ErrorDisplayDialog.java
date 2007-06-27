package de.uka.ipd.sdq.dialogs.error;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class ErrorDisplayDialog extends Dialog {

	private String errorMessage;
	private String details;
	/**
	 * Create the dialog
	 * @param parentShell
	 */
	public ErrorDisplayDialog(Shell parentShell, Throwable t) {
		super(parentShell);
		setShellStyle(SWT.RESIZE|SWT.MAX);
		this.errorMessage = t.getMessage();
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw); 
		t.printStackTrace(pw);
		this.details = sw.toString();
	}

	/**
	 * Create contents of the dialog
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);

		final Group errorMessageGroup = new Group(container, SWT.NONE);
		errorMessageGroup.setLayout(new GridLayout());
		errorMessageGroup.setText("Error Message");
		final GridData gd_errorMessageGroup = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gd_errorMessageGroup.heightHint = 128;
		errorMessageGroup.setLayoutData(gd_errorMessageGroup);

		final Text errorText = new Text(errorMessageGroup, SWT.WRAP | SWT.V_SCROLL | SWT.MULTI | SWT.H_SCROLL | SWT.BORDER);
		final GridData gd_errorText = new GridData(SWT.FILL, SWT.FILL, true, true);
		gd_errorText.heightHint = 92;
		gd_errorText.widthHint = 100;
		errorText.setLayoutData(gd_errorText);
		errorText.setEditable(false);
		errorText.setText(errorMessage);

		final Group detailsGroup = new Group(container, SWT.NONE);
		detailsGroup.setLayout(new GridLayout());
		detailsGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true));
		detailsGroup.setText("Details");

		final Text detailsText = new Text(detailsGroup, SWT.V_SCROLL | SWT.MULTI | SWT.H_SCROLL | SWT.BORDER);
		final GridData gd_detailsText = new GridData(SWT.FILL, SWT.FILL, true, true);
		gd_detailsText.widthHint = 100;
		detailsText.setLayoutData(gd_detailsText);
		detailsText.setEditable(false);
		detailsText.setText(details);
		//
		return container;
	}

	/**
	 * Create contents of the button bar
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(608, 506);
	}
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("An Error occured");
	}

}

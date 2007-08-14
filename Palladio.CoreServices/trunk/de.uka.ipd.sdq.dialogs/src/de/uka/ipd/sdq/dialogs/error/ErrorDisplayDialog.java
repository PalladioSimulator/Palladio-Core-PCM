package de.uka.ipd.sdq.dialogs.error;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class ErrorDisplayDialog extends Dialog {

	private Throwable errorMessage;
	private HashMap<Integer, Throwable> throwablesHash = new HashMap<Integer, Throwable>();
	/**
	 * Create the dialog
	 * @param parentShell
	 */
	public ErrorDisplayDialog(Shell parentShell, Throwable t) {
		super(parentShell);
		setShellStyle(SWT.RESIZE|SWT.MAX);
		this.errorMessage = t;
	}

	private String getStackTrace(Throwable t) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw); 
		t.printStackTrace(pw);
		return sw.toString();
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

		final List errorText = new List(errorMessageGroup, SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
		final GridData gd_errorText = new GridData(SWT.FILL, SWT.FILL, true, true);
		gd_errorText.heightHint = 92;
		gd_errorText.widthHint = 100;
		errorText.setLayoutData(gd_errorText);
		Throwable t = this.errorMessage; int index = 0; ArrayList<Throwable> throwableErrors = new ArrayList<Throwable>();
		do
		{ 
			throwableErrors.add(t);
			t = t.getCause();
		} while (t != null);
		for (int i = throwableErrors.size()-1; i >= 0; i--) {
			if (throwableErrors.get(i).getMessage() != null)
				errorText.add(throwableErrors.get(i).getMessage());
			else
				errorText.add(throwableErrors.get(i).getClass().getName());
			throwablesHash .put(index,throwableErrors.get(i));
			index++;
		}

		final Group detailsGroup = new Group(container, SWT.NONE);
		detailsGroup.setLayout(new GridLayout());
		detailsGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true));
		detailsGroup.setText("Details");

		final Text detailsText = new Text(detailsGroup, SWT.V_SCROLL | SWT.MULTI | SWT.H_SCROLL | SWT.BORDER);
		final GridData gd_detailsText = new GridData(SWT.FILL, SWT.FILL, true, true);
		gd_detailsText.widthHint = 100;
		detailsText.setLayoutData(gd_detailsText);
		detailsText.setEditable(false);
		detailsText.setText(getStackTrace(throwableErrors.get(throwableErrors.size()-1)));
		//

		errorText.addSelectionListener(new SelectionListener(){

			public void widgetDefaultSelected(SelectionEvent e) {
				detailsText.setText(getStackTrace(throwablesHash.get(errorText
						.getSelectionIndex())));
			}

			public void widgetSelected(SelectionEvent e) {
				detailsText.setText(getStackTrace(
						throwablesHash.get(errorText.getSelectionIndex())));
			}
			
		});
		
		errorText.select(0);
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
		return new Point(800, 600);
	}
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("An Error occured");
	}

}

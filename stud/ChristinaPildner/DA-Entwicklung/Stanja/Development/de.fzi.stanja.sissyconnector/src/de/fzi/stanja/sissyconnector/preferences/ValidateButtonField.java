package de.fzi.stanja.sissyconnector.preferences;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

/**
 * the field that shows the validate button in the SissyConnector preferences
 * it has no editor, since the action made is not saved in the preferences.   
 * @author Christina Pildner
 *
 */
public class ValidateButtonField extends FieldEditor {
	
	private Composite parent; 
	
	private Button validateButton; 
	private ValidateListener listener = new ValidateListener();
	
	/*TODO
	 *fields editors that are checked
	 */
	
	
	ValidateButtonField(String name, String labelText,
            Composite parent) {
		/* allready implemented in fieldEditor*/
        init(name, labelText);
        createControl(parent);
        this.parent = parent;
    }
	

	@Override
	protected void adjustForNumColumns(int numColumns) {
		( (GridData) validateButton.getLayoutData()).horizontalSpan = numColumns;
				
	}

	@Override
	protected void doFillIntoGrid(Composite parent, int numColumns) {
		getLabelControl(parent);
		
		validateButton = setValidateButton(parent);
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
        int widthHint = convertHorizontalDLUsToPixels(validateButton,
                IDialogConstants.BUTTON_WIDTH);
        gridData.widthHint = Math.max(widthHint, validateButton.computeSize(
                SWT.DEFAULT, SWT.DEFAULT, true).x);
        validateButton.setLayoutData(gridData);
	
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * shows the validate button and the 
	 * @param parent
	 * @return
	 */
	private Button setValidateButton(Composite parent){
		if (validateButton == null){
			validateButton = new Button(parent,SWT.PUSH);
			validateButton.setText("validate connection");
			validateButton.setFont(parent.getFont());
			validateButton.addListener(SWT.Selection, listener);
		}
		else {
			checkParent(validateButton, parent);
		}
		return validateButton;
	}

	@Override
	protected void doLoad() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doLoadDefault() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doStore() {
		/*no storage necessary*/
	}

	@Override
	public int getNumberOfControls() {
		return 1;
	}

	/**
	 * @author Christina Pildner
	 * validateButtons Listener
	 * the action takes place   
	 */
	class ValidateListener implements Listener{
			@Override
		public void handleEvent(Event event) {
			MessageDialog.openInformation(parent.getShell(), "Connection Validation" , "Validation result" );
			
			
		}
		
	}
}

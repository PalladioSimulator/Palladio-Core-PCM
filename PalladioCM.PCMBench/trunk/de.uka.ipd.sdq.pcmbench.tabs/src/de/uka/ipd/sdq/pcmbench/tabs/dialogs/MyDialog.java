/**
 * 
 */
package de.uka.ipd.sdq.pcmbench.tabs.dialogs;

import java.util.Collection;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import de.uka.ipd.sdq.dialogs.selection.PalladioSelectEObjectDialog;

/**
 * @author admin
 *
 */
public class MyDialog extends PalladioSelectEObjectDialog {

	protected Shell shell;
	
	/**
	 * @param parent
	 * @param filterList
	 * @param additionalChildReferences
	 * @param input
	 */
	public MyDialog(Shell parent, Collection filterList,
			Collection additionalChildReferences, Object input) {
		super(parent, filterList, additionalChildReferences, input);
	}

	/**
	 * @param parent
	 * @param filterList
	 * @param input
	 */
	public MyDialog(Shell parent, Collection filterList, Object input) {
		super(parent, filterList, input);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.dialogs.selection.SelectEObjectDialog#createContents()
	 */
	@Override
	protected void createContents() {
		
		super.createContents();
		
		final Label labelNewType = new Label(sharetGroup, SWT.NONE);
		labelNewType.setText("New Type:");
		labelNewType.setBounds(355, 260, 52, 13);

		final Button button = new Button(sharetGroup, SWT.NONE);
		button.setText("...");
		button.setBounds(436, 255, 24, 23);
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				Shell shell = e.widget.getDisplay().getActiveShell();
				PalladioCreateDataTypeDialog dialog = new PalladioCreateDataTypeDialog(shell);
				dialog.open();
			}
		});
		
	}
}
	

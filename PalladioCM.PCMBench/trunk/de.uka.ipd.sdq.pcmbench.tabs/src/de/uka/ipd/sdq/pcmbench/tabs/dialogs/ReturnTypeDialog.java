package de.uka.ipd.sdq.pcmbench.tabs.dialogs;

import java.util.Collection;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Shell;

import de.uka.ipd.sdq.dialogs.selection.PalladioSelectEObjectDialog;

/**
 * @author admin
 *
 */
public class ReturnTypeDialog extends PalladioSelectEObjectDialog {

	protected Shell shell;
	
	/**
	 * @param parent
	 * @param filterList
	 * @param additionalChildReferences
	 * @param input
	 */
	public ReturnTypeDialog(Shell parent, Collection filterList,
			Collection additionalChildReferences, Object input) {
		super(parent, filterList, additionalChildReferences, input);
	}

	/**
	 * @param parent
	 * @param filterList
	 * @param input
	 */
	public ReturnTypeDialog(Shell parent, Collection filterList, Object input) {
		super(parent, filterList, input);
	}

	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.dialogs.selection.SelectEObjectDialog#createContents()
	 */
	@Override
	protected void createContents() {
		
		super.createContents();
		
		// Activire the ToolBar with items
		super.enableToolBar(true, false, false);
		
		setAddSelectionListener(new SelectionAdapter(){

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = e.widget.getDisplay().getActiveShell();
				PalladioCreateDataTypeDialog dialog = new PalladioCreateDataTypeDialog(shell);
				dialog.open();
			}
			
		});
	}
}
	

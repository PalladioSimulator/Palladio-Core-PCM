/**
 * 
 */
package de.uka.ipd.sdq.codegen.simudatavisualization.tabs;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import de.uka.ipd.sdq.codegen.simudatavisualization.birt.*;
import de.uka.ipd.sdq.codegen.simudatavisualization.dialogs.ExperimentRunsDialog;

/**
 * @author admin
 * 
 */
public class AddRunEntryActionListener extends SelectionAdapter {

	private SensorsPropertySection section;
	
	/**
	 * @param section
	 */
	public AddRunEntryActionListener(SensorsPropertySection section) {
		this.section = section;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	@Override
	public void widgetSelected(SelectionEvent e) {

		ReportCongiguration congiguration = section.getConfigObject();
		
		Assert.isNotNull(congiguration);
		ExperimentRunsDialog dialog = new ExperimentRunsDialog(e.display.getActiveShell());
		if (dialog.open() == dialog.OK && dialog.getResult() != null){
				congiguration.addNewEntry(dialog.getResult());
				section.getViewer().refresh();
		}
	}

}

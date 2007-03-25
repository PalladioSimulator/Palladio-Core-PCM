/**
 * 
 */
package de.uka.ipd.sdq.codegen.simudatavisualization.tabs;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import de.uka.ipd.sdq.codegen.simudatavisualization.birt.*;
import de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorfactory.entities.impl.ExperimentRunImpl;

/**
 * @author admin
 * 
 */
public class AddRunEntryActionListener extends SelectionAdapter {

	private ReportCongiguration congiguration;
	private TableViewer viewer;

	/**
	 * @param congiguration
	 */
	public AddRunEntryActionListener(ReportCongiguration congiguration,
			TableViewer viewer) {
		this.congiguration = congiguration;
		this.viewer = viewer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	@Override
	public void widgetSelected(SelectionEvent e) {

		ChoiceRunDialog dialog = new ChoiceRunDialog(e.display.getActiveShell());
		if (dialog.open() == dialog.OK && dialog.getResult() != null){
				congiguration.addNewEntry(dialog.getResult());
				viewer.refresh();
		}
	}

}

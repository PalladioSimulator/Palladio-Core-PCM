/**
 * 
 */
package de.uka.ipd.sdq.codegen.simudatavisualization.tabs;

import java.util.List;

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

	/**
	 * @param congiguration
	 */
	public AddRunEntryActionListener(ReportCongiguration congiguration) {
		this.congiguration = congiguration;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	@Override
	public void widgetSelected(SelectionEvent e) {
		ExperimentRun run = new ExperimentRunImpl() ;
		run.setExperimentRunID(1122221);
		run.setExperimentDateTime("2007.03.23 12:00");
		congiguration.addNewEntry(run);
	}

}

/**
 *
 */
package de.fzi.se.validation.effort.ui;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

/**Base class for launch configuration tabs containing parameters of estimators.
 *
 * @author groenda
 *
 */
public abstract class AbstractEstimatorConfigurationTab extends
		AbstractLaunchConfigurationTab {
	/** Generic listener for modifications. */
	protected ModifyListener modifyListener = new ModifyListener(){

		/* (non-Javadoc)
		 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
		 */
		public void modifyText(ModifyEvent e) {
			AbstractEstimatorConfigurationTab.this.setDirty(true);
			AbstractEstimatorConfigurationTab.this.updateLaunchConfigurationDialog();
		}
	};
	/** Generic listener for selections. */
	protected SelectionListener selectionListener = new SelectionAdapter() {

		/* (non-Javadoc)
		 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
		 */
		public void widgetSelected(SelectionEvent e) {
			AbstractEstimatorConfigurationTab.this.setDirty(true);
			AbstractEstimatorConfigurationTab.this.updateLaunchConfigurationDialog();
		}
	};
	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout());
	}
}

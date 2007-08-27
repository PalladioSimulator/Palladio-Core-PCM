/**
 * 
 */
package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

import de.uka.ipd.sdq.codegen.runconfig.tabs.ConfigurationTab;
import de.uka.ipd.sdq.codegen.runconfig.tabs.ConstantsContainer;

/**
 * The class extends ConfigurationTab by CheckBox. User can decide whether that
 * generated instance of Palladio Component Model after simulating must be
 * deleted.
 * 
 * @see de.uka.ipd.sdq.codegen.runconfig.tabs.ConfigurationTab
 * 
 * @author Roman Andrej
 */
public class SimuConfigurationTab extends ConfigurationTab {
	
	private Button clearButton;

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.runconfig.tabs.ConfigurationTab#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		
		Composite container = (Composite) getControl();

		/** Clear group*/
		final Group clearGroup = new Group(container, SWT.NONE);
		clearGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		clearGroup.setText("Generated code");
		clearGroup.setLayout(new GridLayout());
		clearButton = new Button(clearGroup,
				SWT.CHECK);
		clearButton.setLayoutData( new GridData(SWT.LEFT, SWT.CENTER, false, false, 4, 1));
		clearButton.setText("Delete generated code at simulation end");
		clearButton.setSelection(true);
		clearButton.addSelectionListener(new SelectionAdapter() {
			
			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				SimuConfigurationTab.this.setDirty(true);
				SimuConfigurationTab.this.updateLaunchConfigurationDialog();
			}
		});
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.runconfig.tabs.ConfigurationTab#initializeFrom(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		super.initializeFrom(configuration);

		try {
			clearButton.setSelection(configuration.getAttribute(
					ConstantsContainer.DELETE_PLUGIN, true));
		} catch (CoreException e) {
			clearButton.setSelection(true);
		}
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.runconfig.tabs.ConfigurationTab#performApply(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		super.performApply(configuration);

		configuration.setAttribute(ConstantsContainer.DELETE_PLUGIN,
				clearButton.getSelection());
	}
}

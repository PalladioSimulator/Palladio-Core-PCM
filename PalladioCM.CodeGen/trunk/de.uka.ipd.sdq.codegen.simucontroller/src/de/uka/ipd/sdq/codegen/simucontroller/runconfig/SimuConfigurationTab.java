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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

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
		
		final Group sensitivityAnalysisParametersGroup = new Group(container, SWT.NONE);
		sensitivityAnalysisParametersGroup.setText("Sensitivity Analysis Parameters");
		final GridData gd_sensitivityAnalysisParametersGroup = new GridData(SWT.FILL, SWT.CENTER, true, false);
		sensitivityAnalysisParametersGroup.setLayoutData(gd_sensitivityAnalysisParametersGroup);
		final GridLayout gridLayout_1 = new GridLayout();
		gridLayout_1.numColumns = 3;
		sensitivityAnalysisParametersGroup.setLayout(gridLayout_1);

		final Label variableToAdaptLabel = new Label(sensitivityAnalysisParametersGroup, SWT.NONE);
		final GridData gd_variableToAdaptLabel = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
		variableToAdaptLabel.setLayoutData(gd_variableToAdaptLabel);
		variableToAdaptLabel.setText("Variable:");

		final Text text = new Text(sensitivityAnalysisParametersGroup, SWT.BORDER);
		text.setEnabled(false);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Button selectVariableButton = new Button(sensitivityAnalysisParametersGroup, SWT.NONE);
		selectVariableButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
			}
		});
		selectVariableButton.setText("Select Variable...");

		final Composite composite = new Composite(sensitivityAnalysisParametersGroup, SWT.NONE);
		final GridData gd_composite = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
		composite.setLayoutData(gd_composite);
		final GridLayout gridLayout_2 = new GridLayout();
		gridLayout_2.numColumns = 6;
		composite.setLayout(gridLayout_2);

		final Label minimumLabel = new Label(composite, SWT.NONE);
		minimumLabel.setText("Minimum:");

		final Text text_1 = new Text(composite, SWT.BORDER);
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Label maximumLabel = new Label(composite, SWT.NONE);
		maximumLabel.setText("Maximum:");

		final Text text_2 = new Text(composite, SWT.BORDER);
		text_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Label stepWidthLabel = new Label(composite, SWT.NONE);
		stepWidthLabel.setText("Step Width:");

		final Text text_3 = new Text(composite, SWT.BORDER);
		text_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
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

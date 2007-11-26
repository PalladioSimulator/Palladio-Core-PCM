/**
 * 
 */
package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import sun.management.counter.Variability;

import de.uka.ipd.sdq.codegen.runconfig.tabs.ConfigurationTab;
import de.uka.ipd.sdq.codegen.runconfig.tabs.ConstantsContainer;
import de.uka.ipd.sdq.codegen.runconfig.tabs.FileNamesInputTab;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;

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
	private Text variableText;
	private Text minimumText;
	private Text maximumText;
	private Text stepWidthText;
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.runconfig.tabs.ConfigurationTab#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		
		final ModifyListener modifyListener = new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				SimuConfigurationTab.this.setDirty(true);
				SimuConfigurationTab.this.updateLaunchConfigurationDialog();
			}
		};
		
		
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

		variableText = new Text(sensitivityAnalysisParametersGroup, SWT.BORDER);
		variableText.setEnabled(false);
		variableText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		variableText.addModifyListener(modifyListener);
		
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

		minimumText = new Text(composite, SWT.BORDER);
		minimumText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		minimumText.addModifyListener(modifyListener);
		
		final Label maximumLabel = new Label(composite, SWT.NONE);
		maximumLabel.setText("Maximum:");

		maximumText = new Text(composite, SWT.BORDER);
		maximumText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		maximumText.addModifyListener(modifyListener);
		
		final Label stepWidthLabel = new Label(composite, SWT.NONE);
		stepWidthLabel.setText("Step Width:");

		stepWidthText = new Text(composite, SWT.BORDER);
		stepWidthText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		stepWidthText.addModifyListener(modifyListener);
		
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
		
		try {
			variableText.setText(configuration.getAttribute(
					ConstantsContainer.VARIABLE_TEXT, ""));
		} catch (CoreException e) {
			variableText.setText("");
		}

		try {
			minimumText.setText(configuration.getAttribute(
					ConstantsContainer.MINIMUM_TEXT, ""));
		} catch (CoreException e) {
			minimumText.setText("");
		}
		
		try {
			maximumText.setText(configuration.getAttribute(
					ConstantsContainer.MAXIMUM_TEXT, ""));
		} catch (CoreException e) {
			maximumText.setText("");
		}
		
		try {
			stepWidthText.setText(configuration.getAttribute(
					ConstantsContainer.STEP_WIDTH_TEXT, ""));
		} catch (CoreException e) {
			stepWidthText.setText("");
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
		configuration.setAttribute(ConstantsContainer.VARIABLE_TEXT,
				variableText.getText());
		configuration.setAttribute(ConstantsContainer.MINIMUM_TEXT,
				minimumText.getText());
		configuration.setAttribute(ConstantsContainer.MAXIMUM_TEXT,
				maximumText.getText());
		configuration.setAttribute(ConstantsContainer.STEP_WIDTH_TEXT,
				stepWidthText.getText());
		
	}
}

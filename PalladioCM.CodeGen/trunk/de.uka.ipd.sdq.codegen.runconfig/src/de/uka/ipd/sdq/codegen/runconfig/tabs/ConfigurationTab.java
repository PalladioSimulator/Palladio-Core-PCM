package de.uka.ipd.sdq.codegen.runconfig.tabs;


import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.uka.ipd.sdq.codegen.runconfig.ConstantsContainer;
import de.uka.ipd.sdq.codegen.runconfig.RunConfigImages;
import de.uka.ipd.sdq.codegen.runconfig.RunConfigPlugin;

/**
 * The class defines a tab, which is responsible for the minimum configuration
 * of oAW generator.
 * 
 * @author Roman Andrej
 */
public class ConfigurationTab extends AbstractLaunchConfigurationTab {

	private Text outputPathField;
	private Label locationLabel;
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#getImage()
	 */
	public Image getImage() {
		return RunConfigImages.getConfigurationTabImage();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		
		final ModifyListener modifyListener = new ModifyListener(){

			public void modifyText(ModifyEvent e) {
				ConfigurationTab.this.setDirty(true);
				ConfigurationTab.this.updateLaunchConfigurationDialog();
			}
		};
		
		Composite container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout());

		/** Create outPath section */
		final Group outputPathGroup = new Group(container, SWT.NONE);
		outputPathGroup.setText("Plugin ID");
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 4;
		outputPathGroup.setLayout(gridLayout);
		final GridData gd_outputPathGroup = new GridData(SWT.FILL, SWT.CENTER, true, false);
		outputPathGroup.setLayoutData(gd_outputPathGroup);

		/** default location button */
		final Button defaultLocationButton = new Button(outputPathGroup,
				SWT.CHECK);
		final GridData gridData_dl = new GridData(SWT.LEFT, SWT.CENTER, false, false, 4, 1);
		defaultLocationButton.setLayoutData(gridData_dl);
		defaultLocationButton.setText("Use default location");
		defaultLocationButton.setSelection(true);
		defaultLocationButton.addSelectionListener(new SelectionAdapter() {

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				setElementsEnabled(false);
				outputPathField.setText(ConstantsContainer.SIMUCOM_DEFAULT_PROJECT_ID);

				if (!defaultLocationButton.getSelection()) {
					setElementsEnabled(true);
					outputPathField.setSelection(0);

				}
			}
		});

		locationLabel = new Label(outputPathGroup, SWT.NONE);
		locationLabel.setLayoutData(new GridData(48, SWT.DEFAULT));
		locationLabel.setText("Location:");

		outputPathField = new Text(outputPathGroup, SWT.BORDER);
		final GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true,
				false);
		gridData.widthHint = 20;
		outputPathField.setLayoutData(gridData);
		outputPathField.setText(ConstantsContainer.SIMUCOM_DEFAULT_PROJECT_ID);
		outputPathField.addModifyListener(modifyListener);

		// disabled widget
		setElementsEnabled(false);

	}

	/**
	 * Those makes enabled/disabled for the input the responsible widget
	 */
	private void setElementsEnabled(boolean enable) {
		locationLabel.setEnabled(enable);
		outputPathField.setEnabled(enable);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#getName()
	 */
	public String getName() {
		return "Configuration";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#initializeFrom(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			outputPathField.setText(configuration.getAttribute(
					ConstantsContainer.PLUGIN_ID, ConstantsContainer.SIMUCOM_DEFAULT_PROJECT_ID));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),"Location", e.getMessage());
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(ConstantsContainer.PLUGIN_ID,
				outputPathField.getText());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#setDefaults(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
	}
	
	public boolean isValid(ILaunchConfiguration launchConfig) {
		setErrorMessage(null);

		if (outputPathField.getText().equals("")){
			setErrorMessage("The output path location is not specified!");
			return false;
		}
		return true;
	}
}

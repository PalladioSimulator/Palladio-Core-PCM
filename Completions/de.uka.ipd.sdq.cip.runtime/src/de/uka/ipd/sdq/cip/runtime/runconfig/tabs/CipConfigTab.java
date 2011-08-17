package de.uka.ipd.sdq.cip.runtime.runconfig.tabs;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
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

import de.uka.ipd.sdq.cip.ConstantsContainer;
import de.uka.ipd.sdq.cip.runtime.RunConfigImages;

public class CipConfigTab extends AbstractCipLaunchConfigurationTab {

	private Label locationLabel;
	private Text outputPathField;
	private Button clearButton;
	private Button checkLoggingButton;

	@Override
	public void createControl(Composite parent) {
		final ModifyListener modifyListener = new ModifyListener(){

			public void modifyText(ModifyEvent e) {
				CipConfigTab.this.setDirty(true);
				CipConfigTab.this.updateLaunchConfigurationDialog();
			}
		};
		
		Composite mainComponent = new Composite(parent,SWT.NONE);
		setControl(mainComponent);
		mainComponent.setLayout(new GridLayout());
		
		/* Copyed from ConfigurationTab */
		/** Create outPath section */
		final Group outputPathGroup = new Group(mainComponent, SWT.NONE);
		outputPathGroup.setText("Completion Plugin ID");
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
				outputPathField.setText(de.uka.ipd.sdq.cip.ConstantsContainer.COMPLETION_DEFAULT_PROJECT_ID);

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
		outputPathField.setText(de.uka.ipd.sdq.cip.ConstantsContainer.COMPLETION_DEFAULT_PROJECT_ID);
		outputPathField.addModifyListener(modifyListener);

		/** Clear group*/
		final Group clearGroup = new Group(mainComponent, SWT.NONE);
		clearGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		clearGroup.setText("Generated models");
		clearGroup.setLayout(new GridLayout());
		clearButton = new Button(clearGroup,
				SWT.CHECK);
		clearButton.setLayoutData( new GridData(SWT.LEFT, SWT.CENTER, false, false, 4, 1));
		clearButton.setText("Delete generated models at simulation end");
		clearButton.setSelection(true);
		clearButton.addSelectionListener(new SelectionAdapter() {
			
			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				CipConfigTab.this.setDirty(true);
				CipConfigTab.this.updateLaunchConfigurationDialog();
			}
		});
		
		/** Logging group*/
		final Group loggingGroup = new Group(mainComponent, SWT.NONE);
		loggingGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		loggingGroup.setText("QVT Logging");
		loggingGroup.setLayout(new GridLayout());
		checkLoggingButton = new Button(loggingGroup, SWT.CHECK);
		checkLoggingButton.setText("Enable verbose logging");
		checkLoggingButton.addSelectionListener(new SelectionAdapter() {
			
			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				CipConfigTab.this.setDirty(true);
				CipConfigTab.this.updateLaunchConfigurationDialog();
			}
		});
		checkLoggingButton.setSelection(false);
		
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
	
	@Override
	public String getName() {
		return "CIP Configuration";
	}
	
	@Override
	public Image getImage() {
		return RunConfigImages.getCompletionTabImage();
	}
	
	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			outputPathField.setText(configuration.getAttribute(
					ConstantsContainer.COMPLETION_PROJECT_ID, de.uka.ipd.sdq.cip.ConstantsContainer.COMPLETION_DEFAULT_PROJECT_ID));
		} catch (CoreException e) {
			//CipPlugin.errorLogger(getName(),"Location", e.getMessage());
		}
		try {
			clearButton.setSelection(configuration.getAttribute(
					ConstantsContainer.COMPLETION_DELETE_PLUGIN, true));
		} catch (CoreException e) {
			clearButton.setSelection(true);
		}
		try {
			checkLoggingButton.setSelection(configuration.getAttribute(
					ConstantsContainer.COMPLETION_QVT_VERBOSE_LOGGING, false));
		} catch (CoreException e) {
			checkLoggingButton.setSelection(false);
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(ConstantsContainer.COMPLETION_PROJECT_ID,
				outputPathField.getText());
		configuration.setAttribute(ConstantsContainer.COMPLETION_DELETE_PLUGIN,
				clearButton.getSelection());
		configuration.setAttribute(ConstantsContainer.COMPLETION_QVT_VERBOSE_LOGGING,
				checkLoggingButton.getSelection());
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {}
	
	public boolean isValid(ILaunchConfiguration launchConfig) {
		setErrorMessage(null);

		if (outputPathField.getText().equals("")){
			setErrorMessage("The output path location is not specified!");
			return false;
		}
		return true;
	}
	
	@Override
	public void activated(ILaunchConfigurationWorkingCopy workingCopy) {
		// Leave this method empty to prevent unnecessary invocation of
		// initializeFrom() and multiple resulting invocations of
		// performApply().
	}

	@Override
	public void deactivated(ILaunchConfigurationWorkingCopy workingCopy) {}

}

package de.uka.ipd.sdq.workflow.pcm.runconfig;


import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.uka.ipd.sdq.workflow.launchconfig.RunConfigImages;
import de.uka.ipd.sdq.workflow.launchconfig.RunConfigPlugin;
import de.uka.ipd.sdq.workflow.launchconfig.tabs.TabHelper;
import de.uka.ipd.sdq.workflow.pcm.ConstantsContainer;

/**Configuration of an analysis method.
 * Represents configuration settings which are independent of the solving method.
 *
 * @author groenda
 * @author Roman Andrej
 */
public class ConfigurationTab extends AbstractLaunchConfigurationTab {
	/** Title of the accuracy information group. */
	private static final String GROUP_ACCURACY_LABEL = "Accuracy influence analysis";
	/** Label for the accuracy influence analysis setting. */
	private static final String BUTTON_SIMULATE_ACCURACY_LABEL = "Analyse accuracy influence";
	/** Label of the file selection field for the accuracy information model file. */
	private static final String DEFAULT_ACCURACY_QUALITY_ANNOTATION_FILE_LABEL = "Quality Annotation File";

	/** Text field for name of the plug-in project containing temporary data. */
	protected Text temporaryLocationField;
	/** Label for the temporary data plug-in project name field. */
	private Label temporaryLocationLabel;
	/** Button stating if the default location should be selected. */
	protected Button defaultLocationButton;
	/** Button stating if the temporary data should be deleted after an analysis. */
	protected Button clearButton;
	/** Button used to enable/disable accuracy influence checking. */
	private Button simulateAccuracyButton;
	/** Text containing the location of the file containing quality annotations for PCM specifications. */
	private Text  textAccuracyQualityAnnotationFile;

	protected ModifyListener modifyListener;
	protected SelectionListener selectionListener;

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

		modifyListener = new ModifyListener(){

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				ConfigurationTab.this.setDirty(true);
				ConfigurationTab.this.updateLaunchConfigurationDialog();
			}
		};
		selectionListener = new SelectionAdapter() {

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				ConfigurationTab.this.setDirty(true);
				ConfigurationTab.this.updateLaunchConfigurationDialog();
			}
		};

		Composite container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout());

		// Create temporary data location section
		createTemporaryDataLocationSection(container);
		createDeleteTemporaryDataAfterAnalysisSection(container);
		createAccuracySection(container);

		// disabled widget
		setTemporaryLocationElementsEnabled(false);
	}

	/**Creates the section for the accuracy analysis.
	 * @param container Container in which teh elements are created.
	 */
	protected void createAccuracySection(Composite container) {
		// Create accuracy section
		final Group accuracyGroup = new Group(container, SWT.NONE);
		accuracyGroup.setText(GROUP_ACCURACY_LABEL);
		final GridData gd_accuracyGroup = new GridData(SWT.FILL, SWT.CENTER, true, false);
		accuracyGroup.setLayoutData(gd_accuracyGroup);
		accuracyGroup.setLayout(new GridLayout());
		simulateAccuracyButton = new Button(accuracyGroup, SWT.CHECK);
		simulateAccuracyButton.setLayoutData(gd_accuracyGroup);
		simulateAccuracyButton.setText(BUTTON_SIMULATE_ACCURACY_LABEL);
		simulateAccuracyButton.setSelection(false);
		simulateAccuracyButton.addSelectionListener(selectionListener);
		textAccuracyQualityAnnotationFile = new Text(accuracyGroup, SWT.SINGLE | SWT.BORDER);
		textAccuracyQualityAnnotationFile.setLayoutData(gd_accuracyGroup);
		textAccuracyQualityAnnotationFile.addModifyListener(modifyListener);
		TabHelper.createFileInputSection(accuracyGroup, modifyListener,
				DEFAULT_ACCURACY_QUALITY_ANNOTATION_FILE_LABEL,
				ConstantsContainer.ACCURACY_QUALITY_ANNOTATION_EXTENSION,
				textAccuracyQualityAnnotationFile, getShell(), ConstantsContainer.DEFAULT_ACCURACY_QUALITY_ANNOTATION_FILE);
	}

	/**Creates the section for the deletion of temporary data.
	 * @param container Container in which the elements are created.
	 */
	protected void createDeleteTemporaryDataAfterAnalysisSection(Composite container) {
		final Group clearGroup = new Group(container, SWT.NONE);
		clearGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		clearGroup.setText("Temporary Data");
		clearGroup.setLayout(new GridLayout());
		clearButton = new Button(clearGroup,
				SWT.CHECK);
		clearButton.setLayoutData( new GridData(SWT.LEFT, SWT.CENTER, false, false, 4, 1));
		clearButton.setText("Delete temporary data after analysis");
		clearButton.addSelectionListener(selectionListener);
	}

	/**Creates the section for the selection of the temporary data location.
	 * @param container Container in which the elements are created.
	 * @param modifyListener The lister to use on modifications.
	 */
	protected void createTemporaryDataLocationSection(Composite container) {
		final Group outputPathGroup = new Group(container, SWT.NONE);
		outputPathGroup.setText("Location of temporary data");
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 4;
		outputPathGroup.setLayout(gridLayout);
		final GridData gd_outputPathGroup = new GridData(SWT.FILL, SWT.CENTER, true, false);
		outputPathGroup.setLayoutData(gd_outputPathGroup);

		/** default temporary location button */
		defaultLocationButton = new Button(outputPathGroup,
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
				setTemporaryLocationElementsEnabled(!defaultLocationButton.getSelection());

				if (defaultLocationButton.getSelection() == true) {
					temporaryLocationField.setText(ConstantsContainer.DEFAULT_TEMPORARY_DATA_LOCATION);
				}
				ConfigurationTab.this.setDirty(true);
				ConfigurationTab.this.updateLaunchConfigurationDialog();
			}
		});

		temporaryLocationLabel = new Label(outputPathGroup, SWT.NONE);
		temporaryLocationLabel.setLayoutData(new GridData(48, SWT.DEFAULT));
		temporaryLocationLabel.setText("Location:");

		temporaryLocationField = new Text(outputPathGroup, SWT.BORDER);
		final GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true,
				false);
		gridData.widthHint = 20;
		temporaryLocationField.setLayoutData(gridData);
		temporaryLocationField.setText(ConstantsContainer.DEFAULT_TEMPORARY_DATA_LOCATION);
		temporaryLocationField.addModifyListener(modifyListener);
	}

	/**Set the enable-state for the elements in the temporary location section.
	 * @param enable
	 */
	private void setTemporaryLocationElementsEnabled(boolean enable) {
		temporaryLocationLabel.setEnabled(enable);
		temporaryLocationField.setEnabled(enable);
	}

	/**
	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#getName()
	 */
	public String getName() {
		return "Analysis Configuration";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#initializeFrom(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			temporaryLocationField.setText(configuration.getAttribute(
					ConstantsContainer.TEMPORARY_DATA_LOCATION, ConstantsContainer.DEFAULT_TEMPORARY_DATA_LOCATION));
			// set default selection button state
			if (temporaryLocationField.getText().equals(ConstantsContainer.DEFAULT_TEMPORARY_DATA_LOCATION)) {
				defaultLocationButton.setSelection(true);
				setTemporaryLocationElementsEnabled(false);
			} else {
				defaultLocationButton.setSelection(false);
				setTemporaryLocationElementsEnabled(true);
			}
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),"Temporary Location Settings", e.getMessage());
			defaultLocationButton.setSelection(true);
		}
		try {
			clearButton
					.setSelection(configuration
							.getAttribute(
									ConstantsContainer.DELETE_TEMPORARY_DATA_AFTER_ANALYSIS,
									ConstantsContainer.DEFAULT_DELETE_TEMPORARY_DATA_AFTER_ANALYSIS));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(), "Delete temporaray data after analysis.", e.getMessage());
		}
		try {
			simulateAccuracyButton.setSelection(configuration.getAttribute(
					ConstantsContainer.ANALYSE_ACCURACY,
					ConstantsContainer.DEFAULT_ANALYSE_ACCURACY));
			textAccuracyQualityAnnotationFile.setText(configuration.getAttribute(
					ConstantsContainer.ACCURACY_QUALITY_ANNOTATION_FILE,
					ConstantsContainer.DEFAULT_ACCURACY_QUALITY_ANNOTATION_FILE));
		} catch (CoreException e) {
			simulateAccuracyButton.setSelection(ConstantsContainer.DEFAULT_ANALYSE_ACCURACY);
			textAccuracyQualityAnnotationFile.setText(ConstantsContainer.DEFAULT_ACCURACY_QUALITY_ANNOTATION_FILE);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(ConstantsContainer.TEMPORARY_DATA_LOCATION,
				temporaryLocationField.getText());
		configuration.setAttribute(
				ConstantsContainer.DELETE_TEMPORARY_DATA_AFTER_ANALYSIS,
				clearButton.getSelection());
		configuration.setAttribute(ConstantsContainer.ANALYSE_ACCURACY,
				this.simulateAccuracyButton.getSelection());
		configuration.setAttribute(
				ConstantsContainer.ACCURACY_QUALITY_ANNOTATION_FILE,
				this.textAccuracyQualityAnnotationFile.getText());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#setDefaults(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(ConstantsContainer.TEMPORARY_DATA_LOCATION,
				ConstantsContainer.DEFAULT_TEMPORARY_DATA_LOCATION);
		configuration
				.setAttribute(
						ConstantsContainer.DELETE_TEMPORARY_DATA_AFTER_ANALYSIS,
						ConstantsContainer.DEFAULT_DELETE_TEMPORARY_DATA_AFTER_ANALYSIS);
		configuration.setAttribute(ConstantsContainer.ANALYSE_ACCURACY,
				ConstantsContainer.DEFAULT_ANALYSE_ACCURACY);
		configuration.setAttribute(
				ConstantsContainer.ACCURACY_QUALITY_ANNOTATION_FILE,
				ConstantsContainer.DEFAULT_ACCURACY_QUALITY_ANNOTATION_FILE);
	}

	public boolean isValid(ILaunchConfiguration launchConfig) {
		setErrorMessage(null);

		if (temporaryLocationField.getText().equals("")){
			setErrorMessage("The location for temporary data is missing.");
			return false;
		}
		if (simulateAccuracyButton.getSelection() == true
				&& !TabHelper.validateFilenameExtension(
						textAccuracyQualityAnnotationFile.getText(),
						ConstantsContainer.ACCURACY_QUALITY_ANNOTATION_EXTENSION)) {
			setErrorMessage("Quality Annotation File must be present for accuracy influence analysis.");
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
	public void deactivated(ILaunchConfigurationWorkingCopy workingCopy) {
		// intentionally left blank
	}

}

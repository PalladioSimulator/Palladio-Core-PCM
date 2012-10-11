package de.uka.ipd.sdq.workflow.pcm.runconfig;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import de.uka.ipd.sdq.workflow.launchconfig.RunConfigPlugin;
import de.uka.ipd.sdq.workflow.launchconfig.tabs.TabHelper;
import de.uka.ipd.sdq.workflow.pcm.ConstantsContainer;

/**
 * Configuration of an analysis method. Represents configuration settings which
 * are independent of the solving method.
 * 
 * @author groenda
 * @author Roman Andrej
 */
public class ConfigurationTab extends AbstractConfigurationTab {

	/** Title of the accuracy information group. */
	private static final String GROUP_ACCURACY_LABEL = "Accuracy influence analysis";
	/** Label for the accuracy influence analysis setting. */
	private static final String BUTTON_SIMULATE_ACCURACY_LABEL = "Analyse accuracy influence";
	/**
	 * Label of the file selection field for the accuracy information model
	 * file.
	 */
	private static final String DEFAULT_ACCURACY_QUALITY_ANNOTATION_FILE_LABEL = "Quality Annotation File";

	/**
	 * Button stating if the temporary data should be deleted after an analysis.
	 */
	protected Button clearButton;
	/** Button used to enable/disable accuracy influence checking. */
	private Button simulateAccuracyButton;
	/**
	 * Text containing the location of the file containing quality annotations
	 * for PCM specifications.
	 */
	private Text textAccuracyQualityAnnotationFile;

	/**
	 * Creates the section for the accuracy analysis.
	 * 
	 * @param container
	 *            Container in which teh elements are created.
	 */
	protected void createAccuracySection(Composite container) {
		// Create accuracy section
		final Group accuracyGroup = new Group(container, SWT.NONE);
		accuracyGroup.setText(GROUP_ACCURACY_LABEL);
		final GridData gd_accuracyGroup = new GridData(SWT.FILL, SWT.CENTER,
				true, false);
		accuracyGroup.setLayoutData(gd_accuracyGroup);
		accuracyGroup.setLayout(new GridLayout());
		simulateAccuracyButton = new Button(accuracyGroup, SWT.CHECK);
		simulateAccuracyButton.setLayoutData(gd_accuracyGroup);
		simulateAccuracyButton.setText(BUTTON_SIMULATE_ACCURACY_LABEL);
		simulateAccuracyButton.setSelection(false);
		simulateAccuracyButton.addSelectionListener(selectionListener);
		textAccuracyQualityAnnotationFile = new Text(accuracyGroup, SWT.SINGLE
				| SWT.BORDER);
		textAccuracyQualityAnnotationFile.setLayoutData(gd_accuracyGroup);
		textAccuracyQualityAnnotationFile.addModifyListener(modifyListener);
		TabHelper.createFileInputSection(accuracyGroup, modifyListener,
				DEFAULT_ACCURACY_QUALITY_ANNOTATION_FILE_LABEL,
				ConstantsContainer.ACCURACY_QUALITY_ANNOTATION_EXTENSION,
				textAccuracyQualityAnnotationFile, getShell(),
				ConstantsContainer.DEFAULT_ACCURACY_QUALITY_ANNOTATION_FILE);
	}

	/**
	 * Creates the section for the deletion of temporary data.
	 * 
	 * @param container
	 *            Container in which the elements are created.
	 */
	protected void createDeleteTemporaryDataAfterAnalysisSection(
			Composite container) {
		final Group clearGroup = new Group(container, SWT.NONE);
		clearGroup
				.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		clearGroup.setText("Temporary Data");
		clearGroup.setLayout(new GridLayout());
		clearButton = new Button(clearGroup, SWT.CHECK);
		clearButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 4, 1));
		clearButton.setText("Delete temporary data after analysis");
		clearButton.addSelectionListener(selectionListener);
	}

	/**
	 * Derived classes may add further sections here.
	 * 
	 * @param container
	 *            Container in which the elements are created.
	 */
	protected void createFurtherSections(Composite container) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.ui.ILaunchConfigurationTab#initializeFrom(org.eclipse
	 * .debug.core.ILaunchConfiguration)
	 */
	public void initializeFrom(ILaunchConfiguration configuration) {
		super.initializeFrom(configuration);
		try {
			clearButton
					.setSelection(configuration
							.getAttribute(
									ConstantsContainer.DELETE_TEMPORARY_DATA_AFTER_ANALYSIS,
									ConstantsContainer.DEFAULT_DELETE_TEMPORARY_DATA_AFTER_ANALYSIS));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),
					"Delete temporaray data after analysis.", e.getMessage());
		}
		try {
			simulateAccuracyButton.setSelection(configuration.getAttribute(
					ConstantsContainer.ANALYSE_ACCURACY,
					ConstantsContainer.DEFAULT_ANALYSE_ACCURACY));
			textAccuracyQualityAnnotationFile
					.setText(configuration
							.getAttribute(
									ConstantsContainer.ACCURACY_QUALITY_ANNOTATION_FILE,
									ConstantsContainer.DEFAULT_ACCURACY_QUALITY_ANNOTATION_FILE));
		} catch (CoreException e) {
			simulateAccuracyButton
					.setSelection(ConstantsContainer.DEFAULT_ANALYSE_ACCURACY);
			textAccuracyQualityAnnotationFile
					.setText(ConstantsContainer.DEFAULT_ACCURACY_QUALITY_ANNOTATION_FILE);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(org.eclipse
	 * .debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		super.performApply(configuration);
		configuration.setAttribute(
				ConstantsContainer.DELETE_TEMPORARY_DATA_AFTER_ANALYSIS,
				clearButton.getSelection());
		configuration.setAttribute(ConstantsContainer.ANALYSE_ACCURACY,
				this.simulateAccuracyButton.getSelection());
		configuration.setAttribute(
				ConstantsContainer.ACCURACY_QUALITY_ANNOTATION_FILE,
				this.textAccuracyQualityAnnotationFile.getText());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.ui.ILaunchConfigurationTab#setDefaults(org.eclipse.
	 * debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		super.setDefaults(configuration);
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
		boolean tmp = super.isValid(launchConfig);

		if (simulateAccuracyButton.getSelection() == true
				&& !TabHelper
						.validateFilenameExtension(
								textAccuracyQualityAnnotationFile.getText(),
								ConstantsContainer.ACCURACY_QUALITY_ANNOTATION_EXTENSION)) {
			setErrorMessage("Quality Annotation File must be present for accuracy influence analysis.");
			return false;
		}
		return tmp;
	}

}

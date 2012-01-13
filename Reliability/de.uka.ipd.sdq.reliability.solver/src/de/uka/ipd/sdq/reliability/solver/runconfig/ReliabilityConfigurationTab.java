/**
 * 
 */
package de.uka.ipd.sdq.reliability.solver.runconfig;

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

import de.uka.ipd.sdq.workflow.launchconfig.tabs.TabHelper;
import de.uka.ipd.sdq.workflow.pcm.ConstantsContainer;
import de.uka.ipd.sdq.workflow.pcm.runconfig.ConfigurationTab;

/**
 * @author brosch
 *
 */
public class ReliabilityConfigurationTab extends ConfigurationTab {

	/** Title of the sensitivity analysis group. */
	private static final String GROUP_SENSITIVITY_LABEL = "Sensitivity analysis";
	/** Label for the sensitivity analysis setting. */
	private static final String BUTTON_SENSITIVITY_LABEL = "Perform sensitivity analysis";
	/** Label of the file selection field for the accuracy information model file. */
	private static final String DEFAULT_SENSITIVITY_FILE_LABEL = "Sensitivity Model File";

	/** Button used to enable/disable accuracy influence checking. */
	private Button sensitivityButton;
	/** Text containing the location of the file containing quality annotations for PCM specifications. */
	private Text  textSensitivityFile;

	/*
	 * (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.pcm.runconfig.ConfigurationTab#createFurtherSections(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void createFurtherSections(Composite container) {
		// Create sensitivity analysis section:
		final Group sensitivityGroup = new Group(container, SWT.NONE);
		sensitivityGroup.setText(GROUP_SENSITIVITY_LABEL);
		final GridData gd_sensitivityGroup = new GridData(SWT.FILL, SWT.CENTER, true, false);
		sensitivityGroup.setLayoutData(gd_sensitivityGroup);
		sensitivityGroup.setLayout(new GridLayout());
		sensitivityButton = new Button(sensitivityGroup, SWT.CHECK);
		sensitivityButton.setLayoutData(gd_sensitivityGroup);
		sensitivityButton.setText(BUTTON_SENSITIVITY_LABEL);
		sensitivityButton.setSelection(false);
		sensitivityButton.addSelectionListener(selectionListener);
		textSensitivityFile = new Text(sensitivityGroup, SWT.SINGLE | SWT.BORDER);
		textSensitivityFile.setLayoutData(gd_sensitivityGroup);
		textSensitivityFile.addModifyListener(modifyListener);
		TabHelper.createFileInputSection(sensitivityGroup, modifyListener,
				DEFAULT_SENSITIVITY_FILE_LABEL,
				ConstantsContainer.SENSITIVITY_ANALYSIS_EXTENSION,
				textSensitivityFile,
				getShell(),
				ConstantsContainer.DEFAULT_SENSITIVITY_MODEL_FILE);
	}

	/*
	 * (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.pcm.runconfig.ConfigurationTab#initializeFrom(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		super.initializeFrom(configuration);
		try {
			sensitivityButton.setSelection(configuration.getAttribute(
					ConstantsContainer.DO_SENSITIVITY_ANALYSIS,
					ConstantsContainer.DEFAULT_DO_SENSITIVITY_ANALYSIS));
			textSensitivityFile.setText(configuration.getAttribute(
					ConstantsContainer.SENSITIVITY_MODEL_FILE,
					ConstantsContainer.DEFAULT_SENSITIVITY_MODEL_FILE));
		} catch (CoreException e) {
			sensitivityButton.setSelection(ConstantsContainer.DEFAULT_DO_SENSITIVITY_ANALYSIS);
			textSensitivityFile.setText(ConstantsContainer.DEFAULT_SENSITIVITY_MODEL_FILE);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.pcm.runconfig.ConfigurationTab#isValid(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		if(!super.isValid(launchConfig)){
			return false;
		}
		if (sensitivityButton.getSelection() == true
				&& !TabHelper.validateFilenameExtension(
						textSensitivityFile.getText(),
						ConstantsContainer.SENSITIVITY_ANALYSIS_EXTENSION)) {
			setErrorMessage("Sensitivity Model File must be present for sensitivity analysis.");
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.pcm.runconfig.ConfigurationTab#performApply(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		super.performApply(configuration);
		configuration.setAttribute(ConstantsContainer.DO_SENSITIVITY_ANALYSIS,
				this.sensitivityButton.getSelection());
		configuration.setAttribute(
				ConstantsContainer.SENSITIVITY_MODEL_FILE,
				this.textSensitivityFile.getText());
	}

	/*
	 * (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.pcm.runconfig.ConfigurationTab#setDefaults(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		super.setDefaults(configuration);
		configuration.setAttribute(ConstantsContainer.DO_SENSITIVITY_ANALYSIS,
				ConstantsContainer.DEFAULT_DO_SENSITIVITY_ANALYSIS);
		configuration.setAttribute(
				ConstantsContainer.SENSITIVITY_MODEL_FILE,
				ConstantsContainer.DEFAULT_SENSITIVITY_MODEL_FILE);
	}

}

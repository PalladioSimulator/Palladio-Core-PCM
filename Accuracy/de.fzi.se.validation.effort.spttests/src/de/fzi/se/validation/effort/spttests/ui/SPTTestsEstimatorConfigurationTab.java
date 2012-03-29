package de.fzi.se.validation.effort.spttests.ui;


import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.fzi.se.validation.effort.spttests.SPTEstimatorConfiguration;
import de.fzi.se.validation.effort.spttests.SPTTestsEstimatorConstantsContainer;
import de.fzi.se.validation.effort.ui.AbstractEstimatorConfigurationTab;
import de.uka.ipd.sdq.workflow.launchconfig.RunConfigImages;
import de.uka.ipd.sdq.workflow.launchconfig.RunConfigPlugin;
import de.uka.ipd.sdq.workflow.pcm.runconfig.ConfigurationTab;

/**Launch configuration dialog tab for SPT-Tests validation effort estimation
 *
 * @author groenda
 *
 */
public class SPTTestsEstimatorConfigurationTab extends AbstractEstimatorConfigurationTab {
	private static final String NAME = "SPT-Tests Estimator";
	/** Label of the estimator group. */
	private static final String ESTIMATOR_GROUP_LABEL = "SPT(n)-Tests";
	/** Label of the parameter n. */
	private static final String N_LABEL = "n:";

	/** Repository file uri text field. */
	private Text nText;

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		Composite container = (Composite) getControl();

		// SPT-Tests group
		final Group estimatorGroup = new Group(container, SWT.NONE);
		estimatorGroup.setText(SPTTestsEstimatorConfigurationTab.ESTIMATOR_GROUP_LABEL);
		final GridData gd_estimatorGroup = new GridData(SWT.FILL, SWT.CENTER, true, false);
		estimatorGroup.setLayoutData(gd_estimatorGroup);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		estimatorGroup.setLayout(gridLayout);

		// Parameter n
		final Label n_label = new Label(estimatorGroup, SWT.NONE);
		n_label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		n_label.setText(SPTTestsEstimatorConfigurationTab.N_LABEL);
		nText = new Text(estimatorGroup, SWT.SINGLE | SWT.BORDER);
		nText.setEnabled(true);
		nText.setLayoutData(gd_estimatorGroup);
		nText.addModifyListener(modifyListener);

	}

	@Override
	public String getName() {
		return SPTTestsEstimatorConfigurationTab.NAME;
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			nText.setText(configuration.getAttribute(SPTTestsEstimatorConstantsContainer.N, SPTTestsEstimatorConstantsContainer.DEFAULT_N));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),"Error setting configuration. See error log for details.", e.getMessage());
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(SPTTestsEstimatorConstantsContainer.N, this.nText.getText());
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(SPTTestsEstimatorConstantsContainer.N, SPTTestsEstimatorConstantsContainer.DEFAULT_N);
	}

	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		setErrorMessage(null);

		if (nText.getText().equals("")) {
			setErrorMessage("A value for n is missing.");
			return false;
		}
		if (Integer.parseInt(nText.getText()) <= SPTEstimatorConfiguration.INVALID_N) {
			setErrorMessage("The value for n mus be greater or equal to " + SPTEstimatorConfiguration.INVALID_N + ".");
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

	@Override
	public Image getImage() {
		return RunConfigImages.getTabImage(ConfigurationTab.PLUGIN_ID,ConfigurationTab.CONFIGURATION_TAB_IMAGE_PATH);
	}

}

/**
 *
 */
package de.fzi.se.validation.effort.jjnpaths.ui;

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

import de.fzi.se.validation.effort.jjnpaths.JJnPathsEstimatorConstantsContainer;
import de.fzi.se.validation.effort.ui.AbstractEstimatorConfigurationTab;
import de.uka.ipd.sdq.workflow.launchconfig.RunConfigImages;
import de.uka.ipd.sdq.workflow.launchconfig.RunConfigPlugin;
import de.uka.ipd.sdq.workflow.pcm.runconfig.ConfigurationTab;

/**Launch configuration dialog tab for JJn-Paths validation effort estimation
 *
 * @author groenda
 *
 */
public class JJnPathsEstimatorConfigurationTab extends AbstractEstimatorConfigurationTab {
	private static final String NAME = "JJn-Paths Estimator";
	/** Label of the estimator group. */
	private static final String JJNPATHS_ESTIMATOR_GROUP_LABEL = "JJn-Paths";
	/** Label of the parameter n. */
	private static final String N_LABEL = "n:";

	/** Repository file uri text field. */
	private Text nText;

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		Composite container = (Composite) getControl();

		// JJn-Paths group
		final Group estimatorGroup = new Group(container, SWT.NONE);
		estimatorGroup.setText(JJnPathsEstimatorConfigurationTab.JJNPATHS_ESTIMATOR_GROUP_LABEL);
		final GridData gd_estimatorGroup = new GridData(SWT.FILL, SWT.CENTER, true, false);
		estimatorGroup.setLayoutData(gd_estimatorGroup);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		estimatorGroup.setLayout(gridLayout);

		// Parameter n
		final Label n_label = new Label(estimatorGroup, SWT.NONE);
		n_label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		n_label.setText(JJnPathsEstimatorConfigurationTab.N_LABEL);
		nText = new Text(estimatorGroup, SWT.SINGLE | SWT.BORDER);
		nText.setEnabled(true);
		nText.setLayoutData(gd_estimatorGroup);
		nText.addModifyListener(modifyListener);

	}

	@Override
	public String getName() {
		return JJnPathsEstimatorConfigurationTab.NAME;
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			nText.setText(configuration.getAttribute(JJnPathsEstimatorConstantsContainer.N, JJnPathsEstimatorConstantsContainer.DEFAULT_N));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),"Errors storing configuration. Please see error log for details.", e.getMessage());
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(JJnPathsEstimatorConstantsContainer.N, this.nText.getText());
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(JJnPathsEstimatorConstantsContainer.N, JJnPathsEstimatorConstantsContainer.DEFAULT_N);
	}

	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		setErrorMessage(null);

		if (nText.getText().equals("")) {
			setErrorMessage("A value for n is missing.");
			return false;
		}
		if (Integer.parseInt(nText.getText()) < 1) {
			setErrorMessage("The value for n must be greater or equal to 1.");
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

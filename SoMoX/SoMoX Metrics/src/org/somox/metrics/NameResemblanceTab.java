package org.somox.metrics;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class NameResemblanceTab extends MetricTab {
	
	protected Composite control;
	private Text percentageField;

	public void activated(ILaunchConfigurationWorkingCopy workingCopy) {

	}

	public boolean canSave() {
		return true;
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public void createControl(Composite parent) {
		control = new Composite(parent, SWT.NONE);
		control.setLayout(new GridLayout(2, false));
		{
			Label lblPercentag = new Label(control, SWT.NONE);
			lblPercentag.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			lblPercentag.setText("Percentage: ");
		}
		{
			percentageField = new Text(control, SWT.BORDER);
			percentageField.setText("80");
			percentageField.setToolTipText("Indicates how many percent of two class names need to resemble each other to have a name resemblance.");
			percentageField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		}
	}

	public void deactivated(ILaunchConfigurationWorkingCopy workingCopy) {

	}

	public void dispose() {
	}

	public Control getControl() {
		return control;
	}

	public String getErrorMessage() {
		return null;
	}
	
	public Image getImage() {
		return null;
	}

	public String getMessage() {
		return null;
	}

	@Override
	public String getName() {
		return "NameResemblance";
	}

	public void initializeFrom(ILaunchConfiguration configuration) {
		
	}

	public boolean isValid(ILaunchConfiguration launchConfig) {
		return true;
	}

	public void launched(ILaunch launch) {

	}

	public void performApply(ILaunchConfigurationWorkingCopy configuration) {

	}

	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
	}

	public void setLaunchConfigurationDialog(ILaunchConfigurationDialog dialog) {

	}
}

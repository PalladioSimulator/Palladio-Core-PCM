package org.somox.metrics;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.somox.analyzer.MetricTab;
import org.somox.analyzer.ModelAnalyzerTabGroupBlackboard;
import org.somox.core.SoMoXCoreLogger;

public class TestMetricTab extends MetricTab {
	
	protected Composite control;

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
		control.setLayout(new GridLayout(1, false));
		{
			Button btnButton = new Button(control, SWT.NONE);
			btnButton.addMouseListener(new MouseAdapter() {
				public void mouseDown(MouseEvent e) {
					
				}
			});
			btnButton.setText("InputFile");
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

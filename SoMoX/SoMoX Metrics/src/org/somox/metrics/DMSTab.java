package org.somox.metrics;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Tree;
import org.somox.analyzer.MetricTab;

public class DMSTab extends MetricTab {
	
	protected Composite control;
	private Group group;

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
			group = new Group(control, SWT.NONE);
			group.setLayout(new FillLayout(SWT.VERTICAL));
			{
				Button btnBlacklist = new Button(group, SWT.RADIO);
				btnBlacklist.setSelection(true);
				btnBlacklist.setText("Blacklist");
			}
			{
				Button btnWhitelist = new Button(group, SWT.RADIO);
				btnWhitelist.setText("Whitelist");
			}
		}
		{
			CheckboxTreeViewer checkboxTreeViewer = new CheckboxTreeViewer(control, SWT.BORDER);
			Tree tree = checkboxTreeViewer.getTree();
			tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
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
		return "DMS";
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

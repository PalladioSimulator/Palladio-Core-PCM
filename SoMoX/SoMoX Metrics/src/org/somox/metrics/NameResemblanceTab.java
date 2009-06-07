package org.somox.metrics;

import java.util.LinkedList;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;

public class NameResemblanceTab extends MetricTab {
	
	protected Composite control;
	private Text suffixText;
	private Text prefixText;
	private List prefixList;
	private List suffixList;

	public void activated(ILaunchConfigurationWorkingCopy workingCopy) {

	}

	public boolean canSave() {
		return true;
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public void createControl(Composite parent) {		
		control = new Composite(parent, SWT.BORDER);
		control.setLayout(new FillLayout(SWT.HORIZONTAL));
		{
			Group grpPrefixes = new Group(control, SWT.BORDER);
			grpPrefixes.setLayout(new FillLayout(SWT.VERTICAL));
			grpPrefixes.setText("Prefixes");
			{
				Composite composite = new Composite(grpPrefixes, SWT.NONE);
				{
					prefixList = new List(composite, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
					prefixList.setBounds(0, 0, 314, 205);
				}
			}
			{
				Composite composite = new Composite(grpPrefixes, SWT.NONE);
				GridLayout gridLayout = new GridLayout(2, false);
				gridLayout.verticalSpacing = 3;
				composite.setLayout(gridLayout);
				new Label(composite, SWT.NONE);
				{
					Button prefixRemoveButton = new Button(composite, SWT.NONE);
					prefixRemoveButton.addMouseListener(new MouseAdapter() {
						public void mouseDown(MouseEvent e) {
							prefixList.remove(prefixList.getFocusIndex());
						}
					});
					prefixRemoveButton.setText("Remove selected");
				}
				{
					prefixText = new Text(composite, SWT.BORDER);
					prefixText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
				}
				{
					Button prefixAddButton = new Button(composite, SWT.NONE);
					prefixAddButton.addMouseListener(new MouseAdapter() {
						public void mouseDown(MouseEvent e) {
							String text = prefixText.getText();
							if (text != null && !text.equals("")) {
								prefixList.add(text);
							}
						}
					});
					prefixAddButton.setText("Add prefix");
				}
			}
		}
		{
			Group grpSuffixes = new Group(control, SWT.BORDER);
			grpSuffixes.setLayout(new FillLayout(SWT.VERTICAL));
			grpSuffixes.setText("Suffixes");
			{
				Composite composite = new Composite(grpSuffixes, SWT.NONE);
				{
					suffixList = new List(composite, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
					suffixList.setBounds(0, 0, 314, 205);
				}
			}
			{
				Composite composite = new Composite(grpSuffixes, SWT.NONE);
				GridLayout gridLayout = new GridLayout(2, false);
				gridLayout.verticalSpacing = 3;
				composite.setLayout(gridLayout);
				new Label(composite, SWT.NONE);
				{
					Button suffixRemoveButton = new Button(composite, SWT.NONE);
					suffixRemoveButton.addMouseListener(new MouseAdapter() {
						public void mouseDown(MouseEvent e) {
							suffixList.remove(suffixList.getFocusIndex());
						}
					});
					suffixRemoveButton.setText("Remove selected");
				}
				{
					suffixText = new Text(composite, SWT.BORDER);
					suffixText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
				}
				{
					Button suffixAddButton = new Button(composite, SWT.NONE);
					suffixAddButton.addMouseListener(new MouseAdapter() {
						public void mouseDown(MouseEvent e) {
							String text = suffixText.getText();
							if (text != null && !text.equals("")) {
								suffixList.add(text);
							}
						}
					});
					suffixAddButton.setText("Add suffix");
				}
			}
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
		String[] prefixes = prefixList.getItems();
		String[] suffixes = prefixList.getItems();
		
		java.util.List<String> excludedPrefixes = new LinkedList<String>();
		java.util.List<String> excludedSuffixes = new LinkedList<String>();
		
		for (int i=0;i<prefixes.length;i++) {
			excludedPrefixes.add(prefixes[i]);
		}
		

		for (int i=0;i<suffixes.length;i++) {
			excludedSuffixes.add(suffixes[i]);
		}
		
		configuration.setAttribute("org.somox.metrics.nameResemblance.excludedPrefixes", excludedPrefixes);
		configuration.setAttribute("org.somox.metrics.nameResemblance.excludedSuffixes", excludedSuffixes);
	}

	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
	}

	public void setLaunchConfigurationDialog(ILaunchConfigurationDialog dialog) {

	}
}

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
import org.somox.analyzer.BlackboardListener;

import de.fzi.gast.core.Root;
import de.fzi.gast.types.GASTClass;

public class DMSTab extends MetricTab {
	
	private final String DELIMITER = "§";
	
	protected Composite control;
	private Group group;
	
	protected CheckboxTreeViewer checkboxTreeViewer;
	private Root root;
	private Button btnBlacklist, btnWhitelist;

	public void activated(ILaunchConfigurationWorkingCopy workingCopy) {

	}

	public boolean canSave() {
		return true;
	}
	
	public void setRoot (Root root) {
		if (this.root != root) {
			checkboxTreeViewer.getTree().dispose();
			checkboxTreeViewer = new CheckboxTreeViewer(control, SWT.BORDER);
			checkboxTreeViewer.setContentProvider(new CheckboxContentProvider());
			checkboxTreeViewer.setLabelProvider(new CheckboxLabelProvider());
			Tree tree = checkboxTreeViewer.getTree();
			tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		}
		this.root = root;
		//checkboxTreeViewer.setInput(this.root);
			
		if (this.root != null) {
			checkboxTreeViewer.setGrayed(this.root, true);
		}
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
				btnBlacklist = new Button(group, SWT.RADIO);
				btnBlacklist.setSelection(true);
				btnBlacklist.setText("Blacklist");
			}
			{
				btnWhitelist = new Button(group, SWT.RADIO);
				btnWhitelist.setText("Whitelist");
			}
		}
		{
			checkboxTreeViewer = new CheckboxTreeViewer(control, SWT.BORDER);
			checkboxTreeViewer.setContentProvider(new CheckboxContentProvider());
			checkboxTreeViewer.setLabelProvider(new CheckboxLabelProvider());
			Tree tree = checkboxTreeViewer.getTree();
			tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		}
		
		this.getModelAnalyzerTabGroupBlackboard().addBlackboardListener(new BlackboardListener() {

			public void blackboardChanged() {
				DMSTab.this.setRoot(DMSTab.this.getModelAnalyzerTabGroupBlackboard().getRoot());
			}
			
		});
		this.setRoot(this.getModelAnalyzerTabGroupBlackboard().getRoot());
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
		Object [] checked = checkboxTreeViewer.getCheckedElements();
		String [] wildcards = new String [checked.length];
		int i=0;
		for (Object current : checked) {
			if (current instanceof GASTClass) {
				wildcards[i] = ((GASTClass)current).getQualifiedName();
			} else if (current instanceof de.fzi.gast.core.Package) {
				wildcards[i] = ((de.fzi.gast.core.Package)current).getQualifiedName() + ".*";
			}
			i++;
		}
		
		StringBuffer buffer = new StringBuffer();
		for (i=0;i<wildcards.length;i++) {
			buffer.append(wildcards[i]);
			buffer.append(DELIMITER);
		}
		configuration.setAttribute("org.somox.metrics.dms.wildcards", buffer.toString());
		
		boolean blacklistIndicator = true;
		
		if (btnWhitelist.getSelection()) {
			blacklistIndicator = false;
		}
		
		configuration.setAttribute("org.somox.metrics.dms.blacklistIndicator", blacklistIndicator);
	}

	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
	}

	public void setLaunchConfigurationDialog(ILaunchConfigurationDialog dialog) {

	}
}

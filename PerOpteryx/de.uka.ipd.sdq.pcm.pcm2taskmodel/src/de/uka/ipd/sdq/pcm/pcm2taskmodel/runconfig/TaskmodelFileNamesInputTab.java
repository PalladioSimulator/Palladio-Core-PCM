package de.uka.ipd.sdq.pcm.pcm2taskmodel.runconfig;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import de.uka.ipd.sdq.dsexplore.launch.DSEConstantsContainer;
import de.uka.ipd.sdq.workflow.launchconfig.RunConfigPlugin;
import de.uka.ipd.sdq.workflow.launchconfig.tabs.FileNamesInputTab;
import de.uka.ipd.sdq.workflow.launchconfig.tabs.TabHelper;

public class TaskmodelFileNamesInputTab extends FileNamesInputTab {

	private Text textTaskModelFile;
	private Text textTaskModelResult;
	
	public static final String TASKMODEL_OUTPUT = "dsexplore.taskmodel.out";
	public static final String TASKMODEL_DEFAULT_OUTPUT = "C://tmp//result.taskmodel";
	private static final String DEFAULT_DESIGN_DECISION_FILE = "";
	private static final String DEFAULT_OUTPUT_TASKMODEL_FILE = TASKMODEL_DEFAULT_OUTPUT; 

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		
		final ModifyListener modifyListener = new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				TaskmodelFileNamesInputTab.this.setDirty(true);
				TaskmodelFileNamesInputTab.this.updateLaunchConfigurationDialog();
			}
		};
		
				
		this.textTaskModelFile = new Text(container, SWT.SINGLE | SWT.BORDER);
		String[] designDecisionExtension = DSEConstantsContainer.DESIGNDECISION_EXTENSION;
		TabHelper.createFileInputSection(container, modifyListener, "Design decision file", designDecisionExtension, textTaskModelFile, getShell(), DEFAULT_DESIGN_DECISION_FILE);
	
		this.textTaskModelResult = new Text(container, SWT.SINGLE | SWT.BORDER);
		String[] taskmodelExtension = {"*.taskmodel"};
		TabHelper.createFileInputSection(container, modifyListener, "Output taskmodel file", taskmodelExtension, textTaskModelResult, getShell(), DEFAULT_OUTPUT_TASKMODEL_FILE);

	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		super.setDefaults(configuration);
		
		this.textTaskModelResult.setText(TASKMODEL_DEFAULT_OUTPUT);
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		super.initializeFrom(configuration);
		
		try {
			this.textTaskModelFile.setText(configuration.getAttribute(
					DSEConstantsContainer.DESIGN_DECISION_FILE, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),DSEConstantsContainer.DESIGN_DECISION_FILE, e.getMessage());
		}
		
		try {
			this.textTaskModelResult.setText(configuration.getAttribute(
					TASKMODEL_OUTPUT, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),TASKMODEL_OUTPUT, e.getMessage());
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		super.performApply(configuration);
		
		configuration.setAttribute(
				DSEConstantsContainer.DESIGN_DECISION_FILE, 
				this.textTaskModelFile.getText());
		
		configuration.setAttribute(
				TASKMODEL_OUTPUT, 
				this.textTaskModelResult.getText());
	}

}

package de.uka.ipd.sdq.measurements.osscheduler.ui.tabs;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.navigator.ResourcePatternFilter;

import de.uka.ipd.sdq.measurements.osscheduler.ui.Constants;
import de.uka.ipd.sdq.workflow.launchconfig.RunConfigPlugin;

public class OSSchedulerMeasurementsConfigurationTab extends AbstractLaunchConfigurationTab {
	private Text measurementScriptFileText;
	private Text machineIPText;
	private Text machinePortText;
	private Composite composite;
	private Composite measurementScriptComposite;
	private Composite systemComposite;
	private StackLayout compositeStackLayout;
	private Button measurementScriptButton;
	private Button systemButton;

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		final ModifyListener modifyListener = new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				OSSchedulerMeasurementsConfigurationTab.this.setDirty(true);
				OSSchedulerMeasurementsConfigurationTab.this.updateLaunchConfigurationDialog();
			}
		};
		setControl(container);
		container.setLayout(new GridLayout(2, false));
		
		measurementScriptButton = new Button(container, SWT.RADIO);
		measurementScriptButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		measurementScriptButton.setText("Provide Measurement Script");
		measurementScriptButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (measurementScriptButton.getSelection() == true) {
					compositeStackLayout.topControl = measurementScriptComposite;
					composite.layout();
					OSSchedulerMeasurementsConfigurationTab.this.setDirty(true);
					OSSchedulerMeasurementsConfigurationTab.this.updateLaunchConfigurationDialog();
				}
			}
			
		});
		
		systemButton = new Button(container, SWT.RADIO);
		systemButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		systemButton.setText("Specify System");
		systemButton.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (systemButton.getSelection() == true) {
					compositeStackLayout.topControl = systemComposite;
					composite.layout();
					OSSchedulerMeasurementsConfigurationTab.this.setDirty(true);
					OSSchedulerMeasurementsConfigurationTab.this.updateLaunchConfigurationDialog();
				}
			}
			
		});
		
		
		composite = new Composite(container, SWT.NONE);
		compositeStackLayout = new StackLayout();
		compositeStackLayout.topControl = measurementScriptComposite;
		composite.setLayout(compositeStackLayout);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		
		measurementScriptComposite = new Composite(composite, SWT.NONE);
		measurementScriptComposite.setLayout(new GridLayout(3, false));
		
		Label lblMeasurementScript = new Label(measurementScriptComposite, SWT.NONE);
		lblMeasurementScript.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
		lblMeasurementScript.setText("Measurement Script:");
		
		measurementScriptFileText = new Text(measurementScriptComposite, SWT.BORDER);
		measurementScriptFileText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		measurementScriptFileText.addModifyListener(modifyListener);
		
		Button workspaceButton = new Button(measurementScriptComposite, SWT.NONE);
		workspaceButton.setText("Workspace...");
		workspaceButton.addSelectionListener(new WorkspaceButtonSelectionListener(
				measurementScriptFileText, Constants.MEASUREMENTSCRIPT_EXTENSION));
		
		Button fileSystemButton = new Button(measurementScriptComposite, SWT.NONE);
		fileSystemButton.setText("File System...");
		fileSystemButton.addSelectionListener(new FileSystemButtonSelectionAdapter(measurementScriptFileText,Constants.MEASUREMENTSCRIPT_EXTENSION));
		
		systemComposite = new Composite(composite, SWT.NONE);
		systemComposite.setLayout(new GridLayout(2, false));
		
		Label lblMachineIp = new Label(systemComposite, SWT.NONE);
		lblMachineIp.setText("Machine IP");
		
		machineIPText = new Text(systemComposite, SWT.BORDER);
		machineIPText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		machineIPText.addModifyListener(modifyListener);
		
		Label lblMachinePort = new Label(systemComposite, SWT.NONE);
		lblMachinePort.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblMachinePort.setText("Machine Port");
		
		machinePortText = new Text(systemComposite, SWT.BORDER);
		machinePortText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		machinePortText.addModifyListener(modifyListener);

		
	}

	@Override
	public String getName() {
		return "General";
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			measurementScriptFileText.setText(configuration.getAttribute(
					Constants.MEASUREMENTSCRIPT_FILE, ""));
			if (configuration.getAttribute(Constants.USE_MEASUREMENT_SCRIPT, "true").equals("true")) {
				measurementScriptButton.setSelection(true);
				compositeStackLayout.topControl = measurementScriptComposite;
				composite.layout();
			} else {
				systemButton.setSelection(true);
				compositeStackLayout.topControl = systemComposite;
				composite.layout();
			}
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),"Measurement Script File", e.getMessage());
		}		
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(Constants.MEASUREMENTSCRIPT_FILE, measurementScriptFileText.getText());
		configuration.setAttribute(Constants.MACHINE_IP, machineIPText.getText());
		configuration.setAttribute(Constants.MACHINE_PORT, machinePortText.getText());
		if (measurementScriptButton.getSelection()) {
			configuration.setAttribute(Constants.USE_MEASUREMENT_SCRIPT, "true");
		} else {
			configuration.setAttribute(Constants.USE_MEASUREMENT_SCRIPT, "false");
		}
		
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean canSave() {
		return true;
	}
	
	
class FileSystemButtonSelectionAdapter extends SelectionAdapter {
		
		private Text field;
		private String[] extensions;
		
		public FileSystemButtonSelectionAdapter(Text field, String[] fileExtension){
			this.field = field;
			this.extensions = fileExtension;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
		 */
		public void widgetSelected(SelectionEvent e) {
			setOpenFileDialogResultToTextField(this.field, this.extensions);
			setDirty(true);
			updateLaunchConfigurationDialog();
		}
	}


	/** Button SelectionListener - call a WorkspaceResourceDialog */
	class WorkspaceButtonSelectionListener extends SelectionAdapter {

		private Text field;
		private String extension;

		public WorkspaceButtonSelectionListener(Text field, String[] extensions) {
			this.field = field;
			this.extension = getExtensionFromArray(extensions);
		}

		/* (non-Javadoc)
		 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
		 */
		@Override
		public void widgetSelected(SelectionEvent e) {
			setOpenFileDialogResultToTextField(this.field, this.extension);
			setDirty(true);
			updateLaunchConfigurationDialog();
		}
	}
	
	private boolean validateFilePath(String filePath, String[] extensions){
		if (filePath.equals(""))
			return false;
		String extension = getExtensionFromArray(extensions).replace("*", ""); 
		if (filePath.contains(extension))
			return true;
		return false;
	}

	private String getExtensionFromArray(String[] array){
		return array[0];
	}
	
	/**
	 * Overloading of setOpenFileDialogResultToTextField because of different extensions types.
	 * 
	 * @param textField
	 * @param EXTENSION
	 */
	private void setOpenFileDialogResultToTextField(Text textField, final String EXTENSION) {
		String resultOpenFileDialog = openResourceDialog(EXTENSION);
		if (!resultOpenFileDialog.equals(new String(""))) {
			textField.setText(resultOpenFileDialog);			
		}
		// Otherwise the default value of textField would not be changed.
	}
	
	/**
	 * Get the result from the openFileDialog. If the result is "" then this method do
	 * not change the default value of the textField.
	 * 
	 * @param textField The Text-Field Control which contains the result of 
	 */
	private void setOpenFileDialogResultToTextField(Text textField, final String[] EXTENSION) {
		String resultOpenFileDialog = openFileDialog(EXTENSION);
		if (!resultOpenFileDialog.equals(new String(""))) {
			textField.setText(resultOpenFileDialog);
		}
		// Otherwise the default value of textField would not be changed.
	}
	
	/**
	 * The function calls the FileDialog and gives back absolute path on the file
	 * as String
	 * 
	 * @param extensions
	 *            which the dialog will use to filter the files it shows to the
	 *            argument
	 * @return absolute path to a file
	 */
	private String openFileDialog(String[] extensions) {
		String filename = "";
		
		FileDialog dialog = new FileDialog(getShell(), SWT.OPEN);
		dialog.setFilterExtensions(extensions);
		dialog.setText("Select model file");
		
		if (dialog.open() != null) {
			String root = dialog.getFilterPath() + File.separatorChar;
			filename = root + dialog.getFileName();	
		}	
		
		return filename;
	}

	/**
	 * The function calls the ContainerSelectionDialog and gives back relative to
	 * the workspace
	 * 
	 * @return relative path to file in workspace
	 */
	private String openResourceDialog(String extension) {
		
		/** Filter from the redundant files. */
		List<ViewerFilter> filters = new ArrayList<ViewerFilter>();
		ResourcePatternFilter filter = new ResourcePatternFilter();
		filter.setPatterns(new String[]{"*diagram","*.settings","*.project"});
		filters.add(filter);
		
		/** create the dialog message*/
		String msg = "Select a file (" + extension + ").";

		IFile file = null;

		IFile[] files = WorkspaceResourceDialog.openFileSelection(getShell(),
				null, msg, false, null, filters);
		
		if (files.length != 0)
			file = files[0];
		if (file != null)
			return file.getLocation().toOSString();
		
		return "";
	}

}

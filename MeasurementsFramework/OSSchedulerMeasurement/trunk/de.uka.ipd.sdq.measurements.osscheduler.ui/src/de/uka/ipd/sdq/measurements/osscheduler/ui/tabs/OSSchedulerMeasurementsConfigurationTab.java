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
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
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
		container.setLayout(new GridLayout(3, false));
		
		Label lblMeasurementScript = new Label(container, SWT.NONE);
		lblMeasurementScript.setText("Measurement Script:");
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		measurementScriptFileText = new Text(container, SWT.BORDER);
		measurementScriptFileText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		measurementScriptFileText.addModifyListener(modifyListener);
		
		Button btnWorkspace = new Button(container, SWT.NONE);
		btnWorkspace.addSelectionListener(new WorkspaceButtonSelectionListener(
				measurementScriptFileText, Constants.MEASUREMENTSCRIPT_EXTENSION));
		btnWorkspace.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		btnWorkspace.setText("Workspace...");
		
		Button btnFileSystem = new Button(container, SWT.NONE);
		btnFileSystem.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		btnFileSystem.setText("File System...");
		
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
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),"Measurement Script File", e.getMessage());
		}		
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		// TODO Auto-generated method stub
		
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

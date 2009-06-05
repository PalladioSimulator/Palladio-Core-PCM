package de.uka.ipd.sdq.pcmsolver.runconfig;

import java.io.File;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.emf.edit.ui.action.LoadResourceAction.LoadResourceDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class FileNameTab extends AbstractLaunchConfigurationTab {

	private Text textAllocation;
	private Text textRepository;
	private Text textResourceEnvironment;
	private Text textResourceType;
	private Text textSystem;
	private Text textUsage;
	private Text textOutput;
	
	private final String BUTTON_BROWSE = "Browse...";


	
	private Group inputFilesGroup = null;

	private FileNameTabListener listener = new FileNameTabListener();
	
	private class FileNameTabListener extends SelectionAdapter implements ModifyListener {
		public void modifyText(ModifyEvent e) {
			updateLaunchConfigurationDialog();
		}
	}
	
	
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout());
		
		final GridLayout glGroup = new GridLayout();
		glGroup.numColumns = 3;
		
		inputFilesGroup = new Group(container, SWT.NONE);
		inputFilesGroup.setLayout(glGroup);
		inputFilesGroup.setText("Input");
		inputFilesGroup.setLayoutData(new GridData(500, SWT.DEFAULT));
		createSelectIndividualFiles(container, inputFilesGroup);
		
		final Group outputFilesGroup = new Group(container, SWT.NONE);
		outputFilesGroup.setLayout(glGroup);
		outputFilesGroup.setText("Output");
		outputFilesGroup.setLayoutData(new GridData(500, SWT.DEFAULT));
		createSelectOutputFolder(outputFilesGroup);
		
	}
	
	private void createSelectOutputFolder(final Group outputFilesGroup) {
		Label outputFolderLabel = new Label(outputFilesGroup, SWT.NONE);
		outputFolderLabel.setText("Output Folder:");
		outputFolderLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		outputFolderLabel.setEnabled(false);
		
		textOutput = new Text(outputFilesGroup, SWT.SINGLE | SWT.BORDER);
		textOutput.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		textOutput.addModifyListener(listener);
		textOutput.setEnabled(false);
		
		
		final Button button1 = new Button(outputFilesGroup,	SWT.NONE);
		button1.setText(BUTTON_BROWSE);
		button1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				textOutput.setText(openDirectoryDialog(e));
			}
		});
		button1.setEnabled(false);
		
		
	}

	private void createSelectIndividualFiles(Composite container,
			final Group inputFilesGroup) {
		textAllocation = new Text(container, SWT.SINGLE | SWT.BORDER);
		createFolderSelector(inputFilesGroup, textAllocation, "Allocation:", "allocation");
		textRepository = new Text(container, SWT.SINGLE | SWT.BORDER);
		createFolderSelector(inputFilesGroup, textRepository, "Repository:", "repository");
		textResourceEnvironment = new Text(container, SWT.SINGLE | SWT.BORDER);
		createFolderSelector(inputFilesGroup, textResourceEnvironment, "Resource Environment:", "resourceenvironment");
		textResourceType = new Text(container, SWT.SINGLE | SWT.BORDER);
		createFolderSelector(inputFilesGroup, textResourceType, "Resource Type:", "resourcetype");
		textSystem = new Text(container, SWT.SINGLE | SWT.BORDER);
		createFolderSelector(inputFilesGroup, textSystem, "System:", "system");
		textUsage = new Text(container, SWT.SINGLE | SWT.BORDER);
		createFolderSelector(inputFilesGroup, textUsage, "Usage Model:", "usagemodel");
	}

	private void createFolderSelector(final Group inputFilesGroup, final Text text, String label, final String extension) {
		Label singleLabel = new Label(inputFilesGroup, SWT.NONE);
		singleLabel.setText(label);
		singleLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		
		text.setParent(inputFilesGroup);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		text.addModifyListener(listener);
		
		final Button button = new Button(inputFilesGroup,	SWT.NONE);
		button.setText(BUTTON_BROWSE);
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				text.setText(openResourceDialog());
			}
		});
		
	}


	protected String openResourceDialog() {
		LoadResourceDialog loadResourceDialog = new LoadResourceDialog(getShell());
		
		loadResourceDialog.open();
		return loadResourceDialog.getURIText();
	}

	public String getName() {
		return "File Names";
	}

	public void initializeFrom(ILaunchConfiguration configuration) {
		try{
			textAllocation.setText(configuration.getAttribute("inputAllocation", ""));
		} catch(CoreException e){
			textAllocation.setText("");
		}
		try{
			textRepository.setText(configuration.getAttribute("inputRepository", ""));
		} catch(CoreException e){
			textRepository.setText("");
		}
		try{
			textResourceEnvironment.setText(configuration.getAttribute("inputResourceEnvironment", ""));
		} catch(CoreException e){
			textResourceEnvironment.setText("");
		}
		try{
			textResourceType.setText(configuration.getAttribute("inputResourceType", ""));
		} catch(CoreException e){
			textResourceType.setText("");
		}
		try{
			textSystem.setText(configuration.getAttribute("inputSystem", ""));
		} catch(CoreException e){
			textSystem.setText("n/a");
		}
		try{
			textUsage.setText(configuration.getAttribute("inputUsage", ""));
		} catch(CoreException e){
			textUsage.setText("");
		}

		try{
			textOutput.setText(configuration.getAttribute("outputPath", ""));
		} catch(CoreException e){
			textOutput.setText("");
		}
		
	}

	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute("inputAllocation", textAllocation.getText());
		configuration.setAttribute("inputRepository", textRepository.getText());
		configuration.setAttribute("inputResourceEnvironment", textResourceEnvironment.getText());
		configuration.setAttribute("inputResourceType", textResourceType.getText());
		configuration.setAttribute("inputSystem", textSystem.getText());
		configuration.setAttribute("inputUsage", textUsage.getText());
		configuration.setAttribute("outputPath", textOutput.getText());
	}

	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
	}
	
	
	/**
	 * The function calls the FileDialog and give back absolute path on the file as String
	 * 
	 * @param shell which will be the parent of the new instance
	 * @param extensions which the dialog will use to filter the files it shows to the argument
	 * @return absolute path to a file
	 */
	private String openFileDialog(SelectionEvent e, String[] extensions) {

		Shell shell = e.display.getActiveShell();
		String filename = "";

		FileDialog dialog = new FileDialog(shell, SWT.OPEN);
		dialog.setFilterExtensions(extensions);
		dialog.setText("Select file");

		if (dialog.open() != null) {
			String root = dialog.getFilterPath() + File.separatorChar;
			filename = root + dialog.getFileName();
		}
		return filename;
	}
	
	private String openDirectoryDialog(SelectionEvent e){
		String dirname ="";
		Shell shell = e.display.getActiveShell();
		DirectoryDialog dialog = new DirectoryDialog(shell, SWT.OPEN);
		dialog.setText("Select folder");
		if (dialog.open() != null){
			dirname = dialog.getFilterPath();
		}
		return dirname;
	}

	
	public boolean isValid(ILaunchConfiguration launchConfig) {
	    setErrorMessage(null);

		if (textAllocation.getText().equals("")) {
			setErrorMessage("Allocation is missing!");
			return false;
		}
		if (textRepository.getText().equals("")) {
			setErrorMessage("Repository is missing!");
			return false;
		}
		if (textResourceEnvironment.getText().equals("")) {
			setErrorMessage("Resource environment is missing!");
			return false;
		}
		if (textResourceType.getText().equals("")) {
			setErrorMessage("Resource type is missing!");
			return false;
		}
		if (textSystem.getText().equals("")) {
			setErrorMessage("System is missing!");
			return false;
		}
		if (textUsage.getText().equals("")) {
			setErrorMessage("Usage is missing!");
			return false;
		}
	    
	    
//	    if (textOutput.getText().equals("")){
//	    	setErrorMessage("Output path is missing!");
//	    	return false;
//	    }
	    // TODO
	    return true;
	}
	
}

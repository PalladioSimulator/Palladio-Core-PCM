package de.uka.ipd.sdq.workflow.launchconfig.tabs;

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
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.navigator.ResourcePatternFilter;

import de.uka.ipd.sdq.workflow.launchconfig.ConstantsContainer;
import de.uka.ipd.sdq.workflow.launchconfig.RunConfigImages;
import de.uka.ipd.sdq.workflow.launchconfig.RunConfigPlugin;

/**
 * The class defines a tab, which is responsible for the input of an instance of
 * the Palladio Component Model.
 * 
 * @author Roman Andrej
 */
public class FileNamesInputTab extends AbstractLaunchConfigurationTab {

	private static final String PCM_GLASSFISHREPOSITORY_FILE_URI = "pathmap://PCM_MODELS/Glassfish.repository";
	private static final String PCM_RESOURCETYPE_FILE_URI = "pathmap://PCM_MODELS/Palladio.resourcetype";
	
	/** input fields */
	private Text textResourceType;
	private Text textResourceEnvironment;
	private Text textRepository;
	private Text textSystem;
	private Text textAllocation;
	private Text textUsage;
	private Text mwtextRepository;
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#getImage()
	 */
	public Image getImage() {
		return RunConfigImages.getFileNamesTabImage();
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
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		final ModifyListener modifyListener = new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				FileNamesInputTab.this.setDirty(true);
				FileNamesInputTab.this.updateLaunchConfigurationDialog();
			}
		};

		Composite container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout());

		/**
		 * Create resource type section
		 */
		textResourceType = new Text(container, SWT.SINGLE | SWT.BORDER);
		createFileInputSection(container, modifyListener, "Resource Type File", ConstantsContainer.RESOURCETYPE_EXTENSION, textResourceType);

		/**
		 * Create resource environment section
		 */
		textResourceEnvironment = new Text(container, SWT.SINGLE | SWT.BORDER);
		createFileInputSection(container, modifyListener, "Resource Environment File", ConstantsContainer.RESOURCEENVIRONMENT_EXTENSION, textResourceEnvironment);

		/**
		 * Create repository section
		 */
		textRepository = new Text(container, SWT.SINGLE | SWT.BORDER);
		createFileInputSection(container, modifyListener, "Repository File", ConstantsContainer.REPOSITORY_EXTENSION, textRepository);

		/**
		 * Create MW repository section
		 */
		mwtextRepository = new Text(container, SWT.SINGLE | SWT.BORDER);
		createFileInputSection(container, modifyListener, "Middleware Repository File", ConstantsContainer.REPOSITORY_EXTENSION, mwtextRepository);

		/**
		 * Create system Section
		 */
		textSystem = new Text(container, SWT.SINGLE | SWT.BORDER);
		createFileInputSection(container, modifyListener, "System File", ConstantsContainer.SYSTEM_EXTENSION, textSystem);
		
		/**
		 * Create allocation section
		 */
		textAllocation = new Text(container, SWT.SINGLE | SWT.BORDER);
		createFileInputSection(container, modifyListener, "Allocation File", ConstantsContainer.ALLOCATION_EXTENSION, textAllocation);
		
		/**
		 * Create usage section
		 */
		//First set the text like this, will be changed to the right parent in createFileInputSection
		textUsage = new Text(container, SWT.SINGLE | SWT.BORDER);
		createFileInputSection(container, modifyListener, "Usage File", ConstantsContainer.USAGEMODEL_EXTENSION, textUsage);
	}
	
	/**
	 * Creates a section in the parent container for selection files. Creates a {@link Group} with a label. Inside the group, a text field for the file with the given extension, a button to load from the workspace and a button to load from the file system are displayed. 
	 * @param container The parent container
	 * @param modifyListener The listener for modifications
	 * @param modelFileLabel The label of the section around the file input text field 
	 * @param fileExtension The extensions to load 
	 * @param textFileNameToLoad The text field that contains the filename. Its parent will be reset to the appropriate group within this method. 
	 */
	public void createFileInputSection(final Composite container, final ModifyListener modifyListener, final String modelFileLabel,  final String[] fileExtension, Text textFileNameToLoad){

		final Group fileInputGroup = new Group(container, SWT.NONE);
		final GridLayout glFileInputGroup = new GridLayout();
		glFileInputGroup.numColumns = 3;
		fileInputGroup.setLayout(glFileInputGroup);
		fileInputGroup.setText(modelFileLabel); //The group name
		fileInputGroup
				.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		textFileNameToLoad.setParent(fileInputGroup);
		final GridData gd_textFileName = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gd_textFileName.widthHint = 200;
		textFileNameToLoad
				.setLayoutData(gd_textFileName);
		textFileNameToLoad.addModifyListener(modifyListener);

		final Button workspaceButton_4 = new Button(fileInputGroup, SWT.NONE);
		workspaceButton_4.setText("Workspace...");
		workspaceButton_4
				.addSelectionListener(new WorkspaceButtonSelectionListener(
						textFileNameToLoad, fileExtension));
		
		final Button buttonUsage = new Button(fileInputGroup, SWT.NONE);
		buttonUsage.setText("File System...");
		buttonUsage.addSelectionListener(new FileSystemButtonSelectionAdapter(textFileNameToLoad,fileExtension));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#getName()
	 */
	public String getName() {
		return "Models file";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#initializeFrom(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			textAllocation.setText(configuration.getAttribute(
					ConstantsContainer.ALLOCATION_FILE, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),"Allocation File", e.getMessage());
		}

		try {
			textRepository.setText(configuration.getAttribute(
					ConstantsContainer.REPOSITORY_FILE, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),"Repository File", e.getMessage());
		}

		try {
			mwtextRepository.setText(configuration.getAttribute(
					ConstantsContainer.MWREPOSITORY_FILE, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),"Middleware Repository File", e.getMessage());
		}

		try {
			textResourceType.setText(configuration.getAttribute(
					ConstantsContainer.RESOURCETYPEREPOSITORY_FILE, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),"Resource Type File", e.getMessage());
		}

		try {
			textResourceEnvironment.setText(configuration.getAttribute(
					ConstantsContainer.RESOURCEENVIRONMENT_FILE, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),"Resource Environment File", e.getMessage());
		}

		try {
			textSystem.setText(configuration.getAttribute(
					ConstantsContainer.SYSTEM_FILE, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),"System File", e.getMessage());
		}

		try {
			textUsage.setText(configuration.getAttribute(
					ConstantsContainer.USAGE_FILE, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),"Usage File", e.getMessage());
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				ConstantsContainer.RESOURCETYPEREPOSITORY_FILE,
				textResourceType.getText());
		configuration.setAttribute(
				ConstantsContainer.RESOURCEENVIRONMENT_FILE,
				textResourceEnvironment.getText());
		configuration.setAttribute(ConstantsContainer.REPOSITORY_FILE,
				textRepository.getText());
		configuration.setAttribute(ConstantsContainer.MWREPOSITORY_FILE,
				mwtextRepository.getText());
		configuration.setAttribute(ConstantsContainer.SYSTEM_FILE, textSystem
				.getText());
		configuration.setAttribute(ConstantsContainer.ALLOCATION_FILE,
				textAllocation.getText());
		configuration.setAttribute(ConstantsContainer.USAGE_FILE, textUsage
				.getText());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#setDefaults(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(ConstantsContainer.RESOURCETYPEREPOSITORY_FILE,
			PCM_RESOURCETYPE_FILE_URI);
		configuration.setAttribute(ConstantsContainer.MWREPOSITORY_FILE,
			PCM_GLASSFISHREPOSITORY_FILE_URI);
	}

	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#isValid(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		setErrorMessage(null);

		if (!validateFilePath(textRepository.getText(),
				ConstantsContainer.REPOSITORY_EXTENSION)) {
			setErrorMessage("Repository is missing!");
			return false;
		}
		if (!validateFilePath(mwtextRepository.getText(),
				ConstantsContainer.REPOSITORY_EXTENSION)) {
			setErrorMessage("Middleware Repository is missing!");
			return false;
		}
		if (!validateFilePath(textResourceType.getText(),
				ConstantsContainer.RESOURCETYPE_EXTENSION)) {
			setErrorMessage("ResourceTypeRepository is missing!");
			return false;
		}
		if (!validateFilePath(textResourceEnvironment.getText(),
				ConstantsContainer.RESOURCEENVIRONMENT_EXTENSION)) {
			setErrorMessage("ResourceEnvironment is missing!");
			return false;
		}
		if (!validateFilePath(textSystem.getText(),
				ConstantsContainer.SYSTEM_EXTENSION)) {
			setErrorMessage("System is missing!");
			return false;
		}
		if (!validateFilePath(textAllocation.getText(),
				ConstantsContainer.ALLOCATION_EXTENSION)) {
			setErrorMessage("Allocation is missing!");
			return false;
		}
		if (!validateFilePath(textUsage.getText(),
				ConstantsContainer.USAGEMODEL_EXTENSION)) {
			setErrorMessage("Usage is missing!");
			return false;
		}
		return true;
	}

	@Override
	public boolean canSave() {
		return true;
	}
	
	@Override
	public void activated(ILaunchConfigurationWorkingCopy workingCopy) {
		// Leave this method empty to prevent unnecessary invocation of
		// initializeFrom() and multiple resulting invocations of
		// performApply().
	}

	@Override
	public void deactivated(ILaunchConfigurationWorkingCopy workingCopy) {}
	
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


	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#getId()
	 */
	@Override
	public String getId() {
		return "de.uka.ipd.sdq.codegen.runconfig.tabs.FileNamesInputTab";
	}
}

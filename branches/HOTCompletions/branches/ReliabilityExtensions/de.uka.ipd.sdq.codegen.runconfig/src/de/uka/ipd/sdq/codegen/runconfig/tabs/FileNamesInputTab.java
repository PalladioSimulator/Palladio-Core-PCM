package de.uka.ipd.sdq.codegen.runconfig.tabs;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;

import de.uka.ipd.sdq.codegen.runconfig.RunConfigImages;
import de.uka.ipd.sdq.codegen.runconfig.RunConfigPlugin;

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
	 * Overloading of setOpenFileDialogResultToTextField because of different extension types.
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
		final Group repositoryTypeGroup = new Group(container, SWT.NONE);
		final GridLayout glReposetoryTypeGroup = new GridLayout();
		glReposetoryTypeGroup.numColumns = 3;
		repositoryTypeGroup.setLayout(glReposetoryTypeGroup);
		repositoryTypeGroup.setText("Resource Type File");
		repositoryTypeGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false));

		textResourceType = new Text(repositoryTypeGroup, SWT.SINGLE
				| SWT.BORDER);
		final GridData gd_textResourceTypeRepository = new GridData(SWT.FILL,
				SWT.CENTER, true, false);
		gd_textResourceTypeRepository.widthHint = 200;
		textResourceType.setLayoutData(gd_textResourceTypeRepository);
		textResourceType.addModifyListener(modifyListener);

		final Button workspaceButton = new Button(repositoryTypeGroup, SWT.NONE);
		workspaceButton.setText("Workspace...");
		workspaceButton
				.addSelectionListener(new WorkspaceButtonSelectionListener(
						textResourceType, ConstantsContainer.RESOURCETYPE_EXTENSION));

		final Button buttonResourceTypeRepository = new Button(
				repositoryTypeGroup, SWT.NONE);
		buttonResourceTypeRepository.setLayoutData(new GridData());
		buttonResourceTypeRepository.setText("File System...");
		buttonResourceTypeRepository
				.addSelectionListener(new SelectionAdapter() {
					
					/* (non-Javadoc)
					 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
					 */
					public void widgetSelected(SelectionEvent e) {
						setOpenFileDialogResultToTextField(textResourceType, ConstantsContainer.RESOURCETYPE_EXTENSION);
					}
				});

		/**
		 * Create resource environment section
		 */
		final Group repositoryEnvironmentGroup = new Group(container, SWT.NONE);
		final GridLayout glReposetoryEnvironmentGroup = new GridLayout();
		glReposetoryEnvironmentGroup.numColumns = 3;
		repositoryEnvironmentGroup.setLayout(glReposetoryEnvironmentGroup);
		repositoryEnvironmentGroup.setText("Resource Environment File");
		repositoryEnvironmentGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false));

		textResourceEnvironment = new Text(repositoryEnvironmentGroup, SWT.SINGLE
				| SWT.BORDER);
		final GridData gd_textResourceEnvironmentRepository = new GridData(SWT.FILL,
				SWT.CENTER, true, false);
		gd_textResourceEnvironmentRepository.widthHint = 200;
		textResourceEnvironment.setLayoutData(gd_textResourceEnvironmentRepository);
		textResourceEnvironment.addModifyListener(modifyListener);

		final Button workspaceButton_0 = new Button(repositoryEnvironmentGroup, SWT.NONE);
		workspaceButton_0.setText("Workspace...");
		workspaceButton_0
				.addSelectionListener(new WorkspaceButtonSelectionListener(
						textResourceEnvironment, ConstantsContainer.RESOURCEENVIRONMENT_EXTENSION));

		final Button buttonResourceEnvironmentRepository = new Button(
				repositoryEnvironmentGroup, SWT.NONE);
		buttonResourceEnvironmentRepository.setLayoutData(new GridData());
		buttonResourceEnvironmentRepository.setText("File System...");
		buttonResourceEnvironmentRepository
				.addSelectionListener(new SelectionAdapter() {
					
					/* (non-Javadoc)
					 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
					 */
					public void widgetSelected(SelectionEvent e) {
						setOpenFileDialogResultToTextField(textResourceEnvironment, ConstantsContainer.RESOURCEENVIRONMENT_EXTENSION);
					}
				});

		/**
		 * Create repository section
		 */
		final Group repositoryGroup = new Group(container, SWT.NONE);
		final GridLayout glReposetoryGroup = new GridLayout();
		glReposetoryGroup.numColumns = 3;
		repositoryGroup.setLayout(glReposetoryGroup);
		repositoryGroup.setText("Repository File");
		repositoryGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false));

		textRepository = new Text(repositoryGroup, SWT.SINGLE | SWT.BORDER);
		final GridData gd_textRepository = new GridData(SWT.FILL, SWT.CENTER, true,
				false);
		gd_textRepository.widthHint = 200;
		textRepository.setLayoutData(gd_textRepository);
		textRepository.addModifyListener(modifyListener);

		final Button workspaceButton_1 = new Button(repositoryGroup, SWT.NONE);
		workspaceButton_1.setText("Workspace...");
		workspaceButton_1
				.addSelectionListener(new WorkspaceButtonSelectionListener(
						textRepository, ConstantsContainer.REPOSITORY_EXTENSION));

		final Button buttonRepository = new Button(repositoryGroup, SWT.NONE);
		buttonRepository.setText("File System...");
		buttonRepository.addSelectionListener(new SelectionAdapter() {

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				setOpenFileDialogResultToTextField(textRepository, ConstantsContainer.REPOSITORY_EXTENSION);
			}
		});

		/**
		 * Create MW repository section
		 */
		final Group mwrepositoryGroup = new Group(container, SWT.NONE);
		final GridLayout mwglReposetoryGroup = new GridLayout();
		mwglReposetoryGroup.numColumns = 3;
		mwrepositoryGroup.setLayout(mwglReposetoryGroup);
		mwrepositoryGroup.setText("Middleware Repository File");
		mwrepositoryGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false));

		mwtextRepository = new Text(mwrepositoryGroup, SWT.SINGLE | SWT.BORDER);
		final GridData mwgd_textRepository = new GridData(SWT.FILL, SWT.CENTER, true,
				false);
		mwgd_textRepository.widthHint = 200;
		mwtextRepository.setLayoutData(mwgd_textRepository);
		mwtextRepository.addModifyListener(modifyListener);

		final Button mwworkspaceButton_1 = new Button(mwrepositoryGroup, SWT.NONE);
		mwworkspaceButton_1.setText("Workspace...");
		mwworkspaceButton_1
				.addSelectionListener(new WorkspaceButtonSelectionListener(
						mwtextRepository, ConstantsContainer.REPOSITORY_EXTENSION));

		final Button mwbuttonRepository = new Button(mwrepositoryGroup, SWT.NONE);
		mwbuttonRepository.setText("File System...");
		mwbuttonRepository.addSelectionListener(new SelectionAdapter() {

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				setOpenFileDialogResultToTextField(mwtextRepository, ConstantsContainer.REPOSITORY_EXTENSION);
			}
		});

		/**
		 * Create system Section
		 */
		final Group systemGroup = new Group(container, SWT.NONE);
		final GridLayout glFileGroup = new GridLayout();
		glFileGroup.numColumns = 3;
		systemGroup.setLayout(glFileGroup);
		systemGroup.setText("System File");
		systemGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false));

		textSystem = new Text(systemGroup, SWT.SINGLE | SWT.BORDER);
		final GridData gd_textSystem = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gd_textSystem.widthHint = 200;
		textSystem
				.setLayoutData(gd_textSystem);
		textSystem.addModifyListener(modifyListener);

		final Button workspaceButton_2 = new Button(systemGroup, SWT.NONE);
		workspaceButton_2.setText("Workspace...");
		workspaceButton_2
				.addSelectionListener(new WorkspaceButtonSelectionListener(
						textSystem, ConstantsContainer.SYSTEM_EXTENSION));

		final Button buttonSystem = new Button(systemGroup, SWT.NONE);
		buttonSystem.setText("File System...");
		buttonSystem.addSelectionListener(new SelectionAdapter() {

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				setOpenFileDialogResultToTextField(textSystem, ConstantsContainer.SYSTEM_EXTENSION);
			}
		});

		/**
		 * Create allocation section
		 */
		final Group allocationGroup = new Group(container, SWT.NONE);
		final GridLayout dlAllocationGroup = new GridLayout();
		dlAllocationGroup.numColumns = 3;
		allocationGroup.setLayout(dlAllocationGroup);
		allocationGroup.setText("Allocation File");
		allocationGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false));

		textAllocation = new Text(allocationGroup, SWT.SINGLE | SWT.BORDER);
		final GridData gd_textAllocation = new GridData(SWT.FILL, SWT.CENTER, true,
				false);
		gd_textAllocation.widthHint = 200;
		textAllocation.setLayoutData(gd_textAllocation);
		textAllocation.addModifyListener(modifyListener);

		final Button workspaceButton_3 = new Button(allocationGroup, SWT.NONE);
		workspaceButton_3.setText("Workspace...");
		workspaceButton_3
				.addSelectionListener(new WorkspaceButtonSelectionListener(
						textAllocation, ConstantsContainer.ALLOCATION_EXTENSION));

		final Button buttonAllocation = new Button(allocationGroup, SWT.NONE);
		buttonAllocation.setText("File System...");
		buttonAllocation.addSelectionListener(new SelectionAdapter() {
			
			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				setOpenFileDialogResultToTextField(textAllocation, ConstantsContainer.ALLOCATION_EXTENSION);
			}
		});

		/**
		 * Create usage section
		 */
		final Group usageGroup = new Group(container, SWT.NONE);
		final GridLayout glUsageGroup = new GridLayout();
		glUsageGroup.numColumns = 3;
		usageGroup.setLayout(glUsageGroup);
		usageGroup.setText("Usage File");
		usageGroup
				.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		textUsage = new Text(usageGroup, SWT.SINGLE | SWT.BORDER);
		final GridData gd_textUsage = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gd_textUsage.widthHint = 200;
		textUsage
				.setLayoutData(gd_textUsage);
		textUsage.addModifyListener(modifyListener);

		final Button workspaceButton_4 = new Button(usageGroup, SWT.NONE);
		workspaceButton_4.setText("Workspace...");
		workspaceButton_4
				.addSelectionListener(new WorkspaceButtonSelectionListener(
						textUsage, ConstantsContainer.USAGEMODEL_EXTENSION));

		final Button buttonUsage = new Button(usageGroup, SWT.NONE);
		buttonUsage.setText("File System...");
		buttonUsage.addSelectionListener(new SelectionAdapter() {

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				setOpenFileDialogResultToTextField(textUsage, ConstantsContainer.USAGEMODEL_EXTENSION);
				updateLaunchConfigurationDialog();
			}
		});
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#getName()
	 */
	public String getName() {
		return "Model Files";
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
			setOpenFileDialogResultToTextField(field, extension);
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

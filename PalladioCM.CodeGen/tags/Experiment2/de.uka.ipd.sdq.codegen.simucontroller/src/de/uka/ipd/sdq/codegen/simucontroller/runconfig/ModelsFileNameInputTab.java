package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

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
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;

/**
 * @author roman
 */
public class ModelsFileNameInputTab extends AbstractLaunchConfigurationTab {

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#getImage()
	 */
	public Image getImage() {
		return ResourceManagerTab.getModelsListImage();
	}

	/**
	 * Set the file extensions which the dialog will use to filter the files it
	 * shows to the argument.
	 */
	private final String[] RESOURCETYPE_EXTENSION = new String[] { "*.resourcetype" };
	private final String[] REPOSITORY_EXTENSION = new String[] { "*.repository" };
	private final String[] SYSTEM_EXTENSION = new String[] { "*.system" };
	private final String[] ALLOCATION_EXTENSION = new String[] { "*.allocation" };
	private final String[] USAGEMODEL_EXTENSION = new String[] { "*.usagemodel" };

	private Text textResourceType;
	private Text textRepository;
	private Text textSystem;
	private Text textAllocation;
	private Text textUsage;

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		final ModifyListener modifyListener = new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				ModelsFileNameInputTab.this.setDirty(true);
				ModelsFileNameInputTab.this.updateLaunchConfigurationDialog();
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
				.addSelectionListener(new WorkspaseButtonSelectionListener(
						textResourceType, RESOURCETYPE_EXTENSION));

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
						textResourceType
								.setText(openFileDialog(RESOURCETYPE_EXTENSION));
					}
				});

		/**
		 * Create reposetory section
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
				.addSelectionListener(new WorkspaseButtonSelectionListener(
						textRepository, REPOSITORY_EXTENSION));

		final Button buttonRepository = new Button(repositoryGroup, SWT.NONE);
		buttonRepository.setText("File System...");
		buttonRepository.addSelectionListener(new SelectionAdapter() {

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				textRepository.setText(openFileDialog(REPOSITORY_EXTENSION));
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
				.addSelectionListener(new WorkspaseButtonSelectionListener(
						textSystem, SYSTEM_EXTENSION));

		final Button buttonSystem = new Button(systemGroup, SWT.NONE);
		buttonSystem.setText("File System...");
		buttonSystem.addSelectionListener(new SelectionAdapter() {

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				textSystem.setText(openFileDialog(SYSTEM_EXTENSION));
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
				.addSelectionListener(new WorkspaseButtonSelectionListener(
						textAllocation, ALLOCATION_EXTENSION));

		final Button buttonAllocation = new Button(allocationGroup, SWT.NONE);
		buttonAllocation.setText("File System...");
		buttonAllocation.addSelectionListener(new SelectionAdapter() {
			
			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				textAllocation.setText(openFileDialog(ALLOCATION_EXTENSION));
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
				.addSelectionListener(new WorkspaseButtonSelectionListener(
						textUsage, USAGEMODEL_EXTENSION));

		final Button buttonUsage = new Button(usageGroup, SWT.NONE);
		buttonUsage.setText("File System...");
		buttonUsage.addSelectionListener(new SelectionAdapter() {

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				textUsage.setText(openFileDialog(USAGEMODEL_EXTENSION));
				updateLaunchConfigurationDialog();
			}
		});
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
					ResourceManagerTab.ALLOCATION_FILE, ""));
		} catch (CoreException e) {
			textAllocation.setText("CoreException e -> ALLOCATION_FILE");
		}

		try {
			textRepository.setText(configuration.getAttribute(
					ResourceManagerTab.REPOSITORY_FILE, ""));
		} catch (CoreException e) {
			textRepository.setText("CoreException e -> REPOSITORY_FILE");
		}

		try {
			textResourceType.setText(configuration.getAttribute(
					ResourceManagerTab.RESOURCETYPEREPOSITORY_FILE, ""));
		} catch (CoreException e) {
			textResourceType
					.setText("CoreException e -> RESOURCETYPEREPOSITORY_FILE");
		}

		try {
			textSystem.setText(configuration.getAttribute(
					ResourceManagerTab.SYSTEM_FILE, ""));
		} catch (CoreException e) {
			textSystem.setText("CoreException e -> SYSTEM_FILE");
		}

		try {
			textUsage.setText(configuration.getAttribute(
					ResourceManagerTab.USAGE_FILE, ""));
		} catch (CoreException e) {
			textUsage.setText("CoreException e -> USAGE_FILE");
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				ResourceManagerTab.RESOURCETYPEREPOSITORY_FILE,
				textResourceType.getText());
		configuration.setAttribute(ResourceManagerTab.REPOSITORY_FILE,
				textRepository.getText());
		configuration.setAttribute(ResourceManagerTab.SYSTEM_FILE, textSystem
				.getText());
		configuration.setAttribute(ResourceManagerTab.ALLOCATION_FILE,
				textAllocation.getText());
		configuration.setAttribute(ResourceManagerTab.USAGE_FILE, textUsage
				.getText());

	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#setDefaults(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		// TODO Auto-generated method stub

	}

	public boolean isValid(ILaunchConfiguration launchConfig) {
		setErrorMessage(null);

		if (!validateFilePath(textRepository.getText(),REPOSITORY_EXTENSION)) {
			setErrorMessage("Repository is missing!");
			return false;
		}
		if (!validateFilePath(textResourceType.getText(), RESOURCETYPE_EXTENSION)) {
			setErrorMessage("ResourceTypeRepository is missing!");
			return false;
		}
		if (!validateFilePath(textSystem.getText(), SYSTEM_EXTENSION)) {
			setErrorMessage("System is missing!");
			return false;
		}
		if (!validateFilePath(textAllocation.getText(), ALLOCATION_EXTENSION)) {
			setErrorMessage("Allocation is missing!");
			return false;
		}
		if (!validateFilePath(textUsage.getText(), USAGEMODEL_EXTENSION)) {
			setErrorMessage("Usage is missing!");
			return false;
		}
		return true;
	}

	public boolean canSave() {
		return true;
	}
	
	private boolean validateFilePath(String filePath, String[] extentions){
		if (filePath.equals(""))
			return false;
		String extention = getExtentionFromArray(extentions).replace("*", ""); 
		if (filePath.contains(extention))
			return true;
		return false;
	}

	private String getExtentionFromArray(String[] array){
		return array[0];
	}
	/**
	 * The function calls the FileDialog and give back absolute path on the file
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
	 * The function calls the ContainerSelectionDialog and give back relative to
	 * the workspace
	 * 
	 * @return relative path to file in workspace
	 */
	private String openResourceDialog(String extention) {
		
		/** Filter from the redundant files. */
		List<ViewerFilter> filters = new ArrayList<ViewerFilter>();
		ResourcePatternFilter filter = new ResourcePatternFilter();
		filter.setPatterns(new String[]{"*diagram","*.settings","*.project"});
		filters.add(filter);
		
		/** create the dialog message*/
		String msg = "Select a file (" + extention + ").";

		IFile file = null;

		IFile[] files = WorkspaceResourceDialog.openFileSelection(getShell(),
				null, msg, false, null, filters);
		
		if (files.length != 0)
			file = files[0];
		if (file != null)
			return file.getLocation().toOSString();
		
		return "";
	}
	

	class WorkspaseButtonSelectionListener extends SelectionAdapter {

		private Text field;
		private String extension;

		public WorkspaseButtonSelectionListener(Text field, String[] extensions) {
			this.field = field;
			this.extension = getExtentionFromArray(extensions);
		}

		/* (non-Javadoc)
		 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
		 */
		@Override
		public void widgetSelected(SelectionEvent e) {
			field.setText(openResourceDialog(extension));
		}
	}
}

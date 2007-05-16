package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import java.io.File;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
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
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
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

	//The default value for the button Name.
	private final String BUTTON_NAME = "Browse...";

	/**
	 * The default value for the 'height' Layout attribute.
	 */
	private final int LAYOUT_WIDTH = 554;

	/**
	 * Set the file extensions which the dialog will use to filter the files it
	 * shows to the argument.
	 */
	private final String[] REPOSITORY_EXTENSION = new String[] { "*.repository" };
	private final String[] SYSTEM_EXTENSION 	= new String[] { "*.system" };
	private final String[] ALLOCATION_EXTENSION = new String[] { "*.allocation" };
	private final String[] USAGEMODEL_EXTENSION = new String[] { "*.usagemodel" };
	
	private Text textRepository;
	private Text textSystem;
	private Text textAllocation;
	private Text textUsage;
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		final ModifyListener modifyListener = new ModifyListener(){

			public void modifyText(ModifyEvent e) {
				ModelsFileNameInputTab.this.setDirty(true);
				ModelsFileNameInputTab.this.updateLaunchConfigurationDialog();
			}
		};

		Composite container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout());
		
		// Create reposetory section
		final Group repositoryFileGroup = new Group(container, SWT.NONE);
		final GridLayout glReposetoryGroup = new GridLayout();
		glReposetoryGroup.numColumns = 2;
		repositoryFileGroup.setLayout(glReposetoryGroup);
		repositoryFileGroup.setText("Repository File");
		repositoryFileGroup.setLayoutData(new GridData(LAYOUT_WIDTH,
				SWT.DEFAULT));

		textRepository = new Text(repositoryFileGroup, SWT.SINGLE
				| SWT.BORDER);
		textRepository.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false));
		textRepository.addModifyListener(modifyListener);

		final Button buttonRepository = new Button(repositoryFileGroup,
				SWT.NONE);
		buttonRepository.setText(BUTTON_NAME);
		buttonRepository.addSelectionListener(new SelectionAdapter() {
			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				textRepository.setText(openFileDialog(e, REPOSITORY_EXTENSION));
			}
		});

		// Create system Section
		final Group systemFileGroup = new Group(container, SWT.NONE);
		final GridLayout glFileGroup = new GridLayout();
		glFileGroup.numColumns = 2;
		systemFileGroup.setLayout(glFileGroup);
		systemFileGroup.setText("System File");
		systemFileGroup.setLayoutData(new GridData(LAYOUT_WIDTH, SWT.DEFAULT));

		textSystem = new Text(systemFileGroup, SWT.SINGLE
				| SWT.BORDER);
		textSystem
				.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		textSystem.addModifyListener(modifyListener);
		
		final Button buttonSystem = new Button(systemFileGroup, SWT.NONE);
		buttonSystem.setText(BUTTON_NAME);
		buttonSystem.addSelectionListener(new SelectionAdapter() {
			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				textSystem.setText(openFileDialog(e, SYSTEM_EXTENSION));
			}
		});

		// Create allocation section
		final Group allocationFileGroup = new Group(container, SWT.NONE);
		final GridLayout dlAllocationGroup = new GridLayout();
		dlAllocationGroup.numColumns = 2;
		allocationFileGroup.setLayout(dlAllocationGroup);
		allocationFileGroup.setText("Allocation File");
		allocationFileGroup.setLayoutData(new GridData(LAYOUT_WIDTH,
				SWT.DEFAULT));

		textAllocation = new Text(allocationFileGroup, SWT.SINGLE
				| SWT.BORDER);
		textAllocation.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false));
		textAllocation.addModifyListener(modifyListener);

		final Button buttonAllocation = new Button(allocationFileGroup,
				SWT.NONE);
		buttonAllocation.setText(BUTTON_NAME);
		buttonAllocation.addSelectionListener(new SelectionAdapter() {
			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				textAllocation.setText(openFileDialog(e, ALLOCATION_EXTENSION));
			}
		});

		// Create usage section
		final Group usageFileGroup = new Group(container, SWT.NONE);
		final GridLayout glUsageGroup = new GridLayout();
		glUsageGroup.numColumns = 2;
		usageFileGroup.setLayout(glUsageGroup);
		usageFileGroup.setText("Usage File");
		usageFileGroup.setLayoutData(new GridData(LAYOUT_WIDTH, SWT.DEFAULT));

		textUsage = new Text(usageFileGroup, SWT.SINGLE | SWT.BORDER);
		textUsage
				.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		textUsage.addModifyListener(modifyListener);

		final Button buttonUsage = new Button(usageFileGroup, SWT.NONE);
		buttonUsage.setText(BUTTON_NAME);
		buttonUsage.addSelectionListener(new SelectionAdapter() {
			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				textUsage.setText(openFileDialog(e, USAGEMODEL_EXTENSION));
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
			textAllocation.setText(configuration.getAttribute(ResourceManagerTab.ALLOCATION_FILE, ""));
		} catch (CoreException e) {
			textAllocation.setText("CoreException e -> ALLOCATION_FILE");
		}
		
		try {
			textRepository.setText(configuration.getAttribute(ResourceManagerTab.REPOSITORY_FILE, ""));
		} catch (CoreException e) {
			textRepository.setText("CoreException e -> REPOSITORY_FILE");
		}
		
		try {
			textSystem.setText(configuration.getAttribute(ResourceManagerTab.SYSTEM_FILE, ""));
		} catch (CoreException e) {
			textSystem.setText("CoreException e -> SYSTEM_FILE");
		}
		
		try {
			textUsage.setText(configuration.getAttribute(ResourceManagerTab.USAGE_FILE, ""));
		} catch (CoreException e) {
			textUsage.setText("CoreException e -> USAGE_FILE");
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(ResourceManagerTab.REPOSITORY_FILE, textRepository.getText());
		configuration.setAttribute(ResourceManagerTab.SYSTEM_FILE, textSystem.getText());
		configuration.setAttribute(ResourceManagerTab.ALLOCATION_FILE, textAllocation.getText());
		configuration.setAttribute(ResourceManagerTab.USAGE_FILE, textUsage.getText());

	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#setDefaults(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		// TODO Auto-generated method stub

	}
	
	public boolean isValid(ILaunchConfiguration launchConfig) {
		setErrorMessage(null);

		if (textRepository.getText().equals("")){
			setErrorMessage("Repository is missing!");
			return false;
		}
		if (textSystem.getText().equals("")){
			setErrorMessage("System is missing!");
			return false;
		}
		if (textAllocation.getText().equals("")){
	    	setErrorMessage("Allocation is missing!");
	    	return false;
    	}
		if (textUsage.getText().equals("")){
			setErrorMessage("Usage is missing!");
			return false;
		}
		return true;
	}
	
	public boolean canSave() {
		return true;
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
		dialog.setText("Select model file");

		if (dialog.open() != null) {
			String root = dialog.getFilterPath() + File.separatorChar;
			filename = root + dialog.getFileName();
		}
		return filename;
	}
}

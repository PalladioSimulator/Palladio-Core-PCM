package de.uka.ipd.sdq.workflow.pcm.runconfig;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import de.uka.ipd.sdq.workflow.launchconfig.RunConfigImages;
import de.uka.ipd.sdq.workflow.launchconfig.RunConfigPlugin;
import de.uka.ipd.sdq.workflow.launchconfig.tabs.TabHelper;
import de.uka.ipd.sdq.workflow.pcm.ConstantsContainer;

/**
 * The class defines a tab, which is responsible for the input model(s) of
 * the Palladio Component Model.
 *
 * @author Roman Andrej
 * @author groenda
 */
public class FileNamesInputTab extends AbstractLaunchConfigurationTab {

	// input fields
	/** Text field for path to allocation model file. */
	protected Text textAllocation;
	/** Text field for path to usage model file. */
	protected Text textUsage;
	/** Text field for path to middleware model file. */
	protected Text mwtextRepository;
	/** Text field for path to event middleware model file. */
	protected Text eventMiddlewareRepository;

	/** Container for UI elements. */
	protected Composite container;

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#getImage()
	 */
	@Override
	public Image getImage() {
		return RunConfigImages.getFileNamesTabImage();
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

		this.container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout());

		/**
		 * Create MW repository section
		 */
		mwtextRepository = new Text(container, SWT.SINGLE | SWT.BORDER);
		TabHelper.createFileInputSection(container, modifyListener, "Middleware Repository File", ConstantsContainer.REPOSITORY_EXTENSION, mwtextRepository, "Select Middleware Repository File", getShell(), ConstantsContainer.DEFAULT_MIDDLEWARE_REPOSITORY_FILE);

		/**
		 * Create event MW repository section
		 */
		eventMiddlewareRepository = new Text(container, SWT.SINGLE | SWT.BORDER);
		TabHelper.createFileInputSection(container, modifyListener, "Event Middleware Repository File", ConstantsContainer.REPOSITORY_EXTENSION, eventMiddlewareRepository, "Select Event Middleware Repository File", getShell(), ConstantsContainer.DEFAULT_EVENT_MIDDLEWARE_FILE);

		/**
		 * Create allocation section
		 */
		textAllocation = new Text(container, SWT.SINGLE | SWT.BORDER);
		TabHelper.createFileInputSection(container, modifyListener, "Allocation File", ConstantsContainer.ALLOCATION_EXTENSION, textAllocation, "Select Allocation File", getShell(), ConstantsContainer.DEFAULT_ALLOCATION_FILE);

		/**
		 * Create usage section
		 */
		//First set the text like this, will be changed to the right parent in createFileInputSection
		textUsage = new Text(container, SWT.SINGLE | SWT.BORDER);
		TabHelper.createFileInputSection(container, modifyListener, "Usage File", ConstantsContainer.USAGEMODEL_EXTENSION, textUsage, "Select Usage File", getShell(), ConstantsContainer.DEFAULT_USAGE_FILE);

	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#getName()
	 */
	public String getName() {
		return "Architecture Model(s)";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#initializeFrom(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			textAllocation.setText(configuration.getAttribute(
					ConstantsContainer.ALLOCATION_FILE, ConstantsContainer.DEFAULT_ALLOCATION_FILE));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),"Allocation File", e.getMessage());
		}
		try {
			mwtextRepository.setText(configuration.getAttribute(
					ConstantsContainer.MWREPOSITORY_FILE, ConstantsContainer.DEFAULT_MIDDLEWARE_REPOSITORY_FILE));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),"Middleware Repository File", e.getMessage());
		}

		try {
			eventMiddlewareRepository.setText(configuration.getAttribute(
					ConstantsContainer.EVENT_MIDDLEWARE_REPOSITORY_FILE, ConstantsContainer.DEFAULT_EVENT_MIDDLEWARE_FILE));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),"Event Middleware Repository File", e.getMessage());
		}
		try {
			textUsage.setText(configuration.getAttribute(
					ConstantsContainer.USAGE_FILE, ConstantsContainer.DEFAULT_USAGE_FILE));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),"Usage File", e.getMessage());
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(ConstantsContainer.MWREPOSITORY_FILE,
				mwtextRepository.getText());
		configuration.setAttribute(ConstantsContainer.EVENT_MIDDLEWARE_REPOSITORY_FILE,
				eventMiddlewareRepository.getText());
		configuration.setAttribute(ConstantsContainer.ALLOCATION_FILE,
				textAllocation.getText());
		configuration.setAttribute(ConstantsContainer.USAGE_FILE, textUsage
				.getText());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#setDefaults(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(ConstantsContainer.MWREPOSITORY_FILE,
				ConstantsContainer.DEFAULT_MIDDLEWARE_REPOSITORY_FILE);
		configuration.setAttribute(
				ConstantsContainer.EVENT_MIDDLEWARE_REPOSITORY_FILE,
				ConstantsContainer.DEFAULT_EVENT_MIDDLEWARE_FILE);
	}


	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#isValid(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		setErrorMessage(null);

		if (!TabHelper.validateFilenameExtension(mwtextRepository.getText(),
				ConstantsContainer.REPOSITORY_EXTENSION)) {
			setErrorMessage("Middleware Repository is missing.");
			return false;
		}
		if (!TabHelper.validateFilenameExtension(eventMiddlewareRepository.getText(),
				ConstantsContainer.REPOSITORY_EXTENSION)) {
			setErrorMessage("Event Middleware Repository is missing.");
			return false;
		}
		if (!TabHelper.validateFilenameExtension(textAllocation.getText(),
				ConstantsContainer.ALLOCATION_EXTENSION)) {
			setErrorMessage("Allocation is missing.");
			return false;
		}
		if (!TabHelper.validateFilenameExtension(textUsage.getText(),
				ConstantsContainer.USAGEMODEL_EXTENSION)) {
			setErrorMessage("Usage is missing.");
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
		// Override this methods's super class implementation in order to
		// prevent multiple invocation of initializeFrom() and subsequent
		// invocations of performApply().
	}

	@Override
	public void deactivated(ILaunchConfigurationWorkingCopy workingCopy) {}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#getId()
	 */
	@Override
	public String getId() {
		return "de.uka.ipd.sdq.codegen.runconfig.tabs.FileNamesInputTab";
	}
}

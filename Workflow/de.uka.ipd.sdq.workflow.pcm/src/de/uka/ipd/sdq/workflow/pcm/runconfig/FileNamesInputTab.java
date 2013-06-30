package de.uka.ipd.sdq.workflow.pcm.runconfig;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import de.uka.ipd.sdq.workflow.launchconfig.LaunchConfigPlugin;
import de.uka.ipd.sdq.workflow.launchconfig.tabs.TabHelper;
import de.uka.ipd.sdq.workflow.pcm.ConstantsContainer;

/**
 * The class defines a tab, which is responsible for the input model(s) of
 * the Palladio Component Model.
 *
 * @author Roman Andrej
 * @author groenda
 */
public class FileNamesInputTab extends ProtocomFileNamesInputTab {
	
	// input fields
	/** Text field for path to middleware model file. */
	protected Text mwtextRepository;
	/** Text field for path to event middleware model file. */
	protected Text eventMiddlewareRepository;

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		super.createControl(parent);
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
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#initializeFrom(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	public void initializeFrom(ILaunchConfiguration configuration) {
		super.initializeFrom(configuration);
		try {
			mwtextRepository.setText(configuration.getAttribute(
					ConstantsContainer.MWREPOSITORY_FILE, ConstantsContainer.DEFAULT_MIDDLEWARE_REPOSITORY_FILE));
		} catch (CoreException e) {
			LaunchConfigPlugin.errorLogger(getName(),"Middleware Repository File", e.getMessage());
		}

		try {
			eventMiddlewareRepository.setText(configuration.getAttribute(
					ConstantsContainer.EVENT_MIDDLEWARE_REPOSITORY_FILE, ConstantsContainer.DEFAULT_EVENT_MIDDLEWARE_FILE));
		} catch (CoreException e) {
			LaunchConfigPlugin.errorLogger(getName(),"Event Middleware Repository File", e.getMessage());
		}
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		super.performApply(configuration);
		configuration.setAttribute(ConstantsContainer.MWREPOSITORY_FILE,
				mwtextRepository.getText());
		configuration.setAttribute(ConstantsContainer.EVENT_MIDDLEWARE_REPOSITORY_FILE,
				eventMiddlewareRepository.getText());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#setDefaults(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		super.setDefaults(configuration);
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
		boolean tmp = super.isValid(launchConfig);

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
		return tmp;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#getId()
	 */
	@Override
	public String getId() {
		return "de.uka.ipd.sdq.codegen.runconfig.tabs.FileNamesInputTab";
	}
}

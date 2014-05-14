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

import de.uka.ipd.sdq.workflow.launchconfig.ImageRegistryHelper;
import de.uka.ipd.sdq.workflow.launchconfig.LaunchConfigPlugin;
import de.uka.ipd.sdq.workflow.launchconfig.tabs.TabHelper;
import de.uka.ipd.sdq.workflow.pcm.ConstantsContainer;

/**
 * The class defines a tab, which is responsible for the input model(s) of
 * the Palladio Component Model.
 *
 * @author Benjamin Bulk
 */
public class ProtocomFileNamesInputTab extends AbstractLaunchConfigurationTab {
	
	/** The id of this plug-in. */
	public static final String PLUGIN_ID = "de.uka.ipd.sdq.workflow.pcm";
	/** The path to the image file for the tab icon. */
	private static final String FILENAME_TAB_IMAGE_PATH = "icons/filenames_tab.gif";

	// input fields
	/** Text field for path to allocation model file. */
	protected Text textAllocation;
	/** Text field for path to usage model file. */
	protected Text textUsage;
	
	/** Container for UI elements. */
	protected Composite container;

	protected ModifyListener modifyListener;
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#getImage()
	 */
	@Override
	public Image getImage() {
		return ImageRegistryHelper.getTabImage(PLUGIN_ID,FILENAME_TAB_IMAGE_PATH);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent){
		modifyListener = new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				setDirty(true);
				updateLaunchConfigurationDialog();
			}
		};
		container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout());
	
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
	public void initializeFrom(ILaunchConfiguration configuration){
		try {
			textAllocation.setText(configuration.getAttribute(
					ConstantsContainer.ALLOCATION_FILE, ConstantsContainer.DEFAULT_ALLOCATION_FILE));
		} catch (CoreException e) {
			LaunchConfigPlugin.errorLogger(getName(),"Allocation File", e.getMessage());
		}
		try {
			textUsage.setText(configuration.getAttribute(
					ConstantsContainer.USAGE_FILE, ConstantsContainer.DEFAULT_USAGE_FILE));
		} catch (CoreException e) {
			LaunchConfigPlugin.errorLogger(getName(),"Usage File", e.getMessage());
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void performApply(ILaunchConfigurationWorkingCopy configuration){
		configuration.setAttribute(ConstantsContainer.ALLOCATION_FILE,
				textAllocation.getText());
		configuration.setAttribute(ConstantsContainer.USAGE_FILE, textUsage
				.getText());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#setDefaults(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration){
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#isValid(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	@Override
	public boolean isValid(ILaunchConfiguration launchConfig){
		setErrorMessage(null);

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
		return "de.uka.ipd.sdq.codegen.runconfig.tabs.ProtocomFileNamesInputTab";
	}
}

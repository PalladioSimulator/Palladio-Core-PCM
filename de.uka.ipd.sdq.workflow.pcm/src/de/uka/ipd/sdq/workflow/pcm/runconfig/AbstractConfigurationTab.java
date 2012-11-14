package de.uka.ipd.sdq.workflow.pcm.runconfig;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.uka.ipd.sdq.workflow.launchconfig.RunConfigImages;
import de.uka.ipd.sdq.workflow.launchconfig.RunConfigPlugin;
import de.uka.ipd.sdq.workflow.pcm.ConstantsContainer;

/**
 * Configuration of an analysis method. Represents configuration settings which
 * are independent of the solving method.
 * 
 * @author groenda
 * @author Roman Andrej
 */
public class AbstractConfigurationTab extends AbstractLaunchConfigurationTab {

	/** The id of this plug-in. */
	public static final String PLUGIN_ID = "de.uka.ipd.sdq.workflow.pcm";
	/** The path to the image file for the tab icon. */
	public static final String CONFIGURATION_TAB_IMAGE_PATH = "icons/configuration_tab.gif";

	/** Text field for name of the plug-in project containing temporary data. */
	protected Text temporaryLocationField;
	/** Label for the temporary data plug-in project name field. */
	private Label temporaryLocationLabel;
	/** Button stating if the default location should be selected. */
	protected Button defaultLocationButton;
	
	protected ModifyListener modifyListener;
	protected SelectionListener selectionListener;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#getImage()
	 */
	public Image getImage() {
		return RunConfigImages.getTabImage(PLUGIN_ID,
				CONFIGURATION_TAB_IMAGE_PATH);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.ui.ILaunchConfigurationTab#createControl(org.eclipse
	 * .swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {

		modifyListener = new ModifyListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.
			 * swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				AbstractConfigurationTab.this.setDirty(true);
				AbstractConfigurationTab.this.updateLaunchConfigurationDialog();
			}
		};
		selectionListener = new SelectionAdapter() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse
			 * .swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				AbstractConfigurationTab.this.setDirty(true);
				AbstractConfigurationTab.this.updateLaunchConfigurationDialog();
			}
		};

		// Create a new Composite to hold the page's controls.
		// The composite will show scroll bars if the size of
		// the dialog decreases below the minimum size of the
		// contained controls:
		ScrolledComposite container = new ScrolledComposite(parent,
				SWT.H_SCROLL | SWT.V_SCROLL);
		container.setExpandHorizontal(true);
		container.setExpandVertical(true);
		Composite contentContainer = new Composite(container, SWT.NONE);
		container.setContent(contentContainer);
		GridLayout layout = new GridLayout();
		contentContainer.setLayout(layout);

		// Sets the scrolled composite to be the displayed
		// top-level control in this tab:
		setControl(container);

		// Create temporary data location section
		createTemporaryDataLocationSection(contentContainer);
		createDeleteTemporaryDataAfterAnalysisSection(contentContainer);
		createAccuracySection(contentContainer);

		// Create further sections as required:
		createFurtherSections(contentContainer);

		// disabled widget
		setTemporaryLocationElementsEnabled(false);

		// After all internal controls have been created,
		// calculate the minimal size of the contentContainer.
		// Scrollbars will be shown if the dialog size decreases
		// below the calculated min size:
		container.setMinSize(contentContainer.computeSize(SWT.DEFAULT,
				SWT.DEFAULT));
	}

	/**
	 * Creates the section for the accuracy analysis.
	 * 
	 * @param container
	 *            Container in which teh elements are created.
	 */
	protected void createAccuracySection(Composite container) {
	}

	/**
	 * Creates the section for the deletion of temporary data.
	 * 
	 * @param container
	 *            Container in which the elements are created.
	 */
	protected void createDeleteTemporaryDataAfterAnalysisSection(
			Composite container) {
		
	}

	/**
	 * Creates the section for the selection of the temporary data location.
	 * 
	 * @param container
	 *            Container in which the elements are created.
	 * @param modifyListener
	 *            The lister to use on modifications.
	 */
	protected void createTemporaryDataLocationSection(Composite container) {
		final Group outputPathGroup = new Group(container, SWT.NONE);
		outputPathGroup.setText("Location of temporary data");
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 4;
		outputPathGroup.setLayout(gridLayout);
		final GridData gd_outputPathGroup = new GridData(SWT.FILL, SWT.CENTER,
				true, false);
		outputPathGroup.setLayoutData(gd_outputPathGroup);

		/** default temporary location button */
		defaultLocationButton = new Button(outputPathGroup, SWT.CHECK);
		final GridData gridData_dl = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 4, 1);
		defaultLocationButton.setLayoutData(gridData_dl);
		defaultLocationButton.setText("Use default location");
		defaultLocationButton.setSelection(true);
		defaultLocationButton.addSelectionListener(new SelectionAdapter() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse
			 * .swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				setTemporaryLocationElementsEnabled(!defaultLocationButton
						.getSelection());

				if (defaultLocationButton.getSelection() == true) {
					temporaryLocationField
							.setText(ConstantsContainer.DEFAULT_TEMPORARY_DATA_LOCATION);
				}
				AbstractConfigurationTab.this.setDirty(true);
				AbstractConfigurationTab.this.updateLaunchConfigurationDialog();
			}
		});

		temporaryLocationLabel = new Label(outputPathGroup, SWT.NONE);
		temporaryLocationLabel.setLayoutData(new GridData(48, SWT.DEFAULT));
		temporaryLocationLabel.setText("Location:");

		temporaryLocationField = new Text(outputPathGroup, SWT.BORDER);
		final GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true,
				false);
		gridData.widthHint = 20;
		temporaryLocationField.setLayoutData(gridData);
		temporaryLocationField
				.setText(ConstantsContainer.DEFAULT_TEMPORARY_DATA_LOCATION);
		temporaryLocationField.addModifyListener(modifyListener);
	}

	/**
	 * Derived classes may add further sections here.
	 * 
	 * @param container
	 *            Container in which the elements are created.
	 */
	protected void createFurtherSections(Composite container) {
	}

	/**
	 * Set the enable-state for the elements in the temporary location section.
	 * 
	 * @param enable
	 */
	private void setTemporaryLocationElementsEnabled(boolean enable) {
		temporaryLocationLabel.setEnabled(enable);
		temporaryLocationField.setEnabled(enable);
	}

	/**
	 * /* (non-Javadoc)
	 * 
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#getName()
	 */
	public String getName() {
		return "Analysis Configuration";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.ui.ILaunchConfigurationTab#initializeFrom(org.eclipse
	 * .debug.core.ILaunchConfiguration)
	 */
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			temporaryLocationField.setText(configuration.getAttribute(
					ConstantsContainer.TEMPORARY_DATA_LOCATION,
					ConstantsContainer.DEFAULT_TEMPORARY_DATA_LOCATION));
			// set default selection button state
			if (temporaryLocationField.getText().equals(
					ConstantsContainer.DEFAULT_TEMPORARY_DATA_LOCATION)) {
				defaultLocationButton.setSelection(true);
				setTemporaryLocationElementsEnabled(false);
			} else {
				defaultLocationButton.setSelection(false);
				setTemporaryLocationElementsEnabled(true);
			}
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),
					"Temporary Location Settings", e.getMessage());
			defaultLocationButton.setSelection(true);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(org.eclipse
	 * .debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(ConstantsContainer.TEMPORARY_DATA_LOCATION,
				temporaryLocationField.getText());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.ui.ILaunchConfigurationTab#setDefaults(org.eclipse.
	 * debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(ConstantsContainer.TEMPORARY_DATA_LOCATION,
				ConstantsContainer.DEFAULT_TEMPORARY_DATA_LOCATION);
	}

	public boolean isValid(ILaunchConfiguration launchConfig) {
		setErrorMessage(null);

		if (temporaryLocationField.getText().equals("")) {
			setErrorMessage("The location for temporary data is missing.");
			return false;
		}
		return true;
	}

	@Override
	public void activated(ILaunchConfigurationWorkingCopy workingCopy) {
		// Leave this method empty to prevent unnecessary invocation of
		// initializeFrom() and multiple resulting invocations of
		// performApply().
	}

	@Override
	public void deactivated(ILaunchConfigurationWorkingCopy workingCopy) {
		// intentionally left blank
	}

}

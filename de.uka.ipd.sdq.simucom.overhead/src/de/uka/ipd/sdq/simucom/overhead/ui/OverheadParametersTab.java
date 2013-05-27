package de.uka.ipd.sdq.simucom.overhead.ui;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
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

import de.uka.ipd.sdq.simucom.overhead.Constants;
import de.uka.ipd.sdq.simucom.overhead.OverheadSimuComExtensionPlugin;
import de.uka.ipd.sdq.workflow.launchconfig.tabs.TabHelper;
import de.uka.ipd.sdq.workflow.pcm.ConstantsContainer;

/**
 * The class defines a tab, where the simucom overhead be set
 *
 * @author Michael Hauck
 */
public class OverheadParametersTab extends AbstractLaunchConfigurationTab {

	private static final String LABEL_USE_LOAD_OVERHEAD_PARAMETERS = "Use Load Overhead parameter configuration in simulation";

	// Default values
	private static final Boolean DEFAULT_USE_LOAD_OVERHEAD_PARAMETERS = false;
	// UI elements
	

	private Button useLoadOverheadParametersButton;
	private Text textLoadOverheadConfiguration;




	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.eclipse.debug.ui.ILaunchConfigurationTab#createControl(org.eclipse
	 * .swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {

		final ModifyListener modifyListener = new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				OverheadParametersTab.this.setDirty(true);
				OverheadParametersTab.this.updateLaunchConfigurationDialog();
			}
		};

		final SelectionListener selectionListener = new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				OverheadParametersTab.this.setDirty(true);
				OverheadParametersTab.this.updateLaunchConfigurationDialog();
			}

			public void widgetSelected(SelectionEvent e) {
				OverheadParametersTab.this.setDirty(true);
				OverheadParametersTab.this.updateLaunchConfigurationDialog();
			}
		};

		// Create the top-level container:
		Composite container = new Composite(parent, SWT.NONE);

		setControl(container);
		container.setLayout(new GridLayout());
		
		

		
		
		// Create Load overhead parameter configuration section:
		final Group featureConfigGroupLoadOverhead = new Group(container, SWT.NONE);
		featureConfigGroupLoadOverhead.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		featureConfigGroupLoadOverhead.setLayout(gridLayout);
		featureConfigGroupLoadOverhead.setText("CPU Overhead");
		

		useLoadOverheadParametersButton = new Button(featureConfigGroupLoadOverhead, SWT.CHECK);
		final GridData gd_useLoadOverheadParametersButton = new GridData(
				SWT.FILL, SWT.CENTER, true, false, 1,1);
		useLoadOverheadParametersButton
				.setLayoutData(gd_useLoadOverheadParametersButton);
		useLoadOverheadParametersButton.setText(LABEL_USE_LOAD_OVERHEAD_PARAMETERS);
		useLoadOverheadParametersButton.addSelectionListener(selectionListener);
		
		Label nameLabel = new Label(featureConfigGroupLoadOverhead, SWT.NONE);
		nameLabel.setText("Specify CPU overhead for resource containers (format: id1:overhead1[linebreak]id2:overhead2):");
		textLoadOverheadConfiguration = new Text(featureConfigGroupLoadOverhead, SWT.MULTI | SWT.BORDER);
		final GridData gd_nameField = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gd_nameField.widthHint = 70;
		gd_nameField.heightHint = 50;
		textLoadOverheadConfiguration.setLayoutData(gd_nameField);
		textLoadOverheadConfiguration.addModifyListener(modifyListener);
			
	}

	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		setErrorMessage(null);
		if (useLoadOverheadParametersButton.getSelection() == true) {
			if (textLoadOverheadConfiguration.getText().isEmpty()) {
				setErrorMessage("Load overhead parameter configuration is missing!");
				return false;
			}
		}

		return true;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#getName()
	 */
	public String getName() {
		return "Overhead Parameters";
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#getImage()
	 */
	@Override
	public Image getImage() {
		return OverheadSimuComExtensionPlugin.getDefault().getOverheadTabImage();
	}
	
	private ILaunchConfiguration myConfiguration = null;

    /*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.eclipse.debug.ui.ILaunchConfigurationTab#initializeFrom(org.eclipse
	 * .debug.core.ILaunchConfiguration)
	 */
	public void initializeFrom(ILaunchConfiguration configuration) {
		myConfiguration = configuration;
		try {
			useLoadOverheadParametersButton.setSelection(configuration.getAttribute(
									Constants.USE_LOAD_OVERHEAD_PARAMETERS,
									false));
		} catch (CoreException e) {
			useLoadOverheadParametersButton.setSelection(false);
		}
		try {
			textLoadOverheadConfiguration.setText(configuration.getAttribute(
					Constants.LOAD_OVERHEAD_PARAMETERS, Constants.DEFAULT_LOAD_OVERHEAD_PARAMETERS));
		} catch (CoreException e) {
			textLoadOverheadConfiguration.setText(Constants.DEFAULT_LOAD_OVERHEAD_PARAMETERS);
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
		configuration.setAttribute(
				Constants.USE_LOAD_OVERHEAD_PARAMETERS,
				this.useLoadOverheadParametersButton.getSelection());
		configuration.setAttribute(Constants.LOAD_OVERHEAD_PARAMETERS,
				textLoadOverheadConfiguration.getText());
	}




	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.eclipse.debug.ui.ILaunchConfigurationTab#setDefaults(org.eclipse.
	 * debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {	
		configuration.setAttribute(Constants.LOAD_OVERHEAD_PARAMETERS,
				Constants.DEFAULT_LOAD_OVERHEAD_PARAMETERS);
		configuration.setAttribute(
				Constants.USE_LOAD_OVERHEAD_PARAMETERS, DEFAULT_USE_LOAD_OVERHEAD_PARAMETERS);
	}


	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#activated(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	@Override
	public void activated(ILaunchConfigurationWorkingCopy workingCopy) {
		// Leave this method empty to prevent unnecessary invocation of
		// initializeFrom() and multiple resulting invocations of
		// performApply().
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#deactivated(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	@Override
	public void deactivated(ILaunchConfigurationWorkingCopy workingCopy) {
		// Intentionally left empty.
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#getId()
	 */
	@Override
	public String getId() {
		return "de.uka.ipd.sdq.simucom.overhead.ui.GinpexParametersTab";
    }

}

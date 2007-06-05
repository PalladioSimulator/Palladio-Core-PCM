/**
 * 
 */
package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.uka.ipd.sdq.simucomframework.SimuComConfig;

/**
 * @author admin
 *
 */
public class SimuComConfigurationTab extends AbstractLaunchConfigurationTab {
	
	/** The default value for the 'height' Layout attribute. */
	private final int LAYOUT_WIDTH = 554;
	
	private Text nameField;
	private Text timeField;

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		final ModifyListener modifyListener = new ModifyListener(){

			public void modifyText(ModifyEvent e) {
				SimuComConfigurationTab.this.setDirty(true);
				SimuComConfigurationTab.this.updateLaunchConfigurationDialog();
			}
		};
		
		Composite container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout());

		/** Create Experiment Run section */
		final Group experimentrunGroup = new Group(container, SWT.NONE);
		experimentrunGroup.setText("Experiment Run");
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		experimentrunGroup.setLayout(gridLayout);
		experimentrunGroup.setLayoutData(new GridData(LAYOUT_WIDTH, 40));
		
		Label nameLabel = new Label(experimentrunGroup, SWT.NONE);
		nameLabel.setLayoutData(new GridData(48, SWT.DEFAULT));
		nameLabel.setText("Experiment Name:");

		nameField = new Text(experimentrunGroup, SWT.BORDER);
		final GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true,
				false, 2, 1);
		gridData.widthHint = 170;
		nameField.setLayoutData(gridData);
		nameField.addModifyListener(modifyListener);
		
		/** Create SimuCom section */
		final Group simucomGroup = new Group(container, SWT.NONE);
		simucomGroup.setLayout(new FormLayout());
		simucomGroup.setText("SimuCom");
		gridLayout.numColumns = 3;
		simucomGroup.setLayoutData(new GridData(LAYOUT_WIDTH, 40));

		final Label timeLabel = new Label(simucomGroup, SWT.NONE);
		final FormData fd_timeLabel = new FormData();
		fd_timeLabel.bottom = new FormAttachment(0, 31);
		fd_timeLabel.top = new FormAttachment(0, 14);
		fd_timeLabel.right = new FormAttachment(0, 187);
		fd_timeLabel.left = new FormAttachment(0, 60);
		timeLabel.setLayoutData(fd_timeLabel);
		timeLabel.setText("Maximum simulation time:");

		timeField = new Text(simucomGroup, SWT.BORDER);
		final FormData fd_text = new FormData();
		fd_text.top = new FormAttachment(0, 10);
		fd_text.right = new FormAttachment(0, 307);
		fd_text.left = new FormAttachment(0, 200);
		timeField.setLayoutData(fd_text);
		timeField.addModifyListener(modifyListener);

		final Label secLabel = new Label(simucomGroup, SWT.NONE);
		final FormData fd_secLabel = new FormData();
		fd_secLabel.bottom = new FormAttachment(0, 30);
		fd_secLabel.top = new FormAttachment(0, 14);
		fd_secLabel.right = new FormAttachment(0, 365);
		fd_secLabel.left = new FormAttachment(0, 320);
		secLabel.setLayoutData(fd_secLabel);
		secLabel.setText("Sec.");
		gridData.widthHint = 456;


	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#getName()
	 */
	public String getName() {
		return "SimuCom";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#initializeFrom(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			nameField.setText(configuration.getAttribute(
					SimuComConfig.EXPERIMENT_RUN, ""));
		} catch (CoreException e) {
			nameField.setText("CoreException e -> EXPERIMENT_RUN");
		}

		try {
			timeField.setText(configuration.getAttribute(
					SimuComConfig.SIMULATION_TIME, ""));
		} catch (CoreException e) {
			timeField.setText("CoreException e -> SIMULATION_TIME");
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(SimuComConfig.EXPERIMENT_RUN,
				nameField.getText());
		configuration.setAttribute(SimuComConfig.SIMULATION_TIME,
				timeField.getText());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#setDefaults(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(SimuComConfig.EXPERIMENT_RUN,
				"MyRun");
		configuration.setAttribute(SimuComConfig.SIMULATION_TIME,
				"150000");
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#getImage()
	 */
	@Override
	public Image getImage() {
		return ResourceManagerTab.getSimuComConfImage();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#isValid(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		setErrorMessage(null);

		if (nameField.getText().equals("")){
			setErrorMessage("ExperimentRun name is missing!");
			return false;
		}
		if (timeField.getText().equals("")){
			setErrorMessage("Simulation time is missing!");
			return false;
		}
		return true;
	}

}

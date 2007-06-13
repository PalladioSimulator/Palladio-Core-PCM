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
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.uka.ipd.sdq.dialogs.dataset.SensorDataSetDialog;
import de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;

/** @author roman */
public class SimuComConfigurationTab extends AbstractLaunchConfigurationTab {
	
	/** The default value for the 'height' Layout attribute. */
	private final int LAYOUT_WIDTH = 554;
	
	private Text nameField;
	private Text timeField;
	private Text dataField;

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
		experimentrunGroup.setLayoutData(new GridData(LAYOUT_WIDTH, 30));
		
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
		simucomGroup.setLayoutData(new GridData(LAYOUT_WIDTH, 30));

		final Label timeLabel = new Label(simucomGroup, SWT.NONE);
		final FormData fd_timeLabel = new FormData();
		fd_timeLabel.bottom = new FormAttachment(0, 26);
		fd_timeLabel.top = new FormAttachment(0, 9);
		fd_timeLabel.right = new FormAttachment(0, 187);
		fd_timeLabel.left = new FormAttachment(0, 60);
		timeLabel.setLayoutData(fd_timeLabel);
		timeLabel.setText("Maximum simulation time:");

		timeField = new Text(simucomGroup, SWT.BORDER);
		final FormData fd_text = new FormData();
		fd_text.bottom = new FormAttachment(0, 24);
		fd_text.top = new FormAttachment(0, 5);
		fd_text.right = new FormAttachment(0, 307);
		fd_text.left = new FormAttachment(0, 200);
		timeField.setLayoutData(fd_text);
		timeField.addModifyListener(modifyListener);

		final Label secLabel = new Label(simucomGroup, SWT.NONE);
		final FormData fd_secLabel = new FormData();
		fd_secLabel.bottom = new FormAttachment(0, 25);
		fd_secLabel.top = new FormAttachment(0, 9);
		fd_secLabel.right = new FormAttachment(0, 365);
		fd_secLabel.left = new FormAttachment(0, 320);
		secLabel.setLayoutData(fd_secLabel);
		secLabel.setText("Sec.");
		gridData.widthHint = 456;

		/**DataSet group */
		final Group dataSetGroup = new Group(container, SWT.NONE);
		dataSetGroup.setLayout(new FormLayout());
		dataSetGroup.setText("Data Set");
		final GridData gd_dataSetGroup = new GridData(LAYOUT_WIDTH, 32);
		dataSetGroup.setLayoutData(gd_dataSetGroup);

		final Label dataSourceLabel = new Label(dataSetGroup, SWT.NONE);
		final FormData fd_dataSourceLabel = new FormData();
		fd_dataSourceLabel.bottom = new FormAttachment(0, 30);
		fd_dataSourceLabel.top = new FormAttachment(0, 11);
		fd_dataSourceLabel.right = new FormAttachment(0, 190);
		fd_dataSourceLabel.left = new FormAttachment(0, 118);
		dataSourceLabel.setLayoutData(fd_dataSourceLabel);
		dataSourceLabel.setText("Data source:");

		dataField = new Text(dataSetGroup, SWT.BORDER);
		final FormData fd_text_1 = new FormData();
		fd_text_1.right = new FormAttachment(0, 476);
		fd_text_1.bottom = new FormAttachment(0, 26);
		fd_text_1.top = new FormAttachment(0, 6);
		fd_text_1.left = new FormAttachment(0, 200);
		dataField.setLayoutData(fd_text_1);
		dataField.addModifyListener(modifyListener);

		final Button browseButton = new Button(dataSetGroup, SWT.NONE);
		final FormData fd_browseButton = new FormData();
		fd_browseButton.bottom = new FormAttachment(0, 28);
		fd_browseButton.top = new FormAttachment(0, 4);
		fd_browseButton.right = new FormAttachment(0, 549);
		fd_browseButton.left = new FormAttachment(0, 481);
		browseButton.setLayoutData(fd_browseButton);
		browseButton.setText("Browse...");
		browseButton.addSelectionListener(new SelectionAdapter(){

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				SensorDataSetDialog dialog = new SensorDataSetDialog(e.display
						.getActiveShell());
				if (dialog.open() == dialog.OK) {
					IDAOFactory dataSet = (IDAOFactory) dialog.getResult();
					dataField.setText(String.valueOf(dataSet.getID()));
				}
			}
		});


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
			nameField.setText("MyRun");
		}

		try {
			timeField.setText(configuration.getAttribute(
					SimuComConfig.SIMULATION_TIME, ""));
		} catch (CoreException e) {
			timeField.setText("150000");
		}
		
		try {
			dataField.setText(configuration.getAttribute(
					SimuComConfig.DATASOURCE_ID, ""));
		} catch (CoreException e) {
			dataField.setText("1");
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
		configuration.setAttribute(SimuComConfig.DATASOURCE_ID,
				dataField.getText());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#setDefaults(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(SimuComConfig.EXPERIMENT_RUN,
				"MyRun");
		configuration.setAttribute(SimuComConfig.SIMULATION_TIME,
				"150000");
		configuration.setAttribute(SimuComConfig.DATASOURCE_ID,
				1/*TODO*/);
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
		if (dataField.getText().equals("")){
			setErrorMessage("Data source is missing!");
			return false;
		}
		return true;
	}
}

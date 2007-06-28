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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.uka.ipd.sdq.dialogs.dataset.SensorDataSetDialog;
import de.uka.ipd.sdq.sensorfactory.SensorFrameworkDataset;
import de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;

/** @author roman */
public class SimuComConfigurationTab extends AbstractLaunchConfigurationTab {

	private Text nameField;
	private Text timeField;
	private Text dataField;

	protected int selectedDataSourceID;

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
		container.setLayout(new GridLayout());
		setControl(container);
		
		/** Create SimuCom section */
		final Group simucomGroup = new Group(container, SWT.NONE);
		simucomGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		final GridLayout gridLayout_1 = new GridLayout();
		gridLayout_1.numColumns = 3;
		simucomGroup.setLayout(gridLayout_1);
		simucomGroup.setText("SimuCom");

		final Label timeLabel = new Label(simucomGroup, SWT.NONE);
		timeLabel.setText("Maximum simulation time:");

		timeField = new Text(simucomGroup, SWT.BORDER);
		timeField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		timeField.addModifyListener(modifyListener);

		final Label secLabel = new Label(simucomGroup, SWT.NONE);
		secLabel.setText("Simulated Seconds");

		/** Create Experiment Run section */
		final Group experimentrunGroup = new Group(container, SWT.NONE);
		experimentrunGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		experimentrunGroup.setLayout(gridLayout);
		experimentrunGroup.setText("Experiment Run");
		
		Label nameLabel = new Label(experimentrunGroup, SWT.NONE);
		nameLabel.setText("Experiment Name:");

		nameField = new Text(experimentrunGroup, SWT.BORDER);
		final GridData gd_nameField = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gd_nameField.widthHint = 70;
		nameField.setLayoutData(gd_nameField);
		nameField.addModifyListener(modifyListener);

		/**DataSet group */
		final Group dataSetGroup = new Group(container, SWT.NONE);
		dataSetGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		final GridLayout gridLayout_2 = new GridLayout();
		gridLayout_2.numColumns = 3;
		dataSetGroup.setLayout(gridLayout_2);
		dataSetGroup.setText("Data Set");

		final Label dataSourceLabel = new Label(dataSetGroup, SWT.NONE);
		dataSourceLabel.setText("Data source:");

		dataField = new Text(dataSetGroup, SWT.BORDER | SWT.READ_ONLY);
		dataField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		dataField.addModifyListener(modifyListener);

		final Button browseButton = new Button(dataSetGroup, SWT.NONE);
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
					selectedDataSourceID = (int) dataSet.getID();
					dataField.setText(dataSet.getName());
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
			selectedDataSourceID = 
				configuration.getAttribute(
						SimuComConfig.DATASOURCE_ID, -1);
			if (SensorFrameworkDataset.singleton().getDataSourceByID(selectedDataSourceID) == null)
				dataField.setText("");
			else
				dataField.setText(SensorFrameworkDataset.singleton().getDataSourceByID(selectedDataSourceID).getName());
		} catch (CoreException e) {
			selectedDataSourceID = -1;
			dataField.setText("");
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
				selectedDataSourceID);
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
				-1);
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
		if (SensorFrameworkDataset.singleton().getDataSourceByID(selectedDataSourceID) == null){
			setErrorMessage("Data source is missing!");
			return false;
		}
		return true;
	}
}

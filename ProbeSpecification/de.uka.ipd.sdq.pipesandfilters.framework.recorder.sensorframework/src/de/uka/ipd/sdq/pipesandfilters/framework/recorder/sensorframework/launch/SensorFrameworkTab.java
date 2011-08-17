package de.uka.ipd.sdq.pipesandfilters.framework.recorder.sensorframework.launch;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.uka.ipd.sdq.sensorframework.SensorFrameworkDataset;
import de.uka.ipd.sdq.sensorframework.dialogs.dataset.ConfigureDatasourceDialog;
import de.uka.ipd.sdq.sensorframework.dialogs.dataset.DatasourceListLabelProvider;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

public class SensorFrameworkTab extends AbstractLaunchConfigurationTab {

	private Text dataField;

	protected int selectedDataSourceID;

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout());
		setControl(container);

		final ModifyListener modifyListener = new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				SensorFrameworkTab.this.setDirty(true);
				SensorFrameworkTab.this.updateLaunchConfigurationDialog();
			}
		};

		final Group dataSetGroup = new Group(container, SWT.NONE);
		dataSetGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false));
		final GridLayout gridLayout_2 = new GridLayout();
		gridLayout_2.numColumns = 3;
		dataSetGroup.setLayout(gridLayout_2);
		dataSetGroup.setText("Data Set");

		final Label dataSourceLabel = new Label(dataSetGroup, SWT.NONE);
		dataSourceLabel.setText("Data source:");

		dataField = new Text(dataSetGroup, SWT.BORDER | SWT.READ_ONLY);
		dataField
				.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		dataField.addModifyListener(modifyListener);

		final Button browseButton = new Button(dataSetGroup, SWT.NONE);
		browseButton.setText("Browse...");
		browseButton.addSelectionListener(new SelectionAdapter() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse
			 * .swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				ConfigureDatasourceDialog dialog = new ConfigureDatasourceDialog(
						e.display.getActiveShell(), "Select Datasource...",
						true);
				if (dialog.open() == Dialog.OK) {
					IDAOFactory dataSet = (IDAOFactory) dialog.getResult();
					selectedDataSourceID = (int) dataSet.getID();
					dataField.setText(dataSet.getName() + " ["
							+ dataSet.getID() + " ]");
				}
			}
		});

	}

	@Override
	public String getName() {
		return "SensorFramework";
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			selectedDataSourceID = configuration.getAttribute(
					SensorFrameworkConfig.DATASOURCE_ID, -1);
			if (SensorFrameworkDataset.singleton().getDataSourceByID(
					selectedDataSourceID) == null)
				dataField.setText("");
			else {
				IDAOFactory factory = SensorFrameworkDataset.singleton()
						.getDataSourceByID(selectedDataSourceID);
				dataField.setText(DatasourceListLabelProvider
						.dataSetRepresentation(factory));
			}
		} catch (CoreException e) {
			selectedDataSourceID = -1;
			dataField.setText("");
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(SensorFrameworkConfig.DATASOURCE_ID,
				selectedDataSourceID);

	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(SensorFrameworkConfig.DATASOURCE_ID, -1);
	}

	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		if (SensorFrameworkDataset.singleton().getDataSourceByID(
				selectedDataSourceID) == null) {
			setErrorMessage("Data source is missing!");
			return false;
		}
		return true;
	}
	
	@Override
	public void activated(ILaunchConfigurationWorkingCopy workingCopy) {}

	@Override
	public void deactivated(ILaunchConfigurationWorkingCopy workingCopy) {}

}

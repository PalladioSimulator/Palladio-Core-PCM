package de.uka.ipd.sdq.measurements.osscheduler.ui.tabs;

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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.uka.ipd.sdq.measurements.osscheduler.ui.Constants;
import de.uka.ipd.sdq.sensorframework.SensorFrameworkDataset;
import de.uka.ipd.sdq.sensorframework.dialogs.dataset.ConfigureDatasourceDialog;
import de.uka.ipd.sdq.sensorframework.dialogs.dataset.DatasourceListLabelProvider;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

public class StorageTab extends AbstractLaunchConfigurationTab {
	
	private Text dataField;
	protected int selectedDataSourceID;

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		final ModifyListener modifyListener = new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				StorageTab.this.setDirty(true);
				StorageTab.this.updateLaunchConfigurationDialog();
			}
		};
		setControl(container);
		container.setLayout(new GridLayout(3, false));
		
		
		final Label dataSourceLabel = new Label(container, SWT.NONE);
		dataSourceLabel.setText("Data source:");

		dataField = new Text(container, SWT.BORDER | SWT.READ_ONLY);
		dataField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		dataField.addModifyListener(modifyListener);
		
		final Button browseButton = new Button(container, SWT.NONE);
		browseButton.setText("Browse...");
		browseButton.addSelectionListener(new SelectionAdapter(){

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				ConfigureDatasourceDialog dialog = new ConfigureDatasourceDialog(e.display
						.getActiveShell(),"Select Datasource...", true);
				if (dialog.open() == Dialog.OK) {
					IDAOFactory dataSet = (IDAOFactory) dialog.getResult();
					selectedDataSourceID = (int) dataSet.getID();
					dataField.setText(dataSet.getName() + " [" + dataSet.getID() + " ]");
				}
			}
		});
		
	}

	@Override
	public String getName() {
		return "Measurement Results Storage";
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			selectedDataSourceID = 
				configuration.getAttribute(
						Constants.MEASUREMENTS_RESULTS_DATASOURCE_ID, -1);
			if (SensorFrameworkDataset.singleton().getDataSourceByID(selectedDataSourceID) == null)
				dataField.setText("");
			else {
				IDAOFactory factory = SensorFrameworkDataset.singleton().getDataSourceByID(selectedDataSourceID);
				dataField.setText(DatasourceListLabelProvider.dataSetRepresentation(factory));
			}
		} catch (CoreException e) {
			selectedDataSourceID = -1;
			dataField.setText("");
		}	
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		System.out.println("X");
		configuration.setAttribute(Constants.MEASUREMENTS_RESULTS_DATASOURCE_ID,
				selectedDataSourceID);
		System.out.println("Y");
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(Constants.MEASUREMENTS_RESULTS_DATASOURCE_ID,
				-1);		
	}
}

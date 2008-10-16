package de.uka.ipd.sdq.sensorframework.dialogs.dataset;


import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Shell;

import de.uka.ipd.sdq.sensorframework.SensorFrameworkDataset;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

/** @author Roman Andrej */
public class ConfigureDatasourceDialog extends DatasourceDialog {
	
    public static String OPEN_WIZARD_TITLE = "Load a source storage for the sensor framework.";
    public static String ADD_WIZARD_TITLE = "Select/create a storage for the sensor framework.";
    
    private SensorFrameworkDataset dataset;

	public ConfigureDatasourceDialog(Shell parentShell, String dialogTitel, boolean makeValidation,
			final SensorFrameworkDataset dataset) {
		super(parentShell, dialogTitel, dataset.getDataSources(), makeValidation);
		this.dataset = dataset;
		create();
		setRemoveButtonAction(new SelectionAdapter() {

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				IDAOFactory selectedSource = (IDAOFactory) getResult();
				dataset.removeDataSource(
						selectedSource);
				refresh();
			}
		});
		
		setAddButtonAction(new SelectionAdapter(){

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				AddNewDatasourceWizard w = new AddNewDatasourceWizard(dataset);
				//w.init(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getWorkbench(),
			    //       null);
			    // Instantiates the wizard container with the wizard and opens it
			    WizardDialog dialog = new WizardDialog(e.display.getActiveShell(), w);
			    dialog.create();
			    dialog.setTitle(ADD_WIZARD_TITLE);
			    dialog.open();			    
			    refresh();
			}
			
		});
		
		setOpenButtonAction(new SelectionAdapter(){

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {

				OpenDatasourceWizard w = new OpenDatasourceWizard(dataset);

				// Instantiates the wizard container with the wizard and opens it
				WizardDialog dialog = new WizardDialog(e.display
						.getActiveShell(), w);
				dialog.create();
				dialog.setTitle(OPEN_WIZARD_TITLE);
				dialog.open();
				refresh();
			}
		});
	}
}

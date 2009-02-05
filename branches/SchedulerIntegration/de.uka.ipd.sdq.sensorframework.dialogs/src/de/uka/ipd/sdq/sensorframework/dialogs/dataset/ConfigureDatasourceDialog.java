package de.uka.ipd.sdq.sensorframework.dialogs.dataset;


import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Shell;

import de.uka.ipd.sdq.sensorframework.SensorFrameworkDataset;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

/** @author Roman Andrej */
public class ConfigureDatasourceDialog extends DatasourceDialog {
	
    public static String OPEN_WISARD_TITLE = "Load a source storage for the sensor framework.";
    public static String ADD_WIZARD_TITLE = "Select/create a storage for the sensor framework.";

	public ConfigureDatasourceDialog(Shell parentShell, String dialogTitel, boolean makeValidation) {
		super(parentShell, dialogTitel, SensorFrameworkDataset
				.singleton().getDataSources(), makeValidation);
		create();
		setRemoveButtonAction(new SelectionAdapter() {

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				IDAOFactory selectedSource = (IDAOFactory) getResult();
				SensorFrameworkDataset.singleton().removeDataSource(
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
				AddNewDatasourceWizard w = new AddNewDatasourceWizard();
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

				OpenDatasourceWizard w = new OpenDatasourceWizard();

				// Instantiates the wizard container with the wizard and opens it
				WizardDialog dialog = new WizardDialog(e.display
						.getActiveShell(), w);
				dialog.create();
				dialog.setTitle(OPEN_WISARD_TITLE);
				dialog.open();
				refresh();
			}
		});
	}
}

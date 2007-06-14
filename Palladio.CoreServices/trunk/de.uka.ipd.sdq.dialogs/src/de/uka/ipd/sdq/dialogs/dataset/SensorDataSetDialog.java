package de.uka.ipd.sdq.dialogs.dataset;

import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Shell;

import de.uka.ipd.sdq.sensorfactory.SensorFrameworkDataset;
import de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory;

/** @author roman */
public class SensorDataSetDialog extends DataSetDialog {

	public SensorDataSetDialog(Shell parentShell) {
		super(parentShell, SensorFrameworkDataset.singleton().getDataSources());
		create();
		setRemoveButtonAction(new SelectionAdapter(){

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				IDAOFactory selectedSource = (IDAOFactory) getResult();
			    SensorFrameworkDataset.singleton().removeDataSource(selectedSource);
				refresh();
			}
		});
		
		setAddButtonAction(new SelectionAdapter(){

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				DataSetAddWizard w = new DataSetAddWizard();
				//w.init(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getWorkbench(),
			    //       null);
			    // Instantiates the wizard container with the wizard and opens it
			    WizardDialog dialog = new WizardDialog(SensorDataSetDialog.this.getShell(), w);
			    dialog.create();
			    dialog.setTitle("Select/create datastore");
			    dialog.open();			    
			    refresh();
			}
			
		});
	}
	
}

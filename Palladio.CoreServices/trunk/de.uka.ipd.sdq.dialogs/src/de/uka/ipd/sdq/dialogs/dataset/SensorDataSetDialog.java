package de.uka.ipd.sdq.dialogs.dataset;

import java.io.File;

import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import de.uka.ipd.sdq.sensorfactory.SensorFrameworkDataset;
import de.uka.ipd.sdq.sensorfactory.dao.db4o.DB4ODAOFactory;
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
		
		setOpenButtonAction(new SelectionAdapter(){

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				String result = "";
				FileDialog dialog = new FileDialog(getShell(), SWT.OPEN);
				dialog.setText("Select DataSet file");

				if (dialog.open() != null) {
					result = dialog.getFilterPath() + File.separatorChar
							+ dialog.getFileName();

					SensorFrameworkDataset.singleton().addDataSource(
							new DB4ODAOFactory(result));
					refresh();
				}
			}
			
		});
	}
	
	/**
	 * The function calls the FileDialog and give back absolute path on the file
	 * as String
	 * 
	 * @return absolute path to a file
	 */
	private String openDataFileDialog() {

		FileDialog dialog = new FileDialog(getShell(), SWT.OPEN);
		dialog.setText("Select model file");

		if (dialog.open() != null)
			return dialog.getFilterPath() + File.separatorChar + dialog.getFileName();
		
		return null;
	}
	
}

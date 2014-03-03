package de.uka.ipd.sdq.edp2.ui.dialogs.datasource;


import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Shell;

import de.uka.ipd.sdq.edp2.EDP2Plugin;
import de.uka.ipd.sdq.edp2.impl.RepositoryManager;
import de.uka.ipd.sdq.edp2.models.Repository.Repository;
import de.uka.ipd.sdq.edp2.ui.wizards.datasource.OpenDataSourceWizard;

/**
 * Dialog to manage EDP2 repositories used as data sources from within a run configuration.
 *      
 * @author Sebastian Lehrig
 * */
public class ConfigureDatasourceDialog extends DatasourceDialog {
	
    public static String OPEN_WISARD_TITLE = "Load a source storage for EDP2.";
    public static String ADD_WIZARD_TITLE = "Select/create a storage for EDP2.";

	public ConfigureDatasourceDialog(Shell parentShell, String dialogTitel, boolean makeValidation) {
		super(parentShell, dialogTitel, EDP2Plugin.INSTANCE.getRepositories().getAvailableRepositories(), makeValidation);
		create();
		setRemoveButtonAction(new SelectionAdapter() {

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				Repository selectedRepository = (Repository) getResult();
				RepositoryManager.removeRepository(EDP2Plugin.INSTANCE.getRepositories(), selectedRepository);
				refresh();
			}
		});
		
		setAddButtonAction(new SelectionAdapter(){

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
			    OpenDataSourceWizard w = new OpenDataSourceWizard();
				//AddNewDataSourceWizard w = new AddNewDataSourceWizard();
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

				OpenDataSourceWizard w = new OpenDataSourceWizard();

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

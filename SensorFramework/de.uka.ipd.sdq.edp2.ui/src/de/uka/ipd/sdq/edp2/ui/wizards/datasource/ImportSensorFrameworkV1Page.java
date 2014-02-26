/**
 * 
 */
package de.uka.ipd.sdq.edp2.ui.wizards.datasource;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;

import de.uka.ipd.sdq.edp2.models.Repository.LocalSensorFrameworkRepository;

/**
 * @author groenda
 *
 */
public class ImportSensorFrameworkV1Page extends WizardPage {

	private LocalSensorFrameworkRepository lsfRepo;

	protected ImportSensorFrameworkV1Page(LocalSensorFrameworkRepository lsfRepo) {
		super("wizardPage");
		this.lsfRepo = lsfRepo;

		setTitle("Discover Local Memory Data Source");
		setDescription("Please select the data source you want to open.");
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		// TODO Auto-generated method stub

	}

}

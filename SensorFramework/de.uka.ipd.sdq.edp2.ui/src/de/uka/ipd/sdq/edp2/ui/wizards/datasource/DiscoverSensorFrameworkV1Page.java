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
public class DiscoverSensorFrameworkV1Page extends WizardPage {

	private LocalSensorFrameworkRepository lsfRepo;

	protected DiscoverSensorFrameworkV1Page(LocalSensorFrameworkRepository lsfRepo) {
		super("wizardPage");
		this.lsfRepo = lsfRepo;

		setTitle("Discover Local Memory Data Source");
		setDescription("Please select the data source you want to open.");
	}

	@Override
	public void createControl(Composite parent) {
		// TODO Auto-generated method stub
		
	}
	
}

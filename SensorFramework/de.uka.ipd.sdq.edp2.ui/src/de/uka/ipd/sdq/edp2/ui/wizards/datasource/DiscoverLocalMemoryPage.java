/**
 * 
 */
package de.uka.ipd.sdq.edp2.ui.wizards.datasource;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;

import de.uka.ipd.sdq.edp2.models.Repository.LocalMemoryRepository;

/**
 * @author groenda
 *
 */
public class DiscoverLocalMemoryPage extends WizardPage {

	private LocalMemoryRepository lmRepo;

	protected DiscoverLocalMemoryPage(LocalMemoryRepository lmRepo) {
		super("wizardPage");
		this.lmRepo = lmRepo;

		setTitle("Discover Local Memory Data Source");
		setDescription("Please select the data source you want to open.");
	}

	@Override
	public void createControl(Composite parent) {
		// TODO Auto-generated method stub
	}
	
}

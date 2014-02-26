/**
 * 
 */
package de.uka.ipd.sdq.edp2.ui.wizards.datasource;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;

import de.uka.ipd.sdq.edp2.models.Repository.RemoteCdoRepository;

/**
 * @author groenda
 *
 */
public class DiscoverRemotePage extends WizardPage {

	private RemoteCdoRepository rcRepo;

	protected DiscoverRemotePage(RemoteCdoRepository rcRepo) {
		super("wizardPage");
		this.rcRepo = rcRepo;

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

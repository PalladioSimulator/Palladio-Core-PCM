/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dialogs.dataset;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;

import de.uka.ipd.sdq.sensorframework.SensorFrameworkDataset;
import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorframework.dialogs.SensorFrameworkDialogPlugin;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

/**
 * The OpenDatasourceWizard allows the user to choose which data source file to
 * run.
 * 
 * @author Roman Andrej
 */
public class OpenDatasourceWizard extends Wizard {

	
	private WizardDatasourceLoadPage db40DatasourceLoadPage, fileDatasourceLoadPage;
	private WizardSelectDatasourcePage selectDatasourceTypePage;

	public OpenDatasourceWizard() {
		super();
		this.setWindowTitle("Load datastore...");
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {
		super.addPages();

		selectDatasourceTypePage = new WizardSelectDatasourcePage(
				"Select Type of Datasource to load", false, true, true);
		this.addPage(selectDatasourceTypePage);

		db40DatasourceLoadPage = new WizardDatasourceLoadPage("Open the database file",
				IResource.FILE);
		this.addPage(db40DatasourceLoadPage);

		fileDatasourceLoadPage = new WizardDatasourceLoadPage(
				"Open the database folder", IResource.FOLDER);
		this.addPage(fileDatasourceLoadPage);
	}

	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		IDAOFactory factory = null;
		IPath path = null;

		if (selectDatasourceTypePage.getResult().equals(
				WizardSelectDatasourcePage.FILE_DATASRC)) {
			path = fileDatasourceLoadPage.getFileFullPath();

			try {
				factory = new FileDAOFactory(path.toOSString());
				SensorFrameworkDataset.singleton().addDataSource(factory);
			} catch (Throwable e) {
				MessageDialog.openError(getShell(), "File DAO factory error.",
						e.getMessage());
				SensorFrameworkDialogPlugin.log(IStatus.ERROR, e.getMessage());
				return false;
			}

		} else {
			return false;
		}

		return true;
	}

	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#canFinish()
	 */
	@Override
	public boolean canFinish() {
		if (selectDatasourceTypePage.getResult().equals(
				WizardSelectDatasourcePage.FILE_DATASRC)) {
			return fileDatasourceLoadPage.isPageComplete();
		}
		return false;
	}
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#getNextPage(org.eclipse.jface.wizard.IWizardPage)
	 */
	@Override
	public IWizardPage getNextPage(IWizardPage page) {

		if (page instanceof WizardSelectDatasourcePage) {
			WizardSelectDatasourcePage data_type_page = (WizardSelectDatasourcePage) page;
			if (data_type_page.getResult().equals(
					WizardSelectDatasourcePage.FILE_DATASRC)) {
				return fileDatasourceLoadPage;
			}
		}
		return null;
	}
}

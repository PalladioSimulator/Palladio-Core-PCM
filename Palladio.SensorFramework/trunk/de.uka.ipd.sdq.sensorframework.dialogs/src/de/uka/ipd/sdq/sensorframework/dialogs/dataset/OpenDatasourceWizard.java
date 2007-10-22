/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dialogs.dataset;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;

import de.uka.ipd.sdq.sensorframework.SensorFrameworkDataset;
import de.uka.ipd.sdq.sensorframework.dao.db4o.DB4ODAOFactory;
import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

/**
 * The OpenDatasourceWizard allows the user to choose which data source file to
 * run.
 * 
 * @author Roman Andrej
 */
public class OpenDatasourceWizard extends Wizard {

	
	private WizardDatasourceLoadPage fileLoadPage, folderLoadPage;
	private String result;
	private WizardSelectDatasourcePage selectTypePage;

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

		selectTypePage = new WizardSelectDatasourcePage(
				"Select Type of Datasource to load", false, true, true);
		this.addPage(selectTypePage);

		fileLoadPage = new WizardDatasourceLoadPage("Open the database file",
				IResource.FILE);
		this.addPage(fileLoadPage);

		folderLoadPage = new WizardDatasourceLoadPage(
				"Open the database folder", IResource.FOLDER);
		this.addPage(folderLoadPage);
	}

	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		IDAOFactory factory = null;

		if (selectTypePage.getResult().equals(
				WizardSelectDatasourcePage.DB4O_DATASRC)) {
			IPath path = fileLoadPage.getFileFullPath();
			result = path.toOSString();
			factory = new DB4ODAOFactory(path.toOSString());
		}

		if (selectTypePage.getResult().equals(
				WizardSelectDatasourcePage.FILE_DATASRC)) {
			IPath path = folderLoadPage.getFileFullPath();
			result = path.toOSString();
			factory = new FileDAOFactory(result);
		}

		SensorFrameworkDataset.singleton().addDataSource(factory);
		return true;
	}

	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#canFinish()
	 */
	@Override
	public boolean canFinish() {
		if (selectTypePage.getResult().equals(
				WizardSelectDatasourcePage.DB4O_DATASRC)) {
			return fileLoadPage.isPageComplete();
		}
		if (selectTypePage.getResult().equals(
				WizardSelectDatasourcePage.FILE_DATASRC)) {
			return folderLoadPage.isPageComplete();
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
					WizardSelectDatasourcePage.DB4O_DATASRC)) {
				return fileLoadPage;
			} else if (data_type_page.getResult().equals(
					WizardSelectDatasourcePage.FILE_DATASRC)) {
				return folderLoadPage;
			}
		}
		return null;
	}

	public String getResult() {
		return result;
	}
}

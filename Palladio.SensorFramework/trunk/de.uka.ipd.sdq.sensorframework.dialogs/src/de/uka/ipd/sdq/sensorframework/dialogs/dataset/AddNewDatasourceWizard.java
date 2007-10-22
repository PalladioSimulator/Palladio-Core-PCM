package de.uka.ipd.sdq.sensorframework.dialogs.dataset;

import java.io.File;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.dialogs.WizardNewFolderMainPage;

import de.uka.ipd.sdq.sensorframework.SensorFrameworkDataset;
import de.uka.ipd.sdq.sensorframework.dao.db4o.DB4ODAOFactory;
import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorframework.dao.memory.MemoryDAOFactory;

public class AddNewDatasourceWizard extends Wizard {

	private WizardNewFolderMainPage newFolderPage;
	private WizardNewFileCreationPage newDBpage;
	private String result;
	private WizardSelectDatasourcePage selectTypePage;

	public AddNewDatasourceWizard() {
		super();
		this.setWindowTitle("Select/create datastore...");
	}

	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {
		super.addPages();

		selectTypePage = new WizardSelectDatasourcePage(
				"Select Type of Datasource to create", true, true, true);
		this.addPage(selectTypePage);

		newDBpage = new WizardNewFileCreationPage("Create new database",
				new TreeSelection());
		this.addPage(newDBpage);

		newFolderPage = new WizardNewFolderMainPage(
				"Create new data directory", new TreeSelection());
		this.addPage(newFolderPage);
	}

	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		
		if (selectTypePage.getResult().equals("Memory Datasource")) {
			
			SensorFrameworkDataset.singleton().addDataSource(
					new MemoryDAOFactory(""));
			
		} else if (selectTypePage.getResult().equals("DB4O Datasource")) {
			
			IPath rootPath = ResourcesPlugin.getWorkspace().getRoot()
					.getLocation();
			IPath path = newDBpage.getContainerFullPath();
			result = rootPath.toOSString() + path.toOSString()
					+ File.separatorChar + newDBpage.getFileName();
			SensorFrameworkDataset.singleton().addDataSource(
					new DB4ODAOFactory(result));
			
		} else if (selectTypePage.getResult().equals("File Datasource")) {
			
			IPath rootPath = ResourcesPlugin.getWorkspace().getRoot()
					.getLocation();
			IPath path = newFolderPage.createNewFolder().getFullPath();
			SensorFrameworkDataset.singleton().addDataSource(
					new FileDAOFactory(rootPath.toOSString()
							+ path.toOSString()));
		}
		return true;
	}

	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#canFinish()
	 */
	@Override
	public boolean canFinish() {
		if (selectTypePage.getResult().equals("Memory Datasource")) {
			return true;
		} else if (selectTypePage.getResult().equals("DB4O Datasource")) {
			return newDBpage.isPageComplete();
		} else if (selectTypePage.getResult().equals("File Datasource")) {
			return newFolderPage.isPageComplete();
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
			
			if (data_type_page.getResult().equals("DB4O Datasource")) {
				return newDBpage;
			} else if (data_type_page.getResult().equals("File Datasource")) {
				return newFolderPage;
			}
		}
		return null;
	}

	public String getResult() {
		return result;
	}
}


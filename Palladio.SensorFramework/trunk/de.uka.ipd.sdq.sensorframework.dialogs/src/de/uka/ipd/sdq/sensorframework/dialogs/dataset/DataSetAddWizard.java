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

public class DataSetAddWizard extends Wizard {

	private WizardNewFolderMainPage newFolderPage;
	private WizardNewFileCreationPage newDBpage;
	private String result;
	private WizardSelectDataTypePage selectTypePage;

	public DataSetAddWizard() {
		super();
		this.setWindowTitle("Select/create a new result storage for the sensor framework");
	}

	@Override
	public void addPages() {
		super.addPages();
		selectTypePage = new WizardSelectDataTypePage("Select Type of Datasource");
		this.addPage(selectTypePage);
		newDBpage = new WizardNewFileCreationPage("Create new database", new TreeSelection());
		newFolderPage = new WizardNewFolderMainPage("Create new data directory",  new TreeSelection());
		this.addPage(newDBpage);
		this.addPage(newFolderPage);
	}

	public boolean performFinish() {
		if (selectTypePage.getResult().equals("Memory Datasource")) {
		    SensorFrameworkDataset.singleton().addDataSource(new MemoryDAOFactory(""));
		} else if (selectTypePage.getResult().equals("DB4O Datasource")) {
			IPath rootPath = ResourcesPlugin.getWorkspace().getRoot().getLocation();
			IPath path = newDBpage.getContainerFullPath();
			File f = path.makeAbsolute().toFile();
			result = rootPath.toOSString() + path.toOSString() + File.separatorChar + 
				newDBpage.getFileName();
		    SensorFrameworkDataset.singleton().addDataSource(new DB4ODAOFactory(result));
		} else if (selectTypePage.getResult().equals("File Datasource")){
			IPath rootPath = ResourcesPlugin.getWorkspace().getRoot().getLocation();
			IPath path = newFolderPage.createNewFolder().getFullPath();
			SensorFrameworkDataset.singleton().addDataSource(new FileDAOFactory(rootPath.toOSString() + path.toOSString()));
		}
		return true;
	}

	@Override
	public boolean canFinish() {
		if (selectTypePage.getResult().equals("Memory Datasource")) {
			return true;
		} else if (selectTypePage.getResult().equals("DB4O Datasource")) {
			return newDBpage.isPageComplete();
		} else if (selectTypePage.getResult().equals("File Datasource")){
			return newFolderPage.isPageComplete();
		}
		return false;
	}
	
	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		if (page instanceof WizardSelectDataTypePage) {
			WizardSelectDataTypePage data_type_page = (WizardSelectDataTypePage) page;
			if (data_type_page.getResult().equals("DB4O Datasource")){
				return newDBpage;
			} else if (data_type_page.getResult().equals("File Datasource")){
				return newFolderPage;
			}
		}
		return null;
		//return super.getNextPage(page);
	}

	public String getResult() {
		return result;
	}
}


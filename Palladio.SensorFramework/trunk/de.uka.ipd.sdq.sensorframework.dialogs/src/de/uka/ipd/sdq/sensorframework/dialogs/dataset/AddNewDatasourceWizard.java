package de.uka.ipd.sdq.sensorframework.dialogs.dataset;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.dialogs.WizardNewFolderMainPage;

import de.uka.ipd.sdq.dialogs.error.ErrorDisplayDialog;
import de.uka.ipd.sdq.sensorframework.SensorFrameworkDataset;
import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorframework.dao.memory.MemoryDAOFactory;
import de.uka.ipd.sdq.sensorframework.dialogs.SensorFrameworkDialogPlugin;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

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
			
		} else if (selectTypePage.getResult().equals("File Datasource")) {
			
			IPath rootPath = ResourcesPlugin.getWorkspace().getRoot()
					.getLocation();
			IPath path = newFolderPage.createNewFolder().getFullPath();
			try {
				IDAOFactory fileFactory = new FileDAOFactory(rootPath.toOSString()
						+ path.toOSString()); 
				SensorFrameworkDataset.singleton().addDataSource(
						fileFactory);
			} catch (Exception ex) {
				MessageDialog.openError(getShell(), "File DAO factory error.",
						ex.getMessage());
				SensorFrameworkDialogPlugin.log(IStatus.ERROR, ex.getMessage() == null ? "" : ex.getMessage());
				return false;
			}
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
	
	private class ErrorDisplayRunner implements Runnable {
		private Throwable e;

		/**
		 * @param e the throwable to display in the error
		 * display dialog
		 */
		public ErrorDisplayRunner(Throwable e) {
			super();
			this.e = e;
		}

		public void run() {
			new ErrorDisplayDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getShell(), e).open();
		}
	}
	
}


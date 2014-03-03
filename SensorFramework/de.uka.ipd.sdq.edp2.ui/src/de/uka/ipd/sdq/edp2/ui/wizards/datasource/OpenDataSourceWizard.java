/**
 * 
 */
package de.uka.ipd.sdq.edp2.ui.wizards.datasource;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;

import de.uka.ipd.sdq.edp2.EDP2Plugin;
import de.uka.ipd.sdq.edp2.impl.RepositoryManager;
import de.uka.ipd.sdq.edp2.models.Repository.LocalDirectoryRepository;
import de.uka.ipd.sdq.edp2.models.Repository.LocalMemoryRepository;
import de.uka.ipd.sdq.edp2.models.Repository.LocalSensorFrameworkRepository;
import de.uka.ipd.sdq.edp2.models.Repository.RemoteCdoRepository;
import de.uka.ipd.sdq.edp2.models.Repository.Repositories;
import de.uka.ipd.sdq.edp2.models.Repository.RepositoryFactory;

/**
 * @author groenda
 *
 */
public class OpenDataSourceWizard extends Wizard {
	Repositories repos;
	private DiscoverLocalDirectoryPage discoverLocalFilePage;
	private DiscoverLocalMemoryPage discoverLocalMemoryPage;
	private DiscoverRemotePage discoverRemotePage;
	private DiscoverSensorFrameworkV1Page discoverSensorFrameworkV1Page;
	private ImportSensorFrameworkV1Page importSensorFrameworkV1Page;
	private SelectDataSourceTypePage selectDataSourceTypePage;
	private LocalDirectoryRepository ldRepo;
	private LocalMemoryRepository lmRepo;
	private LocalSensorFrameworkRepository lsfRepo;
	private RemoteCdoRepository rcRepo;

	public OpenDataSourceWizard() {
		// Create empty list of storage nodes
		ldRepo = RepositoryFactory.eINSTANCE.createLocalDirectoryRepository();
		lmRepo = RepositoryFactory.eINSTANCE.createLocalMemoryRepository();
		lsfRepo = RepositoryFactory.eINSTANCE.createLocalSensorFrameworkRepository();
		rcRepo = RepositoryFactory.eINSTANCE.createRemoteCdoRepository();
	}
	
	@Override
	public void addPages() {
		// Select type of storage node and store it in the list of nodes
		selectDataSourceTypePage = new SelectDataSourceTypePage(); 
		addPage(selectDataSourceTypePage);
		discoverLocalFilePage = new DiscoverLocalDirectoryPage(ldRepo); 
		addPage(discoverLocalFilePage);
		discoverLocalMemoryPage = new DiscoverLocalMemoryPage(lmRepo); 
		//addPage(discoverLocalMemoryPage);
		discoverRemotePage = new DiscoverRemotePage(rcRepo); 
		//addPage(discoverRemotePage);
		discoverSensorFrameworkV1Page = new DiscoverSensorFrameworkV1Page(lsfRepo); 
		//addPage(discoverSensorFrameworkV1Page);
		importSensorFrameworkV1Page = new ImportSensorFrameworkV1Page(lsfRepo); 
		//addPage(importSensorFrameworkV1Page);
	}
	
	@Override
	public String getWindowTitle() {
		return "Open Data Source";
	}

	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		if (page == selectDataSourceTypePage) {
			// Initial Data Source Selection Page
			if (selectDataSourceTypePage.getSelection().equals(SelectDataSourceTypePage.NO_TYPE_SELECTED)) {
				return null;
			} else if (selectDataSourceTypePage.getSelection().equals(SelectDataSourceTypePage.FILE_DATA_SOURCE)) {
				return discoverLocalFilePage;
			} else if (selectDataSourceTypePage.getSelection().equals(SelectDataSourceTypePage.IN_MEMORY_DATA_SOURCE)) {
				return discoverLocalMemoryPage;
			} else if (selectDataSourceTypePage.getSelection().equals(SelectDataSourceTypePage.REMOTE_DATA_SOURCE)) {
				return discoverRemotePage;
			} else if (selectDataSourceTypePage.getSelection().equals(SelectDataSourceTypePage.SENSORFRAMEWORK_V1_DATA_SOURCE)) {
				return discoverSensorFrameworkV1Page;
			} else {
				// This line should never be reached. Otherwise there likely are unaccounted data source types.
				assert(false);
			}
		}
		if (page == discoverSensorFrameworkV1Page) {
			return importSensorFrameworkV1Page;
		}
		return null;
	}
	
	@Override
	public boolean canFinish() {
		if (selectDataSourceTypePage.isPageComplete()) {
			if (selectDataSourceTypePage.getSelection().equals(SelectDataSourceTypePage.FILE_DATA_SOURCE)) {
				if (discoverLocalFilePage.isPageComplete()) {
					return true;
				}
			} else if (selectDataSourceTypePage.getSelection().equals(SelectDataSourceTypePage.IN_MEMORY_DATA_SOURCE)) {
				if (discoverLocalMemoryPage.isPageComplete()) {
					return true;
				}
			} else if (selectDataSourceTypePage.getSelection().equals(SelectDataSourceTypePage.REMOTE_DATA_SOURCE)) {
				if (discoverRemotePage.isPageComplete()) {
					return true;
				}
			} else if (selectDataSourceTypePage.getSelection().equals(SelectDataSourceTypePage.SENSORFRAMEWORK_V1_DATA_SOURCE)) {
				if (discoverSensorFrameworkV1Page.isPageComplete() && importSensorFrameworkV1Page.isPageComplete()) {
					return true;
				}
			}
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		assert(!selectDataSourceTypePage.getSelection().equals(SelectDataSourceTypePage.NO_TYPE_SELECTED));
		
		if (selectDataSourceTypePage.getSelection().equals(SelectDataSourceTypePage.FILE_DATA_SOURCE)) {
			RepositoryManager.addRepository(EDP2Plugin.INSTANCE.getRepositories(), ldRepo);
		} else if (selectDataSourceTypePage.getSelection().equals(SelectDataSourceTypePage.IN_MEMORY_DATA_SOURCE)) {
			RepositoryManager.addRepository(EDP2Plugin.INSTANCE.getRepositories(), lmRepo);
		} else if (selectDataSourceTypePage.getSelection().equals(SelectDataSourceTypePage.REMOTE_DATA_SOURCE)) {
			RepositoryManager.addRepository(EDP2Plugin.INSTANCE.getRepositories(), rcRepo);
		} else if (selectDataSourceTypePage.getSelection().equals(SelectDataSourceTypePage.SENSORFRAMEWORK_V1_DATA_SOURCE)) {
			RepositoryManager.addRepository(EDP2Plugin.INSTANCE.getRepositories(), lsfRepo);
		} else {
			// This line should never be reached. Otherwise there likely are unaccounted data source types.
			assert(false);
			return false;
		}
		return true;
	}

}

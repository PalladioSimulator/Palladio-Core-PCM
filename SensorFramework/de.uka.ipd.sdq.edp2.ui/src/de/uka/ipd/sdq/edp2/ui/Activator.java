package de.uka.ipd.sdq.edp2.ui;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.service.prefs.BackingStoreException;

import de.uka.ipd.sdq.edp2.impl.RepositoryManager;
import de.uka.ipd.sdq.edp2.models.Repository.LocalDirectoryRepository;
import de.uka.ipd.sdq.edp2.models.Repository.LocalMemoryRepository;
import de.uka.ipd.sdq.edp2.models.Repository.LocalSensorFrameworkRepository;
import de.uka.ipd.sdq.edp2.models.Repository.RemoteCdoRepository;
import de.uka.ipd.sdq.edp2.models.Repository.Repositories;
import de.uka.ipd.sdq.edp2.models.Repository.RepositoryFactory;

public class Activator extends AbstractUIPlugin {
	/** Logger for this class. */
	private static Logger logger = Logger.getLogger(Activator.class.getCanonicalName());
	
	/** Setting: Should there be an initial population or mock-up data of repositories? */
	private static String SETTING_INITIALLY_POPULATE_REPOSITORY = "populate_repository";
	
	// The plug-in ID
    public static final String PLUGIN_ID = "de.uka.ipd.sdq.edp2.ui";
    
	public static Activator INSTANCE;
	
	public Activator() {
		// initialize
		IScopeContext context = new ConfigurationScope();
		IEclipsePreferences node = context.getNode("de.uka.ipd.sdq.edp2.ui");
		Boolean populate = false;
		if (node != null) {
			populate = node.getBoolean(SETTING_INITIALLY_POPULATE_REPOSITORY, false);
			node.putBoolean(SETTING_INITIALLY_POPULATE_REPOSITORY, populate);
			try {
				node.flush();
			} catch (BackingStoreException e) {
				logger.log(Level.SEVERE, "Could not load/store preferences. ", e);
			}
		}
		if (populate) {
			populateRepository();
		}
		
		INSTANCE = this;
	}

	/**Populates the repositories instance with mock-up data.
	 * Only used and important for testing. Creation is controlled via a properties file.
	 */
	private void populateRepository() {
		RepositoryFactory repoFactory = RepositoryFactory.eINSTANCE;
		Repositories repos = getRepositories();
		
		LocalDirectoryRepository ldRepo = repoFactory.createLocalDirectoryRepository();
		ldRepo.setUri(URI.createPlatformPluginURI("/de.uka.ipd.sdq.edp2.examples/LocalRepository", true).toString());
		RepositoryManager.addRepository(repos, ldRepo);
		
		RemoteCdoRepository rcRepo = repoFactory.createRemoteCdoRepository();
		rcRepo.setUrl("tcp://localhost:2036");
		RepositoryManager.addRepository(repos, rcRepo);
		
		LocalMemoryRepository lmRepo = repoFactory.createLocalMemoryRepository();
		lmRepo.setDomain("Domain 1");
		RepositoryManager.addRepository(repos, lmRepo);
		
		LocalSensorFrameworkRepository lsfRepo = repoFactory.createLocalSensorFrameworkRepository();
		RepositoryManager.addRepository(repos, lsfRepo);
	}

	/**
	 * @return The Repositories instance containing all available repositories.
	 */
	public Repositories getRepositories() {
		return RepositoryManager.getCentralRepository();
	}

}

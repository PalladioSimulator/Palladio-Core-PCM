package de.uka.ipd.sdq.edp2.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.plugin.AbstractUIPlugin;

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
	
	/** Path to the file containing the settings for the UI plug-in. */
	private static String PROPERTY_SETTINGS_FILE = "ui_settings.properties";
	/** Setting: Should there be an initial population or mock-up data of repositories? */
	private static String SETTING_INITIALLY_POPULATE_REPOSITORY = "populate_repository";
	
	static Activator INSTANCE;
	
	public Activator() {
		// initialize
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(PROPERTY_SETTINGS_FILE));
			if (properties.get(SETTING_INITIALLY_POPULATE_REPOSITORY) == Boolean.TRUE) {
				populateRepository();
			}
		} catch (FileNotFoundException e) {
			logger.log(Level.WARNING, "Could not find properties file with settings " +
					"for the plugin. Expected filename is " + PROPERTY_SETTINGS_FILE + ", lookup path is " + new File(".").getParent());
		} catch (IOException e) {
			logger.log(Level.SEVERE, "IO error occured during properties file access. " +
					"Filename is " + PROPERTY_SETTINGS_FILE + ", error is " + e.getMessage());
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
		repos.getAvailableRepositories().add(ldRepo);
		
		RemoteCdoRepository rcRepo = repoFactory.createRemoteCdoRepository();
		rcRepo.setUrl("tcp://localhost:2036");
		repos.getAvailableRepositories().add(rcRepo);
		
		LocalMemoryRepository lmRepo = repoFactory.createLocalMemoryRepository();
		lmRepo.setDomain("Domain 1");
		repos.getAvailableRepositories().add(lmRepo);
		
		LocalSensorFrameworkRepository lsfRepo = repoFactory.createLocalSensorFrameworkRepository();
		repos.getAvailableRepositories().add(lsfRepo);
	}

	/**
	 * @return The Repositories instance containing all available repositories.
	 */
	public Repositories getRepositories() {
		return RepositoryManager.getCentralRepository();
	}

}

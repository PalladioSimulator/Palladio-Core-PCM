/**
 * 
 */
package de.uka.ipd.sdq.edp2.impl;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.URI;

import de.uka.ipd.sdq.edp2.models.Repository.LocalDirectoryRepository;
import de.uka.ipd.sdq.edp2.models.Repository.Repositories;
import de.uka.ipd.sdq.edp2.models.Repository.Repository;
import de.uka.ipd.sdq.edp2.models.Repository.RepositoryFactory;

/**Utility class to manage repositories.
 * @author groenda, Sebastian Lehrig
 *
 */
public class RepositoryManager {
	/** Logger for this class. */
	private static Logger logger = Logger.getLogger(RepositoryManager.class.getCanonicalName());
	
	/** Central instance of a repository (singleton). */
	private static Repositories centralRepository = RepositoryFactory.eINSTANCE.createRepositories();
	
	/**Adds a repository to the list of repositories.
	 * The repository is automatically opened, if possible.
	 * @param repos The currently available repositories.
	 * @param newRepo The new repository to add.
	 */
	public static void addRepository(Repositories repos, Repository newRepo) {
		repos.getAvailableRepositories().add(newRepo);
		if (newRepo.canOpen()) {
			try {
				newRepo.open();
			} catch (DataNotAccessibleException e) {
				logger.log(Level.WARNING, "Could not open repository after adding it to repositories.", e);
			}
		}
	}
	
	/**Removes a repository from the given list of the available repositories.
	 * The repository is automatically closed, if possible.
	 * @param repos The currently available repositories.
	 * @param repo The repository to remove.
	 */
	public static void removeRepository(Repositories repos, Repository repo) {
		assert (repos.getAvailableRepositories().indexOf(repo) > -1); // repo must be in list
		if (repo.canClose()) {
			try {
				repo.close();
			} catch (DataNotAccessibleException e) {
				logger.log(Level.WARNING, "Could not close repository before removing it from the list.", e);
			}
		}
		repos.getAvailableRepositories().remove(repo);
		logger.log(Level.INFO, "Repository is removed.");
	}

	/**Provides access to a central repository.
	 * Convenience function to provide access to a singleton which can then be managed.
	 * @return Reference to the central repository.
	 */
	public static Repositories getCentralRepository() {
		return centralRepository;
	}
	
	/**Returns Repository with given UUID from central repository.
     * @return Reference to the repository with given UUID. Null if not found.
     */
    public static Repository getRepositoryFromUUID(String uuid) {
        for(Repository repository : centralRepository.getAvailableRepositories()) {
            if(repository.getUuid().equals(uuid)) {
                return repository;
            }
        }
        return null;
    }

	/**Creates and initialized a LocalDirectoryRepository.
	 * @param location The directory on the local machine which should be accessed by the repository.
	 * @return Initialized repository instance. <code>null</code> if the initialization failed.
	 */
	public static LocalDirectoryRepository initializeLocalDirectoryRepository(File location) {
		LocalDirectoryRepository ldRepo = RepositoryFactory.eINSTANCE.createLocalDirectoryRepository();
		String pathToRepo = location.getAbsolutePath();
		if (!location.exists()) {
			boolean result = location.mkdir();
			if (result == false) {
				logger.severe("Could not create directory at location " + pathToRepo);
				return null;
			}
		} else {
			if (!location.isDirectory()) {
				logger.severe("Directory can't be created. A file of the same name already exists. Location: " + pathToRepo);
				return null;
			}
		}
			
		String uriString = URI.createFileURI(pathToRepo).toString();
		ldRepo.setUri(uriString);
		logger.info("The repository has been initialized. Location: " + pathToRepo + ".");
		return ldRepo;
	}
	
}

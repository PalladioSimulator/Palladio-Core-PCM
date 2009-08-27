/**
 * 
 */
package de.uka.ipd.sdq.edp2.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import de.uka.ipd.sdq.edp2.models.emfmodel.Repository.Repositories;
import de.uka.ipd.sdq.edp2.models.emfmodel.Repository.Repository;
import de.uka.ipd.sdq.edp2.models.emfmodel.Repository.RepositoryFactory;

/**Utility class to manage repositories.
 * @author groenda
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
	}

	/**Provides access to a central repository.
	 * Convenience function to provide access to a singleton which can then be managed.
	 * @return Reference to the central repository.
	 */
	public static Repositories getCentralRepository() {
		return centralRepository;
	}
}

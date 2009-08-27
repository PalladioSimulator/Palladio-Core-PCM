import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.common.util.URI;

import de.uka.ipd.sdq.edp2.impl.DataNotAccessibleException;
import de.uka.ipd.sdq.edp2.impl.RepositoryManager;
import de.uka.ipd.sdq.edp2.models.emfmodel.Repository.LocalDirectoryRepository;
import de.uka.ipd.sdq.edp2.models.emfmodel.Repository.RepositoryFactory;

/**
 * 
 */

/**Contains an example how data can be stored with EDP2.
 * @author groenda
 */
public class StoreExample {
	/** (Relative) name of the directory in which the data of the example will be stored. */
	public static String DIRECTORY = "LocalRepository";
	/** Logger for this class. */
	private static Logger logger = Logger.getLogger(StoreExample.class.getCanonicalName());
	
	/** Repository which is used to store the data. */
	private LocalDirectoryRepository ldRepo;
	/** Helper class used to create all data for the example. */
	private ExampleData exampleData;
	
	/**Initializes an instance of this class.
	 */
	public StoreExample() {
		initializeRepository();
		exampleData = new ExampleData();
	}
	
	/**Initializes the repository in which the data will be stored.
	 */
	private void initializeRepository() {
		assert (ldRepo == null);
		// create local directory repository
		ldRepo = RepositoryFactory.eINSTANCE.createLocalDirectoryRepository();
		File ldRepoDirectory = new File(DIRECTORY);
		String pathToRepo = ldRepoDirectory.getAbsolutePath();
		if (!ldRepoDirectory.exists()) {
			boolean result = ldRepoDirectory.mkdir();
			if (result == false) {
				logger.severe("Could not create directory at location " + pathToRepo);
			}
		} else {
			if (!ldRepoDirectory.isDirectory()) {
				logger.severe("Directory can't be created. A file of the same name already exists. Location: " + pathToRepo);
			}
		}
			
		String uriString = URI.createFileURI(pathToRepo).toString();
		ldRepo.setUri(uriString);
		logger.info("The repository has been initialized. Location: " + pathToRepo + ".");
		
		/* Optional: add repository to a central directory of repositories. 
		 * This can be useful to manage more than one repository or have links
		 * between different existing repositories. */
		RepositoryManager.addRepository(RepositoryManager.getCentralRepository(), ldRepo);
	}
	
	
	private void createExample() {
		ldRepo.getDescription().addAll(exampleData.createDescriptions());
		ldRepo.getExperimentGroup().add(exampleData.createExperimentalGroupAndSetting());
		exampleData.simulateExperimentRun();
	}
	
	/**Opens the data store behind the repository, as this is a DAO.
	 * Access is only allowed to opened repositories. Repositories may be
	 * reopened (and the also reclosed).
	 * @throws DataNotAccessibleException if access to the repository fails. 
	 */
	private void openRepository() throws DataNotAccessibleException {
		/* Attention: Using addRepository() of RepositoryManager already opens
		 * the DAO. open() is only necessary if you don't use the convenience
		 * function. 
		 */
		if (!ldRepo.isOpen()) {
			ldRepo.open();
		}
		logger.info("Repository is now open.");
	}

	/**Closes the data store behind the repository, as this is a DAO.
	 * Access is only allowed to opened repositories. Repositories may be
	 * reopened (and the also reclosed).
	 * @throws DataNotAccessibleException if access to the repository fails. 
	 */
	private void closeRepository() throws DataNotAccessibleException {
		ldRepo.close();
		logger.info("Repository is now closed.");
	}
	
	/**Method body which executes all necessary steps to create and store an example.
	 */
	public void run() {
		try {
			openRepository();
			createExample();
			closeRepository();
		} catch (DataNotAccessibleException e) {
			logger.log(Level.SEVERE, "Error while accessing the datastore.", e);
		}
	}

	/**Main method to run the example.
	 * @param args Not used.
	 */
	public static void main(String[] args) {
		StoreExample example = new StoreExample();
		example.run();
	}
}

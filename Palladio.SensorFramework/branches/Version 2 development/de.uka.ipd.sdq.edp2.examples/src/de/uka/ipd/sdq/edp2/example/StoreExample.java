package de.uka.ipd.sdq.edp2.example;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import de.uka.ipd.sdq.edp2.impl.DataNotAccessibleException;
import de.uka.ipd.sdq.edp2.impl.RepositoryManager;
import de.uka.ipd.sdq.edp2.models.emfmodel.Repository.LocalDirectoryRepository;

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
		ldRepo = RepositoryManager.initializeLocalDirectoryRepository(new File(DIRECTORY));
		/* Add repository to a (optional) central directory of repositories. 
		 * This can be useful to manage more than one repository or have links
		 * between different existing repositories. 
		 * A repository must be connected to a instance of Repositories in order
		 * to be opened.*/
		RepositoryManager.addRepository(RepositoryManager.getCentralRepository(), ldRepo);
	}
	
	/**Opens the data store behind the repository, as this is a DAO.
	 * Access is only allowed to opened repositories. Repositories may be
	 * reopened (and the also reclosed).
	 * @throws DataNotAccessibleException if access to the repository fails. 
	 */
	private void openRepository() throws DataNotAccessibleException {
		/* Attention: Using addRepository() of RepositoryManager already opens
		 * the DAO. open() is only necessary if you don't use the convenience
		 * function or closed the repository and want to reopen it. 
		 */
		if (!ldRepo.isOpen()) {
			ldRepo.open();
		}
		if (ldRepo.isOpen()) {
			logger.info("Repository is now open.");
		}
	}

	private void createExample() {
		ldRepo.getDescriptions().addAll(exampleData.createDescriptions());
		ldRepo.getExperimentGroups().add(exampleData.createExperimentalGroupAndSetting());
		exampleData.simulateExperimentRun();
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

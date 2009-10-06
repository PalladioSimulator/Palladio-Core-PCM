package de.uka.ipd.sdq.edp2.example;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import de.uka.ipd.sdq.edp2.impl.DataNotAccessibleException;
import de.uka.ipd.sdq.edp2.impl.RepositoryManager;
import de.uka.ipd.sdq.edp2.models.Repository.LocalDirectoryRepository;

/**
 * 
 */

/**Contains an example how data can be stored with EDP2.
 * @author groenda
 */
public class StoreLoadExample {
	/** (Relative) name of the directory in which the data of the example will be stored. */
	public static String DEFAULT_DIRECTORY = "LocalRepository";
	/** Logger for this class. */
	private static Logger logger = Logger.getLogger(StoreLoadExample.class.getCanonicalName());
	
	/** Repository which is used to store the data. */
	private LocalDirectoryRepository ldRepo;
	/** Helper class used to process data for the example. */
	private ExampleData exampleData;
	/** Directory which is used to store the measurements.*/
	private String directory;
	
	/**Initializes an instance of this class with the default directory as target.
	 */
	public StoreLoadExample() {
		this(DEFAULT_DIRECTORY);
	}
	
	/**Initializes an instance of this class.
	 * @param directory Directory to be used to store measurements.
	 */
	public StoreLoadExample(String directory) {
		this.directory = directory;
		initializeRepository();
		exampleData = new ExampleData();
	}
	
	/**Initializes the repository in which the data will be stored.
	 */
	private void initializeRepository() {
		ldRepo = RepositoryManager.initializeLocalDirectoryRepository(new File(directory));
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
	 * reopened (and then also reclosed).
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
			String storedData = exampleData.printStoredMeasurements(ldRepo);
			closeRepository();
			openRepository();
			String readData = exampleData.printStoredMeasurements(ldRepo);
			if (readData != null && !readData.equals(storedData)) {
				throw new IllegalStateException("Stored and loaded data is not equal. Stored: " + storedData + "\nLoaded: " + readData);
			}
			System.out.println(readData);
			closeRepository();
		} catch (DataNotAccessibleException e) {
			logger.log(Level.SEVERE, "Error while accessing the datastore.", e);
		}
	}

	/**Main method to run the example.
	 * @param args Not used.
	 */
	public static void main(String[] args) {
		StoreLoadExample example = new StoreLoadExample();
		example.run();
	}
}

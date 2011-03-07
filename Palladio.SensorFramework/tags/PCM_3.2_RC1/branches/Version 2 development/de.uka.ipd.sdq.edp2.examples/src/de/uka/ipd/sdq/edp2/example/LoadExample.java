package de.uka.ipd.sdq.edp2.example;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import de.uka.ipd.sdq.edp2.impl.DataNotAccessibleException;
import de.uka.ipd.sdq.edp2.impl.MeasurementsUtility;
import de.uka.ipd.sdq.edp2.impl.RepositoryManager;
import de.uka.ipd.sdq.edp2.models.Repository.LocalDirectoryRepository;


/**Contains an example how data can be loaded with EDP2.
 * @author groenda
 *
 */
public class LoadExample {
	/** (Relative) name of the directory in which the data of the example will be stored. */
	public static String DEFAULT_DIRECTORY = "LocalRepository";
	/** Logger for this class. */
	private static Logger logger = Logger.getLogger(LoadExample.class.getCanonicalName());

	/** Helper class used to process data for the example. */
	private final ExampleData exampleData;
	/** Repository which is used to store the data. */
	private final LocalDirectoryRepository ldRepo;

	/**Initializes an instance of the class with the default directory.
	 */
	public LoadExample() {
		this(DEFAULT_DIRECTORY);
	}
	
	/**Initializes an instance of this class.
	 * @param directory Directory to be used to store measurements.
	 */
	public LoadExample(final String directory) {
		ldRepo = initializeRepository(directory);
		exampleData = new ExampleData();
	}
	
	/**Initializes the repository in which the data will be stored.
	 * @param directory Path to directory in which the data should be stored.
	 * @return the initialized repository.
	 */
	private LocalDirectoryRepository initializeRepository(final String directory) {
		LocalDirectoryRepository repo = RepositoryManager.initializeLocalDirectoryRepository(new File(directory));
		/* Add repository to a (optional) central directory of repositories. 
		 * This can be useful to manage more than one repository or have links
		 * between different existing repositories. 
		 * A repository must be connected to an instance of Repositories in order
		 * to be opened.*/
		RepositoryManager.addRepository(RepositoryManager.getCentralRepository(), repo);
		return repo;
	}

	/**Method body which executes all necessary steps to create and store an example.
	 */
	public void run() {
		try {
			// Now, the repository can be accessed.
			MeasurementsUtility.ensureOpenRepository(ldRepo);
			System.out
					.println(exampleData.printStoredMeasurements(ldRepo, ldRepo
							.getExperimentGroups().get(
									ldRepo.getExperimentGroups().size() - 1)
							.getUuid()));
			MeasurementsUtility.ensureClosedRepository(ldRepo);
		} catch (DataNotAccessibleException e) {
			logger.log(Level.SEVERE, "Error while accessing the datastore.", e);
		}
	}

	/**Main method to run the example.
	 * @param args Not used.
	 */
	public static void main(String[] args) {
		LoadExample example = new LoadExample();
		example.run();
	}
}

package de.uka.ipd.sdq.edp2.example;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import de.uka.ipd.sdq.edp2.impl.DataNotAccessibleException;
import de.uka.ipd.sdq.edp2.impl.MeasurementsUtility;
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
	private final LocalDirectoryRepository ldRepo;
	/** Helper class used to process data for the example. */
	private final ExampleData exampleData;
	
	/**Initializes an instance of this class with the default directory as target.
	 */
	public StoreLoadExample() {
		this(DEFAULT_DIRECTORY);
	}
	
	/**Initializes an instance of this class.
	 * @param directory Directory to be used to store measurements.
	 */
	public StoreLoadExample(final String directory) {
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
	
	private void createExample() {
		// create metric descriptions and experiment meta data
		ldRepo.getDescriptions().addAll(
				exampleData.createExampleBaseMetricDescriptions(ldRepo
						.getDescriptions()));
		ldRepo.getDescriptions().addAll(
				exampleData.createExampleMetricSetDescriptions(ldRepo
						.getDescriptions()));
		exampleData.createExampleExperimentMetadata();
		ldRepo.getExperimentGroups().add(exampleData.getExampleExperimentGroup());
		// create experiment data
		exampleData.simulateExperimentRun();
	}
	
	/**Method body which executes all necessary steps to create and store an example.
	 */
	public void run() {
		try {
			// store
			MeasurementsUtility.ensureOpenRepository(ldRepo);
			createExample();
			String storedData = exampleData.printStoredMeasurements(ldRepo);
			MeasurementsUtility.ensureClosedRepository(ldRepo);

			// load
			MeasurementsUtility.ensureOpenRepository(ldRepo);
			String readData = exampleData.printStoredMeasurements(ldRepo);
			if (readData != null && !readData.equals(storedData)) {
				throw new IllegalStateException("Stored and loaded data is not equal. Stored: " + storedData + "\nLoaded: " + readData);
			}
			System.out.println(readData);
			MeasurementsUtility.ensureClosedRepository(ldRepo);
		} catch (DataNotAccessibleException e) {
			logger.log(Level.SEVERE, "Error while accessing the datastore.", e);
		}
	}

	/**Main method to run the example.
	 * @param args Not used.
	 */
	public static void main(final String[] args) {
		StoreLoadExample example = new StoreLoadExample();
		example.run();
	}
}

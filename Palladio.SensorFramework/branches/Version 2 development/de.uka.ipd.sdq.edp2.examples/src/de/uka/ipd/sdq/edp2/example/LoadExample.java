package de.uka.ipd.sdq.edp2.example;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.measure.Measure;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.edp2.OrdinalMeasurementsDao;
import de.uka.ipd.sdq.edp2.impl.DataNotAccessibleException;
import de.uka.ipd.sdq.edp2.impl.MeasurementsUtility;
import de.uka.ipd.sdq.edp2.impl.RepositoryManager;
import de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricSetDescription;
import de.uka.ipd.sdq.edp2.models.Repository.LocalDirectoryRepository;


/**Contains an example how data can be loaded with EDP2.
 * @author groenda
 *
 */
public class LoadExample {
	/** (Relative) name of the directory in which the data of the example will be stored. */
	public static String DIRECTORY = "LocalRepository";
	/** Logger for this class. */
	private static Logger logger = Logger.getLogger(LoadExample.class.getCanonicalName());

	/** Repository which is used to store the data. */
	private LocalDirectoryRepository ldRepo;

	/**Initializes the repository from which the data will be loaded.
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

	/**Method body which executes all necessary steps to create and store an example.
	 */
	@SuppressWarnings("unchecked")
	public void run() {
		try {
			initializeRepository();
			// Now, the repository can be accessed.
			if (ldRepo.getExperimentGroups().size() == 1) {
				// get DAOs
				EList<DataSeries> series = ldRepo.getExperimentGroups().get(0).getExperimentSettings().get(0).getExperimentRuns().get(0).getMeasurement().get(0).getMeasurementRange().get(0).getRawMeasurements().getDataSeries();
				OrdinalMeasurementsDao<Measure> omdSeries1 = MeasurementsUtility.getOrdinalMeasurementsDao(series.get(0));
				OrdinalMeasurementsDao<Measure> omdSeries2 = MeasurementsUtility.getOrdinalMeasurementsDao(series.get(1));
				// print stored data
				System.out.println("Stored example data");
				System.out.println("-------------------\n");
				// label data series according to metric definitions
				MetricSetDescription md = (MetricSetDescription) series.get(0).getRawMeasurements().getMeasurementRange().getMeasurement().getMeasure().getMetric();
				System.out.println(md.getSubsumedMetrics().get(0).getName() + "\t"
						+ md.getSubsumedMetrics().get(1).getName());
				// list data
				List<Measure> list1 = omdSeries1.getMeasurements();
				List<Measure> list2 = omdSeries2.getMeasurements();
				for (int pos = 0; pos < list1.size(); pos++) {
					System.out.println(list1.get(pos) + "\t" + list2.get(pos));
				}
			} else {
				logger.warning("The data in the repository is (at least not completely) created by StoreExample. Hence, data access will not be tested.");
			}
			ldRepo.close();
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

package de.uka.ipd.sdq.statistics.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import junit.framework.TestCase;
import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.statistics.CrossingMeanWarmUpFilter;

/**
 * Tests the {@link CrossingMeanWarmUpFilter}. This test case is intended for
 * manual testing only. For evaluating the outcome the date series needs to be
 * plotted (e.g. as time series) and compared manually.
 * 
 * @author Philipp Merkle
 * 
 */
public class TestCrossingMeanWarmUpFilter extends TestCase {

	public void testWarmUpFilter() {
		// Adjust path to data store here!
		String dataStorePath = "D:\\Studium\\Master\\HiWi IPD\\runtime-150909\\brs\\Data4";

		File dataStoreFolder = new File(dataStorePath);
		if (dataStoreFolder.exists()) {
			IDAOFactory factory = new FileDAOFactory(dataStorePath);
			Collection<Measurement> measurements = TestUtils.loadMeasurements(
					factory, 0, 0, 24);

			List<Double> samples = new ArrayList<Double>(measurements.size());
			for (Measurement m : measurements) {
				TimeSpanMeasurement tsm = (TimeSpanMeasurement) m;
				samples.add(tsm.getTimeSpan());
			}

			CrossingMeanWarmUpFilter filter = new CrossingMeanWarmUpFilter();
			int i = 0;
			for (Double sample : samples) {
				filter.offerSample(sample);
				if (filter.isStationary()) {
					System.out.println("Warm-Up Peroid: Up to measurement " + i);
					break;
				}
				++i;
			}

			factory.finalizeAndClose();
		} else {
			System.err.println("Could not find data store path \""
					+ dataStorePath + "\"");
		}
	}

}

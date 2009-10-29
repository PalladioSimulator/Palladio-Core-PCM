package de.uka.ipd.sdq.statistics.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import junit.framework.TestCase;
import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.statistics.CrossingMeanWarmUpFilter;
import de.uka.ipd.sdq.statistics.MCRWarmUpFilter;

public class TestCrossingMeanWarmUpFilter extends TestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testWarmUpFilter() {
		IDAOFactory factory = new FileDAOFactory(
				"D:\\Studium\\Master\\HiWi IPD\\runtime-150909\\brs\\Data4");
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
	}

}

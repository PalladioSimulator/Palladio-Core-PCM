/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dao.file.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import junit.framework.JUnit4TestAdapter;

import org.junit.BeforeClass;
import org.junit.Test;

import de.uka.ipd.sdq.sensorframework.SensorFrameworkDataset;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

/** TODO this test is not yet a part of a JUnit test suite
 * @author Ihssane El-Oudghiri
 * 
 */
public class FileFactoryTest {

	static IDAOFactory f;

	@BeforeClass
	public static void setUpBeforClass() {
		f = SensorFrameworkDataset.singleton().getDataSourceByID(2);
		Experiment e = f.createExperimentDAO().addExperiment("Test");
		ExperimentRun er1 = e.addExperimentRun("TestRun1");
		ExperimentRun er2 = e.addExperimentRun("TestRun2");
		TimeSpanSensor s1 = e.addTimeSpanSensor("ATimeSpanSensor1");
		TimeSpanSensor s2 = e.addTimeSpanSensor("ATimeSpanSensor2");

		double[] m1s1 = new double[] { 1.0, 2.0, 3.0, 4.0, 5.0 };
		double[] m1s2 = new double[] { 1.5, 2.5, 3.5, 4.5, 5.5 };
		double[] m2s1 = new double[] { 2.0, 2.0, 3.0, 1.0, 0.0, 7.4 };

		for (double d : m1s1)
			er1.addTimeSpanMeasurement(s1, d, d);
		for (double d : m1s2)
			er1.addTimeSpanMeasurement(s2, d, d);
		for (double d : m2s1)
			er2.addTimeSpanMeasurement(s1, d, d);

		f.finalizeAndClose();
	}

	@Test
	public void loadExperiment() {
		// IDAOFactory f =
		// SensorFrameworkDataset.singleton().getDataSourceByID(2);
		Experiment e1 = f.createExperimentDAO().get(0);
		Experiment e2 = new ArrayList<Experiment>(f.createExperimentDAO()
				.findByExperimentName("Test")).get(0);
		assertEquals("Test", e1.getExperimentName());
		assertEquals(0, e1.getExperimentID());
		assertEquals(2, e1.getSensors().size());
		assertEquals(2, e1.getExperimentRuns().size());
		assertEquals("ATimeSpanSensor1", ((List<Sensor>) e1.getSensors())
				.get(0).getSensorName());
		assertEquals("ATimeSpanSensor2", ((List<Sensor>) e1.getSensors())
				.get(1).getSensorName());
		assertEquals("TestRun1", ((List<ExperimentRun>) e1.getExperimentRuns())
				.get(0).getExperimentDateTime());
		assertEquals("TestRun2", ((List<ExperimentRun>) e1.getExperimentRuns())
				.get(1).getExperimentDateTime());

		assertEquals("Test", e2.getExperimentName());
		assertEquals(0, e2.getExperimentID());
		assertEquals(2, e2.getSensors().size());
		assertEquals(2, e2.getExperimentRuns().size());
		assertEquals("ATimeSpanSensor1", ((List<Sensor>) e2.getSensors())
				.get(0).getSensorName());
		assertEquals("ATimeSpanSensor2", ((List<Sensor>) e2.getSensors())
				.get(1).getSensorName());
		assertEquals("TestRun1", ((List<ExperimentRun>) e2.getExperimentRuns())
				.get(0).getExperimentDateTime());
		assertEquals("TestRun2", ((List<ExperimentRun>) e2.getExperimentRuns())
				.get(1).getExperimentDateTime());

	}

	@Test
	public void loadMeasurements() {
		// IDAOFactory f =
		// SensorFrameworkDataset.singleton().getDataSourceByID(2);
		Experiment e1 = f.createExperimentDAO().get(0);
		Sensor s1 = ((List<Sensor>) e1.getSensors()).get(0);
		Sensor s2 = ((List<Sensor>) e1.getSensors()).get(1);

		ExperimentRun r1 = ((List<ExperimentRun>) e1.getExperimentRuns())
				.get(0);
		ExperimentRun r2 = ((List<ExperimentRun>) e1.getExperimentRuns())
				.get(1);

		List<Measurement> m1s1 = (List<Measurement>) r1
				.getMeasurementsOfSensor(s1).getMeasurements();
		assertEquals(5, m1s1.size());
		double e = 10e-9;
		assertEquals(1.0, m1s1.get(0).getEventTime(), e);
		assertEquals(2.0, m1s1.get(1).getEventTime(), e);
		assertEquals(3.0, m1s1.get(2).getEventTime(), e);
		assertEquals(4.0, m1s1.get(3).getEventTime(), e);
		assertEquals(5.0, m1s1.get(4).getEventTime(), e);

		List<Measurement> m1s2 = (List<Measurement>) r1
				.getMeasurementsOfSensor(s2).getMeasurements();
		assertEquals(5, m1s1.size());
		assertEquals(1.5, m1s2.get(0).getEventTime(), e);
		assertEquals(2.5, m1s2.get(1).getEventTime(), e);
		assertEquals(3.5, m1s2.get(2).getEventTime(), e);
		assertEquals(4.5, m1s2.get(3).getEventTime(), e);
		assertEquals(5.5, m1s2.get(4).getEventTime(), e);

		List<Measurement> m2s1 = (List<Measurement>) r2
				.getMeasurementsOfSensor(s1).getMeasurements();
		assertEquals(6, m2s1.size());
		assertEquals(2.0, m2s1.get(0).getEventTime(), e);
		assertEquals(2.0, m2s1.get(1).getEventTime(), e);
		assertEquals(3.0, m2s1.get(2).getEventTime(), e);
		assertEquals(1.0, m2s1.get(3).getEventTime(), e);
		assertEquals(0.0, m2s1.get(4).getEventTime(), e);
		assertEquals(7.4, m2s1.get(5).getEventTime(), e);
	}

	@Test
	public void addExperiment() {
		f = SensorFrameworkDataset.singleton().getDataSourceByID(2);
		Experiment e2 = f.createExperimentDAO().addExperiment("Test2");

		assertEquals(2, f.createExperimentDAO().getExperiments().size());
		assertEquals(1, e2.getExperimentID());

		f.createExperimentDAO().removeExperiment(e2, false);
		assertEquals(1, f.createExperimentDAO().getExperiments().size());
		f.finalizeAndClose();

	}

	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(FileFactoryTest.class);
	}

}

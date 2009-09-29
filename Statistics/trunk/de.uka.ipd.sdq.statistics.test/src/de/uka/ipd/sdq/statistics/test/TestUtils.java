package de.uka.ipd.sdq.statistics.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.dao.IExperimentDAO;

public class TestUtils {

	/**
	 * 
	 * @param numberOfSamples
	 * @param desiredLag
	 *            set lag > 1 in order to obtain a sequence of dependent values.
	 * @return
	 */
	public static List<Double> createSampleSequence(int numberOfSamples,
			int desiredLag) {
		Random random = new Random();
		List<Double> samples = new ArrayList<Double>();
		for (int i = 0; i < numberOfSamples; i += desiredLag) {
			double randDbl = random.nextDouble();
			for (int j = 0; j < desiredLag && i + j < numberOfSamples; j++) {
				samples.add(randDbl + (j * randDbl));
			}
		}

		return samples;
	}

	public static Collection<Measurement> loadMeasurements(IDAOFactory factory,
			int experimentId, int runId, int sensorId) {
		IExperimentDAO experimentDAO = factory.createExperimentDAO();
		
		// Obtain experiment with specified id
		Experiment experiment = null;
		for (Experiment e : experimentDAO.getExperiments()) {
			if (e.getExperimentID() == experimentId) {
				experiment = e;
				break;
			}
		}
	
		// Obtain (time span) sensor with specified id
		TimeSpanSensor sensor = null;
		for (Sensor s : experiment.getSensors()) {
			if (s.getSensorID() == sensorId) {
				 if (s instanceof TimeSpanSensor) {
					 sensor = (TimeSpanSensor)s;
					 break;
				 }
			}
		}
		
		// Obtain experiment run with specified id
		ExperimentRun run = null;
		for (ExperimentRun r : experiment.getExperimentRuns()) {
			if (r.getExperimentRunID() == runId) {
				run = r;
				break;
			}
		}
		
		SensorAndMeasurements sam = run.getMeasurementsOfSensor(sensor);
		return sam.getMeasurements();
	}

}

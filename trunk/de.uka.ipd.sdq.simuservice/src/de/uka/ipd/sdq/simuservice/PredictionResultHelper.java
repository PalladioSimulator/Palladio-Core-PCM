package de.uka.ipd.sdq.simuservice;

import java.util.Iterator;

import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorframework.dao.file.entities.TimeSpanMeasurementImpl;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.simuservice.types.SimuServiceResultStatus;
import de.uka.ipd.sdq.simuservice.types.SimulationResult;

/**
 * This class provides auxiliary functionality to work with prediction results.
 * 
 * @author brosch
 * 
 */
public class PredictionResultHelper {

	/**
	 * A singleton pattern ensures the existence of only one result helper.
	 */
	private static PredictionResultHelper singletonInstance = new PredictionResultHelper();

	/**
	 * Retrieves the singleton instance.
	 * 
	 * @return the singleton instance
	 */
	public static PredictionResultHelper getHelper() {
		return singletonInstance;
	}

	/**
	 * The constructor is made private according to the singleton pattern.
	 */
	private PredictionResultHelper() {
	}

	/**
	 * References the measurements helper.
	 */
	private MeasurementsHelper valuesHelper = MeasurementsHelper.getHelper();

	/**
	 * Aggregates simulation results and stores them into the simuservice return
	 * value.
	 * 
	 * @param status
	 *            the simuservice return value
	 * @param resultsPath
	 *            the absolute path where the simulation results reside
	 */
	public void buildPredictionResult(final SimuServiceResultStatus status,
			final String resultsPath) {

		// Create a data source object:
		FileDAOFactory dataSource = new FileDAOFactory(resultsPath);

		// Retrieve the list of sensors within the simulation results:
		Iterator<Sensor> sensorsIterator = dataSource.createSensorDAO()
				.getSensors().iterator();

		// Go through the list of sensors:
		while (sensorsIterator.hasNext()) {
			buildSensorResult(dataSource, sensorsIterator.next(), status);
		}

		// Finalize the data source:
		dataSource.finalizeAndClose();
	}

	/**
	 * Aggregates the results of a simulation sensor and stores them into the
	 * simuservice return value.
	 * 
	 * @param dataSource
	 *            the simulation result data
	 * @param sensor
	 *            the simulation sensor
	 * @param status
	 *            the simuservice return value
	 */
	private void buildSensorResult(final FileDAOFactory dataSource,
			final Sensor sensor, final SimuServiceResultStatus status) {

		// Only deal with response time data for now:
		if (!sensor.getSensorName().contains("Response Time")) {
			return;
		}

		// TODO: Only deal with sensors for usage scenario response times. In a
		// more elaborate version, the names of the usage scenarios could be
		// read from the usage model and given as an input to string matching
		// with the sensor name. Later on, there should even be a mechanism that
		// does not need string comparison.
		if (sensor.getSensorName().contains("Response Time of Call")) {
			return;
		}

		// Get measurements data:
		MeasurementsData data = valuesHelper.getMeasurements(dataSource, sensor
				.getSensorName(), TimeSpanMeasurementImpl.class);

		// Consider the possibility of empty sensors:
		if (data.hasMeasurements()) {

			// Create a container for the aggregated results:
			SimulationResult result = new SimulationResult();
			result.setSensorName(sensor.getSensorName());

			// Get the percentiles of the measurement data:
			for (double specification = 0.05; specification < 1.0; specification += 0.05) {
				double percentile = valuesHelper.getPercentile(data,
						specification);
				result.getPercentiles().put(specification, percentile);
			}

			// TODO: also collect the throughput for the measurement and add it
			// to the simulation result
			status.getSimulationResults().add(result);
		}
	}
}

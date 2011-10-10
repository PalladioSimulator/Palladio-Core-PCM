package de.uka.ipd.sdq.prototype.framework;

import java.util.Collection;
import java.util.Iterator;

import javax.management.RuntimeErrorException;

import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;

/**
 * Manages the time span sensors and measurements.
 * 
 * @author Steffen Becker, Sebastian Lehrig, Thomas Zolynski
 *
 */
public class ExperimentManager {

	/** 
	 * Suffix for ProtoCom sensors, as seen in the diagrams 
	 */
	private static final String PROTOCOM_SENSOR_SUFFIX = " (ProtoCom)";

	protected static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getRootLogger();
	
	private static de.uka.ipd.sdq.sensorframework.entities.Experiment exp = null;

	
	public static de.uka.ipd.sdq.sensorframework.entities.Experiment getExperiment() {
		return exp;
	}

	public static void setExperiment(de.uka.ipd.sdq.sensorframework.entities.Experiment exp) {
		ExperimentManager.exp = exp;
	}

	/**
	 * Adds a new experiment run to the experiment. Current date is used for
     * as date.
     *
	 * @return the newly created experiment run
	 */
	public static ExperimentRun addExperimentRun() {
		if (exp == null) {
			logger.error("Experiment not set");
			throw new RuntimeErrorException(null, "Experiment not set");
		}
		
		return exp.addExperimentRun(new java.util.Date().toString());
	}
	
	
	/**
	 * Restored this from an older version.
	 * Will be changed eventually.
	 * @return
	 */
	public static long takeStartTimeForInnerMeasurement() {
		return System.nanoTime();
	}

	/**
	 * Takes a measurement (from start time till current time) on the given sensor
	 * 
	 * @param start						start time
	 * @param experimentRun				
	 * @param timeSpanSensor		sensor
	 */
	public static void takeMeasurement(long start, ExperimentRun experimentRun, TimeSpanSensor timeSpanSensor) {
	
		logger.info("Take measurement of " + timeSpanSensor.getSensorName());
		
		long now = System.nanoTime();
		double measuredTimeSpan = (now - start) / Math.pow(10, 9);
	
		experimentRun.addTimeSpanMeasurement(timeSpanSensor, now / Math.pow(10, 9), measuredTimeSpan);
	}

	/**
	 * Returns a {@link TimeSpanSensor} in the experiment that has the name
	 * sensorName. Creates a new sensor and returns it of no sensor with this
	 * name exists. The reuse is required because the EJB container may decide
	 * at times to create new instances of the components, so for one component
	 * type and one signature, this method may be called multiple times during
	 * the measurements. We want to store all results per component type into
	 * one sensor, though.
	 * 
	 * @param sensorName
	 *            The sensor name to match
	 * @return The {@link TimeSpanSensor} with the passed name or a new
	 *         {@link TimeSpanSensor} with that name that is then also added to
	 *         the experiment.
	 */
	public static TimeSpanSensor createOrReuseTimeSpanSensor(String sensorName) {
	
		Collection<Sensor> existingSesors = ExperimentManager.exp.getSensors();
		for (Sensor sensor : existingSesors) {
			if (sensor instanceof TimeSpanSensor && sensor.getSensorName().equals(sensorName + ExperimentManager.PROTOCOM_SENSOR_SUFFIX)) {
				return (TimeSpanSensor) sensor;
			}
		}
	
		TimeSpanSensor tss = getExperiment().addTimeSpanSensor(sensorName + ExperimentManager.PROTOCOM_SENSOR_SUFFIX);
		return tss;
	}

	
	/**
	 * Returns the newest experiment run instance. If no one exists, a new experiment run
	 * will be created. Note that the experiment run usually should be created explicitly 
	 * and not here. This one is just a (quick) fix to get measurements from sensors running
	 * on instances different from the usage scenario.
	 * 
	 * @return latest experiment run instance or a new one
	 */
	public static ExperimentRun getLatestExperimentRun() {		
		if (getExperiment().getExperimentRuns().isEmpty()) {
			addExperimentRun();
		}
		
		Collection<ExperimentRun> runs = getExperiment().getExperimentRuns();
		Iterator<ExperimentRun> it = runs.iterator();
	
		ExperimentRun experimentRun = null;
	
		while (it.hasNext()) {
			experimentRun = (ExperimentRun) it.next();
		}
	
		return experimentRun;
	}
}

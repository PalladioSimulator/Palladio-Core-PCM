package de.uka.ipd.sdq.sensorframework.util;

import java.util.Collection;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.dao.IExperimentDAO;

/**
 * TODO this class has no documentation at all!
 * It is not used by any other class, so there is no need for it, unless it is a "hidden" test class.
 * 
 * @author Jens Happe
 * @author Steffen Becker
 * 
 *
 */
public class ExperimentManager {

	public final static double SCALING_FACTOR = 1000000;

	private Hashtable<String, TimeSpanSensor> timeSpanSensorHash = new Hashtable<String, TimeSpanSensor>();
	
	private Experiment experiment;
	
	private ExperimentRun run;
	
	private IDAOFactory factory;
	
	public ExperimentManager(String experimentName, IDAOFactory factory){
		this.factory = factory;
		this.experiment = getExperiment(experimentName);
		run = experiment.addExperimentRun("Run "+new Date().toString());
	}
	
	private Experiment getExperiment(String experimentName) {
		IExperimentDAO expDAO = factory.createExperimentDAO();
		Collection<Experiment> experimentColl = expDAO.findByExperimentName(experimentName);
		if (experimentColl.size() > 0){
			return experimentColl.iterator().next();
		} else {
			return expDAO.addExperiment(experimentName);
		}
	}

	public void storeTimeSpan(String sensorName, long startTime, long stopTime){
		double time = (stopTime - startTime) / SCALING_FACTOR;
		if (sensorName.equals("ServiceTime") && time < 0.5){
			System.out.println(time);
			System.out.println(startTime);
			System.out.println(stopTime);
		}
		TimeSpanSensor sensor = getTimeSpanSensor(sensorName);
		run.addTimeSpanMeasurement(sensor, startTime, time);
	}
	
	public void storeTimeSpans(String sensorName, double[] durationArray, double[] timeArray, int upperBound) {
		TimeSpanSensor sensor = getTimeSpanSensor(sensorName);
		for (int i=0; i<upperBound; i++){
			run.addTimeSpanMeasurement(sensor, timeArray[i], durationArray[i]);
		}
	}	
	
	public void storeTimeSpans(String sensorName, List<Double> elements) {
		TimeSpanSensor sensor = getTimeSpanSensor(sensorName);
		int i=0;
		for (Double d: elements){
			run.addTimeSpanMeasurement(sensor, i, d);
			i++;
		}
	}	

	public void close(){
		factory.finalizeAndClose();
	}
	
	
	private TimeSpanSensor getTimeSpanSensor(String name) {
		TimeSpanSensor result = timeSpanSensorHash.get(name);
		if (result == null){
			for (Sensor sensor : experiment.getSensors()) {
				if ( sensor.getSensorName().equals(name) ) {
					result = (TimeSpanSensor) sensor;
					break;
				}
			}
			if (result == null){
				result = experiment.addTimeSpanSensor(name);
			}
			timeSpanSensorHash.put(name, result);
		}
		return result;
	}
	
	public void finalizeAndClose() {
		factory.finalizeAndClose();
	}

}

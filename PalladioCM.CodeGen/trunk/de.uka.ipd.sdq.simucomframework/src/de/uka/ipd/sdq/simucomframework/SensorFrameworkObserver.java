package de.uka.ipd.sdq.simucomframework;

import java.util.Date;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.sensorfactory.SensorFrameworkDataset;
import de.uka.ipd.sdq.sensorfactory.entities.Experiment;
import de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorfactory.entities.Sensor;
import de.uka.ipd.sdq.sensorfactory.entities.TimeSpanSensor;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.sensors.ISensorObserver;
import de.uka.ipd.sdq.simucomframework.sensors.SensorAddedEvent;

class SensorObserver implements Observer {

	private TimeSpanSensor mySensor;
	private ExperimentRun run;
	private boolean warmUpTime = true;
	private double lastValue = 0;

	public SensorObserver(ExperimentRun run, TimeSpanSensor sensor) {
		this.mySensor = sensor;
		this.run = run;
	}

	public void update(Observable arg0, Object arg1) {
		if (warmUpTime) {
			if (lastValue < (Double)arg1) {
				lastValue = (Double)arg1;
			} else {
				warmUpTime = false;
			}
		}
		if (!warmUpTime)
			run.addTimeSpanMeasurement(mySensor, 0, (Double)arg1);
	}
	
}

public class SensorFrameworkObserver implements ISensorObserver {
	private static Logger logger = 
		Logger.getLogger(SensorFrameworkObserver.class.getName());
	
	private Experiment experiment = null;
	protected ExperimentRun run = null;
	protected HashMap<String, Sensor> sensors = new HashMap<String, Sensor>();
	
	public SensorFrameworkObserver(SimuComModel model) {
		experiment = model.getExperimentDatastore();
		run = model.getCurrentExperimentRun();
	}
	
	public void sensorAddedEvent(SensorAddedEvent e) {
		if (!sensors.containsKey(e.getId())){
			logger.info("Creating TimeSpan Sensor: "+e.getId());
			TimeSpanSensor sensor = createOrReuseSensor(experiment.getExperimentName()+": " + e.getId()); 
			sensors.put(e.getId(),sensor);
			e.getSupplier().addObserver(new SensorObserver(run,sensor));
		}
	}

	private TimeSpanSensor createOrReuseSensor(String id) {
		for (Sensor s : experiment.getSensors()) {
			if (s.getSensorName().equals(id))
				if (s instanceof TimeSpanSensor)
					return (TimeSpanSensor)s;
		}
		return experiment.addTimeSpanSensor(id);
	}

}

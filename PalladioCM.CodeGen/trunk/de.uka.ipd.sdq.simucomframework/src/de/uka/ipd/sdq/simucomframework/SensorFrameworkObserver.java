package de.uka.ipd.sdq.simucomframework;

import java.util.Date;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import de.uka.ipd.sdq.sensorfactory.entities.Experiment;
import de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorfactory.entities.Sensor;
import de.uka.ipd.sdq.sensorfactory.entities.TimeSpanSensor;
import de.uka.ipd.sdq.sensorfactory.entities.impl.ExperimentDAO;
import de.uka.ipd.sdq.simucomframework.sensors.ISensorObserver;
import de.uka.ipd.sdq.simucomframework.sensors.SensorAddedEvent;

class SensorObserver implements Observer {

	private TimeSpanSensor mySensor;
	private ExperimentRun run;
	private Experiment experiment;
	private long storeCountdown = 0;

	public SensorObserver(Experiment experiment, ExperimentRun run, TimeSpanSensor sensor) {
		this.mySensor = sensor;
		this.run = run;
		this.experiment = experiment;
	}

	public void update(Observable arg0, Object arg1) {
		run.addTimeSpanMeasurement(mySensor, (Double)arg1, 0);
		storeCountdown++;
		if (storeCountdown % 10000 == 0)
			ExperimentDAO.singleton().storeExperiment(experiment);
	}
	
}

public class SensorFrameworkObserver implements ISensorObserver {
	
	private Experiment experiment = ExperimentDAO.singleton().createExperiment("Simucom Experiment");
	protected HashMap<String, Sensor> sensors = new HashMap<String, Sensor>();
	protected ExperimentRun run = null;
	
	public SensorFrameworkObserver() {
		run = experiment.addExperimentRun("Run "+new Date());
	}
	
	public void sensorAddedEvent(SensorAddedEvent e) {
		if (!sensors.containsKey(e.getId())){
			TimeSpanSensor sensor = experiment.addTimeSpanSensor(e.getId());
			sensors.put(e.getId(),sensor);
			e.getSupplier().addObserver(new SensorObserver(experiment,run,sensor));
		}
	}

	public void finish() {
		ExperimentDAO.singleton().storeExperiment(experiment);
	}

}

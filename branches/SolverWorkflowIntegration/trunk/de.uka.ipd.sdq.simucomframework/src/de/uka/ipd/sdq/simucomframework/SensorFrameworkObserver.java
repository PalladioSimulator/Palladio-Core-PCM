//package de.uka.ipd.sdq.simucomframework;
//
//import java.util.HashMap;
//import java.util.Observable;
//import java.util.Observer;
//
//import org.apache.log4j.Logger;
//
//import de.uka.ipd.sdq.sensorframework.entities.Experiment;
//import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
//import de.uka.ipd.sdq.sensorframework.entities.Sensor;
//import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;
//import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
//import de.uka.ipd.sdq.simucomframework.sensors.ISensorObserver;
//import de.uka.ipd.sdq.simucomframework.sensors.SensorAddedEvent;
//
//class SensorObserver implements Observer {
//
//	private TimeSpanSensor mySensor;
//	private ExperimentRun run;
//	private boolean warmUpTime = true;
//	private double lastValue = 0;
//	private SimuComModel model;
//
//	public SensorObserver(SimuComModel m, ExperimentRun run, TimeSpanSensor sensor) {
//		this.mySensor = sensor;
//		this.run = run;
//		this.model = m;
//	}
//
//	public void update(Observable arg0, Object arg1) {
//		if (warmUpTime) {
//			if (lastValue < (Double)arg1) {
//				lastValue = (Double)arg1;
//			} else {
//				warmUpTime = false;
//			}
//		}
//		if (!warmUpTime)
//			run.addTimeSpanMeasurement(mySensor, model.currentTime().getTimeValue(), (Double)arg1);
//	}
//	
//}
//
///**
// * Sensorframework observer for the old sensor framework which logs into the new
// * sensorframework. 
// * @author Steffen Becker
// *
// */
//public class SensorFrameworkObserver implements ISensorObserver {
//	private static Logger logger = 
//		Logger.getLogger(SensorFrameworkObserver.class.getName());
//	
//	private Experiment experiment = null;
//	protected ExperimentRun run = null;
//	protected HashMap<String, Sensor> sensors = new HashMap<String, Sensor>();
//
//	private SimuComModel model;
//	
//	public SensorFrameworkObserver(SimuComModel model) {
//		experiment = model.getExperimentDatastore();
//		run = model.getCurrentExperimentRun();
//		this.model = model;
//	}
//	
//	public void sensorAddedEvent(SensorAddedEvent e) {
//		if (!sensors.containsKey(e.getId())){
//			logger.info("Creating TimeSpan Sensor: "+e.getId());
//			TimeSpanSensor sensor = createOrReuseSensor(experiment.getExperimentName()+": " + e.getId()); 
//			sensors.put(e.getId(),sensor);
//			e.getSupplier().addObserver(new SensorObserver(model,run,sensor));
//		}
//	}
//
//	private TimeSpanSensor createOrReuseSensor(String id) {
//		for (Sensor s : experiment.getSensors()) {
//			if (s.getSensorName().equals(id))
//				if (s instanceof TimeSpanSensor)
//					return (TimeSpanSensor)s;
//		}
//		return experiment.addTimeSpanSensor(id);
//	}
//
//}

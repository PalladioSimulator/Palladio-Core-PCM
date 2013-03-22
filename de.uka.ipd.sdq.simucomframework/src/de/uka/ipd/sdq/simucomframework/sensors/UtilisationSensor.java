//package de.uka.ipd.sdq.simucomframework.sensors;
//
//import java.util.Hashtable;
//
//import de.uka.ipd.sdq.scheduler.factory.SchedulingFactory;
//import de.uka.ipd.sdq.scheduler.resources.active.SimResourceInstance;
//import de.uka.ipd.sdq.scheduler.sensors.IActiveResourceStateSensor;
//import de.uka.ipd.sdq.sensorframework.entities.State;
//import de.uka.ipd.sdq.sensorframework.entities.StateSensor;
//import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
//
//public class UtilisationSensor implements IActiveResourceStateSensor{
//
//	private Hashtable<String, StateSensor> instance_sensors = new Hashtable<String, StateSensor>();
//	private SimuComModel model;
//	private State idle_state;
//	private State busy_state;
//	private String description;
//
//	
//	public UtilisationSensor(SimuComModel model, String description){
//		this.model = model;
//		this.description = description;
//		this.idle_state = SensorHelper.createOrReuseState(model.getDAOFactory(), "Idle");
//		this.busy_state = SensorHelper.createOrReuseState(model.getDAOFactory(), "Busy");
//		this.instance_sensors = new Hashtable<String, StateSensor>();
//	}
//	
//	private StateSensor getStateSensor(String id){
//		StateSensor sensor = instance_sensors.get(id);
//		if (sensor == null){
//			sensor = SensorHelper.createOrReuseStateSensor(model.getDAOFactory(), model.getExperimentDatastore(), id, idle_state);
//			sensor.addSensorState(idle_state);
//			sensor.addSensorState(busy_state);
//			instance_sensors.put(id, sensor);
//		}
//		return sensor;
//	}
//
//	@Override
//	public void update(SimResourceInstance instance) {
//		String id = "Core " + (instance.getId()+1) + " " + description;
//		if (instance.isIdle()){
//			addState(id, idle_state);
//		} else {
//			addState(id, busy_state);
//			
//		}
//	}
//
//	private void addState(String id, State state) {
//		double now = SchedulingFactory.getUsedSimulator().time();
//		model.getCurrentExperimentRun().addStateMeasurement(getStateSensor(id),state, now);
//	}
//}

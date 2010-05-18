package de.uka.ipd.sdq.simucomframework.sensors;

import java.util.Hashtable;

import de.uka.ipd.sdq.scheduler.factory.SchedulingFactory;
import de.uka.ipd.sdq.scheduler.resources.active.SimResourceInstance;
import de.uka.ipd.sdq.scheduler.sensors.IActiveResourceStateSensor;
import de.uka.ipd.sdq.sensorframework.entities.State;
import de.uka.ipd.sdq.sensorframework.entities.StateSensor;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public class UtilisationSensor implements IActiveResourceStateSensor{

	Hashtable<String, StateSensor> instance_sensors = new Hashtable<String, StateSensor>();
	private SimuComModel model;
	private State idle_state;
	private State busy_state;

	
	public UtilisationSensor(SimuComModel model){
		this.model = model;
		this.idle_state = SensorHelper.createOrReuseState(model.getDAOFactory(), "Idle");
		this.busy_state = SensorHelper.createOrReuseState(model.getDAOFactory(), "Busy");
	}
	
	private StateSensor getStateSensor(String id){
		StateSensor sensor =SensorHelper.createOrReuseStateSensor(model.getDAOFactory(), model.getExperimentDatastore(), id, idle_state);
		sensor.addSensorState(idle_state);
		sensor.addSensorState(busy_state);
		return sensor;
	}
	
	@Override
	public void update(SimResourceInstance instance) {
		if (instance.isIdle()){
			addState(instance.getName(), idle_state);
		} else {
			addState(instance.getName(), busy_state);
			
		}
	}

	private void addState(String name, State state) {
		double now = SchedulingFactory.getUsedSimulator().time();
		model.getCurrentExperimentRun().addStateMeasurement(getStateSensor("Utilisation_" + name),state, now);
	}
}

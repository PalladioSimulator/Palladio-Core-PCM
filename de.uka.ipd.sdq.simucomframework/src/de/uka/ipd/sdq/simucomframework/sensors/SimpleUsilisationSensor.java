package de.uka.ipd.sdq.simucomframework.sensors;

import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.State;
import de.uka.ipd.sdq.sensorframework.entities.StateSensor;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimulationControlDelegate;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public class SimpleUsilisationSensor {
	
	private StateSensor sensor;
	private ExperimentRun experimentRun;
	private ISimulationControlDelegate simulationControl;
	private State idle;
	private State busy;

	public SimpleUsilisationSensor(SimuComModel model, String description) {
		super();
		idle = SensorHelper.createOrReuseState(model.getDAOFactory(), "idle");
		busy = SensorHelper.createOrReuseState(model.getDAOFactory(), "busy");
		this.sensor = SensorHelper.createOrReuseStateSensor(model.getDAOFactory(), model.getExperimentDatastore(), description, busy);
		sensor.addSensorState(idle);
		sensor.addSensorState(busy);
		this.experimentRun = model.getCurrentExperimentRun();
		this.simulationControl = model.getSimulationControl();
	}
	
	public void setTotalResourceDemand(double resourceDemand){
		double totalTime = simulationControl.getCurrentSimulationTime();
		experimentRun.addStateMeasurement(this.sensor, busy, 0);
		experimentRun.addStateMeasurement(this.sensor, idle, resourceDemand);
		experimentRun.addStateMeasurement(this.sensor, busy, totalTime);
	}
	
	public StateSensor getSensor(){
		return sensor;
	}
}

//package de.uka.ipd.sdq.simucomframework.sensors;
//
//import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
//import de.uka.ipd.sdq.sensorframework.entities.State;
//import de.uka.ipd.sdq.sensorframework.entities.StateSensor;
//import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationControlDelegate;
//import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
//
//public class OverallUtilisationSensor {
//	
//	private StateSensor sensor;
//	private ExperimentRun experimentRun;
//	private ISimulationControlDelegate simulationControl;
//	private State idle;
//	private State busy;
//
//	public OverallUtilisationSensor(SimuComModel model, String description) {
//		super();
//		idle = SensorHelper.createOrReuseState(model.getDAOFactory(), "idle");
//		busy = SensorHelper.createOrReuseState(model.getDAOFactory(), "busy");
//		this.sensor = SensorHelper.createOrReuseStateSensor(model.getDAOFactory(), model.getExperimentDatastore(), description, busy);
//		sensor.addSensorState(idle);
//		sensor.addSensorState(busy);
//		this.experimentRun = model.getCurrentExperimentRun();
//		this.simulationControl = model.getSimulationControl();
//	}
//	
//	public void setTotalResourceDemand(double resourceDemand, int numberOfCores){
//		double totalTime = simulationControl.getCurrentSimulationTime()*numberOfCores;
//		if (resourceDemand>totalTime) {
//			resourceDemand = totalTime;
//		}
//		if (experimentRun instanceof SimuComExperimentRunDecorator){
//			SimuComExperimentRunDecorator erd = (SimuComExperimentRunDecorator) experimentRun;
//			erd.addStateMeasurementAfterRun(this.sensor, busy, 0);
//			erd.addStateMeasurementAfterRun(this.sensor, idle, resourceDemand);
//			erd.addStateMeasurementAfterRun(this.sensor, busy, totalTime);
//		}
//	}
//	
//	public StateSensor getSensor(){
//		return sensor;
//	}
//}

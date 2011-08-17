//package de.uka.ipd.sdq.simucomframework.sensors;
//
//import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
//import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;
//import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationControlDelegate;
//import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
//
//public class SimpleTimeSpanSensor {
//	
//	private TimeSpanSensor sensor;
//	private ExperimentRun experimentRun;
//	private ISimulationControlDelegate simulationControl;
//
//	public SimpleTimeSpanSensor(SimuComModel model, String description) {
//		super();
//		this.sensor = SensorHelper.createOrReuseTimeSensor(model
//				.getDAOFactory(), model.getExperimentDatastore(), model
//				.getExperimentDatastore().getExperimentName() + ": " 
//				+ description);
//		this.experimentRun = model.getCurrentExperimentRun();
//		this.simulationControl = model.getSimulationControl();
//	}
//	
//	public void record(double value){
//		experimentRun.addTimeSpanMeasurement(sensor, simulationControl.getCurrentSimulationTime(), value);
//	}
//	
//	public TimeSpanSensor getSensor(){
//		return sensor;
//	}
//}

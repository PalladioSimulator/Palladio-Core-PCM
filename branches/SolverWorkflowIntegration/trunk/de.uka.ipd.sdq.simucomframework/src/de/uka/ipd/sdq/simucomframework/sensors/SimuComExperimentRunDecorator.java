package de.uka.ipd.sdq.simucomframework.sensors;

import java.util.Collection;

import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.ScalabilityMeasurement;
import de.uka.ipd.sdq.sensorframework.entities.ScalabilitySensor;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.State;
import de.uka.ipd.sdq.sensorframework.entities.StateMeasurement;
import de.uka.ipd.sdq.sensorframework.entities.StateSensor;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public class SimuComExperimentRunDecorator implements ExperimentRun {

	private ExperimentRun decoratedRun = null;
	private SimuComModel model;

	public SimuComExperimentRunDecorator(SimuComModel simuComModel,
			ExperimentRun experimentRun) {
		this.model = simuComModel;
		this.decoratedRun = experimentRun;
	}

	public void addMeasurement(Measurement arg0) {
		if (model.getSimulationControl().isRunning())
			decoratedRun.addMeasurement(arg0);
	}

	public StateMeasurement addStateMeasurement(StateSensor arg0, State arg1,
			double arg2) {
		if (model.getSimulationControl().isRunning())
			return decoratedRun.addStateMeasurement(arg0, arg1, arg2);
		else
			return null;
	}

	public TimeSpanMeasurement addTimeSpanMeasurement(TimeSpanSensor arg0,
			double arg1, double arg2) {
		if (model.getSimulationControl().isRunning())
			return decoratedRun.addTimeSpanMeasurement(arg0, arg1, arg2);
		else
			return null;
	}
	
	public ScalabilityMeasurement addScalabilityMeasurement(ScalabilitySensor arg0,
			Double[] arg1, double arg2) {
		if (model.getSimulationControl().isRunning())
			return decoratedRun.addScalabilityMeasurement(arg0, arg1, arg2);
		else
			return null;
	}

	public String getExperimentDateTime() {
		return decoratedRun.getExperimentDateTime();
	}

	public long getExperimentRunID() {
		return decoratedRun.getExperimentRunID();
	}

	public Collection<Measurement> getMeasurements() {
		return decoratedRun.getMeasurements();
	}

	public SensorAndMeasurements getMeasurementsOfSensor(Sensor arg0) {
		return decoratedRun.getMeasurementsOfSensor(arg0);
	}

	public void setExperimentDateTime(String arg0) {
		decoratedRun.setExperimentDateTime(arg0);
	}

	public void setExperimentRunID(long arg0) {
		decoratedRun.setExperimentRunID(arg0);
	}
}

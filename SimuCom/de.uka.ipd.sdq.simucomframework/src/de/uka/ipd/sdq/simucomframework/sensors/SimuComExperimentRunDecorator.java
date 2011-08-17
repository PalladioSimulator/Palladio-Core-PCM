package de.uka.ipd.sdq.simucomframework.sensors;

import java.util.Collection;
import java.util.Observable;

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

@Deprecated
public class SimuComExperimentRunDecorator extends Observable implements
		ExperimentRun {

	private ExperimentRun decoratedRun = null;
	private SimuComModel model;

	public SimuComExperimentRunDecorator(SimuComModel simuComModel,
			ExperimentRun experimentRun) {
		this.model = simuComModel;
		this.decoratedRun = experimentRun;
	}

	public void addMeasurement(Measurement arg0) {
		if (model.getSimulationControl().isRunning()) {
			setChanged();
			notifyObservers(arg0);
			decoratedRun.addMeasurement(arg0);
		}
	}

	public StateMeasurement addStateMeasurement(StateSensor arg0, State arg1,
			double arg2) {
		// Hauck:
		// Changed behaviour here in order to allow adding states after
		// simulation has stopped. This is necessary for the OverallUtlilisationSensor
		
		//if (model.getSimulationControl().isRunning()) {
			StateMeasurement measurement = decoratedRun.addStateMeasurement(
					arg0, arg1, arg2);
			setChanged();
			notifyObservers(measurement);
			return measurement;
		//} else
			//return null;
	}

	public TimeSpanMeasurement addTimeSpanMeasurement(TimeSpanSensor arg0,
			double arg1, double arg2) {
		if (model.getSimulationControl().isRunning()) {
			TimeSpanMeasurement measurement = decoratedRun
					.addTimeSpanMeasurement(arg0, arg1, arg2);
			setChanged();
			notifyObservers(new DecoratorTimeSpanMeasurement(arg0, arg1, arg2));
			return measurement;
		} else
			return null;
	}

	public StateMeasurement addStateMeasurementAfterRun(StateSensor arg0,
			State arg1, double arg2) {
		StateMeasurement measurement = decoratedRun.addStateMeasurement(arg0,
				arg1, arg2);
		setChanged();
		notifyObservers(measurement);
		return measurement;
	}

	public TimeSpanMeasurement addTimeSpanMeasurementAfterRun(
			TimeSpanSensor sensor, double eventtime, double timespan) {
		TimeSpanMeasurement measurement = decoratedRun.addTimeSpanMeasurement(
				sensor, eventtime, timespan);
		setChanged();
		notifyObservers(new DecoratorTimeSpanMeasurement(sensor, eventtime, timespan));
		return measurement;
	}

	public ScalabilityMeasurement addScalabilityMeasurement(
			ScalabilitySensor arg0, Double[] arg1, double arg2) {
		if (model.getSimulationControl().isRunning()) {
			ScalabilityMeasurement measurement = decoratedRun
					.addScalabilityMeasurement(arg0, arg1, arg2);
			setChanged();
			notifyObservers(measurement);
			return measurement;
		} else
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

	public class DecoratorMeasurement {

		protected double eventTime;

		protected Sensor sensor;

		public DecoratorMeasurement(Sensor sensor, double eventTime) {
			this.eventTime = eventTime;
			this.sensor = sensor;
		}

		public double getEventTime() {
			return eventTime;
		}

		public void setEventTime(double eventTime) {
			this.eventTime = eventTime;
		}

		public Sensor getSensor() {
			return sensor;
		}

		public void setSensor(Sensor sensor) {
			this.sensor = sensor;
		}

	}

	public class DecoratorTimeSpanMeasurement extends DecoratorMeasurement {

		private double timeSpan;

		public DecoratorTimeSpanMeasurement(Sensor sensor, double eventTime,
				double timeSpan) {
			super(sensor, eventTime);
			this.timeSpan = timeSpan;
		}

		public double getTimeSpan() {
			return timeSpan;
		}

		public void setTimeSpan(double timeSpan) {
			this.timeSpan = timeSpan;
		}

	}

}
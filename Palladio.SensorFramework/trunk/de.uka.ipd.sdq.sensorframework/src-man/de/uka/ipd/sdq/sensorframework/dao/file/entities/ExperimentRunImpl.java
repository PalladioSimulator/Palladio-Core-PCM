/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dao.file.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.State;
import de.uka.ipd.sdq.sensorframework.entities.StateMeasurement;
import de.uka.ipd.sdq.sensorframework.entities.StateSensor;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;

/**
 * @author ihssane
 * 
 */
public class ExperimentRunImpl implements ExperimentRun, Serializable {

	private static final long serialVersionUID = 1L;
	private transient FileDAOFactory factory;
	private long experimentRunID;
	private String experimetDateTime; // TODO: Typo
	private transient HashMap<Long, SensorAndMeasurementsImpl> sensorAndMeasurements;
	public List<Long> sensorIDs;

	public ExperimentRunImpl(FileDAOFactory factory) {
		this.factory = factory;
		sensorAndMeasurements = new HashMap<Long, SensorAndMeasurementsImpl>();
		sensorIDs = new ArrayList<Long>();
	}

	public void setFactory(FileDAOFactory factory) {
		this.factory = factory;
	}

	public long getExperimentRunID() {
		return experimentRunID;
	}

	// TODO: darf die ID verändert werden?
	public void setExperimentRunID(long experimentRunID) {
		this.experimentRunID = experimentRunID;
	}

	public String getExperimentDateTime() {
		return experimetDateTime;
	}

	// TODO: darf dieser wert verändert werden?
	public void setExperimentDateTime(String experimetDateTime) {
		this.experimetDateTime = experimetDateTime;
	}

	public void addMeasurement(Measurement value) {
		return;
	}

	public Collection<SensorAndMeasurementsImpl> getCachedSensorAndMeasurements() {
		return sensorAndMeasurements.values();
	}

	public Collection<SensorAndMeasurementsImpl> getSensorAndMeasurements() {
		Collection<SensorAndMeasurementsImpl> result = new ArrayList<SensorAndMeasurementsImpl>();
		if (sensorAndMeasurements == null)
			sensorAndMeasurements = new HashMap<Long, SensorAndMeasurementsImpl>();

		for (long l : sensorIDs) {
			SensorAndMeasurementsImpl sam = sensorAndMeasurements.get(l);
			if (sam == null)
				sam = loadMeasurementsFromFile(l);
			result.add(sam);
		}
		return result;
	}

	// TODO: diese einfache Operation benötigt sehr viele Fallunterscheidungen
	// und Prüfungen. Können hier vorbedingungen gefordert werden, die den
	// Zugriff beschleunigen?
	public StateMeasurement addStateMeasurement(StateSensor p_sensor,
			State p_sensorstate, double p_eventtime) {
		SensorAndMeasurementsImpl sam = null;

		// TODO: Warum kann dieser Fall auftreten? Tabelle wird im Konstruktor
		// initialisiert.
		if (sensorAndMeasurements == null)
			sensorAndMeasurements = new HashMap<Long, SensorAndMeasurementsImpl>();

		// TODO sensorIDs == sensorAndMasurements.keys() !!
		// TODO senorAndMeasurements umbenennen in z.B.
		// measurmentsForSensorTable
		if (!sensorIDs.contains(p_sensor.getSensorID())) { // TODO: Langsam, da
															// Dateien geladen
															// werden!!!
			sam = new StateSensorAndMeasurement(p_sensor);
			sensorIDs.add(p_sensor.getSensorID());
			sensorAndMeasurements.put(p_sensor.getSensorID(), sam);
		}

		sam = sensorAndMeasurements.get(p_sensor.getSensorID());
		if (sam == null) {
			// TODO: was, wenn die Datei nicht existiert?
			// TODO: wie sortiert sich dieser Fall in die oben gelisteten Fälle
			// ein?
			sam = loadMeasurementsFromFile(p_sensor.getSensorID());
		}
		sam.addEventTime(p_eventtime);
		((StateSensorAndMeasurement) sam).addState(p_sensorstate);

		return factory.createMeasurementDAO().addStateMeasurement(p_sensor,
				p_sensorstate, p_eventtime);
	}

	// TODO: Analog zu addStateMeasurement
	public TimeSpanMeasurement addTimeSpanMeasurement(TimeSpanSensor p_sensor,
			double p_eventtime, double p_timespan) {
		SensorAndMeasurementsImpl sam = null;
		if (sensorAndMeasurements == null)
			sensorAndMeasurements = new HashMap<Long, SensorAndMeasurementsImpl>();

		if (!sensorIDs.contains(p_sensor.getSensorID())) {
			sam = new TimeSpanSensorAndMeasurement(p_sensor);
			sensorIDs.add(p_sensor.getSensorID());
			sensorAndMeasurements.put(p_sensor.getSensorID(), sam);
		}

		sam = sensorAndMeasurements.get(p_sensor.getSensorID());
		if (sam == null) {
			sam = loadMeasurementsFromFile(p_sensor.getSensorID());
		}
		sam.addEventTime(p_eventtime);
		((TimeSpanSensorAndMeasurement) sam).addTimeSpan(p_timespan);

		return factory.createMeasurementDAO().addTimeSpanMeasurement(p_sensor,
				p_eventtime, p_timespan);
	}

	public Collection<Measurement> getMeasurements() {
		ArrayList<Measurement> m = new ArrayList<Measurement>();

		for (SensorAndMeasurementsImpl sam : getSensorAndMeasurements()) {
			m.addAll(sam.getMeasurements());
		}
		return m;
	}

	private SensorAndMeasurementsImpl loadMeasurementsFromFile(long sensorID) {
		return (SensorAndMeasurementsImpl) factory.deserializeFromFile("ExpRun"
				+ getExperimentRunID() + "Measurements" + sensorID);
	}

	public SensorAndMeasurements getMeasurementsOfSensor(Sensor sensor) {
		if (!sensorIDs.contains(sensor.getSensorID())) {
			System.err.println("Error: No Measuremts for Sensor: "
					+ sensor.getSensorName() + " found");
			return null;
		}
		if (sensorAndMeasurements == null)
			sensorAndMeasurements = new HashMap<Long, SensorAndMeasurementsImpl>();

		SensorAndMeasurementsImpl sam = sensorAndMeasurements.get(sensor
				.getSensorID());
		if (sam == null) {
			sam = loadMeasurementsFromFile(sensor.getSensorID());
		}

		return new SensorAndMeasurements(sensor, sam.getMeasurements());
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ExperimentRunImpl))
			return false;
		ExperimentRunImpl er = (ExperimentRunImpl) obj;

		if (!(experimentRunID == er.getExperimentRunID() && experimetDateTime
				.equals(er.getExperimentDateTime())))
			return false;
		if (!(sensorIDs.equals(er.sensorIDs)))
			return false;

		if (!(getSensorAndMeasurements().equals(er.getSensorAndMeasurements())))
			return false;
		return true;
	}
}

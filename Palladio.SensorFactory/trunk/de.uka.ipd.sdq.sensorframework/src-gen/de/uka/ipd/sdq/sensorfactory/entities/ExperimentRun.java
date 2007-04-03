package de.uka.ipd.sdq.sensorfactory.entities;

import de.uka.ipd.sdq.sensorfactory.entities.impl.SensorAndMeasurements;

@javax.persistence.Entity
@javax.persistence.Table(name = "EXPERIMENTRUN")
public abstract class ExperimentRun {
    /* Getter and Setter for Properties with cardinality 0..1 or 1 which are not a composition */
    @javax.persistence.Column(name = "EXPERIMENTDATETIME")
    private String m_experimentDateTime;
    @javax.persistence.Id
    @javax.persistence.Column(name = "EXPERIMENTRUNID")
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private long m_experimentRunID;

    /* Getter and Setter for Properties with cardinality 0..1 or 1 which are a composition */

    /* Getter and Setter for Properties with cardinality 0..* which are not a composition */

    /* Getter and Setter for Properties with cardinality 0..* which are a composition */
    @javax.persistence.OneToMany(cascade = javax.persistence.CascadeType.ALL)
    @javax.persistence.JoinTable(name = "ExperimentRun_measurements", joinColumns =  {
        @javax.persistence.JoinColumn(name = "EXPERIMENTRUN_ID")
    }
    , inverseJoinColumns =  {
        @javax.persistence.JoinColumn(name = "MEASUREMENT_ID")
    }
    )
    private java.util.Collection<de.uka.ipd.sdq.sensorfactory.entities.Measurement> m_measurements =
        new java.util.ArrayList<de.uka.ipd.sdq.sensorfactory.entities.Measurement>(10000);

    public String getExperimentDateTime() {
        return m_experimentDateTime;
    }

    public void setExperimentDateTime(String value) {
        this.m_experimentDateTime = value;
    }

    public long getExperimentRunID() {
        return m_experimentRunID;
    }

    public void setExperimentRunID(long value) {
        this.m_experimentRunID = value;
    }

    public de.uka.ipd.sdq.sensorfactory.entities.TimeSpanMeasurement addTimeSpanMeasurement(
        de.uka.ipd.sdq.sensorfactory.entities.TimeSpanSensor p_sensor,
        double p_timespan, double p_eventtime) {
        de.uka.ipd.sdq.sensorfactory.entities.TimeSpanMeasurement result = new de.uka.ipd.sdq.sensorfactory.entities.impl.TimeSpanMeasurementImpl();

        result.setTimeSpan(p_timespan);
        result.setEventTime(p_eventtime);
        result.setSensor(p_sensor);

        m_measurements.add(result);

        return result;
    }

    public de.uka.ipd.sdq.sensorfactory.entities.StateMeasurement addStateMeasurement(
        de.uka.ipd.sdq.sensorfactory.entities.StateSensor p_sensor,
        de.uka.ipd.sdq.sensorfactory.entities.State p_sensorstate,
        double p_eventtime) {
        de.uka.ipd.sdq.sensorfactory.entities.StateMeasurement result = new de.uka.ipd.sdq.sensorfactory.entities.impl.StateMeasurementImpl();

        result.setSensor(p_sensor);
        result.setEventTime(p_eventtime);
        result.setSensorState(p_sensorstate);

        m_measurements.add(result);

        return result;
    }

    public java.util.Collection<de.uka.ipd.sdq.sensorfactory.entities.Measurement> getMeasurements() {
        return this.m_measurements;
    }

    /* Abstract Operations */
    public abstract SensorAndMeasurements getMeasurementsOfSensor(
        de.uka.ipd.sdq.sensorfactory.entities.Sensor sensor);
}

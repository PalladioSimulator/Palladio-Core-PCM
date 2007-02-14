package de.uka.ipd.sdq.sensorfactory.entities;

@javax.persistence.Entity
public abstract class TimeSpanMeasurement extends de.uka.ipd.sdq.sensorfactory.entities.Measurement {
    /* Getter and Setter for Properties with cardinality 0..1 or 1 which are not a composition */
    @javax.persistence.Column(name = "TIMESPAN")
    private double m_timeSpan;
    @javax.persistence.OneToOne()
    @javax.persistence.JoinColumn(name = "FK_SENSOR")
    private de.uka.ipd.sdq.sensorfactory.entities.TimeSpanSensor m_sensor;

    public double getTimeSpan() {
        return m_timeSpan;
    }

    public void setTimeSpan(double value) {
        this.m_timeSpan = value;
    }

    public de.uka.ipd.sdq.sensorfactory.entities.TimeSpanSensor getSensor() {
        return m_sensor;
    }

    public void setSensor(
        de.uka.ipd.sdq.sensorfactory.entities.TimeSpanSensor value) {
        this.m_sensor = value;
    }

    /* Getter and Setter for Properties with cardinality 0..1 or 1 which are a composition */

    /* Getter and Setter for Properties with cardinality 0..* which are not a composition */

    /* Getter and Setter for Properties with cardinality 0..* which are a composition */

    /* Abstract Operations */
}

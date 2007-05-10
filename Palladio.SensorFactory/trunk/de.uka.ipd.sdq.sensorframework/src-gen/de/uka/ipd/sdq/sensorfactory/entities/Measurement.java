package de.uka.ipd.sdq.sensorfactory.entities;

@javax.persistence.Entity
@javax.persistence.Table(name = "MEASUREMENT")
public abstract class Measurement {
    /* Getter and Setter for Properties with cardinality 0..1 or 1 which are not a composition */
    @javax.persistence.Id
    @javax.persistence.Column(name = "MEASUREMENTID")
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    private long m_measurementID;
    @javax.persistence.Column(name = "EVENTTIME")
    private double m_eventTime;

    public long getMeasurementID() {
        return m_measurementID;
    }

    public void setMeasurementID(long value) {
        this.m_measurementID = value;
    }

    public double getEventTime() {
        return m_eventTime;
    }

    public void setEventTime(double value) {
        this.m_eventTime = value;
    }

    /* Getter and Setter for Properties with cardinality 0..1 or 1 which are a composition */

    /* Getter and Setter for Properties with cardinality 0..* which are not a composition */

    /* Getter and Setter for Properties with cardinality 0..* which are a composition */

    /* Abstract Operations */
}

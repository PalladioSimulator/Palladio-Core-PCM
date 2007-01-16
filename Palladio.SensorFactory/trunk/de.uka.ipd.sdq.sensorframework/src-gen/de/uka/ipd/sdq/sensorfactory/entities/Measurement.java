package de.uka.ipd.sdq.sensorfactory.entities;

@javax.persistence.Entity
@javax.persistence.Table(name = "MEASUREMENT")
public abstract class Measurement {
    @javax.persistence.Id
    @javax.persistence.GeneratedValue
    @javax.persistence.Column(name = "MEASUREMENTID")
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
}

package de.uka.ipd.sdq.sensorfactory.entities;

@javax.persistence.Entity
public abstract class TimeSpan extends de.uka.ipd.sdq.sensorfactory.entities.Measurement {
    @javax.persistence.Column(name = "TIMESPAN")
    private double m_timeSpan;

    public double getTimeSpan() {
        return m_timeSpan;
    }

    public void setTimeSpan(double value) {
        this.m_timeSpan = value;
    }
}

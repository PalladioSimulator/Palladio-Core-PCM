package de.uka.ipd.sdq.sensorfactory.entities;

@javax.persistence.Entity
@javax.persistence.Table(name = "SENSOR")
public abstract class Sensor {
    @javax.persistence.Column(name = "SENSORNAME")
    private String m_sensorName;
    @javax.persistence.Id
    @javax.persistence.GeneratedValue
    @javax.persistence.Column(name = "SENSORID")
    private long m_sensorID;

    public String getSensorName() {
        return m_sensorName;
    }

    public void setSensorName(String value) {
        this.m_sensorName = value;
    }

    public long getSensorID() {
        return m_sensorID;
    }

    public void setSensorID(long value) {
        this.m_sensorID = value;
    }
}

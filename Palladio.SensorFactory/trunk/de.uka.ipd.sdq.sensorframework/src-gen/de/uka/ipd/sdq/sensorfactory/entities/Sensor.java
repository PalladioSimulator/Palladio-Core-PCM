package de.uka.ipd.sdq.sensorfactory.entities;

@javax.persistence.Entity
@javax.persistence.Table(name = "SENSOR")
public abstract class Sensor {
    /* Getter and Setter for Properties with cardinality 0..1 or 1 which are not a composition */
    @javax.persistence.Column(name = "SENSORNAME")
    private String m_sensorName;
    @javax.persistence.Id
    @javax.persistence.Column(name = "SENSORID")
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
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

    /* Getter and Setter for Properties with cardinality 0..1 or 1 which are a composition */

    /* Getter and Setter for Properties with cardinality 0..* which are not a composition */

    /* Getter and Setter for Properties with cardinality 0..* which are a composition */

    /* Abstract Operations */
}

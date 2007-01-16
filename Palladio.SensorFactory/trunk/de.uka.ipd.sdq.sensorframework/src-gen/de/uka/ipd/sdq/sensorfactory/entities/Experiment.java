package de.uka.ipd.sdq.sensorfactory.entities;

@javax.persistence.Entity
@javax.persistence.Table(name = "EXPERIMENT")
public abstract class Experiment {
    @javax.persistence.Id
    @javax.persistence.GeneratedValue
    @javax.persistence.Column(name = "EXPERIMENTID")
    private long m_experimentID;
    @javax.persistence.Column(name = "EXPERIMENTNAME")
    private String m_experimentName;
    @javax.persistence.OneToMany(cascade = javax.persistence.CascadeType.ALL)
    @javax.persistence.JoinColumn(name = "FK_EXPERIMENT")
    private java.util.Collection<de.uka.ipd.sdq.sensorfactory.entities.Sensor> m_sensors =
        java.util.Collections.synchronizedList(new java.util.ArrayList<de.uka.ipd.sdq.sensorfactory.entities.Sensor>(
                10000));

    public long getExperimentID() {
        return m_experimentID;
    }

    public void setExperimentID(long value) {
        this.m_experimentID = value;
    }

    public String getExperimentName() {
        return m_experimentName;
    }

    public void setExperimentName(String value) {
        this.m_experimentName = value;
    }

    public de.uka.ipd.sdq.sensorfactory.entities.StateSensor addStateSensor(
        String p_sensorname) {
        de.uka.ipd.sdq.sensorfactory.entities.StateSensor result = new de.uka.ipd.sdq.sensorfactory.entities.impl.StateSensorImpl();

        result.setSensorName(p_sensorname);

        m_sensors.add(result);

        return result;
    }

    public de.uka.ipd.sdq.sensorfactory.entities.TimeSpanSensor addTimeSpanSensor(
        String p_sensorname) {
        de.uka.ipd.sdq.sensorfactory.entities.TimeSpanSensor result = new de.uka.ipd.sdq.sensorfactory.entities.impl.TimeSpanSensorImpl();

        result.setSensorName(p_sensorname);

        m_sensors.add(result);

        return result;
    }

    public java.util.Collection<de.uka.ipd.sdq.sensorfactory.entities.Sensor> getSensors() {
        return this.m_sensors;
    }
}

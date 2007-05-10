package de.uka.ipd.sdq.sensorfactory.entities;

@javax.persistence.Entity
@javax.persistence.Table(name = "EXPERIMENT")
public abstract class Experiment {
    /* Getter and Setter for Properties with cardinality 0..1 or 1 which are not a composition */
    @javax.persistence.Id
    @javax.persistence.Column(name = "EXPERIMENTID")
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private long m_experimentID;
    @javax.persistence.Column(name = "EXPERIMENTNAME")
    private String m_experimentName;

    /* Getter and Setter for Properties with cardinality 0..1 or 1 which are a composition */

    /* Getter and Setter for Properties with cardinality 0..* which are not a composition */

    /* Getter and Setter for Properties with cardinality 0..* which are a composition */
    @javax.persistence.OneToMany()
    @javax.persistence.JoinTable(name = "Experiment_sensors", joinColumns =  {
        @javax.persistence.JoinColumn(name = "EXPERIMENT_ID")
    }
    , inverseJoinColumns =  {
        @javax.persistence.JoinColumn(name = "SENSOR_ID")
    }
    )
    private java.util.Collection<de.uka.ipd.sdq.sensorfactory.entities.Sensor> m_sensors =
        new java.util.ArrayList<de.uka.ipd.sdq.sensorfactory.entities.Sensor>(10000);
    @javax.persistence.OneToMany(cascade = javax.persistence.CascadeType.ALL)
    @javax.persistence.JoinTable(name = "Experiment_experimentRuns", joinColumns =  {
        @javax.persistence.JoinColumn(name = "EXPERIMENT_ID")
    }
    , inverseJoinColumns =  {
        @javax.persistence.JoinColumn(name = "EXPERIMENTRUN_ID")
    }
    )
    private java.util.Collection<de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun> m_experimentRuns =
        new java.util.ArrayList<de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun>(10000);

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

    public de.uka.ipd.sdq.sensorfactory.entities.TimeSpanSensor addTimeSpanSensor(
        String p_sensorname) {
        de.uka.ipd.sdq.sensorfactory.entities.TimeSpanSensor result = new de.uka.ipd.sdq.sensorfactory.entities.impl.TimeSpanSensorImpl();

        result.setSensorName(p_sensorname);

        m_sensors.add(result);

        return result;
    }

    public de.uka.ipd.sdq.sensorfactory.entities.StateSensor addStateSensor(
        String p_sensorname) {
        de.uka.ipd.sdq.sensorfactory.entities.StateSensor result = new de.uka.ipd.sdq.sensorfactory.entities.impl.StateSensorImpl();

        result.setSensorName(p_sensorname);

        m_sensors.add(result);

        return result;
    }

    public java.util.Collection<de.uka.ipd.sdq.sensorfactory.entities.Sensor> getSensors() {
        return this.m_sensors;
    }

    public de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun addExperimentRun(
        String p_experimentdatetime) {
        de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun result = new de.uka.ipd.sdq.sensorfactory.entities.impl.ExperimentRunImpl();

        result.setExperimentDateTime(p_experimentdatetime);

        m_experimentRuns.add(result);

        return result;
    }

    public java.util.Collection<de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun> getExperimentRuns() {
        return this.m_experimentRuns;
    }

    /* Abstract Operations */
}

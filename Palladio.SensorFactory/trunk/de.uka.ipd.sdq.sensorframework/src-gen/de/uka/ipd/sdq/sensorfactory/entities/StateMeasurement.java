package de.uka.ipd.sdq.sensorfactory.entities;

@javax.persistence.Entity
public abstract class StateMeasurement extends de.uka.ipd.sdq.sensorfactory.entities.Measurement {
    /* Getter and Setter for Properties with cardinality 0..1 or 1 which are not a composition */
    @javax.persistence.OneToOne()
    @javax.persistence.JoinColumn(name = "FK_SENSORSTATE")
    private de.uka.ipd.sdq.sensorfactory.entities.State m_sensorState;
    @javax.persistence.OneToOne()
    @javax.persistence.JoinColumn(name = "FK_SENSOR")
    private de.uka.ipd.sdq.sensorfactory.entities.StateSensor m_sensor;

    public de.uka.ipd.sdq.sensorfactory.entities.State getSensorState() {
        return m_sensorState;
    }

    public void setSensorState(
        de.uka.ipd.sdq.sensorfactory.entities.State value) {
        this.m_sensorState = value;
    }

    public de.uka.ipd.sdq.sensorfactory.entities.StateSensor getSensor() {
        return m_sensor;
    }

    public void setSensor(
        de.uka.ipd.sdq.sensorfactory.entities.StateSensor value) {
        this.m_sensor = value;
    }

    /* Getter and Setter for Properties with cardinality 0..1 or 1 which are a composition */

    /* Getter and Setter for Properties with cardinality 0..* which are not a composition */

    /* Getter and Setter for Properties with cardinality 0..* which are a composition */

    /* Abstract Operations */
}

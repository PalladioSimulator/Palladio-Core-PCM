package de.uka.ipd.sdq.sensorfactory.entities;

@javax.persistence.Entity
public abstract class State extends de.uka.ipd.sdq.sensorfactory.entities.Measurement {
    @javax.persistence.OneToOne(cascade = javax.persistence.CascadeType.ALL)
    @javax.persistence.JoinColumn(name = "FK_STATE")
    private de.uka.ipd.sdq.sensorfactory.entities.SensorState m_sensorState;

    public de.uka.ipd.sdq.sensorfactory.entities.SensorState getSensorState() {
        return m_sensorState;
    }

    public void setSensorState(
        de.uka.ipd.sdq.sensorfactory.entities.SensorState value) {
        this.m_sensorState = value;
    }
}

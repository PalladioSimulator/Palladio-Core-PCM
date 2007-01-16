package de.uka.ipd.sdq.sensorfactory.entities;

@javax.persistence.Entity
public abstract class StateSensor extends de.uka.ipd.sdq.sensorfactory.entities.Sensor {
    @javax.persistence.OneToOne(cascade = javax.persistence.CascadeType.ALL)
    @javax.persistence.JoinColumn(name = "FK_STATESENSOR")
    private de.uka.ipd.sdq.sensorfactory.entities.SensorState m_initialState;
    @javax.persistence.OneToMany(cascade = javax.persistence.CascadeType.ALL)
    @javax.persistence.JoinColumn(name = "FK_STATESENSOR")
    private java.util.Collection<de.uka.ipd.sdq.sensorfactory.entities.SensorState> m_sensorStates =
        java.util.Collections.synchronizedList(new java.util.ArrayList<de.uka.ipd.sdq.sensorfactory.entities.SensorState>(
                10000));
    @javax.persistence.OneToMany(cascade = javax.persistence.CascadeType.ALL)
    @javax.persistence.JoinColumn(name = "FK_STATESENSOR")
    private java.util.Collection<de.uka.ipd.sdq.sensorfactory.entities.State> m_stateChanges =
        java.util.Collections.synchronizedList(new java.util.ArrayList<de.uka.ipd.sdq.sensorfactory.entities.State>(
                10000));

    public de.uka.ipd.sdq.sensorfactory.entities.SensorState getInitialState() {
        return m_initialState;
    }

    public void setInitialState(
        de.uka.ipd.sdq.sensorfactory.entities.SensorState value) {
        this.m_initialState = value;
    }

    public de.uka.ipd.sdq.sensorfactory.entities.SensorState addSensorState(
        String p_stateliteral) {
        de.uka.ipd.sdq.sensorfactory.entities.SensorState result = new de.uka.ipd.sdq.sensorfactory.entities.impl.SensorStateImpl();

        result.setStateLiteral(p_stateliteral);

        m_sensorStates.add(result);

        return result;
    }

    public java.util.Collection<de.uka.ipd.sdq.sensorfactory.entities.SensorState> getSensorStates() {
        return this.m_sensorStates;
    }

    public de.uka.ipd.sdq.sensorfactory.entities.State addState(
        double p_eventtime) {
        de.uka.ipd.sdq.sensorfactory.entities.State result = new de.uka.ipd.sdq.sensorfactory.entities.impl.StateImpl();

        result.setEventTime(p_eventtime);

        m_stateChanges.add(result);

        return result;
    }

    public java.util.Collection<de.uka.ipd.sdq.sensorfactory.entities.State> getStateChanges() {
        return this.m_stateChanges;
    }
}

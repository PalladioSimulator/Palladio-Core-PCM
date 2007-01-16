package de.uka.ipd.sdq.sensorfactory.entities;

@javax.persistence.Entity
@javax.persistence.Table(name = "SENSORSTATE")
public abstract class SensorState {
    @javax.persistence.Id
    @javax.persistence.GeneratedValue
    @javax.persistence.Column(name = "STATEID")
    private long m_stateID;
    @javax.persistence.Column(name = "STATELITERAL")
    private String m_stateLiteral;

    public long getStateID() {
        return m_stateID;
    }

    public void setStateID(long value) {
        this.m_stateID = value;
    }

    public String getStateLiteral() {
        return m_stateLiteral;
    }

    public void setStateLiteral(String value) {
        this.m_stateLiteral = value;
    }
}

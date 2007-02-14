package de.uka.ipd.sdq.sensorfactory.entities;

@javax.persistence.Entity
@javax.persistence.Table(name = "STATE")
public abstract class State {
    /* Getter and Setter for Properties with cardinality 0..1 or 1 which are not a composition */
    @javax.persistence.Id
    @javax.persistence.Column(name = "STATEID")
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
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

    /* Getter and Setter for Properties with cardinality 0..1 or 1 which are a composition */

    /* Getter and Setter for Properties with cardinality 0..* which are not a composition */

    /* Getter and Setter for Properties with cardinality 0..* which are a composition */

    /* Abstract Operations */
}

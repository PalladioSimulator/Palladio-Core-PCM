package de.uka.ipd.sdq.sensorfactory.entities;

@javax.persistence.Entity
public abstract class StateSensor extends de.uka.ipd.sdq.sensorfactory.entities.Sensor {
    /* Getter and Setter for Properties with cardinality 0..1 or 1 which are not a composition */
    @javax.persistence.OneToOne()
    @javax.persistence.JoinColumn(name = "FK_INITIALSTATE")
    private de.uka.ipd.sdq.sensorfactory.entities.State m_initialState;

    /* Getter and Setter for Properties with cardinality 0..1 or 1 which are a composition */

    /* Getter and Setter for Properties with cardinality 0..* which are not a composition */

    /* Getter and Setter for Properties with cardinality 0..* which are a composition */
    @javax.persistence.OneToMany(cascade = javax.persistence.CascadeType.ALL)
    @javax.persistence.JoinTable(name = "StateSensor_sensorStates", joinColumns =  {
        @javax.persistence.JoinColumn(name = "STATESENSOR_ID")
    }
    , inverseJoinColumns =  {
        @javax.persistence.JoinColumn(name = "SENSORSTATE_ID")
    }
    )
    private java.util.Collection<de.uka.ipd.sdq.sensorfactory.entities.State> m_sensorStates =
        new java.util.ArrayList<de.uka.ipd.sdq.sensorfactory.entities.State>(10000);

    public de.uka.ipd.sdq.sensorfactory.entities.State getInitialState() {
        return m_initialState;
    }

    public void setInitialState(
        de.uka.ipd.sdq.sensorfactory.entities.State value) {
        this.m_initialState = value;
    }

    public de.uka.ipd.sdq.sensorfactory.entities.State addState(
        String p_stateliteral) {
        de.uka.ipd.sdq.sensorfactory.entities.State result = new de.uka.ipd.sdq.sensorfactory.entities.impl.StateImpl();

        result.setStateLiteral(p_stateliteral);

        m_sensorStates.add(result);

        return result;
    }

    public java.util.Collection<de.uka.ipd.sdq.sensorfactory.entities.State> getSensorStates() {
        return this.m_sensorStates;
    }

    /* Abstract Operations */
}

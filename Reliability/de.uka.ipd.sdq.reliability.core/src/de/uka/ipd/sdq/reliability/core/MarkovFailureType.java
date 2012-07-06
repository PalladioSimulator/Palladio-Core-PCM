package de.uka.ipd.sdq.reliability.core;

/**
 * Represents a type identification for failure-on-demand occurrences during the reliability
 * analysis / simulation.
 * 
 * @author brosch
 * 
 */
public abstract class MarkovFailureType implements Comparable<MarkovFailureType> {

    /**
     * The degree of differentiation between failure types.
     */
    protected MarkovEvaluationType evaluationType = MarkovEvaluationType.POINTSOFFAILURE;

    /**
     * A default id for new failure types.
     */
    protected static String DEFAULT_ID = "Failure";

    /**
     * A default name for new failure types.
     */
    protected static String DEFAULT_NAME = "Failure";

    /**
     * The ID of this failure type.
     * 
     * The ID is unique across all failure types within an analysis or simulation run.
     */
    protected String id = null;

    /**
     * The id of the (system-required) interface which exhibits the failure.
     */
    protected String interfaceId = "";

    /**
     * The name of the (system-required) interface which exhibits the failure.
     */
    protected String interfaceName = "";

    /**
     * The human-readable name of this failure type.
     */
    protected String name = null;

    /**
     * The id of the (system-required) role which exhibits the failure.
     */
    protected String roleId = "";

    /**
     * The name of the (system-required) role which exhibits the failure.
     */
    protected String roleName = "";

    /**
     * The id of the (system-required) signature which exhibits the failure.
     */
    protected String signatureId = "";

    /**
     * The name of the (system-required) signature which exhibits the failure.
     */
    protected String signatureName = "";

    /**
     * Indicates if this failure type is system-external, i.e. originated outside the system.
     * 
     * By default, failure types are instantiated as being internal.
     */
    protected boolean systemExternal = false;

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo(MarkovFailureType o) {
        // The comparison is done by name:
        return getName().compareTo(o.getName());
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object obj) {

        // The equality test is based on (the failure type class and) the ID
        // attribute:
        if (evaluationType == MarkovEvaluationType.SINGLE) {
            return (obj instanceof MarkovFailureType) && (this.getId().equals(((MarkovFailureType) obj).getId()));
        } else {
            return (this.getClass().equals(obj.getClass())) && (this.getId().equals(((MarkovFailureType) obj).getId()));
        }
    }

    /**
     * Retrieves the ID of this failure type.
     * 
     * @return the ID of this failure type
     */
    public String getId() {
        return id;
    }

    /**
     * Retrieves the id of the (system-required) interface which exhibits the failure.
     * 
     * @return the interface id
     */
    public String getInterfaceId() {
        return interfaceId;
    }

    /**
     * Retrieves the name of the (system-required) interface which exhibits the failure.
     * 
     * @return the interface name
     */
    public String getInterfaceName() {
        return interfaceName;
    }

    /**
     * Retrieves a name of this failure type.
     * 
     * The name is used for describing the failure type in the simulation result data.
     * 
     * @return the name of this failure type.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the id of the (system-required) role which exhibits the failure.
     * 
     * @return the role id
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * Retrieves the name of the (system-required) role which exhibits the failure.
     * 
     * @return the role name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Retrieves the id of the (system-required) signature which exhibits the failure.
     * 
     * @return the signature id
     */
    public String getSignatureId() {
        return signatureId;
    }

    /**
     * Retrieves the name of the (system-required) signature which exhibits the failure.
     * 
     * @return the signature name
     */
    public String getSignatureName() {
        return signatureName;
    }

    /**
     * Indicates if this failure type is system-external, i.e. originated outside the system.
     * 
     * @return
     */
    public boolean isSystemExternal() {
        return systemExternal;
    }
}

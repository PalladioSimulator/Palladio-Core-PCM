package de.uka.ipd.sdq.reliability.solver.pcm2markov;

/**
 * Reflects a processing resource type from the PCM meta-model.
 * 
 * @author brosch
 * 
 */
public class MarkovResourceType {

    /**
     * The default value for members of this class that have not been specified.
     */
    static final String NOTSPECIFIED = "UNKNOWN";

    /**
     * The id of the associated resource type.
     */
    private String typeId;

    /**
     * The name of the resource type.
     */
    private String typeName;

    /**
     * The constructor.
     */
    public MarkovResourceType() {
        setId(NOTSPECIFIED);
        setName(NOTSPECIFIED);
    }

    /**
     * Retrieves the type ID.
     * 
     * @return the type ID
     */
    public String getId() {
        return typeId;
    }

    /**
     * Retrieves the type name.
     * 
     * @return the type name
     */
    public String getName() {
        return typeName;
    }

    /**
     * Sets the type ID.
     * 
     * @param typeId
     *            the type ID to set
     */
    public void setId(String typeId) {
        this.typeId = typeId;
    }

    /**
     * Sets the type name.
     * 
     * @param typeName
     *            the type name
     */
    public void setName(String typeName) {
        this.typeName = typeName;
    }
}
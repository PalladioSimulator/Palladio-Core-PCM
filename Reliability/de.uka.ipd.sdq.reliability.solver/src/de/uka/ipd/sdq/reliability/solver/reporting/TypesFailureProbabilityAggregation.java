package de.uka.ipd.sdq.reliability.solver.reporting;

/**
 * Class used for aggregation of failure probabilities according to a FailureAnalysisFailureType
 * when considering failure types.
 * 
 * @author Daniel Patejdl
 * 
 */
public class TypesFailureProbabilityAggregation {
    /**
     * The aggregated failure probability.
     */
    private double failureProbability;

    /**
     * The failure analysis failure type. The type may be used to distinguish several instances of
     * this class.
     */
    private FailureAnalysisFailureType failureType;

    /**
     * An additional string used to distinguish several instances of this class.
     */
    private String typeIdentifier;

    /**
     * Creates a new instance of this class, given the failure analysis failure type.
     * 
     * @param failureAggregationType
     *            the failure analysis failure type
     * @param typeIdentifier
     *            the type identifier
     * @param failureProbability
     *            the failure probability
     */
    public TypesFailureProbabilityAggregation(FailureAnalysisFailureType failureType, String typeIdentifier,
            double failureProbability) {
        this.failureType = failureType;
        this.typeIdentifier = typeIdentifier;
        this.failureProbability = failureProbability;
    }

    /**
     * Adds to the current aggregated failure probability additional failure probability.
     * 
     * @param failureProbability
     *            the failure probability to be added to the existing one
     */
    public void addToFailureProbability(double failureProbability) {
        this.failureProbability += failureProbability;
    }

    /**
     * Compares this instances failure type and type identifier to another instance's failure type
     * and type identifier.
     * 
     * @param otherfailureType
     *            the other instance's failure type
     * @param otherTypeIdentifier
     *            the other instance's type identifier
     * @return <code>true</code>, if and only if both the failure types and type identifiers match
     */
    public boolean compareTo(FailureAnalysisFailureType otherfailureType, String otherTypeIdentifier) {
        return (failureType == otherfailureType && typeIdentifier == otherTypeIdentifier);
    }

    /**
     * Retrieves the aggregated failure probability.
     * 
     * @return the aggregated failure probability
     */
    public double getFailureProbability() {
        return failureProbability;
    }

    /**
     * Returns the failure type.
     * 
     * @return the failure type
     */
    public FailureAnalysisFailureType getType() {
        return failureType;
    }

    /**
     * Gets the type identifier.
     * 
     * @return the type identifier
     */
    public String getTypeIdentifier() {
        return typeIdentifier;
    }

    /**
     * Sets the failure type.
     * 
     * @param failureType
     *            the failure type
     */
    public void setType(FailureAnalysisFailureType failureType) {
        this.failureType = failureType;
    }

    /**
     * Sets the type identifier
     * 
     * @param typeIdentifier
     *            the type identifier
     */
    public void setTypeIdentifier(String typeIdentifier) {
        this.typeIdentifier = typeIdentifier;
    }
}

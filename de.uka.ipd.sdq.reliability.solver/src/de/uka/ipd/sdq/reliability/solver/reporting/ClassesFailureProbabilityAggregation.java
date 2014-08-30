package de.uka.ipd.sdq.reliability.solver.reporting;

/**
 * Class used for aggregation of failure probabilities according to a FailureAnalysisFailureType
 * when considering failure categories (classes).
 * 
 * @author Daniel Patejdl
 * 
 */
public class ClassesFailureProbabilityAggregation {
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
     * Creates a new instance of this class, given the failure analysis failure type.
     * 
     * @param failureAggregationType
     */
    public ClassesFailureProbabilityAggregation(FailureAnalysisFailureType failureType) {
        this.failureType = failureType;
    }

    /**
     * Adds to the current aggregated failure probability additional failure probability.
     * 
     * @param failureProbability
     *            the failure probability to be added to the existing one
     */
    public void addToFailureProbabilityBy(double failureProbability) {
        this.failureProbability += failureProbability;
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
     * Sets the failure type.
     * 
     * @param failureAggregationType
     *            the failure type
     */
    public void setType(FailureAnalysisFailureType failureType) {
        this.failureType = failureType;
    }
}

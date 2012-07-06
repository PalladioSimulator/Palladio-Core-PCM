package de.uka.ipd.sdq.reliability.solver.pcm2markov;

import de.uka.ipd.sdq.reliability.core.MarkovFailureType;

/**
 * Describes a point of failure in a PCM model.
 * 
 * @author brosch
 * 
 */
public class FailureDescription {

    /**
     * The probability of failure.
     */
    private double failureProbability;

    /**
     * The type of failure.
     */
    private MarkovFailureType failureType;

    /**
     * Creates a new FailureDescription.
     * 
     * @param type
     *            the type of failure
     * @param probability
     *            the probability of failure
     */
    public FailureDescription(final MarkovFailureType type, final double probability) {
        this.failureType = type;
        this.failureProbability = probability;
    }

    /**
     * Retrieves the probability of failure.
     * 
     * @return the probability of failure
     */
    public final double getFailureProbability() {
        return failureProbability;
    }

    /**
     * Retrieves the type of failure.
     * 
     * @return the type of failure
     */
    public final MarkovFailureType getFailureType() {
        return failureType;
    }

    /**
     * Overwrites an existing failure probability.
     * 
     * @param failureProbability
     */
    public void setFailureProbability(final double failureProbability) {
        this.failureProbability = failureProbability;
    }
}

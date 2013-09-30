package de.uka.ipd.sdq.reliability.solver.pcm2markov;

/**
 * This class represents an approximated Markov transformation result value.
 * 
 * @author brosch
 * 
 */
public class MarkovResultApproximation {

    /**
     * The maximal accuracy yielded by an approximation.
     */
    private static final int MAXACCURACY = 10;

    /**
     * The accuracy (i.e., number of exact decimal places) of this approximation.
     */
    private int accuracy = 0;

    /**
     * The lower approximation bound after adjustment.
     */
    private double adjustedLowerBound = 0.0;

    /**
     * The upper approximation bound after adjustment.
     */
    private double adjustedUpperBound = 0.0;

    /**
     * A lower approximation bound.
     */
    private double lowerBound = 0.0;

    /**
     * An upper approximation bound.
     */
    private double upperBound = 0.0;

    /**
     * Initializes a new Markov result value approximation.
     * 
     * @param lowerBound
     *            the lower bound of the approximation
     * @param upperBound
     *            the upper bound of the approximation
     */
    public MarkovResultApproximation(final double lowerBound, final double upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        calculateAccuracy();
        adjustBounds();
    }

    /**
     * Replaces the approximation through a more coarse-grained one, in order to reduce the number
     * of decimal places of the bounds to the value of accuracy.
     */
    private void adjustBounds() {
        adjustedLowerBound = Math.floor(lowerBound * Math.pow(10, accuracy + 1)) / Math.pow(10, accuracy + 1);
        adjustedUpperBound = Math.ceil(upperBound * Math.pow(10, accuracy + 1)) / Math.pow(10, accuracy + 1);
    }

    /**
     * Determines the accuracy of the approximation.
     */
    private void calculateAccuracy() {
        double delta = upperBound - lowerBound;
        accuracy = 1;
        while (delta < Math.pow(0.1, accuracy)) {
            accuracy++;
            if (accuracy > MAXACCURACY) {
                break;
            }
        }
        accuracy -= 1;
    }

    /**
     * Retrieves the accuracy (i.e., number of exact decimal values) of the approximation.
     * 
     * @return the accuracy of the approximation
     */
    public int getAccuracy() {
        return accuracy;
    }

    /**
     * Retrieves the lower approximation bound after adjustment.
     * 
     * @return the lower approximation bound
     */
    public double getAdjustedLowerBound() {
        return adjustedLowerBound;
    }

    /**
     * Retrieves the upper approximation bound after adjustment.
     * 
     * @return the upper approximation bound
     */
    public double getAdjustedUpperBound() {
        return adjustedUpperBound;
    }

    /**
     * Retrieves the lower approximation bound.
     * 
     * @return the lower approximation bound
     */
    public double getLowerBound() {
        return lowerBound;
    }

    /**
     * Retrieves the upper approximation bound.
     * 
     * @return the upper approximation bound
     */
    public double getUpperBound() {
        return upperBound;
    }

    /**
     * Checks if the approximation fulfills a required accuracy (i.e., number of exact decimal
     * places).
     * 
     * @param requiredAccuracy
     *            the required accuracy
     * @return true if the required accuracy is fulfilled
     */
    public boolean hasRequiredAccuracy(final int requiredAccuracy) {
        return (accuracy >= requiredAccuracy);
    }
}

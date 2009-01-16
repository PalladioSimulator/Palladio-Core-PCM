/**
 * 
 */
package de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes;

/**This class contains the information about one bucket of a histogram.
 * It stores the value at which a bucket starts and the probability for
 * that bucket.
 * @author admin
 * @author groenda
 */
public class HistogramBucketInformation {
	
	/** The probability for the bucket */
	private double probability;
	
	/** The value at which the bucket starts */
	private double value;

	/**Creates a new bucket information.
	 * @param probability The probability of the bucket.
	 * @param value The value at which the bucket starts.
	 */
	public HistogramBucketInformation(double probability, double value) {
		this.probability = probability;
		this.value = value;
	}
	
	/**Receives the probability for the bucket.
	 * @return the probability
	 */
	public double getProbability() {
		return probability;
	}
	/**Sets the probability for the bucket.
	 * @param probability the new probability for the bucket.
	 */
	public void setProbability(double probability) {
		this.probability = probability;
	}
	/**Receives the value at which the bucket starts.
	 * @return the value at which the bucket starts.
	 */
	public double getValue() {
		return value;
	}
	/**Sets the value at which the bucket starts.
	 * @param value the new start value
	 */
	public void setValue(double value) {
		this.value = value;
	}
}

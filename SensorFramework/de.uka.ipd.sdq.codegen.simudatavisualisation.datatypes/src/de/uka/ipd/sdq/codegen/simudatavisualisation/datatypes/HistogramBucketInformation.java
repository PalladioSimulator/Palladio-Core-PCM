/**
 * 
 */
package de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes;

import java.io.Serializable;

import org.apache.log4j.Logger;

/**This class contains the information about one bucket of a histogram.
 * It stores the value at which a bucket starts and the probability for
 * that bucket.
 * @author groenda, Michael Kuperberg
 */
public class HistogramBucketInformation implements Comparable<HistogramBucketInformation>, Serializable {
	/** The logger used by this class. */
	private Logger logger;
	
	/**
	 * If the distance between two doubles is smaller than this value, they are considered tp be equal. 
	 */
	private static final double EPSILON = 0.00011D;

	/**
	 * For serialization
	 */
	private static final long serialVersionUID = 1L;

	/** The probability for the bucket */
	private double probability = Double.NaN;
	
	/** The value at which the bucket starts, i.e. NOT the middle of the bucket */
	private double value = Double.NaN;
	
	@SuppressWarnings("unused")
	private HistogramBucketInformation(){
		//empty private constructor to prevent undesired external usage
	}

	/**Creates a new bucket information.
	 * @param probability The probability of the bucket.
	 * @param value The value at which the bucket starts.
	 */
	public HistogramBucketInformation(double probability, double value) {
		this.logger =Logger.getLogger(this.getClass().getName());
		this.setProbability(probability);
		this.setValue(value);
	}
	
	@Override
	public int compareTo(HistogramBucketInformation o) {
		if(Math.abs(this.getValue()-o.getValue())<EPSILON){//Values are close enough
			if(Math.abs(this.getProbability()-o.getProbability())<EPSILON){
				return 0;
			}else{
				return Double.compare(this.getProbability(), o.getProbability());
			}
		}else{
			return Double.compare(this.getValue(), o.getValue());
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof HistogramBucketInformation){
			HistogramBucketInformation other = (HistogramBucketInformation) obj;
			if(this.compareTo(other)==0){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	/**Receives the probability for the bucket.
	 * @return the probability
	 */
	public double getProbability() {
		return probability;
	}
	
	/**Receives the value at which the bucket starts.
	 * @return the value at which the bucket starts.
	 */
	public double getValue() {
		return value;
	}

	/**Sets the probability for the bucket.
	 * @param probability the new probability for the bucket.
	 */
	public void setProbability(double probability) {
		if(probability<0.0D){
			logger.error/*throw new RuntimeException*/
			("Negative probability not permitted for HistogramBucketInformation");
			//this = null;//The only way to abort a constructor is to throw an exception?
		}else if(probability>1.0D){
			logger.error/*throw new RuntimeException*/
			("Probability >1 not permitted for HistogramBucketInformation");
		}else if(probability==Double.NaN){
			logger.error//*throw new RuntimeException*/
			("Probability NaN not permitted for HistogramBucketInformation");
		}else{
			this.probability = probability;
		}
	}
	
	/**Sets the value at which the bucket starts.
	 * @param value the new start value
	 */
	public void setValue(double value) {
		if(value==Double.NaN){
			logger.error/*throw new RuntimeException*/
			("Value NaN not permitted for HistogramBucketInformation");
		}else{
			this.value = value;
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return "(prob "+probability+", value "+value+")";
	}
}

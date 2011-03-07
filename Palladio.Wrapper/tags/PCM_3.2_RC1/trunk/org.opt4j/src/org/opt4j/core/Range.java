/**
 * 
 */
package org.opt4j.core;

/**
 * representing a range of values [min, max]
 * @author noorshams
 *
 */
public class Range {
	protected double min;
	protected double max;
	
	public Range(final double min, final double max) {
		this.min = min;
		this.max = max;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Range = [" + min + "," + max + "]";
	}
	/**
	 * @return the min
	 */
	public double getMin() {
		return min;
	}
	/**
	 * @param min the min to set
	 */
	public void setMin(final double min) {
		this.min = min;
	}
	/**
	 * @return the max
	 */
	public double getMax() {
		return max;
	}
	/**
	 * @param max the max to set
	 */
	public void setMax(final double max) {
		this.max = max;
	}
}
/**
 *
 */
package de.fzi.validation.effort.spttests;

import de.uka.ipd.sdq.workflow.AbstractJobConfiguration;

/**Configuration class for SPT-Paths validation effort estimations.
 *
 * @author Martin Krogmann
 * @author groenda
 *
 */
public class SPTEstimatorConfiguration extends AbstractJobConfiguration {
	/** Constant marking an invalid value for n. Supremum of invalid values. */
	public static final int INVALID_N = 0;

	/** Value of n in SPT-Tests. */
	protected int n = INVALID_N;

	public SPTEstimatorConfiguration() {
		super();
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.AbstractJobConfiguration#getErrorMessage()
	 */
	@Override
	public String getErrorMessage() {
		if (n < SPTEstimatorConfiguration.INVALID_N) {
			return "The parameter n must have a value greater or equal to 1.";
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.AbstractJobConfiguration#setDefaults()
	 */
	@Override
	public void setDefaults() {
		n = 1;
	}

	/**
	 * @return the n in SPT-Tests
	 */
	public int getN() {
		return n;
	}

	/**
	 * @param n the n to set in SPT-Tests
	 */
	public void setN(int n) {
		this.n = n;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		SPTEstimatorConfiguration result = (SPTEstimatorConfiguration) super.clone();
		result.n = this.n;
		return result;
	}
}

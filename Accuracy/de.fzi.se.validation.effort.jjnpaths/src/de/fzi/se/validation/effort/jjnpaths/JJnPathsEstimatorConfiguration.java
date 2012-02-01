/**
 *
 */
package de.fzi.se.validation.effort.jjnpaths;

import de.uka.ipd.sdq.workflow.AbstractJobConfiguration;

/**Configuration class for JJn-Paths validation effort estimations.
 *
 * @author groenda
 *
 */
public class JJnPathsEstimatorConfiguration extends AbstractJobConfiguration {
	/** Constant marking an invalid value for n. Supremum of invalid values. */
	public static final int INVALID_N = 0;

	/** Value of n in JJn-Paths. */
	protected int n = INVALID_N;

	public JJnPathsEstimatorConfiguration() {
		super();
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.AbstractJobConfiguration#getErrorMessage()
	 */
	@Override
	public String getErrorMessage() {
		if (n < JJnPathsEstimatorConfiguration.INVALID_N) {
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
	 * @return the n in JJn-PAths
	 */
	public int getN() {
		return n;
	}

	/**
	 * @param n the n to set in JJn-Paths
	 */
	public void setN(int n) {
		this.n = n;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		JJnPathsEstimatorConfiguration result = (JJnPathsEstimatorConfiguration) super.clone();
		result.n = this.n;
		return result;
	}
}

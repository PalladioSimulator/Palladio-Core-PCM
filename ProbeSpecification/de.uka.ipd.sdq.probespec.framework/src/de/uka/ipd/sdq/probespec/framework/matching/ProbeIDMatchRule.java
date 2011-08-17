package de.uka.ipd.sdq.probespec.framework.matching;

import javax.measure.quantity.Quantity;

import de.uka.ipd.sdq.probespec.framework.ProbeSample;

/**
 * This MatchRule is able to decide whether the passed {@link ProbeSample}
 * originates from the Probe with the specified probe id.
 * 
 * @author pmerkle
 * 
 */
public class ProbeIDMatchRule implements IMatchRule {

	private String probeID;

	/**
	 * Class constructor specifying the probe id to match.
	 * 
	 * @param probeID
	 *            the probe id to match
	 */
	public ProbeIDMatchRule(String probeID) {
		super();
		this.probeID = probeID;
	}

	/**
	 * Checks whether the passed ProbeSample originates from the probe with the
	 * probe id which has been passed using the constructor.
	 */
	@Override
	public boolean match(ProbeSample<?, ? extends Quantity> sample) {
		return sample.getProbeID().equals(probeID);
	}

}
package de.uka.ipd.sdq.probespec.framework.matching;

import javax.measure.quantity.Quantity;

import de.uka.ipd.sdq.probespec.framework.ProbeSample;
import de.uka.ipd.sdq.probespec.framework.ProbeType;

/**
 * This MatchRule is able to decide whether the passed {@link ProbeSample} is of
 * the specified probe type.
 * 
 * @author pmerkle
 * @see ProbeType
 */
public class ProbeTypeMatchRule implements IMatchRule {

	private ProbeType probeType;

	/**
	 * Class constructor specifying the probe type to match.
	 * 
	 * @param probeType
	 *            the probe type to match
	 */
	public ProbeTypeMatchRule(ProbeType probeType) {
		super();
		this.probeType = probeType;
	}

	/**
	 * Checks whether the passed ProbeSample is of the probe type which has been
	 * passed using the constructor.
	 */
	@Override
	public boolean match(ProbeSample<?, ? extends Quantity> sample) {
		return sample.getProbeType().equals(probeType);
	}

}

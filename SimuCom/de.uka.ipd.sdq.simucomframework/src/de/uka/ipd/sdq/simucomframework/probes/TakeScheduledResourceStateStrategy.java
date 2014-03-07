package de.uka.ipd.sdq.simucomframework.probes;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;

import de.uka.ipd.sdq.probespec.framework.ProbeSample;
import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.probes.IProbeStrategy;
import de.uka.ipd.sdq.simucomframework.resources.AbstractScheduledResource;

/**
 * ProbeStrategy which is able to measure the state of a
 * {@link AbstractScheduledResource}. The state is the total job count of the
 * resource.
 *
 * @author Philipp Merkle
 *
 */
public class TakeScheduledResourceStateStrategy implements IProbeStrategy {

	/**
	 * @param o
	 *            expects a {@link Long} representing the resource state
	 */
	@Override
	public ProbeSample<Long, Dimensionless> takeSample(String probeId,
			Object... o) {
		Long state = null;
		if (o.length >= 1 && o[0] instanceof Long) {
			state = (Long) o[0];
		} else {
			throw new IllegalArgumentException("Expected an argument of type "
					+ Long.class.getSimpleName() + ".");
		}

		Measure<Long, Dimensionless> stateMeasure = Measure.valueOf(state,
				Dimensionless.UNIT);
		ProbeSample<Long, Dimensionless> sample = new ProbeSample<Long, Dimensionless>(
				stateMeasure, probeId, ProbeType.RESOURCE_STATE);

		return sample;
	}

}

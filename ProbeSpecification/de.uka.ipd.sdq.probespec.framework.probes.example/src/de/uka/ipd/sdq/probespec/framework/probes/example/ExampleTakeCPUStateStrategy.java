package de.uka.ipd.sdq.probespec.framework.probes.example;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;

import de.uka.ipd.sdq.probespec.framework.ProbeSample;
import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.probes.IProbeStrategy;

public class ExampleTakeCPUStateStrategy implements IProbeStrategy {

	/**
	 * @param o
	 *            expects a {@link SimpleCPUResource}
	 */
	@Override
	public ProbeSample<Integer, Dimensionless> takeSample(final String probeId,
			final Object... o) {
		ASimpleActiveResource res = null;
		if (o[0] instanceof SimpleCPUResource) {
			res = (ASimpleActiveResource) o[0];
		} else {
			throw new IllegalArgumentException("Expected an argument of type "
					+ SimpleCPUResource.class.getSimpleName() + ".");
		}

		Measure<Integer, Dimensionless> jobs = Measure.valueOf(res.getJobs(),
				Dimensionless.UNIT);
		ProbeSample<Integer, Dimensionless> sample = new ProbeSample<Integer, Dimensionless>(
				jobs, probeId, ProbeType.RESOURCE_STATE);

		return sample;
	}

}

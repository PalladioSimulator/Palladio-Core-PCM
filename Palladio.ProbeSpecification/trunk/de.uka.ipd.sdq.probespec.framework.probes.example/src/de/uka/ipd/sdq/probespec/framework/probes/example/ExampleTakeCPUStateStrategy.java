package de.uka.ipd.sdq.probespec.framework.probes.example;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;

import de.uka.ipd.sdq.probespec.framework.ProbeSample;
import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.probes.ATakeCPUStateStrategy;

/**
 * Provides a specialized {@link ATakeCPUStateStrategy} for demonstration
 * purposes. It is in particular used inside of several test cases.
 * 
 * @author pmerkle
 * 
 */
public class ExampleTakeCPUStateStrategy extends ATakeCPUStateStrategy {

	/**
	 * Take a probe sample.
	 * 
	 * @param probeId
	 *            the id of the probe representing the measuring method within
	 *            the underlying model
	 * @param o
	 *            the active resource to be measured. Pass an object which
	 *            conforms to {@link ASimpleActiveResource}.
	 * @return the {@link ProbeSample} representing the measured sample
	 */
	@Override
	public ProbeSample<Integer, Dimensionless> takeSample(final String probeId,
			final Object... o) {
		ASimpleActiveResource res = null;
		if (o[0] instanceof SimpleCPUResource) {
			res = (ASimpleActiveResource) o[0];
		} else {
			throw new IllegalArgumentException(
					"Expected an argument of type SimpleCPUResource.");
		}

		Measure<Integer, Dimensionless> jobs = Measure.valueOf(res.getJobs(),
				Dimensionless.UNIT);
		ProbeSample<Integer, Dimensionless> sample = new ProbeSample<Integer, Dimensionless>(
				jobs, probeId, ProbeType.CPU_RESOURCE_STATE);

		return sample;
	}

}

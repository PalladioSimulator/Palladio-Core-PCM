package de.uka.ipd.sdq.probespec.framework.probes.example;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;

import de.uka.ipd.sdq.probespec.framework.ProbeSample;
import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.probes.ATakeHDDStateStrategy;

public class ExampleTakeHDDStateStrategy extends ATakeHDDStateStrategy {

	@Override
	public ProbeSample<Integer, Dimensionless> takeSample(String probeId,
			Object... o) {
		ASimpleActiveResource res = null;
		if (o[0] instanceof SimpleHDDResource) {
			res = (ASimpleActiveResource) o[0];
		} else {
			throw new IllegalArgumentException(
					"Expected an argument of type SimpleHDDResource.");
		}

		Measure<Integer, Dimensionless> jobs = Measure.valueOf(res.getJobs(),
				Dimensionless.UNIT);
		ProbeSample<Integer, Dimensionless> sample = new ProbeSample<Integer, Dimensionless>(
				jobs, probeId, ProbeType.HDD_RESOURCE_STATE);

		return sample;
	}

}

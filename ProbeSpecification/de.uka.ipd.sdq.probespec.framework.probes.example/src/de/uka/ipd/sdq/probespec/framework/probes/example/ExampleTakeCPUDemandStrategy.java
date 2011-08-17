package de.uka.ipd.sdq.probespec.framework.probes.example;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;

import de.uka.ipd.sdq.probespec.framework.ProbeSample;
import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.probes.IProbeStrategy;

public class ExampleTakeCPUDemandStrategy implements IProbeStrategy {

	/**
	 * @param o
	 *            expects a {@link ISimpleDemanding} and a
	 *            {@link ASimpleActiveResource} in arbitrary order
	 */
	@Override
	public ProbeSample<Double, Dimensionless> takeSample(String probeId,
			Object... o) {
		ISimpleDemanding demanding = null;
		ASimpleActiveResource resource = null;
		for (Object object : o) {
			if (object instanceof ISimpleDemanding) {
				demanding = (ISimpleDemanding) object;
			} else if (object instanceof SimpleCPUResource) {
				resource = (ASimpleActiveResource) object;
			}
		}
		if (demanding == null) {
			throw new IllegalArgumentException(
					"Expected an argument implementing IExampleDemanding.");
		}
		if (resource == null) {
			throw new IllegalArgumentException(
					"Expected an argument of type SimpleCPUResource.");
		}

		Measure<Double, Dimensionless> demand = Measure.valueOf(demanding
				.getDemand(resource), Dimensionless.UNIT);
		ProbeSample<Double, Dimensionless> sample = new ProbeSample<Double, Dimensionless>(
				demand, probeId, ProbeType.RESOURCE_DEMAND);

		return sample;
	}

}

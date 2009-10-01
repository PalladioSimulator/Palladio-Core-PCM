package de.uka.ipd.sdq.probespec.framework.probes.example;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;

import de.uka.ipd.sdq.probespec.framework.ProbeSample;
import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.probes.ATakeStoExStrategy;

public class ExampleTakeStoExStrategy extends ATakeStoExStrategy {

	@Override
	public ProbeSample<Double, Dimensionless> takeSample(String probeId,
			Object... o) {
		SimpleStoEx ex = null;
		if (o[0] instanceof SimpleStoEx) {
			ex = (SimpleStoEx) o[0];
		} else {
			throw new IllegalArgumentException(
					"Expected an argument of type SimpleStoEx.");
		}

		Measure<Double, Dimensionless> evalEx = Measure.valueOf(ex
				.evaluateExpression(), Dimensionless.UNIT);
		ProbeSample<Double, Dimensionless> sample = new ProbeSample<Double, Dimensionless>(
				evalEx, probeId, ProbeType.STOEX);

		return sample;
	}

}

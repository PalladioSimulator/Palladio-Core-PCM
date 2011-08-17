package de.uka.ipd.sdq.probespec.framework.probes.example;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;

import de.uka.ipd.sdq.probespec.framework.ProbeSample;
import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.probes.IProbeStrategy;

public class ExampleTakeSEFFParameterStrategy implements IProbeStrategy {

	/**
	 * @param o
	 *            expects a {@link SimpleSEFFParameter}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ProbeSample<?, Dimensionless> takeSample(String probeId, Object... o) {
		SimpleSEFFParameter<?> parameter;
		if (o[0] instanceof SimpleSEFFParameter) {
			parameter = (SimpleSEFFParameter<?>) o[0];
		} else {
			throw new IllegalArgumentException("Expected an argument of type "
					+ SimpleSEFFParameter.class.getSimpleName() + ".");
		}

		ProbeSample<?, Dimensionless> sample = null;
		if (parameter.getValue() instanceof Double) {
			Measure<Double, Dimensionless> value = Measure.valueOf(
					(Double) parameter.getValue(), Dimensionless.UNIT);
			sample = new ProbeSample<Double, Dimensionless>(value, probeId,
					ProbeType.SEFF_PARAMETER);
		} else if (parameter.getValue() instanceof Float) {
			Measure<Float, Dimensionless> value = Measure.valueOf(
					(Float) parameter.getValue(), Dimensionless.UNIT);
			sample = new ProbeSample<Float, Dimensionless>(value, probeId,
					ProbeType.SEFF_PARAMETER);
		} else if (parameter.getValue() instanceof Integer) {
			Measure<Integer, Dimensionless> value = Measure.valueOf(
					(Integer) parameter.getValue(), Dimensionless.UNIT);
			sample = new ProbeSample<Integer, Dimensionless>(value, probeId,
					ProbeType.SEFF_PARAMETER);
		} else if (parameter.getValue() instanceof Long) {
			Measure<Long, Dimensionless> value = Measure.valueOf(
					(Long) parameter.getValue(), Dimensionless.UNIT);
			sample = new ProbeSample<Long, Dimensionless>(value, probeId,
					ProbeType.SEFF_PARAMETER);
		} else {
			throw new IllegalArgumentException(
					"Expected an argument containing a value of type Double, Float, Integer or Long.");
		}

		return sample;
	}
}

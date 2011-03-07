package de.uka.ipd.sdq.probespec.framework.probes.example;

import static javax.measure.unit.SI.MILLI;
import static javax.measure.unit.SI.SECOND;

import javax.measure.Measure;
import javax.measure.quantity.Duration;
import javax.measure.unit.SI;

import de.uka.ipd.sdq.probespec.framework.ProbeSample;
import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.probes.IProbeStrategy;

/**
 * ProbeStrategy which is able to measure the current simulated time. The
 * simulated time's unit is assumed to be {@link SI#SECOND}.
 * 
 * @author Philipp Merkle
 * 
 */
public class ExampleTakeCurrentTimeStrategy implements IProbeStrategy {

	/**
	 * @param o
	 *            expects a {@link SimpleSimulationContext}
	 */
	@Override
	public ProbeSample<Double, Duration> takeSample(final String probeId,
			final Object... o) {
		SimpleSimulationContext simContext = null;
		if (o.length >= 1 && o[0] instanceof SimpleSimulationContext) {
			simContext = (SimpleSimulationContext) o[0];
		} else {
			if (o.length == 0) {
				throw new IllegalArgumentException("Missing argument of type "
						+ SimpleSimulationContext.class.getSimpleName() + ".");
			} else {
				throw new IllegalArgumentException("Expected an argument of type "
						+ SimpleSimulationContext.class.getSimpleName()
						+ " but was " + o[0].getClass().getSimpleName() + ".");	
			}
		}

		Measure<Double, Duration> time = Measure.valueOf((double) simContext
				.getSimulatedTime(), MILLI(SECOND));
		ProbeSample<Double, Duration> sample = new ProbeSample<Double, Duration>(
				time, probeId, ProbeType.CURRENT_TIME);
		return sample;
	}

}

package de.uka.ipd.sdq.probespec.framework.probes.example;

import javax.measure.Measure;
import javax.measure.quantity.Duration;
import static javax.measure.unit.SI.*;

import de.uka.ipd.sdq.probespec.framework.ProbeSample;
import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.probes.ATakeCurrentTimeStrategy;

/**
 * Provides a specialized {@link ATakeCurrentTimeStrategy} for demonstration
 * purposes. It is in particular used inside of several test cases.
 * 
 * @author pmerkle
 * 
 */
public class ExampleTakeCurrentTimeStrategy extends ATakeCurrentTimeStrategy {

	private SimpleSimulationContext ctx;

	/**
	 * Class constructor specifying the example simulation context.
	 * <p>
	 * The simulation context provides the current simulation time to be
	 * measured.
	 * 
	 * @param ctx
	 *            the example simulation context
	 * @see SimpleSimulationContext
	 */
	public ExampleTakeCurrentTimeStrategy(SimpleSimulationContext ctx) {
		this.ctx = ctx;
	}

	/**
	 * Take a probe sample.
	 * 
	 * @param probeId
	 *            the id of the probe representing the measuring method within
	 *            the underlying model
	 * @param o
	 *            this parameter is unused; <code>null</code> should be passed
	 * @return the {@link ProbeSample} representing the measured sample
	 */
	@Override
	public ProbeSample<Long, Duration> takeSample(final String probeId,
			final Object... o) {
		Measure<Long, Duration> time = Measure.valueOf(ctx.getSimulatedTime(),
				MILLI(SECOND));
		ProbeSample<Long, Duration> sample = new ProbeSample<Long, Duration>(
				time, probeId, ProbeType.CURRENT_TIME);
		return sample;
	}

}

package edu.kit.ipd.sdq.eventsim.measurement.calculator;

import edu.kit.ipd.sdq.eventsim.measurement.ProbeConfiguration;
import edu.kit.ipd.sdq.eventsim.measurement.probe.IProbe;
import edu.kit.ipd.sdq.eventsim.measurement.probe.ProbeFactory;

public class CalculatorBuilder<R, F, S, T, C extends ProbeConfiguration>
		implements IntermediateCalculatorFrom<R, F, S, T>, IntermediateCalculatorTo<R, F, S, T> {

	private IProbe<F, T> fromProbe;

	private IProbe<S, T> toProbe;

	private BinaryCalculator<R, F, S, T> c;

	private ProbeFactory<C> probeFactory;

	private CalculatorBuilder(BinaryCalculator<R, F, S, T> c, ProbeFactory<C> probeFactory) {
		this.c = c;
		this.probeFactory = probeFactory;
	}

	@Override
	public IntermediateCalculatorTo<R, F, S, T> from(F first, String property, Object... measurementContexts) {
		fromProbe = probeFactory.create(first, property, measurementContexts);
		return this;
	}

	@Override
	public BinaryCalculator<R, F, S, T> to(S second, String property, Object... measurementContexts) {
		toProbe = probeFactory.create(second, property, measurementContexts);
		c.setup(fromProbe, toProbe);
		return c;
	}

	public static <R, F, S, T, C extends ProbeConfiguration> IntermediateCalculatorFrom<R, F, S, T> create(
			BinaryCalculator<R, F, S, T> c, ProbeFactory<C> probeFactory) {
		return new CalculatorBuilder<R, F, S, T, C>(c, probeFactory);
	}

}

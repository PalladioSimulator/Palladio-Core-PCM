package de.uka.ipd.sdq.simucomframework.probes;

import javax.measure.Measure;
import javax.measure.quantity.Duration;
import javax.measure.unit.SI;

import de.uka.ipd.sdq.probespec.framework.ProbeSample;
import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.probes.ATakeCurrentTimeStrategy;
import de.uka.ipd.sdq.simucomframework.Context;

public class SimuComTakeCurrentTimeStrategy extends ATakeCurrentTimeStrategy {

	@Override
	public ProbeSample<Long, Duration> takeSample(String probeId, Object... o) {
		Context ctx = null;
		if (o[0] instanceof Context) {
			ctx = (Context) o[0];
		} else {
			throw new IllegalArgumentException(
					"Expected an argument of type Context.");
		}

		// Here it is assumed that the simulation time's unit is SI.SECOND
		double simTime = ctx.getModel().getSimulationControl()
				.getCurrentSimulationTime();

		// If a higher accuracy is needed, use e.g. SI.NANO after multiplying
		// simTime by 10^9
		// TODO	Check, whether accuracy is retained 
		Measure<Long, Duration> time = Measure.valueOf(
				(long) (simTime * 1000.0), SI.NANO(SI.SECOND));
		ProbeSample<Long, Duration> sample = new ProbeSample<Long, Duration>(
				time, probeId, ProbeType.CURRENT_TIME);

		return sample;
	}

}

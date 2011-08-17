package de.uka.ipd.sdq.probespec.framework.calculator;

import java.math.BigDecimal;
import java.util.Vector;

import javax.measure.Measure;
import javax.measure.quantity.Duration;
import javax.measure.quantity.Quantity;

import de.uka.ipd.sdq.probespec.framework.ProbeSample;
import de.uka.ipd.sdq.probespec.framework.ProbeSetSample;
import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;
import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.exceptions.CalculatorException;
import de.uka.ipd.sdq.probespec.framework.matching.IMatchRule;
import de.uka.ipd.sdq.probespec.framework.matching.ProbeTypeMatchRule;

/**
 * Calculates a time span. It expects two ProbeSets each containing at least a
 * {@link ProbeType#CURRENT_TIME} probe.
 * 
 * @author Faber, Philipp Merkle
 * 
 */
public abstract class TimeSpanCalculator extends BinaryCalculator {

    public TimeSpanCalculator(ProbeSpecContext ctx, Integer startProbeSetID, Integer endProbeSetID) {
        super(ctx, startProbeSetID, endProbeSetID);
    }

	/**
	 * Calculates the time span.
	 * 
	 * @param start
	 *            the ProbeSample of the start ProbeSet (ProbeType.CURRENT_TIME)
	 * @param end
	 *            the ProbeSample of the end ProbeSet (ProbeType.CURRENT_TIME)
	 * @return a result tuple containing two components. The first component is
	 *         the calculated time span, the second component is the end time of
	 *         the time span.
	 */
	@Override
	protected Vector<Measure<?, ? extends Quantity>> calculate(
			ProbeSetSample start, ProbeSetSample end)
			throws CalculatorException {
		// Obtain start time sample
		ProbeSample<Double, Duration> startTimeSample = obtainCurrentTimeProbeSample(start);
		if (startTimeSample == null) {
			throw new CalculatorException(
					"Could not access start probe sample.");
		}

		// Obtain end time sample
		ProbeSample<Double, Duration> endTimeSample = obtainCurrentTimeProbeSample(end);
		if (endTimeSample == null) {
			throw new CalculatorException("Could not access end probe sample.");
		}

		// Calculate time span
		BigDecimal endTime = BigDecimal.valueOf(endTimeSample.getMeasure().doubleValue(
				startTimeSample.getMeasure().getUnit()));
		BigDecimal startTime = BigDecimal.valueOf(startTimeSample.getMeasure().doubleValue(
				startTimeSample.getMeasure().getUnit()));
		
		BigDecimal responseTime = endTime.subtract(startTime);

		// Create result tuple
		Measure<Double, Duration> timeSpanMeasure = Measure.valueOf(
				responseTime.doubleValue(), startTimeSample.getMeasure().getUnit());
		Measure<Double, Duration> endTimeMeasure = endTimeSample.getMeasure();
		Vector<Measure<?, ? extends Quantity>> resultTuple = new Vector<Measure<?, ? extends Quantity>>();
		resultTuple.add(timeSpanMeasure);
		resultTuple.add(endTimeMeasure);

		return resultTuple;
	}

	@SuppressWarnings("unchecked")
	private ProbeSample<Double, Duration> obtainCurrentTimeProbeSample(
			ProbeSetSample probeSetSample) {
		IMatchRule[] rules = new IMatchRule[1];
		rules[0] = new ProbeTypeMatchRule(ProbeType.CURRENT_TIME);
		Vector<ProbeSample<?, ? extends Quantity>> result = probeSetSample
				.getProbeSamples(rules);

		if (result != null && result.size() > 0)
			return (ProbeSample<Double, Duration>) result.get(0);

		return null;
	}

}

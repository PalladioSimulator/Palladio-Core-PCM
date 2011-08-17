package de.uka.ipd.sdq.probespec.framework.calculator;

import java.util.Vector;

import javax.measure.Measure;
import javax.measure.quantity.Duration;
import javax.measure.quantity.Quantity;
import javax.measure.unit.Unit;

import de.uka.ipd.sdq.probespec.framework.ProbeSample;
import de.uka.ipd.sdq.probespec.framework.ProbeSetSample;
import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;
import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.exceptions.CalculatorException;
import de.uka.ipd.sdq.probespec.framework.matching.IMatchRule;
import de.uka.ipd.sdq.probespec.framework.matching.ProbeTypeMatchRule;

/**
 * Calculates the waiting time for resources in environments where the stop of
 * the waiting period cannot be observed directly. Rather the following values
 * (respectively events) should be observable.
 * <ul>
 * <li><code>start</code> - "request for processing"-event</li>
 * <li><code>stop</code> - "end of processing"-event (Notice: This is different
 * from the waiting period stop)</li>
 * <li><code>demand</code> - the demanded time</li>
 * </ul>
 * The waiting time results from calculating
 * <code>(stop - start) - demand </code>.
 * 
 * @author pmerkle
 * 
 */
public class DemandBasedWaitingTimeCalculator extends WaitingTimeCalculator {

    public DemandBasedWaitingTimeCalculator(ProbeSpecContext ctx, Integer startWaitingProbeSetID,
            Integer stopProcessingProbeSetID) {
        super(ctx, startWaitingProbeSetID, stopProcessingProbeSetID);
    }

	@SuppressWarnings("unchecked")
	@Override
	protected Vector<Measure<?, ? extends Quantity>> calculate(
			ProbeSetSample start, ProbeSetSample end)
			throws CalculatorException {
		// Obtain demand. The demand of start and end should be equal!
		ProbeSample<Double, Duration> demandSample = obtainDemandProbeSample(start);
		if (demandSample == null) {
			throw new CalculatorException(
					"Could not access demand probe sample.");
		}

		// Obtain processing time
		Vector<Measure<?, ? extends Quantity>> timeSpanResultTuple = super
				.calculate(start, end);
		Measure<Double, Duration> processingTimeSpanMeasure = (Measure<Double, Duration>) timeSpanResultTuple
				.get(0);
		Measure<Double, Duration> endTimeMeasure = (Measure<Double, Duration>) timeSpanResultTuple
				.get(1);

		// Calculate waiting time
		Unit<Duration> unit = processingTimeSpanMeasure.getUnit();
		double demand = demandSample.getMeasure().doubleValue(unit);
		double processingTime = processingTimeSpanMeasure.doubleValue(unit);
		double waitingTime = processingTime - demand;
		if (waitingTime < 0) {
//			final double threshold = -0.000001;
//			if (waitingTime < threshold) {
//				throw new RuntimeException(
//						"Calculated negative waiting time. This should not happen!");
//			} else {
				waitingTime = 0;
//			}
		}

		// Create result tuple
		Measure<Double, Duration> waitingTimeMeasure = Measure.valueOf(
				waitingTime, unit);
		Vector<Measure<?, ? extends Quantity>> resultTuple = new Vector<Measure<?, ? extends Quantity>>();
		resultTuple.add(waitingTimeMeasure);
		resultTuple.add(endTimeMeasure);

		return resultTuple;
	}

	@SuppressWarnings("unchecked")
	private ProbeSample<Double, Duration> obtainDemandProbeSample(
			ProbeSetSample probeSetSample) {
		IMatchRule[] rules = new IMatchRule[1];
		rules[0] = new ProbeTypeMatchRule(ProbeType.RESOURCE_DEMAND);
		Vector<ProbeSample<?, ? extends Quantity>> result = probeSetSample
				.getProbeSamples(rules);

		if (result != null && result.size() > 0)
			return (ProbeSample<Double, Duration>) result.get(0);

		return null;
	}

}

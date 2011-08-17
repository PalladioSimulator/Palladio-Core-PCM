package de.uka.ipd.sdq.probespec.framework.calculator;

import java.util.Vector;

import javax.measure.unit.SI;

import de.uka.ipd.sdq.pipesandfilters.framework.CaptureType;
import de.uka.ipd.sdq.pipesandfilters.framework.MeasurementMetric;
import de.uka.ipd.sdq.pipesandfilters.framework.Scale;
import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;

/**
 * Calculates a time span representing the waiting time.
 * 
 * @author Faber, Philipp Merkle
 * @see UnaryCalculator
 * @see Calculator
 */
public class WaitingTimeCalculator extends TimeSpanCalculator {

	private static Vector<MeasurementMetric> concreteMeasurementMetrics;

	/**
	 * Default Constructor.
	 * 
	 * @param ctx
	 *            the {@link ProbeSpecContext}
	 * @param startWaitingProbeSetID
	 *            references the ProbeSet which represents the starting point
	 *            for the waiting time measurement
	 * @param stopWaitingProbeSetID
	 *            references the ProbeSet which represents the final point for
	 *            the waiting time measurement
	 */
    public WaitingTimeCalculator(ProbeSpecContext ctx, Integer startWaitingProbeSetID, Integer stopWaitingProbeSetID) {
        super(ctx, startWaitingProbeSetID, stopWaitingProbeSetID);
    }

	// @SuppressWarnings("unchecked")
	// @Override
	// protected Vector<Measure<?, ? extends Quantity>> calculate(
	// ProbeSetSample sample) throws CalculatorException {
	// // Obtain measured resource response time
	// IMatchRule[] rules = new IMatchRule[1];
	// rules[0] = new ProbeTypeMatchRule(ProbeType.CPU_RESPONSE_TIME);
	// Vector<ProbeSample<?, ? extends Quantity>> result = sample
	// .getProbeSamples(rules);
	// ProbeSample<Double, Duration> responseTimeSample = null;
	// double responseTime = -1;
	// if (result != null && result.size() > 0) {
	// responseTimeSample = (ProbeSample<Double, Duration>) result.get(0);
	// responseTime = responseTimeSample.getMeasure().doubleValue(
	// responseTimeSample.getMeasure().getUnit());
	// }
	//
	// // Obtain measured demand
	// rules[0] = new ProbeTypeMatchRule(ProbeType.CPU_RESOURCE_DEMAND);
	// result = sample.getProbeSamples(rules);
	// ProbeSample<Double, Duration> demandSample = null;
	// double demand = -1;
	// if (result != null && result.size() > 0) {
	// demandSample = (ProbeSample<Double, Duration>) result.get(0);
	// demand = demandSample.getMeasure().doubleValue(
	// responseTimeSample.getMeasure().getUnit());
	// }
	//
	// if (responseTimeSample != null && demandSample != null) {
	// // Create result tuple
	// double waitTime = responseTime - demand;
	//
	// Measure<Double, Duration> waitTimeMeasure = Measure.valueOf(
	// waitTime, responseTimeSample.getMeasure().getUnit());
	// Vector<Measure<?, ? extends Quantity>> resultTuple = new
	// Vector<Measure<?, ? extends Quantity>>();
	// resultTuple.add(waitTimeMeasure);
	//
	// return resultTuple;
	// } else {
	// throw new CalculatorException(
	// "Could not access all needed probe samples.");
	// }
	// }

	/**
	 * Initializes the metric information for the result of this calculator
	 * type. The method is called by the constructor of the super class.
	 */
	@Override
	protected synchronized Vector<MeasurementMetric> getConcreteMeasurementMetrics() {
		if (concreteMeasurementMetrics == null) {
			concreteMeasurementMetrics = new Vector<MeasurementMetric>();
			MeasurementMetric mm = new MeasurementMetric(
					CaptureType.NATURAL_NUMBER, SI.MILLI(SI.SECOND),
					Scale.ORDINAL);
			mm.setDescription("This measure represents the waiting time");
			mm.setMonotonic(false);
			mm.setName("Waiting Time");
			mm.setStrongMonotonic(false);
			concreteMeasurementMetrics.add(mm);
		}
		return concreteMeasurementMetrics;
	}

}

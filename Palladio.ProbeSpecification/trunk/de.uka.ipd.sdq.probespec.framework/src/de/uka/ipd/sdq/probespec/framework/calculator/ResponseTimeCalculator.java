package de.uka.ipd.sdq.probespec.framework.calculator;

import java.util.Vector;

import javax.measure.Measure;
import javax.measure.quantity.Duration;
import javax.measure.quantity.Quantity;
import javax.measure.unit.SI;

import de.uka.ipd.sdq.pipesandfilters.framework.CaptureType;
import de.uka.ipd.sdq.pipesandfilters.framework.MeasurementMetric;
import de.uka.ipd.sdq.pipesandfilters.framework.PipeData;
import de.uka.ipd.sdq.pipesandfilters.framework.Scale;
import de.uka.ipd.sdq.probespec.framework.IMatchRule;
import de.uka.ipd.sdq.probespec.framework.ProbeSample;
import de.uka.ipd.sdq.probespec.framework.ProbeSetSample;
import de.uka.ipd.sdq.probespec.framework.ProbeSetSampleID;
import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.ProbeTypeMatchRule;
import de.uka.ipd.sdq.probespec.framework.SampleBlackboard;
import de.uka.ipd.sdq.probespec.framework.exceptions.CalculatorException;

/**
 * This class is a specific Calculator which calculates a time span representing
 * the ResponseTime. It needs two ProbeSets each containing at least a
 * CURRENT_TIME probe.
 * 
 * @author Faber
 * 
 */
public class ResponseTimeCalculator extends Calculator {

	private String startProbeSetID;
	private String endProbeSetID;

	private static Vector<MeasurementMetric> concreteMeasurementMetrics;

	/**
	 * Constructor for the ResponseTimeCalculator. It takes a reference of the
	 * blackboard and the IDs of the probe set elements taken from the model.
	 * 
	 * @param blackboard
	 *            A reference to the blackboard which this calculator will
	 *            observe
	 * @param startProbeSetID
	 *            ID of the start probe set element from the model
	 * @param endProbeSetID
	 *            ID of the end probe set element from the model
	 */
	public ResponseTimeCalculator(SampleBlackboard blackboard,
			String startProbeSetID, String endProbeSetID) {
		super(blackboard);
		this.startProbeSetID = startProbeSetID;
		this.endProbeSetID = endProbeSetID;
	}

	/**
	 * This method is called by the update method (Observer pattern) of the
	 * superclass. The method tries to get the corresponding start probe set
	 * sample and then extracts the necessary ProbeSamples. Here we make the
	 * assumption that the start ProbeSetSample always arrives before the end
	 * ProbeSetSample. Without this assumption all binary calculators would also
	 * have to try to get the end ProbeSetSample when the start ProbeSetSample
	 * arrives. Probably this would have a negative effect on the performance.
	 * 
	 * After the extraction it delegates the calculation to the calculate
	 * method.
	 * 
	 * @param pss
	 *            The last ProbeSetSample which was added to the
	 *            SampleBlackboard and so triggered this Calculator.
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected void execute(ProbeSetSample pss) throws CalculatorException {
		ProbeSetSample startSetSample;
		ProbeSetSample endSetSample;

		// For Binary Calculators: Execute only if second ProbeSetSample
		// arrives. Here we make the assumption that the start ProbeSetSample
		// always arrives before the end ProbeSetSample. See JavaDoc comment
		// above.
		if (endProbeSetID.equals(pss.getProbeSetSampleID().getProbeSetID())) {
			endSetSample = pss;

			startSetSample = blackboard.getProbeSetSample(new ProbeSetSampleID(
					startProbeSetID, pss.getProbeSetSampleID().getCtxID()));

			if (startSetSample != null) {
				ProbeSample<Long, Duration> startProbeValue = null;
				ProbeSample<Long, Duration> endProbeValue = null;

				IMatchRule[] rules = new IMatchRule[1];
				rules[0] = new ProbeTypeMatchRule(ProbeType.CURRENT_TIME);
				Vector<ProbeSample<?, ? extends Quantity>> result = startSetSample
						.getProbeSamples(rules);
				if (result != null && result.size() > 0)
					startProbeValue = (ProbeSample<Long, Duration>) result
							.get(0);

				rules[0] = new ProbeTypeMatchRule(ProbeType.CURRENT_TIME);
				result = endSetSample.getProbeSamples(rules);
				if (result != null && result.size() > 0)
					endProbeValue = (ProbeSample<Long, Duration>) result.get(0);

				if (startProbeValue != null && endProbeValue != null) {
					calculate(startProbeValue, endProbeValue);
				} else {
					throw new CalculatorException(
							"Could not access all needed probe samples.");
				}
			} else {
				throw new CalculatorException(
						"Could not access the corresponding start ProbeSetSample.");
			}
		}
	}

	/**
	 * This method encapsulates the actual logic of this Calculator. It creates
	 * a PipeData object containing the result tuple and then passes it to the
	 * pipe and filter chain.
	 * 
	 * @param r1
	 *            The ProbeSample of the start probe set
	 *            (ProbeType.CURRENT_TIME)
	 * @param r2
	 *            The ProbeSample of the end probe set (ProbeType.CURRENT_TIME)
	 */
	private void calculate(ProbeSample<Long, Duration> r1,
			ProbeSample<Long, Duration> r2) throws CalculatorException {
		
		// TODO Assert r1.unit == r2. unit!?
		Measure<Long, Duration> result = Measure.valueOf(r2.getMeasure()
				.longValue(r1.getMeasure().getUnit())
				- r1.getMeasure().longValue(r1.getMeasure().getUnit()), r1.getMeasure().getUnit());

		Vector<Measure<?, ? extends Quantity>> resultTuple = new Vector<Measure<?, ? extends Quantity>>();

		resultTuple.add(result);

		PipeData pd = new PipeData(resultTuple);

		if (pipesAndFiltersManager != null) {
			pipesAndFiltersManager.processData(pd);
		} else {
			throw new CalculatorException(
					"No PipesAndFilterManager is set. Could not pass the result to the PipesAndFilterManager.");
		}
	}

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
			mm.setDescription("This measure represents the response time");
			mm.setMonotonic(false);
			mm.setName("Response Time");
			mm.setStrongMonotonic(false);
			concreteMeasurementMetrics.add(mm);
		}
		return concreteMeasurementMetrics;
	}

}

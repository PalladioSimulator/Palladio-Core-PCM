package de.uka.ipd.sdq.probespec.framework.calculator;

import java.util.Vector;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;
import javax.measure.quantity.Quantity;
import javax.measure.unit.SI;

import de.uka.ipd.sdq.pipesandfilters.framework.CaptureType;
import de.uka.ipd.sdq.pipesandfilters.framework.MeasurementMetric;
import de.uka.ipd.sdq.pipesandfilters.framework.PipeData;
import de.uka.ipd.sdq.pipesandfilters.framework.Scale;
import de.uka.ipd.sdq.probespec.framework.IMatchRule;
import de.uka.ipd.sdq.probespec.framework.ProbeSample;
import de.uka.ipd.sdq.probespec.framework.ProbeSetSample;
import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.ProbeTypeMatchRule;
import de.uka.ipd.sdq.probespec.framework.SampleBlackboard;
import de.uka.ipd.sdq.probespec.framework.exceptions.CalculatorException;

/**
 * This class is a specific Calculator which composes a 2-tuple containing a
 * time stamp (first tuple element) and the state of the HDD resource (second
 * tuple element). It needs one ProbeSet containing at least a CURRENT_TIME
 * probe and an HDD_RESOURCE_STATE probe.
 * 
 * @author Faber
 * 
 */
public class HDDStateCalculator extends Calculator {

	private String probeSetID;
	private static Vector<MeasurementMetric> concreteMeasurementMetrics;

	/**
	 * Constructor for the HDDStateCalculator. It takes a reference of the
	 * blackboard and the ID of the probe set element taken from the model.
	 * 
	 * @param blackboard
	 *            A reference to the blackboard which this calculator will
	 *            observe
	 * @param probeSetID
	 *            ID of the probe set element from the model
	 */
	public HDDStateCalculator(SampleBlackboard blackboard, String probeSetID) {
		super(blackboard);
		this.probeSetID = probeSetID;
	}

	/**
	 * This method is called by the update method (Observer pattern) of the
	 * superclass. The method extracts the necessary ProbeSamples and then
	 * composes the PipeData. Finally it passes this PipeData to the pipe and
	 * filter chain.
	 * 
	 * @param pss
	 *            The last ProbeSetSample which was added to the
	 *            SampleBlackboard and so triggered this Calculator.
	 */
	@Override
	protected void execute(ProbeSetSample pss) throws CalculatorException {
		if (probeSetID.equals(pss.getProbeSetSampleID().getProbeSetID())) {
			ProbeSample<?, ? extends Quantity> time = null;
			ProbeSample<?, ? extends Quantity> hdd = null;

			IMatchRule[] rules = new IMatchRule[1];
			rules[0] = new ProbeTypeMatchRule(ProbeType.CURRENT_TIME);
			Vector<ProbeSample<?, ? extends Quantity>> result = pss
					.getProbeSamples(rules);
			if (result != null && result.size() > 0)
				time = result.get(0);

			rules[0] = new ProbeTypeMatchRule(ProbeType.HDD_RESOURCE_STATE);
			result = pss.getProbeSamples(rules);
			if (result != null && result.size() > 0)
				hdd = result.get(0);

			if (time != null && hdd != null) {
				Vector<Measure<?, ? extends Quantity>> resultTuple = new Vector<Measure<?, ? extends Quantity>>();

				resultTuple.add(time.getMeasure());
				resultTuple.add(hdd.getMeasure());

				PipeData pd = new PipeData(resultTuple);

				if (pipesAndFiltersManager != null) {
					pipesAndFiltersManager.processData(pd);
				} else {
					throw new CalculatorException(
							"No PipesAndFilterManager is set. Could not pass the result to the PipesAndFilterManager.");
				}
			} else {
				throw new CalculatorException(
						"Could not access all needed probe samples.");
			}
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
			mm
					.setDescription("This meausre represents the point of time when the value is taken");
			mm.setMonotonic(false);
			mm.setName("Point of time");
			mm.setStrongMonotonic(false);
			concreteMeasurementMetrics.add(mm);

			mm = new MeasurementMetric(CaptureType.NATURAL_NUMBER,
					Dimensionless.UNIT, Scale.ORDINAL);
			mm
					.setDescription("This measure represents the state of the HDD resource");
			mm.setMonotonic(false);
			mm.setName("State of the HDD resource");
			mm.setStrongMonotonic(false);
			concreteMeasurementMetrics.add(mm);
		}
		return concreteMeasurementMetrics;
	}

}

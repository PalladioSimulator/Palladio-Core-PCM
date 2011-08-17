package de.uka.ipd.sdq.probespec.framework.calculator;

import java.util.Vector;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;
import javax.measure.quantity.Quantity;
import javax.measure.unit.SI;

import de.uka.ipd.sdq.pipesandfilters.framework.CaptureType;
import de.uka.ipd.sdq.pipesandfilters.framework.MeasurementMetric;
import de.uka.ipd.sdq.pipesandfilters.framework.Scale;
import de.uka.ipd.sdq.probespec.framework.ProbeSample;
import de.uka.ipd.sdq.probespec.framework.ProbeSetSample;
import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;
import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.exceptions.CalculatorException;
import de.uka.ipd.sdq.probespec.framework.matching.IMatchRule;
import de.uka.ipd.sdq.probespec.framework.matching.ProbeTypeMatchRule;

/**
 * This class is a specific Calculator which composes a 2-tuple containing a
 * time stamp (first tuple element) and the CPU demand of an entity (second
 * tuple element). It needs one ProbeSet containing at least a CURRENT_TIME
 * probe and an CPU_RESOURCE_DEMAND probe.
 * 
 * @author Faber, Philipp Merkle
 * 
 */
public class DemandCalculator extends UnaryCalculator {

	private static Vector<MeasurementMetric> concreteMeasurementMetrics;

    /**
     * Constructor for the CPUDemandCalculator. It takes a reference of the blackboard and the ID of
     * the probe set element taken from the model.
     * 
     * @param ctx
     *            the {@link ProbeSpecContext}
     * @param probeSetID
     *            ID of the probe set element from the model
     */
    public DemandCalculator(ProbeSpecContext ctx, Integer probeSetID) {
        super(ctx, probeSetID);
    }

	@Override
	public Vector<Measure<?, ? extends Quantity>> calculate(
			ProbeSetSample sample) throws CalculatorException {
		// Obtain measurement time
		ProbeSample<?, ? extends Quantity> measurementTime = null;
		IMatchRule[] rules = new IMatchRule[1];
		rules[0] = new ProbeTypeMatchRule(ProbeType.CURRENT_TIME);
		Vector<ProbeSample<?, ? extends Quantity>> result = sample
				.getProbeSamples(rules);
		if (result != null && result.size() > 0)
			measurementTime = result.get(0);

		// Obtain demand
		ProbeSample<?, ? extends Quantity> demand = null;
		rules[0] = new ProbeTypeMatchRule(ProbeType.RESOURCE_DEMAND);
		result = sample.getProbeSamples(rules);
		if (result != null && result.size() > 0)
			demand = result.get(0);

		if (measurementTime != null && demand != null) {
			Vector<Measure<?, ? extends Quantity>> resultTuple = new Vector<Measure<?, ? extends Quantity>>();

			resultTuple.add(measurementTime.getMeasure());
			resultTuple.add(demand.getMeasure());

			return resultTuple;
		} else {
			throw new CalculatorException(
					"Could not access all needed probe samples.");
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
					.setDescription("This measure represents the point of time when the value is taken");
			mm.setMonotonic(false);
			mm.setName("Point of time");
			mm.setStrongMonotonic(false);
			concreteMeasurementMetrics.add(mm);

			mm = new MeasurementMetric(CaptureType.NATURAL_NUMBER,
					Dimensionless.UNIT, Scale.ORDINAL);
			mm
					.setDescription("This measure represents the CPU demand of the entity");
			mm.setMonotonic(false);
			mm.setName("CPU demand of the entity");
			mm.setStrongMonotonic(false);
			concreteMeasurementMetrics.add(mm);
		}
		return concreteMeasurementMetrics;
	}

}

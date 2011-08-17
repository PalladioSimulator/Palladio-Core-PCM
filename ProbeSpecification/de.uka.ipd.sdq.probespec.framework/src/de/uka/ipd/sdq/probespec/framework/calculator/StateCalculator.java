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
 * time stamp (first tuple element) and the state of a resource (second tuple
 * element). It needs one ProbeSet containing at least a CURRENT_TIME probe and
 * an {@link ProbeType#RESOURCE_STATE} probe.
 * 
 * @author Faber, Philipp Merkle
 * 
 */
public class StateCalculator extends UnaryCalculator {

	private static Vector<MeasurementMetric> concreteMeasurementMetrics;

    /**
     * Constructor. It takes a reference of the blackboard and the ID of the probe set element taken
     * from the model.
     * 
     * @param ctx
     *            the {@link ProbeSpecContext}
     * @param probeSetID
     *            ID of the probe set element from the model
     */
	public StateCalculator(ProbeSpecContext ctx, Integer probeSetID) {
		super(ctx, probeSetID);
	}

	@Override
	protected Vector<Measure<?, ? extends Quantity>> calculate(
			ProbeSetSample sample) throws CalculatorException {
		// Obtain measuring time
		IMatchRule[] rules = new IMatchRule[1];
		rules[0] = new ProbeTypeMatchRule(ProbeType.CURRENT_TIME);
		Vector<ProbeSample<?, ? extends Quantity>> result = sample
				.getProbeSamples(rules);
		ProbeSample<?, ? extends Quantity> time = null;
		if (result != null && result.size() > 0)
			time = result.get(0);

		// Obtain measured state
		rules[0] = new ProbeTypeMatchRule(ProbeType.RESOURCE_STATE);
		result = sample.getProbeSamples(rules);
		ProbeSample<?, ? extends Quantity> resourceState = null;
		if (result != null && result.size() > 0)
			resourceState = result.get(0);

		if (time != null && resourceState != null) {
			// Create result tuple
			Vector<Measure<?, ? extends Quantity>> resultTuple = new Vector<Measure<?, ? extends Quantity>>();
			resultTuple.add(time.getMeasure());
			resultTuple.add(resourceState.getMeasure());

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
					.setDescription("This meausre represents the point of time when the value is taken");
			mm.setMonotonic(false);
			mm.setName("Point of time");
			mm.setStrongMonotonic(false);
			concreteMeasurementMetrics.add(mm);

			mm = new MeasurementMetric(CaptureType.NATURAL_NUMBER,
					Dimensionless.UNIT, Scale.ORDINAL);
			mm
					.setDescription("This measure represents the state of the CPU resource");
			mm.setMonotonic(false);
			mm.setName("State of the CPU resource");
			mm.setStrongMonotonic(false);
			concreteMeasurementMetrics.add(mm);
		}
		return concreteMeasurementMetrics;
	}

}

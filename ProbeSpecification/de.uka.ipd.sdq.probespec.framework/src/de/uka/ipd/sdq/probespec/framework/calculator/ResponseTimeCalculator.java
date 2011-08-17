package de.uka.ipd.sdq.probespec.framework.calculator;

import java.util.Vector;

import javax.measure.unit.SI;

import de.uka.ipd.sdq.pipesandfilters.framework.CaptureType;
import de.uka.ipd.sdq.pipesandfilters.framework.MeasurementMetric;
import de.uka.ipd.sdq.pipesandfilters.framework.Scale;
import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;
import de.uka.ipd.sdq.probespec.framework.ProbeType;

/**
 * Calculates a time span representing the response time. It expects two
 * ProbeSets each containing at least a {@link ProbeType#CURRENT_TIME} probe.
 * 
 * @author Faber, Philipp Merkle
 * @see BinaryCalculator
 * @see Calculator
 */
public class ResponseTimeCalculator extends TimeSpanCalculator {

	private static Vector<MeasurementMetric> concreteMeasurementMetrics;

    /**
     * Default Constructor.
     * 
     * @param ctx
     *            the {@link ProbeSpecContext}
     * @param startProbeSetID
     *            ID of the start probe set element from the model
     * @param endProbeSetID
     *            ID of the end probe set element from the model
     */
    public ResponseTimeCalculator(ProbeSpecContext ctx, Integer startProbeSetID, Integer endProbeSetID) {
        super(ctx, startProbeSetID, endProbeSetID);
    }

	/**
	 * Initializes the metric information for the result of this calculator
	 * type. The method is called by the constructor of the super class.
	 */
	@Override
	protected synchronized Vector<MeasurementMetric> getConcreteMeasurementMetrics() {
		if (concreteMeasurementMetrics == null) {
			concreteMeasurementMetrics = new Vector<MeasurementMetric>();
			// TODO Specifying the unit here could be problematic since it can
			// conflict with the actually measured unit
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

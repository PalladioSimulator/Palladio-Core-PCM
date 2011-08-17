package de.uka.ipd.sdq.probespec.framework.calculator;

import java.util.Vector;

import javax.measure.unit.SI;

import de.uka.ipd.sdq.pipesandfilters.framework.CaptureType;
import de.uka.ipd.sdq.pipesandfilters.framework.MeasurementMetric;
import de.uka.ipd.sdq.pipesandfilters.framework.Scale;
import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;

/**
 * Calculates a time span representing the hold time.
 * 
 * @author Philipp Merkle
 */
public class HoldTimeCalculator extends TimeSpanCalculator {

	private static Vector<MeasurementMetric> concreteMeasurementMetrics;

    /**
     * Default Constructor.
     * 
     * @param ctx
     *            the {@link ProbeSpecContext}
     * @param startHoldProbeSetID
     *            references the ProbeSet which represents the starting point for the hold time
     *            measurement
     * @param stopHoldProbeSetID
     *            references the ProbeSet which represents the final point for the hold time
     *            measurement
     */
    public HoldTimeCalculator(ProbeSpecContext ctx, Integer startHoldProbeSetID, Integer stopHoldProbeSetID) {
        super(ctx, startHoldProbeSetID, stopHoldProbeSetID);
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
			mm.setDescription("This measure represents the hold time");
			mm.setMonotonic(false);
			mm.setName("Hold Time");
			mm.setStrongMonotonic(false);
			concreteMeasurementMetrics.add(mm);
		}
		return concreteMeasurementMetrics;
	}

}

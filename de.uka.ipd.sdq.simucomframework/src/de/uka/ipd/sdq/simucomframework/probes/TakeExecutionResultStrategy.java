package de.uka.ipd.sdq.simucomframework.probes;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;

import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.measurements.BasicMeasurement;
import de.uka.ipd.sdq.probespec.framework.probes.IProbeStrategy;

/**
 * ProbeStrategy which is able to measure the type of an execution result.
 *
 * The execution result type is identified through its numeric ID.
 *
 * @author brosch
 *
 */
public class TakeExecutionResultStrategy implements IProbeStrategy {

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * de.uka.ipd.sdq.probespec.framework.probes.IProbeStrategy#takeSample(java
	 * .lang.String, java.lang.Object[])
	 */
	public BasicMeasurement<Integer, Dimensionless> takeSample(String probeId,
			Object... o) {
		Integer stateId = null;
		if (o.length >= 1 && o[0] instanceof Integer) {
			stateId = (Integer) o[0];
		} else {
			throw new IllegalArgumentException("Expected an argument of type "
					+ Integer.class.getSimpleName() + ".");
		}
		Measure<Integer, Dimensionless> stateMeasure = Measure.valueOf(stateId,
				Dimensionless.UNIT);
		BasicMeasurement<Integer, Dimensionless> sample = new BasicMeasurement<Integer, Dimensionless>(
				stateMeasure, probeId, ProbeType.EXECUTION_RESULT);
		return sample;
	}
}

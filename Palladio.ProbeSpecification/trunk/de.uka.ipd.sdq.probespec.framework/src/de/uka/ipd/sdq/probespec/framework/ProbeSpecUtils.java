package de.uka.ipd.sdq.probespec.framework;

import java.util.Vector;

import javax.measure.quantity.Quantity;

public class ProbeSpecUtils {

	public static ProbeSetSample buildProbeSetSample(
			ProbeSample<?, ? extends Quantity> sample, String requestContextID,
			String modelElementId, String probeSetId) {
		Vector<ProbeSample<?, ? extends Quantity>> probeSampleVector = new Vector<ProbeSample<?, ? extends Quantity>>();
		probeSampleVector.add(sample);

		ProbeSetSample pss = new ProbeSetSample(probeSampleVector,
				new RequestContextID(requestContextID), modelElementId,
				probeSetId);
		pss.addToTimeToLive(1);
		return pss;
	}

}

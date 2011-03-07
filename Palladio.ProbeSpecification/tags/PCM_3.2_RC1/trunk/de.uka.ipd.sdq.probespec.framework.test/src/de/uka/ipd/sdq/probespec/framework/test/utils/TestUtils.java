package de.uka.ipd.sdq.probespec.framework.test.utils;

import java.util.Vector;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;
import javax.measure.quantity.Quantity;

import de.uka.ipd.sdq.probespec.framework.ProbeSample;

public class TestUtils {

	public static Vector<ProbeSample<?, ? extends Quantity>> createDummyProbeSample(
			Integer sample) {
		Vector<ProbeSample<?, ? extends Quantity>> samplesVector = new Vector<ProbeSample<?, ? extends Quantity>>();
		samplesVector.add(new ProbeSample<Integer, Dimensionless>(Measure
				.valueOf(sample, Dimensionless.UNIT), null, null));
		return samplesVector;
	}

}

/**
 * 
 */
package de.uka.ipd.sdq.probfunction.math.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;
import junit.framework.JUnit4TestAdapter;

import org.junit.Before;
import org.junit.Test;

import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.ISamplePDF;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInTimeDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.NegativeDistanceException;

/**
 * @author Ihssane
 * 
 */
public class SamplePDFTest {

	private ISamplePDF df1, df2, df3;

	private IProbabilityFunctionFactory dfFactory = IProbabilityFunctionFactory.eINSTANCE;

	
	private ISamplePDF createRandomSamplePDF(double distance, Double[] values) {
		return dfFactory.createSamplePDFFromDouble(distance, Arrays.asList(values),  dfFactory.createDefaultUnit());
	}
	
	@Before
	public void setUp() {
		df1 = createRandomSamplePDF(10, new Double[]{0.1, 0.2, 0.4, 0.3 });
		df2 = createRandomSamplePDF(10, new Double[]{0.0, 0.2, 0.1, 0.2, 0.3, 0.2 });
		df3 = createRandomSamplePDF(10, new Double[]{0.0, 0.2, 0.05, 0.15, 0.3, 0.2, 0.07, 0.03, 0.0 });
	}

	@Test
	public void timeDomain() {
		try {
			Assert.assertTrue(df1.isInTimeDomain());
			Assert.assertTrue(df2.isInTimeDomain());
			Assert.assertFalse(df1.isInFrequencyDomain());
			IProbabilityDensityFunction pdf = df1.getFourierTransform();
			Assert.assertFalse(pdf.isInTimeDomain());
			Assert.assertTrue(pdf.isInFrequencyDomain());
		} catch (FunctionNotInTimeDomainException e) {
			e.printStackTrace();
			Assert.assertFalse(true);
		}
	}
	
	@Test
	public void scale(){
		
	}



	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(SamplePDFTest.class);
	}
}

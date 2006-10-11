/**
 * 
 */
package de.uka.ipd.sdq.probfunction.math.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import junit.framework.JUnit4TestAdapter;

import org.junit.Before;
import org.junit.Test;

import de.uka.ipd.sdq.probfunction.math.IBoxedPDF;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.ISamplePDF;
import de.uka.ipd.sdq.probfunction.math.exception.UnknownPDFTypeException;

/**
 * @author Ihssane
 * 
 */
public class ProbabilityFunctionFactoryTest {

	private IBoxedPDF boxed;
	private double err = 1e-10;
	private IProbabilityFunctionFactory pfFactory = IProbabilityFunctionFactory.eINSTANCE;

	@Before
	public void setUp() {
		boxed = pfFactory.createBoxedPDF(null);
	}

	@Test
	public void boxedToSamplePDF() {
		boxed.getSamples().add(pfFactory.createContinuousSample(0.9, 0.3));
		boxed.getSamples().add(pfFactory.createContinuousSample(1.5, 0.4));
		boxed.getSamples().add(pfFactory.createContinuousSample(1.8, 0.2));
		boxed.getSamples().add(pfFactory.createContinuousSample(2.4, 0.1));

		ISamplePDF samplePDF;
		try {
			samplePDF = pfFactory.transformToSamplePDF(boxed);
			
			assertTrue(Math.abs(samplePDF.getDistance() - 0.3) < err);
			assertEquals(samplePDF.getValuesAsDouble().size(), 8);

			assertTrue(Math.abs(samplePDF.getValuesAsDouble().get(0) - 0.3 * 0.3 / 0.9) < err);
			assertTrue(Math.abs(samplePDF.getValuesAsDouble().get(1) - 0.3 * 0.3 / 0.9) < err);
			assertTrue(Math.abs(samplePDF.getValuesAsDouble().get(2) - 0.3 * 0.3 / 0.9) < err);
			assertTrue(Math.abs(samplePDF.getValuesAsDouble().get(3) - 0.4 * 0.3 / 0.6) < err);
			assertTrue(Math.abs(samplePDF.getValuesAsDouble().get(4) - 0.4 * 0.3 / 0.6) < err);
			assertTrue(Math.abs(samplePDF.getValuesAsDouble().get(5) - 0.2) < err);
			assertTrue(Math.abs(samplePDF.getValuesAsDouble().get(6) - 0.1 * 0.5) < err);
			assertTrue(Math.abs(samplePDF.getValuesAsDouble().get(7) - 0.1 * 0.5) < err);			
		} catch (UnknownPDFTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(ProbabilityFunctionFactoryTest.class);
	}
}

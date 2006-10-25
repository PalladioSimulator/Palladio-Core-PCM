package de.uka.ipd.sdq.probfunction.math.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import junit.framework.JUnit4TestAdapter;

import org.junit.Before;
import org.junit.Test;

import de.uka.ipd.sdq.probfunction.ProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.Sample;
import de.uka.ipd.sdq.probfunction.math.IBoxedPDF;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.ISample;
import de.uka.ipd.sdq.probfunction.math.ISamplePDF;
import de.uka.ipd.sdq.probfunction.math.IUnit;
import de.uka.ipd.sdq.probfunction.math.exception.DoubleSampleException;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilitySumNotOneException;
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
		try {
			boxed = pfFactory.createBoxedPDF(null);
		} catch (ProbabilitySumNotOneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DoubleSampleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

			assertTrue(Math
					.abs(samplePDF.getValuesAsDouble().get(0) - 0.3 * 0.3 / 0.9) < err);
			assertTrue(Math
					.abs(samplePDF.getValuesAsDouble().get(1) - 0.3 * 0.3 / 0.9) < err);
			assertTrue(Math
					.abs(samplePDF.getValuesAsDouble().get(2) - 0.3 * 0.3 / 0.9) < err);
			assertTrue(Math
					.abs(samplePDF.getValuesAsDouble().get(3) - 0.4 * 0.3 / 0.6) < err);
			assertTrue(Math
					.abs(samplePDF.getValuesAsDouble().get(4) - 0.4 * 0.3 / 0.6) < err);
			assertTrue(Math.abs(samplePDF.getValuesAsDouble().get(5) - 0.2) < err);
			assertTrue(Math
					.abs(samplePDF.getValuesAsDouble().get(6) - 0.1 * 0.5) < err);
			assertTrue(Math
					.abs(samplePDF.getValuesAsDouble().get(7) - 0.1 * 0.5) < err);
		} catch (UnknownPDFTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Transforming IProbabilityMassFunction to ProbabilityMassFunction should 
	 * leave samples, unit, and ordered domain intact.
	 */
	@Test
	public void iPMFToPMF() {
		IProbabilityMassFunction iProbFunc = pfFactory
				.createProbabilityMassFunction(getTestSamples(), getTestUnit(), true);

		ProbabilityMassFunction probFunc = pfFactory
				.transformToModelPMF(iProbFunc);

		Sample sample0 = (Sample)probFunc.getSamples().get(0);
		assertTrue((Integer)sample0.getValue() == 1);
		assertTrue(sample0.getProbability() == 0.1);
		Sample sample1 = (Sample)probFunc.getSamples().get(1);
		assertTrue((Integer)sample1.getValue() == 2);
		assertTrue(sample1.getProbability() == 0.3);
		Sample sample2 = (Sample)probFunc.getSamples().get(2);
		assertTrue((Integer)sample2.getValue() == 3);
		assertTrue(sample2.getProbability() == 0.5);
		Sample sample3 = (Sample)probFunc.getSamples().get(3);
		assertTrue((Integer)sample3.getValue() == 4);
		assertTrue(sample3.getProbability() == 0.1);
		
		assertTrue(probFunc.getUnit().getUnitName().equals("sec"));
		assertTrue(probFunc.isOrderedDomain());
	}

	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(ProbabilityFunctionFactoryTest.class);
	}

	private List<ISample> getTestSamples() {
		Object[] testSamples = { 1, 0.1, 2, 0.3, 3, 0.5, 4, 0.1 };
		List<ISample> sList = new ArrayList<ISample>();
		for (int i = 0; i < testSamples.length; i += 2) {
			ISample s = pfFactory.createSample(testSamples[i],
					(Double) testSamples[i + 1]);
			sList.add(s);
		}
		return sList;
	}
	
	private IUnit getTestUnit(){
		return pfFactory.createUnit("sec");
	}
}

package de.uka.ipd.sdq.probfunction.math.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import junit.framework.JUnit4TestAdapter;

import org.eclipse.emf.common.util.EList;
import org.junit.Before;
import org.junit.Test;

import de.uka.ipd.sdq.probfunction.BoxedPDF;
import de.uka.ipd.sdq.probfunction.ContinuousSample;
import de.uka.ipd.sdq.probfunction.ProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.ProbfunctionFactory;
import de.uka.ipd.sdq.probfunction.Sample;
import de.uka.ipd.sdq.probfunction.math.IBoxedPDF;
import de.uka.ipd.sdq.probfunction.math.IContinuousSample;
import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.ISample;
import de.uka.ipd.sdq.probfunction.math.ISamplePDF;
import de.uka.ipd.sdq.probfunction.math.IUnit;
import de.uka.ipd.sdq.probfunction.math.exception.DoubleSampleException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInTimeDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.InvalidSampleValueException;
import de.uka.ipd.sdq.probfunction.math.exception.NegativeDistanceException;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilitySumNotOneException;
import de.uka.ipd.sdq.probfunction.math.exception.UnitNameNotSetException;
import de.uka.ipd.sdq.probfunction.math.exception.UnitNotSetException;
import de.uka.ipd.sdq.probfunction.math.exception.UnknownPDFTypeException;
import de.uka.ipd.sdq.probfunction.math.impl.ExponentialDistribution;
import de.uka.ipd.sdq.probfunction.math.impl.GammaDistribution;
import de.uka.ipd.sdq.probfunction.math.impl.LognormalDistribution;
import de.uka.ipd.sdq.probfunction.math.impl.ProbabilityFunctionFactoryImpl;

/**
 * @author Ihssane
 * 
 */
public class ProbabilityFunctionFactoryTest {

	private IBoxedPDF boxed;

	private double err = 1e-10;

	private IProbabilityFunctionFactory pfFactory = IProbabilityFunctionFactory.eINSTANCE;
	private ProbfunctionFactory epfFactory = ProbfunctionFactory.eINSTANCE;

	@Before
	public void setUp() {
	}

	@Test
	public void boxedToSamplePDF() {
		List<IContinuousSample> samples = new ArrayList<IContinuousSample>();
		Collections.addAll(samples, pfFactory.createContinuousSample(0.9, 0.3),
				pfFactory.createContinuousSample(1.5, 0.4), pfFactory
						.createContinuousSample(1.8, 0.2), pfFactory
						.createContinuousSample(2.4, 0.1));
		try {
			boxed = pfFactory.createBoxedPDF(samples, null);
		} catch (DoubleSampleException e1) {
			e1.printStackTrace();
		}

		ISamplePDF samplePDF;
		try {
			samplePDF = pfFactory.transformToSamplePDF(boxed);

			assertTrue(Math.abs(samplePDF.getDistance() - 0.3) < err);
			assertEquals(samplePDF.getValuesAsDouble().size(), 9);

			assertTrue(Math
					.abs(samplePDF.getValuesAsDouble().get(0) - 0.3 * 0.15 / 0.9) < err);
			assertTrue(Math
					.abs(samplePDF.getValuesAsDouble().get(1) - 0.3 * 0.3 / 0.9) < err);
			assertTrue(Math
					.abs(samplePDF.getValuesAsDouble().get(2) - 0.3 * 0.3 / 0.9) < err);
			assertTrue(Math.abs(samplePDF.getValuesAsDouble().get(3)
					- ((0.3 * 0.15 / 0.9) + (0.4 * 0.15 / 0.6))) < err);
			assertTrue(Math
					.abs(samplePDF.getValuesAsDouble().get(4) - 0.4 * 0.3 / 0.6) < err);
			assertTrue(Math.abs(samplePDF.getValuesAsDouble().get(5)
					- ((0.4 * 0.15 / 0.6) + (0.2 * 0.15 / 0.3))) < err);
			assertTrue(Math.abs(samplePDF.getValuesAsDouble().get(6)
					- ((0.2 * 0.15 / 0.3) + (0.1 * 0.15 / 0.6))) < err);
			assertTrue(Math.abs(samplePDF.getValuesAsDouble().get(7)
					- (0.1 * 0.3 / 0.6)) < err);
			assertTrue(Math.abs(samplePDF.getValuesAsDouble().get(7)
					- (0.1 * 0.3 / 0.6)) < err);
			assertTrue(Math.abs(samplePDF.getValuesAsDouble().get(8)
					- (0.1 * 0.15 / 0.6)) < err);
		} catch (UnknownPDFTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		samplePDF = ((ProbabilityFunctionFactoryImpl) pfFactory)
				.transformBoxedToSamplePDF(boxed, 0.5);
		assertTrue(Math.abs(samplePDF.getDistance() - 0.5) < err);
		assertEquals(samplePDF.getValuesAsDouble().size(), 6);

		assertTrue(Math
				.abs(samplePDF.getValuesAsDouble().get(0) - 0.3 * 0.25 / 0.9) < err);
		assertTrue(Math
				.abs(samplePDF.getValuesAsDouble().get(1) - 0.3 * 0.5 / 0.9) < err);
		assertTrue(Math.abs(samplePDF.getValuesAsDouble().get(2)
				- ((0.3 * 0.15 / 0.9) + (0.4 * 0.35 / 0.6))) < err);
		assertTrue(Math.abs(samplePDF.getValuesAsDouble().get(3)
				- ((0.4 * 0.25 / 0.6) + (0.2 * 0.25 / 0.3))) < err);
		assertTrue(Math.abs(samplePDF.getValuesAsDouble().get(4)
				- ((0.2 * 0.05 / 0.3) + (0.1 * 0.45 / 0.6))) < err);
		assertTrue(Math.abs(samplePDF.getValuesAsDouble().get(5)
				- (0.1 * 0.15 / 0.6)) < err);
	}

	/**
	 * Transforming IProbabilityMassFunction to ProbabilityMassFunction should
	 * leave samples, unit, and ordered domain intact.
	 */
	@Test
	public void iPMFToPMF() {
		IProbabilityMassFunction iProbFunc = pfFactory
				.createProbabilityMassFunction(getTestSamples(), getTestUnit(),
						true);

		// this is the method to be tested:
		ProbabilityMassFunction probFunc = pfFactory
				.transformToModelPMF(iProbFunc);

		Sample sample0 = (Sample) probFunc.getSamples().get(0);
		assertTrue((Integer) sample0.getValue() == 1);
		assertTrue(sample0.getProbability() == 0.1);
		Sample sample1 = (Sample) probFunc.getSamples().get(1);
		assertTrue((Integer) sample1.getValue() == 2);
		assertTrue(sample1.getProbability() == 0.3);
		Sample sample2 = (Sample) probFunc.getSamples().get(2);
		assertTrue((Integer) sample2.getValue() == 3);
		assertTrue(sample2.getProbability() == 0.5);
		Sample sample3 = (Sample) probFunc.getSamples().get(3);
		assertTrue((Integer) sample3.getValue() == 4);
		assertTrue(sample3.getProbability() == 0.1);

//		assertTrue(probFunc.getUnitSpecification().equals("sec"));
		assertTrue(probFunc.isOrderedDomain());

		//
		iProbFunc = pfFactory.transformToPMF(probFunc);

		ISample s0 = iProbFunc.getSamples().get(0);
		assertTrue((Integer) s0.getValue() == 1);
		assertTrue(s0.getProbability() == 0.1);
		ISample s1 = iProbFunc.getSamples().get(1);
		assertTrue((Integer) s1.getValue() == 2);
		assertTrue(s1.getProbability() == 0.3);
		ISample s2 = iProbFunc.getSamples().get(2);
		assertTrue((Integer) s2.getValue() == 3);
		assertTrue(s2.getProbability() == 0.5);
		ISample s3 = iProbFunc.getSamples().get(3);
		assertTrue((Integer) s3.getValue() == 4);
		assertTrue(s3.getProbability() == 0.1);

		//assertTrue(iProbFunc.getUnit().getUnitName().equals("sec"));
		assertTrue(iProbFunc.hasOrderedDomain());
	}

	@Test
	public void ePMFToIPMF() {
		ProbabilityMassFunction epmf = epfFactory
				.createProbabilityMassFunction();
		epmf.setOrderedDomain(true);
		//epmf.setUnit(pfFactory.transformToModelUnit(getTestUnit()));
		initTestESamples(epmf.getSamples());

		IProbabilityMassFunction pmf = pfFactory.transformToPMF(epmf);

		ISample sample0 = pmf.getSamples().get(0);
		assertTrue((Integer) sample0.getValue() == 2);
		assertTrue(sample0.getProbability() == 0.1);
		ISample sample1 = pmf.getSamples().get(1);
		assertTrue((Integer) sample1.getValue() == 4);
		assertTrue(sample1.getProbability() == 0.3);
		ISample sample2 = pmf.getSamples().get(2);
		assertTrue((Integer) sample2.getValue() == 6);
		assertTrue(sample2.getProbability() == 0.5);
		ISample sample3 = pmf.getSamples().get(3);
		assertTrue((Integer) sample3.getValue() == 8);
		assertTrue(sample3.getProbability() == 0.1);

		//assertTrue(pmf.getUnit().getUnitName().equals("sec"));
		assertTrue(pmf.hasOrderedDomain());
	}

//	@Test
//	public void iSamplePDFToSamplePDF() throws UnknownPDFTypeException {
//		List<Double> samples = new ArrayList<Double>();
//		Collections.addAll(samples, 0.1, 0.3, 0.2, 0.2, 0.2);
//		ISamplePDF spdf = pfFactory.createSamplePDFFromDouble(0.1, samples,
//				getTestUnit());
//
//		SamplePDF espdf = pfFactory.transformToModelSamplePDF(spdf);
//
//		assertTrue(MathTools.equalsDouble(espdf.getDistance(), 0.1));
//		assertTrue((Double) espdf.getValues().get(0) == 0.1);
//		assertTrue((Double) espdf.getValues().get(1) == 0.3);
//		assertTrue((Double) espdf.getValues().get(2) == 0.2);
//		assertTrue((Double) espdf.getValues().get(3) == 0.2);
//		assertTrue((Double) espdf.getValues().get(4) == 0.2);
//		assertEquals(espdf.getUnit().getUnitName(), getTestUnit().getUnitName());
//	}

//	@SuppressWarnings("unchecked")
//	@Test
//	public void eSamplePDFToSamplePDF() throws UnknownPDFTypeException,
//			ProbabilitySumNotOneException, DoubleSampleException {
//		SamplePDF espdf = epfFactory.createSamplePDF();
//		espdf.setDistance(0.2);
//		Collections.addAll(espdf.getValues(), 0.1, 0.3, 0.2, 0.2, 0.2);
//		espdf.setUnit(pfFactory.transformToModelUnit(getTestUnit()));
//
//		ISamplePDF spdf = pfFactory.transformToSamplePDF(espdf);
//		assertTrue(spdf.getDistance() == 0.2);
//		//assertEquals(espdf.getUnit().getUnitName(), getTestUnit().getUnitName());
//		assertTrue(spdf.getValues().get(0).getReal() == 0.1);
//		assertTrue(spdf.getValues().get(1).getReal() == 0.3);
//		assertTrue(spdf.getValues().get(2).getReal() == 0.2);
//		assertTrue(spdf.getValues().get(3).getReal() == 0.2);
//		assertTrue(spdf.getValues().get(4).getReal() == 0.2);
//	}

//	@Test
//	public void iBoxedPDFToBoxedPDF() throws DoubleSampleException,
//			UnknownPDFTypeException, ProbabilitySumNotOneException,
//			FunctionNotInTimeDomainException {
//		IBoxedPDF bpdf = pfFactory.createBoxedPDF(getTestContinuousSamples(),
//				getTestUnit());
//
//		// this is the method to be tested:
//		BoxedPDF ebpdf = pfFactory.transformToModelBoxedPDF(bpdf);
//
//		ContinuousSample sample0 = (ContinuousSample) ebpdf.getSamples().get(0);
//		assertTrue(sample0.getValue() == 1.0);
//		assertTrue(sample0.getProbability() == 0.1);
//		ContinuousSample sample1 = (ContinuousSample) ebpdf.getSamples().get(1);
//		assertTrue(sample1.getValue() == 2.0);
//		assertTrue(sample1.getProbability() == 0.3);
//		ContinuousSample sample2 = (ContinuousSample) ebpdf.getSamples().get(2);
//		assertTrue(sample2.getValue() == 3.0);
//		assertTrue(sample2.getProbability() == 0.5);
//		ContinuousSample sample3 = (ContinuousSample) ebpdf.getSamples().get(3);
//		assertTrue(sample3.getValue() == 4.0);
//		assertTrue(sample3.getProbability() == 0.1);
//
//		assertTrue(ebpdf.getUnit()..getUnitName().equals("sec"));
//	}

	@Test
	public void eBoxedPDFToIBoxedPDF() throws ProbabilitySumNotOneException,
			DoubleSampleException {
		BoxedPDF ebpdf = epfFactory.createBoxedPDF();
		//ebpdf.setUnit(pfFactory.transformToModelUnit(getTestUnit()));
		initTestEContinuousSamples(ebpdf.getSamples());

		IBoxedPDF bpdf = pfFactory.transformToBoxedPDF(ebpdf);

		IContinuousSample sample0 = (IContinuousSample) bpdf.getSamples()
				.get(0);
		assertTrue(sample0.getValue() == 2.1);
		assertTrue(sample0.getProbability() == 0.1);
		IContinuousSample sample1 = (IContinuousSample) bpdf.getSamples()
				.get(1);
		assertTrue(sample1.getValue() == 3.5);
		assertTrue(sample1.getProbability() == 0.3);
		IContinuousSample sample2 = (IContinuousSample) bpdf.getSamples()
				.get(2);
		assertTrue(sample2.getValue() == 6.2);
		assertTrue(sample2.getProbability() == 0.5);
		IContinuousSample sample3 = (IContinuousSample) bpdf.getSamples()
				.get(3);
		assertTrue(sample3.getValue() == 6.7);
		assertTrue(sample3.getProbability() == 0.1);

		//assertTrue(bpdf.getUnit().getUnitName().equals("sec"));

		try {
			ebpdf = pfFactory.transformToModelBoxedPDF(bpdf);
		} catch (UnknownPDFTypeException e) {
			e.printStackTrace();
		} catch (FunctionNotInTimeDomainException e) {
			e.printStackTrace();
		}

		ContinuousSample s0 = (ContinuousSample) ebpdf.getSamples().get(0);
		assertTrue(s0.getValue() == 2.1);
		assertTrue(s0.getProbability() == 0.1);
		ContinuousSample s1 = (ContinuousSample) ebpdf.getSamples().get(1);
		assertTrue(s1.getValue() == 3.5);
		assertTrue(s1.getProbability() == 0.3);
		ContinuousSample s2 = (ContinuousSample) ebpdf.getSamples().get(2);
		assertTrue(s2.getValue() == 6.2);
		assertTrue(s2.getProbability() == 0.5);
		ContinuousSample s3 = (ContinuousSample) ebpdf.getSamples().get(3);
		assertTrue(s3.getValue() == 6.7);
		assertTrue(s3.getProbability() == 0.1);

		//assertTrue(ebpdf.getUnit().getUnitName().equals("sec"));
	}

	@Test
	public void createISamplePDF() {
		List<Double> samples = new ArrayList<Double>();
		Collections.addAll(samples, 0.1, 0.3, 0.2, 0.2, 0.2);
		ISamplePDF spdf = pfFactory.createSamplePDFFromDouble(0.1, samples,
				false, getTestUnit());
		assertTrue(!spdf.isInFrequencyDomain());
		assertTrue(spdf.getUnit().getUnitName().equals("sec"));
		
	}
//	@Test
//	public void createSamplePDFFromMeasurements() {
//		List<Double> measurements = new ArrayList<Double>();
//		Collections.addAll(measurements, 0.12, 0.34, 0.54, 1.4, 4.0, 3.0, 1.7,
//				1.8, 1.9, 2.1);
//		ISamplePDF spdf = pfFactory.createSamplePDFFromMeasurements(0.5,
//				measurements, getTestUnit());
//
//		assertTrue(MathTools.equalsDouble(0.5, spdf.getDistance()));
//		assertEquals(spdf.getValues().size(), 9);
//		assertTrue(MathTools.equalsDouble(spdf.getValues().get(0).getReal(),
//				0.1));
//		assertTrue(MathTools.equalsDouble(spdf.getValues().get(1).getReal(),
//				0.2));
//		assertTrue(MathTools.equalsDouble(spdf.getValues().get(2).getReal(),
//				0.0));
//		assertTrue(MathTools.equalsDouble(spdf.getValues().get(3).getReal(),
//				0.2));
//		assertTrue(MathTools.equalsDouble(spdf.getValues().get(4).getReal(),
//				0.3));
//		assertTrue(MathTools.equalsDouble(spdf.getValues().get(5).getReal(),
//				0.0));
//		assertTrue(MathTools.equalsDouble(spdf.getValues().get(6).getReal(),
//				0.1));
//		assertTrue(MathTools.equalsDouble(spdf.getValues().get(7).getReal(),
//				0.0));
//		assertTrue(MathTools.equalsDouble(spdf.getValues().get(8).getReal(),
//				0.1));
//	}

	@Test
	public void createPMFFromMeasurements() {
		Double[] measurements = {0.123, 0.340, 0.124, 0.343, 1.934, 0.345,
				1.935, 1.940, 1.945, 2.134};
		IProbabilityMassFunction pmf = pfFactory.createPMFFromMeasurements(
				measurements, 0.01, getTestUnit(), true);

		assertEquals(5, pmf.getSamples().size());
		assertTrue(0.2 == pmf.getSamples().get(0).getProbability());
		assertTrue(0.3 == pmf.getSamples().get(1).getProbability());
		assertTrue(0.3 == pmf.getSamples().get(2).getProbability());
		assertTrue(0.1 == pmf.getSamples().get(3).getProbability());
		assertTrue(0.1 == pmf.getSamples().get(4).getProbability());

		Integer[] m2 = {2, 7, 7, 3, 2, 3, 3, 1, 3, 0};
		pmf = pfFactory.createPMFFromMeasurements(m2, getTestUnit(), true);
		assertEquals(5, pmf.getSamples().size());
		assertTrue(0.1 == pmf.getSamples().get(0).getProbability());
		assertTrue(0.1 == pmf.getSamples().get(1).getProbability());
		assertTrue(0.2 == pmf.getSamples().get(2).getProbability());
		assertTrue(0.4 == pmf.getSamples().get(3).getProbability());
		assertTrue(0.2 == pmf.getSamples().get(4).getProbability());

		String[] m3 = {"test1", "test2", "1test", "test1", "1test", "test3",
				"test3", "test1", "test2", "test2"};
		pmf = pfFactory.createPMFFromMeasurements(m3, getTestUnit(), true);
		assertEquals(4, pmf.getSamples().size());
		assertTrue(0.2 == pmf.getSamples().get(0).getProbability());
		assertTrue(0.3 == pmf.getSamples().get(1).getProbability());
		assertTrue(0.3 == pmf.getSamples().get(2).getProbability());
		assertTrue(0.2 == pmf.getSamples().get(3).getProbability());

		Boolean[] m4 = {true, true, false, true, false, true, false, false,
				false, false};
		pmf = pfFactory.createPMFFromMeasurements(m4, getTestUnit(), true);
		assertEquals(2, pmf.getSamples().size());
		assertTrue(0.6 == pmf.getSamples().get(0).getProbability());
		assertTrue(0.4 == pmf.getSamples().get(1).getProbability());
	}

	@Test
	public void transformContinuousToBoxedPDF() throws UnknownPDFTypeException, ProbabilitySumNotOneException, DoubleSampleException, FunctionNotInTimeDomainException, NegativeDistanceException, UnitNotSetException, UnitNameNotSetException, InvalidSampleValueException{
		
		LognormalDistribution lognorm = new LognormalDistribution(1, 0.5);
		ExponentialDistribution exp = new ExponentialDistribution(0.5);
		GammaDistribution gamma = new GammaDistribution(3, 2);
				
		//Should not throw any exceptions
		transformAndCheck(lognorm);
		transformAndCheck(exp);
		transformAndCheck(gamma);
	}

	private void transformAndCheck(IProbabilityDensityFunction func) throws UnknownPDFTypeException,
			ProbabilitySumNotOneException, DoubleSampleException,
			FunctionNotInTimeDomainException, NegativeDistanceException,
			UnitNotSetException, UnitNameNotSetException,
			InvalidSampleValueException {
		IProbabilityFunctionFactory factory = ProbabilityFunctionFactoryImpl.getInstance();
		IBoxedPDF boxedPDF = factory.transformToBoxedPDF(func);
		boxedPDF.checkConstrains();
	}
	
	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(ProbabilityFunctionFactoryTest.class);
	}
	

	private List<ISample> getTestSamples() {
		Object[] testSamples = {1, 0.1, 2, 0.3, 3, 0.5, 4, 0.1};
		List<ISample> sList = new ArrayList<ISample>();
		for (int i = 0; i < testSamples.length; i += 2) {
			ISample s = pfFactory.createSample(testSamples[i],
					(Double) testSamples[i + 1]);
			sList.add(s);
		}
		return sList;
	}

	private List<IContinuousSample> getTestContinuousSamples() {
		Double[] testSamples = {1.0, 0.1, 2.0, 0.3, 3.0, 0.5, 4.0, 0.1};
		List<IContinuousSample> sList = new ArrayList<IContinuousSample>();
		for (int i = 0; i < testSamples.length; i += 2) {
			IContinuousSample s = pfFactory.createContinuousSample(
					testSamples[i], (Double) testSamples[i + 1]);
			sList.add(s);
		}
		return sList;
	}

	@SuppressWarnings("unchecked")
	private void initTestESamples(EList esList) {
		Object[] testSamples = {2, 0.1, 4, 0.3, 6, 0.5, 8, 0.1};
		for (int i = 0; i < testSamples.length; i += 2) {
			Sample s = epfFactory.createSample();
			s.setValue(testSamples[i]);
			s.setProbability((Double) testSamples[i + 1]);
			esList.add(s);
		}
	}

	@SuppressWarnings("unchecked")
	private void initTestEContinuousSamples(EList esList) {
		Double[] testSamples = {2.1, 0.1, 3.5, 0.3, 6.2, 0.5, 6.7, 0.1};
		for (int i = 0; i < testSamples.length; i += 2) {
			ContinuousSample s = epfFactory.createContinuousSample();
			s.setValue(testSamples[i]);
			s.setProbability((Double) testSamples[i + 1]);
			esList.add(s);
		}
	}
	private IUnit getTestUnit() {
		return pfFactory.createUnit("sec");
	}
}

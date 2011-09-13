/**
 * 
 */
package de.uka.ipd.sdq.probfunction.math.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import junit.framework.Assert;
import junit.framework.JUnit4TestAdapter;

import org.junit.Before;
import org.junit.Test;

import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.ISamplePDF;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInTimeDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionsInDifferenDomainsException;
import de.uka.ipd.sdq.probfunction.math.exception.IncompatibleUnitsException;
import de.uka.ipd.sdq.probfunction.math.exception.InvalidSampleValueException;
import de.uka.ipd.sdq.probfunction.math.exception.NegativeDistanceException;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilitySumNotOneException;
import de.uka.ipd.sdq.probfunction.math.exception.UnitNameNotSetException;
import de.uka.ipd.sdq.probfunction.math.exception.UnitNotSetException;
import de.uka.ipd.sdq.probfunction.math.exception.UnknownPDFTypeException;

/**
 * @author Ihssane
 * 
 */
public class SamplePDFTest {

	private ISamplePDF df1, df2, df3;

	private IProbabilityFunctionFactory dfFactory = IProbabilityFunctionFactory.eINSTANCE;

	private ISamplePDF createSamplePDF(double distance, Double[] values) {
		return dfFactory.createSamplePDFFromDouble(distance, Arrays
				.asList(values), dfFactory.createDefaultUnit());
	}

	@Before
	public void setUp() {
		df1 = createSamplePDF(10, new Double[]{0.1, 0.2, 0.4, 0.3});
		df2 = createSamplePDF(10, new Double[]{0.0, 0.2, 0.1, 0.2, 0.3, 0.2});
		df3 = createSamplePDF(10, new Double[]{0.0, 0.2, 0.05, 0.15, 0.3, 0.2,
				0.07, 0.03, 0.0});
	}

	@Test
	public void timeDomain() throws FunctionNotInTimeDomainException {
		Assert.assertTrue(df1.isInTimeDomain());
		Assert.assertTrue(df2.isInTimeDomain());
		Assert.assertFalse(df1.isInFrequencyDomain());
		IProbabilityDensityFunction pdf = df1.getFourierTransform();
		Assert.assertFalse(pdf.isInTimeDomain());
		Assert.assertTrue(pdf.isInFrequencyDomain());
	}

	@Test
	public void equals() {
		Assert.assertTrue(df1.equals(df1));

		ISamplePDF df1copy = createSamplePDF(10, new Double[]{0.1, 0.2, 0.4,
				0.3});
		Assert.assertTrue(df1.equals(df1copy));

		ISamplePDF df1LongCopy = createSamplePDF(10, new Double[]{0.1, 0.2,
				0.4, 0.3, 0.0});
		Assert.assertTrue(df1.equals(df1LongCopy));

		ISamplePDF df1LongWrongCopy = createSamplePDF(10, new Double[]{0.1,
				0.2, 0.4, 0.3, 0.0, 0.01});
		Assert.assertFalse(df1.equals(df1LongWrongCopy));

		Assert.assertFalse(df2.equals(df1));
		ISamplePDF df1WrongCopy = createSamplePDF(10, new Double[]{0.2, 0.1,
				0.4, 0.3});
		Assert.assertFalse(df1.equals(df1WrongCopy));
	}

	@Test
	public void scale() {
		IProbabilityDensityFunction df1scale = df1.scale(0.1);
		ISamplePDF spdf = createSamplePDF(10, new Double[]{0.01, 0.02, 0.04,
				0.03});
		Assert.assertEquals(spdf, df1scale);
	}

	@Test
	public void adjustDistance() throws NegativeDistanceException,
			FunctionNotInTimeDomainException {
		ISamplePDF pdf = df1.getFunctionWithNewDistance(10.0);
		Assert.assertEquals(df1, pdf);

		pdf = df1.getFunctionWithNewDistance(5.0);
		ISamplePDF expected = createSamplePDF(5.0, new Double[]{0.05, 0.1, 0.1,
				0.15, 0.2, 0.175, 0.15, 0.075});
		Assert.assertEquals(expected, pdf);

		pdf = df1.getFunctionWithNewDistance(7.0);
		expected = createSamplePDF(7, new Double[]{0.07, 0.14, 0.19, 0.28,
				0.215, 0.105});
		Assert.assertEquals(expected, pdf);

		pdf = df1.getFunctionWithNewDistance(15.0);
		expected = createSamplePDF(15, new Double[]{0.15, 0.45, 0.4});
		Assert.assertEquals(expected, pdf);

		pdf = df1.getFunctionWithNewDistance(13.0);
		expected = createSamplePDF(13, new Double[]{0.13, 0.35, 0.445, 0.075});
		Assert.assertEquals(expected, pdf);
	}

	@Test
	public void add() throws FunctionsInDifferenDomainsException,
			UnknownPDFTypeException, IncompatibleUnitsException {
		IProbabilityDensityFunction sum = df1.add(df1);
		ISamplePDF sumExpected = createSamplePDF(10, new Double[]{0.2, 0.4,
				0.8, 0.6});
		Assert.assertEquals(sumExpected, sum);

		sum = df1.add(df3);
		sumExpected = createSamplePDF(10, new Double[]{0.1, 0.4, 0.45, 0.45,
				0.3, 0.2, 0.07, 0.03, 0.0});
		Assert.assertEquals(sumExpected, sum);

		ISamplePDF pdf = createSamplePDF(5, new Double[]{0.05, 0.05, 0.1, 0.1,
				0.2, 0.2, 0.15, 0.15});
		sum = df1.add(pdf);
		sumExpected = createSamplePDF(5, new Double[]{0.1, 0.15, 0.2, 0.25,
				0.4, 0.375, 0.3, 0.225});
		Assert.assertEquals(sumExpected, sum);
	}

	@Test
	public void mult() throws FunctionsInDifferenDomainsException,
			UnknownPDFTypeException, IncompatibleUnitsException {
		IProbabilityDensityFunction prod = df1.mult(df1);
		ISamplePDF expected = createSamplePDF(10, new Double[]{0.01, 0.04,
				0.16, 0.09});
		Assert.assertEquals(expected, prod);
	}

	@Test
	public void checkConstraints() throws NegativeDistanceException,
			ProbabilitySumNotOneException, FunctionNotInTimeDomainException,
			UnitNotSetException, UnitNameNotSetException,
			InvalidSampleValueException {
		df1.checkConstrains();
		df2.checkConstrains();
		df3.checkConstrains();
	}

	@Test(expected = NegativeDistanceException.class)
	public void checkConstraints1() throws NegativeDistanceException,
			ProbabilitySumNotOneException, FunctionNotInTimeDomainException,
			UnitNotSetException, UnitNameNotSetException,
			InvalidSampleValueException {
		ISamplePDF s = createSamplePDF(-1.0, new Double[]{0.1, 0.4, 0.2, 0.3,
				0.2});
		s.checkConstrains();
	}

	@Test(expected = ProbabilitySumNotOneException.class)
	public void checkConstraints2() throws NegativeDistanceException,
			ProbabilitySumNotOneException, FunctionNotInTimeDomainException,
			UnitNotSetException, UnitNameNotSetException,
			InvalidSampleValueException {
		ISamplePDF s = createSamplePDF(1.0, new Double[]{0.1, 0.4, 0.2, 0.3,
				0.2});
		s.checkConstrains();
	}

	@Test(expected = InvalidSampleValueException.class)
	public void checkConstraints3() throws NegativeDistanceException,
			ProbabilitySumNotOneException, FunctionNotInTimeDomainException,
			UnitNotSetException, UnitNameNotSetException,
			InvalidSampleValueException {
		ISamplePDF s = createSamplePDF(1.0, new Double[]{0.1, -0.4, 0.2, 1.1});
		s.checkConstrains();
	}

	@Test(expected = UnitNotSetException.class)
	public void checkConstraints4() throws NegativeDistanceException,
			ProbabilitySumNotOneException, FunctionNotInTimeDomainException,
			UnitNotSetException, UnitNameNotSetException,
			InvalidSampleValueException {
		List<Double> samples = new ArrayList<Double>();
		Collections.addAll(samples, 0.1, 0.4, 0.2, 0.1);
		ISamplePDF s = dfFactory.createSamplePDFFromDouble(1.0, samples, null);
		s.checkConstrains();
	}

	// TODO: what is this supposed to test?
//	@Test
//	public void getMedian() throws UnorderedDomainException {
//		System.out.println("Df1 "+df1);
//		Assert.assertEquals(15.0, df1.getMedian());
//		Assert.assertEquals(25.0, df2.getMedian());
//		Assert.assertEquals(40.0, df3.getMedian());
//
//	}

	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(SamplePDFTest.class);
	}
}

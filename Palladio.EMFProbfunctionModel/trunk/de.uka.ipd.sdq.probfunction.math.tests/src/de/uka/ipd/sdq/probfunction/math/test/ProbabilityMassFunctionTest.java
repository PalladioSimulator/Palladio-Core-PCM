package de.uka.ipd.sdq.probfunction.math.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.ISample;
import de.uka.ipd.sdq.probfunction.math.IUnit;
import de.uka.ipd.sdq.probfunction.math.exception.DifferentDomainsException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInTimeDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.InvalidSampleValueException;
import de.uka.ipd.sdq.probfunction.math.exception.NegativeDistanceException;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilitySumNotOneException;
import de.uka.ipd.sdq.probfunction.math.exception.UnitNameNotSetException;
import de.uka.ipd.sdq.probfunction.math.exception.UnitNotSetException;
import de.uka.ipd.sdq.probfunction.math.exception.UnorderedDomainException;

public class ProbabilityMassFunctionTest {

	// unordered domain
	IProbabilityMassFunction u1, u1extended, u1exDiffProbs, u1same, u2;

	// ordered domain
	IProbabilityMassFunction o1, o1extended, o1exDiffProbs, o1same, o2;

	@Before
	public void setUp() throws Exception {
		u1 = createPMF(new Object[]{"car", 0.1, "house", 0.5, "bike", 0.3,
				"street", 0.1}, false);
		u1same = createPMF(new Object[]{"car", 0.2, "house", 0.3, "bike", 0.4,
				"street", 0.1}, false);

		u1extended = createPMF(new Object[]{"car", 0.1, "house", 0.5, "bike",
				0.3, "street", 0.1, "tree", 0.0}, false);
		u1exDiffProbs = createPMF(new Object[]{"car", 0.1, "house", 0.15,
				"bike", 0.3, "street", 0.1, "tree", 3.5}, false);
		u2 = createPMF(new Object[]{"dog", 0.2, "cat", 0.3, "pig", 0.4, "cow",
				0.1}, false);

		o1 = createPMF(new Object[]{0.1, 0.2, 0.2, 0.3, 0.3, 0.4, 0.4, 0.1},
				true);
		o1same = createPMF(
				new Object[]{0.1, 0.1, 0.2, 0.4, 0.3, 0.2, 0.4, 0.3}, true);

		o1extended = createPMF(new Object[]{0.1, 0.2, 0.2, 0.3, 0.3, 0.4, 0.4,
				0.1, 0.5, 0.0}, true);
		o1exDiffProbs = createPMF(new Object[]{0.1, 0.1, 0.2, 0.15, 0.3, 0.25,
				0.4, 0.3, 0.5, 0.1}, true);
		o2 = createPMF(new Object[]{0.2, 0.2, 0.4, 0.3, 0.6, 0.4, 0.8, 0.1},
				true);
	}

	@Test
	public void testCreatePMF() {
		Assert.assertEquals(4, o1.getSamples().size());
		Assert.assertEquals(4, u1.getSamples().size());
		Assert.assertEquals(5, u1extended.getSamples().size());
	}

	@Test
	public void equalsUnordered() {
		Assert.assertTrue(u1.equals(u1));

		IProbabilityMassFunction u1copy = createPMF(new Object[]{"car", 0.1,
				"house", 0.5, "bike", 0.3, "street", 0.1}, false);
		Assert.assertTrue(u1.equals(u1copy));

		Assert.assertFalse(u1.equals(u1same));

		Assert.assertFalse(u1.equals(u2));

		Assert.assertFalse(u1extended.equals(u1exDiffProbs));

		Assert.assertFalse(u1.equals(u1extended));

	}

	@Test
	public void equalsOrdered() {
		Assert.assertTrue(o1.equals(o1));

		IProbabilityMassFunction o1copy = createPMF(new Object[]{0.1, 0.2, 0.2,
				0.3, 0.3, 0.4, 0.4, 0.1}, true);
		Assert.assertTrue(o1.equals(o1copy));

		Assert.assertFalse(o1.equals(o1same));

		Assert.assertFalse(o1.equals(o2));

		Assert.assertFalse(o1extended.equals(o1exDiffProbs));

		Assert.assertFalse(o1.equals(o1extended));
	}

	@Test
	public void hasOrderDomain() {
		Assert.assertTrue(o1.hasOrderedDomain());
		Assert.assertFalse(u1.hasOrderedDomain());
	}

	@Test(expected = UnorderedDomainException.class)
	public void unorderedGetMedian() throws UnorderedDomainException {
		u1.getMedian();
	}

	@Test(expected = UnorderedDomainException.class)
	public void unorderedPercentile() throws UnorderedDomainException {
		u1.getPercentile(10);
	}

	@Test
	public void percentile() throws IndexOutOfBoundsException,
			UnorderedDomainException {
		Assert.assertEquals(0.3, o1.getPercentile(50)); // ??
	}

	@Test
	public void getMedian() throws UnorderedDomainException {
		Assert.assertEquals(0.3, o1.getMedian());
	}

	@Test
	public void addSameDom() throws DifferentDomainsException {
		IProbabilityMassFunction sum = o1.add(o1same);
		IProbabilityMassFunction expected = createPMF(new Object[]{0.1, 0.3,
				0.2, 0.7, 0.3, 0.6, 0.4, 0.4}, true);
		Assert.assertEquals(expected, sum);

		sum = u1.add(u1same);
		expected = createPMF(new Object[]{"car", 0.3, "house", 0.8, "bike",
				0.7, "street", 0.2}, true);
		Assert.assertEquals(expected, sum);

		IProbabilityMassFunction unsorted = createPMF(new Object[]{"car", 0.2,
				"street", 0.1, "house", 0.3, "bike", 0.4}, false);
		sum = u1.add(unsorted);
		expected = createPMF(new Object[]{"house", 0.8, "bike", 0.7, "car",
				0.3, "street", 0.2}, true);
		Assert.assertEquals(expected, sum);
	}

	@Test(expected = DifferentDomainsException.class)
	public void addExtendedDomOrdered() throws DifferentDomainsException {
		o1.add(o1extended);
	}

	@Test(expected = DifferentDomainsException.class)
	public void addExtendedDomUnOrdered() throws DifferentDomainsException {
		u1.add(u1extended);
	}

	@Test(expected = DifferentDomainsException.class)
	public void addOrderedUnOrdered() throws DifferentDomainsException {
		o1.add(u1);
	}

	@Test
	public void multSameDom() throws DifferentDomainsException {
		IProbabilityMassFunction sum = o1.mult(o1same);
		IProbabilityMassFunction expected = createPMF(new Object[]{0.1, 0.02,
				0.2, 0.12, 0.3, 0.08, 0.4, 0.03}, true);
		Assert.assertEquals(expected, sum);

		sum = u1.mult(u1same);
		expected = createPMF(new Object[]{"car", 0.1 * 0.2, "house", 0.5 * 0.3,
				"bike", 0.3 * 0.4, "street", 0.1 * 0.1}, false);
		Assert.assertEquals(expected, sum);
	}

	@Test
	public void scale() {
		IProbabilityMassFunction result = u1.scale(0.1);
		IProbabilityMassFunction expected = createPMF(new Object[]{"car", 0.01,
				"house", 0.05, "bike", 0.03, "street", 0.01}, false);
		Assert.assertEquals(expected, result);
	}

	@Test(expected = DifferentDomainsException.class)
	public void multExtendedDomOrdered() throws DifferentDomainsException {
		o1.add(o1extended);
	}

	@Test(expected = DifferentDomainsException.class)
	public void multExtendedDomUnOrdered() throws DifferentDomainsException {
		u1.add(u1extended);
	}

	@Test(expected = DifferentDomainsException.class)
	public void multOrderedUnOrdered() throws DifferentDomainsException {
		o1.add(u1);
	}

	@Test(expected = ProbabilitySumNotOneException.class)
	public void checkConstrains1() throws NegativeDistanceException,
			ProbabilitySumNotOneException, FunctionNotInTimeDomainException,
			UnitNotSetException, UnitNameNotSetException,
			InvalidSampleValueException {
		IProbabilityMassFunction pmf = createPMF(new Object[]{0.1, 0.3, 0.2,
				0.3, 0.3, 0.4, 0.4, 0.1}, true);
		pmf.checkConstrains();
	}

	@Test(expected = InvalidSampleValueException.class)
	public void checkConstrains3() throws NegativeDistanceException,
			ProbabilitySumNotOneException, FunctionNotInTimeDomainException,
			UnitNotSetException, UnitNameNotSetException,
			InvalidSampleValueException {
		IProbabilityMassFunction pmf = createPMF(new Object[]{0.1, 0.3, 0.2,
				0.4, 0.4, 0.4, 0.4, -0.1}, true);
		pmf.checkConstrains();
	}

//	@Test(expected = UnitNotSetException.class)
//	public void checkConstrains2() throws NegativeDistanceException,
//			ProbabilitySumNotOneException, FunctionNotInTimeDomainException,
//			UnitNotSetException, UnitNameNotSetException,
//			InvalidSampleValueException {
//		List<ISample> samples = new ArrayList<ISample>();
//		Collections.addAll(samples, dfFactory.createSample(0.1, 0.3), dfFactory
//				.createSample(0.2, 0.2), dfFactory.createSample(0.3, 0.4),
//				dfFactory.createSample(0.4, 0.1));
//		IProbabilityMassFunction pmf = dfFactory.createProbabilityMassFunction(
//				samples, null, true);
//		pmf.checkConstrains();
//	}

	@Test
	public void checkConstrains4() throws NegativeDistanceException,
			ProbabilitySumNotOneException, FunctionNotInTimeDomainException,
			UnitNotSetException, UnitNameNotSetException,
			InvalidSampleValueException {
		u1.checkConstrains();
		o1.checkConstrains();
		u1extended.checkConstrains();
	}

	private IProbabilityFunctionFactory dfFactory = IProbabilityFunctionFactory.eINSTANCE;

	private IProbabilityMassFunction createPMF(Object[] samples,
			boolean isOrderedSet) {
		List<ISample> sList = new ArrayList<ISample>();
		for (int i = 0; i < samples.length; i += 2) {
			ISample s = dfFactory.createSample(samples[i],
					(Double) samples[i + 1]);
			sList.add(s);
		}
		IUnit ms = dfFactory.createUnit("ms");
		IProbabilityMassFunction pmf = dfFactory.createProbabilityMassFunction(
				sList, ms, isOrderedSet);
		return pmf;
	}
}

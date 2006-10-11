/**
 * 
 */
package de.uka.ipd.sdq.probfunction.math.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.ISample;
import de.uka.ipd.sdq.probfunction.math.exception.DomainNotNumbersException;
import de.uka.ipd.sdq.probfunction.math.exception.UnorderedDomainException;

/**
 * @author Ihssane
 * 
 */
public class ProbabilityMassFunctionImpl extends ProbabilityFunctionImpl implements IProbabilityMassFunction {

	private List<ISample> samples;
	private IProbabilityFunctionFactory pfFactory;

	protected ProbabilityMassFunctionImpl() {
		samples = new ArrayList<ISample>();
		pfFactory = IProbabilityFunctionFactory.eINSTANCE;
	}

	protected ProbabilityMassFunctionImpl(List<ISample> samples) {
		this.samples = samples;
	}

	public IProbabilityMassFunction add(IProbabilityMassFunction pmf) {
		if (haveSameDomain(this.samples, pmf.getSamples()))
			throw new IllegalArgumentException("Operation not supported");
		if (samples.size() != pmf.getSamples().size())
			throw new IllegalArgumentException("");

		List<ISample> newList = new ArrayList<ISample>();
		Iterator<ISample> iterator = pmf.getSamples().iterator();
		for (ISample sample : samples)
			newList.add(pfFactory.createSample( sample.getValue(), sample.getProbability()
					+ iterator.next().getProbability()));

		return pfFactory.createProbabilityMassFunction(newList, false);
	}

	public IProbabilityMassFunction mult(IProbabilityMassFunction pmf) {
		if (haveSameDomain(this.samples, pmf.getSamples()))
			throw new IllegalArgumentException("Operation not supported");
		if (samples.size() != pmf.getSamples().size())
			throw new IllegalArgumentException("");

		List<ISample> newList = new ArrayList<ISample>();
		Iterator<ISample> iterator = pmf.getSamples().iterator();
		for (ISample sample : samples)
			newList.add(pfFactory.createSample(sample.getValue(), sample.getProbability()
					* iterator.next().getProbability()));
		
		return pfFactory.createProbabilityMassFunction(newList, false);
	}

	public IProbabilityMassFunction scale(Double scalar) {

		List<ISample> newList = new ArrayList<ISample>();
		for (ISample sample : samples)
			newList.add(pfFactory.createSample(sample
					.getValue(), sample.getProbability() * scalar));

		return pfFactory.createProbabilityMassFunction(newList, false);
	}

	@SuppressWarnings("unchecked")
	public boolean haveSameDomain(List<ISample> values1, List<ISample> values2) {
		if (values1.size() != values2.size())
			return false;

		if (!((values1.get(0).getValue() instanceof Double && values2.get(0)
				.getValue() instanceof Double)
				|| (values1.get(0).getValue() instanceof String && values2.get(
						0).getValue() instanceof String) || (values1.get(0)
				.getValue() instanceof Integer && values2.get(0).getValue() instanceof Integer)))
			return false;
		List s1 = null;
		List s2 = null;

		if (values1.get(0).getValue() instanceof Double) {
			s1 = convertToDoubleList(values1);
			s2 = convertToDoubleList(values2);
		} else if (values1.get(0).getValue() instanceof Integer) {
			s1 = convertToIntegerList(values1);
			s2 = convertToIntegerList(values2);
		} else {
			s1 = convertToStringList(values1);
			s2 = convertToStringList(values2);
		}

		Collections.sort(s1);
		Collections.sort(s2);
		
		boolean result = true;
		Iterator iterator = s2.iterator();
		for (Object o : s1)
			if (!o.equals(iterator.next()))
				result = false;

		return result;
	}

	private List<Double> convertToDoubleList(List<ISample> list) {
		List<Double> newList = new ArrayList<Double>();
		for (ISample o : list)
			newList.add((Double) o.getValue());
		return newList;
	}

	private List<String> convertToStringList(List<ISample> list) {
		List<String> newList = new ArrayList<String>();
		for (ISample o : list)
			newList.add((String) o.getValue());
		return newList;
	}

	private List<Integer> convertToIntegerList(List<ISample> list) {
		List<Integer> newList = new ArrayList<Integer>();
		for (ISample o : list)
			newList.add((Integer) o.getValue());
		return newList;
	}

	public IProbabilityMassFunction getFourierTramsform() {
		// TODO Auto-generated method stub
		return null;
	}

	public IProbabilityMassFunction getInverseFourierTransform() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the samples
	 */
	public List<ISample> getSamples() {
		return samples;
	}

	/**
	 * @param samples
	 *            the samples to set
	 */
	public void setSamples(List<ISample> samples) {
		this.samples = samples;
	}

	public IProbabilityMassFunction div(IProbabilityMassFunction pmf) {
		// TODO Auto-generated method stub
		return null;
	}

	public IProbabilityMassFunction scale(double scalar) {
		// TODO Auto-generated method stub
		return null;
	}

	public IProbabilityMassFunction sub(IProbabilityMassFunction pmf) {
		// TODO Auto-generated method stub
		return null;
	}

	public double getArithmeticMeanValue() throws DomainNotNumbersException {
		// TODO Auto-generated method stub
		return 0;
	}

	public Object getMedian() throws UnorderedDomainException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getPercentile(int p) throws IndexOutOfBoundsException, UnorderedDomainException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean hasOrderedDomain() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isInFrequencyDomain() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isInTimeDomain() {
		// TODO Auto-generated method stub
		return false;
	}

	public Object drawSample() {
		// TODO Auto-generated method stub
		return null;
	}

}

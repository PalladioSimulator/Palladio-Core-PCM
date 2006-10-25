/**
 * 
 */
package de.uka.ipd.sdq.probfunction.math.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.IRandomGenerator;
import de.uka.ipd.sdq.probfunction.math.ISample;
import de.uka.ipd.sdq.probfunction.math.IUnit;
import de.uka.ipd.sdq.probfunction.math.exception.DifferentDomainsException;
import de.uka.ipd.sdq.probfunction.math.exception.DomainNotNumbersException;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilitySumNotOneException;
import de.uka.ipd.sdq.probfunction.math.exception.UnorderedDomainException;
import de.uka.ipd.sdq.probfunction.math.util.MathTools;

/**
 * @author Ihssane
 * 
 */
public class ProbabilityMassFunctionImpl extends ProbabilityFunctionImpl
		implements
			IProbabilityMassFunction {

	private List<ISample> samples;

	private enum Operation {
		ADD, SUB, MULT, DIV
	}

	protected ProbabilityMassFunctionImpl(IUnit unit, boolean hasOrderedDomain,
			boolean isInFrequencyDomain) {
		this(new ArrayList<ISample>(), unit, hasOrderedDomain,
				isInFrequencyDomain);
	}

	protected ProbabilityMassFunctionImpl(List<ISample> samples, IUnit unit,
			boolean hasOrderedDomain, boolean isInFrequencyDomain) {
		this(samples, unit, hasOrderedDomain, isInFrequencyDomain,
				new DefaultRandomGenerator());
	}

	protected ProbabilityMassFunctionImpl(List<ISample> samples, IUnit unit,
			boolean hasOrderedDomain, boolean isInFrequencyDomain,
			IRandomGenerator generator) {
		super(unit, hasOrderedDomain, isInFrequencyDomain);
		Collections.sort(samples, MathTools.getSampleComparator());
		this.samples = samples;

		randomGenerator = generator;
	}

	private IProbabilityMassFunction performOperation(Operation op,
			IProbabilityMassFunction pmf1, IProbabilityMassFunction pmf2) {
		List<ISample> resultList = new ArrayList<ISample>();

		Iterator<ISample> iterator = pmf2.getSamples().iterator();
		for (ISample s1 : pmf1.getSamples()) {
			ISample s2 = iterator.next();
			double result;
			switch (op) {
				case ADD :
					result = s1.getProbability() + s2.getProbability();
					break;
				case SUB :
					result = s1.getProbability() - s2.getProbability();
					break;
				case MULT :
					result = s1.getProbability() * s2.getProbability();
					break;
				case DIV :
					result = s1.getProbability() / s2.getProbability();
					break;
				default :
					result = 0.0;
					break;
			}
			resultList.add(pfFactory.createSample(s1.getValue(), result));
		}
		return pfFactory.createProbabilityMassFunction(resultList, this
				.getUnit(), hasOrderedDomain());
	}

	public IProbabilityMassFunction add(IProbabilityMassFunction pmf)
			throws DifferentDomainsException {
		if (!haveSameDomain(this.samples, pmf.getSamples()))
			throw new DifferentDomainsException();

		return performOperation(Operation.ADD, this, pmf);
	}

	public IProbabilityMassFunction mult(IProbabilityMassFunction pmf)
			throws DifferentDomainsException {
		if (!haveSameDomain(this.samples, pmf.getSamples()))
			throw new DifferentDomainsException();

		return performOperation(Operation.MULT, this, pmf);
	}

	public IProbabilityMassFunction scale(double scalar) {

		List<ISample> newList = new ArrayList<ISample>();
		for (ISample sample : samples)
			newList.add(pfFactory.createSample(sample.getValue(), sample
					.getProbability()
					* scalar));

		return pfFactory.createProbabilityMassFunction(newList, this.getUnit(),
				this.hasOrderedDomain());
	}

	public IProbabilityMassFunction div(IProbabilityMassFunction pmf)
			throws DifferentDomainsException {
		if (!haveSameDomain(this.samples, pmf.getSamples()))
			throw new DifferentDomainsException();

		return performOperation(Operation.DIV, this, pmf);
	}

	public IProbabilityMassFunction sub(IProbabilityMassFunction pmf)
			throws DifferentDomainsException {
		if (!haveSameDomain(this.samples, pmf.getSamples()))
			throw new DifferentDomainsException();

		return performOperation(Operation.SUB, this, pmf);
	}

	@SuppressWarnings("unchecked")
	private boolean haveSameDomain(List<ISample> values1, List<ISample> values2) {
		if (values1.size() != values2.size())
			return false;
		if (values1.size() == 0 && values2.size() == 0)
			return true;
		if (!(values1.get(0).getValue().getClass().isInstance(values2.get(0)
				.getValue())))
			return false;
		if (!(values1.get(0).getValue() instanceof Comparable))
			return false;

		Collections.sort(values1, MathTools.getSampleComparator());
		Collections.sort(values2, MathTools.getSampleComparator());

		boolean result = true;
		Iterator<ISample> iterator = values2.iterator();
		for (ISample o : values1) {
			if (!o.getValue().equals((iterator.next().getValue())))
				result = false;
		}

		return result;
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
		return new ArrayList<ISample>(samples);
	}

	/**
	 * @param samples
	 *            the samples to set
	 * @throws ProbabilitySumNotOneException
	 */
	public void setSamples(List<ISample> samples)
			throws ProbabilitySumNotOneException {
		if (!MathTools.equalsDouble(MathTools.sumOfSamples(samples), 1.0))
			throw new ProbabilitySumNotOneException();

		if (samples.size() > 1
				&& samples.get(0).getValue() instanceof Comparable)
			Collections.sort(samples, MathTools.getSampleComparator());
		this.samples = samples;
	}

	public double getArithmeticMeanValue() throws DomainNotNumbersException {
		double mean = 0;
		for (ISample sample : this.samples) {
			Object value = sample.getValue();
			if (value instanceof Double) {
				Double d = (Double) value;
				mean += d * sample.getProbability();
			} else if (value instanceof Integer) {
				Integer i = (Integer) value;
				mean += i * sample.getProbability();
			} else if (value instanceof Long) {
				Long i = (Long) value;
				mean += i * sample.getProbability();
			} else if (value instanceof Float) {
				Float i = (Float) value;
				mean += i * sample.getProbability();
			} else {
				throw new DomainNotNumbersException();
			}
		}
		return mean;
	}

	public Object getMedian() throws UnorderedDomainException {
		return getPercentile(50);
	}

	public Object getPercentile(int p) throws IndexOutOfBoundsException,
			UnorderedDomainException {
		if (!hasOrderedDomain())
			throw new UnorderedDomainException();
		if (p < 0 || p > 100)
			throw new IndexOutOfBoundsException();

		int rank = (int) Math.floor((p * (samples.size() + 1.0)) / 100.0);
		return samples.get(rank).getValue();
	}

	public Object drawSample() {
		Object result = 0.0;
		List<Double> intervals = MathTools
				.computeIntervalsOfProb(getProbabilities());

		double random = randomGenerator.random();
		for (int j = 0; j < intervals.size(); j++)
			if (random < intervals.get(j)) {
				result = samples.get(j).getValue();
				break;
			}
		return result;
	}

	private List<Double> getProbabilities() {
		List<Double> prob = new ArrayList<Double>();
		for (ISample s : samples)
			prob.add(s.getProbability());
		return prob;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (((IProbabilityMassFunction) obj).getSamples().size() != this.samples
				.size())
			return false;

		boolean result = true;
		Iterator<ISample> iterator = ((IProbabilityMassFunction) obj)
				.getSamples().iterator();
		for (ISample o : this.getSamples()) {
			if (!o.equals(iterator.next()))
				result = false;
		}

		return result;
	}

	public double getProbabilitySum() {
		double sum = 0;
		for (ISample sample : samples) {
			sum += sample.getProbability();
		}
		return sum;
	}

}

/**
 * 
 */
package de.uka.ipd.sdq.probfunction.math.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.swing.Box;

import de.uka.ipd.sdq.probfunction.math.IBoxedPDF;
import de.uka.ipd.sdq.probfunction.math.IContinuousSample;
import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.IRandomGenerator;
import de.uka.ipd.sdq.probfunction.math.ISamplePDF;
import de.uka.ipd.sdq.probfunction.math.IUnit;
import de.uka.ipd.sdq.probfunction.math.exception.DomainNotNumbersException;
import de.uka.ipd.sdq.probfunction.math.exception.DoubleSampleException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInFrequencyDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInTimeDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionsInDifferenDomainsException;
import de.uka.ipd.sdq.probfunction.math.exception.IncompatibleUnitsException;
import de.uka.ipd.sdq.probfunction.math.exception.UnknownPDFTypeException;
import de.uka.ipd.sdq.probfunction.math.exception.UnorderedDomainException;
import de.uka.ipd.sdq.probfunction.math.util.Line;
import de.uka.ipd.sdq.probfunction.math.util.MathTools;

/**
 * @author Ihssane
 * 
 */
public class BoxedPDFImpl extends ProbabilityDensityFunctionImpl
		implements
			IBoxedPDF {

	private List<IContinuousSample> samples;

	protected BoxedPDFImpl(IUnit unit) {
		this(unit, new DefaultRandomGenerator());
	}

	protected BoxedPDFImpl(IUnit unit, IRandomGenerator generator) {
		super(unit, false);
		this.randomGenerator = generator;
		samples = new ArrayList<IContinuousSample>();
	}

	public IProbabilityDensityFunction add(IProbabilityDensityFunction pdf)
			throws FunctionsInDifferenDomainsException,
			UnknownPDFTypeException, IncompatibleUnitsException {
		ISamplePDF sPDF = pfFactory.transformToSamplePDF(this);
		return sPDF.add(pdf);
	}

	public IProbabilityDensityFunction mult(IProbabilityDensityFunction pdf)
			throws FunctionsInDifferenDomainsException,
			UnknownPDFTypeException, IncompatibleUnitsException {
		ISamplePDF sPDF = pfFactory.transformToSamplePDF(this);
		return sPDF.mult(pdf);
	}

	public IProbabilityDensityFunction scale(double scalar) {
		List<IContinuousSample> list = new ArrayList<IContinuousSample>();
		for (IContinuousSample s : this.samples)
			list.add(pfFactory.createContinuousSample(s.getValue(), s
					.getProbability()
					* scalar));

		IBoxedPDF result = null;
		try {
			result = pfFactory.createBoxedPDF(list, this.getUnit());
		} catch (DoubleSampleException e) {
			e.printStackTrace();
			System.exit(1); // should never happen
		}
		return result;
	}

	public List<IContinuousSample> getSamples() {
		return Collections.unmodifiableList(samples);
	}

	public List<Double> getValues() {
		List<Double> values = new ArrayList<Double>();
		for (IContinuousSample cs : samples)
			values.add(cs.getValue());
		return values;
	}

	public List<Double> getProbabilities() {
		List<Double> probs = new ArrayList<Double>();
		for (IContinuousSample cs : samples)
			probs.add(cs.getProbability());
		return probs;
	}

	public void setSamples(List<IContinuousSample> samples)
			throws DoubleSampleException {
		if (containsDoubleSamples(samples))
			throw new DoubleSampleException();

		Collections.sort(samples, MathTools.getContinuousSampleComparator());
		this.samples = samples;
	}

	public IProbabilityDensityFunction div(IProbabilityDensityFunction pdf)
			throws FunctionsInDifferenDomainsException,
			UnknownPDFTypeException, IncompatibleUnitsException {
		ISamplePDF sPDF = pfFactory.transformToSamplePDF(this);
		return sPDF.div(pdf);
	}

	public double drawSample() {
		double result = 0.0;

		List<Double> intervals = MathTools.computeIntervalsOfProb(getValues());
		HashMap<Double, Line> lines = MathTools
				.computeLines(samples, intervals);

		double random = randomGenerator.random();
		for (int j = 0; j < intervals.size(); j++)
			if (random < intervals.get(j)) {
				result = lines.get(intervals.get(j)).getX(random);
				break;
			}

		return result;
	}

	public IProbabilityDensityFunction getFourierTransform()
			throws FunctionNotInTimeDomainException {
		if (!isInTimeDomain())
			throw new FunctionNotInTimeDomainException();

		ISamplePDF sPDF = null;
		try {
			sPDF = pfFactory.transformToSamplePDF(this);
		} catch (UnknownPDFTypeException e) {
			// should never happen...
			e.printStackTrace();
			System.exit(1);
		}
		return sPDF.getFourierTransform();
	}

	public IProbabilityDensityFunction getInverseFourierTransform()
			throws FunctionNotInFrequencyDomainException {
		if (isInTimeDomain())
			throw new FunctionNotInFrequencyDomainException();

		ISamplePDF sPDF = null;
		try {
			sPDF = pfFactory.transformToSamplePDF(this);
		} catch (UnknownPDFTypeException e) {
			// should never happen...
			e.printStackTrace();
			System.exit(1);
		}
		return sPDF.getInverseFourierTransform();
	}

	public double getLowerDomainBorder() {
		return 0;
	}

	public IProbabilityDensityFunction sub(IProbabilityDensityFunction pdf)
			throws FunctionsInDifferenDomainsException,
			UnknownPDFTypeException, IncompatibleUnitsException {
		ISamplePDF sPDF = pfFactory.transformToSamplePDF(this);
		return sPDF.sub(pdf);
	}

	public double getArithmeticMeanValue() throws DomainNotNumbersException {
		return MathTools.sumOfCountinuousSamples(samples) / samples.size();
	}

	public Object getMedian() throws UnorderedDomainException {
		if (!hasOrderedDomain())
			throw new UnorderedDomainException();

		if (samples.size() % 2 != 0) {
			int i = (int) Math.floor(samples.size() / 2.0);
			return samples.get(i).getValue();
		} else {
			int i1 = (int) Math.round(samples.size() / 2.0);
			return (samples.get(i1).getValue() + samples.get(i1 - 1).getValue()) / 2;
		}
	}

	public Object getPercentile(int p) throws IndexOutOfBoundsException,
			UnorderedDomainException {
		if (p < 0 || p > 100)
			throw new IndexOutOfBoundsException();

		int rank = (int) Math.round((p * (samples.size() - 1.0)) / 100.0);
		return samples.get(rank).getProbability();
	}

	public boolean isInFrequencyDomain() {
		return false;
	}

	public boolean isInTimeDomain() {
		return true;
	}

	public double getProbabilitySum() {
		double sum = 0;
		for (IContinuousSample sample : samples) {
			sum += sample.getProbability();
		}
		return sum;
	}

	private boolean containsDoubleSamples(List<IContinuousSample> samples) {
		HashSet<Double> set = new HashSet<Double>();
		for (IContinuousSample s : samples)
			set.add(s.getValue());

		return set.size() != samples.size();
	}

	public boolean checkConstrains() {
		if (!MathTools.equalsDouble(getProbabilitySum(), 1.0))
			return false;

		if (getUnit() == null || getUnit().getUnitName() == null)
			return false;

		boolean result = true;
		for (IContinuousSample s : samples) {
			if (s == null)
				return false;
			result = result && (s.getValue() >= 0.0);
			result = result && (s.getProbability() >= 0.0)
					&& (s.getProbability() <= 1.0);
		}
		return result;
	}

	public IProbabilityDensityFunction getCumulativeFunction() {
		List<Double> newProb = MathTools
				.computeIntervalsOfProb(getProbabilities());
		List<IContinuousSample> newSamples = new ArrayList<IContinuousSample>();
		int index = 0;
		for (Double d : newProb) {
			newSamples.add(pfFactory.createContinuousSample(samples.get(index)
					.getValue(), d));
			index++;
		}

		IBoxedPDF bpdf = null;
		try {
			bpdf = pfFactory.createBoxedPDF(newSamples, this.getUnit());
		} catch (DoubleSampleException e) {
			// should never happen
			e.printStackTrace();
			System.exit(1);
		}
		return bpdf;
	}

	/**
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof IBoxedPDF) {
			IBoxedPDF pdf = (IBoxedPDF) obj;

			if (pdf.getSamples().size() != samples.size())
				return false;

			Iterator<IContinuousSample> iter = pdf.getSamples().iterator();
			for (IContinuousSample s : samples)
				if (!s.equals(iter.next()))
					return false;
			return true;
		}
		return false;
	}

	public double probabilisticEquals(IProbabilityDensityFunction pdf) {
		// TODO Auto-generated method stub
		return 0;
	}

	public double greaterThan(IProbabilityDensityFunction pdf) {
		// TODO Auto-generated method stub
		return 0;
	}

	public double lessThan(IProbabilityDensityFunction pdf) {
		// TODO Auto-generated method stub
		return 0;
	}

	public IProbabilityDensityFunction stretchDomain(double scalar) {
		List<IContinuousSample> newSamples = new ArrayList<IContinuousSample>();
		for (IContinuousSample oldSample : samples){
			newSamples.add(pfFactory.createContinuousSample(oldSample.getValue()
					+ scalar, oldSample.getProbability()));
		}

		IBoxedPDF result = null;
		try {
			result = pfFactory.createBoxedPDF(newSamples, this.getUnit());
		} catch (DoubleSampleException e) {
			e.printStackTrace();
			System.exit(1); // should never happen
		}
		return result;
	}

	public IProbabilityDensityFunction shiftDomain(double scalar) throws DomainNotNumbersException {
		// TODO Auto-generated method stub
		return null;
	}

}

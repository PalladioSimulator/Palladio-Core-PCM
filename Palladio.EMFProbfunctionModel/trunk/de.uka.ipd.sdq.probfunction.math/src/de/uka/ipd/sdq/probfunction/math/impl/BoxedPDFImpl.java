/**
 * 
 */
package de.uka.ipd.sdq.probfunction.math.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import de.uka.ipd.sdq.probfunction.math.IBoxedPDF;
import de.uka.ipd.sdq.probfunction.math.IContinuousSample;
import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.ISamplePDF;
import de.uka.ipd.sdq.probfunction.math.exception.DomainNotNumbersException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInFrequencyDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInTimeDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionsInDifferenDomainsException;
import de.uka.ipd.sdq.probfunction.math.exception.IncompatibleUnitsException;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilitySumNotOneException;
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

	protected BoxedPDFImpl() {
		super();
		samples = new ArrayList<IContinuousSample>();
	}

	protected BoxedPDFImpl(List<IContinuousSample> samples) {
		this();
		this.samples = samples;
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

		return pfFactory.createBoxedPDF(list);
	}

	public List<IContinuousSample> getSamples() {
		return samples;
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
			throws ProbabilitySumNotOneException {
		if (!MathTools.equalsDouble(MathTools.sumOfCountinuousSamples(samples),
				1.0))
			throw new ProbabilitySumNotOneException();

		Collections.sort(samples, new Comparator<IContinuousSample>() {
			public int compare(IContinuousSample o1, IContinuousSample o2) {
				int result = -1;
				if (o1.getProbability() > o2.getProbability())
					result = 1;
				else if (MathTools.equalsDouble(o1.getProbability(), o2
						.getProbability()))
					result = 0;
				return result;
			}

		});
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

		List<Double> intervals = MathTools.computeIntervalOfProb(getValues());
		HashMap<Double, Line> lines = MathTools
				.computeLines(samples, intervals);

		double random = Math.random();
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return null;
	}

	public Object getPercentile(int p) throws IndexOutOfBoundsException,
			UnorderedDomainException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isInFrequencyDomain() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isInTimeDomain() {
		// TODO Auto-generated method stub
		return false;
	}

}

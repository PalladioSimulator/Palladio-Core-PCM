/**
 * 
 */
package de.uka.ipd.sdq.probfunction.math.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IRandomGenerator;
import de.uka.ipd.sdq.probfunction.math.ISamplePDF;
import de.uka.ipd.sdq.probfunction.math.IUnit;
import de.uka.ipd.sdq.probfunction.math.exception.DomainNotNumbersException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInTimeDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionsInDifferenDomainsException;
import de.uka.ipd.sdq.probfunction.math.exception.IncompatibleUnitsException;
import de.uka.ipd.sdq.probfunction.math.exception.InvalidSampleValueException;
import de.uka.ipd.sdq.probfunction.math.exception.NegativeDistanceException;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilityFunctionException;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilitySumNotOneException;
import de.uka.ipd.sdq.probfunction.math.exception.SizeTooSmallException;
import de.uka.ipd.sdq.probfunction.math.exception.UnitNameNotSetException;
import de.uka.ipd.sdq.probfunction.math.exception.UnitNotSetException;
import de.uka.ipd.sdq.probfunction.math.exception.UnknownPDFTypeException;
import de.uka.ipd.sdq.probfunction.math.exception.UnorderedDomainException;
import de.uka.ipd.sdq.probfunction.math.util.MathTools;
import flanagan.complex.Complex;
import flanagan.math.FourierTransform;

/**
 * @author Ihssane
 * 
 */
public class SamplePDFImpl extends ProbabilityDensityFunctionImpl
		implements
			ISamplePDF {

	private enum Operation {
		ADD, SUB, MULT, DIV
	}

	private static final Complex DEFAULT_FILL_VALUE = new Complex(0, 0);

	private static final int FOURIER_TRANSFORM = 0;

	private static final int INVERSE_FOURIER_TRANSFORM = 1;

	private double distance;

	private List<Complex> values;

	private Complex fillValue;

	private FourierTransform fft = new FourierTransform();

	protected SamplePDFImpl(double distance, IUnit unit) {
		this(distance, unit, new DefaultRandomGenerator());

	}

	protected SamplePDFImpl(double distance, IUnit unit,
			IRandomGenerator generator) {
		this(distance, unit, false, new DefaultRandomGenerator());
	}

	protected SamplePDFImpl(double distance, IUnit unit,
			boolean isInFrequencyDomain) {
		this(distance, unit, isInFrequencyDomain, new DefaultRandomGenerator());
	}

	protected SamplePDFImpl(double distance, IUnit unit,
			boolean isInFrequencyDomain, IRandomGenerator generator) {
		super(unit, isInFrequencyDomain);
		this.distance = distance;
		values = new ArrayList<Complex>();
		fillValue = DEFAULT_FILL_VALUE;
		randomGenerator = generator;
	}

	public IProbabilityDensityFunction add(IProbabilityDensityFunction pdf)
			throws UnknownPDFTypeException,
			FunctionsInDifferenDomainsException, IncompatibleUnitsException {
		return performOperation(Operation.ADD, this, pdf);
	}

	public IProbabilityDensityFunction mult(IProbabilityDensityFunction pdf)
			throws UnknownPDFTypeException,
			FunctionsInDifferenDomainsException, IncompatibleUnitsException {
		return performOperation(Operation.MULT, this, pdf);
	}

	public IProbabilityDensityFunction div(IProbabilityDensityFunction pdf)
			throws FunctionsInDifferenDomainsException,
			UnknownPDFTypeException, IncompatibleUnitsException {
		return performOperation(Operation.DIV, this, pdf);
	}

	public IProbabilityDensityFunction sub(IProbabilityDensityFunction pdf)
			throws FunctionsInDifferenDomainsException,
			UnknownPDFTypeException, IncompatibleUnitsException {
		return performOperation(Operation.SUB, this, pdf);
	}

	public IProbabilityDensityFunction scale(double scalar) {
		ArrayList<Complex> resultList = new ArrayList<Complex>();

		for (Complex z : values) {
			resultList.add(z.times(scalar));
		}

		return pfFactory.createSamplePDFFromComplex(distance, resultList, this
				.isInFrequencyDomain(), pfFactory.createDefaultUnit());
	}

	public IProbabilityDensityFunction getFourierTransform() {
		return transformFunction(FOURIER_TRANSFORM);
	}

	public IProbabilityDensityFunction getInverseFourierTransform() {
		return transformFunction(INVERSE_FOURIER_TRANSFORM);
	}

	public void expand(int newSize) throws SizeTooSmallException {
		int diff = newSize - values.size();

		if (diff < 0)
			throw new SizeTooSmallException();

		for (int i = 0; i < diff; i++) {
			values.add(new Complex(fillValue));
		}
	}

	public double getDistance() {
		return distance;
	}

	public List<Double> getValuesAsDouble() {
		return MathTools.transformComplexToDouble(values);
	}

	public void setValuesAsDouble(List<Double> values) {
		this.values = new ArrayList<Complex>(MathTools
				.transformDoubleToComplex(values));
	}

	/**
	 * @return the fillValue
	 */
	public double getFillValueAsDouble() {
		return fillValue.getReal();
	}

	/**
	 * @param fillValue
	 *            the fillValue to set
	 */
	public void setFillValue(double fillValue) {
		this.fillValue = new Complex(fillValue);
	}

	public Complex getFillValue() {
		return fillValue;
	}

	public ISamplePDF getFunctionWithNewDistance(double distance)
			throws NegativeDistanceException, FunctionNotInTimeDomainException {
		List<Double> newList = getValuesForDistance(distance);
		return pfFactory.createSamplePDFFromDouble(distance, newList, this
				.getUnit());
	}

	public List<Complex> getValues() {
		return new ArrayList<Complex>(values);
	}

	public void setFillValue(Complex fillValue) {
		this.fillValue = fillValue;

	}

	public void setValues(List<Complex> values, boolean isInFrequencyDomain) {
		this.values = new ArrayList<Complex>(values);
		this.setInFrequencyDomain(isInFrequencyDomain);
	}

	public double getLowerDomainBorder() {
		return 0;
	}

	public double drawSample() {
		double result = 0.0;
		List<Double> intervals = MathTools
				.computeCumulativeProbabilities(getValuesAsDouble());

		double probability = randomGenerator.random();
		double lowerBoundProbability;
		double upperBoundProbability;
		double probabilityDistance;
		double middleValue;
		double scalingFactor;
		for (int currentInterval = 0; currentInterval < intervals.size(); currentInterval++) {
			upperBoundProbability = intervals.get(currentInterval);
			if (probability < upperBoundProbability) {
				middleValue = distance * currentInterval;
				double lowerBoundValue = middleValue - (distance / 2);
				// special case first interval (no negative values allowed)
				if (currentInterval == 0)
					lowerBoundProbability = 0.0;
				else
					lowerBoundProbability = intervals.get(currentInterval - 1);
				probabilityDistance = upperBoundProbability
						- lowerBoundProbability;
				// sepcial case no values in interval.
				if (probabilityDistance > 0)
					scalingFactor = (probability - lowerBoundProbability)
							/ (probabilityDistance);
				else
					scalingFactor = 0.0;
				result = lowerBoundValue + distance * scalingFactor;
				break;
			}
		}
		return result;
	}

	public double getArithmeticMeanValue() throws DomainNotNumbersException,
			FunctionNotInTimeDomainException {
		if (!isInTimeDomain())
			throw new FunctionNotInTimeDomainException();
		double pos = 0;
		double mean = 0;
		for (Complex val : values) {
			mean += pos * val.getReal();
			pos += distance;
		}
		return mean;
	}

	public Object getMedian() throws UnorderedDomainException {
		if (!hasOrderedDomain())
			throw new UnorderedDomainException();
		if (values.size() % 2 != 0) {
			int i = (int) Math.floor(values.size() / 2.0);
			return distance * i;
		} else {
			int i = (int) Math.round(values.size() / 2.0);
			return (distance * (2 * i - 1)) / 2;
		}
	}

	public Object getPercentile(int p) throws IndexOutOfBoundsException,
			UnorderedDomainException {
		if (!hasOrderedDomain())
			throw new UnorderedDomainException();
		if (p < 0 || p > 100)
			throw new IndexOutOfBoundsException();

		int rank = (int) Math.round((p * (values.size() + 1.0)) / 100.0);
		return values.get(rank).getReal();
	}

	public int numberOfSamples() {
		return values.size();
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (obj instanceof ISamplePDF) {
			ISamplePDF pdf = (ISamplePDF) obj;
			if ((pdf.getDistance() == this.getDistance())) {
				List<Complex> v1 = values;
				List<Complex> v2 = pdf.getValues();
				if (v1.size() > v2.size()) {
					List<Complex> tmp = v2;
					v2 = v1;
					v1 = tmp;
				}
				Iterator<Complex> iter = v2.iterator();
				result = true;
				for (Complex z : v1) {
					if (!MathTools.equalsComplex(iter.next(), z)) {
						result = false;
						break;
					}
				}
				while (iter.hasNext() && result) {
					if (!(MathTools.equalsComplex(iter.next(),
							new Complex(0, 0)))) {
						result = false;
					}
				}
			}
		}
		return result;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		String result = "unit = " + getUnit().getUnitName() + "; ";
		result += "distance = " + getDistance() + "; ";
		result += "samples: ";
		boolean isFirst = true;
		for (Complex z : values) {
			if (isFirst) {
				isFirst = false;
			} else {
				result += ", ";
			}
			result += "(" + MathTools.asString(z.getReal()) + ", "
					+ MathTools.asString(z.getImag()) + ")";
		}
		return result;
	}

	private List<Double> getValuesForDistance(double newDistance)
			throws NegativeDistanceException, FunctionNotInTimeDomainException {
		// same distance
		if (MathTools.equalsDouble(distance, newDistance))
			return getValuesAsDouble();

		// check preconditions
		if ((distance < 0) || (newDistance < 0))
			throw new NegativeDistanceException();

		if (!isInTimeDomain())
			throw new FunctionNotInTimeDomainException();

		// begin implementation
		double oldPoint = distance / 2;
		double newPoint = newDistance / 2;
		int currentIndex = 0;
		double buffer = 0.0;

		List<Double> newValues = new ArrayList<Double>();

		if (MathTools.equalsDouble(newDistance, distance)) {
			newValues = getValuesAsDouble();
		} else if (newDistance < distance) {
			while (currentIndex < values.size()) {
				if (newPoint < oldPoint) {
					if (newPoint == newDistance / 2)
						newValues
								.add(getProb(currentIndex, newPoint, oldPoint));
					else
						newValues.add(getProb(currentIndex, newDistance,
								distance));

				} else {
					if (oldPoint == distance / 2) {
						newValues.add(getLeftProb(oldPoint, currentIndex,
								newPoint, newDistance, oldPoint)
								+ getRightProb(oldPoint, currentIndex + 1,
										newPoint));
					} else
						newValues.add(getLeftProb(oldPoint, currentIndex,
								newPoint, newDistance, distance)
								+ getRightProb(oldPoint, currentIndex + 1,
										newPoint));
					oldPoint += distance;
					currentIndex++;
				}
				newPoint += newDistance;
			}
		} else if (newDistance > distance) {
			while (currentIndex < values.size()) {
				if (oldPoint < newPoint) {
					buffer += values.get(currentIndex).getReal();

				} else {
					newValues.add(buffer
							+ getLeftProb(newPoint, currentIndex, oldPoint,
									distance, distance));
					buffer = getRightProb(newPoint, currentIndex, oldPoint);
					newPoint += newDistance;
				}
				oldPoint += distance;
				currentIndex++;
			}
			if (buffer != 0)
				newValues.add(buffer);
		}
		return newValues;
	}

	private double getProb(int index, double newDistance, double distance) {
		return (newDistance / distance) * values.get(index).getReal();
	}

	private double getLeftProb(double oldP, int index, double newP, double diff, double distance) {
		double fractal = (diff - (newP - oldP)) / distance;
		return values.get(index).getReal() * fractal;
	}

	private double getRightProb(double oldP, int index, double newP) {
		double fractal = (newP - oldP) / distance;
		if (index < values.size())
			return values.get(index).getReal() * fractal;
		else
			return 0;
	}

	private static IProbabilityDensityFunction performOperation(Operation op,
			IProbabilityDensityFunction pdf1, IProbabilityDensityFunction pdf2)
			throws FunctionsInDifferenDomainsException,
			UnknownPDFTypeException, IncompatibleUnitsException {

		List<ISamplePDF> operands = prepareForComputation(pdf1, pdf2);

		ISamplePDF sPDF1 = operands.get(0);
		ISamplePDF sPDF2 = operands.get(1);
		ArrayList<Complex> resultList = new ArrayList<Complex>();
		double distance = sPDF1.getDistance();
		boolean inFrequencyDomain = sPDF1.isInFrequencyDomain();

		Iterator<Complex> iterator = sPDF2.getValues().iterator();
		for (Complex z1 : sPDF1.getValues()) {
			Complex z2 = iterator.next();
			Complex result;
			switch (op) {
				case ADD :
					result = z1.plus(z2);
					break;
				case SUB :
					result = z1.minus(z2);
					break;
				case MULT :
					result = z1.times(z2);
					break;
				case DIV :
					result = z1.over(z2);
					break;
				default :
					result = null;
					break;
			}
			resultList.add(result);
		}
		IProbabilityDensityFunction p = pfFactory.createSamplePDFFromComplex(
				distance, resultList, inFrequencyDomain, sPDF1.getUnit());
		return p;
	}

	private static List<ISamplePDF> prepareForComputation(
			IProbabilityDensityFunction pdf1, IProbabilityDensityFunction pdf2)
			throws FunctionsInDifferenDomainsException,
			UnknownPDFTypeException, IncompatibleUnitsException {
		// check preconditions
		if (pdf1.isInTimeDomain() != pdf2.isInTimeDomain())
			throw new FunctionsInDifferenDomainsException();

		if (!pdf1.getUnit().equals(pdf2.getUnit()))
			throw new IncompatibleUnitsException();

		// ensure that we only have SamplePDFs with equal distances and the same
		// number of samples
		ISamplePDF sPDF1 = pfFactory.transformToSamplePDF(pdf1);
		ISamplePDF sPDF2 = pfFactory.transformToSamplePDF(pdf2);

		List<ISamplePDF> operands;
		operands = createFunctionsWithEqualDistance(sPDF1, sPDF2);
		sPDF1 = operands.get(0);
		sPDF2 = operands.get(1);

		try {
			int maxSize = Math.max(sPDF1.numberOfSamples(), sPDF2
					.numberOfSamples());
			sPDF1.expand(maxSize);
			sPDF2.expand(maxSize);
		} catch (SizeTooSmallException e) {
			// should never happen...
			e.printStackTrace();
			System.exit(1);
		}
		return operands;
	}

	private IProbabilityDensityFunction transformFunction(int flag) {
		Complex[] cValues = new Complex[values.size()];
		values.toArray(cValues);
		fft.setData(cValues);

		if (flag == FOURIER_TRANSFORM)
			fft.transform();
		else
			fft.inverse();

		List<Complex> resultList = Arrays.asList(fft
				.getTransformedDataAsComplex());

		ISamplePDF spdf = pfFactory.createSamplePDFFromComplex(distance,
				resultList, !this.isInFrequencyDomain(), pfFactory
						.createDefaultUnit());
		return spdf;
	}

	/**
	 * Creates two functions with an equal distance, if both functions are in
	 * the time domain. Precondition: Functions are in the same domain.
	 * 
	 * @param pdf1
	 * @param pdf2
	 * @return
	 * @throws FunctionNotInTimeDomainException
	 * @throws NegativeDistanceException
	 * @throws FunctionNotInTimeDomainException
	 *             Thrown if one of the input pdfs is not in the time domain.
	 */
	protected static List<ISamplePDF> createFunctionsWithEqualDistance(
			ISamplePDF pdf1, ISamplePDF pdf2) {

		ArrayList<ISamplePDF> resultList = new ArrayList<ISamplePDF>();

		try {
			if (!MathTools.equalsDouble(pdf1.getDistance(), pdf2.getDistance())) {
				boolean inTimeDomain = pdf1.isInTimeDomain();

				if (!inTimeDomain) {
					pdf1 = (ISamplePDF) pdf1.getInverseFourierTransform();
					pdf2 = (ISamplePDF) pdf2.getInverseFourierTransform();
				}

				double distance = MathTools.gcd(pdf1.getDistance(), pdf2
						.getDistance());

				pdf1 = pdf1.getFunctionWithNewDistance(distance);
				pdf2 = pdf2.getFunctionWithNewDistance(distance);

				if (!inTimeDomain) {
					pdf1 = (ISamplePDF) pdf1.getFourierTransform();
					pdf2 = (ISamplePDF) pdf2.getFourierTransform();
				}

			}

			resultList.add(pdf1);
			resultList.add(pdf2);
		} catch (ProbabilityFunctionException e) {
			// should never happen
			e.printStackTrace();
			System.exit(1);
		}
		return resultList;
	}

	public double getProbabilitySum() throws FunctionNotInTimeDomainException {
		if (!isInTimeDomain())
			throw new FunctionNotInTimeDomainException();
		double sum = 0;
		for (Complex value : values) {
			sum += value.getReal();
		}
		return sum;
	}

	public void checkConstrains() throws NegativeDistanceException,
			ProbabilitySumNotOneException, FunctionNotInTimeDomainException,
			UnitNotSetException, UnitNameNotSetException,
			InvalidSampleValueException {
		if (distance <= 0.0)
			throw new NegativeDistanceException();
		if (getUnit() == null)
			throw new UnitNotSetException();
		if (getUnit().getUnitName() == null)
			throw new UnitNameNotSetException();
		try {
			if (!MathTools.equalsDouble(getProbabilitySum(), 1.0))
				throw new ProbabilitySumNotOneException();
			for (double p : getValuesAsDouble())
				if (!(p >= 0.0 - MathTools.EPSILON_ERROR && p <= 1.0 + MathTools.EPSILON_ERROR))
					throw new InvalidSampleValueException();
		} catch (FunctionNotInTimeDomainException e) {
			throw e;
		}

	}

	public IProbabilityDensityFunction getCumulativeFunction()
			throws FunctionNotInTimeDomainException {

		if (!isInTimeDomain())
			throw new FunctionNotInTimeDomainException();

		List<Double> cumulativeProbabilities = MathTools
				.computeCumulativeProbabilities(getValuesAsDouble());
		ISamplePDF spdf = pfFactory.createSamplePDFFromDouble(distance,
				cumulativeProbabilities, isInFrequencyDomain(), this.getUnit(),
				this.getRandomGenerator());
		spdf.setFillValue(new Complex(1.0, 0.0));
		return spdf;
	}

	public double probabilisticEquals(IProbabilityDensityFunction pdf)
			throws ProbabilityFunctionException {
		return compareTo(pdf, CompareOperation.EQUALS);
	}

	public double greaterThan(IProbabilityDensityFunction pdf)
			throws ProbabilityFunctionException {
		return compareTo(pdf, CompareOperation.GREATER);
	}

	public double lessThan(IProbabilityDensityFunction pdf)
			throws ProbabilityFunctionException {
		return compareTo(pdf, CompareOperation.LESS);
	}

	private double compareTo(IProbabilityDensityFunction pdf,
			CompareOperation op) throws ProbabilityFunctionException {
		ISamplePDF sPDF = pfFactory.transformToSamplePDF(pdf);
		sPDF = sPDF.getFunctionWithNewDistance(this.distance);
		int maxSize = Math
				.max(sPDF.getValues().size(), this.getValues().size());
		sPDF.expand(maxSize);
		this.expand(maxSize);
		List<Double> pdfValues = sPDF.getValuesAsDouble();
		List<Double> thisValues = this.getValuesAsDouble();

		switch (op) {
			case EQUALS :
				return equals(thisValues, pdfValues);
			case GREATER :
				return greaterThan(thisValues, pdfValues);
			case LESS :
				return greaterThan(pdfValues, thisValues);
			default :
				return 0;
		}
	}

	private double greaterThan(List<Double> firstValues,
			List<Double> secondValues) {
		assert (firstValues.size() == secondValues.size());
		double prob = 0;
		for (int i = 0; i < secondValues.size(); i++) {
			double tempProb = greaterThan(secondValues, i);
			prob += tempProb * secondValues.get(i);
		}
		return prob;
	}

	private double greaterThan(List<Double> secondValues, int i) {
		double prob = 0;
		for (int j = i + 1; j < secondValues.size(); j++) {
			prob += secondValues.get(j);
		}
		return prob;
	}

	private double equals(List<Double> firstValues, List<Double> secondValues) {
		double prob = 0;
		for (int i = 0; i < firstValues.size(); i++) {
			prob += firstValues.get(i) * secondValues.get(i);
		}
		return prob;
	}

	public IProbabilityDensityFunction stretchDomain(double scalar) {
		SamplePDFImpl sPDF = new SamplePDFImpl(this.getDistance() * scalar,
				this.getUnit(), this.randomGenerator);
		sPDF.setValues(this.getValues(), this.isInFrequencyDomain());
		sPDF.setFillValue(this.getFillValue());
		return sPDF;
	}

	public IProbabilityDensityFunction shiftDomain(double scalar)
			throws DomainNotNumbersException {
		throw new UnsupportedOperationException();
		// SamplePDFImpl sPDF = new SamplePDFImpl(this.getDistance(),
		// this.getUnit(), this.randomGenerator);
		// List<Complex> sampleList = this.getValues();
		// sampleList.add(0, new Complex(0,0));
	}

	public Complex getValue(int pos) {
		return pos < values.size() ? values.get(pos) : fillValue;
	}

	public Double getValueAsDouble(int pos) {
		return getValue(pos).getReal();
	}
}

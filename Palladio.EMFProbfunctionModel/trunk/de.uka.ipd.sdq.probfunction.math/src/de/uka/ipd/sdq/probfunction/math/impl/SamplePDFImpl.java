/**
 * 
 */
package de.uka.ipd.sdq.probfunction.math.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.ISamplePDF;
import de.uka.ipd.sdq.probfunction.math.IUnit;
import de.uka.ipd.sdq.probfunction.math.exception.DomainNotNumbersException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInTimeDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionsInDifferenDomainsException;
import de.uka.ipd.sdq.probfunction.math.exception.IncompatibleUnitsException;
import de.uka.ipd.sdq.probfunction.math.exception.NegativeDistanceException;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilitySumNotOneException;
import de.uka.ipd.sdq.probfunction.math.exception.SizeTooSmallException;
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

	protected SamplePDFImpl(double distance, List<Double> samples, IUnit unit) {
		super(unit, false);
		this.distance = distance;
		values = MathTools.transformDoubleToComplex(samples);
		fillValue = DEFAULT_FILL_VALUE;
	}

	protected SamplePDFImpl(double distance, List<Complex> samples, IUnit unit,
			boolean isInFrequencyDomain) {
		super(unit, isInFrequencyDomain);
		this.distance = distance;
		values = samples;
		fillValue = DEFAULT_FILL_VALUE;
	}

	// hide constructor
	protected SamplePDFImpl() {
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

	public void setValuesAsDouble(List<Double> values) throws ProbabilitySumNotOneException {
		if (!MathTools.equalsDouble(MathTools.sumOfDoubles(values),
				1.0))
			throw new ProbabilitySumNotOneException();		
		this.values = MathTools.transformDoubleToComplex(values);
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

	public void setValues(List<Complex> values, boolean isInFrequencyDomain)
			throws ProbabilitySumNotOneException {
		List<Double> valuesAsDouble = MathTools.transformComplexToDouble(values);
		if (!MathTools.equalsDouble(MathTools.sumOfDoubles(valuesAsDouble),
				1.0))
			throw new ProbabilitySumNotOneException();		
		this.values = values;
		this.setInFrequencyDomain(isInFrequencyDomain);
	}

	public double getLowerDomainBorder() {
		return 0;
	}

	public double drawSample() {
		double result = 0.0;
		List<Double> intervals = MathTools
				.computeIntervalsOfProb(getValuesAsDouble());

		double random = Math.random();
		for (int j = 0; j < intervals.size(); j++)
			if (random < intervals.get(j)) {
				result = distance * (j + 1);
				break;
			}
		return result;
	}

	public double getArithmeticMeanValue() throws DomainNotNumbersException {
		return MathTools.sumOfDoubles(getValuesAsDouble()) / values.size();
	}

	public Object getMedian() throws UnorderedDomainException {
		if (!hasOrderedDomain())
			throw new UnorderedDomainException();

		return getPercentile(50);
	}

	public Object getPercentile(int p) throws IndexOutOfBoundsException,
			UnorderedDomainException {
		if (!hasOrderedDomain())
			throw new UnorderedDomainException();
		if (p < 0 || p > 100)
			throw new IndexOutOfBoundsException();
		
		int rank = (int) Math.round((p * (values.size() + 1.0)) / 100.0);
		return values.get(rank);
	}

	public int numberOfSamples() {
		return values.size();
	}

	private List<Double> getValuesForDistance(double newDistance)
			throws NegativeDistanceException, FunctionNotInTimeDomainException {

		// check preconditions
		if ((distance < 0) || (newDistance < 0))
			throw new NegativeDistanceException();

		if (!isInTimeDomain())
			throw new FunctionNotInTimeDomainException();

		// begin implementation
		double oldPoint = distance;
		double newPoint = newDistance;
		int currentIndex = 0;
		double buffer = 0.0;

		ArrayList<Double> newValues = new ArrayList<Double>();

		if (newDistance < distance) {
			while (currentIndex < values.size()) {
				if (newPoint < oldPoint) {
					newValues.add(getProb(currentIndex, newDistance));
				} else {
					newValues
							.add(getLeftProb(oldPoint, currentIndex, newPoint,
									newDistance)
									+ getRightProb(oldPoint, currentIndex + 1,
											newPoint));
					oldPoint += distance;
					currentIndex++;
				}
				newPoint += newDistance;
			}
		}
		if (newDistance > distance) {
			while (currentIndex < values.size()) {
				if (oldPoint < newPoint) {
					buffer += values.get(currentIndex).getReal();

				} else {
					newValues.add(buffer
							+ getLeftProb(newPoint, currentIndex, oldPoint,
									distance));
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

	private double getProb(int index, double newDistance) {
		return (newDistance / distance) * values.get(index).getReal();
	}

	private double getLeftProb(double oldP, int index, double newP, double diff) {
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
		return pfFactory.createSamplePDFFromComplex(distance, resultList,
				inFrequencyDomain, pfFactory.createDefaultUnit());
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
		ISamplePDF sPDF2 = pfFactory.transformToSamplePDF(pdf1);
		ISamplePDF sPDF1 = pfFactory.transformToSamplePDF(pdf2);

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

}

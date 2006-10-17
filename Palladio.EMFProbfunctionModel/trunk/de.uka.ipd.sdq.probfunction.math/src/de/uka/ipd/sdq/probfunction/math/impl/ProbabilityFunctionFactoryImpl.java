/**
 * 
 */
package de.uka.ipd.sdq.probfunction.math.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.probfunction.BoxedPDF;
import de.uka.ipd.sdq.probfunction.ContinuousSample;
import de.uka.ipd.sdq.probfunction.ProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.ProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.Sample;
import de.uka.ipd.sdq.probfunction.SamplePDF;
import de.uka.ipd.sdq.probfunction.Unit;
import de.uka.ipd.sdq.probfunction.ProbfunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IBoxedPDF;
import de.uka.ipd.sdq.probfunction.math.IContinuousSample;
import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.ISample;
import de.uka.ipd.sdq.probfunction.math.ISamplePDF;
import de.uka.ipd.sdq.probfunction.math.IUnit;
import de.uka.ipd.sdq.probfunction.math.exception.UnknownPDFTypeException;
import de.uka.ipd.sdq.probfunction.math.util.MathTools;
import flanagan.complex.Complex;

/**
 * @author Ihssane
 * 
 */
public class ProbabilityFunctionFactoryImpl
		implements
			IProbabilityFunctionFactory {

	public static final String DEFAULT_UNIT_NAME = "ms";
	private ProbfunctionFactory eFactory = ProbfunctionFactory.eINSTANCE;
	private static final IProbabilityFunctionFactory factoryInstance = new ProbabilityFunctionFactoryImpl();

	private ProbabilityFunctionFactoryImpl() {
		super();
	}

	public IBoxedPDF transformToBoxedPDF(ProbabilityDensityFunction epdf) {
		IBoxedPDF bpdf = createBoxedPDF();
		if (epdf instanceof BoxedPDF) {
			for (Object s : ((BoxedPDF) epdf).getSamples())
				bpdf.getSamples().add(
						transformToContinuousSample((ContinuousSample) s));
		} else if (epdf instanceof SamplePDF) {
			int i = 1;
			for (Object v : ((SamplePDF) epdf).getValues()) {
				bpdf.getSamples()
						.add(createContinuousSample(i* ((SamplePDF) epdf).getDistance(),
										(Double) v));
				i++;
			}
		}
		return bpdf;
	}

	public ISamplePDF transformToSamplePDF(ProbabilityDensityFunction epdf)
			throws UnknownPDFTypeException {
		IBoxedPDF bpdf = transformToBoxedPDF(epdf);
		return transformToSamplePDF(bpdf);
	}

	public IProbabilityMassFunction transformToPMF(ProbabilityMassFunction epmf) {
		IProbabilityMassFunction pmf = createProbabilityMassFunction();
		for (Object s : epmf.getSamples())
			pmf.getSamples().add(
					transformToSample((Sample) s));
		return pmf;
	}

	public IBoxedPDF createBoxedPDF() {
		return new BoxedPDFImpl();
	}

	public IBoxedPDF createBoxedPDF(List<IContinuousSample> samples) {
		return new BoxedPDFImpl(samples);
	}

	public IContinuousSample createContinuousSample(double value, double d) {
		return new ContinuousSampleImpl(value, d);
	}

	public IUnit createDefaultUnit() {
		return new UnitImpl(DEFAULT_UNIT_NAME);
	}

	public ISamplePDF createDiracImpulse(int numOfSamplingPoints,
			double distance, IUnit unit) {
		List<Complex> zeroList = createZeroList(numOfSamplingPoints);
		zeroList.get(0).setReal(1.0);
		return createSamplePDFFromComplex(distance, zeroList, false, unit);
	}

	private List<Complex> createZeroList(int numOfSamplingPoints) {
		List<Complex> resultList = new ArrayList<Complex>();
		for (int i = 0; i < numOfSamplingPoints; i++) {
			resultList.add(new Complex(0, 0));
		}
		return resultList;
	}

	public IProbabilityMassFunction createProbabilityMassFunction() {
		return new ProbabilityMassFunctionImpl();
	}

	public IProbabilityMassFunction createProbabilityMassFunction(
			List<ISample> samples, boolean isOrderedSet) {
		return new ProbabilityMassFunctionImpl();
	}

	public ISample createSample(Object value, double probability) {
		return new SampleImpl(value, probability);
	}

	public ISamplePDF createSamplePDFFromComplex(double distance,
			List<Complex> samples, boolean isInFrequencyDomain, IUnit unit) {
		return new SamplePDFImpl(distance, samples, unit, isInFrequencyDomain);
	}

	public ISamplePDF createSamplePDFFromDouble(double distance,
			List<Double> samples, IUnit unit) {
		return new SamplePDFImpl(distance, samples, unit);
	}

	public IUnit createUnit(String unitName) {
		return new UnitImpl(unitName);
	}

	public ISamplePDF createZeroFunction(int numOfSamplingPoints,
			double distance, IUnit unit) {
		List<Complex> zeroList = createZeroList(numOfSamplingPoints);
		return createSamplePDFFromComplex(distance, zeroList, false, unit);
	}

	public IBoxedPDF transformToBoxedPDF(IProbabilityDensityFunction pdf)
			throws UnknownPDFTypeException {
		IBoxedPDF resultPDF;
		if (pdf instanceof IBoxedPDF) {
			resultPDF = (IBoxedPDF) pdf;
		} else if (pdf instanceof ISamplePDF) {
			resultPDF = transformSampledToBoxedPDF((ISamplePDF) pdf);
		} else {
			throw new UnknownPDFTypeException();
		}
		return resultPDF;
	}

	@SuppressWarnings("unchecked")
	public BoxedPDF transformToModelBoxedPDF(IProbabilityDensityFunction pdf)
			throws UnknownPDFTypeException {
		IBoxedPDF boxedPDF = transformToBoxedPDF(pdf);

		BoxedPDF ePDF = eFactory.createBoxedPDF();
		EList list = ePDF.getSamples();

		for (IContinuousSample s : boxedPDF.getSamples())
			list.add(transformToModelContinuousSample(s));
		return ePDF;
	}

	public ProbabilityDensityFunction transformToModelPDF(
			IProbabilityDensityFunction pdf) throws UnknownPDFTypeException {
		ProbabilityDensityFunction ePDF;

		if (pdf instanceof ISamplePDF) {
			ePDF = transformToModelSamplePDF(pdf);
		} else if (pdf instanceof IBoxedPDF) {
			ePDF = transformToModelBoxedPDF(pdf);
		} else {
			throw new UnknownPDFTypeException();
		}
		return ePDF;
	}

	@SuppressWarnings("unchecked")
	public ProbabilityMassFunction transformToModelPMF(
			IProbabilityMassFunction pmf) {
		ProbabilityMassFunction epmf = eFactory.createProbabilityMassFunction();
		EList list = epmf.getSamples();

		for (ISample s : pmf.getSamples())
			list.add(transformToModelSample(s));
		return epmf;
	}

	@SuppressWarnings("unchecked")
	public SamplePDF transformToModelSamplePDF(IProbabilityDensityFunction pdf)
			throws UnknownPDFTypeException {
		ISamplePDF samplePDF = transformToSamplePDF(pdf);
		SamplePDF ePDF = eFactory.createSamplePDF();
		EList list = ePDF.getValues();

		for (Complex d : samplePDF.getValues())
			list.add(d);
		return ePDF;
	}

	public IProbabilityDensityFunction transformToPDF(
			ProbabilityDensityFunction ePDF) throws UnknownPDFTypeException {
		IProbabilityDensityFunction pdf;

		if (ePDF instanceof SamplePDF) {
			pdf = transformToSamplePDF(ePDF);
		} else if (ePDF instanceof IBoxedPDF) {
			pdf = transformToBoxedPDF(ePDF);
		} else {
			throw new UnknownPDFTypeException();
		}
		return pdf;
	}

	public ISamplePDF transformToSamplePDF(IProbabilityDensityFunction pdf)
			throws UnknownPDFTypeException {
		ISamplePDF resultPDF;
		if (pdf instanceof ISamplePDF) {
			resultPDF = (ISamplePDF) pdf;
		} else if (pdf instanceof IBoxedPDF) {
			resultPDF = transformBoxedToSamplePDF((IBoxedPDF) pdf);
		} else {
			throw new UnknownPDFTypeException();
		}
		return resultPDF;
	}

	public IContinuousSample transformToContinuousSample(
			ContinuousSample eSample) {
		IContinuousSample sample = createContinuousSample(eSample.getValue(),
				eSample.getProbability());
		return sample;
	}

	public ContinuousSample transformToModelContinuousSample(
			IContinuousSample sample) {
		ContinuousSample eSample = eFactory.createContinuousSample();
		eSample.setProbability(sample.getProbability());
		eSample.setValue(sample.getValue());
		return eSample;
	}

	public Sample transformToModelSample(ISample sample) {
		Sample eSample = eFactory.createSample();
		eSample.setProbability(sample.getProbability());
		eSample.setValue(sample.getValue());
		return eSample;
	}

	public Unit transformToModelUnit(IUnit unit) {
		Unit eUnit = eFactory.createUnit();
		eUnit.setUnitName(unit.getUnitName());
		return eUnit;
	}

	public ISample transformToSample(Sample eSample) {
		ISample sample = createSample(eSample.getValue(), eSample
				.getProbability());
		return sample;
	}

	public IUnit transformToUnit(Unit eUnit) {
		IUnit unit = createDefaultUnit();
		unit.setUnitName(eUnit.getUnitName());
		return unit;
	}

	public static IProbabilityFunctionFactory getInstance() {
		return factoryInstance;
	}

	private ISamplePDF transformBoxedToSamplePDF(IBoxedPDF pdf) {
		List<Double> values = continuousSamplesToDoubles(pdf.getSamples());
		List<Double> newValues = new ArrayList<Double>();
		double distance = MathTools.gcd(values);
		double start = 0;

		for (IContinuousSample s : pdf.getSamples()) {
			int times = (int) Math.round((s.getValue() - start) / distance);
			double fractal = 1.0 / times;
			for (int i = 0; i < times; i++) {
				newValues.add(fractal * s.getProbability());
			}
			start = s.getValue();
		}
		return createSamplePDFFromDouble(distance, newValues, pdf.getUnit());
	}

	private IBoxedPDF transformSampledToBoxedPDF(ISamplePDF spdf) {
		List<Double> values = spdf.getValuesAsDouble();
		List<IContinuousSample> samples = new ArrayList<IContinuousSample>();

		int i = 1;
		for (Double d : values) {
			IContinuousSample sample = this.createContinuousSample(spdf
					.getDistance()
					* i, d);
			samples.add(sample);
			i++;
		}
		return createBoxedPDF(samples);
	}

	private List<Double> continuousSamplesToDoubles(List<IContinuousSample> list) {
		ArrayList<Double> newList = new ArrayList<Double>();
		double start = 0;
		for (IContinuousSample s : list) {
			newList.add(s.getValue() - start);
			start = s.getValue();
		}
		return newList;
	}

}

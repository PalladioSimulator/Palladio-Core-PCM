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
import de.uka.ipd.sdq.probfunction.ProbfunctionFactory;
import de.uka.ipd.sdq.probfunction.Sample;
import de.uka.ipd.sdq.probfunction.SamplePDF;
import de.uka.ipd.sdq.probfunction.Unit;
import de.uka.ipd.sdq.probfunction.math.IBoxedPDF;
import de.uka.ipd.sdq.probfunction.math.IContinuousSample;
import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.IRandomGenerator;
import de.uka.ipd.sdq.probfunction.math.ISample;
import de.uka.ipd.sdq.probfunction.math.ISamplePDF;
import de.uka.ipd.sdq.probfunction.math.IUnit;
import de.uka.ipd.sdq.probfunction.math.exception.DoubleSampleException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInTimeDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilitySumNotOneException;
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

	public IBoxedPDF transformToBoxedPDF(ProbabilityDensityFunction epdf)
			throws ProbabilitySumNotOneException, DoubleSampleException {
		IUnit unit = transformToUnit(epdf.getUnit());
		List<IContinuousSample> samples = new ArrayList<IContinuousSample>();
		
		if (epdf instanceof BoxedPDF) {
			List<IContinuousSample> sampleList = new ArrayList<IContinuousSample>();
			for (Object s : ((BoxedPDF) epdf).getSamples()){
				sampleList.add(transformToContinuousSample((ContinuousSample) s));
			}
		} else if (epdf instanceof SamplePDF) {
			int i = 1;
			for (Object v : ((SamplePDF) epdf).getValues()) {
						samples.add(
								createContinuousSample(i
										* ((SamplePDF) epdf).getDistance(),
										(Double) v));
				i++;
			}
		}
		return createBoxedPDF(samples,unit);
	}

	@SuppressWarnings("unchecked")
	public ISamplePDF transformToSamplePDF(ProbabilityDensityFunction epdf)
			throws UnknownPDFTypeException, ProbabilitySumNotOneException,
			DoubleSampleException {
		if (epdf instanceof SamplePDF) {
			SamplePDF spdf = (SamplePDF) epdf;
			double distance = spdf.getDistance();
			IUnit unit = transformToUnit(spdf.getUnit());
			List<Double> values = new ArrayList<Double>((List<Double>) spdf
					.getValues());
			return createSamplePDFFromDouble(distance, values, unit);
		} else {
			IBoxedPDF bpdf = transformToBoxedPDF(epdf);
			return transformBoxedToSamplePDF(bpdf);
		}
	}

	@SuppressWarnings("unchecked")
	public IProbabilityMassFunction transformToPMF(ProbabilityMassFunction epmf) {
		IUnit unit = transformToUnit(epmf.getUnit());
		boolean hasOrderedDomain = epmf.isOrderedDomain();
		IProbabilityMassFunction pmf = new ProbabilityMassFunctionImpl(unit,
				hasOrderedDomain,false);
		List samples = new ArrayList();
		for (Object s : epmf.getSamples()){
			Sample sample = (Sample) s;
			samples.add(transformToSample(sample));
		}
		
		pmf.setSamples(samples);
		return pmf;
	}

	public IBoxedPDF createBoxedPDF(List<IContinuousSample> samples, IUnit unit)
			throws DoubleSampleException {
		BoxedPDFImpl bpdf = new BoxedPDFImpl(unit);
		bpdf.setSamples(samples);
		return bpdf;
	}

	public IBoxedPDF createBoxedPDF(List<IContinuousSample> samples,
			IUnit unit, IRandomGenerator generator)
			throws DoubleSampleException {
		BoxedPDFImpl bpdf = new BoxedPDFImpl(unit);
		bpdf.setSamples(samples);
		return new BoxedPDFImpl(unit, generator);
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

	public IProbabilityMassFunction createProbabilityMassFunction(
			List<ISample> samples, IUnit unit, boolean hasOrderedDomain) {
		return new ProbabilityMassFunctionImpl(samples, unit, hasOrderedDomain,
				false);
	}

	public ISample createSample(Object value, double probability) {
		return new SampleImpl(value, probability);
	}

	public ISamplePDF createSamplePDFFromComplex(double distance,
			List<Complex> values, IUnit unit) {
		ISamplePDF spdf = new SamplePDFImpl(distance, unit);
		spdf.setValues(values, false);
		return spdf;
	}

	public ISamplePDF createSamplePDFFromComplex(double distance,
			List<Complex> samples, boolean isInFrequencyDomain, IUnit unit) {
		ISamplePDF spdf = new SamplePDFImpl(distance, unit, isInFrequencyDomain);
		spdf.setValues(samples, isInFrequencyDomain);
		return spdf;
	}

	public ISamplePDF createSamplePDFFromComplex(double distance,
			List<Complex> samples, IUnit unit, IRandomGenerator generator) {
		ISamplePDF spdf = new SamplePDFImpl(distance, unit, generator);
		spdf.setValues(samples, false);
		return spdf;
	}

	public ISamplePDF createSamplePDFFromComplex(double distance,
			List<Complex> samples, boolean isInFrequencyDomain, IUnit unit,
			IRandomGenerator generator) {
		ISamplePDF spdf = new SamplePDFImpl(distance, unit,
				isInFrequencyDomain, generator);
		spdf.setValues(samples, isInFrequencyDomain);
		return spdf;
	}

	public ISamplePDF createSamplePDFFromDouble(double distance,
			List<Double> values, IUnit unit) {
		ISamplePDF spdf = new SamplePDFImpl(distance, unit);
		spdf.setValuesAsDouble(values);
		return spdf;
	}

	public ISamplePDF createSamplePDFFromDouble(double distance,
			List<Double> values, boolean isInFrequencyDomain, IUnit unit) {
		ISamplePDF spdf = new SamplePDFImpl(distance, unit, isInFrequencyDomain);
		spdf.setValuesAsDouble(values);
		return spdf;
	}

	public ISamplePDF createSamplePDFFromDouble(double distance,
			List<Double> values, IUnit unit, IRandomGenerator generator) {
		ISamplePDF spdf = new SamplePDFImpl(distance, unit, generator);
		spdf.setValuesAsDouble(values);
		return spdf;
	}

	public ISamplePDF createSamplePDFFromDouble(double distance,
			List<Double> values, boolean isInFrequencyDomain, IUnit unit,
			IRandomGenerator generator) {
		ISamplePDF spdf = new SamplePDFImpl(distance, unit,
				isInFrequencyDomain, generator);
		spdf.setValuesAsDouble(values);
		return spdf;
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
			throws UnknownPDFTypeException, 
			DoubleSampleException, FunctionNotInTimeDomainException {
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
			throws UnknownPDFTypeException, 
			DoubleSampleException, FunctionNotInTimeDomainException {
		IBoxedPDF boxedPDF = transformToBoxedPDF(pdf);

		BoxedPDF ePDF = eFactory.createBoxedPDF();
		EList list = ePDF.getSamples();
		
		Unit unit = transformToModelUnit(pdf.getUnit());
		ePDF.setUnit(unit);

		for (IContinuousSample s : boxedPDF.getSamples())
			list.add(transformToModelContinuousSample(s));
		return ePDF;
	}

	public ProbabilityDensityFunction transformToModelPDF(
			IProbabilityDensityFunction pdf) throws UnknownPDFTypeException,
			DoubleSampleException, FunctionNotInTimeDomainException {
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
		epmf.setUnit(transformToModelUnit(pmf.getUnit()));
		epmf.setOrderedDomain(pmf.hasOrderedDomain());
		return epmf;
	}

	@SuppressWarnings("unchecked")
	public SamplePDF transformToModelSamplePDF(IProbabilityDensityFunction pdf)
			throws UnknownPDFTypeException {
		ISamplePDF samplePDF = transformToSamplePDF(pdf);
		SamplePDF ePDF = eFactory.createSamplePDF();
		EList list = ePDF.getValues();

		for (Complex d : samplePDF.getValues())
			list.add(d.getReal());
		
		Unit unit = transformToModelUnit(pdf.getUnit());
		ePDF.setUnit(unit);
		
		ePDF.setDistance(samplePDF.getDistance());
		
		return ePDF;
	}

	public IProbabilityDensityFunction transformToPDF(
			ProbabilityDensityFunction ePDF) throws UnknownPDFTypeException,
			ProbabilitySumNotOneException, DoubleSampleException {
		IProbabilityDensityFunction pdf;

		if (ePDF instanceof SamplePDF) {
			pdf = transformToSamplePDF(ePDF);
		} else if (ePDF instanceof BoxedPDF) {
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

	private IBoxedPDF transformSampledToBoxedPDF(ISamplePDF spdf)
			throws DoubleSampleException, FunctionNotInTimeDomainException {
		if (spdf.isInFrequencyDomain())
			throw new FunctionNotInTimeDomainException();
		
		List<Double> values = spdf.getValuesAsDouble();
		List<IContinuousSample> samples = new ArrayList<IContinuousSample>();

		int i = 0;
		for (Double d : values) {
			IContinuousSample sample = this.createContinuousSample(spdf
					.getDistance()
					* i, d);
			samples.add(sample);
			i++;
		}
		return createBoxedPDF(samples, spdf.getUnit());
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

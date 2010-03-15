package de.uka.ipd.sdq.probfunction.math.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.probfunction.BoxedPDF;
import de.uka.ipd.sdq.probfunction.ContinuousSample;
import de.uka.ipd.sdq.probfunction.ExponentialDistribution;
import de.uka.ipd.sdq.probfunction.GammaDistribution;
import de.uka.ipd.sdq.probfunction.LognormalDistribution;
import de.uka.ipd.sdq.probfunction.ProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.ProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.ProbfunctionFactory;
import de.uka.ipd.sdq.probfunction.Sample;
import de.uka.ipd.sdq.probfunction.SamplePDF;
import de.uka.ipd.sdq.probfunction.math.IBoxedPDF;
import de.uka.ipd.sdq.probfunction.math.IContinousPDF;
import de.uka.ipd.sdq.probfunction.math.IContinuousSample;
import de.uka.ipd.sdq.probfunction.math.IExponentialDistribution;
import de.uka.ipd.sdq.probfunction.math.IGammaDistribution;
import de.uka.ipd.sdq.probfunction.math.ILognormalDistribution;
import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.IRandomGenerator;
import de.uka.ipd.sdq.probfunction.math.ISample;
import de.uka.ipd.sdq.probfunction.math.ISamplePDF;
import de.uka.ipd.sdq.probfunction.math.IUnit;
import de.uka.ipd.sdq.probfunction.math.exception.DoubleSampleException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInTimeDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.NegativeDistanceException;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilitySumNotOneException;
import de.uka.ipd.sdq.probfunction.math.exception.UnknownPDFTypeException;
import de.uka.ipd.sdq.probfunction.math.util.MathTools;
import flanagan.complex.Complex;

/**
 * @author Ihssane
 * 
 */
public class ProbabilityFunctionFactoryImpl implements
		IProbabilityFunctionFactory {

	public static final String DEFAULT_UNIT_NAME = "ms";
	private ProbfunctionFactory eFactory = ProbfunctionFactory.eINSTANCE;
	private static final IProbabilityFunctionFactory factoryInstance = new ProbabilityFunctionFactoryImpl();

	private ProbabilityFunctionFactoryImpl() {
		super();
	}

	public IBoxedPDF transformToBoxedPDF(ProbabilityDensityFunction epdf)
			throws ProbabilitySumNotOneException, DoubleSampleException {
		// TODO: IUnit unit = transformToUnit(epdf.getUnitSpecification());
		List<IContinuousSample> samples = new ArrayList<IContinuousSample>();

		if (epdf instanceof BoxedPDF) {
			for (Object s : ((BoxedPDF) epdf).getSamples()) {
				samples.add(transformToContinuousSample((ContinuousSample) s));
			}
		} else if (epdf instanceof SamplePDF) {
			int i = 1;
			for (Object v : ((SamplePDF) epdf).getValues()) {
				samples.add(createContinuousSample(i
						* ((SamplePDF) epdf).getDistance(), (Double) v));
				i++;
			}
		}
		return createBoxedPDF(samples, /* TODO:Unit */null);
	}

	public ISamplePDF transformToSamplePDF(ProbabilityDensityFunction epdf)
			throws UnknownPDFTypeException, ProbabilitySumNotOneException,
			DoubleSampleException {
		if (epdf instanceof SamplePDF) {
			SamplePDF spdf = (SamplePDF) epdf;
			double distance = spdf.getDistance();
			// TODO: Unit IUnit unit =
			// transformToUnit(spdf.getUnitSpecification());
			// TODO: Fix this after PCM4 migration
			//List<Double> values = new ArrayList<Double>((List<Double>) spdf
			//		.getValues());
			List<Double> values = new ArrayList<Double>();
			return createSamplePDFFromDouble(distance, values, /* TODO:Unit */
					null);
		} else {
			IBoxedPDF bpdf = transformToBoxedPDF(epdf);
			return transformBoxedToSamplePDF(bpdf);
		}
	}

	@SuppressWarnings("unchecked")
	public IProbabilityMassFunction transformToPMF(ProbabilityMassFunction epmf) {
		// TODO:Unit! IUnit unit = transformToUnit(epmf.getUnitSpecification());
		boolean hasOrderedDomain = epmf.isOrderedDomain();
		IProbabilityMassFunction pmf = new ProbabilityMassFunctionImpl(
				/* TODO:Unit */null, hasOrderedDomain, false);
		List samples = new ArrayList();
		for (Object s : epmf.getSamples()) {
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
		return createImpulseAt(0, numOfSamplingPoints, distance, unit);
	}

	public ISamplePDF createImpulseAt(int pos, int numOfSamplingPoints,
			double distance, IUnit unit) {
		assert (pos < numOfSamplingPoints);

		List<Complex> zeroList = createZeroList(numOfSamplingPoints);
		zeroList.get(pos).setReal(1.0);
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

	public IProbabilityMassFunction createPMFFromMeasurements(
			Boolean[] measurements, IUnit unit, boolean hasOrderedDomain) {
		HashMap<Boolean, Integer> times = new HashMap<Boolean, Integer>();
		List<Boolean> measurementsList = Arrays.asList(measurements);
		for (Boolean i : measurementsList) {
			int oldValue = times.get(i) == null ? 0 : times.get(i);
			times.put(i, ++oldValue);
		}
		List<ISample> samples = createPMFFromList(times, measurementsList
				.size());
		return createProbabilityMassFunction(samples, unit, hasOrderedDomain);
	}

	public IProbabilityMassFunction createPMFFromMeasurements(
			Double[] measurements, double epsilon, IUnit unit,
			boolean hasOrderedDomain) {
		HashMap<Double, Integer> times = new HashMap<Double, Integer>();
		List<Double> measurementsList = Arrays.asList(measurements);
		List<Integer> compared = new ArrayList<Integer>();
		int index1 = 0;
		for (Double d1 : measurementsList) {
			int index = 0;
			if (compared.contains(index1)) {
				index1++;
				continue;
			}
			for (Double d2 : measurementsList) {
				if (Math.abs(d1 - d2) < epsilon && !compared.contains(index)) {
					int oldValue = times.get(d1) == null ? 0 : times.get(d1);
					times.put(d1, ++oldValue);
					compared.add(index);
				}
				index++;
			}
			index1++;
		}
		List<ISample> samples = createPMFFromList(times, measurementsList
				.size());
		return createProbabilityMassFunction(samples, unit, hasOrderedDomain);
	}

	public IProbabilityMassFunction createPMFFromMeasurements(
			String[] measurements, IUnit unit, boolean hasOrderedDomain) {
		HashMap<String, Integer> times = new HashMap<String, Integer>();
		List<String> measurementsList = Arrays.asList(measurements);
		for (String i : measurementsList) {
			int oldValue = times.get(i) == null ? 0 : times.get(i);
			times.put(i, ++oldValue);
		}
		List<ISample> samples = createPMFFromList(times, measurementsList
				.size());
		return createProbabilityMassFunction(samples, unit, hasOrderedDomain);
	}

	public IProbabilityMassFunction createPMFFromMeasurements(
			Integer[] measurements, IUnit unit, boolean hasOrderedDomain) {
		HashMap<Integer, Integer> times = new HashMap<Integer, Integer>();
		List<Integer> measurementsList = Arrays.asList(measurements);
		for (Integer i : measurementsList) {
			int oldValue = times.get(i) == null ? 0 : times.get(i);
			times.put(i, ++oldValue);
		}
		List<ISample> samples = createPMFFromList(times, measurementsList
				.size());
		return createProbabilityMassFunction(samples, unit, hasOrderedDomain);
	}

	private List<ISample> createPMFFromList(
			HashMap<? extends Object, Integer> map, int count) {
		List<ISample> samples = new ArrayList<ISample>();
		for (Object value : map.keySet())
			samples.add(createSample(value, map.get(value) * 1.0 / count));

		return samples;
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

	public ISamplePDF createSamplePDFFromMeasurements(double distance,
			List<Double> measurements, IUnit unit) {
		Collections.sort(measurements);
		List<Double> samples = new ArrayList<Double>();
		HashMap<Integer, Integer> timesMap = new HashMap<Integer, Integer>();

		int maxPos = 0;

		for (Double d : measurements) {
			int pos = (int) (d / distance);
			double rest = (d % distance) / distance;
			if (rest > 0.5)
				pos += 1;
			maxPos = pos > maxPos ? pos : maxPos;
			Integer value = timesMap.get(pos);
			if (value == null)
				value = new Integer(0);
			value++;
			timesMap.put(pos, value);
		}

		for (int i = 0; i <= maxPos; i++) {
			Integer value = timesMap.get(i);
			if (value == null) {
				samples.add(0.0);
			} else {
				samples.add((double) value / (double) measurements.size());
			}
		}

		return createSamplePDFFromDouble(distance, samples, unit);
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
			throws UnknownPDFTypeException, DoubleSampleException,
			FunctionNotInTimeDomainException {
		IBoxedPDF resultPDF;
		if (pdf instanceof IBoxedPDF) {
			resultPDF = (IBoxedPDF) pdf;
		} else if (pdf instanceof ISamplePDF) {
			resultPDF = transformSampledToBoxedPDF((ISamplePDF) pdf);
		} else if (pdf instanceof IContinousPDF){
			resultPDF = transformContinuousToBoxedPDF((IContinousPDF) pdf);
		} else {
			throw new UnknownPDFTypeException(pdf);
		}
		return resultPDF;
	}

	@SuppressWarnings("unchecked")
	public BoxedPDF transformToModelBoxedPDF(IProbabilityDensityFunction pdf)
			throws UnknownPDFTypeException, DoubleSampleException,
			FunctionNotInTimeDomainException {
		IBoxedPDF boxedPDF = transformToBoxedPDF(pdf);

		BoxedPDF ePDF = eFactory.createBoxedPDF();
		EList list = ePDF.getSamples();

		// TODO:Unit!
		// ePDF.setUnitSpecification(transformToModelUnitSpecification(pdf.getUnit()));

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
		} else if (pdf instanceof IExponentialDistribution){
			ExponentialDistribution expPDF = eFactory.createExponentialDistribution();
			expPDF.setRate(((IExponentialDistribution)pdf).getRate());
			ePDF = expPDF;
		} else if (pdf instanceof IGammaDistribution){
			GammaDistribution gamma = eFactory.createGammaDistribution();
			gamma.setAlpha(((IGammaDistribution)pdf).getAlpha());
			gamma.setBeta(((IGammaDistribution)pdf).getBeta());
			ePDF = gamma;
		} else if (pdf instanceof ILognormalDistribution){
			LognormalDistribution lognorm = eFactory.createLognormalDistribution();
			lognorm.setMu(((ILognormalDistribution)pdf).getMu());
			lognorm.setSigma(((ILognormalDistribution)pdf).getSigma());
			ePDF = lognorm;
		} else {
			throw new UnknownPDFTypeException(pdf);
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
		// TODO:Unit!
		// epmf.setUnitSpecification(transformToModelUnitSpecification(pmf.getUnit()));
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

		// TODO:Unit!
		// ePDF.setUnitSpecification(transformToModelUnitSpecification(pdf.getUnit()));

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
		} else if (ePDF instanceof de.uka.ipd.sdq.probfunction.ExponentialDistribution){
			pdf = new de.uka.ipd.sdq.probfunction.math.impl.ExponentialDistribution(((de.uka.ipd.sdq.probfunction.ExponentialDistribution)ePDF).getRate());
		} else if (ePDF instanceof de.uka.ipd.sdq.probfunction.GammaDistribution){
			pdf = new de.uka.ipd.sdq.probfunction.math.impl.GammaDistribution(((de.uka.ipd.sdq.probfunction.GammaDistribution)ePDF).getAlpha(),((de.uka.ipd.sdq.probfunction.GammaDistribution)ePDF).getBeta());
		} else if (ePDF instanceof de.uka.ipd.sdq.probfunction.LognormalDistribution){
			pdf = new de.uka.ipd.sdq.probfunction.math.impl.LognormalDistribution(((de.uka.ipd.sdq.probfunction.LognormalDistribution)ePDF).getMu(),((de.uka.ipd.sdq.probfunction.LognormalDistribution)ePDF).getSigma());
		} else {
			throw new UnknownPDFTypeException(ePDF);
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
		} else if (pdf != null) {
			throw new UnknownPDFTypeException(pdf);
		} else {
			return null;
		}
		return resultPDF;
	}

	public ISamplePDF transformToSamplePDF(IProbabilityDensityFunction pdf,
			double newDistance) throws UnknownPDFTypeException,
			NegativeDistanceException, FunctionNotInTimeDomainException {
		ISamplePDF resultPDF;
		if (pdf instanceof ISamplePDF) {
			resultPDF = ((ISamplePDF) pdf)
					.getFunctionWithNewDistance(newDistance);
		} else if (pdf instanceof IBoxedPDF) {
			resultPDF = transformBoxedToSamplePDF((IBoxedPDF) pdf, newDistance);
		} else if (pdf != null) {
			throw new UnknownPDFTypeException(pdf);
		} else {
			return null;
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

	public String transformToModelUnitSpecification(IUnit unit) {
		return unit.getUnitName();
	}

	public ISample transformToSample(Sample eSample) {
		ISample sample = createSample(eSample.getValue(), eSample
				.getProbability());
		return sample;
	}

	public IUnit transformToUnit(String unitSpecification) {
		IUnit unit = createDefaultUnit();
		unit.setUnitName(unitSpecification);
		return unit;
	}

	public static IProbabilityFunctionFactory getInstance() {
		return factoryInstance;
	}

	private ISamplePDF transformBoxedToSamplePDF(IBoxedPDF pdf) {
		List<Double> values = continuousSamplesToDoubles(pdf.getSamples());
		List<Double> newValues = new ArrayList<Double>();
		double distance = MathTools.gcd(values);
		double halfDistance = distance / 2;
		double start = 0;

		// the first value
		int flag = 1;
		double np = 0.0;
		for (IContinuousSample s : pdf.getSamples()) {
			int times = (int) Math.round((s.getValue() - start) / halfDistance);
			for (int i = 0; i < times; i++) {
				if (flag == 1) {
					np += s.getProbability() / times;
					newValues.add(np);
					flag = 0;
				} else {
					np = s.getProbability() / times;
					flag++;
				}
			}
			start = s.getValue();
		}
		if (flag == 1)
			newValues.add(np);
		return createSamplePDFFromDouble(distance, newValues, pdf.getUnit());
	}

	public ISamplePDF transformBoxedToSamplePDF(IBoxedPDF bpdf, double distance) {
		if (bpdf.getSamples().size() == 0)
			return createSamplePDFFromComplex(distance,
					new ArrayList<Complex>(), bpdf.getUnit());

		double maxValue = bpdf.getSamples().get(bpdf.getSamples().size() - 1)
				.getValue();
		double currentNewSample = distance / 2;
		int index = 0;
		List<IContinuousSample> samples = bpdf.getSamples();
		List<Double> newSamples = new ArrayList<Double>();
		double newProb = 0.0;

		while (currentNewSample < maxValue || index < samples.size()) {
			if (currentNewSample < samples.get(index).getValue()) {
				if (newSamples.size() == 0)
					newProb = (currentNewSample / samples.get(0).getValue())
							* samples.get(0).getProbability();
				else {
					double dif = index == 0 ? samples.get(0).getValue()
							: samples.get(index).getValue()
									- samples.get(index - 1).getValue();
					newProb = (distance / dif)
							* samples.get(index).getProbability();
				}
				newSamples.add(newProb);
				currentNewSample += distance;

			} else {
				double dif = index == 0 ? samples.get(0).getValue() : samples
						.get(index).getValue()
						- samples.get(index - 1).getValue();
				//FIXME: wrong for testcase if values are smaller that 1 
				//see de.uka.ipd.sdq.stoex.analyser.tests.ExpressionSolveVisitorTest 
				newProb = ((samples.get(index).getValue() - currentNewSample + distance) / dif)
						* samples.get(index).getProbability();
				index++;

				while (index < samples.size()
						&& samples.get(index).getValue() < currentNewSample) {
					newProb += samples.get(index).getProbability();
					index++;
				}
				if (index < samples.size())
					newProb += (1 - ((samples.get(index).getValue() - currentNewSample) / (samples
							.get(index).getValue() - samples.get(index - 1)
							.getValue())))
							* samples.get(index).getProbability();
				newSamples.add(newProb);
				currentNewSample += distance;
				// if (currentNewSample > samples.get(index).getValue())
				// index++;

			}
		}
		return createSamplePDFFromDouble(distance, newSamples, false, bpdf
				.getUnit());
	}

	private IBoxedPDF transformSampledToBoxedPDF(ISamplePDF spdf)
			throws DoubleSampleException, FunctionNotInTimeDomainException {
		if (spdf.isInFrequencyDomain())
			throw new FunctionNotInTimeDomainException();

		List<Double> values = spdf.getValuesAsDouble();
		List<IContinuousSample> samples = new ArrayList<IContinuousSample>();

//		int i = 1;
//		for (Double d : values) {
//			IContinuousSample sample = this.createContinuousSample(spdf
//					.getDistance()
//					* i, d);
//			samples.add(sample);
//			i++;
//		}
		double distance = spdf.getDistance();

		for (int i = 0; i < values.size();) {
			double currentProb = values.get(i);
			double prob = currentProb;
			for (i = i + 1; i < values.size(); i++) {
				double nextProb = values.get(i);
				if (MathTools.equalsDouble(nextProb, currentProb)) {
					prob += nextProb;
				} else {
					break;
				}
			}
			IContinuousSample s = this.
				createContinuousSample(distance * i, prob);
			samples.add(s);
		}

		return createBoxedPDF(samples, spdf.getUnit());
	}
	

	/**
	 * This function creates an approximation histogram of the passed pdf. 
	 * The number of bins is fixed to 20. 
	 * If the passed pdf has an infinite support (e.g. ranges from 0 to + 
	 * infinity like the exponential function), the 95% or 5% percentile is
	 * used for the support of the histogram.    
	 * The value of each bin with the range lowerLimit to upperLimit 
	 * is the difference of the cumulated probabilities of its limit points:
	 * p(bin) = pdf.cdf(upperLimit) - pdf.cdf(lowerLimit). 
	 * @param pdf The continuous probability function to approximate.
	 * @return
	 * @throws DoubleSampleException
	 */
	private IBoxedPDF transformContinuousToBoxedPDF(IContinousPDF pdf) throws DoubleSampleException {
		// number of boxes needs to be defined. Not too much, or it becomes too big. 
		int numberOfBoxes = 20;
		double cutMargin = 0.05;
	
		// get lower and upper bound for the boxes. 
		double xSup = pdf.getXsup();
		double xInf = pdf.getXinf();
		
		// try xInf and xsup and test that not inifinity. If no, use them directly for bounds. 
		if (Double.isInfinite(xSup) || Double.isNaN(xSup)){
			// If yes, lets define it so that 95% of the
			// probability is covered.
			xSup = pdf.inverseF(1-cutMargin);
			//TODO: adjust pdf to new xSup?
		}
		if (Double.isInfinite(xInf) || Double.isNaN(xInf)){
			xInf = pdf.inverseF(0+cutMargin);
			//TODO: adjust pdf to new xInf?
		}

		double stepwidth = (xSup - xInf) / 20;
		double x = xInf;
		double upperProbability = 0;
		double lowerProbability = 0;
		
		List<IContinuousSample> samples = new ArrayList<IContinuousSample>();
		if (xInf != 0){
			IContinuousSample s = this.createContinuousSample(xInf, 0);
			samples.add(s);
		}
		for (int i = 1; i <= numberOfBoxes; i++){
			x = xInf + i * stepwidth;
			
			lowerProbability = upperProbability;
			upperProbability = pdf.cdf(x);
			
			IContinuousSample s = this.createContinuousSample(x, upperProbability - lowerProbability);
			samples.add(s);
		}
		
		BoxedPDFImpl boxedPdf = (BoxedPDFImpl)createBoxedPDF(samples, pdf.getUnit());
		double sum = boxedPdf.getProbabilitySum();
		
		if (Math.abs(sum - 1) > 10e-10 ){
			// Adjust wrong PDFs
			double delta = (1 - sum) / countNonZeroContiniousSamples(samples);
			for(IContinuousSample sample : boxedPdf.getSamples()) {
				if (sample.getProbability() > 0)
					((ContinuousSampleImpl)sample).setProbability(sample.getProbability()+delta);
			}
		}
	
		return boxedPdf;
	}
	
	private double countNonZeroContiniousSamples(List<IContinuousSample> samples) {
		int count=0;
		for (IContinuousSample s : samples)
			if (s.getProbability()>0)
				count++;
		return count;
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

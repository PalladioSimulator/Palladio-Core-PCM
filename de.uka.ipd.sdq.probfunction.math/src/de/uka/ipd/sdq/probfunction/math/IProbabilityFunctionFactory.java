package de.uka.ipd.sdq.probfunction.math;

import java.util.List;

import de.uka.ipd.sdq.probfunction.BoxedPDF;
import de.uka.ipd.sdq.probfunction.ContinuousSample;
import de.uka.ipd.sdq.probfunction.ProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.ProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.Sample;
import de.uka.ipd.sdq.probfunction.SamplePDF;
import de.uka.ipd.sdq.probfunction.math.exception.DoubleSampleException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInTimeDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.NegativeDistanceException;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilitySumNotOneException;
import de.uka.ipd.sdq.probfunction.math.exception.UnknownPDFTypeException;
import flanagan.complex.Complex;

/**
 * Factory. Provides a set of methods to create all kinds of probability
 * functions and related objects. It also allows the transformation of different
 * function types.
 * 
 * @author ihssane, jens
 * 
 */
public interface IProbabilityFunctionFactory {

	/**
	 * Singleton instance of the factory.
	 */
	IProbabilityFunctionFactory eINSTANCE = de.uka.ipd.sdq.probfunction.math.impl.ProbabilityFunctionFactoryImpl
			.getInstance();

	/**
	 * Creates a new ContinuousSample with the attributes value and probability
	 * set.
	 * 
	 * @param Value
	 *            domain (x) value of the sample.
	 * @param Probability
	 *            range (y) value of the sample.
	 * @return New ContinuousSample instance.
	 */
	IContinuousSample createContinuousSample(double value, double probability);

	/**
	 * Converts a function object to a model object with the same attributes.
	 * 
	 * @param sample
	 *            Object to transform.
	 * @return New ContinuousSample instance.
	 */
	ContinuousSample transformToModelContinuousSample(IContinuousSample sample);

	/**
	 * Converts a model object to a function object with the same attributes.
	 * 
	 * @param eSample
	 *            Object to transform.
	 * @return New ContinuousSample instance.
	 */
	IContinuousSample transformToContinuousSample(ContinuousSample eSample);

	/**
	 * Creates a new Sample with the attributes value and probability set.
	 * 
	 * @param Value
	 *            domain (x) value of the sample.
	 * @param Probability
	 *            range (y) value of the sample.
	 * @return New Sample instance.
	 */
	ISample createSample(Object value, double probability);

	/**
	 * Converts a function object to a model object with the same attributes.
	 * 
	 * @param sample
	 *            Object to transform.
	 * @return New Sample instance.
	 */
	Sample transformToModelSample(ISample sample);

	/**
	 * Converts a model object to a function object with the same attributes.
	 * 
	 * @param eSample
	 *            Object to transform.
	 * @return New Sample instance.
	 */
	ISample transformToSample(Sample eSample);

	/**
	 * Creates new Unit with name unitName.
	 * 
	 * @param unitName
	 *            Name of the unit.
	 * @return New Unit instance.
	 */
	IUnit createUnit(String unitName);

	/**
	 * Creates new Unit with name DEFAULT_UNIT_NAME, which is "ms".
	 * 
	 * @param unitName
	 *            Name of the unit.
	 * @return New Unit instance.
	 */
	IUnit createDefaultUnit();

	/**
	 * Converts a function object to a model object with the same attributes.
	 * 
	 * @param unit
	 *            Object to transform.
	 * @return New Unit instance.
	 */
	String transformToModelUnitSpecification(IUnit unit);

	/**
	 * Converts a model object to a function object with the same attributes.
	 * 
	 * @param eUnit
	 *            Object to transform.
	 * @return New Unit instance.
	 */
	IUnit transformToUnit(String unitSpecification);

	/**
	 * Creates a new SamplePDF instace whose distance is set to 'distance' and
	 * whose sampling points are set to samples. As the sampling points are
	 * complex values in general, this function sets only the real part of the
	 * values. The imaginary part is set to zero.
	 * 
	 * @param distance
	 *            Distance between the sampling points stored in samples.
	 * @param samples
	 *            Sampling points of the approximated PDF.
	 * @param unit
	 *            TODO
	 * @return New instance of SamplePDF with set attributes.
	 */
	ISamplePDF createSamplePDFFromDouble(double distance, List<Double> samples,
			IUnit unit);

	/**
	 * @param distance
	 * @param samples
	 * @param isInFrequencyDomain
	 * @param unit
	 * @return
	 */
	ISamplePDF createSamplePDFFromDouble(double distance, List<Double> samples,
			boolean isInFrequencyDomain, IUnit unit);

	/**
	 * @param distance
	 * @param values
	 * @param unit
	 * @param generator
	 * @return
	 */
	ISamplePDF createSamplePDFFromDouble(double distance, List<Double> values,
			IUnit unit, IRandomGenerator generator);

	/**
	 * @param distance
	 * @param values
	 * @param isInFrequencyDomain
	 * @param unit
	 * @param generator
	 * @return
	 */
	ISamplePDF createSamplePDFFromDouble(double distance, List<Double> values,
			boolean isInFrequencyDomain, IUnit unit, IRandomGenerator generator);
	/**
	 * @param distance
	 * @param samples
	 * @param unit
	 * @return
	 */
	ISamplePDF createSamplePDFFromComplex(double distance,
			List<Complex> samples, IUnit unit);
	/**
	 * @param distance
	 * @param samples
	 * @param unit
	 * @param generator
	 * @return
	 */
	ISamplePDF createSamplePDFFromComplex(double distance,
			List<Complex> samples, IUnit unit, IRandomGenerator generator);
	/**
	 * @param distance
	 * @param samples
	 * @param isInFrequencyDomain
	 * @param unit
	 * @param generator
	 * @return
	 */
	ISamplePDF createSamplePDFFromComplex(double distance,
			List<Complex> samples, boolean isInFrequencyDomain, IUnit unit,
			IRandomGenerator generator);
	/**
	 * Creates a new SamplePDF instace whose distance is set to 'distance' and
	 * whose sampling points are set to samples.
	 * 
	 * @param distance
	 *            Distance between the sampling points stored in samples.
	 * @param samples
	 *            Sampling points of the approximated PDF.
	 * @param isInFrequencyDomain
	 *            Indicates whether the values are in frequency domain (true) or
	 *            time domain (false).
	 * @param unit
	 *            TODO
	 * @return New instance of SamplePDF with set attributes.
	 */
	ISamplePDF createSamplePDFFromComplex(double distance,
			List<Complex> samples, boolean isInFrequencyDomain, IUnit unit);

	/**
	 * @param distance
	 * @param measurements
	 * @return
	 */
	ISamplePDF createSamplePDFFromMeasurements(double distance,
			List<Double> measurements, IUnit unit);

	/**
	 * creates a distribution function, wich represents a dirac impulse. The
	 * returned function consists of numOfSamplingPoints equidistant points.
	 * 
	 * @param numOfSamplingPoints
	 *            number of points.
	 * @param distance
	 *            distance between each two points.
	 * @param unit
	 *            TODO
	 * @return a new probability density function with entered parameters.
	 */
	ISamplePDF createDiracImpulse(int numOfSamplingPoints, double distance,
			IUnit unit);

	/**
	 * Creates a distribution function, which describes a random variable with a
	 * constant outcome. In this case, it is given by distance * pos.
	 * 
	 * @param pos
	 * @param numOfSamplingPoints
	 * @param distance
	 * @param unit
	 * @return a new probability density function with entered parameters.
	 */
	ISamplePDF createImpulseAt(int pos, int numOfSamplingPoints,
			double distance, IUnit unit);

	/**
	 * creates a distribution function, wich consists of numOfSamplingspoints
	 * zeros.
	 * 
	 * @param numOfSamplingPoints
	 *            number of points.
	 * @param distance
	 *            distance between each two points.
	 * @return a new "zeros" DistributionFunction.
	 */
	ISamplePDF createZeroFunction(int numOfSamplingPoints, double distance,
			IUnit unit);

	/**
	 * Converts a arbitrary PDF to a SamplePDF. So far, only two cases are
	 * supported: The input PDF is a SamplePDF, then a reference to the original
	 * PDF is returned or the input pdf is a BoxedPDF, then the a new SamplePDF
	 * is created from the BoxedPDF.
	 * 
	 * @param pdf
	 *            PDF to transform.
	 * @return Either a reference to the input PDF or a new SamplePDF with the
	 *         same properties as the input pdf.
	 * @throws UnknownPDFTypeException
	 *             Thrown in case pdf is neither a BoxedPDF nor a SamplePDF.
	 */
	ISamplePDF transformToSamplePDF(IProbabilityDensityFunction pdf)
			throws UnknownPDFTypeException;

	/**
	 * Converts a arbitrary PDF to a SamplePDF. So far, only two cases are
	 * supported: The input PDF is a SamplePDF, then a reference to a new Sample
	 * PDF with the given distance is returned or the input pdf is a BoxedPDF,
	 * then a new SamplePDF is created from the BoxedPDF.
	 * 
	 * @param pdf
	 *            PDF to transform.
	 * @param newDistance
	 *            the new distance
	 * @return Either a reference to the input PDF or a new SamplePDF with the
	 *         same properties as the input pdf.
	 * @throws UnknownPDFTypeException
	 *             Thrown in case pdf is neither a BoxedPDF nor a SamplePDF.
	 * @throws FunctionNotInTimeDomainException
	 * @throws NegativeDistanceException
	 */
	ISamplePDF transformToSamplePDF(IProbabilityDensityFunction pdf,
			double newDistance) throws UnknownPDFTypeException,
			NegativeDistanceException, FunctionNotInTimeDomainException;

	/**
	 * Converts a model object to a function object with the same attributes.
	 * 
	 * @param ePDF
	 *            Object to transform.
	 * @return New SamplePDF instance.
	 * @throws UnknownPDFTypeException
	 *             Thrown in case pdf is neither a BoxedPDF nor a SamplePDF
	 * @throws DoubleSampleException
	 * @throws ProbabilitySumNotOneException
	 */
	ISamplePDF transformToSamplePDF(ProbabilityDensityFunction ePDF)
			throws UnknownPDFTypeException, ProbabilitySumNotOneException,
			DoubleSampleException;

	/**
	 * Converts a function object to a model object with the same attributes.
	 * 
	 * @param pdf
	 *            Object to transform.
	 * @return New SamplePDF instance.
	 */
	SamplePDF transformToModelSamplePDF(IProbabilityDensityFunction pdf)
			throws UnknownPDFTypeException;

	/**
	 * Creates a new BoxedPDF, whose boxes are defined by 'samples'.
	 * 
	 * @param samples
	 *            List of ContinuousSamples, which defines the upper right
	 *            corners of the PDF's boxes. The list may be unsorted. The
	 *            values of all samples must be greater or equal to zero.
	 * @return New BoxedPDF instance.
	 * @throws ProbabilitySumNotOneException
	 * @throws DoubleSampleException
	 */
	IBoxedPDF createBoxedPDF(List<IContinuousSample> samples, IUnit unit)
			throws DoubleSampleException;

	/**
	 * Converts a arbitrary PDF to a BoxedPDF. So far, only two cases are
	 * supported: The input PDF is a BoxedPDF, then a reference to the original
	 * PDF is returned or the input pdf is a SamplePDF, then the a new BoxedPDF
	 * is created from the SamplePDF.
	 * 
	 * @param pdf
	 *            PDF to transform.
	 * @return Either a reference to the input PDF or a new BoxedPDF with the
	 *         same properties as the input pdf.
	 * @throws UnknownPDFTypeException
	 *             Thrown in case pdf is neither a BoxedPDF nor a SamplePDF.
	 * @throws DoubleSampleException
	 * @throws ProbabilitySumNotOneException
	 * @throws FunctionNotInTimeDomainException
	 */
	IBoxedPDF transformToBoxedPDF(IProbabilityDensityFunction pdf)
			throws UnknownPDFTypeException, ProbabilitySumNotOneException,
			DoubleSampleException, FunctionNotInTimeDomainException;

	/**
	 * Converts a model object to a function object with the same attributes.
	 * 
	 * @param ePDF
	 *            Object to transform.
	 * @return New BoxedPDF instance.
	 * @throws DoubleSampleException
	 * @throws ProbabilitySumNotOneException
	 */
	IBoxedPDF transformToBoxedPDF(ProbabilityDensityFunction ePDF)
			throws ProbabilitySumNotOneException, DoubleSampleException;

	/**
	 * Converts a model object to a function object with the same attributes.
	 * 
	 * @param ePDF
	 *            Object to transform.
	 * @param randomNumberGenerator
	 * 			  Number generator to use
	 * @return New BoxedPDF instance.
	 * @throws DoubleSampleException
	 * @throws ProbabilitySumNotOneException
	 */
	IBoxedPDF transformToBoxedPDF(ProbabilityDensityFunction ePDF,
			IRandomGenerator randomNumberGenerator)
			throws ProbabilitySumNotOneException, DoubleSampleException;	
	/**
	 * Converts a function object to a model object with the same attributes.
	 * 
	 * @param pdf
	 *            Object to transform.
	 * @return New BoxedPDF instance.
	 * @throws DoubleSampleException
	 * @throws ProbabilitySumNotOneException
	 * @throws FunctionNotInTimeDomainException
	 */
	BoxedPDF transformToModelBoxedPDF(IProbabilityDensityFunction pdf)
			throws UnknownPDFTypeException, ProbabilitySumNotOneException,
			DoubleSampleException, FunctionNotInTimeDomainException;

	/**
	 * Creates a new ProbabilityMassFunction whose samples are set to 'samples'.
	 * If the samples are marked as ordered, they will be sorted and stochastic
	 * values such as median and percentile are available.
	 * 
	 * @param samples
	 *            List of samples for the PMF.
	 * @param hasOrderedDomain
	 *            Marks a set as ordered.
	 * @return New ProbabilityMassFunction instance.
	 */
	IProbabilityMassFunction createProbabilityMassFunction(
			List<ISample> samples, IUnit unit, boolean hasOrderedDomain);

	/**
	 * @param measurements
	 * @param unit
	 * @param hasOrderedDomain
	 * @return
	 */
	IProbabilityMassFunction createPMFFromMeasurements(Double[] measurements,
			double epsilon, IUnit unit, boolean hasOrderedDomain);

	/**
	 * @param measurements
	 * @param unit
	 * @param hasOrderedDomain
	 * @return
	 */
	IProbabilityMassFunction createPMFFromMeasurements(Integer[] measurements,
			IUnit unit, boolean hasOrderedDomain);

	/**
	 * @param measurements
	 * @param unit
	 * @param hasOrderedDomain
	 * @return
	 */
	IProbabilityMassFunction createPMFFromMeasurements(String[] measurements,
			IUnit unit, boolean hasOrderedDomain);

	/**
	 * @param measurements
	 * @param unit
	 * @param hasOrderedDomain
	 * @return
	 */
	IProbabilityMassFunction createPMFFromMeasurements(Boolean[] measurements,
			IUnit unit, boolean hasOrderedDomain);

	/**
	 * Converts a model object to a function object with the same attributes.
	 * 
	 * @param ePMF
	 *            Object to transform.
	 * @return New ProbabilityMassFunction instance.
	 */
	IProbabilityMassFunction transformToPMF(ProbabilityMassFunction ePMF);

	/**
	 * Converts a model object to a function object with the same attributes.
	 * 
	 * @param ePMF
	 *            Object to transform.
	 * @return New ProbabilityMassFunction instance.
	 */
	IProbabilityMassFunction transformToPMF(ProbabilityMassFunction ePMF,
			IRandomGenerator randomNumberGenerator);
	
	/**
	 * Converts a function object to a model object with the same attributes.
	 * 
	 * @param pmf
	 *            Object to transform.
	 * @return New ProbabilityMassFunction instance.
	 */
	ProbabilityMassFunction transformToModelPMF(IProbabilityMassFunction pmf);

	/**
	 * Converts a model object to a function object with the same attributes.
	 * (BoxedPDF -> IBoxedPDF, SamplePDF -> ISamplePDF)
	 * 
	 * @param ePDF
	 *            Object to transform.
	 * @return New ProbabilityDensityFunction instance.
	 * @throws DoubleSampleException
	 * @throws ProbabilitySumNotOneException
	 */
	IProbabilityDensityFunction transformToPDF(ProbabilityDensityFunction ePDF)
			throws UnknownPDFTypeException, ProbabilitySumNotOneException,
			DoubleSampleException;

	/**
	 * Converts a model object to a function object with the same attributes.
	 * (BoxedPDF -> IBoxedPDF, SamplePDF -> ISamplePDF)
	 * 
	 * @param ePDF
	 *            Object to transform.
	 * @return New ProbabilityDensityFunction instance.
	 * @throws DoubleSampleException
	 * @throws ProbabilitySumNotOneException
	 */
	IProbabilityDensityFunction transformToPDF(ProbabilityDensityFunction ePDF,
			IRandomGenerator randomNumberGenerator)
			throws UnknownPDFTypeException, ProbabilitySumNotOneException,
			DoubleSampleException;
	
	/**
	 * Converts a function object to a model object with the same attributes.
	 * 
	 * @param pdf
	 *            Object to transform.
	 * @return New ProbabilityDensityFunction instance.
	 * @throws DoubleSampleException
	 * @throws FunctionNotInTimeDomainException
	 * @throws ProbabilitySumNotOneException
	 */
	ProbabilityDensityFunction transformToModelPDF(
			IProbabilityDensityFunction pdf) throws UnknownPDFTypeException,
			DoubleSampleException, FunctionNotInTimeDomainException;
}

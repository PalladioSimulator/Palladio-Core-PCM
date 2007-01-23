package de.uka.ipd.sdq.probfunction.math;

import java.io.StringBufferInputStream;

import antlr.RecognitionException;
import antlr.TokenStreamException;
import de.uka.ipd.sdq.probfunction.BoxedPDF;
import de.uka.ipd.sdq.probfunction.ProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.SamplePDF;
import de.uka.ipd.sdq.probfunction.math.exception.ConfigurationNotSetException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInFrequencyDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInTimeDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilityFunctionException;
import de.uka.ipd.sdq.probfunction.math.exception.SizeTooSmallException;
import de.uka.ipd.sdq.probfunction.math.exception.StringNotPDFException;
import de.uka.ipd.sdq.probfunction.math.exception.UnknownPDFTypeException;
import de.uka.ipd.sdq.probfunction.math.util.MathTools;
import de.uka.ipd.sdq.probfunction.print.ProbFunctionPrettyPrint;
import de.uka.ipd.sdq.stoex.ProbabilityFunctionLiteral;
import de.uka.ipd.sdq.stoex.parser.StochasticExpressionsLexer;
import de.uka.ipd.sdq.stoex.parser.StochasticExpressionsParser;

/**
 * To be continued...
 * 
 * @author jens
 * 
 */
public class ManagedPDF {

	private IProbabilityDensityFunction pdfTimeDomain;

	private ISamplePDF samplePdfTimeDomain;

	private IBoxedPDF boxedPdfTimeDomain;

	private IProbabilityDensityFunction pdfFrequencyDomain;

	private ISamplePDF samplePdfFrequencyDomain;

	private ProbabilityDensityFunction modelPDF;

	private BoxedPDF modelBoxedPDF;

	private SamplePDF modelSamplePDF;

	private boolean useConfiguration = false;

	private String pdfAsString;

	private double meanValue;

	private ISamplePDF cumulativeDistributionFunction;

	private static IProbabilityFunctionFactory pfFactory = IProbabilityFunctionFactory.eINSTANCE;

	private ManagedPDF() {
		reset();
	}

	public ManagedPDF(ProbabilityDensityFunction pdf) {
		this();
		this.useConfiguration = false;
		setModelPdf(pdf);
	}

	public ManagedPDF(IProbabilityDensityFunction pdf) {
		this();
		this.useConfiguration = false;
		setPdf(pdf);
	}

	public ManagedPDF(IProbabilityDensityFunction pdf, boolean useConfiguration) {
		this();
		this.useConfiguration = useConfiguration;
		setPdf(pdf);
	}

	public ManagedPDF(ProbabilityDensityFunction pdf, boolean useConfiguration) {
		this();
		this.useConfiguration = useConfiguration;
		setModelPdf(pdf);
	}

	private void reset() {
		this.pdfFrequencyDomain = null;
		this.samplePdfFrequencyDomain = null;
		this.pdfTimeDomain = null;
		this.samplePdfTimeDomain = null;
		this.boxedPdfTimeDomain = null;
		this.modelPDF = null;
		this.modelBoxedPDF = null;
		this.modelSamplePDF = null;
		this.pdfAsString = null;
		this.cumulativeDistributionFunction = null;
		this.meanValue = -1;
	}

	public IProbabilityDensityFunction getPdfTimeDomain() {
		if (pdfTimeDomain == null) {
			if (modelPDF != null) {
				try {
					pdfTimeDomain = IProbabilityFunctionFactory.eINSTANCE
							.transformToPDF(modelPDF);
				} catch (ProbabilityFunctionException e) {
					e.printStackTrace();
					System.exit(1);
				}
			} else if (pdfFrequencyDomain != null)
				try {
					pdfTimeDomain = pdfFrequencyDomain
							.getInverseFourierTransform();
				} catch (FunctionNotInFrequencyDomainException e) {
					e.printStackTrace();
					System.exit(1);
				}
		}
		return pdfTimeDomain;
	}

	public IBoxedPDF getBoxedPdfTimeDomain() {
		if (this.boxedPdfTimeDomain == null) {
			try {
				this.boxedPdfTimeDomain = pfFactory
						.transformToBoxedPDF(getPdfTimeDomain());
			} catch (ProbabilityFunctionException e) {
				e.printStackTrace();
				System.exit(-1);
			}
		}
		return this.boxedPdfTimeDomain;
	}

	public ISamplePDF getSamplePdfTimeDomain() {
		if (this.samplePdfTimeDomain == null) {
			try {
				this.samplePdfTimeDomain = pfFactory
						.transformToSamplePDF(getPdfTimeDomain());
			} catch (UnknownPDFTypeException e) {
				e.printStackTrace();
				System.exit(-1);
			}
		}
		return this.samplePdfTimeDomain;

	}

	public ISamplePDF getSamplePdfFrequencyDomain() {
		if (this.samplePdfFrequencyDomain == null) {
			try {
				this.samplePdfFrequencyDomain = pfFactory
						.transformToSamplePDF(getPdfFrequencyDomain());
			} catch (UnknownPDFTypeException e) {
				e.printStackTrace();
				System.exit(-1);
			}
		}
		return this.samplePdfFrequencyDomain;
	}

	public IProbabilityDensityFunction getPdfFrequencyDomain() {
		if (pdfFrequencyDomain == null) {
			if (this.getPdfTimeDomain() != null)
				try {
					pdfFrequencyDomain = this.getPdfTimeDomain()
							.getFourierTransform();
				} catch (FunctionNotInTimeDomainException e) {
					e.printStackTrace();
					System.exit(1);
				}
		}
		return pdfFrequencyDomain;
	}

	private void setPdf(IProbabilityDensityFunction pdf) {
		reset();
		if (pdf.isInFrequencyDomain()) {
			pdfFrequencyDomain = pdf;
		} else {
			pdfTimeDomain = pdf;
		}
		adjustToConfiguration();
	}

	private void setModelPdf(ProbabilityDensityFunction pdf) {
		reset();
		this.modelPDF = pdf;
		adjustToConfiguration();
	}

	private void adjustToConfiguration() {
		try {
			if (useConfiguration) {
				try {
					PDFConfiguration config = PDFConfiguration
							.getCurrentConfiguration();
					if (config != null) {
						IProbabilityDensityFunction pdf = getPdfTimeDomain();
						ISamplePDF samplePDF = null;
						boolean changed = false;

						if (!(pdf instanceof ISamplePDF)) {
							changed = true;
							samplePDF = pfFactory.transformToSamplePDF(pdf);
						} else {
							samplePDF = (ISamplePDF) pdf;
						}

						if (!config.getUnit().equals(samplePDF.getUnit())) {
							changed = true;
							// TODO correct conversion of units!!
							samplePDF = pfFactory.createSamplePDFFromComplex(
									samplePDF.getDistance(), samplePDF
											.getValues(), false, config
											.getUnit());
						}

						if (!MathTools.equalsDouble(config.getDistance(),
								samplePDF.getDistance())) {
							changed = true;
							samplePDF = samplePDF
									.getFunctionWithNewDistance(config
											.getDistance());
						}

						if (config.getNumSamplingPoints() > samplePDF
								.numberOfSamples()) {
							changed = true;
							samplePDF.expand(config.getNumSamplingPoints());
						}

						if (changed) {
							setPdf(samplePDF);
						}
					}
				} catch (ConfigurationNotSetException e) {
					System.err.println("No configuration for pdf's found!");
				}
			}
		} catch (ProbabilityFunctionException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	public ProbabilityDensityFunction getModelPdf() {
		try {
			if (this.modelPDF == null) {
				this.modelPDF = IProbabilityFunctionFactory.eINSTANCE
						.transformToModelPDF(this.getPdfTimeDomain());
			}
		} catch (ProbabilityFunctionException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return this.modelPDF;
	}

	public boolean isComplete() {
		boolean result = false;
		if (getModelPdf().getUnit() != null) {
			result = true;
		}
		return result;
	}

	public static ManagedPDF createDiracImpulse()
			throws ConfigurationNotSetException {
		return createImpulseAt(0);
	}

	public static ManagedPDF createImpulseAt(int pos)
			throws ConfigurationNotSetException {
		PDFConfiguration config = PDFConfiguration.getCurrentConfiguration();
		IProbabilityDensityFunction pdf = pfFactory
				.createImpulseAt(pos, config.getNumSamplingPoints(), config
						.getDistance(), config.getUnit());
		return new ManagedPDF(pdf, true);
	}

	public static ManagedPDF createZeroFunction()
			throws ConfigurationNotSetException {
		PDFConfiguration config = PDFConfiguration.getCurrentConfiguration();
		IProbabilityDensityFunction pdf = pfFactory
				.createZeroFunction(config.getNumSamplingPoints(), config
						.getDistance(), config.getUnit());
		return new ManagedPDF(pdf, true);
	}

	@Override
	public String toString() {
		if (pdfAsString == null) {
			ProbabilityDensityFunction pdf = getModelBoxedPdf();
			ProbFunctionPrettyPrint pp = new ProbFunctionPrettyPrint();
			pdfAsString = (String) pp.doSwitch(pdf);
		}
		return pdfAsString;
	}

	@SuppressWarnings("deprecation")
	public static ManagedPDF createFromString(String pdfAsString)
			throws RecognitionException, TokenStreamException,
			StringNotPDFException {
		StochasticExpressionsLexer lexer = new StochasticExpressionsLexer(
				new StringBufferInputStream("=" + pdfAsString));
		StochasticExpressionsParser parser = new StochasticExpressionsParser(
				lexer);
		ProbabilityFunctionLiteral value = (ProbabilityFunctionLiteral) parser
				.expression();
		try {
			ProbabilityDensityFunction pdf = (ProbabilityDensityFunction) value
					.getFunction_ProbabilityFunctionLiteral();
			return new ManagedPDF(pdf);
		} catch (ClassCastException e) {
			throw new StringNotPDFException();
		}
	}

	public BoxedPDF getModelBoxedPdf() {
		if (modelBoxedPDF == null) {
			try {
				modelBoxedPDF = pfFactory
						.transformToModelBoxedPDF(getBoxedPdfTimeDomain());
			} catch (ProbabilityFunctionException e) {
				e.printStackTrace();
				System.exit(-1);
			}
		}
		return modelBoxedPDF;
	}

	public SamplePDF getModelSamplePDF() {
		if (modelSamplePDF == null) {
			try {
				modelSamplePDF = pfFactory
						.transformToModelSamplePDF(getSamplePdfTimeDomain());
			} catch (UnknownPDFTypeException e) {
				e.printStackTrace();
				System.exit(-1);
			}
		}
		return modelSamplePDF;
	}

	public double getMeanValue() {
		if (this.meanValue < 0) {
			try {
				meanValue = this.getPdfTimeDomain().getArithmeticMeanValue();
			} catch (ProbabilityFunctionException e) {
				e.printStackTrace();
				System.exit(-1);
			}
		}
		return meanValue;
	}

	public ISamplePDF getCumulativeDistributionFunction() {
		if (this.cumulativeDistributionFunction == null) {
			try {
				this.cumulativeDistributionFunction = (ISamplePDF) this
						.getSamplePdfTimeDomain().getCumulativeFunction();
			} catch (FunctionNotInTimeDomainException e) {
				e.printStackTrace();
				System.exit(-1);
			}
		}
		return this.cumulativeDistributionFunction;
	}

	public double probEquals(ManagedPDF pdf) {
		try {
			return getSamplePdfTimeDomain().probabilisticEquals(
					pdf.getSamplePdfTimeDomain());
		} catch (ProbabilityFunctionException e) {
			e.printStackTrace();
			System.exit(-1);
			return -1;
		}
	}

	public double probGreaterThan(ManagedPDF pdf) {
		ISamplePDF cdfA = this.getCumulativeDistributionFunction();
		ISamplePDF pdfA = this.getSamplePdfTimeDomain();
		int size = pdfA.getValues().size();
		double distance = pdfA.getDistance();
		pdf.adjustPDF(distance, size);
		ISamplePDF pdfB = pdf.getSamplePdfTimeDomain();

		double prob = 0;
		for (int i = 0; i < size; i++) {
			prob += pdfB.getValueAsDouble(i)
					* (1 - cdfA.getValueAsDouble(i));
		}
		return prob;
	}

	public double probGreaterOrEqualThan(ManagedPDF pdf) {
		ISamplePDF pdfA = this.getSamplePdfTimeDomain();
		ISamplePDF cdfA = this.getCumulativeDistributionFunction();
		int size = pdfA.getValues().size();
		double distance = pdfA.getDistance();
		pdf.adjustPDF( distance, size);
		ISamplePDF pdfB = pdf.getSamplePdfTimeDomain();

		double prob = 0;
		for (int i = 0; i < size; i++) {
			prob += pdfB.getValueAsDouble(i)
					* (1 - cdfA.getValueAsDouble(i) + pdfA.getValueAsDouble(i));
		}
		return prob;
	}
	
	public double probLessThan(ManagedPDF pdf) {
		return pdf.probGreaterThan(this);
	}

	public void adjustPDF(double distance, int size) {
		try {
			ISamplePDF sPDF = this.getSamplePdfTimeDomain();
			
			sPDF = sPDF.getFunctionWithNewDistance(distance);
			if (size > sPDF.getValues().size()) {
				sPDF.expand(size);
			}
			this.setPdf(sPDF);
		} catch (ProbabilityFunctionException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return new ManagedPDF(this.getPdfTimeDomain());
	}
	
	public boolean usesConfiguration(){
		return this.useConfiguration;
	}

}

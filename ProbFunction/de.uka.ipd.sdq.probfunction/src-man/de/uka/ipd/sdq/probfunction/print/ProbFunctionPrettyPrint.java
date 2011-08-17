package de.uka.ipd.sdq.probfunction.print;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

import de.uka.ipd.sdq.probfunction.BoxedPDF;
import de.uka.ipd.sdq.probfunction.ContinuousSample;
import de.uka.ipd.sdq.probfunction.ExponentialDistribution;
import de.uka.ipd.sdq.probfunction.GammaDistribution;
import de.uka.ipd.sdq.probfunction.LognormalDistribution;
import de.uka.ipd.sdq.probfunction.NormalDistribution;
import de.uka.ipd.sdq.probfunction.ProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.Sample;
import de.uka.ipd.sdq.probfunction.util.ProbfunctionSwitch;

public class ProbFunctionPrettyPrint extends ProbfunctionSwitch<String> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.probfunction.util.ProbfunctionSwitch#caseBoxedPDF(de.uka.ipd.sdq.probfunction.BoxedPDF)
	 */
	@Override
	public String caseBoxedPDF(BoxedPDF object) {
		String sampleString = "";
		for (ContinuousSample s : (List<ContinuousSample>) object.getSamples()) {
			double value = s.getProbability();
			//double precision = 0.00001;
			double precision = 0.00000001;
			
			value *= 1 / precision;
			long temp = Math.round(value);
			double prob = temp * precision;
			DecimalFormat df = new DecimalFormat("0.00000000", new DecimalFormatSymbols(Locale.US));
			
			sampleString += " (" + s.getValue() + "; " + df.format(prob)
					+ ")";
		}
		
		return "DoublePDF[" + sampleString + " ]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.probfunction.util.ProbfunctionSwitch#caseProbabilityMassFunction(de.uka.ipd.sdq.probfunction.ProbabilityMassFunction)
	 */
	@Override
	public String caseProbabilityMassFunction(ProbabilityMassFunction object) {
		Sample sample = (Sample)object.getSamples().get(0);
		
		String pmfType = detectType(sample);
		String sampleString = "";
		String leftSeparator = "";
		String rightSeparator = ";";

		if (pmfType.equals("EnumPMF")) {
			leftSeparator = "\"";
			rightSeparator = "\";";
		}
		
		for (Sample s : (List<Sample>) object.getSamples()) {
			sampleString += " (" + leftSeparator + s.getValue() 
			+ rightSeparator + s.getProbability() + ")";
		}
		return pmfType + "[" + sampleString + " ]";
	}
	
	@Override
	public String caseExponentialDistribution(ExponentialDistribution object) {
		return "Exp("+object.getRate()+")";
	}
	


	@Override
	public String caseGammaDistribution(GammaDistribution object) {
		return "Gamma("+object.getAlpha()+", "+object.getTheta()+")";
	}

	@Override
	public String caseLognormalDistribution(LognormalDistribution object) {
		return "Lognorm("+object.getMu()+", "+object.getSigma()+")";
	}

	@Override
	public String caseNormalDistribution(NormalDistribution object) {
		return "Norm("+object.getMu()+", "+object.getSigma()+")";
	}

	private String detectType(Sample object) {
		if (object.getValue() instanceof Integer)
			return "IntPMF";
		if (object.getValue() instanceof Double)
			return "DoublePMF";
		if (object.getValue().equals("true") || object.getValue().equals("false") || object.getValue() instanceof Boolean)
			return "BoolPMF";
		if (object.getValue() instanceof String)
			return "EnumPMF";
		throw new UnsupportedOperationException("Unknown PMF found!");
	}

}

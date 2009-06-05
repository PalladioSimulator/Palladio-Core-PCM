package de.uka.ipd.sdq.probfunction.print;

import java.util.List;

import de.uka.ipd.sdq.probfunction.BoxedPDF;
import de.uka.ipd.sdq.probfunction.ContinuousSample;
import de.uka.ipd.sdq.probfunction.ProbabilityFunction;
import de.uka.ipd.sdq.probfunction.ProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.Sample;
import de.uka.ipd.sdq.probfunction.util.ProbfunctionSwitch;

public class ProbFunctionCSVPrint extends ProbfunctionSwitch<String> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.probfunction.util.ProbfunctionSwitch#caseBoxedPDF(de.uka.ipd.sdq.probfunction.BoxedPDF)
	 */
	/**
	 * Prints a {@link ProbabilityFunction} as comma separated values using the generated EMF visitor.  
	 */
	@Override
	public String caseBoxedPDF(BoxedPDF object) {
		String sampleString = "";
		for (ContinuousSample s : (List<ContinuousSample>) object.getSamples()) {
			double value = s.getProbability();
			//double precision = 0.00001;
			//double precision = 0.00000001;
			
			/*value *= 1 / precision;
			long temp = Math.round(value);
			double prob = temp * precision;
			DecimalFormat df = new DecimalFormat("0.00000000", new DecimalFormatSymbols(Locale.US));*/
			
			//sampleString += " (" + s.getValue() + "; " + df.format(prob)
			sampleString += s.getValue() + ";" + value + "\n";
		}
		
		return sampleString;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.probfunction.util.ProbfunctionSwitch#caseProbabilityMassFunction(de.uka.ipd.sdq.probfunction.ProbabilityMassFunction)
	 */
	@Override
	public String caseProbabilityMassFunction(ProbabilityMassFunction object) {
	
		String sampleString = "";
		String leftSeparator = "";
		String rightSeparator = ";";

		
		for (Sample s : (List<Sample>) object.getSamples()) {
			sampleString += leftSeparator + s.getValue() 
			+ rightSeparator + s.getProbability() + "\n";
		}
		return sampleString;
	}



}

package de.uka.ipd.sdq.pcm.stochasticexpressions;

import java.util.Iterator;
import java.util.List;

import de.uka.ipd.sdq.probfunction.BoxedPDF;
import de.uka.ipd.sdq.probfunction.ProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.Sample;
import de.uka.ipd.sdq.probfunction.util.ProbfunctionSwitch;

public class ProbFunctionPrettyPrint extends ProbfunctionSwitch {

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.probfunction.util.ProbfunctionSwitch#caseBoxedPDF(de.uka.ipd.sdq.probfunction.BoxedPDF)
	 */
	@Override
	public Object caseBoxedPDF(BoxedPDF object) {
		// TODO Auto-generated method stub
		return super.caseBoxedPDF(object);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.probfunction.util.ProbfunctionSwitch#caseProbabilityMassFunction(de.uka.ipd.sdq.probfunction.ProbabilityMassFunction)
	 */
	@Override
	public Object caseProbabilityMassFunction(ProbabilityMassFunction object) {
		String pmfType = detectType((Sample)object.getSamples().get(0));
		String sampleString = "";
		for (Sample s : (List<Sample>)object.getSamples())
	    {
	    	sampleString += " ("+s.getProbability()+"; "+s.getValue()+")";
	    }
		return pmfType + "[" + sampleString + " ]";
	}

	private String detectType(Sample object) {
		if (object.getValue() instanceof Integer)
			return "IntRandomVar";
		if (object.getValue() instanceof Double)
			return "RealRandomVar";
		if (object.getValue() instanceof String)
			return "EnumRandomVar";
		throw new UnsupportedOperationException("Unknown PMF found!");
	}

}

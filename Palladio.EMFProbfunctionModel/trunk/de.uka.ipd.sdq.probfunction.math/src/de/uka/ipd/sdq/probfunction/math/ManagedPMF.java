package de.uka.ipd.sdq.probfunction.math;

import java.util.Iterator;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import de.uka.ipd.sdq.probfunction.ProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.exception.StringNotPDFException;
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
public class ManagedPMF {

	private IProbabilityFunctionFactory pfFactory = IProbabilityFunctionFactory.eINSTANCE;

	private IProbabilityMassFunction pmfTimeDomain;

	private ProbabilityMassFunction modelPmf;

	private String pmfAsString;

	private ManagedPMF() {
		reset();
	}

	public ManagedPMF(IProbabilityMassFunction pmf) {
		this();
		pmfTimeDomain = pmf;
	}

	public ManagedPMF(ProbabilityMassFunction modelPMF) {
		this();
		this.modelPmf = modelPMF;
	}

	private void reset() {
		pmfTimeDomain = null;
		modelPmf = null;
		pmfAsString = null;
	}

	public IProbabilityMassFunction getPmfTimeDomain() {
		if (pmfTimeDomain == null) {
			pmfTimeDomain = pfFactory.transformToPMF(modelPmf);
		}
		return pmfTimeDomain;
	}

	public ProbabilityMassFunction getModelPmf() {
		if (modelPmf == null) {
			modelPmf = pfFactory.transformToModelPMF(pmfTimeDomain);
		}
		return modelPmf;
	}

	@Override
	public String toString() {
		if (pmfAsString == null) {
			ProbabilityMassFunction pmf = getModelPmf();
			ProbFunctionPrettyPrint pp = new ProbFunctionPrettyPrint();
			pmfAsString = (String) pp.doSwitch(pmf);
		}
		return pmfAsString;
	}

	@SuppressWarnings("unchecked")
	public Object getMaxValue() {
		IProbabilityMassFunction pmf = getPmfTimeDomain();
		if (pmf.hasOrderedDomain()) {
			Object max = null;
			for (Iterator iter = pmf.getSamples().iterator(); iter.hasNext();) {
				ISample sample = (ISample) iter.next();
				Object obj = sample.getValue();
				if ((max == null) || ( ((Comparable)max).compareTo(obj) < 0)) {
					max = obj;
				}
			}
			return max;
		} else {
			return null;
		}
	}

	public Long getExpectedValue() {
		IProbabilityMassFunction pmf = getPmfTimeDomain();
		List<ISample> sampleList = pmf.getSamples();
		double result = 0.0;
		for (ISample sample : sampleList){
			Integer value = (Integer)sample.getValue();
			result += value.doubleValue() * sample.getProbability();
		}
		return new Long(Math.round(result));
	}
	
	
	private static ProbabilityFunctionLiteral parse(String s) throws RecognitionException {
		try{
			int iterInt = Integer.parseInt(s);
			s = "IntPMF[("+iterInt+";1.0)]";
		}
		catch(NumberFormatException e){
		}
		
		StochasticExpressionsLexer lexer = new StochasticExpressionsLexer(
				new ANTLRStringStream(s));
		StochasticExpressionsParser parser = new StochasticExpressionsParser(
				new CommonTokenStream(lexer));
		return (ProbabilityFunctionLiteral)parser.expression();
	}
	
	@SuppressWarnings("deprecation")
	public static ManagedPMF createFromString(String pmfAsString)
			throws RecognitionException,
			StringNotPDFException {
		ProbabilityFunctionLiteral value = parse(pmfAsString);
		try {
			ProbabilityMassFunction pmf = (ProbabilityMassFunction) value
					.getFunction_ProbabilityFunctionLiteral();
			return new ManagedPMF(pmf);
		} catch (ClassCastException e) {
			throw new StringNotPDFException();
		}
	}
}

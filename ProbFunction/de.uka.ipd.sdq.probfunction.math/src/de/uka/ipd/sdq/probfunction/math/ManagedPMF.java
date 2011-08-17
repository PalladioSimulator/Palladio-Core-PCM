package de.uka.ipd.sdq.probfunction.math;

import java.io.StringBufferInputStream;
import java.util.Comparator;
import java.util.Iterator;

import antlr.RecognitionException;
import antlr.TokenStreamException;
import de.uka.ipd.sdq.probfunction.ProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.exception.StringNotPDFException;
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

	@SuppressWarnings("deprecation")
	public static ManagedPMF createFromString(String pmfAsString)
			throws RecognitionException, TokenStreamException,
			StringNotPDFException {
		StochasticExpressionsLexer lexer = new StochasticExpressionsLexer(
				new StringBufferInputStream("=" + pmfAsString));
		StochasticExpressionsParser parser = new StochasticExpressionsParser(
				lexer);
		ProbabilityFunctionLiteral value = (ProbabilityFunctionLiteral) parser
				.expression();
		try {
			ProbabilityMassFunction pmf = (ProbabilityMassFunction) value
					.getFunction_ProbabilityFunctionLiteral();
			return new ManagedPMF(pmf);
		} catch (ClassCastException e) {
			throw new StringNotPDFException();
		}
	}
}

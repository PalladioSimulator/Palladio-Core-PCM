package de.uka.ipd.sdq.simucomframework.variables.cache;

import java.io.StringReader;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.PCMStoExLexer;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.PCMStoExParser;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunction;
import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.analyser.visitors.ExpressionInferTypeVisitor;
import de.uka.ipd.sdq.stoex.analyser.visitors.NonProbabilisticExpressionInferTypeVisitor;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;
import de.uka.ipd.sdq.stoex.parser.StochasticExpressionsLexer;

public class StoExCacheEntry {

	private String spec;
	private Expression parsedExpression;
	private ExpressionInferTypeVisitor typeInferer;
	private ProbFunctionCache probFunctionCache;

	public StoExCacheEntry(String spec) {
		this.spec = spec;
		PCMStoExLexer lexer = new PCMStoExLexer(
				new ANTLRStringStream(spec));
		Expression formula = null;
		try {
			formula = new PCMStoExParser(new CommonTokenStream(lexer)).expression();
		} catch (RecognitionException e) {
			throw new RuntimeException("Expression not parsable \""+spec+"\"",e);
		} catch (Exception e) {
			throw new RuntimeException("Expression not parsable \""+spec+"\"",e);
		}
		try {
			typeInferer = new NonProbabilisticExpressionInferTypeVisitor();
			typeInferer.doSwitch(formula);
		} catch (Exception e) {
			throw new RuntimeException("Expression not parsable \""+spec+"\"",e);
		}
		this.parsedExpression = formula;
		this.probFunctionCache = new ProbFunctionCache(formula);
	}

	public Expression getParsedExpression() {
		return parsedExpression;
	}

	public String getSpec() {
		return spec;
	}

	public ExpressionInferTypeVisitor getTypeInferer() {
		return typeInferer;
	}

	public TypeEnum getInferedType(Expression e) {
		return typeInferer.getType(e);
	}

	public ProbFunctionCache getProbFunctionCache() {
		return probFunctionCache;
	}

	public IProbabilityFunction getProbFunction(EObject e) {
		return probFunctionCache.getProbFunction(e);
	}
}

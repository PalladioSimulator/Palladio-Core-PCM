package de.uka.ipd.sdq.simucomframework.variables.cache;

import java.util.Iterator;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.ErrorEntry;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.MyPCMStoExParser;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.PCMStoExLexer;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunction;
import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.analyser.visitors.ExpressionInferTypeVisitor;
import de.uka.ipd.sdq.stoex.analyser.visitors.NonProbabilisticExpressionInferTypeVisitor;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;

/**
 * An entry in the stoex cache containing all information given by parsing and
 * analysing the stoex
 * @author Steffen Becker
 *
 */
/**
 * @author Steffen Becker
 *
 */
public class StoExCacheEntry {

    private final String spec;
    private final Expression parsedExpression;
    private final ExpressionInferTypeVisitor typeInferer;
    private final ProbFunctionCache probFunctionCache;

    /**
     * Parse the expression and store its AST as well as its infered types
     * 
     * @param spec
     *            The stoex to parse and store
     */
    public StoExCacheEntry(String spec) {
        this.spec = spec;
        PCMStoExLexer lexer = new PCMStoExLexer(new ANTLRStringStream(spec));
        Expression formula = null;
        try {
            MyPCMStoExParser parser = new MyPCMStoExParser(new CommonTokenStream(lexer));
            formula = parser.expression();
            if (parser.hasErrors()) {
                for (ErrorEntry error : parser.getErrors()) {
                    throw new RuntimeException("Expression not parsable \"" + spec + "\"", error.getEx());
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Expression not parsable \"" + spec + "\"", e);
        }
        try {
            typeInferer = new NonProbabilisticExpressionInferTypeVisitor();
            typeInferer.doSwitch(formula);
        } catch (Exception e) {
            throw new RuntimeException("Expression not parsable \"" + spec + "\"", e);
        }
        this.parsedExpression = formula;
        this.probFunctionCache = new ProbFunctionCache(formula);
    }

    /**
     * @return The AST of the cached stoex
     */
    public Expression getParsedExpression() {
        return parsedExpression;
    }

    /**
     * @return Original stoex as string
     */
    public String getSpec() {
        return spec;
    }

    /**
     * @return Type inferer for this stoex
     */
    public ExpressionInferTypeVisitor getTypeInferer() {
        return typeInferer;
    }

    /**
     * @param e
     *            Return the infered type of the given subexpression of this stoex
     * @return The type of the given subexpression or null if the subexpression is not part of this
     *         stoex
     */
    public TypeEnum getInferedType(Expression e) {
        return typeInferer.getType(e);
    }

    /**
     * @return Probfunction cache used to cache the probfunctions of this stoex
     */
    public ProbFunctionCache getProbFunctionCache() {
        return probFunctionCache;
    }

    /**
     * Get the probfunction from the probfunction cache
     * 
     * @param e
     *            A subexpression which represents a probfunction literal
     * @return The probfunction for the given subexpression
     */
    public IProbabilityFunction getProbFunction(EObject e) {
        assert contains(getParsedExpression().eAllContents(), e);
        return probFunctionCache.getProbFunction(e);
    }

    private boolean contains(Iterator<EObject> i, EObject e) {
        while (i.hasNext()) {
            EObject n = i.next();
            if (n == e)
                return true;
        }
        return false;
    }
}

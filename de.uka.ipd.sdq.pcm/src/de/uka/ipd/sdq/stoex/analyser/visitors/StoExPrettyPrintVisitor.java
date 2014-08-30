package de.uka.ipd.sdq.stoex.analyser.visitors;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import de.uka.ipd.sdq.probfunction.print.ProbFunctionPrettyPrint;
import de.uka.ipd.sdq.stoex.BoolLiteral;
import de.uka.ipd.sdq.stoex.BooleanOperatorExpression;
import de.uka.ipd.sdq.stoex.CompareExpression;
import de.uka.ipd.sdq.stoex.DoubleLiteral;
import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.FunctionLiteral;
import de.uka.ipd.sdq.stoex.IfElseExpression;
import de.uka.ipd.sdq.stoex.IntLiteral;
import de.uka.ipd.sdq.stoex.NamespaceReference;
import de.uka.ipd.sdq.stoex.NegativeExpression;
import de.uka.ipd.sdq.stoex.NotExpression;
import de.uka.ipd.sdq.stoex.Parenthesis;
import de.uka.ipd.sdq.stoex.PowerExpression;
import de.uka.ipd.sdq.stoex.ProbabilityFunctionLiteral;
import de.uka.ipd.sdq.stoex.ProductExpression;
import de.uka.ipd.sdq.stoex.StringLiteral;
import de.uka.ipd.sdq.stoex.TermExpression;
import de.uka.ipd.sdq.stoex.Variable;
import de.uka.ipd.sdq.stoex.VariableReference;
import de.uka.ipd.sdq.stoex.util.StoexSwitch;

/**
 * @deprecated Since StoEx migration to Xtext
 */
@Deprecated
public class StoExPrettyPrintVisitor extends StoexSwitch<StringBuilder> {
    
    protected static final int AVERAGE_STOEX_SIZE = 30;
    protected final StringBuilder resultBuilder = new StringBuilder(AVERAGE_STOEX_SIZE);
    protected final static DecimalFormat df = new DecimalFormat("#0.0###########", new DecimalFormatSymbols(Locale.US));


    @Override
	public StringBuilder caseBoolLiteral(BoolLiteral object) {
		resultBuilder.append(object.isValue() ? "true" : "false");
		return resultBuilder;
	}

	@Override
	public StringBuilder casePowerExpression(PowerExpression object) {
	    doSwitch(object.getBase());
	    resultBuilder.append(" ^ ");
	    doSwitch(object.getExponent());
		return resultBuilder;
	}

	@Override
	public StringBuilder caseStringLiteral(StringLiteral object) {
	    resultBuilder.append("\"");
	    resultBuilder.append(object.getValue());
	    resultBuilder.append("\"");
		return resultBuilder;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.util.StochasticsSwitch#caseCompareExpression(de.uka.ipd.sdq.pcm.core.stochastics.CompareExpression)
	 */
	@Override
	public StringBuilder caseCompareExpression(CompareExpression object) {
		String op;
		switch(object.getOperation())
		{
		case EQUALS:
			op = " == ";
			break;
		case GREATER:
			op = " > ";
			break;
		case GREATEREQUAL:
			op = " >= ";
			break;
		case LESS: 
			op = " < ";
			break;
		case LESSEQUAL:
			op = " <= ";
			break;
		case NOTEQUAL:
			op = " <> ";
			break;
		default:
		    throw new RuntimeException("Unsupported StoEx comparison detected.");
		}
		doSwitch(object.getLeft());
		resultBuilder.append(op);
		doSwitch(object.getRight());
		return resultBuilder;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.util.StochasticsSwitch#caseDoubleLiteral(de.uka.ipd.sdq.pcm.core.stochastics.DoubleLiteral)
	 */
	@Override
	public StringBuilder caseDoubleLiteral(DoubleLiteral object) {
		resultBuilder.append(df.format(object.getValue()));
		return resultBuilder;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.util.StochasticsSwitch#caseIntLiteral(de.uka.ipd.sdq.pcm.core.stochastics.IntLiteral)
	 */
	@Override
	public StringBuilder caseIntLiteral(IntLiteral object) {
		resultBuilder.append(Integer.toString(object.getValue()));
		return resultBuilder;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.util.StochasticsSwitch#caseParantesis(de.uka.ipd.sdq.pcm.core.stochastics.Parantesis)
	 */
	@Override
	public StringBuilder caseParenthesis(Parenthesis object) {
	    resultBuilder.append("(");
	    resultBuilder.append(doSwitch(object.getInnerExpression()));
	    resultBuilder.append(")");
	    return resultBuilder;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.util.StochasticsSwitch#caseProbabilityFunctionLiteral(de.uka.ipd.sdq.pcm.core.stochastics.ProbabilityFunctionLiteral)
	 */
	@Override
	public StringBuilder caseProbabilityFunctionLiteral(ProbabilityFunctionLiteral object) {
	    new ProbFunctionPrettyPrint(resultBuilder).doSwitch(object.getFunction_ProbabilityFunctionLiteral());
		return resultBuilder;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.util.StochasticsSwitch#caseProductExpression(de.uka.ipd.sdq.pcm.core.stochastics.ProductExpression)
	 */
	@Override
	public StringBuilder caseProductExpression(ProductExpression object) {
		String op;
		switch(object.getOperation())
		{
		case MULT:
			op = " * ";
			break;
		case MOD:
			op = " % ";
			break;
		case DIV:
			op = " / ";
			break;
		default:
		    throw new RuntimeException("Unknown operator found in StoEx!");
		}
		doSwitch(object.getLeft());
		resultBuilder.append(op);
		doSwitch(object.getRight());
		return resultBuilder;	
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.util.StochasticsSwitch#caseTermExpression(de.uka.ipd.sdq.pcm.core.stochastics.TermExpression)
	 */
	@Override
	public StringBuilder caseTermExpression(TermExpression object) {
		String op;
		switch(object.getOperation())
		{
		case ADD:
			op = " + ";
			break;
		case SUB:
			op = " - ";
			break;
		default:
            throw new RuntimeException("Unknown operator found in StoEx!");
		}
        doSwitch(object.getLeft());
        resultBuilder.append(op);
        doSwitch(object.getRight());
        return resultBuilder;    
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.parameter.util.ParameterSwitch#caseNamespaceReference(de.uka.ipd.sdq.pcm.parameter.NamespaceReference)
	 */
	@Override
	public StringBuilder caseNamespaceReference(NamespaceReference object) {
	    resultBuilder.append(object.getReferenceName());
	    resultBuilder.append(".");
	    doSwitch(object.getInnerReference_NamespaceReference());
	    return resultBuilder;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.parameter.util.ParameterSwitch#caseVariableReference(de.uka.ipd.sdq.pcm.parameter.VariableReference)
	 */
	@Override
	public StringBuilder caseVariableReference(VariableReference object) {
	    resultBuilder.append(object.getReferenceName());
		return resultBuilder;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.util.StochasticsSwitch#caseVariable(de.uka.ipd.sdq.pcm.core.stochastics.Variable)
	 */
	@Override
	public StringBuilder caseVariable(Variable object) {
		doSwitch(object.getId_Variable());
		return resultBuilder;
	}

	@Override
	public StringBuilder caseBooleanOperatorExpression(BooleanOperatorExpression object) {
		this.doSwitch(object.getLeft());
		resultBuilder.append(" ");
		resultBuilder.append(object.getOperation().getLiteral());
		resultBuilder.append(" ");
		this.doSwitch(object.getRight());
		return resultBuilder;
	}

	@Override
	public StringBuilder caseNegativeExpression(NegativeExpression object) {
	    resultBuilder.append("-");
	    this.doSwitch(object.getInner());
		return resultBuilder;
	}

	@Override
	public StringBuilder caseNotExpression(NotExpression object) {
	    resultBuilder.append("NOT ");
	    this.doSwitch(object.getInner());
	    return resultBuilder;
	}

	@Override
	public StringBuilder caseFunctionLiteral(FunctionLiteral object) {
	    resultBuilder.append(object.getId());
	    resultBuilder.append("(");

	    if (object.getParameters_FunctionLiteral().size() > 0) {
    		for (Expression parameter : object.getParameters_FunctionLiteral()) {
    		    this.doSwitch(parameter);
    		    resultBuilder.append(", ");
    		}
    		resultBuilder.delete(resultBuilder.length() - 2, resultBuilder.length());
	    }
        resultBuilder.append(")");

		return resultBuilder;
	}

	@Override
	public StringBuilder caseIfElseExpression(IfElseExpression object) {
	    this.doSwitch(object.getConditionExpression());
	    resultBuilder.append(" ? ");
	    this.doSwitch(object.getIfExpression());
	    resultBuilder.append(" : ");
	    this.doSwitch(object.getElseExpression());
		return  resultBuilder;
	}
	
}

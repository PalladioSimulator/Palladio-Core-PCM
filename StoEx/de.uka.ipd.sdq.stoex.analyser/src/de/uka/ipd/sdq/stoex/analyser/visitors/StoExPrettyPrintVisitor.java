package de.uka.ipd.sdq.stoex.analyser.visitors;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import org.eclipse.emf.ecore.EObject;

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

public class StoExPrettyPrintVisitor extends StoexSwitch<String> {
    
    private static final int AVERAGE_STOEX_SIZE = 30;
    private final StringBuilder resultBuilder = new StringBuilder(AVERAGE_STOEX_SIZE);
    private final static DecimalFormat df = new DecimalFormat("#0.0###########", new DecimalFormatSymbols(Locale.US));


    @Override
	public String caseBoolLiteral(BoolLiteral object) {
		resultBuilder.append(object.isValue() ? "true" : "false");
		return resultBuilder.toString();
	}

	@Override
	public String casePowerExpression(PowerExpression object) {
	    doSwitch(object.getBase());
	    resultBuilder.append(" ^ ");
	    doSwitch(object.getExponent());
		return resultBuilder.toString();
	}

	@Override
	public String caseStringLiteral(StringLiteral object) {
	    resultBuilder.append("\"");
	    resultBuilder.append(object.getValue());
	    resultBuilder.append("\"");
		return resultBuilder.toString();
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.util.StochasticsSwitch#caseCompareExpression(de.uka.ipd.sdq.pcm.core.stochastics.CompareExpression)
	 */
	@Override
	public String caseCompareExpression(CompareExpression object) {
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
		return resultBuilder.toString();
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.util.StochasticsSwitch#caseDoubleLiteral(de.uka.ipd.sdq.pcm.core.stochastics.DoubleLiteral)
	 */
	@Override
	public String caseDoubleLiteral(DoubleLiteral object) {
		resultBuilder.append(df.format(object.getValue()));
		return resultBuilder.toString();
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.util.StochasticsSwitch#caseIntLiteral(de.uka.ipd.sdq.pcm.core.stochastics.IntLiteral)
	 */
	@Override
	public String caseIntLiteral(IntLiteral object) {
		resultBuilder.append(Integer.toString(object.getValue()));
		return resultBuilder.toString();
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.util.StochasticsSwitch#caseParantesis(de.uka.ipd.sdq.pcm.core.stochastics.Parantesis)
	 */
	@Override
	public String caseParenthesis(Parenthesis object) {
	    resultBuilder.append("(");
	    resultBuilder.append(doSwitch(object.getInnerExpression()));
	    resultBuilder.append(")");
	    return resultBuilder.toString();
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.util.StochasticsSwitch#caseProbabilityFunctionLiteral(de.uka.ipd.sdq.pcm.core.stochastics.ProbabilityFunctionLiteral)
	 */
	@Override
	public String caseProbabilityFunctionLiteral(ProbabilityFunctionLiteral object) {
		return new ProbFunctionPrettyPrint(resultBuilder).doSwitch(object.getFunction_ProbabilityFunctionLiteral());
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.util.StochasticsSwitch#caseProductExpression(de.uka.ipd.sdq.pcm.core.stochastics.ProductExpression)
	 */
	@Override
	public String caseProductExpression(ProductExpression object) {
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
		return resultBuilder.toString();	
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.util.StochasticsSwitch#caseTermExpression(de.uka.ipd.sdq.pcm.core.stochastics.TermExpression)
	 */
	@Override
	public String caseTermExpression(TermExpression object) {
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
        return resultBuilder.toString();    
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.parameter.util.ParameterSwitch#caseNamespaceReference(de.uka.ipd.sdq.pcm.parameter.NamespaceReference)
	 */
	@Override
	public String caseNamespaceReference(NamespaceReference object) {
	    resultBuilder.append(object.getReferenceName());
	    resultBuilder.append(".");
	    doSwitch(object.getInnerReference_NamespaceReference());
	    return resultBuilder.toString();
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.parameter.util.ParameterSwitch#caseVariableReference(de.uka.ipd.sdq.pcm.parameter.VariableReference)
	 */
	@Override
	public String caseVariableReference(VariableReference object) {
	    resultBuilder.append(object.getReferenceName());
		return resultBuilder.toString();
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.util.StochasticsSwitch#caseVariable(de.uka.ipd.sdq.pcm.core.stochastics.Variable)
	 */
	@Override
	public String caseVariable(Variable object) {
		doSwitch(object.getId_Variable());
		return resultBuilder.toString();
	}

	public String prettyPrint(EObject theObject) {
		return doSwitch(theObject);
	}

	@Override
	public String caseBooleanOperatorExpression(BooleanOperatorExpression object) {
		this.doSwitch(object.getLeft());
		resultBuilder.append(" ");
		resultBuilder.append(object.getOperation().getLiteral());
		resultBuilder.append(" ");
		this.doSwitch(object.getRight());
		return resultBuilder.toString();
	}

	@Override
	public String caseNegativeExpression(NegativeExpression object) {
	    resultBuilder.append("-");
	    this.doSwitch(object.getInner());
		return resultBuilder.toString();
	}

	@Override
	public String caseNotExpression(NotExpression object) {
	    resultBuilder.append("NOT ");
	    this.doSwitch(object.getInner());
	    return resultBuilder.toString();
	}

	@Override
	public String caseFunctionLiteral(FunctionLiteral object) {
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

		return resultBuilder.toString();
	}

	@Override
	public String caseIfElseExpression(IfElseExpression object) {
	    this.doSwitch(object.getConditionExpression());
	    resultBuilder.append(" ? ");
	    this.doSwitch(object.getIfExpression());
	    resultBuilder.append(" : ");
	    this.doSwitch(object.getElseExpression());
		return  resultBuilder.toString();
	}
	
}

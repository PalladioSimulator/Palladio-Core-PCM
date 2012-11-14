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
	@Override
	public String caseBoolLiteral(BoolLiteral object) {
		return object.isValue() ? "true" : "false";
	}

	@Override
	public String casePowerExpression(PowerExpression object) {
		return ((String)doSwitch(object.getBase()))+" ^ "+((String)doSwitch(object.getExponent()));
	}

	@Override
	public String caseStringLiteral(StringLiteral object) {
		return "\""+object.getValue()+"\"";
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.util.StochasticsSwitch#caseCompareExpression(de.uka.ipd.sdq.pcm.core.stochastics.CompareExpression)
	 */
	@Override
	public String caseCompareExpression(CompareExpression object) {
		String op = "";
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
		}
		return ((String)doSwitch(object.getLeft()))+op+((String)doSwitch(object.getRight()));
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.util.StochasticsSwitch#caseDoubleLiteral(de.uka.ipd.sdq.pcm.core.stochastics.DoubleLiteral)
	 */
	@Override
	public String caseDoubleLiteral(DoubleLiteral object) {
		DecimalFormat df = new DecimalFormat("#0.0###########", new DecimalFormatSymbols(Locale.US));
		//DecimalFormat df = new DecimalFormat("#0.0#", new DecimalFormatSymbols(Locale.US));
		return df.format(object.getValue());
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.util.StochasticsSwitch#caseIntLiteral(de.uka.ipd.sdq.pcm.core.stochastics.IntLiteral)
	 */
	@Override
	public String caseIntLiteral(IntLiteral object) {
		return Integer.toString(object.getValue());
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.util.StochasticsSwitch#caseParantesis(de.uka.ipd.sdq.pcm.core.stochastics.Parantesis)
	 */
	@Override
	public String caseParenthesis(Parenthesis object) {
		return "( " + (String)doSwitch(object.getInnerExpression())+" )";
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.util.StochasticsSwitch#caseProbabilityFunctionLiteral(de.uka.ipd.sdq.pcm.core.stochastics.ProbabilityFunctionLiteral)
	 */
	@Override
	public String caseProbabilityFunctionLiteral(ProbabilityFunctionLiteral object) {
		return new ProbFunctionPrettyPrint().doSwitch(object.getFunction_ProbabilityFunctionLiteral());
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.util.StochasticsSwitch#caseProductExpression(de.uka.ipd.sdq.pcm.core.stochastics.ProductExpression)
	 */
	@Override
	public String caseProductExpression(ProductExpression object) {
		String op = "";
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
		}
		return ((String)doSwitch(object.getLeft()))+op+((String)doSwitch(object.getRight()));	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.util.StochasticsSwitch#caseTermExpression(de.uka.ipd.sdq.pcm.core.stochastics.TermExpression)
	 */
	@Override
	public String caseTermExpression(TermExpression object) {
		String op = "";
		switch(object.getOperation())
		{
		case ADD:
			op = " + ";
			break;
		case SUB:
			op = " - ";
			break;
		}
		return ((String)doSwitch(object.getLeft()))+op+((String)doSwitch(object.getRight()));
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.parameter.util.ParameterSwitch#caseNamespaceReference(de.uka.ipd.sdq.pcm.parameter.NamespaceReference)
	 */
	@Override
	public String caseNamespaceReference(NamespaceReference object) {
		return object.getReferenceName()+"."+(String)doSwitch(object.getInnerReference_NamespaceReference());
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.parameter.util.ParameterSwitch#caseVariableReference(de.uka.ipd.sdq.pcm.parameter.VariableReference)
	 */
	@Override
	public String caseVariableReference(VariableReference object) {
		return object.getReferenceName();
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.util.StochasticsSwitch#caseVariable(de.uka.ipd.sdq.pcm.core.stochastics.Variable)
	 */
	@Override
	public String caseVariable(Variable object) {
		String result = (String)doSwitch(object.getId_Variable());
		// TODO: Move this part: result += "." + object.getCharacterisationType().getLiteral();
		return result;
	}

	public String prettyPrint(EObject theObject)
	{
		return (String)doSwitch(theObject);
	}

	@Override
	public String caseBooleanOperatorExpression(BooleanOperatorExpression object) {
		String result = this.doSwitch(object.getLeft());
		result += " "+object.getOperation().getLiteral()+" ";
		return result + this.doSwitch(object.getRight());
	}

	@Override
	public String caseNegativeExpression(NegativeExpression object) {
		return "-"+this.doSwitch(object.getInner());
	}

	@Override
	public String caseNotExpression(NotExpression object) {
		return "NOT "+this.doSwitch(object.getInner())+"";
	}

	@Override
	public String caseFunctionLiteral(FunctionLiteral object) {
		String result = object.getId() + "(";
		for (int i=0; i < object.getParameters_FunctionLiteral().size()-1; i++)
			result += this.doSwitch(object.getParameters_FunctionLiteral().get(i)) + ", ";
		result += this.doSwitch(object.getParameters_FunctionLiteral().get(object.getParameters_FunctionLiteral().size()-1)) + ")";
		return result;
	}

	@Override
	public String caseIfElseExpression(IfElseExpression object) {
		return this.doSwitch(object.getConditionExpression()) + " ? " +
				this.doSwitch(object.getIfExpression()) + " : " +
				this.doSwitch(object.getElseExpression());
	}
	
}

package de.uka.ipd.sdq.stoex.analyser.visitors;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.probfunction.print.ProbFunctionPrettyPrint;
import de.uka.ipd.sdq.stoex.BoolLiteral;
import de.uka.ipd.sdq.stoex.CompareExpression;
import de.uka.ipd.sdq.stoex.CompareOperations;
import de.uka.ipd.sdq.stoex.DoubleLiteral;
import de.uka.ipd.sdq.stoex.IntLiteral;
import de.uka.ipd.sdq.stoex.NamespaceReference;
import de.uka.ipd.sdq.stoex.Parenthesis;
import de.uka.ipd.sdq.stoex.PowerExpression;
import de.uka.ipd.sdq.stoex.ProbabilityFunctionLiteral;
import de.uka.ipd.sdq.stoex.ProductExpression;
import de.uka.ipd.sdq.stoex.ProductOperations;
import de.uka.ipd.sdq.stoex.StringLiteral;
import de.uka.ipd.sdq.stoex.TermExpression;
import de.uka.ipd.sdq.stoex.TermOperations;
import de.uka.ipd.sdq.stoex.Variable;
import de.uka.ipd.sdq.stoex.VariableReference;
import de.uka.ipd.sdq.stoex.util.StoexSwitch;

public class StoExPrettyPrintVisitor
extends StoexSwitch
{
	@Override
	public Object caseBoolLiteral(BoolLiteral object) {
		return object.isValue() ? "true" : "false";
	}

	@Override
	public Object casePowerExpression(PowerExpression object) {
		return ((String)doSwitch(object.getBase()))+" ^ "+((String)doSwitch(object.getExponent()));
	}

	@Override
	public Object caseStringLiteral(StringLiteral object) {
		return "\""+object.getValue()+"\"";
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.util.StochasticsSwitch#caseCompareExpression(de.uka.ipd.sdq.pcm.core.stochastics.CompareExpression)
	 */
	@Override
	public Object caseCompareExpression(CompareExpression object) {
		String op = "";
		switch(object.getOperation().getValue())
		{
		case CompareOperations.EQUALS:
			op = " == ";
			break;
		case CompareOperations.GREATER:
			op = " > ";
			break;
		case CompareOperations.GREATEREQUAL:
			op = " >= ";
			break;
		case CompareOperations.LESS:
			op = " < ";
			break;
		case CompareOperations.LESSEQUAL:
			op = " <= ";
			break;
		case CompareOperations.NOTEQUAL:
			op = " != ";
			break;
		}
		return ((String)doSwitch(object.getLeft()))+op+((String)doSwitch(object.getRight()));
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.util.StochasticsSwitch#caseDoubleLiteral(de.uka.ipd.sdq.pcm.core.stochastics.DoubleLiteral)
	 */
	@Override
	public Object caseDoubleLiteral(DoubleLiteral object) {
		return Double.toString(object.getValue());
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.util.StochasticsSwitch#caseIntLiteral(de.uka.ipd.sdq.pcm.core.stochastics.IntLiteral)
	 */
	@Override
	public Object caseIntLiteral(IntLiteral object) {
		return Integer.toString(object.getValue());
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.util.StochasticsSwitch#caseParantesis(de.uka.ipd.sdq.pcm.core.stochastics.Parantesis)
	 */
	@Override
	public Object caseParenthesis(Parenthesis object) {
		return "( " + (String)doSwitch(object.getInnerExpression())+" )";
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.util.StochasticsSwitch#caseProbabilityFunctionLiteral(de.uka.ipd.sdq.pcm.core.stochastics.ProbabilityFunctionLiteral)
	 */
	@Override
	public Object caseProbabilityFunctionLiteral(ProbabilityFunctionLiteral object) {
		return new ProbFunctionPrettyPrint().doSwitch(object.getFunction_ProbabilityFunctionLiteral());
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.util.StochasticsSwitch#caseProductExpression(de.uka.ipd.sdq.pcm.core.stochastics.ProductExpression)
	 */
	@Override
	public Object caseProductExpression(ProductExpression object) {
		String op = "";
		switch(object.getOperation().getValue())
		{
		case ProductOperations.MULT:
			op = " * ";
			break;
		case ProductOperations.MOD:
			op = " % ";
			break;
		case ProductOperations.DIV:
			op = " / ";
			break;
		}
		return ((String)doSwitch(object.getLeft()))+op+((String)doSwitch(object.getRight()));	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.util.StochasticsSwitch#caseTermExpression(de.uka.ipd.sdq.pcm.core.stochastics.TermExpression)
	 */
	@Override
	public Object caseTermExpression(TermExpression object) {
		String op = "";
		switch(object.getOperation().getValue())
		{
		case TermOperations.ADD:
			op = " + ";
			break;
		case TermOperations.SUB:
			op = " - ";
			break;
		}
		return ((String)doSwitch(object.getLeft()))+op+((String)doSwitch(object.getRight()));
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.parameter.util.ParameterSwitch#caseNamespaceReference(de.uka.ipd.sdq.pcm.parameter.NamespaceReference)
	 */
	@Override
	public Object caseNamespaceReference(NamespaceReference object) {
		return object.getReferenceName()+"."+(String)doSwitch(object.getInnerReference_NamespaceReference());
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.parameter.util.ParameterSwitch#caseVariableReference(de.uka.ipd.sdq.pcm.parameter.VariableReference)
	 */
	@Override
	public Object caseVariableReference(VariableReference object) {
		return object.getReferenceName();
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.util.StochasticsSwitch#caseVariable(de.uka.ipd.sdq.pcm.core.stochastics.Variable)
	 */
	@Override
	public Object caseVariable(Variable object) {
		String result = (String)doSwitch(object.getId_Variable());
		// TODO: Move this part: result += "." + object.getCharacterisationType().getLiteral();
		return result;
	}

	public String prettyPrint(EObject theObject)
	{
		return (String)doSwitch(theObject);
	}
}

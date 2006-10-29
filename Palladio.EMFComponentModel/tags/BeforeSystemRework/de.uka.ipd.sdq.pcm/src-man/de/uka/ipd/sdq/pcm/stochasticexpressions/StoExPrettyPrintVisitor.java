package de.uka.ipd.sdq.pcm.stochasticexpressions;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.core.stochastics.Atom;
import de.uka.ipd.sdq.pcm.core.stochastics.CompareExpression;
import de.uka.ipd.sdq.pcm.core.stochastics.CompareOperations;
import de.uka.ipd.sdq.pcm.core.stochastics.Comparison;
import de.uka.ipd.sdq.pcm.core.stochastics.DoubleLiteral;
import de.uka.ipd.sdq.pcm.core.stochastics.Expression;
import de.uka.ipd.sdq.pcm.core.stochastics.IntLiteral;
import de.uka.ipd.sdq.pcm.core.stochastics.NumericLiteral;
import de.uka.ipd.sdq.pcm.core.stochastics.Parantesis;
import de.uka.ipd.sdq.pcm.core.stochastics.Power;
import de.uka.ipd.sdq.pcm.core.stochastics.ProbabilityFunctionLiteral;
import de.uka.ipd.sdq.pcm.core.stochastics.Product;
import de.uka.ipd.sdq.pcm.core.stochastics.ProductExpression;
import de.uka.ipd.sdq.pcm.core.stochastics.ProductOperations;
import de.uka.ipd.sdq.pcm.core.stochastics.RandomVariable;
import de.uka.ipd.sdq.pcm.core.stochastics.Term;
import de.uka.ipd.sdq.pcm.core.stochastics.TermExpression;
import de.uka.ipd.sdq.pcm.core.stochastics.TermOperations;
import de.uka.ipd.sdq.pcm.core.stochastics.Variable;
import de.uka.ipd.sdq.pcm.core.stochastics.util.StochasticsSwitch;

public class StoExPrettyPrintVisitor
extends StochasticsSwitch
{
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
	public Object caseParantesis(Parantesis object) {
		return "(" + (String)doSwitch(object.getInnerExpression())+")";
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
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.util.StochasticsSwitch#caseVariable(de.uka.ipd.sdq.pcm.core.stochastics.Variable)
	 */
	@Override
	public Object caseVariable(Variable object) {
		return object.getId();
	}
	
	public String prettyPrint(EObject theObject)
	{
		return (String)doSwitch(theObject);
	}
}

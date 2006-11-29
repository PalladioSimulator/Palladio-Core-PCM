package de.uka.ipd.sdq.simucomframework.stoexvisitor;

import de.uka.ipd.sdq.pcm.parameter.CharacterisedVariable;
import de.uka.ipd.sdq.pcm.stochasticexpressions.PCMStoExPrettyPrintVisitor;
import de.uka.ipd.sdq.pcm.stochasticexpressions.PCMStoExSwitch;
import de.uka.ipd.sdq.probfunction.ProbabilityFunction;
import de.uka.ipd.sdq.simucomframework.stackframe.SimulatedStackframe;
import de.uka.ipd.sdq.simucomframework.stackframe.ValueNotInFrameException;
import de.uka.ipd.sdq.stoex.AbstractNamedReference;
import de.uka.ipd.sdq.stoex.Atom;
import de.uka.ipd.sdq.stoex.CompareExpression;
import de.uka.ipd.sdq.stoex.Comparison;
import de.uka.ipd.sdq.stoex.DoubleLiteral;
import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.IntLiteral;
import de.uka.ipd.sdq.stoex.Parenthesis;
import de.uka.ipd.sdq.stoex.Power;
import de.uka.ipd.sdq.stoex.ProbabilityFunctionLiteral;
import de.uka.ipd.sdq.stoex.Product;
import de.uka.ipd.sdq.stoex.ProductExpression;
import de.uka.ipd.sdq.stoex.ProductOperations;
import de.uka.ipd.sdq.stoex.RandomVariable;
import de.uka.ipd.sdq.stoex.Term;
import de.uka.ipd.sdq.stoex.TermExpression;
import de.uka.ipd.sdq.stoex.Variable;


public class PCMStoExEvaluationVisitor extends PCMStoExSwitch {

	private PCMProbfunctionEvaluationVisitor probfunctionVisitor = new PCMProbfunctionEvaluationVisitor();
	private SimulatedStackframe<Object> myStackFrame;
	private static PCMStoExPrettyPrintVisitor printVisitor = new PCMStoExPrettyPrintVisitor();
	
	public PCMStoExEvaluationVisitor(SimulatedStackframe<Object> frame) {
		myStackFrame = frame;
	}

	@Override
	public Object caseCharacterisedVariable(CharacterisedVariable object) {
		String variableID = (String)printVisitor.caseCharacterisedVariable(object);
		try {
			return this.myStackFrame.getValue(variableID);
		} catch (ValueNotInFrameException e) {
			e.printStackTrace();
		}
        throw new RuntimeException("Architecture specification incomplete. Stackframe is missing id "+variableID);
	}

	@Override
	public Object caseCompareExpression(CompareExpression object) {
		// TODO Auto-generated method stub
		return super.caseCompareExpression(object);
	}

	@Override
	public Object caseComparison(Comparison object) {
		// TODO Auto-generated method stub
		return super.caseComparison(object);
	}

	@Override
	public Object caseDoubleLiteral(DoubleLiteral object) {
		return object.getValue();
	}

	@Override
	public Object caseExpression(Expression object) {
		// TODO Auto-generated method stub
		return super.caseExpression(object);
	}

	@Override
	public Object caseIntLiteral(IntLiteral object) {
		return object.getValue();
	}

	@Override
	public Object caseParenthesis(Parenthesis object) {
		return doSwitch(object.getInnerExpression());
	}

	@Override
	public Object casePower(Power object) {
		// TODO Auto-generated method stub
		return super.casePower(object);
	}

	@Override
	public Object caseProbabilityFunctionLiteral(ProbabilityFunctionLiteral object) {
		return probfunctionVisitor.doSwitch(object.getFunction_ProbabilityFunctionLiteral());
	}

	@Override
	public Object caseProductExpression(ProductExpression object) {
		double left = (Integer)doSwitch(object.getLeft());
		double right = (Integer)doSwitch(object.getRight());
		switch(object.getOperation().getValue())
		{
		case ProductOperations.DIV:
			return left / right;
		case ProductOperations.MULT:
			return left * right;
		case ProductOperations.MOD:
			return left % right;
		}
		throw new RuntimeException("This should never happen!");
	}

	@Override
	public Object caseRandomVariable(RandomVariable object) {
		// TODO Auto-generated method stub
		return super.caseRandomVariable(object);
	}

	@Override
	public Object caseTerm(Term object) {
		// TODO Auto-generated method stub
		return super.caseTerm(object);
	}

	@Override
	public Object caseTermExpression(TermExpression object) {
		// TODO Auto-generated method stub
		return super.caseTermExpression(object);
	}

	@Override
	public Object caseVariable(Variable object) {
		// TODO Auto-generated method stub
		return super.caseVariable(object);
	}
 
}

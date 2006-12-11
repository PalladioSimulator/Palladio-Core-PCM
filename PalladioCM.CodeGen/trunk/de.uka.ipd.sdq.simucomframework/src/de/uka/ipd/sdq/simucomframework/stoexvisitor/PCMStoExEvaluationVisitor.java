package de.uka.ipd.sdq.simucomframework.stoexvisitor;

import sun.awt.datatransfer.DataTransferer.IndexedComparator;
import de.uka.ipd.sdq.pcm.parameter.CharacterisedVariable;
import de.uka.ipd.sdq.pcm.stochasticexpressions.PCMStoExPrettyPrintVisitor;
import de.uka.ipd.sdq.pcm.stochasticexpressions.PCMStoExSwitch;
import de.uka.ipd.sdq.probfunction.ProbabilityFunction;
import de.uka.ipd.sdq.simucomframework.Context;
import de.uka.ipd.sdq.simucomframework.stackframe.SimulatedStackframe;
import de.uka.ipd.sdq.simucomframework.stackframe.ValueNotInFrameException;
import de.uka.ipd.sdq.stoex.AbstractNamedReference;
import de.uka.ipd.sdq.stoex.Atom;
import de.uka.ipd.sdq.stoex.CompareExpression;
import de.uka.ipd.sdq.stoex.CompareOperations;
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
import de.uka.ipd.sdq.stoex.analyser.visitors.ExpressionInferTypeVisitor;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;


public class PCMStoExEvaluationVisitor extends PCMStoExSwitch {

	private PCMProbfunctionEvaluationVisitor probfunctionVisitor = new PCMProbfunctionEvaluationVisitor();
	private SimulatedStackframe<Object> myStackFrame;
	private ExpressionInferTypeVisitor typeInferer;
	private static PCMStoExPrettyPrintVisitor printVisitor = new PCMStoExPrettyPrintVisitor();
	
	public PCMStoExEvaluationVisitor(ExpressionInferTypeVisitor typeInferer, SimulatedStackframe<Object> frame) {
		myStackFrame = frame;
		this.typeInferer = typeInferer;
	}

	@Override
	public Object caseCharacterisedVariable(CharacterisedVariable object) {
		String variableID = (String)printVisitor.caseCharacterisedVariable(object);
		try {
			Object value = this.myStackFrame.getValue(variableID); 
			if (value instanceof EvaluationProxy) {
				EvaluationProxy proxy = (EvaluationProxy)value;
				return Context.evaluate(proxy.getStoEx(), proxy.getStackFrame());
			} else {
				return value;
			}
		} catch (ValueNotInFrameException e) {
			e.printStackTrace();
		}
        throw new RuntimeException("Architecture specification incomplete. Stackframe is missing id "+variableID);
	}

	@Override
	public Object caseCompareExpression(CompareExpression object) {
		Object leftExpr = doSwitch(object.getLeft());
		Object rightExpr = doSwitch(object.getRight());
		int result = ((Comparable)leftExpr).compareTo(rightExpr);
		switch(object.getOperation().getValue())
		{
		case CompareOperations.EQUALS:
			return result == 0;
		case CompareOperations.LESS:
			return result < 0;
		case CompareOperations.LESSEQUAL:
			return result <= 0;
		case CompareOperations.GREATER:
			return result > 0;
		case CompareOperations.GREATEREQUAL:
			return result >= 0;
		case CompareOperations.NOTEQUAL:
			return result != 0;
		}
		throw new RuntimeException("Unknown Compare Operation found! Should not happen!");
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
		TypeEnum leftType = typeInferer.getType(object.getLeft());
		TypeEnum rightType = typeInferer.getType(object.getRight());
		Object left = doSwitch(object.getLeft());
		Object right = doSwitch(object.getRight());
		if (leftType == TypeEnum.ANY) leftType = getDynamicType(left);
		if (leftType == TypeEnum.ANY) rightType = getDynamicType(right);
		if (leftType == TypeEnum.INT &&	rightType == TypeEnum.INT) {
			int leftInt = (Integer)left;
			int rightInt = (Integer)right;
			switch(object.getOperation().getValue())
			{
			case ProductOperations.DIV:
				return leftInt / rightInt;
			case ProductOperations.MULT:
				return leftInt * rightInt;
			case ProductOperations.MOD:
				return leftInt % rightInt;
			}
			throw new RuntimeException("This should never happen!");
			
		} else {
			double leftDouble = getDouble(left);
			double rightDouble = getDouble(right);
			switch(object.getOperation().getValue())
			{
			case ProductOperations.DIV:
				return leftDouble / rightDouble;
			case ProductOperations.MULT:
				return leftDouble * rightDouble;
			case ProductOperations.MOD:
				return leftDouble % rightDouble;
			}
			throw new RuntimeException("This should never happen!");
		}
	}

	private double getDouble(Object o) {
		if (o instanceof Double)
			return (Double)o;
		if (o instanceof Integer)
			return (Integer)o;
		throw new UnsupportedOperationException("Trying to cast a "+o.getClass().getCanonicalName()+" to a Double!");
	}

	private TypeEnum getDynamicType(Object o) {
		if (o instanceof Integer)
			return TypeEnum.INT;
		if (o instanceof Double)
			return TypeEnum.DOUBLE;
		if (o instanceof String)
			return TypeEnum.ENUM;
		if (o instanceof Boolean)
			return TypeEnum.BOOL;
		throw new RuntimeException("Unknown dynamic type found! Should never happen!");
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

package de.uka.ipd.sdq.simucomframework.variables.stoexvisitor;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.parameter.CharacterisedVariable;
import de.uka.ipd.sdq.pcm.stochasticexpressions.PCMStoExPrettyPrintVisitor;
import de.uka.ipd.sdq.pcm.stochasticexpressions.PCMStoExSwitch;
import de.uka.ipd.sdq.simucomframework.variables.EvaluationProxy;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.cache.ProbFunctionCache;
import de.uka.ipd.sdq.simucomframework.variables.cache.StoExCache;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.ValueNotInFrameException;
import de.uka.ipd.sdq.stoex.CompareExpression;
import de.uka.ipd.sdq.stoex.CompareOperations;
import de.uka.ipd.sdq.stoex.DoubleLiteral;
import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.IntLiteral;
import de.uka.ipd.sdq.stoex.Parenthesis;
import de.uka.ipd.sdq.stoex.Power;
import de.uka.ipd.sdq.stoex.ProbabilityFunctionLiteral;
import de.uka.ipd.sdq.stoex.ProductExpression;
import de.uka.ipd.sdq.stoex.ProductOperations;
import de.uka.ipd.sdq.stoex.RandomVariable;
import de.uka.ipd.sdq.stoex.StringLiteral;
import de.uka.ipd.sdq.stoex.Term;
import de.uka.ipd.sdq.stoex.TermExpression;
import de.uka.ipd.sdq.stoex.TermOperations;
import de.uka.ipd.sdq.stoex.Variable;
import de.uka.ipd.sdq.stoex.analyser.visitors.ExpressionInferTypeVisitor;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;


public class PCMStoExEvaluationVisitor extends PCMStoExSwitch {

	private static Logger logger = 
		Logger.getLogger(PCMStoExEvaluationVisitor.class.getName());
	
	private PCMProbfunctionEvaluationVisitor probfunctionVisitor;
	private SimulatedStackframe<Object> myStackFrame;
	private ExpressionInferTypeVisitor typeInferer;
	private static PCMStoExPrettyPrintVisitor printVisitor = new PCMStoExPrettyPrintVisitor();
	private String stoex;
	
	public PCMStoExEvaluationVisitor(String stoex, SimulatedStackframe<Object> frame) {
		myStackFrame = frame;
		this.typeInferer = StoExCache.singleton().getEntry(stoex).getTypeInferer();
		this.stoex = stoex;
		probfunctionVisitor = new PCMProbfunctionEvaluationVisitor(stoex);
	}

	@Override
	public Object caseCharacterisedVariable(CharacterisedVariable object) {
		String variableID = (String)printVisitor.caseCharacterisedVariable(object);
		try {
			Object value = this.myStackFrame.getValue(variableID); 
			if (value instanceof EvaluationProxy) {
				EvaluationProxy proxy = (EvaluationProxy)value;
				return StackContext.evaluate(proxy.getStoEx(), proxy.getStackFrame());
			} else {
				return value;
			}
		} catch (ValueNotInFrameException e) {
			logger.error("Value should be in stackframe, but it is not!",e);
			e.printStackTrace();
		}
		RuntimeException re = new RuntimeException("Architecture specification incomplete. Stackframe is missing id "+variableID);
        logger.error("Value not found in specification",re);
		throw re; 
	}

	@Override
	public Object caseCompareExpression(CompareExpression object) {
		TypeEnum leftType = typeInferer.getType(object.getLeft());
		TypeEnum rightType = typeInferer.getType(object.getRight());
		Object leftExpr = doSwitch(object.getLeft());
		Object rightExpr = doSwitch(object.getRight());
		if (leftType == TypeEnum.ANY) leftType = getDynamicType(leftExpr);
		if (leftType == TypeEnum.ANY) rightType = getDynamicType(rightExpr);
		
		if (leftType == TypeEnum.INT && rightType == TypeEnum.DOUBLE)
			leftExpr = Double.valueOf( (((Integer)leftExpr).intValue()));
		if (rightType == TypeEnum.INT && leftType == TypeEnum.DOUBLE)
			rightExpr = Double.valueOf( (((Integer)rightExpr).intValue()));
		
		int result = ((Comparable)leftExpr).compareTo(rightExpr);
		switch(object.getOperation())
		{
		case EQUALS:
			return result == 0;
		case LESS:
			return result < 0;
		case LESSEQUAL:
			return result <= 0;
		case GREATER:
			return result > 0;
		case GREATEREQUAL:
			return result >= 0;
		case NOTEQUAL:
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
	public Object caseStringLiteral(StringLiteral object) {
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
			switch(object.getOperation())
			{
			case DIV:
				return leftInt / rightInt;
			case MULT:
				return leftInt * rightInt;
			case MOD:
				return leftInt % rightInt;
			}
			throw new RuntimeException("This should never happen!");
			
		} else {
			double leftDouble = getDouble(left);
			double rightDouble = getDouble(right);
			switch(object.getOperation())
			{
			case DIV:
				return leftDouble / rightDouble;
			case MULT:
				return leftDouble * rightDouble;
			case MOD:
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
		TypeEnum leftType = typeInferer.getType(object.getLeft());
		TypeEnum rightType = typeInferer.getType(object.getRight());
		Object left = doSwitch(object.getLeft());
		Object right = doSwitch(object.getRight());
		if (leftType == TypeEnum.ANY) leftType = getDynamicType(left);
		if (leftType == TypeEnum.ANY) rightType = getDynamicType(right);
		if (leftType == TypeEnum.INT &&	rightType == TypeEnum.INT) {
			int leftInt = (Integer)left;
			int rightInt = (Integer)right;
			switch(object.getOperation())
			{
			case ADD:
				return leftInt + rightInt;
			case SUB:
				return leftInt - rightInt;
			}
			throw new RuntimeException("This should never happen!");
			
		} else {
			double leftDouble = getDouble(left);
			double rightDouble = getDouble(right);
			switch(object.getOperation())
			{
			case ADD:
				return leftDouble + rightDouble;
			case SUB:
				return leftDouble - rightDouble;
			}
			throw new RuntimeException("This should never happen!");
		}
	}

	@Override
	public Object caseVariable(Variable object) {
		// TODO Auto-generated method stub
		return super.caseVariable(object);
	}
 
}

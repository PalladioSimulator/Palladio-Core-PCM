package de.uka.ipd.sdq.dsolver.visitors;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.core.stochastics.DoubleLiteral;
import de.uka.ipd.sdq.pcm.core.stochastics.Expression;
import de.uka.ipd.sdq.pcm.core.stochastics.IntLiteral;
import de.uka.ipd.sdq.pcm.core.stochastics.ProbabilityFunctionLiteral;
import de.uka.ipd.sdq.pcm.core.stochastics.ProductExpression;
import de.uka.ipd.sdq.pcm.core.stochastics.ProductOperations;
import de.uka.ipd.sdq.pcm.core.stochastics.RandomVariable;
import de.uka.ipd.sdq.pcm.core.stochastics.StochasticsFactory;
import de.uka.ipd.sdq.pcm.core.stochastics.TermExpression;
import de.uka.ipd.sdq.pcm.core.stochastics.util.StochasticsSwitch;
import de.uka.ipd.sdq.probfunction.ProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.ProbfunctionFactory;
import de.uka.ipd.sdq.probfunction.Unit;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.ISample;
import de.uka.ipd.sdq.probfunction.math.IUnit;
import de.uka.ipd.sdq.probfunction.math.exception.DifferentDomainsException;

public class ExpressionSolveSwitch extends StochasticsSwitch {

	private static Logger logger = Logger.getLogger(ExpressionSolveSwitch.class
			.getName());

	private ExpressionTypeSwitch typeVisitor;

	private IProbabilityFunctionFactory iProbFuncFactory = IProbabilityFunctionFactory.eINSTANCE;

	private ProbfunctionFactory probFuncFactory = ProbfunctionFactory.eINSTANCE;

	private StochasticsFactory stocFactory = StochasticsFactory.eINSTANCE;

	public ExpressionSolveSwitch(Expression expr) {
		typeVisitor = new ExpressionTypeSwitch();
		try {
			typeVisitor.doSwitch(expr);
		} catch (Exception e) {
			logger.error("Inferring Expression Types caused Exception!"
					+ e.getMessage());
			e.printStackTrace();
		}
	}

	public Object caseTermExpression(TermExpression expr){
		String opName = expr.getOperation().getName();
		OpEnum op;
		if (opName.equals("ADD"))
			op = OpEnum.ADD;
		else if (opName.equals("SUB"))
			op = OpEnum.SUB;
		else {
			logger.error("Operation not supported!");
			return expr;
		}
		return handleExpression(expr, op);
	}
	
	public Object caseProductExpression(ProductExpression expr) {
		String opName = expr.getOperation().getName();
		OpEnum op;
		if (opName.equals("MULT"))
			op = OpEnum.MULT;
		else if (opName.equals("DIV"))
			op = OpEnum.DIV;
		else if (opName.equals("MOD"))
			op = OpEnum.MOD;
		else {
			logger.error("Operation not supported!");
			return expr;
		}
		return handleExpression((TermExpression)expr, op);
	}

	public Object caseIntLiteral(IntLiteral il) {
		return il;
	}

	public Object caseDoubleLiteral(DoubleLiteral dl) {
		return dl;
	}

	public Object caseProbabilityFunctionLiteral(
			ProbabilityFunctionLiteral probFuncLit) {
		return probFuncLit.getFunction_ProbabilityFunctionLiteral();
	}

	/**
	 * @param expr
	 * @param op
	 * @return
	 */
	private Expression handleExpression(TermExpression expr, OpEnum op) {
		Expression left = (Expression) doSwitch(expr.getLeft());
		Expression right = (Expression) doSwitch(expr.getRight());

		TypeEnum exprType = typeVisitor.getTypeAnnotation(expr);

		switch (exprType) {
		case INT:
			return handleIntInt(left, right, op);
		case DOUBLE:
			return handleDoubleDouble(left, right, op);
		case INT_PMF:
			if (left instanceof IntLiteral) {
				return handleIntPMFInt((ProbabilityMassFunction) right,
						(IntLiteral) left, op);
			} else if (right instanceof IntLiteral) {
				return handleIntPMFInt((ProbabilityMassFunction) left,
						(IntLiteral) right, op);
			} else if (left instanceof ProbabilityMassFunction
					&& right instanceof ProbabilityMassFunction) {
				return handleIntPMFIntPMF(left, right, op);
			} else {
				logger.error("Operation " + op.toString() + " failed!");
				return expr;
			}
		case DOUBLE_PMF:
			// TODO
		}
		return expr;
	}

	private ProbabilityFunctionLiteral handleIntPMFIntPMF(Expression left,
			Expression right, OpEnum operation) {
		ProbabilityMassFunction leftPMF = (ProbabilityMassFunction) left;
		IProbabilityMassFunction iLeftPMF = iProbFuncFactory
				.transformToPMF(leftPMF);

		ProbabilityMassFunction rightPMF = (ProbabilityMassFunction) right;
		IProbabilityMassFunction iRightPMF = iProbFuncFactory
				.transformToPMF(rightPMF);

		IProbabilityMassFunction resultIPMF = null;
		try {
			switch (operation) {
			case ADD:
				resultIPMF = iLeftPMF.add(iRightPMF);
				break;
			case SUB:
				resultIPMF = iLeftPMF.sub(iRightPMF);
				break;
			case MULT:
				resultIPMF = iLeftPMF.mult(iRightPMF);
				break;
			case DIV:
				resultIPMF = iLeftPMF.div(iRightPMF);
				break;
			case MOD:
				//resultIPMF = iLeftPMF.mod(iRightPMF);
				break;
			}
		} catch (DifferentDomainsException e) {
			logger.error("Calculation with two PMFs failed!");
			e.printStackTrace();
		}

		ProbabilityMassFunction resultPMF = iProbFuncFactory
				.transformToModelPMF(resultIPMF);

		// TODO: setting ordered domain and unit should already be done by
		// transform method
		resultPMF.setOrderedDomain(resultIPMF.hasOrderedDomain());
		Unit unit = probFuncFactory.createUnit();
		unit.setUnitName("");
		resultPMF.setUnit(unit);

		ProbabilityFunctionLiteral resultPMFLiteral = stocFactory
				.createProbabilityFunctionLiteral();
		resultPMFLiteral.setFunction_ProbabilityFunctionLiteral(resultPMF);

		return resultPMFLiteral;

	}

	/**
	 * @param operation
	 *            TODO
	 * @param right
	 *            IntPMF
	 * @param left
	 *            IntLiteral
	 * @return
	 */
	private ProbabilityFunctionLiteral handleIntPMFInt(
			ProbabilityMassFunction intPMF, IntLiteral intLiteral,
			OpEnum operation) {
		IProbabilityMassFunction iPMF = iProbFuncFactory.transformToPMF(intPMF);
		Integer intValue = intLiteral.getValue();

		IProbabilityMassFunction resultIPMF = null;
		try {
			switch (operation) {
			case ADD:
				// resultIPMF = iPMF.shiftDomain(intValue); break;
			case SUB:
				// resultIPMF = iPMF.shiftDomain(-intValue); break;
			case MULT:
				// resultIPMF = iPMF.stretchDomain(intValue); break;
			case DIV:
				// resultIPMF = iPMF.stretchDomain(1/intValue); break;
			case MOD:
				// ???
			}
			logger.error("Combining PMF with Integer not supported yet!");
		} catch (Exception e) {
		}
		// } catch (DifferentDomainsException e) {
		// logger.error("Multplying PMF with Integer failed!");
		// e.printStackTrace();
		// }
		ProbabilityMassFunction resultPMF = iProbFuncFactory
				.transformToModelPMF(resultIPMF);

		// TODO: setting ordered domain and unit should already be done by
		// transform method
		resultPMF.setOrderedDomain(resultIPMF.hasOrderedDomain());
		Unit unit = probFuncFactory.createUnit();
		unit.setUnitName("");
		resultPMF.setUnit(unit);

		ProbabilityFunctionLiteral resultPMFLiteral = stocFactory
				.createProbabilityFunctionLiteral();
		resultPMFLiteral.setFunction_ProbabilityFunctionLiteral(resultPMF);

		return resultPMFLiteral;
	}

	/**
	 * @param left
	 * @param right
	 * @param operation
	 *            TODO
	 * @return
	 */
	private DoubleLiteral handleDoubleDouble(Expression left, Expression right,
			OpEnum operation) {
		double leftValue = getDoubleFromNumericLiteral(left);
		double rightValue = getDoubleFromNumericLiteral(right);
		DoubleLiteral result = stocFactory.eINSTANCE.createDoubleLiteral();
		switch (operation) {
		case ADD:
			result.setValue(leftValue + rightValue);
			break;
		case SUB:
			result.setValue(leftValue - rightValue);
			break;
		case MULT:
			result.setValue(leftValue * rightValue);
			break;
		case DIV:
			result.setValue(leftValue / rightValue);
			break;
		case MOD:
			result.setValue(leftValue % rightValue);
			break;
		}
		return result;
	}

	/**
	 * @param left
	 * @param right
	 * @param operation
	 *            TODO
	 * @return
	 */
	private IntLiteral handleIntInt(Expression left, Expression right,
			OpEnum operation) {
		int leftValue = ((IntLiteral) left).getValue();
		int rightValue = ((IntLiteral) right).getValue();
		IntLiteral result = stocFactory.createIntLiteral();
		switch (operation) {
		case ADD:
			result.setValue(leftValue + rightValue);
			break;
		case SUB:
			result.setValue(leftValue - rightValue);
			break;
		case MULT:
			result.setValue(leftValue * rightValue);
			break;
		case DIV:
			result.setValue(leftValue / rightValue);
			break;
		case MOD:
			result.setValue(leftValue % rightValue);
			break;
		}
		return result;
	}

	/**
	 * @param expr
	 */
	private double getDoubleFromNumericLiteral(Expression expr) {
		if (expr instanceof IntLiteral) {
			return (double) ((IntLiteral) expr).getValue();
		} else if (expr instanceof DoubleLiteral) {
			return (double) ((DoubleLiteral) expr).getValue();
		} else {
			logger.error("Could not get Double value from NumericLiteral!");
			return 0.0;
		}
	}

}

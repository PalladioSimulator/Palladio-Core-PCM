package de.uka.ipd.sdq.dsolver.visitors;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.dsolver.operations.AddOperation;
import de.uka.ipd.sdq.dsolver.operations.DivOperation;
import de.uka.ipd.sdq.dsolver.operations.IOperation;
import de.uka.ipd.sdq.dsolver.operations.ModOperation;
import de.uka.ipd.sdq.dsolver.operations.MultOperation;
import de.uka.ipd.sdq.dsolver.operations.SubOperation;
import de.uka.ipd.sdq.pcm.core.stochastics.DoubleLiteral;
import de.uka.ipd.sdq.pcm.core.stochastics.Expression;
import de.uka.ipd.sdq.pcm.core.stochastics.IntLiteral;
import de.uka.ipd.sdq.pcm.core.stochastics.Power;
import de.uka.ipd.sdq.pcm.core.stochastics.ProbabilityFunctionLiteral;
import de.uka.ipd.sdq.pcm.core.stochastics.Product;
import de.uka.ipd.sdq.pcm.core.stochastics.ProductExpression;
import de.uka.ipd.sdq.pcm.core.stochastics.StochasticsFactory;
import de.uka.ipd.sdq.pcm.core.stochastics.Term;
import de.uka.ipd.sdq.pcm.core.stochastics.TermExpression;
import de.uka.ipd.sdq.pcm.core.stochastics.util.StochasticsSwitch;
import de.uka.ipd.sdq.probfunction.ProbabilityFunction;
import de.uka.ipd.sdq.probfunction.ProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.ProbfunctionFactory;
import de.uka.ipd.sdq.probfunction.Unit;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.exception.DifferentDomainsException;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilitySumNotOneException;

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
		IOperation op;
		if (opName.equals("ADD"))
			op = new AddOperation();
		else if (opName.equals("SUB"))
			op = new SubOperation();
		else {
			logger.error("Operation not supported!");
			return expr;
		}
		
		Expression left = (Expression) doSwitch(expr.getLeft());
		Expression right = (Expression) doSwitch(expr.getRight());
		TypeEnum exprType = typeVisitor.getTypeAnnotation(expr);

		return handleExpression(exprType, left, right,op);
	}
	
	public Object caseProductExpression(ProductExpression expr) {
		String opName = expr.getOperation().getName();
		IOperation op;
		if (opName.equals("MULT"))
			op = new MultOperation();
		else if (opName.equals("DIV"))
			op = new DivOperation();
		else if (opName.equals("MOD"))
			op = new ModOperation();
		else {
			logger.error("Operation not supported!");
			return expr;
		}
		
		Expression left = (Expression) doSwitch(expr.getLeft());
		Expression right = (Expression) doSwitch(expr.getRight());
		TypeEnum exprType = typeVisitor.getTypeAnnotation(expr);

		return handleExpression(exprType, left, right,op);
	}

	public Object caseIntLiteral(IntLiteral il) {
		return il;
	}

	public Object caseDoubleLiteral(DoubleLiteral dl) {
		return dl;
	}

	public Object caseProbabilityFunctionLiteral(
			ProbabilityFunctionLiteral probFuncLit) {
		return probFuncLit;
	}
	
	/**
	 * @param expr
	 * @param op
	 * @return
	 * @throws ProbabilitySumNotOneException 
	 */
	private Expression handleExpression(TypeEnum exprType, Expression left, Expression right, IOperation op) {
		switch (exprType) {
		case INT:
			return handleIntInt(left, right, null);
		case DOUBLE:
			return handleDoubleDouble(left, right, null);
		case INT_PMF:
			if (left instanceof IntLiteral) {
				ProbabilityFunctionLiteral rightPMFLiteral = (ProbabilityFunctionLiteral)right;
				ProbabilityFunction rightPMF = rightPMFLiteral.getFunction_ProbabilityFunctionLiteral();
				return handleIntPMFInt((ProbabilityMassFunction) rightPMF,
						(IntLiteral) left, null);
			} else if (right instanceof IntLiteral) {
				ProbabilityFunctionLiteral leftPMFLiteral = (ProbabilityFunctionLiteral)left;
				ProbabilityFunction leftPMF = leftPMFLiteral.getFunction_ProbabilityFunctionLiteral();
				return handleIntPMFInt((ProbabilityMassFunction) leftPMF,
						(IntLiteral) right, null);
			} else if (left instanceof ProbabilityFunctionLiteral
					&& right instanceof ProbabilityFunctionLiteral) {
				ProbabilityFunctionLiteral rightPMFLiteral = (ProbabilityFunctionLiteral)right;
				ProbabilityFunction rightPMF = rightPMFLiteral.getFunction_ProbabilityFunctionLiteral();
				ProbabilityFunctionLiteral leftPMFLiteral = (ProbabilityFunctionLiteral)left;
				ProbabilityFunction leftPMF = leftPMFLiteral.getFunction_ProbabilityFunctionLiteral();
				return handleIntPMFIntPMF((ProbabilityMassFunction)leftPMF, (ProbabilityMassFunction)rightPMF, op);
			} else {
				logger.error("Operation " + op.toString() + " failed!");
				return null;
			}
		case DOUBLE_PMF:
			// TODO
		}
		return null;
	}

	private ProbabilityFunctionLiteral handleIntPMFIntPMF(ProbabilityMassFunction left,
			ProbabilityMassFunction right, IOperation operation) {
		
		ProbabilityMassFunction leftPMF = (ProbabilityMassFunction) left;
		Unit unit = probFuncFactory.createUnit(); //TODO: remove
		unit.setUnitName("sec");
		leftPMF.setUnit(unit);

		ProbabilityMassFunction rightPMF = (ProbabilityMassFunction) right;
		Unit unit2 = probFuncFactory.createUnit(); //TODO: remove
		unit2.setUnitName("sec");
		rightPMF.setUnit(unit2);

		IProbabilityMassFunction iLeftPMF = null;
		IProbabilityMassFunction iRightPMF = null;
		try {
			iLeftPMF = iProbFuncFactory
			.transformToPMF(leftPMF);
			iRightPMF = iProbFuncFactory
			.transformToPMF(rightPMF);
		} catch (ProbabilitySumNotOneException e1) {
			logger.error("Transforming PMF to IPMF failed!");
			e1.printStackTrace();
		}

		IProbabilityMassFunction resultIPMF = null;
		try {
			resultIPMF = operation.opPMFPMF(iLeftPMF, iRightPMF);
		} catch (DifferentDomainsException e) {
			logger.error("Calculation with two PMFs failed!");
			e.printStackTrace();
		}

		ProbabilityMassFunction resultPMF = iProbFuncFactory
				.transformToModelPMF(resultIPMF);

		// TODO: setting ordered domain and unit should already be done by
		// transform method
		resultPMF.setOrderedDomain(resultIPMF.hasOrderedDomain());
		resultPMF.setUnit(unit);

		ProbabilityFunctionLiteral resultPMFLiteral = stocFactory
				.createProbabilityFunctionLiteral();
		resultPMFLiteral.setFunction_ProbabilityFunctionLiteral(resultPMF);

		return resultPMFLiteral;

	}

	/**
	 * @param operation TODO
	 * @param right
	 *            IntPMF
	 * @param left
	 *            IntLiteral
	 * @return
	 */
	private ProbabilityFunctionLiteral handleIntPMFInt(
			ProbabilityMassFunction intPMF, IntLiteral intLiteral,
			IOperation operation) {
		Unit unit = probFuncFactory.createUnit();
		unit.setUnitName("sec");
		intPMF.setUnit(unit);
		
		IProbabilityMassFunction iPMF = null;
		try {
			iPMF = iProbFuncFactory.transformToPMF(intPMF);
		} catch (ProbabilitySumNotOneException e) {
			logger.error("Transforming PMF to IPMF failed!");
			e.printStackTrace();
		}
		int intValue = intLiteral.getValue();

		IProbabilityMassFunction resultIPMF = operation.opPMFInt(iPMF, intValue);

		ProbabilityMassFunction resultPMF = iProbFuncFactory
				.transformToModelPMF(resultIPMF);

		// TODO: setting ordered domain and unit should already be done by
		// transform method
		resultPMF.setOrderedDomain(resultIPMF.hasOrderedDomain());
		Unit unit2 = probFuncFactory.createUnit();
		unit2.setUnitName("sec");
		resultPMF.setUnit(unit2);

		ProbabilityFunctionLiteral resultPMFLiteral = stocFactory
				.createProbabilityFunctionLiteral();
		resultPMFLiteral.setFunction_ProbabilityFunctionLiteral(resultPMF);

		return resultPMFLiteral;
	}

	/**
	 * @param left
	 * @param right
	 * @param operation TODO
	 * @return
	 */
	private DoubleLiteral handleDoubleDouble(Expression left, Expression right,
			IOperation operation) {
		double leftValue = getDoubleFromNumericLiteral(left);
		double rightValue = getDoubleFromNumericLiteral(right);
		double resultValue = operation.opDoubleDouble(leftValue, rightValue);
		
		DoubleLiteral result = stocFactory.createDoubleLiteral();
		result.setValue(resultValue);
		return result;
	}

	/**
	 * @param left
	 * @param right
	 * @param operation TODO
	 * @return
	 */
	private IntLiteral handleIntInt(Expression left, Expression right,
			IOperation operation) {
		int leftValue = ((IntLiteral) left).getValue();
		int rightValue = ((IntLiteral) right).getValue();
		int resultValue = operation.opIntInt(leftValue, rightValue);

		IntLiteral result = stocFactory.createIntLiteral();
		result.setValue(resultValue);
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

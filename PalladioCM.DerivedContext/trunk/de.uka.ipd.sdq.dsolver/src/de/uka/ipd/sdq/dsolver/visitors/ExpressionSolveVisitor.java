package de.uka.ipd.sdq.dsolver.visitors;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.dsolver.operations.AddOperation;
import de.uka.ipd.sdq.dsolver.operations.DivOperation;
import de.uka.ipd.sdq.dsolver.operations.EqualsOperation;
import de.uka.ipd.sdq.dsolver.operations.GreaterEqualOperation;
import de.uka.ipd.sdq.dsolver.operations.GreaterOperation;
import de.uka.ipd.sdq.dsolver.operations.ICompareOperation;
import de.uka.ipd.sdq.dsolver.operations.IOperation;
import de.uka.ipd.sdq.dsolver.operations.LessEqualOperation;
import de.uka.ipd.sdq.dsolver.operations.LessOperation;
import de.uka.ipd.sdq.dsolver.operations.ModOperation;
import de.uka.ipd.sdq.dsolver.operations.MultOperation;
import de.uka.ipd.sdq.dsolver.operations.NotEqualOperation;
import de.uka.ipd.sdq.dsolver.operations.SubOperation;
import de.uka.ipd.sdq.pcm.core.stochastics.CompareExpression;
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

public class ExpressionSolveVisitor extends StochasticsSwitch {

	private static Logger logger = Logger.getLogger(ExpressionSolveVisitor.class
			.getName());

	private ExpressionInferTypeVisitor typeVisitor;

	private IProbabilityFunctionFactory iProbFuncFactory = IProbabilityFunctionFactory.eINSTANCE;

	private ProbfunctionFactory probFuncFactory = ProbfunctionFactory.eINSTANCE;

	private StochasticsFactory stocFactory = StochasticsFactory.eINSTANCE;

	public ExpressionSolveVisitor(Expression expr) {
		typeVisitor = new ExpressionInferTypeVisitor();
		try {
			typeVisitor.doSwitch(expr);
		} catch (Exception e) {
			logger.error("Inferring Expression Types caused Exception!"
					+ e.getMessage());
			e.printStackTrace();
		}
	}

	public Object caseCompareExpression(CompareExpression expr){
		String opName = expr.getOperation().getName();
		ICompareOperation op;
		if (opName.equals("GREATER"))
			op = new GreaterOperation();
		else if(opName.equals("EQUALS"))
			op = new EqualsOperation();
		else if(opName.equals("LESS"))
			op = new LessOperation();
		else if(opName.equals("NOTEQUAL"))
			op = new NotEqualOperation();
		else if(opName.equals("GREATEREQUAL"))
			op = new GreaterEqualOperation();
		else if(opName.equals("LESSEQUAL"))
			op = new LessEqualOperation();
		else
			throw new UnsupportedOperationException();
		
		Expression left = (Expression) doSwitch(expr.getLeft());
		Expression right = (Expression) doSwitch(expr.getRight());
		
		return handleComparison(left, right, op);
	}

	public Object caseTermExpression(TermExpression expr) {
		String opName = expr.getOperation().getName();
		IOperation op;
		if (opName.equals("ADD"))
			op = new AddOperation();
		else if (opName.equals("SUB"))
			op = new SubOperation();
		else
			throw new UnsupportedOperationException();

		Expression left = (Expression) doSwitch(expr.getLeft());
		Expression right = (Expression) doSwitch(expr.getRight());
		TypeEnum exprType = typeVisitor.getTypeAnnotation(expr);

		return handleComputation(exprType, left, right, op);
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
		else 
			throw new UnsupportedOperationException();

		Expression left = (Expression) doSwitch(expr.getLeft());
		Expression right = (Expression) doSwitch(expr.getRight());
		TypeEnum exprType = typeVisitor.getTypeAnnotation(expr);

		return handleComputation(exprType, left, right, op);
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
	 * @param left
	 * @param right
	 * @param op
	 * @return
	 */
	private Object handleComparison(Expression left, Expression right,
			ICompareOperation op) {
		if (isIntDouble(left) && isIntDouble(right))
			return op.compare(extractDoubleFromLiteral(left),
					extractDoubleFromLiteral(right));
		else if (isProbFunc(left) && isIntDouble(right))
			return op.compare(extractIPMFFromLiteral(left),
					extractDoubleFromLiteral(right));
		else if (isIntDouble(left) && isProbFunc(right))
			return op.compare(extractDoubleFromLiteral(left),
					extractIPMFFromLiteral(right));
		else if (isProbFunc(left) && isProbFunc(right))
			return op.compare(extractIPMFFromLiteral(left),
					extractIPMFFromLiteral(right));
		else
			throw new UnsupportedOperationException();
	}

	/**
	 * @param expr
	 * @param op
	 * @return
	 * @throws ProbabilitySumNotOneException
	 */
	private Expression handleComputation(TypeEnum exprType, Expression left,
			Expression right, IOperation op) {
		switch (exprType) {
		case INT:
			return handle(extractIntFromLiteral(left),
					extractIntFromLiteral(right), op);
		case DOUBLE:
			return handle(extractDoubleFromLiteral(left),
					extractDoubleFromLiteral(right), op);
		case INT_PMF:
			if (left instanceof IntLiteral) {
				return handle(extractIPMFFromLiteral(right),
						extractIntFromLiteral(left), op);
			} else if (right instanceof IntLiteral) {
				return handle(extractIPMFFromLiteral(left),
						extractIntFromLiteral(right), op);
			} else if (left instanceof ProbabilityFunctionLiteral
					&& right instanceof ProbabilityFunctionLiteral) {
				return handle(extractIPMFFromLiteral(left),
						extractIPMFFromLiteral(right), op);
			} else 
				throw new UnsupportedOperationException();
		case DOUBLE_PMF:
			// TODO
		}
		return null;
	}

	private ProbabilityFunctionLiteral handle(IProbabilityMassFunction iLeftPMF,
			IProbabilityMassFunction iRightPMF, IOperation operation) {
		IProbabilityMassFunction resultIPMF = null;
		try {
			resultIPMF = operation.compute(iLeftPMF, iRightPMF);
		} catch (DifferentDomainsException e) {
			logger.error("Calculation with two PMFs failed!");
			e.printStackTrace();
		}
		logger.debug("Result: "+resultIPMF.getSamples().toString());
		return createLiteralForIPMF(resultIPMF);
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
	private ProbabilityFunctionLiteral handle(IProbabilityMassFunction iIntPMF,
			int intValue, IOperation operation) {
		IProbabilityMassFunction resultIPMF = null;
		try {
			resultIPMF = operation.compute(iIntPMF, intValue);
		} catch (Exception e) {
			logger.error("Calculation with PMF and int failed!");
			e.printStackTrace();
		}
		logger.debug("Result: "+resultIPMF.getSamples().toString());
		return createLiteralForIPMF(resultIPMF);
	}

	/**
	 * @param left
	 * @param right
	 * @param operation
	 *            TODO
	 * @return
	 */
	private DoubleLiteral handle(double leftValue, double rightValue,
			IOperation operation) {
		DoubleLiteral result = stocFactory.createDoubleLiteral();
		double resultValue = operation.compute(leftValue, rightValue);
		result.setValue(resultValue);
		return result;
	}

	/**
	 * @param left
	 * @param right
	 * @param operation
	 *            TODO
	 * @return
	 */
	private IntLiteral handle(int leftValue, int rightValue,
			IOperation operation) {
		IntLiteral result = stocFactory.createIntLiteral();
		int resultValue = operation.compute(leftValue, rightValue);
		result.setValue(resultValue);
		return result;
	}

	private boolean isProbFunc(Expression expr) {
		return (expr instanceof ProbabilityFunctionLiteral);
	}

	private boolean isIntDouble(Expression expr) {
		return (expr instanceof IntLiteral || expr instanceof DoubleLiteral);		
	}

	/**
	 * @param expr
	 */
	private double extractDoubleFromLiteral(Expression expr) {
		if (expr instanceof IntLiteral) {
			return (double) ((IntLiteral) expr).getValue();
		} else if (expr instanceof DoubleLiteral) {
			return (double) ((DoubleLiteral) expr).getValue();
		} else {
			logger.error("Could not get Double value from NumericLiteral!");
			return 0.0;
		}
	}

	private int extractIntFromLiteral(Expression expr) {
		return ((IntLiteral) expr).getValue();
	}

	private IProbabilityMassFunction extractIPMFFromLiteral(Expression expr) {
		ProbabilityFunctionLiteral probFuncLiteral = (ProbabilityFunctionLiteral)expr;
		ProbabilityMassFunction pmf = (ProbabilityMassFunction)probFuncLiteral.getFunction_ProbabilityFunctionLiteral();
		
		Unit unit = probFuncFactory.createUnit(); // TODO: remove
		unit.setUnitName("sec");
		pmf.setUnit(unit);
		
		return iProbFuncFactory.transformToPMF(pmf);
	}

	/**
	 * @param resultIPMF
	 * @return
	 */
	private ProbabilityFunctionLiteral createLiteralForIPMF(
			IProbabilityMassFunction resultIPMF) {
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

}

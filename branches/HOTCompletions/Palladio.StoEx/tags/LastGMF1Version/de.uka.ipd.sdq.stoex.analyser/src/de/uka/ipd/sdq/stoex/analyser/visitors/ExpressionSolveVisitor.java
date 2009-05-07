package de.uka.ipd.sdq.stoex.analyser.visitors;

import java.util.HashMap;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.probfunction.ProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.ProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.ProbfunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.ISample;
import de.uka.ipd.sdq.probfunction.math.exception.DifferentDomainsException;
import de.uka.ipd.sdq.probfunction.math.exception.DomainNotNumbersException;
import de.uka.ipd.sdq.probfunction.math.exception.DoubleSampleException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInTimeDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionsInDifferenDomainsException;
import de.uka.ipd.sdq.probfunction.math.exception.IncompatibleUnitsException;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilitySumNotOneException;
import de.uka.ipd.sdq.probfunction.math.exception.UnknownPDFTypeException;
import de.uka.ipd.sdq.stoex.BoolLiteral;
import de.uka.ipd.sdq.stoex.CompareExpression;
import de.uka.ipd.sdq.stoex.DoubleLiteral;
import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.IntLiteral;
import de.uka.ipd.sdq.stoex.NumericLiteral;
import de.uka.ipd.sdq.stoex.Parenthesis;
import de.uka.ipd.sdq.stoex.PowerExpression;
import de.uka.ipd.sdq.stoex.ProbabilityFunctionLiteral;
import de.uka.ipd.sdq.stoex.ProductExpression;
import de.uka.ipd.sdq.stoex.StoexFactory;
import de.uka.ipd.sdq.stoex.TermExpression;
import de.uka.ipd.sdq.stoex.Variable;
import de.uka.ipd.sdq.stoex.analyser.operations.AddOperation;
import de.uka.ipd.sdq.stoex.analyser.operations.CompareOperation;
import de.uka.ipd.sdq.stoex.analyser.operations.DivOperation;
import de.uka.ipd.sdq.stoex.analyser.operations.EqualsOperation;
import de.uka.ipd.sdq.stoex.analyser.operations.GreaterEqualOperation;
import de.uka.ipd.sdq.stoex.analyser.operations.GreaterOperation;
import de.uka.ipd.sdq.stoex.analyser.operations.LessEqualOperation;
import de.uka.ipd.sdq.stoex.analyser.operations.LessOperation;
import de.uka.ipd.sdq.stoex.analyser.operations.ModOperation;
import de.uka.ipd.sdq.stoex.analyser.operations.MultOperation;
import de.uka.ipd.sdq.stoex.analyser.operations.NotEqualOperation;
import de.uka.ipd.sdq.stoex.analyser.operations.SubOperation;
import de.uka.ipd.sdq.stoex.analyser.operations.TermProductOperation;
import de.uka.ipd.sdq.stoex.util.StoexSwitch;

public class ExpressionSolveVisitor extends StoexSwitch {

	private static Logger logger = Logger
			.getLogger(ExpressionSolveVisitor.class.getName());

	protected IProbabilityFunctionFactory iProbFuncFactory = 
		IProbabilityFunctionFactory.eINSTANCE;

	protected ProbfunctionFactory probFuncFactory = ProbfunctionFactory.eINSTANCE;

	protected StoexFactory stocFactory = StoexFactory.eINSTANCE;

	protected HashMap<Expression, TypeEnum> typeAnnotation;

	public ExpressionSolveVisitor(HashMap<Expression, TypeEnum> typeAnn) {
		this.typeAnnotation = typeAnn;
	}

	public Object caseCompareExpression(CompareExpression expr){
		String opName = expr.getOperation().getName();
		CompareOperation op;
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
		TermProductOperation op;
		if (opName.equals("ADD"))
			op = new AddOperation();
		else if (opName.equals("SUB"))
			op = new SubOperation();
		else
			throw new UnsupportedOperationException();

		Expression left = (Expression) doSwitch(expr.getLeft());
		Expression right = (Expression) doSwitch(expr.getRight());
		TypeEnum exprType = this.typeAnnotation.get(expr); 

		return handleComputation(exprType, left, right, op);
	}

	public Object caseProductExpression(ProductExpression expr) {
		String opName = expr.getOperation().getName();
		TermProductOperation op;
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
		TypeEnum exprType = this.typeAnnotation.get(expr); 
			

		return handleComputation(exprType, left, right, op);
	}

	@Override
	public Object caseParenthesis(Parenthesis parenthesis) {
		Expression child = (Expression)doSwitch(parenthesis.getInnerExpression());
		return child;
	}

	@Override
	public Object caseVariable(Variable var){
		// Cannot handle variables! Use inheritance to add this.
		return var;
	}
	
	@Override
	public Object caseBoolLiteral(BoolLiteral bl) {
		EqualsOperation eo = new EqualsOperation();
		IProbabilityMassFunction iPMF = null;
		if (bl.isValue()){
			iPMF = eo.getBoolPMF(1.0);
		} else {
			iPMF = eo.getBoolPMF(0.0);
		}
		return createLiteralForIPMF(iPMF);
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

	@Override
	public Object casePowerExpression(PowerExpression expr) {
		Expression base = (Expression) doSwitch(expr.getBase());
		Expression exponent = (Expression) doSwitch(expr.getExponent());
		
		double baseValue = getDoubleFromNumericLiteral(base);
		double exponentValue = getDoubleFromNumericLiteral(exponent);
		
		DoubleLiteral doubleLiteral = StoexFactory.eINSTANCE.createDoubleLiteral();
		doubleLiteral.setValue(Math.pow(baseValue, exponentValue));
		
		return doubleLiteral;
	}

	/**
	 * @param base
	 */
	private double getDoubleFromNumericLiteral(Expression base) {
		
		if (base instanceof IntLiteral){
			IntLiteral intLiteral = (IntLiteral)base;
			Integer intValue = intLiteral.getValue();
			return intValue.doubleValue();
		} else if (base instanceof DoubleLiteral){
			DoubleLiteral doubleLiteral = (DoubleLiteral)base;
			return doubleLiteral.getValue();
		} else
			throw new UnsupportedOperationException();
	}

	/**
	 * @param left
	 * @param right
	 * @param op
	 * @return
	 */
	private Object handleComparison(Expression left, Expression right,
			CompareOperation op) {
		IProbabilityMassFunction iPMF = null;

		if (isIntDouble(left) && isIntDouble(right))
			iPMF = op.compare(extractDoubleFromLiteral(left),
					extractDoubleFromLiteral(right));
		else if (isProbFunc(left) && isIntDouble(right))
			iPMF = op.compare(extractIPMFFromLiteral(left),
					extractDoubleFromLiteral(right));
		else if (isIntDouble(left) && isProbFunc(right))
			iPMF = op.compare(extractDoubleFromLiteral(left),
					extractIPMFFromLiteral(right));
		else if (isProbFunc(left) && isProbFunc(right))
			iPMF = op.compare(extractIPMFFromLiteral(left),
					extractIPMFFromLiteral(right));
		else
			throw new UnsupportedOperationException();
		
		return createLiteralForIPMF(iPMF);
	}

	/**
	 * @param expr
	 * @param op
	 * @return
	 * @throws ProbabilitySumNotOneException
	 */
	private Expression handleComputation(TypeEnum exprType, Expression left,
			Expression right, TermProductOperation op) {

		if (exprType == TypeEnum.ANY_PMF){
			if (left instanceof ProbabilityFunctionLiteral){
				exprType = resolveActualType(exprType, left);
			} else if (right instanceof ProbabilityFunctionLiteral){
				exprType = resolveActualType(exprType, right);
			} else 
				throw new UnsupportedOperationException();
		}
		
		switch (exprType) {
		case INT:
			return handle(extractIntFromLiteral(left),
					extractIntFromLiteral(right), op);
		case DOUBLE:
			return handle(extractDoubleFromLiteral(left),
					extractDoubleFromLiteral(right), op);
		case ANY_PMF:
			throw new UnsupportedOperationException();
		case INT_PMF:
			if (left instanceof IntLiteral && right instanceof IntLiteral){
				// this case can happen because the 
				// typeAnnotation assumes INT_PMF as type
				// for some parameter characterisations
				// where in fact they could be composed just out 
				// of INTs in an expression
				return handle(extractIntFromLiteral(left),
						extractIntFromLiteral(right), op);
			} else if (left instanceof IntLiteral 
					&& right instanceof ProbabilityFunctionLiteral) {
				return handle(extractIPMFFromLiteral(right),extractIntFromLiteral(left), op);
			} else if (left instanceof ProbabilityFunctionLiteral 
					&& right instanceof IntLiteral) {
				return handle(extractIPMFFromLiteral(left),extractIntFromLiteral(right), op);
			} else if (left instanceof ProbabilityFunctionLiteral
					&& right instanceof ProbabilityFunctionLiteral) {
				return handle(extractIPMFFromLiteral(left),extractIPMFFromLiteral(right), op);
			} else 
				throw new UnsupportedOperationException();
		case DOUBLE_PMF:
			if (left instanceof DoubleLiteral && right instanceof DoubleLiteral) {
				return handle(extractDoubleFromLiteral(left), extractDoubleFromLiteral(right), op);
			} else if(left instanceof ProbabilityFunctionLiteral
				&& right instanceof DoubleLiteral){
				return handle(extractIPMFFromLiteral(left),extractDoubleFromLiteral(right), op);					
			} else if(left instanceof DoubleLiteral
				&& right instanceof ProbabilityFunctionLiteral){
				return handle(extractIPMFFromLiteral(right),extractDoubleFromLiteral(left), op);
			} else if(left instanceof ProbabilityFunctionLiteral 
				&& right instanceof ProbabilityFunctionLiteral){
				return handle(extractIPMFFromLiteral(left), extractIPMFFromLiteral(right), op);
			} else 
				throw new UnsupportedOperationException();
		case DOUBLE_PDF:
			if (left instanceof ProbabilityFunctionLiteral){
				if (right instanceof IntLiteral){
					return handle(extractIPDFFromLiteral(left), extractIntFromLiteral(right), op);
				} else if (right instanceof DoubleLiteral){
					return handle(extractIPDFFromLiteral(left), extractDoubleFromLiteral(right), op);
				} else if (right instanceof ProbabilityFunctionLiteral){
					return handle(extractIPDFFromLiteral(left),extractIPDFFromLiteral(right), op);
				} else
					throw new UnsupportedOperationException();
			} else if (right instanceof ProbabilityFunctionLiteral){
				if (left instanceof IntLiteral){
					return handle(extractIPDFFromLiteral(right), extractIntFromLiteral(left), op);	
				} else if (left instanceof DoubleLiteral){
					return handle(extractIPDFFromLiteral(right), extractDoubleFromLiteral(left), op);
				} else
					throw new UnsupportedOperationException();
			} else
				throw new UnsupportedOperationException();
		}
		return null;
	}

	private Expression handle(IProbabilityDensityFunction iLeftPDF, double right, TermProductOperation op) {
		IProbabilityDensityFunction resultIPDF = null;

		try {
			resultIPDF = op.compute(iLeftPDF, right);
		} catch (DomainNotNumbersException e) {
			logger.error("Calculation with PDF and Literal failed!");
			e.printStackTrace();
		}

		logger.debug("Result: "+resultIPDF.toString());

		return createLiteralForIPDF(resultIPDF);
	}

	/**
	 * @param exprType
	 * @param expr
	 * @return
	 */
	private TypeEnum resolveActualType(TypeEnum exprType, Expression expr) {
		IProbabilityMassFunction iPMF = extractIPMFFromLiteral(expr);
		ISample samplePoint = iPMF.getSamples().get(0);
		
		if (samplePoint.getValue() instanceof Integer){
			exprType = TypeEnum.INT_PMF;
		} else if (samplePoint.getValue() instanceof Double){
			exprType = TypeEnum.DOUBLE_PMF;
		}
		return exprType;
	}

	/**
	 * @param iLeftPDF
	 * @param iRightPDF
	 * @param op
	 * @return
	 */
	private Expression handle(IProbabilityDensityFunction iLeftPDF, IProbabilityDensityFunction iRightPDF, TermProductOperation op) {
		IProbabilityDensityFunction resultIPDF = null;
		
		try {
			resultIPDF = op.compute(iLeftPDF, iRightPDF);
		} catch (FunctionsInDifferenDomainsException e){
			logger.error("Calculation with two PDFs failed!");
			e.printStackTrace();
		} catch (UnknownPDFTypeException e){
			logger.error("Calculation with two PDFs failed!");
			e.printStackTrace();
		} catch (IncompatibleUnitsException e){
			logger.error("Calculation with two PDFs failed!");
			e.printStackTrace();
		}
		logger.debug("Result: "+resultIPDF.toString());

		return createLiteralForIPDF(resultIPDF);

	}

	/**
	 * @param resultIPMF
	 * @return
	 */
	private ProbabilityFunctionLiteral createLiteralForIPMF(
			IProbabilityMassFunction resultIPMF) {
		ProbabilityMassFunction resultPMF = iProbFuncFactory
				.transformToModelPMF(resultIPMF);
		ProbabilityFunctionLiteral resultPMFLiteral = stocFactory
				.createProbabilityFunctionLiteral();
		resultPMFLiteral.setFunction_ProbabilityFunctionLiteral(resultPMF);
	
		return resultPMFLiteral;
	}

	/**
	 * @param iPDF
	 * @return
	 */
	private Expression createLiteralForIPDF(IProbabilityDensityFunction iPDF) {
		ProbabilityDensityFunction pdf = null;
		try {
			pdf = iProbFuncFactory.transformToModelPDF(iPDF);
		} catch (UnknownPDFTypeException e) {
			e.printStackTrace();
		} catch (DoubleSampleException e) {
			e.printStackTrace();
		} catch (FunctionNotInTimeDomainException e) {
			e.printStackTrace();
		}
		
		ProbabilityFunctionLiteral resultPDFLiteral = stocFactory.createProbabilityFunctionLiteral();
		resultPDFLiteral.setFunction_ProbabilityFunctionLiteral(pdf);

		return resultPDFLiteral;
	}

	/**
	 * @param iLeftPMF
	 * @param iRightPMF
	 * @param operation
	 * @return
	 */
	private ProbabilityFunctionLiteral handle(IProbabilityMassFunction iLeftPMF,
			IProbabilityMassFunction iRightPMF, TermProductOperation operation) {
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
	 * @param iIntPMF
	 * @param doubleValue
	 * @param operation
	 * @return
	 */
	private ProbabilityFunctionLiteral handle(IProbabilityMassFunction iIntPMF,
			double doubleValue, TermProductOperation operation) {
		IProbabilityMassFunction resultIPMF = null;
		try {
			resultIPMF = operation.compute(iIntPMF, doubleValue);
		} catch (Exception e) {
			logger.error("Calculation with PMF and int failed!");
			e.printStackTrace();
		}
		logger.debug("Result: "+resultIPMF.getSamples().toString());
		return createLiteralForIPMF(resultIPMF);
	}


	/**
	 * @param leftValue
	 * @param rightValue
	 * @param operation
	 * @return
	 */
	private DoubleLiteral handle(double leftValue, double rightValue,
			TermProductOperation operation) {
		DoubleLiteral result = stocFactory.createDoubleLiteral();
		double resultValue = operation.compute(leftValue, rightValue);
		result.setValue(resultValue);
		return result;
	}


	/**
	 * @param leftValue
	 * @param rightValue
	 * @param operation
	 * @return
	 */
	private IntLiteral handle(int leftValue, int rightValue,
			TermProductOperation operation) {
		IntLiteral result = stocFactory.createIntLiteral();
		int resultValue = operation.compute(leftValue, rightValue);
		result.setValue(resultValue);
		return result;
	}

	/**
	 * @param expr
	 * @return
	 */
	private boolean isProbFunc(Expression expr) {
		return (expr instanceof ProbabilityFunctionLiteral);
	}

	/**
	 * @param expr
	 * @return
	 */
	private boolean isIntDouble(Expression expr) {
		return (expr instanceof IntLiteral || expr instanceof DoubleLiteral);		
	}

	/**
	 * @param expr
	 * @return
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

	/**
	 * @param expr
	 * @return
	 */
	private int extractIntFromLiteral(Expression expr) {
		return ((IntLiteral) expr).getValue();
	}

	/**
	 * @param expr
	 * @return
	 */
	private IProbabilityMassFunction extractIPMFFromLiteral(Expression expr) {
		ProbabilityFunctionLiteral probFuncLiteral = (ProbabilityFunctionLiteral)expr;
		ProbabilityMassFunction pmf = (ProbabilityMassFunction)probFuncLiteral.getFunction_ProbabilityFunctionLiteral();
		return iProbFuncFactory.transformToPMF(pmf);
	}

	/**
	 * @param expr
	 * @return
	 */
	private IProbabilityDensityFunction extractIPDFFromLiteral(Expression expr) {
		ProbabilityFunctionLiteral pfl = (ProbabilityFunctionLiteral)expr;
		ProbabilityDensityFunction pdf = (ProbabilityDensityFunction)pfl.getFunction_ProbabilityFunctionLiteral();
		IProbabilityDensityFunction ipdf = null;
		try {
			ipdf = iProbFuncFactory.transformToPDF(pdf);
		} catch (UnknownPDFTypeException e) {
			e.printStackTrace();
		} catch (ProbabilitySumNotOneException e) {
			e.printStackTrace();
		} catch (DoubleSampleException e) {
			e.printStackTrace();
		}
		return ipdf;
	}

}

package de.uka.ipd.sdq.stoex.analyser.visitors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.probfunction.BoxedPDF;
import de.uka.ipd.sdq.probfunction.ContinuousSample;
import de.uka.ipd.sdq.probfunction.ProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.ProbabilityFunction;
import de.uka.ipd.sdq.probfunction.ProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.ProbfunctionFactory;
import de.uka.ipd.sdq.probfunction.Sample;
import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.ISample;
import de.uka.ipd.sdq.probfunction.math.ISamplePDF;
import de.uka.ipd.sdq.probfunction.math.exception.DifferentDomainsException;
import de.uka.ipd.sdq.probfunction.math.exception.DomainNotNumbersException;
import de.uka.ipd.sdq.probfunction.math.exception.DoubleSampleException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionNotInTimeDomainException;
import de.uka.ipd.sdq.probfunction.math.exception.FunctionsInDifferenDomainsException;
import de.uka.ipd.sdq.probfunction.math.exception.IncompatibleUnitsException;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilitySumNotOneException;
import de.uka.ipd.sdq.probfunction.math.exception.UnknownPDFTypeException;
import de.uka.ipd.sdq.stoex.BoolLiteral;
import de.uka.ipd.sdq.stoex.BooleanOperatorExpression;
import de.uka.ipd.sdq.stoex.CompareExpression;
import de.uka.ipd.sdq.stoex.DoubleLiteral;
import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.FunctionLiteral;
import de.uka.ipd.sdq.stoex.IfElseExpression;
import de.uka.ipd.sdq.stoex.IntLiteral;
import de.uka.ipd.sdq.stoex.NotExpression;
import de.uka.ipd.sdq.stoex.NumericLiteral;
import de.uka.ipd.sdq.stoex.Parenthesis;
import de.uka.ipd.sdq.stoex.PowerExpression;
import de.uka.ipd.sdq.stoex.ProbabilityFunctionLiteral;
import de.uka.ipd.sdq.stoex.ProductExpression;
import de.uka.ipd.sdq.stoex.StoexFactory;
import de.uka.ipd.sdq.stoex.StringLiteral;
import de.uka.ipd.sdq.stoex.TermExpression;
import de.uka.ipd.sdq.stoex.Variable;
import de.uka.ipd.sdq.stoex.analyser.operations.AddOperation;
import de.uka.ipd.sdq.stoex.analyser.operations.AndOperation;
import de.uka.ipd.sdq.stoex.analyser.operations.CompareOperation;
import de.uka.ipd.sdq.stoex.analyser.operations.DivOperation;
import de.uka.ipd.sdq.stoex.analyser.operations.EqualsOperation;
import de.uka.ipd.sdq.stoex.analyser.operations.GreaterEqualOperation;
import de.uka.ipd.sdq.stoex.analyser.operations.GreaterOperation;
import de.uka.ipd.sdq.stoex.analyser.operations.LessEqualOperation;
import de.uka.ipd.sdq.stoex.analyser.operations.LessOperation;
import de.uka.ipd.sdq.stoex.analyser.operations.LogicalOperation;
import de.uka.ipd.sdq.stoex.analyser.operations.ModOperation;
import de.uka.ipd.sdq.stoex.analyser.operations.MultOperation;
import de.uka.ipd.sdq.stoex.analyser.operations.NotEqualOperation;
import de.uka.ipd.sdq.stoex.analyser.operations.OrOperation;
import de.uka.ipd.sdq.stoex.analyser.operations.SubOperation;
import de.uka.ipd.sdq.stoex.analyser.operations.TermProductOperation;
import de.uka.ipd.sdq.stoex.analyser.probfunction.ProbfunctionHelper;
import de.uka.ipd.sdq.stoex.util.StoexSwitch;

/**
 * A visitor for stochastic expressions, which evaluates
 * the operations within a expression and returns the
 * resulting expression, which does not contain any operation
 * any more.
 * For example, when a stochastic expression contains a 
 * division operation between a INT_PMF and a constant it
 * returns an INT_PMF divided by the constant.
 * The visitor is invoked as usual via the 
 * doSwitch(Expression toSolve) command. It returns the solved
 * expression. 
 * This class uses the operations in 
 * de.uka.ipd.sdq.stoex.analyser.operations as an interface
 * to the probability function package.
 * 
 * @author koziolek
 */
public class ExpressionSolveVisitor extends StoexSwitch<Object> {

	private static Logger logger = Logger
			.getLogger(ExpressionSolveVisitor.class.getName());
	
	/**
	 * For the Trunc function with a DoublePDF parameter, the DoublePDF is 
	 * transformed into an IntPMF. Here, a sample is generated for each 
	 * integer lying in the range of the DoublePDF. This can easily cause an
	 * OutOfMemoryException, thus, we constraint the maximum number of samples here. 
	 * Then, only each e.g. third integer value is used if the interval is too large 
	 */
	private static final int MAX_NUMBER_OF_SAMPLES_FOR_TRUNC =1000;

	protected IProbabilityFunctionFactory iProbFuncFactory = 
		IProbabilityFunctionFactory.eINSTANCE;

	protected ProbfunctionFactory probFuncFactory = ProbfunctionFactory.eINSTANCE;

	protected StoexFactory stocFactory = StoexFactory.eINSTANCE;

	protected HashMap<Expression, TypeEnum> typeAnnotation;

	/**
	 * Constructor storing the evaluated type annotations.
	 * @param typeAnn
	 */
	public ExpressionSolveVisitor(HashMap<Expression, TypeEnum> typeAnn) {
		this.typeAnnotation = typeAnn;
	}

	/**
	 * Performs compare operations.
	 */
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

	/**
	 * Performs logical operations (AND, OR).
	 */
	public Object caseBooleanOperatorExpression(BooleanOperatorExpression expr) {

		String opName = expr.getOperation().getName();
		LogicalOperation op;
		if (opName.equals("AND"))
			op = new AndOperation();
		else if(opName.equals("OR"))
			op = new OrOperation();
		else
			throw new UnsupportedOperationException();

		Expression left = (Expression) doSwitch(expr.getLeft());
		Expression right = (Expression) doSwitch(expr.getRight());

		return handleLogical(left, right, op);
	}

	/**
	 * Performs term operations (ADD, SUB)
	 */
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
	
	/**
	 * Performs product operations (MULT, DIV, MOD).
	 */
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
	public Object caseIfElseExpression(IfElseExpression expr) {

		// first get the probability function from the condition expression and determine the if-probability
		ProbabilityFunctionLiteral conditionExpr = (ProbabilityFunctionLiteral) doSwitch(expr.getConditionExpression());
		ProbabilityMassFunction pmf = (ProbabilityMassFunction)conditionExpr.getFunction_ProbabilityFunctionLiteral();
		 
		double ifProb = 1.0;
		List<Sample> points = pmf.getSamples();
		for (Sample point : points) {
			String bool = point.getValue().toString();
			if (bool.toLowerCase().equals("true")) {
				ifProb = point.getProbability();
			}
		}
		
		// now build a new DoublePMF to replace the IfElseExpression
		Expression ifExpr = (Expression) doSwitch(expr.getIfExpression());
		Expression elseExpr = (Expression) doSwitch(expr.getElseExpression());
		
		if (ifExpr instanceof NumericLiteral && elseExpr instanceof NumericLiteral){
			// we only support NumericLiterals here, i.e., INT or DOUBLE. 
			List<ISample> newPoints = new ArrayList<ISample>();
			double ifValue = getDoubleFromNumericLiteral(ifExpr);
			newPoints.add(iProbFuncFactory.createSample(ifValue, ifProb));
			double elseValue = getDoubleFromNumericLiteral(elseExpr);
			newPoints.add(iProbFuncFactory.createSample(elseValue, 1-ifProb));
			
			IProbabilityMassFunction iPMF = iProbFuncFactory.createProbabilityMassFunction(newPoints, null, false);
			ProbabilityMassFunction resultPMF = iProbFuncFactory.transformToModelPMF(iPMF);
			ProbabilityFunctionLiteral resultPMFLiteral = stocFactory.createProbabilityFunctionLiteral();
			resultPMFLiteral.setFunction_ProbabilityFunctionLiteral(resultPMF);
			return resultPMFLiteral;
		} else 
			// any probability functions involved are not supported:
			throw new UnsupportedOperationException();
	}

	/** 
	 * Forwards the visitor to the inner expression within the parenthesis.
	 */
	public Object caseParenthesis(Parenthesis parenthesis) {
		Expression child = (Expression)doSwitch(parenthesis.getInnerExpression());
		return child;
	}

	/** 
	 * Skips variables. This visitor cannot handle variables. Use the
	 * PCM Solver to handle variables in stochastic expressions.
	 */
	public Object caseVariable(Variable var){
		// Cannot handle variables! Use inheritance to add this.
		return var;
	}
	
	/**
	 * Creates a BoolPMF for the given BoolLiteral.
	 */
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

	/**
	 * Just returns the given int literal.
	 */
	public Object caseIntLiteral(IntLiteral il) {
		return il;
	}

	/**
	 * Just returns the given double literal.
	 */
	public Object caseDoubleLiteral(DoubleLiteral dl) {
		return dl;
	}

	
	@Override
	public Object caseStringLiteral(StringLiteral object) {
		// TODO Auto-generated method stub
		return object;
	}

	/**
	 * Just returns the given probfunction literal.
	 */
	public Object caseProbabilityFunctionLiteral(
			ProbabilityFunctionLiteral probFuncLit) {
		return probFuncLit;
	}

	/**
	 * Performs a power operation (only for constants).
	 */
	public Object casePowerExpression(PowerExpression expr) {
		Expression base = (Expression) doSwitch(expr.getBase());
		Expression exponent = (Expression) doSwitch(expr.getExponent());
		
		double baseValue = getDoubleFromNumericLiteral(base);
		double exponentValue = getDoubleFromNumericLiteral(exponent);
		
		DoubleLiteral doubleLiteral = StoexFactory.eINSTANCE.createDoubleLiteral();
		doubleLiteral.setValue(Math.pow(baseValue, exponentValue));
		
		return doubleLiteral;
	}
	
	@Override
	public ProbabilityFunctionLiteral caseFunctionLiteral(FunctionLiteral object) {
		for (Expression e : object.getParameters_FunctionLiteral())
			doSwitch(e);
		
		List<Expression> parameterList = new ArrayList<Expression>();
		for (Expression parameter : object.getParameters_FunctionLiteral()) {
			parameterList.add((Expression)doSwitch(parameter));
		}
		
		if (ProbfunctionHelper.isFunctionID(object.getId())){
			ProbabilityFunction func = ProbfunctionHelper.createFunction(parameterList, object.getId(), probFuncFactory);
			ProbabilityFunctionLiteral literal = StoexFactory.eINSTANCE.createProbabilityFunctionLiteral();
			literal.setFunction_ProbabilityFunctionLiteral(func);
			return literal;
		} else	if (object.getId().equals("Trunc")) {
			//Create an equivalent ProbabilityMassFunction or Integer from the given expression.
			
			//Trunc must only have one parameter 
			if (object.getParameters_FunctionLiteral().size() == 1){
				Expression solvedParam = parameterList.get(0);
				//Parameter for Trunc must can be a DoublePDF or a DoubleLiteral? 
				if (solvedParam instanceof ProbabilityFunctionLiteral){
					ProbabilityFunctionLiteral pfl = (ProbabilityFunctionLiteral)solvedParam;
					ProbabilityFunction insideFunction = pfl.getFunction_ProbabilityFunctionLiteral();
					if (insideFunction instanceof BoxedPDF){
						//create a ProbabilityMassFunction for this BoxedPDF
						return truncPMFFromBoxedPDF((BoxedPDF)insideFunction, object);
					}
				} else if (solvedParam instanceof DoubleLiteral) {
						IntLiteral intLit = StoexFactory.eINSTANCE.createIntLiteral();
						intLit.setValue((int)Math.round(((DoubleLiteral)solvedParam).getValue()));
				} else
					throw new ExpressionSolvingFailedException("Function Trunc is only supported supported for a DoublePDF or a single double parameter!", object);
			}
		}  else 
			throw new UnsupportedOperationException("Function "+object.getId()+" not supported!");
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Not Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation casts the result of its inner expression to boolean and returns the 
	 * resulting values. If it cannot be cast to Boolean or BoolPMF, an exception is thrown. 
	 * <!-- end-user-doc -->
	 * @param notExpression the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Not Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	@Override
	public Object caseNotExpression(NotExpression notExpression) {
		Expression child = (Expression)doSwitch(notExpression.getInner());
		
		if (child instanceof ProbabilityFunctionLiteral){
			IProbabilityMassFunction massFunction = extractIPMFFromLiteral(child);
			IProbabilityMassFunction invertedFunction = CompareOperation.invertBoolPMF(massFunction);
			return createLiteralForIPMF(invertedFunction);
			
		} else {
			throw new UnsupportedComputationException(notExpression, "NOT");
		}

	}


	/**
	 * Converts a PDF to an IntPMF for the Trunc function. This is just a rough estimates. Especially for small values, it is far from the original. 
	 * 
	 * The Boundaries of the PDF are rounded down to the next integer. Then, the possible integer values are evenly distributed with the probability of the respective ContinousSample.
	 * If no integer value exists between two ContinousSamples, their probabilities are added. 
	 * 
	 * In this way, the distribution is changed a lot for small values. For large values, it does not matter. 
	 * 
	 * If the range of the whole PDF is too small, the closest surrounding integers is used with probability one.   
	 *   
	 * Maybe this should be moved in the probfunction package. 
	 * 
	 * @param pdf
	 * @param object
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private ProbabilityFunctionLiteral truncPMFFromBoxedPDF(BoxedPDF pdf, FunctionLiteral object) {
		
		List<ContinuousSample> samples = pdf.getSamples();
		
		if (samples.size() == 0){
			throw new ExpressionSolvingFailedException("Cannot handle an empty DoublePDF for Trunc.",object);
		}
		double leftBorder = samples.get(0).getProbability() > 0 ? samples.get(0).getValue() : 0;
		int range = (int)Math.ceil(samples.get(samples.size()-1).getValue() - leftBorder);
		
		int distance = range / MAX_NUMBER_OF_SAMPLES_FOR_TRUNC + 1;
		
		ISamplePDF samplePDF = null;
		try {
			samplePDF = iProbFuncFactory.transformToSamplePDF(iProbFuncFactory.transformToPDF(pdf),distance);
		} catch (Exception e) {
			throw new ExpressionSolvingFailedException(object, e);
		} 
		
		if (samplePDF.getLowerDomainBorder() < 0){
			throw new ExpressionSolvingFailedException("Cannot Trunc a DoublePDF with negative values.",object);
		}
		if (samplePDF.getDistance() != distance){
			throw new ExpressionSolvingFailedException("Bug! Distance of SamplePDF is not "+distance, object);
		}
		
		ProbabilityMassFunction pmf = this.probFuncFactory.createProbabilityMassFunction();
		
		pmf.setOrderedDomain(true);
		List<Double> probabilities = samplePDF.getValuesAsDouble();
		
		//TODO: There is a bug in the probfunction stuff
		// input Trunc(DoublePDF[ (0.2; 0.30000000) (1.7; 0.20000000) (2.7; 0.50000000) ])
		// results in IntPMF[ (0;1.0899999999999999) (1;0.13333333333333333) (2;0.4266666666666666) (3;0.10000000000000006) ]
		// not too bad, but wrong. 
		int numberOfSamples = samplePDF.numberOfSamples();
		for (int i = 0; i < numberOfSamples; i++){
			Sample sample = this.probFuncFactory.createSample();
			sample.setProbability(probabilities.get(i));
			sample.setValue(i*distance);
			pmf.getSamples().add(sample);
		}
		
		ProbabilityFunctionLiteral literal = StoexFactory.eINSTANCE.createProbabilityFunctionLiteral();
		literal.setFunction_ProbabilityFunctionLiteral(pmf);
		
		logger.debug("Trunc result: "+new StoExPrettyPrintVisitor().prettyPrint(literal));
		
		return literal;
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
		else if (isString(left) && isString(right))
			iPMF = op.compare(extractStringFromLiteral(left),
					extractStringFromLiteral(right));
		else if (isString(left) && isProbFunc(right))
			iPMF = op.compare(extractStringFromLiteral(left),
					extractIPMFFromLiteral(right));
		else if (isString(right) && isProbFunc(left))
			iPMF = op.compare(extractStringFromLiteral(right),
					extractIPMFFromLiteral(left));
		else
			throw new UnsupportedOperationException();
		
		return createLiteralForIPMF(iPMF);
	}

	private Object handleLogical(Expression left, Expression right,
			LogicalOperation op) {
		IProbabilityMassFunction iPMF = null;
		if (isProbFunc(left) && isProbFunc(right))
			iPMF = op.evaluate(extractIPMFFromLiteral(left),
					extractIPMFFromLiteral(right));
		else
			throw new UnsupportedOperationException();
		
		return createLiteralForIPMF(iPMF);
	}

	private String extractStringFromLiteral(Expression left) {
		return ((StringLiteral)left).getValue();
	}

	private boolean isString(Expression expr) {
		return expr instanceof StringLiteral;
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
			} else if (left instanceof FunctionLiteral){
				exprType = ProbfunctionHelper.isFunctionID(((FunctionLiteral)left).getId()) ? TypeEnum.CONTINOUS_PROBFUNCTION : TypeEnum.AUX_FUNCTION;
			} else if (right instanceof FunctionLiteral){
				exprType = ProbfunctionHelper.isFunctionID(((FunctionLiteral)right).getId()) ? TypeEnum.CONTINOUS_PROBFUNCTION : TypeEnum.AUX_FUNCTION;
			} else if (left instanceof IntLiteral && right instanceof IntLiteral){
				//both are integers
				exprType = TypeEnum.INT;
			} else if (left instanceof NumericLiteral && right instanceof NumericLiteral){
				//both are double, or one is int, the other double. 
				exprType = TypeEnum.DOUBLE;
			} else 
				throw new UnsupportedComputationException(right, left, op, exprType);
		}
		
		switch (exprType) {
		case INT:
			return handle(extractIntFromLiteral(left),
					extractIntFromLiteral(right), op);
		case DOUBLE:
			return handle(extractDoubleFromLiteral(left),
					extractDoubleFromLiteral(right), op);
		case ANY_PMF:
			throw new UnsupportedComputationException(right, left, op, exprType);
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
				throw new UnsupportedComputationException(right, left, op, exprType);
		case DOUBLE_PMF:
			if (left instanceof NumericLiteral && right instanceof NumericLiteral) {
				return handle(extractDoubleFromLiteral(left), extractDoubleFromLiteral(right), op);
			} else if(left instanceof ProbabilityFunctionLiteral
				&& right instanceof NumericLiteral){
				return handle(extractIPMFFromLiteral(left),extractDoubleFromLiteral(right), op);					
			} else if(left instanceof NumericLiteral
				&& right instanceof ProbabilityFunctionLiteral){
				return handle(extractIPMFFromLiteral(right),extractDoubleFromLiteral(left), op);
			} else if(left instanceof ProbabilityFunctionLiteral 
				&& right instanceof ProbabilityFunctionLiteral){
				return handle(extractIPMFFromLiteral(left), extractIPMFFromLiteral(right), op);
			} else 
				throw new UnsupportedComputationException(right, left, op, exprType);
		case DOUBLE_PDF:
			if (left instanceof ProbabilityFunctionLiteral){
				if (right instanceof IntLiteral){
					return handle(extractIPDFFromLiteral(left), extractIntFromLiteral(right), op);
				} else if (right instanceof DoubleLiteral){
					return handle(extractIPDFFromLiteral(left), extractDoubleFromLiteral(right), op);
				} else if (right instanceof ProbabilityFunctionLiteral){
					return handle(extractIPDFFromLiteral(left),extractIPDFFromLiteral(right), op);
				} else
					throw new UnsupportedComputationException(right, left, op, exprType);
			} else if (right instanceof ProbabilityFunctionLiteral){
				if (left instanceof IntLiteral){
					return handle(extractIPDFFromLiteral(right), extractIntFromLiteral(left), op);	
				} else if (left instanceof DoubleLiteral){
					return handle(extractIPDFFromLiteral(right), extractDoubleFromLiteral(left), op);
				} else
					throw new UnsupportedComputationException(right, left, op, exprType);
			} else
				throw new UnsupportedComputationException(right, left, op, exprType);
		case CONTINOUS_PROBFUNCTION:
			if (left instanceof FunctionLiteral){
				if (right instanceof IntLiteral) {
					double rightDouble = ((IntLiteral)right).getValue();
					return handle(extractIPDFFromLiteral(caseFunctionLiteral((FunctionLiteral) left)),rightDouble, op);
				} else if (right instanceof DoubleLiteral){
					double rightDouble = ((DoubleLiteral)right).getValue();
					return handle(extractIPDFFromLiteral(caseFunctionLiteral((FunctionLiteral) left)),rightDouble, op);
				}	else throw new UnsupportedOperationException("I can only apply operation "+op.getClass().getName()+" to a function and an number, not more.");
			} if (right instanceof FunctionLiteral){
				if (left instanceof IntLiteral){
					double leftDouble = ((IntLiteral)left).getValue();
					return handle(extractIPDFFromLiteral(caseFunctionLiteral((FunctionLiteral) right)),leftDouble, op);	
				} else if (left instanceof DoubleLiteral){
					double leftDouble = ((DoubleLiteral)left).getValue();
					return handle(extractIPDFFromLiteral(caseFunctionLiteral((FunctionLiteral) right)),leftDouble, op);
				} else throw new UnsupportedOperationException("I can only apply operation "+op.getClass().getName()+" to a function and an number, not more.");
			} else throw new UnsupportedComputationException(right, left, op, exprType);
		case AUX_FUNCTION:
			//TODO: 
			throw new UnsupportedOperationException("It is not yet supported to do calculations with auxiliary functions.");
			
		}
		return null;

	}

	private TypeEnum getFunctionType(Expression right) {
		// TODO Auto-generated method stub
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
		return createLiteralForIPDF(resultIPDF);
	}

	/**
	 * @param exprType
	 * @param expr
	 * @return
	 */
	private TypeEnum resolveActualType(TypeEnum exprType, Expression expr) {
		ProbabilityFunctionLiteral pfl = (ProbabilityFunctionLiteral)expr;
		ProbabilityFunction probFunc = pfl.getFunction_ProbabilityFunctionLiteral();
		
		if (probFunc instanceof ProbabilityMassFunction){
			IProbabilityMassFunction iPMF = extractIPMFFromLiteral(expr);
			ISample samplePoint = iPMF.getSamples().get(0);
			
			if (samplePoint.getValue() instanceof Integer){
				exprType = TypeEnum.INT_PMF;
			} else if (samplePoint.getValue() instanceof Double){
				exprType = TypeEnum.DOUBLE_PMF;
			}
			return exprType;
		} else if (probFunc instanceof ProbabilityDensityFunction){
			return TypeEnum.DOUBLE_PDF;
		} else
			throw new UnsupportedOperationException();
		
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
		//logger.debug("Result: "+resultIPDF.toString());

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
			throw new RuntimeException(e);
		}
		//logger.debug("Result: "+resultIPMF.getSamples().toString());
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
		//logger.debug("Result: "+resultIPMF.getSamples().toString());
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
		ProbabilityFunction function = probFuncLiteral.getFunction_ProbabilityFunctionLiteral();
		if (function instanceof ProbabilityMassFunction){
			ProbabilityMassFunction pmf = (ProbabilityMassFunction)function;
			return iProbFuncFactory.transformToPMF(pmf);
		} else if (function instanceof ProbabilityDensityFunction){
			String msg = "Could not transform expression to PMF. Note that NUMBER_OF_ELEMENT and BYTESIZE characterisations are assumed to be PMFs and must not be PDFs. Maybe you need to fix your models here.";
			logger.error(msg);
			throw new TypeInferenceFailedException(expr, msg);
		} else {
			String msg = "Unknown ProbabilityFunction subclass "+function.getClass().getName()+" that cannot be handled by "+this.getClass().getName();
			logger.error(msg);
			throw new TypeInferenceFailedException(expr, msg);
		}
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

class UnsupportedComputationException extends UnsupportedOperationException {


	public UnsupportedComputationException(Expression right, Expression left,
			TermProductOperation op, TypeEnum exprType) {
		super("Cannot compute operation "+op+" with expression type "+exprType+" on expressions "+right.getClass()+" and "+left.getClass());
	}
	
	public UnsupportedComputationException(Expression exp,
			String op) {
		super("Cannot compute operation "+op+" on expression "+exp.getClass());
	}
	

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 653425379466321794L;
	
	
}



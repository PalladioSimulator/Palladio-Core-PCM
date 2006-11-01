package de.uka.ipd.sdq.dsolver.visitors;

import java.util.HashMap;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.core.stochastics.CompareExpression;
import de.uka.ipd.sdq.pcm.core.stochastics.DoubleLiteral;
import de.uka.ipd.sdq.pcm.core.stochastics.Expression;
import de.uka.ipd.sdq.pcm.core.stochastics.IntLiteral;
import de.uka.ipd.sdq.pcm.core.stochastics.ProbabilityFunctionLiteral;
import de.uka.ipd.sdq.pcm.core.stochastics.ProductExpression;
import de.uka.ipd.sdq.pcm.core.stochastics.ProductOperations;
import de.uka.ipd.sdq.pcm.core.stochastics.StochasticsFactory;
import de.uka.ipd.sdq.pcm.core.stochastics.TermExpression;
import de.uka.ipd.sdq.pcm.core.stochastics.TermOperations;
import de.uka.ipd.sdq.pcm.core.stochastics.util.StochasticsSwitch;
import de.uka.ipd.sdq.probfunction.ProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.ProbabilityFunction;
import de.uka.ipd.sdq.probfunction.ProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.Sample;

public class ExpressionInferTypeVisitor extends StochasticsSwitch {

	private static Logger logger = Logger.getLogger(ExpressionInferTypeVisitor.class.getName());
	
	private HashMap<Expression, TypeEnum> typeAnnotation = new HashMap<Expression, TypeEnum>();
	
	public Object caseCompareExpression(CompareExpression expr){
		doSwitch(expr.getLeft());
		doSwitch(expr.getRight());

		typeAnnotation.put(expr, TypeEnum.DOUBLE);
		return expr; 
	}
	
	public Object caseProductExpression(ProductExpression expr){
		TypeEnum leftType = getTypeOfChild((Expression)expr.getLeft());
		TypeEnum rightType = getTypeOfChild((Expression)expr.getRight());
		
		ProductOperations op = expr.getOperation();  
		if (op.getName().equals("MULT")){
			// may result in ints or doubles
			inferIntAndDouble(expr, leftType, rightType);
		} else if (op.getName().equals("DIV")){
			// always results in doubles
			inferDouble(expr, leftType, rightType);
		} else if (op.getName().equals("MOD")){
			//TODO
			throw new UnsupportedOperationException();
		} else
			throw new UnsupportedOperationException();
		logger.debug(expr.getOperation().toString());

		return expr;
	}

	public Object caseTermExpression(TermExpression expr){
		TypeEnum leftType = getTypeOfChild((Expression)expr.getLeft());
		TypeEnum rightType = getTypeOfChild((Expression)expr.getRight());
		
		TermOperations op = expr.getOperation();
		if (op.getName().equals("ADD") || op.getName().equals("SUB")) {
			// may result in ints or doubles
			inferIntAndDouble(expr, leftType, rightType);
		} else
			throw new UnsupportedOperationException();
		logger.debug(expr.getOperation().toString());

		return expr;
	}

	public Object caseProbabilityFunctionLiteral(ProbabilityFunctionLiteral pfl){
		ProbabilityFunction pf = pfl.getFunction_ProbabilityFunctionLiteral();
		if (pf instanceof ProbabilityMassFunction){
			ProbabilityMassFunction pmf = (ProbabilityMassFunction)pf;
			Sample firstSample = (Sample)pmf.getSamples().get(0);
			Object value = firstSample.getValue();
			if (value instanceof Integer){
				typeAnnotation.put(pfl, TypeEnum.INT_PMF);
			} else if (value instanceof Double){
				typeAnnotation.put(pfl, TypeEnum.DOUBLE_PMF);
			} else if (value instanceof String){
				typeAnnotation.put(pfl, TypeEnum.ENUM_PMF);
			} else {
				logger.error("Could not determine type of PMF!");
			}
		} else if (pf instanceof ProbabilityDensityFunction){
			typeAnnotation.put(pfl, TypeEnum.DOUBLE_PDF); //TODO
		} else {
			logger.error("Could not determine type of ProbabilityFunctionLiteral!");
		}
		return pfl;
	}

	public Object caseIntLiteral(IntLiteral il){
		typeAnnotation.put(il, TypeEnum.INT);
		return il;
	}

	public Object caseDoubleLiteral(DoubleLiteral dl){
		typeAnnotation.put(dl, TypeEnum.DOUBLE);
		return dl;
	}

	/**
	 * @param expr
	 * @param leftType
	 * @param rightType
	 */
	private void inferIntAndDouble(Expression expr, TypeEnum leftType, TypeEnum rightType) {
		if (leftType == TypeEnum.INT && rightType == TypeEnum.INT){
			typeAnnotation.put(expr, TypeEnum.INT);
		} else if (isIntPMF(leftType) && isIntPMF(rightType)){
			typeAnnotation.put(expr, TypeEnum.INT_PMF);
		} else
			inferDouble(expr, leftType, rightType);
	}

	/**
	 * @param expr
	 * @param leftType
	 * @param rightType
	 */
	private void inferDouble(Expression expr, TypeEnum leftType, TypeEnum rightType) {
		if (isNumeric(leftType) && isNumeric(rightType)){
			typeAnnotation.put(expr, TypeEnum.DOUBLE);
		} else if (isDoubleIntPMF(leftType) && isDoubleIntPMF(rightType)){
			typeAnnotation.put(expr, TypeEnum.DOUBLE_PMF);
		} else {
			throw new UnsupportedOperationException();
		}
	}

	/**
	 * @param expr
	 * @return
	 */
	private TypeEnum getTypeOfChild(Expression expr) {
		Expression left = (Expression)doSwitch(expr);
		TypeEnum leftType = typeAnnotation.get(left);
		return leftType;
	}
	
	private boolean isIntPMF(TypeEnum type) {
		return (type == TypeEnum.INT || type == TypeEnum.INT_PMF);
	}

	private boolean isDoubleIntPMF(TypeEnum type) {
		return (type == TypeEnum.DOUBLE || type == TypeEnum.INT
				|| type == TypeEnum.INT_PMF || type == TypeEnum.DOUBLE_PMF);
	
	}

	private boolean isNumeric(TypeEnum inferedType) {
		return (inferedType == TypeEnum.INT || inferedType == TypeEnum.DOUBLE);
	}
	
	public TypeEnum getTypeAnnotation(Expression expr) {
		return typeAnnotation.get(expr);
	}
	
}

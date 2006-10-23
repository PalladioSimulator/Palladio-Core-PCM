package de.uka.ipd.sdq.dsolver.visitors;

import java.util.HashMap;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.core.stochastics.DoubleLiteral;
import de.uka.ipd.sdq.pcm.core.stochastics.Expression;
import de.uka.ipd.sdq.pcm.core.stochastics.IntLiteral;
import de.uka.ipd.sdq.pcm.core.stochastics.ProbabilityFunctionLiteral;
import de.uka.ipd.sdq.pcm.core.stochastics.ProductExpression;
import de.uka.ipd.sdq.pcm.core.stochastics.ProductOperations;
import de.uka.ipd.sdq.pcm.core.stochastics.util.StochasticsSwitch;
import de.uka.ipd.sdq.probfunction.ProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.ProbabilityFunction;
import de.uka.ipd.sdq.probfunction.ProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.Sample;

public class ExpressionTypeSwitch extends StochasticsSwitch {

	private static Logger logger = Logger.getLogger(ExpressionTypeSwitch.class.getName());
	
	private HashMap<Expression, TypeEnum> typeAnnotation = new HashMap<Expression, TypeEnum>();
	
	public Object caseProductExpression(ProductExpression expr){
		Expression left = (Expression)doSwitch(expr.getLeft());
		TypeEnum leftType = typeAnnotation.get(left);
		Expression right = (Expression)doSwitch(expr.getRight());
		TypeEnum rightType = typeAnnotation.get(right);
		
		ProductOperations op = expr.getOperation();  
		if (op.getName().equals("MULT")){
			if (leftType == TypeEnum.INT && rightType == TypeEnum.INT){
				typeAnnotation.put(expr, TypeEnum.INT);
				return expr;
			} else if (isNumeric(leftType) && isNumeric(rightType)){
				typeAnnotation.put(expr, TypeEnum.DOUBLE);
				return expr;
			} else if ((leftType == TypeEnum.INT_PMF 	&& rightType == TypeEnum.INT)
					|| (leftType == TypeEnum.INT 		&& rightType == TypeEnum.INT_PMF)
					|| (leftType == TypeEnum.INT_PMF 	&& rightType == TypeEnum.INT_PMF)){
				typeAnnotation.put(expr, TypeEnum.INT_PMF);
				return expr;
			} else if ((leftType == TypeEnum.DOUBLE_PMF && rightType == TypeEnum.INT)
					|| (leftType == TypeEnum.INT 		&& rightType == TypeEnum.DOUBLE_PMF)
					|| (leftType == TypeEnum.INT_PMF 	&& rightType == TypeEnum.DOUBLE)
					|| (leftType == TypeEnum.DOUBLE 	&& rightType == TypeEnum.INT_PMF)
					|| (leftType == TypeEnum.DOUBLE_PMF && rightType == TypeEnum.DOUBLE)
					|| (leftType == TypeEnum.DOUBLE 	&& rightType == TypeEnum.DOUBLE_PMF)
					|| (leftType == TypeEnum.DOUBLE_PMF && rightType == TypeEnum.DOUBLE_PMF)){
				typeAnnotation.put(expr, TypeEnum.DOUBLE_PMF);
				return expr;
			} else {
				logger.error("Product operation on "+leftType.toString()+
						" and "+rightType.toString()+" is not supported!");
			}
		} else if (op.getName().equals("DIV")){
			logger.error("Operation DIV not supported yet!");
		} else if (op.getName().equals("MOD")){
			logger.error("Operation MOD not supported yet!");
		} else {
			logger.error("Unknown Operation!");
		}
		
		
		logger.debug(expr.getLeft().toString());
		logger.debug(expr.getOperation().toString());
		logger.debug(expr.getRight().toString());
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
	
	private boolean isNumeric(TypeEnum inferedType) {
		return (inferedType == TypeEnum.INT || inferedType == TypeEnum.DOUBLE);
	}
	
	public TypeEnum getTypeAnnotation(Expression expr) {
		return typeAnnotation.get(expr);
	}
	
}

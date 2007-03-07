package de.uka.ipd.sdq.stoex.analyser.visitors;

import java.util.HashMap;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.parameter.CharacterisedVariable;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType;
import de.uka.ipd.sdq.probfunction.ProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.ProbabilityFunction;
import de.uka.ipd.sdq.probfunction.ProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.Sample;
import de.uka.ipd.sdq.stoex.BoolLiteral;
import de.uka.ipd.sdq.stoex.CompareExpression;
import de.uka.ipd.sdq.stoex.DoubleLiteral;
import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.IntLiteral;
import de.uka.ipd.sdq.stoex.Parenthesis;
import de.uka.ipd.sdq.stoex.PowerExpression;
import de.uka.ipd.sdq.stoex.ProbabilityFunctionLiteral;
import de.uka.ipd.sdq.stoex.ProductExpression;
import de.uka.ipd.sdq.stoex.ProductOperations;
import de.uka.ipd.sdq.stoex.TermExpression;
import de.uka.ipd.sdq.stoex.TermOperations;
import de.uka.ipd.sdq.stoex.Variable;
import de.uka.ipd.sdq.stoex.util.StoexSwitch;

public class ExpressionInferTypeVisitor extends StoexSwitch {

	private static Logger logger = Logger
			.getLogger(ExpressionInferTypeVisitor.class.getName());
	
	private HashMap<Expression, TypeEnum> typeAnnotation = 
		new HashMap<Expression, TypeEnum>();

	public ExpressionInferTypeVisitor(){
	}
	
	public Object caseCompareExpression(CompareExpression expr){
		doSwitch(expr.getLeft());
		doSwitch(expr.getRight());

		typeAnnotation.put(expr, TypeEnum.BOOL_PMF);
		return expr; 
	}
	
	public Object caseProductExpression(ProductExpression expr){
		TypeEnum leftType = getTypeOfChild((Expression)expr.getLeft());
		TypeEnum rightType = getTypeOfChild((Expression)expr.getRight());
		
		ProductOperations op = expr.getOperation();  
		if (op.getName().equals("MULT") || op.getName().equals("DIV")){
			// may result in ints or doubles
			inferIntAndDouble(expr, leftType, rightType);
		} else if (op.getName().equals("MOD")){
			//TODO
			throw new UnsupportedOperationException();
		} else
			throw new UnsupportedOperationException();
		logger.debug(expr.getOperation().toString());

		return expr;
	}

	@Override
	public Object casePowerExpression(PowerExpression expr) {
		TypeEnum baseType = getTypeOfChild((Expression)expr.getBase());
		TypeEnum exponentType = getTypeOfChild((Expression)expr.getExponent());
		
		if (isNumeric(baseType) && isNumeric(exponentType)){
			typeAnnotation.put(expr, TypeEnum.DOUBLE);
		} else
			throw new UnsupportedOperationException();
		
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
			} else if (value instanceof Boolean){
				typeAnnotation.put(pfl, TypeEnum.BOOL_PMF);
			} else {
				logger.error("Could not determine type of PMF!");
			}
		} else if (pf instanceof ProbabilityDensityFunction){
			typeAnnotation.put(pfl, TypeEnum.DOUBLE_PDF);
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
	
	public Object caseVariable(Variable var){
		//logger.debug("Found variable: " + var.getId_Variable());
		if (var instanceof CharacterisedVariable) {
			CharacterisedVariable chVar = (CharacterisedVariable) var;
			VariableCharacterisationType chType = chVar
					.getCharacterisationType();
			String chTypeString = chType.getName();
			if (chTypeString.equals("VALUE") 
			 || chTypeString.equals("DATATYPE")
			 || chTypeString.equals("STRUCTURE")) {
				typeAnnotation.put(var, TypeEnum.ANY_PMF);
				//logger.debug("Inferred to ENUM_PMF");
			} else if (chTypeString.equals("NUMBER_OF_ELEMENTS")
					|| chTypeString.equals("BYTESIZE")) {
				typeAnnotation.put(var, TypeEnum.INT_PMF);
				//logger.debug("Inferred to INT_PMF");
			}
		}
		return var;
	}

	@Override
	public Object caseBoolLiteral(BoolLiteral bl) {
		typeAnnotation.put(bl, TypeEnum.BOOL);
		return bl;
	}

	@Override
	public Object caseParenthesis(Parenthesis parenthesis) {
		TypeEnum type = getTypeOfChild(parenthesis.getInnerExpression());
		typeAnnotation.put(parenthesis, type);
		return parenthesis;
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
		} else if (isNumeric(leftType) && isNumeric(rightType)){
			typeAnnotation.put(expr, TypeEnum.DOUBLE);
		} else if (isDoubleIntPMF(leftType) && isDoubleIntPMF(rightType)){
			typeAnnotation.put(expr, TypeEnum.DOUBLE_PMF);
		} else if (isDoubleIntAnyPMF(leftType) && isDoubleIntAnyPMF(rightType)) {
			typeAnnotation.put(expr, TypeEnum.ANY_PMF);
		} else if (isDoubleIntPDF(leftType) && isDoubleIntPDF(rightType)){
			typeAnnotation.put(expr, TypeEnum.DOUBLE_PDF);
		} else {
			throw new UnsupportedOperationException();
		}
	}


	/**
	 * @param expr
	 * @return
	 */ 
	private TypeEnum getTypeOfChild(Expression expr) {
		Expression childExpr = (Expression)doSwitch(expr);
		TypeEnum type = typeAnnotation.get(childExpr);
		return type;
	}
	
	private boolean isIntPMF(TypeEnum type) {
		return (type == TypeEnum.INT 
			 || type == TypeEnum.INT_PMF);
	}

	private boolean isNumeric(TypeEnum type) {
		return (type == TypeEnum.INT 
			 || type == TypeEnum.DOUBLE);
	}

	private boolean isDoubleIntPMF(TypeEnum type) {
		return (type == TypeEnum.DOUBLE 
			 || type == TypeEnum.INT
			 || type == TypeEnum.INT_PMF 
			 || type == TypeEnum.DOUBLE_PMF);
	
	}
	
	private boolean isDoubleIntAnyPMF(TypeEnum type) {
		return (type == TypeEnum.DOUBLE 
				 || type == TypeEnum.INT
				 || type == TypeEnum.INT_PMF 
				 || type == TypeEnum.DOUBLE_PMF
				 || type == TypeEnum.ANY_PMF);
	}


	private boolean isDoubleIntPDF(TypeEnum type) {
		return (type == TypeEnum.DOUBLE 
 			 || type == TypeEnum.INT
			 || type == TypeEnum.INT_PMF 
			 || type == TypeEnum.DOUBLE_PMF 
			 || type == TypeEnum.DOUBLE_PDF);
	}
	
	public HashMap<Expression, TypeEnum> getTypeAnnotation() {
		return typeAnnotation;
	}

	public void setTypeAnnotation(HashMap<Expression, TypeEnum> typeAnnotation) {
		this.typeAnnotation = typeAnnotation;
	}

	/**
	 * Return the infered type of the passed in expression node
	 * @pre e is part of the expression tree on which this inferer infered its types
	 * @param e The node whose type should be returned
	 * @return The infered type of the expresion
	 */
	public TypeEnum getType(Expression e)
	{
		assert typeAnnotation.containsKey(e);
		return typeAnnotation.get(e);
	}
}

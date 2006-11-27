package de.uka.ipd.sdq.dsolver.visitors;

import java.util.HashMap;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.dsolver.Context;
import de.uka.ipd.sdq.pcm.core.stochastics.CompareExpression;
import de.uka.ipd.sdq.pcm.core.stochastics.DoubleLiteral;
import de.uka.ipd.sdq.pcm.core.stochastics.Expression;
import de.uka.ipd.sdq.pcm.core.stochastics.IntLiteral;
import de.uka.ipd.sdq.pcm.core.stochastics.ProbabilityFunctionLiteral;
import de.uka.ipd.sdq.pcm.core.stochastics.ProductExpression;
import de.uka.ipd.sdq.pcm.core.stochastics.ProductOperations;
import de.uka.ipd.sdq.pcm.core.stochastics.TermExpression;
import de.uka.ipd.sdq.pcm.core.stochastics.TermOperations;
import de.uka.ipd.sdq.pcm.core.stochastics.Variable;
import de.uka.ipd.sdq.pcm.core.stochastics.util.StochasticsSwitch;
import de.uka.ipd.sdq.pcm.parameter.ParameterFactory;
import de.uka.ipd.sdq.probfunction.ProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.ProbabilityFunction;
import de.uka.ipd.sdq.probfunction.ProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.Sample;

public class ExpressionInferTypeVisitor extends StochasticsSwitch {

	private static Logger logger = Logger.getLogger(ExpressionInferTypeVisitor.class.getName());
	
	private HashMap<Expression, TypeEnum> typeAnnotation = 
		new HashMap<Expression, TypeEnum>();

	private HashMap<Expression, Expression> parameterAnnotation = 
		new HashMap<Expression, Expression>();
	
	private Context context;
	
	private ParameterFactory paramFactory = ParameterFactory.eINSTANCE;
	
	public ExpressionInferTypeVisitor(Context _context){
		this.context = _context;
	}
	
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
			inferIntAndDouble(expr, leftType, rightType);
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
	
	public Object caseVariable(Variable var){
//		logger.debug("Found variable: "+var.getId());
//		
//		StringTokenizer st = new StringTokenizer(var.getId(), ".");
//		
//		EList parChars = ECollections.EMPTY_ELIST;
//		
//		ParameterUsage currentParamUsage = null;
//		while (st.hasMoreTokens()) {
//			String currentToken = st.nextToken().toUpperCase();
//			if (isCharacterisationType(currentToken)){
//				handleParameterCharacterisationType(var, currentParamUsage, currentToken);
//			} else if (currentToken.equals("INNER")){
//				// TODO
//			} else { // currentToken is variable name
//				currentParamUsage = getParameterUsage(currentToken);
//				//parChars = getParameterCharacterisations(currentToken);
//				//TODO: support CompositeParameters
//			}
//		}
		return var;
	}

//	/**
//	 * @param referencedParameterName
//	 * @return
//	 */
//	private ParameterUsage getParameterUsage(String referencedParameterName) {
////		EList parameters = context.getUsageContext()
////				.getActualParameterUsage_UsageContext();
////		for (Object o : parameters) {
////			ParameterUsage pu = (ParameterUsage) o;
////			String parameterName = pu.getParameter_ParameterUsage()
////					.getParameterName().toUpperCase();
////			if (parameterName.equals(referencedParameterName)) {
////				return pu;
////			}
////		}
//		return null;
//	}

//	/**
//	 * @param var
//	 * @param parChars
//	 * @param currentToken
//	 */
//	private void handleParameterCharacterisationType(Variable var, ParameterUsage currentUsage, String currentToken) {
//		// this is duplicated code, because ParameterCharacterisation and
//		// CollectionParameterCharacterisation do not inherit from the same class
//		if (currentUsage instanceof CollectionParameterUsage){
//			CollectionParameterUsage cpu = (CollectionParameterUsage)currentUsage;	
//			EList parChars = cpu.getParameterCharacterisation_CollectionParameterUsage();
//			for(Object o : parChars){
//				CollectionParameterCharacterisation cpc = (CollectionParameterCharacterisation)o;
//				if (cpc.getType().getName().equals(currentToken)){
//					Expression expr = cpc.getSpecification_RandomVariable();
//					storeAnnotations(var, expr);
//					return;
//				}
//			}
//			parChars = cpu.getParameterCharacterisation_ParameterUsage();
//			for(Object o : parChars){
//				ParameterCharacterisation pc = (ParameterCharacterisation)o;
//				if (pc.getType().getName().equals(currentToken)){
//					Expression expr = pc.getSpecification_RandomVariable();
//					storeAnnotations(var, expr);
//				}
//			}
//			
//			
//			
//		} else if (currentUsage instanceof PrimitiveParameterUsage){
//			handleParameterCharacterisation(var, currentUsage, currentToken);
//		}
//	}

//	/**
//	 * @param var
//	 * @param currentUsage
//	 * @param currentToken
//	 */
//	private void handleParameterCharacterisation(Variable var, ParameterUsage currentUsage, String currentToken) {
//		PrimitiveParameterUsage ppu = (PrimitiveParameterUsage)currentUsage;
//		EList parChars = ppu.getParameterCharacterisation_ParameterUsage();
//		for(Object o : parChars){
//			ParameterCharacterisation pc = (ParameterCharacterisation)o;
//			if (pc.getType().getName().equals(currentToken)){
//				Expression expr = pc.getSpecification_RandomVariable();
//				storeAnnotations(var, expr);
//			}
//		}
//	}

//	/**
//	 * @param var
//	 * @param expr
//	 */
//	private void storeAnnotations(Variable var, Expression expr) {
//		parameterAnnotation.put(var, expr);
//		//	resolve type annotation
//		doSwitch(expr); 
//		// get resolved type annotation and use it as var type annotation
//		typeAnnotation.put(var, getTypeAnnotation(expr));
//	}
//
//	/**
//	 * @param currentToken
//	 * @return
//	 */
//	private boolean isCharacterisationType(String currentToken) {
//		return currentToken.equals("VALUE") 
//				|| currentToken.equals("TYPE")
//				|| currentToken.equals("BYTESIZE")
//				|| currentToken.equals("NUMBER_OF_ELEMENTS")
//				|| currentToken.equals("STRUCTURE");
//	}

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
	
	public Expression getParameterAnnotation(Expression expr){
		return parameterAnnotation.get(expr);
	}
	
}

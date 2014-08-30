/**
 * 
 */
package de.uka.ipd.sdq.stoex.analyser.visitors;

import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.PowerExpression;

/**
 * @author Steffen
 *
 */
public class NonProbabilisticExpressionInferTypeVisitor extends
		ExpressionInferTypeVisitor {

	/**
	 * 
	 */
	public NonProbabilisticExpressionInferTypeVisitor() {
		super();
	}

	@Override
	public TypeEnum getType(Expression e) {
		TypeEnum result = super.getType(e);
		if (result == TypeEnum.INT_PMF)
			result = TypeEnum.INT;
		if (result == TypeEnum.DOUBLE_PMF || result == TypeEnum.DOUBLE_PDF)
			result = TypeEnum.DOUBLE;
		if (result == TypeEnum.ENUM_PMF)
			result = TypeEnum.ENUM;
		if (result == TypeEnum.BOOL_PMF)
			result = TypeEnum.BOOL;
		if (result == TypeEnum.ANY_PMF)
			result = TypeEnum.ANY;
		return result;
	}
	
	/**
	 * Result of a power expression so far only be of type DOUBLE,
	 * as the power operation is only allowed on NUMBERs, not PMFs.
	 */
	@Override
	public Object casePowerExpression(PowerExpression expr) {
		doSwitch(expr.getBase());
		doSwitch(expr.getExponent());
		
		TypeEnum baseType = getType(expr.getBase());
		TypeEnum exponentType = getType(expr.getExponent());
		
		if (baseType == TypeEnum.INT && exponentType == TypeEnum.INT)
			getTypeAnnotation().put(expr, TypeEnum.INT);
		else if (isNumeric(baseType) && isNumeric(exponentType)){
			getTypeAnnotation().put(expr, TypeEnum.DOUBLE);
		} else 
			getTypeAnnotation().put(expr, TypeEnum.ANY);
		return expr;
	}
}

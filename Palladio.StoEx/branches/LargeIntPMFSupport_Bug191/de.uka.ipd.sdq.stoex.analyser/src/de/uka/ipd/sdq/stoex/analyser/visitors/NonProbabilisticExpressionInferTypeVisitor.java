/**
 * 
 */
package de.uka.ipd.sdq.stoex.analyser.visitors;

import de.uka.ipd.sdq.stoex.Expression;

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
}

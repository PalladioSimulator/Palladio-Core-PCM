package de.uka.ipd.sdq.pcmsolver.transformations.pcm2regex;

import java.util.List;

import de.uka.ipd.sdq.spa.expression.Alternative;
import de.uka.ipd.sdq.spa.expression.Expression;
import de.uka.ipd.sdq.spa.expression.ExpressionFactory;
import de.uka.ipd.sdq.spa.expression.Option;

public class Pcm2RegexHelper {

	public static Expression createAlternativesForExpressions(
			List<Option> listOfExpressions) {
		
		if (listOfExpressions.size() == 1){
			return listOfExpressions.get(0).getRegexp();
		} else if (listOfExpressions.size() == 0){
			return null;
		}
		
		ExpressionFactory expFactory = ExpressionFactory.eINSTANCE;
		Alternative alternative = expFactory.createAlternative();
		
		Option leftOption = listOfExpressions.get(0);
		alternative.setLeftOption(leftOption);
		
		Option rightOption = expFactory.createOption();
		alternative.setRightOption(rightOption);
		rightOption.setProbability(1-leftOption.getProbability());
		
		if (listOfExpressions.size() == 2){
			//this is the leaf
			alternative.setRightOption(listOfExpressions.get(1));
		} else {
			Expression subAlternative = createAlternativesForExpressions(listOfExpressions.subList(1, listOfExpressions.size()));
			rightOption.setRegexp(subAlternative);
		}
		return alternative;
	}
	
}

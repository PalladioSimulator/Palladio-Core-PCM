package de.uka.ipd.sdq.pcmsolver.visitors;

import java.util.HashMap;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.PCMStoExLexer;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.PCMStoExParser;
import de.uka.ipd.sdq.pcmsolver.transformations.ContextWrapper;
import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.analyser.visitors.ExpressionInferTypeVisitor;
import de.uka.ipd.sdq.stoex.analyser.visitors.StoExPrettyPrintVisitor;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;

public class ExpressionHelper {

	/**
	 * @param specification
	 */
	public static Expression parseToExpression(String specification) {
		Expression expression = null;
		PCMStoExLexer lexer = new PCMStoExLexer(
				new ANTLRStringStream(specification));
		PCMStoExParser parser = new PCMStoExParser(new CommonTokenStream(lexer));
		try {
			expression = parser.expression();
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return expression;
	}
	
	public static String getSolvedExpressionAsString(String specification, ContextWrapper ctxWrp){
		Expression solvedExpression = getSolvedExpression(specification, ctxWrp);
		
		StoExPrettyPrintVisitor printer = new StoExPrettyPrintVisitor();
		String solvedExprString = (String)printer.doSwitch(solvedExpression);
		
		if (solvedExpression == null){
			throw new RuntimeException("Could not print solved expression "+specification);
		}
		
		return solvedExprString;
	}
	
	public static Expression getSolvedExpression(String specification,
			ContextWrapper ctxWrp) {
		Expression expr = parseToExpression(specification);
		
		ExpressionInferTypeVisitor inferTypeVisitor = new ExpressionInferTypeVisitor();
		inferTypeVisitor.doSwitch(expr);

		HashMap<Expression, TypeEnum> typeAnnotation = inferTypeVisitor
				.getTypeAnnotation();

		ExpressionParameterSolverVisitor solveVisitor = new ExpressionParameterSolverVisitor(
				typeAnnotation, ctxWrp);
		
		return (Expression) solveVisitor.doSwitch(expr);
	}
	
	public static HashMap<Expression,TypeEnum> getTypeAnnotation(Expression expr){
		ExpressionInferTypeVisitor inferTypeVisitor = 
			new ExpressionInferTypeVisitor();
		inferTypeVisitor.doSwitch(expr);
		return inferTypeVisitor.getTypeAnnotation();
	}
	
	
}

package de.uka.ipd.sdq.pcm.stochasticexpressions.tests;

import junit.framework.Assert;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.PCMStoExLexer;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.PCMStoExParser;
import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.FunctionLiteral;
import de.uka.ipd.sdq.stoex.IfElseExpression;
import de.uka.ipd.sdq.stoex.analyser.visitors.ExpressionInferTypeVisitor;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;

public class TypeInferTests {

	@Test public void testEnums() throws RecognitionException{
		ExpressionInferTypeVisitor visitor = new ExpressionInferTypeVisitor();
		Expression expression = parser("\"blah\"");
		infer(expression,visitor);
		Assert.assertEquals(TypeEnum.ENUM, visitor.getType(expression));
		visitor = new ExpressionInferTypeVisitor();
		expression = parser("EnumPMF[(\"blah\";0.4)(\"blub\";0.6)]");
		infer(expression,visitor);
		Assert.assertEquals(TypeEnum.ENUM_PMF, visitor.getType(expression));
	}

	@Test public void testDoubleAnyCompare() throws RecognitionException{
		ExpressionInferTypeVisitor visitor = new ExpressionInferTypeVisitor();
		Expression expression = parser("192.0 / file.STRUCTURE < 1");
		infer(expression,visitor);
		Assert.assertEquals(TypeEnum.BOOL_PMF, visitor.getType(expression));
	}

	@Test public void testDoubleAnyCompareIfElse() throws RecognitionException{
		ExpressionInferTypeVisitor visitor = new ExpressionInferTypeVisitor();
		IfElseExpression expression = (IfElseExpression) parser("192.0 / file.STRUCTURE < 1 ? 5 : 5");
		infer(expression,visitor);
		Assert.assertEquals(TypeEnum.ANY, visitor.getType(expression));
		Assert.assertEquals(TypeEnum.BOOL_PMF, visitor.getType(expression.getConditionExpression()));
	}

	@Test public void testTypeInfererBool() throws RecognitionException {
		Assert.assertTrue(infer("true AND false") == TypeEnum.BOOL);
		Assert.assertTrue(infer("true OR false") == TypeEnum.BOOL);
		Assert.assertTrue(infer("128.0 < 192 OR false") == TypeEnum.BOOL);
		Assert.assertTrue(infer("NOT(128.0 < 192 OR false)") == TypeEnum.BOOL);
		Assert.assertTrue(infer("true ? 1 : 5") == TypeEnum.ANY);
	}
	
	@Test public void subInferTest() throws RecognitionException {
		ExpressionInferTypeVisitor visitor = new ExpressionInferTypeVisitor();
		IfElseExpression expression = (IfElseExpression) parser("true ? 1 : 5.5");
		infer(expression,visitor);
		Assert.assertEquals(visitor.getType(expression.getConditionExpression()),TypeEnum.BOOL);
		Assert.assertEquals(TypeEnum.INT,visitor.getType(expression.getIfExpression()));
		Assert.assertEquals(TypeEnum.DOUBLE,visitor.getType(expression.getElseExpression()));
	}

	@Test public void subFuncInferTest() throws RecognitionException {
		ExpressionInferTypeVisitor visitor = new ExpressionInferTypeVisitor();
		FunctionLiteral expression = (FunctionLiteral) parser("Trunc(2.5)");
		infer(expression,visitor);
		Assert.assertEquals(TypeEnum.INT_PMF,visitor.getType(expression));
		Assert.assertEquals(TypeEnum.DOUBLE,visitor.getType(expression.getParameters_FunctionLiteral().get(0)));
	}	

	@Test public void variableTest() throws RecognitionException {
		ExpressionInferTypeVisitor visitor = new ExpressionInferTypeVisitor();
		Expression expression = parser("file.TYPE");
		infer(expression,visitor);
		Assert.assertEquals(TypeEnum.ANY_PMF,visitor.getType(expression));
	}

	@Test public void parenthesisTest() throws RecognitionException {
		ExpressionInferTypeVisitor visitor = new ExpressionInferTypeVisitor();
		Expression expression = parser("file.BYTESIZE * ( file.TYPE / 192 )");
		infer(expression,visitor);
		Assert.assertEquals(TypeEnum.ANY_PMF,visitor.getType(expression));
	}
	
	@Test public void tenaryOpTest() throws RecognitionException {
		ExpressionInferTypeVisitor visitor = new ExpressionInferTypeVisitor();
		IfElseExpression expression = (IfElseExpression) parser("file.TYPE > 192 ? file.BYTESIZE * ( file.TYPE / 192 ) : file.BYTESIZE");
		infer(expression,visitor);
	}
	
	private TypeEnum infer(String expression) throws RecognitionException{
		return infer(expression, new ExpressionInferTypeVisitor());
	}
	
	private  TypeEnum infer(String expression, ExpressionInferTypeVisitor typeInferer) throws RecognitionException{
		Expression formula = parser(expression);
		typeInferer.doSwitch(formula);
		
		return typeInferer.getType(formula);
	}

	private  TypeEnum infer(Expression expression, ExpressionInferTypeVisitor typeInferer) throws RecognitionException{
		Expression formula = expression;
		typeInferer.doSwitch(formula);
		
		return typeInferer.getType(formula);
	}
	
	private Expression parser(String expression) throws RecognitionException {
		PCMStoExLexer lexer = new PCMStoExLexer(
				new ANTLRStringStream(expression));
		Expression formula = null;
		formula = new PCMStoExParser(new CommonTokenStream(lexer)).expression();
		return formula;
	}
}

package de.uka.ipd.sdq.pcm.stochasticexpressions.tests;

import junit.framework.TestCase;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.palladiosimulator.pcm.pcmstoex.adapter.PCMStoExParser;

import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.FunctionLiteral;
import de.uka.ipd.sdq.stoex.IfElseExpression;
import de.uka.ipd.sdq.stoex.analyser.visitors.ExpressionInferTypeVisitor;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;

public class TypeInferTests extends TestCase {

	public void testEnums() throws RecognitionException{
		ExpressionInferTypeVisitor visitor = new ExpressionInferTypeVisitor();
		Expression expression = parser("\"blah\"");
		infer(expression,visitor);
		assertEquals(TypeEnum.ENUM, visitor.getType(expression));
		visitor = new ExpressionInferTypeVisitor();
		expression = parser("EnumPMF[(\"blah\";0.4)(\"blub\";0.6)]");
		infer(expression,visitor);
		assertEquals(TypeEnum.ENUM_PMF, visitor.getType(expression));
	}
	
	public void testIntPMF() throws RecognitionException{
		ExpressionInferTypeVisitor visitor = new ExpressionInferTypeVisitor();
		Expression expression = parser("IntPMF[(1;0.2)(2;0.4)]");
		infer(expression,visitor);
		assertEquals(TypeEnum.INT_PMF, visitor.getType(expression));
	}

	public void testNegativeDoublePDF() throws RecognitionException{
		ExpressionInferTypeVisitor visitor = new ExpressionInferTypeVisitor();
		Expression expression = parser("DoublePDF[(-1.0;0.2)(2.0;0.4)]");
		infer(expression,visitor);
		assertEquals(TypeEnum.DOUBLE_PDF, visitor.getType(expression));
	}

	
	public void testDoubleAnyCompare() throws RecognitionException{
		ExpressionInferTypeVisitor visitor = new ExpressionInferTypeVisitor();
		Expression expression = parser("192.0 / file.STRUCTURE < 1");
		infer(expression,visitor);
		assertEquals(TypeEnum.BOOL_PMF, visitor.getType(expression));
	}

	public void testDoubleAnyCompareIfElse() throws RecognitionException{
		ExpressionInferTypeVisitor visitor = new ExpressionInferTypeVisitor();
		IfElseExpression expression = (IfElseExpression) parser("192.0 / file.STRUCTURE < 1 ? 5 : 5");
		infer(expression,visitor);
		assertEquals(TypeEnum.ANY, visitor.getType(expression));
		assertEquals(TypeEnum.BOOL_PMF, visitor.getType(expression.getConditionExpression()));
	}

	public void testTypeInfererBool() throws RecognitionException {
		assertTrue(infer("true AND false") == TypeEnum.BOOL);
		assertTrue(infer("true OR false") == TypeEnum.BOOL);
		assertTrue(infer("128.0 < 192 OR false") == TypeEnum.BOOL);
		assertTrue(infer("NOT(128.0 < 192 OR false)") == TypeEnum.BOOL);
		assertTrue(infer("true ? 1 : 5") == TypeEnum.ANY);
	}
	
	public void testsubInfer() throws RecognitionException {
		ExpressionInferTypeVisitor visitor = new ExpressionInferTypeVisitor();
		IfElseExpression expression = (IfElseExpression) parser("true ? 1 : 5.5");
		infer(expression,visitor);
		assertEquals(visitor.getType(expression.getConditionExpression()),TypeEnum.BOOL);
		assertEquals(TypeEnum.INT,visitor.getType(expression.getIfExpression()));
		assertEquals(TypeEnum.DOUBLE,visitor.getType(expression.getElseExpression()));
	}

	public void testSubFuncInfer() throws RecognitionException {
		ExpressionInferTypeVisitor visitor = new ExpressionInferTypeVisitor();
		FunctionLiteral expression = (FunctionLiteral) parser("Trunc(2.5)");
		infer(expression,visitor);
		assertEquals(TypeEnum.INT_PMF,visitor.getType(expression));
		assertEquals(TypeEnum.DOUBLE,visitor.getType(expression.getParameters_FunctionLiteral().get(0)));
	}	

	public void testVariables() throws RecognitionException {
		ExpressionInferTypeVisitor visitor = new ExpressionInferTypeVisitor();
		Expression expression = parser("file.TYPE");
		infer(expression,visitor);
		assertEquals(TypeEnum.ANY_PMF,visitor.getType(expression));
	}

	public void testParenthesis() throws RecognitionException {
		ExpressionInferTypeVisitor visitor = new ExpressionInferTypeVisitor();
		Expression expression = parser("file.BYTESIZE * ( file.TYPE / 192 )");
		infer(expression,visitor);
		assertEquals(TypeEnum.ANY_PMF,visitor.getType(expression));
	}
	
	public void testTenaryOp() throws RecognitionException {
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
		Expression formula = null;
		formula = new PCMStoExParser(expression).expression();
		return formula;
	}
}

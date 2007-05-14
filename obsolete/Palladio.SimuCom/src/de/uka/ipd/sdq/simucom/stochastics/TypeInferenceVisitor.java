package de.uka.ipd.sdq.simucom.stochastics;

import java.util.HashMap;

import stoex.parser.ExpressionParserTokenTypes;
import antlr.TreeParser;
import antlr.collections.AST;
import de.uka.ipd.sdq.pcm.parameter.CollectionParameterCharacterisationType;
import de.uka.ipd.sdq.pcm.parameter.PrimitiveParameterCharacterisationType;
import de.uka.ipd.sdq.simucom.emfhelper.ParameterCharacterisationHelper;

public class TypeInferenceVisitor extends TreeParser {

	private HashMap<AST, TypeEnum> typeAnnotation = new HashMap<AST, TypeEnum>();

	public TypeInferenceVisitor() {
	}

	public TypeEnum inferType(AST expr) throws Exception {
		match(expr,ExpressionParserTokenTypes.EQUAL);
		typeAnnotation.put(expr,inferFormularType(expr));
		return typeAnnotation.get(expr);
	}

	public TypeEnum inferFormularType(AST expr) throws Exception {
		match(expr, ExpressionParserTokenTypes.EQUAL);
		AST t = expr.getFirstChild();
		TypeEnum innerType = inferFormularTypeInternal(t);
		typeAnnotation.put(expr, innerType);
		return innerType;
	}

	private TypeEnum inferFormularTypeInternal(AST t) throws Exception {
		switch (t.getType()) {
		case ExpressionParserTokenTypes.INT_DEF:
			typeAnnotation.put(t,TypeEnum.INT);
			return TypeEnum.INT;
		case ExpressionParserTokenTypes.ENUM_DEF:
			typeAnnotation.put(t,TypeEnum.ENUM);
			return TypeEnum.ENUM;
		case ExpressionParserTokenTypes.REAL_DEF:
			typeAnnotation.put(t,TypeEnum.REAL);
			return TypeEnum.REAL;
		case ExpressionParserTokenTypes.PARAM:
			TypeEnum paramType = inferParamType(t);
			typeAnnotation.put(t,paramType);
			return paramType;
		case ExpressionParserTokenTypes.MUL:
			TypeEnum inferedTypeLeft = inferFormularTypeInternal(t
					.getFirstChild());
			TypeEnum inferedTypeRight = inferFormularTypeInternal(t
					.getFirstChild().getNextSibling());
			if (inferedTypeLeft == TypeEnum.INT
					&& inferedTypeRight == TypeEnum.INT) {
				typeAnnotation.put(t, TypeEnum.INT);
				return TypeEnum.INT;
			} else if (isNumeric(inferedTypeLeft)
					&& isNumeric(inferedTypeRight)) {
				typeAnnotation.put(t, TypeEnum.REAL);
				return TypeEnum.REAL;
			}
			throw new Exception("Numbers required for MUL");
		case ExpressionParserTokenTypes.DIV:
			inferedTypeLeft = inferFormularTypeInternal(t
					.getFirstChild());
			inferedTypeRight = inferFormularTypeInternal(t
					.getFirstChild().getNextSibling());
			if (isNumeric(inferedTypeLeft) && isNumeric(inferedTypeRight))
			{
				typeAnnotation.put(t,TypeEnum.REAL);
				return TypeEnum.REAL;
			}
			throw new Exception("Numbers required for DIV");
		case ExpressionParserTokenTypes.NUMBER:
			TypeEnum ty = inferNumber(t.getText());
			typeAnnotation.put(t, ty);
			return ty;
		}
		throw new Exception("Expression not supported yet");
	}

	/**
	 * @param t
	 * @throws Exception
	 */
	private TypeEnum inferParamType(AST t) throws Exception {
		String characterisationType = t.getFirstChild().getNextSibling()
				.getText();
		if (t.getText().equals("prim_param")) {
			PrimitiveParameterCharacterisationType type = ParameterCharacterisationHelper
					.getPrimitiveParameterCharacterisationType(characterisationType);
			switch (type.getValue()) {
			case PrimitiveParameterCharacterisationType.BYTESIZE:
				typeAnnotation.put(t, TypeEnum.INT);
				return TypeEnum.INT;
			}
			throw new Exception("Unknown parameter abstraction!");

		} else {
			CollectionParameterCharacterisationType type = ParameterCharacterisationHelper
					.getCollectionParameterCharacterisationType(characterisationType);
			switch (type.getValue()) {
			case CollectionParameterCharacterisationType.NUMBER_OF_ELEMENTS:
				typeAnnotation.put(t, TypeEnum.INT);
				return TypeEnum.INT;
			case CollectionParameterCharacterisationType.STRUCTURE:
				typeAnnotation.put(t, TypeEnum.ENUM);
				return TypeEnum.ENUM;
			}
			throw new Exception("Unknown parameter abstraction!");
		}
	}

	private boolean isNumeric(TypeEnum inferedType) {
		if (inferedType == TypeEnum.INT || inferedType == TypeEnum.REAL)
			return true;
		return false;
	}

	private TypeEnum inferNumber(String text) {
		if (text.indexOf('.') > 0)
			return TypeEnum.REAL;
		else
			return TypeEnum.INT;
	}

	public TypeEnum getASTNodeType(AST expr) {
		return typeAnnotation.get(expr);
	}
}

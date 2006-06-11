package de.uka.ipd.sdq.simucom.stochastics;

import java.io.StringBufferInputStream;
import java.util.Iterator;

import de.uka.ipd.sdq.simucom.DistributionObjectsStorage;
import de.uka.ipd.sdq.simucom.behaviour.SimulatedStackFrame;
import de.uka.ipd.sdq.simucom.emfhelper.ParameterCharacterisationHelper;
import stoex.parser.ExpressionLexer;
import stoex.parser.ExpressionParser;
import stoex.parser.ExpressionParserTokenTypes;
import stoex.stochastics.RandomVariable;
import stoex.visitors.DefinitionTreeParser;
import ParameterPackage.CollectionParameterCharacterisationType;
import ParameterPackage.ParameterPackagePackage;
import ParameterPackage.ParameterUsage;
import ParameterPackage.PrimitiveParameterCharacterisation;
import ParameterPackage.PrimitiveParameterCharacterisationType;
import antlr.CommonAST;
import antlr.TreeParser;
import antlr.collections.AST;

public class StoExEvaluationVisitor extends TreeParser {

	private String mySpecification = null;

	private SimulatedStackFrame myStackFrame = null;

	protected TypeInferenceVisitor typeVisitor = null;

	protected AST parseTree = null;

	public StoExEvaluationVisitor(String specification,
			SimulatedStackFrame stackFrame) throws Exception {
		this.mySpecification = specification;
		this.myStackFrame = stackFrame;
		parseTree = parseSpec();
		typeVisitor = new TypeInferenceVisitor();
		typeVisitor.inferType(parseTree);
	}

	public Object evaluate() throws Exception {
		switch (parseTree.getType()) {
		case ExpressionParserTokenTypes.EQUAL:
			return evaluateFormular(parseTree);
		case ExpressionParserTokenTypes.INT_DEF:
		case ExpressionParserTokenTypes.ENUM_DEF:
		case ExpressionParserTokenTypes.REAL_DEF:
			RandomVariable r = DefinitionTreeParser.parseDefinition(parseTree);
			return DistributionObjectsStorage.getSingletonInstance()
					.getDistributionSample(mySpecification, r);
		}
		throw new Exception(
				"You should never arrive here, otherwise the parser is broken");
	}

	public Object evaluateFormular(AST expr) throws Exception {
		match(expr, ExpressionParserTokenTypes.EQUAL);
		AST t = expr.getFirstChild();
		return evaluateFormularInternal(t);
	}

	public Object evaluateFormularInternal(AST t) throws Exception {
		switch (t.getType()) {
		case ExpressionParserTokenTypes.PARAM:
			String characterisationType = t.getFirstChild()
			.getNextSibling().getText();
			if (t.getFirstChild().getType() != ExpressionParserTokenTypes.INNER) {
				String parameterName = t.getFirstChild().getText();
				if (t.getText().equals("prim_param")) {
					PrimitiveParameterCharacterisationType type = ParameterCharacterisationHelper
							.getPrimitiveParameterCharacterisationType(characterisationType);
					return myStackFrame.getPrimitiveParameterCharacterisation(
							parameterName, type);
				} else if (t.getText().equals("coll_param")) {
					CollectionParameterCharacterisationType type = ParameterCharacterisationHelper
							.getCollectionParameterCharacterisationType(characterisationType);
					return myStackFrame.getCollectionParameterCharacterisation(
							parameterName, type);
				}
			} else {
				t = t.getFirstChild();
				String parameterName = t.getFirstChild().getText();
				ParameterUsage usage = myStackFrame.getInnerParameter(parameterName);
				if (usage.eClass() != ParameterPackagePackage.eINSTANCE
						.getCollectionParameterUsage()) {
					PrimitiveParameterCharacterisationType type = ParameterCharacterisationHelper
							.getPrimitiveParameterCharacterisationType(characterisationType);
					String spec = getPrimitiveRandomVariableSpecification(usage,type);
					return RandomVariableHelper.getSample(spec, myStackFrame);
				} else {
					CollectionParameterCharacterisationType type = ParameterCharacterisationHelper
							.getCollectionParameterCharacterisationType(characterisationType);
					return myStackFrame.getCollectionParameterCharacterisation(
							parameterName, type);
				}
			}
		case ExpressionParserTokenTypes.NUMBER:
			String num = t.getText();
			if (typeVisitor.getASTNodeType(t) == TypeEnum.INT)
				return new Integer(num);
			if (typeVisitor.getASTNodeType(t) == TypeEnum.REAL)
				return new Double(num);
			throw new Exception("Number can not be evaluated");
		case ExpressionParserTokenTypes.MUL:
			if (typeVisitor.getASTNodeType(t) == TypeEnum.INT)
				return new Integer((Integer) evaluateFormularInternal(t
						.getFirstChild())
						* (Integer) evaluateFormularInternal(t.getFirstChild()
								.getNextSibling()));
			if (typeVisitor.getASTNodeType(t) == TypeEnum.REAL)
				return new Double((Double) evaluateFormularInternal(t
						.getFirstChild())
						* (Double) evaluateFormularInternal(t.getFirstChild()
								.getNextSibling()));
		case ExpressionParserTokenTypes.DIV:
			if (typeVisitor.getASTNodeType(t) == TypeEnum.REAL)
				return saveDoubleCast(evaluateFormularInternal(t
						.getFirstChild()))
						/ saveDoubleCast(evaluateFormularInternal(t.getFirstChild()
								.getNextSibling()));
		}
		return null;
	}

	private Double saveDoubleCast(Object o)
	{
		if (o instanceof Integer)
			return new Double((Integer)o);
		if (o instanceof Double)
			return (Double)o;
		return null;
	}
	
	private String getPrimitiveRandomVariableSpecification(ParameterUsage usage, PrimitiveParameterCharacterisationType characterisationType) {
		Iterator i = usage.getParameterCharacterisation_ParameterUsage().iterator();
		while(i.hasNext())
		{
			PrimitiveParameterCharacterisation characterisation = (PrimitiveParameterCharacterisation)i.next();
			if (characterisation.getType() == characterisationType )
				return characterisation.getSpecification();
			
		}
		return null;
	}

	private CommonAST parseSpec() throws Exception {
		ExpressionLexer lexer = new ExpressionLexer(
				new StringBufferInputStream(mySpecification));
		ExpressionParser parser = new ExpressionParser(lexer);
		parser.stochexpr();
		return (CommonAST) parser.getAST();
	}

	public TypeEnum getEvaluatedType() {
		return typeVisitor.getASTNodeType(parseTree);
	}
}

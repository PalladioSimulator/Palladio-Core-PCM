package de.uka.ipd.sdq.dialogs.stoex;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.RecognitionException;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Shell;

import de.uka.ipd.sdq.errorhandling.IIssue;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.ErrorEntry;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.MyPCMStoExLexer;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.MyPCMStoExParser;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.PCMStoExLexer;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.PCMStoExParser;
import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.RandomVariable;
import de.uka.ipd.sdq.stoex.analyser.exceptions.ExpectedTypeMismatchIssue;
import de.uka.ipd.sdq.stoex.analyser.visitors.ExpressionInferTypeVisitor;
import de.uka.ipd.sdq.stoex.analyser.visitors.NonProbabilisticExpressionInferTypeVisitor;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeCheckVisitor;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;
import de.uka.ipd.sdq.stoex.parser.StochasticExpressionsLexer;

public class StochasticExpressionEditDialog extends
		AbstractGrammerBasedEditDialog {

	private TypeEnum expectedType;

	public StochasticExpressionEditDialog(Shell parent, TypeEnum expectedType) {
		super(parent);
		this.expectedType = expectedType;
	}

	public StochasticExpressionEditDialog(Shell parent, TypeEnum expectedType, Parameter[] context) {
		super(parent,context);
		this.expectedType = expectedType;
	}
	
	public void setInitialExpression(RandomVariable ex) {
		newText = ex.getSpecification();
	}

	public Expression getResult() {
		return (Expression)super.getResult();
	}
	
	@Override
	protected String getInitialText() {
		return "";
	}

	@Override
	protected Lexer getLexer(String text) {
		return new MyPCMStoExLexer(new ANTLRStringStream(text));
	}

	@Override
	protected String getTitle() {
		return "Edit stochastic expression";
	}

	@Override
	protected EObject parse(Lexer lexer) throws RecognitionException, StoExParserException {
		MyPCMStoExParser parser = new MyPCMStoExParser(new CommonTokenStream(lexer));
		EObject result = parser.expression();
		ArrayList<IIssue> errorList = new ArrayList<IIssue>();
		errorList.addAll(((MyPCMStoExLexer)lexer).getErrors());
		errorList.addAll(parser.getErrors());
		
		NonProbabilisticExpressionInferTypeVisitor typeVisitor = new NonProbabilisticExpressionInferTypeVisitor();
		typeVisitor.doSwitch(result);
		errorList.addAll(checkTypes(result,typeVisitor));
		errorList.addAll(assertType(result,typeVisitor,expectedType));

		if (errorList.size() > 0)
			throw new StoExParserException(errorList);
		return result;
	}

	private Collection<? extends IIssue> assertType(EObject result,
			ExpressionInferTypeVisitor typeVisitor, TypeEnum expectedType) {
		if (!TypeCheckVisitor.typesCompatible(expectedType,typeVisitor.getType((Expression)result))){
			return Collections.singletonList(new ExpectedTypeMismatchIssue(
					expectedType,
					typeVisitor.getType((Expression)result)));
		}
		return Collections.emptyList();
	}

	private Collection<IIssue> checkTypes(EObject result,
			NonProbabilisticExpressionInferTypeVisitor typeVisitor) {
		TypeCheckVisitor typeChecker = new TypeCheckVisitor(typeVisitor);
		typeChecker.doSwitch(result);
		TreeIterator<EObject> iterator = result.eAllContents(); 
		for(;iterator.hasNext();){
			EObject treeNode = iterator.next(); 
			typeChecker.doSwitch(treeNode);
		}
		return typeChecker.getIssues();
	}

	@Override
	protected Class<PCMStoExLexer> getLexerClass() {
		return PCMStoExLexer.class;
	}

	@Override
	protected ITokenMapper getTokenMapper() {
		return new StoExTokenMapper();
	}
	
	public static TypeEnum getTypeFromVariableCharacterisation(VariableCharacterisation ch){
		switch(ch.getType()){
			case BYTESIZE:
			case NUMBER_OF_ELEMENTS:
				return TypeEnum.INT;
		}
		return TypeEnum.ANY;
 	}
}

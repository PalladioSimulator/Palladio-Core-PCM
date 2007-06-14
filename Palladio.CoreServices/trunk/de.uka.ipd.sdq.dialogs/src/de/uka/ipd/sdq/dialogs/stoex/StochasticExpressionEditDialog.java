package de.uka.ipd.sdq.dialogs.stoex;

import java.io.StringReader;
import java.util.ArrayList;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.RecognitionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Shell;

import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.ErrorEntry;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.MyPCMStoExLexer;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.MyPCMStoExParser;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.PCMStoExLexer;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.PCMStoExParser;
import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.RandomVariable;
import de.uka.ipd.sdq.stoex.parser.StochasticExpressionsLexer;

public class StochasticExpressionEditDialog extends
		AbstractGrammerBasedEditDialog {

	public StochasticExpressionEditDialog(Shell parent) {
		super(parent);
	}

	public StochasticExpressionEditDialog(Shell parent, Parameter[] context) {
		super(parent,context);
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
		ArrayList<ErrorEntry> errorList = new ArrayList<ErrorEntry>();
		errorList.addAll(((MyPCMStoExLexer)lexer).getErrors());
		errorList.addAll(parser.getErrors());
		if (errorList.size() > 0)
			throw new StoExParserException(errorList);
		return result;
	}

	@Override
	protected Class getLexerClass() {
		return PCMStoExLexer.class;
	}

	@Override
	protected ITokenMapper getTokenMapper() {
		return new StoExTokenMapper();
	}
}

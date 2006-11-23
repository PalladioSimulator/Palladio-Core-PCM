package de.uka.ipd.sdq.dialogs.selection;

import java.io.StringReader;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Shell;

import antlr.CharScanner;
import antlr.RecognitionException;
import antlr.TokenStreamException;

import de.uka.ipd.sdq.pcm.core.stochastics.Expression;
import de.uka.ipd.sdq.pcm.stochasticexpressions.StoExPrettyPrintVisitor;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.StochasticExpressionsLexer;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.StochasticExpressionsParser;

public class StochasticExpressionEditDialog extends
		AbstractGrammerBasedEditDialog {

	public StochasticExpressionEditDialog(Shell parent) {
		super(parent);
	}

	public void setInitialExpression(Expression ex) {
		newText = "= " + new StoExPrettyPrintVisitor().prettyPrint(ex);
	}

	public Expression getResult() {
		return (Expression)super.getResult();
	}
	
	@Override
	protected String getInitialText() {
		return "= ";
	}

	@Override
	protected CharScanner getLexer(String text) {
		return new StochasticExpressionsLexer(new StringReader(text));
	}

	@Override
	protected String getTitle() {
		return "Edit stochastic expression";
	}

	@Override
	protected EObject parse(CharScanner lexer) throws RecognitionException, TokenStreamException {
		return new StochasticExpressionsParser(lexer).expression();
	}

	@Override
	protected Class getLexerClass() {
		return StochasticExpressionsLexer.class;
	}

	@Override
	protected ITokenMapper getTokenMapper() {
		return new StoExTokenMapper();
	}
}

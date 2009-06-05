package de.uka.ipd.sdq.dialogs.selection;

import java.io.StringReader;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Shell;

import antlr.CharScanner;
import antlr.RecognitionException;
import antlr.TokenStreamException;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.stochasticexpressions.PCMStoExPrettyPrintVisitor;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.PCMStoExParser;
import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.RandomVariable;
import de.uka.ipd.sdq.stoex.analyser.visitors.StoExPrettyPrintVisitor;
import de.uka.ipd.sdq.stoex.parser.StochasticExpressionsLexer;
import de.uka.ipd.sdq.stoex.parser.StochasticExpressionsParser;

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
	protected CharScanner getLexer(String text) {
		return new StochasticExpressionsLexer(new StringReader(text));
	}

	@Override
	protected String getTitle() {
		return "Edit stochastic expression";
	}

	@Override
	protected EObject parse(CharScanner lexer) throws RecognitionException, TokenStreamException {
		return new PCMStoExParser(lexer).expression();
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

/**
 * 
 */
package de.uka.ipd.sdq.dialogs.selection;

import java.io.StringReader;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Shell;

import antlr.CharScanner;
import antlr.RecognitionException;
import antlr.Token;
import antlr.TokenStreamException;
import de.uka.ipd.sdq.pcm.stochasticexpressions.ParameterPrettyPrint;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.VariableUsageParser;
import de.uka.ipd.sdq.stoex.AbstractNamedReference;
import de.uka.ipd.sdq.stoex.analyser.visitors.StoExPrettyPrintVisitor;
import de.uka.ipd.sdq.stoex.parser.StochasticExpressionsLexer;

/**
 * @author Steffen Becker
 *
 */
public class VariableUsageEditDialog extends AbstractGrammerBasedEditDialog {

	/**
	 * @param parent
	 */
	public VariableUsageEditDialog(Shell parent) {
		super(parent);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.dialogs.selection.AbstractGrammerBasedEditDialog#getInitialText()
	 */
	@Override
	protected String getInitialText() {
		return "a.b.INNER";
	}

	@Override
	protected CharScanner getLexer(String text) {
		return new StochasticExpressionsLexer(new StringReader(text));
	}

	@Override
	protected String getTitle() {
		return "Edit variable reference";
	}

	@Override
	protected EObject parse(CharScanner lexer) throws RecognitionException, TokenStreamException {
		VariableUsageParser parser = new VariableUsageParser(lexer); 
		EObject result = parser.scoped_id();
		if (parser.LT(1).getType() != Token.EOF_TYPE)
			throw new RecognitionException("Expecting EOF, found "+parser.LT(1).getText(),parser.LT(1).getText(),parser.LT(1).getLine(),parser.LT(1).getColumn());
		return  result;
	}

	@Override
	protected Class getLexerClass() {
		return StochasticExpressionsLexer.class;
	}

	@Override
	protected ITokenMapper getTokenMapper() {
		return new StoExTokenMapper();
	}

	public void setInitialExpression(AbstractNamedReference vu) {
		try
		{
			newText = (String)new StoExPrettyPrintVisitor().doSwitch(vu);
		}
		catch(Exception e)
		{
			newText = getInitialText();
		}
	}
	
	public AbstractNamedReference getResult()
	{
		return (AbstractNamedReference)super.getResult();
	}
}

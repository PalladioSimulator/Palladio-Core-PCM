/**
 * 
 */
package de.uka.ipd.sdq.dialogs.selection;

import java.io.StringReader;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Shell;

import de.uka.ipd.sdq.pcm.parameter.AbstractNamedReference;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.stochasticexpressions.ParameterPrettyPrint;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.StochasticExpressionsLexer;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.StochasticExpressionsParser;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.VariableUsageParser;

import antlr.CharScanner;
import antlr.RecognitionException;
import antlr.TokenStreamException;

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
		return new VariableUsageParser(lexer).scoped_id();
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
			newText = (String)new ParameterPrettyPrint().doSwitch(vu);
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

/**
 * 
 */
package de.uka.ipd.sdq.dialogs.selection;

import java.io.StringReader;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Shell;

import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
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
		return "a.BYTESIZE = b.BYTESIZE";
	}

	@Override
	protected CharScanner getLexer(String text) {
		return new StochasticExpressionsLexer(new StringReader(text));
	}

	@Override
	protected String getTitle() {
		return "Edit variable usage";
	}

	@Override
	protected EObject parse(CharScanner lexer) throws RecognitionException, TokenStreamException {
		return new VariableUsageParser(lexer).variable_usage();
	}

	@Override
	protected Class getLexerClass() {
		return StochasticExpressionsLexer.class;
	}

	@Override
	protected ITokenMapper getTokenMapper() {
		return new StoExTokenMapper();
	}

	public void setInitialExpression(VariableUsage randVar) {
		
	}
	
	public VariableUsage getResult()
	{
		return (VariableUsage)super.getResult();
	}
}

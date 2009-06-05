/**
 * 
 */
package de.uka.ipd.sdq.dialogs.selection;

import java.io.StringReader;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Shell;

import antlr.CharScanner;
import antlr.RecognitionException;
import antlr.TokenStreamException;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.stochasticexpressions.ParameterPrettyPrint;
import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.VariableUsageParser;
import de.uka.ipd.sdq.stoex.parser.StochasticExpressionsLexer;

/**
 * @author Steffen Becker
 *
 */
public class VariableCharacterisationEditDialog extends AbstractGrammerBasedEditDialog {

	/**
	 * @param parent
	 */
	public VariableCharacterisationEditDialog(Shell parent) {
		super(parent);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.dialogs.selection.AbstractGrammerBasedEditDialog#getInitialText()
	 */
	@Override
	protected String getInitialText() {
		return "BYTESIZE = b.BYTESIZE";
	}

	@Override
	protected CharScanner getLexer(String text) {
		return new StochasticExpressionsLexer(new StringReader(text));
	}

	@Override
	protected String getTitle() {
		return "Edit variable characterisation";
	}

	@Override
	protected EObject parse(CharScanner lexer) throws RecognitionException, TokenStreamException {
		return new VariableUsageParser(lexer).variable_characterisation();
	}

	@Override
	protected Class getLexerClass() {
		return StochasticExpressionsLexer.class;
	}

	@Override
	protected ITokenMapper getTokenMapper() {
		return new StoExTokenMapper();
	}

	public void setInitialExpression(VariableCharacterisation vc) {
		try 
		{
			newText = (String)new ParameterPrettyPrint().doSwitch(vc);
		}
		catch(Exception e)
		{
			newText = getInitialText();
		}
	}
	
	public VariableCharacterisation getResult()
	{
		return (VariableCharacterisation)super.getResult();
	}
}

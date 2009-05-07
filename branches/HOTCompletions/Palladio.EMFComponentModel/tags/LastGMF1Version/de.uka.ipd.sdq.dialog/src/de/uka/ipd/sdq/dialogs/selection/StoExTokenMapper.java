/**
 * 
 */
package de.uka.ipd.sdq.dialogs.selection;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

import antlr.Token;
import de.uka.ipd.sdq.stoex.parser.StochasticExpressionsParserTokenTypes;

/**
 * @author Steffen Becker
 *
 */
public class StoExTokenMapper implements ITokenMapper {

	/**
	 * 
	 */
	public StoExTokenMapper() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.dialogs.selection.IColorMapper#mapColor(antlr.Token)
	 */
	public Object mapColor(Token t) {
		switch (t.getType()) {
		case StochasticExpressionsParserTokenTypes.EQUAL:
		case StochasticExpressionsParserTokenTypes.PLUS:
		case StochasticExpressionsParserTokenTypes.MINUS:
		case StochasticExpressionsParserTokenTypes.MUL:
		case StochasticExpressionsParserTokenTypes.DIV:
		case StochasticExpressionsParserTokenTypes.POW:
		case StochasticExpressionsParserTokenTypes.LPAREN:
		case StochasticExpressionsParserTokenTypes.RPAREN:
			return null; //new TextAttribute (new Color( null, new RGB(255,255,0) ), null, SWT.BOLD);
		case StochasticExpressionsParserTokenTypes.LITERAL_DoublePDF:
		case StochasticExpressionsParserTokenTypes.LITERAL_IntPMF:
		case StochasticExpressionsParserTokenTypes.LITERAL_EnumPMF:
		case StochasticExpressionsParserTokenTypes.LITERAL_BoolPMF:			
		case StochasticExpressionsParserTokenTypes.LITERAL_DoublePMF:
			return new TextAttribute (new Color( null, new RGB(255,0,0) ), null, SWT.BOLD);
		case StochasticExpressionsParserTokenTypes.NUMBER:
		case StochasticExpressionsParserTokenTypes.STRING_LITERAL:
			return new TextAttribute (new Color( null, new RGB(0,0,255) ), null, SWT.BOLD);
		case StochasticExpressionsParserTokenTypes.LITERAL_BYTESIZE:
		case StochasticExpressionsParserTokenTypes.LITERAL_NUMBER_OF_ELEMENTS:
		case StochasticExpressionsParserTokenTypes.LITERAL_STRUCTURE:
		case StochasticExpressionsParserTokenTypes.LITERAL_VALUE:
		case StochasticExpressionsParserTokenTypes.LITERAL_TYPE:
		case StochasticExpressionsParserTokenTypes.LITERAL_INNER:
		case StochasticExpressionsParserTokenTypes.LITERAL_false:
		case StochasticExpressionsParserTokenTypes.LITERAL_true:
			return new TextAttribute (new Color( null, new RGB(255,0,255) ), null, SWT.ITALIC);
		case StochasticExpressionsParserTokenTypes.ID:
			return new TextAttribute (new Color( null, new RGB(255,0,255) ), null, SWT.NONE);
		default:
			return null;
		}
	}

}


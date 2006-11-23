/**
 * 
 */
package de.uka.ipd.sdq.dialogs.selection;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

import de.uka.ipd.sdq.pcm.stochasticexpressions.parser.StochasticExpressionsParserTokenTypes;
import antlr.Token;

/**
 * @author Steffen Becker
 *
 */
public class StoExTokenMapper implements IColorMapper {

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
			return null; //new TextAttribute (new Color( null, new RGB(255,255,0) ), null, SWT.BOLD);
		case StochasticExpressionsParserTokenTypes.REAL_DEF:
		case StochasticExpressionsParserTokenTypes.INT_DEF:
		case StochasticExpressionsParserTokenTypes.ENUM_DEF:
		case StochasticExpressionsParserTokenTypes.REAL_PDF:
			return new TextAttribute (new Color( null, new RGB(255,0,0) ), null, SWT.BOLD);
		case StochasticExpressionsParserTokenTypes.NUMBER:
		case StochasticExpressionsParserTokenTypes.STRING_LITERAL:
			return new TextAttribute (new Color( null, new RGB(0,0,255) ), null, SWT.BOLD);
		case StochasticExpressionsParserTokenTypes.ID:
			return new TextAttribute (new Color( null, new RGB(255,0,255) ), null, SWT.BOLD);
		default:
			return null;
		}
	}

}

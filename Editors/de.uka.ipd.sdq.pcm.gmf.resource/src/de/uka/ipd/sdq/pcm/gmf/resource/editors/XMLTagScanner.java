package de.uka.ipd.sdq.pcm.gmf.resource.editors;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;

/**
 * An xml tag scanner.
 */
public class XMLTagScanner extends RuleBasedScanner {

    /**
     * Initializes the xml tag scanner using a ColorManager.
     * 
     * @param manager
     *            a color manager
     */
    public XMLTagScanner(ColorManager manager) {
        IToken string = new Token(new TextAttribute(manager.getColor(IXMLColorConstants.STRING)));

        IRule[] rules = new IRule[3];

        // Add rule for double quotes
        rules[0] = new SingleLineRule("\"", "\"", string, '\\');
        // Add a rule for single quotes
        rules[1] = new SingleLineRule("'", "'", string, '\\');
        // Add generic whitespace rule.
        rules[2] = new WhitespaceRule(new XMLWhitespaceDetector());

        setRules(rules);
    }
}

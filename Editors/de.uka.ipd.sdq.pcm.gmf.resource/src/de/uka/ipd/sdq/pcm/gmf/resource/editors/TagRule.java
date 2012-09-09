package de.uka.ipd.sdq.pcm.gmf.resource.editors;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.MultiLineRule;

/**
 * A tag rule.
 */
public class TagRule extends MultiLineRule {

    /**
     * Initiates the tag rule using a token.
     * 
     * @param token
     *            the IToken
     */
    public TagRule(IToken token) {
        super("<", ">", token);
    }

    /**
     * true if a sequence has been detected.
     * 
     * @param eofAllowed
     *            true if eof is allowed.
     * @param scanner
     *            an ICharacterScanner
     * @param sequence
     *            a char Array
     * @return true if sequence has beed detected
     */
    protected boolean sequenceDetected(ICharacterScanner scanner, char[] sequence, boolean eofAllowed) {
        int c = scanner.read();
        if (sequence[0] == '<') {
            if (c == '?') {
                // processing instruction - abort
                scanner.unread();
                return false;
            }
            if (c == '!') {
                scanner.unread();
                // comment - abort
                return false;
            }
        } else if (sequence[0] == '>') {
            scanner.unread();
        }
        return super.sequenceDetected(scanner, sequence, eofAllowed);
    }
}

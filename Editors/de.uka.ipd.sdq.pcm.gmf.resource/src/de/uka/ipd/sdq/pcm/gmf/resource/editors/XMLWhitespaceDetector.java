package de.uka.ipd.sdq.pcm.gmf.resource.editors;

import org.eclipse.jface.text.rules.IWhitespaceDetector;

/**
 * An xml whitespace detector.
 */
public class XMLWhitespaceDetector implements IWhitespaceDetector {

    /**
     * @param c
     *            the character to test
     * @return ture if c is a whitespace
     */
    public boolean isWhitespace(char c) {
        return (c == ' ' || c == '\t' || c == '\n' || c == '\r');
    }
}

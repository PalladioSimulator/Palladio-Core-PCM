/**
 * 
 */
package de.uka.ipd.sdq.pcm.dialogs.stoex;

import java.lang.reflect.InvocationTargetException;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.Lexer;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.ITokenScanner;

/**
 * @author Steffen Becker
 * 
 */
public class ANTLRTokenScannerAdapter implements ITokenScanner {

    int lastTokenLength = 0;

    private int tokenOffset;

    private Class<?> scannerClass;

    private Lexer scanner;

    private String currentInput;

    private IDocument currentDocument;

    private int baseOffset;

    private ITokenMapper myMapper;

    private int lastTokenOffset;

    /**
	 * 
	 */
    public ANTLRTokenScannerAdapter(Class<?> scannerClass, ITokenMapper mapper) {
        this.scannerClass = scannerClass;
        this.myMapper = mapper;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.text.rules.ITokenScanner#getTokenLength()
     */
    public int getTokenLength() {
        return lastTokenLength;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.text.rules.ITokenScanner#getTokenOffset()
     */
    public int getTokenOffset() {
        return tokenOffset;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.text.rules.ITokenScanner#nextToken()
     */
    public IToken nextToken() {
        tokenOffset = baseOffset + scanner.getCharIndex(); // Token starts at point where lexer is
        ANTLRTokenWrapper wrapper = new ANTLRTokenWrapper(scanner.nextToken(), myMapper);
        lastTokenLength = wrapper.getToken().getText() == null ? 0 : wrapper.getToken().getText().length();
        tokenOffset += (scanner.getCharIndex() + baseOffset) - tokenOffset - lastTokenLength; // Correct
                                                                                              // the
                                                                                              // position
                                                                                              // in
                                                                                              // case
                                                                                              // of
                                                                                              // recognition
                                                                                              // exceptions

        wrapper.setIsWhitespace(wrapper.getToken().getChannel() == BaseRecognizer.HIDDEN);// Token
                                                                                          // is a
                                                                                          // Whitespace
        return wrapper;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.text.rules.ITokenScanner#setRange(org.eclipse.jface.text.IDocument,
     * int, int)
     */
    public void setRange(IDocument document, int offset, int length) {
        currentInput = "";
        currentDocument = document;
        try {
            currentInput = document.get(offset, length);
            lastTokenOffset = 0;
            tokenOffset = offset;
            baseOffset = offset;
        } catch (BadLocationException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        ANTLRStringStream reader = new ANTLRStringStream(currentInput);
        try {
            scanner = (Lexer) scannerClass.getConstructor(CharStream.class).newInstance(new Object[] { reader });
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

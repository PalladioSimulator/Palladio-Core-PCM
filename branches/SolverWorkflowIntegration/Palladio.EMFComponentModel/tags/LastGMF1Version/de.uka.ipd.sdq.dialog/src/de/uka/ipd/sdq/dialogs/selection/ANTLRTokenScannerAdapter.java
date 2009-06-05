/**
 * 
 */
package de.uka.ipd.sdq.dialogs.selection;

import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.ITokenScanner;

import antlr.CharScanner;
import antlr.CharStreamException;
import antlr.TokenStreamException;

/**
 * @author Steffen Becker
 * 
 */
public class ANTLRTokenScannerAdapter implements ITokenScanner {

	int lastTokenLength = 0;

	private int tokenOffset;

	private Class scannerClass;

	private CharScanner scanner;

	private String currentInput;

	private ANTLRTokenWrapper holdBackToken;

	private IDocument currentDocument;

	private int baseOffset;

	private ITokenMapper myMapper;

	/**
	 * 
	 */
	public ANTLRTokenScannerAdapter(Class scannerClass, ITokenMapper mapper) {
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
		ANTLRTokenWrapper wrapper = null;
		if (holdBackToken != null){
			wrapper = holdBackToken;
			holdBackToken = null;
		} else {
			try {
				wrapper = new ANTLRTokenWrapper(scanner.nextToken(), myMapper);
			} catch (TokenStreamException e) {
				try {
					if (ParserHelper.positionToOffset(currentDocument, scanner.getLine(), scanner.getColumn()) + baseOffset <= currentDocument.get().length())
					{
						scanner.consume();
						lastTokenLength = 1;
					}
					else
					{
						lastTokenLength = 0;
					}
				} catch (CharStreamException e1) {
					e1.printStackTrace();
				}
				tokenOffset = ParserHelper.positionToOffset(currentDocument, scanner.getLine(), scanner.getColumn()) + baseOffset;
				return new ANTLRTokenWrapper(true,false);
			}
			if (ParserHelper.positionToOffset(currentDocument, wrapper.getToken().getLine(), wrapper.getToken().getColumn()) + baseOffset != tokenOffset+lastTokenLength) {
				this.holdBackToken = wrapper;
			    tokenOffset += lastTokenLength;
			    lastTokenLength = ParserHelper.positionToOffset(currentDocument, wrapper.getToken().getLine(), wrapper.getToken().getColumn()) + baseOffset - tokenOffset;
				return new ANTLRTokenWrapper(false,true);
			}
		}
		lastTokenLength = wrapper.getToken().getText() == null ? 0 : wrapper.getToken().getText().length();
		tokenOffset = ParserHelper.positionToOffset(currentDocument, wrapper.getToken().getLine(), wrapper.getToken().getColumn())+baseOffset;
		return wrapper;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.text.rules.ITokenScanner#setRange(org.eclipse.jface.text.IDocument,
	 *      int, int)
	 */
	public void setRange(IDocument document, int offset, int length) {
		currentInput = ""; currentDocument = document;
		try {
			currentInput = document.get(offset, length);
			lastTokenLength = 0;
			tokenOffset = offset; 
			baseOffset = offset;
		} catch (BadLocationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		StringReader reader = new StringReader(currentInput);
		try {
			scanner = (CharScanner) scannerClass.getConstructor(Reader.class)
					.newInstance(new Object[] { reader });
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

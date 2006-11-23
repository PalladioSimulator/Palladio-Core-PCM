package de.uka.ipd.sdq.dialogs.selection;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

import antlr.CharScanner;
import antlr.Token;

public class ANTLRTokenWrapper implements IToken {

	private Token token;
	private boolean isUndefined;
	private IColorMapper mapper;
	private boolean isWhitespace;

	public ANTLRTokenWrapper(Token t, IColorMapper mapper)
	{
		this.token = t;
		this.isUndefined = false;
		this.isWhitespace = false;
		this.mapper = mapper;
	}
	
	public ANTLRTokenWrapper(boolean isUndefined, boolean isWhitespace) {
		this.isWhitespace = isWhitespace;
		this.isUndefined = isUndefined;
	}

	public Object getData() {
		if (mapper == null)
			return null;
		return mapper.mapColor(token);
	}

	public boolean isEOF() {
		if (token == null)
			return false;
		return token.getType() == Token.EOF_TYPE;
	}

	public boolean isOther() {
		return false;
	}

	public boolean isUndefined() {
		return isUndefined;
	}

	public boolean isWhitespace() {
		return isWhitespace;
	}

	public Token getToken() {
		return token;
	}
}

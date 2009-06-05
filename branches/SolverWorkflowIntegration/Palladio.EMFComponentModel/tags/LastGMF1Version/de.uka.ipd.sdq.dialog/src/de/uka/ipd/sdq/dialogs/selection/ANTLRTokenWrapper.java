package de.uka.ipd.sdq.dialogs.selection;

import org.eclipse.jface.text.rules.IToken;

import antlr.Token;

public class ANTLRTokenWrapper implements IToken {

	private Token token;
	private boolean isUndefined;
	private ITokenMapper mapper;
	private boolean isWhitespace;

	public ANTLRTokenWrapper(Token t, ITokenMapper myMapper)
	{
		this.token = t;
		this.isUndefined = false;
		this.isWhitespace = false;
		this.mapper = myMapper;
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

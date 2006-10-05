// $ANTLR : "stoex.g" -> "StochasticExpressionsParser.java"$
  
	package de.uka.ipd.sdq.pcm.stochasticexpressions.parser;
	import de.uka.ipd.sdq.pcm.core.stochastics.*;

import antlr.TokenBuffer;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.ANTLRException;
import antlr.LLkParser;
import antlr.Token;
import antlr.TokenStream;
import antlr.RecognitionException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.ParserSharedInputState;
import antlr.collections.impl.BitSet;
@SuppressWarnings({"unused"})
public class StochasticExpressionsParser extends antlr.LLkParser       implements StochasticExpressionsParserTokenTypes
 {

protected StochasticExpressionsParser(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
}

public StochasticExpressionsParser(TokenBuffer tokenBuf) {
  this(tokenBuf,1);
}

protected StochasticExpressionsParser(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
}

public StochasticExpressionsParser(TokenStream lexer) {
  this(lexer,1);
}

public StochasticExpressionsParser(ParserSharedInputState state) {
  super(state,1);
  tokenNames = _tokenNames;
}

	public final Expression  expression() throws RecognitionException, TokenStreamException {
		Expression exp;
		
		exp = null;
		
		Comparison c;
		match(EQUAL);
		c=compareExpr();
		exp = c;
		return exp;
	}
	
	public final Comparison  compareExpr() throws RecognitionException, TokenStreamException {
		Comparison comp;
		
		comp = null;
		
		Term t1 = null, t2 = null;
		t1=sumExpr();
		comp = t1;
		{
		switch ( LA(1)) {
		case EQUAL:
		case GREATER:
		case LESS:
		case NOTEQUAL:
		case GREATEREQUAL:
		case LESSEQUAL:
		{
			CompareExpression compExp = StochasticsFactory.eINSTANCE.createCompareExpression();
			{
			switch ( LA(1)) {
			case GREATER:
			{
				match(GREATER);
				compExp.setOperation(CompareOperations.GREATER_LITERAL);
				break;
			}
			case LESS:
			{
				match(LESS);
				compExp.setOperation(CompareOperations.LESS_LITERAL);
				break;
			}
			case EQUAL:
			{
				match(EQUAL);
				compExp.setOperation(CompareOperations.EQUALS_LITERAL);
				break;
			}
			case NOTEQUAL:
			{
				match(NOTEQUAL);
				compExp.setOperation(CompareOperations.NOTEQUAL_LITERAL);
				break;
			}
			case GREATEREQUAL:
			{
				match(GREATEREQUAL);
				compExp.setOperation(CompareOperations.GREATEREQUAL_LITERAL);
				break;
			}
			case LESSEQUAL:
			{
				match(LESSEQUAL);
				compExp.setOperation(CompareOperations.LESSEQUAL_LITERAL);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			t2=sumExpr();
			compExp.setLeft(t1); compExp.setRight(t2); comp=compExp;
			break;
		}
		case EOF:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		return comp;
	}
	
	public final Term  sumExpr() throws RecognitionException, TokenStreamException {
		Term t;
		
		t = null;
		
		Product p1 = null, p2 = null;
		p1=prodExpr();
		t = p1;
		{
		_loop1418:
		do {
			if ((LA(1)==PLUS||LA(1)==MINUS)) {
				TermExpression termExp = StochasticsFactory.eINSTANCE.createTermExpression();
				{
				switch ( LA(1)) {
				case PLUS:
				{
					match(PLUS);
					termExp.setOperation(TermOperations.ADD_LITERAL);
					break;
				}
				case MINUS:
				{
					match(MINUS);
					termExp.setOperation(TermOperations.SUB_LITERAL);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				p2=prodExpr();
				termExp.setLeft(t); termExp.setRight(p2); t = termExp;
			}
			else {
				break _loop1418;
			}
			
		} while (true);
		}
		return t;
	}
	
	public final Product  prodExpr() throws RecognitionException, TokenStreamException {
		Product p;
		
		p = null;
		
		Power pw1 = null, pw2 = null;
		pw1=powExpr();
		p = pw1;
		{
		_loop1422:
		do {
			if (((LA(1) >= MUL && LA(1) <= MOD))) {
				ProductExpression prodExp = StochasticsFactory.eINSTANCE.createProductExpression();
				{
				switch ( LA(1)) {
				case MUL:
				{
					match(MUL);
					prodExp.setOperation(ProductOperations.MULT_LITERAL);
					break;
				}
				case DIV:
				{
					match(DIV);
					prodExp.setOperation(ProductOperations.DIV_LITERAL);
					break;
				}
				case MOD:
				{
					match(MOD);
					prodExp.setOperation(ProductOperations.MOD_LITERAL);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				pw2=powExpr();
				prodExp.setLeft(p); prodExp.setRight(pw2); p = prodExp;
			}
			else {
				break _loop1422;
			}
			
		} while (true);
		}
		return p;
	}
	
	public final Power  powExpr() throws RecognitionException, TokenStreamException {
		Power pw;
		
		pw = null;
		
		Atom a1 = null, a2 = null;
		a1=atom();
		pw = a1;
		{
		switch ( LA(1)) {
		case POW:
		{
			match(POW);
			a2=atom();
			break;
		}
		case EOF:
		case EQUAL:
		case GREATER:
		case LESS:
		case NOTEQUAL:
		case GREATEREQUAL:
		case LESSEQUAL:
		case PLUS:
		case MINUS:
		case MUL:
		case DIV:
		case MOD:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		return pw;
	}
	
	public final Atom  atom() throws RecognitionException, TokenStreamException {
		Atom a;
		
		Token  number = null;
		Token  id = null;
		a = null;
		
		{
		switch ( LA(1)) {
		case NUMBER:
		{
			number = LT(1);
			match(NUMBER);
			
							String value = number.getText();
							if (value.indexOf('.') < 0)
							{
								IntLiteral il = StochasticsFactory.eINSTANCE.createIntLiteral();
								il.setValue(Integer.parseInt(value));
								a = il;
							}
							else
							{
								DoubleLiteral dl = StochasticsFactory.eINSTANCE.createDoubleLiteral();
								dl.setValue(Double.parseDouble(value));
								a = dl;
							}
						
			break;
		}
		case ID:
		{
			id = LT(1);
			match(ID);
			a = StochasticsFactory.eINSTANCE.createVariable();
					  	((Variable)a).setId(id.getText());
					
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		return a;
	}
	
	public final void definition() throws RecognitionException, TokenStreamException {
		
		
		switch ( LA(1)) {
		case INT_DEF:
		case REAL_DEF:
		{
			{
			switch ( LA(1)) {
			case INT_DEF:
			{
				match(INT_DEF);
				break;
			}
			case REAL_DEF:
			{
				match(REAL_DEF);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(SQUARE_PAREN_L);
			{
			int _cnt1430=0;
			_loop1430:
			do {
				if ((LA(1)==LPAREN)) {
					numericsample();
				}
				else {
					if ( _cnt1430>=1 ) { break _loop1430; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt1430++;
			} while (true);
			}
			match(SQUARE_PAREN_R);
			break;
		}
		case ENUM_DEF:
		{
			{
			match(ENUM_DEF);
			}
			match(SQUARE_PAREN_L);
			{
			int _cnt1433=0;
			_loop1433:
			do {
				if ((LA(1)==LPAREN)) {
					stringsample();
				}
				else {
					if ( _cnt1433>=1 ) { break _loop1433; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt1433++;
			} while (true);
			}
			match(SQUARE_PAREN_R);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}
	
	public final void numericsample() throws RecognitionException, TokenStreamException {
		
		
		match(LPAREN);
		match(NUMBER);
		match(SEMI);
		match(NUMBER);
		match(RPAREN);
	}
	
	public final void stringsample() throws RecognitionException, TokenStreamException {
		
		
		match(LPAREN);
		match(NUMBER);
		match(SEMI);
		match(STRING_LITERAL);
		match(RPAREN);
	}
	
	public final void parameter_id() throws RecognitionException, TokenStreamException {
		
		
		switch ( LA(1)) {
		case STRING_LITERAL:
		{
			match(STRING_LITERAL);
			break;
		}
		case INNER:
		{
			match(INNER);
			match(LESS);
			match(STRING_LITERAL);
			match(GREATER);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"EQUAL",
		"GREATER",
		"LESS",
		"NOTEQUAL",
		"GREATEREQUAL",
		"LESSEQUAL",
		"PLUS",
		"MINUS",
		"MUL",
		"DIV",
		"MOD",
		"POW",
		"NUMBER",
		"ID",
		"INT_DEF",
		"REAL_DEF",
		"SQUARE_PAREN_L",
		"SQUARE_PAREN_R",
		"ENUM_DEF",
		"LPAREN",
		"SEMI",
		"RPAREN",
		"STRING_LITERAL",
		"INNER",
		"DIGIT",
		"ALPHA",
		"MEAN",
		"PROB",
		"FUNCTION_DEF",
		"WS"
	};
	
	
	}

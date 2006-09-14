// $ANTLR 2.7.3: "bibtex2.g" -> "MyEntryLexer.cs"$

    // gets inserted in the C# source file before any
    // generated namespace declarations
    // hence -- can only be using directives
    using System.Collections;
    using BibTeX.Parser.Types;
    using BibTeX.Parser.Interfaces;
    using antlr;

namespace BibTeX.Parser.Grammar
{
	// Generate header specific to lexer CSharp file
	using System;
	using Stream                          = System.IO.Stream;
	using TextReader                      = System.IO.TextReader;
	using Hashtable                       = System.Collections.Hashtable;
	using Comparer                        = System.Collections.Comparer;
	
	using TokenStreamException            = antlr.TokenStreamException;
	using TokenStreamIOException          = antlr.TokenStreamIOException;
	using TokenStreamRecognitionException = antlr.TokenStreamRecognitionException;
	using CharStreamException             = antlr.CharStreamException;
	using CharStreamIOException           = antlr.CharStreamIOException;
	using ANTLRException                  = antlr.ANTLRException;
	using CharScanner                     = antlr.CharScanner;
	using InputBuffer                     = antlr.InputBuffer;
	using ByteBuffer                      = antlr.ByteBuffer;
	using CharBuffer                      = antlr.CharBuffer;
	using Token                           = antlr.Token;
	using CommonToken                     = antlr.CommonToken;
	using SemanticException               = antlr.SemanticException;
	using RecognitionException            = antlr.RecognitionException;
	using NoViableAltForCharException     = antlr.NoViableAltForCharException;
	using MismatchedCharException         = antlr.MismatchedCharException;
	using TokenStream                     = antlr.TokenStream;
	using LexerSharedInputState           = antlr.LexerSharedInputState;
	using BitSet                          = antlr.collections.impl.BitSet;
	
   // global code stuff that will be included in the source file just before the 'MyLexer' class below

	internal 	class MyEntryLexer : antlr.CharScanner	, TokenStream
	 {
		public const int EOF = 1;
		public const int NULL_TREE_LOOKAHEAD = 3;
		public const int OPENBRACE = 4;
		public const int CLOSEBRACE = 5;
		public const int QUOTES = 6;
		public const int WS_TOKEN = 7;
		public const int NEWLINE = 8;
		public const int ESC = 9;
		public const int CONTENT_CHAR = 10;
		public const int INNER_CHAR = 11;
		public const int INNER_CHAR2 = 12;
		public const int INNER_CHAR3 = 13;
		public const int CONTENT = 14;
		public const int STRINGVALUEINNER = 15;
		public const int STRINGVALUEINNER2 = 16;
		public const int STRINGVALUEINNER3 = 17;
		public const int UNQUOTED_STRINGVALUE = 18;
		public const int QUOTED_STRINGVALUE = 19;
		public const int BRACED_STRINGVALUE = 20;
		public const int WS_BEFORE_STRING_VALUE = 21;
		public const int CHARS = 22;
		public const int DIGITS = 23;
		public const int SPECIALS = 24;
		public const int SPECIALS1 = 25;
		public const int SPECIALS2 = 26;
		public const int SPECIALS3 = 27;
		public const int ENTRY_OPEN = 28;
		public const int ENTRY_CLOSE = 29;
		public const int EQUALS = 30;
		public const int HASH = 31;
		public const int COMMA = 32;
		public const int COMMENT = 33;
		public const int WS = 34;
		public const int ID = 35;
		
		
   public event LogEventHandler LexerLogEvent;
   
   public override void reportError(string message)
   {
	base.reportError(message);
	if (LexerLogEvent != null)
		LexerLogEvent(this,new LogEventArgs(LogType.ERROR,message));
   }

   public override void reportError(RecognitionException ex)
   {
	base.reportError(ex);
	if (LexerLogEvent != null)
		LexerLogEvent(this,new LogEventArgs(LogType.ERROR,ex.Message));
   }
		public MyEntryLexer(Stream ins) : this(new ByteBuffer(ins))
		{
		}
		
		public MyEntryLexer(TextReader r) : this(new CharBuffer(r))
		{
		}
		
		public MyEntryLexer(InputBuffer ib)		 : this(new LexerSharedInputState(ib))
		{
		}
		
		public MyEntryLexer(LexerSharedInputState state) : base(state)
		{
			initialize();
		}
		private void initialize()
		{
			caseSensitiveLiterals = true;
			setCaseSensitive(true);
			literals = new Hashtable(null, Comparer.Default);
		}
		
		override public Token nextToken()			//throws TokenStreamException
		{
			Token theRetToken = null;
tryAgain:
			for (;;)
			{
				Token _token = null;
				int _ttype = Token.INVALID_TYPE;
				resetText();
				try     // for char stream error handling
				{
					try     // for lexical error handling
					{
						switch ( LA(1) )
						{
						case '(':  case '{':
						{
							mENTRY_OPEN(true);
							theRetToken = returnToken_;
							break;
						}
						case ')':  case '}':
						{
							mENTRY_CLOSE(true);
							theRetToken = returnToken_;
							break;
						}
						case '=':
						{
							mEQUALS(true);
							theRetToken = returnToken_;
							break;
						}
						case '#':
						{
							mHASH(true);
							theRetToken = returnToken_;
							break;
						}
						case ',':
						{
							mCOMMA(true);
							theRetToken = returnToken_;
							break;
						}
						case '%':
						{
							mCOMMENT(true);
							theRetToken = returnToken_;
							break;
						}
						case '\t':  case '\n':  case '\r':  case ' ':
						{
							mWS(true);
							theRetToken = returnToken_;
							break;
						}
						case '-':  case '0':  case '1':  case '2':
						case '3':  case '4':  case '5':  case '6':
						case '7':  case '8':  case '9':  case ':':
						case 'A':  case 'B':  case 'C':  case 'D':
						case 'E':  case 'F':  case 'G':  case 'H':
						case 'I':  case 'J':  case 'K':  case 'L':
						case 'M':  case 'N':  case 'O':  case 'P':
						case 'Q':  case 'R':  case 'S':  case 'T':
						case 'U':  case 'V':  case 'W':  case 'X':
						case 'Y':  case 'Z':  case '_':  case 'a':
						case 'b':  case 'c':  case 'd':  case 'e':
						case 'f':  case 'g':  case 'h':  case 'i':
						case 'j':  case 'k':  case 'l':  case 'm':
						case 'n':  case 'o':  case 'p':  case 'q':
						case 'r':  case 's':  case 't':  case 'u':
						case 'v':  case 'w':  case 'x':  case 'y':
						case 'z':
						{
							mID(true);
							theRetToken = returnToken_;
							break;
						}
						default:
						{
							if (LA(1)==EOF_CHAR) { uponEOF(); returnToken_ = makeToken(Token.EOF_TYPE); }
				else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
						}
						break; }
						if ( null==returnToken_ ) goto tryAgain; // found SKIP token
						_ttype = returnToken_.Type;
						_ttype = testLiteralsTable(_ttype);
						returnToken_.Type = _ttype;
						return returnToken_;
					}
					catch (RecognitionException e) {
							throw new TokenStreamRecognitionException(e);
					}
				}
				catch (CharStreamException cse) {
					if ( cse is CharStreamIOException ) {
						throw new TokenStreamIOException(((CharStreamIOException)cse).io);
					}
					else {
						throw new TokenStreamException(cse.Message);
					}
				}
			}
		}
		
	public void mENTRY_OPEN(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = ENTRY_OPEN;
		
		switch ( LA(1) )
		{
		case '(':
		{
			match('(');
			break;
		}
		case '{':
		{
			match('{');
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		 }
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mENTRY_CLOSE(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = ENTRY_CLOSE;
		
		{
			switch ( LA(1) )
			{
			case ')':
			{
				match(')');
				break;
			}
			case '}':
			{
				match('}');
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			 }
		}
		MyParser.selector.pop();
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mEQUALS(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = EQUALS;
		
		match('=');
		MyParser.selector.push("valuelexer");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mHASH(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = HASH;
		
		match('#');
		MyParser.selector.push("valuelexer");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCOMMA(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = COMMA;
		
		match(',');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mCOMMENT(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = COMMENT;
		
		match('%');
		{    // ( ... )*
			for (;;)
			{
				if ((tokenSet_0_.member(LA(1))))
				{
					matchNot('\n');
				}
				else
				{
					goto _loop9_breakloop;
				}
				
			}
_loop9_breakloop:			;
		}    // ( ... )*
		match('\n');
		_ttype = Token.SKIP; newline();
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	protected void mNEWLINE(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = NEWLINE;
		
		match('\n');
		newline();
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	protected void mWS_TOKEN(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = WS_TOKEN;
		
		{ // ( ... )+
		int _cnt13=0;
		for (;;)
		{
			switch ( LA(1) )
			{
			case ' ':
			{
				match(' ');
				break;
			}
			case '\r':
			{
				match('\r');
				break;
			}
			case '\t':
			{
				match('\t');
				break;
			}
			default:
			{
				if (_cnt13 >= 1) { goto _loop13_breakloop; } else { throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());; }
			}
			break; }
			_cnt13++;
		}
_loop13_breakloop:		;
		}    // ( ... )+
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mWS(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = WS;
		
		{
			switch ( LA(1) )
			{
			case '\n':
			{
				mNEWLINE(false);
				break;
			}
			case '\t':  case '\r':  case ' ':
			{
				mWS_TOKEN(false);
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			 }
		}
		_ttype = Token.SKIP;
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	protected void mCHARS(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CHARS;
		
		switch ( LA(1) )
		{
		case 'a':  case 'b':  case 'c':  case 'd':
		case 'e':  case 'f':  case 'g':  case 'h':
		case 'i':  case 'j':  case 'k':  case 'l':
		case 'm':  case 'n':  case 'o':  case 'p':
		case 'q':  case 'r':  case 's':  case 't':
		case 'u':  case 'v':  case 'w':  case 'x':
		case 'y':  case 'z':
		{
			matchRange('a','z');
			break;
		}
		case 'A':  case 'B':  case 'C':  case 'D':
		case 'E':  case 'F':  case 'G':  case 'H':
		case 'I':  case 'J':  case 'K':  case 'L':
		case 'M':  case 'N':  case 'O':  case 'P':
		case 'Q':  case 'R':  case 'S':  case 'T':
		case 'U':  case 'V':  case 'W':  case 'X':
		case 'Y':  case 'Z':
		{
			matchRange('A','Z');
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		 }
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	protected void mDIGITS(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = DIGITS;
		
		matchRange('0','9');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	protected void mSPECIALS(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = SPECIALS;
		
		switch ( LA(1) )
		{
		case '_':
		{
			match('_');
			break;
		}
		case '-':
		{
			match('-');
			break;
		}
		case ':':
		{
			match(':');
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		 }
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mID(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = ID;
		
		{ // ( ... )+
		int _cnt21=0;
		for (;;)
		{
			switch ( LA(1) )
			{
			case 'A':  case 'B':  case 'C':  case 'D':
			case 'E':  case 'F':  case 'G':  case 'H':
			case 'I':  case 'J':  case 'K':  case 'L':
			case 'M':  case 'N':  case 'O':  case 'P':
			case 'Q':  case 'R':  case 'S':  case 'T':
			case 'U':  case 'V':  case 'W':  case 'X':
			case 'Y':  case 'Z':  case 'a':  case 'b':
			case 'c':  case 'd':  case 'e':  case 'f':
			case 'g':  case 'h':  case 'i':  case 'j':
			case 'k':  case 'l':  case 'm':  case 'n':
			case 'o':  case 'p':  case 'q':  case 'r':
			case 's':  case 't':  case 'u':  case 'v':
			case 'w':  case 'x':  case 'y':  case 'z':
			{
				mCHARS(false);
				break;
			}
			case '0':  case '1':  case '2':  case '3':
			case '4':  case '5':  case '6':  case '7':
			case '8':  case '9':
			{
				mDIGITS(false);
				break;
			}
			case '-':  case ':':  case '_':
			{
				mSPECIALS(false);
				break;
			}
			default:
			{
				if (_cnt21 >= 1) { goto _loop21_breakloop; } else { throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());; }
			}
			break; }
			_cnt21++;
		}
_loop21_breakloop:		;
		}    // ( ... )+
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	
	private static long[] mk_tokenSet_0_()
	{
		long[] data = { 2882078537727091200L, 3458764507512307710L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_0_ = new BitSet(mk_tokenSet_0_());
	
}
}

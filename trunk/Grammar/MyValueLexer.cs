// $ANTLR 2.7.3: "bibtex3.g" -> "MyValueLexer.cs"$

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

	internal 	class MyValueLexer : antlr.CharScanner	, TokenStream
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
		public MyValueLexer(Stream ins) : this(new ByteBuffer(ins))
		{
		}
		
		public MyValueLexer(TextReader r) : this(new CharBuffer(r))
		{
		}
		
		public MyValueLexer(InputBuffer ib)		 : this(new LexerSharedInputState(ib))
		{
		}
		
		public MyValueLexer(LexerSharedInputState state) : base(state)
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
						case '0':  case '1':  case '2':  case '3':
						case '4':  case '5':  case '6':  case '7':
						case '8':  case '9':  case 'A':  case 'B':
						case 'C':  case 'D':  case 'E':  case 'F':
						case 'G':  case 'H':  case 'I':  case 'J':
						case 'K':  case 'L':  case 'M':  case 'N':
						case 'O':  case 'P':  case 'Q':  case 'R':
						case 'S':  case 'T':  case 'U':  case 'V':
						case 'W':  case 'X':  case 'Y':  case 'Z':
						case '\\':  case 'a':  case 'b':  case 'c':
						case 'd':  case 'e':  case 'f':  case 'g':
						case 'h':  case 'i':  case 'j':  case 'k':
						case 'l':  case 'm':  case 'n':  case 'o':
						case 'p':  case 'q':  case 'r':  case 's':
						case 't':  case 'u':  case 'v':  case 'w':
						case 'x':  case 'y':  case 'z':
						{
							mUNQUOTED_STRINGVALUE(true);
							theRetToken = returnToken_;
							break;
						}
						case '"':
						{
							mQUOTED_STRINGVALUE(true);
							theRetToken = returnToken_;
							break;
						}
						case '{':
						{
							mBRACED_STRINGVALUE(true);
							theRetToken = returnToken_;
							break;
						}
						case '\t':  case '\n':  case '\r':  case ' ':
						{
							mWS_BEFORE_STRING_VALUE(true);
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
		
	protected void mOPENBRACE(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = OPENBRACE;
		
		match('{');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	protected void mCLOSEBRACE(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CLOSEBRACE;
		
		match('}');
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	protected void mQUOTES(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = QUOTES;
		
		match('\"');
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
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			 }
		}
		text.Length = _begin; text.Append(" ");
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
	
	protected void mESC(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = ESC;
		
		match('\\');
		{
			switch ( LA(1) )
			{
			case '\\':
			{
				match('\\');
				break;
			}
			case '{':
			{
				match('{');
				break;
			}
			case '}':
			{
				match('}');
				break;
			}
			case '(':
			{
				match('(');
				break;
			}
			case ')':
			{
				match(')');
				break;
			}
			case '"':
			{
				match('\"');
				break;
			}
			case '&':
			{
				match('&');
				break;
			}
			case '-':
			{
				match('-');
				break;
			}
			case '_':
			{
				match('_');
				break;
			}
			case '$':
			{
				match('$');
				break;
			}
			case '@':
			{
				match('@');
				break;
			}
			case '\'':
			{
				match('\'');
				break;
			}
			case ' ':
			{
				match(' ');
				break;
			}
			case '`':
			{
				match('`');
				break;
			}
			case '\u00b4':
			{
				match('´');
				break;
			}
			case '^':
			{
				match('^');
				break;
			}
			case '~':
			{
				match('~');
				break;
			}
			case ',':
			{
				match(',');
				break;
			}
			case '!':
			{
				match('!');
				break;
			}
			case '=':
			{
				match('=');
				break;
			}
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
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			 }
		}
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
	
	protected void mCONTENT_CHAR(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CONTENT_CHAR;
		
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
		case '\\':
		{
			mESC(false);
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
	
	protected void mINNER_CHAR(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = INNER_CHAR;
		
		switch ( LA(1) )
		{
		case '0':  case '1':  case '2':  case '3':
		case '4':  case '5':  case '6':  case '7':
		case '8':  case '9':  case 'A':  case 'B':
		case 'C':  case 'D':  case 'E':  case 'F':
		case 'G':  case 'H':  case 'I':  case 'J':
		case 'K':  case 'L':  case 'M':  case 'N':
		case 'O':  case 'P':  case 'Q':  case 'R':
		case 'S':  case 'T':  case 'U':  case 'V':
		case 'W':  case 'X':  case 'Y':  case 'Z':
		case '\\':  case 'a':  case 'b':  case 'c':
		case 'd':  case 'e':  case 'f':  case 'g':
		case 'h':  case 'i':  case 'j':  case 'k':
		case 'l':  case 'm':  case 'n':  case 'o':
		case 'p':  case 'q':  case 'r':  case 's':
		case 't':  case 'u':  case 'v':  case 'w':
		case 'x':  case 'y':  case 'z':
		{
			mCONTENT_CHAR(false);
			break;
		}
		case '\t':  case '\n':  case '\r':  case ' ':
		case '!':  case '$':  case '&':  case '\'':
		case '*':  case '+':  case '-':  case '.':
		case '/':  case ':':  case ';':  case '<':
		case '=':  case '>':  case '?':  case '[':
		case ']':  case '^':  case '_':  case '`':
		case '|':  case '~':  case '\u00b4':  case '\u00c4':
		case '\u00d6':  case '\u00dc':  case '\u00df':  case '\u00e4':
		case '\u00e9':  case '\u00f3':  case '\u00f4':  case '\u00f6':
		case '\u00fc':  case '\u00fd':
		{
			mSPECIALS(false);
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
	
	protected void mSPECIALS(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = SPECIALS;
		
		switch ( LA(1) )
		{
		case '\t':  case '\n':  case '\r':  case ' ':
		case '!':  case '$':  case '\'':  case '*':
		case '+':  case '-':  case '.':  case '/':
		case ':':  case ';':  case '<':  case '=':
		case '>':  case '?':  case '[':  case ']':
		case '^':  case '`':  case '|':  case '~':
		case '\u00b4':
		{
			mSPECIALS1(false);
			break;
		}
		case '\u00e9':  case '\u00f3':  case '\u00f4':  case '\u00fd':
		{
			mSPECIALS2(false);
			break;
		}
		case '&':  case '_':  case '\u00c4':  case '\u00d6':
		case '\u00dc':  case '\u00df':  case '\u00e4':  case '\u00f6':
		case '\u00fc':
		{
			mSPECIALS3(false);
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
	
	protected void mINNER_CHAR2(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = INNER_CHAR2;
		
		switch ( LA(1) )
		{
		case '\t':  case '\n':  case '\r':  case ' ':
		case '!':  case '$':  case '&':  case '\'':
		case '*':  case '+':  case '-':  case '.':
		case '/':  case '0':  case '1':  case '2':
		case '3':  case '4':  case '5':  case '6':
		case '7':  case '8':  case '9':  case ':':
		case ';':  case '<':  case '=':  case '>':
		case '?':  case 'A':  case 'B':  case 'C':
		case 'D':  case 'E':  case 'F':  case 'G':
		case 'H':  case 'I':  case 'J':  case 'K':
		case 'L':  case 'M':  case 'N':  case 'O':
		case 'P':  case 'Q':  case 'R':  case 'S':
		case 'T':  case 'U':  case 'V':  case 'W':
		case 'X':  case 'Y':  case 'Z':  case '[':
		case '\\':  case ']':  case '^':  case '_':
		case '`':  case 'a':  case 'b':  case 'c':
		case 'd':  case 'e':  case 'f':  case 'g':
		case 'h':  case 'i':  case 'j':  case 'k':
		case 'l':  case 'm':  case 'n':  case 'o':
		case 'p':  case 'q':  case 'r':  case 's':
		case 't':  case 'u':  case 'v':  case 'w':
		case 'x':  case 'y':  case 'z':  case '|':
		case '~':  case '\u00b4':  case '\u00c4':  case '\u00d6':
		case '\u00dc':  case '\u00df':  case '\u00e4':  case '\u00e9':
		case '\u00f3':  case '\u00f4':  case '\u00f6':  case '\u00fc':
		case '\u00fd':
		{
			mINNER_CHAR(false);
			break;
		}
		case ',':
		{
			match(',');
			break;
		}
		case '#':
		{
			match('#');
			break;
		}
		case '(':
		{
			match('(');
			break;
		}
		case ')':
		{
			match(')');
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
	
	protected void mINNER_CHAR3(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = INNER_CHAR3;
		
		switch ( LA(1) )
		{
		case '\t':  case '\n':  case '\r':  case ' ':
		case '!':  case '$':  case '&':  case '\'':
		case '*':  case '+':  case '-':  case '.':
		case '/':  case '0':  case '1':  case '2':
		case '3':  case '4':  case '5':  case '6':
		case '7':  case '8':  case '9':  case ':':
		case ';':  case '<':  case '=':  case '>':
		case '?':  case 'A':  case 'B':  case 'C':
		case 'D':  case 'E':  case 'F':  case 'G':
		case 'H':  case 'I':  case 'J':  case 'K':
		case 'L':  case 'M':  case 'N':  case 'O':
		case 'P':  case 'Q':  case 'R':  case 'S':
		case 'T':  case 'U':  case 'V':  case 'W':
		case 'X':  case 'Y':  case 'Z':  case '[':
		case '\\':  case ']':  case '^':  case '_':
		case '`':  case 'a':  case 'b':  case 'c':
		case 'd':  case 'e':  case 'f':  case 'g':
		case 'h':  case 'i':  case 'j':  case 'k':
		case 'l':  case 'm':  case 'n':  case 'o':
		case 'p':  case 'q':  case 'r':  case 's':
		case 't':  case 'u':  case 'v':  case 'w':
		case 'x':  case 'y':  case 'z':  case '|':
		case '~':  case '\u00b4':  case '\u00c4':  case '\u00d6':
		case '\u00dc':  case '\u00df':  case '\u00e4':  case '\u00e9':
		case '\u00f3':  case '\u00f4':  case '\u00f6':  case '\u00fc':
		case '\u00fd':
		{
			mINNER_CHAR(false);
			break;
		}
		case ',':
		{
			match(',');
			break;
		}
		case '#':
		{
			match('#');
			break;
		}
		case '"':
		{
			match('"');
			break;
		}
		case '(':
		{
			match('(');
			break;
		}
		case ')':
		{
			match(')');
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
	
	protected void mCONTENT(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = CONTENT;
		
		{ // ( ... )+
		int _cnt15=0;
		for (;;)
		{
			if ((tokenSet_0_.member(LA(1))))
			{
				mCONTENT_CHAR(false);
			}
			else
			{
				if (_cnt15 >= 1) { goto _loop15_breakloop; } else { throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());; }
			}
			
			_cnt15++;
		}
_loop15_breakloop:		;
		}    // ( ... )+
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	protected void mSTRINGVALUEINNER(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = STRINGVALUEINNER;
		
		{    // ( ... )*
			for (;;)
			{
				if ((tokenSet_1_.member(LA(1))))
				{
					mINNER_CHAR(false);
				}
				else
				{
					goto _loop18_breakloop;
				}
				
			}
_loop18_breakloop:			;
		}    // ( ... )*
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	protected void mSTRINGVALUEINNER2(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = STRINGVALUEINNER2;
		
		switch ( LA(1) )
		{
		case '\t':  case '\n':  case '\r':  case ' ':
		case '!':  case '#':  case '$':  case '&':
		case '\'':  case '(':  case ')':  case '*':
		case '+':  case ',':  case '-':  case '.':
		case '/':  case '0':  case '1':  case '2':
		case '3':  case '4':  case '5':  case '6':
		case '7':  case '8':  case '9':  case ':':
		case ';':  case '<':  case '=':  case '>':
		case '?':  case 'A':  case 'B':  case 'C':
		case 'D':  case 'E':  case 'F':  case 'G':
		case 'H':  case 'I':  case 'J':  case 'K':
		case 'L':  case 'M':  case 'N':  case 'O':
		case 'P':  case 'Q':  case 'R':  case 'S':
		case 'T':  case 'U':  case 'V':  case 'W':
		case 'X':  case 'Y':  case 'Z':  case '[':
		case '\\':  case ']':  case '^':  case '_':
		case '`':  case 'a':  case 'b':  case 'c':
		case 'd':  case 'e':  case 'f':  case 'g':
		case 'h':  case 'i':  case 'j':  case 'k':
		case 'l':  case 'm':  case 'n':  case 'o':
		case 'p':  case 'q':  case 'r':  case 's':
		case 't':  case 'u':  case 'v':  case 'w':
		case 'x':  case 'y':  case 'z':  case '{':
		case '|':  case '~':  case '\u00b4':  case '\u00c4':
		case '\u00d6':  case '\u00dc':  case '\u00df':  case '\u00e4':
		case '\u00e9':  case '\u00f3':  case '\u00f4':  case '\u00f6':
		case '\u00fc':  case '\u00fd':
		{
			{ // ( ... )+
			int _cnt22=0;
			for (;;)
			{
				switch ( LA(1) )
				{
				case '\t':  case '\n':  case '\r':  case ' ':
				case '!':  case '#':  case '$':  case '&':
				case '\'':  case '(':  case ')':  case '*':
				case '+':  case ',':  case '-':  case '.':
				case '/':  case '0':  case '1':  case '2':
				case '3':  case '4':  case '5':  case '6':
				case '7':  case '8':  case '9':  case ':':
				case ';':  case '<':  case '=':  case '>':
				case '?':  case 'A':  case 'B':  case 'C':
				case 'D':  case 'E':  case 'F':  case 'G':
				case 'H':  case 'I':  case 'J':  case 'K':
				case 'L':  case 'M':  case 'N':  case 'O':
				case 'P':  case 'Q':  case 'R':  case 'S':
				case 'T':  case 'U':  case 'V':  case 'W':
				case 'X':  case 'Y':  case 'Z':  case '[':
				case '\\':  case ']':  case '^':  case '_':
				case '`':  case 'a':  case 'b':  case 'c':
				case 'd':  case 'e':  case 'f':  case 'g':
				case 'h':  case 'i':  case 'j':  case 'k':
				case 'l':  case 'm':  case 'n':  case 'o':
				case 'p':  case 'q':  case 'r':  case 's':
				case 't':  case 'u':  case 'v':  case 'w':
				case 'x':  case 'y':  case 'z':  case '|':
				case '~':  case '\u00b4':  case '\u00c4':  case '\u00d6':
				case '\u00dc':  case '\u00df':  case '\u00e4':  case '\u00e9':
				case '\u00f3':  case '\u00f4':  case '\u00f6':  case '\u00fc':
				case '\u00fd':
				{
					mINNER_CHAR2(false);
					break;
				}
				case '{':
				{
					{
						mOPENBRACE(false);
						mSTRINGVALUEINNER3(false);
						mCLOSEBRACE(false);
					}
					break;
				}
				default:
				{
					if (_cnt22 >= 1) { goto _loop22_breakloop; } else { throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());; }
				}
				break; }
				_cnt22++;
			}
_loop22_breakloop:			;
			}    // ( ... )+
			break;
		}
		case '"':
		{
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
	
	protected void mSTRINGVALUEINNER3(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = STRINGVALUEINNER3;
		
		switch ( LA(1) )
		{
		case '\t':  case '\n':  case '\r':  case ' ':
		case '!':  case '"':  case '#':  case '$':
		case '&':  case '\'':  case '(':  case ')':
		case '*':  case '+':  case ',':  case '-':
		case '.':  case '/':  case '0':  case '1':
		case '2':  case '3':  case '4':  case '5':
		case '6':  case '7':  case '8':  case '9':
		case ':':  case ';':  case '<':  case '=':
		case '>':  case '?':  case 'A':  case 'B':
		case 'C':  case 'D':  case 'E':  case 'F':
		case 'G':  case 'H':  case 'I':  case 'J':
		case 'K':  case 'L':  case 'M':  case 'N':
		case 'O':  case 'P':  case 'Q':  case 'R':
		case 'S':  case 'T':  case 'U':  case 'V':
		case 'W':  case 'X':  case 'Y':  case 'Z':
		case '[':  case '\\':  case ']':  case '^':
		case '_':  case '`':  case 'a':  case 'b':
		case 'c':  case 'd':  case 'e':  case 'f':
		case 'g':  case 'h':  case 'i':  case 'j':
		case 'k':  case 'l':  case 'm':  case 'n':
		case 'o':  case 'p':  case 'q':  case 'r':
		case 's':  case 't':  case 'u':  case 'v':
		case 'w':  case 'x':  case 'y':  case 'z':
		case '{':  case '|':  case '~':  case '\u00b4':
		case '\u00c4':  case '\u00d6':  case '\u00dc':  case '\u00df':
		case '\u00e4':  case '\u00e9':  case '\u00f3':  case '\u00f4':
		case '\u00f6':  case '\u00fc':  case '\u00fd':
		{
			{ // ( ... )+
			int _cnt26=0;
			for (;;)
			{
				switch ( LA(1) )
				{
				case '\t':  case '\n':  case '\r':  case ' ':
				case '!':  case '"':  case '#':  case '$':
				case '&':  case '\'':  case '(':  case ')':
				case '*':  case '+':  case ',':  case '-':
				case '.':  case '/':  case '0':  case '1':
				case '2':  case '3':  case '4':  case '5':
				case '6':  case '7':  case '8':  case '9':
				case ':':  case ';':  case '<':  case '=':
				case '>':  case '?':  case 'A':  case 'B':
				case 'C':  case 'D':  case 'E':  case 'F':
				case 'G':  case 'H':  case 'I':  case 'J':
				case 'K':  case 'L':  case 'M':  case 'N':
				case 'O':  case 'P':  case 'Q':  case 'R':
				case 'S':  case 'T':  case 'U':  case 'V':
				case 'W':  case 'X':  case 'Y':  case 'Z':
				case '[':  case '\\':  case ']':  case '^':
				case '_':  case '`':  case 'a':  case 'b':
				case 'c':  case 'd':  case 'e':  case 'f':
				case 'g':  case 'h':  case 'i':  case 'j':
				case 'k':  case 'l':  case 'm':  case 'n':
				case 'o':  case 'p':  case 'q':  case 'r':
				case 's':  case 't':  case 'u':  case 'v':
				case 'w':  case 'x':  case 'y':  case 'z':
				case '|':  case '~':  case '\u00b4':  case '\u00c4':
				case '\u00d6':  case '\u00dc':  case '\u00df':  case '\u00e4':
				case '\u00e9':  case '\u00f3':  case '\u00f4':  case '\u00f6':
				case '\u00fc':  case '\u00fd':
				{
					mINNER_CHAR3(false);
					break;
				}
				case '{':
				{
					{
						mOPENBRACE(false);
						mSTRINGVALUEINNER3(false);
						mCLOSEBRACE(false);
					}
					break;
				}
				default:
				{
					if (_cnt26 >= 1) { goto _loop26_breakloop; } else { throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());; }
				}
				break; }
				_cnt26++;
			}
_loop26_breakloop:			;
			}    // ( ... )+
			break;
		}
		case '}':
		{
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
	
	public void mUNQUOTED_STRINGVALUE(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = UNQUOTED_STRINGVALUE;
		
		mCONTENT_CHAR(false);
		mSTRINGVALUEINNER(false);
		MyParser.selector.pop();
		if (text.ToString(_begin, text.Length-_begin) == "")
		{
				   if (LexerLogEvent != null)
				      LexerLogEvent(this,new LogEventArgs(LogType.WARNING,"Found empty string value at "+getLine()+":"+getColumn()));
		}
		
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mQUOTED_STRINGVALUE(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = QUOTED_STRINGVALUE;
		
		int _saveIndex = 0;
		_saveIndex = text.Length;
		mQUOTES(false);
		text.Length = _saveIndex;
		mSTRINGVALUEINNER2(false);
		_saveIndex = text.Length;
		mQUOTES(false);
		text.Length = _saveIndex;
		MyParser.selector.pop();
		if (text.ToString(_begin, text.Length-_begin) == "")
		{
				   if (LexerLogEvent != null)
				      LexerLogEvent(this,new LogEventArgs(LogType.WARNING,"Found empty string value at "+getLine()+":"+getColumn()));
		}
		
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mBRACED_STRINGVALUE(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = BRACED_STRINGVALUE;
		
		int _saveIndex = 0;
		_saveIndex = text.Length;
		mOPENBRACE(false);
		text.Length = _saveIndex;
		mSTRINGVALUEINNER3(false);
		_saveIndex = text.Length;
		mCLOSEBRACE(false);
		text.Length = _saveIndex;
		MyParser.selector.pop();
		if (text.ToString(_begin, text.Length-_begin) == "")
		{
				   if (LexerLogEvent != null)
				      LexerLogEvent(this,new LogEventArgs(LogType.WARNING,"Found empty string value at "+getLine()+":"+getColumn()));
		}
		
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mWS_BEFORE_STRING_VALUE(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = WS_BEFORE_STRING_VALUE;
		
		{ // ( ... )+
		int _cnt32=0;
		for (;;)
		{
			switch ( LA(1) )
			{
			case '\t':  case '\r':  case ' ':
			{
				mWS_TOKEN(false);
				break;
			}
			case '\n':
			{
				mNEWLINE(false);
				break;
			}
			default:
			{
				if (_cnt32 >= 1) { goto _loop32_breakloop; } else { throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());; }
			}
			break; }
			_cnt32++;
		}
_loop32_breakloop:		;
		}    // ( ... )+
		_ttype = Token.SKIP;
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	protected void mSPECIALS1(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = SPECIALS1;
		
		switch ( LA(1) )
		{
		case '-':
		{
			match('-');
			break;
		}
		case '/':
		{
			match('/');
			break;
		}
		case ':':
		{
			match(':');
			break;
		}
		case '\t':  case '\r':  case ' ':
		{
			mWS_TOKEN(false);
			break;
		}
		case '\n':
		{
			mNEWLINE(false);
			break;
		}
		case '\'':
		{
			match('\'');
			break;
		}
		case '\u00b4':
		{
			match('´');
			break;
		}
		case '`':
		{
			match('`');
			break;
		}
		case '^':
		{
			match('^');
			break;
		}
		case '$':
		{
			match('$');
			break;
		}
		case '.':
		{
			match('.');
			break;
		}
		case ';':
		{
			match(';');
			break;
		}
		case '+':
		{
			match('+');
			break;
		}
		case '~':
		{
			match('~');
			break;
		}
		case '*':
		{
			match('*');
			break;
		}
		case '?':
		{
			match('?');
			break;
		}
		case '=':
		{
			match('=');
			break;
		}
		case '!':
		{
			match('!');
			break;
		}
		case '<':
		{
			match('<');
			break;
		}
		case '>':
		{
			match('>');
			break;
		}
		case '|':
		{
			match('|');
			break;
		}
		case '[':
		{
			match('[');
			break;
		}
		case ']':
		{
			match(']');
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
	
	protected void mSPECIALS2(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = SPECIALS2;
		
		{
			switch ( LA(1) )
			{
			case '\u00f3':
			{
				match('ó');
				break;
			}
			case '\u00f4':
			{
				match('ô');
				break;
			}
			case '\u00fd':
			{
				match('ý');
				break;
			}
			case '\u00e9':
			{
				match('é');
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			 }
		}
		
				         if (LexerLogEvent != null)
				            LexerLogEvent(this,new LogEventArgs(LogType.ERROR,
					       "Found non-latex compliant character "+text.ToString(_begin, text.Length-_begin)+" at "+getLine()+":"+getColumn()+". Input discarded by lexer!"));
					 text.Length = _begin; text.Append("");
					
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	protected void mSPECIALS3(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = SPECIALS3;
		
		switch ( LA(1) )
		{
		case '_':
		{
			{
				match('_');
				
						        if (LexerLogEvent != null)
						            LexerLogEvent(this,new LogEventArgs(LogType.WARNING,
							       "Found non-latex compliant character "+text.ToString(_begin, text.Length-_begin)+" at "+getLine()+":"+getColumn()+". Please check if input is correct!"));
							
			}
			break;
		}
		case '&':  case '\u00c4':  case '\u00d6':  case '\u00dc':
		case '\u00df':  case '\u00e4':  case '\u00f6':  case '\u00fc':
		{
			{
				switch ( LA(1) )
				{
				case '&':
				{
					match('&');
					text.Length = _begin; text.Append("{\\&}");
					break;
				}
				case '\u00e4':
				{
					match('ä');
					text.Length = _begin; text.Append("{\\\"a}");
					break;
				}
				case '\u00f6':
				{
					match('ö');
					text.Length = _begin; text.Append("{\\\"o}");
					break;
				}
				case '\u00fc':
				{
					match('ü');
					text.Length = _begin; text.Append("{\\\"u}");
					break;
				}
				case '\u00c4':
				{
					match('Ä');
					text.Length = _begin; text.Append("{\\\"A}");
					break;
				}
				case '\u00d6':
				{
					match('Ö');
					text.Length = _begin; text.Append("{\\\"O}");
					break;
				}
				case '\u00dc':
				{
					match('Ü');
					text.Length = _begin; text.Append("{\\\"U}");
					break;
				}
				case '\u00df':
				{
					match('ß');
					text.Length = _begin; text.Append("{\\ss}");
					break;
				}
				default:
				{
					throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
				}
				 }
			}
			
					        if (LexerLogEvent != null)
					            LexerLogEvent(this,new LogEventArgs(LogType.WARNING,
						       "Found non-latex compliant character "+text.ToString(_begin, text.Length-_begin)+" at "+getLine()+":"+getColumn()+". Character replaced by lexer!"));
						
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
	
	
	private static long[] mk_tokenSet_0_()
	{
		long[] data = { 287948901175001088L, 576460744116142078L, 0L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_0_ = new BitSet(mk_tokenSet_0_());
	private static long[] mk_tokenSet_1_()
	{
		long[] data = new long[8];
		data[0]=-21083994446336L;
		data[1]=6341068275337658366L;
		data[2]=4503599627370496L;
		data[3]=3483536581933924368L;
		for (int i = 4; i<=7; i++) { data[i]=0L; }
		return data;
	}
	public static readonly BitSet tokenSet_1_ = new BitSet(mk_tokenSet_1_());
	
}
}

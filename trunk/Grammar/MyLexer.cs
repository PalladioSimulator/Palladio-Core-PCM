// $ANTLR 2.7.3: "bibtex.g" -> "MyLexer.cs"$

    // gets inserted in the C# source file before any
    // generated namespace declarations
    // hence -- can only be using directives
    using System.Collections;
    using System.IO;
    using BibTeX.Parser.Types;
    using BibTeX.Parser.Exceptions;
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

	internal 	class MyLexer : antlr.CharScanner	, TokenStream
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
		public const int ENTRY_COMMENT = 36;
		public const int ENTRY_MACRO = 37;
		public const int ENTRY_PREAMBLE = 38;
		public const int ENTRY_REGULAR = 39;
		public const int TOP_JUNK = 40;
		
		
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
		public MyLexer(Stream ins) : this(new ByteBuffer(ins))
		{
		}
		
		public MyLexer(TextReader r) : this(new CharBuffer(r))
		{
		}
		
		public MyLexer(InputBuffer ib)		 : this(new LexerSharedInputState(ib))
		{
		}
		
		public MyLexer(LexerSharedInputState state) : base(state)
		{
			initialize();
		}
		private void initialize()
		{
			caseSensitiveLiterals = true;
			setCaseSensitive(false);
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
						if ((LA(1)=='@') && (LA(2)=='p') && (LA(3)=='r') && (LA(4)=='e') && (LA(5)=='a'))
						{
							mENTRY_PREAMBLE(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='@') && (tokenSet_0_.member(LA(2))) && (tokenSet_1_.member(LA(3))) && (tokenSet_2_.member(LA(4))) && (tokenSet_3_.member(LA(5)))) {
							mENTRY_REGULAR(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='@') && (LA(2)=='c') && (LA(3)=='o') && (LA(4)=='m')) {
							mENTRY_COMMENT(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='@') && (LA(2)=='s')) {
							mENTRY_MACRO(true);
							theRetToken = returnToken_;
						}
						else if ((LA(1)=='%')) {
							mCOMMENT(true);
							theRetToken = returnToken_;
						}
						else if ((tokenSet_4_.member(LA(1)))) {
							mWS(true);
							theRetToken = returnToken_;
						}
						else
						{
							if (LA(1)==EOF_CHAR) { uponEOF(); returnToken_ = makeToken(Token.EOF_TYPE); }
				else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
						}
						
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
		
	public void mENTRY_COMMENT(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = ENTRY_COMMENT;
		
		int _saveIndex = 0;
		_saveIndex = text.Length;
		match("@comment");
		text.Length = _saveIndex;
		{    // ( ... )*
			for (;;)
			{
				if ((LA(1)=='\t'||LA(1)=='\r'||LA(1)==' '))
				{
					_saveIndex = text.Length;
					mWS_TOKEN(false);
					text.Length = _saveIndex;
				}
				else
				{
					goto _loop14_breakloop;
				}
				
			}
_loop14_breakloop:			;
		}    // ( ... )*
		{
			match(tokenSet_5_);
		}
		{    // ( ... )*
			for (;;)
			{
				if ((tokenSet_6_.member(LA(1))))
				{
					matchNot('\n');
				}
				else
				{
					goto _loop17_breakloop;
				}
				
			}
_loop17_breakloop:			;
		}    // ( ... )*
		_saveIndex = text.Length;
		match('\n');
		text.Length = _saveIndex;
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
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mENTRY_MACRO(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = ENTRY_MACRO;
		
		int _saveIndex = 0;
		_saveIndex = text.Length;
		match("@string");
		text.Length = _saveIndex;
		MyParser.selector.push("entrylexer");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mENTRY_PREAMBLE(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = ENTRY_PREAMBLE;
		
		int _saveIndex = 0;
		_saveIndex = text.Length;
		match("@preamble");
		text.Length = _saveIndex;
		MyParser.selector.push("entrylexer");
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	public void mENTRY_REGULAR(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = ENTRY_REGULAR;
		
		int _saveIndex = 0;
		_saveIndex = text.Length;
		match('@');
		text.Length = _saveIndex;
		{
			switch ( LA(1) )
			{
			case 'a':
			{
				match("article");
				break;
			}
			case 'u':
			{
				match("unpublished");
				break;
			}
			case 'j':
			{
				match("journal");
				break;
			}
			case 'c':
			{
				match("conference");
				break;
			}
			default:
				if ((LA(1)=='b') && (LA(2)=='o') && (LA(3)=='o') && (LA(4)=='k') && (LA(5)=='l'))
				{
					match("booklet");
				}
				else if ((LA(1)=='b') && (LA(2)=='o') && (LA(3)=='o') && (LA(4)=='k') && (true)) {
					match("book");
				}
				else if ((LA(1)=='i') && (LA(2)=='n') && (LA(3)=='p')) {
					match("inproceedings");
				}
				else if ((LA(1)=='m') && (LA(2)=='a') && (LA(3)=='s')) {
					match("mastersthesis");
				}
				else if ((LA(1)=='i') && (LA(2)=='n') && (LA(3)=='c')) {
					match("incollection");
				}
				else if ((LA(1)=='i') && (LA(2)=='n') && (LA(3)=='b')) {
					match("inbook");
				}
				else if ((LA(1)=='m') && (LA(2)=='a') && (LA(3)=='n')) {
					match("manual");
				}
				else if ((LA(1)=='m') && (LA(2)=='i')) {
					match("misc");
				}
				else if ((LA(1)=='t') && (LA(2)=='h')) {
					match("thesis");
				}
				else if ((LA(1)=='p') && (LA(2)=='h')) {
					match("phdthesis");
				}
				else if ((LA(1)=='p') && (LA(2)=='r')) {
					match("proceedings");
				}
				else if ((LA(1)=='t') && (LA(2)=='e')) {
					match("techreport");
				}
			else
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			break; }
		}
		MyParser.selector.push("entrylexer");
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
				if ((tokenSet_6_.member(LA(1))))
				{
					matchNot('\n');
				}
				else
				{
					goto _loop24_breakloop;
				}
				
			}
_loop24_breakloop:			;
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
	
	protected void mTOP_JUNK(bool _createToken) //throws RecognitionException, CharStreamException, TokenStreamException
{
		int _ttype; Token _token=null; int _begin=text.Length;
		_ttype = TOP_JUNK;
		
		{ // ( ... )+
		int _cnt31=0;
		for (;;)
		{
			if ((tokenSet_7_.member(LA(1))))
			{
				{
					match(tokenSet_7_);
				}
			}
			else
			{
				if (_cnt31 >= 1) { goto _loop31_breakloop; } else { throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());; }
			}
			
			_cnt31++;
		}
_loop31_breakloop:		;
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
				{ // ( ... )+
				int _cnt35=0;
				for (;;)
				{
					if ((LA(1)=='\t'||LA(1)=='\r'||LA(1)==' '))
					{
						mWS_TOKEN(false);
					}
					else
					{
						if (_cnt35 >= 1) { goto _loop35_breakloop; } else { throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());; }
					}
					
					_cnt35++;
				}
_loop35_breakloop:				;
				}    // ( ... )+
				break;
			}
			default:
				if ((tokenSet_7_.member(LA(1))))
				{
					mTOP_JUNK(false);
				}
			else
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			break; }
		}
		_ttype = Token.SKIP;
		if (_createToken && (null == _token) && (_ttype != Token.SKIP))
		{
			_token = makeToken(_ttype);
			_token.setText(text.ToString(_begin, text.Length-_begin));
		}
		returnToken_ = _token;
	}
	
	
	private static long[] mk_tokenSet_0_()
	{
		long[] data = new long[1025];
		data[0]=0L;
		data[1]=13834115430219776L;
		for (int i = 2; i<=1024; i++) { data[i]=0L; }
		return data;
	}
	public static readonly BitSet tokenSet_0_ = new BitSet(mk_tokenSet_0_());
	private static long[] mk_tokenSet_1_()
	{
		long[] data = new long[1025];
		data[0]=0L;
		data[1]=1340450703147008L;
		for (int i = 2; i<=1024; i++) { data[i]=0L; }
		return data;
	}
	public static readonly BitSet tokenSet_1_ = new BitSet(mk_tokenSet_1_());
	private static long[] mk_tokenSet_2_()
	{
		long[] data = new long[1025];
		data[0]=0L;
		data[1]=16255437603078144L;
		for (int i = 2; i<=1024; i++) { data[i]=0L; }
		return data;
	}
	public static readonly BitSet tokenSet_2_ = new BitSet(mk_tokenSet_2_());
	private static long[] mk_tokenSet_3_()
	{
		long[] data = new long[1025];
		data[0]=0L;
		data[1]=17041639956545536L;
		for (int i = 2; i<=1024; i++) { data[i]=0L; }
		return data;
	}
	public static readonly BitSet tokenSet_3_ = new BitSet(mk_tokenSet_3_());
	private static long[] mk_tokenSet_4_()
	{
		long[] data = new long[2048];
		data[0]=-137438953473L;
		data[1]=-2L;
		for (int i = 2; i<=1022; i++) { data[i]=-1L; }
		data[1023]=9223372036854775807L;
		for (int i = 1024; i<=2047; i++) { data[i]=0L; }
		return data;
	}
	public static readonly BitSet tokenSet_4_ = new BitSet(mk_tokenSet_4_());
	private static long[] mk_tokenSet_5_()
	{
		long[] data = new long[2048];
		data[0]=-4294976001L;
		for (int i = 1; i<=1022; i++) { data[i]=-1L; }
		data[1023]=9223372036854775807L;
		for (int i = 1024; i<=2047; i++) { data[i]=0L; }
		return data;
	}
	public static readonly BitSet tokenSet_5_ = new BitSet(mk_tokenSet_5_());
	private static long[] mk_tokenSet_6_()
	{
		long[] data = new long[2048];
		data[0]=-1025L;
		for (int i = 1; i<=1022; i++) { data[i]=-1L; }
		data[1023]=9223372036854775807L;
		for (int i = 1024; i<=2047; i++) { data[i]=0L; }
		return data;
	}
	public static readonly BitSet tokenSet_6_ = new BitSet(mk_tokenSet_6_());
	private static long[] mk_tokenSet_7_()
	{
		long[] data = new long[2048];
		data[0]=-141733930497L;
		data[1]=-2L;
		for (int i = 2; i<=1022; i++) { data[i]=-1L; }
		data[1023]=9223372036854775807L;
		for (int i = 1024; i<=2047; i++) { data[i]=0L; }
		return data;
	}
	public static readonly BitSet tokenSet_7_ = new BitSet(mk_tokenSet_7_());
	
}
}

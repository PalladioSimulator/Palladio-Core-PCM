// $ANTLR 2.7.3: "bibtex.g" -> "MyParser.cs"$

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
	// Generate the header common to all output files.
	using System;
	
	using TokenBuffer              = antlr.TokenBuffer;
	using TokenStreamException     = antlr.TokenStreamException;
	using TokenStreamIOException   = antlr.TokenStreamIOException;
	using ANTLRException           = antlr.ANTLRException;
	using LLkParser = antlr.LLkParser;
	using Token                    = antlr.Token;
	using TokenStream              = antlr.TokenStream;
	using RecognitionException     = antlr.RecognitionException;
	using NoViableAltException     = antlr.NoViableAltException;
	using MismatchedTokenException = antlr.MismatchedTokenException;
	using SemanticException        = antlr.SemanticException;
	using ParserSharedInputState   = antlr.ParserSharedInputState;
	using BitSet                   = antlr.collections.impl.BitSet;
	
   //  global code stuff that will be included in the source file just before the 'MyParser' class below

	internal 	class MyParser : antlr.LLkParser
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
		
		
   /// TokenStream Selector used during parsing
   public static TokenStreamSelector selector = new TokenStreamSelector();
   
   public void MyInitialize(TextReader inputStream, string streamID)
   {
	MyLexer lexer = new MyLexer(inputStream);
	lexer.setFilename(streamID);
	lexer.LexerLogEvent += new LogEventHandler(this.LexerLogEventHandler);
	selector.addInputStream(lexer,"lexer");
	MyEntryLexer lexer2 = new MyEntryLexer(lexer.getInputState());
	selector.addInputStream(lexer2,"entrylexer");
	lexer2.LexerLogEvent += new LogEventHandler(this.LexerLogEventHandler);
	MyValueLexer lexer3 = new MyValueLexer(lexer.getInputState());
	selector.addInputStream(lexer3,"valuelexer");
	lexer3.LexerLogEvent += new LogEventHandler(this.LexerLogEventHandler);
	selector.push("lexer");
   }
   
   public event LogEventHandler ParserLogEvent;
   
   public override void reportError(string message)
   {
	base.reportError(message);
	if (ParserLogEvent != null)
		ParserLogEvent(this,new LogEventArgs(LogType.ERROR,message));
   }

   public override void reportError(RecognitionException ex)
   {
	base.reportError(ex);
	if (ParserLogEvent != null)
		ParserLogEvent(this,new LogEventArgs(LogType.ERROR,ex.Message));
   }
   
   public void LexerLogEventHandler(object sender, LogEventArgs args)
   {
	if (ParserLogEvent != null)
		ParserLogEvent(sender,args);
   }
   
   public MyParser() : this(selector,1)
   {
   }
		
		protected void initialize()
		{
			tokenNames = tokenNames_;
		}
		
		
		protected MyParser(TokenBuffer tokenBuf, int k) : base(tokenBuf, k)
		{
			initialize();
		}
		
		public MyParser(TokenBuffer tokenBuf) : this(tokenBuf,1)
		{
		}
		
		protected MyParser(TokenStream lexer, int k) : base(lexer,k)
		{
			initialize();
		}
		
		public MyParser(TokenStream lexer) : this(lexer,1)
		{
		}
		
		public MyParser(ParserSharedInputState state) : base(state,1)
		{
			initialize();
		}
		
	public IBibTeXFile  bibfile() //throws RecognitionException, TokenStreamException
{
		IBibTeXFile file;
		
		
		ArrayList entries = new ArrayList();
		file = null;
		
		
		try {      // for error handling
			IEntry e;
			{    // ( ... )*
				for (;;)
				{
					if (((LA(1) >= ENTRY_COMMENT && LA(1) <= ENTRY_REGULAR)))
					{
						e=entry();
						entries.Add(e);
					}
					else
					{
						goto _loop3_breakloop;
					}
					
				}
_loop3_breakloop:				;
			}    // ( ... )*
			file = new Bibfile(entries);
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_0_);
		}
		return file;
	}
	
	public IEntry  entry() //throws RecognitionException, TokenStreamException
{
		IEntry entry;
		
		Token  comment = null;
		Token  preamble = null;
		Token  macro = null;
		Token  t = null;
		Token  label = null;
		IStringValue[] s;
		entry = null;
		IFieldArray macros = null;	
		IFieldArray fieldArray = null;
		
		
		try {      // for error handling
			switch ( LA(1) )
			{
			case ENTRY_COMMENT:
			{
				comment = LT(1);
				match(ENTRY_COMMENT);
				entry = new EntryComment(comment.getText()); entry.SortOrder = comment.getLine();
				break;
			}
			case ENTRY_PREAMBLE:
			{
				preamble = LT(1);
				match(ENTRY_PREAMBLE);
				match(ENTRY_OPEN);
				MyParser.selector.push("valuelexer");
				s=field_value();
				match(ENTRY_CLOSE);
				entry = new EntryPreamble(s); entry.SortOrder = preamble.getLine();
				break;
			}
			case ENTRY_MACRO:
			{
				macro = LT(1);
				match(ENTRY_MACRO);
				match(ENTRY_OPEN);
				macros=fields();
				match(ENTRY_CLOSE);
				entry = new EntryMacro(macros); entry.SortOrder = macro.getLine();
				break;
			}
			case ENTRY_REGULAR:
			{
				t = LT(1);
				match(ENTRY_REGULAR);
				match(ENTRY_OPEN);
				label = LT(1);
				match(ID);
				match(COMMA);
				fieldArray=fields();
				match(ENTRY_CLOSE);
				entry = new EntryRegular(t.getText(),label.getText(),fieldArray); entry.SortOrder = t.getLine();
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_1_);
		}
		return entry;
	}
	
	public IStringValue[]  field_value() //throws RecognitionException, TokenStreamException
{
		IStringValue[] val;
		
		ArrayList values = new ArrayList();
		Stringvalue v;
		val = null;
		
		
		try {      // for error handling
			v=simple_value();
			values.Add(v);
			{    // ( ... )*
				for (;;)
				{
					if ((LA(1)==HASH))
					{
						match(HASH);
						v=simple_value();
						values.Add(v);
					}
					else
					{
						goto _loop10_breakloop;
					}
					
				}
_loop10_breakloop:				;
			}    // ( ... )*
			
			val = (IStringValue[])values.ToArray(Type.GetType("BibTeX.Parser.Interfaces.IStringValue",true));
			
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_2_);
		}
		return val;
	}
	
	public IFieldArray  fields() //throws RecognitionException, TokenStreamException
{
		IFieldArray fieldList;
		
		IField f = null;
		fieldList = null;
		
		
		try {      // for error handling
			f=field();
			{
				switch ( LA(1) )
				{
				case COMMA:
				{
					match(COMMA);
					fieldList=fields();
					break;
				}
				case ENTRY_CLOSE:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				 }
			}
			
			if (fieldList == null)
			{
				fieldList = new FieldArray();
			}
			if (f != null)
			{
				if (!fieldList.HasField(f.ID))
					fieldList.AddField(f);
				else
					throw new BibTeXParserException("Duplicate field ID >"+f.ID+"< in an entry somewhere around line " + LT(1).getLine());
			}
			
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_3_);
		}
		return fieldList;
	}
	
	public IField  field() //throws RecognitionException, TokenStreamException
{
		IField f;
		
		Token  n = null;
		IStringValue[] v;
		f=null;
		
		try {      // for error handling
			if (((LA(1)==ID))&&(LA(1) == ID))
			{
				n = LT(1);
				match(ID);
				match(EQUALS);
				v=field_value();
				f=new Field(n.getText(),v);
				
			}
			else if ((LA(1)==ENTRY_CLOSE||LA(1)==COMMA)) {
				f=null;
			}
			else
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_2_);
		}
		return f;
	}
	
	public Stringvalue  simple_value() //throws RecognitionException, TokenStreamException
{
		Stringvalue val;
		
		Token  v = null;
		Token  v2 = null;
		Token  v3 = null;
		val = null;
		
		try {      // for error handling
			switch ( LA(1) )
			{
			case QUOTED_STRINGVALUE:
			{
				v = LT(1);
				match(QUOTED_STRINGVALUE);
				val = new Stringvalue(v.getText(),StringValueType.QUOTED);
				break;
			}
			case UNQUOTED_STRINGVALUE:
			{
				v2 = LT(1);
				match(UNQUOTED_STRINGVALUE);
				val = new Stringvalue(v2.getText(),StringValueType.UNQUOTED);
				break;
			}
			case BRACED_STRINGVALUE:
			{
				v3 = LT(1);
				match(BRACED_STRINGVALUE);
				val = new Stringvalue(v3.getText(),StringValueType.BRACED);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		catch (RecognitionException ex)
		{
			reportError(ex);
			consume();
			consumeUntil(tokenSet_4_);
		}
		return val;
	}
	
	private void initializeFactory()
	{
	}
	
	public static readonly string[] tokenNames_ = new string[] {
		@"""<0>""",
		@"""EOF""",
		@"""<2>""",
		@"""NULL_TREE_LOOKAHEAD""",
		@"""OPENBRACE""",
		@"""CLOSEBRACE""",
		@"""QUOTES""",
		@"""WS_TOKEN""",
		@"""NEWLINE""",
		@"""ESC""",
		@"""CONTENT_CHAR""",
		@"""INNER_CHAR""",
		@"""INNER_CHAR2""",
		@"""INNER_CHAR3""",
		@"""CONTENT""",
		@"""STRINGVALUEINNER""",
		@"""STRINGVALUEINNER2""",
		@"""STRINGVALUEINNER3""",
		@"""UNQUOTED_STRINGVALUE""",
		@"""QUOTED_STRINGVALUE""",
		@"""BRACED_STRINGVALUE""",
		@"""WS_BEFORE_STRING_VALUE""",
		@"""CHARS""",
		@"""DIGITS""",
		@"""SPECIALS""",
		@"""SPECIALS1""",
		@"""SPECIALS2""",
		@"""SPECIALS3""",
		@"""ENTRY_OPEN""",
		@"""ENTRY_CLOSE""",
		@"""EQUALS""",
		@"""HASH""",
		@"""COMMA""",
		@"""COMMENT""",
		@"""WS""",
		@"""ID""",
		@"""ENTRY_COMMENT""",
		@"""ENTRY_MACRO""",
		@"""ENTRY_PREAMBLE""",
		@"""ENTRY_REGULAR""",
		@"""TOP_JUNK"""
	};
	
	private static long[] mk_tokenSet_0_()
	{
		long[] data = { 2L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_0_ = new BitSet(mk_tokenSet_0_());
	private static long[] mk_tokenSet_1_()
	{
		long[] data = { 1030792151042L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_1_ = new BitSet(mk_tokenSet_1_());
	private static long[] mk_tokenSet_2_()
	{
		long[] data = { 4831838208L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_2_ = new BitSet(mk_tokenSet_2_());
	private static long[] mk_tokenSet_3_()
	{
		long[] data = { 536870912L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_3_ = new BitSet(mk_tokenSet_3_());
	private static long[] mk_tokenSet_4_()
	{
		long[] data = { 6979321856L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_4_ = new BitSet(mk_tokenSet_4_());
	
}
}

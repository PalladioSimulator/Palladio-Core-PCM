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
	public class MyEntryTokenTypes
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
		
	}
}

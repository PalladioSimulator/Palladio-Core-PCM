header 
{
    // gets inserted in the C# source file before any
    // generated namespace declarations
    // hence -- can only be using directives
    using System.Collections;
    using BibTeX.Parser.Types;
    using BibTeX.Parser.Interfaces;
    using antlr;
}

options {
    language  = "CSharp";
    namespace = "BibTeX.Parser.Grammar";  // encapsulate code in this namespace
}

{
   // global code stuff that will be included in the source file just before the 'MyLexer' class below
}
class MyEntryLexer extends Lexer;
options {
   importVocab=MyValue;
   exportVocab=MyEntry;
   classHeaderPrefix=internal;
}
{
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
}

ENTRY_OPEN:		'(' | '{';
ENTRY_CLOSE:		( ')' | '}' ) {MyParser.selector.pop();} ;
EQUALS:			'=' {MyParser.selector.push("valuelexer");} ;
HASH:			'#' {MyParser.selector.push("valuelexer");};
COMMA:			',';
COMMENT:		'%' (~'\n')* '\n' { $setType(Token.SKIP); newline(); };
protected NEWLINE:	'\n' { newline(); };
protected WS_TOKEN:	(' '|'\r'|'\t')+ ;
WS:			(NEWLINE | WS_TOKEN) { $setType(Token.SKIP); };

protected CHARS:		'a'..'z'|'A'..'Z' ;
protected DIGITS:		'0'..'9' ;
protected SPECIALS:		'_' | '-' | ':';
ID:			(CHARS | DIGITS | SPECIALS)+;

header 
{
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
class MyValueLexer extends Lexer;
options {
   exportVocab=MyValue;
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

protected OPENBRACE:		'{';
protected CLOSEBRACE:		'}';
protected QUOTES:		'\"';
protected WS_TOKEN:		(' '|'\r'|'\t') { $setText(" "); };
protected NEWLINE:		'\n' {newline();};
protected ESC:
	 '\\'
         ( '\\' | '{'  | '}' | '(' | ')' | '\"' | '&' | '-' | '_' | '$' | '@' |
           '\'' | ' ' | '`' | '´' | '^' | '~' | ',' | '!' | '=' | CHARS | DIGITS);
protected CONTENT_CHAR: CHARS | DIGITS | ESC;
protected INNER_CHAR:   CONTENT_CHAR | SPECIALS;
protected INNER_CHAR2:  INNER_CHAR | ',' | '#' | '(' | ')';
protected INNER_CHAR3:  INNER_CHAR | ',' | '#' | '"' | '(' | ')';
protected CONTENT:	(CONTENT_CHAR)+;
/* Content of an unqouted and unmarked string */
protected STRINGVALUEINNER: (INNER_CHAR)*;
/* Content of a quoted string */
protected STRINGVALUEINNER2:
		(INNER_CHAR2
		|(OPENBRACE STRINGVALUEINNER3 CLOSEBRACE))+
		| /**/;
/* Content of a braced string */
protected STRINGVALUEINNER3: 
		(INNER_CHAR3
		|(OPENBRACE STRINGVALUEINNER3 CLOSEBRACE))+
		| /**/;

UNQUOTED_STRINGVALUE: CONTENT_CHAR STRINGVALUEINNER
                {MyParser.selector.pop();
                if ($getText == "")
                {
		   if (LexerLogEvent != null)
		      LexerLogEvent(this,new LogEventArgs(LogType.WARNING,"Found empty string value at "+getLine()+":"+getColumn()));
                }
                } 
                ;

QUOTED_STRINGVALUE: QUOTES! STRINGVALUEINNER2 QUOTES! 
                {MyParser.selector.pop();
                if ($getText == "")
                {
		   if (LexerLogEvent != null)
		      LexerLogEvent(this,new LogEventArgs(LogType.WARNING,"Found empty string value at "+getLine()+":"+getColumn()));
                }
                } 
                ;

BRACED_STRINGVALUE: OPENBRACE! STRINGVALUEINNER3 CLOSEBRACE! 
                {MyParser.selector.pop();
                if ($getText == "")
                {
		   if (LexerLogEvent != null)
		      LexerLogEvent(this,new LogEventArgs(LogType.WARNING,"Found empty string value at "+getLine()+":"+getColumn()));
                }
                } 
                ;

WS_BEFORE_STRING_VALUE: (WS_TOKEN|NEWLINE)+ {$setType(Token.SKIP);};

/* Uncritical chars and digits -- All ASCII standard */		
protected CHARS:	'a'..'z' | 'A'..'Z';
protected DIGITS:	'0'..'9' ;

/* All types of special chars */
protected SPECIALS:	SPECIALS1 | SPECIALS2 | SPECIALS3;

/* Special chars of the kind TeX knows about */
protected SPECIALS1:	'-' | '/' | ':' | WS_TOKEN | NEWLINE | '\'' | '´' | '`' |
			'^' | '$' | '.' | ';' | '+' | '~' | '*' | '?' | '=' | '!' |
			'<' | '>' | '|' | '[' | ']';

/* Special chars of the kind TeX complains if not using extra packages */
protected SPECIALS2:    ('ó' | 'ô' | 'ý')
			{
    		         if (LexerLogEvent != null)
		            LexerLogEvent(this,new LogEventArgs(LogType.ERROR,
			       "Found non-latex compliant character "+$getText+" at "+getLine()+":"+getColumn()+". Input discarded by lexer!"));
			 $setText("");
			};

/* Special chars of the kind TeX complains if not using extra packages -- replaceable ones */
protected SPECIALS3:    ( '_' 
			{
    		        if (LexerLogEvent != null)
		            LexerLogEvent(this,new LogEventArgs(LogType.WARNING,
			       "Found non-latex compliant character "+$getText+" at "+getLine()+":"+getColumn()+". Please check if input is correct!"));
			}) |
			  ( '&' {$setText("{\\&}");} 
			  | 'ä' {$setText("{\\\"a}");}
			  | 'ö' {$setText("{\\\"o}");}
			  | 'ü' {$setText("{\\\"u}");}
			  | 'Ä' {$setText("{\\\"A}");} 
			  | 'Ö' {$setText("{\\\"O}");} 
			  | 'Ü' {$setText("{\\\"U}");}
			  | 'ß' {$setText("{\\ss}");})
			{
    		        if (LexerLogEvent != null)
		            LexerLogEvent(this,new LogEventArgs(LogType.WARNING,
			       "Found non-latex compliant character "+$getText+" at "+getLine()+":"+getColumn()+". Character replaced by lexer!"));
			};

header 
{
    // gets inserted in the C# source file before any
    // generated namespace declarations
    // hence -- can only be using directives
    using System.Collections;
    using System.IO;
    using BibTeX.Parser.Types;
    using BibTeX.Parser.Exceptions;
    using BibTeX.Parser.Interfaces;
    using antlr;
}

options {
    language  = "CSharp";
    namespace = "BibTeX.Parser.Grammar";  // encapsulate code in this namespace
}

{
   //  global code stuff that will be included in the source file just before the 'MyParser' class below
}
class MyParser extends Parser;
options {
   importVocab=MyValue;
   importVocab=MyEntry;
   importVocab=My;
   classHeaderPrefix=internal;
}
{
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
}

bibfile returns [IBibTeXFile file]
{
  ArrayList entries = new ArrayList();
  file = null;
}
: {IEntry e;}
  ( e=entry {entries.Add(e);} ) *
  {file = new Bibfile(entries);}
;

entry returns [IEntry entry]
{  IStringValue[] s;
   entry = null;
   IFieldArray macros = null;	
   IFieldArray fieldArray = null;
}
: 
	comment:ENTRY_COMMENT
	{ entry = new EntryComment(comment.getText()); entry.SortOrder = comment.getLine(); }
        | preamble:ENTRY_PREAMBLE ENTRY_OPEN  {MyParser.selector.push("valuelexer");} s=field_value ENTRY_CLOSE
        { entry = new EntryPreamble(s); entry.SortOrder = preamble.getLine(); }
        | macro:ENTRY_MACRO ENTRY_OPEN macros=fields ENTRY_CLOSE
        { entry = new EntryMacro(macros); entry.SortOrder = macro.getLine();}
        | t:ENTRY_REGULAR ENTRY_OPEN label:ID COMMA fieldArray=fields ENTRY_CLOSE
        { entry = new EntryRegular(t.getText(),label.getText(),fieldArray); entry.SortOrder = t.getLine(); }
;
   
fields returns [IFieldArray fieldList]
{ IField f = null;
  fieldList = null;
}
:
   f = field 
   ( COMMA fieldList = fields | )
   {
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
   ;
   
field returns [IField f]
{ IStringValue[] v;
  f=null; }
:
   {LA(1) == ID}?
   n:ID EQUALS v=field_value
   {f=new Field(n.getText(),v);
   }
   | {f=null;}
   ;
   
field_value returns [IStringValue[] val]
{  ArrayList values = new ArrayList();
   Stringvalue v;
   val = null;
}
:
   v=simple_value 
   {values.Add(v);}
   ( HASH v=simple_value {values.Add(v);})*
   {
   val = (IStringValue[])values.ToArray(Type.GetType("BibTeX.Parser.Interfaces.IStringValue",true));
   }
   ;
   
simple_value returns [Stringvalue val]
{  val = null; }
:
    v:QUOTED_STRINGVALUE 
    {val = new Stringvalue(v.getText(),StringValueType.QUOTED);}
   |v2:UNQUOTED_STRINGVALUE
    {val = new Stringvalue(v2.getText(),StringValueType.UNQUOTED);}
   |v3:BRACED_STRINGVALUE
    {val = new Stringvalue(v3.getText(),StringValueType.BRACED);}
   ;
   
{
   // global code stuff that will be included in the source file just before the 'MyLexer' class below
}
class MyLexer extends Lexer;
options {
   importVocab=MyEntry;
   exportVocab=My;
   charVocabulary='\u0000'..'\uFFFE';
   caseSensitive=false;
   k = 5;
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

ENTRY_COMMENT:		"@comment"! (WS_TOKEN!)* ~(' '|'\r'|'\t') (~'\n')* '\n'! {newline();};
ENTRY_MACRO:		"@string"! {MyParser.selector.push("entrylexer");};
ENTRY_PREAMBLE:		"@preamble"! {MyParser.selector.push("entrylexer");};
ENTRY_REGULAR:		'@'! ("misc" | "article" | "book" | "inproceedings" |
			"thesis" | "mastersthesis" | "phdthesis" | "incollection" |
			"unpublished" | "proceedings" | "booklet" | "journal" |
			"techreport" | "conference" | "inbook" | "manual") 
			{MyParser.selector.push("entrylexer");};
COMMENT:		'%' (~'\n')* '\n' { $setType(Token.SKIP); newline(); };
protected NEWLINE:	'\n' {newline();};
protected WS_TOKEN:	(' '|'\r'|'\t');
protected TOP_JUNK:	(~('%'|'@'|'\n'|' '|'\r'|'\t'))+ ;
WS:			( TOP_JUNK | NEWLINE | (WS_TOKEN)+ ) { $setType(Token.SKIP); } ;
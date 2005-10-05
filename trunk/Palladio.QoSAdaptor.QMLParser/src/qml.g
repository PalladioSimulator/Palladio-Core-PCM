
options {
	language = "CSharp";
	namespace = "QmlParser";
}

// P A R S E R

class QMLParser extends Parser;
options {
	exportVocab = QML;
	defaultErrorHandler = false;
	buildAST = true;
	k = 2;
}

tokens {
	DECLARATIONS;
	CONTRACT_TYPE_DECL;
	DIMENSION_DECL;
	INCREASING_ORDER_SEM;
	DECREASING_ORDER_SEM;
	ENUM_DEF;
	SET_DEF;
	NUMERIC_DEF;
	ORDER_DEF;
	ONE_ORDER;
	UNIT;
	
	CONTRACT_DECL;
	CONTRACT_EXP_CONTRACT;
	CONTRACT_EXP_REFINED_BY;
	SIMPLE_CONSTR;
	ASPECT_CONSTR;
	PERCENTILE_CONTR;
	FREQUENCY_CONTR;
	MEAN_CONTR;
	VARIANCE_CONTR;
	FREQ_RANGE;
	INCLUDE_BOUND;
	NOT_INCLUDE_BOUND;
	NAME_LIST;
	
	PROFILE_DECL;
	PROFILE_EXP_PROFILE;
	PROFILE_EXP_REFINED_BY;
	REQ_CLAUSE;
	CONTRACT_LIST;
	ENTITY_LIST;
	ENTITY;
	ENTITY_PARM;
	ENTITY_RESULT_OF;
			
	NUMOP_GTE;
	NUMOP_GTHAN;
	NUMOP_LTHAN;
	NUMOP_LTE;
	NUMOP_EQUAL;
	NAME;
	NUMBER;
}

declarations
			:	(declaration)*
				{	#declarations = #([DECLARATIONS, "declarations"], #declarations);	}
			;
			
declaration
			:	contrTypeDecl
			|	contrDecl
			|	profileDecl
			;
			
contrTypeDecl!
			:	type:"type" name:name ASSIGN contractType:contractType[#type, #name]
				{	#contrTypeDecl = #contractType;	}
			;
			
contractType[AST type, AST name]
			:	"contract"! LCURLY! (dimensionDecl)* RCURLY!
				{
					QmlParser.NodeHelper.CopyComments(type, name);
					#contractType = #([CONTRACT_TYPE_DECL, "contrTypeDecl"], #name, #contractType);	
				}
			;

dimensionDecl
			:	name COLON! dimensionType (unit)? SEMI!
				{
					#dimensionDecl = #([DIMENSION_DECL, "dimensionDecl"], #dimensionDecl);
				}
			;
			
dimensionType
			:	(enumDef) => enumDef
			|	(setDef) => setDef
			|	numeric
			;
			
orderSem!
			:	"increasing"
				{	
					#orderSem = #([INCREASING_ORDER_SEM, "increasing"]);	
				}
			|	"decreasing"
				{	
					#orderSem = #([DECREASING_ORDER_SEM, "decreasing"]);	
				}
			;
			
enumDef
			:	"enum"! LCURLY! nameList:nameList RCURLY!
				{
					#enumDef = #([ENUM_DEF, "enumDef"], #enumDef);
				}
			|	orderSem "enum"! LCURLY! nameList RCURLY! "with"! orderDef
				{
					#enumDef = #([ENUM_DEF, "enumDef"], #enumDef);
				}
			;
			
setDef
			:	"set"! LCURLY! nameList RCURLY!
				{
					#setDef = #([SET_DEF, "setDef"], #setDef);
				}
			|	orderSem "set"! LCURLY! nameList RCURLY! ("with"! orderDef)?
				{
					#setDef = #([SET_DEF, "setDef"], #setDef);
				}
			;	
			
orderDef
			:	"order"! LCURLY! (oneOrder (COMMA! oneOrder)*)? RCURLY!
				{
					#orderDef = #([ORDER_DEF, "orderDef"], #orderDef);
				}
			;

oneOrder
			:	name LTHAN! name
				{
					#oneOrder = #([ONE_ORDER, "oneOrder"], #oneOrder);
				}
			;

numeric
			:	orderSem "numeric"!
				{
					#numeric = #([NUMERIC_DEF, "numeric"], #numeric);
				}
			;
			
unit		:	name
				{
					#unit = #([UNIT, "unit"], #unit);
				}
			|	name DIV! name
				{
					#unit = #([UNIT, "unit"], #unit);
				}
			;
	
// -----------------------------------------------------------------------------	
				
contrDecl
			:	name ASSIGN! contrExp
				{
					#contrDecl = #([CONTRACT_DECL, "contrDecl"], #contrDecl);
				}
			;

contrExp
			:	name "contract"! LCURLY! (dimConstraint)* RCURLY!
				{
					#contrExp = #([CONTRACT_EXP_CONTRACT, "contrExp contract"], #contrExp);
				}
//			|	name "refined"! "by"! LCURLY! (dimConstraint)* RCURLY!
//				{
//					#contrExp = #([CONTRACT_EXP_REFINED_BY, "contrExp refined by"], #contrExp);
//				}
			;
	
dimConstraint
			:	simpleConstr SEMI!
			|	aspectConstr SEMI!
			;
				
simpleConstr
			:	name numOp valueLiteral (unit)?
				{
					#simpleConstr = #([SIMPLE_CONSTR, "simpleConstr"], #simpleConstr);
				}
			;	

valueLiteral
			:	number
			|	LCURLY! nameList RCURLY!
			|	name
			;
				
aspectConstr	
			:	name LCURLY! (statConstr)* RCURLY!
				{
					#aspectConstr = #([ASPECT_CONSTR, "aspectConstr"], #aspectConstr);
				}
			;
						
statConstr
			:	"percentile"! number numOp number SEMI!
				{	
					#statConstr= #([PERCENTILE_CONTR, "statConstr percentile"], #statConstr);
				}
			|	"frequency"! freqRange numOp number PERCENT! SEMI!
				{	
					#statConstr= #([FREQUENCY_CONTR, "statConstr frequency"], #statConstr);
				}
			|	"mean"! numOp number SEMI!
				{	
					#statConstr= #([MEAN_CONTR, "statConstr mean"], #statConstr);
				}
			|	"variance"! numOp number SEMI!
				{	
					#statConstr= #([VARIANCE_CONTR, "statConstr variance"], #statConstr);
				}
			;
										
freqRange		
			:!	(l1:LBRACK|l2:LPARAN) lowerNumber:number COMMA upperNumber:number (r1:RPARAN|r2:RBRACK)
				{
					
					int lIncludeBound = INCLUDE_BOUND;
					string lIBStr = "[";
					int rIncludeBound = INCLUDE_BOUND;
					string rIBStr = "]";
					if (l1 == null && l2 != null)
					{
						lIBStr = "(";
						lIncludeBound = NOT_INCLUDE_BOUND;
					}
					if (r2 == null && r1 != null) 
					{
						rIBStr = ")";
						rIncludeBound = NOT_INCLUDE_BOUND;	
					}
					#freqRange = #([FREQ_RANGE, "freqRange"], [lIncludeBound, lIBStr], #lowerNumber, #upperNumber, [rIncludeBound, rIBStr]);
					
				}
			|	valueLiteral
			;		
				
nameList
			:	name (COMMA! name)*
				{
					#nameList = #([NAME_LIST, "nameList"], #nameList);
				}
			;

// -----------------------------------------------------------------------------	
						
profileDecl
			:	name "for"! name ASSIGN! profileExp
				{
					#profileDecl = #([PROFILE_DECL, "profileDecl"], #profileDecl);
				}
			;

profileExp
			:	"profile"! LCURLY! (reqClause)* RCURLY!
				{
					#profileExp = #([PROFILE_EXP_PROFILE, "profileExp profile"], #profileExp);
				}
//			|	name "refined"! "by"! LCURLY! (reqClause)* RCURLY!
//				{
//					#profileExp = #([PROFILE_EXP_REFINED_BY, "profileExp refined by"], #profileExp);
//				}
			;				
				
reqClause
			:	(fromEntityList)? "require"! (contractList | name) SEMI!
				{
					#reqClause = #([REQ_CLAUSE, "reqClause"], #reqClause);
				}
			;

contractList
			:	contrExp (COMMA! contrExp)*
				{
					#contractList = #([CONTRACT_LIST, "contractList"], #contractList);
				}
			;
			
fromEntityList
			:	"from"! entityList
			;

entityList
			:	entity (COMMA! entity)*
				{
					#entityList = #([ENTITY_LIST, "entityList"], #entityList);
				}
			;

entity
			:	name
				{
					#entity = #([ENTITY, "entity"], #entity);
				}
			|	name DOT! name
				{
					#entity = #([ENTITY_PARM, "entity parm"], #entity);
				}
			|	"result"! "of"! name
				{
					#entity = #([ENTITY_RESULT_OF, "entity result of"], #entity);
				}
			;
						
// -----------------------------------------------------------------------------				
			
name
			:	i:IDENT	
			{ 
				#name = #([NAME, i.getText()]);	
				QmlParser.NodeHelper.CopyComments(#i, #name);
				QmlParser.NodeHelper.CopyLocation(#i, #name);
			}
			;

numOp					
			:	GTE 			{	#numOp = #([NUMOP_GTE, "greaterThanOrEqual"]);	}
			| 	GTHAN 		{	#numOp = #([NUMOP_GTHAN, "greaterThan"]);	}
			| 	LTHAN 		{	#numOp = #([NUMOP_LTHAN, "lessThan"]);	}
			| 	LTE 			{	#numOp = #([NUMOP_LTE, "lessThanOrEqual"]);	}
			| 	EQUAL			{	#numOp = #([NUMOP_EQUAL, "equal"]);	}
			;

			
number
			:	n:NUM			{	#number = #([NUMBER, n.getText()]);	}
			;
			
		

// L E X E R

class QMLLexer extends Lexer;
options {
	charVocabulary = '\0'..'\377';
	exportVocab = QML;
	testLiterals = false;
	k = 4;
	caseSensitive = true;
	caseSensitiveLiterals = true;
	defaultErrorHandler = false;
}

ASSIGN		:	'=';
LCURLY		:	'{';
RCURLY		:	'}';
COLON			:	':';
SEMI			:	';';
COMMA			:	',';
LTHAN			:	'<';
GTHAN			:	'>';
DIV			:	'/';
LBRACK		:	'[';
RBRACK		:	']';
LPARAN		:	'(';
RPARAN		:	')';
GTE			:	">=";
LTE			:	"<=";
EQUAL			:	"==";	
PERCENT		:	'%';
DOT			:	'.';

protected
LETTER		:	'a'..'z'|'A'..'Z';

protected
DIGIT			:	'0'..'9';

IDENT
	options {
		testLiterals = true;
	}
				:	LETTER ('_' | LETTER | DIGIT )*
				;
		
NUM			:	(DIGIT)+ ('.' (DIGIT)* ( ('e'|'E')('+'|'-')? (DIGIT)+ )?)?
			;
							
WS	
options {
  paraphrase = "white space";
}
		:	(' '
		|	'\t'
		|	'\n'  { newline(); }
		|	'\r')
			{ $setType(Token.SKIP); }
		;
			
// C O M M E N T S
			
SL_COMMENT
options {
  paraphrase = "a comment";
}
		:	"//"!
			(~('\n'|'\r'))* ('\n'|'\r'('\n')?)
			{newline();}
		;
	
ML_COMMENT
options {
  paraphrase = "a comment";
}
		:	"/*"!
			(	options {
					generateAmbigWarnings=false;
				}
			:
				{ LA(2)!='/' }? '*'!
			|	'\r' '\n'		{newline();}
			|	'\r'			{newline();}
			|	'\n'			{newline();}
			|	~('*'|'\n'|'\r')
			)*
			"*/"!
		;
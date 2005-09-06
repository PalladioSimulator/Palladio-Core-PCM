// $ANTLR 2.7.5 (20050128): "qml.g" -> "QMLParser.cs"$

namespace QmlParser
{
	// Generate the header common to all output files.
	using System;
	
	using TokenBuffer              = antlr.TokenBuffer;
	using TokenStreamException     = antlr.TokenStreamException;
	using TokenStreamIOException   = antlr.TokenStreamIOException;
	using ANTLRException           = antlr.ANTLRException;
	using LLkParser = antlr.LLkParser;
	using Token                    = antlr.Token;
	using IToken                   = antlr.IToken;
	using TokenStream              = antlr.TokenStream;
	using RecognitionException     = antlr.RecognitionException;
	using NoViableAltException     = antlr.NoViableAltException;
	using MismatchedTokenException = antlr.MismatchedTokenException;
	using SemanticException        = antlr.SemanticException;
	using ParserSharedInputState   = antlr.ParserSharedInputState;
	using BitSet                   = antlr.collections.impl.BitSet;
	using AST                      = antlr.collections.AST;
	using ASTPair                  = antlr.ASTPair;
	using ASTFactory               = antlr.ASTFactory;
	using ASTArray                 = antlr.collections.impl.ASTArray;
	
	public 	class QMLParser : antlr.LLkParser
	{
		public const int EOF = 1;
		public const int NULL_TREE_LOOKAHEAD = 3;
		public const int DECLARATIONS = 4;
		public const int CONTRACT_TYPE_DECL = 5;
		public const int DIMENSION_DECL = 6;
		public const int INCREASING_ORDER_SEM = 7;
		public const int DECREASING_ORDER_SEM = 8;
		public const int ENUM_DEF = 9;
		public const int SET_DEF = 10;
		public const int NUMERIC_DEF = 11;
		public const int ORDER_DEF = 12;
		public const int ONE_ORDER = 13;
		public const int UNIT = 14;
		public const int CONTRACT_DECL = 15;
		public const int CONTRACT_EXP_CONTRACT = 16;
		public const int CONTRACT_EXP_REFINED_BY = 17;
		public const int SIMPLE_CONSTR = 18;
		public const int ASPECT_CONSTR = 19;
		public const int PERCENTILE_CONTR = 20;
		public const int FREQUENCY_CONTR = 21;
		public const int MEAN_CONTR = 22;
		public const int VARIANCE_CONTR = 23;
		public const int FREQ_RANGE = 24;
		public const int INCLUDE_BOUND = 25;
		public const int NOT_INCLUDE_BOUND = 26;
		public const int NAME_LIST = 27;
		public const int PROFILE_DECL = 28;
		public const int PROFILE_EXP_PROFILE = 29;
		public const int PROFILE_EXP_REFINED_BY = 30;
		public const int REQ_CLAUSE = 31;
		public const int CONTRACT_LIST = 32;
		public const int ENTITY_LIST = 33;
		public const int ENTITY = 34;
		public const int ENTITY_PARM = 35;
		public const int ENTITY_RESULT_OF = 36;
		public const int NUMOP_GTE = 37;
		public const int NUMOP_GTHAN = 38;
		public const int NUMOP_LTHAN = 39;
		public const int NUMOP_LTE = 40;
		public const int NUMOP_EQUAL = 41;
		public const int NAME = 42;
		public const int NUMBER = 43;
		public const int LITERAL_type = 44;
		public const int ASSIGN = 45;
		public const int LITERAL_contract = 46;
		public const int LCURLY = 47;
		public const int RCURLY = 48;
		public const int COLON = 49;
		public const int SEMI = 50;
		public const int LITERAL_increasing = 51;
		public const int LITERAL_decreasing = 52;
		public const int LITERAL_enum = 53;
		public const int LITERAL_with = 54;
		public const int LITERAL_set = 55;
		public const int LITERAL_order = 56;
		public const int COMMA = 57;
		public const int LTHAN = 58;
		public const int LITERAL_numeric = 59;
		public const int DIV = 60;
		public const int LITERAL_percentile = 61;
		public const int LITERAL_frequency = 62;
		public const int PERCENT = 63;
		public const int LITERAL_mean = 64;
		public const int LITERAL_variance = 65;
		public const int LBRACK = 66;
		public const int LPARAN = 67;
		public const int RPARAN = 68;
		public const int RBRACK = 69;
		public const int LITERAL_for = 70;
		public const int LITERAL_profile = 71;
		public const int LITERAL_require = 72;
		public const int LITERAL_from = 73;
		public const int DOT = 74;
		public const int LITERAL_result = 75;
		public const int LITERAL_of = 76;
		public const int IDENT = 77;
		public const int GTE = 78;
		public const int GTHAN = 79;
		public const int LTE = 80;
		public const int EQUAL = 81;
		public const int NUM = 82;
		public const int LETTER = 83;
		public const int DIGIT = 84;
		public const int WS = 85;
		public const int SL_COMMENT = 86;
		public const int ML_COMMENT = 87;
		
		
		protected void initialize()
		{
			tokenNames = tokenNames_;
			initializeFactory();
		}
		
		
		protected QMLParser(TokenBuffer tokenBuf, int k) : base(tokenBuf, k)
		{
			initialize();
		}
		
		public QMLParser(TokenBuffer tokenBuf) : this(tokenBuf,2)
		{
		}
		
		protected QMLParser(TokenStream lexer, int k) : base(lexer,k)
		{
			initialize();
		}
		
		public QMLParser(TokenStream lexer) : this(lexer,2)
		{
		}
		
		public QMLParser(ParserSharedInputState state) : base(state,2)
		{
			initialize();
		}
		
	public void declarations() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = ASTPair.GetInstance();
		AST declarations_AST = null;
		
		{    // ( ... )*
			for (;;)
			{
				if ((LA(1)==LITERAL_type||LA(1)==IDENT))
				{
					declaration();
					if (0 == inputState.guessing)
					{
						astFactory.addASTChild(currentAST, returnAST);
					}
				}
				else
				{
					goto _loop3_breakloop;
				}
				
			}
_loop3_breakloop:			;
		}    // ( ... )*
		if (0==inputState.guessing)
		{
			declarations_AST = (AST)currentAST.root;
				declarations_AST = (AST) astFactory.make(astFactory.create(DECLARATIONS,"declarations"), declarations_AST);	
			currentAST.root = declarations_AST;
			if ( (null != declarations_AST) && (null != declarations_AST.getFirstChild()) )
				currentAST.child = declarations_AST.getFirstChild();
			else
				currentAST.child = declarations_AST;
			currentAST.advanceChildToEnd();
		}
		declarations_AST = currentAST.root;
		returnAST = declarations_AST;
		ASTPair.PutInstance(currentAST);
	}
	
	public void declaration() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = ASTPair.GetInstance();
		AST declaration_AST = null;
		
		if ((LA(1)==LITERAL_type))
		{
			contrTypeDecl();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			declaration_AST = currentAST.root;
		}
		else if ((LA(1)==IDENT) && (LA(2)==ASSIGN)) {
			contrDecl();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			declaration_AST = currentAST.root;
		}
		else if ((LA(1)==IDENT) && (LA(2)==LITERAL_for)) {
			profileDecl();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			declaration_AST = currentAST.root;
		}
		else
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		returnAST = declaration_AST;
		ASTPair.PutInstance(currentAST);
	}
	
	public void contrTypeDecl() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = ASTPair.GetInstance();
		AST contrTypeDecl_AST = null;
		IToken  type = null;
		AST type_AST = null;
		AST name_AST = null;
		AST contractType_AST = null;
		
		type = LT(1);
		type_AST = astFactory.create(type);
		match(LITERAL_type);
		name();
		if (0 == inputState.guessing)
		{
			name_AST = (AST)returnAST;
		}
		AST tmp1_AST = null;
		tmp1_AST = astFactory.create(LT(1));
		match(ASSIGN);
		contractType(type_AST, name_AST);
		if (0 == inputState.guessing)
		{
			contractType_AST = (AST)returnAST;
		}
		if (0==inputState.guessing)
		{
			contrTypeDecl_AST = (AST)currentAST.root;
				contrTypeDecl_AST = contractType_AST;	
			currentAST.root = contrTypeDecl_AST;
			if ( (null != contrTypeDecl_AST) && (null != contrTypeDecl_AST.getFirstChild()) )
				currentAST.child = contrTypeDecl_AST.getFirstChild();
			else
				currentAST.child = contrTypeDecl_AST;
			currentAST.advanceChildToEnd();
		}
		returnAST = contrTypeDecl_AST;
		ASTPair.PutInstance(currentAST);
	}
	
	public void contrDecl() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = ASTPair.GetInstance();
		AST contrDecl_AST = null;
		
		name();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		match(ASSIGN);
		contrExp();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		if (0==inputState.guessing)
		{
			contrDecl_AST = (AST)currentAST.root;
			
								contrDecl_AST = (AST) astFactory.make(astFactory.create(CONTRACT_DECL,"contrDecl"), contrDecl_AST);
							
			currentAST.root = contrDecl_AST;
			if ( (null != contrDecl_AST) && (null != contrDecl_AST.getFirstChild()) )
				currentAST.child = contrDecl_AST.getFirstChild();
			else
				currentAST.child = contrDecl_AST;
			currentAST.advanceChildToEnd();
		}
		contrDecl_AST = currentAST.root;
		returnAST = contrDecl_AST;
		ASTPair.PutInstance(currentAST);
	}
	
	public void profileDecl() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = ASTPair.GetInstance();
		AST profileDecl_AST = null;
		
		name();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		match(LITERAL_for);
		name();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		match(ASSIGN);
		profileExp();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		if (0==inputState.guessing)
		{
			profileDecl_AST = (AST)currentAST.root;
			
								profileDecl_AST = (AST) astFactory.make(astFactory.create(PROFILE_DECL,"profileDecl"), profileDecl_AST);
							
			currentAST.root = profileDecl_AST;
			if ( (null != profileDecl_AST) && (null != profileDecl_AST.getFirstChild()) )
				currentAST.child = profileDecl_AST.getFirstChild();
			else
				currentAST.child = profileDecl_AST;
			currentAST.advanceChildToEnd();
		}
		profileDecl_AST = currentAST.root;
		returnAST = profileDecl_AST;
		ASTPair.PutInstance(currentAST);
	}
	
	public void name() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = ASTPair.GetInstance();
		AST name_AST = null;
		IToken  i = null;
		AST i_AST = null;
		
		i = LT(1);
		i_AST = astFactory.create(i);
		astFactory.addASTChild(currentAST, i_AST);
		match(IDENT);
		if (0==inputState.guessing)
		{
			name_AST = (AST)currentAST.root;
			
							name_AST = (AST) astFactory.make(astFactory.create(NAME,i.getText()));	
							QmlParser.NodeHelper.CopyComments(i_AST, name_AST);
							QmlParser.NodeHelper.CopyLocation(i_AST, name_AST);
						
			currentAST.root = name_AST;
			if ( (null != name_AST) && (null != name_AST.getFirstChild()) )
				currentAST.child = name_AST.getFirstChild();
			else
				currentAST.child = name_AST;
			currentAST.advanceChildToEnd();
		}
		name_AST = currentAST.root;
		returnAST = name_AST;
		ASTPair.PutInstance(currentAST);
	}
	
	public void contractType(
		AST type, AST name
	) //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = ASTPair.GetInstance();
		AST contractType_AST = null;
		
		match(LITERAL_contract);
		match(LCURLY);
		{    // ( ... )*
			for (;;)
			{
				if ((LA(1)==IDENT))
				{
					dimensionDecl();
					if (0 == inputState.guessing)
					{
						astFactory.addASTChild(currentAST, returnAST);
					}
				}
				else
				{
					goto _loop8_breakloop;
				}
				
			}
_loop8_breakloop:			;
		}    // ( ... )*
		match(RCURLY);
		if (0==inputState.guessing)
		{
			contractType_AST = (AST)currentAST.root;
			
								QmlParser.NodeHelper.CopyComments(type, name);
								contractType_AST = (AST) astFactory.make(astFactory.create(CONTRACT_TYPE_DECL,"contrTypeDecl"), name, contractType_AST);	
							
			currentAST.root = contractType_AST;
			if ( (null != contractType_AST) && (null != contractType_AST.getFirstChild()) )
				currentAST.child = contractType_AST.getFirstChild();
			else
				currentAST.child = contractType_AST;
			currentAST.advanceChildToEnd();
		}
		contractType_AST = currentAST.root;
		returnAST = contractType_AST;
		ASTPair.PutInstance(currentAST);
	}
	
	public void dimensionDecl() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = ASTPair.GetInstance();
		AST dimensionDecl_AST = null;
		
		name();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		match(COLON);
		dimensionType();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		{
			switch ( LA(1) )
			{
			case IDENT:
			{
				unit();
				if (0 == inputState.guessing)
				{
					astFactory.addASTChild(currentAST, returnAST);
				}
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		match(SEMI);
		if (0==inputState.guessing)
		{
			dimensionDecl_AST = (AST)currentAST.root;
			
								dimensionDecl_AST = (AST) astFactory.make(astFactory.create(DIMENSION_DECL,"dimensionDecl"), dimensionDecl_AST);
							
			currentAST.root = dimensionDecl_AST;
			if ( (null != dimensionDecl_AST) && (null != dimensionDecl_AST.getFirstChild()) )
				currentAST.child = dimensionDecl_AST.getFirstChild();
			else
				currentAST.child = dimensionDecl_AST;
			currentAST.advanceChildToEnd();
		}
		dimensionDecl_AST = currentAST.root;
		returnAST = dimensionDecl_AST;
		ASTPair.PutInstance(currentAST);
	}
	
	public void dimensionType() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = ASTPair.GetInstance();
		AST dimensionType_AST = null;
		
		bool synPredMatched13 = false;
		if ((((LA(1) >= LITERAL_increasing && LA(1) <= LITERAL_enum)) && (LA(2)==LCURLY||LA(2)==LITERAL_enum)))
		{
			int _m13 = mark();
			synPredMatched13 = true;
			inputState.guessing++;
			try {
				{
					enumDef();
				}
			}
			catch (RecognitionException)
			{
				synPredMatched13 = false;
			}
			rewind(_m13);
			inputState.guessing--;
		}
		if ( synPredMatched13 )
		{
			enumDef();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			dimensionType_AST = currentAST.root;
		}
		else {
			bool synPredMatched15 = false;
			if (((LA(1)==LITERAL_increasing||LA(1)==LITERAL_decreasing||LA(1)==LITERAL_set) && (LA(2)==LCURLY||LA(2)==LITERAL_set)))
			{
				int _m15 = mark();
				synPredMatched15 = true;
				inputState.guessing++;
				try {
					{
						setDef();
					}
				}
				catch (RecognitionException)
				{
					synPredMatched15 = false;
				}
				rewind(_m15);
				inputState.guessing--;
			}
			if ( synPredMatched15 )
			{
				setDef();
				if (0 == inputState.guessing)
				{
					astFactory.addASTChild(currentAST, returnAST);
				}
				dimensionType_AST = currentAST.root;
			}
			else if ((LA(1)==LITERAL_increasing||LA(1)==LITERAL_decreasing) && (LA(2)==LITERAL_numeric)) {
				numeric();
				if (0 == inputState.guessing)
				{
					astFactory.addASTChild(currentAST, returnAST);
				}
				dimensionType_AST = currentAST.root;
			}
			else
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			returnAST = dimensionType_AST;
			ASTPair.PutInstance(currentAST);
		}
		
	public void unit() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = ASTPair.GetInstance();
		AST unit_AST = null;
		
		if ((LA(1)==IDENT) && (LA(2)==SEMI))
		{
			name();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			if (0==inputState.guessing)
			{
				unit_AST = (AST)currentAST.root;
				
									unit_AST = (AST) astFactory.make(astFactory.create(UNIT,"unit"), unit_AST);
								
				currentAST.root = unit_AST;
				if ( (null != unit_AST) && (null != unit_AST.getFirstChild()) )
					currentAST.child = unit_AST.getFirstChild();
				else
					currentAST.child = unit_AST;
				currentAST.advanceChildToEnd();
			}
			unit_AST = currentAST.root;
		}
		else if ((LA(1)==IDENT) && (LA(2)==DIV)) {
			name();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			match(DIV);
			name();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			if (0==inputState.guessing)
			{
				unit_AST = (AST)currentAST.root;
				
									unit_AST = (AST) astFactory.make(astFactory.create(UNIT,"unit"), unit_AST);
								
				currentAST.root = unit_AST;
				if ( (null != unit_AST) && (null != unit_AST.getFirstChild()) )
					currentAST.child = unit_AST.getFirstChild();
				else
					currentAST.child = unit_AST;
				currentAST.advanceChildToEnd();
			}
			unit_AST = currentAST.root;
		}
		else
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		returnAST = unit_AST;
		ASTPair.PutInstance(currentAST);
	}
	
	public void enumDef() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = ASTPair.GetInstance();
		AST enumDef_AST = null;
		AST nameList_AST = null;
		
		switch ( LA(1) )
		{
		case LITERAL_enum:
		{
			match(LITERAL_enum);
			match(LCURLY);
			nameList();
			if (0 == inputState.guessing)
			{
				nameList_AST = (AST)returnAST;
				astFactory.addASTChild(currentAST, returnAST);
			}
			match(RCURLY);
			if (0==inputState.guessing)
			{
				enumDef_AST = (AST)currentAST.root;
				
									enumDef_AST = (AST) astFactory.make(astFactory.create(ENUM_DEF,"enumDef"), enumDef_AST);
								
				currentAST.root = enumDef_AST;
				if ( (null != enumDef_AST) && (null != enumDef_AST.getFirstChild()) )
					currentAST.child = enumDef_AST.getFirstChild();
				else
					currentAST.child = enumDef_AST;
				currentAST.advanceChildToEnd();
			}
			enumDef_AST = currentAST.root;
			break;
		}
		case LITERAL_increasing:
		case LITERAL_decreasing:
		{
			orderSem();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			match(LITERAL_enum);
			match(LCURLY);
			nameList();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			match(RCURLY);
			match(LITERAL_with);
			orderDef();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			if (0==inputState.guessing)
			{
				enumDef_AST = (AST)currentAST.root;
				
									enumDef_AST = (AST) astFactory.make(astFactory.create(ENUM_DEF,"enumDef"), enumDef_AST);
								
				currentAST.root = enumDef_AST;
				if ( (null != enumDef_AST) && (null != enumDef_AST.getFirstChild()) )
					currentAST.child = enumDef_AST.getFirstChild();
				else
					currentAST.child = enumDef_AST;
				currentAST.advanceChildToEnd();
			}
			enumDef_AST = currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		 }
		returnAST = enumDef_AST;
		ASTPair.PutInstance(currentAST);
	}
	
	public void setDef() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = ASTPair.GetInstance();
		AST setDef_AST = null;
		
		switch ( LA(1) )
		{
		case LITERAL_set:
		{
			match(LITERAL_set);
			match(LCURLY);
			nameList();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			match(RCURLY);
			if (0==inputState.guessing)
			{
				setDef_AST = (AST)currentAST.root;
				
									setDef_AST = (AST) astFactory.make(astFactory.create(SET_DEF,"setDef"), setDef_AST);
								
				currentAST.root = setDef_AST;
				if ( (null != setDef_AST) && (null != setDef_AST.getFirstChild()) )
					currentAST.child = setDef_AST.getFirstChild();
				else
					currentAST.child = setDef_AST;
				currentAST.advanceChildToEnd();
			}
			setDef_AST = currentAST.root;
			break;
		}
		case LITERAL_increasing:
		case LITERAL_decreasing:
		{
			orderSem();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			match(LITERAL_set);
			match(LCURLY);
			nameList();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			match(RCURLY);
			{
				switch ( LA(1) )
				{
				case LITERAL_with:
				{
					match(LITERAL_with);
					orderDef();
					if (0 == inputState.guessing)
					{
						astFactory.addASTChild(currentAST, returnAST);
					}
					break;
				}
				case SEMI:
				case IDENT:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				 }
			}
			if (0==inputState.guessing)
			{
				setDef_AST = (AST)currentAST.root;
				
									setDef_AST = (AST) astFactory.make(astFactory.create(SET_DEF,"setDef"), setDef_AST);
								
				currentAST.root = setDef_AST;
				if ( (null != setDef_AST) && (null != setDef_AST.getFirstChild()) )
					currentAST.child = setDef_AST.getFirstChild();
				else
					currentAST.child = setDef_AST;
				currentAST.advanceChildToEnd();
			}
			setDef_AST = currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		 }
		returnAST = setDef_AST;
		ASTPair.PutInstance(currentAST);
	}
	
	public void numeric() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = ASTPair.GetInstance();
		AST numeric_AST = null;
		
		orderSem();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		match(LITERAL_numeric);
		if (0==inputState.guessing)
		{
			numeric_AST = (AST)currentAST.root;
			
								numeric_AST = (AST) astFactory.make(astFactory.create(NUMERIC_DEF,"numeric"), numeric_AST);
							
			currentAST.root = numeric_AST;
			if ( (null != numeric_AST) && (null != numeric_AST.getFirstChild()) )
				currentAST.child = numeric_AST.getFirstChild();
			else
				currentAST.child = numeric_AST;
			currentAST.advanceChildToEnd();
		}
		numeric_AST = currentAST.root;
		returnAST = numeric_AST;
		ASTPair.PutInstance(currentAST);
	}
	
	public void orderSem() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = ASTPair.GetInstance();
		AST orderSem_AST = null;
		
		switch ( LA(1) )
		{
		case LITERAL_increasing:
		{
			match(LITERAL_increasing);
			if (0==inputState.guessing)
			{
				orderSem_AST = (AST)currentAST.root;
					
									orderSem_AST = (AST) astFactory.make(astFactory.create(INCREASING_ORDER_SEM,"increasing"));	
								
				currentAST.root = orderSem_AST;
				if ( (null != orderSem_AST) && (null != orderSem_AST.getFirstChild()) )
					currentAST.child = orderSem_AST.getFirstChild();
				else
					currentAST.child = orderSem_AST;
				currentAST.advanceChildToEnd();
			}
			break;
		}
		case LITERAL_decreasing:
		{
			match(LITERAL_decreasing);
			if (0==inputState.guessing)
			{
				orderSem_AST = (AST)currentAST.root;
					
									orderSem_AST = (AST) astFactory.make(astFactory.create(DECREASING_ORDER_SEM,"decreasing"));	
								
				currentAST.root = orderSem_AST;
				if ( (null != orderSem_AST) && (null != orderSem_AST.getFirstChild()) )
					currentAST.child = orderSem_AST.getFirstChild();
				else
					currentAST.child = orderSem_AST;
				currentAST.advanceChildToEnd();
			}
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		 }
		returnAST = orderSem_AST;
		ASTPair.PutInstance(currentAST);
	}
	
	public void nameList() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = ASTPair.GetInstance();
		AST nameList_AST = null;
		
		name();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		{    // ( ... )*
			for (;;)
			{
				if ((LA(1)==COMMA))
				{
					match(COMMA);
					name();
					if (0 == inputState.guessing)
					{
						astFactory.addASTChild(currentAST, returnAST);
					}
				}
				else
				{
					goto _loop44_breakloop;
				}
				
			}
_loop44_breakloop:			;
		}    // ( ... )*
		if (0==inputState.guessing)
		{
			nameList_AST = (AST)currentAST.root;
			
								nameList_AST = (AST) astFactory.make(astFactory.create(NAME_LIST,"nameList"), nameList_AST);
							
			currentAST.root = nameList_AST;
			if ( (null != nameList_AST) && (null != nameList_AST.getFirstChild()) )
				currentAST.child = nameList_AST.getFirstChild();
			else
				currentAST.child = nameList_AST;
			currentAST.advanceChildToEnd();
		}
		nameList_AST = currentAST.root;
		returnAST = nameList_AST;
		ASTPair.PutInstance(currentAST);
	}
	
	public void orderDef() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = ASTPair.GetInstance();
		AST orderDef_AST = null;
		
		match(LITERAL_order);
		match(LCURLY);
		{
			switch ( LA(1) )
			{
			case IDENT:
			{
				oneOrder();
				if (0 == inputState.guessing)
				{
					astFactory.addASTChild(currentAST, returnAST);
				}
				{    // ( ... )*
					for (;;)
					{
						if ((LA(1)==COMMA))
						{
							match(COMMA);
							oneOrder();
							if (0 == inputState.guessing)
							{
								astFactory.addASTChild(currentAST, returnAST);
							}
						}
						else
						{
							goto _loop23_breakloop;
						}
						
					}
_loop23_breakloop:					;
				}    // ( ... )*
				break;
			}
			case RCURLY:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		match(RCURLY);
		if (0==inputState.guessing)
		{
			orderDef_AST = (AST)currentAST.root;
			
								orderDef_AST = (AST) astFactory.make(astFactory.create(ORDER_DEF,"orderDef"), orderDef_AST);
							
			currentAST.root = orderDef_AST;
			if ( (null != orderDef_AST) && (null != orderDef_AST.getFirstChild()) )
				currentAST.child = orderDef_AST.getFirstChild();
			else
				currentAST.child = orderDef_AST;
			currentAST.advanceChildToEnd();
		}
		orderDef_AST = currentAST.root;
		returnAST = orderDef_AST;
		ASTPair.PutInstance(currentAST);
	}
	
	public void oneOrder() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = ASTPair.GetInstance();
		AST oneOrder_AST = null;
		
		name();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		match(LTHAN);
		name();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		if (0==inputState.guessing)
		{
			oneOrder_AST = (AST)currentAST.root;
			
								oneOrder_AST = (AST) astFactory.make(astFactory.create(ONE_ORDER,"oneOrder"), oneOrder_AST);
							
			currentAST.root = oneOrder_AST;
			if ( (null != oneOrder_AST) && (null != oneOrder_AST.getFirstChild()) )
				currentAST.child = oneOrder_AST.getFirstChild();
			else
				currentAST.child = oneOrder_AST;
			currentAST.advanceChildToEnd();
		}
		oneOrder_AST = currentAST.root;
		returnAST = oneOrder_AST;
		ASTPair.PutInstance(currentAST);
	}
	
	public void contrExp() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = ASTPair.GetInstance();
		AST contrExp_AST = null;
		
		name();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		match(LITERAL_contract);
		match(LCURLY);
		{    // ( ... )*
			for (;;)
			{
				if ((LA(1)==IDENT))
				{
					dimConstraint();
					if (0 == inputState.guessing)
					{
						astFactory.addASTChild(currentAST, returnAST);
					}
				}
				else
				{
					goto _loop30_breakloop;
				}
				
			}
_loop30_breakloop:			;
		}    // ( ... )*
		match(RCURLY);
		if (0==inputState.guessing)
		{
			contrExp_AST = (AST)currentAST.root;
			
								contrExp_AST = (AST) astFactory.make(astFactory.create(CONTRACT_EXP_CONTRACT,"contrExp contract"), contrExp_AST);
							
			currentAST.root = contrExp_AST;
			if ( (null != contrExp_AST) && (null != contrExp_AST.getFirstChild()) )
				currentAST.child = contrExp_AST.getFirstChild();
			else
				currentAST.child = contrExp_AST;
			currentAST.advanceChildToEnd();
		}
		contrExp_AST = currentAST.root;
		returnAST = contrExp_AST;
		ASTPair.PutInstance(currentAST);
	}
	
	public void dimConstraint() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = ASTPair.GetInstance();
		AST dimConstraint_AST = null;
		
		if ((LA(1)==IDENT) && (tokenSet_0_.member(LA(2))))
		{
			simpleConstr();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			match(SEMI);
			dimConstraint_AST = currentAST.root;
		}
		else if ((LA(1)==IDENT) && (LA(2)==LCURLY)) {
			aspectConstr();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			match(SEMI);
			dimConstraint_AST = currentAST.root;
		}
		else
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		returnAST = dimConstraint_AST;
		ASTPair.PutInstance(currentAST);
	}
	
	public void simpleConstr() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = ASTPair.GetInstance();
		AST simpleConstr_AST = null;
		
		name();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		numOp();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		valueLiteral();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		{
			switch ( LA(1) )
			{
			case IDENT:
			{
				unit();
				if (0 == inputState.guessing)
				{
					astFactory.addASTChild(currentAST, returnAST);
				}
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		if (0==inputState.guessing)
		{
			simpleConstr_AST = (AST)currentAST.root;
			
								simpleConstr_AST = (AST) astFactory.make(astFactory.create(SIMPLE_CONSTR,"simpleConstr"), simpleConstr_AST);
							
			currentAST.root = simpleConstr_AST;
			if ( (null != simpleConstr_AST) && (null != simpleConstr_AST.getFirstChild()) )
				currentAST.child = simpleConstr_AST.getFirstChild();
			else
				currentAST.child = simpleConstr_AST;
			currentAST.advanceChildToEnd();
		}
		simpleConstr_AST = currentAST.root;
		returnAST = simpleConstr_AST;
		ASTPair.PutInstance(currentAST);
	}
	
	public void aspectConstr() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = ASTPair.GetInstance();
		AST aspectConstr_AST = null;
		
		name();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		match(LCURLY);
		{    // ( ... )*
			for (;;)
			{
				if ((tokenSet_1_.member(LA(1))))
				{
					statConstr();
					if (0 == inputState.guessing)
					{
						astFactory.addASTChild(currentAST, returnAST);
					}
				}
				else
				{
					goto _loop37_breakloop;
				}
				
			}
_loop37_breakloop:			;
		}    // ( ... )*
		match(RCURLY);
		if (0==inputState.guessing)
		{
			aspectConstr_AST = (AST)currentAST.root;
			
								aspectConstr_AST = (AST) astFactory.make(astFactory.create(ASPECT_CONSTR,"aspectConstr"), aspectConstr_AST);
							
			currentAST.root = aspectConstr_AST;
			if ( (null != aspectConstr_AST) && (null != aspectConstr_AST.getFirstChild()) )
				currentAST.child = aspectConstr_AST.getFirstChild();
			else
				currentAST.child = aspectConstr_AST;
			currentAST.advanceChildToEnd();
		}
		aspectConstr_AST = currentAST.root;
		returnAST = aspectConstr_AST;
		ASTPair.PutInstance(currentAST);
	}
	
	public void numOp() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = ASTPair.GetInstance();
		AST numOp_AST = null;
		
		switch ( LA(1) )
		{
		case GTE:
		{
			AST tmp41_AST = null;
			tmp41_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp41_AST);
			match(GTE);
			if (0==inputState.guessing)
			{
				numOp_AST = (AST)currentAST.root;
					numOp_AST = (AST) astFactory.make(astFactory.create(NUMOP_GTE,"greaterThanOrEqual"));	
				currentAST.root = numOp_AST;
				if ( (null != numOp_AST) && (null != numOp_AST.getFirstChild()) )
					currentAST.child = numOp_AST.getFirstChild();
				else
					currentAST.child = numOp_AST;
				currentAST.advanceChildToEnd();
			}
			numOp_AST = currentAST.root;
			break;
		}
		case GTHAN:
		{
			AST tmp42_AST = null;
			tmp42_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp42_AST);
			match(GTHAN);
			if (0==inputState.guessing)
			{
				numOp_AST = (AST)currentAST.root;
					numOp_AST = (AST) astFactory.make(astFactory.create(NUMOP_GTHAN,"greaterThan"));	
				currentAST.root = numOp_AST;
				if ( (null != numOp_AST) && (null != numOp_AST.getFirstChild()) )
					currentAST.child = numOp_AST.getFirstChild();
				else
					currentAST.child = numOp_AST;
				currentAST.advanceChildToEnd();
			}
			numOp_AST = currentAST.root;
			break;
		}
		case LTHAN:
		{
			AST tmp43_AST = null;
			tmp43_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp43_AST);
			match(LTHAN);
			if (0==inputState.guessing)
			{
				numOp_AST = (AST)currentAST.root;
					numOp_AST = (AST) astFactory.make(astFactory.create(NUMOP_LTHAN,"lessThan"));	
				currentAST.root = numOp_AST;
				if ( (null != numOp_AST) && (null != numOp_AST.getFirstChild()) )
					currentAST.child = numOp_AST.getFirstChild();
				else
					currentAST.child = numOp_AST;
				currentAST.advanceChildToEnd();
			}
			numOp_AST = currentAST.root;
			break;
		}
		case LTE:
		{
			AST tmp44_AST = null;
			tmp44_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp44_AST);
			match(LTE);
			if (0==inputState.guessing)
			{
				numOp_AST = (AST)currentAST.root;
					numOp_AST = (AST) astFactory.make(astFactory.create(NUMOP_LTE,"lessThanOrEqual"));	
				currentAST.root = numOp_AST;
				if ( (null != numOp_AST) && (null != numOp_AST.getFirstChild()) )
					currentAST.child = numOp_AST.getFirstChild();
				else
					currentAST.child = numOp_AST;
				currentAST.advanceChildToEnd();
			}
			numOp_AST = currentAST.root;
			break;
		}
		case EQUAL:
		{
			AST tmp45_AST = null;
			tmp45_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp45_AST);
			match(EQUAL);
			if (0==inputState.guessing)
			{
				numOp_AST = (AST)currentAST.root;
					numOp_AST = (AST) astFactory.make(astFactory.create(NUMOP_EQUAL,"equal"));	
				currentAST.root = numOp_AST;
				if ( (null != numOp_AST) && (null != numOp_AST.getFirstChild()) )
					currentAST.child = numOp_AST.getFirstChild();
				else
					currentAST.child = numOp_AST;
				currentAST.advanceChildToEnd();
			}
			numOp_AST = currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		 }
		returnAST = numOp_AST;
		ASTPair.PutInstance(currentAST);
	}
	
	public void valueLiteral() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = ASTPair.GetInstance();
		AST valueLiteral_AST = null;
		
		switch ( LA(1) )
		{
		case NUM:
		{
			number();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			valueLiteral_AST = currentAST.root;
			break;
		}
		case LCURLY:
		{
			match(LCURLY);
			nameList();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			match(RCURLY);
			valueLiteral_AST = currentAST.root;
			break;
		}
		case IDENT:
		{
			name();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			valueLiteral_AST = currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		 }
		returnAST = valueLiteral_AST;
		ASTPair.PutInstance(currentAST);
	}
	
	public void number() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = ASTPair.GetInstance();
		AST number_AST = null;
		IToken  n = null;
		AST n_AST = null;
		
		n = LT(1);
		n_AST = astFactory.create(n);
		astFactory.addASTChild(currentAST, n_AST);
		match(NUM);
		if (0==inputState.guessing)
		{
			number_AST = (AST)currentAST.root;
				number_AST = (AST) astFactory.make(astFactory.create(NUMBER,n.getText()));	
			currentAST.root = number_AST;
			if ( (null != number_AST) && (null != number_AST.getFirstChild()) )
				currentAST.child = number_AST.getFirstChild();
			else
				currentAST.child = number_AST;
			currentAST.advanceChildToEnd();
		}
		number_AST = currentAST.root;
		returnAST = number_AST;
		ASTPair.PutInstance(currentAST);
	}
	
	public void statConstr() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = ASTPair.GetInstance();
		AST statConstr_AST = null;
		
		switch ( LA(1) )
		{
		case LITERAL_percentile:
		{
			match(LITERAL_percentile);
			number();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			numOp();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			number();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			match(SEMI);
			if (0==inputState.guessing)
			{
				statConstr_AST = (AST)currentAST.root;
					
									statConstr_AST= (AST) astFactory.make(astFactory.create(PERCENTILE_CONTR,"statConstr percentile"), statConstr_AST);
								
				currentAST.root = statConstr_AST;
				if ( (null != statConstr_AST) && (null != statConstr_AST.getFirstChild()) )
					currentAST.child = statConstr_AST.getFirstChild();
				else
					currentAST.child = statConstr_AST;
				currentAST.advanceChildToEnd();
			}
			statConstr_AST = currentAST.root;
			break;
		}
		case LITERAL_frequency:
		{
			match(LITERAL_frequency);
			freqRange();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			numOp();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			number();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			match(PERCENT);
			match(SEMI);
			if (0==inputState.guessing)
			{
				statConstr_AST = (AST)currentAST.root;
					
									statConstr_AST= (AST) astFactory.make(astFactory.create(FREQUENCY_CONTR,"statConstr frequency"), statConstr_AST);
								
				currentAST.root = statConstr_AST;
				if ( (null != statConstr_AST) && (null != statConstr_AST.getFirstChild()) )
					currentAST.child = statConstr_AST.getFirstChild();
				else
					currentAST.child = statConstr_AST;
				currentAST.advanceChildToEnd();
			}
			statConstr_AST = currentAST.root;
			break;
		}
		case LITERAL_mean:
		{
			match(LITERAL_mean);
			numOp();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			number();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			match(SEMI);
			if (0==inputState.guessing)
			{
				statConstr_AST = (AST)currentAST.root;
					
									statConstr_AST= (AST) astFactory.make(astFactory.create(MEAN_CONTR,"statConstr mean"), statConstr_AST);
								
				currentAST.root = statConstr_AST;
				if ( (null != statConstr_AST) && (null != statConstr_AST.getFirstChild()) )
					currentAST.child = statConstr_AST.getFirstChild();
				else
					currentAST.child = statConstr_AST;
				currentAST.advanceChildToEnd();
			}
			statConstr_AST = currentAST.root;
			break;
		}
		case LITERAL_variance:
		{
			match(LITERAL_variance);
			numOp();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			number();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			match(SEMI);
			if (0==inputState.guessing)
			{
				statConstr_AST = (AST)currentAST.root;
					
									statConstr_AST= (AST) astFactory.make(astFactory.create(VARIANCE_CONTR,"statConstr variance"), statConstr_AST);
								
				currentAST.root = statConstr_AST;
				if ( (null != statConstr_AST) && (null != statConstr_AST.getFirstChild()) )
					currentAST.child = statConstr_AST.getFirstChild();
				else
					currentAST.child = statConstr_AST;
				currentAST.advanceChildToEnd();
			}
			statConstr_AST = currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		 }
		returnAST = statConstr_AST;
		ASTPair.PutInstance(currentAST);
	}
	
	public void freqRange() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = ASTPair.GetInstance();
		AST freqRange_AST = null;
		IToken  l1 = null;
		AST l1_AST = null;
		IToken  l2 = null;
		AST l2_AST = null;
		AST lowerNumber_AST = null;
		AST upperNumber_AST = null;
		IToken  r1 = null;
		AST r1_AST = null;
		IToken  r2 = null;
		AST r2_AST = null;
		
		switch ( LA(1) )
		{
		case LBRACK:
		case LPARAN:
		{
			{
				switch ( LA(1) )
				{
				case LBRACK:
				{
					l1 = LT(1);
					l1_AST = astFactory.create(l1);
					match(LBRACK);
					break;
				}
				case LPARAN:
				{
					l2 = LT(1);
					l2_AST = astFactory.create(l2);
					match(LPARAN);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				 }
			}
			number();
			if (0 == inputState.guessing)
			{
				lowerNumber_AST = (AST)returnAST;
			}
			AST tmp57_AST = null;
			tmp57_AST = astFactory.create(LT(1));
			match(COMMA);
			number();
			if (0 == inputState.guessing)
			{
				upperNumber_AST = (AST)returnAST;
			}
			{
				switch ( LA(1) )
				{
				case RPARAN:
				{
					r1 = LT(1);
					r1_AST = astFactory.create(r1);
					match(RPARAN);
					break;
				}
				case RBRACK:
				{
					r2 = LT(1);
					r2_AST = astFactory.create(r2);
					match(RBRACK);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				 }
			}
			if (0==inputState.guessing)
			{
				freqRange_AST = (AST)currentAST.root;
				
									
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
									freqRange_AST = (AST) astFactory.make(astFactory.create(FREQ_RANGE,"freqRange"), astFactory.create(lIncludeBound,lIBStr), lowerNumber_AST, upperNumber_AST, astFactory.create(rIncludeBound,rIBStr));
									
								
				currentAST.root = freqRange_AST;
				if ( (null != freqRange_AST) && (null != freqRange_AST.getFirstChild()) )
					currentAST.child = freqRange_AST.getFirstChild();
				else
					currentAST.child = freqRange_AST;
				currentAST.advanceChildToEnd();
			}
			break;
		}
		case LCURLY:
		case IDENT:
		case NUM:
		{
			valueLiteral();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			freqRange_AST = currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		 }
		returnAST = freqRange_AST;
		ASTPair.PutInstance(currentAST);
	}
	
	public void profileExp() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = ASTPair.GetInstance();
		AST profileExp_AST = null;
		
		match(LITERAL_profile);
		match(LCURLY);
		{    // ( ... )*
			for (;;)
			{
				if ((LA(1)==LITERAL_require||LA(1)==LITERAL_from))
				{
					reqClause();
					if (0 == inputState.guessing)
					{
						astFactory.addASTChild(currentAST, returnAST);
					}
				}
				else
				{
					goto _loop48_breakloop;
				}
				
			}
_loop48_breakloop:			;
		}    // ( ... )*
		match(RCURLY);
		if (0==inputState.guessing)
		{
			profileExp_AST = (AST)currentAST.root;
			
								profileExp_AST = (AST) astFactory.make(astFactory.create(PROFILE_EXP_PROFILE,"profileExp profile"), profileExp_AST);
							
			currentAST.root = profileExp_AST;
			if ( (null != profileExp_AST) && (null != profileExp_AST.getFirstChild()) )
				currentAST.child = profileExp_AST.getFirstChild();
			else
				currentAST.child = profileExp_AST;
			currentAST.advanceChildToEnd();
		}
		profileExp_AST = currentAST.root;
		returnAST = profileExp_AST;
		ASTPair.PutInstance(currentAST);
	}
	
	public void reqClause() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = ASTPair.GetInstance();
		AST reqClause_AST = null;
		
		{
			switch ( LA(1) )
			{
			case LITERAL_from:
			{
				fromEntityList();
				if (0 == inputState.guessing)
				{
					astFactory.addASTChild(currentAST, returnAST);
				}
				break;
			}
			case LITERAL_require:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			 }
		}
		match(LITERAL_require);
		{
			if ((LA(1)==IDENT) && (LA(2)==LITERAL_contract))
			{
				contractList();
				if (0 == inputState.guessing)
				{
					astFactory.addASTChild(currentAST, returnAST);
				}
			}
			else if ((LA(1)==IDENT) && (LA(2)==SEMI)) {
				name();
				if (0 == inputState.guessing)
				{
					astFactory.addASTChild(currentAST, returnAST);
				}
			}
			else
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		match(SEMI);
		if (0==inputState.guessing)
		{
			reqClause_AST = (AST)currentAST.root;
			
								reqClause_AST = (AST) astFactory.make(astFactory.create(REQ_CLAUSE,"reqClause"), reqClause_AST);
							
			currentAST.root = reqClause_AST;
			if ( (null != reqClause_AST) && (null != reqClause_AST.getFirstChild()) )
				currentAST.child = reqClause_AST.getFirstChild();
			else
				currentAST.child = reqClause_AST;
			currentAST.advanceChildToEnd();
		}
		reqClause_AST = currentAST.root;
		returnAST = reqClause_AST;
		ASTPair.PutInstance(currentAST);
	}
	
	public void fromEntityList() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = ASTPair.GetInstance();
		AST fromEntityList_AST = null;
		
		match(LITERAL_from);
		entityList();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		fromEntityList_AST = currentAST.root;
		returnAST = fromEntityList_AST;
		ASTPair.PutInstance(currentAST);
	}
	
	public void contractList() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = ASTPair.GetInstance();
		AST contractList_AST = null;
		
		contrExp();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		{    // ( ... )*
			for (;;)
			{
				if ((LA(1)==COMMA))
				{
					match(COMMA);
					contrExp();
					if (0 == inputState.guessing)
					{
						astFactory.addASTChild(currentAST, returnAST);
					}
				}
				else
				{
					goto _loop54_breakloop;
				}
				
			}
_loop54_breakloop:			;
		}    // ( ... )*
		if (0==inputState.guessing)
		{
			contractList_AST = (AST)currentAST.root;
			
								contractList_AST = (AST) astFactory.make(astFactory.create(CONTRACT_LIST,"contractList"), contractList_AST);
							
			currentAST.root = contractList_AST;
			if ( (null != contractList_AST) && (null != contractList_AST.getFirstChild()) )
				currentAST.child = contractList_AST.getFirstChild();
			else
				currentAST.child = contractList_AST;
			currentAST.advanceChildToEnd();
		}
		contractList_AST = currentAST.root;
		returnAST = contractList_AST;
		ASTPair.PutInstance(currentAST);
	}
	
	public void entityList() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = ASTPair.GetInstance();
		AST entityList_AST = null;
		
		entity();
		if (0 == inputState.guessing)
		{
			astFactory.addASTChild(currentAST, returnAST);
		}
		{    // ( ... )*
			for (;;)
			{
				if ((LA(1)==COMMA))
				{
					match(COMMA);
					entity();
					if (0 == inputState.guessing)
					{
						astFactory.addASTChild(currentAST, returnAST);
					}
				}
				else
				{
					goto _loop58_breakloop;
				}
				
			}
_loop58_breakloop:			;
		}    // ( ... )*
		if (0==inputState.guessing)
		{
			entityList_AST = (AST)currentAST.root;
			
								entityList_AST = (AST) astFactory.make(astFactory.create(ENTITY_LIST,"entityList"), entityList_AST);
							
			currentAST.root = entityList_AST;
			if ( (null != entityList_AST) && (null != entityList_AST.getFirstChild()) )
				currentAST.child = entityList_AST.getFirstChild();
			else
				currentAST.child = entityList_AST;
			currentAST.advanceChildToEnd();
		}
		entityList_AST = currentAST.root;
		returnAST = entityList_AST;
		ASTPair.PutInstance(currentAST);
	}
	
	public void entity() //throws RecognitionException, TokenStreamException
{
		
		returnAST = null;
		ASTPair currentAST = ASTPair.GetInstance();
		AST entity_AST = null;
		
		if ((LA(1)==IDENT) && (LA(2)==COMMA||LA(2)==LITERAL_require))
		{
			name();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			if (0==inputState.guessing)
			{
				entity_AST = (AST)currentAST.root;
				
									entity_AST = (AST) astFactory.make(astFactory.create(ENTITY,"entity"), entity_AST);
								
				currentAST.root = entity_AST;
				if ( (null != entity_AST) && (null != entity_AST.getFirstChild()) )
					currentAST.child = entity_AST.getFirstChild();
				else
					currentAST.child = entity_AST;
				currentAST.advanceChildToEnd();
			}
			entity_AST = currentAST.root;
		}
		else if ((LA(1)==IDENT) && (LA(2)==DOT)) {
			name();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			match(DOT);
			name();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			if (0==inputState.guessing)
			{
				entity_AST = (AST)currentAST.root;
				
									entity_AST = (AST) astFactory.make(astFactory.create(ENTITY_PARM,"entity parm"), entity_AST);
								
				currentAST.root = entity_AST;
				if ( (null != entity_AST) && (null != entity_AST.getFirstChild()) )
					currentAST.child = entity_AST.getFirstChild();
				else
					currentAST.child = entity_AST;
				currentAST.advanceChildToEnd();
			}
			entity_AST = currentAST.root;
		}
		else if ((LA(1)==LITERAL_result)) {
			match(LITERAL_result);
			match(LITERAL_of);
			name();
			if (0 == inputState.guessing)
			{
				astFactory.addASTChild(currentAST, returnAST);
			}
			if (0==inputState.guessing)
			{
				entity_AST = (AST)currentAST.root;
				
									entity_AST = (AST) astFactory.make(astFactory.create(ENTITY_RESULT_OF,"entity result of"), entity_AST);
								
				currentAST.root = entity_AST;
				if ( (null != entity_AST) && (null != entity_AST.getFirstChild()) )
					currentAST.child = entity_AST.getFirstChild();
				else
					currentAST.child = entity_AST;
				currentAST.advanceChildToEnd();
			}
			entity_AST = currentAST.root;
		}
		else
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		returnAST = entity_AST;
		ASTPair.PutInstance(currentAST);
	}
	
	private void initializeFactory()
	{
		if (astFactory == null)
		{
			astFactory = new ASTFactory();
		}
		initializeASTFactory( astFactory );
	}
	static public void initializeASTFactory( ASTFactory factory )
	{
		factory.setMaxNodeType(87);
	}
	
	public static readonly string[] tokenNames_ = new string[] {
		@"""<0>""",
		@"""EOF""",
		@"""<2>""",
		@"""NULL_TREE_LOOKAHEAD""",
		@"""DECLARATIONS""",
		@"""CONTRACT_TYPE_DECL""",
		@"""DIMENSION_DECL""",
		@"""INCREASING_ORDER_SEM""",
		@"""DECREASING_ORDER_SEM""",
		@"""ENUM_DEF""",
		@"""SET_DEF""",
		@"""NUMERIC_DEF""",
		@"""ORDER_DEF""",
		@"""ONE_ORDER""",
		@"""UNIT""",
		@"""CONTRACT_DECL""",
		@"""CONTRACT_EXP_CONTRACT""",
		@"""CONTRACT_EXP_REFINED_BY""",
		@"""SIMPLE_CONSTR""",
		@"""ASPECT_CONSTR""",
		@"""PERCENTILE_CONTR""",
		@"""FREQUENCY_CONTR""",
		@"""MEAN_CONTR""",
		@"""VARIANCE_CONTR""",
		@"""FREQ_RANGE""",
		@"""INCLUDE_BOUND""",
		@"""NOT_INCLUDE_BOUND""",
		@"""NAME_LIST""",
		@"""PROFILE_DECL""",
		@"""PROFILE_EXP_PROFILE""",
		@"""PROFILE_EXP_REFINED_BY""",
		@"""REQ_CLAUSE""",
		@"""CONTRACT_LIST""",
		@"""ENTITY_LIST""",
		@"""ENTITY""",
		@"""ENTITY_PARM""",
		@"""ENTITY_RESULT_OF""",
		@"""NUMOP_GTE""",
		@"""NUMOP_GTHAN""",
		@"""NUMOP_LTHAN""",
		@"""NUMOP_LTE""",
		@"""NUMOP_EQUAL""",
		@"""NAME""",
		@"""NUMBER""",
		@"""type""",
		@"""ASSIGN""",
		@"""contract""",
		@"""LCURLY""",
		@"""RCURLY""",
		@"""COLON""",
		@"""SEMI""",
		@"""increasing""",
		@"""decreasing""",
		@"""enum""",
		@"""with""",
		@"""set""",
		@"""order""",
		@"""COMMA""",
		@"""LTHAN""",
		@"""numeric""",
		@"""DIV""",
		@"""percentile""",
		@"""frequency""",
		@"""PERCENT""",
		@"""mean""",
		@"""variance""",
		@"""LBRACK""",
		@"""LPARAN""",
		@"""RPARAN""",
		@"""RBRACK""",
		@"""for""",
		@"""profile""",
		@"""require""",
		@"""from""",
		@"""DOT""",
		@"""result""",
		@"""of""",
		@"""IDENT""",
		@"""GTE""",
		@"""GTHAN""",
		@"""LTE""",
		@"""EQUAL""",
		@"""NUM""",
		@"""LETTER""",
		@"""DIGIT""",
		@"""white space""",
		@"""a comment""",
		@"""a comment"""
	};
	
	private static long[] mk_tokenSet_0_()
	{
		long[] data = { 288230376151711744L, 245760L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_0_ = new BitSet(mk_tokenSet_0_());
	private static long[] mk_tokenSet_1_()
	{
		long[] data = { 6917529027641081856L, 3L, 0L, 0L};
		return data;
	}
	public static readonly BitSet tokenSet_1_ = new BitSet(mk_tokenSet_1_());
	
}
}

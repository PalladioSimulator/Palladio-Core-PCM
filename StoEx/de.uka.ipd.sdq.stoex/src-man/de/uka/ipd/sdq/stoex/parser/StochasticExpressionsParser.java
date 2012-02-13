// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g 2012-02-13 18:32:22
  
	package de.uka.ipd.sdq.stoex.parser;
	import de.uka.ipd.sdq.stoex.*;
	import de.uka.ipd.sdq.probfunction.*;
	import java.util.ArrayList;
	import java.util.Collection;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class StochasticExpressionsParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "OR", "XOR", "GREATER", "LESS", "EQUAL", "NOTEQUAL", "GREATEREQUAL", "LESSEQUAL", "PLUS", "MINUS", "MUL", "DIV", "MOD", "POW", "NOT", "NUMBER", "STRING_LITERAL", "ID", "LPAREN", "RPAREN", "SQUARE_PAREN_L", "SQUARE_PAREN_R", "COLON", "INTPMF", "DOUBLEPMF", "ENUMPMF", "ORDERED_DEF", "DOUBLEPDF", "BOOLPMF", "SEMI", "FALSE", "TRUE", "BYTESIZE", "STRUCTURE", "NUMBER_OF_ELEMENTS", "TYPE", "VALUE", "DOT", "INNER", "UNIT", "BOOL", "DEFINITION", "DIGIT", "Exponent", "ALPHA", "WS", "COMMENT", "LINE_COMMENT", "'?'", "':'"
    };
    public static final int INNER=43;
    public static final int MOD=17;
    public static final int BOOLPMF=33;
    public static final int Exponent=48;
    public static final int GREATEREQUAL=11;
    public static final int ENUMPMF=30;
    public static final int NOT=19;
    public static final int AND=4;
    public static final int ID=22;
    public static final int EOF=-1;
    public static final int STRUCTURE=38;
    public static final int LPAREN=23;
    public static final int TYPE=40;
    public static final int NOTEQUAL=10;
    public static final int RPAREN=24;
    public static final int GREATER=7;
    public static final int STRING_LITERAL=21;
    public static final int POW=18;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int EQUAL=9;
    public static final int LESS=8;
    public static final int DEFINITION=46;
    public static final int PLUS=13;
    public static final int DIGIT=47;
    public static final int COMMENT=51;
    public static final int DOT=42;
    public static final int DOUBLEPDF=32;
    public static final int XOR=6;
    public static final int INTPMF=28;
    public static final int LINE_COMMENT=52;
    public static final int DOUBLEPMF=29;
    public static final int BOOL=45;
    public static final int NUMBER=20;
    public static final int NUMBER_OF_ELEMENTS=39;
    public static final int MINUS=14;
    public static final int VALUE=41;
    public static final int MUL=15;
    public static final int SEMI=34;
    public static final int TRUE=36;
    public static final int ALPHA=49;
    public static final int COLON=27;
    public static final int SQUARE_PAREN_R=26;
    public static final int UNIT=44;
    public static final int WS=50;
    public static final int SQUARE_PAREN_L=25;
    public static final int OR=5;
    public static final int BYTESIZE=37;
    public static final int DIV=16;
    public static final int ORDERED_DEF=31;
    public static final int FALSE=35;
    public static final int LESSEQUAL=12;

    // delegates
    // delegators


        public StochasticExpressionsParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public StochasticExpressionsParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return StochasticExpressionsParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g"; }



    // $ANTLR start "expression"
    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:17:1: expression returns [Expression exp] : c= ifelseExpr EOF ;
    public final Expression expression() throws RecognitionException {
        Expression exp = null;

        IfElse c = null;


        try {
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:18:3: (c= ifelseExpr EOF )
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:19:3: c= ifelseExpr EOF
            {
            pushFollow(FOLLOW_ifelseExpr_in_expression41);
            c=ifelseExpr();

            state._fsp--;

            match(input,EOF,FOLLOW_EOF_in_expression43); 
            exp = c;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return exp;
    }
    // $ANTLR end "expression"


    // $ANTLR start "ifelseExpr"
    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:22:1: ifelseExpr returns [IfElse ifelseExp] : cond= boolAndExpr ( '?' ifEx= boolAndExpr ':' elseEx= boolAndExpr )? ;
    public final IfElse ifelseExpr() throws RecognitionException {
        IfElse ifelseExp = null;

        BooleanExpression cond = null;

        BooleanExpression ifEx = null;

        BooleanExpression elseEx = null;


        try {
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:23:2: (cond= boolAndExpr ( '?' ifEx= boolAndExpr ':' elseEx= boolAndExpr )? )
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:24:2: cond= boolAndExpr ( '?' ifEx= boolAndExpr ':' elseEx= boolAndExpr )?
            {
            pushFollow(FOLLOW_boolAndExpr_in_ifelseExpr66);
            cond=boolAndExpr();

            state._fsp--;

            ifelseExp = cond;
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:25:3: ( '?' ifEx= boolAndExpr ':' elseEx= boolAndExpr )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==53) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:25:4: '?' ifEx= boolAndExpr ':' elseEx= boolAndExpr
                    {
                    IfElseExpression newIfelseExp = StoexFactory.eINSTANCE.createIfElseExpression();
                    		  newIfelseExp.setConditionExpression(cond);
                    match(input,53,FOLLOW_53_in_ifelseExpr79); 
                    pushFollow(FOLLOW_boolAndExpr_in_ifelseExpr85);
                    ifEx=boolAndExpr();

                    state._fsp--;

                    newIfelseExp.setIfExpression(ifEx);
                    match(input,54,FOLLOW_54_in_ifelseExpr89); 
                    pushFollow(FOLLOW_boolAndExpr_in_ifelseExpr95);
                    elseEx=boolAndExpr();

                    state._fsp--;

                    newIfelseExp.setElseExpression(elseEx);
                    		 ifelseExp = newIfelseExp;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ifelseExp;
    }
    // $ANTLR end "ifelseExpr"


    // $ANTLR start "boolAndExpr"
    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:31:1: boolAndExpr returns [BooleanExpression boolExp] : b1= boolOrExpr ( AND b2= boolOrExpr )* ;
    public final BooleanExpression boolAndExpr() throws RecognitionException {
        BooleanExpression boolExp = null;

        BooleanExpression b1 = null;

        BooleanExpression b2 = null;


        try {
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:32:2: (b1= boolOrExpr ( AND b2= boolOrExpr )* )
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:33:2: b1= boolOrExpr ( AND b2= boolOrExpr )*
            {
            pushFollow(FOLLOW_boolOrExpr_in_boolAndExpr120);
            b1=boolOrExpr();

            state._fsp--;

            boolExp = b1;
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:34:3: ( AND b2= boolOrExpr )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==AND) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:34:4: AND b2= boolOrExpr
            	    {
            	    BooleanOperatorExpression boolExprNew = StoexFactory.eINSTANCE.createBooleanOperatorExpression();
            	    match(input,AND,FOLLOW_AND_in_boolAndExpr131); 
            	    boolExprNew.setOperation(BooleanOperations.AND);
            	    pushFollow(FOLLOW_boolOrExpr_in_boolAndExpr142);
            	    b2=boolOrExpr();

            	    state._fsp--;

            	    boolExprNew.setLeft(b1); boolExprNew.setRight(b2); boolExp = boolExprNew;

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return boolExp;
    }
    // $ANTLR end "boolAndExpr"


    // $ANTLR start "boolOrExpr"
    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:39:1: boolOrExpr returns [BooleanExpression boolExp] : b1= compareExpr ( ( OR | XOR ) b2= compareExpr )* ;
    public final BooleanExpression boolOrExpr() throws RecognitionException {
        BooleanExpression boolExp = null;

        Comparison b1 = null;

        Comparison b2 = null;


        try {
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:40:2: (b1= compareExpr ( ( OR | XOR ) b2= compareExpr )* )
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:41:2: b1= compareExpr ( ( OR | XOR ) b2= compareExpr )*
            {
            pushFollow(FOLLOW_compareExpr_in_boolOrExpr169);
            b1=compareExpr();

            state._fsp--;

            boolExp = b1;
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:42:3: ( ( OR | XOR ) b2= compareExpr )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=OR && LA4_0<=XOR)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:42:5: ( OR | XOR ) b2= compareExpr
            	    {
            	    BooleanOperatorExpression boolExprNew = StoexFactory.eINSTANCE.createBooleanOperatorExpression();
            	    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:43:3: ( OR | XOR )
            	    int alt3=2;
            	    int LA3_0 = input.LA(1);

            	    if ( (LA3_0==OR) ) {
            	        alt3=1;
            	    }
            	    else if ( (LA3_0==XOR) ) {
            	        alt3=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 3, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt3) {
            	        case 1 :
            	            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:43:4: OR
            	            {
            	            match(input,OR,FOLLOW_OR_in_boolOrExpr182); 
            	            boolExprNew.setOperation(BooleanOperations.OR);

            	            }
            	            break;
            	        case 2 :
            	            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:44:4: XOR
            	            {
            	            match(input,XOR,FOLLOW_XOR_in_boolOrExpr190); 
            	            boolExprNew.setOperation(BooleanOperations.XOR);

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_compareExpr_in_boolOrExpr202);
            	    b2=compareExpr();

            	    state._fsp--;

            	    boolExprNew.setLeft(b1); boolExprNew.setRight(b2); boolExp = boolExprNew;

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return boolExp;
    }
    // $ANTLR end "boolOrExpr"


    // $ANTLR start "compareExpr"
    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:52:1: compareExpr returns [Comparison comp] : t1= sumExpr ( ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL ) t2= sumExpr )? ;
    public final Comparison compareExpr() throws RecognitionException {
        Comparison comp = null;

        Term t1 = null;

        Term t2 = null;


        try {
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:53:3: (t1= sumExpr ( ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL ) t2= sumExpr )? )
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:54:4: t1= sumExpr ( ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL ) t2= sumExpr )?
            {
            pushFollow(FOLLOW_sumExpr_in_compareExpr240);
            t1=sumExpr();

            state._fsp--;

            comp = t1;
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:54:30: ( ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL ) t2= sumExpr )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=GREATER && LA6_0<=LESSEQUAL)) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:55:5: ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL ) t2= sumExpr
                    {
                    CompareExpression compExp = StoexFactory.eINSTANCE.createCompareExpression();
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:56:5: ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL )
                    int alt5=6;
                    switch ( input.LA(1) ) {
                    case GREATER:
                        {
                        alt5=1;
                        }
                        break;
                    case LESS:
                        {
                        alt5=2;
                        }
                        break;
                    case EQUAL:
                        {
                        alt5=3;
                        }
                        break;
                    case NOTEQUAL:
                        {
                        alt5=4;
                        }
                        break;
                    case GREATEREQUAL:
                        {
                        alt5=5;
                        }
                        break;
                    case LESSEQUAL:
                        {
                        alt5=6;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 0, input);

                        throw nvae;
                    }

                    switch (alt5) {
                        case 1 :
                            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:56:6: GREATER
                            {
                            match(input,GREATER,FOLLOW_GREATER_in_compareExpr257); 
                            compExp.setOperation(CompareOperations.GREATER);

                            }
                            break;
                        case 2 :
                            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:57:6: LESS
                            {
                            match(input,LESS,FOLLOW_LESS_in_compareExpr267); 
                            compExp.setOperation(CompareOperations.LESS);

                            }
                            break;
                        case 3 :
                            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:58:6: EQUAL
                            {
                            match(input,EQUAL,FOLLOW_EQUAL_in_compareExpr277); 
                            compExp.setOperation(CompareOperations.EQUALS);

                            }
                            break;
                        case 4 :
                            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:59:6: NOTEQUAL
                            {
                            match(input,NOTEQUAL,FOLLOW_NOTEQUAL_in_compareExpr287); 
                            compExp.setOperation(CompareOperations.NOTEQUAL);

                            }
                            break;
                        case 5 :
                            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:60:6: GREATEREQUAL
                            {
                            match(input,GREATEREQUAL,FOLLOW_GREATEREQUAL_in_compareExpr297); 
                            compExp.setOperation(CompareOperations.GREATEREQUAL);

                            }
                            break;
                        case 6 :
                            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:61:6: LESSEQUAL
                            {
                            match(input,LESSEQUAL,FOLLOW_LESSEQUAL_in_compareExpr307); 
                            compExp.setOperation(CompareOperations.LESSEQUAL);

                            }
                            break;

                    }

                    pushFollow(FOLLOW_sumExpr_in_compareExpr322);
                    t2=sumExpr();

                    state._fsp--;

                    compExp.setLeft(t1); compExp.setRight(t2); comp=compExp;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return comp;
    }
    // $ANTLR end "compareExpr"


    // $ANTLR start "sumExpr"
    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:65:1: sumExpr returns [Term t] : p1= prodExpr ( ( PLUS | MINUS ) p2= prodExpr )? ;
    public final Term sumExpr() throws RecognitionException {
        Term t = null;

        Product p1 = null;

        Product p2 = null;


        try {
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:66:4: (p1= prodExpr ( ( PLUS | MINUS ) p2= prodExpr )? )
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:67:3: p1= prodExpr ( ( PLUS | MINUS ) p2= prodExpr )?
            {
            pushFollow(FOLLOW_prodExpr_in_sumExpr356);
            p1=prodExpr();

            state._fsp--;

            t = p1;
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:67:27: ( ( PLUS | MINUS ) p2= prodExpr )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=PLUS && LA8_0<=MINUS)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:68:7: ( PLUS | MINUS ) p2= prodExpr
                    {
                    TermExpression termExp = StoexFactory.eINSTANCE.createTermExpression();
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:69:7: ( PLUS | MINUS )
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==PLUS) ) {
                        alt7=1;
                    }
                    else if ( (LA7_0==MINUS) ) {
                        alt7=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 0, input);

                        throw nvae;
                    }
                    switch (alt7) {
                        case 1 :
                            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:69:8: PLUS
                            {
                            match(input,PLUS,FOLLOW_PLUS_in_sumExpr382); 
                            termExp.setOperation(TermOperations.ADD);

                            }
                            break;
                        case 2 :
                            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:70:7: MINUS
                            {
                            match(input,MINUS,FOLLOW_MINUS_in_sumExpr393); 
                            termExp.setOperation(TermOperations.SUB);

                            }
                            break;

                    }

                    pushFollow(FOLLOW_prodExpr_in_sumExpr409);
                    p2=prodExpr();

                    state._fsp--;

                    termExp.setLeft(t); termExp.setRight(p2); t = termExp;

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return t;
    }
    // $ANTLR end "sumExpr"


    // $ANTLR start "prodExpr"
    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:76:1: prodExpr returns [Product p] : pw1= powExpr ( ( MUL | DIV | MOD ) pw2= powExpr )* ;
    public final Product prodExpr() throws RecognitionException {
        Product p = null;

        Power pw1 = null;

        Power pw2 = null;


        try {
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:77:3: (pw1= powExpr ( ( MUL | DIV | MOD ) pw2= powExpr )* )
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:78:3: pw1= powExpr ( ( MUL | DIV | MOD ) pw2= powExpr )*
            {
            pushFollow(FOLLOW_powExpr_in_prodExpr454);
            pw1=powExpr();

            state._fsp--;

            p = pw1;
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:79:4: ( ( MUL | DIV | MOD ) pw2= powExpr )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=MUL && LA10_0<=MOD)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:80:4: ( MUL | DIV | MOD ) pw2= powExpr
            	    {
            	    ProductExpression prodExp = StoexFactory.eINSTANCE.createProductExpression();
            	    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:81:5: ( MUL | DIV | MOD )
            	    int alt9=3;
            	    switch ( input.LA(1) ) {
            	    case MUL:
            	        {
            	        alt9=1;
            	        }
            	        break;
            	    case DIV:
            	        {
            	        alt9=2;
            	        }
            	        break;
            	    case MOD:
            	        {
            	        alt9=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 9, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt9) {
            	        case 1 :
            	            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:81:6: MUL
            	            {
            	            match(input,MUL,FOLLOW_MUL_in_prodExpr474); 
            	            prodExp.setOperation(ProductOperations.MULT);

            	            }
            	            break;
            	        case 2 :
            	            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:82:6: DIV
            	            {
            	            match(input,DIV,FOLLOW_DIV_in_prodExpr485); 
            	            prodExp.setOperation(ProductOperations.DIV);

            	            }
            	            break;
            	        case 3 :
            	            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:83:6: MOD
            	            {
            	            match(input,MOD,FOLLOW_MOD_in_prodExpr496); 
            	            prodExp.setOperation(ProductOperations.MOD);

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_powExpr_in_prodExpr512);
            	    pw2=powExpr();

            	    state._fsp--;

            	    prodExp.setLeft(p); prodExp.setRight(pw2); p = prodExp;

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return p;
    }
    // $ANTLR end "prodExpr"


    // $ANTLR start "powExpr"
    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:89:1: powExpr returns [Power pw] : a1= unaryExpr ( POW a2= unaryExpr )? ;
    public final Power powExpr() throws RecognitionException {
        Power pw = null;

        Unary a1 = null;

        Unary a2 = null;


        try {
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:90:3: (a1= unaryExpr ( POW a2= unaryExpr )? )
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:91:3: a1= unaryExpr ( POW a2= unaryExpr )?
            {
            pushFollow(FOLLOW_unaryExpr_in_powExpr553);
            a1=unaryExpr();

            state._fsp--;

            pw = a1;
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:92:4: ( POW a2= unaryExpr )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==POW) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:92:5: POW a2= unaryExpr
                    {
                    match(input,POW,FOLLOW_POW_in_powExpr562); 
                    pushFollow(FOLLOW_unaryExpr_in_powExpr568);
                    a2=unaryExpr();

                    state._fsp--;

                    PowerExpression pwExp = StoexFactory.eINSTANCE.createPowerExpression();
                    					pwExp.setBase(a1); pwExp.setExponent(a2); pw = pwExp;
                    				

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return pw;
    }
    // $ANTLR end "powExpr"


    // $ANTLR start "unaryExpr"
    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:98:1: unaryExpr returns [Unary u] : ( MINUS uminus= unaryExpr | NOT unot= unaryExpr | a= atom );
    public final Unary unaryExpr() throws RecognitionException {
        Unary u = null;

        Unary uminus = null;

        Unary unot = null;

        Atom a = null;


        try {
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:98:29: ( MINUS uminus= unaryExpr | NOT unot= unaryExpr | a= atom )
            int alt12=3;
            switch ( input.LA(1) ) {
            case MINUS:
                {
                alt12=1;
                }
                break;
            case NOT:
                {
                alt12=2;
                }
                break;
            case NUMBER:
            case STRING_LITERAL:
            case ID:
            case LPAREN:
            case INTPMF:
            case DOUBLEPMF:
            case ENUMPMF:
            case DOUBLEPDF:
            case BOOLPMF:
            case FALSE:
            case TRUE:
                {
                alt12=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:100:5: MINUS uminus= unaryExpr
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_unaryExpr604); 
                    pushFollow(FOLLOW_unaryExpr_in_unaryExpr610);
                    uminus=unaryExpr();

                    state._fsp--;

                    NegativeExpression ne = StoexFactory.eINSTANCE.createNegativeExpression();
                    		  ne.setInner(uminus);
                    		  u = ne;

                    }
                    break;
                case 2 :
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:105:5: NOT unot= unaryExpr
                    {
                    match(input,NOT,FOLLOW_NOT_in_unaryExpr628); 
                    pushFollow(FOLLOW_unaryExpr_in_unaryExpr634);
                    unot=unaryExpr();

                    state._fsp--;

                    NotExpression no = StoexFactory.eINSTANCE.createNotExpression();
                    		  no.setInner(unot);
                    		  u = no;

                    }
                    break;
                case 3 :
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:110:5: a= atom
                    {
                    pushFollow(FOLLOW_atom_in_unaryExpr656);
                    a=atom();

                    state._fsp--;

                    u = a;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return u;
    }
    // $ANTLR end "unaryExpr"


    // $ANTLR start "atom"
    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:112:1: atom returns [Atom a] : (number= NUMBER ( unit )? | def= definition | sl= STRING_LITERAL | bl= boolean_keywords | id= scoped_id | fid= ID args= arguments | LPAREN inner= ifelseExpr RPAREN ) ;
    public final Atom atom() throws RecognitionException {
        Atom a = null;

        Token number=null;
        Token sl=null;
        Token fid=null;
        ProbabilityFunctionLiteral def = null;

        String bl = null;

        AbstractNamedReference id = null;

        Collection<Expression> args = null;

        IfElse inner = null;


        try {
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:113:3: ( (number= NUMBER ( unit )? | def= definition | sl= STRING_LITERAL | bl= boolean_keywords | id= scoped_id | fid= ID args= arguments | LPAREN inner= ifelseExpr RPAREN ) )
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:114:3: (number= NUMBER ( unit )? | def= definition | sl= STRING_LITERAL | bl= boolean_keywords | id= scoped_id | fid= ID args= arguments | LPAREN inner= ifelseExpr RPAREN )
            {
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:114:3: (number= NUMBER ( unit )? | def= definition | sl= STRING_LITERAL | bl= boolean_keywords | id= scoped_id | fid= ID args= arguments | LPAREN inner= ifelseExpr RPAREN )
            int alt14=7;
            switch ( input.LA(1) ) {
            case NUMBER:
                {
                alt14=1;
                }
                break;
            case INTPMF:
            case DOUBLEPMF:
            case ENUMPMF:
            case DOUBLEPDF:
            case BOOLPMF:
                {
                alt14=2;
                }
                break;
            case STRING_LITERAL:
                {
                alt14=3;
                }
                break;
            case FALSE:
            case TRUE:
                {
                alt14=4;
                }
                break;
            case ID:
                {
                int LA14_5 = input.LA(2);

                if ( (LA14_5==EOF||(LA14_5>=AND && LA14_5<=POW)||LA14_5==RPAREN||LA14_5==COLON||LA14_5==DOT||(LA14_5>=53 && LA14_5<=54)) ) {
                    alt14=5;
                }
                else if ( (LA14_5==LPAREN) ) {
                    alt14=6;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 5, input);

                    throw nvae;
                }
                }
                break;
            case LPAREN:
                {
                alt14=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:116:5: number= NUMBER ( unit )?
                    {
                    number=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_atom691); 
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:116:19: ( unit )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==SQUARE_PAREN_L) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:116:19: unit
                            {
                            pushFollow(FOLLOW_unit_in_atom693);
                            unit();

                            state._fsp--;


                            }
                            break;

                    }


                    				String value = number.getText();
                    				if (value.indexOf('.') < 0)
                    				{
                    					IntLiteral il = StoexFactory.eINSTANCE.createIntLiteral();
                    					il.setValue(Integer.parseInt(value));
                    					a = il;
                    				}
                    				else
                    				{
                    					DoubleLiteral dl = StoexFactory.eINSTANCE.createDoubleLiteral();
                    					dl.setValue(Double.parseDouble(value));
                    					a = dl;
                    				}
                    			

                    }
                    break;
                case 2 :
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:134:5: def= definition
                    {
                    pushFollow(FOLLOW_definition_in_atom720);
                    def=definition();

                    state._fsp--;

                    a=def;

                    }
                    break;
                case 3 :
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:138:5: sl= STRING_LITERAL
                    {
                    sl=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_atom745); 

                    		  	StringLiteral stringLiteral = StoexFactory.eINSTANCE.createStringLiteral();
                    		  	stringLiteral.setValue(sl.getText().replace("\"",""));
                    		  	a = stringLiteral;
                    		  

                    }
                    break;
                case 4 :
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:146:5: bl= boolean_keywords
                    {
                    pushFollow(FOLLOW_boolean_keywords_in_atom772);
                    bl=boolean_keywords();

                    state._fsp--;


                    		  	BoolLiteral boolLiteral = StoexFactory.eINSTANCE.createBoolLiteral();
                    	   		boolLiteral.setValue(bl.equals("true"));
                    	   		a = boolLiteral;
                    	   	  

                    }
                    break;
                case 5 :
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:154:5: id= scoped_id
                    {
                    pushFollow(FOLLOW_scoped_id_in_atom800);
                    id=scoped_id();

                    state._fsp--;

                     a = StoexFactory.eINSTANCE.createVariable();
                    		  	((Variable)a).setId_Variable(id);
                    		  

                    }
                    break;
                case 6 :
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:160:5: fid= ID args= arguments
                    {
                    fid=(Token)match(input,ID,FOLLOW_ID_in_atom827); 
                    FunctionLiteral flit = StoexFactory.eINSTANCE.createFunctionLiteral();
                    		  	    flit.setId(fid.getText());
                    pushFollow(FOLLOW_arguments_in_atom840);
                    args=arguments();

                    state._fsp--;

                    flit.getParameters_FunctionLiteral().addAll(args);
                    		  	a = flit;

                    }
                    break;
                case 7 :
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:167:5: LPAREN inner= ifelseExpr RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_atom865); 
                    pushFollow(FOLLOW_ifelseExpr_in_atom875);
                    inner=ifelseExpr();

                    state._fsp--;

                    match(input,RPAREN,FOLLOW_RPAREN_in_atom881); 

                    			Parenthesis paren = StoexFactory.eINSTANCE.createParenthesis();
                    			paren.setInnerExpression(inner);
                    			a = paren;
                    		  

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return a;
    }
    // $ANTLR end "atom"


    // $ANTLR start "unit"
    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:178:1: unit : SQUARE_PAREN_L unit_spec SQUARE_PAREN_R ;
    public final void unit() throws RecognitionException {
        try {
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:178:6: ( SQUARE_PAREN_L unit_spec SQUARE_PAREN_R )
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:178:8: SQUARE_PAREN_L unit_spec SQUARE_PAREN_R
            {
            match(input,SQUARE_PAREN_L,FOLLOW_SQUARE_PAREN_L_in_unit904); 
            pushFollow(FOLLOW_unit_spec_in_unit906);
            unit_spec();

            state._fsp--;

            match(input,SQUARE_PAREN_R,FOLLOW_SQUARE_PAREN_R_in_unit908); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "unit"


    // $ANTLR start "unit_spec_atom"
    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:182:1: unit_spec_atom : ( ID | ID POW NUMBER );
    public final void unit_spec_atom() throws RecognitionException {
        try {
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:183:2: ( ID | ID POW NUMBER )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==ID) ) {
                int LA15_1 = input.LA(2);

                if ( (LA15_1==POW) ) {
                    alt15=2;
                }
                else if ( (LA15_1==DIV||LA15_1==SQUARE_PAREN_R) ) {
                    alt15=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:183:4: ID
                    {
                    match(input,ID,FOLLOW_ID_in_unit_spec_atom920); 

                    }
                    break;
                case 2 :
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:183:9: ID POW NUMBER
                    {
                    match(input,ID,FOLLOW_ID_in_unit_spec_atom924); 
                    match(input,POW,FOLLOW_POW_in_unit_spec_atom926); 
                    match(input,NUMBER,FOLLOW_NUMBER_in_unit_spec_atom928); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "unit_spec_atom"


    // $ANTLR start "unit_spec"
    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:186:1: unit_spec : ( unit_spec_atom | unit_spec_atom DIV unit_spec );
    public final void unit_spec() throws RecognitionException {
        try {
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:187:2: ( unit_spec_atom | unit_spec_atom DIV unit_spec )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==ID) ) {
                switch ( input.LA(2) ) {
                case POW:
                    {
                    int LA16_2 = input.LA(3);

                    if ( (LA16_2==NUMBER) ) {
                        int LA16_5 = input.LA(4);

                        if ( (LA16_5==DIV) ) {
                            alt16=2;
                        }
                        else if ( (LA16_5==SQUARE_PAREN_R) ) {
                            alt16=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 16, 5, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 16, 2, input);

                        throw nvae;
                    }
                    }
                    break;
                case DIV:
                    {
                    alt16=2;
                    }
                    break;
                case SQUARE_PAREN_R:
                    {
                    alt16=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:187:4: unit_spec_atom
                    {
                    pushFollow(FOLLOW_unit_spec_atom_in_unit_spec940);
                    unit_spec_atom();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:187:22: unit_spec_atom DIV unit_spec
                    {
                    pushFollow(FOLLOW_unit_spec_atom_in_unit_spec945);
                    unit_spec_atom();

                    state._fsp--;

                    match(input,DIV,FOLLOW_DIV_in_unit_spec947); 
                    pushFollow(FOLLOW_unit_spec_in_unit_spec949);
                    unit_spec();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "unit_spec"


    // $ANTLR start "arguments"
    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:191:1: arguments returns [Collection<Expression> parameters] : LPAREN (paramList= expressionList )? RPAREN ;
    public final Collection<Expression> arguments() throws RecognitionException {
        Collection<Expression> parameters = null;

        Collection<Expression> paramList = null;


        parameters = new ArrayList<Expression>();
        try {
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:193:2: ( LPAREN (paramList= expressionList )? RPAREN )
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:194:2: LPAREN (paramList= expressionList )? RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_arguments983); 
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:194:19: (paramList= expressionList )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==MINUS||(LA17_0>=NOT && LA17_0<=LPAREN)||(LA17_0>=INTPMF && LA17_0<=ENUMPMF)||(LA17_0>=DOUBLEPDF && LA17_0<=BOOLPMF)||(LA17_0>=FALSE && LA17_0<=TRUE)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:194:19: paramList= expressionList
                    {
                    pushFollow(FOLLOW_expressionList_in_arguments989);
                    paramList=expressionList();

                    state._fsp--;


                    }
                    break;

            }

            parameters.addAll(paramList);
            match(input,RPAREN,FOLLOW_RPAREN_in_arguments994); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return parameters;
    }
    // $ANTLR end "arguments"


    // $ANTLR start "expressionList"
    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:197:1: expressionList returns [Collection<Expression> parameters] : p1= boolAndExpr ( COLON p2= boolAndExpr )* ;
    public final Collection<Expression> expressionList() throws RecognitionException {
        Collection<Expression> parameters = null;

        BooleanExpression p1 = null;

        BooleanExpression p2 = null;


        parameters = new ArrayList<Expression>();
        try {
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:199:2: (p1= boolAndExpr ( COLON p2= boolAndExpr )* )
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:200:7: p1= boolAndExpr ( COLON p2= boolAndExpr )*
            {
            pushFollow(FOLLOW_boolAndExpr_in_expressionList1032);
            p1=boolAndExpr();

            state._fsp--;

            parameters.add(p1);
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:200:46: ( COLON p2= boolAndExpr )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==COLON) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:200:47: COLON p2= boolAndExpr
            	    {
            	    match(input,COLON,FOLLOW_COLON_in_expressionList1037); 
            	    pushFollow(FOLLOW_boolAndExpr_in_expressionList1043);
            	    p2=boolAndExpr();

            	    state._fsp--;

            	    parameters.add(p2);

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return parameters;
    }
    // $ANTLR end "expressionList"


    // $ANTLR start "definition"
    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:203:1: definition returns [ProbabilityFunctionLiteral pfl] : ( INTPMF SQUARE_PAREN_L (isample= numeric_int_sample )+ SQUARE_PAREN_R ( unit )? | DOUBLEPMF SQUARE_PAREN_L (rsample= numeric_real_sample )+ SQUARE_PAREN_R ( unit )? | ENUMPMF ( LPAREN ORDERED_DEF RPAREN )? SQUARE_PAREN_L (ssample= stringsample )+ SQUARE_PAREN_R | DOUBLEPDF SQUARE_PAREN_L (pdf_sample= real_pdf_sample )+ SQUARE_PAREN_R ( unit )? | BOOLPMF ( LPAREN ORDERED_DEF RPAREN )? SQUARE_PAREN_L (ssample= boolsample )+ SQUARE_PAREN_R );
    public final ProbabilityFunctionLiteral definition() throws RecognitionException {
        ProbabilityFunctionLiteral pfl = null;

        Sample isample = null;

        Sample rsample = null;

        Sample ssample = null;

        ContinuousSample pdf_sample = null;


        pfl = StoexFactory.eINSTANCE.createProbabilityFunctionLiteral();
        	 ProbabilityFunction probFunction = null; 
        try {
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:205:46: ( INTPMF SQUARE_PAREN_L (isample= numeric_int_sample )+ SQUARE_PAREN_R ( unit )? | DOUBLEPMF SQUARE_PAREN_L (rsample= numeric_real_sample )+ SQUARE_PAREN_R ( unit )? | ENUMPMF ( LPAREN ORDERED_DEF RPAREN )? SQUARE_PAREN_L (ssample= stringsample )+ SQUARE_PAREN_R | DOUBLEPDF SQUARE_PAREN_L (pdf_sample= real_pdf_sample )+ SQUARE_PAREN_R ( unit )? | BOOLPMF ( LPAREN ORDERED_DEF RPAREN )? SQUARE_PAREN_L (ssample= boolsample )+ SQUARE_PAREN_R )
            int alt29=5;
            switch ( input.LA(1) ) {
            case INTPMF:
                {
                alt29=1;
                }
                break;
            case DOUBLEPMF:
                {
                alt29=2;
                }
                break;
            case ENUMPMF:
                {
                alt29=3;
                }
                break;
            case DOUBLEPDF:
                {
                alt29=4;
                }
                break;
            case BOOLPMF:
                {
                alt29=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:209:4: INTPMF SQUARE_PAREN_L (isample= numeric_int_sample )+ SQUARE_PAREN_R ( unit )?
                    {
                    match(input,INTPMF,FOLLOW_INTPMF_in_definition1090); 
                    probFunction = ProbfunctionFactory.eINSTANCE.createProbabilityMassFunction();
                    				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
                    match(input,SQUARE_PAREN_L,FOLLOW_SQUARE_PAREN_L_in_definition1101); 
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:213:5: (isample= numeric_int_sample )+
                    int cnt19=0;
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==LPAREN) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:214:7: isample= numeric_int_sample
                    	    {
                    	    pushFollow(FOLLOW_numeric_int_sample_in_definition1121);
                    	    isample=numeric_int_sample();

                    	    state._fsp--;

                    	    ((ProbabilityMassFunction)probFunction).getSamples().add(isample);

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt19 >= 1 ) break loop19;
                                EarlyExitException eee =
                                    new EarlyExitException(19, input);
                                throw eee;
                        }
                        cnt19++;
                    } while (true);

                    match(input,SQUARE_PAREN_R,FOLLOW_SQUARE_PAREN_R_in_definition1138); 
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:216:20: ( unit )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==SQUARE_PAREN_L) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:216:20: unit
                            {
                            pushFollow(FOLLOW_unit_in_definition1140);
                            unit();

                            state._fsp--;


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:218:5: DOUBLEPMF SQUARE_PAREN_L (rsample= numeric_real_sample )+ SQUARE_PAREN_R ( unit )?
                    {
                    match(input,DOUBLEPMF,FOLLOW_DOUBLEPMF_in_definition1153); 
                    probFunction = ProbfunctionFactory.eINSTANCE.createProbabilityMassFunction();
                    				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
                    match(input,SQUARE_PAREN_L,FOLLOW_SQUARE_PAREN_L_in_definition1166); 
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:222:5: (rsample= numeric_real_sample )+
                    int cnt21=0;
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==LPAREN) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:223:5: rsample= numeric_real_sample
                    	    {
                    	    pushFollow(FOLLOW_numeric_real_sample_in_definition1184);
                    	    rsample=numeric_real_sample();

                    	    state._fsp--;

                    	    ((ProbabilityMassFunction)probFunction).getSamples().add(rsample);

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt21 >= 1 ) break loop21;
                                EarlyExitException eee =
                                    new EarlyExitException(21, input);
                                throw eee;
                        }
                        cnt21++;
                    } while (true);

                    match(input,SQUARE_PAREN_R,FOLLOW_SQUARE_PAREN_R_in_definition1201); 
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:225:19: ( unit )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==SQUARE_PAREN_L) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:225:19: unit
                            {
                            pushFollow(FOLLOW_unit_in_definition1203);
                            unit();

                            state._fsp--;


                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:228:4: ENUMPMF ( LPAREN ORDERED_DEF RPAREN )? SQUARE_PAREN_L (ssample= stringsample )+ SQUARE_PAREN_R
                    {
                    match(input,ENUMPMF,FOLLOW_ENUMPMF_in_definition1218); 
                    probFunction = ProbfunctionFactory.eINSTANCE.createProbabilityMassFunction();
                    				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
                    				   ((ProbabilityMassFunction)probFunction).setOrderedDomain(false);
                    				   
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:233:4: ( LPAREN ORDERED_DEF RPAREN )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==LPAREN) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:233:5: LPAREN ORDERED_DEF RPAREN
                            {
                            match(input,LPAREN,FOLLOW_LPAREN_in_definition1231); 
                            match(input,ORDERED_DEF,FOLLOW_ORDERED_DEF_in_definition1238); 
                            ((ProbabilityMassFunction)probFunction).setOrderedDomain(true);
                            match(input,RPAREN,FOLLOW_RPAREN_in_definition1250); 

                            }
                            break;

                    }

                    match(input,SQUARE_PAREN_L,FOLLOW_SQUARE_PAREN_L_in_definition1257); 
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:238:5: (ssample= stringsample )+
                    int cnt24=0;
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==LPAREN) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:239:5: ssample= stringsample
                    	    {
                    	    pushFollow(FOLLOW_stringsample_in_definition1275);
                    	    ssample=stringsample();

                    	    state._fsp--;

                    	    ((ProbabilityMassFunction)probFunction).getSamples().add(ssample);

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt24 >= 1 ) break loop24;
                                EarlyExitException eee =
                                    new EarlyExitException(24, input);
                                throw eee;
                        }
                        cnt24++;
                    } while (true);

                    match(input,SQUARE_PAREN_R,FOLLOW_SQUARE_PAREN_R_in_definition1292); 

                    }
                    break;
                case 4 :
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:243:4: DOUBLEPDF SQUARE_PAREN_L (pdf_sample= real_pdf_sample )+ SQUARE_PAREN_R ( unit )?
                    {
                    match(input,DOUBLEPDF,FOLLOW_DOUBLEPDF_in_definition1302); 
                    probFunction = ProbfunctionFactory.eINSTANCE.createBoxedPDF();
                    				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
                    match(input,SQUARE_PAREN_L,FOLLOW_SQUARE_PAREN_L_in_definition1313); 
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:247:5: (pdf_sample= real_pdf_sample )+
                    int cnt25=0;
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==LPAREN) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:248:7: pdf_sample= real_pdf_sample
                    	    {
                    	    pushFollow(FOLLOW_real_pdf_sample_in_definition1333);
                    	    pdf_sample=real_pdf_sample();

                    	    state._fsp--;

                    	    ((BoxedPDF)probFunction).getSamples().add(pdf_sample);

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt25 >= 1 ) break loop25;
                                EarlyExitException eee =
                                    new EarlyExitException(25, input);
                                throw eee;
                        }
                        cnt25++;
                    } while (true);

                    match(input,SQUARE_PAREN_R,FOLLOW_SQUARE_PAREN_R_in_definition1350); 
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:250:20: ( unit )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==SQUARE_PAREN_L) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:250:20: unit
                            {
                            pushFollow(FOLLOW_unit_in_definition1352);
                            unit();

                            state._fsp--;


                            }
                            break;

                    }


                    }
                    break;
                case 5 :
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:252:4: BOOLPMF ( LPAREN ORDERED_DEF RPAREN )? SQUARE_PAREN_L (ssample= boolsample )+ SQUARE_PAREN_R
                    {
                    match(input,BOOLPMF,FOLLOW_BOOLPMF_in_definition1363); 
                    probFunction = ProbfunctionFactory.eINSTANCE.createProbabilityMassFunction();
                    				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
                    				   ((ProbabilityMassFunction)probFunction).setOrderedDomain(false);
                    				   
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:257:4: ( LPAREN ORDERED_DEF RPAREN )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==LPAREN) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:257:5: LPAREN ORDERED_DEF RPAREN
                            {
                            match(input,LPAREN,FOLLOW_LPAREN_in_definition1376); 
                            match(input,ORDERED_DEF,FOLLOW_ORDERED_DEF_in_definition1383); 
                            ((ProbabilityMassFunction)probFunction).setOrderedDomain(true);
                            match(input,RPAREN,FOLLOW_RPAREN_in_definition1395); 

                            }
                            break;

                    }

                    match(input,SQUARE_PAREN_L,FOLLOW_SQUARE_PAREN_L_in_definition1402); 
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:262:5: (ssample= boolsample )+
                    int cnt28=0;
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==LPAREN) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:263:5: ssample= boolsample
                    	    {
                    	    pushFollow(FOLLOW_boolsample_in_definition1420);
                    	    ssample=boolsample();

                    	    state._fsp--;

                    	    ((ProbabilityMassFunction)probFunction).getSamples().add(ssample);

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt28 >= 1 ) break loop28;
                                EarlyExitException eee =
                                    new EarlyExitException(28, input);
                                throw eee;
                        }
                        cnt28++;
                    } while (true);

                    match(input,SQUARE_PAREN_R,FOLLOW_SQUARE_PAREN_R_in_definition1437); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return pfl;
    }
    // $ANTLR end "definition"


    // $ANTLR start "numeric_int_sample"
    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:268:1: numeric_int_sample returns [Sample s] : LPAREN n= signed_number SEMI n2= NUMBER RPAREN ;
    public final Sample numeric_int_sample() throws RecognitionException {
        Sample s = null;

        Token n2=null;
        String n = null;


        s = null;
        try {
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:269:20: ( LPAREN n= signed_number SEMI n2= NUMBER RPAREN )
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:270:3: LPAREN n= signed_number SEMI n2= NUMBER RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_numeric_int_sample1463); 
            s = ProbfunctionFactory.eINSTANCE.createSample();
            pushFollow(FOLLOW_signed_number_in_numeric_int_sample1476);
            n=signed_number();

            state._fsp--;

            s.setValue(Integer.parseInt(n));
            match(input,SEMI,FOLLOW_SEMI_in_numeric_int_sample1487); 
            n2=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numeric_int_sample1495); 
            s.setProbability(Double.parseDouble(n2.getText()));
            match(input,RPAREN,FOLLOW_RPAREN_in_numeric_int_sample1507); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return s;
    }
    // $ANTLR end "numeric_int_sample"


    // $ANTLR start "numeric_real_sample"
    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:279:1: numeric_real_sample returns [Sample s] : LPAREN n= signed_number SEMI n2= NUMBER RPAREN ;
    public final Sample numeric_real_sample() throws RecognitionException {
        Sample s = null;

        Token n2=null;
        String n = null;


        s = null;
        try {
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:280:20: ( LPAREN n= signed_number SEMI n2= NUMBER RPAREN )
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:281:3: LPAREN n= signed_number SEMI n2= NUMBER RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_numeric_real_sample1530); 
            s = ProbfunctionFactory.eINSTANCE.createSample();
            pushFollow(FOLLOW_signed_number_in_numeric_real_sample1543);
            n=signed_number();

            state._fsp--;

            s.setValue(Double.parseDouble(n));
            match(input,SEMI,FOLLOW_SEMI_in_numeric_real_sample1554); 
            n2=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numeric_real_sample1562); 
            s.setProbability(Double.parseDouble(n2.getText()));
            match(input,RPAREN,FOLLOW_RPAREN_in_numeric_real_sample1574); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return s;
    }
    // $ANTLR end "numeric_real_sample"


    // $ANTLR start "real_pdf_sample"
    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:290:1: real_pdf_sample returns [ContinuousSample s] : LPAREN n= signed_number SEMI n2= NUMBER RPAREN ;
    public final ContinuousSample real_pdf_sample() throws RecognitionException {
        ContinuousSample s = null;

        Token n2=null;
        String n = null;


        s = null;
        try {
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:291:20: ( LPAREN n= signed_number SEMI n2= NUMBER RPAREN )
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:292:3: LPAREN n= signed_number SEMI n2= NUMBER RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_real_pdf_sample1598); 
            s = ProbfunctionFactory.eINSTANCE.createContinuousSample();
            pushFollow(FOLLOW_signed_number_in_real_pdf_sample1611);
            n=signed_number();

            state._fsp--;

            s.setValue(Double.parseDouble(n));
            match(input,SEMI,FOLLOW_SEMI_in_real_pdf_sample1622); 
            n2=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_real_pdf_sample1630); 
            s.setProbability(Double.parseDouble(n2.getText()));
            match(input,RPAREN,FOLLOW_RPAREN_in_real_pdf_sample1642); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return s;
    }
    // $ANTLR end "real_pdf_sample"


    // $ANTLR start "stringsample"
    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:301:1: stringsample returns [Sample s] : LPAREN str= STRING_LITERAL SEMI n= NUMBER RPAREN ;
    public final Sample stringsample() throws RecognitionException {
        Sample s = null;

        Token str=null;
        Token n=null;

        try {
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:302:3: ( LPAREN str= STRING_LITERAL SEMI n= NUMBER RPAREN )
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:303:3: LPAREN str= STRING_LITERAL SEMI n= NUMBER RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_stringsample1663); 
            s = ProbfunctionFactory.eINSTANCE.createSample();
            str=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_stringsample1675); 
            s.setValue(str.getText().replace("\"",""));
            match(input,SEMI,FOLLOW_SEMI_in_stringsample1686); 
            n=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_stringsample1692); 
            s.setProbability(Double.parseDouble(n.getText()));
            match(input,RPAREN,FOLLOW_RPAREN_in_stringsample1703); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return s;
    }
    // $ANTLR end "stringsample"


    // $ANTLR start "boolsample"
    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:312:1: boolsample returns [Sample s] : LPAREN str= boolean_keywords SEMI n= NUMBER RPAREN ;
    public final Sample boolsample() throws RecognitionException {
        Sample s = null;

        Token n=null;
        String str = null;


        try {
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:313:3: ( LPAREN str= boolean_keywords SEMI n= NUMBER RPAREN )
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:314:3: LPAREN str= boolean_keywords SEMI n= NUMBER RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_boolsample1721); 
            s = ProbfunctionFactory.eINSTANCE.createSample();
            pushFollow(FOLLOW_boolean_keywords_in_boolsample1735);
            str=boolean_keywords();

            state._fsp--;

            s.setValue(str.equals("true"));
            match(input,SEMI,FOLLOW_SEMI_in_boolsample1743); 
            n=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_boolsample1749); 
            s.setProbability(Double.parseDouble(n.getText()));
            match(input,RPAREN,FOLLOW_RPAREN_in_boolsample1760); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return s;
    }
    // $ANTLR end "boolsample"


    // $ANTLR start "boolean_keywords"
    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:323:1: boolean_keywords returns [String keyword] : ( FALSE | TRUE ) ;
    public final String boolean_keywords() throws RecognitionException {
        String keyword = null;

        try {
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:324:2: ( ( FALSE | TRUE ) )
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:325:3: ( FALSE | TRUE )
            {
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:325:3: ( FALSE | TRUE )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==FALSE) ) {
                alt30=1;
            }
            else if ( (LA30_0==TRUE) ) {
                alt30=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:326:3: FALSE
                    {
                    match(input,FALSE,FOLLOW_FALSE_in_boolean_keywords1779); 
                    keyword = "false";

                    }
                    break;
                case 2 :
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:329:3: TRUE
                    {
                    match(input,TRUE,FOLLOW_TRUE_in_boolean_keywords1793); 
                    keyword = "true"; 

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return keyword;
    }
    // $ANTLR end "boolean_keywords"


    // $ANTLR start "signed_number"
    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:333:1: signed_number returns [String stringValue] : ( MINUS )? n= NUMBER ;
    public final String signed_number() throws RecognitionException {
        String stringValue = null;

        Token n=null;

        stringValue = "";
        try {
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:335:1: ( ( MINUS )? n= NUMBER )
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:335:3: ( MINUS )? n= NUMBER
            {
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:335:3: ( MINUS )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==MINUS) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:335:4: MINUS
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_signed_number1820); 

                      stringValue +="-";


                    }
                    break;

            }

            n=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_signed_number1828); 

            stringValue += n.getText();


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return stringValue;
    }
    // $ANTLR end "signed_number"


    // $ANTLR start "characterisation_keywords"
    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:345:1: characterisation_keywords returns [String keyword] : ( BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE ) ;
    public final String characterisation_keywords() throws RecognitionException {
        String keyword = null;

        keyword = null;
        try {
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:346:24: ( ( BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE ) )
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:347:2: ( BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE )
            {
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:347:2: ( BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE )
            int alt32=5;
            switch ( input.LA(1) ) {
            case BYTESIZE:
                {
                alt32=1;
                }
                break;
            case STRUCTURE:
                {
                alt32=2;
                }
                break;
            case NUMBER_OF_ELEMENTS:
                {
                alt32=3;
                }
                break;
            case TYPE:
                {
                alt32=4;
                }
                break;
            case VALUE:
                {
                alt32=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:347:3: BYTESIZE
                    {
                    match(input,BYTESIZE,FOLLOW_BYTESIZE_in_characterisation_keywords1850); 
                    keyword="BYTESIZE";

                    }
                    break;
                case 2 :
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:348:4: STRUCTURE
                    {
                    match(input,STRUCTURE,FOLLOW_STRUCTURE_in_characterisation_keywords1857); 
                    keyword="STRUCTURE";

                    }
                    break;
                case 3 :
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:349:4: NUMBER_OF_ELEMENTS
                    {
                    match(input,NUMBER_OF_ELEMENTS,FOLLOW_NUMBER_OF_ELEMENTS_in_characterisation_keywords1864); 
                    keyword="NUMBER_OF_ELEMENTS";

                    }
                    break;
                case 4 :
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:350:4: TYPE
                    {
                    match(input,TYPE,FOLLOW_TYPE_in_characterisation_keywords1871); 
                    keyword="TYPE";

                    }
                    break;
                case 5 :
                    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:351:4: VALUE
                    {
                    match(input,VALUE,FOLLOW_VALUE_in_characterisation_keywords1878); 
                    keyword="VALUE";

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return keyword;
    }
    // $ANTLR end "characterisation_keywords"


    // $ANTLR start "scoped_id"
    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:354:1: scoped_id returns [AbstractNamedReference ref] : id1= ID ( DOT (id2= ID | INNER ) )* ;
    public final AbstractNamedReference scoped_id() throws RecognitionException {
        AbstractNamedReference ref = null;

        Token id1=null;
        Token id2=null;

        ref = null;
        		ArrayList<String> nameParts = new ArrayList<String>();
        try {
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:356:59: (id1= ID ( DOT (id2= ID | INNER ) )* )
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:358:2: id1= ID ( DOT (id2= ID | INNER ) )*
            {
            id1=(Token)match(input,ID,FOLLOW_ID_in_scoped_id1908); 
            nameParts.add(id1.getText());
            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:359:6: ( DOT (id2= ID | INNER ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==DOT) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:359:7: DOT (id2= ID | INNER )
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_scoped_id1919); 
            	    // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:359:11: (id2= ID | INNER )
            	    int alt33=2;
            	    int LA33_0 = input.LA(1);

            	    if ( (LA33_0==ID) ) {
            	        alt33=1;
            	    }
            	    else if ( (LA33_0==INNER) ) {
            	        alt33=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 33, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt33) {
            	        case 1 :
            	            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:359:12: id2= ID
            	            {
            	            id2=(Token)match(input,ID,FOLLOW_ID_in_scoped_id1924); 
            	            nameParts.add(id2.getText());

            	            }
            	            break;
            	        case 2 :
            	            // /Users/joerg/Documents/work/palladio-dev/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:359:53: INNER
            	            {
            	            match(input,INNER,FOLLOW_INNER_in_scoped_id1930); 
            	            nameParts.add("INNER");

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);


            	AbstractNamedReference firstNsRef=null;
            	NamespaceReference lastNsRef = null;
            	for (int i=0; i < nameParts.size()-1; i++)
            	{
            		NamespaceReference nsRef = StoexFactory.eINSTANCE.createNamespaceReference();
            		nsRef.setReferenceName(nameParts.get(i));
            		if (lastNsRef != null)
            			lastNsRef.setInnerReference_NamespaceReference(nsRef);
            		if (i == 0)
            		   	firstNsRef = nsRef;
            		lastNsRef = nsRef;
            	}
            	VariableReference varRef = StoexFactory.eINSTANCE.createVariableReference();
            	varRef.setReferenceName(nameParts.get(nameParts.size()-1));
            		if (lastNsRef != null) {
            			lastNsRef.setInnerReference_NamespaceReference(varRef);
            			ref = firstNsRef;
            		}
            		else
            			ref = varRef;
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ref;
    }
    // $ANTLR end "scoped_id"

    // Delegated rules


 

    public static final BitSet FOLLOW_ifelseExpr_in_expression41 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_expression43 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolAndExpr_in_ifelseExpr66 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_53_in_ifelseExpr79 = new BitSet(new long[]{0x0000001B70F84000L});
    public static final BitSet FOLLOW_boolAndExpr_in_ifelseExpr85 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_ifelseExpr89 = new BitSet(new long[]{0x0000001B70F84000L});
    public static final BitSet FOLLOW_boolAndExpr_in_ifelseExpr95 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolOrExpr_in_boolAndExpr120 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_AND_in_boolAndExpr131 = new BitSet(new long[]{0x0000001B70F84000L});
    public static final BitSet FOLLOW_boolOrExpr_in_boolAndExpr142 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_compareExpr_in_boolOrExpr169 = new BitSet(new long[]{0x0000000000000062L});
    public static final BitSet FOLLOW_OR_in_boolOrExpr182 = new BitSet(new long[]{0x0000001B70F84000L});
    public static final BitSet FOLLOW_XOR_in_boolOrExpr190 = new BitSet(new long[]{0x0000001B70F84000L});
    public static final BitSet FOLLOW_compareExpr_in_boolOrExpr202 = new BitSet(new long[]{0x0000000000000062L});
    public static final BitSet FOLLOW_sumExpr_in_compareExpr240 = new BitSet(new long[]{0x0000000000001F82L});
    public static final BitSet FOLLOW_GREATER_in_compareExpr257 = new BitSet(new long[]{0x0000001B70F84000L});
    public static final BitSet FOLLOW_LESS_in_compareExpr267 = new BitSet(new long[]{0x0000001B70F84000L});
    public static final BitSet FOLLOW_EQUAL_in_compareExpr277 = new BitSet(new long[]{0x0000001B70F84000L});
    public static final BitSet FOLLOW_NOTEQUAL_in_compareExpr287 = new BitSet(new long[]{0x0000001B70F84000L});
    public static final BitSet FOLLOW_GREATEREQUAL_in_compareExpr297 = new BitSet(new long[]{0x0000001B70F84000L});
    public static final BitSet FOLLOW_LESSEQUAL_in_compareExpr307 = new BitSet(new long[]{0x0000001B70F84000L});
    public static final BitSet FOLLOW_sumExpr_in_compareExpr322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_prodExpr_in_sumExpr356 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_PLUS_in_sumExpr382 = new BitSet(new long[]{0x0000001B70F84000L});
    public static final BitSet FOLLOW_MINUS_in_sumExpr393 = new BitSet(new long[]{0x0000001B70F84000L});
    public static final BitSet FOLLOW_prodExpr_in_sumExpr409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_powExpr_in_prodExpr454 = new BitSet(new long[]{0x0000000000038002L});
    public static final BitSet FOLLOW_MUL_in_prodExpr474 = new BitSet(new long[]{0x0000001B70F84000L});
    public static final BitSet FOLLOW_DIV_in_prodExpr485 = new BitSet(new long[]{0x0000001B70F84000L});
    public static final BitSet FOLLOW_MOD_in_prodExpr496 = new BitSet(new long[]{0x0000001B70F84000L});
    public static final BitSet FOLLOW_powExpr_in_prodExpr512 = new BitSet(new long[]{0x0000000000038002L});
    public static final BitSet FOLLOW_unaryExpr_in_powExpr553 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_POW_in_powExpr562 = new BitSet(new long[]{0x0000001B70F84000L});
    public static final BitSet FOLLOW_unaryExpr_in_powExpr568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_unaryExpr604 = new BitSet(new long[]{0x0000001B70F84000L});
    public static final BitSet FOLLOW_unaryExpr_in_unaryExpr610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_unaryExpr628 = new BitSet(new long[]{0x0000001B70F84000L});
    public static final BitSet FOLLOW_unaryExpr_in_unaryExpr634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_unaryExpr656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_atom691 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_unit_in_atom693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definition_in_atom720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_atom745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolean_keywords_in_atom772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scoped_id_in_atom800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_atom827 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_arguments_in_atom840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_atom865 = new BitSet(new long[]{0x0000001B70F84000L});
    public static final BitSet FOLLOW_ifelseExpr_in_atom875 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RPAREN_in_atom881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SQUARE_PAREN_L_in_unit904 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_unit_spec_in_unit906 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_R_in_unit908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_unit_spec_atom920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_unit_spec_atom924 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_POW_in_unit_spec_atom926 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_unit_spec_atom928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unit_spec_atom_in_unit_spec940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unit_spec_atom_in_unit_spec945 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_DIV_in_unit_spec947 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_unit_spec_in_unit_spec949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_arguments983 = new BitSet(new long[]{0x0000001B71F84000L});
    public static final BitSet FOLLOW_expressionList_in_arguments989 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RPAREN_in_arguments994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolAndExpr_in_expressionList1032 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_COLON_in_expressionList1037 = new BitSet(new long[]{0x0000001B70F84000L});
    public static final BitSet FOLLOW_boolAndExpr_in_expressionList1043 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_INTPMF_in_definition1090 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_L_in_definition1101 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_numeric_int_sample_in_definition1121 = new BitSet(new long[]{0x0000000004800000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_R_in_definition1138 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_unit_in_definition1140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLEPMF_in_definition1153 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_L_in_definition1166 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_numeric_real_sample_in_definition1184 = new BitSet(new long[]{0x0000000004800000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_R_in_definition1201 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_unit_in_definition1203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENUMPMF_in_definition1218 = new BitSet(new long[]{0x0000000002800000L});
    public static final BitSet FOLLOW_LPAREN_in_definition1231 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_ORDERED_DEF_in_definition1238 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RPAREN_in_definition1250 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_L_in_definition1257 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_stringsample_in_definition1275 = new BitSet(new long[]{0x0000000004800000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_R_in_definition1292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLEPDF_in_definition1302 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_L_in_definition1313 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_real_pdf_sample_in_definition1333 = new BitSet(new long[]{0x0000000004800000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_R_in_definition1350 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_unit_in_definition1352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLPMF_in_definition1363 = new BitSet(new long[]{0x0000000002800000L});
    public static final BitSet FOLLOW_LPAREN_in_definition1376 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_ORDERED_DEF_in_definition1383 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RPAREN_in_definition1395 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_L_in_definition1402 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_boolsample_in_definition1420 = new BitSet(new long[]{0x0000000004800000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_R_in_definition1437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_numeric_int_sample1463 = new BitSet(new long[]{0x0000000000104000L});
    public static final BitSet FOLLOW_signed_number_in_numeric_int_sample1476 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMI_in_numeric_int_sample1487 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_numeric_int_sample1495 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RPAREN_in_numeric_int_sample1507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_numeric_real_sample1530 = new BitSet(new long[]{0x0000000000104000L});
    public static final BitSet FOLLOW_signed_number_in_numeric_real_sample1543 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMI_in_numeric_real_sample1554 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_numeric_real_sample1562 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RPAREN_in_numeric_real_sample1574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_real_pdf_sample1598 = new BitSet(new long[]{0x0000000000104000L});
    public static final BitSet FOLLOW_signed_number_in_real_pdf_sample1611 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMI_in_real_pdf_sample1622 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_real_pdf_sample1630 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RPAREN_in_real_pdf_sample1642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_stringsample1663 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_stringsample1675 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMI_in_stringsample1686 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_stringsample1692 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RPAREN_in_stringsample1703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_boolsample1721 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_boolean_keywords_in_boolsample1735 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMI_in_boolsample1743 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_boolsample1749 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RPAREN_in_boolsample1760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_boolean_keywords1779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_boolean_keywords1793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_signed_number1820 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_signed_number1828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTESIZE_in_characterisation_keywords1850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRUCTURE_in_characterisation_keywords1857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_OF_ELEMENTS_in_characterisation_keywords1864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TYPE_in_characterisation_keywords1871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VALUE_in_characterisation_keywords1878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_scoped_id1908 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_DOT_in_scoped_id1919 = new BitSet(new long[]{0x0000080000400000L});
    public static final BitSet FOLLOW_ID_in_scoped_id1924 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_INNER_in_scoped_id1930 = new BitSet(new long[]{0x0000040000000002L});

}
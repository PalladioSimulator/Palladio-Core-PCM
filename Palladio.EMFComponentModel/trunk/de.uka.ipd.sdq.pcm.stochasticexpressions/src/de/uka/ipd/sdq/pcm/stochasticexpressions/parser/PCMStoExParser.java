// $ANTLR 3.0 C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g 2007-06-15 07:31:11
  
	package de.uka.ipd.sdq.pcm.stochasticexpressions.parser;
	import de.uka.ipd.sdq.stoex.*;
	import de.uka.ipd.sdq.probfunction.*;
	import de.uka.ipd.sdq.pcm.parameter.*;
	import java.util.ArrayList;
	import java.util.Collection;
	import de.uka.ipd.sdq.stoex.analyser.visitors.StoExPrettyPrintVisitor;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class PCMStoExParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "OR", "XOR", "GREATER", "LESS", "EQUAL", "NOTEQUAL", "GREATEREQUAL", "LESSEQUAL", "PLUS", "MINUS", "MUL", "DIV", "MOD", "POW", "NOT", "NUMBER", "STRING_LITERAL", "DOT", "ID", "LPAREN", "RPAREN", "COLON", "INTPMF", "SQUARE_PAREN_L", "SQUARE_PAREN_R", "DOUBLEPMF", "ENUMPMF", "SEMI", "ORDERED_DEF", "DOUBLEPDF", "BOOLPMF", "UNIT", "DEFINITION", "BOOL", "FALSE", "TRUE", "BYTESIZE", "STRUCTURE", "NUMBER_OF_ELEMENTS", "TYPE", "VALUE", "INNER", "DIGIT", "Exponent", "ALPHA", "WS", "COMMENT", "LINE_COMMENT"
    };
    public static final int INNER=46;
    public static final int MOD=17;
    public static final int BOOLPMF=35;
    public static final int Exponent=48;
    public static final int GREATEREQUAL=11;
    public static final int ENUMPMF=31;
    public static final int NOT=19;
    public static final int AND=4;
    public static final int ID=23;
    public static final int EOF=-1;
    public static final int STRUCTURE=42;
    public static final int LPAREN=24;
    public static final int TYPE=44;
    public static final int NOTEQUAL=10;
    public static final int RPAREN=25;
    public static final int GREATER=7;
    public static final int STRING_LITERAL=21;
    public static final int POW=18;
    public static final int EQUAL=9;
    public static final int LESS=8;
    public static final int DEFINITION=37;
    public static final int PLUS=13;
    public static final int DIGIT=47;
    public static final int COMMENT=51;
    public static final int DOT=22;
    public static final int DOUBLEPDF=34;
    public static final int XOR=6;
    public static final int INTPMF=27;
    public static final int LINE_COMMENT=52;
    public static final int DOUBLEPMF=30;
    public static final int NUMBER=20;
    public static final int BOOL=38;
    public static final int NUMBER_OF_ELEMENTS=43;
    public static final int VALUE=45;
    public static final int MINUS=14;
    public static final int MUL=15;
    public static final int SEMI=32;
    public static final int TRUE=40;
    public static final int ALPHA=49;
    public static final int COLON=26;
    public static final int SQUARE_PAREN_R=29;
    public static final int UNIT=36;
    public static final int WS=50;
    public static final int SQUARE_PAREN_L=28;
    public static final int OR=5;
    public static final int BYTESIZE=41;
    public static final int DIV=16;
    public static final int ORDERED_DEF=33;
    public static final int FALSE=39;
    public static final int LESSEQUAL=12;

        public PCMStoExParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g"; }



    // $ANTLR start expression
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:15:1: expression returns [Expression exp] : c= boolAndExpr EOF ;
    public final Expression expression() throws RecognitionException {
        Expression exp = null;

        BooleanExpression c = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:17:3: (c= boolAndExpr EOF )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:17:3: c= boolAndExpr EOF
            {
            pushFollow(FOLLOW_boolAndExpr_in_expression32);
            c=boolAndExpr();
            _fsp--;

            match(input,EOF,FOLLOW_EOF_in_expression34); 
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
    // $ANTLR end expression


    // $ANTLR start boolAndExpr
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:21:1: boolAndExpr returns [BooleanExpression boolExp] : b1= boolOrExpr ( AND b2= boolOrExpr )* ;
    public final BooleanExpression boolAndExpr() throws RecognitionException {
        BooleanExpression boolExp = null;

        BooleanExpression b1 = null;

        BooleanExpression b2 = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:23:2: (b1= boolOrExpr ( AND b2= boolOrExpr )* )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:23:2: b1= boolOrExpr ( AND b2= boolOrExpr )*
            {
            pushFollow(FOLLOW_boolOrExpr_in_boolAndExpr59);
            b1=boolOrExpr();
            _fsp--;

            boolExp = b1;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:24:3: ( AND b2= boolOrExpr )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==AND) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:24:4: AND b2= boolOrExpr
            	    {
            	    BooleanOperatorExpression boolExprNew = StoexFactory.eINSTANCE.createBooleanOperatorExpression();
            	    match(input,AND,FOLLOW_AND_in_boolAndExpr70); 
            	    boolExprNew.setOperation(BooleanOperations.AND);
            	    pushFollow(FOLLOW_boolOrExpr_in_boolAndExpr81);
            	    b2=boolOrExpr();
            	    _fsp--;

            	    boolExprNew.setLeft(b1); boolExprNew.setRight(b2); boolExp = boolExprNew;

            	    }
            	    break;

            	default :
            	    break loop1;
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
    // $ANTLR end boolAndExpr


    // $ANTLR start boolOrExpr
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:29:1: boolOrExpr returns [BooleanExpression boolExp] : b1= compareExpr ( ( OR | XOR ) b2= compareExpr )* ;
    public final BooleanExpression boolOrExpr() throws RecognitionException {
        BooleanExpression boolExp = null;

        Comparison b1 = null;

        Comparison b2 = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:31:2: (b1= compareExpr ( ( OR | XOR ) b2= compareExpr )* )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:31:2: b1= compareExpr ( ( OR | XOR ) b2= compareExpr )*
            {
            pushFollow(FOLLOW_compareExpr_in_boolOrExpr108);
            b1=compareExpr();
            _fsp--;

            boolExp = b1;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:32:3: ( ( OR | XOR ) b2= compareExpr )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=OR && LA3_0<=XOR)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:32:5: ( OR | XOR ) b2= compareExpr
            	    {
            	    BooleanOperatorExpression boolExprNew = StoexFactory.eINSTANCE.createBooleanOperatorExpression();
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:33:3: ( OR | XOR )
            	    int alt2=2;
            	    int LA2_0 = input.LA(1);

            	    if ( (LA2_0==OR) ) {
            	        alt2=1;
            	    }
            	    else if ( (LA2_0==XOR) ) {
            	        alt2=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("33:3: ( OR | XOR )", 2, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:33:4: OR
            	            {
            	            match(input,OR,FOLLOW_OR_in_boolOrExpr121); 
            	            boolExprNew.setOperation(BooleanOperations.OR);

            	            }
            	            break;
            	        case 2 :
            	            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:34:4: XOR
            	            {
            	            match(input,XOR,FOLLOW_XOR_in_boolOrExpr129); 
            	            boolExprNew.setOperation(BooleanOperations.XOR);

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_compareExpr_in_boolOrExpr141);
            	    b2=compareExpr();
            	    _fsp--;

            	    boolExprNew.setLeft(b1); boolExprNew.setRight(b2); boolExp = boolExprNew;

            	    }
            	    break;

            	default :
            	    break loop3;
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
    // $ANTLR end boolOrExpr


    // $ANTLR start compareExpr
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:42:1: compareExpr returns [Comparison comp] : t1= sumExpr ( ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL ) t2= sumExpr )? ;
    public final Comparison compareExpr() throws RecognitionException {
        Comparison comp = null;

        Term t1 = null;

        Term t2 = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:44:4: (t1= sumExpr ( ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL ) t2= sumExpr )? )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:44:4: t1= sumExpr ( ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL ) t2= sumExpr )?
            {
            pushFollow(FOLLOW_sumExpr_in_compareExpr179);
            t1=sumExpr();
            _fsp--;

            comp = t1;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:44:30: ( ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL ) t2= sumExpr )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=GREATER && LA5_0<=LESSEQUAL)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:45:5: ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL ) t2= sumExpr
                    {
                    CompareExpression compExp = StoexFactory.eINSTANCE.createCompareExpression();
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:46:5: ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL )
                    int alt4=6;
                    switch ( input.LA(1) ) {
                    case GREATER:
                        {
                        alt4=1;
                        }
                        break;
                    case LESS:
                        {
                        alt4=2;
                        }
                        break;
                    case EQUAL:
                        {
                        alt4=3;
                        }
                        break;
                    case NOTEQUAL:
                        {
                        alt4=4;
                        }
                        break;
                    case GREATEREQUAL:
                        {
                        alt4=5;
                        }
                        break;
                    case LESSEQUAL:
                        {
                        alt4=6;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("46:5: ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL )", 4, 0, input);

                        throw nvae;
                    }

                    switch (alt4) {
                        case 1 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:46:6: GREATER
                            {
                            match(input,GREATER,FOLLOW_GREATER_in_compareExpr196); 
                            compExp.setOperation(CompareOperations.GREATER);

                            }
                            break;
                        case 2 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:47:6: LESS
                            {
                            match(input,LESS,FOLLOW_LESS_in_compareExpr206); 
                            compExp.setOperation(CompareOperations.LESS);

                            }
                            break;
                        case 3 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:48:6: EQUAL
                            {
                            match(input,EQUAL,FOLLOW_EQUAL_in_compareExpr216); 
                            compExp.setOperation(CompareOperations.EQUALS);

                            }
                            break;
                        case 4 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:49:6: NOTEQUAL
                            {
                            match(input,NOTEQUAL,FOLLOW_NOTEQUAL_in_compareExpr226); 
                            compExp.setOperation(CompareOperations.NOTEQUAL);

                            }
                            break;
                        case 5 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:50:6: GREATEREQUAL
                            {
                            match(input,GREATEREQUAL,FOLLOW_GREATEREQUAL_in_compareExpr236); 
                            compExp.setOperation(CompareOperations.GREATEREQUAL);

                            }
                            break;
                        case 6 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:51:6: LESSEQUAL
                            {
                            match(input,LESSEQUAL,FOLLOW_LESSEQUAL_in_compareExpr246); 
                            compExp.setOperation(CompareOperations.LESSEQUAL);

                            }
                            break;

                    }

                    pushFollow(FOLLOW_sumExpr_in_compareExpr261);
                    t2=sumExpr();
                    _fsp--;

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
    // $ANTLR end compareExpr


    // $ANTLR start sumExpr
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:55:1: sumExpr returns [Term t] : p1= prodExpr ( ( PLUS | MINUS ) p2= prodExpr )* ;
    public final Term sumExpr() throws RecognitionException {
        Term t = null;

        Product p1 = null;

        Product p2 = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:57:2: (p1= prodExpr ( ( PLUS | MINUS ) p2= prodExpr )* )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:57:2: p1= prodExpr ( ( PLUS | MINUS ) p2= prodExpr )*
            {
            pushFollow(FOLLOW_prodExpr_in_sumExpr293);
            p1=prodExpr();
            _fsp--;

            t = p1;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:57:26: ( ( PLUS | MINUS ) p2= prodExpr )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=PLUS && LA7_0<=MINUS)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:58:4: ( PLUS | MINUS ) p2= prodExpr
            	    {
            	    TermExpression termExp = StoexFactory.eINSTANCE.createTermExpression();
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:59:4: ( PLUS | MINUS )
            	    int alt6=2;
            	    int LA6_0 = input.LA(1);

            	    if ( (LA6_0==PLUS) ) {
            	        alt6=1;
            	    }
            	    else if ( (LA6_0==MINUS) ) {
            	        alt6=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("59:4: ( PLUS | MINUS )", 6, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt6) {
            	        case 1 :
            	            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:59:5: PLUS
            	            {
            	            match(input,PLUS,FOLLOW_PLUS_in_sumExpr311); 
            	            termExp.setOperation(TermOperations.ADD);

            	            }
            	            break;
            	        case 2 :
            	            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:60:4: MINUS
            	            {
            	            match(input,MINUS,FOLLOW_MINUS_in_sumExpr319); 
            	            termExp.setOperation(TermOperations.SUB);

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_prodExpr_in_sumExpr333);
            	    p2=prodExpr();
            	    _fsp--;

            	    termExp.setLeft(t); termExp.setRight(p2); t = termExp;

            	    }
            	    break;

            	default :
            	    break loop7;
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
        return t;
    }
    // $ANTLR end sumExpr


    // $ANTLR start prodExpr
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:66:1: prodExpr returns [Product p] : pw1= powExpr ( ( MUL | DIV | MOD ) pw2= powExpr )* ;
    public final Product prodExpr() throws RecognitionException {
        Product p = null;

        Power pw1 = null;

        Power pw2 = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:68:3: (pw1= powExpr ( ( MUL | DIV | MOD ) pw2= powExpr )* )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:68:3: pw1= powExpr ( ( MUL | DIV | MOD ) pw2= powExpr )*
            {
            pushFollow(FOLLOW_powExpr_in_prodExpr371);
            pw1=powExpr();
            _fsp--;

            p = pw1;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:69:4: ( ( MUL | DIV | MOD ) pw2= powExpr )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=MUL && LA9_0<=MOD)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:70:4: ( MUL | DIV | MOD ) pw2= powExpr
            	    {
            	    ProductExpression prodExp = StoexFactory.eINSTANCE.createProductExpression();
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:71:5: ( MUL | DIV | MOD )
            	    int alt8=3;
            	    switch ( input.LA(1) ) {
            	    case MUL:
            	        {
            	        alt8=1;
            	        }
            	        break;
            	    case DIV:
            	        {
            	        alt8=2;
            	        }
            	        break;
            	    case MOD:
            	        {
            	        alt8=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("71:5: ( MUL | DIV | MOD )", 8, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt8) {
            	        case 1 :
            	            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:71:6: MUL
            	            {
            	            match(input,MUL,FOLLOW_MUL_in_prodExpr391); 
            	            prodExp.setOperation(ProductOperations.MULT);

            	            }
            	            break;
            	        case 2 :
            	            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:72:6: DIV
            	            {
            	            match(input,DIV,FOLLOW_DIV_in_prodExpr402); 
            	            prodExp.setOperation(ProductOperations.DIV);

            	            }
            	            break;
            	        case 3 :
            	            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:73:6: MOD
            	            {
            	            match(input,MOD,FOLLOW_MOD_in_prodExpr413); 
            	            prodExp.setOperation(ProductOperations.MOD);

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_powExpr_in_prodExpr429);
            	    pw2=powExpr();
            	    _fsp--;

            	    prodExp.setLeft(p); prodExp.setRight(pw2); p = prodExp;

            	    }
            	    break;

            	default :
            	    break loop9;
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
    // $ANTLR end prodExpr


    // $ANTLR start powExpr
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:79:1: powExpr returns [Power pw] : a1= unaryExpr ( POW a2= unaryExpr )? ;
    public final Power powExpr() throws RecognitionException {
        Power pw = null;

        Unary a1 = null;

        Unary a2 = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:81:3: (a1= unaryExpr ( POW a2= unaryExpr )? )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:81:3: a1= unaryExpr ( POW a2= unaryExpr )?
            {
            pushFollow(FOLLOW_unaryExpr_in_powExpr470);
            a1=unaryExpr();
            _fsp--;

            pw = a1;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:82:4: ( POW a2= unaryExpr )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==POW) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:82:5: POW a2= unaryExpr
                    {
                    match(input,POW,FOLLOW_POW_in_powExpr479); 
                    pushFollow(FOLLOW_unaryExpr_in_powExpr485);
                    a2=unaryExpr();
                    _fsp--;

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
    // $ANTLR end powExpr


    // $ANTLR start unaryExpr
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:88:1: unaryExpr returns [Unary u] : ( MINUS uminus= unaryExpr | NOT unot= unaryExpr | a= atom );
    public final Unary unaryExpr() throws RecognitionException {
        Unary u = null;

        Unary uminus = null;

        Unary unot = null;

        Atom a = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:90:5: ( MINUS uminus= unaryExpr | NOT unot= unaryExpr | a= atom )
            int alt11=3;
            switch ( input.LA(1) ) {
            case MINUS:
                {
                alt11=1;
                }
                break;
            case NOT:
                {
                alt11=2;
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
                alt11=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("88:1: unaryExpr returns [Unary u] : ( MINUS uminus= unaryExpr | NOT unot= unaryExpr | a= atom );", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:90:5: MINUS uminus= unaryExpr
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_unaryExpr521); 
                    pushFollow(FOLLOW_unaryExpr_in_unaryExpr527);
                    uminus=unaryExpr();
                    _fsp--;

                    NegativeExpression ne = StoexFactory.eINSTANCE.createNegativeExpression();
                    		  ne.setInner(uminus);
                    		  u = ne;

                    }
                    break;
                case 2 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:95:5: NOT unot= unaryExpr
                    {
                    match(input,NOT,FOLLOW_NOT_in_unaryExpr545); 
                    pushFollow(FOLLOW_unaryExpr_in_unaryExpr551);
                    unot=unaryExpr();
                    _fsp--;

                    NotExpression no = StoexFactory.eINSTANCE.createNotExpression();
                    		  no.setInner(unot);
                    		  u = no;

                    }
                    break;
                case 3 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:100:5: a= atom
                    {
                    pushFollow(FOLLOW_atom_in_unaryExpr573);
                    a=atom();
                    _fsp--;

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
    // $ANTLR end unaryExpr


    // $ANTLR start atom
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:102:1: atom returns [Atom a] : (number= NUMBER | def= definition | sl= STRING_LITERAL | bl= boolean_keywords | id= scoped_id DOT type= characterisation | fid= ID args= arguments | LPAREN inner= compareExpr RPAREN ) ;
    public final Atom atom() throws RecognitionException {
        Atom a = null;

        Token number=null;
        Token sl=null;
        Token fid=null;
        ProbabilityFunctionLiteral def = null;

        String bl = null;

        AbstractNamedReference id = null;

        VariableCharacterisationType type = null;

        Collection<Expression> args = null;

        Comparison inner = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:104:3: ( (number= NUMBER | def= definition | sl= STRING_LITERAL | bl= boolean_keywords | id= scoped_id DOT type= characterisation | fid= ID args= arguments | LPAREN inner= compareExpr RPAREN ) )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:104:3: (number= NUMBER | def= definition | sl= STRING_LITERAL | bl= boolean_keywords | id= scoped_id DOT type= characterisation | fid= ID args= arguments | LPAREN inner= compareExpr RPAREN )
            {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:104:3: (number= NUMBER | def= definition | sl= STRING_LITERAL | bl= boolean_keywords | id= scoped_id DOT type= characterisation | fid= ID args= arguments | LPAREN inner= compareExpr RPAREN )
            int alt12=7;
            switch ( input.LA(1) ) {
            case NUMBER:
                {
                alt12=1;
                }
                break;
            case INTPMF:
            case DOUBLEPMF:
            case ENUMPMF:
            case DOUBLEPDF:
            case BOOLPMF:
                {
                alt12=2;
                }
                break;
            case STRING_LITERAL:
                {
                alt12=3;
                }
                break;
            case FALSE:
            case TRUE:
                {
                alt12=4;
                }
                break;
            case ID:
                {
                int LA12_5 = input.LA(2);

                if ( (LA12_5==LPAREN) ) {
                    alt12=6;
                }
                else if ( (LA12_5==DOT) ) {
                    alt12=5;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("104:3: (number= NUMBER | def= definition | sl= STRING_LITERAL | bl= boolean_keywords | id= scoped_id DOT type= characterisation | fid= ID args= arguments | LPAREN inner= compareExpr RPAREN )", 12, 5, input);

                    throw nvae;
                }
                }
                break;
            case LPAREN:
                {
                alt12=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("104:3: (number= NUMBER | def= definition | sl= STRING_LITERAL | bl= boolean_keywords | id= scoped_id DOT type= characterisation | fid= ID args= arguments | LPAREN inner= compareExpr RPAREN )", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:106:5: number= NUMBER
                    {
                    number=(Token)input.LT(1);
                    match(input,NUMBER,FOLLOW_NUMBER_in_atom608); 
                    
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
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:124:5: def= definition
                    {
                    pushFollow(FOLLOW_definition_in_atom635);
                    def=definition();
                    _fsp--;

                    a=def;

                    }
                    break;
                case 3 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:128:5: sl= STRING_LITERAL
                    {
                    sl=(Token)input.LT(1);
                    match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_atom660); 
                    
                    		  	StringLiteral stringLiteral = StoexFactory.eINSTANCE.createStringLiteral();
                    		  	stringLiteral.setValue(sl.getText().replace("\"",""));
                    		  	a = stringLiteral;
                    		  

                    }
                    break;
                case 4 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:136:5: bl= boolean_keywords
                    {
                    pushFollow(FOLLOW_boolean_keywords_in_atom687);
                    bl=boolean_keywords();
                    _fsp--;

                    
                    		  	BoolLiteral boolLiteral = StoexFactory.eINSTANCE.createBoolLiteral();
                    	   		boolLiteral.setValue(bl.equals("true"));
                    	   		a = boolLiteral;
                    	   	  

                    }
                    break;
                case 5 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:144:5: id= scoped_id DOT type= characterisation
                    {
                    pushFollow(FOLLOW_scoped_id_in_atom715);
                    id=scoped_id();
                    _fsp--;

                    match(input,DOT,FOLLOW_DOT_in_atom717); 
                    pushFollow(FOLLOW_characterisation_in_atom723);
                    type=characterisation();
                    _fsp--;

                     a = ParameterFactory.eINSTANCE.createCharacterisedVariable();
                    		  	((CharacterisedVariable)a).setId_Variable(id);
                    		  	((CharacterisedVariable)a).setCharacterisationType(type);
                    		  

                    }
                    break;
                case 6 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:151:5: fid= ID args= arguments
                    {
                    fid=(Token)input.LT(1);
                    match(input,ID,FOLLOW_ID_in_atom750); 
                    FunctionLiteral flit = StoexFactory.eINSTANCE.createFunctionLiteral();
                    		  	    flit.setId(fid.getText());
                    pushFollow(FOLLOW_arguments_in_atom763);
                    args=arguments();
                    _fsp--;

                    flit.getParameters_FunctionLiteral().addAll(args);
                    		  	a = flit;

                    }
                    break;
                case 7 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:158:5: LPAREN inner= compareExpr RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_atom788); 
                    pushFollow(FOLLOW_compareExpr_in_atom798);
                    inner=compareExpr();
                    _fsp--;

                    match(input,RPAREN,FOLLOW_RPAREN_in_atom804); 
                    
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
    // $ANTLR end atom


    // $ANTLR start arguments
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:169:1: arguments returns [Collection<Expression> parameters] : LPAREN (paramList= expressionList )? RPAREN ;
    public final Collection<Expression> arguments() throws RecognitionException {
        Collection<Expression> parameters = null;

        Collection<Expression> paramList = null;


        parameters = new ArrayList<Expression>();
        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:172:2: ( LPAREN (paramList= expressionList )? RPAREN )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:172:2: LPAREN (paramList= expressionList )? RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_arguments850); 
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:172:19: (paramList= expressionList )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==MINUS||(LA13_0>=NOT && LA13_0<=STRING_LITERAL)||(LA13_0>=ID && LA13_0<=LPAREN)||LA13_0==INTPMF||(LA13_0>=DOUBLEPMF && LA13_0<=ENUMPMF)||(LA13_0>=DOUBLEPDF && LA13_0<=BOOLPMF)||(LA13_0>=FALSE && LA13_0<=TRUE)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:172:19: paramList= expressionList
                    {
                    pushFollow(FOLLOW_expressionList_in_arguments856);
                    paramList=expressionList();
                    _fsp--;


                    }
                    break;

            }

            parameters.addAll(paramList);
            match(input,RPAREN,FOLLOW_RPAREN_in_arguments861); 

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
    // $ANTLR end arguments


    // $ANTLR start expressionList
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:175:1: expressionList returns [Collection<Expression> parameters] : p1= boolAndExpr ( COLON p2= boolAndExpr )* ;
    public final Collection<Expression> expressionList() throws RecognitionException {
        Collection<Expression> parameters = null;

        BooleanExpression p1 = null;

        BooleanExpression p2 = null;


        parameters = new ArrayList<Expression>();
        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:178:7: (p1= boolAndExpr ( COLON p2= boolAndExpr )* )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:178:7: p1= boolAndExpr ( COLON p2= boolAndExpr )*
            {
            pushFollow(FOLLOW_boolAndExpr_in_expressionList899);
            p1=boolAndExpr();
            _fsp--;

            parameters.add(p1);
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:178:46: ( COLON p2= boolAndExpr )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==COLON) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:178:47: COLON p2= boolAndExpr
            	    {
            	    match(input,COLON,FOLLOW_COLON_in_expressionList904); 
            	    pushFollow(FOLLOW_boolAndExpr_in_expressionList910);
            	    p2=boolAndExpr();
            	    _fsp--;

            	    parameters.add(p2);

            	    }
            	    break;

            	default :
            	    break loop14;
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
    // $ANTLR end expressionList


    // $ANTLR start characterisation
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:181:1: characterisation returns [VariableCharacterisationType ct] : type= characterisation_keywords ;
    public final VariableCharacterisationType characterisation() throws RecognitionException {
        VariableCharacterisationType ct = null;

        String type = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:183:2: (type= characterisation_keywords )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:183:2: type= characterisation_keywords
            {
            pushFollow(FOLLOW_characterisation_keywords_in_characterisation943);
            type=characterisation_keywords();
            _fsp--;

            if(type.equals("TYPE"))
            		ct = VariableCharacterisationType.TYPE;
            	 else if(type.equals("BYTESIZE"))
            		ct = VariableCharacterisationType.BYTESIZE;
            	 else if(type.equals("NUMBER_OF_ELEMENTS"))
            		ct = VariableCharacterisationType.NUMBER_OF_ELEMENTS;
            	 else if(type.equals("VALUE"))
            		ct = VariableCharacterisationType.VALUE;
            	 else if(type.equals("STRUCTURE"))
            		ct = VariableCharacterisationType.STRUCTURE;
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ct;
    }
    // $ANTLR end characterisation


    // $ANTLR start definition
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:197:1: definition returns [ProbabilityFunctionLiteral pfl] : ( INTPMF ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (isample= numeric_int_sample )+ SQUARE_PAREN_R | DOUBLEPMF ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (rsample= numeric_real_sample )+ SQUARE_PAREN_R | ENUMPMF ( LPAREN (uunit= unit ) ( SEMI ORDERED_DEF ) RPAREN )? SQUARE_PAREN_L (ssample= stringsample )+ SQUARE_PAREN_R | DOUBLEPDF ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (pdf_sample= real_pdf_sample )+ SQUARE_PAREN_R | BOOLPMF ( LPAREN (uunit= bool_unit ) ( SEMI ORDERED_DEF )? RPAREN )? SQUARE_PAREN_L (ssample= boolsample )+ SQUARE_PAREN_R );
    public final ProbabilityFunctionLiteral definition() throws RecognitionException {
        ProbabilityFunctionLiteral pfl = null;

        Unit uunit = null;

        Sample isample = null;

        Sample rsample = null;

        Sample ssample = null;

        ContinuousSample pdf_sample = null;


        pfl = StoexFactory.eINSTANCE.createProbabilityFunctionLiteral();
        	 ProbabilityFunction probFunction = null; 
        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:203:4: ( INTPMF ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (isample= numeric_int_sample )+ SQUARE_PAREN_R | DOUBLEPMF ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (rsample= numeric_real_sample )+ SQUARE_PAREN_R | ENUMPMF ( LPAREN (uunit= unit ) ( SEMI ORDERED_DEF ) RPAREN )? SQUARE_PAREN_L (ssample= stringsample )+ SQUARE_PAREN_R | DOUBLEPDF ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (pdf_sample= real_pdf_sample )+ SQUARE_PAREN_R | BOOLPMF ( LPAREN (uunit= bool_unit ) ( SEMI ORDERED_DEF )? RPAREN )? SQUARE_PAREN_L (ssample= boolsample )+ SQUARE_PAREN_R )
            int alt26=5;
            switch ( input.LA(1) ) {
            case INTPMF:
                {
                alt26=1;
                }
                break;
            case DOUBLEPMF:
                {
                alt26=2;
                }
                break;
            case ENUMPMF:
                {
                alt26=3;
                }
                break;
            case DOUBLEPDF:
                {
                alt26=4;
                }
                break;
            case BOOLPMF:
                {
                alt26=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("197:1: definition returns [ProbabilityFunctionLiteral pfl] : ( INTPMF ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (isample= numeric_int_sample )+ SQUARE_PAREN_R | DOUBLEPMF ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (rsample= numeric_real_sample )+ SQUARE_PAREN_R | ENUMPMF ( LPAREN (uunit= unit ) ( SEMI ORDERED_DEF ) RPAREN )? SQUARE_PAREN_L (ssample= stringsample )+ SQUARE_PAREN_R | DOUBLEPDF ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (pdf_sample= real_pdf_sample )+ SQUARE_PAREN_R | BOOLPMF ( LPAREN (uunit= bool_unit ) ( SEMI ORDERED_DEF )? RPAREN )? SQUARE_PAREN_L (ssample= boolsample )+ SQUARE_PAREN_R );", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:203:4: INTPMF ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (isample= numeric_int_sample )+ SQUARE_PAREN_R
                    {
                    match(input,INTPMF,FOLLOW_INTPMF_in_definition980); 
                    probFunction = ProbfunctionFactory.eINSTANCE.createProbabilityMassFunction();
                    				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:206:4: ( LPAREN (uunit= unit ) RPAREN )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==LPAREN) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:206:5: LPAREN (uunit= unit ) RPAREN
                            {
                            match(input,LPAREN,FOLLOW_LPAREN_in_definition992); 
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:207:6: (uunit= unit )
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:208:6: uunit= unit
                            {
                            pushFollow(FOLLOW_unit_in_definition1010);
                            uunit=unit();
                            _fsp--;

                            probFunction.setUnit(uunit);

                            }

                            match(input,RPAREN,FOLLOW_RPAREN_in_definition1024); 

                            }
                            break;

                    }

                    match(input,SQUARE_PAREN_L,FOLLOW_SQUARE_PAREN_L_in_definition1031); 
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:212:5: (isample= numeric_int_sample )+
                    int cnt16=0;
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==LPAREN) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:213:7: isample= numeric_int_sample
                    	    {
                    	    pushFollow(FOLLOW_numeric_int_sample_in_definition1051);
                    	    isample=numeric_int_sample();
                    	    _fsp--;

                    	    ((ProbabilityMassFunction)probFunction).getSamples().add(isample);

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt16 >= 1 ) break loop16;
                                EarlyExitException eee =
                                    new EarlyExitException(16, input);
                                throw eee;
                        }
                        cnt16++;
                    } while (true);

                    match(input,SQUARE_PAREN_R,FOLLOW_SQUARE_PAREN_R_in_definition1068); 

                    }
                    break;
                case 2 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:217:5: DOUBLEPMF ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (rsample= numeric_real_sample )+ SQUARE_PAREN_R
                    {
                    match(input,DOUBLEPMF,FOLLOW_DOUBLEPMF_in_definition1081); 
                    probFunction = ProbfunctionFactory.eINSTANCE.createProbabilityMassFunction();
                    				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:220:4: ( LPAREN (uunit= unit ) RPAREN )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==LPAREN) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:220:5: LPAREN (uunit= unit ) RPAREN
                            {
                            match(input,LPAREN,FOLLOW_LPAREN_in_definition1094); 
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:221:6: (uunit= unit )
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:222:6: uunit= unit
                            {
                            pushFollow(FOLLOW_unit_in_definition1112);
                            uunit=unit();
                            _fsp--;

                            probFunction.setUnit(uunit);

                            }

                            match(input,RPAREN,FOLLOW_RPAREN_in_definition1126); 

                            }
                            break;

                    }

                    match(input,SQUARE_PAREN_L,FOLLOW_SQUARE_PAREN_L_in_definition1134); 
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:226:5: (rsample= numeric_real_sample )+
                    int cnt18=0;
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==LPAREN) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:227:5: rsample= numeric_real_sample
                    	    {
                    	    pushFollow(FOLLOW_numeric_real_sample_in_definition1152);
                    	    rsample=numeric_real_sample();
                    	    _fsp--;

                    	    ((ProbabilityMassFunction)probFunction).getSamples().add(rsample);

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt18 >= 1 ) break loop18;
                                EarlyExitException eee =
                                    new EarlyExitException(18, input);
                                throw eee;
                        }
                        cnt18++;
                    } while (true);

                    match(input,SQUARE_PAREN_R,FOLLOW_SQUARE_PAREN_R_in_definition1169); 

                    }
                    break;
                case 3 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:232:4: ENUMPMF ( LPAREN (uunit= unit ) ( SEMI ORDERED_DEF ) RPAREN )? SQUARE_PAREN_L (ssample= stringsample )+ SQUARE_PAREN_R
                    {
                    match(input,ENUMPMF,FOLLOW_ENUMPMF_in_definition1183); 
                    probFunction = ProbfunctionFactory.eINSTANCE.createProbabilityMassFunction();
                    				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
                    				   ((ProbabilityMassFunction)probFunction).setOrderedDomain(false);
                    				   
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:237:4: ( LPAREN (uunit= unit ) ( SEMI ORDERED_DEF ) RPAREN )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==LPAREN) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:237:5: LPAREN (uunit= unit ) ( SEMI ORDERED_DEF ) RPAREN
                            {
                            match(input,LPAREN,FOLLOW_LPAREN_in_definition1196); 
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:238:6: (uunit= unit )
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:239:6: uunit= unit
                            {
                            pushFollow(FOLLOW_unit_in_definition1214);
                            uunit=unit();
                            _fsp--;

                            probFunction.setUnit(uunit);

                            }

                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:241:6: ( SEMI ORDERED_DEF )
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:241:7: SEMI ORDERED_DEF
                            {
                            match(input,SEMI,FOLLOW_SEMI_in_definition1231); 
                            match(input,ORDERED_DEF,FOLLOW_ORDERED_DEF_in_definition1238); 
                            ((ProbabilityMassFunction)probFunction).setOrderedDomain(true);

                            }

                            match(input,RPAREN,FOLLOW_RPAREN_in_definition1257); 

                            }
                            break;

                    }

                    match(input,SQUARE_PAREN_L,FOLLOW_SQUARE_PAREN_L_in_definition1264); 
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:247:5: (ssample= stringsample )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==LPAREN) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:248:5: ssample= stringsample
                    	    {
                    	    pushFollow(FOLLOW_stringsample_in_definition1282);
                    	    ssample=stringsample();
                    	    _fsp--;

                    	    ((ProbabilityMassFunction)probFunction).getSamples().add(ssample);

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt20 >= 1 ) break loop20;
                                EarlyExitException eee =
                                    new EarlyExitException(20, input);
                                throw eee;
                        }
                        cnt20++;
                    } while (true);

                    match(input,SQUARE_PAREN_R,FOLLOW_SQUARE_PAREN_R_in_definition1299); 

                    }
                    break;
                case 4 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:252:4: DOUBLEPDF ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (pdf_sample= real_pdf_sample )+ SQUARE_PAREN_R
                    {
                    match(input,DOUBLEPDF,FOLLOW_DOUBLEPDF_in_definition1309); 
                    probFunction = ProbfunctionFactory.eINSTANCE.createBoxedPDF();
                    				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:255:4: ( LPAREN (uunit= unit ) RPAREN )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==LPAREN) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:255:5: LPAREN (uunit= unit ) RPAREN
                            {
                            match(input,LPAREN,FOLLOW_LPAREN_in_definition1321); 
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:256:6: (uunit= unit )
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:257:6: uunit= unit
                            {
                            pushFollow(FOLLOW_unit_in_definition1339);
                            uunit=unit();
                            _fsp--;

                            probFunction.setUnit(uunit);

                            }

                            match(input,RPAREN,FOLLOW_RPAREN_in_definition1353); 

                            }
                            break;

                    }

                    match(input,SQUARE_PAREN_L,FOLLOW_SQUARE_PAREN_L_in_definition1360); 
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:261:5: (pdf_sample= real_pdf_sample )+
                    int cnt22=0;
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==LPAREN) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:262:7: pdf_sample= real_pdf_sample
                    	    {
                    	    pushFollow(FOLLOW_real_pdf_sample_in_definition1380);
                    	    pdf_sample=real_pdf_sample();
                    	    _fsp--;

                    	    ((BoxedPDF)probFunction).getSamples().add(pdf_sample);

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt22 >= 1 ) break loop22;
                                EarlyExitException eee =
                                    new EarlyExitException(22, input);
                                throw eee;
                        }
                        cnt22++;
                    } while (true);

                    match(input,SQUARE_PAREN_R,FOLLOW_SQUARE_PAREN_R_in_definition1397); 

                    }
                    break;
                case 5 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:266:4: BOOLPMF ( LPAREN (uunit= bool_unit ) ( SEMI ORDERED_DEF )? RPAREN )? SQUARE_PAREN_L (ssample= boolsample )+ SQUARE_PAREN_R
                    {
                    match(input,BOOLPMF,FOLLOW_BOOLPMF_in_definition1408); 
                    probFunction = ProbfunctionFactory.eINSTANCE.createProbabilityMassFunction();
                    				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
                    				   ((ProbabilityMassFunction)probFunction).setOrderedDomain(false);
                    				   
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:271:4: ( LPAREN (uunit= bool_unit ) ( SEMI ORDERED_DEF )? RPAREN )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==LPAREN) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:271:5: LPAREN (uunit= bool_unit ) ( SEMI ORDERED_DEF )? RPAREN
                            {
                            match(input,LPAREN,FOLLOW_LPAREN_in_definition1421); 
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:272:6: (uunit= bool_unit )
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:273:6: uunit= bool_unit
                            {
                            pushFollow(FOLLOW_bool_unit_in_definition1439);
                            uunit=bool_unit();
                            _fsp--;

                            probFunction.setUnit(uunit);

                            }

                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:275:6: ( SEMI ORDERED_DEF )?
                            int alt23=2;
                            int LA23_0 = input.LA(1);

                            if ( (LA23_0==SEMI) ) {
                                alt23=1;
                            }
                            switch (alt23) {
                                case 1 :
                                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:275:7: SEMI ORDERED_DEF
                                    {
                                    match(input,SEMI,FOLLOW_SEMI_in_definition1456); 
                                    match(input,ORDERED_DEF,FOLLOW_ORDERED_DEF_in_definition1463); 
                                    ((ProbabilityMassFunction)probFunction).setOrderedDomain(true);

                                    }
                                    break;

                            }

                            match(input,RPAREN,FOLLOW_RPAREN_in_definition1483); 

                            }
                            break;

                    }

                    match(input,SQUARE_PAREN_L,FOLLOW_SQUARE_PAREN_L_in_definition1490); 
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:281:5: (ssample= boolsample )+
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
                    	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:282:5: ssample= boolsample
                    	    {
                    	    pushFollow(FOLLOW_boolsample_in_definition1508);
                    	    ssample=boolsample();
                    	    _fsp--;

                    	    ((ProbabilityMassFunction)probFunction).getSamples().add(ssample);

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

                    match(input,SQUARE_PAREN_R,FOLLOW_SQUARE_PAREN_R_in_definition1525); 

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
    // $ANTLR end definition


    // $ANTLR start unit
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:288:1: unit returns [Unit u] : UNIT DEFINITION str= STRING_LITERAL ;
    public final Unit unit() throws RecognitionException {
        Unit u = null;

        Token str=null;

        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:290:3: ( UNIT DEFINITION str= STRING_LITERAL )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:290:3: UNIT DEFINITION str= STRING_LITERAL
            {
            match(input,UNIT,FOLLOW_UNIT_in_unit1549); 
             u = ProbfunctionFactory.eINSTANCE.createUnit(); 
            match(input,DEFINITION,FOLLOW_DEFINITION_in_unit1559); 
            str=(Token)input.LT(1);
            match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_unit1566); 
            u.setUnitName(str.getText().replace("\"",""));

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
    // $ANTLR end unit


    // $ANTLR start bool_unit
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:296:1: bool_unit returns [Unit u] : UNIT EQUAL BOOL ;
    public final Unit bool_unit() throws RecognitionException {
        Unit u = null;

        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:298:3: ( UNIT EQUAL BOOL )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:298:3: UNIT EQUAL BOOL
            {
            match(input,UNIT,FOLLOW_UNIT_in_bool_unit1588); 
             u = ProbfunctionFactory.eINSTANCE.createUnit(); 
            match(input,EQUAL,FOLLOW_EQUAL_in_bool_unit1598); 
            match(input,BOOL,FOLLOW_BOOL_in_bool_unit1603); 
            u.setUnitName("bool");

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
    // $ANTLR end bool_unit


    // $ANTLR start numeric_int_sample
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:305:1: numeric_int_sample returns [Sample s] : LPAREN n= NUMBER SEMI n2= NUMBER RPAREN ;
    public final Sample numeric_int_sample() throws RecognitionException {
        Sample s = null;

        Token n=null;
        Token n2=null;

        s = null;
        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:307:3: ( LPAREN n= NUMBER SEMI n2= NUMBER RPAREN )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:307:3: LPAREN n= NUMBER SEMI n2= NUMBER RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_numeric_int_sample1631); 
            s = ProbfunctionFactory.eINSTANCE.createSample();
            n=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_numeric_int_sample1644); 
            s.setValue(Integer.parseInt(n.getText()));
            match(input,SEMI,FOLLOW_SEMI_in_numeric_int_sample1655); 
            n2=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_numeric_int_sample1663); 
            s.setProbability(Double.parseDouble(n2.getText()));
            match(input,RPAREN,FOLLOW_RPAREN_in_numeric_int_sample1675); 

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
    // $ANTLR end numeric_int_sample


    // $ANTLR start numeric_real_sample
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:316:1: numeric_real_sample returns [Sample s] : LPAREN n= NUMBER SEMI n2= NUMBER RPAREN ;
    public final Sample numeric_real_sample() throws RecognitionException {
        Sample s = null;

        Token n=null;
        Token n2=null;

        s = null;
        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:318:3: ( LPAREN n= NUMBER SEMI n2= NUMBER RPAREN )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:318:3: LPAREN n= NUMBER SEMI n2= NUMBER RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_numeric_real_sample1698); 
            s = ProbfunctionFactory.eINSTANCE.createSample();
            n=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_numeric_real_sample1711); 
            s.setValue(Double.parseDouble(n.getText()));
            match(input,SEMI,FOLLOW_SEMI_in_numeric_real_sample1722); 
            n2=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_numeric_real_sample1730); 
            s.setProbability(Double.parseDouble(n2.getText()));
            match(input,RPAREN,FOLLOW_RPAREN_in_numeric_real_sample1742); 

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
    // $ANTLR end numeric_real_sample


    // $ANTLR start real_pdf_sample
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:327:1: real_pdf_sample returns [ContinuousSample s] : LPAREN n= NUMBER SEMI n2= NUMBER RPAREN ;
    public final ContinuousSample real_pdf_sample() throws RecognitionException {
        ContinuousSample s = null;

        Token n=null;
        Token n2=null;

        s = null;
        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:329:3: ( LPAREN n= NUMBER SEMI n2= NUMBER RPAREN )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:329:3: LPAREN n= NUMBER SEMI n2= NUMBER RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_real_pdf_sample1766); 
            s = ProbfunctionFactory.eINSTANCE.createContinuousSample();
            n=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_real_pdf_sample1779); 
            s.setValue(Double.parseDouble(n.getText()));
            match(input,SEMI,FOLLOW_SEMI_in_real_pdf_sample1790); 
            n2=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_real_pdf_sample1798); 
            s.setProbability(Double.parseDouble(n2.getText()));
            match(input,RPAREN,FOLLOW_RPAREN_in_real_pdf_sample1810); 

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
    // $ANTLR end real_pdf_sample


    // $ANTLR start stringsample
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:338:1: stringsample returns [Sample s] : LPAREN str= STRING_LITERAL SEMI n= NUMBER RPAREN ;
    public final Sample stringsample() throws RecognitionException {
        Sample s = null;

        Token str=null;
        Token n=null;

        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:340:3: ( LPAREN str= STRING_LITERAL SEMI n= NUMBER RPAREN )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:340:3: LPAREN str= STRING_LITERAL SEMI n= NUMBER RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_stringsample1831); 
            s = ProbfunctionFactory.eINSTANCE.createSample();
            str=(Token)input.LT(1);
            match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_stringsample1843); 
            s.setValue(str.getText().replace("\"",""));
            match(input,SEMI,FOLLOW_SEMI_in_stringsample1854); 
            n=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_stringsample1860); 
            s.setProbability(Double.parseDouble(n.getText()));
            match(input,RPAREN,FOLLOW_RPAREN_in_stringsample1871); 

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
    // $ANTLR end stringsample


    // $ANTLR start boolsample
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:349:1: boolsample returns [Sample s] : LPAREN str= boolean_keywords SEMI n= NUMBER RPAREN ;
    public final Sample boolsample() throws RecognitionException {
        Sample s = null;

        Token n=null;
        String str = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:351:3: ( LPAREN str= boolean_keywords SEMI n= NUMBER RPAREN )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:351:3: LPAREN str= boolean_keywords SEMI n= NUMBER RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_boolsample1889); 
            s = ProbfunctionFactory.eINSTANCE.createSample();
            pushFollow(FOLLOW_boolean_keywords_in_boolsample1903);
            str=boolean_keywords();
            _fsp--;

            s.setValue(str);
            match(input,SEMI,FOLLOW_SEMI_in_boolsample1911); 
            n=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_boolsample1917); 
            s.setProbability(Double.parseDouble(n.getText()));
            match(input,RPAREN,FOLLOW_RPAREN_in_boolsample1928); 

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
    // $ANTLR end boolsample


    // $ANTLR start boolean_keywords
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:360:1: boolean_keywords returns [String keyword] : ( FALSE | TRUE ) ;
    public final String boolean_keywords() throws RecognitionException {
        String keyword = null;

        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:362:3: ( ( FALSE | TRUE ) )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:362:3: ( FALSE | TRUE )
            {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:362:3: ( FALSE | TRUE )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==FALSE) ) {
                alt27=1;
            }
            else if ( (LA27_0==TRUE) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("362:3: ( FALSE | TRUE )", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:363:3: FALSE
                    {
                    match(input,FALSE,FOLLOW_FALSE_in_boolean_keywords1947); 
                    keyword = "false";

                    }
                    break;
                case 2 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:366:3: TRUE
                    {
                    match(input,TRUE,FOLLOW_TRUE_in_boolean_keywords1961); 
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
    // $ANTLR end boolean_keywords


    // $ANTLR start characterisation_keywords
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:370:1: characterisation_keywords returns [String keyword] : ( BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE ) ;
    public final String characterisation_keywords() throws RecognitionException {
        String keyword = null;

        keyword = null;
        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:372:2: ( ( BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE ) )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:372:2: ( BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE )
            {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:372:2: ( BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE )
            int alt28=5;
            switch ( input.LA(1) ) {
            case BYTESIZE:
                {
                alt28=1;
                }
                break;
            case STRUCTURE:
                {
                alt28=2;
                }
                break;
            case NUMBER_OF_ELEMENTS:
                {
                alt28=3;
                }
                break;
            case TYPE:
                {
                alt28=4;
                }
                break;
            case VALUE:
                {
                alt28=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("372:2: ( BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE )", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:372:3: BYTESIZE
                    {
                    match(input,BYTESIZE,FOLLOW_BYTESIZE_in_characterisation_keywords1989); 
                    keyword="BYTESIZE";

                    }
                    break;
                case 2 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:373:4: STRUCTURE
                    {
                    match(input,STRUCTURE,FOLLOW_STRUCTURE_in_characterisation_keywords1996); 
                    keyword="STRUCTURE";

                    }
                    break;
                case 3 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:374:4: NUMBER_OF_ELEMENTS
                    {
                    match(input,NUMBER_OF_ELEMENTS,FOLLOW_NUMBER_OF_ELEMENTS_in_characterisation_keywords2003); 
                    keyword="NUMBER_OF_ELEMENTS";

                    }
                    break;
                case 4 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:375:4: TYPE
                    {
                    match(input,TYPE,FOLLOW_TYPE_in_characterisation_keywords2010); 
                    keyword="TYPE";

                    }
                    break;
                case 5 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:376:4: VALUE
                    {
                    match(input,VALUE,FOLLOW_VALUE_in_characterisation_keywords2017); 
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
    // $ANTLR end characterisation_keywords


    // $ANTLR start scoped_id
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:379:1: scoped_id returns [AbstractNamedReference ref] : id1= ID ( DOT (id2= ID | INNER ) )* ;
    public final AbstractNamedReference scoped_id() throws RecognitionException {
        AbstractNamedReference ref = null;

        Token id1=null;
        Token id2=null;

        ref = null;
        		ArrayList<String> nameParts = new ArrayList<String>();
        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:383:2: (id1= ID ( DOT (id2= ID | INNER ) )* )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:383:2: id1= ID ( DOT (id2= ID | INNER ) )*
            {
            id1=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_scoped_id2047); 
            nameParts.add(id1.getText());
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:384:6: ( DOT (id2= ID | INNER ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==DOT) ) {
                    int LA30_1 = input.LA(2);

                    if ( (LA30_1==ID||LA30_1==INNER) ) {
                        alt30=1;
                    }


                }


                switch (alt30) {
            	case 1 :
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:384:7: DOT (id2= ID | INNER )
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_scoped_id2058); 
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:384:11: (id2= ID | INNER )
            	    int alt29=2;
            	    int LA29_0 = input.LA(1);

            	    if ( (LA29_0==ID) ) {
            	        alt29=1;
            	    }
            	    else if ( (LA29_0==INNER) ) {
            	        alt29=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("384:11: (id2= ID | INNER )", 29, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt29) {
            	        case 1 :
            	            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:384:12: id2= ID
            	            {
            	            id2=(Token)input.LT(1);
            	            match(input,ID,FOLLOW_ID_in_scoped_id2063); 
            	            nameParts.add(id2.getText());

            	            }
            	            break;
            	        case 2 :
            	            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:384:53: INNER
            	            {
            	            match(input,INNER,FOLLOW_INNER_in_scoped_id2069); 
            	            nameParts.add("INNER");

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop30;
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
    // $ANTLR end scoped_id


 

    public static final BitSet FOLLOW_boolAndExpr_in_expression32 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_expression34 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolOrExpr_in_boolAndExpr59 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_AND_in_boolAndExpr70 = new BitSet(new long[]{0x0000018CC9B84000L});
    public static final BitSet FOLLOW_boolOrExpr_in_boolAndExpr81 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_compareExpr_in_boolOrExpr108 = new BitSet(new long[]{0x0000000000000062L});
    public static final BitSet FOLLOW_OR_in_boolOrExpr121 = new BitSet(new long[]{0x0000018CC9B84000L});
    public static final BitSet FOLLOW_XOR_in_boolOrExpr129 = new BitSet(new long[]{0x0000018CC9B84000L});
    public static final BitSet FOLLOW_compareExpr_in_boolOrExpr141 = new BitSet(new long[]{0x0000000000000062L});
    public static final BitSet FOLLOW_sumExpr_in_compareExpr179 = new BitSet(new long[]{0x0000000000001F82L});
    public static final BitSet FOLLOW_GREATER_in_compareExpr196 = new BitSet(new long[]{0x0000018CC9B84000L});
    public static final BitSet FOLLOW_LESS_in_compareExpr206 = new BitSet(new long[]{0x0000018CC9B84000L});
    public static final BitSet FOLLOW_EQUAL_in_compareExpr216 = new BitSet(new long[]{0x0000018CC9B84000L});
    public static final BitSet FOLLOW_NOTEQUAL_in_compareExpr226 = new BitSet(new long[]{0x0000018CC9B84000L});
    public static final BitSet FOLLOW_GREATEREQUAL_in_compareExpr236 = new BitSet(new long[]{0x0000018CC9B84000L});
    public static final BitSet FOLLOW_LESSEQUAL_in_compareExpr246 = new BitSet(new long[]{0x0000018CC9B84000L});
    public static final BitSet FOLLOW_sumExpr_in_compareExpr261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_prodExpr_in_sumExpr293 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_PLUS_in_sumExpr311 = new BitSet(new long[]{0x0000018CC9B84000L});
    public static final BitSet FOLLOW_MINUS_in_sumExpr319 = new BitSet(new long[]{0x0000018CC9B84000L});
    public static final BitSet FOLLOW_prodExpr_in_sumExpr333 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_powExpr_in_prodExpr371 = new BitSet(new long[]{0x0000000000038002L});
    public static final BitSet FOLLOW_MUL_in_prodExpr391 = new BitSet(new long[]{0x0000018CC9B84000L});
    public static final BitSet FOLLOW_DIV_in_prodExpr402 = new BitSet(new long[]{0x0000018CC9B84000L});
    public static final BitSet FOLLOW_MOD_in_prodExpr413 = new BitSet(new long[]{0x0000018CC9B84000L});
    public static final BitSet FOLLOW_powExpr_in_prodExpr429 = new BitSet(new long[]{0x0000000000038002L});
    public static final BitSet FOLLOW_unaryExpr_in_powExpr470 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_POW_in_powExpr479 = new BitSet(new long[]{0x0000018CC9B84000L});
    public static final BitSet FOLLOW_unaryExpr_in_powExpr485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_unaryExpr521 = new BitSet(new long[]{0x0000018CC9B84000L});
    public static final BitSet FOLLOW_unaryExpr_in_unaryExpr527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_unaryExpr545 = new BitSet(new long[]{0x0000018CC9B84000L});
    public static final BitSet FOLLOW_unaryExpr_in_unaryExpr551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_unaryExpr573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_atom608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definition_in_atom635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_atom660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolean_keywords_in_atom687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scoped_id_in_atom715 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_DOT_in_atom717 = new BitSet(new long[]{0x00003E0000000000L});
    public static final BitSet FOLLOW_characterisation_in_atom723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_atom750 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_arguments_in_atom763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_atom788 = new BitSet(new long[]{0x0000018CC9B84000L});
    public static final BitSet FOLLOW_compareExpr_in_atom798 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RPAREN_in_atom804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_arguments850 = new BitSet(new long[]{0x0000018CCBB84000L});
    public static final BitSet FOLLOW_expressionList_in_arguments856 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RPAREN_in_arguments861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolAndExpr_in_expressionList899 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_COLON_in_expressionList904 = new BitSet(new long[]{0x0000018CC9B84000L});
    public static final BitSet FOLLOW_boolAndExpr_in_expressionList910 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_characterisation_keywords_in_characterisation943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTPMF_in_definition980 = new BitSet(new long[]{0x0000000011000000L});
    public static final BitSet FOLLOW_LPAREN_in_definition992 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_unit_in_definition1010 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RPAREN_in_definition1024 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_L_in_definition1031 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_numeric_int_sample_in_definition1051 = new BitSet(new long[]{0x0000000021000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_R_in_definition1068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLEPMF_in_definition1081 = new BitSet(new long[]{0x0000000011000000L});
    public static final BitSet FOLLOW_LPAREN_in_definition1094 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_unit_in_definition1112 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RPAREN_in_definition1126 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_L_in_definition1134 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_numeric_real_sample_in_definition1152 = new BitSet(new long[]{0x0000000021000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_R_in_definition1169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENUMPMF_in_definition1183 = new BitSet(new long[]{0x0000000011000000L});
    public static final BitSet FOLLOW_LPAREN_in_definition1196 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_unit_in_definition1214 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_SEMI_in_definition1231 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_ORDERED_DEF_in_definition1238 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RPAREN_in_definition1257 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_L_in_definition1264 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_stringsample_in_definition1282 = new BitSet(new long[]{0x0000000021000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_R_in_definition1299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLEPDF_in_definition1309 = new BitSet(new long[]{0x0000000011000000L});
    public static final BitSet FOLLOW_LPAREN_in_definition1321 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_unit_in_definition1339 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RPAREN_in_definition1353 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_L_in_definition1360 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_real_pdf_sample_in_definition1380 = new BitSet(new long[]{0x0000000021000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_R_in_definition1397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLPMF_in_definition1408 = new BitSet(new long[]{0x0000000011000000L});
    public static final BitSet FOLLOW_LPAREN_in_definition1421 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_bool_unit_in_definition1439 = new BitSet(new long[]{0x0000000102000000L});
    public static final BitSet FOLLOW_SEMI_in_definition1456 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_ORDERED_DEF_in_definition1463 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RPAREN_in_definition1483 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_L_in_definition1490 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_boolsample_in_definition1508 = new BitSet(new long[]{0x0000000021000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_R_in_definition1525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNIT_in_unit1549 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_DEFINITION_in_unit1559 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_unit1566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNIT_in_bool_unit1588 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQUAL_in_bool_unit1598 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_BOOL_in_bool_unit1603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_numeric_int_sample1631 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_numeric_int_sample1644 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_SEMI_in_numeric_int_sample1655 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_numeric_int_sample1663 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RPAREN_in_numeric_int_sample1675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_numeric_real_sample1698 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_numeric_real_sample1711 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_SEMI_in_numeric_real_sample1722 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_numeric_real_sample1730 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RPAREN_in_numeric_real_sample1742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_real_pdf_sample1766 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_real_pdf_sample1779 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_SEMI_in_real_pdf_sample1790 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_real_pdf_sample1798 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RPAREN_in_real_pdf_sample1810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_stringsample1831 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_stringsample1843 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_SEMI_in_stringsample1854 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_stringsample1860 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RPAREN_in_stringsample1871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_boolsample1889 = new BitSet(new long[]{0x0000018000000000L});
    public static final BitSet FOLLOW_boolean_keywords_in_boolsample1903 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_SEMI_in_boolsample1911 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_boolsample1917 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RPAREN_in_boolsample1928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_boolean_keywords1947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_boolean_keywords1961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTESIZE_in_characterisation_keywords1989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRUCTURE_in_characterisation_keywords1996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_OF_ELEMENTS_in_characterisation_keywords2003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TYPE_in_characterisation_keywords2010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VALUE_in_characterisation_keywords2017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_scoped_id2047 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_DOT_in_scoped_id2058 = new BitSet(new long[]{0x0000400000800000L});
    public static final BitSet FOLLOW_ID_in_scoped_id2063 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_INNER_in_scoped_id2069 = new BitSet(new long[]{0x0000000000400002L});

}
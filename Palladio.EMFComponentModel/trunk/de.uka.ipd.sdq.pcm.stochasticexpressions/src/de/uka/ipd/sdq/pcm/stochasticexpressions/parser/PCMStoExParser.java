// $ANTLR 3.0 C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g 2007-06-14 21:42:20
  
	package de.uka.ipd.sdq.pcm.stochasticexpressions.parser;
	import de.uka.ipd.sdq.stoex.*;
	import de.uka.ipd.sdq.probfunction.*;
	import de.uka.ipd.sdq.pcm.parameter.*;
	import java.util.ArrayList;
	import de.uka.ipd.sdq.stoex.analyser.visitors.StoExPrettyPrintVisitor;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class PCMStoExParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "OR", "XOR", "GREATER", "LESS", "EQUAL", "NOTEQUAL", "GREATEREQUAL", "LESSEQUAL", "PLUS", "MINUS", "MUL", "DIV", "MOD", "POW", "NOT", "NUMBER", "DOT", "STRING_LITERAL", "LPAREN", "RPAREN", "INTPMF", "SQUARE_PAREN_L", "SQUARE_PAREN_R", "DOUBLEPMF", "ENUMPMF", "SEMI", "ORDERED_DEF", "DOUBLEPDF", "BOOLPMF", "UNIT", "DEFINITION", "BOOL", "FALSE", "TRUE", "BYTESIZE", "STRUCTURE", "NUMBER_OF_ELEMENTS", "TYPE", "VALUE", "ID", "INNER", "DIGIT", "Exponent", "ALPHA", "WS", "COMMENT", "LINE_COMMENT"
    };
    public static final int INNER=45;
    public static final int MOD=17;
    public static final int BOOLPMF=33;
    public static final int Exponent=47;
    public static final int GREATEREQUAL=11;
    public static final int ENUMPMF=29;
    public static final int NOT=19;
    public static final int ID=44;
    public static final int AND=4;
    public static final int EOF=-1;
    public static final int STRUCTURE=40;
    public static final int LPAREN=23;
    public static final int TYPE=42;
    public static final int NOTEQUAL=10;
    public static final int RPAREN=24;
    public static final int GREATER=7;
    public static final int STRING_LITERAL=22;
    public static final int POW=18;
    public static final int EQUAL=9;
    public static final int LESS=8;
    public static final int DEFINITION=35;
    public static final int PLUS=13;
    public static final int DIGIT=46;
    public static final int COMMENT=50;
    public static final int DOT=21;
    public static final int DOUBLEPDF=32;
    public static final int XOR=6;
    public static final int INTPMF=25;
    public static final int LINE_COMMENT=51;
    public static final int DOUBLEPMF=28;
    public static final int NUMBER=20;
    public static final int BOOL=36;
    public static final int NUMBER_OF_ELEMENTS=41;
    public static final int MINUS=14;
    public static final int VALUE=43;
    public static final int MUL=15;
    public static final int SEMI=30;
    public static final int TRUE=38;
    public static final int ALPHA=48;
    public static final int SQUARE_PAREN_R=27;
    public static final int UNIT=34;
    public static final int WS=49;
    public static final int SQUARE_PAREN_L=26;
    public static final int OR=5;
    public static final int BYTESIZE=39;
    public static final int DIV=16;
    public static final int ORDERED_DEF=31;
    public static final int FALSE=37;
    public static final int LESSEQUAL=12;

        public PCMStoExParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g"; }



    // $ANTLR start expression
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:14:1: expression returns [Expression exp] : c= boolAndExpr EOF ;
    public final Expression expression() throws RecognitionException {
        Expression exp = null;

        BooleanExpression c = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:16:3: (c= boolAndExpr EOF )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:16:3: c= boolAndExpr EOF
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:20:1: boolAndExpr returns [BooleanExpression boolExp] : b1= boolOrExpr ( AND b2= boolOrExpr )* ;
    public final BooleanExpression boolAndExpr() throws RecognitionException {
        BooleanExpression boolExp = null;

        BooleanExpression b1 = null;

        BooleanExpression b2 = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:22:2: (b1= boolOrExpr ( AND b2= boolOrExpr )* )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:22:2: b1= boolOrExpr ( AND b2= boolOrExpr )*
            {
            pushFollow(FOLLOW_boolOrExpr_in_boolAndExpr59);
            b1=boolOrExpr();
            _fsp--;

            boolExp = b1;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:23:3: ( AND b2= boolOrExpr )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==AND) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:23:4: AND b2= boolOrExpr
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:28:1: boolOrExpr returns [BooleanExpression boolExp] : b1= compareExpr ( ( OR | XOR ) b2= compareExpr )* ;
    public final BooleanExpression boolOrExpr() throws RecognitionException {
        BooleanExpression boolExp = null;

        Comparison b1 = null;

        Comparison b2 = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:30:2: (b1= compareExpr ( ( OR | XOR ) b2= compareExpr )* )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:30:2: b1= compareExpr ( ( OR | XOR ) b2= compareExpr )*
            {
            pushFollow(FOLLOW_compareExpr_in_boolOrExpr108);
            b1=compareExpr();
            _fsp--;

            boolExp = b1;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:31:3: ( ( OR | XOR ) b2= compareExpr )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=OR && LA3_0<=XOR)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:31:5: ( OR | XOR ) b2= compareExpr
            	    {
            	    BooleanOperatorExpression boolExprNew = StoexFactory.eINSTANCE.createBooleanOperatorExpression();
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:32:3: ( OR | XOR )
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
            	            new NoViableAltException("32:3: ( OR | XOR )", 2, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:32:4: OR
            	            {
            	            match(input,OR,FOLLOW_OR_in_boolOrExpr121); 
            	            boolExprNew.setOperation(BooleanOperations.OR);

            	            }
            	            break;
            	        case 2 :
            	            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:33:4: XOR
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:41:1: compareExpr returns [Comparison comp] : t1= sumExpr ( ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL ) t2= sumExpr )? ;
    public final Comparison compareExpr() throws RecognitionException {
        Comparison comp = null;

        Term t1 = null;

        Term t2 = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:43:4: (t1= sumExpr ( ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL ) t2= sumExpr )? )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:43:4: t1= sumExpr ( ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL ) t2= sumExpr )?
            {
            pushFollow(FOLLOW_sumExpr_in_compareExpr179);
            t1=sumExpr();
            _fsp--;

            comp = t1;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:43:30: ( ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL ) t2= sumExpr )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=GREATER && LA5_0<=LESSEQUAL)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:44:5: ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL ) t2= sumExpr
                    {
                    CompareExpression compExp = StoexFactory.eINSTANCE.createCompareExpression();
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:45:5: ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL )
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
                            new NoViableAltException("45:5: ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL )", 4, 0, input);

                        throw nvae;
                    }

                    switch (alt4) {
                        case 1 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:45:6: GREATER
                            {
                            match(input,GREATER,FOLLOW_GREATER_in_compareExpr196); 
                            compExp.setOperation(CompareOperations.GREATER);

                            }
                            break;
                        case 2 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:46:6: LESS
                            {
                            match(input,LESS,FOLLOW_LESS_in_compareExpr206); 
                            compExp.setOperation(CompareOperations.LESS);

                            }
                            break;
                        case 3 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:47:6: EQUAL
                            {
                            match(input,EQUAL,FOLLOW_EQUAL_in_compareExpr216); 
                            compExp.setOperation(CompareOperations.EQUALS);

                            }
                            break;
                        case 4 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:48:6: NOTEQUAL
                            {
                            match(input,NOTEQUAL,FOLLOW_NOTEQUAL_in_compareExpr226); 
                            compExp.setOperation(CompareOperations.NOTEQUAL);

                            }
                            break;
                        case 5 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:49:6: GREATEREQUAL
                            {
                            match(input,GREATEREQUAL,FOLLOW_GREATEREQUAL_in_compareExpr236); 
                            compExp.setOperation(CompareOperations.GREATEREQUAL);

                            }
                            break;
                        case 6 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:50:6: LESSEQUAL
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:54:1: sumExpr returns [Term t] : p1= prodExpr ( ( PLUS | MINUS ) p2= prodExpr )* ;
    public final Term sumExpr() throws RecognitionException {
        Term t = null;

        Product p1 = null;

        Product p2 = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:56:2: (p1= prodExpr ( ( PLUS | MINUS ) p2= prodExpr )* )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:56:2: p1= prodExpr ( ( PLUS | MINUS ) p2= prodExpr )*
            {
            pushFollow(FOLLOW_prodExpr_in_sumExpr293);
            p1=prodExpr();
            _fsp--;

            t = p1;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:56:26: ( ( PLUS | MINUS ) p2= prodExpr )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=PLUS && LA7_0<=MINUS)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:57:4: ( PLUS | MINUS ) p2= prodExpr
            	    {
            	    TermExpression termExp = StoexFactory.eINSTANCE.createTermExpression();
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:58:4: ( PLUS | MINUS )
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
            	            new NoViableAltException("58:4: ( PLUS | MINUS )", 6, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt6) {
            	        case 1 :
            	            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:58:5: PLUS
            	            {
            	            match(input,PLUS,FOLLOW_PLUS_in_sumExpr311); 
            	            termExp.setOperation(TermOperations.ADD);

            	            }
            	            break;
            	        case 2 :
            	            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:59:4: MINUS
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:65:1: prodExpr returns [Product p] : pw1= powExpr ( ( MUL | DIV | MOD ) pw2= powExpr )* ;
    public final Product prodExpr() throws RecognitionException {
        Product p = null;

        Power pw1 = null;

        Power pw2 = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:67:3: (pw1= powExpr ( ( MUL | DIV | MOD ) pw2= powExpr )* )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:67:3: pw1= powExpr ( ( MUL | DIV | MOD ) pw2= powExpr )*
            {
            pushFollow(FOLLOW_powExpr_in_prodExpr371);
            pw1=powExpr();
            _fsp--;

            p = pw1;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:68:4: ( ( MUL | DIV | MOD ) pw2= powExpr )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=MUL && LA9_0<=MOD)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:69:4: ( MUL | DIV | MOD ) pw2= powExpr
            	    {
            	    ProductExpression prodExp = StoexFactory.eINSTANCE.createProductExpression();
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:70:5: ( MUL | DIV | MOD )
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
            	            new NoViableAltException("70:5: ( MUL | DIV | MOD )", 8, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt8) {
            	        case 1 :
            	            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:70:6: MUL
            	            {
            	            match(input,MUL,FOLLOW_MUL_in_prodExpr391); 
            	            prodExp.setOperation(ProductOperations.MULT);

            	            }
            	            break;
            	        case 2 :
            	            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:71:6: DIV
            	            {
            	            match(input,DIV,FOLLOW_DIV_in_prodExpr402); 
            	            prodExp.setOperation(ProductOperations.DIV);

            	            }
            	            break;
            	        case 3 :
            	            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:72:6: MOD
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:78:1: powExpr returns [Power pw] : a1= unaryExpr ( POW a2= unaryExpr )? ;
    public final Power powExpr() throws RecognitionException {
        Power pw = null;

        Unary a1 = null;

        Unary a2 = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:80:3: (a1= unaryExpr ( POW a2= unaryExpr )? )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:80:3: a1= unaryExpr ( POW a2= unaryExpr )?
            {
            pushFollow(FOLLOW_unaryExpr_in_powExpr470);
            a1=unaryExpr();
            _fsp--;

            pw = a1;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:81:4: ( POW a2= unaryExpr )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==POW) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:81:5: POW a2= unaryExpr
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:87:1: unaryExpr returns [Unary u] : ( MINUS uminus= unaryExpr | NOT unot= unaryExpr | a= atom );
    public final Unary unaryExpr() throws RecognitionException {
        Unary u = null;

        Unary uminus = null;

        Unary unot = null;

        Atom a = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:89:5: ( MINUS uminus= unaryExpr | NOT unot= unaryExpr | a= atom )
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
            case LPAREN:
            case INTPMF:
            case DOUBLEPMF:
            case ENUMPMF:
            case DOUBLEPDF:
            case BOOLPMF:
            case FALSE:
            case TRUE:
            case ID:
                {
                alt11=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("87:1: unaryExpr returns [Unary u] : ( MINUS uminus= unaryExpr | NOT unot= unaryExpr | a= atom );", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:89:5: MINUS uminus= unaryExpr
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
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:94:5: NOT unot= unaryExpr
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
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:99:5: a= atom
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:101:1: atom returns [Atom a] : (number= NUMBER | id= scoped_id DOT type= characterisation | def= definition | sl= STRING_LITERAL | bl= boolean_keywords | LPAREN inner= compareExpr RPAREN ) ;
    public final Atom atom() throws RecognitionException {
        Atom a = null;

        Token number=null;
        Token sl=null;
        AbstractNamedReference id = null;

        VariableCharacterisationType type = null;

        ProbabilityFunctionLiteral def = null;

        String bl = null;

        Comparison inner = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:103:3: ( (number= NUMBER | id= scoped_id DOT type= characterisation | def= definition | sl= STRING_LITERAL | bl= boolean_keywords | LPAREN inner= compareExpr RPAREN ) )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:103:3: (number= NUMBER | id= scoped_id DOT type= characterisation | def= definition | sl= STRING_LITERAL | bl= boolean_keywords | LPAREN inner= compareExpr RPAREN )
            {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:103:3: (number= NUMBER | id= scoped_id DOT type= characterisation | def= definition | sl= STRING_LITERAL | bl= boolean_keywords | LPAREN inner= compareExpr RPAREN )
            int alt12=6;
            switch ( input.LA(1) ) {
            case NUMBER:
                {
                alt12=1;
                }
                break;
            case ID:
                {
                alt12=2;
                }
                break;
            case INTPMF:
            case DOUBLEPMF:
            case ENUMPMF:
            case DOUBLEPDF:
            case BOOLPMF:
                {
                alt12=3;
                }
                break;
            case STRING_LITERAL:
                {
                alt12=4;
                }
                break;
            case FALSE:
            case TRUE:
                {
                alt12=5;
                }
                break;
            case LPAREN:
                {
                alt12=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("103:3: (number= NUMBER | id= scoped_id DOT type= characterisation | def= definition | sl= STRING_LITERAL | bl= boolean_keywords | LPAREN inner= compareExpr RPAREN )", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:105:5: number= NUMBER
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
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:123:5: id= scoped_id DOT type= characterisation
                    {
                    pushFollow(FOLLOW_scoped_id_in_atom635);
                    id=scoped_id();
                    _fsp--;

                    match(input,DOT,FOLLOW_DOT_in_atom637); 
                    pushFollow(FOLLOW_characterisation_in_atom643);
                    type=characterisation();
                    _fsp--;

                     a = ParameterFactory.eINSTANCE.createCharacterisedVariable();
                    		  	((CharacterisedVariable)a).setId_Variable(id);
                    		  	((CharacterisedVariable)a).setCharacterisationType(type);
                    		  

                    }
                    break;
                case 3 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:130:5: def= definition
                    {
                    pushFollow(FOLLOW_definition_in_atom671);
                    def=definition();
                    _fsp--;

                    a=def;

                    }
                    break;
                case 4 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:134:5: sl= STRING_LITERAL
                    {
                    sl=(Token)input.LT(1);
                    match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_atom696); 
                    
                    		  	StringLiteral stringLiteral = StoexFactory.eINSTANCE.createStringLiteral();
                    		  	stringLiteral.setValue(sl.getText().replace("\"",""));
                    		  	a = stringLiteral;
                    		  

                    }
                    break;
                case 5 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:142:5: bl= boolean_keywords
                    {
                    pushFollow(FOLLOW_boolean_keywords_in_atom723);
                    bl=boolean_keywords();
                    _fsp--;

                    
                    		  	BoolLiteral boolLiteral = StoexFactory.eINSTANCE.createBoolLiteral();
                    	   		boolLiteral.setValue(bl.equals("true"));
                    	   		a = boolLiteral;
                    	   	  

                    }
                    break;
                case 6 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:150:5: LPAREN inner= compareExpr RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_atom747); 
                    pushFollow(FOLLOW_compareExpr_in_atom757);
                    inner=compareExpr();
                    _fsp--;

                    match(input,RPAREN,FOLLOW_RPAREN_in_atom763); 
                    
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


    // $ANTLR start characterisation
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:161:1: characterisation returns [VariableCharacterisationType ct] : type= characterisation_keywords ;
    public final VariableCharacterisationType characterisation() throws RecognitionException {
        VariableCharacterisationType ct = null;

        String type = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:163:2: (type= characterisation_keywords )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:163:2: type= characterisation_keywords
            {
            pushFollow(FOLLOW_characterisation_keywords_in_characterisation802);
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:177:1: definition returns [ProbabilityFunctionLiteral pfl] : ( INTPMF ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (isample= numeric_int_sample )+ SQUARE_PAREN_R | DOUBLEPMF ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (rsample= numeric_real_sample )+ SQUARE_PAREN_R | ENUMPMF ( LPAREN (uunit= unit ) ( SEMI ORDERED_DEF ) RPAREN )? SQUARE_PAREN_L (ssample= stringsample )+ SQUARE_PAREN_R | DOUBLEPDF ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (pdf_sample= real_pdf_sample )+ SQUARE_PAREN_R | BOOLPMF ( LPAREN (uunit= bool_unit ) ( SEMI ORDERED_DEF )? RPAREN )? SQUARE_PAREN_L (ssample= boolsample )+ SQUARE_PAREN_R );
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
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:183:4: ( INTPMF ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (isample= numeric_int_sample )+ SQUARE_PAREN_R | DOUBLEPMF ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (rsample= numeric_real_sample )+ SQUARE_PAREN_R | ENUMPMF ( LPAREN (uunit= unit ) ( SEMI ORDERED_DEF ) RPAREN )? SQUARE_PAREN_L (ssample= stringsample )+ SQUARE_PAREN_R | DOUBLEPDF ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (pdf_sample= real_pdf_sample )+ SQUARE_PAREN_R | BOOLPMF ( LPAREN (uunit= bool_unit ) ( SEMI ORDERED_DEF )? RPAREN )? SQUARE_PAREN_L (ssample= boolsample )+ SQUARE_PAREN_R )
            int alt24=5;
            switch ( input.LA(1) ) {
            case INTPMF:
                {
                alt24=1;
                }
                break;
            case DOUBLEPMF:
                {
                alt24=2;
                }
                break;
            case ENUMPMF:
                {
                alt24=3;
                }
                break;
            case DOUBLEPDF:
                {
                alt24=4;
                }
                break;
            case BOOLPMF:
                {
                alt24=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("177:1: definition returns [ProbabilityFunctionLiteral pfl] : ( INTPMF ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (isample= numeric_int_sample )+ SQUARE_PAREN_R | DOUBLEPMF ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (rsample= numeric_real_sample )+ SQUARE_PAREN_R | ENUMPMF ( LPAREN (uunit= unit ) ( SEMI ORDERED_DEF ) RPAREN )? SQUARE_PAREN_L (ssample= stringsample )+ SQUARE_PAREN_R | DOUBLEPDF ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (pdf_sample= real_pdf_sample )+ SQUARE_PAREN_R | BOOLPMF ( LPAREN (uunit= bool_unit ) ( SEMI ORDERED_DEF )? RPAREN )? SQUARE_PAREN_L (ssample= boolsample )+ SQUARE_PAREN_R );", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:183:4: INTPMF ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (isample= numeric_int_sample )+ SQUARE_PAREN_R
                    {
                    match(input,INTPMF,FOLLOW_INTPMF_in_definition839); 
                    probFunction = ProbfunctionFactory.eINSTANCE.createProbabilityMassFunction();
                    				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:186:4: ( LPAREN (uunit= unit ) RPAREN )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==LPAREN) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:186:5: LPAREN (uunit= unit ) RPAREN
                            {
                            match(input,LPAREN,FOLLOW_LPAREN_in_definition851); 
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:187:6: (uunit= unit )
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:188:6: uunit= unit
                            {
                            pushFollow(FOLLOW_unit_in_definition869);
                            uunit=unit();
                            _fsp--;

                            probFunction.setUnit(uunit);

                            }

                            match(input,RPAREN,FOLLOW_RPAREN_in_definition883); 

                            }
                            break;

                    }

                    match(input,SQUARE_PAREN_L,FOLLOW_SQUARE_PAREN_L_in_definition890); 
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:192:5: (isample= numeric_int_sample )+
                    int cnt14=0;
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==LPAREN) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:193:7: isample= numeric_int_sample
                    	    {
                    	    pushFollow(FOLLOW_numeric_int_sample_in_definition910);
                    	    isample=numeric_int_sample();
                    	    _fsp--;

                    	    ((ProbabilityMassFunction)probFunction).getSamples().add(isample);

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt14 >= 1 ) break loop14;
                                EarlyExitException eee =
                                    new EarlyExitException(14, input);
                                throw eee;
                        }
                        cnt14++;
                    } while (true);

                    match(input,SQUARE_PAREN_R,FOLLOW_SQUARE_PAREN_R_in_definition927); 

                    }
                    break;
                case 2 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:197:5: DOUBLEPMF ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (rsample= numeric_real_sample )+ SQUARE_PAREN_R
                    {
                    match(input,DOUBLEPMF,FOLLOW_DOUBLEPMF_in_definition940); 
                    probFunction = ProbfunctionFactory.eINSTANCE.createProbabilityMassFunction();
                    				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:200:4: ( LPAREN (uunit= unit ) RPAREN )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==LPAREN) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:200:5: LPAREN (uunit= unit ) RPAREN
                            {
                            match(input,LPAREN,FOLLOW_LPAREN_in_definition953); 
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:201:6: (uunit= unit )
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:202:6: uunit= unit
                            {
                            pushFollow(FOLLOW_unit_in_definition971);
                            uunit=unit();
                            _fsp--;

                            probFunction.setUnit(uunit);

                            }

                            match(input,RPAREN,FOLLOW_RPAREN_in_definition985); 

                            }
                            break;

                    }

                    match(input,SQUARE_PAREN_L,FOLLOW_SQUARE_PAREN_L_in_definition993); 
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:206:5: (rsample= numeric_real_sample )+
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
                    	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:207:5: rsample= numeric_real_sample
                    	    {
                    	    pushFollow(FOLLOW_numeric_real_sample_in_definition1011);
                    	    rsample=numeric_real_sample();
                    	    _fsp--;

                    	    ((ProbabilityMassFunction)probFunction).getSamples().add(rsample);

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

                    match(input,SQUARE_PAREN_R,FOLLOW_SQUARE_PAREN_R_in_definition1028); 

                    }
                    break;
                case 3 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:212:4: ENUMPMF ( LPAREN (uunit= unit ) ( SEMI ORDERED_DEF ) RPAREN )? SQUARE_PAREN_L (ssample= stringsample )+ SQUARE_PAREN_R
                    {
                    match(input,ENUMPMF,FOLLOW_ENUMPMF_in_definition1042); 
                    probFunction = ProbfunctionFactory.eINSTANCE.createProbabilityMassFunction();
                    				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
                    				   ((ProbabilityMassFunction)probFunction).setOrderedDomain(false);
                    				   
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:217:4: ( LPAREN (uunit= unit ) ( SEMI ORDERED_DEF ) RPAREN )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==LPAREN) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:217:5: LPAREN (uunit= unit ) ( SEMI ORDERED_DEF ) RPAREN
                            {
                            match(input,LPAREN,FOLLOW_LPAREN_in_definition1055); 
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:218:6: (uunit= unit )
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:219:6: uunit= unit
                            {
                            pushFollow(FOLLOW_unit_in_definition1073);
                            uunit=unit();
                            _fsp--;

                            probFunction.setUnit(uunit);

                            }

                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:221:6: ( SEMI ORDERED_DEF )
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:221:7: SEMI ORDERED_DEF
                            {
                            match(input,SEMI,FOLLOW_SEMI_in_definition1090); 
                            match(input,ORDERED_DEF,FOLLOW_ORDERED_DEF_in_definition1097); 
                            ((ProbabilityMassFunction)probFunction).setOrderedDomain(true);

                            }

                            match(input,RPAREN,FOLLOW_RPAREN_in_definition1116); 

                            }
                            break;

                    }

                    match(input,SQUARE_PAREN_L,FOLLOW_SQUARE_PAREN_L_in_definition1123); 
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:227:5: (ssample= stringsample )+
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
                    	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:228:5: ssample= stringsample
                    	    {
                    	    pushFollow(FOLLOW_stringsample_in_definition1141);
                    	    ssample=stringsample();
                    	    _fsp--;

                    	    ((ProbabilityMassFunction)probFunction).getSamples().add(ssample);

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

                    match(input,SQUARE_PAREN_R,FOLLOW_SQUARE_PAREN_R_in_definition1158); 

                    }
                    break;
                case 4 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:232:4: DOUBLEPDF ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (pdf_sample= real_pdf_sample )+ SQUARE_PAREN_R
                    {
                    match(input,DOUBLEPDF,FOLLOW_DOUBLEPDF_in_definition1168); 
                    probFunction = ProbfunctionFactory.eINSTANCE.createBoxedPDF();
                    				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:235:4: ( LPAREN (uunit= unit ) RPAREN )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==LPAREN) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:235:5: LPAREN (uunit= unit ) RPAREN
                            {
                            match(input,LPAREN,FOLLOW_LPAREN_in_definition1180); 
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:236:6: (uunit= unit )
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:237:6: uunit= unit
                            {
                            pushFollow(FOLLOW_unit_in_definition1198);
                            uunit=unit();
                            _fsp--;

                            probFunction.setUnit(uunit);

                            }

                            match(input,RPAREN,FOLLOW_RPAREN_in_definition1212); 

                            }
                            break;

                    }

                    match(input,SQUARE_PAREN_L,FOLLOW_SQUARE_PAREN_L_in_definition1219); 
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:241:5: (pdf_sample= real_pdf_sample )+
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
                    	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:242:7: pdf_sample= real_pdf_sample
                    	    {
                    	    pushFollow(FOLLOW_real_pdf_sample_in_definition1239);
                    	    pdf_sample=real_pdf_sample();
                    	    _fsp--;

                    	    ((BoxedPDF)probFunction).getSamples().add(pdf_sample);

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

                    match(input,SQUARE_PAREN_R,FOLLOW_SQUARE_PAREN_R_in_definition1256); 

                    }
                    break;
                case 5 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:246:4: BOOLPMF ( LPAREN (uunit= bool_unit ) ( SEMI ORDERED_DEF )? RPAREN )? SQUARE_PAREN_L (ssample= boolsample )+ SQUARE_PAREN_R
                    {
                    match(input,BOOLPMF,FOLLOW_BOOLPMF_in_definition1267); 
                    probFunction = ProbfunctionFactory.eINSTANCE.createProbabilityMassFunction();
                    				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
                    				   ((ProbabilityMassFunction)probFunction).setOrderedDomain(false);
                    				   
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:251:4: ( LPAREN (uunit= bool_unit ) ( SEMI ORDERED_DEF )? RPAREN )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==LPAREN) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:251:5: LPAREN (uunit= bool_unit ) ( SEMI ORDERED_DEF )? RPAREN
                            {
                            match(input,LPAREN,FOLLOW_LPAREN_in_definition1280); 
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:252:6: (uunit= bool_unit )
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:253:6: uunit= bool_unit
                            {
                            pushFollow(FOLLOW_bool_unit_in_definition1298);
                            uunit=bool_unit();
                            _fsp--;

                            probFunction.setUnit(uunit);

                            }

                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:255:6: ( SEMI ORDERED_DEF )?
                            int alt21=2;
                            int LA21_0 = input.LA(1);

                            if ( (LA21_0==SEMI) ) {
                                alt21=1;
                            }
                            switch (alt21) {
                                case 1 :
                                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:255:7: SEMI ORDERED_DEF
                                    {
                                    match(input,SEMI,FOLLOW_SEMI_in_definition1315); 
                                    match(input,ORDERED_DEF,FOLLOW_ORDERED_DEF_in_definition1322); 
                                    ((ProbabilityMassFunction)probFunction).setOrderedDomain(true);

                                    }
                                    break;

                            }

                            match(input,RPAREN,FOLLOW_RPAREN_in_definition1342); 

                            }
                            break;

                    }

                    match(input,SQUARE_PAREN_L,FOLLOW_SQUARE_PAREN_L_in_definition1349); 
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:261:5: (ssample= boolsample )+
                    int cnt23=0;
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==LPAREN) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:262:5: ssample= boolsample
                    	    {
                    	    pushFollow(FOLLOW_boolsample_in_definition1367);
                    	    ssample=boolsample();
                    	    _fsp--;

                    	    ((ProbabilityMassFunction)probFunction).getSamples().add(ssample);

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt23 >= 1 ) break loop23;
                                EarlyExitException eee =
                                    new EarlyExitException(23, input);
                                throw eee;
                        }
                        cnt23++;
                    } while (true);

                    match(input,SQUARE_PAREN_R,FOLLOW_SQUARE_PAREN_R_in_definition1384); 

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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:268:1: unit returns [Unit u] : UNIT DEFINITION str= STRING_LITERAL ;
    public final Unit unit() throws RecognitionException {
        Unit u = null;

        Token str=null;

        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:270:3: ( UNIT DEFINITION str= STRING_LITERAL )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:270:3: UNIT DEFINITION str= STRING_LITERAL
            {
            match(input,UNIT,FOLLOW_UNIT_in_unit1408); 
             u = ProbfunctionFactory.eINSTANCE.createUnit(); 
            match(input,DEFINITION,FOLLOW_DEFINITION_in_unit1418); 
            str=(Token)input.LT(1);
            match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_unit1425); 
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:276:1: bool_unit returns [Unit u] : UNIT EQUAL BOOL ;
    public final Unit bool_unit() throws RecognitionException {
        Unit u = null;

        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:278:3: ( UNIT EQUAL BOOL )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:278:3: UNIT EQUAL BOOL
            {
            match(input,UNIT,FOLLOW_UNIT_in_bool_unit1447); 
             u = ProbfunctionFactory.eINSTANCE.createUnit(); 
            match(input,EQUAL,FOLLOW_EQUAL_in_bool_unit1457); 
            match(input,BOOL,FOLLOW_BOOL_in_bool_unit1462); 
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:285:1: numeric_int_sample returns [Sample s] : LPAREN n= NUMBER SEMI n2= NUMBER RPAREN ;
    public final Sample numeric_int_sample() throws RecognitionException {
        Sample s = null;

        Token n=null;
        Token n2=null;

        s = null;
        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:287:3: ( LPAREN n= NUMBER SEMI n2= NUMBER RPAREN )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:287:3: LPAREN n= NUMBER SEMI n2= NUMBER RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_numeric_int_sample1490); 
            s = ProbfunctionFactory.eINSTANCE.createSample();
            n=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_numeric_int_sample1503); 
            s.setValue(Integer.parseInt(n.getText()));
            match(input,SEMI,FOLLOW_SEMI_in_numeric_int_sample1514); 
            n2=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_numeric_int_sample1522); 
            s.setProbability(Double.parseDouble(n2.getText()));
            match(input,RPAREN,FOLLOW_RPAREN_in_numeric_int_sample1534); 

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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:296:1: numeric_real_sample returns [Sample s] : LPAREN n= NUMBER SEMI n2= NUMBER RPAREN ;
    public final Sample numeric_real_sample() throws RecognitionException {
        Sample s = null;

        Token n=null;
        Token n2=null;

        s = null;
        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:298:3: ( LPAREN n= NUMBER SEMI n2= NUMBER RPAREN )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:298:3: LPAREN n= NUMBER SEMI n2= NUMBER RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_numeric_real_sample1557); 
            s = ProbfunctionFactory.eINSTANCE.createSample();
            n=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_numeric_real_sample1570); 
            s.setValue(Double.parseDouble(n.getText()));
            match(input,SEMI,FOLLOW_SEMI_in_numeric_real_sample1581); 
            n2=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_numeric_real_sample1589); 
            s.setProbability(Double.parseDouble(n2.getText()));
            match(input,RPAREN,FOLLOW_RPAREN_in_numeric_real_sample1601); 

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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:307:1: real_pdf_sample returns [ContinuousSample s] : LPAREN n= NUMBER SEMI n2= NUMBER RPAREN ;
    public final ContinuousSample real_pdf_sample() throws RecognitionException {
        ContinuousSample s = null;

        Token n=null;
        Token n2=null;

        s = null;
        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:309:3: ( LPAREN n= NUMBER SEMI n2= NUMBER RPAREN )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:309:3: LPAREN n= NUMBER SEMI n2= NUMBER RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_real_pdf_sample1625); 
            s = ProbfunctionFactory.eINSTANCE.createContinuousSample();
            n=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_real_pdf_sample1638); 
            s.setValue(Double.parseDouble(n.getText()));
            match(input,SEMI,FOLLOW_SEMI_in_real_pdf_sample1649); 
            n2=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_real_pdf_sample1657); 
            s.setProbability(Double.parseDouble(n2.getText()));
            match(input,RPAREN,FOLLOW_RPAREN_in_real_pdf_sample1669); 

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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:318:1: stringsample returns [Sample s] : LPAREN str= STRING_LITERAL SEMI n= NUMBER RPAREN ;
    public final Sample stringsample() throws RecognitionException {
        Sample s = null;

        Token str=null;
        Token n=null;

        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:320:3: ( LPAREN str= STRING_LITERAL SEMI n= NUMBER RPAREN )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:320:3: LPAREN str= STRING_LITERAL SEMI n= NUMBER RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_stringsample1690); 
            s = ProbfunctionFactory.eINSTANCE.createSample();
            str=(Token)input.LT(1);
            match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_stringsample1702); 
            s.setValue(str.getText().replace("\"",""));
            match(input,SEMI,FOLLOW_SEMI_in_stringsample1713); 
            n=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_stringsample1719); 
            s.setProbability(Double.parseDouble(n.getText()));
            match(input,RPAREN,FOLLOW_RPAREN_in_stringsample1730); 

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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:329:1: boolsample returns [Sample s] : LPAREN str= boolean_keywords SEMI n= NUMBER RPAREN ;
    public final Sample boolsample() throws RecognitionException {
        Sample s = null;

        Token n=null;
        String str = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:331:3: ( LPAREN str= boolean_keywords SEMI n= NUMBER RPAREN )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:331:3: LPAREN str= boolean_keywords SEMI n= NUMBER RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_boolsample1748); 
            s = ProbfunctionFactory.eINSTANCE.createSample();
            pushFollow(FOLLOW_boolean_keywords_in_boolsample1762);
            str=boolean_keywords();
            _fsp--;

            s.setValue(str);
            match(input,SEMI,FOLLOW_SEMI_in_boolsample1770); 
            n=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_boolsample1776); 
            s.setProbability(Double.parseDouble(n.getText()));
            match(input,RPAREN,FOLLOW_RPAREN_in_boolsample1787); 

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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:340:1: boolean_keywords returns [String keyword] : ( FALSE | TRUE ) ;
    public final String boolean_keywords() throws RecognitionException {
        String keyword = null;

        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:342:3: ( ( FALSE | TRUE ) )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:342:3: ( FALSE | TRUE )
            {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:342:3: ( FALSE | TRUE )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==FALSE) ) {
                alt25=1;
            }
            else if ( (LA25_0==TRUE) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("342:3: ( FALSE | TRUE )", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:343:3: FALSE
                    {
                    match(input,FALSE,FOLLOW_FALSE_in_boolean_keywords1806); 
                    keyword = "false";

                    }
                    break;
                case 2 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:346:3: TRUE
                    {
                    match(input,TRUE,FOLLOW_TRUE_in_boolean_keywords1820); 
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:350:1: characterisation_keywords returns [String keyword] : ( BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE ) ;
    public final String characterisation_keywords() throws RecognitionException {
        String keyword = null;

        keyword = null;
        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:352:2: ( ( BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE ) )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:352:2: ( BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE )
            {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:352:2: ( BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE )
            int alt26=5;
            switch ( input.LA(1) ) {
            case BYTESIZE:
                {
                alt26=1;
                }
                break;
            case STRUCTURE:
                {
                alt26=2;
                }
                break;
            case NUMBER_OF_ELEMENTS:
                {
                alt26=3;
                }
                break;
            case TYPE:
                {
                alt26=4;
                }
                break;
            case VALUE:
                {
                alt26=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("352:2: ( BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE )", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:352:3: BYTESIZE
                    {
                    match(input,BYTESIZE,FOLLOW_BYTESIZE_in_characterisation_keywords1848); 
                    keyword="BYTESIZE";

                    }
                    break;
                case 2 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:353:4: STRUCTURE
                    {
                    match(input,STRUCTURE,FOLLOW_STRUCTURE_in_characterisation_keywords1855); 
                    keyword="STRUCTURE";

                    }
                    break;
                case 3 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:354:4: NUMBER_OF_ELEMENTS
                    {
                    match(input,NUMBER_OF_ELEMENTS,FOLLOW_NUMBER_OF_ELEMENTS_in_characterisation_keywords1862); 
                    keyword="NUMBER_OF_ELEMENTS";

                    }
                    break;
                case 4 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:355:4: TYPE
                    {
                    match(input,TYPE,FOLLOW_TYPE_in_characterisation_keywords1869); 
                    keyword="TYPE";

                    }
                    break;
                case 5 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:356:4: VALUE
                    {
                    match(input,VALUE,FOLLOW_VALUE_in_characterisation_keywords1876); 
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:359:1: scoped_id returns [AbstractNamedReference ref] : id1= ID ( DOT (id2= ID | INNER ) )* ;
    public final AbstractNamedReference scoped_id() throws RecognitionException {
        AbstractNamedReference ref = null;

        Token id1=null;
        Token id2=null;

        ref = null;
        		ArrayList<String> nameParts = new ArrayList<String>();
        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:363:2: (id1= ID ( DOT (id2= ID | INNER ) )* )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:363:2: id1= ID ( DOT (id2= ID | INNER ) )*
            {
            id1=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_scoped_id1906); 
            nameParts.add(id1.getText());
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:364:6: ( DOT (id2= ID | INNER ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==DOT) ) {
                    int LA28_1 = input.LA(2);

                    if ( ((LA28_1>=ID && LA28_1<=INNER)) ) {
                        alt28=1;
                    }


                }


                switch (alt28) {
            	case 1 :
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:364:7: DOT (id2= ID | INNER )
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_scoped_id1917); 
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:364:11: (id2= ID | INNER )
            	    int alt27=2;
            	    int LA27_0 = input.LA(1);

            	    if ( (LA27_0==ID) ) {
            	        alt27=1;
            	    }
            	    else if ( (LA27_0==INNER) ) {
            	        alt27=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("364:11: (id2= ID | INNER )", 27, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt27) {
            	        case 1 :
            	            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:364:12: id2= ID
            	            {
            	            id2=(Token)input.LT(1);
            	            match(input,ID,FOLLOW_ID_in_scoped_id1922); 
            	            nameParts.add(id2.getText());

            	            }
            	            break;
            	        case 2 :
            	            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:364:53: INNER
            	            {
            	            match(input,INNER,FOLLOW_INNER_in_scoped_id1928); 
            	            nameParts.add("INNER");

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
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
    public static final BitSet FOLLOW_AND_in_boolAndExpr70 = new BitSet(new long[]{0x0000106332D84000L});
    public static final BitSet FOLLOW_boolOrExpr_in_boolAndExpr81 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_compareExpr_in_boolOrExpr108 = new BitSet(new long[]{0x0000000000000062L});
    public static final BitSet FOLLOW_OR_in_boolOrExpr121 = new BitSet(new long[]{0x0000106332D84000L});
    public static final BitSet FOLLOW_XOR_in_boolOrExpr129 = new BitSet(new long[]{0x0000106332D84000L});
    public static final BitSet FOLLOW_compareExpr_in_boolOrExpr141 = new BitSet(new long[]{0x0000000000000062L});
    public static final BitSet FOLLOW_sumExpr_in_compareExpr179 = new BitSet(new long[]{0x0000000000001F82L});
    public static final BitSet FOLLOW_GREATER_in_compareExpr196 = new BitSet(new long[]{0x0000106332D84000L});
    public static final BitSet FOLLOW_LESS_in_compareExpr206 = new BitSet(new long[]{0x0000106332D84000L});
    public static final BitSet FOLLOW_EQUAL_in_compareExpr216 = new BitSet(new long[]{0x0000106332D84000L});
    public static final BitSet FOLLOW_NOTEQUAL_in_compareExpr226 = new BitSet(new long[]{0x0000106332D84000L});
    public static final BitSet FOLLOW_GREATEREQUAL_in_compareExpr236 = new BitSet(new long[]{0x0000106332D84000L});
    public static final BitSet FOLLOW_LESSEQUAL_in_compareExpr246 = new BitSet(new long[]{0x0000106332D84000L});
    public static final BitSet FOLLOW_sumExpr_in_compareExpr261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_prodExpr_in_sumExpr293 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_PLUS_in_sumExpr311 = new BitSet(new long[]{0x0000106332D84000L});
    public static final BitSet FOLLOW_MINUS_in_sumExpr319 = new BitSet(new long[]{0x0000106332D84000L});
    public static final BitSet FOLLOW_prodExpr_in_sumExpr333 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_powExpr_in_prodExpr371 = new BitSet(new long[]{0x0000000000038002L});
    public static final BitSet FOLLOW_MUL_in_prodExpr391 = new BitSet(new long[]{0x0000106332D84000L});
    public static final BitSet FOLLOW_DIV_in_prodExpr402 = new BitSet(new long[]{0x0000106332D84000L});
    public static final BitSet FOLLOW_MOD_in_prodExpr413 = new BitSet(new long[]{0x0000106332D84000L});
    public static final BitSet FOLLOW_powExpr_in_prodExpr429 = new BitSet(new long[]{0x0000000000038002L});
    public static final BitSet FOLLOW_unaryExpr_in_powExpr470 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_POW_in_powExpr479 = new BitSet(new long[]{0x0000106332D84000L});
    public static final BitSet FOLLOW_unaryExpr_in_powExpr485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_unaryExpr521 = new BitSet(new long[]{0x0000106332D84000L});
    public static final BitSet FOLLOW_unaryExpr_in_unaryExpr527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_unaryExpr545 = new BitSet(new long[]{0x0000106332D84000L});
    public static final BitSet FOLLOW_unaryExpr_in_unaryExpr551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_unaryExpr573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_atom608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scoped_id_in_atom635 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_DOT_in_atom637 = new BitSet(new long[]{0x00000F8000000000L});
    public static final BitSet FOLLOW_characterisation_in_atom643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definition_in_atom671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_atom696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolean_keywords_in_atom723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_atom747 = new BitSet(new long[]{0x0000106332D84000L});
    public static final BitSet FOLLOW_compareExpr_in_atom757 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RPAREN_in_atom763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_characterisation_keywords_in_characterisation802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTPMF_in_definition839 = new BitSet(new long[]{0x0000000004800000L});
    public static final BitSet FOLLOW_LPAREN_in_definition851 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_unit_in_definition869 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RPAREN_in_definition883 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_L_in_definition890 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_numeric_int_sample_in_definition910 = new BitSet(new long[]{0x0000000008800000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_R_in_definition927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLEPMF_in_definition940 = new BitSet(new long[]{0x0000000004800000L});
    public static final BitSet FOLLOW_LPAREN_in_definition953 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_unit_in_definition971 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RPAREN_in_definition985 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_L_in_definition993 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_numeric_real_sample_in_definition1011 = new BitSet(new long[]{0x0000000008800000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_R_in_definition1028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENUMPMF_in_definition1042 = new BitSet(new long[]{0x0000000004800000L});
    public static final BitSet FOLLOW_LPAREN_in_definition1055 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_unit_in_definition1073 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_SEMI_in_definition1090 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_ORDERED_DEF_in_definition1097 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RPAREN_in_definition1116 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_L_in_definition1123 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_stringsample_in_definition1141 = new BitSet(new long[]{0x0000000008800000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_R_in_definition1158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLEPDF_in_definition1168 = new BitSet(new long[]{0x0000000004800000L});
    public static final BitSet FOLLOW_LPAREN_in_definition1180 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_unit_in_definition1198 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RPAREN_in_definition1212 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_L_in_definition1219 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_real_pdf_sample_in_definition1239 = new BitSet(new long[]{0x0000000008800000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_R_in_definition1256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLPMF_in_definition1267 = new BitSet(new long[]{0x0000000004800000L});
    public static final BitSet FOLLOW_LPAREN_in_definition1280 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_bool_unit_in_definition1298 = new BitSet(new long[]{0x0000000041000000L});
    public static final BitSet FOLLOW_SEMI_in_definition1315 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_ORDERED_DEF_in_definition1322 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RPAREN_in_definition1342 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_L_in_definition1349 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_boolsample_in_definition1367 = new BitSet(new long[]{0x0000000008800000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_R_in_definition1384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNIT_in_unit1408 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_DEFINITION_in_unit1418 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_unit1425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNIT_in_bool_unit1447 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQUAL_in_bool_unit1457 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_BOOL_in_bool_unit1462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_numeric_int_sample1490 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_numeric_int_sample1503 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_SEMI_in_numeric_int_sample1514 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_numeric_int_sample1522 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RPAREN_in_numeric_int_sample1534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_numeric_real_sample1557 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_numeric_real_sample1570 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_SEMI_in_numeric_real_sample1581 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_numeric_real_sample1589 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RPAREN_in_numeric_real_sample1601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_real_pdf_sample1625 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_real_pdf_sample1638 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_SEMI_in_real_pdf_sample1649 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_real_pdf_sample1657 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RPAREN_in_real_pdf_sample1669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_stringsample1690 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_stringsample1702 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_SEMI_in_stringsample1713 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_stringsample1719 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RPAREN_in_stringsample1730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_boolsample1748 = new BitSet(new long[]{0x0000006000000000L});
    public static final BitSet FOLLOW_boolean_keywords_in_boolsample1762 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_SEMI_in_boolsample1770 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_boolsample1776 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RPAREN_in_boolsample1787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_boolean_keywords1806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_boolean_keywords1820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTESIZE_in_characterisation_keywords1848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRUCTURE_in_characterisation_keywords1855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_OF_ELEMENTS_in_characterisation_keywords1862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TYPE_in_characterisation_keywords1869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VALUE_in_characterisation_keywords1876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_scoped_id1906 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_DOT_in_scoped_id1917 = new BitSet(new long[]{0x0000300000000000L});
    public static final BitSet FOLLOW_ID_in_scoped_id1922 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_INNER_in_scoped_id1928 = new BitSet(new long[]{0x0000000000200002L});

}
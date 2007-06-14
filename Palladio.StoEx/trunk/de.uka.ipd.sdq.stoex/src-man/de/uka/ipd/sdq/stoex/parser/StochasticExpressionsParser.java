// $ANTLR 3.0 C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g 2007-06-14 08:31:47
  
	package de.uka.ipd.sdq.stoex.parser;
	import de.uka.ipd.sdq.stoex.*;
	import de.uka.ipd.sdq.probfunction.*;
	import java.util.ArrayList;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class StochasticExpressionsParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "GREATER", "LESS", "EQUAL", "NOTEQUAL", "GREATEREQUAL", "LESSEQUAL", "PLUS", "MINUS", "MUL", "DIV", "MOD", "POW", "NUMBER", "STRING_LITERAL", "LPAREN", "RPAREN", "SQUARE_PAREN_L", "SQUARE_PAREN_R", "SEMI", "ORDERED_DEF", "DEFINITION", "ID", "DOT", "DIGIT", "Exponent", "ALPHA", "WS", "COMMENT", "LINE_COMMENT", "'OR'", "'XOR'", "'AND'", "'NOT'", "'IntPMF'", "'DoublePMF'", "'EnumPMF'", "'DoublePDF'", "'BoolPMF'", "'unit'", "'\"bool\"'", "'false'", "'true'", "'BYTESIZE'", "'STRUCTURE'", "'NUMBER_OF_ELEMENTS'", "'TYPE'", "'VALUE'", "'INNER'"
    };
    public static final int LINE_COMMENT=32;
    public static final int MOD=14;
    public static final int NUMBER=16;
    public static final int Exponent=28;
    public static final int GREATEREQUAL=8;
    public static final int MINUS=11;
    public static final int ID=25;
    public static final int EOF=-1;
    public static final int SEMI=22;
    public static final int MUL=12;
    public static final int ALPHA=29;
    public static final int LPAREN=18;
    public static final int NOTEQUAL=7;
    public static final int SQUARE_PAREN_R=21;
    public static final int RPAREN=19;
    public static final int WS=30;
    public static final int GREATER=4;
    public static final int STRING_LITERAL=17;
    public static final int POW=15;
    public static final int SQUARE_PAREN_L=20;
    public static final int EQUAL=6;
    public static final int LESS=5;
    public static final int DEFINITION=24;
    public static final int PLUS=10;
    public static final int DIGIT=27;
    public static final int DIV=13;
    public static final int COMMENT=31;
    public static final int DOT=26;
    public static final int ORDERED_DEF=23;
    public static final int LESSEQUAL=9;

        public StochasticExpressionsParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g"; }



    // $ANTLR start expression
    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:12:1: expression returns [Expression exp] : c= boolOrExpr ;
    public final Expression expression() throws RecognitionException {
        Expression exp = null;

        BooleanExpression c = null;


        try {
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:14:4: (c= boolOrExpr )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:14:4: c= boolOrExpr
            {
            pushFollow(FOLLOW_boolOrExpr_in_expression33);
            c=boolOrExpr();
            _fsp--;

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


    // $ANTLR start boolOrExpr
    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:17:1: boolOrExpr returns [BooleanExpression boolExp] : b1= boolAndExpr ( ( 'OR' | 'XOR' ) boolAndExpr )* ;
    public final BooleanExpression boolOrExpr() throws RecognitionException {
        BooleanExpression boolExp = null;

        BooleanExpression b1 = null;


        try {
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:19:2: (b1= boolAndExpr ( ( 'OR' | 'XOR' ) boolAndExpr )* )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:19:2: b1= boolAndExpr ( ( 'OR' | 'XOR' ) boolAndExpr )*
            {
            pushFollow(FOLLOW_boolAndExpr_in_boolOrExpr57);
            b1=boolAndExpr();
            _fsp--;

            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:20:3: ( ( 'OR' | 'XOR' ) boolAndExpr )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=33 && LA1_0<=34)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:20:4: ( 'OR' | 'XOR' ) boolAndExpr
            	    {
            	    if ( (input.LA(1)>=33 && input.LA(1)<=34) ) {
            	        input.consume();
            	        errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_boolOrExpr63);    throw mse;
            	    }

            	    pushFollow(FOLLOW_boolAndExpr_in_boolOrExpr79);
            	    boolAndExpr();
            	    _fsp--;


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
    // $ANTLR end boolOrExpr


    // $ANTLR start boolAndExpr
    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:26:1: boolAndExpr returns [BooleanExpression boolExp] : b1= compareExpr ( 'AND' compareExpr )* ;
    public final BooleanExpression boolAndExpr() throws RecognitionException {
        BooleanExpression boolExp = null;

        Comparison b1 = null;


        try {
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:28:2: (b1= compareExpr ( 'AND' compareExpr )* )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:28:2: b1= compareExpr ( 'AND' compareExpr )*
            {
            pushFollow(FOLLOW_compareExpr_in_boolAndExpr105);
            b1=compareExpr();
            _fsp--;

            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:29:3: ( 'AND' compareExpr )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==35) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:29:4: 'AND' compareExpr
            	    {
            	    match(input,35,FOLLOW_35_in_boolAndExpr111); 
            	    pushFollow(FOLLOW_compareExpr_in_boolAndExpr117);
            	    compareExpr();
            	    _fsp--;


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
    // $ANTLR end boolAndExpr


    // $ANTLR start compareExpr
    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:35:1: compareExpr returns [Comparison comp] : t1= sumExpr ( ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL ) t2= sumExpr )? ;
    public final Comparison compareExpr() throws RecognitionException {
        Comparison comp = null;

        Term t1 = null;

        Term t2 = null;


        try {
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:37:4: (t1= sumExpr ( ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL ) t2= sumExpr )? )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:37:4: t1= sumExpr ( ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL ) t2= sumExpr )?
            {
            pushFollow(FOLLOW_sumExpr_in_compareExpr146);
            t1=sumExpr();
            _fsp--;

            comp = t1;
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:37:30: ( ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL ) t2= sumExpr )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=GREATER && LA4_0<=LESSEQUAL)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:38:5: ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL ) t2= sumExpr
                    {
                    CompareExpression compExp = StoexFactory.eINSTANCE.createCompareExpression();
                    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:39:5: ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL )
                    int alt3=6;
                    switch ( input.LA(1) ) {
                    case GREATER:
                        {
                        alt3=1;
                        }
                        break;
                    case LESS:
                        {
                        alt3=2;
                        }
                        break;
                    case EQUAL:
                        {
                        alt3=3;
                        }
                        break;
                    case NOTEQUAL:
                        {
                        alt3=4;
                        }
                        break;
                    case GREATEREQUAL:
                        {
                        alt3=5;
                        }
                        break;
                    case LESSEQUAL:
                        {
                        alt3=6;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("39:5: ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL )", 3, 0, input);

                        throw nvae;
                    }

                    switch (alt3) {
                        case 1 :
                            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:39:6: GREATER
                            {
                            match(input,GREATER,FOLLOW_GREATER_in_compareExpr163); 
                            compExp.setOperation(CompareOperations.GREATER);

                            }
                            break;
                        case 2 :
                            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:40:6: LESS
                            {
                            match(input,LESS,FOLLOW_LESS_in_compareExpr173); 
                            compExp.setOperation(CompareOperations.LESS);

                            }
                            break;
                        case 3 :
                            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:41:6: EQUAL
                            {
                            match(input,EQUAL,FOLLOW_EQUAL_in_compareExpr183); 
                            compExp.setOperation(CompareOperations.EQUALS);

                            }
                            break;
                        case 4 :
                            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:42:6: NOTEQUAL
                            {
                            match(input,NOTEQUAL,FOLLOW_NOTEQUAL_in_compareExpr193); 
                            compExp.setOperation(CompareOperations.NOTEQUAL);

                            }
                            break;
                        case 5 :
                            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:43:6: GREATEREQUAL
                            {
                            match(input,GREATEREQUAL,FOLLOW_GREATEREQUAL_in_compareExpr203); 
                            compExp.setOperation(CompareOperations.GREATEREQUAL);

                            }
                            break;
                        case 6 :
                            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:44:6: LESSEQUAL
                            {
                            match(input,LESSEQUAL,FOLLOW_LESSEQUAL_in_compareExpr213); 
                            compExp.setOperation(CompareOperations.LESSEQUAL);

                            }
                            break;

                    }

                    pushFollow(FOLLOW_sumExpr_in_compareExpr228);
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
    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:48:1: sumExpr returns [Term t] : p1= prodExpr ( ( PLUS | MINUS ) p2= prodExpr )* ;
    public final Term sumExpr() throws RecognitionException {
        Term t = null;

        Product p1 = null;

        Product p2 = null;


        try {
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:50:2: (p1= prodExpr ( ( PLUS | MINUS ) p2= prodExpr )* )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:50:2: p1= prodExpr ( ( PLUS | MINUS ) p2= prodExpr )*
            {
            pushFollow(FOLLOW_prodExpr_in_sumExpr260);
            p1=prodExpr();
            _fsp--;

            t = p1;
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:50:26: ( ( PLUS | MINUS ) p2= prodExpr )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=PLUS && LA6_0<=MINUS)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:51:4: ( PLUS | MINUS ) p2= prodExpr
            	    {
            	    TermExpression termExp = StoexFactory.eINSTANCE.createTermExpression();
            	    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:52:4: ( PLUS | MINUS )
            	    int alt5=2;
            	    int LA5_0 = input.LA(1);

            	    if ( (LA5_0==PLUS) ) {
            	        alt5=1;
            	    }
            	    else if ( (LA5_0==MINUS) ) {
            	        alt5=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("52:4: ( PLUS | MINUS )", 5, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt5) {
            	        case 1 :
            	            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:52:5: PLUS
            	            {
            	            match(input,PLUS,FOLLOW_PLUS_in_sumExpr278); 
            	            termExp.setOperation(TermOperations.ADD);

            	            }
            	            break;
            	        case 2 :
            	            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:53:4: MINUS
            	            {
            	            match(input,MINUS,FOLLOW_MINUS_in_sumExpr286); 
            	            termExp.setOperation(TermOperations.SUB);

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_prodExpr_in_sumExpr300);
            	    p2=prodExpr();
            	    _fsp--;

            	    termExp.setLeft(t); termExp.setRight(p2); t = termExp;

            	    }
            	    break;

            	default :
            	    break loop6;
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
    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:59:1: prodExpr returns [Product p] : pw1= powExpr ( ( MUL | DIV | MOD ) pw2= powExpr )* ;
    public final Product prodExpr() throws RecognitionException {
        Product p = null;

        Power pw1 = null;

        Power pw2 = null;


        try {
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:61:3: (pw1= powExpr ( ( MUL | DIV | MOD ) pw2= powExpr )* )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:61:3: pw1= powExpr ( ( MUL | DIV | MOD ) pw2= powExpr )*
            {
            pushFollow(FOLLOW_powExpr_in_prodExpr338);
            pw1=powExpr();
            _fsp--;

            p = pw1;
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:62:4: ( ( MUL | DIV | MOD ) pw2= powExpr )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=MUL && LA8_0<=MOD)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:63:4: ( MUL | DIV | MOD ) pw2= powExpr
            	    {
            	    ProductExpression prodExp = StoexFactory.eINSTANCE.createProductExpression();
            	    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:64:5: ( MUL | DIV | MOD )
            	    int alt7=3;
            	    switch ( input.LA(1) ) {
            	    case MUL:
            	        {
            	        alt7=1;
            	        }
            	        break;
            	    case DIV:
            	        {
            	        alt7=2;
            	        }
            	        break;
            	    case MOD:
            	        {
            	        alt7=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("64:5: ( MUL | DIV | MOD )", 7, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt7) {
            	        case 1 :
            	            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:64:6: MUL
            	            {
            	            match(input,MUL,FOLLOW_MUL_in_prodExpr358); 
            	            prodExp.setOperation(ProductOperations.MULT);

            	            }
            	            break;
            	        case 2 :
            	            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:65:6: DIV
            	            {
            	            match(input,DIV,FOLLOW_DIV_in_prodExpr369); 
            	            prodExp.setOperation(ProductOperations.DIV);

            	            }
            	            break;
            	        case 3 :
            	            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:66:6: MOD
            	            {
            	            match(input,MOD,FOLLOW_MOD_in_prodExpr380); 
            	            prodExp.setOperation(ProductOperations.MOD);

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_powExpr_in_prodExpr396);
            	    pw2=powExpr();
            	    _fsp--;

            	    prodExp.setLeft(p); prodExp.setRight(pw2); p = prodExp;

            	    }
            	    break;

            	default :
            	    break loop8;
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
    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:72:1: powExpr returns [Power pw] : a1= unaryExpr ( POW a2= unaryExpr )? ;
    public final Power powExpr() throws RecognitionException {
        Power pw = null;

        Atom a1 = null;

        Atom a2 = null;


        try {
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:74:3: (a1= unaryExpr ( POW a2= unaryExpr )? )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:74:3: a1= unaryExpr ( POW a2= unaryExpr )?
            {
            pushFollow(FOLLOW_unaryExpr_in_powExpr437);
            a1=unaryExpr();
            _fsp--;

            pw = a1;
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:75:4: ( POW a2= unaryExpr )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==POW) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:75:5: POW a2= unaryExpr
                    {
                    match(input,POW,FOLLOW_POW_in_powExpr446); 
                    pushFollow(FOLLOW_unaryExpr_in_powExpr452);
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
    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:81:1: unaryExpr returns [Atom a] : ( MINUS uminus= unaryExpr | 'NOT' unot= unaryExpr | atom );
    public final Atom unaryExpr() throws RecognitionException {
        Atom a = null;

        Atom uminus = null;

        Atom unot = null;


        try {
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:83:5: ( MINUS uminus= unaryExpr | 'NOT' unot= unaryExpr | atom )
            int alt10=3;
            switch ( input.LA(1) ) {
            case MINUS:
                {
                alt10=1;
                }
                break;
            case 36:
                {
                alt10=2;
                }
                break;
            case NUMBER:
            case STRING_LITERAL:
            case LPAREN:
            case ID:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 44:
            case 45:
                {
                alt10=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("81:1: unaryExpr returns [Atom a] : ( MINUS uminus= unaryExpr | 'NOT' unot= unaryExpr | atom );", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:83:5: MINUS uminus= unaryExpr
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_unaryExpr488); 
                    pushFollow(FOLLOW_unaryExpr_in_unaryExpr494);
                    uminus=unaryExpr();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:86:5: 'NOT' unot= unaryExpr
                    {
                    match(input,36,FOLLOW_36_in_unaryExpr511); 
                    pushFollow(FOLLOW_unaryExpr_in_unaryExpr517);
                    unot=unaryExpr();
                    _fsp--;


                    }
                    break;
                case 3 :
                    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:88:5: atom
                    {
                    pushFollow(FOLLOW_atom_in_unaryExpr529);
                    atom();
                    _fsp--;


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
        return a;
    }
    // $ANTLR end unaryExpr


    // $ANTLR start atom
    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:91:1: atom returns [Atom a] : (number= NUMBER | id= scoped_id | def= definition | sl= STRING_LITERAL | bl= boolean_keywords | LPAREN inner= compareExpr RPAREN ) ;
    public final Atom atom() throws RecognitionException {
        Atom a = null;

        Token number=null;
        Token sl=null;
        AbstractNamedReference id = null;

        ProbabilityFunctionLiteral def = null;

        String bl = null;

        Comparison inner = null;


        try {
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:93:3: ( (number= NUMBER | id= scoped_id | def= definition | sl= STRING_LITERAL | bl= boolean_keywords | LPAREN inner= compareExpr RPAREN ) )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:93:3: (number= NUMBER | id= scoped_id | def= definition | sl= STRING_LITERAL | bl= boolean_keywords | LPAREN inner= compareExpr RPAREN )
            {
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:93:3: (number= NUMBER | id= scoped_id | def= definition | sl= STRING_LITERAL | bl= boolean_keywords | LPAREN inner= compareExpr RPAREN )
            int alt11=6;
            switch ( input.LA(1) ) {
            case NUMBER:
                {
                alt11=1;
                }
                break;
            case ID:
                {
                alt11=2;
                }
                break;
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
                {
                alt11=3;
                }
                break;
            case STRING_LITERAL:
                {
                alt11=4;
                }
                break;
            case 44:
            case 45:
                {
                alt11=5;
                }
                break;
            case LPAREN:
                {
                alt11=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("93:3: (number= NUMBER | id= scoped_id | def= definition | sl= STRING_LITERAL | bl= boolean_keywords | LPAREN inner= compareExpr RPAREN )", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:95:5: number= NUMBER
                    {
                    number=(Token)input.LT(1);
                    match(input,NUMBER,FOLLOW_NUMBER_in_atom563); 
                    
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
                    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:113:5: id= scoped_id
                    {
                    pushFollow(FOLLOW_scoped_id_in_atom590);
                    id=scoped_id();
                    _fsp--;

                     a = StoexFactory.eINSTANCE.createVariable();
                    		  	((Variable)a).setId_Variable(id);
                    		  

                    }
                    break;
                case 3 :
                    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:119:5: def= definition
                    {
                    pushFollow(FOLLOW_definition_in_atom619);
                    def=definition();
                    _fsp--;

                    a=def;

                    }
                    break;
                case 4 :
                    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:123:5: sl= STRING_LITERAL
                    {
                    sl=(Token)input.LT(1);
                    match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_atom644); 
                    
                    		  	StringLiteral stringLiteral = StoexFactory.eINSTANCE.createStringLiteral();
                    		  	stringLiteral.setValue(sl.getText().replace("\"",""));
                    		  

                    }
                    break;
                case 5 :
                    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:130:5: bl= boolean_keywords
                    {
                    pushFollow(FOLLOW_boolean_keywords_in_atom671);
                    bl=boolean_keywords();
                    _fsp--;

                    
                    		  	BoolLiteral boolLiteral = StoexFactory.eINSTANCE.createBoolLiteral();
                    	   		boolLiteral.setValue(bl.equals("true"));
                    	   	  

                    }
                    break;
                case 6 :
                    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:137:5: LPAREN inner= compareExpr RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_atom695); 
                    pushFollow(FOLLOW_compareExpr_in_atom705);
                    inner=compareExpr();
                    _fsp--;

                    match(input,RPAREN,FOLLOW_RPAREN_in_atom711); 
                    
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


    // $ANTLR start definition
    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:148:1: definition returns [ProbabilityFunctionLiteral pfl] : ( 'IntPMF' ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (isample= numeric_int_sample )+ SQUARE_PAREN_R | 'DoublePMF' ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (rsample= numeric_real_sample )+ SQUARE_PAREN_R | 'EnumPMF' ( LPAREN (uunit= unit ) ( SEMI ORDERED_DEF ) RPAREN )? SQUARE_PAREN_L (ssample= stringsample )+ SQUARE_PAREN_R | 'DoublePDF' ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (pdf_sample= real_pdf_sample )+ SQUARE_PAREN_R | 'BoolPMF' ( LPAREN (uunit= bool_unit ) ( SEMI ORDERED_DEF )? RPAREN )? SQUARE_PAREN_L (ssample= boolsample )+ SQUARE_PAREN_R );
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
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:154:4: ( 'IntPMF' ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (isample= numeric_int_sample )+ SQUARE_PAREN_R | 'DoublePMF' ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (rsample= numeric_real_sample )+ SQUARE_PAREN_R | 'EnumPMF' ( LPAREN (uunit= unit ) ( SEMI ORDERED_DEF ) RPAREN )? SQUARE_PAREN_L (ssample= stringsample )+ SQUARE_PAREN_R | 'DoublePDF' ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (pdf_sample= real_pdf_sample )+ SQUARE_PAREN_R | 'BoolPMF' ( LPAREN (uunit= bool_unit ) ( SEMI ORDERED_DEF )? RPAREN )? SQUARE_PAREN_L (ssample= boolsample )+ SQUARE_PAREN_R )
            int alt23=5;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt23=1;
                }
                break;
            case 38:
                {
                alt23=2;
                }
                break;
            case 39:
                {
                alt23=3;
                }
                break;
            case 40:
                {
                alt23=4;
                }
                break;
            case 41:
                {
                alt23=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("148:1: definition returns [ProbabilityFunctionLiteral pfl] : ( 'IntPMF' ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (isample= numeric_int_sample )+ SQUARE_PAREN_R | 'DoublePMF' ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (rsample= numeric_real_sample )+ SQUARE_PAREN_R | 'EnumPMF' ( LPAREN (uunit= unit ) ( SEMI ORDERED_DEF ) RPAREN )? SQUARE_PAREN_L (ssample= stringsample )+ SQUARE_PAREN_R | 'DoublePDF' ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (pdf_sample= real_pdf_sample )+ SQUARE_PAREN_R | 'BoolPMF' ( LPAREN (uunit= bool_unit ) ( SEMI ORDERED_DEF )? RPAREN )? SQUARE_PAREN_L (ssample= boolsample )+ SQUARE_PAREN_R );", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:154:4: 'IntPMF' ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (isample= numeric_int_sample )+ SQUARE_PAREN_R
                    {
                    match(input,37,FOLLOW_37_in_definition760); 
                    probFunction = ProbfunctionFactory.eINSTANCE.createProbabilityMassFunction();
                    				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
                    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:157:4: ( LPAREN (uunit= unit ) RPAREN )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==LPAREN) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:157:5: LPAREN (uunit= unit ) RPAREN
                            {
                            match(input,LPAREN,FOLLOW_LPAREN_in_definition772); 
                            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:158:6: (uunit= unit )
                            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:159:6: uunit= unit
                            {
                            pushFollow(FOLLOW_unit_in_definition790);
                            uunit=unit();
                            _fsp--;

                            probFunction.setUnit(uunit);

                            }

                            match(input,RPAREN,FOLLOW_RPAREN_in_definition804); 

                            }
                            break;

                    }

                    match(input,SQUARE_PAREN_L,FOLLOW_SQUARE_PAREN_L_in_definition811); 
                    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:163:5: (isample= numeric_int_sample )+
                    int cnt13=0;
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==LPAREN) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:164:7: isample= numeric_int_sample
                    	    {
                    	    pushFollow(FOLLOW_numeric_int_sample_in_definition831);
                    	    isample=numeric_int_sample();
                    	    _fsp--;

                    	    ((ProbabilityMassFunction)probFunction).getSamples().add(isample);

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt13 >= 1 ) break loop13;
                                EarlyExitException eee =
                                    new EarlyExitException(13, input);
                                throw eee;
                        }
                        cnt13++;
                    } while (true);

                    match(input,SQUARE_PAREN_R,FOLLOW_SQUARE_PAREN_R_in_definition848); 

                    }
                    break;
                case 2 :
                    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:168:5: 'DoublePMF' ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (rsample= numeric_real_sample )+ SQUARE_PAREN_R
                    {
                    match(input,38,FOLLOW_38_in_definition861); 
                    probFunction = ProbfunctionFactory.eINSTANCE.createProbabilityMassFunction();
                    				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
                    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:171:4: ( LPAREN (uunit= unit ) RPAREN )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==LPAREN) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:171:5: LPAREN (uunit= unit ) RPAREN
                            {
                            match(input,LPAREN,FOLLOW_LPAREN_in_definition874); 
                            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:172:6: (uunit= unit )
                            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:173:6: uunit= unit
                            {
                            pushFollow(FOLLOW_unit_in_definition892);
                            uunit=unit();
                            _fsp--;

                            probFunction.setUnit(uunit);

                            }

                            match(input,RPAREN,FOLLOW_RPAREN_in_definition906); 

                            }
                            break;

                    }

                    match(input,SQUARE_PAREN_L,FOLLOW_SQUARE_PAREN_L_in_definition914); 
                    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:177:5: (rsample= numeric_real_sample )+
                    int cnt15=0;
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==LPAREN) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:178:5: rsample= numeric_real_sample
                    	    {
                    	    pushFollow(FOLLOW_numeric_real_sample_in_definition932);
                    	    rsample=numeric_real_sample();
                    	    _fsp--;

                    	    ((ProbabilityMassFunction)probFunction).getSamples().add(rsample);

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt15 >= 1 ) break loop15;
                                EarlyExitException eee =
                                    new EarlyExitException(15, input);
                                throw eee;
                        }
                        cnt15++;
                    } while (true);

                    match(input,SQUARE_PAREN_R,FOLLOW_SQUARE_PAREN_R_in_definition949); 

                    }
                    break;
                case 3 :
                    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:183:4: 'EnumPMF' ( LPAREN (uunit= unit ) ( SEMI ORDERED_DEF ) RPAREN )? SQUARE_PAREN_L (ssample= stringsample )+ SQUARE_PAREN_R
                    {
                    match(input,39,FOLLOW_39_in_definition963); 
                    probFunction = ProbfunctionFactory.eINSTANCE.createProbabilityMassFunction();
                    				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
                    				   ((ProbabilityMassFunction)probFunction).setOrderedDomain(false);
                    				   
                    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:188:4: ( LPAREN (uunit= unit ) ( SEMI ORDERED_DEF ) RPAREN )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==LPAREN) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:188:5: LPAREN (uunit= unit ) ( SEMI ORDERED_DEF ) RPAREN
                            {
                            match(input,LPAREN,FOLLOW_LPAREN_in_definition976); 
                            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:189:6: (uunit= unit )
                            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:190:6: uunit= unit
                            {
                            pushFollow(FOLLOW_unit_in_definition994);
                            uunit=unit();
                            _fsp--;

                            probFunction.setUnit(uunit);

                            }

                            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:192:6: ( SEMI ORDERED_DEF )
                            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:192:7: SEMI ORDERED_DEF
                            {
                            match(input,SEMI,FOLLOW_SEMI_in_definition1011); 
                            match(input,ORDERED_DEF,FOLLOW_ORDERED_DEF_in_definition1018); 
                            ((ProbabilityMassFunction)probFunction).setOrderedDomain(true);

                            }

                            match(input,RPAREN,FOLLOW_RPAREN_in_definition1037); 

                            }
                            break;

                    }

                    match(input,SQUARE_PAREN_L,FOLLOW_SQUARE_PAREN_L_in_definition1044); 
                    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:198:5: (ssample= stringsample )+
                    int cnt17=0;
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==LPAREN) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:199:5: ssample= stringsample
                    	    {
                    	    pushFollow(FOLLOW_stringsample_in_definition1062);
                    	    ssample=stringsample();
                    	    _fsp--;

                    	    ((ProbabilityMassFunction)probFunction).getSamples().add(ssample);

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt17 >= 1 ) break loop17;
                                EarlyExitException eee =
                                    new EarlyExitException(17, input);
                                throw eee;
                        }
                        cnt17++;
                    } while (true);

                    match(input,SQUARE_PAREN_R,FOLLOW_SQUARE_PAREN_R_in_definition1079); 

                    }
                    break;
                case 4 :
                    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:203:4: 'DoublePDF' ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (pdf_sample= real_pdf_sample )+ SQUARE_PAREN_R
                    {
                    match(input,40,FOLLOW_40_in_definition1089); 
                    probFunction = ProbfunctionFactory.eINSTANCE.createBoxedPDF();
                    				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
                    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:206:4: ( LPAREN (uunit= unit ) RPAREN )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==LPAREN) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:206:5: LPAREN (uunit= unit ) RPAREN
                            {
                            match(input,LPAREN,FOLLOW_LPAREN_in_definition1101); 
                            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:207:6: (uunit= unit )
                            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:208:6: uunit= unit
                            {
                            pushFollow(FOLLOW_unit_in_definition1119);
                            uunit=unit();
                            _fsp--;

                            probFunction.setUnit(uunit);

                            }

                            match(input,RPAREN,FOLLOW_RPAREN_in_definition1133); 

                            }
                            break;

                    }

                    match(input,SQUARE_PAREN_L,FOLLOW_SQUARE_PAREN_L_in_definition1140); 
                    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:212:5: (pdf_sample= real_pdf_sample )+
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
                    	    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:213:7: pdf_sample= real_pdf_sample
                    	    {
                    	    pushFollow(FOLLOW_real_pdf_sample_in_definition1160);
                    	    pdf_sample=real_pdf_sample();
                    	    _fsp--;

                    	    ((BoxedPDF)probFunction).getSamples().add(pdf_sample);

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

                    match(input,SQUARE_PAREN_R,FOLLOW_SQUARE_PAREN_R_in_definition1177); 

                    }
                    break;
                case 5 :
                    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:217:4: 'BoolPMF' ( LPAREN (uunit= bool_unit ) ( SEMI ORDERED_DEF )? RPAREN )? SQUARE_PAREN_L (ssample= boolsample )+ SQUARE_PAREN_R
                    {
                    match(input,41,FOLLOW_41_in_definition1188); 
                    probFunction = ProbfunctionFactory.eINSTANCE.createProbabilityMassFunction();
                    				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
                    				   ((ProbabilityMassFunction)probFunction).setOrderedDomain(false);
                    				   
                    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:222:4: ( LPAREN (uunit= bool_unit ) ( SEMI ORDERED_DEF )? RPAREN )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==LPAREN) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:222:5: LPAREN (uunit= bool_unit ) ( SEMI ORDERED_DEF )? RPAREN
                            {
                            match(input,LPAREN,FOLLOW_LPAREN_in_definition1201); 
                            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:223:6: (uunit= bool_unit )
                            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:224:6: uunit= bool_unit
                            {
                            pushFollow(FOLLOW_bool_unit_in_definition1219);
                            uunit=bool_unit();
                            _fsp--;

                            probFunction.setUnit(uunit);

                            }

                            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:226:6: ( SEMI ORDERED_DEF )?
                            int alt20=2;
                            int LA20_0 = input.LA(1);

                            if ( (LA20_0==SEMI) ) {
                                alt20=1;
                            }
                            switch (alt20) {
                                case 1 :
                                    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:226:7: SEMI ORDERED_DEF
                                    {
                                    match(input,SEMI,FOLLOW_SEMI_in_definition1236); 
                                    match(input,ORDERED_DEF,FOLLOW_ORDERED_DEF_in_definition1243); 
                                    ((ProbabilityMassFunction)probFunction).setOrderedDomain(true);

                                    }
                                    break;

                            }

                            match(input,RPAREN,FOLLOW_RPAREN_in_definition1263); 

                            }
                            break;

                    }

                    match(input,SQUARE_PAREN_L,FOLLOW_SQUARE_PAREN_L_in_definition1270); 
                    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:232:5: (ssample= boolsample )+
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
                    	    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:233:5: ssample= boolsample
                    	    {
                    	    pushFollow(FOLLOW_boolsample_in_definition1288);
                    	    ssample=boolsample();
                    	    _fsp--;

                    	    ((ProbabilityMassFunction)probFunction).getSamples().add(ssample);

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

                    match(input,SQUARE_PAREN_R,FOLLOW_SQUARE_PAREN_R_in_definition1305); 

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
    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:239:1: unit returns [Unit u] : 'unit' DEFINITION str= STRING_LITERAL ;
    public final Unit unit() throws RecognitionException {
        Unit u = null;

        Token str=null;

        try {
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:241:3: ( 'unit' DEFINITION str= STRING_LITERAL )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:241:3: 'unit' DEFINITION str= STRING_LITERAL
            {
            match(input,42,FOLLOW_42_in_unit1329); 
             u = ProbfunctionFactory.eINSTANCE.createUnit(); 
            match(input,DEFINITION,FOLLOW_DEFINITION_in_unit1339); 
            str=(Token)input.LT(1);
            match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_unit1346); 
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
    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:247:1: bool_unit returns [Unit u] : 'unit' EQUAL '\"bool\"' ;
    public final Unit bool_unit() throws RecognitionException {
        Unit u = null;

        try {
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:249:3: ( 'unit' EQUAL '\"bool\"' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:249:3: 'unit' EQUAL '\"bool\"'
            {
            match(input,42,FOLLOW_42_in_bool_unit1368); 
             u = ProbfunctionFactory.eINSTANCE.createUnit(); 
            match(input,EQUAL,FOLLOW_EQUAL_in_bool_unit1378); 
            match(input,43,FOLLOW_43_in_bool_unit1383); 
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
    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:256:1: numeric_int_sample returns [Sample s] : LPAREN n= NUMBER SEMI n2= NUMBER RPAREN ;
    public final Sample numeric_int_sample() throws RecognitionException {
        Sample s = null;

        Token n=null;
        Token n2=null;

        s = null;
        try {
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:258:3: ( LPAREN n= NUMBER SEMI n2= NUMBER RPAREN )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:258:3: LPAREN n= NUMBER SEMI n2= NUMBER RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_numeric_int_sample1411); 
            s = ProbfunctionFactory.eINSTANCE.createSample();
            n=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_numeric_int_sample1424); 
            s.setValue(Integer.parseInt(n.getText()));
            match(input,SEMI,FOLLOW_SEMI_in_numeric_int_sample1435); 
            n2=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_numeric_int_sample1443); 
            s.setProbability(Double.parseDouble(n2.getText()));
            match(input,RPAREN,FOLLOW_RPAREN_in_numeric_int_sample1455); 

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
    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:267:1: numeric_real_sample returns [Sample s] : LPAREN n= NUMBER SEMI n2= NUMBER RPAREN ;
    public final Sample numeric_real_sample() throws RecognitionException {
        Sample s = null;

        Token n=null;
        Token n2=null;

        s = null;
        try {
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:269:3: ( LPAREN n= NUMBER SEMI n2= NUMBER RPAREN )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:269:3: LPAREN n= NUMBER SEMI n2= NUMBER RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_numeric_real_sample1478); 
            s = ProbfunctionFactory.eINSTANCE.createSample();
            n=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_numeric_real_sample1491); 
            s.setValue(Double.parseDouble(n.getText()));
            match(input,SEMI,FOLLOW_SEMI_in_numeric_real_sample1502); 
            n2=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_numeric_real_sample1510); 
            s.setProbability(Double.parseDouble(n2.getText()));
            match(input,RPAREN,FOLLOW_RPAREN_in_numeric_real_sample1522); 

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
    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:278:1: real_pdf_sample returns [ContinuousSample s] : LPAREN n= NUMBER SEMI n2= NUMBER RPAREN ;
    public final ContinuousSample real_pdf_sample() throws RecognitionException {
        ContinuousSample s = null;

        Token n=null;
        Token n2=null;

        s = null;
        try {
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:280:3: ( LPAREN n= NUMBER SEMI n2= NUMBER RPAREN )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:280:3: LPAREN n= NUMBER SEMI n2= NUMBER RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_real_pdf_sample1546); 
            s = ProbfunctionFactory.eINSTANCE.createContinuousSample();
            n=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_real_pdf_sample1559); 
            s.setValue(Double.parseDouble(n.getText()));
            match(input,SEMI,FOLLOW_SEMI_in_real_pdf_sample1570); 
            n2=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_real_pdf_sample1578); 
            s.setProbability(Double.parseDouble(n2.getText()));
            match(input,RPAREN,FOLLOW_RPAREN_in_real_pdf_sample1590); 

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
    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:289:1: stringsample returns [Sample s] : LPAREN str= STRING_LITERAL SEMI n= NUMBER RPAREN ;
    public final Sample stringsample() throws RecognitionException {
        Sample s = null;

        Token str=null;
        Token n=null;

        try {
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:291:3: ( LPAREN str= STRING_LITERAL SEMI n= NUMBER RPAREN )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:291:3: LPAREN str= STRING_LITERAL SEMI n= NUMBER RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_stringsample1611); 
            s = ProbfunctionFactory.eINSTANCE.createSample();
            str=(Token)input.LT(1);
            match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_stringsample1623); 
            s.setValue(str.getText().replace("\"",""));
            match(input,SEMI,FOLLOW_SEMI_in_stringsample1634); 
            n=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_stringsample1640); 
            s.setProbability(Double.parseDouble(n.getText()));
            match(input,RPAREN,FOLLOW_RPAREN_in_stringsample1651); 

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
    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:300:1: boolsample returns [Sample s] : LPAREN str= boolean_keywords SEMI n= NUMBER RPAREN ;
    public final Sample boolsample() throws RecognitionException {
        Sample s = null;

        Token n=null;
        String str = null;


        try {
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:302:3: ( LPAREN str= boolean_keywords SEMI n= NUMBER RPAREN )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:302:3: LPAREN str= boolean_keywords SEMI n= NUMBER RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_boolsample1669); 
            s = ProbfunctionFactory.eINSTANCE.createSample();
            pushFollow(FOLLOW_boolean_keywords_in_boolsample1683);
            str=boolean_keywords();
            _fsp--;

            s.setValue(str);
            match(input,SEMI,FOLLOW_SEMI_in_boolsample1691); 
            n=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_boolsample1697); 
            s.setProbability(Double.parseDouble(n.getText()));
            match(input,RPAREN,FOLLOW_RPAREN_in_boolsample1708); 

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
    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:311:1: boolean_keywords returns [String keyword] : ( 'false' | 'true' ) ;
    public final String boolean_keywords() throws RecognitionException {
        String keyword = null;

        try {
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:313:3: ( ( 'false' | 'true' ) )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:313:3: ( 'false' | 'true' )
            {
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:313:3: ( 'false' | 'true' )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==44) ) {
                alt24=1;
            }
            else if ( (LA24_0==45) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("313:3: ( 'false' | 'true' )", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:314:3: 'false'
                    {
                    match(input,44,FOLLOW_44_in_boolean_keywords1727); 
                    keyword = "false";

                    }
                    break;
                case 2 :
                    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:317:3: 'true'
                    {
                    match(input,45,FOLLOW_45_in_boolean_keywords1741); 
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
    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:321:1: characterisation_keywords returns [String keyword] : ( 'BYTESIZE' | 'STRUCTURE' | 'NUMBER_OF_ELEMENTS' | 'TYPE' | 'VALUE' ) ;
    public final String characterisation_keywords() throws RecognitionException {
        String keyword = null;

        keyword = null;
        try {
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:323:2: ( ( 'BYTESIZE' | 'STRUCTURE' | 'NUMBER_OF_ELEMENTS' | 'TYPE' | 'VALUE' ) )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:323:2: ( 'BYTESIZE' | 'STRUCTURE' | 'NUMBER_OF_ELEMENTS' | 'TYPE' | 'VALUE' )
            {
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:323:2: ( 'BYTESIZE' | 'STRUCTURE' | 'NUMBER_OF_ELEMENTS' | 'TYPE' | 'VALUE' )
            int alt25=5;
            switch ( input.LA(1) ) {
            case 46:
                {
                alt25=1;
                }
                break;
            case 47:
                {
                alt25=2;
                }
                break;
            case 48:
                {
                alt25=3;
                }
                break;
            case 49:
                {
                alt25=4;
                }
                break;
            case 50:
                {
                alt25=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("323:2: ( 'BYTESIZE' | 'STRUCTURE' | 'NUMBER_OF_ELEMENTS' | 'TYPE' | 'VALUE' )", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:323:3: 'BYTESIZE'
                    {
                    match(input,46,FOLLOW_46_in_characterisation_keywords1769); 
                    keyword="BYTESIZE";

                    }
                    break;
                case 2 :
                    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:324:4: 'STRUCTURE'
                    {
                    match(input,47,FOLLOW_47_in_characterisation_keywords1776); 
                    keyword="STRUCTURE";

                    }
                    break;
                case 3 :
                    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:325:4: 'NUMBER_OF_ELEMENTS'
                    {
                    match(input,48,FOLLOW_48_in_characterisation_keywords1783); 
                    keyword="NUMBER_OF_ELEMENTS";

                    }
                    break;
                case 4 :
                    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:326:4: 'TYPE'
                    {
                    match(input,49,FOLLOW_49_in_characterisation_keywords1790); 
                    keyword="TYPE";

                    }
                    break;
                case 5 :
                    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:327:4: 'VALUE'
                    {
                    match(input,50,FOLLOW_50_in_characterisation_keywords1797); 
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
    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:330:1: scoped_id returns [AbstractNamedReference ref] : id1= ID ( DOT (id2= ID | 'INNER' ) )* ;
    public final AbstractNamedReference scoped_id() throws RecognitionException {
        AbstractNamedReference ref = null;

        Token id1=null;
        Token id2=null;

        ref = null;
        		ArrayList<String> nameParts = new ArrayList<String>();
        try {
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:334:2: (id1= ID ( DOT (id2= ID | 'INNER' ) )* )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:334:2: id1= ID ( DOT (id2= ID | 'INNER' ) )*
            {
            id1=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_scoped_id1827); 
            nameParts.add(id1.getText());
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:335:6: ( DOT (id2= ID | 'INNER' ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==DOT) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:335:7: DOT (id2= ID | 'INNER' )
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_scoped_id1838); 
            	    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:335:11: (id2= ID | 'INNER' )
            	    int alt26=2;
            	    int LA26_0 = input.LA(1);

            	    if ( (LA26_0==ID) ) {
            	        alt26=1;
            	    }
            	    else if ( (LA26_0==51) ) {
            	        alt26=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("335:11: (id2= ID | 'INNER' )", 26, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt26) {
            	        case 1 :
            	            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:335:12: id2= ID
            	            {
            	            id2=(Token)input.LT(1);
            	            match(input,ID,FOLLOW_ID_in_scoped_id1843); 
            	            nameParts.add(id2.getText());

            	            }
            	            break;
            	        case 2 :
            	            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:335:53: 'INNER'
            	            {
            	            match(input,51,FOLLOW_51_in_scoped_id1849); 
            	            nameParts.add("INNER");

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
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


 

    public static final BitSet FOLLOW_boolOrExpr_in_expression33 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolAndExpr_in_boolOrExpr57 = new BitSet(new long[]{0x0000000600000002L});
    public static final BitSet FOLLOW_set_in_boolOrExpr63 = new BitSet(new long[]{0x000033F002070800L});
    public static final BitSet FOLLOW_boolAndExpr_in_boolOrExpr79 = new BitSet(new long[]{0x0000000600000002L});
    public static final BitSet FOLLOW_compareExpr_in_boolAndExpr105 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_boolAndExpr111 = new BitSet(new long[]{0x000033F002070800L});
    public static final BitSet FOLLOW_compareExpr_in_boolAndExpr117 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_sumExpr_in_compareExpr146 = new BitSet(new long[]{0x00000000000003F2L});
    public static final BitSet FOLLOW_GREATER_in_compareExpr163 = new BitSet(new long[]{0x000033F002070800L});
    public static final BitSet FOLLOW_LESS_in_compareExpr173 = new BitSet(new long[]{0x000033F002070800L});
    public static final BitSet FOLLOW_EQUAL_in_compareExpr183 = new BitSet(new long[]{0x000033F002070800L});
    public static final BitSet FOLLOW_NOTEQUAL_in_compareExpr193 = new BitSet(new long[]{0x000033F002070800L});
    public static final BitSet FOLLOW_GREATEREQUAL_in_compareExpr203 = new BitSet(new long[]{0x000033F002070800L});
    public static final BitSet FOLLOW_LESSEQUAL_in_compareExpr213 = new BitSet(new long[]{0x000033F002070800L});
    public static final BitSet FOLLOW_sumExpr_in_compareExpr228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_prodExpr_in_sumExpr260 = new BitSet(new long[]{0x0000000000000C02L});
    public static final BitSet FOLLOW_PLUS_in_sumExpr278 = new BitSet(new long[]{0x000033F002070800L});
    public static final BitSet FOLLOW_MINUS_in_sumExpr286 = new BitSet(new long[]{0x000033F002070800L});
    public static final BitSet FOLLOW_prodExpr_in_sumExpr300 = new BitSet(new long[]{0x0000000000000C02L});
    public static final BitSet FOLLOW_powExpr_in_prodExpr338 = new BitSet(new long[]{0x0000000000007002L});
    public static final BitSet FOLLOW_MUL_in_prodExpr358 = new BitSet(new long[]{0x000033F002070800L});
    public static final BitSet FOLLOW_DIV_in_prodExpr369 = new BitSet(new long[]{0x000033F002070800L});
    public static final BitSet FOLLOW_MOD_in_prodExpr380 = new BitSet(new long[]{0x000033F002070800L});
    public static final BitSet FOLLOW_powExpr_in_prodExpr396 = new BitSet(new long[]{0x0000000000007002L});
    public static final BitSet FOLLOW_unaryExpr_in_powExpr437 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_POW_in_powExpr446 = new BitSet(new long[]{0x000033F002070800L});
    public static final BitSet FOLLOW_unaryExpr_in_powExpr452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_unaryExpr488 = new BitSet(new long[]{0x000033F002070800L});
    public static final BitSet FOLLOW_unaryExpr_in_unaryExpr494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_unaryExpr511 = new BitSet(new long[]{0x000033F002070800L});
    public static final BitSet FOLLOW_unaryExpr_in_unaryExpr517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_unaryExpr529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_atom563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scoped_id_in_atom590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definition_in_atom619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_atom644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolean_keywords_in_atom671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_atom695 = new BitSet(new long[]{0x000033F002070800L});
    public static final BitSet FOLLOW_compareExpr_in_atom705 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_RPAREN_in_atom711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_definition760 = new BitSet(new long[]{0x0000000000140000L});
    public static final BitSet FOLLOW_LPAREN_in_definition772 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_unit_in_definition790 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_RPAREN_in_definition804 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_L_in_definition811 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_numeric_int_sample_in_definition831 = new BitSet(new long[]{0x0000000000240000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_R_in_definition848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_definition861 = new BitSet(new long[]{0x0000000000140000L});
    public static final BitSet FOLLOW_LPAREN_in_definition874 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_unit_in_definition892 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_RPAREN_in_definition906 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_L_in_definition914 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_numeric_real_sample_in_definition932 = new BitSet(new long[]{0x0000000000240000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_R_in_definition949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_definition963 = new BitSet(new long[]{0x0000000000140000L});
    public static final BitSet FOLLOW_LPAREN_in_definition976 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_unit_in_definition994 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMI_in_definition1011 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_ORDERED_DEF_in_definition1018 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_RPAREN_in_definition1037 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_L_in_definition1044 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_stringsample_in_definition1062 = new BitSet(new long[]{0x0000000000240000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_R_in_definition1079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_definition1089 = new BitSet(new long[]{0x0000000000140000L});
    public static final BitSet FOLLOW_LPAREN_in_definition1101 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_unit_in_definition1119 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_RPAREN_in_definition1133 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_L_in_definition1140 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_real_pdf_sample_in_definition1160 = new BitSet(new long[]{0x0000000000240000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_R_in_definition1177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_definition1188 = new BitSet(new long[]{0x0000000000140000L});
    public static final BitSet FOLLOW_LPAREN_in_definition1201 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_bool_unit_in_definition1219 = new BitSet(new long[]{0x0000000000480000L});
    public static final BitSet FOLLOW_SEMI_in_definition1236 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_ORDERED_DEF_in_definition1243 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_RPAREN_in_definition1263 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_L_in_definition1270 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_boolsample_in_definition1288 = new BitSet(new long[]{0x0000000000240000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_R_in_definition1305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_unit1329 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_DEFINITION_in_unit1339 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_unit1346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_bool_unit1368 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUAL_in_bool_unit1378 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_bool_unit1383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_numeric_int_sample1411 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NUMBER_in_numeric_int_sample1424 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMI_in_numeric_int_sample1435 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NUMBER_in_numeric_int_sample1443 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_RPAREN_in_numeric_int_sample1455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_numeric_real_sample1478 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NUMBER_in_numeric_real_sample1491 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMI_in_numeric_real_sample1502 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NUMBER_in_numeric_real_sample1510 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_RPAREN_in_numeric_real_sample1522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_real_pdf_sample1546 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NUMBER_in_real_pdf_sample1559 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMI_in_real_pdf_sample1570 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NUMBER_in_real_pdf_sample1578 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_RPAREN_in_real_pdf_sample1590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_stringsample1611 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_stringsample1623 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMI_in_stringsample1634 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NUMBER_in_stringsample1640 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_RPAREN_in_stringsample1651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_boolsample1669 = new BitSet(new long[]{0x0000300000000000L});
    public static final BitSet FOLLOW_boolean_keywords_in_boolsample1683 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_SEMI_in_boolsample1691 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NUMBER_in_boolsample1697 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_RPAREN_in_boolsample1708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_boolean_keywords1727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_boolean_keywords1741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_characterisation_keywords1769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_characterisation_keywords1776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_characterisation_keywords1783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_characterisation_keywords1790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_characterisation_keywords1797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_scoped_id1827 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_DOT_in_scoped_id1838 = new BitSet(new long[]{0x0008000002000000L});
    public static final BitSet FOLLOW_ID_in_scoped_id1843 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_51_in_scoped_id1849 = new BitSet(new long[]{0x0000000004000002L});

}
// $ANTLR 3.0 C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g 2007-06-14 10:08:29
  
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

public class PCMStoExParserParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "GREATER", "LESS", "EQUAL", "NOTEQUAL", "GREATEREQUAL", "LESSEQUAL", "PLUS", "MINUS", "MUL", "DIV", "MOD", "POW", "NUMBER", "DOT", "STRING_LITERAL", "LPAREN", "RPAREN", "SQUARE_PAREN_L", "SQUARE_PAREN_R", "SEMI", "ORDERED_DEF", "DEFINITION", "ID", "DIGIT", "Exponent", "ALPHA", "WS", "COMMENT", "LINE_COMMENT", "'OR'", "'XOR'", "'AND'", "'NOT'", "'IntPMF'", "'DoublePMF'", "'EnumPMF'", "'DoublePDF'", "'BoolPMF'", "'unit'", "'\"bool\"'", "'false'", "'true'", "'BYTESIZE'", "'STRUCTURE'", "'NUMBER_OF_ELEMENTS'", "'TYPE'", "'VALUE'", "'INNER'"
    };
    public static final int LINE_COMMENT=32;
    public static final int MOD=14;
    public static final int NUMBER=16;
    public static final int Exponent=28;
    public static final int GREATEREQUAL=8;
    public static final int MINUS=11;
    public static final int ID=26;
    public static final int EOF=-1;
    public static final int SEMI=23;
    public static final int MUL=12;
    public static final int ALPHA=29;
    public static final int LPAREN=19;
    public static final int NOTEQUAL=7;
    public static final int SQUARE_PAREN_R=22;
    public static final int RPAREN=20;
    public static final int WS=30;
    public static final int GREATER=4;
    public static final int STRING_LITERAL=18;
    public static final int POW=15;
    public static final int SQUARE_PAREN_L=21;
    public static final int EQUAL=6;
    public static final int LESS=5;
    public static final int DEFINITION=25;
    public static final int PLUS=10;
    public static final int DIGIT=27;
    public static final int DIV=13;
    public static final int COMMENT=31;
    public static final int ORDERED_DEF=24;
    public static final int DOT=17;
    public static final int LESSEQUAL=9;

        public PCMStoExParserParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g"; }



    // $ANTLR start expression
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:14:1: expression returns [Expression exp] : c= boolOrExpr ;
    public final Expression expression() throws RecognitionException {
        Expression exp = null;

        BooleanExpression c = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:16:4: (c= boolOrExpr )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:16:4: c= boolOrExpr
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:19:1: boolOrExpr returns [BooleanExpression boolExp] : b1= boolAndExpr ( ( 'OR' | 'XOR' ) boolAndExpr )* ;
    public final BooleanExpression boolOrExpr() throws RecognitionException {
        BooleanExpression boolExp = null;

        BooleanExpression b1 = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:21:2: (b1= boolAndExpr ( ( 'OR' | 'XOR' ) boolAndExpr )* )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:21:2: b1= boolAndExpr ( ( 'OR' | 'XOR' ) boolAndExpr )*
            {
            pushFollow(FOLLOW_boolAndExpr_in_boolOrExpr57);
            b1=boolAndExpr();
            _fsp--;

            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:22:3: ( ( 'OR' | 'XOR' ) boolAndExpr )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=33 && LA1_0<=34)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:22:4: ( 'OR' | 'XOR' ) boolAndExpr
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:28:1: boolAndExpr returns [BooleanExpression boolExp] : b1= compareExpr ( 'AND' compareExpr )* ;
    public final BooleanExpression boolAndExpr() throws RecognitionException {
        BooleanExpression boolExp = null;

        Comparison b1 = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:30:2: (b1= compareExpr ( 'AND' compareExpr )* )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:30:2: b1= compareExpr ( 'AND' compareExpr )*
            {
            pushFollow(FOLLOW_compareExpr_in_boolAndExpr105);
            b1=compareExpr();
            _fsp--;

            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:31:3: ( 'AND' compareExpr )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==35) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:31:4: 'AND' compareExpr
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:37:1: compareExpr returns [Comparison comp] : t1= sumExpr ( ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL ) t2= sumExpr )? ;
    public final Comparison compareExpr() throws RecognitionException {
        Comparison comp = null;

        Term t1 = null;

        Term t2 = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:39:4: (t1= sumExpr ( ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL ) t2= sumExpr )? )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:39:4: t1= sumExpr ( ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL ) t2= sumExpr )?
            {
            pushFollow(FOLLOW_sumExpr_in_compareExpr146);
            t1=sumExpr();
            _fsp--;

            comp = t1;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:39:30: ( ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL ) t2= sumExpr )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=GREATER && LA4_0<=LESSEQUAL)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:40:5: ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL ) t2= sumExpr
                    {
                    CompareExpression compExp = StoexFactory.eINSTANCE.createCompareExpression();
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:41:5: ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL )
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
                            new NoViableAltException("41:5: ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL )", 3, 0, input);

                        throw nvae;
                    }

                    switch (alt3) {
                        case 1 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:41:6: GREATER
                            {
                            match(input,GREATER,FOLLOW_GREATER_in_compareExpr163); 
                            compExp.setOperation(CompareOperations.GREATER);

                            }
                            break;
                        case 2 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:42:6: LESS
                            {
                            match(input,LESS,FOLLOW_LESS_in_compareExpr173); 
                            compExp.setOperation(CompareOperations.LESS);

                            }
                            break;
                        case 3 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:43:6: EQUAL
                            {
                            match(input,EQUAL,FOLLOW_EQUAL_in_compareExpr183); 
                            compExp.setOperation(CompareOperations.EQUALS);

                            }
                            break;
                        case 4 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:44:6: NOTEQUAL
                            {
                            match(input,NOTEQUAL,FOLLOW_NOTEQUAL_in_compareExpr193); 
                            compExp.setOperation(CompareOperations.NOTEQUAL);

                            }
                            break;
                        case 5 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:45:6: GREATEREQUAL
                            {
                            match(input,GREATEREQUAL,FOLLOW_GREATEREQUAL_in_compareExpr203); 
                            compExp.setOperation(CompareOperations.GREATEREQUAL);

                            }
                            break;
                        case 6 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:46:6: LESSEQUAL
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:50:1: sumExpr returns [Term t] : p1= prodExpr ( ( PLUS | MINUS ) p2= prodExpr )* ;
    public final Term sumExpr() throws RecognitionException {
        Term t = null;

        Product p1 = null;

        Product p2 = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:52:2: (p1= prodExpr ( ( PLUS | MINUS ) p2= prodExpr )* )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:52:2: p1= prodExpr ( ( PLUS | MINUS ) p2= prodExpr )*
            {
            pushFollow(FOLLOW_prodExpr_in_sumExpr260);
            p1=prodExpr();
            _fsp--;

            t = p1;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:52:26: ( ( PLUS | MINUS ) p2= prodExpr )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=PLUS && LA6_0<=MINUS)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:53:4: ( PLUS | MINUS ) p2= prodExpr
            	    {
            	    TermExpression termExp = StoexFactory.eINSTANCE.createTermExpression();
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:54:4: ( PLUS | MINUS )
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
            	            new NoViableAltException("54:4: ( PLUS | MINUS )", 5, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt5) {
            	        case 1 :
            	            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:54:5: PLUS
            	            {
            	            match(input,PLUS,FOLLOW_PLUS_in_sumExpr278); 
            	            termExp.setOperation(TermOperations.ADD);

            	            }
            	            break;
            	        case 2 :
            	            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:55:4: MINUS
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:61:1: prodExpr returns [Product p] : pw1= powExpr ( ( MUL | DIV | MOD ) pw2= powExpr )* ;
    public final Product prodExpr() throws RecognitionException {
        Product p = null;

        Power pw1 = null;

        Power pw2 = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:63:3: (pw1= powExpr ( ( MUL | DIV | MOD ) pw2= powExpr )* )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:63:3: pw1= powExpr ( ( MUL | DIV | MOD ) pw2= powExpr )*
            {
            pushFollow(FOLLOW_powExpr_in_prodExpr338);
            pw1=powExpr();
            _fsp--;

            p = pw1;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:64:4: ( ( MUL | DIV | MOD ) pw2= powExpr )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=MUL && LA8_0<=MOD)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:65:4: ( MUL | DIV | MOD ) pw2= powExpr
            	    {
            	    ProductExpression prodExp = StoexFactory.eINSTANCE.createProductExpression();
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:66:5: ( MUL | DIV | MOD )
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
            	            new NoViableAltException("66:5: ( MUL | DIV | MOD )", 7, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt7) {
            	        case 1 :
            	            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:66:6: MUL
            	            {
            	            match(input,MUL,FOLLOW_MUL_in_prodExpr358); 
            	            prodExp.setOperation(ProductOperations.MULT);

            	            }
            	            break;
            	        case 2 :
            	            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:67:6: DIV
            	            {
            	            match(input,DIV,FOLLOW_DIV_in_prodExpr369); 
            	            prodExp.setOperation(ProductOperations.DIV);

            	            }
            	            break;
            	        case 3 :
            	            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:68:6: MOD
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:74:1: powExpr returns [Power pw] : a1= unaryExpr ( POW a2= unaryExpr )? ;
    public final Power powExpr() throws RecognitionException {
        Power pw = null;

        Atom a1 = null;

        Atom a2 = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:76:3: (a1= unaryExpr ( POW a2= unaryExpr )? )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:76:3: a1= unaryExpr ( POW a2= unaryExpr )?
            {
            pushFollow(FOLLOW_unaryExpr_in_powExpr437);
            a1=unaryExpr();
            _fsp--;

            pw = a1;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:77:4: ( POW a2= unaryExpr )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==POW) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:77:5: POW a2= unaryExpr
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:83:1: unaryExpr returns [Atom a] : ( MINUS uminus= unaryExpr | 'NOT' unot= unaryExpr | atom );
    public final Atom unaryExpr() throws RecognitionException {
        Atom a = null;

        Atom uminus = null;

        Atom unot = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:85:5: ( MINUS uminus= unaryExpr | 'NOT' unot= unaryExpr | atom )
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
                    new NoViableAltException("83:1: unaryExpr returns [Atom a] : ( MINUS uminus= unaryExpr | 'NOT' unot= unaryExpr | atom );", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:85:5: MINUS uminus= unaryExpr
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_unaryExpr488); 
                    pushFollow(FOLLOW_unaryExpr_in_unaryExpr494);
                    uminus=unaryExpr();
                    _fsp--;


                    }
                    break;
                case 2 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:88:5: 'NOT' unot= unaryExpr
                    {
                    match(input,36,FOLLOW_36_in_unaryExpr511); 
                    pushFollow(FOLLOW_unaryExpr_in_unaryExpr517);
                    unot=unaryExpr();
                    _fsp--;


                    }
                    break;
                case 3 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:90:5: atom
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:92:1: atom returns [Atom a] : (number= NUMBER | id= scoped_id DOT type= characterisation | def= definition | sl= STRING_LITERAL | bl= boolean_keywords | LPAREN inner= compareExpr RPAREN ) ;
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
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:94:3: ( (number= NUMBER | id= scoped_id DOT type= characterisation | def= definition | sl= STRING_LITERAL | bl= boolean_keywords | LPAREN inner= compareExpr RPAREN ) )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:94:3: (number= NUMBER | id= scoped_id DOT type= characterisation | def= definition | sl= STRING_LITERAL | bl= boolean_keywords | LPAREN inner= compareExpr RPAREN )
            {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:94:3: (number= NUMBER | id= scoped_id DOT type= characterisation | def= definition | sl= STRING_LITERAL | bl= boolean_keywords | LPAREN inner= compareExpr RPAREN )
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
                    new NoViableAltException("94:3: (number= NUMBER | id= scoped_id DOT type= characterisation | def= definition | sl= STRING_LITERAL | bl= boolean_keywords | LPAREN inner= compareExpr RPAREN )", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:96:5: number= NUMBER
                    {
                    number=(Token)input.LT(1);
                    match(input,NUMBER,FOLLOW_NUMBER_in_atom562); 
                    
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
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:114:5: id= scoped_id DOT type= characterisation
                    {
                    pushFollow(FOLLOW_scoped_id_in_atom589);
                    id=scoped_id();
                    _fsp--;

                    match(input,DOT,FOLLOW_DOT_in_atom591); 
                    pushFollow(FOLLOW_characterisation_in_atom597);
                    type=characterisation();
                    _fsp--;

                     a = ParameterFactory.eINSTANCE.createCharacterisedVariable();
                    		  	((CharacterisedVariable)a).setId_Variable(id);
                    		  	((CharacterisedVariable)a).setCharacterisationType(type);
                    		  

                    }
                    break;
                case 3 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:121:5: def= definition
                    {
                    pushFollow(FOLLOW_definition_in_atom625);
                    def=definition();
                    _fsp--;

                    a=def;

                    }
                    break;
                case 4 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:125:5: sl= STRING_LITERAL
                    {
                    sl=(Token)input.LT(1);
                    match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_atom650); 
                    
                    		  	StringLiteral stringLiteral = StoexFactory.eINSTANCE.createStringLiteral();
                    		  	stringLiteral.setValue(sl.getText().replace("\"",""));
                    		  

                    }
                    break;
                case 5 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:132:5: bl= boolean_keywords
                    {
                    pushFollow(FOLLOW_boolean_keywords_in_atom677);
                    bl=boolean_keywords();
                    _fsp--;

                    
                    		  	BoolLiteral boolLiteral = StoexFactory.eINSTANCE.createBoolLiteral();
                    	   		boolLiteral.setValue(bl.equals("true"));
                    	   	  

                    }
                    break;
                case 6 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:139:5: LPAREN inner= compareExpr RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_atom701); 
                    pushFollow(FOLLOW_compareExpr_in_atom711);
                    inner=compareExpr();
                    _fsp--;

                    match(input,RPAREN,FOLLOW_RPAREN_in_atom717); 
                    
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:150:1: characterisation returns [VariableCharacterisationType ct] : type= characterisation_keywords ;
    public final VariableCharacterisationType characterisation() throws RecognitionException {
        VariableCharacterisationType ct = null;

        String type = null;


        String type="";
        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:152:2: (type= characterisation_keywords )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:152:2: type= characterisation_keywords
            {
            pushFollow(FOLLOW_characterisation_keywords_in_characterisation758);
            type=characterisation_keywords();
            _fsp--;

            if(type.equals("TYPE"))
            		ct = VariableCharacterisationType.DATATYPE;
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:166:1: definition returns [ProbabilityFunctionLiteral pfl] : ( 'IntPMF' ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (isample= numeric_int_sample )+ SQUARE_PAREN_R | 'DoublePMF' ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (rsample= numeric_real_sample )+ SQUARE_PAREN_R | 'EnumPMF' ( LPAREN (uunit= unit ) ( SEMI ORDERED_DEF ) RPAREN )? SQUARE_PAREN_L (ssample= stringsample )+ SQUARE_PAREN_R | 'DoublePDF' ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (pdf_sample= real_pdf_sample )+ SQUARE_PAREN_R | 'BoolPMF' ( LPAREN (uunit= bool_unit ) ( SEMI ORDERED_DEF )? RPAREN )? SQUARE_PAREN_L (ssample= boolsample )+ SQUARE_PAREN_R );
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
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:172:4: ( 'IntPMF' ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (isample= numeric_int_sample )+ SQUARE_PAREN_R | 'DoublePMF' ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (rsample= numeric_real_sample )+ SQUARE_PAREN_R | 'EnumPMF' ( LPAREN (uunit= unit ) ( SEMI ORDERED_DEF ) RPAREN )? SQUARE_PAREN_L (ssample= stringsample )+ SQUARE_PAREN_R | 'DoublePDF' ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (pdf_sample= real_pdf_sample )+ SQUARE_PAREN_R | 'BoolPMF' ( LPAREN (uunit= bool_unit ) ( SEMI ORDERED_DEF )? RPAREN )? SQUARE_PAREN_L (ssample= boolsample )+ SQUARE_PAREN_R )
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
                    new NoViableAltException("166:1: definition returns [ProbabilityFunctionLiteral pfl] : ( 'IntPMF' ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (isample= numeric_int_sample )+ SQUARE_PAREN_R | 'DoublePMF' ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (rsample= numeric_real_sample )+ SQUARE_PAREN_R | 'EnumPMF' ( LPAREN (uunit= unit ) ( SEMI ORDERED_DEF ) RPAREN )? SQUARE_PAREN_L (ssample= stringsample )+ SQUARE_PAREN_R | 'DoublePDF' ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (pdf_sample= real_pdf_sample )+ SQUARE_PAREN_R | 'BoolPMF' ( LPAREN (uunit= bool_unit ) ( SEMI ORDERED_DEF )? RPAREN )? SQUARE_PAREN_L (ssample= boolsample )+ SQUARE_PAREN_R );", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:172:4: 'IntPMF' ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (isample= numeric_int_sample )+ SQUARE_PAREN_R
                    {
                    match(input,37,FOLLOW_37_in_definition795); 
                    probFunction = ProbfunctionFactory.eINSTANCE.createProbabilityMassFunction();
                    				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:175:4: ( LPAREN (uunit= unit ) RPAREN )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==LPAREN) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:175:5: LPAREN (uunit= unit ) RPAREN
                            {
                            match(input,LPAREN,FOLLOW_LPAREN_in_definition807); 
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:176:6: (uunit= unit )
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:177:6: uunit= unit
                            {
                            pushFollow(FOLLOW_unit_in_definition825);
                            uunit=unit();
                            _fsp--;

                            probFunction.setUnit(uunit);

                            }

                            match(input,RPAREN,FOLLOW_RPAREN_in_definition839); 

                            }
                            break;

                    }

                    match(input,SQUARE_PAREN_L,FOLLOW_SQUARE_PAREN_L_in_definition846); 
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:181:5: (isample= numeric_int_sample )+
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
                    	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:182:7: isample= numeric_int_sample
                    	    {
                    	    pushFollow(FOLLOW_numeric_int_sample_in_definition866);
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

                    match(input,SQUARE_PAREN_R,FOLLOW_SQUARE_PAREN_R_in_definition883); 

                    }
                    break;
                case 2 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:186:5: 'DoublePMF' ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (rsample= numeric_real_sample )+ SQUARE_PAREN_R
                    {
                    match(input,38,FOLLOW_38_in_definition896); 
                    probFunction = ProbfunctionFactory.eINSTANCE.createProbabilityMassFunction();
                    				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:189:4: ( LPAREN (uunit= unit ) RPAREN )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==LPAREN) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:189:5: LPAREN (uunit= unit ) RPAREN
                            {
                            match(input,LPAREN,FOLLOW_LPAREN_in_definition909); 
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:190:6: (uunit= unit )
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:191:6: uunit= unit
                            {
                            pushFollow(FOLLOW_unit_in_definition927);
                            uunit=unit();
                            _fsp--;

                            probFunction.setUnit(uunit);

                            }

                            match(input,RPAREN,FOLLOW_RPAREN_in_definition941); 

                            }
                            break;

                    }

                    match(input,SQUARE_PAREN_L,FOLLOW_SQUARE_PAREN_L_in_definition949); 
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:195:5: (rsample= numeric_real_sample )+
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
                    	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:196:5: rsample= numeric_real_sample
                    	    {
                    	    pushFollow(FOLLOW_numeric_real_sample_in_definition967);
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

                    match(input,SQUARE_PAREN_R,FOLLOW_SQUARE_PAREN_R_in_definition984); 

                    }
                    break;
                case 3 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:201:4: 'EnumPMF' ( LPAREN (uunit= unit ) ( SEMI ORDERED_DEF ) RPAREN )? SQUARE_PAREN_L (ssample= stringsample )+ SQUARE_PAREN_R
                    {
                    match(input,39,FOLLOW_39_in_definition998); 
                    probFunction = ProbfunctionFactory.eINSTANCE.createProbabilityMassFunction();
                    				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
                    				   ((ProbabilityMassFunction)probFunction).setOrderedDomain(false);
                    				   
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:206:4: ( LPAREN (uunit= unit ) ( SEMI ORDERED_DEF ) RPAREN )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==LPAREN) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:206:5: LPAREN (uunit= unit ) ( SEMI ORDERED_DEF ) RPAREN
                            {
                            match(input,LPAREN,FOLLOW_LPAREN_in_definition1011); 
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:207:6: (uunit= unit )
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:208:6: uunit= unit
                            {
                            pushFollow(FOLLOW_unit_in_definition1029);
                            uunit=unit();
                            _fsp--;

                            probFunction.setUnit(uunit);

                            }

                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:210:6: ( SEMI ORDERED_DEF )
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:210:7: SEMI ORDERED_DEF
                            {
                            match(input,SEMI,FOLLOW_SEMI_in_definition1046); 
                            match(input,ORDERED_DEF,FOLLOW_ORDERED_DEF_in_definition1053); 
                            ((ProbabilityMassFunction)probFunction).setOrderedDomain(true);

                            }

                            match(input,RPAREN,FOLLOW_RPAREN_in_definition1072); 

                            }
                            break;

                    }

                    match(input,SQUARE_PAREN_L,FOLLOW_SQUARE_PAREN_L_in_definition1079); 
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:216:5: (ssample= stringsample )+
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
                    	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:217:5: ssample= stringsample
                    	    {
                    	    pushFollow(FOLLOW_stringsample_in_definition1097);
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

                    match(input,SQUARE_PAREN_R,FOLLOW_SQUARE_PAREN_R_in_definition1114); 

                    }
                    break;
                case 4 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:221:4: 'DoublePDF' ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (pdf_sample= real_pdf_sample )+ SQUARE_PAREN_R
                    {
                    match(input,40,FOLLOW_40_in_definition1124); 
                    probFunction = ProbfunctionFactory.eINSTANCE.createBoxedPDF();
                    				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:224:4: ( LPAREN (uunit= unit ) RPAREN )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==LPAREN) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:224:5: LPAREN (uunit= unit ) RPAREN
                            {
                            match(input,LPAREN,FOLLOW_LPAREN_in_definition1136); 
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:225:6: (uunit= unit )
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:226:6: uunit= unit
                            {
                            pushFollow(FOLLOW_unit_in_definition1154);
                            uunit=unit();
                            _fsp--;

                            probFunction.setUnit(uunit);

                            }

                            match(input,RPAREN,FOLLOW_RPAREN_in_definition1168); 

                            }
                            break;

                    }

                    match(input,SQUARE_PAREN_L,FOLLOW_SQUARE_PAREN_L_in_definition1175); 
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:230:5: (pdf_sample= real_pdf_sample )+
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
                    	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:231:7: pdf_sample= real_pdf_sample
                    	    {
                    	    pushFollow(FOLLOW_real_pdf_sample_in_definition1195);
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

                    match(input,SQUARE_PAREN_R,FOLLOW_SQUARE_PAREN_R_in_definition1212); 

                    }
                    break;
                case 5 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:235:4: 'BoolPMF' ( LPAREN (uunit= bool_unit ) ( SEMI ORDERED_DEF )? RPAREN )? SQUARE_PAREN_L (ssample= boolsample )+ SQUARE_PAREN_R
                    {
                    match(input,41,FOLLOW_41_in_definition1223); 
                    probFunction = ProbfunctionFactory.eINSTANCE.createProbabilityMassFunction();
                    				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
                    				   ((ProbabilityMassFunction)probFunction).setOrderedDomain(false);
                    				   
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:240:4: ( LPAREN (uunit= bool_unit ) ( SEMI ORDERED_DEF )? RPAREN )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==LPAREN) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:240:5: LPAREN (uunit= bool_unit ) ( SEMI ORDERED_DEF )? RPAREN
                            {
                            match(input,LPAREN,FOLLOW_LPAREN_in_definition1236); 
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:241:6: (uunit= bool_unit )
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:242:6: uunit= bool_unit
                            {
                            pushFollow(FOLLOW_bool_unit_in_definition1254);
                            uunit=bool_unit();
                            _fsp--;

                            probFunction.setUnit(uunit);

                            }

                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:244:6: ( SEMI ORDERED_DEF )?
                            int alt20=2;
                            int LA20_0 = input.LA(1);

                            if ( (LA20_0==SEMI) ) {
                                alt20=1;
                            }
                            switch (alt20) {
                                case 1 :
                                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:244:7: SEMI ORDERED_DEF
                                    {
                                    match(input,SEMI,FOLLOW_SEMI_in_definition1271); 
                                    match(input,ORDERED_DEF,FOLLOW_ORDERED_DEF_in_definition1278); 
                                    ((ProbabilityMassFunction)probFunction).setOrderedDomain(true);

                                    }
                                    break;

                            }

                            match(input,RPAREN,FOLLOW_RPAREN_in_definition1298); 

                            }
                            break;

                    }

                    match(input,SQUARE_PAREN_L,FOLLOW_SQUARE_PAREN_L_in_definition1305); 
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:250:5: (ssample= boolsample )+
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
                    	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:251:5: ssample= boolsample
                    	    {
                    	    pushFollow(FOLLOW_boolsample_in_definition1323);
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

                    match(input,SQUARE_PAREN_R,FOLLOW_SQUARE_PAREN_R_in_definition1340); 

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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:257:1: unit returns [Unit u] : 'unit' DEFINITION str= STRING_LITERAL ;
    public final Unit unit() throws RecognitionException {
        Unit u = null;

        Token str=null;

        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:259:3: ( 'unit' DEFINITION str= STRING_LITERAL )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:259:3: 'unit' DEFINITION str= STRING_LITERAL
            {
            match(input,42,FOLLOW_42_in_unit1364); 
             u = ProbfunctionFactory.eINSTANCE.createUnit(); 
            match(input,DEFINITION,FOLLOW_DEFINITION_in_unit1374); 
            str=(Token)input.LT(1);
            match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_unit1381); 
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:265:1: bool_unit returns [Unit u] : 'unit' EQUAL '\"bool\"' ;
    public final Unit bool_unit() throws RecognitionException {
        Unit u = null;

        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:267:3: ( 'unit' EQUAL '\"bool\"' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:267:3: 'unit' EQUAL '\"bool\"'
            {
            match(input,42,FOLLOW_42_in_bool_unit1403); 
             u = ProbfunctionFactory.eINSTANCE.createUnit(); 
            match(input,EQUAL,FOLLOW_EQUAL_in_bool_unit1413); 
            match(input,43,FOLLOW_43_in_bool_unit1418); 
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:274:1: numeric_int_sample returns [Sample s] : LPAREN n= NUMBER SEMI n2= NUMBER RPAREN ;
    public final Sample numeric_int_sample() throws RecognitionException {
        Sample s = null;

        Token n=null;
        Token n2=null;

        s = null;
        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:276:3: ( LPAREN n= NUMBER SEMI n2= NUMBER RPAREN )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:276:3: LPAREN n= NUMBER SEMI n2= NUMBER RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_numeric_int_sample1446); 
            s = ProbfunctionFactory.eINSTANCE.createSample();
            n=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_numeric_int_sample1459); 
            s.setValue(Integer.parseInt(n.getText()));
            match(input,SEMI,FOLLOW_SEMI_in_numeric_int_sample1470); 
            n2=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_numeric_int_sample1478); 
            s.setProbability(Double.parseDouble(n2.getText()));
            match(input,RPAREN,FOLLOW_RPAREN_in_numeric_int_sample1490); 

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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:285:1: numeric_real_sample returns [Sample s] : LPAREN n= NUMBER SEMI n2= NUMBER RPAREN ;
    public final Sample numeric_real_sample() throws RecognitionException {
        Sample s = null;

        Token n=null;
        Token n2=null;

        s = null;
        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:287:3: ( LPAREN n= NUMBER SEMI n2= NUMBER RPAREN )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:287:3: LPAREN n= NUMBER SEMI n2= NUMBER RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_numeric_real_sample1513); 
            s = ProbfunctionFactory.eINSTANCE.createSample();
            n=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_numeric_real_sample1526); 
            s.setValue(Double.parseDouble(n.getText()));
            match(input,SEMI,FOLLOW_SEMI_in_numeric_real_sample1537); 
            n2=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_numeric_real_sample1545); 
            s.setProbability(Double.parseDouble(n2.getText()));
            match(input,RPAREN,FOLLOW_RPAREN_in_numeric_real_sample1557); 

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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:296:1: real_pdf_sample returns [ContinuousSample s] : LPAREN n= NUMBER SEMI n2= NUMBER RPAREN ;
    public final ContinuousSample real_pdf_sample() throws RecognitionException {
        ContinuousSample s = null;

        Token n=null;
        Token n2=null;

        s = null;
        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:298:3: ( LPAREN n= NUMBER SEMI n2= NUMBER RPAREN )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:298:3: LPAREN n= NUMBER SEMI n2= NUMBER RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_real_pdf_sample1581); 
            s = ProbfunctionFactory.eINSTANCE.createContinuousSample();
            n=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_real_pdf_sample1594); 
            s.setValue(Double.parseDouble(n.getText()));
            match(input,SEMI,FOLLOW_SEMI_in_real_pdf_sample1605); 
            n2=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_real_pdf_sample1613); 
            s.setProbability(Double.parseDouble(n2.getText()));
            match(input,RPAREN,FOLLOW_RPAREN_in_real_pdf_sample1625); 

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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:307:1: stringsample returns [Sample s] : LPAREN str= STRING_LITERAL SEMI n= NUMBER RPAREN ;
    public final Sample stringsample() throws RecognitionException {
        Sample s = null;

        Token str=null;
        Token n=null;

        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:309:3: ( LPAREN str= STRING_LITERAL SEMI n= NUMBER RPAREN )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:309:3: LPAREN str= STRING_LITERAL SEMI n= NUMBER RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_stringsample1646); 
            s = ProbfunctionFactory.eINSTANCE.createSample();
            str=(Token)input.LT(1);
            match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_stringsample1658); 
            s.setValue(str.getText().replace("\"",""));
            match(input,SEMI,FOLLOW_SEMI_in_stringsample1669); 
            n=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_stringsample1675); 
            s.setProbability(Double.parseDouble(n.getText()));
            match(input,RPAREN,FOLLOW_RPAREN_in_stringsample1686); 

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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:318:1: boolsample returns [Sample s] : LPAREN str= boolean_keywords SEMI n= NUMBER RPAREN ;
    public final Sample boolsample() throws RecognitionException {
        Sample s = null;

        Token n=null;
        String str = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:320:3: ( LPAREN str= boolean_keywords SEMI n= NUMBER RPAREN )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:320:3: LPAREN str= boolean_keywords SEMI n= NUMBER RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_boolsample1704); 
            s = ProbfunctionFactory.eINSTANCE.createSample();
            pushFollow(FOLLOW_boolean_keywords_in_boolsample1718);
            str=boolean_keywords();
            _fsp--;

            s.setValue(str);
            match(input,SEMI,FOLLOW_SEMI_in_boolsample1726); 
            n=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_boolsample1732); 
            s.setProbability(Double.parseDouble(n.getText()));
            match(input,RPAREN,FOLLOW_RPAREN_in_boolsample1743); 

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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:329:1: boolean_keywords returns [String keyword] : ( 'false' | 'true' ) ;
    public final String boolean_keywords() throws RecognitionException {
        String keyword = null;

        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:331:3: ( ( 'false' | 'true' ) )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:331:3: ( 'false' | 'true' )
            {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:331:3: ( 'false' | 'true' )
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
                    new NoViableAltException("331:3: ( 'false' | 'true' )", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:332:3: 'false'
                    {
                    match(input,44,FOLLOW_44_in_boolean_keywords1762); 
                    keyword = "false";

                    }
                    break;
                case 2 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:335:3: 'true'
                    {
                    match(input,45,FOLLOW_45_in_boolean_keywords1776); 
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:339:1: characterisation_keywords returns [String keyword] : ( 'BYTESIZE' | 'STRUCTURE' | 'NUMBER_OF_ELEMENTS' | 'TYPE' | 'VALUE' ) ;
    public final String characterisation_keywords() throws RecognitionException {
        String keyword = null;

        keyword = null;
        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:341:2: ( ( 'BYTESIZE' | 'STRUCTURE' | 'NUMBER_OF_ELEMENTS' | 'TYPE' | 'VALUE' ) )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:341:2: ( 'BYTESIZE' | 'STRUCTURE' | 'NUMBER_OF_ELEMENTS' | 'TYPE' | 'VALUE' )
            {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:341:2: ( 'BYTESIZE' | 'STRUCTURE' | 'NUMBER_OF_ELEMENTS' | 'TYPE' | 'VALUE' )
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
                    new NoViableAltException("341:2: ( 'BYTESIZE' | 'STRUCTURE' | 'NUMBER_OF_ELEMENTS' | 'TYPE' | 'VALUE' )", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:341:3: 'BYTESIZE'
                    {
                    match(input,46,FOLLOW_46_in_characterisation_keywords1804); 
                    keyword="BYTESIZE";

                    }
                    break;
                case 2 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:342:4: 'STRUCTURE'
                    {
                    match(input,47,FOLLOW_47_in_characterisation_keywords1811); 
                    keyword="STRUCTURE";

                    }
                    break;
                case 3 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:343:4: 'NUMBER_OF_ELEMENTS'
                    {
                    match(input,48,FOLLOW_48_in_characterisation_keywords1818); 
                    keyword="NUMBER_OF_ELEMENTS";

                    }
                    break;
                case 4 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:344:4: 'TYPE'
                    {
                    match(input,49,FOLLOW_49_in_characterisation_keywords1825); 
                    keyword="TYPE";

                    }
                    break;
                case 5 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:345:4: 'VALUE'
                    {
                    match(input,50,FOLLOW_50_in_characterisation_keywords1832); 
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:348:1: scoped_id returns [AbstractNamedReference ref] : id1= ID ( DOT (id2= ID | 'INNER' ) )* ;
    public final AbstractNamedReference scoped_id() throws RecognitionException {
        AbstractNamedReference ref = null;

        Token id1=null;
        Token id2=null;

        ref = null;
        		ArrayList<String> nameParts = new ArrayList<String>();
        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:352:2: (id1= ID ( DOT (id2= ID | 'INNER' ) )* )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:352:2: id1= ID ( DOT (id2= ID | 'INNER' ) )*
            {
            id1=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_scoped_id1862); 
            nameParts.add(id1.getText());
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:353:6: ( DOT (id2= ID | 'INNER' ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==DOT) ) {
                    int LA27_1 = input.LA(2);

                    if ( (LA27_1==ID||LA27_1==51) ) {
                        alt27=1;
                    }


                }


                switch (alt27) {
            	case 1 :
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:353:7: DOT (id2= ID | 'INNER' )
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_scoped_id1873); 
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:353:11: (id2= ID | 'INNER' )
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
            	            new NoViableAltException("353:11: (id2= ID | 'INNER' )", 26, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt26) {
            	        case 1 :
            	            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:353:12: id2= ID
            	            {
            	            id2=(Token)input.LT(1);
            	            match(input,ID,FOLLOW_ID_in_scoped_id1878); 
            	            nameParts.add(id2.getText());

            	            }
            	            break;
            	        case 2 :
            	            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoExParser.g:353:53: 'INNER'
            	            {
            	            match(input,51,FOLLOW_51_in_scoped_id1884); 
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
    public static final BitSet FOLLOW_set_in_boolOrExpr63 = new BitSet(new long[]{0x000033F0040D0800L});
    public static final BitSet FOLLOW_boolAndExpr_in_boolOrExpr79 = new BitSet(new long[]{0x0000000600000002L});
    public static final BitSet FOLLOW_compareExpr_in_boolAndExpr105 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_boolAndExpr111 = new BitSet(new long[]{0x000033F0040D0800L});
    public static final BitSet FOLLOW_compareExpr_in_boolAndExpr117 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_sumExpr_in_compareExpr146 = new BitSet(new long[]{0x00000000000003F2L});
    public static final BitSet FOLLOW_GREATER_in_compareExpr163 = new BitSet(new long[]{0x000033F0040D0800L});
    public static final BitSet FOLLOW_LESS_in_compareExpr173 = new BitSet(new long[]{0x000033F0040D0800L});
    public static final BitSet FOLLOW_EQUAL_in_compareExpr183 = new BitSet(new long[]{0x000033F0040D0800L});
    public static final BitSet FOLLOW_NOTEQUAL_in_compareExpr193 = new BitSet(new long[]{0x000033F0040D0800L});
    public static final BitSet FOLLOW_GREATEREQUAL_in_compareExpr203 = new BitSet(new long[]{0x000033F0040D0800L});
    public static final BitSet FOLLOW_LESSEQUAL_in_compareExpr213 = new BitSet(new long[]{0x000033F0040D0800L});
    public static final BitSet FOLLOW_sumExpr_in_compareExpr228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_prodExpr_in_sumExpr260 = new BitSet(new long[]{0x0000000000000C02L});
    public static final BitSet FOLLOW_PLUS_in_sumExpr278 = new BitSet(new long[]{0x000033F0040D0800L});
    public static final BitSet FOLLOW_MINUS_in_sumExpr286 = new BitSet(new long[]{0x000033F0040D0800L});
    public static final BitSet FOLLOW_prodExpr_in_sumExpr300 = new BitSet(new long[]{0x0000000000000C02L});
    public static final BitSet FOLLOW_powExpr_in_prodExpr338 = new BitSet(new long[]{0x0000000000007002L});
    public static final BitSet FOLLOW_MUL_in_prodExpr358 = new BitSet(new long[]{0x000033F0040D0800L});
    public static final BitSet FOLLOW_DIV_in_prodExpr369 = new BitSet(new long[]{0x000033F0040D0800L});
    public static final BitSet FOLLOW_MOD_in_prodExpr380 = new BitSet(new long[]{0x000033F0040D0800L});
    public static final BitSet FOLLOW_powExpr_in_prodExpr396 = new BitSet(new long[]{0x0000000000007002L});
    public static final BitSet FOLLOW_unaryExpr_in_powExpr437 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_POW_in_powExpr446 = new BitSet(new long[]{0x000033F0040D0800L});
    public static final BitSet FOLLOW_unaryExpr_in_powExpr452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_unaryExpr488 = new BitSet(new long[]{0x000033F0040D0800L});
    public static final BitSet FOLLOW_unaryExpr_in_unaryExpr494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_unaryExpr511 = new BitSet(new long[]{0x000033F0040D0800L});
    public static final BitSet FOLLOW_unaryExpr_in_unaryExpr517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_unaryExpr529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_atom562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scoped_id_in_atom589 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_DOT_in_atom591 = new BitSet(new long[]{0x0007C00000000000L});
    public static final BitSet FOLLOW_characterisation_in_atom597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definition_in_atom625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_atom650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolean_keywords_in_atom677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_atom701 = new BitSet(new long[]{0x000033F0040D0800L});
    public static final BitSet FOLLOW_compareExpr_in_atom711 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_atom717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_characterisation_keywords_in_characterisation758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_definition795 = new BitSet(new long[]{0x0000000000280000L});
    public static final BitSet FOLLOW_LPAREN_in_definition807 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_unit_in_definition825 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_definition839 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_L_in_definition846 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_numeric_int_sample_in_definition866 = new BitSet(new long[]{0x0000000000480000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_R_in_definition883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_definition896 = new BitSet(new long[]{0x0000000000280000L});
    public static final BitSet FOLLOW_LPAREN_in_definition909 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_unit_in_definition927 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_definition941 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_L_in_definition949 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_numeric_real_sample_in_definition967 = new BitSet(new long[]{0x0000000000480000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_R_in_definition984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_definition998 = new BitSet(new long[]{0x0000000000280000L});
    public static final BitSet FOLLOW_LPAREN_in_definition1011 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_unit_in_definition1029 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMI_in_definition1046 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ORDERED_DEF_in_definition1053 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_definition1072 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_L_in_definition1079 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_stringsample_in_definition1097 = new BitSet(new long[]{0x0000000000480000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_R_in_definition1114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_definition1124 = new BitSet(new long[]{0x0000000000280000L});
    public static final BitSet FOLLOW_LPAREN_in_definition1136 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_unit_in_definition1154 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_definition1168 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_L_in_definition1175 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_real_pdf_sample_in_definition1195 = new BitSet(new long[]{0x0000000000480000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_R_in_definition1212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_definition1223 = new BitSet(new long[]{0x0000000000280000L});
    public static final BitSet FOLLOW_LPAREN_in_definition1236 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_bool_unit_in_definition1254 = new BitSet(new long[]{0x0000000000900000L});
    public static final BitSet FOLLOW_SEMI_in_definition1271 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ORDERED_DEF_in_definition1278 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_definition1298 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_L_in_definition1305 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_boolsample_in_definition1323 = new BitSet(new long[]{0x0000000000480000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_R_in_definition1340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_unit1364 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_DEFINITION_in_unit1374 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_unit1381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_bool_unit1403 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_EQUAL_in_bool_unit1413 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_bool_unit1418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_numeric_int_sample1446 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NUMBER_in_numeric_int_sample1459 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMI_in_numeric_int_sample1470 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NUMBER_in_numeric_int_sample1478 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_numeric_int_sample1490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_numeric_real_sample1513 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NUMBER_in_numeric_real_sample1526 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMI_in_numeric_real_sample1537 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NUMBER_in_numeric_real_sample1545 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_numeric_real_sample1557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_real_pdf_sample1581 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NUMBER_in_real_pdf_sample1594 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMI_in_real_pdf_sample1605 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NUMBER_in_real_pdf_sample1613 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_real_pdf_sample1625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_stringsample1646 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_stringsample1658 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMI_in_stringsample1669 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NUMBER_in_stringsample1675 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_stringsample1686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_boolsample1704 = new BitSet(new long[]{0x0000300000000000L});
    public static final BitSet FOLLOW_boolean_keywords_in_boolsample1718 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_SEMI_in_boolsample1726 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_NUMBER_in_boolsample1732 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RPAREN_in_boolsample1743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_boolean_keywords1762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_boolean_keywords1776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_characterisation_keywords1804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_characterisation_keywords1811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_characterisation_keywords1818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_characterisation_keywords1825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_characterisation_keywords1832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_scoped_id1862 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_DOT_in_scoped_id1873 = new BitSet(new long[]{0x0008000004000000L});
    public static final BitSet FOLLOW_ID_in_scoped_id1878 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_51_in_scoped_id1884 = new BitSet(new long[]{0x0000000000020002L});

}
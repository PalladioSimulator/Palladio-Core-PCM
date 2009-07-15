// $ANTLR 3.0.1 PCMStoEx.g 2009-07-10 08:05:03
  
	package de.uka.ipd.sdq.pcm.stochasticexpressions.parser;
	import java.util.ArrayList;
import java.util.Collection;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;

import de.uka.ipd.sdq.pcm.parameter.CharacterisedVariable;
import de.uka.ipd.sdq.pcm.parameter.ParameterFactory;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType;
import de.uka.ipd.sdq.probfunction.BoxedPDF;
import de.uka.ipd.sdq.probfunction.ContinuousSample;
import de.uka.ipd.sdq.probfunction.ProbabilityFunction;
import de.uka.ipd.sdq.probfunction.ProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.ProbfunctionFactory;
import de.uka.ipd.sdq.probfunction.Sample;
import de.uka.ipd.sdq.stoex.AbstractNamedReference;
import de.uka.ipd.sdq.stoex.Atom;
import de.uka.ipd.sdq.stoex.BoolLiteral;
import de.uka.ipd.sdq.stoex.BooleanExpression;
import de.uka.ipd.sdq.stoex.BooleanOperations;
import de.uka.ipd.sdq.stoex.BooleanOperatorExpression;
import de.uka.ipd.sdq.stoex.CompareExpression;
import de.uka.ipd.sdq.stoex.CompareOperations;
import de.uka.ipd.sdq.stoex.Comparison;
import de.uka.ipd.sdq.stoex.DoubleLiteral;
import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.FunctionLiteral;
import de.uka.ipd.sdq.stoex.IfElse;
import de.uka.ipd.sdq.stoex.IfElseExpression;
import de.uka.ipd.sdq.stoex.IntLiteral;
import de.uka.ipd.sdq.stoex.NamespaceReference;
import de.uka.ipd.sdq.stoex.NegativeExpression;
import de.uka.ipd.sdq.stoex.NotExpression;
import de.uka.ipd.sdq.stoex.Parenthesis;
import de.uka.ipd.sdq.stoex.Power;
import de.uka.ipd.sdq.stoex.PowerExpression;
import de.uka.ipd.sdq.stoex.ProbabilityFunctionLiteral;
import de.uka.ipd.sdq.stoex.Product;
import de.uka.ipd.sdq.stoex.ProductExpression;
import de.uka.ipd.sdq.stoex.ProductOperations;
import de.uka.ipd.sdq.stoex.StoexFactory;
import de.uka.ipd.sdq.stoex.StringLiteral;
import de.uka.ipd.sdq.stoex.Term;
import de.uka.ipd.sdq.stoex.TermExpression;
import de.uka.ipd.sdq.stoex.TermOperations;
import de.uka.ipd.sdq.stoex.Unary;
import de.uka.ipd.sdq.stoex.VariableReference;

public class PCMStoExParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "OR", "XOR", "GREATER", "LESS", "EQUAL", "NOTEQUAL", "GREATEREQUAL", "LESSEQUAL", "PLUS", "MINUS", "MUL", "DIV", "MOD", "POW", "NOT", "NUMBER", "STRING_LITERAL", "DOT", "ID", "LPAREN", "RPAREN", "COLON", "INTPMF", "SQUARE_PAREN_L", "SQUARE_PAREN_R", "DOUBLEPMF", "ENUMPMF", "ORDERED_DEF", "DOUBLEPDF", "BOOLPMF", "SEMI", "FALSE", "TRUE", "BYTESIZE", "STRUCTURE", "NUMBER_OF_ELEMENTS", "TYPE", "VALUE", "INNER", "UNIT", "BOOL", "DEFINITION", "DIGIT", "Exponent", "ALPHA", "WS", "COMMENT", "LINE_COMMENT", "'?'", "':'"
    };
    public static final int INNER=43;
    public static final int MOD=17;
    public static final int BOOLPMF=34;
    public static final int Exponent=48;
    public static final int GREATEREQUAL=11;
    public static final int ENUMPMF=31;
    public static final int NOT=19;
    public static final int AND=4;
    public static final int ID=23;
    public static final int EOF=-1;
    public static final int STRUCTURE=39;
    public static final int LPAREN=24;
    public static final int TYPE=41;
    public static final int NOTEQUAL=10;
    public static final int RPAREN=25;
    public static final int GREATER=7;
    public static final int STRING_LITERAL=21;
    public static final int POW=18;
    public static final int EQUAL=9;
    public static final int LESS=8;
    public static final int DEFINITION=46;
    public static final int PLUS=13;
    public static final int DIGIT=47;
    public static final int COMMENT=51;
    public static final int DOT=22;
    public static final int DOUBLEPDF=33;
    public static final int XOR=6;
    public static final int INTPMF=27;
    public static final int LINE_COMMENT=52;
    public static final int DOUBLEPMF=30;
    public static final int BOOL=45;
    public static final int NUMBER=20;
    public static final int NUMBER_OF_ELEMENTS=40;
    public static final int MINUS=14;
    public static final int VALUE=42;
    public static final int MUL=15;
    public static final int SEMI=35;
    public static final int TRUE=37;
    public static final int ALPHA=49;
    public static final int COLON=26;
    public static final int SQUARE_PAREN_R=29;
    public static final int UNIT=44;
    public static final int WS=50;
    public static final int SQUARE_PAREN_L=28;
    public static final int OR=5;
    public static final int BYTESIZE=38;
    public static final int DIV=16;
    public static final int ORDERED_DEF=32;
    public static final int FALSE=36;
    public static final int LESSEQUAL=12;

        public PCMStoExParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "PCMStoEx.g"; }



    // $ANTLR start expression
    // PCMStoEx.g:15:1: expression returns [Expression exp] : c= ifelseExpr EOF ;
    public final Expression expression() throws RecognitionException {
        Expression exp = null;

        IfElse c = null;


        try {
            // PCMStoEx.g:16:3: (c= ifelseExpr EOF )
            // PCMStoEx.g:17:3: c= ifelseExpr EOF
            {
            pushFollow(FOLLOW_ifelseExpr_in_expression32);
            c=ifelseExpr();
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


    // $ANTLR start ifelseExpr
    // PCMStoEx.g:20:1: ifelseExpr returns [IfElse ifelseExp] : cond= boolAndExpr ( '?' ifEx= boolAndExpr ':' elseEx= boolAndExpr )? ;
    public final IfElse ifelseExpr() throws RecognitionException {
        IfElse ifelseExp = null;

        BooleanExpression cond = null;

        BooleanExpression ifEx = null;

        BooleanExpression elseEx = null;


        try {
            // PCMStoEx.g:21:2: (cond= boolAndExpr ( '?' ifEx= boolAndExpr ':' elseEx= boolAndExpr )? )
            // PCMStoEx.g:22:2: cond= boolAndExpr ( '?' ifEx= boolAndExpr ':' elseEx= boolAndExpr )?
            {
            pushFollow(FOLLOW_boolAndExpr_in_ifelseExpr57);
            cond=boolAndExpr();
            _fsp--;

            ifelseExp = cond;
            // PCMStoEx.g:23:3: ( '?' ifEx= boolAndExpr ':' elseEx= boolAndExpr )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==53) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // PCMStoEx.g:23:4: '?' ifEx= boolAndExpr ':' elseEx= boolAndExpr
                    {
                    IfElseExpression newIfelseExp = StoexFactory.eINSTANCE.createIfElseExpression();
                    		  newIfelseExp.setConditionExpression(cond);
                    match(input,53,FOLLOW_53_in_ifelseExpr70); 
                    pushFollow(FOLLOW_boolAndExpr_in_ifelseExpr76);
                    ifEx=boolAndExpr();
                    _fsp--;

                    newIfelseExp.setIfExpression(ifEx);
                    match(input,54,FOLLOW_54_in_ifelseExpr80); 
                    pushFollow(FOLLOW_boolAndExpr_in_ifelseExpr86);
                    elseEx=boolAndExpr();
                    _fsp--;

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
    // $ANTLR end ifelseExpr


    // $ANTLR start boolAndExpr
    // PCMStoEx.g:29:1: boolAndExpr returns [BooleanExpression boolExp] : b1= boolOrExpr ( AND b2= boolOrExpr )* ;
    public final BooleanExpression boolAndExpr() throws RecognitionException {
        BooleanExpression boolExp = null;

        BooleanExpression b1 = null;

        BooleanExpression b2 = null;


        try {
            // PCMStoEx.g:30:2: (b1= boolOrExpr ( AND b2= boolOrExpr )* )
            // PCMStoEx.g:31:2: b1= boolOrExpr ( AND b2= boolOrExpr )*
            {
            pushFollow(FOLLOW_boolOrExpr_in_boolAndExpr111);
            b1=boolOrExpr();
            _fsp--;

            boolExp = b1;
            // PCMStoEx.g:32:3: ( AND b2= boolOrExpr )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==AND) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // PCMStoEx.g:32:4: AND b2= boolOrExpr
            	    {
            	    BooleanOperatorExpression boolExprNew = StoexFactory.eINSTANCE.createBooleanOperatorExpression();
            	    match(input,AND,FOLLOW_AND_in_boolAndExpr122); 
            	    boolExprNew.setOperation(BooleanOperations.AND);
            	    pushFollow(FOLLOW_boolOrExpr_in_boolAndExpr133);
            	    b2=boolOrExpr();
            	    _fsp--;

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
    // $ANTLR end boolAndExpr


    // $ANTLR start boolOrExpr
    // PCMStoEx.g:37:1: boolOrExpr returns [BooleanExpression boolExp] : b1= compareExpr ( ( OR | XOR ) b2= compareExpr )* ;
    public final BooleanExpression boolOrExpr() throws RecognitionException {
        BooleanExpression boolExp = null;

        Comparison b1 = null;

        Comparison b2 = null;


        try {
            // PCMStoEx.g:38:2: (b1= compareExpr ( ( OR | XOR ) b2= compareExpr )* )
            // PCMStoEx.g:39:2: b1= compareExpr ( ( OR | XOR ) b2= compareExpr )*
            {
            pushFollow(FOLLOW_compareExpr_in_boolOrExpr160);
            b1=compareExpr();
            _fsp--;

            boolExp = b1;
            // PCMStoEx.g:40:3: ( ( OR | XOR ) b2= compareExpr )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=OR && LA4_0<=XOR)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // PCMStoEx.g:40:5: ( OR | XOR ) b2= compareExpr
            	    {
            	    BooleanOperatorExpression boolExprNew = StoexFactory.eINSTANCE.createBooleanOperatorExpression();
            	    // PCMStoEx.g:41:3: ( OR | XOR )
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
            	            new NoViableAltException("41:3: ( OR | XOR )", 3, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt3) {
            	        case 1 :
            	            // PCMStoEx.g:41:4: OR
            	            {
            	            match(input,OR,FOLLOW_OR_in_boolOrExpr173); 
            	            boolExprNew.setOperation(BooleanOperations.OR);

            	            }
            	            break;
            	        case 2 :
            	            // PCMStoEx.g:42:4: XOR
            	            {
            	            match(input,XOR,FOLLOW_XOR_in_boolOrExpr181); 
            	            boolExprNew.setOperation(BooleanOperations.XOR);

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_compareExpr_in_boolOrExpr193);
            	    b2=compareExpr();
            	    _fsp--;

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
    // $ANTLR end boolOrExpr


    // $ANTLR start compareExpr
    // PCMStoEx.g:50:1: compareExpr returns [Comparison comp] : t1= sumExpr ( ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL ) t2= sumExpr )? ;
    public final Comparison compareExpr() throws RecognitionException {
        Comparison comp = null;

        Term t1 = null;

        Term t2 = null;


        try {
            // PCMStoEx.g:51:3: (t1= sumExpr ( ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL ) t2= sumExpr )? )
            // PCMStoEx.g:52:4: t1= sumExpr ( ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL ) t2= sumExpr )?
            {
            pushFollow(FOLLOW_sumExpr_in_compareExpr231);
            t1=sumExpr();
            _fsp--;

            comp = t1;
            // PCMStoEx.g:52:30: ( ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL ) t2= sumExpr )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=GREATER && LA6_0<=LESSEQUAL)) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // PCMStoEx.g:53:5: ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL ) t2= sumExpr
                    {
                    CompareExpression compExp = StoexFactory.eINSTANCE.createCompareExpression();
                    // PCMStoEx.g:54:5: ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL )
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
                            new NoViableAltException("54:5: ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL )", 5, 0, input);

                        throw nvae;
                    }

                    switch (alt5) {
                        case 1 :
                            // PCMStoEx.g:54:6: GREATER
                            {
                            match(input,GREATER,FOLLOW_GREATER_in_compareExpr248); 
                            compExp.setOperation(CompareOperations.GREATER);

                            }
                            break;
                        case 2 :
                            // PCMStoEx.g:55:6: LESS
                            {
                            match(input,LESS,FOLLOW_LESS_in_compareExpr258); 
                            compExp.setOperation(CompareOperations.LESS);

                            }
                            break;
                        case 3 :
                            // PCMStoEx.g:56:6: EQUAL
                            {
                            match(input,EQUAL,FOLLOW_EQUAL_in_compareExpr268); 
                            compExp.setOperation(CompareOperations.EQUALS);

                            }
                            break;
                        case 4 :
                            // PCMStoEx.g:57:6: NOTEQUAL
                            {
                            match(input,NOTEQUAL,FOLLOW_NOTEQUAL_in_compareExpr278); 
                            compExp.setOperation(CompareOperations.NOTEQUAL);

                            }
                            break;
                        case 5 :
                            // PCMStoEx.g:58:6: GREATEREQUAL
                            {
                            match(input,GREATEREQUAL,FOLLOW_GREATEREQUAL_in_compareExpr288); 
                            compExp.setOperation(CompareOperations.GREATEREQUAL);

                            }
                            break;
                        case 6 :
                            // PCMStoEx.g:59:6: LESSEQUAL
                            {
                            match(input,LESSEQUAL,FOLLOW_LESSEQUAL_in_compareExpr298); 
                            compExp.setOperation(CompareOperations.LESSEQUAL);

                            }
                            break;

                    }

                    pushFollow(FOLLOW_sumExpr_in_compareExpr313);
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
    // PCMStoEx.g:63:1: sumExpr returns [Term t] : p1= prodExpr ( ( PLUS | MINUS ) p2= prodExpr )* ;
    public final Term sumExpr() throws RecognitionException {
        Term t = null;

        Product p1 = null;

        Product p2 = null;


        try {
            // PCMStoEx.g:64:3: (p1= prodExpr ( ( PLUS | MINUS ) p2= prodExpr )* )
            // PCMStoEx.g:65:2: p1= prodExpr ( ( PLUS | MINUS ) p2= prodExpr )*
            {
            pushFollow(FOLLOW_prodExpr_in_sumExpr345);
            p1=prodExpr();
            _fsp--;

            t = p1;
            // PCMStoEx.g:65:26: ( ( PLUS | MINUS ) p2= prodExpr )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=PLUS && LA8_0<=MINUS)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // PCMStoEx.g:66:4: ( PLUS | MINUS ) p2= prodExpr
            	    {
            	    TermExpression termExp = StoexFactory.eINSTANCE.createTermExpression();
            	    // PCMStoEx.g:67:4: ( PLUS | MINUS )
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
            	            new NoViableAltException("67:4: ( PLUS | MINUS )", 7, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt7) {
            	        case 1 :
            	            // PCMStoEx.g:67:5: PLUS
            	            {
            	            match(input,PLUS,FOLLOW_PLUS_in_sumExpr363); 
            	            termExp.setOperation(TermOperations.ADD);

            	            }
            	            break;
            	        case 2 :
            	            // PCMStoEx.g:68:4: MINUS
            	            {
            	            match(input,MINUS,FOLLOW_MINUS_in_sumExpr371); 
            	            termExp.setOperation(TermOperations.SUB);

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_prodExpr_in_sumExpr385);
            	    p2=prodExpr();
            	    _fsp--;

            	    termExp.setLeft(t); termExp.setRight(p2); t = termExp;

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
        return t;
    }
    // $ANTLR end sumExpr


    // $ANTLR start prodExpr
    // PCMStoEx.g:74:1: prodExpr returns [Product p] : pw1= powExpr ( ( MUL | DIV | MOD ) pw2= powExpr )* ;
    public final Product prodExpr() throws RecognitionException {
        Product p = null;

        Power pw1 = null;

        Power pw2 = null;


        try {
            // PCMStoEx.g:75:3: (pw1= powExpr ( ( MUL | DIV | MOD ) pw2= powExpr )* )
            // PCMStoEx.g:76:3: pw1= powExpr ( ( MUL | DIV | MOD ) pw2= powExpr )*
            {
            pushFollow(FOLLOW_powExpr_in_prodExpr423);
            pw1=powExpr();
            _fsp--;

            p = pw1;
            // PCMStoEx.g:77:4: ( ( MUL | DIV | MOD ) pw2= powExpr )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=MUL && LA10_0<=MOD)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // PCMStoEx.g:78:4: ( MUL | DIV | MOD ) pw2= powExpr
            	    {
            	    ProductExpression prodExp = StoexFactory.eINSTANCE.createProductExpression();
            	    // PCMStoEx.g:79:5: ( MUL | DIV | MOD )
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
            	            new NoViableAltException("79:5: ( MUL | DIV | MOD )", 9, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt9) {
            	        case 1 :
            	            // PCMStoEx.g:79:6: MUL
            	            {
            	            match(input,MUL,FOLLOW_MUL_in_prodExpr443); 
            	            prodExp.setOperation(ProductOperations.MULT);

            	            }
            	            break;
            	        case 2 :
            	            // PCMStoEx.g:80:6: DIV
            	            {
            	            match(input,DIV,FOLLOW_DIV_in_prodExpr454); 
            	            prodExp.setOperation(ProductOperations.DIV);

            	            }
            	            break;
            	        case 3 :
            	            // PCMStoEx.g:81:6: MOD
            	            {
            	            match(input,MOD,FOLLOW_MOD_in_prodExpr465); 
            	            prodExp.setOperation(ProductOperations.MOD);

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_powExpr_in_prodExpr481);
            	    pw2=powExpr();
            	    _fsp--;

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
    // $ANTLR end prodExpr


    // $ANTLR start powExpr
    // PCMStoEx.g:87:1: powExpr returns [Power pw] : a1= unaryExpr ( POW a2= unaryExpr )? ;
    public final Power powExpr() throws RecognitionException {
        Power pw = null;

        Unary a1 = null;

        Unary a2 = null;


        try {
            // PCMStoEx.g:88:3: (a1= unaryExpr ( POW a2= unaryExpr )? )
            // PCMStoEx.g:89:3: a1= unaryExpr ( POW a2= unaryExpr )?
            {
            pushFollow(FOLLOW_unaryExpr_in_powExpr522);
            a1=unaryExpr();
            _fsp--;

            pw = a1;
            // PCMStoEx.g:90:4: ( POW a2= unaryExpr )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==POW) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // PCMStoEx.g:90:5: POW a2= unaryExpr
                    {
                    match(input,POW,FOLLOW_POW_in_powExpr531); 
                    pushFollow(FOLLOW_unaryExpr_in_powExpr537);
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
    // PCMStoEx.g:96:1: unaryExpr returns [Unary u] : ( MINUS uminus= unaryExpr | NOT unot= unaryExpr | a= atom );
    public final Unary unaryExpr() throws RecognitionException {
        Unary u = null;

        Unary uminus = null;

        Unary unot = null;

        Atom a = null;


        try {
            // PCMStoEx.g:96:29: ( MINUS uminus= unaryExpr | NOT unot= unaryExpr | a= atom )
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
                    new NoViableAltException("96:1: unaryExpr returns [Unary u] : ( MINUS uminus= unaryExpr | NOT unot= unaryExpr | a= atom );", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // PCMStoEx.g:98:5: MINUS uminus= unaryExpr
                    {
                    match(input,MINUS,FOLLOW_MINUS_in_unaryExpr573); 
                    pushFollow(FOLLOW_unaryExpr_in_unaryExpr579);
                    uminus=unaryExpr();
                    _fsp--;

                    NegativeExpression ne = StoexFactory.eINSTANCE.createNegativeExpression();
                    		  ne.setInner(uminus);
                    		  u = ne;

                    }
                    break;
                case 2 :
                    // PCMStoEx.g:103:5: NOT unot= unaryExpr
                    {
                    match(input,NOT,FOLLOW_NOT_in_unaryExpr597); 
                    pushFollow(FOLLOW_unaryExpr_in_unaryExpr603);
                    unot=unaryExpr();
                    _fsp--;

                    NotExpression no = StoexFactory.eINSTANCE.createNotExpression();
                    		  no.setInner(unot);
                    		  u = no;

                    }
                    break;
                case 3 :
                    // PCMStoEx.g:108:5: a= atom
                    {
                    pushFollow(FOLLOW_atom_in_unaryExpr625);
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
    // PCMStoEx.g:110:1: atom returns [Atom a] : (number= NUMBER | def= definition | sl= STRING_LITERAL | bl= boolean_keywords | id= scoped_id DOT type= characterisation | fid= ID args= arguments | LPAREN inner= ifelseExpr RPAREN ) ;
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

        IfElse inner = null;


        try {
            // PCMStoEx.g:111:3: ( (number= NUMBER | def= definition | sl= STRING_LITERAL | bl= boolean_keywords | id= scoped_id DOT type= characterisation | fid= ID args= arguments | LPAREN inner= ifelseExpr RPAREN ) )
            // PCMStoEx.g:112:3: (number= NUMBER | def= definition | sl= STRING_LITERAL | bl= boolean_keywords | id= scoped_id DOT type= characterisation | fid= ID args= arguments | LPAREN inner= ifelseExpr RPAREN )
            {
            // PCMStoEx.g:112:3: (number= NUMBER | def= definition | sl= STRING_LITERAL | bl= boolean_keywords | id= scoped_id DOT type= characterisation | fid= ID args= arguments | LPAREN inner= ifelseExpr RPAREN )
            int alt13=7;
            switch ( input.LA(1) ) {
            case NUMBER:
                {
                alt13=1;
                }
                break;
            case INTPMF:
            case DOUBLEPMF:
            case ENUMPMF:
            case DOUBLEPDF:
            case BOOLPMF:
                {
                alt13=2;
                }
                break;
            case STRING_LITERAL:
                {
                alt13=3;
                }
                break;
            case FALSE:
            case TRUE:
                {
                alt13=4;
                }
                break;
            case ID:
                {
                int LA13_5 = input.LA(2);

                if ( (LA13_5==LPAREN) ) {
                    alt13=6;
                }
                else if ( (LA13_5==DOT) ) {
                    alt13=5;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("112:3: (number= NUMBER | def= definition | sl= STRING_LITERAL | bl= boolean_keywords | id= scoped_id DOT type= characterisation | fid= ID args= arguments | LPAREN inner= ifelseExpr RPAREN )", 13, 5, input);

                    throw nvae;
                }
                }
                break;
            case LPAREN:
                {
                alt13=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("112:3: (number= NUMBER | def= definition | sl= STRING_LITERAL | bl= boolean_keywords | id= scoped_id DOT type= characterisation | fid= ID args= arguments | LPAREN inner= ifelseExpr RPAREN )", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // PCMStoEx.g:114:5: number= NUMBER
                    {
                    number=(Token)input.LT(1);
                    match(input,NUMBER,FOLLOW_NUMBER_in_atom660); 
                    
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
                    // PCMStoEx.g:132:5: def= definition
                    {
                    pushFollow(FOLLOW_definition_in_atom687);
                    def=definition();
                    _fsp--;

                    a=def;

                    }
                    break;
                case 3 :
                    // PCMStoEx.g:136:5: sl= STRING_LITERAL
                    {
                    sl=(Token)input.LT(1);
                    match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_atom712); 
                    
                    		  	StringLiteral stringLiteral = StoexFactory.eINSTANCE.createStringLiteral();
                    		  	stringLiteral.setValue(sl.getText().replace("\"",""));
                    		  	a = stringLiteral;
                    		  

                    }
                    break;
                case 4 :
                    // PCMStoEx.g:144:5: bl= boolean_keywords
                    {
                    pushFollow(FOLLOW_boolean_keywords_in_atom739);
                    bl=boolean_keywords();
                    _fsp--;

                    
                    		  	BoolLiteral boolLiteral = StoexFactory.eINSTANCE.createBoolLiteral();
                    	   		boolLiteral.setValue(bl.equals("true"));
                    	   		a = boolLiteral;
                    	   	  

                    }
                    break;
                case 5 :
                    // PCMStoEx.g:152:5: id= scoped_id DOT type= characterisation
                    {
                    pushFollow(FOLLOW_scoped_id_in_atom767);
                    id=scoped_id();
                    _fsp--;

                    match(input,DOT,FOLLOW_DOT_in_atom769); 
                    pushFollow(FOLLOW_characterisation_in_atom775);
                    type=characterisation();
                    _fsp--;

                     a = ParameterFactory.eINSTANCE.createCharacterisedVariable();
                    		  	((CharacterisedVariable)a).setId_Variable(id);
                    		  	((CharacterisedVariable)a).setCharacterisationType(type);
                    		  

                    }
                    break;
                case 6 :
                    // PCMStoEx.g:159:5: fid= ID args= arguments
                    {
                    fid=(Token)input.LT(1);
                    match(input,ID,FOLLOW_ID_in_atom802); 
                    FunctionLiteral flit = StoexFactory.eINSTANCE.createFunctionLiteral();
                    		  	    flit.setId(fid.getText());
                    pushFollow(FOLLOW_arguments_in_atom815);
                    args=arguments();
                    _fsp--;

                    flit.getParameters_FunctionLiteral().addAll(args);
                    		  	a = flit;

                    }
                    break;
                case 7 :
                    // PCMStoEx.g:166:5: LPAREN inner= ifelseExpr RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_atom840); 
                    pushFollow(FOLLOW_ifelseExpr_in_atom850);
                    inner=ifelseExpr();
                    _fsp--;

                    match(input,RPAREN,FOLLOW_RPAREN_in_atom856); 
                    
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
    // PCMStoEx.g:177:1: arguments returns [Collection<Expression> parameters] : LPAREN (paramList= expressionList )? RPAREN ;
    public final Collection<Expression> arguments() throws RecognitionException {
        Collection<Expression> parameters = null;

        Collection<Expression> paramList = null;


        parameters = new ArrayList<Expression>();
        try {
            // PCMStoEx.g:179:2: ( LPAREN (paramList= expressionList )? RPAREN )
            // PCMStoEx.g:180:2: LPAREN (paramList= expressionList )? RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_arguments902); 
            // PCMStoEx.g:180:19: (paramList= expressionList )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==MINUS||(LA14_0>=NOT && LA14_0<=STRING_LITERAL)||(LA14_0>=ID && LA14_0<=LPAREN)||LA14_0==INTPMF||(LA14_0>=DOUBLEPMF && LA14_0<=ENUMPMF)||(LA14_0>=DOUBLEPDF && LA14_0<=BOOLPMF)||(LA14_0>=FALSE && LA14_0<=TRUE)) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // PCMStoEx.g:180:19: paramList= expressionList
                    {
                    pushFollow(FOLLOW_expressionList_in_arguments908);
                    paramList=expressionList();
                    _fsp--;


                    }
                    break;

            }

            parameters.addAll(paramList);
            match(input,RPAREN,FOLLOW_RPAREN_in_arguments913); 

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
    // PCMStoEx.g:183:1: expressionList returns [Collection<Expression> parameters] : p1= boolAndExpr ( COLON p2= boolAndExpr )* ;
    public final Collection<Expression> expressionList() throws RecognitionException {
        Collection<Expression> parameters = null;

        BooleanExpression p1 = null;

        BooleanExpression p2 = null;


        parameters = new ArrayList<Expression>();
        try {
            // PCMStoEx.g:185:2: (p1= boolAndExpr ( COLON p2= boolAndExpr )* )
            // PCMStoEx.g:186:7: p1= boolAndExpr ( COLON p2= boolAndExpr )*
            {
            pushFollow(FOLLOW_boolAndExpr_in_expressionList951);
            p1=boolAndExpr();
            _fsp--;

            parameters.add(p1);
            // PCMStoEx.g:186:46: ( COLON p2= boolAndExpr )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==COLON) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // PCMStoEx.g:186:47: COLON p2= boolAndExpr
            	    {
            	    match(input,COLON,FOLLOW_COLON_in_expressionList956); 
            	    pushFollow(FOLLOW_boolAndExpr_in_expressionList962);
            	    p2=boolAndExpr();
            	    _fsp--;

            	    parameters.add(p2);

            	    }
            	    break;

            	default :
            	    break loop15;
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
    // PCMStoEx.g:189:1: characterisation returns [VariableCharacterisationType ct] : type= characterisation_keywords ;
    public final VariableCharacterisationType characterisation() throws RecognitionException {
        VariableCharacterisationType ct = null;

        String type = null;


        try {
            // PCMStoEx.g:190:3: (type= characterisation_keywords )
            // PCMStoEx.g:191:2: type= characterisation_keywords
            {
            pushFollow(FOLLOW_characterisation_keywords_in_characterisation995);
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
    // PCMStoEx.g:205:1: definition returns [ProbabilityFunctionLiteral pfl] : ( INTPMF SQUARE_PAREN_L (isample= numeric_int_sample )+ SQUARE_PAREN_R | DOUBLEPMF SQUARE_PAREN_L (rsample= numeric_real_sample )+ SQUARE_PAREN_R | ENUMPMF ( LPAREN ORDERED_DEF RPAREN )? SQUARE_PAREN_L (ssample= stringsample )+ SQUARE_PAREN_R | DOUBLEPDF SQUARE_PAREN_L (pdf_sample= real_pdf_sample )+ SQUARE_PAREN_R | BOOLPMF ( LPAREN ORDERED_DEF RPAREN )? SQUARE_PAREN_L (ssample= boolsample )+ SQUARE_PAREN_R );
    public final ProbabilityFunctionLiteral definition() throws RecognitionException {
        ProbabilityFunctionLiteral pfl = null;

        Sample isample = null;

        Sample rsample = null;

        Sample ssample = null;

        ContinuousSample pdf_sample = null;


        pfl = StoexFactory.eINSTANCE.createProbabilityFunctionLiteral();
        	 ProbabilityFunction probFunction = null; 
        try {
            // PCMStoEx.g:207:46: ( INTPMF SQUARE_PAREN_L (isample= numeric_int_sample )+ SQUARE_PAREN_R | DOUBLEPMF SQUARE_PAREN_L (rsample= numeric_real_sample )+ SQUARE_PAREN_R | ENUMPMF ( LPAREN ORDERED_DEF RPAREN )? SQUARE_PAREN_L (ssample= stringsample )+ SQUARE_PAREN_R | DOUBLEPDF SQUARE_PAREN_L (pdf_sample= real_pdf_sample )+ SQUARE_PAREN_R | BOOLPMF ( LPAREN ORDERED_DEF RPAREN )? SQUARE_PAREN_L (ssample= boolsample )+ SQUARE_PAREN_R )
            int alt23=5;
            switch ( input.LA(1) ) {
            case INTPMF:
                {
                alt23=1;
                }
                break;
            case DOUBLEPMF:
                {
                alt23=2;
                }
                break;
            case ENUMPMF:
                {
                alt23=3;
                }
                break;
            case DOUBLEPDF:
                {
                alt23=4;
                }
                break;
            case BOOLPMF:
                {
                alt23=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("205:1: definition returns [ProbabilityFunctionLiteral pfl] : ( INTPMF SQUARE_PAREN_L (isample= numeric_int_sample )+ SQUARE_PAREN_R | DOUBLEPMF SQUARE_PAREN_L (rsample= numeric_real_sample )+ SQUARE_PAREN_R | ENUMPMF ( LPAREN ORDERED_DEF RPAREN )? SQUARE_PAREN_L (ssample= stringsample )+ SQUARE_PAREN_R | DOUBLEPDF SQUARE_PAREN_L (pdf_sample= real_pdf_sample )+ SQUARE_PAREN_R | BOOLPMF ( LPAREN ORDERED_DEF RPAREN )? SQUARE_PAREN_L (ssample= boolsample )+ SQUARE_PAREN_R );", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // PCMStoEx.g:211:4: INTPMF SQUARE_PAREN_L (isample= numeric_int_sample )+ SQUARE_PAREN_R
                    {
                    match(input,INTPMF,FOLLOW_INTPMF_in_definition1032); 
                    probFunction = ProbfunctionFactory.eINSTANCE.createProbabilityMassFunction();
                    				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
                    match(input,SQUARE_PAREN_L,FOLLOW_SQUARE_PAREN_L_in_definition1043); 
                    // PCMStoEx.g:215:5: (isample= numeric_int_sample )+
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
                    	    // PCMStoEx.g:216:7: isample= numeric_int_sample
                    	    {
                    	    pushFollow(FOLLOW_numeric_int_sample_in_definition1063);
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

                    match(input,SQUARE_PAREN_R,FOLLOW_SQUARE_PAREN_R_in_definition1080); 

                    }
                    break;
                case 2 :
                    // PCMStoEx.g:220:5: DOUBLEPMF SQUARE_PAREN_L (rsample= numeric_real_sample )+ SQUARE_PAREN_R
                    {
                    match(input,DOUBLEPMF,FOLLOW_DOUBLEPMF_in_definition1093); 
                    probFunction = ProbfunctionFactory.eINSTANCE.createProbabilityMassFunction();
                    				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
                    match(input,SQUARE_PAREN_L,FOLLOW_SQUARE_PAREN_L_in_definition1106); 
                    // PCMStoEx.g:224:5: (rsample= numeric_real_sample )+
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
                    	    // PCMStoEx.g:225:5: rsample= numeric_real_sample
                    	    {
                    	    pushFollow(FOLLOW_numeric_real_sample_in_definition1124);
                    	    rsample=numeric_real_sample();
                    	    _fsp--;

                    	    ((ProbabilityMassFunction)probFunction).getSamples().add(rsample);

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

                    match(input,SQUARE_PAREN_R,FOLLOW_SQUARE_PAREN_R_in_definition1141); 

                    }
                    break;
                case 3 :
                    // PCMStoEx.g:230:4: ENUMPMF ( LPAREN ORDERED_DEF RPAREN )? SQUARE_PAREN_L (ssample= stringsample )+ SQUARE_PAREN_R
                    {
                    match(input,ENUMPMF,FOLLOW_ENUMPMF_in_definition1155); 
                    probFunction = ProbfunctionFactory.eINSTANCE.createProbabilityMassFunction();
                    				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
                    				   ((ProbabilityMassFunction)probFunction).setOrderedDomain(false);
                    				   
                    // PCMStoEx.g:235:4: ( LPAREN ORDERED_DEF RPAREN )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==LPAREN) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // PCMStoEx.g:235:5: LPAREN ORDERED_DEF RPAREN
                            {
                            match(input,LPAREN,FOLLOW_LPAREN_in_definition1168); 
                            match(input,ORDERED_DEF,FOLLOW_ORDERED_DEF_in_definition1175); 
                            ((ProbabilityMassFunction)probFunction).setOrderedDomain(true);
                            match(input,RPAREN,FOLLOW_RPAREN_in_definition1187); 

                            }
                            break;

                    }

                    match(input,SQUARE_PAREN_L,FOLLOW_SQUARE_PAREN_L_in_definition1194); 
                    // PCMStoEx.g:240:5: (ssample= stringsample )+
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
                    	    // PCMStoEx.g:241:5: ssample= stringsample
                    	    {
                    	    pushFollow(FOLLOW_stringsample_in_definition1212);
                    	    ssample=stringsample();
                    	    _fsp--;

                    	    ((ProbabilityMassFunction)probFunction).getSamples().add(ssample);

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

                    match(input,SQUARE_PAREN_R,FOLLOW_SQUARE_PAREN_R_in_definition1229); 

                    }
                    break;
                case 4 :
                    // PCMStoEx.g:245:4: DOUBLEPDF SQUARE_PAREN_L (pdf_sample= real_pdf_sample )+ SQUARE_PAREN_R
                    {
                    match(input,DOUBLEPDF,FOLLOW_DOUBLEPDF_in_definition1239); 
                    probFunction = ProbfunctionFactory.eINSTANCE.createBoxedPDF();
                    				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
                    match(input,SQUARE_PAREN_L,FOLLOW_SQUARE_PAREN_L_in_definition1250); 
                    // PCMStoEx.g:249:5: (pdf_sample= real_pdf_sample )+
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
                    	    // PCMStoEx.g:250:7: pdf_sample= real_pdf_sample
                    	    {
                    	    pushFollow(FOLLOW_real_pdf_sample_in_definition1270);
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

                    match(input,SQUARE_PAREN_R,FOLLOW_SQUARE_PAREN_R_in_definition1287); 

                    }
                    break;
                case 5 :
                    // PCMStoEx.g:254:4: BOOLPMF ( LPAREN ORDERED_DEF RPAREN )? SQUARE_PAREN_L (ssample= boolsample )+ SQUARE_PAREN_R
                    {
                    match(input,BOOLPMF,FOLLOW_BOOLPMF_in_definition1298); 
                    probFunction = ProbfunctionFactory.eINSTANCE.createProbabilityMassFunction();
                    				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
                    				   ((ProbabilityMassFunction)probFunction).setOrderedDomain(false);
                    				   
                    // PCMStoEx.g:259:4: ( LPAREN ORDERED_DEF RPAREN )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==LPAREN) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // PCMStoEx.g:259:5: LPAREN ORDERED_DEF RPAREN
                            {
                            match(input,LPAREN,FOLLOW_LPAREN_in_definition1311); 
                            match(input,ORDERED_DEF,FOLLOW_ORDERED_DEF_in_definition1318); 
                            ((ProbabilityMassFunction)probFunction).setOrderedDomain(true);
                            match(input,RPAREN,FOLLOW_RPAREN_in_definition1330); 

                            }
                            break;

                    }

                    match(input,SQUARE_PAREN_L,FOLLOW_SQUARE_PAREN_L_in_definition1337); 
                    // PCMStoEx.g:264:5: (ssample= boolsample )+
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
                    	    // PCMStoEx.g:265:5: ssample= boolsample
                    	    {
                    	    pushFollow(FOLLOW_boolsample_in_definition1355);
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

                    match(input,SQUARE_PAREN_R,FOLLOW_SQUARE_PAREN_R_in_definition1372); 

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


    // $ANTLR start numeric_int_sample
    // PCMStoEx.g:270:1: numeric_int_sample returns [Sample s] : LPAREN n= NUMBER SEMI n2= NUMBER RPAREN ;
    public final Sample numeric_int_sample() throws RecognitionException {
        Sample s = null;

        Token n=null;
        Token n2=null;

        s = null;
        try {
            // PCMStoEx.g:271:20: ( LPAREN n= NUMBER SEMI n2= NUMBER RPAREN )
            // PCMStoEx.g:272:3: LPAREN n= NUMBER SEMI n2= NUMBER RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_numeric_int_sample1398); 
            s = ProbfunctionFactory.eINSTANCE.createSample();
            n=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_numeric_int_sample1411); 
            s.setValue(Integer.parseInt(n.getText()));
            match(input,SEMI,FOLLOW_SEMI_in_numeric_int_sample1422); 
            n2=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_numeric_int_sample1430); 
            s.setProbability(Double.parseDouble(n2.getText()));
            match(input,RPAREN,FOLLOW_RPAREN_in_numeric_int_sample1442); 

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
    // PCMStoEx.g:281:1: numeric_real_sample returns [Sample s] : LPAREN n= NUMBER SEMI n2= NUMBER RPAREN ;
    public final Sample numeric_real_sample() throws RecognitionException {
        Sample s = null;

        Token n=null;
        Token n2=null;

        s = null;
        try {
            // PCMStoEx.g:282:20: ( LPAREN n= NUMBER SEMI n2= NUMBER RPAREN )
            // PCMStoEx.g:283:3: LPAREN n= NUMBER SEMI n2= NUMBER RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_numeric_real_sample1465); 
            s = ProbfunctionFactory.eINSTANCE.createSample();
            n=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_numeric_real_sample1478); 
            s.setValue(Double.parseDouble(n.getText()));
            match(input,SEMI,FOLLOW_SEMI_in_numeric_real_sample1489); 
            n2=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_numeric_real_sample1497); 
            s.setProbability(Double.parseDouble(n2.getText()));
            match(input,RPAREN,FOLLOW_RPAREN_in_numeric_real_sample1509); 

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
    // PCMStoEx.g:292:1: real_pdf_sample returns [ContinuousSample s] : LPAREN n= NUMBER SEMI n2= NUMBER RPAREN ;
    public final ContinuousSample real_pdf_sample() throws RecognitionException {
        ContinuousSample s = null;

        Token n=null;
        Token n2=null;

        s = null;
        try {
            // PCMStoEx.g:293:20: ( LPAREN n= NUMBER SEMI n2= NUMBER RPAREN )
            // PCMStoEx.g:294:3: LPAREN n= NUMBER SEMI n2= NUMBER RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_real_pdf_sample1533); 
            s = ProbfunctionFactory.eINSTANCE.createContinuousSample();
            n=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_real_pdf_sample1546); 
            s.setValue(Double.parseDouble(n.getText()));
            match(input,SEMI,FOLLOW_SEMI_in_real_pdf_sample1557); 
            n2=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_real_pdf_sample1565); 
            s.setProbability(Double.parseDouble(n2.getText()));
            match(input,RPAREN,FOLLOW_RPAREN_in_real_pdf_sample1577); 

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
    // PCMStoEx.g:303:1: stringsample returns [Sample s] : LPAREN str= STRING_LITERAL SEMI n= NUMBER RPAREN ;
    public final Sample stringsample() throws RecognitionException {
        Sample s = null;

        Token str=null;
        Token n=null;

        try {
            // PCMStoEx.g:304:3: ( LPAREN str= STRING_LITERAL SEMI n= NUMBER RPAREN )
            // PCMStoEx.g:305:3: LPAREN str= STRING_LITERAL SEMI n= NUMBER RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_stringsample1598); 
            s = ProbfunctionFactory.eINSTANCE.createSample();
            str=(Token)input.LT(1);
            match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_stringsample1610); 
            s.setValue(str.getText().replace("\"",""));
            match(input,SEMI,FOLLOW_SEMI_in_stringsample1621); 
            n=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_stringsample1627); 
            s.setProbability(Double.parseDouble(n.getText()));
            match(input,RPAREN,FOLLOW_RPAREN_in_stringsample1638); 

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
    // PCMStoEx.g:314:1: boolsample returns [Sample s] : LPAREN str= boolean_keywords SEMI n= NUMBER RPAREN ;
    public final Sample boolsample() throws RecognitionException {
        Sample s = null;

        Token n=null;
        String str = null;


        try {
            // PCMStoEx.g:315:3: ( LPAREN str= boolean_keywords SEMI n= NUMBER RPAREN )
            // PCMStoEx.g:316:3: LPAREN str= boolean_keywords SEMI n= NUMBER RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_boolsample1656); 
            s = ProbfunctionFactory.eINSTANCE.createSample();
            pushFollow(FOLLOW_boolean_keywords_in_boolsample1670);
            str=boolean_keywords();
            _fsp--;

            s.setValue(str.equals("true"));
            match(input,SEMI,FOLLOW_SEMI_in_boolsample1678); 
            n=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_boolsample1684); 
            s.setProbability(Double.parseDouble(n.getText()));
            match(input,RPAREN,FOLLOW_RPAREN_in_boolsample1695); 

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
    // PCMStoEx.g:325:1: boolean_keywords returns [String keyword] : ( FALSE | TRUE ) ;
    public final String boolean_keywords() throws RecognitionException {
        String keyword = null;

        try {
            // PCMStoEx.g:326:2: ( ( FALSE | TRUE ) )
            // PCMStoEx.g:327:3: ( FALSE | TRUE )
            {
            // PCMStoEx.g:327:3: ( FALSE | TRUE )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==FALSE) ) {
                alt24=1;
            }
            else if ( (LA24_0==TRUE) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("327:3: ( FALSE | TRUE )", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // PCMStoEx.g:328:3: FALSE
                    {
                    match(input,FALSE,FOLLOW_FALSE_in_boolean_keywords1714); 
                    keyword = "false";

                    }
                    break;
                case 2 :
                    // PCMStoEx.g:331:3: TRUE
                    {
                    match(input,TRUE,FOLLOW_TRUE_in_boolean_keywords1728); 
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
    // PCMStoEx.g:335:1: characterisation_keywords returns [String keyword] : ( BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE ) ;
    public final String characterisation_keywords() throws RecognitionException {
        String keyword = null;

        keyword = null;
        try {
            // PCMStoEx.g:336:24: ( ( BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE ) )
            // PCMStoEx.g:337:2: ( BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE )
            {
            // PCMStoEx.g:337:2: ( BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE )
            int alt25=5;
            switch ( input.LA(1) ) {
            case BYTESIZE:
                {
                alt25=1;
                }
                break;
            case STRUCTURE:
                {
                alt25=2;
                }
                break;
            case NUMBER_OF_ELEMENTS:
                {
                alt25=3;
                }
                break;
            case TYPE:
                {
                alt25=4;
                }
                break;
            case VALUE:
                {
                alt25=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("337:2: ( BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE )", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // PCMStoEx.g:337:3: BYTESIZE
                    {
                    match(input,BYTESIZE,FOLLOW_BYTESIZE_in_characterisation_keywords1756); 
                    keyword="BYTESIZE";

                    }
                    break;
                case 2 :
                    // PCMStoEx.g:338:4: STRUCTURE
                    {
                    match(input,STRUCTURE,FOLLOW_STRUCTURE_in_characterisation_keywords1763); 
                    keyword="STRUCTURE";

                    }
                    break;
                case 3 :
                    // PCMStoEx.g:339:4: NUMBER_OF_ELEMENTS
                    {
                    match(input,NUMBER_OF_ELEMENTS,FOLLOW_NUMBER_OF_ELEMENTS_in_characterisation_keywords1770); 
                    keyword="NUMBER_OF_ELEMENTS";

                    }
                    break;
                case 4 :
                    // PCMStoEx.g:340:4: TYPE
                    {
                    match(input,TYPE,FOLLOW_TYPE_in_characterisation_keywords1777); 
                    keyword="TYPE";

                    }
                    break;
                case 5 :
                    // PCMStoEx.g:341:4: VALUE
                    {
                    match(input,VALUE,FOLLOW_VALUE_in_characterisation_keywords1784); 
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
    // PCMStoEx.g:344:1: scoped_id returns [AbstractNamedReference ref] : id1= ID ( DOT (id2= ID | INNER ) )* ;
    public final AbstractNamedReference scoped_id() throws RecognitionException {
        AbstractNamedReference ref = null;

        Token id1=null;
        Token id2=null;

        ref = null;
        		ArrayList<String> nameParts = new ArrayList<String>();
        try {
            // PCMStoEx.g:346:59: (id1= ID ( DOT (id2= ID | INNER ) )* )
            // PCMStoEx.g:348:2: id1= ID ( DOT (id2= ID | INNER ) )*
            {
            id1=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_scoped_id1814); 
            nameParts.add(id1.getText());
            // PCMStoEx.g:349:6: ( DOT (id2= ID | INNER ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==DOT) ) {
                    int LA27_1 = input.LA(2);

                    if ( (LA27_1==ID||LA27_1==INNER) ) {
                        alt27=1;
                    }


                }


                switch (alt27) {
            	case 1 :
            	    // PCMStoEx.g:349:7: DOT (id2= ID | INNER )
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_scoped_id1825); 
            	    // PCMStoEx.g:349:11: (id2= ID | INNER )
            	    int alt26=2;
            	    int LA26_0 = input.LA(1);

            	    if ( (LA26_0==ID) ) {
            	        alt26=1;
            	    }
            	    else if ( (LA26_0==INNER) ) {
            	        alt26=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("349:11: (id2= ID | INNER )", 26, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt26) {
            	        case 1 :
            	            // PCMStoEx.g:349:12: id2= ID
            	            {
            	            id2=(Token)input.LT(1);
            	            match(input,ID,FOLLOW_ID_in_scoped_id1830); 
            	            nameParts.add(id2.getText());

            	            }
            	            break;
            	        case 2 :
            	            // PCMStoEx.g:349:53: INNER
            	            {
            	            match(input,INNER,FOLLOW_INNER_in_scoped_id1836); 
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


 

    public static final BitSet FOLLOW_ifelseExpr_in_expression32 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_expression34 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolAndExpr_in_ifelseExpr57 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_53_in_ifelseExpr70 = new BitSet(new long[]{0x00000036C9B84000L});
    public static final BitSet FOLLOW_boolAndExpr_in_ifelseExpr76 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_ifelseExpr80 = new BitSet(new long[]{0x00000036C9B84000L});
    public static final BitSet FOLLOW_boolAndExpr_in_ifelseExpr86 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolOrExpr_in_boolAndExpr111 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_AND_in_boolAndExpr122 = new BitSet(new long[]{0x00000036C9B84000L});
    public static final BitSet FOLLOW_boolOrExpr_in_boolAndExpr133 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_compareExpr_in_boolOrExpr160 = new BitSet(new long[]{0x0000000000000062L});
    public static final BitSet FOLLOW_OR_in_boolOrExpr173 = new BitSet(new long[]{0x00000036C9B84000L});
    public static final BitSet FOLLOW_XOR_in_boolOrExpr181 = new BitSet(new long[]{0x00000036C9B84000L});
    public static final BitSet FOLLOW_compareExpr_in_boolOrExpr193 = new BitSet(new long[]{0x0000000000000062L});
    public static final BitSet FOLLOW_sumExpr_in_compareExpr231 = new BitSet(new long[]{0x0000000000001F82L});
    public static final BitSet FOLLOW_GREATER_in_compareExpr248 = new BitSet(new long[]{0x00000036C9B84000L});
    public static final BitSet FOLLOW_LESS_in_compareExpr258 = new BitSet(new long[]{0x00000036C9B84000L});
    public static final BitSet FOLLOW_EQUAL_in_compareExpr268 = new BitSet(new long[]{0x00000036C9B84000L});
    public static final BitSet FOLLOW_NOTEQUAL_in_compareExpr278 = new BitSet(new long[]{0x00000036C9B84000L});
    public static final BitSet FOLLOW_GREATEREQUAL_in_compareExpr288 = new BitSet(new long[]{0x00000036C9B84000L});
    public static final BitSet FOLLOW_LESSEQUAL_in_compareExpr298 = new BitSet(new long[]{0x00000036C9B84000L});
    public static final BitSet FOLLOW_sumExpr_in_compareExpr313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_prodExpr_in_sumExpr345 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_PLUS_in_sumExpr363 = new BitSet(new long[]{0x00000036C9B84000L});
    public static final BitSet FOLLOW_MINUS_in_sumExpr371 = new BitSet(new long[]{0x00000036C9B84000L});
    public static final BitSet FOLLOW_prodExpr_in_sumExpr385 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_powExpr_in_prodExpr423 = new BitSet(new long[]{0x0000000000038002L});
    public static final BitSet FOLLOW_MUL_in_prodExpr443 = new BitSet(new long[]{0x00000036C9B84000L});
    public static final BitSet FOLLOW_DIV_in_prodExpr454 = new BitSet(new long[]{0x00000036C9B84000L});
    public static final BitSet FOLLOW_MOD_in_prodExpr465 = new BitSet(new long[]{0x00000036C9B84000L});
    public static final BitSet FOLLOW_powExpr_in_prodExpr481 = new BitSet(new long[]{0x0000000000038002L});
    public static final BitSet FOLLOW_unaryExpr_in_powExpr522 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_POW_in_powExpr531 = new BitSet(new long[]{0x00000036C9B84000L});
    public static final BitSet FOLLOW_unaryExpr_in_powExpr537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_unaryExpr573 = new BitSet(new long[]{0x00000036C9B84000L});
    public static final BitSet FOLLOW_unaryExpr_in_unaryExpr579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_unaryExpr597 = new BitSet(new long[]{0x00000036C9B84000L});
    public static final BitSet FOLLOW_unaryExpr_in_unaryExpr603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_unaryExpr625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_atom660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definition_in_atom687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_atom712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolean_keywords_in_atom739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scoped_id_in_atom767 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_DOT_in_atom769 = new BitSet(new long[]{0x000007C000000000L});
    public static final BitSet FOLLOW_characterisation_in_atom775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_atom802 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_arguments_in_atom815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_atom840 = new BitSet(new long[]{0x00000036C9B84000L});
    public static final BitSet FOLLOW_ifelseExpr_in_atom850 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RPAREN_in_atom856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_arguments902 = new BitSet(new long[]{0x00000036CBB84000L});
    public static final BitSet FOLLOW_expressionList_in_arguments908 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RPAREN_in_arguments913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolAndExpr_in_expressionList951 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_COLON_in_expressionList956 = new BitSet(new long[]{0x00000036C9B84000L});
    public static final BitSet FOLLOW_boolAndExpr_in_expressionList962 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_characterisation_keywords_in_characterisation995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTPMF_in_definition1032 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_L_in_definition1043 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_numeric_int_sample_in_definition1063 = new BitSet(new long[]{0x0000000021000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_R_in_definition1080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLEPMF_in_definition1093 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_L_in_definition1106 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_numeric_real_sample_in_definition1124 = new BitSet(new long[]{0x0000000021000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_R_in_definition1141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENUMPMF_in_definition1155 = new BitSet(new long[]{0x0000000011000000L});
    public static final BitSet FOLLOW_LPAREN_in_definition1168 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_ORDERED_DEF_in_definition1175 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RPAREN_in_definition1187 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_L_in_definition1194 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_stringsample_in_definition1212 = new BitSet(new long[]{0x0000000021000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_R_in_definition1229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLEPDF_in_definition1239 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_L_in_definition1250 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_real_pdf_sample_in_definition1270 = new BitSet(new long[]{0x0000000021000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_R_in_definition1287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLPMF_in_definition1298 = new BitSet(new long[]{0x0000000011000000L});
    public static final BitSet FOLLOW_LPAREN_in_definition1311 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_ORDERED_DEF_in_definition1318 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RPAREN_in_definition1330 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_L_in_definition1337 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_boolsample_in_definition1355 = new BitSet(new long[]{0x0000000021000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_R_in_definition1372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_numeric_int_sample1398 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_numeric_int_sample1411 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_SEMI_in_numeric_int_sample1422 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_numeric_int_sample1430 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RPAREN_in_numeric_int_sample1442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_numeric_real_sample1465 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_numeric_real_sample1478 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_SEMI_in_numeric_real_sample1489 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_numeric_real_sample1497 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RPAREN_in_numeric_real_sample1509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_real_pdf_sample1533 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_real_pdf_sample1546 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_SEMI_in_real_pdf_sample1557 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_real_pdf_sample1565 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RPAREN_in_real_pdf_sample1577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_stringsample1598 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_stringsample1610 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_SEMI_in_stringsample1621 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_stringsample1627 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RPAREN_in_stringsample1638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_boolsample1656 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_boolean_keywords_in_boolsample1670 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_SEMI_in_boolsample1678 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_boolsample1684 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RPAREN_in_boolsample1695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_boolean_keywords1714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_boolean_keywords1728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTESIZE_in_characterisation_keywords1756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRUCTURE_in_characterisation_keywords1763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_OF_ELEMENTS_in_characterisation_keywords1770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TYPE_in_characterisation_keywords1777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VALUE_in_characterisation_keywords1784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_scoped_id1814 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_DOT_in_scoped_id1825 = new BitSet(new long[]{0x0000080000800000L});
    public static final BitSet FOLLOW_ID_in_scoped_id1830 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_INNER_in_scoped_id1836 = new BitSet(new long[]{0x0000000000400002L});

}
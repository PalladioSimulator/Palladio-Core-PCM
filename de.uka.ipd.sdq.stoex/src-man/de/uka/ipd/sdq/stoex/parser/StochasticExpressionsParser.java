// $ANTLR 3.0 C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g 2007-08-27 10:56:49
  
	package de.uka.ipd.sdq.stoex.parser;
	import java.util.ArrayList;
import java.util.Collection;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;

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
import de.uka.ipd.sdq.stoex.Variable;
import de.uka.ipd.sdq.stoex.VariableReference;

public class StochasticExpressionsParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "OR", "XOR", "GREATER", "LESS", "EQUAL", "NOTEQUAL", "GREATEREQUAL", "LESSEQUAL", "PLUS", "MINUS", "MUL", "DIV", "MOD", "POW", "NOT", "NUMBER", "STRING_LITERAL", "ID", "LPAREN", "RPAREN", "COLON", "INTPMF", "SQUARE_PAREN_L", "SQUARE_PAREN_R", "DOUBLEPMF", "ENUMPMF", "ORDERED_DEF", "DOUBLEPDF", "BOOLPMF", "SEMI", "FALSE", "TRUE", "BYTESIZE", "STRUCTURE", "NUMBER_OF_ELEMENTS", "TYPE", "VALUE", "DOT", "INNER", "UNIT", "BOOL", "DEFINITION", "DIGIT", "Exponent", "ALPHA", "WS", "COMMENT", "LINE_COMMENT", "'?'", "':'"
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
    public static final int EQUAL=9;
    public static final int LESS=8;
    public static final int DEFINITION=46;
    public static final int PLUS=13;
    public static final int DIGIT=47;
    public static final int COMMENT=51;
    public static final int DOT=42;
    public static final int DOUBLEPDF=32;
    public static final int XOR=6;
    public static final int INTPMF=26;
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
    public static final int COLON=25;
    public static final int SQUARE_PAREN_R=28;
    public static final int UNIT=44;
    public static final int WS=50;
    public static final int SQUARE_PAREN_L=27;
    public static final int OR=5;
    public static final int BYTESIZE=37;
    public static final int DIV=16;
    public static final int ORDERED_DEF=31;
    public static final int FALSE=35;
    public static final int LESSEQUAL=12;

        public StochasticExpressionsParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g"; }



    // $ANTLR start expression
    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:13:1: expression returns [Expression exp] : c= ifelseExpr EOF ;
    public final Expression expression() throws RecognitionException {
        Expression exp = null;

        IfElse c = null;


        try {
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:14:3: (c= ifelseExpr EOF )
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:15:3: c= ifelseExpr EOF
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
    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:18:1: ifelseExpr returns [IfElse ifelseExp] : cond= boolAndExpr ( '?' ifEx= boolAndExpr ':' elseEx= boolAndExpr )? ;
    public final IfElse ifelseExpr() throws RecognitionException {
        IfElse ifelseExp = null;

        BooleanExpression cond = null;

        BooleanExpression ifEx = null;

        BooleanExpression elseEx = null;


        try {
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:19:2: (cond= boolAndExpr ( '?' ifEx= boolAndExpr ':' elseEx= boolAndExpr )? )
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:20:2: cond= boolAndExpr ( '?' ifEx= boolAndExpr ':' elseEx= boolAndExpr )?
            {
            pushFollow(FOLLOW_boolAndExpr_in_ifelseExpr57);
            cond=boolAndExpr();
            _fsp--;

            ifelseExp = cond;
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:21:3: ( '?' ifEx= boolAndExpr ':' elseEx= boolAndExpr )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==53) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:21:4: '?' ifEx= boolAndExpr ':' elseEx= boolAndExpr
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
    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:27:1: boolAndExpr returns [BooleanExpression boolExp] : b1= boolOrExpr ( AND b2= boolOrExpr )* ;
    public final BooleanExpression boolAndExpr() throws RecognitionException {
        BooleanExpression boolExp = null;

        BooleanExpression b1 = null;

        BooleanExpression b2 = null;


        try {
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:28:2: (b1= boolOrExpr ( AND b2= boolOrExpr )* )
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:29:2: b1= boolOrExpr ( AND b2= boolOrExpr )*
            {
            pushFollow(FOLLOW_boolOrExpr_in_boolAndExpr111);
            b1=boolOrExpr();
            _fsp--;

            boolExp = b1;
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:30:3: ( AND b2= boolOrExpr )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==AND) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:30:4: AND b2= boolOrExpr
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
    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:35:1: boolOrExpr returns [BooleanExpression boolExp] : b1= compareExpr ( ( OR | XOR ) b2= compareExpr )* ;
    public final BooleanExpression boolOrExpr() throws RecognitionException {
        BooleanExpression boolExp = null;

        Comparison b1 = null;

        Comparison b2 = null;


        try {
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:36:2: (b1= compareExpr ( ( OR | XOR ) b2= compareExpr )* )
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:37:2: b1= compareExpr ( ( OR | XOR ) b2= compareExpr )*
            {
            pushFollow(FOLLOW_compareExpr_in_boolOrExpr160);
            b1=compareExpr();
            _fsp--;

            boolExp = b1;
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:38:3: ( ( OR | XOR ) b2= compareExpr )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=OR && LA4_0<=XOR)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:38:5: ( OR | XOR ) b2= compareExpr
            	    {
            	    BooleanOperatorExpression boolExprNew = StoexFactory.eINSTANCE.createBooleanOperatorExpression();
            	    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:39:3: ( OR | XOR )
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
            	            new NoViableAltException("39:3: ( OR | XOR )", 3, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt3) {
            	        case 1 :
            	            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:39:4: OR
            	            {
            	            match(input,OR,FOLLOW_OR_in_boolOrExpr173); 
            	            boolExprNew.setOperation(BooleanOperations.OR);

            	            }
            	            break;
            	        case 2 :
            	            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:40:4: XOR
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
    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:48:1: compareExpr returns [Comparison comp] : t1= sumExpr ( ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL ) t2= sumExpr )? ;
    public final Comparison compareExpr() throws RecognitionException {
        Comparison comp = null;

        Term t1 = null;

        Term t2 = null;


        try {
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:49:3: (t1= sumExpr ( ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL ) t2= sumExpr )? )
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:50:4: t1= sumExpr ( ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL ) t2= sumExpr )?
            {
            pushFollow(FOLLOW_sumExpr_in_compareExpr231);
            t1=sumExpr();
            _fsp--;

            comp = t1;
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:50:30: ( ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL ) t2= sumExpr )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=GREATER && LA6_0<=LESSEQUAL)) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:51:5: ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL ) t2= sumExpr
                    {
                    CompareExpression compExp = StoexFactory.eINSTANCE.createCompareExpression();
                    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:52:5: ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL )
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
                            new NoViableAltException("52:5: ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL )", 5, 0, input);

                        throw nvae;
                    }

                    switch (alt5) {
                        case 1 :
                            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:52:6: GREATER
                            {
                            match(input,GREATER,FOLLOW_GREATER_in_compareExpr248); 
                            compExp.setOperation(CompareOperations.GREATER);

                            }
                            break;
                        case 2 :
                            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:53:6: LESS
                            {
                            match(input,LESS,FOLLOW_LESS_in_compareExpr258); 
                            compExp.setOperation(CompareOperations.LESS);

                            }
                            break;
                        case 3 :
                            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:54:6: EQUAL
                            {
                            match(input,EQUAL,FOLLOW_EQUAL_in_compareExpr268); 
                            compExp.setOperation(CompareOperations.EQUALS);

                            }
                            break;
                        case 4 :
                            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:55:6: NOTEQUAL
                            {
                            match(input,NOTEQUAL,FOLLOW_NOTEQUAL_in_compareExpr278); 
                            compExp.setOperation(CompareOperations.NOTEQUAL);

                            }
                            break;
                        case 5 :
                            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:56:6: GREATEREQUAL
                            {
                            match(input,GREATEREQUAL,FOLLOW_GREATEREQUAL_in_compareExpr288); 
                            compExp.setOperation(CompareOperations.GREATEREQUAL);

                            }
                            break;
                        case 6 :
                            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:57:6: LESSEQUAL
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
    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:61:1: sumExpr returns [Term t] : p1= prodExpr ( ( PLUS | MINUS ) p2= prodExpr )* ;
    public final Term sumExpr() throws RecognitionException {
        Term t = null;

        Product p1 = null;

        Product p2 = null;


        try {
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:62:3: (p1= prodExpr ( ( PLUS | MINUS ) p2= prodExpr )* )
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:63:2: p1= prodExpr ( ( PLUS | MINUS ) p2= prodExpr )*
            {
            pushFollow(FOLLOW_prodExpr_in_sumExpr345);
            p1=prodExpr();
            _fsp--;

            t = p1;
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:63:26: ( ( PLUS | MINUS ) p2= prodExpr )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=PLUS && LA8_0<=MINUS)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:64:4: ( PLUS | MINUS ) p2= prodExpr
            	    {
            	    TermExpression termExp = StoexFactory.eINSTANCE.createTermExpression();
            	    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:65:4: ( PLUS | MINUS )
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
            	            new NoViableAltException("65:4: ( PLUS | MINUS )", 7, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt7) {
            	        case 1 :
            	            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:65:5: PLUS
            	            {
            	            match(input,PLUS,FOLLOW_PLUS_in_sumExpr363); 
            	            termExp.setOperation(TermOperations.ADD);

            	            }
            	            break;
            	        case 2 :
            	            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:66:4: MINUS
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
    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:72:1: prodExpr returns [Product p] : pw1= powExpr ( ( MUL | DIV | MOD ) pw2= powExpr )* ;
    public final Product prodExpr() throws RecognitionException {
        Product p = null;

        Power pw1 = null;

        Power pw2 = null;


        try {
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:73:3: (pw1= powExpr ( ( MUL | DIV | MOD ) pw2= powExpr )* )
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:74:3: pw1= powExpr ( ( MUL | DIV | MOD ) pw2= powExpr )*
            {
            pushFollow(FOLLOW_powExpr_in_prodExpr423);
            pw1=powExpr();
            _fsp--;

            p = pw1;
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:75:4: ( ( MUL | DIV | MOD ) pw2= powExpr )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=MUL && LA10_0<=MOD)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:76:4: ( MUL | DIV | MOD ) pw2= powExpr
            	    {
            	    ProductExpression prodExp = StoexFactory.eINSTANCE.createProductExpression();
            	    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:77:5: ( MUL | DIV | MOD )
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
            	            new NoViableAltException("77:5: ( MUL | DIV | MOD )", 9, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt9) {
            	        case 1 :
            	            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:77:6: MUL
            	            {
            	            match(input,MUL,FOLLOW_MUL_in_prodExpr443); 
            	            prodExp.setOperation(ProductOperations.MULT);

            	            }
            	            break;
            	        case 2 :
            	            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:78:6: DIV
            	            {
            	            match(input,DIV,FOLLOW_DIV_in_prodExpr454); 
            	            prodExp.setOperation(ProductOperations.DIV);

            	            }
            	            break;
            	        case 3 :
            	            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:79:6: MOD
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
    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:85:1: powExpr returns [Power pw] : a1= unaryExpr ( POW a2= unaryExpr )? ;
    public final Power powExpr() throws RecognitionException {
        Power pw = null;

        Unary a1 = null;

        Unary a2 = null;


        try {
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:86:3: (a1= unaryExpr ( POW a2= unaryExpr )? )
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:87:3: a1= unaryExpr ( POW a2= unaryExpr )?
            {
            pushFollow(FOLLOW_unaryExpr_in_powExpr522);
            a1=unaryExpr();
            _fsp--;

            pw = a1;
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:88:4: ( POW a2= unaryExpr )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==POW) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:88:5: POW a2= unaryExpr
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
    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:94:1: unaryExpr returns [Unary u] : ( MINUS uminus= unaryExpr | NOT unot= unaryExpr | a= atom );
    public final Unary unaryExpr() throws RecognitionException {
        Unary u = null;

        Unary uminus = null;

        Unary unot = null;

        Atom a = null;


        try {
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:94:29: ( MINUS uminus= unaryExpr | NOT unot= unaryExpr | a= atom )
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
                    new NoViableAltException("94:1: unaryExpr returns [Unary u] : ( MINUS uminus= unaryExpr | NOT unot= unaryExpr | a= atom );", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:96:5: MINUS uminus= unaryExpr
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
                    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:101:5: NOT unot= unaryExpr
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
                    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:106:5: a= atom
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
    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:108:1: atom returns [Atom a] : (number= NUMBER | def= definition | sl= STRING_LITERAL | bl= boolean_keywords | id= scoped_id | fid= ID args= arguments | LPAREN inner= ifelseExpr RPAREN ) ;
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
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:109:3: ( (number= NUMBER | def= definition | sl= STRING_LITERAL | bl= boolean_keywords | id= scoped_id | fid= ID args= arguments | LPAREN inner= ifelseExpr RPAREN ) )
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:110:3: (number= NUMBER | def= definition | sl= STRING_LITERAL | bl= boolean_keywords | id= scoped_id | fid= ID args= arguments | LPAREN inner= ifelseExpr RPAREN )
            {
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:110:3: (number= NUMBER | def= definition | sl= STRING_LITERAL | bl= boolean_keywords | id= scoped_id | fid= ID args= arguments | LPAREN inner= ifelseExpr RPAREN )
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

                if ( (LA13_5==EOF||(LA13_5>=AND && LA13_5<=POW)||(LA13_5>=RPAREN && LA13_5<=COLON)||LA13_5==DOT||(LA13_5>=53 && LA13_5<=54)) ) {
                    alt13=5;
                }
                else if ( (LA13_5==LPAREN) ) {
                    alt13=6;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("110:3: (number= NUMBER | def= definition | sl= STRING_LITERAL | bl= boolean_keywords | id= scoped_id | fid= ID args= arguments | LPAREN inner= ifelseExpr RPAREN )", 13, 5, input);

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
                    new NoViableAltException("110:3: (number= NUMBER | def= definition | sl= STRING_LITERAL | bl= boolean_keywords | id= scoped_id | fid= ID args= arguments | LPAREN inner= ifelseExpr RPAREN )", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:112:5: number= NUMBER
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
                    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:130:5: def= definition
                    {
                    pushFollow(FOLLOW_definition_in_atom687);
                    def=definition();
                    _fsp--;

                    a=def;

                    }
                    break;
                case 3 :
                    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:134:5: sl= STRING_LITERAL
                    {
                    sl=(Token)input.LT(1);
                    match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_atom712); 
                    
                    		  	StringLiteral stringLiteral = StoexFactory.eINSTANCE.createStringLiteral();
                    		  	stringLiteral.setValue(sl.getText().replace("\"",""));
                    		  	a = stringLiteral;
                    		  

                    }
                    break;
                case 4 :
                    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:142:5: bl= boolean_keywords
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
                    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:150:5: id= scoped_id
                    {
                    pushFollow(FOLLOW_scoped_id_in_atom767);
                    id=scoped_id();
                    _fsp--;

                     a = StoexFactory.eINSTANCE.createVariable();
                    		  	((Variable)a).setId_Variable(id);
                    		  

                    }
                    break;
                case 6 :
                    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:156:5: fid= ID args= arguments
                    {
                    fid=(Token)input.LT(1);
                    match(input,ID,FOLLOW_ID_in_atom794); 
                    FunctionLiteral flit = StoexFactory.eINSTANCE.createFunctionLiteral();
                    		  	    flit.setId(fid.getText());
                    pushFollow(FOLLOW_arguments_in_atom807);
                    args=arguments();
                    _fsp--;

                    flit.getParameters_FunctionLiteral().addAll(args);
                    		  	a = flit;

                    }
                    break;
                case 7 :
                    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:163:5: LPAREN inner= ifelseExpr RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_atom832); 
                    pushFollow(FOLLOW_ifelseExpr_in_atom842);
                    inner=ifelseExpr();
                    _fsp--;

                    match(input,RPAREN,FOLLOW_RPAREN_in_atom848); 
                    
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
    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:174:1: arguments returns [Collection<Expression> parameters] : LPAREN (paramList= expressionList )? RPAREN ;
    public final Collection<Expression> arguments() throws RecognitionException {
        Collection<Expression> parameters = null;

        Collection<Expression> paramList = null;


        parameters = new ArrayList<Expression>();
        try {
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:176:2: ( LPAREN (paramList= expressionList )? RPAREN )
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:177:2: LPAREN (paramList= expressionList )? RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_arguments894); 
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:177:19: (paramList= expressionList )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==MINUS||(LA14_0>=NOT && LA14_0<=LPAREN)||LA14_0==INTPMF||(LA14_0>=DOUBLEPMF && LA14_0<=ENUMPMF)||(LA14_0>=DOUBLEPDF && LA14_0<=BOOLPMF)||(LA14_0>=FALSE && LA14_0<=TRUE)) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:177:19: paramList= expressionList
                    {
                    pushFollow(FOLLOW_expressionList_in_arguments900);
                    paramList=expressionList();
                    _fsp--;


                    }
                    break;

            }

            parameters.addAll(paramList);
            match(input,RPAREN,FOLLOW_RPAREN_in_arguments905); 

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
    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:180:1: expressionList returns [Collection<Expression> parameters] : p1= boolAndExpr ( COLON p2= boolAndExpr )* ;
    public final Collection<Expression> expressionList() throws RecognitionException {
        Collection<Expression> parameters = null;

        BooleanExpression p1 = null;

        BooleanExpression p2 = null;


        parameters = new ArrayList<Expression>();
        try {
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:182:2: (p1= boolAndExpr ( COLON p2= boolAndExpr )* )
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:183:7: p1= boolAndExpr ( COLON p2= boolAndExpr )*
            {
            pushFollow(FOLLOW_boolAndExpr_in_expressionList943);
            p1=boolAndExpr();
            _fsp--;

            parameters.add(p1);
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:183:46: ( COLON p2= boolAndExpr )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==COLON) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:183:47: COLON p2= boolAndExpr
            	    {
            	    match(input,COLON,FOLLOW_COLON_in_expressionList948); 
            	    pushFollow(FOLLOW_boolAndExpr_in_expressionList954);
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


    // $ANTLR start definition
    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:186:1: definition returns [ProbabilityFunctionLiteral pfl] : ( INTPMF SQUARE_PAREN_L (isample= numeric_int_sample )+ SQUARE_PAREN_R | DOUBLEPMF SQUARE_PAREN_L (rsample= numeric_real_sample )+ SQUARE_PAREN_R | ENUMPMF ( LPAREN ORDERED_DEF RPAREN )? SQUARE_PAREN_L (ssample= stringsample )+ SQUARE_PAREN_R | DOUBLEPDF SQUARE_PAREN_L (pdf_sample= real_pdf_sample )+ SQUARE_PAREN_R | BOOLPMF ( LPAREN ORDERED_DEF RPAREN )? SQUARE_PAREN_L (ssample= boolsample )+ SQUARE_PAREN_R );
    public final ProbabilityFunctionLiteral definition() throws RecognitionException {
        ProbabilityFunctionLiteral pfl = null;

        Sample isample = null;

        Sample rsample = null;

        Sample ssample = null;

        ContinuousSample pdf_sample = null;


        pfl = StoexFactory.eINSTANCE.createProbabilityFunctionLiteral();
        	 ProbabilityFunction probFunction = null; 
        try {
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:188:46: ( INTPMF SQUARE_PAREN_L (isample= numeric_int_sample )+ SQUARE_PAREN_R | DOUBLEPMF SQUARE_PAREN_L (rsample= numeric_real_sample )+ SQUARE_PAREN_R | ENUMPMF ( LPAREN ORDERED_DEF RPAREN )? SQUARE_PAREN_L (ssample= stringsample )+ SQUARE_PAREN_R | DOUBLEPDF SQUARE_PAREN_L (pdf_sample= real_pdf_sample )+ SQUARE_PAREN_R | BOOLPMF ( LPAREN ORDERED_DEF RPAREN )? SQUARE_PAREN_L (ssample= boolsample )+ SQUARE_PAREN_R )
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
                    new NoViableAltException("186:1: definition returns [ProbabilityFunctionLiteral pfl] : ( INTPMF SQUARE_PAREN_L (isample= numeric_int_sample )+ SQUARE_PAREN_R | DOUBLEPMF SQUARE_PAREN_L (rsample= numeric_real_sample )+ SQUARE_PAREN_R | ENUMPMF ( LPAREN ORDERED_DEF RPAREN )? SQUARE_PAREN_L (ssample= stringsample )+ SQUARE_PAREN_R | DOUBLEPDF SQUARE_PAREN_L (pdf_sample= real_pdf_sample )+ SQUARE_PAREN_R | BOOLPMF ( LPAREN ORDERED_DEF RPAREN )? SQUARE_PAREN_L (ssample= boolsample )+ SQUARE_PAREN_R );", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:192:4: INTPMF SQUARE_PAREN_L (isample= numeric_int_sample )+ SQUARE_PAREN_R
                    {
                    match(input,INTPMF,FOLLOW_INTPMF_in_definition1001); 
                    probFunction = ProbfunctionFactory.eINSTANCE.createProbabilityMassFunction();
                    				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
                    match(input,SQUARE_PAREN_L,FOLLOW_SQUARE_PAREN_L_in_definition1012); 
                    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:196:5: (isample= numeric_int_sample )+
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
                    	    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:197:7: isample= numeric_int_sample
                    	    {
                    	    pushFollow(FOLLOW_numeric_int_sample_in_definition1032);
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

                    match(input,SQUARE_PAREN_R,FOLLOW_SQUARE_PAREN_R_in_definition1049); 

                    }
                    break;
                case 2 :
                    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:201:5: DOUBLEPMF SQUARE_PAREN_L (rsample= numeric_real_sample )+ SQUARE_PAREN_R
                    {
                    match(input,DOUBLEPMF,FOLLOW_DOUBLEPMF_in_definition1062); 
                    probFunction = ProbfunctionFactory.eINSTANCE.createProbabilityMassFunction();
                    				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
                    match(input,SQUARE_PAREN_L,FOLLOW_SQUARE_PAREN_L_in_definition1075); 
                    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:205:5: (rsample= numeric_real_sample )+
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
                    	    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:206:5: rsample= numeric_real_sample
                    	    {
                    	    pushFollow(FOLLOW_numeric_real_sample_in_definition1093);
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

                    match(input,SQUARE_PAREN_R,FOLLOW_SQUARE_PAREN_R_in_definition1110); 

                    }
                    break;
                case 3 :
                    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:211:4: ENUMPMF ( LPAREN ORDERED_DEF RPAREN )? SQUARE_PAREN_L (ssample= stringsample )+ SQUARE_PAREN_R
                    {
                    match(input,ENUMPMF,FOLLOW_ENUMPMF_in_definition1124); 
                    probFunction = ProbfunctionFactory.eINSTANCE.createProbabilityMassFunction();
                    				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
                    				   ((ProbabilityMassFunction)probFunction).setOrderedDomain(false);
                    				   
                    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:216:4: ( LPAREN ORDERED_DEF RPAREN )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==LPAREN) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:216:5: LPAREN ORDERED_DEF RPAREN
                            {
                            match(input,LPAREN,FOLLOW_LPAREN_in_definition1137); 
                            match(input,ORDERED_DEF,FOLLOW_ORDERED_DEF_in_definition1144); 
                            ((ProbabilityMassFunction)probFunction).setOrderedDomain(true);
                            match(input,RPAREN,FOLLOW_RPAREN_in_definition1156); 

                            }
                            break;

                    }

                    match(input,SQUARE_PAREN_L,FOLLOW_SQUARE_PAREN_L_in_definition1163); 
                    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:221:5: (ssample= stringsample )+
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
                    	    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:222:5: ssample= stringsample
                    	    {
                    	    pushFollow(FOLLOW_stringsample_in_definition1181);
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

                    match(input,SQUARE_PAREN_R,FOLLOW_SQUARE_PAREN_R_in_definition1198); 

                    }
                    break;
                case 4 :
                    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:226:4: DOUBLEPDF SQUARE_PAREN_L (pdf_sample= real_pdf_sample )+ SQUARE_PAREN_R
                    {
                    match(input,DOUBLEPDF,FOLLOW_DOUBLEPDF_in_definition1208); 
                    probFunction = ProbfunctionFactory.eINSTANCE.createBoxedPDF();
                    				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
                    match(input,SQUARE_PAREN_L,FOLLOW_SQUARE_PAREN_L_in_definition1219); 
                    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:230:5: (pdf_sample= real_pdf_sample )+
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
                    	    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:231:7: pdf_sample= real_pdf_sample
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
                    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:235:4: BOOLPMF ( LPAREN ORDERED_DEF RPAREN )? SQUARE_PAREN_L (ssample= boolsample )+ SQUARE_PAREN_R
                    {
                    match(input,BOOLPMF,FOLLOW_BOOLPMF_in_definition1267); 
                    probFunction = ProbfunctionFactory.eINSTANCE.createProbabilityMassFunction();
                    				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
                    				   ((ProbabilityMassFunction)probFunction).setOrderedDomain(false);
                    				   
                    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:240:4: ( LPAREN ORDERED_DEF RPAREN )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==LPAREN) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:240:5: LPAREN ORDERED_DEF RPAREN
                            {
                            match(input,LPAREN,FOLLOW_LPAREN_in_definition1280); 
                            match(input,ORDERED_DEF,FOLLOW_ORDERED_DEF_in_definition1287); 
                            ((ProbabilityMassFunction)probFunction).setOrderedDomain(true);
                            match(input,RPAREN,FOLLOW_RPAREN_in_definition1299); 

                            }
                            break;

                    }

                    match(input,SQUARE_PAREN_L,FOLLOW_SQUARE_PAREN_L_in_definition1306); 
                    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:245:5: (ssample= boolsample )+
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
                    	    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:246:5: ssample= boolsample
                    	    {
                    	    pushFollow(FOLLOW_boolsample_in_definition1324);
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

                    match(input,SQUARE_PAREN_R,FOLLOW_SQUARE_PAREN_R_in_definition1341); 

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
    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:251:1: numeric_int_sample returns [Sample s] : LPAREN n= NUMBER SEMI n2= NUMBER RPAREN ;
    public final Sample numeric_int_sample() throws RecognitionException {
        Sample s = null;

        Token n=null;
        Token n2=null;

        s = null;
        try {
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:252:20: ( LPAREN n= NUMBER SEMI n2= NUMBER RPAREN )
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:253:3: LPAREN n= NUMBER SEMI n2= NUMBER RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_numeric_int_sample1367); 
            s = ProbfunctionFactory.eINSTANCE.createSample();
            n=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_numeric_int_sample1380); 
            s.setValue(Integer.parseInt(n.getText()));
            match(input,SEMI,FOLLOW_SEMI_in_numeric_int_sample1391); 
            n2=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_numeric_int_sample1399); 
            s.setProbability(Double.parseDouble(n2.getText()));
            match(input,RPAREN,FOLLOW_RPAREN_in_numeric_int_sample1411); 

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
    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:262:1: numeric_real_sample returns [Sample s] : LPAREN n= NUMBER SEMI n2= NUMBER RPAREN ;
    public final Sample numeric_real_sample() throws RecognitionException {
        Sample s = null;

        Token n=null;
        Token n2=null;

        s = null;
        try {
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:263:20: ( LPAREN n= NUMBER SEMI n2= NUMBER RPAREN )
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:264:3: LPAREN n= NUMBER SEMI n2= NUMBER RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_numeric_real_sample1434); 
            s = ProbfunctionFactory.eINSTANCE.createSample();
            n=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_numeric_real_sample1447); 
            s.setValue(Double.parseDouble(n.getText()));
            match(input,SEMI,FOLLOW_SEMI_in_numeric_real_sample1458); 
            n2=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_numeric_real_sample1466); 
            s.setProbability(Double.parseDouble(n2.getText()));
            match(input,RPAREN,FOLLOW_RPAREN_in_numeric_real_sample1478); 

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
    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:273:1: real_pdf_sample returns [ContinuousSample s] : LPAREN n= NUMBER SEMI n2= NUMBER RPAREN ;
    public final ContinuousSample real_pdf_sample() throws RecognitionException {
        ContinuousSample s = null;

        Token n=null;
        Token n2=null;

        s = null;
        try {
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:274:20: ( LPAREN n= NUMBER SEMI n2= NUMBER RPAREN )
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:275:3: LPAREN n= NUMBER SEMI n2= NUMBER RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_real_pdf_sample1502); 
            s = ProbfunctionFactory.eINSTANCE.createContinuousSample();
            n=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_real_pdf_sample1515); 
            s.setValue(Double.parseDouble(n.getText()));
            match(input,SEMI,FOLLOW_SEMI_in_real_pdf_sample1526); 
            n2=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_real_pdf_sample1534); 
            s.setProbability(Double.parseDouble(n2.getText()));
            match(input,RPAREN,FOLLOW_RPAREN_in_real_pdf_sample1546); 

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
    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:284:1: stringsample returns [Sample s] : LPAREN str= STRING_LITERAL SEMI n= NUMBER RPAREN ;
    public final Sample stringsample() throws RecognitionException {
        Sample s = null;

        Token str=null;
        Token n=null;

        try {
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:285:3: ( LPAREN str= STRING_LITERAL SEMI n= NUMBER RPAREN )
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:286:3: LPAREN str= STRING_LITERAL SEMI n= NUMBER RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_stringsample1567); 
            s = ProbfunctionFactory.eINSTANCE.createSample();
            str=(Token)input.LT(1);
            match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_stringsample1579); 
            s.setValue(str.getText().replace("\"",""));
            match(input,SEMI,FOLLOW_SEMI_in_stringsample1590); 
            n=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_stringsample1596); 
            s.setProbability(Double.parseDouble(n.getText()));
            match(input,RPAREN,FOLLOW_RPAREN_in_stringsample1607); 

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
    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:295:1: boolsample returns [Sample s] : LPAREN str= boolean_keywords SEMI n= NUMBER RPAREN ;
    public final Sample boolsample() throws RecognitionException {
        Sample s = null;

        Token n=null;
        String str = null;


        try {
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:296:3: ( LPAREN str= boolean_keywords SEMI n= NUMBER RPAREN )
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:297:3: LPAREN str= boolean_keywords SEMI n= NUMBER RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_boolsample1625); 
            s = ProbfunctionFactory.eINSTANCE.createSample();
            pushFollow(FOLLOW_boolean_keywords_in_boolsample1639);
            str=boolean_keywords();
            _fsp--;

            s.setValue(str.equals("true"));
            match(input,SEMI,FOLLOW_SEMI_in_boolsample1647); 
            n=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_boolsample1653); 
            s.setProbability(Double.parseDouble(n.getText()));
            match(input,RPAREN,FOLLOW_RPAREN_in_boolsample1664); 

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
    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:306:1: boolean_keywords returns [String keyword] : ( FALSE | TRUE ) ;
    public final String boolean_keywords() throws RecognitionException {
        String keyword = null;

        try {
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:307:2: ( ( FALSE | TRUE ) )
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:308:3: ( FALSE | TRUE )
            {
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:308:3: ( FALSE | TRUE )
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
                    new NoViableAltException("308:3: ( FALSE | TRUE )", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:309:3: FALSE
                    {
                    match(input,FALSE,FOLLOW_FALSE_in_boolean_keywords1683); 
                    keyword = "false";

                    }
                    break;
                case 2 :
                    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:312:3: TRUE
                    {
                    match(input,TRUE,FOLLOW_TRUE_in_boolean_keywords1697); 
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
    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:316:1: characterisation_keywords returns [String keyword] : ( BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE ) ;
    public final String characterisation_keywords() throws RecognitionException {
        String keyword = null;

        keyword = null;
        try {
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:317:24: ( ( BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE ) )
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:318:2: ( BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE )
            {
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:318:2: ( BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE )
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
                    new NoViableAltException("318:2: ( BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE )", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:318:3: BYTESIZE
                    {
                    match(input,BYTESIZE,FOLLOW_BYTESIZE_in_characterisation_keywords1725); 
                    keyword="BYTESIZE";

                    }
                    break;
                case 2 :
                    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:319:4: STRUCTURE
                    {
                    match(input,STRUCTURE,FOLLOW_STRUCTURE_in_characterisation_keywords1732); 
                    keyword="STRUCTURE";

                    }
                    break;
                case 3 :
                    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:320:4: NUMBER_OF_ELEMENTS
                    {
                    match(input,NUMBER_OF_ELEMENTS,FOLLOW_NUMBER_OF_ELEMENTS_in_characterisation_keywords1739); 
                    keyword="NUMBER_OF_ELEMENTS";

                    }
                    break;
                case 4 :
                    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:321:4: TYPE
                    {
                    match(input,TYPE,FOLLOW_TYPE_in_characterisation_keywords1746); 
                    keyword="TYPE";

                    }
                    break;
                case 5 :
                    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:322:4: VALUE
                    {
                    match(input,VALUE,FOLLOW_VALUE_in_characterisation_keywords1753); 
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
    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:325:1: scoped_id returns [AbstractNamedReference ref] : id1= ID ( DOT (id2= ID | INNER ) )* ;
    public final AbstractNamedReference scoped_id() throws RecognitionException {
        AbstractNamedReference ref = null;

        Token id1=null;
        Token id2=null;

        ref = null;
        		ArrayList<String> nameParts = new ArrayList<String>();
        try {
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:327:59: (id1= ID ( DOT (id2= ID | INNER ) )* )
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:329:2: id1= ID ( DOT (id2= ID | INNER ) )*
            {
            id1=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_scoped_id1783); 
            nameParts.add(id1.getText());
            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:330:6: ( DOT (id2= ID | INNER ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==DOT) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:330:7: DOT (id2= ID | INNER )
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_scoped_id1794); 
            	    // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:330:11: (id2= ID | INNER )
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
            	            new NoViableAltException("330:11: (id2= ID | INNER )", 26, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt26) {
            	        case 1 :
            	            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:330:12: id2= ID
            	            {
            	            id2=(Token)input.LT(1);
            	            match(input,ID,FOLLOW_ID_in_scoped_id1799); 
            	            nameParts.add(id2.getText());

            	            }
            	            break;
            	        case 2 :
            	            // C:\\Dokumente und Einstellungen\\Koziolek\\Eigene Dateien\\svn\\code\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:330:53: INNER
            	            {
            	            match(input,INNER,FOLLOW_INNER_in_scoped_id1805); 
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
    public static final BitSet FOLLOW_53_in_ifelseExpr70 = new BitSet(new long[]{0x0000001B64F84000L});
    public static final BitSet FOLLOW_boolAndExpr_in_ifelseExpr76 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_ifelseExpr80 = new BitSet(new long[]{0x0000001B64F84000L});
    public static final BitSet FOLLOW_boolAndExpr_in_ifelseExpr86 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolOrExpr_in_boolAndExpr111 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_AND_in_boolAndExpr122 = new BitSet(new long[]{0x0000001B64F84000L});
    public static final BitSet FOLLOW_boolOrExpr_in_boolAndExpr133 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_compareExpr_in_boolOrExpr160 = new BitSet(new long[]{0x0000000000000062L});
    public static final BitSet FOLLOW_OR_in_boolOrExpr173 = new BitSet(new long[]{0x0000001B64F84000L});
    public static final BitSet FOLLOW_XOR_in_boolOrExpr181 = new BitSet(new long[]{0x0000001B64F84000L});
    public static final BitSet FOLLOW_compareExpr_in_boolOrExpr193 = new BitSet(new long[]{0x0000000000000062L});
    public static final BitSet FOLLOW_sumExpr_in_compareExpr231 = new BitSet(new long[]{0x0000000000001F82L});
    public static final BitSet FOLLOW_GREATER_in_compareExpr248 = new BitSet(new long[]{0x0000001B64F84000L});
    public static final BitSet FOLLOW_LESS_in_compareExpr258 = new BitSet(new long[]{0x0000001B64F84000L});
    public static final BitSet FOLLOW_EQUAL_in_compareExpr268 = new BitSet(new long[]{0x0000001B64F84000L});
    public static final BitSet FOLLOW_NOTEQUAL_in_compareExpr278 = new BitSet(new long[]{0x0000001B64F84000L});
    public static final BitSet FOLLOW_GREATEREQUAL_in_compareExpr288 = new BitSet(new long[]{0x0000001B64F84000L});
    public static final BitSet FOLLOW_LESSEQUAL_in_compareExpr298 = new BitSet(new long[]{0x0000001B64F84000L});
    public static final BitSet FOLLOW_sumExpr_in_compareExpr313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_prodExpr_in_sumExpr345 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_PLUS_in_sumExpr363 = new BitSet(new long[]{0x0000001B64F84000L});
    public static final BitSet FOLLOW_MINUS_in_sumExpr371 = new BitSet(new long[]{0x0000001B64F84000L});
    public static final BitSet FOLLOW_prodExpr_in_sumExpr385 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_powExpr_in_prodExpr423 = new BitSet(new long[]{0x0000000000038002L});
    public static final BitSet FOLLOW_MUL_in_prodExpr443 = new BitSet(new long[]{0x0000001B64F84000L});
    public static final BitSet FOLLOW_DIV_in_prodExpr454 = new BitSet(new long[]{0x0000001B64F84000L});
    public static final BitSet FOLLOW_MOD_in_prodExpr465 = new BitSet(new long[]{0x0000001B64F84000L});
    public static final BitSet FOLLOW_powExpr_in_prodExpr481 = new BitSet(new long[]{0x0000000000038002L});
    public static final BitSet FOLLOW_unaryExpr_in_powExpr522 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_POW_in_powExpr531 = new BitSet(new long[]{0x0000001B64F84000L});
    public static final BitSet FOLLOW_unaryExpr_in_powExpr537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_unaryExpr573 = new BitSet(new long[]{0x0000001B64F84000L});
    public static final BitSet FOLLOW_unaryExpr_in_unaryExpr579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_unaryExpr597 = new BitSet(new long[]{0x0000001B64F84000L});
    public static final BitSet FOLLOW_unaryExpr_in_unaryExpr603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_unaryExpr625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_atom660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definition_in_atom687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_atom712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolean_keywords_in_atom739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scoped_id_in_atom767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_atom794 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_arguments_in_atom807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_atom832 = new BitSet(new long[]{0x0000001B64F84000L});
    public static final BitSet FOLLOW_ifelseExpr_in_atom842 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RPAREN_in_atom848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_arguments894 = new BitSet(new long[]{0x0000001B65F84000L});
    public static final BitSet FOLLOW_expressionList_in_arguments900 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RPAREN_in_arguments905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolAndExpr_in_expressionList943 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_COLON_in_expressionList948 = new BitSet(new long[]{0x0000001B64F84000L});
    public static final BitSet FOLLOW_boolAndExpr_in_expressionList954 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_INTPMF_in_definition1001 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_L_in_definition1012 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_numeric_int_sample_in_definition1032 = new BitSet(new long[]{0x0000000010800000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_R_in_definition1049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLEPMF_in_definition1062 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_L_in_definition1075 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_numeric_real_sample_in_definition1093 = new BitSet(new long[]{0x0000000010800000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_R_in_definition1110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENUMPMF_in_definition1124 = new BitSet(new long[]{0x0000000008800000L});
    public static final BitSet FOLLOW_LPAREN_in_definition1137 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_ORDERED_DEF_in_definition1144 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RPAREN_in_definition1156 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_L_in_definition1163 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_stringsample_in_definition1181 = new BitSet(new long[]{0x0000000010800000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_R_in_definition1198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLEPDF_in_definition1208 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_L_in_definition1219 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_real_pdf_sample_in_definition1239 = new BitSet(new long[]{0x0000000010800000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_R_in_definition1256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLPMF_in_definition1267 = new BitSet(new long[]{0x0000000008800000L});
    public static final BitSet FOLLOW_LPAREN_in_definition1280 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_ORDERED_DEF_in_definition1287 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RPAREN_in_definition1299 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_L_in_definition1306 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_boolsample_in_definition1324 = new BitSet(new long[]{0x0000000010800000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_R_in_definition1341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_numeric_int_sample1367 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_numeric_int_sample1380 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMI_in_numeric_int_sample1391 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_numeric_int_sample1399 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RPAREN_in_numeric_int_sample1411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_numeric_real_sample1434 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_numeric_real_sample1447 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMI_in_numeric_real_sample1458 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_numeric_real_sample1466 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RPAREN_in_numeric_real_sample1478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_real_pdf_sample1502 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_real_pdf_sample1515 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMI_in_real_pdf_sample1526 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_real_pdf_sample1534 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RPAREN_in_real_pdf_sample1546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_stringsample1567 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_stringsample1579 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMI_in_stringsample1590 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_stringsample1596 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RPAREN_in_stringsample1607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_boolsample1625 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_boolean_keywords_in_boolsample1639 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_SEMI_in_boolsample1647 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_boolsample1653 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RPAREN_in_boolsample1664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_boolean_keywords1683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_boolean_keywords1697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTESIZE_in_characterisation_keywords1725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRUCTURE_in_characterisation_keywords1732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_OF_ELEMENTS_in_characterisation_keywords1739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TYPE_in_characterisation_keywords1746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VALUE_in_characterisation_keywords1753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_scoped_id1783 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_DOT_in_scoped_id1794 = new BitSet(new long[]{0x0000080000400000L});
    public static final BitSet FOLLOW_ID_in_scoped_id1799 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_INNER_in_scoped_id1805 = new BitSet(new long[]{0x0000040000000002L});

}
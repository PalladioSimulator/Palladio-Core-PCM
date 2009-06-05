// $ANTLR 3.0 C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g 2007-07-04 22:40:41
  
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "OR", "XOR", "GREATER", "LESS", "EQUAL", "NOTEQUAL", "GREATEREQUAL", "LESSEQUAL", "PLUS", "MINUS", "MUL", "DIV", "MOD", "POW", "NOT", "NUMBER", "STRING_LITERAL", "DOT", "ID", "LPAREN", "RPAREN", "COLON", "INTPMF", "SQUARE_PAREN_L", "SQUARE_PAREN_R", "DOUBLEPMF", "ENUMPMF", "SEMI", "ORDERED_DEF", "DOUBLEPDF", "BOOLPMF", "UNIT", "DEFINITION", "BOOL", "FALSE", "TRUE", "BYTESIZE", "STRUCTURE", "NUMBER_OF_ELEMENTS", "TYPE", "VALUE", "INNER", "DIGIT", "Exponent", "ALPHA", "WS", "COMMENT", "LINE_COMMENT", "'?'", "':'"
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:15:1: expression returns [Expression exp] : c= ifelseExpr EOF ;
    public final Expression expression() throws RecognitionException {
        Expression exp = null;

        IfElse c = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:17:3: (c= ifelseExpr EOF )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:17:3: c= ifelseExpr EOF
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:20:1: ifelseExpr returns [IfElse ifelseExp] : cond= boolAndExpr ( '?' ifEx= boolAndExpr ':' elseEx= boolAndExpr )? ;
    public final IfElse ifelseExpr() throws RecognitionException {
        IfElse ifelseExp = null;

        BooleanExpression cond = null;

        BooleanExpression ifEx = null;

        BooleanExpression elseEx = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:22:2: (cond= boolAndExpr ( '?' ifEx= boolAndExpr ':' elseEx= boolAndExpr )? )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:22:2: cond= boolAndExpr ( '?' ifEx= boolAndExpr ':' elseEx= boolAndExpr )?
            {
            pushFollow(FOLLOW_boolAndExpr_in_ifelseExpr57);
            cond=boolAndExpr();
            _fsp--;

            ifelseExp = cond;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:23:3: ( '?' ifEx= boolAndExpr ':' elseEx= boolAndExpr )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==53) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:23:4: '?' ifEx= boolAndExpr ':' elseEx= boolAndExpr
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:29:1: boolAndExpr returns [BooleanExpression boolExp] : b1= boolOrExpr ( AND b2= boolOrExpr )* ;
    public final BooleanExpression boolAndExpr() throws RecognitionException {
        BooleanExpression boolExp = null;

        BooleanExpression b1 = null;

        BooleanExpression b2 = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:31:2: (b1= boolOrExpr ( AND b2= boolOrExpr )* )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:31:2: b1= boolOrExpr ( AND b2= boolOrExpr )*
            {
            pushFollow(FOLLOW_boolOrExpr_in_boolAndExpr111);
            b1=boolOrExpr();
            _fsp--;

            boolExp = b1;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:32:3: ( AND b2= boolOrExpr )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==AND) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:32:4: AND b2= boolOrExpr
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:37:1: boolOrExpr returns [BooleanExpression boolExp] : b1= compareExpr ( ( OR | XOR ) b2= compareExpr )* ;
    public final BooleanExpression boolOrExpr() throws RecognitionException {
        BooleanExpression boolExp = null;

        Comparison b1 = null;

        Comparison b2 = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:39:2: (b1= compareExpr ( ( OR | XOR ) b2= compareExpr )* )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:39:2: b1= compareExpr ( ( OR | XOR ) b2= compareExpr )*
            {
            pushFollow(FOLLOW_compareExpr_in_boolOrExpr160);
            b1=compareExpr();
            _fsp--;

            boolExp = b1;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:40:3: ( ( OR | XOR ) b2= compareExpr )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=OR && LA4_0<=XOR)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:40:5: ( OR | XOR ) b2= compareExpr
            	    {
            	    BooleanOperatorExpression boolExprNew = StoexFactory.eINSTANCE.createBooleanOperatorExpression();
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:41:3: ( OR | XOR )
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
            	            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:41:4: OR
            	            {
            	            match(input,OR,FOLLOW_OR_in_boolOrExpr173); 
            	            boolExprNew.setOperation(BooleanOperations.OR);

            	            }
            	            break;
            	        case 2 :
            	            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:42:4: XOR
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:50:1: compareExpr returns [Comparison comp] : t1= sumExpr ( ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL ) t2= sumExpr )? ;
    public final Comparison compareExpr() throws RecognitionException {
        Comparison comp = null;

        Term t1 = null;

        Term t2 = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:52:4: (t1= sumExpr ( ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL ) t2= sumExpr )? )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:52:4: t1= sumExpr ( ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL ) t2= sumExpr )?
            {
            pushFollow(FOLLOW_sumExpr_in_compareExpr231);
            t1=sumExpr();
            _fsp--;

            comp = t1;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:52:30: ( ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL ) t2= sumExpr )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=GREATER && LA6_0<=LESSEQUAL)) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:53:5: ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL ) t2= sumExpr
                    {
                    CompareExpression compExp = StoexFactory.eINSTANCE.createCompareExpression();
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:54:5: ( GREATER | LESS | EQUAL | NOTEQUAL | GREATEREQUAL | LESSEQUAL )
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
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:54:6: GREATER
                            {
                            match(input,GREATER,FOLLOW_GREATER_in_compareExpr248); 
                            compExp.setOperation(CompareOperations.GREATER);

                            }
                            break;
                        case 2 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:55:6: LESS
                            {
                            match(input,LESS,FOLLOW_LESS_in_compareExpr258); 
                            compExp.setOperation(CompareOperations.LESS);

                            }
                            break;
                        case 3 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:56:6: EQUAL
                            {
                            match(input,EQUAL,FOLLOW_EQUAL_in_compareExpr268); 
                            compExp.setOperation(CompareOperations.EQUALS);

                            }
                            break;
                        case 4 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:57:6: NOTEQUAL
                            {
                            match(input,NOTEQUAL,FOLLOW_NOTEQUAL_in_compareExpr278); 
                            compExp.setOperation(CompareOperations.NOTEQUAL);

                            }
                            break;
                        case 5 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:58:6: GREATEREQUAL
                            {
                            match(input,GREATEREQUAL,FOLLOW_GREATEREQUAL_in_compareExpr288); 
                            compExp.setOperation(CompareOperations.GREATEREQUAL);

                            }
                            break;
                        case 6 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:59:6: LESSEQUAL
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:63:1: sumExpr returns [Term t] : p1= prodExpr ( ( PLUS | MINUS ) p2= prodExpr )* ;
    public final Term sumExpr() throws RecognitionException {
        Term t = null;

        Product p1 = null;

        Product p2 = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:65:2: (p1= prodExpr ( ( PLUS | MINUS ) p2= prodExpr )* )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:65:2: p1= prodExpr ( ( PLUS | MINUS ) p2= prodExpr )*
            {
            pushFollow(FOLLOW_prodExpr_in_sumExpr345);
            p1=prodExpr();
            _fsp--;

            t = p1;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:65:26: ( ( PLUS | MINUS ) p2= prodExpr )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=PLUS && LA8_0<=MINUS)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:66:4: ( PLUS | MINUS ) p2= prodExpr
            	    {
            	    TermExpression termExp = StoexFactory.eINSTANCE.createTermExpression();
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:67:4: ( PLUS | MINUS )
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
            	            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:67:5: PLUS
            	            {
            	            match(input,PLUS,FOLLOW_PLUS_in_sumExpr363); 
            	            termExp.setOperation(TermOperations.ADD);

            	            }
            	            break;
            	        case 2 :
            	            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:68:4: MINUS
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:74:1: prodExpr returns [Product p] : pw1= powExpr ( ( MUL | DIV | MOD ) pw2= powExpr )* ;
    public final Product prodExpr() throws RecognitionException {
        Product p = null;

        Power pw1 = null;

        Power pw2 = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:76:3: (pw1= powExpr ( ( MUL | DIV | MOD ) pw2= powExpr )* )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:76:3: pw1= powExpr ( ( MUL | DIV | MOD ) pw2= powExpr )*
            {
            pushFollow(FOLLOW_powExpr_in_prodExpr423);
            pw1=powExpr();
            _fsp--;

            p = pw1;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:77:4: ( ( MUL | DIV | MOD ) pw2= powExpr )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=MUL && LA10_0<=MOD)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:78:4: ( MUL | DIV | MOD ) pw2= powExpr
            	    {
            	    ProductExpression prodExp = StoexFactory.eINSTANCE.createProductExpression();
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:79:5: ( MUL | DIV | MOD )
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
            	            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:79:6: MUL
            	            {
            	            match(input,MUL,FOLLOW_MUL_in_prodExpr443); 
            	            prodExp.setOperation(ProductOperations.MULT);

            	            }
            	            break;
            	        case 2 :
            	            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:80:6: DIV
            	            {
            	            match(input,DIV,FOLLOW_DIV_in_prodExpr454); 
            	            prodExp.setOperation(ProductOperations.DIV);

            	            }
            	            break;
            	        case 3 :
            	            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:81:6: MOD
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:87:1: powExpr returns [Power pw] : a1= unaryExpr ( POW a2= unaryExpr )? ;
    public final Power powExpr() throws RecognitionException {
        Power pw = null;

        Unary a1 = null;

        Unary a2 = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:89:3: (a1= unaryExpr ( POW a2= unaryExpr )? )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:89:3: a1= unaryExpr ( POW a2= unaryExpr )?
            {
            pushFollow(FOLLOW_unaryExpr_in_powExpr522);
            a1=unaryExpr();
            _fsp--;

            pw = a1;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:90:4: ( POW a2= unaryExpr )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==POW) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:90:5: POW a2= unaryExpr
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:96:1: unaryExpr returns [Unary u] : ( MINUS uminus= unaryExpr | NOT unot= unaryExpr | a= atom );
    public final Unary unaryExpr() throws RecognitionException {
        Unary u = null;

        Unary uminus = null;

        Unary unot = null;

        Atom a = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:98:5: ( MINUS uminus= unaryExpr | NOT unot= unaryExpr | a= atom )
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
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:98:5: MINUS uminus= unaryExpr
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
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:103:5: NOT unot= unaryExpr
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
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:108:5: a= atom
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:110:1: atom returns [Atom a] : (number= NUMBER | def= definition | sl= STRING_LITERAL | bl= boolean_keywords | id= scoped_id DOT type= characterisation | fid= ID args= arguments | LPAREN inner= ifelseExpr RPAREN ) ;
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
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:112:3: ( (number= NUMBER | def= definition | sl= STRING_LITERAL | bl= boolean_keywords | id= scoped_id DOT type= characterisation | fid= ID args= arguments | LPAREN inner= ifelseExpr RPAREN ) )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:112:3: (number= NUMBER | def= definition | sl= STRING_LITERAL | bl= boolean_keywords | id= scoped_id DOT type= characterisation | fid= ID args= arguments | LPAREN inner= ifelseExpr RPAREN )
            {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:112:3: (number= NUMBER | def= definition | sl= STRING_LITERAL | bl= boolean_keywords | id= scoped_id DOT type= characterisation | fid= ID args= arguments | LPAREN inner= ifelseExpr RPAREN )
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

                if ( (LA13_5==DOT) ) {
                    alt13=5;
                }
                else if ( (LA13_5==LPAREN) ) {
                    alt13=6;
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
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:114:5: number= NUMBER
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
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:132:5: def= definition
                    {
                    pushFollow(FOLLOW_definition_in_atom687);
                    def=definition();
                    _fsp--;

                    a=def;

                    }
                    break;
                case 3 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:136:5: sl= STRING_LITERAL
                    {
                    sl=(Token)input.LT(1);
                    match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_atom712); 
                    
                    		  	StringLiteral stringLiteral = StoexFactory.eINSTANCE.createStringLiteral();
                    		  	stringLiteral.setValue(sl.getText().replace("\"",""));
                    		  	a = stringLiteral;
                    		  

                    }
                    break;
                case 4 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:144:5: bl= boolean_keywords
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
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:152:5: id= scoped_id DOT type= characterisation
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
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:159:5: fid= ID args= arguments
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
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:166:5: LPAREN inner= ifelseExpr RPAREN
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:177:1: arguments returns [Collection<Expression> parameters] : LPAREN (paramList= expressionList )? RPAREN ;
    public final Collection<Expression> arguments() throws RecognitionException {
        Collection<Expression> parameters = null;

        Collection<Expression> paramList = null;


        parameters = new ArrayList<Expression>();
        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:180:2: ( LPAREN (paramList= expressionList )? RPAREN )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:180:2: LPAREN (paramList= expressionList )? RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_arguments902); 
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:180:19: (paramList= expressionList )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==MINUS||(LA14_0>=NOT && LA14_0<=STRING_LITERAL)||(LA14_0>=ID && LA14_0<=LPAREN)||LA14_0==INTPMF||(LA14_0>=DOUBLEPMF && LA14_0<=ENUMPMF)||(LA14_0>=DOUBLEPDF && LA14_0<=BOOLPMF)||(LA14_0>=FALSE && LA14_0<=TRUE)) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:180:19: paramList= expressionList
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:183:1: expressionList returns [Collection<Expression> parameters] : p1= boolAndExpr ( COLON p2= boolAndExpr )* ;
    public final Collection<Expression> expressionList() throws RecognitionException {
        Collection<Expression> parameters = null;

        BooleanExpression p1 = null;

        BooleanExpression p2 = null;


        parameters = new ArrayList<Expression>();
        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:186:7: (p1= boolAndExpr ( COLON p2= boolAndExpr )* )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:186:7: p1= boolAndExpr ( COLON p2= boolAndExpr )*
            {
            pushFollow(FOLLOW_boolAndExpr_in_expressionList951);
            p1=boolAndExpr();
            _fsp--;

            parameters.add(p1);
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:186:46: ( COLON p2= boolAndExpr )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==COLON) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:186:47: COLON p2= boolAndExpr
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:189:1: characterisation returns [VariableCharacterisationType ct] : type= characterisation_keywords ;
    public final VariableCharacterisationType characterisation() throws RecognitionException {
        VariableCharacterisationType ct = null;

        String type = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:191:2: (type= characterisation_keywords )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:191:2: type= characterisation_keywords
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:205:1: definition returns [ProbabilityFunctionLiteral pfl] : ( INTPMF ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (isample= numeric_int_sample )+ SQUARE_PAREN_R | DOUBLEPMF ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (rsample= numeric_real_sample )+ SQUARE_PAREN_R | ENUMPMF ( LPAREN (uunit= unit ) ( SEMI ORDERED_DEF ) RPAREN )? SQUARE_PAREN_L (ssample= stringsample )+ SQUARE_PAREN_R | DOUBLEPDF ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (pdf_sample= real_pdf_sample )+ SQUARE_PAREN_R | BOOLPMF ( LPAREN (uunit= bool_unit ) ( SEMI ORDERED_DEF )? RPAREN )? SQUARE_PAREN_L (ssample= boolsample )+ SQUARE_PAREN_R );
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
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:211:4: ( INTPMF ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (isample= numeric_int_sample )+ SQUARE_PAREN_R | DOUBLEPMF ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (rsample= numeric_real_sample )+ SQUARE_PAREN_R | ENUMPMF ( LPAREN (uunit= unit ) ( SEMI ORDERED_DEF ) RPAREN )? SQUARE_PAREN_L (ssample= stringsample )+ SQUARE_PAREN_R | DOUBLEPDF ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (pdf_sample= real_pdf_sample )+ SQUARE_PAREN_R | BOOLPMF ( LPAREN (uunit= bool_unit ) ( SEMI ORDERED_DEF )? RPAREN )? SQUARE_PAREN_L (ssample= boolsample )+ SQUARE_PAREN_R )
            int alt27=5;
            switch ( input.LA(1) ) {
            case INTPMF:
                {
                alt27=1;
                }
                break;
            case DOUBLEPMF:
                {
                alt27=2;
                }
                break;
            case ENUMPMF:
                {
                alt27=3;
                }
                break;
            case DOUBLEPDF:
                {
                alt27=4;
                }
                break;
            case BOOLPMF:
                {
                alt27=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("205:1: definition returns [ProbabilityFunctionLiteral pfl] : ( INTPMF ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (isample= numeric_int_sample )+ SQUARE_PAREN_R | DOUBLEPMF ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (rsample= numeric_real_sample )+ SQUARE_PAREN_R | ENUMPMF ( LPAREN (uunit= unit ) ( SEMI ORDERED_DEF ) RPAREN )? SQUARE_PAREN_L (ssample= stringsample )+ SQUARE_PAREN_R | DOUBLEPDF ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (pdf_sample= real_pdf_sample )+ SQUARE_PAREN_R | BOOLPMF ( LPAREN (uunit= bool_unit ) ( SEMI ORDERED_DEF )? RPAREN )? SQUARE_PAREN_L (ssample= boolsample )+ SQUARE_PAREN_R );", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:211:4: INTPMF ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (isample= numeric_int_sample )+ SQUARE_PAREN_R
                    {
                    match(input,INTPMF,FOLLOW_INTPMF_in_definition1032); 
                    probFunction = ProbfunctionFactory.eINSTANCE.createProbabilityMassFunction();
                    				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:214:4: ( LPAREN (uunit= unit ) RPAREN )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==LPAREN) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:214:5: LPAREN (uunit= unit ) RPAREN
                            {
                            match(input,LPAREN,FOLLOW_LPAREN_in_definition1044); 
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:215:6: (uunit= unit )
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:216:6: uunit= unit
                            {
                            pushFollow(FOLLOW_unit_in_definition1062);
                            uunit=unit();
                            _fsp--;

                            probFunction.setUnit(uunit);

                            }

                            match(input,RPAREN,FOLLOW_RPAREN_in_definition1076); 

                            }
                            break;

                    }

                    match(input,SQUARE_PAREN_L,FOLLOW_SQUARE_PAREN_L_in_definition1083); 
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:220:5: (isample= numeric_int_sample )+
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
                    	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:221:7: isample= numeric_int_sample
                    	    {
                    	    pushFollow(FOLLOW_numeric_int_sample_in_definition1103);
                    	    isample=numeric_int_sample();
                    	    _fsp--;

                    	    ((ProbabilityMassFunction)probFunction).getSamples().add(isample);

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

                    match(input,SQUARE_PAREN_R,FOLLOW_SQUARE_PAREN_R_in_definition1120); 

                    }
                    break;
                case 2 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:225:5: DOUBLEPMF ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (rsample= numeric_real_sample )+ SQUARE_PAREN_R
                    {
                    match(input,DOUBLEPMF,FOLLOW_DOUBLEPMF_in_definition1133); 
                    probFunction = ProbfunctionFactory.eINSTANCE.createProbabilityMassFunction();
                    				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:228:4: ( LPAREN (uunit= unit ) RPAREN )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==LPAREN) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:228:5: LPAREN (uunit= unit ) RPAREN
                            {
                            match(input,LPAREN,FOLLOW_LPAREN_in_definition1146); 
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:229:6: (uunit= unit )
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:230:6: uunit= unit
                            {
                            pushFollow(FOLLOW_unit_in_definition1164);
                            uunit=unit();
                            _fsp--;

                            probFunction.setUnit(uunit);

                            }

                            match(input,RPAREN,FOLLOW_RPAREN_in_definition1178); 

                            }
                            break;

                    }

                    match(input,SQUARE_PAREN_L,FOLLOW_SQUARE_PAREN_L_in_definition1186); 
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:234:5: (rsample= numeric_real_sample )+
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
                    	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:235:5: rsample= numeric_real_sample
                    	    {
                    	    pushFollow(FOLLOW_numeric_real_sample_in_definition1204);
                    	    rsample=numeric_real_sample();
                    	    _fsp--;

                    	    ((ProbabilityMassFunction)probFunction).getSamples().add(rsample);

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

                    match(input,SQUARE_PAREN_R,FOLLOW_SQUARE_PAREN_R_in_definition1221); 

                    }
                    break;
                case 3 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:240:4: ENUMPMF ( LPAREN (uunit= unit ) ( SEMI ORDERED_DEF ) RPAREN )? SQUARE_PAREN_L (ssample= stringsample )+ SQUARE_PAREN_R
                    {
                    match(input,ENUMPMF,FOLLOW_ENUMPMF_in_definition1235); 
                    probFunction = ProbfunctionFactory.eINSTANCE.createProbabilityMassFunction();
                    				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
                    				   ((ProbabilityMassFunction)probFunction).setOrderedDomain(false);
                    				   
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:245:4: ( LPAREN (uunit= unit ) ( SEMI ORDERED_DEF ) RPAREN )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==LPAREN) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:245:5: LPAREN (uunit= unit ) ( SEMI ORDERED_DEF ) RPAREN
                            {
                            match(input,LPAREN,FOLLOW_LPAREN_in_definition1248); 
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:246:6: (uunit= unit )
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:247:6: uunit= unit
                            {
                            pushFollow(FOLLOW_unit_in_definition1266);
                            uunit=unit();
                            _fsp--;

                            probFunction.setUnit(uunit);

                            }

                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:249:6: ( SEMI ORDERED_DEF )
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:249:7: SEMI ORDERED_DEF
                            {
                            match(input,SEMI,FOLLOW_SEMI_in_definition1283); 
                            match(input,ORDERED_DEF,FOLLOW_ORDERED_DEF_in_definition1290); 
                            ((ProbabilityMassFunction)probFunction).setOrderedDomain(true);

                            }

                            match(input,RPAREN,FOLLOW_RPAREN_in_definition1309); 

                            }
                            break;

                    }

                    match(input,SQUARE_PAREN_L,FOLLOW_SQUARE_PAREN_L_in_definition1316); 
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:255:5: (ssample= stringsample )+
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
                    	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:256:5: ssample= stringsample
                    	    {
                    	    pushFollow(FOLLOW_stringsample_in_definition1334);
                    	    ssample=stringsample();
                    	    _fsp--;

                    	    ((ProbabilityMassFunction)probFunction).getSamples().add(ssample);

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

                    match(input,SQUARE_PAREN_R,FOLLOW_SQUARE_PAREN_R_in_definition1351); 

                    }
                    break;
                case 4 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:260:4: DOUBLEPDF ( LPAREN (uunit= unit ) RPAREN )? SQUARE_PAREN_L (pdf_sample= real_pdf_sample )+ SQUARE_PAREN_R
                    {
                    match(input,DOUBLEPDF,FOLLOW_DOUBLEPDF_in_definition1361); 
                    probFunction = ProbfunctionFactory.eINSTANCE.createBoxedPDF();
                    				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:263:4: ( LPAREN (uunit= unit ) RPAREN )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==LPAREN) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:263:5: LPAREN (uunit= unit ) RPAREN
                            {
                            match(input,LPAREN,FOLLOW_LPAREN_in_definition1373); 
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:264:6: (uunit= unit )
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:265:6: uunit= unit
                            {
                            pushFollow(FOLLOW_unit_in_definition1391);
                            uunit=unit();
                            _fsp--;

                            probFunction.setUnit(uunit);

                            }

                            match(input,RPAREN,FOLLOW_RPAREN_in_definition1405); 

                            }
                            break;

                    }

                    match(input,SQUARE_PAREN_L,FOLLOW_SQUARE_PAREN_L_in_definition1412); 
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:269:5: (pdf_sample= real_pdf_sample )+
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
                    	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:270:7: pdf_sample= real_pdf_sample
                    	    {
                    	    pushFollow(FOLLOW_real_pdf_sample_in_definition1432);
                    	    pdf_sample=real_pdf_sample();
                    	    _fsp--;

                    	    ((BoxedPDF)probFunction).getSamples().add(pdf_sample);

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

                    match(input,SQUARE_PAREN_R,FOLLOW_SQUARE_PAREN_R_in_definition1449); 

                    }
                    break;
                case 5 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:274:4: BOOLPMF ( LPAREN (uunit= bool_unit ) ( SEMI ORDERED_DEF )? RPAREN )? SQUARE_PAREN_L (ssample= boolsample )+ SQUARE_PAREN_R
                    {
                    match(input,BOOLPMF,FOLLOW_BOOLPMF_in_definition1460); 
                    probFunction = ProbfunctionFactory.eINSTANCE.createProbabilityMassFunction();
                    				   pfl.setFunction_ProbabilityFunctionLiteral(probFunction);
                    				   ((ProbabilityMassFunction)probFunction).setOrderedDomain(false);
                    				   
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:279:4: ( LPAREN (uunit= bool_unit ) ( SEMI ORDERED_DEF )? RPAREN )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==LPAREN) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:279:5: LPAREN (uunit= bool_unit ) ( SEMI ORDERED_DEF )? RPAREN
                            {
                            match(input,LPAREN,FOLLOW_LPAREN_in_definition1473); 
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:280:6: (uunit= bool_unit )
                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:281:6: uunit= bool_unit
                            {
                            pushFollow(FOLLOW_bool_unit_in_definition1491);
                            uunit=bool_unit();
                            _fsp--;

                            probFunction.setUnit(uunit);

                            }

                            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:283:6: ( SEMI ORDERED_DEF )?
                            int alt24=2;
                            int LA24_0 = input.LA(1);

                            if ( (LA24_0==SEMI) ) {
                                alt24=1;
                            }
                            switch (alt24) {
                                case 1 :
                                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:283:7: SEMI ORDERED_DEF
                                    {
                                    match(input,SEMI,FOLLOW_SEMI_in_definition1508); 
                                    match(input,ORDERED_DEF,FOLLOW_ORDERED_DEF_in_definition1515); 
                                    ((ProbabilityMassFunction)probFunction).setOrderedDomain(true);

                                    }
                                    break;

                            }

                            match(input,RPAREN,FOLLOW_RPAREN_in_definition1535); 

                            }
                            break;

                    }

                    match(input,SQUARE_PAREN_L,FOLLOW_SQUARE_PAREN_L_in_definition1542); 
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:289:5: (ssample= boolsample )+
                    int cnt26=0;
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==LPAREN) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:290:5: ssample= boolsample
                    	    {
                    	    pushFollow(FOLLOW_boolsample_in_definition1560);
                    	    ssample=boolsample();
                    	    _fsp--;

                    	    ((ProbabilityMassFunction)probFunction).getSamples().add(ssample);

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt26 >= 1 ) break loop26;
                                EarlyExitException eee =
                                    new EarlyExitException(26, input);
                                throw eee;
                        }
                        cnt26++;
                    } while (true);

                    match(input,SQUARE_PAREN_R,FOLLOW_SQUARE_PAREN_R_in_definition1577); 

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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:296:1: unit returns [Unit u] : UNIT DEFINITION str= STRING_LITERAL ;
    public final Unit unit() throws RecognitionException {
        Unit u = null;

        Token str=null;

        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:298:3: ( UNIT DEFINITION str= STRING_LITERAL )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:298:3: UNIT DEFINITION str= STRING_LITERAL
            {
            match(input,UNIT,FOLLOW_UNIT_in_unit1601); 
             u = ProbfunctionFactory.eINSTANCE.createUnit(); 
            match(input,DEFINITION,FOLLOW_DEFINITION_in_unit1611); 
            str=(Token)input.LT(1);
            match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_unit1618); 
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:304:1: bool_unit returns [Unit u] : UNIT EQUAL BOOL ;
    public final Unit bool_unit() throws RecognitionException {
        Unit u = null;

        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:306:3: ( UNIT EQUAL BOOL )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:306:3: UNIT EQUAL BOOL
            {
            match(input,UNIT,FOLLOW_UNIT_in_bool_unit1640); 
             u = ProbfunctionFactory.eINSTANCE.createUnit(); 
            match(input,EQUAL,FOLLOW_EQUAL_in_bool_unit1650); 
            match(input,BOOL,FOLLOW_BOOL_in_bool_unit1655); 
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:313:1: numeric_int_sample returns [Sample s] : LPAREN n= NUMBER SEMI n2= NUMBER RPAREN ;
    public final Sample numeric_int_sample() throws RecognitionException {
        Sample s = null;

        Token n=null;
        Token n2=null;

        s = null;
        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:315:3: ( LPAREN n= NUMBER SEMI n2= NUMBER RPAREN )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:315:3: LPAREN n= NUMBER SEMI n2= NUMBER RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_numeric_int_sample1683); 
            s = ProbfunctionFactory.eINSTANCE.createSample();
            n=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_numeric_int_sample1696); 
            s.setValue(Integer.parseInt(n.getText()));
            match(input,SEMI,FOLLOW_SEMI_in_numeric_int_sample1707); 
            n2=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_numeric_int_sample1715); 
            s.setProbability(Double.parseDouble(n2.getText()));
            match(input,RPAREN,FOLLOW_RPAREN_in_numeric_int_sample1727); 

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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:324:1: numeric_real_sample returns [Sample s] : LPAREN n= NUMBER SEMI n2= NUMBER RPAREN ;
    public final Sample numeric_real_sample() throws RecognitionException {
        Sample s = null;

        Token n=null;
        Token n2=null;

        s = null;
        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:326:3: ( LPAREN n= NUMBER SEMI n2= NUMBER RPAREN )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:326:3: LPAREN n= NUMBER SEMI n2= NUMBER RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_numeric_real_sample1750); 
            s = ProbfunctionFactory.eINSTANCE.createSample();
            n=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_numeric_real_sample1763); 
            s.setValue(Double.parseDouble(n.getText()));
            match(input,SEMI,FOLLOW_SEMI_in_numeric_real_sample1774); 
            n2=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_numeric_real_sample1782); 
            s.setProbability(Double.parseDouble(n2.getText()));
            match(input,RPAREN,FOLLOW_RPAREN_in_numeric_real_sample1794); 

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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:335:1: real_pdf_sample returns [ContinuousSample s] : LPAREN n= NUMBER SEMI n2= NUMBER RPAREN ;
    public final ContinuousSample real_pdf_sample() throws RecognitionException {
        ContinuousSample s = null;

        Token n=null;
        Token n2=null;

        s = null;
        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:337:3: ( LPAREN n= NUMBER SEMI n2= NUMBER RPAREN )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:337:3: LPAREN n= NUMBER SEMI n2= NUMBER RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_real_pdf_sample1818); 
            s = ProbfunctionFactory.eINSTANCE.createContinuousSample();
            n=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_real_pdf_sample1831); 
            s.setValue(Double.parseDouble(n.getText()));
            match(input,SEMI,FOLLOW_SEMI_in_real_pdf_sample1842); 
            n2=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_real_pdf_sample1850); 
            s.setProbability(Double.parseDouble(n2.getText()));
            match(input,RPAREN,FOLLOW_RPAREN_in_real_pdf_sample1862); 

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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:346:1: stringsample returns [Sample s] : LPAREN str= STRING_LITERAL SEMI n= NUMBER RPAREN ;
    public final Sample stringsample() throws RecognitionException {
        Sample s = null;

        Token str=null;
        Token n=null;

        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:348:3: ( LPAREN str= STRING_LITERAL SEMI n= NUMBER RPAREN )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:348:3: LPAREN str= STRING_LITERAL SEMI n= NUMBER RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_stringsample1883); 
            s = ProbfunctionFactory.eINSTANCE.createSample();
            str=(Token)input.LT(1);
            match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_stringsample1895); 
            s.setValue(str.getText().replace("\"",""));
            match(input,SEMI,FOLLOW_SEMI_in_stringsample1906); 
            n=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_stringsample1912); 
            s.setProbability(Double.parseDouble(n.getText()));
            match(input,RPAREN,FOLLOW_RPAREN_in_stringsample1923); 

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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:357:1: boolsample returns [Sample s] : LPAREN str= boolean_keywords SEMI n= NUMBER RPAREN ;
    public final Sample boolsample() throws RecognitionException {
        Sample s = null;

        Token n=null;
        String str = null;


        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:359:3: ( LPAREN str= boolean_keywords SEMI n= NUMBER RPAREN )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:359:3: LPAREN str= boolean_keywords SEMI n= NUMBER RPAREN
            {
            match(input,LPAREN,FOLLOW_LPAREN_in_boolsample1941); 
            s = ProbfunctionFactory.eINSTANCE.createSample();
            pushFollow(FOLLOW_boolean_keywords_in_boolsample1955);
            str=boolean_keywords();
            _fsp--;

            s.setValue(str.equals("true"));
            match(input,SEMI,FOLLOW_SEMI_in_boolsample1963); 
            n=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_boolsample1969); 
            s.setProbability(Double.parseDouble(n.getText()));
            match(input,RPAREN,FOLLOW_RPAREN_in_boolsample1980); 

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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:368:1: boolean_keywords returns [String keyword] : ( FALSE | TRUE ) ;
    public final String boolean_keywords() throws RecognitionException {
        String keyword = null;

        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:370:3: ( ( FALSE | TRUE ) )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:370:3: ( FALSE | TRUE )
            {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:370:3: ( FALSE | TRUE )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==FALSE) ) {
                alt28=1;
            }
            else if ( (LA28_0==TRUE) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("370:3: ( FALSE | TRUE )", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:371:3: FALSE
                    {
                    match(input,FALSE,FOLLOW_FALSE_in_boolean_keywords1999); 
                    keyword = "false";

                    }
                    break;
                case 2 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:374:3: TRUE
                    {
                    match(input,TRUE,FOLLOW_TRUE_in_boolean_keywords2013); 
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:378:1: characterisation_keywords returns [String keyword] : ( BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE ) ;
    public final String characterisation_keywords() throws RecognitionException {
        String keyword = null;

        keyword = null;
        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:380:2: ( ( BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE ) )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:380:2: ( BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE )
            {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:380:2: ( BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE )
            int alt29=5;
            switch ( input.LA(1) ) {
            case BYTESIZE:
                {
                alt29=1;
                }
                break;
            case STRUCTURE:
                {
                alt29=2;
                }
                break;
            case NUMBER_OF_ELEMENTS:
                {
                alt29=3;
                }
                break;
            case TYPE:
                {
                alt29=4;
                }
                break;
            case VALUE:
                {
                alt29=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("380:2: ( BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE )", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:380:3: BYTESIZE
                    {
                    match(input,BYTESIZE,FOLLOW_BYTESIZE_in_characterisation_keywords2041); 
                    keyword="BYTESIZE";

                    }
                    break;
                case 2 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:381:4: STRUCTURE
                    {
                    match(input,STRUCTURE,FOLLOW_STRUCTURE_in_characterisation_keywords2048); 
                    keyword="STRUCTURE";

                    }
                    break;
                case 3 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:382:4: NUMBER_OF_ELEMENTS
                    {
                    match(input,NUMBER_OF_ELEMENTS,FOLLOW_NUMBER_OF_ELEMENTS_in_characterisation_keywords2055); 
                    keyword="NUMBER_OF_ELEMENTS";

                    }
                    break;
                case 4 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:383:4: TYPE
                    {
                    match(input,TYPE,FOLLOW_TYPE_in_characterisation_keywords2062); 
                    keyword="TYPE";

                    }
                    break;
                case 5 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:384:4: VALUE
                    {
                    match(input,VALUE,FOLLOW_VALUE_in_characterisation_keywords2069); 
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
    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:387:1: scoped_id returns [AbstractNamedReference ref] : id1= ID ( DOT (id2= ID | INNER ) )* ;
    public final AbstractNamedReference scoped_id() throws RecognitionException {
        AbstractNamedReference ref = null;

        Token id1=null;
        Token id2=null;

        ref = null;
        		ArrayList<String> nameParts = new ArrayList<String>();
        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:391:2: (id1= ID ( DOT (id2= ID | INNER ) )* )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:391:2: id1= ID ( DOT (id2= ID | INNER ) )*
            {
            id1=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_scoped_id2099); 
            nameParts.add(id1.getText());
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:392:6: ( DOT (id2= ID | INNER ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==DOT) ) {
                    int LA31_1 = input.LA(2);

                    if ( (LA31_1==ID||LA31_1==INNER) ) {
                        alt31=1;
                    }


                }


                switch (alt31) {
            	case 1 :
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:392:7: DOT (id2= ID | INNER )
            	    {
            	    match(input,DOT,FOLLOW_DOT_in_scoped_id2110); 
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:392:11: (id2= ID | INNER )
            	    int alt30=2;
            	    int LA30_0 = input.LA(1);

            	    if ( (LA30_0==ID) ) {
            	        alt30=1;
            	    }
            	    else if ( (LA30_0==INNER) ) {
            	        alt30=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("392:11: (id2= ID | INNER )", 30, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt30) {
            	        case 1 :
            	            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:392:12: id2= ID
            	            {
            	            id2=(Token)input.LT(1);
            	            match(input,ID,FOLLOW_ID_in_scoped_id2115); 
            	            nameParts.add(id2.getText());

            	            }
            	            break;
            	        case 2 :
            	            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:392:53: INNER
            	            {
            	            match(input,INNER,FOLLOW_INNER_in_scoped_id2121); 
            	            nameParts.add("INNER");

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
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
    public static final BitSet FOLLOW_53_in_ifelseExpr70 = new BitSet(new long[]{0x0000018CC9B84000L});
    public static final BitSet FOLLOW_boolAndExpr_in_ifelseExpr76 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_ifelseExpr80 = new BitSet(new long[]{0x0000018CC9B84000L});
    public static final BitSet FOLLOW_boolAndExpr_in_ifelseExpr86 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolOrExpr_in_boolAndExpr111 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_AND_in_boolAndExpr122 = new BitSet(new long[]{0x0000018CC9B84000L});
    public static final BitSet FOLLOW_boolOrExpr_in_boolAndExpr133 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_compareExpr_in_boolOrExpr160 = new BitSet(new long[]{0x0000000000000062L});
    public static final BitSet FOLLOW_OR_in_boolOrExpr173 = new BitSet(new long[]{0x0000018CC9B84000L});
    public static final BitSet FOLLOW_XOR_in_boolOrExpr181 = new BitSet(new long[]{0x0000018CC9B84000L});
    public static final BitSet FOLLOW_compareExpr_in_boolOrExpr193 = new BitSet(new long[]{0x0000000000000062L});
    public static final BitSet FOLLOW_sumExpr_in_compareExpr231 = new BitSet(new long[]{0x0000000000001F82L});
    public static final BitSet FOLLOW_GREATER_in_compareExpr248 = new BitSet(new long[]{0x0000018CC9B84000L});
    public static final BitSet FOLLOW_LESS_in_compareExpr258 = new BitSet(new long[]{0x0000018CC9B84000L});
    public static final BitSet FOLLOW_EQUAL_in_compareExpr268 = new BitSet(new long[]{0x0000018CC9B84000L});
    public static final BitSet FOLLOW_NOTEQUAL_in_compareExpr278 = new BitSet(new long[]{0x0000018CC9B84000L});
    public static final BitSet FOLLOW_GREATEREQUAL_in_compareExpr288 = new BitSet(new long[]{0x0000018CC9B84000L});
    public static final BitSet FOLLOW_LESSEQUAL_in_compareExpr298 = new BitSet(new long[]{0x0000018CC9B84000L});
    public static final BitSet FOLLOW_sumExpr_in_compareExpr313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_prodExpr_in_sumExpr345 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_PLUS_in_sumExpr363 = new BitSet(new long[]{0x0000018CC9B84000L});
    public static final BitSet FOLLOW_MINUS_in_sumExpr371 = new BitSet(new long[]{0x0000018CC9B84000L});
    public static final BitSet FOLLOW_prodExpr_in_sumExpr385 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_powExpr_in_prodExpr423 = new BitSet(new long[]{0x0000000000038002L});
    public static final BitSet FOLLOW_MUL_in_prodExpr443 = new BitSet(new long[]{0x0000018CC9B84000L});
    public static final BitSet FOLLOW_DIV_in_prodExpr454 = new BitSet(new long[]{0x0000018CC9B84000L});
    public static final BitSet FOLLOW_MOD_in_prodExpr465 = new BitSet(new long[]{0x0000018CC9B84000L});
    public static final BitSet FOLLOW_powExpr_in_prodExpr481 = new BitSet(new long[]{0x0000000000038002L});
    public static final BitSet FOLLOW_unaryExpr_in_powExpr522 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_POW_in_powExpr531 = new BitSet(new long[]{0x0000018CC9B84000L});
    public static final BitSet FOLLOW_unaryExpr_in_powExpr537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_unaryExpr573 = new BitSet(new long[]{0x0000018CC9B84000L});
    public static final BitSet FOLLOW_unaryExpr_in_unaryExpr579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_unaryExpr597 = new BitSet(new long[]{0x0000018CC9B84000L});
    public static final BitSet FOLLOW_unaryExpr_in_unaryExpr603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_unaryExpr625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_atom660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definition_in_atom687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_atom712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolean_keywords_in_atom739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scoped_id_in_atom767 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_DOT_in_atom769 = new BitSet(new long[]{0x00003E0000000000L});
    public static final BitSet FOLLOW_characterisation_in_atom775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_atom802 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_arguments_in_atom815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_atom840 = new BitSet(new long[]{0x0000018CC9B84000L});
    public static final BitSet FOLLOW_ifelseExpr_in_atom850 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RPAREN_in_atom856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_arguments902 = new BitSet(new long[]{0x0000018CCBB84000L});
    public static final BitSet FOLLOW_expressionList_in_arguments908 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RPAREN_in_arguments913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolAndExpr_in_expressionList951 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_COLON_in_expressionList956 = new BitSet(new long[]{0x0000018CC9B84000L});
    public static final BitSet FOLLOW_boolAndExpr_in_expressionList962 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_characterisation_keywords_in_characterisation995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTPMF_in_definition1032 = new BitSet(new long[]{0x0000000011000000L});
    public static final BitSet FOLLOW_LPAREN_in_definition1044 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_unit_in_definition1062 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RPAREN_in_definition1076 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_L_in_definition1083 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_numeric_int_sample_in_definition1103 = new BitSet(new long[]{0x0000000021000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_R_in_definition1120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLEPMF_in_definition1133 = new BitSet(new long[]{0x0000000011000000L});
    public static final BitSet FOLLOW_LPAREN_in_definition1146 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_unit_in_definition1164 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RPAREN_in_definition1178 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_L_in_definition1186 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_numeric_real_sample_in_definition1204 = new BitSet(new long[]{0x0000000021000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_R_in_definition1221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENUMPMF_in_definition1235 = new BitSet(new long[]{0x0000000011000000L});
    public static final BitSet FOLLOW_LPAREN_in_definition1248 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_unit_in_definition1266 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_SEMI_in_definition1283 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_ORDERED_DEF_in_definition1290 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RPAREN_in_definition1309 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_L_in_definition1316 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_stringsample_in_definition1334 = new BitSet(new long[]{0x0000000021000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_R_in_definition1351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLEPDF_in_definition1361 = new BitSet(new long[]{0x0000000011000000L});
    public static final BitSet FOLLOW_LPAREN_in_definition1373 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_unit_in_definition1391 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RPAREN_in_definition1405 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_L_in_definition1412 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_real_pdf_sample_in_definition1432 = new BitSet(new long[]{0x0000000021000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_R_in_definition1449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLPMF_in_definition1460 = new BitSet(new long[]{0x0000000011000000L});
    public static final BitSet FOLLOW_LPAREN_in_definition1473 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_bool_unit_in_definition1491 = new BitSet(new long[]{0x0000000102000000L});
    public static final BitSet FOLLOW_SEMI_in_definition1508 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_ORDERED_DEF_in_definition1515 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RPAREN_in_definition1535 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_L_in_definition1542 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_boolsample_in_definition1560 = new BitSet(new long[]{0x0000000021000000L});
    public static final BitSet FOLLOW_SQUARE_PAREN_R_in_definition1577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNIT_in_unit1601 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_DEFINITION_in_unit1611 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_unit1618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNIT_in_bool_unit1640 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EQUAL_in_bool_unit1650 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_BOOL_in_bool_unit1655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_numeric_int_sample1683 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_numeric_int_sample1696 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_SEMI_in_numeric_int_sample1707 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_numeric_int_sample1715 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RPAREN_in_numeric_int_sample1727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_numeric_real_sample1750 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_numeric_real_sample1763 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_SEMI_in_numeric_real_sample1774 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_numeric_real_sample1782 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RPAREN_in_numeric_real_sample1794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_real_pdf_sample1818 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_real_pdf_sample1831 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_SEMI_in_real_pdf_sample1842 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_real_pdf_sample1850 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RPAREN_in_real_pdf_sample1862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_stringsample1883 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_stringsample1895 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_SEMI_in_stringsample1906 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_stringsample1912 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RPAREN_in_stringsample1923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_boolsample1941 = new BitSet(new long[]{0x0000018000000000L});
    public static final BitSet FOLLOW_boolean_keywords_in_boolsample1955 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_SEMI_in_boolsample1963 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_NUMBER_in_boolsample1969 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RPAREN_in_boolsample1980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_boolean_keywords1999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_boolean_keywords2013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BYTESIZE_in_characterisation_keywords2041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRUCTURE_in_characterisation_keywords2048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_OF_ELEMENTS_in_characterisation_keywords2055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TYPE_in_characterisation_keywords2062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VALUE_in_characterisation_keywords2069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_scoped_id2099 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_DOT_in_scoped_id2110 = new BitSet(new long[]{0x0000400000800000L});
    public static final BitSet FOLLOW_ID_in_scoped_id2115 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_INNER_in_scoped_id2121 = new BitSet(new long[]{0x0000000000400002L});

}
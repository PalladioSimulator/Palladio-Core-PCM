// $ANTLR 3.2 Sep 23, 2009 12:02:23 /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g 2011-01-25 18:10:25
  
  package de.uka.ipd.sdq.stoex.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class StochasticExpressionsLexer extends Lexer {
    public static final int INNER=43;
    public static final int MOD=17;
    public static final int BOOLPMF=33;
    public static final int ENUMPMF=30;
    public static final int GREATEREQUAL=11;
    public static final int Exponent=48;
    public static final int NOT=19;
    public static final int ID=22;
    public static final int AND=4;
    public static final int EOF=-1;
    public static final int STRUCTURE=38;
    public static final int LPAREN=23;
    public static final int TYPE=40;
    public static final int NOTEQUAL=10;
    public static final int RPAREN=24;
    public static final int STRING_LITERAL=21;
    public static final int GREATER=7;
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

    public StochasticExpressionsLexer() {;} 
    public StochasticExpressionsLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public StochasticExpressionsLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g"; }

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:7:7: ( '?' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:7:9: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:8:7: ( ':' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:8:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:385:2: ( 'OR' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:385:4: 'OR'
            {
            match("OR"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OR"

    // $ANTLR start "XOR"
    public final void mXOR() throws RecognitionException {
        try {
            int _type = XOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:389:2: ( 'XOR' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:389:4: 'XOR'
            {
            match("XOR"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "XOR"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:393:2: ( 'AND' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:393:4: 'AND'
            {
            match("AND"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:397:2: ( 'NOT' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:397:4: 'NOT'
            {
            match("NOT"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NOT"

    // $ANTLR start "INTPMF"
    public final void mINTPMF() throws RecognitionException {
        try {
            int _type = INTPMF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:401:2: ( 'IntPMF' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:401:4: 'IntPMF'
            {
            match("IntPMF"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTPMF"

    // $ANTLR start "DOUBLEPMF"
    public final void mDOUBLEPMF() throws RecognitionException {
        try {
            int _type = DOUBLEPMF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:405:2: ( 'DoublePMF' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:405:4: 'DoublePMF'
            {
            match("DoublePMF"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOUBLEPMF"

    // $ANTLR start "ENUMPMF"
    public final void mENUMPMF() throws RecognitionException {
        try {
            int _type = ENUMPMF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:409:2: ( 'EnumPMF' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:409:4: 'EnumPMF'
            {
            match("EnumPMF"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ENUMPMF"

    // $ANTLR start "DOUBLEPDF"
    public final void mDOUBLEPDF() throws RecognitionException {
        try {
            int _type = DOUBLEPDF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:413:2: ( 'DoublePDF' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:413:4: 'DoublePDF'
            {
            match("DoublePDF"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOUBLEPDF"

    // $ANTLR start "BOOLPMF"
    public final void mBOOLPMF() throws RecognitionException {
        try {
            int _type = BOOLPMF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:417:2: ( 'BoolPMF' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:417:4: 'BoolPMF'
            {
            match("BoolPMF"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BOOLPMF"

    // $ANTLR start "UNIT"
    public final void mUNIT() throws RecognitionException {
        try {
            int _type = UNIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:421:2: ( 'unit' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:421:4: 'unit'
            {
            match("unit"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "UNIT"

    // $ANTLR start "BOOL"
    public final void mBOOL() throws RecognitionException {
        try {
            int _type = BOOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:425:2: ( '\"bool\"' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:425:4: '\"bool\"'
            {
            match("\"bool\""); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BOOL"

    // $ANTLR start "FALSE"
    public final void mFALSE() throws RecognitionException {
        try {
            int _type = FALSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:429:2: ( 'false' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:429:4: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FALSE"

    // $ANTLR start "TRUE"
    public final void mTRUE() throws RecognitionException {
        try {
            int _type = TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:433:2: ( 'true' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:433:4: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TRUE"

    // $ANTLR start "BYTESIZE"
    public final void mBYTESIZE() throws RecognitionException {
        try {
            int _type = BYTESIZE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:437:2: ( 'BYTESIZE' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:437:4: 'BYTESIZE'
            {
            match("BYTESIZE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BYTESIZE"

    // $ANTLR start "STRUCTURE"
    public final void mSTRUCTURE() throws RecognitionException {
        try {
            int _type = STRUCTURE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:441:2: ( 'STRUCTURE' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:441:4: 'STRUCTURE'
            {
            match("STRUCTURE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRUCTURE"

    // $ANTLR start "NUMBER_OF_ELEMENTS"
    public final void mNUMBER_OF_ELEMENTS() throws RecognitionException {
        try {
            int _type = NUMBER_OF_ELEMENTS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:445:2: ( 'NUMBER_OF_ELEMENTS' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:445:4: 'NUMBER_OF_ELEMENTS'
            {
            match("NUMBER_OF_ELEMENTS"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NUMBER_OF_ELEMENTS"

    // $ANTLR start "TYPE"
    public final void mTYPE() throws RecognitionException {
        try {
            int _type = TYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:449:2: ( 'TYPE' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:449:4: 'TYPE'
            {
            match("TYPE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TYPE"

    // $ANTLR start "VALUE"
    public final void mVALUE() throws RecognitionException {
        try {
            int _type = VALUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:453:2: ( 'VALUE' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:453:4: 'VALUE'
            {
            match("VALUE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VALUE"

    // $ANTLR start "INNER"
    public final void mINNER() throws RecognitionException {
        try {
            int _type = INNER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:457:2: ( 'INNER' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:457:4: 'INNER'
            {
            match("INNER"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INNER"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:460:7: ( '+' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:460:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:461:7: ( '-' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:461:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "MUL"
    public final void mMUL() throws RecognitionException {
        try {
            int _type = MUL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:462:7: ( '*' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:462:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MUL"

    // $ANTLR start "DIV"
    public final void mDIV() throws RecognitionException {
        try {
            int _type = DIV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:463:7: ( '/' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:463:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DIV"

    // $ANTLR start "MOD"
    public final void mMOD() throws RecognitionException {
        try {
            int _type = MOD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:464:7: ( '%' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:464:9: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MOD"

    // $ANTLR start "POW"
    public final void mPOW() throws RecognitionException {
        try {
            int _type = POW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:465:7: ( '^' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:465:9: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "POW"

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:466:7: ( '(' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:466:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LPAREN"

    // $ANTLR start "RPAREN"
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:467:7: ( ')' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:467:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RPAREN"

    // $ANTLR start "SEMI"
    public final void mSEMI() throws RecognitionException {
        try {
            int _type = SEMI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:468:7: ( ';' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:468:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SEMI"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:469:8: ( ',' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:469:10: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "DEFINITION"
    public final void mDEFINITION() throws RecognitionException {
        try {
            int _type = DEFINITION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:470:12: ( '=' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:470:14: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DEFINITION"

    // $ANTLR start "ORDERED_DEF"
    public final void mORDERED_DEF() throws RecognitionException {
        try {
            int _type = ORDERED_DEF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:472:2: ( 'ordered' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:472:4: 'ordered'
            {
            match("ordered"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ORDERED_DEF"

    // $ANTLR start "EQUAL"
    public final void mEQUAL() throws RecognitionException {
        try {
            int _type = EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:473:7: ( '==' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:473:9: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQUAL"

    // $ANTLR start "SQUARE_PAREN_L"
    public final void mSQUARE_PAREN_L() throws RecognitionException {
        try {
            int _type = SQUARE_PAREN_L;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:474:16: ( '[' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:474:18: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQUARE_PAREN_L"

    // $ANTLR start "SQUARE_PAREN_R"
    public final void mSQUARE_PAREN_R() throws RecognitionException {
        try {
            int _type = SQUARE_PAREN_R;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:475:16: ( ']' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:475:18: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQUARE_PAREN_R"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:476:16: ( '0' .. '9' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:476:18: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "NUMBER"
    public final void mNUMBER() throws RecognitionException {
        try {
            int _type = NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:477:8: ( ( DIGIT )+ ( '.' ( DIGIT )+ )? ( Exponent )? )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:477:10: ( DIGIT )+ ( '.' ( DIGIT )+ )? ( Exponent )?
            {
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:477:10: ( DIGIT )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:477:11: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:477:19: ( '.' ( DIGIT )+ )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='.') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:477:20: '.' ( DIGIT )+
                    {
                    match('.'); 
                    // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:477:24: ( DIGIT )+
                    int cnt2=0;
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:477:25: DIGIT
                    	    {
                    	    mDIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt2 >= 1 ) break loop2;
                                EarlyExitException eee =
                                    new EarlyExitException(2, input);
                                throw eee;
                        }
                        cnt2++;
                    } while (true);


                    }
                    break;

            }

            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:477:35: ( Exponent )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='E'||LA4_0=='e') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:477:35: Exponent
                    {
                    mExponent(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NUMBER"

    // $ANTLR start "Exponent"
    public final void mExponent() throws RecognitionException {
        try {
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:479:10: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:479:12: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:479:22: ( '+' | '-' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='+'||LA5_0=='-') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:479:33: ( '0' .. '9' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:479:34: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "Exponent"

    // $ANTLR start "ALPHA"
    public final void mALPHA() throws RecognitionException {
        try {
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:480:16: ( 'a' .. 'z' | 'A' .. 'Z' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "ALPHA"

    // $ANTLR start "NOTEQUAL"
    public final void mNOTEQUAL() throws RecognitionException {
        try {
            int _type = NOTEQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:481:10: ( '<>' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:481:12: '<>'
            {
            match("<>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NOTEQUAL"

    // $ANTLR start "GREATER"
    public final void mGREATER() throws RecognitionException {
        try {
            int _type = GREATER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:482:9: ( '>' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:482:11: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GREATER"

    // $ANTLR start "LESS"
    public final void mLESS() throws RecognitionException {
        try {
            int _type = LESS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:483:6: ( '<' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:483:8: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LESS"

    // $ANTLR start "GREATEREQUAL"
    public final void mGREATEREQUAL() throws RecognitionException {
        try {
            int _type = GREATEREQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:484:14: ( '>=' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:484:16: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GREATEREQUAL"

    // $ANTLR start "LESSEQUAL"
    public final void mLESSEQUAL() throws RecognitionException {
        try {
            int _type = LESSEQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:485:11: ( '<=' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:485:13: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LESSEQUAL"

    // $ANTLR start "STRING_LITERAL"
    public final void mSTRING_LITERAL() throws RecognitionException {
        try {
            int _type = STRING_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:486:16: ( '\\\"' ( ALPHA | '_' | ' ' | NUMBER )+ '\\\"' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:486:18: '\\\"' ( ALPHA | '_' | ' ' | NUMBER )+ '\\\"'
            {
            match('\"'); 
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:486:23: ( ALPHA | '_' | ' ' | NUMBER )+
            int cnt7=0;
            loop7:
            do {
                int alt7=5;
                switch ( input.LA(1) ) {
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    {
                    alt7=1;
                    }
                    break;
                case '_':
                    {
                    alt7=2;
                    }
                    break;
                case ' ':
                    {
                    alt7=3;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    {
                    alt7=4;
                    }
                    break;

                }

                switch (alt7) {
            	case 1 :
            	    // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:486:24: ALPHA
            	    {
            	    mALPHA(); 

            	    }
            	    break;
            	case 2 :
            	    // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:486:30: '_'
            	    {
            	    match('_'); 

            	    }
            	    break;
            	case 3 :
            	    // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:486:34: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;
            	case 4 :
            	    // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:486:38: NUMBER
            	    {
            	    mNUMBER(); 

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING_LITERAL"

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:487:4: ( '.' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:487:6: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOT"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:488:3: ( ( ALPHA | '_' )+ )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:488:4: ( ALPHA | '_' )+
            {
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:488:4: ( ALPHA | '_' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='A' && LA8_0<='Z')||LA8_0=='_'||(LA8_0>='a' && LA8_0<='z')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:
            	    {
            	    if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:491:5: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:491:8: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
            {
            if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||(input.LA(1)>='\f' && input.LA(1)<='\r')||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:495:5: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:495:9: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:495:14: ( options {greedy=false; } : . )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='*') ) {
                    int LA9_1 = input.LA(2);

                    if ( (LA9_1=='/') ) {
                        alt9=2;
                    }
                    else if ( ((LA9_1>='\u0000' && LA9_1<='.')||(LA9_1>='0' && LA9_1<='\uFFFF')) ) {
                        alt9=1;
                    }


                }
                else if ( ((LA9_0>='\u0000' && LA9_0<=')')||(LA9_0>='+' && LA9_0<='\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:495:42: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            match("*/"); 

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "LINE_COMMENT"
    public final void mLINE_COMMENT() throws RecognitionException {
        try {
            int _type = LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:499:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? ( '\\n' | EOF ) )
            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:499:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? ( '\\n' | EOF )
            {
            match("//"); 

            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:499:12: (~ ( '\\n' | '\\r' ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\u0000' && LA10_0<='\t')||(LA10_0>='\u000B' && LA10_0<='\f')||(LA10_0>='\u000E' && LA10_0<='\uFFFF')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:499:12: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:499:26: ( '\\r' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\r') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:499:26: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:499:32: ( '\\n' | EOF )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='\n') ) {
                alt12=1;
            }
            else {
                alt12=2;}
            switch (alt12) {
                case 1 :
                    // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:499:33: '\\n'
                    {
                    match('\n'); 

                    }
                    break;
                case 2 :
                    // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:499:38: EOF
                    {
                    match(EOF); 

                    }
                    break;

            }

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LINE_COMMENT"

    public void mTokens() throws RecognitionException {
        // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:8: ( T__53 | T__54 | OR | XOR | AND | NOT | INTPMF | DOUBLEPMF | ENUMPMF | DOUBLEPDF | BOOLPMF | UNIT | BOOL | FALSE | TRUE | BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE | INNER | PLUS | MINUS | MUL | DIV | MOD | POW | LPAREN | RPAREN | SEMI | COLON | DEFINITION | ORDERED_DEF | EQUAL | SQUARE_PAREN_L | SQUARE_PAREN_R | NUMBER | NOTEQUAL | GREATER | LESS | GREATEREQUAL | LESSEQUAL | STRING_LITERAL | DOT | ID | WS | COMMENT | LINE_COMMENT )
        int alt13=48;
        alt13 = dfa13.predict(input);
        switch (alt13) {
            case 1 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:10: T__53
                {
                mT__53(); 

                }
                break;
            case 2 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:16: T__54
                {
                mT__54(); 

                }
                break;
            case 3 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:22: OR
                {
                mOR(); 

                }
                break;
            case 4 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:25: XOR
                {
                mXOR(); 

                }
                break;
            case 5 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:29: AND
                {
                mAND(); 

                }
                break;
            case 6 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:33: NOT
                {
                mNOT(); 

                }
                break;
            case 7 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:37: INTPMF
                {
                mINTPMF(); 

                }
                break;
            case 8 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:44: DOUBLEPMF
                {
                mDOUBLEPMF(); 

                }
                break;
            case 9 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:54: ENUMPMF
                {
                mENUMPMF(); 

                }
                break;
            case 10 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:62: DOUBLEPDF
                {
                mDOUBLEPDF(); 

                }
                break;
            case 11 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:72: BOOLPMF
                {
                mBOOLPMF(); 

                }
                break;
            case 12 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:80: UNIT
                {
                mUNIT(); 

                }
                break;
            case 13 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:85: BOOL
                {
                mBOOL(); 

                }
                break;
            case 14 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:90: FALSE
                {
                mFALSE(); 

                }
                break;
            case 15 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:96: TRUE
                {
                mTRUE(); 

                }
                break;
            case 16 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:101: BYTESIZE
                {
                mBYTESIZE(); 

                }
                break;
            case 17 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:110: STRUCTURE
                {
                mSTRUCTURE(); 

                }
                break;
            case 18 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:120: NUMBER_OF_ELEMENTS
                {
                mNUMBER_OF_ELEMENTS(); 

                }
                break;
            case 19 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:139: TYPE
                {
                mTYPE(); 

                }
                break;
            case 20 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:144: VALUE
                {
                mVALUE(); 

                }
                break;
            case 21 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:150: INNER
                {
                mINNER(); 

                }
                break;
            case 22 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:156: PLUS
                {
                mPLUS(); 

                }
                break;
            case 23 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:161: MINUS
                {
                mMINUS(); 

                }
                break;
            case 24 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:167: MUL
                {
                mMUL(); 

                }
                break;
            case 25 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:171: DIV
                {
                mDIV(); 

                }
                break;
            case 26 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:175: MOD
                {
                mMOD(); 

                }
                break;
            case 27 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:179: POW
                {
                mPOW(); 

                }
                break;
            case 28 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:183: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 29 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:190: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 30 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:197: SEMI
                {
                mSEMI(); 

                }
                break;
            case 31 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:202: COLON
                {
                mCOLON(); 

                }
                break;
            case 32 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:208: DEFINITION
                {
                mDEFINITION(); 

                }
                break;
            case 33 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:219: ORDERED_DEF
                {
                mORDERED_DEF(); 

                }
                break;
            case 34 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:231: EQUAL
                {
                mEQUAL(); 

                }
                break;
            case 35 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:237: SQUARE_PAREN_L
                {
                mSQUARE_PAREN_L(); 

                }
                break;
            case 36 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:252: SQUARE_PAREN_R
                {
                mSQUARE_PAREN_R(); 

                }
                break;
            case 37 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:267: NUMBER
                {
                mNUMBER(); 

                }
                break;
            case 38 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:274: NOTEQUAL
                {
                mNOTEQUAL(); 

                }
                break;
            case 39 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:283: GREATER
                {
                mGREATER(); 

                }
                break;
            case 40 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:291: LESS
                {
                mLESS(); 

                }
                break;
            case 41 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:296: GREATEREQUAL
                {
                mGREATEREQUAL(); 

                }
                break;
            case 42 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:309: LESSEQUAL
                {
                mLESSEQUAL(); 

                }
                break;
            case 43 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:319: STRING_LITERAL
                {
                mSTRING_LITERAL(); 

                }
                break;
            case 44 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:334: DOT
                {
                mDOT(); 

                }
                break;
            case 45 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:338: ID
                {
                mID(); 

                }
                break;
            case 46 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:341: WS
                {
                mWS(); 

                }
                break;
            case 47 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:344: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 48 :
                // /Users/joerg/Documents/work/workspace-pcm/de.uka.ipd.sdq.stoex/src-man/de/uka/ipd/sdq/stoex/parser/StochasticExpressions.g:1:352: LINE_COMMENT
                {
                mLINE_COMMENT(); 

                }
                break;

        }

    }


    protected DFA13 dfa13 = new DFA13(this);
    static final String DFA13_eotS =
        "\3\uffff\11\44\1\uffff\5\44\3\uffff\1\73\6\uffff\1\75\1\44\3\uffff"+
        "\1\101\1\103\3\uffff\1\104\13\44\2\uffff\5\44\5\uffff\1\44\6\uffff"+
        "\1\127\1\130\1\131\10\44\1\uffff\6\44\3\uffff\7\44\1\160\1\uffff"+
        "\1\44\1\163\1\44\1\165\4\44\1\172\4\44\2\uffff\1\u0080\1\uffff\1"+
        "\44\1\uffff\1\u0082\2\44\1\u0085\1\uffff\4\44\2\uffff\1\44\1\uffff"+
        "\2\44\1\uffff\1\44\1\u0090\1\u0091\1\44\1\uffff\1\44\1\u0094\3\44"+
        "\2\uffff\1\u0098\1\44\1\uffff\1\44\1\u009b\1\u009c\1\uffff\1\u009d"+
        "\1\44\3\uffff\7\44\1\u00a6\1\uffff";
    static final String DFA13_eofS =
        "\u00a7\uffff";
    static final String DFA13_minS =
        "\1\11\2\uffff\1\122\1\117\1\116\1\117\1\116\1\157\1\156\1\131\1"+
        "\156\1\40\1\141\1\162\1\124\1\131\1\101\3\uffff\1\52\6\uffff\1\75"+
        "\1\162\3\uffff\2\75\3\uffff\1\101\1\122\1\104\1\124\1\115\1\164"+
        "\1\116\2\165\1\157\1\124\1\151\1\40\1\uffff\1\154\1\165\1\122\1"+
        "\120\1\114\5\uffff\1\144\6\uffff\3\101\1\102\1\120\1\105\1\142\1"+
        "\155\1\154\1\105\1\164\1\40\1\163\1\145\1\125\1\105\1\125\1\145"+
        "\3\uffff\1\105\1\115\1\122\1\154\2\120\1\123\1\101\1\40\1\145\1"+
        "\101\1\103\1\101\1\105\1\162\1\122\1\106\1\101\1\145\2\115\1\111"+
        "\1\uffff\1\40\1\101\1\uffff\1\124\1\uffff\1\101\1\145\1\137\1\101"+
        "\1\uffff\1\120\2\106\1\132\2\uffff\1\125\1\uffff\1\144\1\117\1\uffff"+
        "\1\104\2\101\1\105\1\uffff\1\122\1\101\3\106\2\uffff\1\101\1\105"+
        "\1\uffff\1\137\2\101\1\uffff\1\101\1\105\3\uffff\1\114\1\105\1\115"+
        "\1\105\1\116\1\124\1\123\1\101\1\uffff";
    static final String DFA13_maxS =
        "\1\172\2\uffff\1\122\1\117\1\116\1\125\1\156\1\157\1\156\1\157\1"+
        "\156\1\172\1\141\1\162\1\124\1\131\1\101\3\uffff\1\57\6\uffff\1"+
        "\75\1\162\3\uffff\1\76\1\75\3\uffff\1\172\1\122\1\104\1\124\1\115"+
        "\1\164\1\116\2\165\1\157\1\124\1\151\1\172\1\uffff\1\154\1\165\1"+
        "\122\1\120\1\114\5\uffff\1\144\6\uffff\3\172\1\102\1\120\1\105\1"+
        "\142\1\155\1\154\1\105\1\164\1\172\1\163\1\145\1\125\1\105\1\125"+
        "\1\145\3\uffff\1\105\1\115\1\122\1\154\2\120\1\123\2\172\1\145\1"+
        "\172\1\103\1\172\1\105\1\162\1\122\1\106\1\172\1\145\2\115\1\111"+
        "\1\uffff\2\172\1\uffff\1\124\1\uffff\1\172\1\145\1\137\1\172\1\uffff"+
        "\1\120\2\106\1\132\2\uffff\1\125\1\uffff\1\144\1\117\1\uffff\1\115"+
        "\2\172\1\105\1\uffff\1\122\1\172\3\106\2\uffff\1\172\1\105\1\uffff"+
        "\1\137\2\172\1\uffff\1\172\1\105\3\uffff\1\114\1\105\1\115\1\105"+
        "\1\116\1\124\1\123\1\172\1\uffff";
    static final String DFA13_acceptS =
        "\1\uffff\1\1\1\2\17\uffff\1\26\1\27\1\30\1\uffff\1\32\1\33\1\34"+
        "\1\35\1\36\1\37\2\uffff\1\43\1\44\1\45\2\uffff\1\54\1\55\1\56\15"+
        "\uffff\1\53\5\uffff\1\57\1\60\1\31\1\42\1\40\1\uffff\1\46\1\52\1"+
        "\50\1\51\1\47\1\3\22\uffff\1\4\1\5\1\6\26\uffff\1\14\2\uffff\1\17"+
        "\1\uffff\1\23\4\uffff\1\25\4\uffff\1\15\1\16\1\uffff\1\24\2\uffff"+
        "\1\7\4\uffff\1\15\5\uffff\1\11\1\13\2\uffff\1\41\3\uffff\1\20\2"+
        "\uffff\1\10\1\12\1\21\10\uffff\1\22";
    static final String DFA13_specialS =
        "\u00a7\uffff}>";
    static final String[] DFA13_transitionS = {
            "\2\45\1\uffff\2\45\22\uffff\1\45\1\uffff\1\14\2\uffff\1\26\2"+
            "\uffff\1\30\1\31\1\24\1\22\1\33\1\23\1\43\1\25\12\40\1\2\1\32"+
            "\1\41\1\34\1\42\1\1\1\uffff\1\5\1\12\1\44\1\10\1\11\3\44\1\7"+
            "\4\44\1\6\1\3\3\44\1\17\1\20\1\44\1\21\1\44\1\4\2\44\1\36\1"+
            "\uffff\1\37\1\27\1\44\1\uffff\5\44\1\15\10\44\1\35\4\44\1\16"+
            "\1\13\5\44",
            "",
            "",
            "\1\46",
            "\1\47",
            "\1\50",
            "\1\51\5\uffff\1\52",
            "\1\54\37\uffff\1\53",
            "\1\55",
            "\1\56",
            "\1\60\25\uffff\1\57",
            "\1\61",
            "\1\63\17\uffff\12\63\7\uffff\32\63\4\uffff\1\63\1\uffff\1\63"+
            "\1\62\30\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "",
            "",
            "",
            "\1\71\4\uffff\1\72",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\74",
            "\1\76",
            "",
            "",
            "",
            "\1\100\1\77",
            "\1\102",
            "",
            "",
            "",
            "\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\63\1\uffff\1\63\15\uffff\12\63\7\uffff\32\63\4\uffff\1\63"+
            "\1\uffff\16\63\1\120\13\63",
            "",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
            "",
            "",
            "",
            "",
            "",
            "\1\126",
            "",
            "",
            "",
            "",
            "",
            "",
            "\32\44\4\uffff\1\44\1\uffff\32\44",
            "\32\44\4\uffff\1\44\1\uffff\32\44",
            "\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\63\1\uffff\1\63\15\uffff\12\63\7\uffff\32\63\4\uffff\1\63"+
            "\1\uffff\16\63\1\142\13\63",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "\1\150",
            "",
            "",
            "",
            "\1\151",
            "\1\152",
            "\1\153",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\63\1\uffff\1\63\15\uffff\12\63\7\uffff\32\63\4\uffff\1\63"+
            "\1\uffff\13\63\1\161\16\63",
            "\1\162",
            "\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\164",
            "\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\171",
            "\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\173",
            "\1\174",
            "\1\175",
            "\1\176",
            "",
            "\1\63\1\uffff\1\177\15\uffff\12\63\7\uffff\32\63\4\uffff\1"+
            "\63\1\uffff\32\63",
            "\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "\1\u0081",
            "",
            "\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u0083",
            "\1\u0084",
            "\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "",
            "",
            "\1\u008b",
            "",
            "\1\u008c",
            "\1\u008d",
            "",
            "\1\u008f\10\uffff\1\u008e",
            "\32\44\4\uffff\1\44\1\uffff\32\44",
            "\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u0092",
            "",
            "\1\u0093",
            "\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "",
            "",
            "\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u0099",
            "",
            "\1\u009a",
            "\32\44\4\uffff\1\44\1\uffff\32\44",
            "\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u009e",
            "",
            "",
            "",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "\32\44\4\uffff\1\44\1\uffff\32\44",
            ""
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__53 | T__54 | OR | XOR | AND | NOT | INTPMF | DOUBLEPMF | ENUMPMF | DOUBLEPDF | BOOLPMF | UNIT | BOOL | FALSE | TRUE | BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE | INNER | PLUS | MINUS | MUL | DIV | MOD | POW | LPAREN | RPAREN | SEMI | COLON | DEFINITION | ORDERED_DEF | EQUAL | SQUARE_PAREN_L | SQUARE_PAREN_R | NUMBER | NOTEQUAL | GREATER | LESS | GREATEREQUAL | LESSEQUAL | STRING_LITERAL | DOT | ID | WS | COMMENT | LINE_COMMENT );";
        }
    }
 

}
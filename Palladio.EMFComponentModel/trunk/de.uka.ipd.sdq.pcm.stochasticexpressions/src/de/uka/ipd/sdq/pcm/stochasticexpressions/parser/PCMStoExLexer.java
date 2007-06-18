package de.uka.ipd.sdq.pcm.stochasticexpressions.parser;

// $ANTLR 3.0 C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g 2007-06-15 09:32:20

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class PCMStoExLexer extends Lexer {
    public static final int INNER=46;
    public static final int MOD=17;
    public static final int BOOLPMF=35;
    public static final int ENUMPMF=31;
    public static final int GREATEREQUAL=11;
    public static final int Exponent=48;
    public static final int NOT=19;
    public static final int ID=23;
    public static final int AND=4;
    public static final int EOF=-1;
    public static final int STRUCTURE=42;
    public static final int LPAREN=24;
    public static final int TYPE=44;
    public static final int NOTEQUAL=10;
    public static final int RPAREN=25;
    public static final int STRING_LITERAL=21;
    public static final int GREATER=7;
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
    public static final int Tokens=55;
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
    public static final int T54=54;
    public static final int LESSEQUAL=12;
    public static final int T53=53;
    public PCMStoExLexer() {;} 
    public PCMStoExLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g"; }

    // $ANTLR start T53
    public final void mT53() throws RecognitionException {
        try {
            int _type = T53;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:3:7: ( '?' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:3:7: '?'
            {
            match('?'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T53

    // $ANTLR start T54
    public final void mT54() throws RecognitionException {
        try {
            int _type = T54;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:4:7: ( ':' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:4:7: ':'
            {
            match(':'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T54

    // $ANTLR start OR
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:418:4: ( 'OR' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:418:4: 'OR'
            {
            match("OR"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end OR

    // $ANTLR start XOR
    public final void mXOR() throws RecognitionException {
        try {
            int _type = XOR;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:422:4: ( 'XOR' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:422:4: 'XOR'
            {
            match("XOR"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end XOR

    // $ANTLR start AND
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:426:4: ( 'AND' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:426:4: 'AND'
            {
            match("AND"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end AND

    // $ANTLR start NOT
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:430:4: ( 'NOT' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:430:4: 'NOT'
            {
            match("NOT"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NOT

    // $ANTLR start INTPMF
    public final void mINTPMF() throws RecognitionException {
        try {
            int _type = INTPMF;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:434:4: ( 'IntPMF' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:434:4: 'IntPMF'
            {
            match("IntPMF"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end INTPMF

    // $ANTLR start DOUBLEPMF
    public final void mDOUBLEPMF() throws RecognitionException {
        try {
            int _type = DOUBLEPMF;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:438:4: ( 'DoublePMF' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:438:4: 'DoublePMF'
            {
            match("DoublePMF"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DOUBLEPMF

    // $ANTLR start ENUMPMF
    public final void mENUMPMF() throws RecognitionException {
        try {
            int _type = ENUMPMF;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:442:4: ( 'EnumPMF' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:442:4: 'EnumPMF'
            {
            match("EnumPMF"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ENUMPMF

    // $ANTLR start DOUBLEPDF
    public final void mDOUBLEPDF() throws RecognitionException {
        try {
            int _type = DOUBLEPDF;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:446:4: ( 'DoublePDF' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:446:4: 'DoublePDF'
            {
            match("DoublePDF"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DOUBLEPDF

    // $ANTLR start BOOLPMF
    public final void mBOOLPMF() throws RecognitionException {
        try {
            int _type = BOOLPMF;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:450:4: ( 'BoolPMF' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:450:4: 'BoolPMF'
            {
            match("BoolPMF"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end BOOLPMF

    // $ANTLR start UNIT
    public final void mUNIT() throws RecognitionException {
        try {
            int _type = UNIT;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:454:4: ( 'unit' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:454:4: 'unit'
            {
            match("unit"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end UNIT

    // $ANTLR start BOOL
    public final void mBOOL() throws RecognitionException {
        try {
            int _type = BOOL;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:458:4: ( '\"bool\"' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:458:4: '\"bool\"'
            {
            match("\"bool\""); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end BOOL

    // $ANTLR start FALSE
    public final void mFALSE() throws RecognitionException {
        try {
            int _type = FALSE;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:462:4: ( 'false' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:462:4: 'false'
            {
            match("false"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end FALSE

    // $ANTLR start TRUE
    public final void mTRUE() throws RecognitionException {
        try {
            int _type = TRUE;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:466:4: ( 'true' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:466:4: 'true'
            {
            match("true"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TRUE

    // $ANTLR start BYTESIZE
    public final void mBYTESIZE() throws RecognitionException {
        try {
            int _type = BYTESIZE;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:470:4: ( 'BYTESIZE' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:470:4: 'BYTESIZE'
            {
            match("BYTESIZE"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end BYTESIZE

    // $ANTLR start STRUCTURE
    public final void mSTRUCTURE() throws RecognitionException {
        try {
            int _type = STRUCTURE;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:474:4: ( 'STRUCTURE' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:474:4: 'STRUCTURE'
            {
            match("STRUCTURE"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end STRUCTURE

    // $ANTLR start NUMBER_OF_ELEMENTS
    public final void mNUMBER_OF_ELEMENTS() throws RecognitionException {
        try {
            int _type = NUMBER_OF_ELEMENTS;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:478:4: ( 'NUMBER_OF_ELEMENTS' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:478:4: 'NUMBER_OF_ELEMENTS'
            {
            match("NUMBER_OF_ELEMENTS"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NUMBER_OF_ELEMENTS

    // $ANTLR start TYPE
    public final void mTYPE() throws RecognitionException {
        try {
            int _type = TYPE;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:482:4: ( 'TYPE' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:482:4: 'TYPE'
            {
            match("TYPE"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TYPE

    // $ANTLR start VALUE
    public final void mVALUE() throws RecognitionException {
        try {
            int _type = VALUE;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:486:4: ( 'VALUE' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:486:4: 'VALUE'
            {
            match("VALUE"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end VALUE

    // $ANTLR start INNER
    public final void mINNER() throws RecognitionException {
        try {
            int _type = INNER;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:490:4: ( 'INNER' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:490:4: 'INNER'
            {
            match("INNER"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end INNER

    // $ANTLR start PLUS
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:493:9: ( '+' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:493:9: '+'
            {
            match('+'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end PLUS

    // $ANTLR start MINUS
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:494:9: ( '-' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:494:9: '-'
            {
            match('-'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end MINUS

    // $ANTLR start MUL
    public final void mMUL() throws RecognitionException {
        try {
            int _type = MUL;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:495:9: ( '*' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:495:9: '*'
            {
            match('*'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end MUL

    // $ANTLR start DIV
    public final void mDIV() throws RecognitionException {
        try {
            int _type = DIV;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:496:9: ( '/' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:496:9: '/'
            {
            match('/'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DIV

    // $ANTLR start MOD
    public final void mMOD() throws RecognitionException {
        try {
            int _type = MOD;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:497:9: ( '%' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:497:9: '%'
            {
            match('%'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end MOD

    // $ANTLR start POW
    public final void mPOW() throws RecognitionException {
        try {
            int _type = POW;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:498:9: ( '^' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:498:9: '^'
            {
            match('^'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end POW

    // $ANTLR start LPAREN
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:499:9: ( '(' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:499:9: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LPAREN

    // $ANTLR start RPAREN
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:500:9: ( ')' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:500:9: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RPAREN

    // $ANTLR start SEMI
    public final void mSEMI() throws RecognitionException {
        try {
            int _type = SEMI;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:501:9: ( ';' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:501:9: ';'
            {
            match(';'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SEMI

    // $ANTLR start COLON
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:502:10: ( ',' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:502:10: ','
            {
            match(','); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end COLON

    // $ANTLR start DEFINITION
    public final void mDEFINITION() throws RecognitionException {
        try {
            int _type = DEFINITION;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:503:14: ( '=' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:503:14: '='
            {
            match('='); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DEFINITION

    // $ANTLR start ORDERED_DEF
    public final void mORDERED_DEF() throws RecognitionException {
        try {
            int _type = ORDERED_DEF;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:505:4: ( 'ordered' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:505:4: 'ordered'
            {
            match("ordered"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ORDERED_DEF

    // $ANTLR start EQUAL
    public final void mEQUAL() throws RecognitionException {
        try {
            int _type = EQUAL;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:506:9: ( '==' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:506:9: '=='
            {
            match("=="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end EQUAL

    // $ANTLR start SQUARE_PAREN_L
    public final void mSQUARE_PAREN_L() throws RecognitionException {
        try {
            int _type = SQUARE_PAREN_L;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:507:18: ( '[' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:507:18: '['
            {
            match('['); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SQUARE_PAREN_L

    // $ANTLR start SQUARE_PAREN_R
    public final void mSQUARE_PAREN_R() throws RecognitionException {
        try {
            int _type = SQUARE_PAREN_R;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:508:18: ( ']' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:508:18: ']'
            {
            match(']'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SQUARE_PAREN_R

    // $ANTLR start DIGIT
    public final void mDIGIT() throws RecognitionException {
        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:509:18: ( '0' .. '9' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:509:18: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end DIGIT

    // $ANTLR start NUMBER
    public final void mNUMBER() throws RecognitionException {
        try {
            int _type = NUMBER;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:510:10: ( ( DIGIT )+ ( '.' ( DIGIT )+ )? ( Exponent )? )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:510:10: ( DIGIT )+ ( '.' ( DIGIT )+ )? ( Exponent )?
            {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:510:10: ( DIGIT )+
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
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:510:11: DIGIT
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

            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:510:19: ( '.' ( DIGIT )+ )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='.') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:510:20: '.' ( DIGIT )+
                    {
                    match('.'); 
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:510:24: ( DIGIT )+
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
                    	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:510:25: DIGIT
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

            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:510:35: ( Exponent )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='E'||LA4_0=='e') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:510:35: Exponent
                    {
                    mExponent(); 

                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NUMBER

    // $ANTLR start Exponent
    public final void mExponent() throws RecognitionException {
        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:512:12: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:512:12: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:512:22: ( '+' | '-' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='+'||LA5_0=='-') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }


                    }
                    break;

            }

            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:512:33: ( '0' .. '9' )+
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
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:512:34: '0' .. '9'
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
    // $ANTLR end Exponent

    // $ANTLR start ALPHA
    public final void mALPHA() throws RecognitionException {
        try {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:513:18: ( 'a' .. 'z' | 'A' .. 'Z' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

        }
        finally {
        }
    }
    // $ANTLR end ALPHA

    // $ANTLR start NOTEQUAL
    public final void mNOTEQUAL() throws RecognitionException {
        try {
            int _type = NOTEQUAL;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:514:12: ( '<>' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:514:12: '<>'
            {
            match("<>"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NOTEQUAL

    // $ANTLR start GREATER
    public final void mGREATER() throws RecognitionException {
        try {
            int _type = GREATER;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:515:11: ( '>' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:515:11: '>'
            {
            match('>'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end GREATER

    // $ANTLR start LESS
    public final void mLESS() throws RecognitionException {
        try {
            int _type = LESS;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:516:8: ( '<' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:516:8: '<'
            {
            match('<'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LESS

    // $ANTLR start GREATEREQUAL
    public final void mGREATEREQUAL() throws RecognitionException {
        try {
            int _type = GREATEREQUAL;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:517:16: ( '>=' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:517:16: '>='
            {
            match(">="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end GREATEREQUAL

    // $ANTLR start LESSEQUAL
    public final void mLESSEQUAL() throws RecognitionException {
        try {
            int _type = LESSEQUAL;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:518:13: ( '<=' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:518:13: '<='
            {
            match("<="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LESSEQUAL

    // $ANTLR start STRING_LITERAL
    public final void mSTRING_LITERAL() throws RecognitionException {
        try {
            int _type = STRING_LITERAL;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:519:18: ( '\\\"' ( ALPHA | '_' )+ '\\\"' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:519:18: '\\\"' ( ALPHA | '_' )+ '\\\"'
            {
            match('\"'); 
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:519:23: ( ALPHA | '_' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='A' && LA7_0<='Z')||LA7_0=='_'||(LA7_0>='a' && LA7_0<='z')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:
            	    {
            	    if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


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

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end STRING_LITERAL

    // $ANTLR start DOT
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:520:6: ( '.' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:520:6: '.'
            {
            match('.'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DOT

    // $ANTLR start ID
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:521:4: ( ( ALPHA | '_' )+ )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:521:4: ( ALPHA | '_' )+
            {
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:521:4: ( ALPHA | '_' )+
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
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:
            	    {
            	    if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


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

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ID

    // $ANTLR start WS
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:524:8: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:524:8: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
            {
            if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||(input.LA(1)>='\f' && input.LA(1)<='\r')||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            channel=HIDDEN;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WS

    // $ANTLR start COMMENT
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:528:9: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:528:9: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:528:14: ( options {greedy=false; } : . )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='*') ) {
                    int LA9_1 = input.LA(2);

                    if ( (LA9_1=='/') ) {
                        alt9=2;
                    }
                    else if ( ((LA9_1>='\u0000' && LA9_1<='.')||(LA9_1>='0' && LA9_1<='\uFFFE')) ) {
                        alt9=1;
                    }


                }
                else if ( ((LA9_0>='\u0000' && LA9_0<=')')||(LA9_0>='+' && LA9_0<='\uFFFE')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:528:42: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            match("*/"); 

            channel=HIDDEN;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end COMMENT

    // $ANTLR start LINE_COMMENT
    public final void mLINE_COMMENT() throws RecognitionException {
        try {
            int _type = LINE_COMMENT;
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:532:7: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:532:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 

            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:532:12: (~ ( '\\n' | '\\r' ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\u0000' && LA10_0<='\t')||(LA10_0>='\u000B' && LA10_0<='\f')||(LA10_0>='\u000E' && LA10_0<='\uFFFE')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:532:12: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:532:26: ( '\\r' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\r') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:532:26: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 
            channel=HIDDEN;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LINE_COMMENT

    public void mTokens() throws RecognitionException {
        // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:10: ( T53 | T54 | OR | XOR | AND | NOT | INTPMF | DOUBLEPMF | ENUMPMF | DOUBLEPDF | BOOLPMF | UNIT | BOOL | FALSE | TRUE | BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE | INNER | PLUS | MINUS | MUL | DIV | MOD | POW | LPAREN | RPAREN | SEMI | COLON | DEFINITION | ORDERED_DEF | EQUAL | SQUARE_PAREN_L | SQUARE_PAREN_R | NUMBER | NOTEQUAL | GREATER | LESS | GREATEREQUAL | LESSEQUAL | STRING_LITERAL | DOT | ID | WS | COMMENT | LINE_COMMENT )
        int alt12=48;
        switch ( input.LA(1) ) {
        case '?':
            {
            alt12=1;
            }
            break;
        case ':':
            {
            alt12=2;
            }
            break;
        case 'O':
            {
            int LA12_3 = input.LA(2);

            if ( (LA12_3=='R') ) {
                int LA12_38 = input.LA(3);

                if ( ((LA12_38>='A' && LA12_38<='Z')||LA12_38=='_'||(LA12_38>='a' && LA12_38<='z')) ) {
                    alt12=45;
                }
                else {
                    alt12=3;}
            }
            else {
                alt12=45;}
            }
            break;
        case 'X':
            {
            int LA12_4 = input.LA(2);

            if ( (LA12_4=='O') ) {
                int LA12_39 = input.LA(3);

                if ( (LA12_39=='R') ) {
                    int LA12_69 = input.LA(4);

                    if ( ((LA12_69>='A' && LA12_69<='Z')||LA12_69=='_'||(LA12_69>='a' && LA12_69<='z')) ) {
                        alt12=45;
                    }
                    else {
                        alt12=4;}
                }
                else {
                    alt12=45;}
            }
            else {
                alt12=45;}
            }
            break;
        case 'A':
            {
            int LA12_5 = input.LA(2);

            if ( (LA12_5=='N') ) {
                int LA12_40 = input.LA(3);

                if ( (LA12_40=='D') ) {
                    int LA12_70 = input.LA(4);

                    if ( ((LA12_70>='A' && LA12_70<='Z')||LA12_70=='_'||(LA12_70>='a' && LA12_70<='z')) ) {
                        alt12=45;
                    }
                    else {
                        alt12=5;}
                }
                else {
                    alt12=45;}
            }
            else {
                alt12=45;}
            }
            break;
        case 'N':
            {
            switch ( input.LA(2) ) {
            case 'O':
                {
                int LA12_41 = input.LA(3);

                if ( (LA12_41=='T') ) {
                    int LA12_71 = input.LA(4);

                    if ( ((LA12_71>='A' && LA12_71<='Z')||LA12_71=='_'||(LA12_71>='a' && LA12_71<='z')) ) {
                        alt12=45;
                    }
                    else {
                        alt12=6;}
                }
                else {
                    alt12=45;}
                }
                break;
            case 'U':
                {
                int LA12_42 = input.LA(3);

                if ( (LA12_42=='M') ) {
                    int LA12_72 = input.LA(4);

                    if ( (LA12_72=='B') ) {
                        int LA12_90 = input.LA(5);

                        if ( (LA12_90=='E') ) {
                            int LA12_105 = input.LA(6);

                            if ( (LA12_105=='R') ) {
                                int LA12_120 = input.LA(7);

                                if ( (LA12_120=='_') ) {
                                    int LA12_132 = input.LA(8);

                                    if ( (LA12_132=='O') ) {
                                        int LA12_141 = input.LA(9);

                                        if ( (LA12_141=='F') ) {
                                            int LA12_149 = input.LA(10);

                                            if ( (LA12_149=='_') ) {
                                                int LA12_154 = input.LA(11);

                                                if ( (LA12_154=='E') ) {
                                                    int LA12_158 = input.LA(12);

                                                    if ( (LA12_158=='L') ) {
                                                        int LA12_159 = input.LA(13);

                                                        if ( (LA12_159=='E') ) {
                                                            int LA12_160 = input.LA(14);

                                                            if ( (LA12_160=='M') ) {
                                                                int LA12_161 = input.LA(15);

                                                                if ( (LA12_161=='E') ) {
                                                                    int LA12_162 = input.LA(16);

                                                                    if ( (LA12_162=='N') ) {
                                                                        int LA12_163 = input.LA(17);

                                                                        if ( (LA12_163=='T') ) {
                                                                            int LA12_164 = input.LA(18);

                                                                            if ( (LA12_164=='S') ) {
                                                                                int LA12_165 = input.LA(19);

                                                                                if ( ((LA12_165>='A' && LA12_165<='Z')||LA12_165=='_'||(LA12_165>='a' && LA12_165<='z')) ) {
                                                                                    alt12=45;
                                                                                }
                                                                                else {
                                                                                    alt12=18;}
                                                                            }
                                                                            else {
                                                                                alt12=45;}
                                                                        }
                                                                        else {
                                                                            alt12=45;}
                                                                    }
                                                                    else {
                                                                        alt12=45;}
                                                                }
                                                                else {
                                                                    alt12=45;}
                                                            }
                                                            else {
                                                                alt12=45;}
                                                        }
                                                        else {
                                                            alt12=45;}
                                                    }
                                                    else {
                                                        alt12=45;}
                                                }
                                                else {
                                                    alt12=45;}
                                            }
                                            else {
                                                alt12=45;}
                                        }
                                        else {
                                            alt12=45;}
                                    }
                                    else {
                                        alt12=45;}
                                }
                                else {
                                    alt12=45;}
                            }
                            else {
                                alt12=45;}
                        }
                        else {
                            alt12=45;}
                    }
                    else {
                        alt12=45;}
                }
                else {
                    alt12=45;}
                }
                break;
            default:
                alt12=45;}

            }
            break;
        case 'I':
            {
            switch ( input.LA(2) ) {
            case 'n':
                {
                int LA12_43 = input.LA(3);

                if ( (LA12_43=='t') ) {
                    int LA12_73 = input.LA(4);

                    if ( (LA12_73=='P') ) {
                        int LA12_91 = input.LA(5);

                        if ( (LA12_91=='M') ) {
                            int LA12_106 = input.LA(6);

                            if ( (LA12_106=='F') ) {
                                int LA12_121 = input.LA(7);

                                if ( ((LA12_121>='A' && LA12_121<='Z')||LA12_121=='_'||(LA12_121>='a' && LA12_121<='z')) ) {
                                    alt12=45;
                                }
                                else {
                                    alt12=7;}
                            }
                            else {
                                alt12=45;}
                        }
                        else {
                            alt12=45;}
                    }
                    else {
                        alt12=45;}
                }
                else {
                    alt12=45;}
                }
                break;
            case 'N':
                {
                int LA12_44 = input.LA(3);

                if ( (LA12_44=='N') ) {
                    int LA12_74 = input.LA(4);

                    if ( (LA12_74=='E') ) {
                        int LA12_92 = input.LA(5);

                        if ( (LA12_92=='R') ) {
                            int LA12_107 = input.LA(6);

                            if ( ((LA12_107>='A' && LA12_107<='Z')||LA12_107=='_'||(LA12_107>='a' && LA12_107<='z')) ) {
                                alt12=45;
                            }
                            else {
                                alt12=21;}
                        }
                        else {
                            alt12=45;}
                    }
                    else {
                        alt12=45;}
                }
                else {
                    alt12=45;}
                }
                break;
            default:
                alt12=45;}

            }
            break;
        case 'D':
            {
            int LA12_8 = input.LA(2);

            if ( (LA12_8=='o') ) {
                int LA12_45 = input.LA(3);

                if ( (LA12_45=='u') ) {
                    int LA12_75 = input.LA(4);

                    if ( (LA12_75=='b') ) {
                        int LA12_93 = input.LA(5);

                        if ( (LA12_93=='l') ) {
                            int LA12_108 = input.LA(6);

                            if ( (LA12_108=='e') ) {
                                int LA12_123 = input.LA(7);

                                if ( (LA12_123=='P') ) {
                                    switch ( input.LA(8) ) {
                                    case 'M':
                                        {
                                        int LA12_142 = input.LA(9);

                                        if ( (LA12_142=='F') ) {
                                            int LA12_150 = input.LA(10);

                                            if ( ((LA12_150>='A' && LA12_150<='Z')||LA12_150=='_'||(LA12_150>='a' && LA12_150<='z')) ) {
                                                alt12=45;
                                            }
                                            else {
                                                alt12=8;}
                                        }
                                        else {
                                            alt12=45;}
                                        }
                                        break;
                                    case 'D':
                                        {
                                        int LA12_143 = input.LA(9);

                                        if ( (LA12_143=='F') ) {
                                            int LA12_151 = input.LA(10);

                                            if ( ((LA12_151>='A' && LA12_151<='Z')||LA12_151=='_'||(LA12_151>='a' && LA12_151<='z')) ) {
                                                alt12=45;
                                            }
                                            else {
                                                alt12=10;}
                                        }
                                        else {
                                            alt12=45;}
                                        }
                                        break;
                                    default:
                                        alt12=45;}

                                }
                                else {
                                    alt12=45;}
                            }
                            else {
                                alt12=45;}
                        }
                        else {
                            alt12=45;}
                    }
                    else {
                        alt12=45;}
                }
                else {
                    alt12=45;}
            }
            else {
                alt12=45;}
            }
            break;
        case 'E':
            {
            int LA12_9 = input.LA(2);

            if ( (LA12_9=='n') ) {
                int LA12_46 = input.LA(3);

                if ( (LA12_46=='u') ) {
                    int LA12_76 = input.LA(4);

                    if ( (LA12_76=='m') ) {
                        int LA12_94 = input.LA(5);

                        if ( (LA12_94=='P') ) {
                            int LA12_109 = input.LA(6);

                            if ( (LA12_109=='M') ) {
                                int LA12_124 = input.LA(7);

                                if ( (LA12_124=='F') ) {
                                    int LA12_135 = input.LA(8);

                                    if ( ((LA12_135>='A' && LA12_135<='Z')||LA12_135=='_'||(LA12_135>='a' && LA12_135<='z')) ) {
                                        alt12=45;
                                    }
                                    else {
                                        alt12=9;}
                                }
                                else {
                                    alt12=45;}
                            }
                            else {
                                alt12=45;}
                        }
                        else {
                            alt12=45;}
                    }
                    else {
                        alt12=45;}
                }
                else {
                    alt12=45;}
            }
            else {
                alt12=45;}
            }
            break;
        case 'B':
            {
            switch ( input.LA(2) ) {
            case 'o':
                {
                int LA12_47 = input.LA(3);

                if ( (LA12_47=='o') ) {
                    int LA12_77 = input.LA(4);

                    if ( (LA12_77=='l') ) {
                        int LA12_95 = input.LA(5);

                        if ( (LA12_95=='P') ) {
                            int LA12_110 = input.LA(6);

                            if ( (LA12_110=='M') ) {
                                int LA12_125 = input.LA(7);

                                if ( (LA12_125=='F') ) {
                                    int LA12_136 = input.LA(8);

                                    if ( ((LA12_136>='A' && LA12_136<='Z')||LA12_136=='_'||(LA12_136>='a' && LA12_136<='z')) ) {
                                        alt12=45;
                                    }
                                    else {
                                        alt12=11;}
                                }
                                else {
                                    alt12=45;}
                            }
                            else {
                                alt12=45;}
                        }
                        else {
                            alt12=45;}
                    }
                    else {
                        alt12=45;}
                }
                else {
                    alt12=45;}
                }
                break;
            case 'Y':
                {
                int LA12_48 = input.LA(3);

                if ( (LA12_48=='T') ) {
                    int LA12_78 = input.LA(4);

                    if ( (LA12_78=='E') ) {
                        int LA12_96 = input.LA(5);

                        if ( (LA12_96=='S') ) {
                            int LA12_111 = input.LA(6);

                            if ( (LA12_111=='I') ) {
                                int LA12_126 = input.LA(7);

                                if ( (LA12_126=='Z') ) {
                                    int LA12_137 = input.LA(8);

                                    if ( (LA12_137=='E') ) {
                                        int LA12_146 = input.LA(9);

                                        if ( ((LA12_146>='A' && LA12_146<='Z')||LA12_146=='_'||(LA12_146>='a' && LA12_146<='z')) ) {
                                            alt12=45;
                                        }
                                        else {
                                            alt12=16;}
                                    }
                                    else {
                                        alt12=45;}
                                }
                                else {
                                    alt12=45;}
                            }
                            else {
                                alt12=45;}
                        }
                        else {
                            alt12=45;}
                    }
                    else {
                        alt12=45;}
                }
                else {
                    alt12=45;}
                }
                break;
            default:
                alt12=45;}

            }
            break;
        case 'u':
            {
            int LA12_11 = input.LA(2);

            if ( (LA12_11=='n') ) {
                int LA12_49 = input.LA(3);

                if ( (LA12_49=='i') ) {
                    int LA12_79 = input.LA(4);

                    if ( (LA12_79=='t') ) {
                        int LA12_97 = input.LA(5);

                        if ( ((LA12_97>='A' && LA12_97<='Z')||LA12_97=='_'||(LA12_97>='a' && LA12_97<='z')) ) {
                            alt12=45;
                        }
                        else {
                            alt12=12;}
                    }
                    else {
                        alt12=45;}
                }
                else {
                    alt12=45;}
            }
            else {
                alt12=45;}
            }
            break;
        case '\"':
            {
            int LA12_12 = input.LA(2);

            if ( (LA12_12=='b') ) {
                int LA12_50 = input.LA(3);

                if ( (LA12_50=='o') ) {
                    int LA12_80 = input.LA(4);

                    if ( (LA12_80=='o') ) {
                        int LA12_98 = input.LA(5);

                        if ( (LA12_98=='l') ) {
                            int LA12_113 = input.LA(6);

                            if ( (LA12_113=='\"') ) {
                                alt12=13;
                            }
                            else if ( ((LA12_113>='A' && LA12_113<='Z')||LA12_113=='_'||(LA12_113>='a' && LA12_113<='z')) ) {
                                alt12=43;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1:1: Tokens : ( T53 | T54 | OR | XOR | AND | NOT | INTPMF | DOUBLEPMF | ENUMPMF | DOUBLEPDF | BOOLPMF | UNIT | BOOL | FALSE | TRUE | BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE | INNER | PLUS | MINUS | MUL | DIV | MOD | POW | LPAREN | RPAREN | SEMI | COLON | DEFINITION | ORDERED_DEF | EQUAL | SQUARE_PAREN_L | SQUARE_PAREN_R | NUMBER | NOTEQUAL | GREATER | LESS | GREATEREQUAL | LESSEQUAL | STRING_LITERAL | DOT | ID | WS | COMMENT | LINE_COMMENT );", 12, 113, input);

                                throw nvae;
                            }
                        }
                        else if ( (LA12_98=='\"'||(LA12_98>='A' && LA12_98<='Z')||LA12_98=='_'||(LA12_98>='a' && LA12_98<='k')||(LA12_98>='m' && LA12_98<='z')) ) {
                            alt12=43;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("1:1: Tokens : ( T53 | T54 | OR | XOR | AND | NOT | INTPMF | DOUBLEPMF | ENUMPMF | DOUBLEPDF | BOOLPMF | UNIT | BOOL | FALSE | TRUE | BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE | INNER | PLUS | MINUS | MUL | DIV | MOD | POW | LPAREN | RPAREN | SEMI | COLON | DEFINITION | ORDERED_DEF | EQUAL | SQUARE_PAREN_L | SQUARE_PAREN_R | NUMBER | NOTEQUAL | GREATER | LESS | GREATEREQUAL | LESSEQUAL | STRING_LITERAL | DOT | ID | WS | COMMENT | LINE_COMMENT );", 12, 98, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA12_80=='\"'||(LA12_80>='A' && LA12_80<='Z')||LA12_80=='_'||(LA12_80>='a' && LA12_80<='n')||(LA12_80>='p' && LA12_80<='z')) ) {
                        alt12=43;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1:1: Tokens : ( T53 | T54 | OR | XOR | AND | NOT | INTPMF | DOUBLEPMF | ENUMPMF | DOUBLEPDF | BOOLPMF | UNIT | BOOL | FALSE | TRUE | BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE | INNER | PLUS | MINUS | MUL | DIV | MOD | POW | LPAREN | RPAREN | SEMI | COLON | DEFINITION | ORDERED_DEF | EQUAL | SQUARE_PAREN_L | SQUARE_PAREN_R | NUMBER | NOTEQUAL | GREATER | LESS | GREATEREQUAL | LESSEQUAL | STRING_LITERAL | DOT | ID | WS | COMMENT | LINE_COMMENT );", 12, 80, input);

                        throw nvae;
                    }
                }
                else if ( (LA12_50=='\"'||(LA12_50>='A' && LA12_50<='Z')||LA12_50=='_'||(LA12_50>='a' && LA12_50<='n')||(LA12_50>='p' && LA12_50<='z')) ) {
                    alt12=43;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1:1: Tokens : ( T53 | T54 | OR | XOR | AND | NOT | INTPMF | DOUBLEPMF | ENUMPMF | DOUBLEPDF | BOOLPMF | UNIT | BOOL | FALSE | TRUE | BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE | INNER | PLUS | MINUS | MUL | DIV | MOD | POW | LPAREN | RPAREN | SEMI | COLON | DEFINITION | ORDERED_DEF | EQUAL | SQUARE_PAREN_L | SQUARE_PAREN_R | NUMBER | NOTEQUAL | GREATER | LESS | GREATEREQUAL | LESSEQUAL | STRING_LITERAL | DOT | ID | WS | COMMENT | LINE_COMMENT );", 12, 50, input);

                    throw nvae;
                }
            }
            else if ( ((LA12_12>='A' && LA12_12<='Z')||LA12_12=='_'||LA12_12=='a'||(LA12_12>='c' && LA12_12<='z')) ) {
                alt12=43;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1:1: Tokens : ( T53 | T54 | OR | XOR | AND | NOT | INTPMF | DOUBLEPMF | ENUMPMF | DOUBLEPDF | BOOLPMF | UNIT | BOOL | FALSE | TRUE | BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE | INNER | PLUS | MINUS | MUL | DIV | MOD | POW | LPAREN | RPAREN | SEMI | COLON | DEFINITION | ORDERED_DEF | EQUAL | SQUARE_PAREN_L | SQUARE_PAREN_R | NUMBER | NOTEQUAL | GREATER | LESS | GREATEREQUAL | LESSEQUAL | STRING_LITERAL | DOT | ID | WS | COMMENT | LINE_COMMENT );", 12, 12, input);

                throw nvae;
            }
            }
            break;
        case 'f':
            {
            int LA12_13 = input.LA(2);

            if ( (LA12_13=='a') ) {
                int LA12_52 = input.LA(3);

                if ( (LA12_52=='l') ) {
                    int LA12_81 = input.LA(4);

                    if ( (LA12_81=='s') ) {
                        int LA12_99 = input.LA(5);

                        if ( (LA12_99=='e') ) {
                            int LA12_114 = input.LA(6);

                            if ( ((LA12_114>='A' && LA12_114<='Z')||LA12_114=='_'||(LA12_114>='a' && LA12_114<='z')) ) {
                                alt12=45;
                            }
                            else {
                                alt12=14;}
                        }
                        else {
                            alt12=45;}
                    }
                    else {
                        alt12=45;}
                }
                else {
                    alt12=45;}
            }
            else {
                alt12=45;}
            }
            break;
        case 't':
            {
            int LA12_14 = input.LA(2);

            if ( (LA12_14=='r') ) {
                int LA12_53 = input.LA(3);

                if ( (LA12_53=='u') ) {
                    int LA12_82 = input.LA(4);

                    if ( (LA12_82=='e') ) {
                        int LA12_100 = input.LA(5);

                        if ( ((LA12_100>='A' && LA12_100<='Z')||LA12_100=='_'||(LA12_100>='a' && LA12_100<='z')) ) {
                            alt12=45;
                        }
                        else {
                            alt12=15;}
                    }
                    else {
                        alt12=45;}
                }
                else {
                    alt12=45;}
            }
            else {
                alt12=45;}
            }
            break;
        case 'S':
            {
            int LA12_15 = input.LA(2);

            if ( (LA12_15=='T') ) {
                int LA12_54 = input.LA(3);

                if ( (LA12_54=='R') ) {
                    int LA12_83 = input.LA(4);

                    if ( (LA12_83=='U') ) {
                        int LA12_101 = input.LA(5);

                        if ( (LA12_101=='C') ) {
                            int LA12_116 = input.LA(6);

                            if ( (LA12_116=='T') ) {
                                int LA12_129 = input.LA(7);

                                if ( (LA12_129=='U') ) {
                                    int LA12_139 = input.LA(8);

                                    if ( (LA12_139=='R') ) {
                                        int LA12_147 = input.LA(9);

                                        if ( (LA12_147=='E') ) {
                                            int LA12_153 = input.LA(10);

                                            if ( ((LA12_153>='A' && LA12_153<='Z')||LA12_153=='_'||(LA12_153>='a' && LA12_153<='z')) ) {
                                                alt12=45;
                                            }
                                            else {
                                                alt12=17;}
                                        }
                                        else {
                                            alt12=45;}
                                    }
                                    else {
                                        alt12=45;}
                                }
                                else {
                                    alt12=45;}
                            }
                            else {
                                alt12=45;}
                        }
                        else {
                            alt12=45;}
                    }
                    else {
                        alt12=45;}
                }
                else {
                    alt12=45;}
            }
            else {
                alt12=45;}
            }
            break;
        case 'T':
            {
            int LA12_16 = input.LA(2);

            if ( (LA12_16=='Y') ) {
                int LA12_55 = input.LA(3);

                if ( (LA12_55=='P') ) {
                    int LA12_84 = input.LA(4);

                    if ( (LA12_84=='E') ) {
                        int LA12_102 = input.LA(5);

                        if ( ((LA12_102>='A' && LA12_102<='Z')||LA12_102=='_'||(LA12_102>='a' && LA12_102<='z')) ) {
                            alt12=45;
                        }
                        else {
                            alt12=19;}
                    }
                    else {
                        alt12=45;}
                }
                else {
                    alt12=45;}
            }
            else {
                alt12=45;}
            }
            break;
        case 'V':
            {
            int LA12_17 = input.LA(2);

            if ( (LA12_17=='A') ) {
                int LA12_56 = input.LA(3);

                if ( (LA12_56=='L') ) {
                    int LA12_85 = input.LA(4);

                    if ( (LA12_85=='U') ) {
                        int LA12_103 = input.LA(5);

                        if ( (LA12_103=='E') ) {
                            int LA12_118 = input.LA(6);

                            if ( ((LA12_118>='A' && LA12_118<='Z')||LA12_118=='_'||(LA12_118>='a' && LA12_118<='z')) ) {
                                alt12=45;
                            }
                            else {
                                alt12=20;}
                        }
                        else {
                            alt12=45;}
                    }
                    else {
                        alt12=45;}
                }
                else {
                    alt12=45;}
            }
            else {
                alt12=45;}
            }
            break;
        case '+':
            {
            alt12=22;
            }
            break;
        case '-':
            {
            alt12=23;
            }
            break;
        case '*':
            {
            alt12=24;
            }
            break;
        case '/':
            {
            switch ( input.LA(2) ) {
            case '/':
                {
                alt12=48;
                }
                break;
            case '*':
                {
                alt12=47;
                }
                break;
            default:
                alt12=25;}

            }
            break;
        case '%':
            {
            alt12=26;
            }
            break;
        case '^':
            {
            alt12=27;
            }
            break;
        case '(':
            {
            alt12=28;
            }
            break;
        case ')':
            {
            alt12=29;
            }
            break;
        case ';':
            {
            alt12=30;
            }
            break;
        case ',':
            {
            alt12=31;
            }
            break;
        case '=':
            {
            int LA12_28 = input.LA(2);

            if ( (LA12_28=='=') ) {
                alt12=34;
            }
            else {
                alt12=32;}
            }
            break;
        case 'o':
            {
            int LA12_29 = input.LA(2);

            if ( (LA12_29=='r') ) {
                int LA12_62 = input.LA(3);

                if ( (LA12_62=='d') ) {
                    int LA12_86 = input.LA(4);

                    if ( (LA12_86=='e') ) {
                        int LA12_104 = input.LA(5);

                        if ( (LA12_104=='r') ) {
                            int LA12_119 = input.LA(6);

                            if ( (LA12_119=='e') ) {
                                int LA12_131 = input.LA(7);

                                if ( (LA12_131=='d') ) {
                                    int LA12_140 = input.LA(8);

                                    if ( ((LA12_140>='A' && LA12_140<='Z')||LA12_140=='_'||(LA12_140>='a' && LA12_140<='z')) ) {
                                        alt12=45;
                                    }
                                    else {
                                        alt12=33;}
                                }
                                else {
                                    alt12=45;}
                            }
                            else {
                                alt12=45;}
                        }
                        else {
                            alt12=45;}
                    }
                    else {
                        alt12=45;}
                }
                else {
                    alt12=45;}
            }
            else {
                alt12=45;}
            }
            break;
        case '[':
            {
            alt12=35;
            }
            break;
        case ']':
            {
            alt12=36;
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
            alt12=37;
            }
            break;
        case '<':
            {
            switch ( input.LA(2) ) {
            case '=':
                {
                alt12=42;
                }
                break;
            case '>':
                {
                alt12=38;
                }
                break;
            default:
                alt12=40;}

            }
            break;
        case '>':
            {
            int LA12_34 = input.LA(2);

            if ( (LA12_34=='=') ) {
                alt12=41;
            }
            else {
                alt12=39;}
            }
            break;
        case '.':
            {
            alt12=44;
            }
            break;
        case 'C':
        case 'F':
        case 'G':
        case 'H':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'P':
        case 'Q':
        case 'R':
        case 'U':
        case 'W':
        case 'Y':
        case 'Z':
        case '_':
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt12=45;
            }
            break;
        case '\t':
        case '\n':
        case '\f':
        case '\r':
        case ' ':
            {
            alt12=46;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T53 | T54 | OR | XOR | AND | NOT | INTPMF | DOUBLEPMF | ENUMPMF | DOUBLEPDF | BOOLPMF | UNIT | BOOL | FALSE | TRUE | BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE | INNER | PLUS | MINUS | MUL | DIV | MOD | POW | LPAREN | RPAREN | SEMI | COLON | DEFINITION | ORDERED_DEF | EQUAL | SQUARE_PAREN_L | SQUARE_PAREN_R | NUMBER | NOTEQUAL | GREATER | LESS | GREATEREQUAL | LESSEQUAL | STRING_LITERAL | DOT | ID | WS | COMMENT | LINE_COMMENT );", 12, 0, input);

            throw nvae;
        }

        switch (alt12) {
            case 1 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:10: T53
                {
                mT53(); 

                }
                break;
            case 2 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:14: T54
                {
                mT54(); 

                }
                break;
            case 3 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:18: OR
                {
                mOR(); 

                }
                break;
            case 4 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:21: XOR
                {
                mXOR(); 

                }
                break;
            case 5 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:25: AND
                {
                mAND(); 

                }
                break;
            case 6 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:29: NOT
                {
                mNOT(); 

                }
                break;
            case 7 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:33: INTPMF
                {
                mINTPMF(); 

                }
                break;
            case 8 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:40: DOUBLEPMF
                {
                mDOUBLEPMF(); 

                }
                break;
            case 9 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:50: ENUMPMF
                {
                mENUMPMF(); 

                }
                break;
            case 10 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:58: DOUBLEPDF
                {
                mDOUBLEPDF(); 

                }
                break;
            case 11 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:68: BOOLPMF
                {
                mBOOLPMF(); 

                }
                break;
            case 12 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:76: UNIT
                {
                mUNIT(); 

                }
                break;
            case 13 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:81: BOOL
                {
                mBOOL(); 

                }
                break;
            case 14 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:86: FALSE
                {
                mFALSE(); 

                }
                break;
            case 15 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:92: TRUE
                {
                mTRUE(); 

                }
                break;
            case 16 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:97: BYTESIZE
                {
                mBYTESIZE(); 

                }
                break;
            case 17 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:106: STRUCTURE
                {
                mSTRUCTURE(); 

                }
                break;
            case 18 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:116: NUMBER_OF_ELEMENTS
                {
                mNUMBER_OF_ELEMENTS(); 

                }
                break;
            case 19 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:135: TYPE
                {
                mTYPE(); 

                }
                break;
            case 20 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:140: VALUE
                {
                mVALUE(); 

                }
                break;
            case 21 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:146: INNER
                {
                mINNER(); 

                }
                break;
            case 22 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:152: PLUS
                {
                mPLUS(); 

                }
                break;
            case 23 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:157: MINUS
                {
                mMINUS(); 

                }
                break;
            case 24 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:163: MUL
                {
                mMUL(); 

                }
                break;
            case 25 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:167: DIV
                {
                mDIV(); 

                }
                break;
            case 26 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:171: MOD
                {
                mMOD(); 

                }
                break;
            case 27 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:175: POW
                {
                mPOW(); 

                }
                break;
            case 28 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:179: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 29 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:186: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 30 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:193: SEMI
                {
                mSEMI(); 

                }
                break;
            case 31 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:198: COLON
                {
                mCOLON(); 

                }
                break;
            case 32 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:204: DEFINITION
                {
                mDEFINITION(); 

                }
                break;
            case 33 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:215: ORDERED_DEF
                {
                mORDERED_DEF(); 

                }
                break;
            case 34 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:227: EQUAL
                {
                mEQUAL(); 

                }
                break;
            case 35 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:233: SQUARE_PAREN_L
                {
                mSQUARE_PAREN_L(); 

                }
                break;
            case 36 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:248: SQUARE_PAREN_R
                {
                mSQUARE_PAREN_R(); 

                }
                break;
            case 37 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:263: NUMBER
                {
                mNUMBER(); 

                }
                break;
            case 38 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:270: NOTEQUAL
                {
                mNOTEQUAL(); 

                }
                break;
            case 39 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:279: GREATER
                {
                mGREATER(); 

                }
                break;
            case 40 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:287: LESS
                {
                mLESS(); 

                }
                break;
            case 41 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:292: GREATEREQUAL
                {
                mGREATEREQUAL(); 

                }
                break;
            case 42 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:305: LESSEQUAL
                {
                mLESSEQUAL(); 

                }
                break;
            case 43 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:315: STRING_LITERAL
                {
                mSTRING_LITERAL(); 

                }
                break;
            case 44 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:330: DOT
                {
                mDOT(); 

                }
                break;
            case 45 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:334: ID
                {
                mID(); 

                }
                break;
            case 46 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:337: WS
                {
                mWS(); 

                }
                break;
            case 47 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:340: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 48 :
                // C:\\coding\\gmf2\\Palladio.EMFComponentModel\\trunk\\de.uka.ipd.sdq.pcm.stochasticexpressions\\src\\de\\uka\\ipd\\sdq\\pcm\\stochasticexpressions\\parser\\PCMStoEx.g:1:348: LINE_COMMENT
                {
                mLINE_COMMENT(); 

                }
                break;

        }

    }


 

}
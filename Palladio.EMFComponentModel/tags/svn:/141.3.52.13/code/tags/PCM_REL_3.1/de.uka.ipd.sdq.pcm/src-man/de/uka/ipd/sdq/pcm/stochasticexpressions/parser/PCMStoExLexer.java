package de.uka.ipd.sdq.pcm.stochasticexpressions.parser;

// $ANTLR 3.0.1 PCMStoEx.g 2009-07-10 08:05:03

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class PCMStoExLexer extends Lexer {
    public static final int INNER=43;
    public static final int MOD=17;
    public static final int BOOLPMF=34;
    public static final int ENUMPMF=31;
    public static final int GREATEREQUAL=11;
    public static final int Exponent=48;
    public static final int NOT=19;
    public static final int ID=23;
    public static final int AND=4;
    public static final int EOF=-1;
    public static final int STRUCTURE=39;
    public static final int LPAREN=24;
    public static final int TYPE=41;
    public static final int NOTEQUAL=10;
    public static final int RPAREN=25;
    public static final int STRING_LITERAL=21;
    public static final int GREATER=7;
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
    public static final int Tokens=55;
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
    public static final int T54=54;
    public static final int LESSEQUAL=12;
    public static final int T53=53;
    public PCMStoExLexer() {;} 
    public PCMStoExLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "PCMStoEx.g"; }

    // $ANTLR start T53
    public final void mT53() throws RecognitionException {
        try {
            int _type = T53;
            // PCMStoEx.g:3:5: ( '?' )
            // PCMStoEx.g:3:7: '?'
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
            // PCMStoEx.g:4:5: ( ':' )
            // PCMStoEx.g:4:7: ':'
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
            // PCMStoEx.g:375:2: ( 'OR' )
            // PCMStoEx.g:375:4: 'OR'
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
            // PCMStoEx.g:379:2: ( 'XOR' )
            // PCMStoEx.g:379:4: 'XOR'
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
            // PCMStoEx.g:383:2: ( 'AND' )
            // PCMStoEx.g:383:4: 'AND'
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
            // PCMStoEx.g:387:2: ( 'NOT' )
            // PCMStoEx.g:387:4: 'NOT'
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
            // PCMStoEx.g:391:2: ( 'IntPMF' )
            // PCMStoEx.g:391:4: 'IntPMF'
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
            // PCMStoEx.g:395:2: ( 'DoublePMF' )
            // PCMStoEx.g:395:4: 'DoublePMF'
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
            // PCMStoEx.g:399:2: ( 'EnumPMF' )
            // PCMStoEx.g:399:4: 'EnumPMF'
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
            // PCMStoEx.g:403:2: ( 'DoublePDF' )
            // PCMStoEx.g:403:4: 'DoublePDF'
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
            // PCMStoEx.g:407:2: ( 'BoolPMF' )
            // PCMStoEx.g:407:4: 'BoolPMF'
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
            // PCMStoEx.g:411:2: ( 'unit' )
            // PCMStoEx.g:411:4: 'unit'
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
            // PCMStoEx.g:415:2: ( '\"bool\"' )
            // PCMStoEx.g:415:4: '\"bool\"'
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
            // PCMStoEx.g:419:2: ( 'false' )
            // PCMStoEx.g:419:4: 'false'
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
            // PCMStoEx.g:423:2: ( 'true' )
            // PCMStoEx.g:423:4: 'true'
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
            // PCMStoEx.g:427:2: ( 'BYTESIZE' )
            // PCMStoEx.g:427:4: 'BYTESIZE'
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
            // PCMStoEx.g:431:2: ( 'STRUCTURE' )
            // PCMStoEx.g:431:4: 'STRUCTURE'
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
            // PCMStoEx.g:435:2: ( 'NUMBER_OF_ELEMENTS' )
            // PCMStoEx.g:435:4: 'NUMBER_OF_ELEMENTS'
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
            // PCMStoEx.g:439:2: ( 'TYPE' )
            // PCMStoEx.g:439:4: 'TYPE'
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
            // PCMStoEx.g:443:2: ( 'VALUE' )
            // PCMStoEx.g:443:4: 'VALUE'
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
            // PCMStoEx.g:447:2: ( 'INNER' )
            // PCMStoEx.g:447:4: 'INNER'
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
            // PCMStoEx.g:450:7: ( '+' )
            // PCMStoEx.g:450:9: '+'
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
            // PCMStoEx.g:451:7: ( '-' )
            // PCMStoEx.g:451:9: '-'
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
            // PCMStoEx.g:452:7: ( '*' )
            // PCMStoEx.g:452:9: '*'
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
            // PCMStoEx.g:453:7: ( '/' )
            // PCMStoEx.g:453:9: '/'
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
            // PCMStoEx.g:454:7: ( '%' )
            // PCMStoEx.g:454:9: '%'
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
            // PCMStoEx.g:455:7: ( '^' )
            // PCMStoEx.g:455:9: '^'
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
            // PCMStoEx.g:456:7: ( '(' )
            // PCMStoEx.g:456:9: '('
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
            // PCMStoEx.g:457:7: ( ')' )
            // PCMStoEx.g:457:9: ')'
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
            // PCMStoEx.g:458:7: ( ';' )
            // PCMStoEx.g:458:9: ';'
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
            // PCMStoEx.g:459:8: ( ',' )
            // PCMStoEx.g:459:10: ','
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
            // PCMStoEx.g:460:12: ( '=' )
            // PCMStoEx.g:460:14: '='
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
            // PCMStoEx.g:462:2: ( 'ordered' )
            // PCMStoEx.g:462:4: 'ordered'
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
            // PCMStoEx.g:463:7: ( '==' )
            // PCMStoEx.g:463:9: '=='
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
            // PCMStoEx.g:464:16: ( '[' )
            // PCMStoEx.g:464:18: '['
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
            // PCMStoEx.g:465:16: ( ']' )
            // PCMStoEx.g:465:18: ']'
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
            // PCMStoEx.g:466:16: ( '0' .. '9' )
            // PCMStoEx.g:466:18: '0' .. '9'
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
            // PCMStoEx.g:467:8: ( ( '-' )? ( DIGIT )+ ( '.' ( DIGIT )+ )? ( Exponent )? )
            // PCMStoEx.g:467:10: ( '-' )? ( DIGIT )+ ( '.' ( DIGIT )+ )? ( Exponent )?
            {
            // PCMStoEx.g:467:10: ( '-' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='-') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // PCMStoEx.g:467:10: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // PCMStoEx.g:467:15: ( DIGIT )+
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
            	    // PCMStoEx.g:467:16: DIGIT
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

            // PCMStoEx.g:467:24: ( '.' ( DIGIT )+ )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='.') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // PCMStoEx.g:467:25: '.' ( DIGIT )+
                    {
                    match('.'); 
                    // PCMStoEx.g:467:29: ( DIGIT )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // PCMStoEx.g:467:30: DIGIT
                    	    {
                    	    mDIGIT(); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt3 >= 1 ) break loop3;
                                EarlyExitException eee =
                                    new EarlyExitException(3, input);
                                throw eee;
                        }
                        cnt3++;
                    } while (true);


                    }
                    break;

            }

            // PCMStoEx.g:467:40: ( Exponent )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='E'||LA5_0=='e') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // PCMStoEx.g:467:40: Exponent
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
            // PCMStoEx.g:469:10: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // PCMStoEx.g:469:12: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // PCMStoEx.g:469:22: ( '+' | '-' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='+'||LA6_0=='-') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // PCMStoEx.g:
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

            // PCMStoEx.g:469:33: ( '0' .. '9' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // PCMStoEx.g:469:34: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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


            }

        }
        finally {
        }
    }
    // $ANTLR end Exponent

    // $ANTLR start ALPHA
    public final void mALPHA() throws RecognitionException {
        try {
            // PCMStoEx.g:470:16: ( 'a' .. 'z' | 'A' .. 'Z' )
            // PCMStoEx.g:
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
            // PCMStoEx.g:471:10: ( '<>' )
            // PCMStoEx.g:471:12: '<>'
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
            // PCMStoEx.g:472:9: ( '>' )
            // PCMStoEx.g:472:11: '>'
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
            // PCMStoEx.g:473:6: ( '<' )
            // PCMStoEx.g:473:8: '<'
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
            // PCMStoEx.g:474:14: ( '>=' )
            // PCMStoEx.g:474:16: '>='
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
            // PCMStoEx.g:475:11: ( '<=' )
            // PCMStoEx.g:475:13: '<='
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
            // PCMStoEx.g:476:16: ( '\\\"' ( ALPHA | '_' )+ '\\\"' )
            // PCMStoEx.g:476:18: '\\\"' ( ALPHA | '_' )+ '\\\"'
            {
            match('\"'); 
            // PCMStoEx.g:476:23: ( ALPHA | '_' )+
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
            	    // PCMStoEx.g:
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
            // PCMStoEx.g:477:4: ( '.' )
            // PCMStoEx.g:477:6: '.'
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
            // PCMStoEx.g:478:3: ( ( ALPHA | '_' )+ )
            // PCMStoEx.g:478:4: ( ALPHA | '_' )+
            {
            // PCMStoEx.g:478:4: ( ALPHA | '_' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='A' && LA9_0<='Z')||LA9_0=='_'||(LA9_0>='a' && LA9_0<='z')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // PCMStoEx.g:
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
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
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
            // PCMStoEx.g:481:5: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
            // PCMStoEx.g:481:8: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
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
            // PCMStoEx.g:485:5: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // PCMStoEx.g:485:9: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // PCMStoEx.g:485:14: ( options {greedy=false; } : . )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='*') ) {
                    int LA10_1 = input.LA(2);

                    if ( (LA10_1=='/') ) {
                        alt10=2;
                    }
                    else if ( ((LA10_1>='\u0000' && LA10_1<='.')||(LA10_1>='0' && LA10_1<='\uFFFE')) ) {
                        alt10=1;
                    }


                }
                else if ( ((LA10_0>='\u0000' && LA10_0<=')')||(LA10_0>='+' && LA10_0<='\uFFFE')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // PCMStoEx.g:485:42: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop10;
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
            // PCMStoEx.g:489:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? ( '\\n' | EOF ) )
            // PCMStoEx.g:489:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? ( '\\n' | EOF )
            {
            match("//"); 

            // PCMStoEx.g:489:12: (~ ( '\\n' | '\\r' ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\u0000' && LA11_0<='\t')||(LA11_0>='\u000B' && LA11_0<='\f')||(LA11_0>='\u000E' && LA11_0<='\uFFFE')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // PCMStoEx.g:489:12: ~ ( '\\n' | '\\r' )
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
            	    break loop11;
                }
            } while (true);

            // PCMStoEx.g:489:26: ( '\\r' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='\r') ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // PCMStoEx.g:489:26: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            // PCMStoEx.g:489:32: ( '\\n' | EOF )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='\n') ) {
                alt13=1;
            }
            else {
                alt13=2;}
            switch (alt13) {
                case 1 :
                    // PCMStoEx.g:489:33: '\\n'
                    {
                    match('\n'); 

                    }
                    break;
                case 2 :
                    // PCMStoEx.g:489:38: EOF
                    {
                    match(EOF); 

                    }
                    break;

            }

            channel=HIDDEN;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LINE_COMMENT

    public void mTokens() throws RecognitionException {
        // PCMStoEx.g:1:8: ( T53 | T54 | OR | XOR | AND | NOT | INTPMF | DOUBLEPMF | ENUMPMF | DOUBLEPDF | BOOLPMF | UNIT | BOOL | FALSE | TRUE | BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE | INNER | PLUS | MINUS | MUL | DIV | MOD | POW | LPAREN | RPAREN | SEMI | COLON | DEFINITION | ORDERED_DEF | EQUAL | SQUARE_PAREN_L | SQUARE_PAREN_R | NUMBER | NOTEQUAL | GREATER | LESS | GREATEREQUAL | LESSEQUAL | STRING_LITERAL | DOT | ID | WS | COMMENT | LINE_COMMENT )
        int alt14=48;
        switch ( input.LA(1) ) {
        case '?':
            {
            alt14=1;
            }
            break;
        case ':':
            {
            alt14=2;
            }
            break;
        case 'O':
            {
            int LA14_3 = input.LA(2);

            if ( (LA14_3=='R') ) {
                int LA14_38 = input.LA(3);

                if ( ((LA14_38>='A' && LA14_38<='Z')||LA14_38=='_'||(LA14_38>='a' && LA14_38<='z')) ) {
                    alt14=45;
                }
                else {
                    alt14=3;}
            }
            else {
                alt14=45;}
            }
            break;
        case 'X':
            {
            int LA14_4 = input.LA(2);

            if ( (LA14_4=='O') ) {
                int LA14_39 = input.LA(3);

                if ( (LA14_39=='R') ) {
                    int LA14_70 = input.LA(4);

                    if ( ((LA14_70>='A' && LA14_70<='Z')||LA14_70=='_'||(LA14_70>='a' && LA14_70<='z')) ) {
                        alt14=45;
                    }
                    else {
                        alt14=4;}
                }
                else {
                    alt14=45;}
            }
            else {
                alt14=45;}
            }
            break;
        case 'A':
            {
            int LA14_5 = input.LA(2);

            if ( (LA14_5=='N') ) {
                int LA14_40 = input.LA(3);

                if ( (LA14_40=='D') ) {
                    int LA14_71 = input.LA(4);

                    if ( ((LA14_71>='A' && LA14_71<='Z')||LA14_71=='_'||(LA14_71>='a' && LA14_71<='z')) ) {
                        alt14=45;
                    }
                    else {
                        alt14=5;}
                }
                else {
                    alt14=45;}
            }
            else {
                alt14=45;}
            }
            break;
        case 'N':
            {
            switch ( input.LA(2) ) {
            case 'O':
                {
                int LA14_41 = input.LA(3);

                if ( (LA14_41=='T') ) {
                    int LA14_72 = input.LA(4);

                    if ( ((LA14_72>='A' && LA14_72<='Z')||LA14_72=='_'||(LA14_72>='a' && LA14_72<='z')) ) {
                        alt14=45;
                    }
                    else {
                        alt14=6;}
                }
                else {
                    alt14=45;}
                }
                break;
            case 'U':
                {
                int LA14_42 = input.LA(3);

                if ( (LA14_42=='M') ) {
                    int LA14_73 = input.LA(4);

                    if ( (LA14_73=='B') ) {
                        int LA14_91 = input.LA(5);

                        if ( (LA14_91=='E') ) {
                            int LA14_106 = input.LA(6);

                            if ( (LA14_106=='R') ) {
                                int LA14_121 = input.LA(7);

                                if ( (LA14_121=='_') ) {
                                    int LA14_133 = input.LA(8);

                                    if ( (LA14_133=='O') ) {
                                        int LA14_142 = input.LA(9);

                                        if ( (LA14_142=='F') ) {
                                            int LA14_150 = input.LA(10);

                                            if ( (LA14_150=='_') ) {
                                                int LA14_155 = input.LA(11);

                                                if ( (LA14_155=='E') ) {
                                                    int LA14_159 = input.LA(12);

                                                    if ( (LA14_159=='L') ) {
                                                        int LA14_160 = input.LA(13);

                                                        if ( (LA14_160=='E') ) {
                                                            int LA14_161 = input.LA(14);

                                                            if ( (LA14_161=='M') ) {
                                                                int LA14_162 = input.LA(15);

                                                                if ( (LA14_162=='E') ) {
                                                                    int LA14_163 = input.LA(16);

                                                                    if ( (LA14_163=='N') ) {
                                                                        int LA14_164 = input.LA(17);

                                                                        if ( (LA14_164=='T') ) {
                                                                            int LA14_165 = input.LA(18);

                                                                            if ( (LA14_165=='S') ) {
                                                                                int LA14_166 = input.LA(19);

                                                                                if ( ((LA14_166>='A' && LA14_166<='Z')||LA14_166=='_'||(LA14_166>='a' && LA14_166<='z')) ) {
                                                                                    alt14=45;
                                                                                }
                                                                                else {
                                                                                    alt14=18;}
                                                                            }
                                                                            else {
                                                                                alt14=45;}
                                                                        }
                                                                        else {
                                                                            alt14=45;}
                                                                    }
                                                                    else {
                                                                        alt14=45;}
                                                                }
                                                                else {
                                                                    alt14=45;}
                                                            }
                                                            else {
                                                                alt14=45;}
                                                        }
                                                        else {
                                                            alt14=45;}
                                                    }
                                                    else {
                                                        alt14=45;}
                                                }
                                                else {
                                                    alt14=45;}
                                            }
                                            else {
                                                alt14=45;}
                                        }
                                        else {
                                            alt14=45;}
                                    }
                                    else {
                                        alt14=45;}
                                }
                                else {
                                    alt14=45;}
                            }
                            else {
                                alt14=45;}
                        }
                        else {
                            alt14=45;}
                    }
                    else {
                        alt14=45;}
                }
                else {
                    alt14=45;}
                }
                break;
            default:
                alt14=45;}

            }
            break;
        case 'I':
            {
            switch ( input.LA(2) ) {
            case 'n':
                {
                int LA14_43 = input.LA(3);

                if ( (LA14_43=='t') ) {
                    int LA14_74 = input.LA(4);

                    if ( (LA14_74=='P') ) {
                        int LA14_92 = input.LA(5);

                        if ( (LA14_92=='M') ) {
                            int LA14_107 = input.LA(6);

                            if ( (LA14_107=='F') ) {
                                int LA14_122 = input.LA(7);

                                if ( ((LA14_122>='A' && LA14_122<='Z')||LA14_122=='_'||(LA14_122>='a' && LA14_122<='z')) ) {
                                    alt14=45;
                                }
                                else {
                                    alt14=7;}
                            }
                            else {
                                alt14=45;}
                        }
                        else {
                            alt14=45;}
                    }
                    else {
                        alt14=45;}
                }
                else {
                    alt14=45;}
                }
                break;
            case 'N':
                {
                int LA14_44 = input.LA(3);

                if ( (LA14_44=='N') ) {
                    int LA14_75 = input.LA(4);

                    if ( (LA14_75=='E') ) {
                        int LA14_93 = input.LA(5);

                        if ( (LA14_93=='R') ) {
                            int LA14_108 = input.LA(6);

                            if ( ((LA14_108>='A' && LA14_108<='Z')||LA14_108=='_'||(LA14_108>='a' && LA14_108<='z')) ) {
                                alt14=45;
                            }
                            else {
                                alt14=21;}
                        }
                        else {
                            alt14=45;}
                    }
                    else {
                        alt14=45;}
                }
                else {
                    alt14=45;}
                }
                break;
            default:
                alt14=45;}

            }
            break;
        case 'D':
            {
            int LA14_8 = input.LA(2);

            if ( (LA14_8=='o') ) {
                int LA14_45 = input.LA(3);

                if ( (LA14_45=='u') ) {
                    int LA14_76 = input.LA(4);

                    if ( (LA14_76=='b') ) {
                        int LA14_94 = input.LA(5);

                        if ( (LA14_94=='l') ) {
                            int LA14_109 = input.LA(6);

                            if ( (LA14_109=='e') ) {
                                int LA14_124 = input.LA(7);

                                if ( (LA14_124=='P') ) {
                                    switch ( input.LA(8) ) {
                                    case 'D':
                                        {
                                        int LA14_143 = input.LA(9);

                                        if ( (LA14_143=='F') ) {
                                            int LA14_151 = input.LA(10);

                                            if ( ((LA14_151>='A' && LA14_151<='Z')||LA14_151=='_'||(LA14_151>='a' && LA14_151<='z')) ) {
                                                alt14=45;
                                            }
                                            else {
                                                alt14=10;}
                                        }
                                        else {
                                            alt14=45;}
                                        }
                                        break;
                                    case 'M':
                                        {
                                        int LA14_144 = input.LA(9);

                                        if ( (LA14_144=='F') ) {
                                            int LA14_152 = input.LA(10);

                                            if ( ((LA14_152>='A' && LA14_152<='Z')||LA14_152=='_'||(LA14_152>='a' && LA14_152<='z')) ) {
                                                alt14=45;
                                            }
                                            else {
                                                alt14=8;}
                                        }
                                        else {
                                            alt14=45;}
                                        }
                                        break;
                                    default:
                                        alt14=45;}

                                }
                                else {
                                    alt14=45;}
                            }
                            else {
                                alt14=45;}
                        }
                        else {
                            alt14=45;}
                    }
                    else {
                        alt14=45;}
                }
                else {
                    alt14=45;}
            }
            else {
                alt14=45;}
            }
            break;
        case 'E':
            {
            int LA14_9 = input.LA(2);

            if ( (LA14_9=='n') ) {
                int LA14_46 = input.LA(3);

                if ( (LA14_46=='u') ) {
                    int LA14_77 = input.LA(4);

                    if ( (LA14_77=='m') ) {
                        int LA14_95 = input.LA(5);

                        if ( (LA14_95=='P') ) {
                            int LA14_110 = input.LA(6);

                            if ( (LA14_110=='M') ) {
                                int LA14_125 = input.LA(7);

                                if ( (LA14_125=='F') ) {
                                    int LA14_136 = input.LA(8);

                                    if ( ((LA14_136>='A' && LA14_136<='Z')||LA14_136=='_'||(LA14_136>='a' && LA14_136<='z')) ) {
                                        alt14=45;
                                    }
                                    else {
                                        alt14=9;}
                                }
                                else {
                                    alt14=45;}
                            }
                            else {
                                alt14=45;}
                        }
                        else {
                            alt14=45;}
                    }
                    else {
                        alt14=45;}
                }
                else {
                    alt14=45;}
            }
            else {
                alt14=45;}
            }
            break;
        case 'B':
            {
            switch ( input.LA(2) ) {
            case 'o':
                {
                int LA14_47 = input.LA(3);

                if ( (LA14_47=='o') ) {
                    int LA14_78 = input.LA(4);

                    if ( (LA14_78=='l') ) {
                        int LA14_96 = input.LA(5);

                        if ( (LA14_96=='P') ) {
                            int LA14_111 = input.LA(6);

                            if ( (LA14_111=='M') ) {
                                int LA14_126 = input.LA(7);

                                if ( (LA14_126=='F') ) {
                                    int LA14_137 = input.LA(8);

                                    if ( ((LA14_137>='A' && LA14_137<='Z')||LA14_137=='_'||(LA14_137>='a' && LA14_137<='z')) ) {
                                        alt14=45;
                                    }
                                    else {
                                        alt14=11;}
                                }
                                else {
                                    alt14=45;}
                            }
                            else {
                                alt14=45;}
                        }
                        else {
                            alt14=45;}
                    }
                    else {
                        alt14=45;}
                }
                else {
                    alt14=45;}
                }
                break;
            case 'Y':
                {
                int LA14_48 = input.LA(3);

                if ( (LA14_48=='T') ) {
                    int LA14_79 = input.LA(4);

                    if ( (LA14_79=='E') ) {
                        int LA14_97 = input.LA(5);

                        if ( (LA14_97=='S') ) {
                            int LA14_112 = input.LA(6);

                            if ( (LA14_112=='I') ) {
                                int LA14_127 = input.LA(7);

                                if ( (LA14_127=='Z') ) {
                                    int LA14_138 = input.LA(8);

                                    if ( (LA14_138=='E') ) {
                                        int LA14_147 = input.LA(9);

                                        if ( ((LA14_147>='A' && LA14_147<='Z')||LA14_147=='_'||(LA14_147>='a' && LA14_147<='z')) ) {
                                            alt14=45;
                                        }
                                        else {
                                            alt14=16;}
                                    }
                                    else {
                                        alt14=45;}
                                }
                                else {
                                    alt14=45;}
                            }
                            else {
                                alt14=45;}
                        }
                        else {
                            alt14=45;}
                    }
                    else {
                        alt14=45;}
                }
                else {
                    alt14=45;}
                }
                break;
            default:
                alt14=45;}

            }
            break;
        case 'u':
            {
            int LA14_11 = input.LA(2);

            if ( (LA14_11=='n') ) {
                int LA14_49 = input.LA(3);

                if ( (LA14_49=='i') ) {
                    int LA14_80 = input.LA(4);

                    if ( (LA14_80=='t') ) {
                        int LA14_98 = input.LA(5);

                        if ( ((LA14_98>='A' && LA14_98<='Z')||LA14_98=='_'||(LA14_98>='a' && LA14_98<='z')) ) {
                            alt14=45;
                        }
                        else {
                            alt14=12;}
                    }
                    else {
                        alt14=45;}
                }
                else {
                    alt14=45;}
            }
            else {
                alt14=45;}
            }
            break;
        case '\"':
            {
            int LA14_12 = input.LA(2);

            if ( (LA14_12=='b') ) {
                int LA14_50 = input.LA(3);

                if ( (LA14_50=='o') ) {
                    int LA14_81 = input.LA(4);

                    if ( (LA14_81=='o') ) {
                        int LA14_99 = input.LA(5);

                        if ( (LA14_99=='l') ) {
                            int LA14_114 = input.LA(6);

                            if ( (LA14_114=='\"') ) {
                                alt14=13;
                            }
                            else if ( ((LA14_114>='A' && LA14_114<='Z')||LA14_114=='_'||(LA14_114>='a' && LA14_114<='z')) ) {
                                alt14=43;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1:1: Tokens : ( T53 | T54 | OR | XOR | AND | NOT | INTPMF | DOUBLEPMF | ENUMPMF | DOUBLEPDF | BOOLPMF | UNIT | BOOL | FALSE | TRUE | BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE | INNER | PLUS | MINUS | MUL | DIV | MOD | POW | LPAREN | RPAREN | SEMI | COLON | DEFINITION | ORDERED_DEF | EQUAL | SQUARE_PAREN_L | SQUARE_PAREN_R | NUMBER | NOTEQUAL | GREATER | LESS | GREATEREQUAL | LESSEQUAL | STRING_LITERAL | DOT | ID | WS | COMMENT | LINE_COMMENT );", 14, 114, input);

                                throw nvae;
                            }
                        }
                        else if ( (LA14_99=='\"'||(LA14_99>='A' && LA14_99<='Z')||LA14_99=='_'||(LA14_99>='a' && LA14_99<='k')||(LA14_99>='m' && LA14_99<='z')) ) {
                            alt14=43;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("1:1: Tokens : ( T53 | T54 | OR | XOR | AND | NOT | INTPMF | DOUBLEPMF | ENUMPMF | DOUBLEPDF | BOOLPMF | UNIT | BOOL | FALSE | TRUE | BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE | INNER | PLUS | MINUS | MUL | DIV | MOD | POW | LPAREN | RPAREN | SEMI | COLON | DEFINITION | ORDERED_DEF | EQUAL | SQUARE_PAREN_L | SQUARE_PAREN_R | NUMBER | NOTEQUAL | GREATER | LESS | GREATEREQUAL | LESSEQUAL | STRING_LITERAL | DOT | ID | WS | COMMENT | LINE_COMMENT );", 14, 99, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA14_81=='\"'||(LA14_81>='A' && LA14_81<='Z')||LA14_81=='_'||(LA14_81>='a' && LA14_81<='n')||(LA14_81>='p' && LA14_81<='z')) ) {
                        alt14=43;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1:1: Tokens : ( T53 | T54 | OR | XOR | AND | NOT | INTPMF | DOUBLEPMF | ENUMPMF | DOUBLEPDF | BOOLPMF | UNIT | BOOL | FALSE | TRUE | BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE | INNER | PLUS | MINUS | MUL | DIV | MOD | POW | LPAREN | RPAREN | SEMI | COLON | DEFINITION | ORDERED_DEF | EQUAL | SQUARE_PAREN_L | SQUARE_PAREN_R | NUMBER | NOTEQUAL | GREATER | LESS | GREATEREQUAL | LESSEQUAL | STRING_LITERAL | DOT | ID | WS | COMMENT | LINE_COMMENT );", 14, 81, input);

                        throw nvae;
                    }
                }
                else if ( (LA14_50=='\"'||(LA14_50>='A' && LA14_50<='Z')||LA14_50=='_'||(LA14_50>='a' && LA14_50<='n')||(LA14_50>='p' && LA14_50<='z')) ) {
                    alt14=43;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1:1: Tokens : ( T53 | T54 | OR | XOR | AND | NOT | INTPMF | DOUBLEPMF | ENUMPMF | DOUBLEPDF | BOOLPMF | UNIT | BOOL | FALSE | TRUE | BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE | INNER | PLUS | MINUS | MUL | DIV | MOD | POW | LPAREN | RPAREN | SEMI | COLON | DEFINITION | ORDERED_DEF | EQUAL | SQUARE_PAREN_L | SQUARE_PAREN_R | NUMBER | NOTEQUAL | GREATER | LESS | GREATEREQUAL | LESSEQUAL | STRING_LITERAL | DOT | ID | WS | COMMENT | LINE_COMMENT );", 14, 50, input);

                    throw nvae;
                }
            }
            else if ( ((LA14_12>='A' && LA14_12<='Z')||LA14_12=='_'||LA14_12=='a'||(LA14_12>='c' && LA14_12<='z')) ) {
                alt14=43;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1:1: Tokens : ( T53 | T54 | OR | XOR | AND | NOT | INTPMF | DOUBLEPMF | ENUMPMF | DOUBLEPDF | BOOLPMF | UNIT | BOOL | FALSE | TRUE | BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE | INNER | PLUS | MINUS | MUL | DIV | MOD | POW | LPAREN | RPAREN | SEMI | COLON | DEFINITION | ORDERED_DEF | EQUAL | SQUARE_PAREN_L | SQUARE_PAREN_R | NUMBER | NOTEQUAL | GREATER | LESS | GREATEREQUAL | LESSEQUAL | STRING_LITERAL | DOT | ID | WS | COMMENT | LINE_COMMENT );", 14, 12, input);

                throw nvae;
            }
            }
            break;
        case 'f':
            {
            int LA14_13 = input.LA(2);

            if ( (LA14_13=='a') ) {
                int LA14_52 = input.LA(3);

                if ( (LA14_52=='l') ) {
                    int LA14_82 = input.LA(4);

                    if ( (LA14_82=='s') ) {
                        int LA14_100 = input.LA(5);

                        if ( (LA14_100=='e') ) {
                            int LA14_115 = input.LA(6);

                            if ( ((LA14_115>='A' && LA14_115<='Z')||LA14_115=='_'||(LA14_115>='a' && LA14_115<='z')) ) {
                                alt14=45;
                            }
                            else {
                                alt14=14;}
                        }
                        else {
                            alt14=45;}
                    }
                    else {
                        alt14=45;}
                }
                else {
                    alt14=45;}
            }
            else {
                alt14=45;}
            }
            break;
        case 't':
            {
            int LA14_14 = input.LA(2);

            if ( (LA14_14=='r') ) {
                int LA14_53 = input.LA(3);

                if ( (LA14_53=='u') ) {
                    int LA14_83 = input.LA(4);

                    if ( (LA14_83=='e') ) {
                        int LA14_101 = input.LA(5);

                        if ( ((LA14_101>='A' && LA14_101<='Z')||LA14_101=='_'||(LA14_101>='a' && LA14_101<='z')) ) {
                            alt14=45;
                        }
                        else {
                            alt14=15;}
                    }
                    else {
                        alt14=45;}
                }
                else {
                    alt14=45;}
            }
            else {
                alt14=45;}
            }
            break;
        case 'S':
            {
            int LA14_15 = input.LA(2);

            if ( (LA14_15=='T') ) {
                int LA14_54 = input.LA(3);

                if ( (LA14_54=='R') ) {
                    int LA14_84 = input.LA(4);

                    if ( (LA14_84=='U') ) {
                        int LA14_102 = input.LA(5);

                        if ( (LA14_102=='C') ) {
                            int LA14_117 = input.LA(6);

                            if ( (LA14_117=='T') ) {
                                int LA14_130 = input.LA(7);

                                if ( (LA14_130=='U') ) {
                                    int LA14_140 = input.LA(8);

                                    if ( (LA14_140=='R') ) {
                                        int LA14_148 = input.LA(9);

                                        if ( (LA14_148=='E') ) {
                                            int LA14_154 = input.LA(10);

                                            if ( ((LA14_154>='A' && LA14_154<='Z')||LA14_154=='_'||(LA14_154>='a' && LA14_154<='z')) ) {
                                                alt14=45;
                                            }
                                            else {
                                                alt14=17;}
                                        }
                                        else {
                                            alt14=45;}
                                    }
                                    else {
                                        alt14=45;}
                                }
                                else {
                                    alt14=45;}
                            }
                            else {
                                alt14=45;}
                        }
                        else {
                            alt14=45;}
                    }
                    else {
                        alt14=45;}
                }
                else {
                    alt14=45;}
            }
            else {
                alt14=45;}
            }
            break;
        case 'T':
            {
            int LA14_16 = input.LA(2);

            if ( (LA14_16=='Y') ) {
                int LA14_55 = input.LA(3);

                if ( (LA14_55=='P') ) {
                    int LA14_85 = input.LA(4);

                    if ( (LA14_85=='E') ) {
                        int LA14_103 = input.LA(5);

                        if ( ((LA14_103>='A' && LA14_103<='Z')||LA14_103=='_'||(LA14_103>='a' && LA14_103<='z')) ) {
                            alt14=45;
                        }
                        else {
                            alt14=19;}
                    }
                    else {
                        alt14=45;}
                }
                else {
                    alt14=45;}
            }
            else {
                alt14=45;}
            }
            break;
        case 'V':
            {
            int LA14_17 = input.LA(2);

            if ( (LA14_17=='A') ) {
                int LA14_56 = input.LA(3);

                if ( (LA14_56=='L') ) {
                    int LA14_86 = input.LA(4);

                    if ( (LA14_86=='U') ) {
                        int LA14_104 = input.LA(5);

                        if ( (LA14_104=='E') ) {
                            int LA14_119 = input.LA(6);

                            if ( ((LA14_119>='A' && LA14_119<='Z')||LA14_119=='_'||(LA14_119>='a' && LA14_119<='z')) ) {
                                alt14=45;
                            }
                            else {
                                alt14=20;}
                        }
                        else {
                            alt14=45;}
                    }
                    else {
                        alt14=45;}
                }
                else {
                    alt14=45;}
            }
            else {
                alt14=45;}
            }
            break;
        case '+':
            {
            alt14=22;
            }
            break;
        case '-':
            {
            int LA14_19 = input.LA(2);

            if ( ((LA14_19>='0' && LA14_19<='9')) ) {
                alt14=37;
            }
            else {
                alt14=23;}
            }
            break;
        case '*':
            {
            alt14=24;
            }
            break;
        case '/':
            {
            switch ( input.LA(2) ) {
            case '/':
                {
                alt14=48;
                }
                break;
            case '*':
                {
                alt14=47;
                }
                break;
            default:
                alt14=25;}

            }
            break;
        case '%':
            {
            alt14=26;
            }
            break;
        case '^':
            {
            alt14=27;
            }
            break;
        case '(':
            {
            alt14=28;
            }
            break;
        case ')':
            {
            alt14=29;
            }
            break;
        case ';':
            {
            alt14=30;
            }
            break;
        case ',':
            {
            alt14=31;
            }
            break;
        case '=':
            {
            int LA14_28 = input.LA(2);

            if ( (LA14_28=='=') ) {
                alt14=34;
            }
            else {
                alt14=32;}
            }
            break;
        case 'o':
            {
            int LA14_29 = input.LA(2);

            if ( (LA14_29=='r') ) {
                int LA14_63 = input.LA(3);

                if ( (LA14_63=='d') ) {
                    int LA14_87 = input.LA(4);

                    if ( (LA14_87=='e') ) {
                        int LA14_105 = input.LA(5);

                        if ( (LA14_105=='r') ) {
                            int LA14_120 = input.LA(6);

                            if ( (LA14_120=='e') ) {
                                int LA14_132 = input.LA(7);

                                if ( (LA14_132=='d') ) {
                                    int LA14_141 = input.LA(8);

                                    if ( ((LA14_141>='A' && LA14_141<='Z')||LA14_141=='_'||(LA14_141>='a' && LA14_141<='z')) ) {
                                        alt14=45;
                                    }
                                    else {
                                        alt14=33;}
                                }
                                else {
                                    alt14=45;}
                            }
                            else {
                                alt14=45;}
                        }
                        else {
                            alt14=45;}
                    }
                    else {
                        alt14=45;}
                }
                else {
                    alt14=45;}
            }
            else {
                alt14=45;}
            }
            break;
        case '[':
            {
            alt14=35;
            }
            break;
        case ']':
            {
            alt14=36;
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
            alt14=37;
            }
            break;
        case '<':
            {
            switch ( input.LA(2) ) {
            case '=':
                {
                alt14=42;
                }
                break;
            case '>':
                {
                alt14=38;
                }
                break;
            default:
                alt14=40;}

            }
            break;
        case '>':
            {
            int LA14_34 = input.LA(2);

            if ( (LA14_34=='=') ) {
                alt14=41;
            }
            else {
                alt14=39;}
            }
            break;
        case '.':
            {
            alt14=44;
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
            alt14=45;
            }
            break;
        case '\t':
        case '\n':
        case '\f':
        case '\r':
        case ' ':
            {
            alt14=46;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T53 | T54 | OR | XOR | AND | NOT | INTPMF | DOUBLEPMF | ENUMPMF | DOUBLEPDF | BOOLPMF | UNIT | BOOL | FALSE | TRUE | BYTESIZE | STRUCTURE | NUMBER_OF_ELEMENTS | TYPE | VALUE | INNER | PLUS | MINUS | MUL | DIV | MOD | POW | LPAREN | RPAREN | SEMI | COLON | DEFINITION | ORDERED_DEF | EQUAL | SQUARE_PAREN_L | SQUARE_PAREN_R | NUMBER | NOTEQUAL | GREATER | LESS | GREATEREQUAL | LESSEQUAL | STRING_LITERAL | DOT | ID | WS | COMMENT | LINE_COMMENT );", 14, 0, input);

            throw nvae;
        }

        switch (alt14) {
            case 1 :
                // PCMStoEx.g:1:10: T53
                {
                mT53(); 

                }
                break;
            case 2 :
                // PCMStoEx.g:1:14: T54
                {
                mT54(); 

                }
                break;
            case 3 :
                // PCMStoEx.g:1:18: OR
                {
                mOR(); 

                }
                break;
            case 4 :
                // PCMStoEx.g:1:21: XOR
                {
                mXOR(); 

                }
                break;
            case 5 :
                // PCMStoEx.g:1:25: AND
                {
                mAND(); 

                }
                break;
            case 6 :
                // PCMStoEx.g:1:29: NOT
                {
                mNOT(); 

                }
                break;
            case 7 :
                // PCMStoEx.g:1:33: INTPMF
                {
                mINTPMF(); 

                }
                break;
            case 8 :
                // PCMStoEx.g:1:40: DOUBLEPMF
                {
                mDOUBLEPMF(); 

                }
                break;
            case 9 :
                // PCMStoEx.g:1:50: ENUMPMF
                {
                mENUMPMF(); 

                }
                break;
            case 10 :
                // PCMStoEx.g:1:58: DOUBLEPDF
                {
                mDOUBLEPDF(); 

                }
                break;
            case 11 :
                // PCMStoEx.g:1:68: BOOLPMF
                {
                mBOOLPMF(); 

                }
                break;
            case 12 :
                // PCMStoEx.g:1:76: UNIT
                {
                mUNIT(); 

                }
                break;
            case 13 :
                // PCMStoEx.g:1:81: BOOL
                {
                mBOOL(); 

                }
                break;
            case 14 :
                // PCMStoEx.g:1:86: FALSE
                {
                mFALSE(); 

                }
                break;
            case 15 :
                // PCMStoEx.g:1:92: TRUE
                {
                mTRUE(); 

                }
                break;
            case 16 :
                // PCMStoEx.g:1:97: BYTESIZE
                {
                mBYTESIZE(); 

                }
                break;
            case 17 :
                // PCMStoEx.g:1:106: STRUCTURE
                {
                mSTRUCTURE(); 

                }
                break;
            case 18 :
                // PCMStoEx.g:1:116: NUMBER_OF_ELEMENTS
                {
                mNUMBER_OF_ELEMENTS(); 

                }
                break;
            case 19 :
                // PCMStoEx.g:1:135: TYPE
                {
                mTYPE(); 

                }
                break;
            case 20 :
                // PCMStoEx.g:1:140: VALUE
                {
                mVALUE(); 

                }
                break;
            case 21 :
                // PCMStoEx.g:1:146: INNER
                {
                mINNER(); 

                }
                break;
            case 22 :
                // PCMStoEx.g:1:152: PLUS
                {
                mPLUS(); 

                }
                break;
            case 23 :
                // PCMStoEx.g:1:157: MINUS
                {
                mMINUS(); 

                }
                break;
            case 24 :
                // PCMStoEx.g:1:163: MUL
                {
                mMUL(); 

                }
                break;
            case 25 :
                // PCMStoEx.g:1:167: DIV
                {
                mDIV(); 

                }
                break;
            case 26 :
                // PCMStoEx.g:1:171: MOD
                {
                mMOD(); 

                }
                break;
            case 27 :
                // PCMStoEx.g:1:175: POW
                {
                mPOW(); 

                }
                break;
            case 28 :
                // PCMStoEx.g:1:179: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 29 :
                // PCMStoEx.g:1:186: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 30 :
                // PCMStoEx.g:1:193: SEMI
                {
                mSEMI(); 

                }
                break;
            case 31 :
                // PCMStoEx.g:1:198: COLON
                {
                mCOLON(); 

                }
                break;
            case 32 :
                // PCMStoEx.g:1:204: DEFINITION
                {
                mDEFINITION(); 

                }
                break;
            case 33 :
                // PCMStoEx.g:1:215: ORDERED_DEF
                {
                mORDERED_DEF(); 

                }
                break;
            case 34 :
                // PCMStoEx.g:1:227: EQUAL
                {
                mEQUAL(); 

                }
                break;
            case 35 :
                // PCMStoEx.g:1:233: SQUARE_PAREN_L
                {
                mSQUARE_PAREN_L(); 

                }
                break;
            case 36 :
                // PCMStoEx.g:1:248: SQUARE_PAREN_R
                {
                mSQUARE_PAREN_R(); 

                }
                break;
            case 37 :
                // PCMStoEx.g:1:263: NUMBER
                {
                mNUMBER(); 

                }
                break;
            case 38 :
                // PCMStoEx.g:1:270: NOTEQUAL
                {
                mNOTEQUAL(); 

                }
                break;
            case 39 :
                // PCMStoEx.g:1:279: GREATER
                {
                mGREATER(); 

                }
                break;
            case 40 :
                // PCMStoEx.g:1:287: LESS
                {
                mLESS(); 

                }
                break;
            case 41 :
                // PCMStoEx.g:1:292: GREATEREQUAL
                {
                mGREATEREQUAL(); 

                }
                break;
            case 42 :
                // PCMStoEx.g:1:305: LESSEQUAL
                {
                mLESSEQUAL(); 

                }
                break;
            case 43 :
                // PCMStoEx.g:1:315: STRING_LITERAL
                {
                mSTRING_LITERAL(); 

                }
                break;
            case 44 :
                // PCMStoEx.g:1:330: DOT
                {
                mDOT(); 

                }
                break;
            case 45 :
                // PCMStoEx.g:1:334: ID
                {
                mID(); 

                }
                break;
            case 46 :
                // PCMStoEx.g:1:337: WS
                {
                mWS(); 

                }
                break;
            case 47 :
                // PCMStoEx.g:1:340: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 48 :
                // PCMStoEx.g:1:348: LINE_COMMENT
                {
                mLINE_COMMENT(); 

                }
                break;

        }

    }


 

}
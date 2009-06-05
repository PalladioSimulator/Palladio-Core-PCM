package de.uka.ipd.sdq.stoex.parser;

// $ANTLR 3.0 C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g 2007-06-14 08:31:48

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
 
public class StochasticExpressionsLexer extends Lexer {
    public static final int MOD=14;
    public static final int GREATEREQUAL=8;
    public static final int Exponent=28;
    public static final int ID=25;
    public static final int EOF=-1;
    public static final int LPAREN=18;
    public static final int NOTEQUAL=7;
    public static final int RPAREN=19;
    public static final int GREATER=4;
    public static final int STRING_LITERAL=17;
    public static final int POW=15;
    public static final int EQUAL=6;
    public static final int LESS=5;
    public static final int DEFINITION=24;
    public static final int PLUS=10;
    public static final int T38=38;
    public static final int T37=37;
    public static final int DIGIT=27;
    public static final int T39=39;
    public static final int COMMENT=31;
    public static final int DOT=26;
    public static final int T34=34;
    public static final int T33=33;
    public static final int T36=36;
    public static final int T35=35;
    public static final int LINE_COMMENT=32;
    public static final int NUMBER=16;
    public static final int T49=49;
    public static final int T48=48;
    public static final int MINUS=11;
    public static final int T43=43;
    public static final int Tokens=52;
    public static final int T42=42;
    public static final int MUL=12;
    public static final int SEMI=22;
    public static final int T41=41;
    public static final int T40=40;
    public static final int T47=47;
    public static final int T46=46;
    public static final int ALPHA=29;
    public static final int T45=45;
    public static final int T44=44;
    public static final int SQUARE_PAREN_R=21;
    public static final int WS=30;
    public static final int T50=50;
    public static final int SQUARE_PAREN_L=20;
    public static final int DIV=13;
    public static final int ORDERED_DEF=23;
    public static final int T51=51;
    public static final int LESSEQUAL=9;
    public StochasticExpressionsLexer() {;} 
    public StochasticExpressionsLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g"; }

    // $ANTLR start T33
    public final void mT33() throws RecognitionException {
        try {
            int _type = T33;
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:3:7: ( 'OR' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:3:7: 'OR'
            {
            match("OR"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T33

    // $ANTLR start T34
    public final void mT34() throws RecognitionException {
        try {
            int _type = T34;
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:4:7: ( 'XOR' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:4:7: 'XOR'
            {
            match("XOR"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T34

    // $ANTLR start T35
    public final void mT35() throws RecognitionException {
        try {
            int _type = T35;
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:5:7: ( 'AND' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:5:7: 'AND'
            {
            match("AND"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T35

    // $ANTLR start T36
    public final void mT36() throws RecognitionException {
        try {
            int _type = T36;
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:6:7: ( 'NOT' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:6:7: 'NOT'
            {
            match("NOT"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T36

    // $ANTLR start T37
    public final void mT37() throws RecognitionException {
        try {
            int _type = T37;
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:7:7: ( 'IntPMF' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:7:7: 'IntPMF'
            {
            match("IntPMF"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T37

    // $ANTLR start T38
    public final void mT38() throws RecognitionException {
        try {
            int _type = T38;
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:8:7: ( 'DoublePMF' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:8:7: 'DoublePMF'
            {
            match("DoublePMF"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T38

    // $ANTLR start T39
    public final void mT39() throws RecognitionException {
        try {
            int _type = T39;
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:9:7: ( 'EnumPMF' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:9:7: 'EnumPMF'
            {
            match("EnumPMF"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T39

    // $ANTLR start T40
    public final void mT40() throws RecognitionException {
        try {
            int _type = T40;
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:10:7: ( 'DoublePDF' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:10:7: 'DoublePDF'
            {
            match("DoublePDF"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T40

    // $ANTLR start T41
    public final void mT41() throws RecognitionException {
        try {
            int _type = T41;
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:11:7: ( 'BoolPMF' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:11:7: 'BoolPMF'
            {
            match("BoolPMF"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T41

    // $ANTLR start T42
    public final void mT42() throws RecognitionException {
        try {
            int _type = T42;
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:12:7: ( 'unit' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:12:7: 'unit'
            {
            match("unit"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T42

    // $ANTLR start T43
    public final void mT43() throws RecognitionException {
        try {
            int _type = T43;
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:13:7: ( '\"bool\"' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:13:7: '\"bool\"'
            {
            match("\"bool\""); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T43

    // $ANTLR start T44
    public final void mT44() throws RecognitionException {
        try {
            int _type = T44;
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:14:7: ( 'false' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:14:7: 'false'
            {
            match("false"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T44

    // $ANTLR start T45
    public final void mT45() throws RecognitionException {
        try {
            int _type = T45;
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:15:7: ( 'true' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:15:7: 'true'
            {
            match("true"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T45

    // $ANTLR start T46
    public final void mT46() throws RecognitionException {
        try {
            int _type = T46;
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:16:7: ( 'BYTESIZE' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:16:7: 'BYTESIZE'
            {
            match("BYTESIZE"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T46

    // $ANTLR start T47
    public final void mT47() throws RecognitionException {
        try {
            int _type = T47;
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:17:7: ( 'STRUCTURE' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:17:7: 'STRUCTURE'
            {
            match("STRUCTURE"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T47

    // $ANTLR start T48
    public final void mT48() throws RecognitionException {
        try {
            int _type = T48;
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:18:7: ( 'NUMBER_OF_ELEMENTS' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:18:7: 'NUMBER_OF_ELEMENTS'
            {
            match("NUMBER_OF_ELEMENTS"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T48

    // $ANTLR start T49
    public final void mT49() throws RecognitionException {
        try {
            int _type = T49;
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:19:7: ( 'TYPE' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:19:7: 'TYPE'
            {
            match("TYPE"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T49

    // $ANTLR start T50
    public final void mT50() throws RecognitionException {
        try {
            int _type = T50;
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:20:7: ( 'VALUE' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:20:7: 'VALUE'
            {
            match("VALUE"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T50

    // $ANTLR start T51
    public final void mT51() throws RecognitionException {
        try {
            int _type = T51;
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:21:7: ( 'INNER' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:21:7: 'INNER'
            {
            match("INNER"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T51

    // $ANTLR start PLUS
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:364:9: ( '+' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:364:9: '+'
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
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:365:9: ( '-' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:365:9: '-'
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
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:366:9: ( '*' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:366:9: '*'
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
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:367:9: ( '/' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:367:9: '/'
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
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:368:9: ( '%' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:368:9: '%'
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
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:369:9: ( '^' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:369:9: '^'
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
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:370:9: ( '(' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:370:9: '('
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
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:371:9: ( ')' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:371:9: ')'
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
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:372:9: ( ';' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:372:9: ';'
            {
            match(';'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SEMI

    // $ANTLR start DEFINITION
    public final void mDEFINITION() throws RecognitionException {
        try {
            int _type = DEFINITION;
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:373:14: ( '=' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:373:14: '='
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
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:375:4: ( 'ordered' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:375:4: 'ordered'
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
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:376:9: ( '==' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:376:9: '=='
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
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:377:18: ( '[' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:377:18: '['
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
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:378:18: ( ']' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:378:18: ']'
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
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:379:18: ( '0' .. '9' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:379:18: '0' .. '9'
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
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:380:10: ( ( DIGIT )+ ( '.' ( DIGIT )+ )? ( Exponent )? )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:380:10: ( DIGIT )+ ( '.' ( DIGIT )+ )? ( Exponent )?
            {
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:380:10: ( DIGIT )+
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
            	    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:380:11: DIGIT
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

            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:380:19: ( '.' ( DIGIT )+ )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='.') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:380:20: '.' ( DIGIT )+
                    {
                    match('.'); 
                    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:380:24: ( DIGIT )+
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
                    	    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:380:25: DIGIT
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

            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:380:35: ( Exponent )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='E'||LA4_0=='e') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:380:35: Exponent
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
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:382:12: ( ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+ )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:382:12: ( 'e' | 'E' ) ( '+' | '-' )? ( '0' .. '9' )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:382:22: ( '+' | '-' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='+'||LA5_0=='-') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:
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

            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:382:33: ( '0' .. '9' )+
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
            	    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:382:34: '0' .. '9'
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
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:383:18: ( 'a' .. 'z' | 'A' .. 'Z' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:
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
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:384:12: ( '<>' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:384:12: '<>'
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
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:385:11: ( '>' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:385:11: '>'
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
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:386:8: ( '<' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:386:8: '<'
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
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:387:16: ( '>=' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:387:16: '>='
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
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:388:13: ( '<=' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:388:13: '<='
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
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:389:18: ( '\\\"' ( ALPHA | '_' )+ '\\\"' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:389:18: '\\\"' ( ALPHA | '_' )+ '\\\"'
            {
            match('\"'); 
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:389:23: ( ALPHA | '_' )+
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
            	    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:
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
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:390:6: ( '.' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:390:6: '.'
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
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:391:38: ( ( ALPHA | '_' )+ )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:391:38: ( ALPHA | '_' )+
            {
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:391:38: ( ALPHA | '_' )+
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
            	    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:
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
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:394:8: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:394:8: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
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
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:398:9: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:398:9: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:398:14: ( options {greedy=false; } : . )*
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
            	    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:398:42: .
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
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:402:7: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:402:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 

            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:402:12: (~ ( '\\n' | '\\r' ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\u0000' && LA10_0<='\t')||(LA10_0>='\u000B' && LA10_0<='\f')||(LA10_0>='\u000E' && LA10_0<='\uFFFE')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:402:12: ~ ( '\\n' | '\\r' )
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

            // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:402:26: ( '\\r' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\r') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:402:26: '\\r'
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
        // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:10: ( T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | PLUS | MINUS | MUL | DIV | MOD | POW | LPAREN | RPAREN | SEMI | DEFINITION | ORDERED_DEF | EQUAL | SQUARE_PAREN_L | SQUARE_PAREN_R | NUMBER | NOTEQUAL | GREATER | LESS | GREATEREQUAL | LESSEQUAL | STRING_LITERAL | DOT | ID | WS | COMMENT | LINE_COMMENT )
        int alt12=45;
        switch ( input.LA(1) ) {
        case 'O':
            {
            int LA12_1 = input.LA(2);

            if ( (LA12_1=='R') ) {
                int LA12_35 = input.LA(3);

                if ( ((LA12_35>='A' && LA12_35<='Z')||LA12_35=='_'||(LA12_35>='a' && LA12_35<='z')) ) {
                    alt12=42;
                }
                else {
                    alt12=1;}
            }
            else {
                alt12=42;}
            }
            break;
        case 'X':
            {
            int LA12_2 = input.LA(2);

            if ( (LA12_2=='O') ) {
                int LA12_36 = input.LA(3);

                if ( (LA12_36=='R') ) {
                    int LA12_66 = input.LA(4);

                    if ( ((LA12_66>='A' && LA12_66<='Z')||LA12_66=='_'||(LA12_66>='a' && LA12_66<='z')) ) {
                        alt12=42;
                    }
                    else {
                        alt12=2;}
                }
                else {
                    alt12=42;}
            }
            else {
                alt12=42;}
            }
            break;
        case 'A':
            {
            int LA12_3 = input.LA(2);

            if ( (LA12_3=='N') ) {
                int LA12_37 = input.LA(3);

                if ( (LA12_37=='D') ) {
                    int LA12_67 = input.LA(4);

                    if ( ((LA12_67>='A' && LA12_67<='Z')||LA12_67=='_'||(LA12_67>='a' && LA12_67<='z')) ) {
                        alt12=42;
                    }
                    else {
                        alt12=3;}
                }
                else {
                    alt12=42;}
            }
            else {
                alt12=42;}
            }
            break;
        case 'N':
            {
            switch ( input.LA(2) ) {
            case 'O':
                {
                int LA12_38 = input.LA(3);

                if ( (LA12_38=='T') ) {
                    int LA12_68 = input.LA(4);

                    if ( ((LA12_68>='A' && LA12_68<='Z')||LA12_68=='_'||(LA12_68>='a' && LA12_68<='z')) ) {
                        alt12=42;
                    }
                    else {
                        alt12=4;}
                }
                else {
                    alt12=42;}
                }
                break;
            case 'U':
                {
                int LA12_39 = input.LA(3);

                if ( (LA12_39=='M') ) {
                    int LA12_69 = input.LA(4);

                    if ( (LA12_69=='B') ) {
                        int LA12_87 = input.LA(5);

                        if ( (LA12_87=='E') ) {
                            int LA12_102 = input.LA(6);

                            if ( (LA12_102=='R') ) {
                                int LA12_117 = input.LA(7);

                                if ( (LA12_117=='_') ) {
                                    int LA12_129 = input.LA(8);

                                    if ( (LA12_129=='O') ) {
                                        int LA12_138 = input.LA(9);

                                        if ( (LA12_138=='F') ) {
                                            int LA12_146 = input.LA(10);

                                            if ( (LA12_146=='_') ) {
                                                int LA12_151 = input.LA(11);

                                                if ( (LA12_151=='E') ) {
                                                    int LA12_155 = input.LA(12);

                                                    if ( (LA12_155=='L') ) {
                                                        int LA12_156 = input.LA(13);

                                                        if ( (LA12_156=='E') ) {
                                                            int LA12_157 = input.LA(14);

                                                            if ( (LA12_157=='M') ) {
                                                                int LA12_158 = input.LA(15);

                                                                if ( (LA12_158=='E') ) {
                                                                    int LA12_159 = input.LA(16);

                                                                    if ( (LA12_159=='N') ) {
                                                                        int LA12_160 = input.LA(17);

                                                                        if ( (LA12_160=='T') ) {
                                                                            int LA12_161 = input.LA(18);

                                                                            if ( (LA12_161=='S') ) {
                                                                                int LA12_162 = input.LA(19);

                                                                                if ( ((LA12_162>='A' && LA12_162<='Z')||LA12_162=='_'||(LA12_162>='a' && LA12_162<='z')) ) {
                                                                                    alt12=42;
                                                                                }
                                                                                else {
                                                                                    alt12=16;}
                                                                            }
                                                                            else {
                                                                                alt12=42;}
                                                                        }
                                                                        else {
                                                                            alt12=42;}
                                                                    }
                                                                    else {
                                                                        alt12=42;}
                                                                }
                                                                else {
                                                                    alt12=42;}
                                                            }
                                                            else {
                                                                alt12=42;}
                                                        }
                                                        else {
                                                            alt12=42;}
                                                    }
                                                    else {
                                                        alt12=42;}
                                                }
                                                else {
                                                    alt12=42;}
                                            }
                                            else {
                                                alt12=42;}
                                        }
                                        else {
                                            alt12=42;}
                                    }
                                    else {
                                        alt12=42;}
                                }
                                else {
                                    alt12=42;}
                            }
                            else {
                                alt12=42;}
                        }
                        else {
                            alt12=42;}
                    }
                    else {
                        alt12=42;}
                }
                else {
                    alt12=42;}
                }
                break;
            default:
                alt12=42;}

            }
            break;
        case 'I':
            {
            switch ( input.LA(2) ) {
            case 'n':
                {
                int LA12_40 = input.LA(3);

                if ( (LA12_40=='t') ) {
                    int LA12_70 = input.LA(4);

                    if ( (LA12_70=='P') ) {
                        int LA12_88 = input.LA(5);

                        if ( (LA12_88=='M') ) {
                            int LA12_103 = input.LA(6);

                            if ( (LA12_103=='F') ) {
                                int LA12_118 = input.LA(7);

                                if ( ((LA12_118>='A' && LA12_118<='Z')||LA12_118=='_'||(LA12_118>='a' && LA12_118<='z')) ) {
                                    alt12=42;
                                }
                                else {
                                    alt12=5;}
                            }
                            else {
                                alt12=42;}
                        }
                        else {
                            alt12=42;}
                    }
                    else {
                        alt12=42;}
                }
                else {
                    alt12=42;}
                }
                break;
            case 'N':
                {
                int LA12_41 = input.LA(3);

                if ( (LA12_41=='N') ) {
                    int LA12_71 = input.LA(4);

                    if ( (LA12_71=='E') ) {
                        int LA12_89 = input.LA(5);

                        if ( (LA12_89=='R') ) {
                            int LA12_104 = input.LA(6);

                            if ( ((LA12_104>='A' && LA12_104<='Z')||LA12_104=='_'||(LA12_104>='a' && LA12_104<='z')) ) {
                                alt12=42;
                            }
                            else {
                                alt12=19;}
                        }
                        else {
                            alt12=42;}
                    }
                    else {
                        alt12=42;}
                }
                else {
                    alt12=42;}
                }
                break;
            default:
                alt12=42;}

            }
            break;
        case 'D':
            {
            int LA12_6 = input.LA(2);

            if ( (LA12_6=='o') ) {
                int LA12_42 = input.LA(3);

                if ( (LA12_42=='u') ) {
                    int LA12_72 = input.LA(4);

                    if ( (LA12_72=='b') ) {
                        int LA12_90 = input.LA(5);

                        if ( (LA12_90=='l') ) {
                            int LA12_105 = input.LA(6);

                            if ( (LA12_105=='e') ) {
                                int LA12_120 = input.LA(7);

                                if ( (LA12_120=='P') ) {
                                    switch ( input.LA(8) ) {
                                    case 'M':
                                        {
                                        int LA12_139 = input.LA(9);

                                        if ( (LA12_139=='F') ) {
                                            int LA12_147 = input.LA(10);

                                            if ( ((LA12_147>='A' && LA12_147<='Z')||LA12_147=='_'||(LA12_147>='a' && LA12_147<='z')) ) {
                                                alt12=42;
                                            }
                                            else {
                                                alt12=6;}
                                        }
                                        else {
                                            alt12=42;}
                                        }
                                        break;
                                    case 'D':
                                        {
                                        int LA12_140 = input.LA(9);

                                        if ( (LA12_140=='F') ) {
                                            int LA12_148 = input.LA(10);

                                            if ( ((LA12_148>='A' && LA12_148<='Z')||LA12_148=='_'||(LA12_148>='a' && LA12_148<='z')) ) {
                                                alt12=42;
                                            }
                                            else {
                                                alt12=8;}
                                        }
                                        else {
                                            alt12=42;}
                                        }
                                        break;
                                    default:
                                        alt12=42;}

                                }
                                else {
                                    alt12=42;}
                            }
                            else {
                                alt12=42;}
                        }
                        else {
                            alt12=42;}
                    }
                    else {
                        alt12=42;}
                }
                else {
                    alt12=42;}
            }
            else {
                alt12=42;}
            }
            break;
        case 'E':
            {
            int LA12_7 = input.LA(2);

            if ( (LA12_7=='n') ) {
                int LA12_43 = input.LA(3);

                if ( (LA12_43=='u') ) {
                    int LA12_73 = input.LA(4);

                    if ( (LA12_73=='m') ) {
                        int LA12_91 = input.LA(5);

                        if ( (LA12_91=='P') ) {
                            int LA12_106 = input.LA(6);

                            if ( (LA12_106=='M') ) {
                                int LA12_121 = input.LA(7);

                                if ( (LA12_121=='F') ) {
                                    int LA12_132 = input.LA(8);

                                    if ( ((LA12_132>='A' && LA12_132<='Z')||LA12_132=='_'||(LA12_132>='a' && LA12_132<='z')) ) {
                                        alt12=42;
                                    }
                                    else {
                                        alt12=7;}
                                }
                                else {
                                    alt12=42;}
                            }
                            else {
                                alt12=42;}
                        }
                        else {
                            alt12=42;}
                    }
                    else {
                        alt12=42;}
                }
                else {
                    alt12=42;}
            }
            else {
                alt12=42;}
            }
            break;
        case 'B':
            {
            switch ( input.LA(2) ) {
            case 'o':
                {
                int LA12_44 = input.LA(3);

                if ( (LA12_44=='o') ) {
                    int LA12_74 = input.LA(4);

                    if ( (LA12_74=='l') ) {
                        int LA12_92 = input.LA(5);

                        if ( (LA12_92=='P') ) {
                            int LA12_107 = input.LA(6);

                            if ( (LA12_107=='M') ) {
                                int LA12_122 = input.LA(7);

                                if ( (LA12_122=='F') ) {
                                    int LA12_133 = input.LA(8);

                                    if ( ((LA12_133>='A' && LA12_133<='Z')||LA12_133=='_'||(LA12_133>='a' && LA12_133<='z')) ) {
                                        alt12=42;
                                    }
                                    else {
                                        alt12=9;}
                                }
                                else {
                                    alt12=42;}
                            }
                            else {
                                alt12=42;}
                        }
                        else {
                            alt12=42;}
                    }
                    else {
                        alt12=42;}
                }
                else {
                    alt12=42;}
                }
                break;
            case 'Y':
                {
                int LA12_45 = input.LA(3);

                if ( (LA12_45=='T') ) {
                    int LA12_75 = input.LA(4);

                    if ( (LA12_75=='E') ) {
                        int LA12_93 = input.LA(5);

                        if ( (LA12_93=='S') ) {
                            int LA12_108 = input.LA(6);

                            if ( (LA12_108=='I') ) {
                                int LA12_123 = input.LA(7);

                                if ( (LA12_123=='Z') ) {
                                    int LA12_134 = input.LA(8);

                                    if ( (LA12_134=='E') ) {
                                        int LA12_143 = input.LA(9);

                                        if ( ((LA12_143>='A' && LA12_143<='Z')||LA12_143=='_'||(LA12_143>='a' && LA12_143<='z')) ) {
                                            alt12=42;
                                        }
                                        else {
                                            alt12=14;}
                                    }
                                    else {
                                        alt12=42;}
                                }
                                else {
                                    alt12=42;}
                            }
                            else {
                                alt12=42;}
                        }
                        else {
                            alt12=42;}
                    }
                    else {
                        alt12=42;}
                }
                else {
                    alt12=42;}
                }
                break;
            default:
                alt12=42;}

            }
            break;
        case 'u':
            {
            int LA12_9 = input.LA(2);

            if ( (LA12_9=='n') ) {
                int LA12_46 = input.LA(3);

                if ( (LA12_46=='i') ) {
                    int LA12_76 = input.LA(4);

                    if ( (LA12_76=='t') ) {
                        int LA12_94 = input.LA(5);

                        if ( ((LA12_94>='A' && LA12_94<='Z')||LA12_94=='_'||(LA12_94>='a' && LA12_94<='z')) ) {
                            alt12=42;
                        }
                        else {
                            alt12=10;}
                    }
                    else {
                        alt12=42;}
                }
                else {
                    alt12=42;}
            }
            else {
                alt12=42;}
            }
            break;
        case '\"':
            {
            int LA12_10 = input.LA(2);

            if ( (LA12_10=='b') ) {
                int LA12_47 = input.LA(3);

                if ( (LA12_47=='o') ) {
                    int LA12_77 = input.LA(4);

                    if ( (LA12_77=='o') ) {
                        int LA12_95 = input.LA(5);

                        if ( (LA12_95=='l') ) {
                            int LA12_110 = input.LA(6);

                            if ( (LA12_110=='\"') ) {
                                alt12=11;
                            }
                            else if ( ((LA12_110>='A' && LA12_110<='Z')||LA12_110=='_'||(LA12_110>='a' && LA12_110<='z')) ) {
                                alt12=40;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("1:1: Tokens : ( T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | PLUS | MINUS | MUL | DIV | MOD | POW | LPAREN | RPAREN | SEMI | DEFINITION | ORDERED_DEF | EQUAL | SQUARE_PAREN_L | SQUARE_PAREN_R | NUMBER | NOTEQUAL | GREATER | LESS | GREATEREQUAL | LESSEQUAL | STRING_LITERAL | DOT | ID | WS | COMMENT | LINE_COMMENT );", 12, 110, input);

                                throw nvae;
                            }
                        }
                        else if ( (LA12_95=='\"'||(LA12_95>='A' && LA12_95<='Z')||LA12_95=='_'||(LA12_95>='a' && LA12_95<='k')||(LA12_95>='m' && LA12_95<='z')) ) {
                            alt12=40;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("1:1: Tokens : ( T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | PLUS | MINUS | MUL | DIV | MOD | POW | LPAREN | RPAREN | SEMI | DEFINITION | ORDERED_DEF | EQUAL | SQUARE_PAREN_L | SQUARE_PAREN_R | NUMBER | NOTEQUAL | GREATER | LESS | GREATEREQUAL | LESSEQUAL | STRING_LITERAL | DOT | ID | WS | COMMENT | LINE_COMMENT );", 12, 95, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA12_77=='\"'||(LA12_77>='A' && LA12_77<='Z')||LA12_77=='_'||(LA12_77>='a' && LA12_77<='n')||(LA12_77>='p' && LA12_77<='z')) ) {
                        alt12=40;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("1:1: Tokens : ( T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | PLUS | MINUS | MUL | DIV | MOD | POW | LPAREN | RPAREN | SEMI | DEFINITION | ORDERED_DEF | EQUAL | SQUARE_PAREN_L | SQUARE_PAREN_R | NUMBER | NOTEQUAL | GREATER | LESS | GREATEREQUAL | LESSEQUAL | STRING_LITERAL | DOT | ID | WS | COMMENT | LINE_COMMENT );", 12, 77, input);

                        throw nvae;
                    }
                }
                else if ( (LA12_47=='\"'||(LA12_47>='A' && LA12_47<='Z')||LA12_47=='_'||(LA12_47>='a' && LA12_47<='n')||(LA12_47>='p' && LA12_47<='z')) ) {
                    alt12=40;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("1:1: Tokens : ( T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | PLUS | MINUS | MUL | DIV | MOD | POW | LPAREN | RPAREN | SEMI | DEFINITION | ORDERED_DEF | EQUAL | SQUARE_PAREN_L | SQUARE_PAREN_R | NUMBER | NOTEQUAL | GREATER | LESS | GREATEREQUAL | LESSEQUAL | STRING_LITERAL | DOT | ID | WS | COMMENT | LINE_COMMENT );", 12, 47, input);

                    throw nvae;
                }
            }
            else if ( ((LA12_10>='A' && LA12_10<='Z')||LA12_10=='_'||LA12_10=='a'||(LA12_10>='c' && LA12_10<='z')) ) {
                alt12=40;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1:1: Tokens : ( T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | PLUS | MINUS | MUL | DIV | MOD | POW | LPAREN | RPAREN | SEMI | DEFINITION | ORDERED_DEF | EQUAL | SQUARE_PAREN_L | SQUARE_PAREN_R | NUMBER | NOTEQUAL | GREATER | LESS | GREATEREQUAL | LESSEQUAL | STRING_LITERAL | DOT | ID | WS | COMMENT | LINE_COMMENT );", 12, 10, input);

                throw nvae;
            }
            }
            break;
        case 'f':
            {
            int LA12_11 = input.LA(2);

            if ( (LA12_11=='a') ) {
                int LA12_49 = input.LA(3);

                if ( (LA12_49=='l') ) {
                    int LA12_78 = input.LA(4);

                    if ( (LA12_78=='s') ) {
                        int LA12_96 = input.LA(5);

                        if ( (LA12_96=='e') ) {
                            int LA12_111 = input.LA(6);

                            if ( ((LA12_111>='A' && LA12_111<='Z')||LA12_111=='_'||(LA12_111>='a' && LA12_111<='z')) ) {
                                alt12=42;
                            }
                            else {
                                alt12=12;}
                        }
                        else {
                            alt12=42;}
                    }
                    else {
                        alt12=42;}
                }
                else {
                    alt12=42;}
            }
            else {
                alt12=42;}
            }
            break;
        case 't':
            {
            int LA12_12 = input.LA(2);

            if ( (LA12_12=='r') ) {
                int LA12_50 = input.LA(3);

                if ( (LA12_50=='u') ) {
                    int LA12_79 = input.LA(4);

                    if ( (LA12_79=='e') ) {
                        int LA12_97 = input.LA(5);

                        if ( ((LA12_97>='A' && LA12_97<='Z')||LA12_97=='_'||(LA12_97>='a' && LA12_97<='z')) ) {
                            alt12=42;
                        }
                        else {
                            alt12=13;}
                    }
                    else {
                        alt12=42;}
                }
                else {
                    alt12=42;}
            }
            else {
                alt12=42;}
            }
            break;
        case 'S':
            {
            int LA12_13 = input.LA(2);

            if ( (LA12_13=='T') ) {
                int LA12_51 = input.LA(3);

                if ( (LA12_51=='R') ) {
                    int LA12_80 = input.LA(4);

                    if ( (LA12_80=='U') ) {
                        int LA12_98 = input.LA(5);

                        if ( (LA12_98=='C') ) {
                            int LA12_113 = input.LA(6);

                            if ( (LA12_113=='T') ) {
                                int LA12_126 = input.LA(7);

                                if ( (LA12_126=='U') ) {
                                    int LA12_136 = input.LA(8);

                                    if ( (LA12_136=='R') ) {
                                        int LA12_144 = input.LA(9);

                                        if ( (LA12_144=='E') ) {
                                            int LA12_150 = input.LA(10);

                                            if ( ((LA12_150>='A' && LA12_150<='Z')||LA12_150=='_'||(LA12_150>='a' && LA12_150<='z')) ) {
                                                alt12=42;
                                            }
                                            else {
                                                alt12=15;}
                                        }
                                        else {
                                            alt12=42;}
                                    }
                                    else {
                                        alt12=42;}
                                }
                                else {
                                    alt12=42;}
                            }
                            else {
                                alt12=42;}
                        }
                        else {
                            alt12=42;}
                    }
                    else {
                        alt12=42;}
                }
                else {
                    alt12=42;}
            }
            else {
                alt12=42;}
            }
            break;
        case 'T':
            {
            int LA12_14 = input.LA(2);

            if ( (LA12_14=='Y') ) {
                int LA12_52 = input.LA(3);

                if ( (LA12_52=='P') ) {
                    int LA12_81 = input.LA(4);

                    if ( (LA12_81=='E') ) {
                        int LA12_99 = input.LA(5);

                        if ( ((LA12_99>='A' && LA12_99<='Z')||LA12_99=='_'||(LA12_99>='a' && LA12_99<='z')) ) {
                            alt12=42;
                        }
                        else {
                            alt12=17;}
                    }
                    else {
                        alt12=42;}
                }
                else {
                    alt12=42;}
            }
            else {
                alt12=42;}
            }
            break;
        case 'V':
            {
            int LA12_15 = input.LA(2);

            if ( (LA12_15=='A') ) {
                int LA12_53 = input.LA(3);

                if ( (LA12_53=='L') ) {
                    int LA12_82 = input.LA(4);

                    if ( (LA12_82=='U') ) {
                        int LA12_100 = input.LA(5);

                        if ( (LA12_100=='E') ) {
                            int LA12_115 = input.LA(6);

                            if ( ((LA12_115>='A' && LA12_115<='Z')||LA12_115=='_'||(LA12_115>='a' && LA12_115<='z')) ) {
                                alt12=42;
                            }
                            else {
                                alt12=18;}
                        }
                        else {
                            alt12=42;}
                    }
                    else {
                        alt12=42;}
                }
                else {
                    alt12=42;}
            }
            else {
                alt12=42;}
            }
            break;
        case '+':
            {
            alt12=20;
            }
            break;
        case '-':
            {
            alt12=21;
            }
            break;
        case '*':
            {
            alt12=22;
            }
            break;
        case '/':
            {
            switch ( input.LA(2) ) {
            case '/':
                {
                alt12=45;
                }
                break;
            case '*':
                {
                alt12=44;
                }
                break;
            default:
                alt12=23;}

            }
            break;
        case '%':
            {
            alt12=24;
            }
            break;
        case '^':
            {
            alt12=25;
            }
            break;
        case '(':
            {
            alt12=26;
            }
            break;
        case ')':
            {
            alt12=27;
            }
            break;
        case ';':
            {
            alt12=28;
            }
            break;
        case '=':
            {
            int LA12_25 = input.LA(2);

            if ( (LA12_25=='=') ) {
                alt12=31;
            }
            else {
                alt12=29;}
            }
            break;
        case 'o':
            {
            int LA12_26 = input.LA(2);

            if ( (LA12_26=='r') ) {
                int LA12_59 = input.LA(3);

                if ( (LA12_59=='d') ) {
                    int LA12_83 = input.LA(4);

                    if ( (LA12_83=='e') ) {
                        int LA12_101 = input.LA(5);

                        if ( (LA12_101=='r') ) {
                            int LA12_116 = input.LA(6);

                            if ( (LA12_116=='e') ) {
                                int LA12_128 = input.LA(7);

                                if ( (LA12_128=='d') ) {
                                    int LA12_137 = input.LA(8);

                                    if ( ((LA12_137>='A' && LA12_137<='Z')||LA12_137=='_'||(LA12_137>='a' && LA12_137<='z')) ) {
                                        alt12=42;
                                    }
                                    else {
                                        alt12=30;}
                                }
                                else {
                                    alt12=42;}
                            }
                            else {
                                alt12=42;}
                        }
                        else {
                            alt12=42;}
                    }
                    else {
                        alt12=42;}
                }
                else {
                    alt12=42;}
            }
            else {
                alt12=42;}
            }
            break;
        case '[':
            {
            alt12=32;
            }
            break;
        case ']':
            {
            alt12=33;
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
            alt12=34;
            }
            break;
        case '<':
            {
            switch ( input.LA(2) ) {
            case '=':
                {
                alt12=39;
                }
                break;
            case '>':
                {
                alt12=35;
                }
                break;
            default:
                alt12=37;}

            }
            break;
        case '>':
            {
            int LA12_31 = input.LA(2);

            if ( (LA12_31=='=') ) {
                alt12=38;
            }
            else {
                alt12=36;}
            }
            break;
        case '.':
            {
            alt12=41;
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
            alt12=42;
            }
            break;
        case '\t':
        case '\n':
        case '\f':
        case '\r':
        case ' ':
            {
            alt12=43;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | T51 | PLUS | MINUS | MUL | DIV | MOD | POW | LPAREN | RPAREN | SEMI | DEFINITION | ORDERED_DEF | EQUAL | SQUARE_PAREN_L | SQUARE_PAREN_R | NUMBER | NOTEQUAL | GREATER | LESS | GREATEREQUAL | LESSEQUAL | STRING_LITERAL | DOT | ID | WS | COMMENT | LINE_COMMENT );", 12, 0, input);

            throw nvae;
        }

        switch (alt12) {
            case 1 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:10: T33
                {
                mT33(); 

                }
                break;
            case 2 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:14: T34
                {
                mT34(); 

                }
                break;
            case 3 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:18: T35
                {
                mT35(); 

                }
                break;
            case 4 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:22: T36
                {
                mT36(); 

                }
                break;
            case 5 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:26: T37
                {
                mT37(); 

                }
                break;
            case 6 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:30: T38
                {
                mT38(); 

                }
                break;
            case 7 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:34: T39
                {
                mT39(); 

                }
                break;
            case 8 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:38: T40
                {
                mT40(); 

                }
                break;
            case 9 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:42: T41
                {
                mT41(); 

                }
                break;
            case 10 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:46: T42
                {
                mT42(); 

                }
                break;
            case 11 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:50: T43
                {
                mT43(); 

                }
                break;
            case 12 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:54: T44
                {
                mT44(); 

                }
                break;
            case 13 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:58: T45
                {
                mT45(); 

                }
                break;
            case 14 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:62: T46
                {
                mT46(); 

                }
                break;
            case 15 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:66: T47
                {
                mT47(); 

                }
                break;
            case 16 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:70: T48
                {
                mT48(); 

                }
                break;
            case 17 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:74: T49
                {
                mT49(); 

                }
                break;
            case 18 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:78: T50
                {
                mT50(); 

                }
                break;
            case 19 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:82: T51
                {
                mT51(); 

                }
                break;
            case 20 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:86: PLUS
                {
                mPLUS(); 

                }
                break;
            case 21 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:91: MINUS
                {
                mMINUS(); 

                }
                break;
            case 22 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:97: MUL
                {
                mMUL(); 

                }
                break;
            case 23 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:101: DIV
                {
                mDIV(); 

                }
                break;
            case 24 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:105: MOD
                {
                mMOD(); 

                }
                break;
            case 25 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:109: POW
                {
                mPOW(); 

                }
                break;
            case 26 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:113: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 27 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:120: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 28 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:127: SEMI
                {
                mSEMI(); 

                }
                break;
            case 29 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:132: DEFINITION
                {
                mDEFINITION(); 

                }
                break;
            case 30 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:143: ORDERED_DEF
                {
                mORDERED_DEF(); 

                }
                break;
            case 31 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:155: EQUAL
                {
                mEQUAL(); 

                }
                break;
            case 32 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:161: SQUARE_PAREN_L
                {
                mSQUARE_PAREN_L(); 

                }
                break;
            case 33 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:176: SQUARE_PAREN_R
                {
                mSQUARE_PAREN_R(); 

                }
                break;
            case 34 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:191: NUMBER
                {
                mNUMBER(); 

                }
                break;
            case 35 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:198: NOTEQUAL
                {
                mNOTEQUAL(); 

                }
                break;
            case 36 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:207: GREATER
                {
                mGREATER(); 

                }
                break;
            case 37 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:215: LESS
                {
                mLESS(); 

                }
                break;
            case 38 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:220: GREATEREQUAL
                {
                mGREATEREQUAL(); 

                }
                break;
            case 39 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:233: LESSEQUAL
                {
                mLESSEQUAL(); 

                }
                break;
            case 40 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:243: STRING_LITERAL
                {
                mSTRING_LITERAL(); 

                }
                break;
            case 41 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:258: DOT
                {
                mDOT(); 

                }
                break;
            case 42 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:262: ID
                {
                mID(); 

                }
                break;
            case 43 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:265: WS
                {
                mWS(); 

                }
                break;
            case 44 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:268: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 45 :
                // C:\\coding\\gmf2\\Palladio.StoEx\\trunk\\de.uka.ipd.sdq.stoex\\src-man\\de\\uka\\ipd\\sdq\\stoex\\parser\\StochasticExpressions.g:1:276: LINE_COMMENT
                {
                mLINE_COMMENT(); 

                }
                break;

        }

    }


 

}
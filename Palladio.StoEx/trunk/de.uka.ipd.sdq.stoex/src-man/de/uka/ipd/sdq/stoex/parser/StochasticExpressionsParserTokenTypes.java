// $ANTLR : "stoex.g" -> "StochasticExpressionsParser.java"$
  
	package de.uka.ipd.sdq.stoex.parser;
	import de.uka.ipd.sdq.stoex.*;
	import de.uka.ipd.sdq.probfunction.*;
	import java.util.ArrayList;

public interface StochasticExpressionsParserTokenTypes {
	int EOF = 1;
	int NULL_TREE_LOOKAHEAD = 3;
	int GREATER = 4;
	int LESS = 5;
	int EQUAL = 6;
	int NOTEQUAL = 7;
	int GREATEREQUAL = 8;
	int LESSEQUAL = 9;
	int PLUS = 10;
	int MINUS = 11;
	int MUL = 12;
	int DIV = 13;
	int MOD = 14;
	int POW = 15;
	int NUMBER = 16;
	int STRING_LITERAL = 17;
	int LPAREN = 18;
	int RPAREN = 19;
	int LITERAL_IntPMF = 20;
	int SQUARE_PAREN_L = 21;
	int SQUARE_PAREN_R = 22;
	int LITERAL_DoublePMF = 23;
	int LITERAL_EnumPMF = 24;
	int SEMI = 25;
	int ORDERED_DEF = 26;
	int LITERAL_DoublePDF = 27;
	int LITERAL_BoolPMF = 28;
	int LITERAL_unit = 29;
	int DEFINITION = 30;
	// "\"bool\"" = 31
	int LITERAL_false = 32;
	int LITERAL_true = 33;
	int LITERAL_BYTESIZE = 34;
	int LITERAL_STRUCTURE = 35;
	int LITERAL_NUMBER_OF_ELEMENTS = 36;
	int LITERAL_TYPE = 37;
	int LITERAL_VALUE = 38;
	int ID = 39;
	int DOT = 40;
	int LITERAL_INNER = 41;
	int DIGIT = 42;
	int ALPHA = 43;
	int WS = 44;
}

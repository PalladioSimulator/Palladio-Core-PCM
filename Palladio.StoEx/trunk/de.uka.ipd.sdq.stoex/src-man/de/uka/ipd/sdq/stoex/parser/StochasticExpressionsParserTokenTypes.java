// $ANTLR : "stoex.g" -> "StochasticExpressionsParser.java"$
  
	package de.uka.ipd.sdq.stoex.parser;
	import de.uka.ipd.sdq.stoex.*;
	import de.uka.ipd.sdq.probfunction.*;
	import java.util.ArrayList;

public interface StochasticExpressionsParserTokenTypes {
	int EOF = 1;
	int NULL_TREE_LOOKAHEAD = 3;
	int EQUAL = 4;
	int GREATER = 5;
	int LESS = 6;
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
	int LITERAL_IntPMF = 17;
	int LPAREN = 18;
	int RPAREN = 19;
	int SQUARE_PAREN_L = 20;
	int SQUARE_PAREN_R = 21;
	int LITERAL_DoublePMF = 22;
	int LITERAL_EnumPMF = 23;
	int SEMI = 24;
	int ORDERED_DEF = 25;
	int LITERAL_DoublePDF = 26;
	int LITERAL_BoolPMF = 27;
	int LITERAL_unit = 28;
	int STRING_LITERAL = 29;
	int LITERAL_false = 30;
	int LITERAL_true = 31;
	int LITERAL_BYTESIZE = 32;
	int LITERAL_STRUCTURE = 33;
	int LITERAL_NUMBER_OF_ELEMENTS = 34;
	int LITERAL_TYPE = 35;
	int LITERAL_VALUE = 36;
	int ID = 37;
	int DOT = 38;
	int LITERAL_INNER = 39;
	int DIGIT = 40;
	int ALPHA = 41;
	int WS = 42;
}

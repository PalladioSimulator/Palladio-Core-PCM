// $ANTLR : "stoex.g" -> "StochasticExpressionsParser.java"$
  
	package de.uka.ipd.sdq.pcm.stochasticexpressions.parser;
	import de.uka.ipd.sdq.pcm.core.stochastics.*;
	import de.uka.ipd.sdq.probfunction.*;
	import de.uka.ipd.sdq.pcm.parameter.*;
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
	int DOT = 17;
	int LITERAL_IntPMF = 18;
	int LPAREN = 19;
	int RPAREN = 20;
	int SQUARE_PAREN_L = 21;
	int SQUARE_PAREN_R = 22;
	int LITERAL_DoublePMF = 23;
	int LITERAL_EnumPMF = 24;
	int SEMI = 25;
	int ORDERED_DEF = 26;
	int LITERAL_DoublePDF = 27;
	int LITERAL_unit = 28;
	int STRING_LITERAL = 29;
	int LITERAL_BYTESIZE = 30;
	int LITERAL_STRUCTURE = 31;
	int LITERAL_NUMBER_OF_ELEMENTS = 32;
	int LITERAL_TYPE = 33;
	int LITERAL_VALUE = 34;
	int ID = 35;
	int LITERAL_INNER = 36;
	int DIGIT = 37;
	int ALPHA = 38;
	int WS = 39;
}

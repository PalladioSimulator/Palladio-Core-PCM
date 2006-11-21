// $ANTLR : "stoex.g" -> "StochasticExpressionsParser.java"$
  
	package de.uka.ipd.sdq.pcm.stochasticexpressions.parser;
	import de.uka.ipd.sdq.pcm.core.stochastics.*;
	import de.uka.ipd.sdq.probfunction.*;

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
	int ID = 17;
	int INT_DEF = 18;
	int LPAREN = 19;
	int RPAREN = 20;
	int SQUARE_PAREN_L = 21;
	int SQUARE_PAREN_R = 22;
	int REAL_DEF = 23;
	int ENUM_DEF = 24;
	int SEMI = 25;
	int ORDERED_DEF = 26;
	int REAL_PDF = 27;
	int UNIT_DEF = 28;
	int STRING_LITERAL = 29;
	int INNER = 30;
	int DIGIT = 31;
	int ALPHA = 32;
	int MEAN = 33;
	int PROB = 34;
	int FUNCTION_DEF = 35;
	int WS = 36;
}

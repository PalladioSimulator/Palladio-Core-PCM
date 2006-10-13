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
	int SQUARE_PAREN_L = 19;
	int SQUARE_PAREN_R = 20;
	int REAL_DEF = 21;
	int ENUM_DEF = 22;
	int LPAREN = 23;
	int SEMI = 24;
	int RPAREN = 25;
	int STRING_LITERAL = 26;
	int INNER = 27;
	int DIGIT = 28;
	int ALPHA = 29;
	int MEAN = 30;
	int PROB = 31;
	int FUNCTION_DEF = 32;
	int WS = 33;
}

// $ANTLR : "stoex.g" -> "ExpressionLexer.java"$

	package stoex.parser;

public interface ExpressionParserTokenTypes {
	int EOF = 1;
	int NULL_TREE_LOOKAHEAD = 3;
	int EQUAL = 4;
	int INT_DEF = 5;
	int REAL_DEF = 6;
	int SQUARE_PAREN_L = 7;
	int SQUARE_PAREN_R = 8;
	int ENUM_DEF = 9;
	int LPAREN = 10;
	int NUMBER = 11;
	int SEMI = 12;
	int RPAREN = 13;
	int STRING_LITERAL = 14;
	int GREATER = 15;
	int LESS = 16;
	int NOTEQUAL = 17;
	int GREATEREQUAL = 18;
	int LESSEQUAL = 19;
	int PLUS = 20;
	int MINUS = 21;
	int MUL = 22;
	int DIV = 23;
	int MOD = 24;
	int POW = 25;
	int INNER = 26;
	int PARAM = 27;
	int FUNCTION_DEF = 28;
	int DIGIT = 29;
	int ALPHA = 30;
	int MEAN = 31;
	int PROB = 32;
	int WS = 33;
}

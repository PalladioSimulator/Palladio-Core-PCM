// $ANTLR : "expandedvariableusage.g" -> "VariableUsageParser.java"$
  
	package de.uka.ipd.sdq.pcm.stochasticexpressions.parser;
	import de.uka.ipd.sdq.pcm.core.stochastics.*;
	import de.uka.ipd.sdq.probfunction.*;
	import de.uka.ipd.sdq.pcm.parameter.*;
	import java.util.ArrayList;
	import de.uka.ipd.sdq.pcm.stochasticexpressions.StoExPrettyPrintVisitor;

public interface VariableUsageParserTokenTypes {
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
	int INT_DEF = 17;
	int LPAREN = 18;
	int RPAREN = 19;
	int SQUARE_PAREN_L = 20;
	int SQUARE_PAREN_R = 21;
	int REAL_DEF = 22;
	int ENUM_DEF = 23;
	int SEMI = 24;
	int ORDERED_DEF = 25;
	int REAL_PDF = 26;
	int UNIT_DEF = 27;
	int STRING_LITERAL = 28;
	int DOT = 29;
	int CHARACTERISATIONS = 30;
	int ID = 31;
	int INNER = 32;
	int DIGIT = 33;
	int ALPHA = 34;
	int MEAN = 35;
	int PROB = 36;
	int FUNCTION_DEF = 37;
	int WS = 38;
}

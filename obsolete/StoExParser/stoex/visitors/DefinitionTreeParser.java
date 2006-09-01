package stoex.visitors;

import stoex.parser.ExpressionParserTokenTypes;
import stoex.stochastics.RandomVariable;
import antlr.TreeParser;
import antlr.collections.AST;

/**
 * 
 */

/**
 * @author Snowball
 * 
 */
public class DefinitionTreeParser extends TreeParser {

	public static RandomVariable parseDefinition(AST definitionNode) {
		RandomVariable r = null;
		
		switch (definitionNode.getType()) {
		case ExpressionParserTokenTypes.INT_DEF:
			r = new RandomVariable<Integer>();
			parseSamples(definitionNode.getFirstChild(),r,RandomVariable.INTEGER_DIST);
			return r;
		case ExpressionParserTokenTypes.REAL_DEF:
			r = new RandomVariable<Double>();
			parseSamples(definitionNode.getFirstChild(),r,RandomVariable.REAL_DIST);
			return r;
		case ExpressionParserTokenTypes.ENUM_DEF:
			r = new RandomVariable<String>();
			parseSamples(definitionNode.getFirstChild(),r,RandomVariable.ENUM_DIST);
			return r;
		}
		return null;
	}

	private static void parseSamples(AST firstChild, RandomVariable r, int type) {
		AST current = firstChild;
		do
		{
			// First child is probability
			double probability = Double.parseDouble(current.getFirstChild().getText());
			
			// Second is value encoded in a String
			String value = current.getFirstChild().getNextSibling().getText();
			
			r.addRawSample(probability,value,type);
		}
		while ((current=current.getNextSibling()) != null);
	}
}

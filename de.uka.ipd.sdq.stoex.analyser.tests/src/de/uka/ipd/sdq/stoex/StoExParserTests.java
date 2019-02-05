package de.uka.ipd.sdq.stoex;



import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import de.uka.ipd.sdq.stoex.parser.StochasticExpressionsLexer;
import de.uka.ipd.sdq.stoex.parser.StochasticExpressionsParser;


public class StoExParserTests
{

    @Test
    public void testHelloWorld() throws RecognitionException
    {
        parse("\"Hello World\"");
    }


    @Test
    public void testStoExParser() throws RecognitionException
    {
        parse("true");
        parse("5 > 4");
        parse("IntPMF[(1;0.2)(2;0.4)]");
        parse("10.8E4");
        parse("5+5*6 > 7*7 AND 6*6 < 7");
        parse("-4");
        parse("NOT true");
    }

    /**
     * 
     * @throws RecognitionException
     */
    @Test(expected=RuntimeException.class)
    public void testStoExParserSyntaxErrors() throws RecognitionException
    {

        parse("+6***6");
        parse("a$JFfuRKrp23r32#");
    }

    private void parse(final String s) throws RecognitionException {

        final StochasticExpressionsLexer lexer = new StochasticExpressionsLexer(
                new ANTLRStringStream(s));
        final StochasticExpressionsParser parser = new StochasticExpressionsParser(
                new CommonTokenStream(lexer));

        parser.expression();
        if(parser.getNumberOfSyntaxErrors() > 0) {
            throw new RuntimeException("ANTLR Syntax Error");
        }

    }
}

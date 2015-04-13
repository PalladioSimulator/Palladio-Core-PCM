package org.palladiosimulator.pcm.pcmstoex.tests;

import org.junit.Assert;
import org.junit.Test;
import org.palladiosimulator.commons.stoex.adapter.StoExParser;
import org.palladiosimulator.commons.stoex.adapter.StoExSerializer;
import org.palladiosimulator.pcm.pcmstoex.adapter.PCMStoExParser;
import org.palladiosimulator.pcm.pcmstoex.adapter.PCMStoExSerializer;

import de.uka.ipd.sdq.stoex.Expression;

/**
 * The majority of these tests is copied from de.uka.ipd.sdq.stoex.analyser.tests to test if the
 * same language can be parsed.
 * 
 * @author Jonas Heinisch
 *
 */
public class ParserTest {

    private static final int STOEXPARSER = 0;
    private static final int PCMPARSER = 1;
    private static final int PCMPARSER_ONLY = 2;

    @Test
    public void testHelloWorld() {
        parse("\"Hello World\"", PCMPARSER);
    }

    @Test
    public void testStoExParser() {
        parse("true", PCMPARSER);
        parse("5 > 4", PCMPARSER);
        parse("IntPMF[(1;0.2)(2;0.4)]", PCMPARSER);
        parse("10.8E4", PCMPARSER);
        parse("5+5*6 > 7*7 AND 6*6 < 7", PCMPARSER);
        parse("true OR false", PCMPARSER);
        parse("-4", PCMPARSER);
        parse("NOT true", PCMPARSER);
    }

    /**
     * The examples from the bachelor-thesis.
     */
    @Test
    public void testExamples() {
        parse("DoublePDF[(1.0;0.3)(1.5;0.2)(2.0;0.5)]", PCMPARSER);
        parse("IntPMF[(27;0.1)(28;0.2)(29;0.6)(30;0.1)]", PCMPARSER);
        parse("42", PCMPARSER);
        parse("13.37", PCMPARSER);
        parse("\"Dies ist ein Text!\"", PCMPARSER);
        parse("true", PCMPARSER);
        parse("false", PCMPARSER);
        // this one is not supported by PCMStoExParser, as this is a not type variable
        parse("a.package.variable", STOEXPARSER);
        // this one is not supported by PCMStoExParser, as func is not a valid function
        parse("func(true, 42)", STOEXPARSER);
        parse("40+2", PCMPARSER);
        parse("44-2", PCMPARSER);
        parse("3*3", PCMPARSER);
        parse("84/2", PCMPARSER);
        parse("4%3", PCMPARSER);
        // this one is not supported by PCMStoExParser, as this is a not type variable
        parse("my.variable >= 5", STOEXPARSER);
        // this one is not supported by PCMStoExParser, as this is a not type variable
        parse("your.variable == 0", STOEXPARSER);
        // this one is not supported by PCMStoExParser, as this is a not type variable
        parse("eine.bedingung ? true : false", STOEXPARSER);
        parse("( 2 + 4 ) * 3", PCMPARSER);
        parse("IntPMF[(1;0.2)(2;0.5)(5;0.3)] * Exp(4) + 2 % 4 >= 42 OR 2 == 0", PCMPARSER);
        parse("3[s]", PCMPARSER);
        parse("this.VALUE", PCMPARSER_ONLY);
        parse("4[B^2]", PCMPARSER);
    }

    @Test
    public void testStoExParserSyntaxErrors() {
        parseFail("+6***6", PCMPARSER);
        parseFail("a$JFfuRKrp23r32#", PCMPARSER);
        parseFail("", PCMPARSER);
    }

    @Test
    public void testValidator() {
        parseFail("false AND 42", PCMPARSER_ONLY);
    }

    private void parseFail(String string, int type) {
        boolean crashed = false;
        try {
            parse(string, type);
        } catch (RuntimeException e) {
            crashed = true;
        }
        if (!crashed) {
            throw new RuntimeException("Error expected but there is no :(");
        }
    }

    private void parse(final String s, int type) {
        final StoExParser parser;
        final StoExSerializer seri;
        if (type == STOEXPARSER) {
            parser = new StoExParser(s, true);
            seri = new StoExSerializer();
        } else {
            parser = new PCMStoExParser(s, true);
            seri = new PCMStoExSerializer();
        }

        Expression o = parser.expression();
        if (parser.hasErrors()) {
            throw new RuntimeException("Xtext Syntax Error");
        }

        Assert.assertEquals(removespaces(s), removespaces(seri.valueOf(o)));

        // things parsed with PCMStoExParser should be parsable by the StoExParser
        if (type == PCMPARSER) {
            parse(s, STOEXPARSER);
        }

    }

    private String removespaces(String valueOf) {
        return valueOf.replace(" ", "");
    }

}

package org.palladiosimulator.pcm.stoex.api;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.palladiosimulator.pcm.stoex.api.StoExParser.SyntaxErrorException;
import org.palladiosimulator.pcm.stoex.api.impl.TestBase;

import de.uka.ipd.sdq.stoex.IntLiteral;

public class StoExParserTest extends TestBase {

    @Test
    @Order(0)
    public void testAcquireParser() {
        var subject = StoExParser.createInstance();
        assertThat(subject, is(notNullValue()));
    }

    @Test
    public void testParseValidExpression() throws SyntaxErrorException {
        var subject = StoExParser.createInstance();
        var parseResult = subject.parse("1");
        assertThat(parseResult, is(instanceOf(IntLiteral.class)));
        assertThat(((IntLiteral) parseResult).getValue(), is(1));
    }

    @Test
    public void testParseInvalidExpression() {
        var subject = StoExParser.createInstance();
        assertThrows(SyntaxErrorException.class, () -> subject.parse("1+"));
    }

}

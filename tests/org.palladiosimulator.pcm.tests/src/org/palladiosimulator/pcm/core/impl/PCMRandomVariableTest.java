package org.palladiosimulator.pcm.core.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.IsNull.nullValue;

import org.junit.jupiter.api.Test;
import org.palladiosimulator.pcm.core.CoreFactory;
import org.palladiosimulator.pcm.tests.impl.TestBase;

import de.uka.ipd.sdq.stoex.IntLiteral;

public class PCMRandomVariableTest extends TestBase {

    @Test
    public void testSuccessfullParsingOfValidExpression() {
        var variable = CoreFactory.eINSTANCE.createPCMRandomVariable();
        variable.setSpecification("1");
        var parsedExpression = variable.getExpression();
        assertThat(parsedExpression, is(instanceOf(IntLiteral.class)));
        assertThat(((IntLiteral) parsedExpression).getValue(), is(1));
    }

    @Test
    public void testReturnNullOnInvalidExpression() {
        var variable = CoreFactory.eINSTANCE.createPCMRandomVariable();
        variable.setSpecification("1+");
        var parsedExpression = variable.getExpression();
        assertThat(parsedExpression, is(nullValue()));
    }

}

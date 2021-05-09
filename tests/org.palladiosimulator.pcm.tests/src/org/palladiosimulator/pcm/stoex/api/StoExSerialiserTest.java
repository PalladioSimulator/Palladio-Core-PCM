package org.palladiosimulator.pcm.stoex.api;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.palladiosimulator.pcm.stoex.api.StoExSerialiser.SerialisationErrorException;
import org.palladiosimulator.pcm.stoex.api.impl.TestBase;

import de.uka.ipd.sdq.stoex.StoexFactory;

public class StoExSerialiserTest extends TestBase {

    @Test
    @Order(0)
    public void testAcquireSerialiser() {
        var subject = StoExSerialiser.createInstance();
        assertThat(subject, is(notNullValue()));
    }

    @Test
    public void testSerialiseValidExpression() throws SerialisationErrorException {
        var subject = StoExSerialiser.createInstance();
        var expression = StoexFactory.eINSTANCE.createIntLiteral();
        expression.setValue(1);
        var serialisedExpression = subject.serialise(expression);
        assertThat(serialisedExpression, is(equalTo("1")));
    }

    @Test
    public void testSerialiseInvalidExpression() {
        var subject = StoExSerialiser.createInstance();
        var expression = StoexFactory.eINSTANCE.createNegativeExpression();
        assertThrows(SerialisationErrorException.class, () -> subject.serialise(expression));
    }

    @Test
    @SuppressWarnings("deprecation")
    public void testSerialiseValidVariableReference() throws SerialisationErrorException {
        var subject = StoExSerialiser.createInstance();
        var reference = StoexFactory.eINSTANCE.createVariableReference();
        reference.setReferenceName("foo");
        var serialisedReference = subject.serialise(reference);
        assertThat(serialisedReference, is(equalTo("foo")));
    }
    
    @Test
    @SuppressWarnings("deprecation")
    public void testSerialiseValidNamespaceReference() throws SerialisationErrorException {
        var subject = StoExSerialiser.createInstance();
        var reference = StoexFactory.eINSTANCE.createNamespaceReference();
        reference.setReferenceName("foo");
        var innerReference = StoexFactory.eINSTANCE.createVariableReference();
        innerReference.setReferenceName("bar");
        reference.setInnerReference_NamespaceReference(innerReference);
        var serialisedReference = subject.serialise(reference);
        assertThat(serialisedReference, is(equalTo("foo.bar")));
    }
    
}

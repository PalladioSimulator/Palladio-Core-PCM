package de.uka.ipd.sdq.pcm.stochasticexpressions.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;

import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.palladiosimulator.pcm.parameter.CharacterisedVariable;
import org.palladiosimulator.pcm.parameter.VariableCharacterisationType;

import de.uka.ipd.sdq.pcm.stochasticexpressions.CharacterisedVariableParseResultPostProcessor;
import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.ProductExpression;
import de.uka.ipd.sdq.stoex.ProductOperations;
import de.uka.ipd.sdq.stoex.StoexFactory;
import de.uka.ipd.sdq.stoex.Variable;

public class CharacterisedVariableParseResultPostProcessorTest {

    private CharacterisedVariableParseResultPostProcessor subject;

    @BeforeEach
    public void setup() {
        subject = new CharacterisedVariableParseResultPostProcessor();
    }

    @Test
    public void testNoChanges() {
        var simpleExpression = StoexFactory.eINSTANCE.createIntLiteral();
        simpleExpression.setValue(1);
        var expected = createResult(simpleExpression);
        var actual = subject.postProcess(expected);
        assertEquals(expected, actual);
    }

    @Test
    public void testChangedRootObject() {
        var variable = createVariable("TYPE");
        var input = createResult(variable);

        var actual = subject.postProcess(input);

        assertNotEquals(input, actual);
        assertEquals(input.getRootNode(), actual.getRootNode());
        assertEquals(input.hasSyntaxErrors(), actual.hasSyntaxErrors());
        assertThat(actual.getRootASTElement(), is(instanceOf(CharacterisedVariable.class)));
        var newVariable = (CharacterisedVariable) actual.getRootASTElement();
        assertEquals(VariableCharacterisationType.TYPE, newVariable.getCharacterisationType());
    }

    @Test
    public void testChangedNestedObject() {
        var variable1 = createVariable("VALUE");
        var variable2 = createVariable("test");
        var product = StoexFactory.eINSTANCE.createProductExpression();
        product.setLeft(variable1);
        product.setRight(variable2);
        product.setOperation(ProductOperations.MULT);
        var input = createResult(product);

        var actual = subject.postProcess(input);

        assertEquals(input, actual);
        assertThat(actual.getRootASTElement(), is(instanceOf(ProductExpression.class)));
        var newProduct = (ProductExpression)actual.getRootASTElement();
        assertThat(newProduct.getLeft(), is(instanceOf(CharacterisedVariable.class)));
        var newVariable = (CharacterisedVariable)newProduct.getLeft();
        assertEquals(VariableCharacterisationType.VALUE, newVariable.getCharacterisationType());
    }

    protected static IParseResult createResult(Expression rootObject) {
        var rootNode = mock(ICompositeNode.class);
        return new ParseResult(rootObject, rootNode, false);
    }

    protected static Variable createVariable(String name) {
        var variable = StoexFactory.eINSTANCE.createVariable();
        var reference = StoexFactory.eINSTANCE.createVariableReference();
        reference.setReferenceName(name);
        variable.setId_Variable(reference);
        return variable;
    }
}

package de.uka.ipd.sdq.pcm.stochasticexpressions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.ParseResult;
import org.palladiosimulator.commons.stoex.parser.ParseResultPostProcessor;
import org.palladiosimulator.pcm.parameter.CharacterisedVariable;
import org.palladiosimulator.pcm.parameter.ParameterFactory;
import org.palladiosimulator.pcm.parameter.VariableCharacterisationType;

import de.uka.ipd.sdq.stoex.Variable;
import de.uka.ipd.sdq.stoex.VariableReference;

/**
 * Post processor for StoEx parse results that injects {@link CharacterisedVariable} instances into
 * the result. These more specific variable types replace the generic {@link Variable} instances if
 * the variable refers to a {@link VariableCharacterisationType}.
 */
public class CharacterisedVariableParseResultPostProcessor implements ParseResultPostProcessor {

    @Override
    public IParseResult postProcess(final IParseResult givenResult) {
        var result = givenResult;
        var variableReferences = findContentOfType(result.getRootASTElement(), VariableReference.class);
        for (var variableReference : variableReferences) {
            var refName = variableReference.getReferenceName();
            var characterisationType = VariableCharacterisationType.get(refName);
            if (characterisationType == null) {
                // the reference does not refer to a characterisation type
                continue;
            }
            var variable = findParent(variableReference, Variable.class);
            if (variable.isEmpty()) {
                // the reference does not belong to a variable
                // this should not happen but might change in the future
                continue;
            }
            result = replaceVariable(variable.get(), characterisationType, result);
        }

        return result;
    }

    /**
     * Replaces a variable in the given {@link IParseResult}.
     * 
     * The result will be a new {@link IParseResult} instance if the variable to be replaced is the
     * root element of the given result.
     * 
     * @param variable
     *            The variable to replace.
     * @param characterisationType
     *            The characteristic variable type to use in the replacement.
     * @param result
     *            The result that contains the variable.
     * @return The same or a new {@link IParseResult} instance that contains the replacement.
     */
    protected IParseResult replaceVariable(Variable variable, VariableCharacterisationType characterisationType,
            IParseResult result) {
        var characterisedVariable = ParameterFactory.eINSTANCE.createCharacterisedVariable();
        characterisedVariable.setId_Variable(variable.getId_Variable());
        characterisedVariable.setCharacterisationType(characterisationType);
        if (result.getRootASTElement() == variable) {
            return new ParseResult(characterisedVariable, result.getRootNode(), result.hasSyntaxErrors());
        } else {
            EcoreUtil.replace(variable, characterisedVariable);
        }
        return result;
    }

    /**
     * Finds all transitive contents (including the given start element) of the requested type.
     * 
     * @param <T>
     *            The type of requested contents.
     * @param start
     *            The element to start the search from.
     * @param type
     *            The type of the requested contents.
     * @return The found elements.
     */
    @SuppressWarnings("unchecked")
    protected static <T extends EObject> Iterable<T> findContentOfType(EObject start, Class<T> type) {
        var result = new ArrayList<T>();

        var queue = new LinkedList<EObject>();
        queue.add(start);
        while (!queue.isEmpty()) {
            var current = queue.pop();
            if (current == null) {
                continue;
            }
            queue.addAll(current.eContents());
            if (type.isInstance(current)) {
                result.add((T) current);
            }
        }

        return result;
    }

    /**
     * Finds a transitive parent (including itself) of a given type.
     * 
     * @param <T>
     *            The type of the parent.
     * @param source
     *            The element to start the search from.
     * @param parentType
     *            The type of the parent.
     * @return The found parent or an empty result if there is no such parent.
     */
    @SuppressWarnings("unchecked")
    protected static <T> Optional<T> findParent(EObject source, Class<T> parentType) {
        for (EObject current = source; current != null; current = current.eContainer()) {
            if (parentType.isInstance(current)) {
                return Optional.of((T) current);
            }
        }
        return Optional.empty();
    }

}

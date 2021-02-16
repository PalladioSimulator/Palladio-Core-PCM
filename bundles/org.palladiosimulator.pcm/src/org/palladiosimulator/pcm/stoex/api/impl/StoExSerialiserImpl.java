package org.palladiosimulator.pcm.stoex.api.impl;

import java.util.Optional;
import java.util.UUID;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.serializer.ISerializer;
import org.palladiosimulator.pcm.stoex.api.StoExSerialiser;

import de.uka.ipd.sdq.stoex.Expression;

/**
 * Wrapper for an serialize for StoEx expressions.
 */
public class StoExSerialiserImpl implements StoExSerialiser {

    private final ISerializer serialiser;

    /**
     * Constructs new serialiser instance.
     */
    public StoExSerialiserImpl() {
        serialiser = new XtextStoExSerialiserProvider().get();
    }

    @Override
    public String serialise(Expression expression) throws SerialisationErrorException {
        var tmpExpression = createExpressionCopy(expression);
        try {
            return serialiser.serialize(tmpExpression);
        } catch (RuntimeException e) {
            throw new SerialisationErrorException(e.getMessage());
        } finally {
            removeExpressionCopy(tmpExpression);
        }
    }

    /**
     * Creates a copy of the given expression that will be contained in an {@link XtextResource}.
     * This is necessary because the serialiser demands the expression to be in such a resource.
     * 
     * Please note that this implementation changes the {@link ResourceSet} that transitively
     * contains the expression. Therefore, the effect has to be undone as soon as the copy is not
     * required anymore by calling {@link #removeExpressionCopy(Expression)}.
     * 
     * @param expression
     *            The expression to copy.
     * @return The copy of the expression.
     * @see #removeExpressionCopy(Expression)
     */
    protected Expression createExpressionCopy(Expression expression) {
        var rs = Optional.ofNullable(expression.eResource())
            .map(Resource::getResourceSet)
            .orElseGet(ResourceSetImpl::new);
        var uri = Optional.ofNullable(expression.eResource())
            .map(Resource::getURI)
            .orElseGet(() -> URI.createPlatformResourceURI("/tmp/tmp.xmi", false))
            .trimSegments(1)
            .appendSegment(UUID.randomUUID()
                .toString() + ".stoex");
        var r = rs.createResource(uri);
        var copy = EcoreUtil.copy(expression);
        r.getContents()
            .add(copy);
        return copy;
    }

    /**
     * Undoes the changes done by {@link #createExpressionCopy(Expression)}.
     * 
     * @param copy
     *            The expression copy.
     */
    protected void removeExpressionCopy(Expression copy) {
        var r = copy.eResource();
        r.unload();
        r.getResourceSet()
            .getResources()
            .remove(r);
    }

}

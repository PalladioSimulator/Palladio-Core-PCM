package org.palladiosimulator.pcm.stoex.api;

import org.palladiosimulator.pcm.stoex.api.impl.StoExSerialiserImpl;

import de.uka.ipd.sdq.stoex.AbstractNamedReference;
import de.uka.ipd.sdq.stoex.Expression;

/**
 * Service interface for StoEx serialisers.
 * 
 * The serialiser transforms an {@link Expression} to human readable conrete syntax. You can acquire
 * an instance of the parser via OSGi declarative services or use the {@link #createInstance()}
 * method.
 */
public interface StoExSerialiser {

    /**
     * Exception thrown in case of serialisation errors. Only an unstructured reason is given in
     * textual form.
     */
    public static class SerialisationErrorException extends Exception {

        private static final long serialVersionUID = -74448308338719686L;

        /**
         * Constructs the serialisation exception.
         * 
         * @param message
         *            The message that describes the serialisation error.
         */
        public SerialisationErrorException(String message) {
            super(message);
        }

    }

    /**
     * Serialises an {@link Expression} to a human readable text.
     * 
     * @param expression
     *            The expression to serialise.
     * @return The concrete syntax representation of the given expression.
     * @throws SerialisationErrorException
     *             In case of an error during serialisation. This is usually caused by an invalid
     *             expression.
     */
    String serialise(Expression expression) throws SerialisationErrorException;

    /**
     * Serialises an {@link AbstractNamedReference} to a human readable text.
     * 
     * @param reference
     *            The reference to serialise.
     * @return The concrete syntax representation of the given reference.
     * @throws SerialisationErrorException
     *             In case of an error during serialisation. This is usually caused by an invalid
     *             reference.
     * @deprecated Client code should only serialise complete {@link Expression} elements instead of
     *             subtrees of an expression. The method is only available for backwards
     *             compatibility and will soon be removed. Consider migrating client code to
     *             {@link #serialise(Expression)}.
     */
    @Deprecated
    String serialise(AbstractNamedReference reference) throws SerialisationErrorException;

    /**
     * Creates an instance of the {@link StoExSerialiser}.
     * 
     * @return Instance of {@link StoExSerialiser}
     */
    static StoExSerialiser createInstance() {
        return new StoExSerialiserImpl();
    }
}

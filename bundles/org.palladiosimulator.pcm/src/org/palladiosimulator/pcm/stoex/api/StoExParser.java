package org.palladiosimulator.pcm.stoex.api;

import org.palladiosimulator.pcm.stoex.api.impl.StoExParserImpl;

import de.uka.ipd.sdq.stoex.Expression;

/**
 * Service interface for StoEx parsers.
 * 
 * The parser translates a serialized StoEx into an {@link Expression}. You can acquire an instance
 * of the parser via OSGi declarative services or use the {@link #createInstance()} method.
 *
 */
public interface StoExParser {

    /**
     * Exception thrown in case of syntax errors. The syntax errors are contained as error message.
     */
    public static class SyntaxErrorException extends Exception {
        private static final long serialVersionUID = -3816007293706840864L;

        /**
         * Constructs the syntax exception.
         * 
         * @param message
         *            The message that describes the syntax errors.
         */
        public SyntaxErrorException(String message) {
            super(message);
        }

    }

    /**
     * Parse a serialized StoEx into an {@link Expression}.
     * 
     * @param serializedStoEx
     *            The serialized StoEx.
     * @return The parsed {@link Expression} instance.
     * @throws SyntaxErrorException
     *             thrown in case of a syntax error.
     */
    Expression parse(String serializedStoEx) throws SyntaxErrorException;
    
    /**
     * Creates an instance of the {@link StoExParser}.
     * 
     * @return Instance of {@link StoExParser}
     */
    static StoExParser createInstance() {
        return new StoExParserImpl();
    }

}

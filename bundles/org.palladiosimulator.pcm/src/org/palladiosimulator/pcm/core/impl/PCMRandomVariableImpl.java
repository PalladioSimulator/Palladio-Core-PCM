package org.palladiosimulator.pcm.core.impl;

import org.palladiosimulator.pcm.stoex.api.StoExParser;
import org.palladiosimulator.pcm.stoex.api.StoExParser.SyntaxErrorException;

import de.uka.ipd.sdq.stoex.Expression;

public class PCMRandomVariableImpl extends PCMRandomVariableImplGen {

    /**
     * Instance of an {@link StoExParser} to parse textual StoEx expressions.
     */
    private static final StoExParser STOEX_PARSER = StoExParser.createInstance();

    /**
     * Cached version of specification to decide if re-parsing is required.
     */
    private String lastParsedSpecification;

    /**
     * Cached version of parsed specification to return if no re-parsing is required.
     */
    private Expression lastParseExpression;

    /**
     * Get the basic stochastic expression derived from the specification. This overrides the
     * RandomVariable implementation of this method and takes use of the parser and lexer for our
     * stochastic expression language.
     *
     * @return The prepared Expression parsed from the specification string.
     */
    @Override
    public Expression basicGetExpression() {
        if (this.lastParseExpression == null || !this.lastParsedSpecification.equals(this.getSpecification())) {
            // re-parsing required

            Expression e;
            try {
                e = STOEX_PARSER.parse(this.getSpecification());
            } catch (final SyntaxErrorException e1) {
                e = null;
            }
            this.lastParseExpression = e;
            this.lastParsedSpecification = new String(this.getSpecification());
        }
        return this.lastParseExpression;
    }

}

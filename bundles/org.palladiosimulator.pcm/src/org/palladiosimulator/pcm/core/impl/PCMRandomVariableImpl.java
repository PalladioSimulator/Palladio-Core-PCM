package org.palladiosimulator.pcm.core.impl;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.palladiosimulator.pcm.stochasticexpressions.parser.MyPCMStoExLexer;
import org.palladiosimulator.pcm.stochasticexpressions.parser.MyPCMStoExParser;

import de.uka.ipd.sdq.stoex.Expression;

public class PCMRandomVariableImpl extends PCMRandomVariableImplGen {

    /**
     * Cached version of specification to decide if re-parsing is required.
     *
     * @generated NOT
     */
    private String lastParsedSpecification;
    /**
     * Cached version of parsed specification to return if no re-parsing is required.
     *
     * @generated NOT
     */
    private Expression lastParseExpression;

    /**
     * Get the basic stochastic expression derived from the specification. This overrides the
     * RandomVariable implementation of this method and takes use of the parser and lexer for our
     * stochastic expression language.
     *
     * @return The prepared Expression parsed from the specification string.
     *
     * @generated not
     */
    @Override
    public Expression basicGetExpression() {
        if (this.lastParseExpression == null || !this.lastParsedSpecification.equals(this.getSpecification())) {
            // re-parsing required
            final MyPCMStoExLexer lexer = new MyPCMStoExLexer(new ANTLRStringStream(this.getSpecification()));
            final MyPCMStoExParser parser = new MyPCMStoExParser(new CommonTokenStream(lexer));
            Expression e;
            try {
                e = parser.expression();
            } catch (final RecognitionException e1) {
                e = null;
            }
            if (parser.hasErrors()) {
                e = null;
            }
            this.lastParseExpression = e;
            this.lastParsedSpecification = new String(this.getSpecification());
        } else {
            // old parsed result can be returned
        }
        return this.lastParseExpression;
    }

}

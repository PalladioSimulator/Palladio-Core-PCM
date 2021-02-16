package org.palladiosimulator.pcm.stoex.api.impl;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.palladiosimulator.pcm.stoex.api.StoExParser;

import de.uka.ipd.sdq.stoex.Expression;

/**
 * Wrapper for the Xtext StoEx parser.
 */
public class StoExParserImpl implements StoExParser {

    private final IParser parser;

    /**
     * Constructs new parser instance.
     */
    public StoExParserImpl() {
        parser = new XtextStoExParserProvider().get();
    }

    @Override
    public Expression parse(String serializedStoEx) throws SyntaxErrorException {
        try (var sr = new StringReader(serializedStoEx)) {
            IParseResult result = parser.parse(sr);
            assertNoSyntaxErrorException(result);
            return (Expression) result.getRootASTElement();            
        }
    }

    /**
     * Ensures that there are no syntax errors contained in the result.
     * 
     * @param result
     *            the result of the Xtext parsing process
     * @throws SyntaxErrorException
     *             throw if the result is invalid or contains syntax errors. Contains a textual
     *             description of the syntax error.
     */
    private void assertNoSyntaxErrorException(IParseResult result) throws SyntaxErrorException {
        if (result == null) {
            throw new SyntaxErrorException("Unspecified syntax error");
        }
        if (!result.hasSyntaxErrors()) {
            return;
        }
        List<String> errorMessages = new ArrayList<>();
        for (INode error : result.getSyntaxErrors()) {
            Optional.ofNullable(error)
                .map(INode::getSyntaxErrorMessage)
                .map(SyntaxErrorMessage::getMessage)
                .ifPresent(errorMessages::add);
        }
        String errorMessage = String.join(System.lineSeparator(), errorMessages);
        throw new SyntaxErrorException(errorMessage);
    }

}

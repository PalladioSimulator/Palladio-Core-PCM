package org.palladiosimulator.pcm.stoex.api.impl;

import org.palladiosimulator.commons.stoex.api.impl.generic.GenericStoExParserImpl;
import org.palladiosimulator.pcm.stoex.api.StoExParser;

/**
 * Wrapper for the Xtext StoEx parser.
 */
public class StoExParserImpl extends GenericStoExParserImpl implements StoExParser {

    /**
     * Constructs new parser instance.
     */
    public StoExParserImpl() {
        super(new XtextStoExParserProvider());
    }

}

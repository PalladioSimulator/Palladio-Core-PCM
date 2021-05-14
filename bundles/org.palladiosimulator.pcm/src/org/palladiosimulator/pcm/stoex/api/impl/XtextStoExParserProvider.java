package org.palladiosimulator.pcm.stoex.api.impl;

import org.eclipse.xtext.parser.IParser;
import org.palladiosimulator.commons.stoex.api.impl.generic.GenericXtextToolProviderImpl;
import org.palladiosimulator.commons.stoex.parser.antlr.StoexParser;

/**
 * Provider for {@link StoexParser} instances.
 * 
 * @see XtextToolProviderImpl
 */
public class XtextStoExParserProvider extends GenericXtextToolProviderImpl<IParser> {

    private static final String EP_ID_PARSER = "org.palladiosimulator.pcm.stoex_parser_provider";
    private static final String EP_ID_ATTR = "class";

    /**
     * Constructs the provider.
     */
    public XtextStoExParserProvider() {
        super(XtextStoExInjectorProvider.getInstance(), IParser.class, EP_ID_PARSER, EP_ID_ATTR);
    }

}

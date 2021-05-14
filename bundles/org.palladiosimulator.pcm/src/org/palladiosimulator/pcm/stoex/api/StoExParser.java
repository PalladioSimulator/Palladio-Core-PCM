package org.palladiosimulator.pcm.stoex.api;

import org.palladiosimulator.commons.stoex.api.impl.generic.GenericStoExParser;
import org.palladiosimulator.pcm.stoex.api.impl.StoExParserImpl;

import de.uka.ipd.sdq.stoex.Expression;

/**
 * Service interface for StoEx parsers.
 * 
 * The parser translates a serialized StoEx into an {@link Expression}. You can acquire an instance
 * of the parser via OSGi declarative services or use the {@link #createInstance()} method.
 *
 */
public interface StoExParser extends GenericStoExParser {

    /**
     * Creates an instance of the {@link StoExParser}.
     * 
     * @return Instance of {@link StoExParser}
     */
    static StoExParser createInstance() {
        return new StoExParserImpl();
    }

}

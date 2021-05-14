package org.palladiosimulator.pcm.stoex.api;

import org.palladiosimulator.commons.stoex.api.impl.generic.GenericStoExSerialiser;
import org.palladiosimulator.pcm.stoex.api.impl.StoExSerialiserImpl;

import de.uka.ipd.sdq.stoex.Expression;

/**
 * Service interface for StoEx serialisers.
 * 
 * The serialiser transforms an {@link Expression} to human readable conrete syntax. You can acquire
 * an instance of the parser via OSGi declarative services or use the {@link #createInstance()}
 * method.
 */
public interface StoExSerialiser extends GenericStoExSerialiser {


    /**
     * Creates an instance of the {@link StoExSerialiser}.
     * 
     * @return Instance of {@link StoExSerialiser}
     */
    static StoExSerialiser createInstance() {
        return new StoExSerialiserImpl();
    }
}

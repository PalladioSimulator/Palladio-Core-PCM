package org.palladiosimulator.pcm.stoex.api.impl;

import com.google.inject.Provider;

import org.eclipse.xtext.ISetup;
import org.palladiosimulator.commons.stoex.api.impl.generic.GenericXtextStoExStandaloneInjectorProvider;
import org.palladiosimulator.pcm.stoex.PCMStoexStandaloneSetup;

import com.google.inject.Injector;

/**
 * Provider to get an {@link Injector} for the StoEx language.
 * 
 * The class is meant to be used in standalone environments. It should never be necessary to get an
 * {@link Injector} in OSGi environments.
 * 
 * The implementation creates a {@link PCMStoexStandaloneSetup} instance and calls it.
 */
public class XtextStoExInjectorProvider extends GenericXtextStoExStandaloneInjectorProvider {

    private static final Provider<Injector> INSTANCE = new XtextStoExInjectorProvider();

    /**
     * Constructor not meant to be called by users.
     */
    protected XtextStoExInjectorProvider() {
        // intentionally left blank
    }

    /**
     * Get the instance of the provider.
     * 
     * @return The instance.
     */
    public static Provider<Injector> getInstance() {
        return INSTANCE;
    }

    @Override
    protected ISetup getStoexSetup() {
        return new PCMStoexStandaloneSetup();
    }

}

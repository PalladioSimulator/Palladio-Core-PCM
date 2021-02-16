package org.palladiosimulator.pcm.stoex.api.impl;

import javax.inject.Provider;

import org.eclipse.xtext.ISetup;
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
public class XtextStoExInjectorProvider implements Provider<Injector> {

    private static final Provider<Injector> INSTANCE = new XtextStoExInjectorProvider();
    private volatile Injector stoExInjector;

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
    public Injector get() {
        if (stoExInjector == null) {
            synchronized (this) {
                if (stoExInjector == null) {
                    stoExInjector = getStoexSetup().createInjectorAndDoEMFRegistration();
                }
            }
        }
        return stoExInjector;
    }

    /**
     * Finds an {@link ISetup} implementation to get an {@link Injector} instance from.
     * 
     * The implementation uses the {@link PCMStoexStandaloneSetup}.
     * 
     * @return The {@link ISetup} instance.
     */
    protected ISetup getStoexSetup() {
        return new PCMStoexStandaloneSetup();
    }
}

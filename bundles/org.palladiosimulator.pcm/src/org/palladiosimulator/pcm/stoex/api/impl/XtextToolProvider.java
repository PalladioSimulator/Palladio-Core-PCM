package org.palladiosimulator.pcm.stoex.api.impl;

import javax.inject.Provider;

/**
 * Base interface to get an Xtext tool like parsers or serialisers.
 * 
 * @param <T>
 *            The type of the tool to get.
 */
public interface XtextToolProvider<T> extends Provider<T> {

}

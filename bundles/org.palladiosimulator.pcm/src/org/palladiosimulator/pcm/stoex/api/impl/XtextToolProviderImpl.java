package org.palladiosimulator.pcm.stoex.api.impl;

import java.util.Optional;

import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.IEditorInput;
import org.palladiosimulator.commons.eclipseutils.ExtensionHelper;

/**
 * Abstract base class for {@link XtextToolProvider} implementations.
 * 
 * The logic first tries to collect an implementation from an extension point and tries to create an
 * instance from a standalone initialised provider afterwards. The implementation guarantees to
 * return an implementation if the requested tool type can be provided by the Xtext framework.
 *
 * @param <T>
 *            The type of the requested tool.
 */
public abstract class XtextToolProviderImpl<T> implements XtextToolProvider<T> {

    private final String extensionPointId;
    private final Class<T> requestedType;
    private final String extensionPointAttr;

    /**
     * Initializes the base class with necessary information.
     * 
     * @param requestedType
     *            The type of the requested tool.
     * @param extensionPointId
     *            The extension point id that provides implementations for the requested tool.
     * @param extensionPointAttr
     *            The attribute that contains the tool object.
     */
    public XtextToolProviderImpl(Class<T> requestedType, String extensionPointId, String extensionPointAttr) {
        this.requestedType = requestedType;
        this.extensionPointId = extensionPointId;
        this.extensionPointAttr = extensionPointAttr;
    }

    @Override
    public T get() {
        return getExtension().orElseGet(this::getStandalone);
    }

    /**
     * Gets the requested tool from the extension point given in the constructor.
     * 
     * If multiple extensions are provided, the implementation returns a random implementation.
     * 
     * @return The found extension or an empty {@link Optional} otherwise.
     */
    protected Optional<T> getExtension() {
        if (!Platform.isRunning()) {
            return Optional.empty();
        }
        try {
            // This is done because the Xtext framework requires the Eclipse UI bundle to be loaded
            // when running within the platform. 
            IEditorInput.class.getClass();
        } catch (NoClassDefFoundError e) {
            return Optional.empty();
        }
        final var foundExtensions = ExtensionHelper.<T> getExecutableExtensions(extensionPointId, extensionPointAttr);
        if (foundExtensions.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(foundExtensions.get(0));
    }

    /**
     * Gets the requested tool based on a standalone initialization.
     * 
     * @return The created tool.
     */
    protected T getStandalone() {
        return XtextStoExInjectorProvider.getInstance()
            .get()
            .getInstance(requestedType);
    }

}

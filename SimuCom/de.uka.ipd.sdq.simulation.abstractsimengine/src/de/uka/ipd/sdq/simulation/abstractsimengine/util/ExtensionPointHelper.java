package de.uka.ipd.sdq.simulation.abstractsimengine.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;

/**
 * 
 * Helper class for working with the Eclipse extension point mechanism.
 * 
 * TODO: This class should reside in a general plug-in like "de.uka.ipd.sdq.utils".
 * 
 * @author Philipp Merkle
 * 
 */
public class ExtensionPointHelper {

    public static List<IConfigurationElement> findConfigurationElements(IExtension extension, String elementName)
            throws CoreException {
        List<IConfigurationElement> result = new ArrayList<IConfigurationElement>();
        IConfigurationElement[] elements = extension.getConfigurationElements();
        for (IConfigurationElement element : elements) {
            if (element.getName().equals(elementName)) {
                result.add(element);
            }
        }
        return result;
    }

    public static List<IExtension> findExtensions(String extensionPointId) {
        IExtension[] exts = Platform.getExtensionRegistry().getExtensionPoint(extensionPointId).getExtensions();
        List<IExtension> results = new ArrayList<IExtension>();
        for (IExtension extension : exts) {
            results.add(extension);
        }
        return results;
    }

}

package de.uka.ipd.sdq.simulation.abstractsimengine.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;

import de.uka.ipd.sdq.simulation.abstractsimengine.ISimEngineFactory;

/**
 * Helper class for the extension point {@code de.uka.ipd.sdq.simulation.abstractsimengine.engine}
 * ("Abstract Simulation Engine").
 * 
 * @author Philipp Merkle
 * 
 */
public class AbstractSimEngineExtensionHelper {

    /** the id for the "Palladio Simulator" extension point */
    public static final String EXTENSION_POINT_ID = "de.uka.ipd.sdq.simulation.abstractsimengine.engine";

    public static String[] getEngineNames() throws CoreException {
        List<String> names = new ArrayList<String>();
        for (IExtension extension : ExtensionPointHelper.findExtensions(EXTENSION_POINT_ID)) {
            for (IConfigurationElement e : ExtensionPointHelper.findConfigurationElements(extension, "engine")) {
                if (e != null) {
                    names.add(e.getAttribute("name"));
                }
            }
        }
        return names.toArray(new String[names.size()]);
    }

    public static String[][] getEngineNamesAndIds() throws CoreException {
        List<String[]> names = new ArrayList<String[]>();
        for (IExtension extension : ExtensionPointHelper.findExtensions(EXTENSION_POINT_ID)) {
            for (IConfigurationElement e : ExtensionPointHelper.findConfigurationElements(extension, "engine")) {
                if (e != null) {
                    names.add(new String[] {
                            e.getAttribute("name"), e.getAttribute("id")
                    });
                }
            }
        }
        return names.toArray(new String[names.size()][2]);
    }

    public static String getEngineNameForId(String engineId) throws CoreException {
        for (IExtension extension : ExtensionPointHelper.findExtensions(EXTENSION_POINT_ID)) {
            for (IConfigurationElement e : ExtensionPointHelper.findConfigurationElements(extension, "engine")) {
                if (e != null && e.getAttribute("id").equals(engineId)) {
                    return e.getAttribute("name");
                }
            }
        }

        // could not find an extension for the specified id
        return "";
    }

    public static String getEngineIdForName(String engineName) throws CoreException {
        for (IExtension extension : ExtensionPointHelper.findExtensions(EXTENSION_POINT_ID)) {
            for (IConfigurationElement e : ExtensionPointHelper.findConfigurationElements(extension, "engine")) {
                if (e != null && e.getAttribute("name").equals(engineName)) {
                    return e.getAttribute("id");
                }
            }
        }

        // could not find an extension for the specified name
        return "";
    }

    public static ISimEngineFactory getEngineFactory(String engineId) throws CoreException {
        for (IExtension extension : ExtensionPointHelper.findExtensions(EXTENSION_POINT_ID)) {
            for (IConfigurationElement e : ExtensionPointHelper.findConfigurationElements(extension, "engine")) {
                if (e != null && e.getAttribute("id").equals(engineId)) {
                    return (ISimEngineFactory) e.createExecutableExtension("class");
                }
            }
        }

        // could not find an extension for the specified id
        return null;
    }

}

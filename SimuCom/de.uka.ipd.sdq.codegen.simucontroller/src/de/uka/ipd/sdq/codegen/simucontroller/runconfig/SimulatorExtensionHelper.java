package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;

/**
 * Helper class for the extension point de.uka.ipd.sdq.codegen.simucontroller.simulator
 * ("Palladio Simulator").
 * 
 * @author Philipp Merkle
 * 
 */
public class SimulatorExtensionHelper {

    /** the id for the "Palladio Simulator" extension point */
    public static final String EXTENSION_POINT_ID = "de.uka.ipd.sdq.codegen.simucontroller.simulator";

    public static String[] getSimulatorNames() throws CoreException {
        List<String> names = new ArrayList<String>();
        for (IExtension extension : loadSimulatorExtensions()) {
            IConfigurationElement e = obtainConfigurationElement("simulator", extension);
            if (e != null) {
                names.add(e.getAttribute("name"));
            }
        }
        return names.toArray(new String[names.size()]);
    }

    public static String getSimulatorNameForId(String simulatorId) throws CoreException {
        for (IExtension extension : loadSimulatorExtensions()) {
            IConfigurationElement e = obtainConfigurationElement("simulator", extension);
            if (e != null && e.getAttribute("id").equals(simulatorId)) {
                return e.getAttribute("name");
            }
        }

        // could not find a simulator extension for the specified id
        return "";
    }

    public static String getSimulatorIdForName(String simulatorName) throws CoreException {
        for (IExtension extension : loadSimulatorExtensions()) {
            IConfigurationElement e = obtainConfigurationElement("simulator", extension);
            if (e != null && e.getAttribute("name").equals(simulatorName)) {
                return e.getAttribute("id");
            }
        }

        // could not find a simulator extension for the specified name
        return "";
    }

    private static IConfigurationElement obtainConfigurationElement(String elementName, IExtension extension)
            throws CoreException {
        IConfigurationElement[] elements = extension.getConfigurationElements();
        for (IConfigurationElement element : elements) {
            if (element.getName().equals(elementName)) {
                return element;
            }
        }
        return null;
    }

    private static List<IExtension> loadSimulatorExtensions() {
        IExtension[] exts = Platform.getExtensionRegistry().getExtensionPoint(EXTENSION_POINT_ID).getExtensions();
        List<IExtension> results = new ArrayList<IExtension>();
        for (IExtension extension : exts) {
            results.add(extension);
        }
        return results;
    }

}

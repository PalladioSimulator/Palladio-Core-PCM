package edu.kit.ipd.sdq.simcomp.middleware;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

import edu.kit.ipd.sdq.simcomp.component.meta.SimulationComponentType;

/**
 * This class reads the meta information about all simulation components
 * registered over the extension point mechanism in form of a proper data
 * structure.
 * 
 * TODO (SimComp): Add GUI contribution for simulation components
 * 
 * @author Christoph Föhrdes
 * 
 */
public class SimulationComponentMetaCollector {

	private static String SIMCOMP_TYPE_EXTENSION_POINT = "edu.kit.ipd.sdq.simcomp.middleware.simulationComponentType";
	private static String SIMCOMP_EXTENSION_POINT = "edu.kit.ipd.sdq.simcomp.middleware.simulationComponent";

	private IExtensionRegistry registry;

	private SimulationComponentMetaCollector() {
		// this factory is intended to be used in a static way

		registry = Platform.getExtensionRegistry();
	}

	/**
	 * Builds a list of meta data of all registered simulation component.
	 * 
	 * @return A List of component type meta data
	 */
	public static List<SimulationComponentType> buildComponentMetaData() {
		SimulationComponentMetaCollector collector = new SimulationComponentMetaCollector();

		return collector.getSimulationComponentTypes();
	}

	/**
	 * Fetches all simulation component types registered at the extension point.
	 * 
	 * @return A List of component type meta data
	 */
	private List<SimulationComponentType> getSimulationComponentTypes() {
		List<SimulationComponentType> componentTypes = new ArrayList<SimulationComponentType>();

		IExtensionPoint point = registry.getExtensionPoint(SIMCOMP_TYPE_EXTENSION_POINT);
		IConfigurationElement[] elements = point.getConfigurationElements();
		for (IConfigurationElement configurationElement : elements) {
			String id = configurationElement.getAttribute("id");
			String name = configurationElement.getAttribute("name");
			String typeInterface = configurationElement.getAttribute("type_interface");
			SimulationComponentType componentType = new SimulationComponentType(id, name, typeInterface);

			// add the context fields
			this.addContextFields(componentType);

			// add the currently registered implementations
			this.addAvailableComponents(componentType);

			componentTypes.add(componentType);
		}

		return componentTypes;
	}

	/**
	 * Fetches all registered implementations of a given simulation component type
	 * and adds meta data about them to the type data.
	 * 
	 * @param componentType
	 */
	private void addAvailableComponents(SimulationComponentType componentType) {
		// TODO (SimComp): Fetch and Build component data from extensions
	}

	/**
	 * Fetches all registered simulation context fields of a given simulation component type
	 * and adds meta data about them to the type data.
	 * 
	 * @param componentType
	 */
	private void addContextFields(SimulationComponentType componentType) {
		// TODO (SimComp): Fetch and Build context field data from extensions
	}

}

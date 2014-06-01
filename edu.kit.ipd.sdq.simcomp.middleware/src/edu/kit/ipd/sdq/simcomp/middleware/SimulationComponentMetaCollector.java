package edu.kit.ipd.sdq.simcomp.middleware;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

import edu.kit.ipd.sdq.simcomp.component.meta.SimulationComponentMeta;
import edu.kit.ipd.sdq.simcomp.component.meta.SimulationComponentType;
import edu.kit.ipd.sdq.simcomp.component.meta.SimulationContextField;

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

	public static String SIMCOMP_TYPE_EXTENSION_POINT = "edu.kit.ipd.sdq.simcomp.middleware.simulationComponentType";
	public static String SIMCOMP_EXTENSION_POINT = "edu.kit.ipd.sdq.simcomp.middleware.simulationComponent";

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
		List<SimulationComponentType> componentTypes = collector.getSimulationComponentTypes();
		Collections.sort(componentTypes);

		return componentTypes;
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
			this.addContextFields(componentType, configurationElement);

			// add the currently registered implementations
			this.addAvailableComponents(componentType);

			componentTypes.add(componentType);
		}

		return componentTypes;
	}

	/**
	 * Fetches all registered simulation context fields of a given simulation
	 * component type and adds meta data about them to the type data.
	 * 
	 * @param componentType
	 */
	private void addContextFields(SimulationComponentType componentType, IConfigurationElement configurationElement) {
		IConfigurationElement[] fieldElements = configurationElement.getChildren("simulation_context_field");
		for (IConfigurationElement fieldElement : fieldElements) {
			String id = fieldElement.getAttribute("id");
			String name = fieldElement.getAttribute("name");
			SimulationContextField field = new SimulationContextField(id, componentType, name);
			componentType.addContextField(field);
		}
	}

	/**
	 * Fetches all registered implementations of a given simulation component
	 * type and adds meta data about them to the type data.
	 * 
	 * @param componentType
	 */
	private void addAvailableComponents(SimulationComponentType componentType) {
		IExtensionPoint point = registry.getExtensionPoint(SIMCOMP_EXTENSION_POINT);
		IConfigurationElement[] elements = point.getConfigurationElements();

		for (IConfigurationElement configurationElement : elements) {
			String typeId = configurationElement.getAttribute("type");

			if (componentType.getId().equalsIgnoreCase(typeId)) {
				String id = configurationElement.getAttribute("id");
				String name = configurationElement.getAttribute("name");
				String componentClass = configurationElement.getAttribute("component_class");
				SimulationComponentMeta component = new SimulationComponentMeta(id, name, componentClass, componentType);
				componentType.addComponent(component);
			}
		}
	}

}

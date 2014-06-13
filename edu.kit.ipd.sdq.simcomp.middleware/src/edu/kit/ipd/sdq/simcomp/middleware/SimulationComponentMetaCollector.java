package edu.kit.ipd.sdq.simcomp.middleware;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

import edu.kit.ipd.sdq.simcomp.component.meta.SimulationComponentRequiredType;
import edu.kit.ipd.sdq.simcomp.component.meta.SimulationComponentImpl;
import edu.kit.ipd.sdq.simcomp.component.meta.SimulationComponentType;
import edu.kit.ipd.sdq.simcomp.component.meta.SimulationContextField;

/**
 * This class reads the meta information about all simulation components
 * registered over the extension point mechanism in form of a proper data
 * structure.
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
	 * Builds the metadata of all registered simulation components based on the
	 * registrations at the simulation middleware extension points.
	 * 
	 * @return A list of component metadata
	 */
	public static List<SimulationComponentImpl> buildComponentMetaData() {
		SimulationComponentMetaCollector collector = new SimulationComponentMetaCollector();

		return collector.getRegisteredSimulationComponents();
	}

	/**
	 * Reads all simulation component implementations registered at the
	 * middleware extension point and converts them to the metadata class
	 * structure.
	 * 
	 * @return A list of component implementation metadata objects
	 */
	private List<SimulationComponentImpl> getRegisteredSimulationComponents() {
		List<SimulationComponentImpl> components = new ArrayList<SimulationComponentImpl>();

		IExtensionPoint point = registry.getExtensionPoint(SIMCOMP_EXTENSION_POINT);
		IConfigurationElement[] elements = point.getConfigurationElements();

		for (IConfigurationElement configurationElement : elements) {
			String id = configurationElement.getAttribute("id");
			String name = configurationElement.getAttribute("name");
			String componentClass = configurationElement.getAttribute("component_class");

			SimulationComponentImpl component = new SimulationComponentImpl(id, name, componentClass);

			this.addProvidedTypes(component, configurationElement);
			this.addRequiredTypes(component, configurationElement);

			components.add(component);
		}

		return components;
	}

	/**
	 * Converts all registered provided interface types from the configuration,
	 * converts them to the metadata class structure and adds them to the
	 * simulation component metadata object.
	 * 
	 * @param component
	 *            The component to add the provided interface types to
	 * @param configurationElement
	 *            The simulation component registration configuration element to
	 *            read the information from.
	 */
	private void addProvidedTypes(SimulationComponentImpl component, IConfigurationElement configurationElement) {
		IConfigurationElement[] providedTypeElements = configurationElement.getChildren("provided_type");
		for (IConfigurationElement providedTypeElement : providedTypeElements) {

			SimulationComponentType type = this.getSimulationComponentTypeForId(providedTypeElement.getAttribute("type"));

			component.addProvidedType(type);
		}
	}

	/**
	 * Converts all registered required interface types and their context fields
	 * from the configuration, converts them to the metadata class structure and
	 * adds them to the simulation component metadata object.
	 * 
	 * @param component
	 *            The component to add the required interface types and context
	 *            fields to
	 * @param configurationElement
	 *            The simulation component registration configuration element to
	 *            read the information from.
	 */
	private void addRequiredTypes(SimulationComponentImpl component, IConfigurationElement configurationElement) {
		IConfigurationElement[] requiredTypeElements = configurationElement.getChildren("required_type");
		for (IConfigurationElement requiredTypeElement : requiredTypeElements) {

			SimulationComponentType type = this.getSimulationComponentTypeForId(requiredTypeElement.getAttribute("type"));
			SimulationComponentRequiredType requiredType = new SimulationComponentRequiredType(component, type);

			this.addContextFields(requiredType, requiredTypeElement);

			component.addRequiredType(requiredType);
		}

	}

	/**
	 * Fetches all registered simulation context fields for a given required
	 * simulation component type, converts them to the metadata class structure
	 * and adds them to the required type.
	 * 
	 * @param componentType
	 */
	private void addContextFields(SimulationComponentRequiredType componentType, IConfigurationElement configurationElement) {
		IConfigurationElement[] fieldElements = configurationElement.getChildren("context_field");
		for (IConfigurationElement fieldElement : fieldElements) {

			String id = fieldElement.getAttribute("id");
			String name = fieldElement.getAttribute("name");

			componentType.addContextField(new SimulationContextField(id, name));
		}
	}

	/**
	 * Creates a simulation component type metadata object based on the given id
	 * by reading the information about it form the middleware extension point
	 * where the types are registered.
	 * 
	 * @param typeId
	 *            An id of a registered simulation component type
	 * @return A simulation component type metadata object
	 */
	private SimulationComponentType getSimulationComponentTypeForId(String typeId) {
		IExtensionPoint point = registry.getExtensionPoint(SIMCOMP_TYPE_EXTENSION_POINT);
		IConfigurationElement[] elements = point.getConfigurationElements();

		for (IConfigurationElement configurationElement : elements) {
			String id = configurationElement.getAttribute("id");

			if (typeId.equals(id)) {

				String name = configurationElement.getAttribute("name");
				String typeInterface = configurationElement.getAttribute("type_interface");

				return new SimulationComponentType(id, name, typeInterface);
			}
		}

		throw new IllegalStateException("There was no registered simulation component type found for id " + typeId);
	}

}

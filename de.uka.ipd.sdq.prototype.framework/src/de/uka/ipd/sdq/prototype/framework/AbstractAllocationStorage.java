package de.uka.ipd.sdq.prototype.framework;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Manages the sets of container ID, name and allocated components
 * 
 * @author zolynski
 */
public abstract class AbstractAllocationStorage {
	protected static AbstractAllocationStorage singleton;

	private static Map<String, String> containerIdToName = new HashMap<String, String>();
	private static Map<String, List<ComponentAllocation>> containerIdToComponents = new HashMap<String, List<ComponentAllocation>>();

	private static String activeContainer;
	private static boolean localMode = false;

	/**
	 * Stores a tuple of container ID, name and one component, as well as the
	 * assembly context of the component.
	 * 
	 * @param containerId
	 *            key, can be used multiple times
	 * @param containerName
	 *            value
	 * @param component
	 *            value
	 * @param assemblyContext
	 *            ID of the assembly context
	 */
	protected static void saveContainerComponent(String containerId, String containerName, Class<?> component, String assemblyContext) {
		if (!containerIdToName.containsKey(containerId)) {
			containerIdToName.put(containerId, containerName);
			containerIdToComponents.put(containerId, new LinkedList<ComponentAllocation>());
		}

		containerIdToComponents.get(containerId).add(new ComponentAllocation(component, assemblyContext));
	}

	public static String getContainerName(String containerId) {
		return containerIdToName.get(containerId);
	}

	/**
	 * FIXME: Possible source of errors if two container have the same name?
	 * 
	 * @param container
	 * @return
	 */
	public static String getContainerID(String container) {
		for (Entry<String, String> entry : containerIdToName.entrySet()) {
			if (entry.getValue().equals(container)) {
				return entry.getKey();
			}
		}
		return null;
	}

	/**
	 * Returns a set of all container ids
	 * 
	 * @return Set of container ids
	 */
	public static Collection<String> getContainerIds() {
		return containerIdToName.keySet();
	}

	/**
	 * Returns a set of all container names
	 * 
	 * @return Set of container names
	 */
	public static Collection<String> getContainerNames() {
		return containerIdToName.values();
	}

	/**
	 * Returns a collection of components to a given container id
	 * 
	 * @param containerId
	 * @return collection of components
	 */
	public static Collection<ComponentAllocation> getComponents(String containerId) {
		return containerIdToComponents.get(containerId);
	}


	protected abstract void initContainerTemplate();

	public static void initContainer() {
		singleton.initContainerTemplate();
	}

	public static void initSingleton(AbstractAllocationStorage instance) {
		singleton = instance;
	}

	public static void setActiveContainer(String containerId) {
		activeContainer = containerId;
	}

	/**
	 * Returns the container of this current component. FIXME: Also returns the
	 * FIRST container if local mode is active, since no container has been (and
	 * can not be) chosen for this hardware node.
	 * 
	 * @return
	 */
	public static String getActiveContainer() {
		if (!localMode) {
			return activeContainer;
		} else {
			return containerIdToName.entrySet().iterator().next().getKey();
		}
	}

	public static void setLocalMode(boolean localMode) {
		AbstractAllocationStorage.localMode = localMode;
	}

	public static boolean isLocalMode() {
		return localMode;
	}

}

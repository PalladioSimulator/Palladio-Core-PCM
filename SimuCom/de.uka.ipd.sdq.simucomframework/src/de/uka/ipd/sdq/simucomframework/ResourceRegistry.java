package de.uka.ipd.sdq.simucomframework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.resources.AbstractScheduledResource;
import de.uka.ipd.sdq.simucomframework.resources.AbstractSimulatedResourceContainer;
import de.uka.ipd.sdq.simucomframework.resources.SimulatedLinkingResourceContainer;
import de.uka.ipd.sdq.simucomframework.resources.SimulatedResourceContainer;

/**
 * Central registry for all simulated resources. The central registry can be used to start and stop
 * all resources simultaniously
 * 
 * @author Steffen Becker
 *
 */
public class ResourceRegistry {
    // ResourceContainerID -> ResourceContainer Object
    private final HashMap<String, AbstractSimulatedResourceContainer> resourceContainerHash = new HashMap<String, AbstractSimulatedResourceContainer>();

    private SimuComModel myModel = null;

    public ResourceRegistry(SimuComModel model) {
        this.myModel = model;
    }

    /**
     * Create and add a PCM ResourceContainer
     * 
     * @param containerID
     *            PCM ID of the resource container to create
     * @return The simulated resource container object
     */
    public AbstractSimulatedResourceContainer createResourceContainer(String containerID) {
        if (!resourceContainerHash.containsKey(containerID)) {
            SimulatedResourceContainer container = new SimulatedResourceContainer(myModel, containerID);
            addResourceContainer(container);
        }
        return resourceContainerHash.get(containerID);
    }

    /**
     * Add a PCM ResourceContainer
     * 
     * @param container
     *            the resource container to add
     */
    public void addResourceContainer(SimulatedResourceContainer container) {
        assert (!resourceContainerHash.containsKey(container.getResourceContainerID()));
        resourceContainerHash.put(container.getResourceContainerID(), container);
    }

    /**
     * Create a simulated PCM LinkingResource
     * 
     * @param containerID
     *            PCM ID of the LinkingResource
     * @return The resource container introduced for the linking resource. Note, this container is
     *         virtuall as it does not exist in the PCMs orginal model. However, it exists in the
     *         simulation to unify resource container and link resource behaviour.
     */
    public AbstractSimulatedResourceContainer createLinkingResourceContainer(String containerID) {
        if (!resourceContainerHash.containsKey(containerID)) {
            SimulatedLinkingResourceContainer container = new SimulatedLinkingResourceContainer(myModel, containerID);
            resourceContainerHash.put(containerID, container);
        }
        return resourceContainerHash.get(containerID);
    }

    /**
     * Add a PCM LinkingResourceContainer
     * 
     * @param container
     *            the linking resource container to add
     */
    public void addLinkingResourceContainer(SimulatedLinkingResourceContainer container) {
        assert (!resourceContainerHash.containsKey(container.getResourceContainerID()));
        resourceContainerHash.put(container.getResourceContainerID(), container);
    }

    public List<SimulatedLinkingResourceContainer> getLinkingResourceContainers() {
        List<SimulatedLinkingResourceContainer> resourceContainers = new ArrayList<SimulatedLinkingResourceContainer>();
        for (AbstractSimulatedResourceContainer container : resourceContainerHash.values()) {
            if (container instanceof SimulatedLinkingResourceContainer) {
                resourceContainers.add((SimulatedLinkingResourceContainer) container);
            }
        }
        return resourceContainers;
    }

    public List<SimulatedResourceContainer> getSimulatedResourceContainers() {
        List<SimulatedResourceContainer> resourceContainers = new ArrayList<SimulatedResourceContainer>();
        for (AbstractSimulatedResourceContainer container : resourceContainerHash.values()) {
            if (container instanceof SimulatedResourceContainer) {
                resourceContainers.add((SimulatedResourceContainer) container);
            }
        }
        return resourceContainers;
    }

    /**
     * @param resourceContainerID
     *            ID of the container
     * @return True if the given ID is known in the resource registry
     */
    public boolean containsResourceContainer(String resourceContainerID) {
        return resourceContainerHash.containsKey(resourceContainerID);
    }

    /**
     * Retrieve the resource container with the given ID
     * 
     * @param resourceContainerID
     *            ID of the container to retrieve. The container must exist in this registry
     * @return The queried resource container
     */
    public AbstractSimulatedResourceContainer getResourceContainer(String resourceContainerID) {
        assert containsResourceContainer(resourceContainerID);
        return resourceContainerHash.get(resourceContainerID);
    }

    /**
     * Retrieve the resource container with the given ID
     * 
     * @param resourceContainerID
     *            ID of the container to retrieve. The container must exist in this registry
     * @return The queried resource container
     */
    public AbstractSimulatedResourceContainer removeResourceContainerFromRegistry(String resourceContainerID) {
        AbstractSimulatedResourceContainer container = null;
        if (containsResourceContainer(resourceContainerID)) {
            container = resourceContainerHash.get(resourceContainerID);
            resourceContainerHash.remove(resourceContainerID);
        }
        return container;
    }

    /**
     * Start all simulated resources in the simulation framework
     */
    public void activateAllActiveResources() {
        ArrayList<AbstractScheduledResource> resources = new ArrayList<AbstractScheduledResource>();
        for (AbstractSimulatedResourceContainer src : resourceContainerHash.values()) {
            resources.addAll(src.getActiveResources());
        }
        for (AbstractScheduledResource sar : resources) {
            sar.activateResource();
        }
    }

    /**
     * Stop all resources in the simulation framework
     */
    public void deactivateAllActiveResources() {
        ArrayList<AbstractScheduledResource> resources = new ArrayList<AbstractScheduledResource>();
        for (AbstractSimulatedResourceContainer src : resourceContainerHash.values()) {
            resources.addAll(src.getActiveResources());
        }
        for (AbstractScheduledResource sar : resources) {
            sar.deactivateResource();
        }
    }

    public void deactivateAllPassiveResources() {
        // TODO Is it necessary to deactivate passive resources here or is this
        // already done elsewhere?
    }

}

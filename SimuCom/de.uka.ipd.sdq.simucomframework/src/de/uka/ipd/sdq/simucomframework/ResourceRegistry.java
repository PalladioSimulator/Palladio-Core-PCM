package de.uka.ipd.sdq.simucomframework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.palladiosimulator.commons.designpatterns.AbstractObservable;
import org.palladiosimulator.commons.designpatterns.IAbstractObservable;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.resources.AbstractScheduledResource;
import de.uka.ipd.sdq.simucomframework.resources.AbstractSimulatedResourceContainer;
import de.uka.ipd.sdq.simucomframework.resources.IResourceEnvironmentListener;
import de.uka.ipd.sdq.simucomframework.resources.SimulatedLinkingResourceContainer;
import de.uka.ipd.sdq.simucomframework.resources.SimulatedResourceContainer;

/**
 * Central registry for simulated resources (resource containers, linking resources). The central
 * registry can be used to start and stop all resources simultaniously.
 *
 * @author Steffen Becker, Sebastian Lehrig
 */
public class ResourceRegistry implements IAbstractObservable<IResourceEnvironmentListener> {

    /** ResourceContainerID -> ResourceContainer Object */
    private final Map<String, AbstractSimulatedResourceContainer> resourceContainerHash = new HashMap<String, AbstractSimulatedResourceContainer>();

    /** Delegator object used for implementing IAbstractObservable (c.f., "Delegator pattern") */
    private final AbstractObservable<IResourceEnvironmentListener> observableDelegate;

    private final SimuComModel myModel;

    /**
     * Default initialization.
     *
     * @param model
     *            the corresponding SimuCom model.
     */
    public ResourceRegistry(final SimuComModel model) {
        super();
        this.myModel = model;
        this.observableDelegate = new AbstractObservable<IResourceEnvironmentListener>() {
        };
    }

    /**
     * Add a PCM ResourceContainer
     *
     * @param container
     *            the resource container to add
     */
    public void addResourceContainer(final SimulatedResourceContainer container) {
        assert (!resourceContainerHash.containsKey(container.getResourceContainerID()));
        resourceContainerHash.put(container.getResourceContainerID(), container);
    }

    /**
     * Create and add a PCM ResourceContainer
     *
     * @param containerID
     *            PCM ID of the resource container to create
     * @return The simulated resource container object
     */
    public AbstractSimulatedResourceContainer createResourceContainer(final String containerID) {
        if (!resourceContainerHash.containsKey(containerID)) {
            final SimulatedResourceContainer container = new SimulatedResourceContainer(myModel, containerID);
            resourceContainerHash.put(container.getResourceContainerID(), container);
            this.observableDelegate.getEventDispatcher()
            .addedResourceContainer(container, resourceContainerHash.size());
        }
        return resourceContainerHash.get(containerID);
    }

    /**
     * Create a simulated PCM LinkingResource
     *
     * @param containerID
     *            PCM ID of the LinkingResource
     * @return The resource container introduced for the linking resource. Note, this container is
     *         virtual as it does not exist in the PCMs original model. However, it exists in the
     *         simulation to unify resource container and link resource behavior.
     */
    public AbstractSimulatedResourceContainer createLinkingResourceContainer(final String containerID) {
        if (!resourceContainerHash.containsKey(containerID)) {
            final SimulatedLinkingResourceContainer container = new SimulatedLinkingResourceContainer(myModel, containerID);
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
    public void addLinkingResourceContainer(final SimulatedLinkingResourceContainer container) {
        assert (!resourceContainerHash.containsKey(container.getResourceContainerID()));
        resourceContainerHash.put(container.getResourceContainerID(), container);
    }

    public List<SimulatedLinkingResourceContainer> getLinkingResourceContainers() {
        final List<SimulatedLinkingResourceContainer> resourceContainers = new ArrayList<SimulatedLinkingResourceContainer>();
        for (final AbstractSimulatedResourceContainer container : resourceContainerHash.values()) {
            if (container instanceof SimulatedLinkingResourceContainer) {
                resourceContainers.add((SimulatedLinkingResourceContainer) container);
            }
        }
        return resourceContainers;
    }

    public List<SimulatedResourceContainer> getSimulatedResourceContainers() {
        final List<SimulatedResourceContainer> resourceContainers = new ArrayList<SimulatedResourceContainer>();
        for (final AbstractSimulatedResourceContainer container : resourceContainerHash.values()) {
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
    public boolean containsResourceContainer(final String resourceContainerID) {
        return resourceContainerHash.containsKey(resourceContainerID);
    }

    /**
     * Retrieve the resource container with the given ID
     *
     * @param resourceContainerID
     *            ID of the container to retrieve. The container must exist in this registry
     * @return The queried resource container
     */
    public AbstractSimulatedResourceContainer getResourceContainer(final String resourceContainerID) {
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
    public AbstractSimulatedResourceContainer removeResourceContainerFromRegistry(final String resourceContainerID) {
        AbstractSimulatedResourceContainer container = null;
        if (containsResourceContainer(resourceContainerID)) {
            container = resourceContainerHash.get(resourceContainerID);
            resourceContainerHash.remove(resourceContainerID);

            if (container instanceof SimulatedResourceContainer) {
                this.observableDelegate.getEventDispatcher().removedResourceContainer(
                        (SimulatedResourceContainer) container, resourceContainerHash.size());
            }
        }
        return container;
    }

    /**
     * Start all simulated resources in the simulation framework
     */
    public void activateAllActiveResources() {
        final ArrayList<AbstractScheduledResource> resources = new ArrayList<AbstractScheduledResource>();
        for (final AbstractSimulatedResourceContainer src : resourceContainerHash.values()) {
            resources.addAll(src.getActiveResources());
        }
        for (final AbstractScheduledResource sar : resources) {
            sar.activateResource();
        }
    }

    /**
     * Stop all resources in the simulation framework
     */
    public void deactivateAllActiveResources() {
        final List<AbstractScheduledResource> resources = new ArrayList<AbstractScheduledResource>();
        for (final AbstractSimulatedResourceContainer src : resourceContainerHash.values()) {
            resources.addAll(src.getActiveResources());
        }
        for (final AbstractScheduledResource sar : resources) {
            sar.deactivateResource();
        }
    }

    public void deactivateAllPassiveResources() {
        // TODO Is it necessary to deactivate passive resources here or is this
        // already done elsewhere?
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addObserver(final IResourceEnvironmentListener observer) {
        observableDelegate.addObserver(observer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeObserver(final IResourceEnvironmentListener observer) {
        observableDelegate.removeObserver(observer);
    }

}

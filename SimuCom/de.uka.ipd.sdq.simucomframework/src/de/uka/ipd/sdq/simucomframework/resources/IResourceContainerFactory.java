package de.uka.ipd.sdq.simucomframework.resources;

/**
 * Interface for factories used to instanciate simulated resources in a execution environment
 * 
 * @author Steffen Becker
 *
 */
public interface IResourceContainerFactory {

    /**
     * @return A list of IDs of resource container existing in the resource environment to create
     */
    String[] getResourceContainerIDList();

    /**
     * Called by the framework to indicate that the given resource container should be set up
     * 
     * @param container
     *            The container to fill with active resources
     */
    void fillResourceContainerWithResources(SimulatedResourceContainer container);

    /**
     * Called by the framework to indicate that the given resource container should be set up
     * 
     * @param container
     *            The container to fill with active resources
     */
    void fillResourceContainerWithNestedResourceContainers(SimulatedResourceContainer container);

    /**
     * @return A list of IDs of linking resources existing in the resource environment to create
     */
    String[] getLinkingResourceContainerIDList();

    /**
     * Called by the framework to indicate that the given resource container should be set up
     * 
     * @param container
     *            The container to fill with active resources
     */
    void fillLinkingResourceContainer(SimulatedLinkingResourceContainer container);
}

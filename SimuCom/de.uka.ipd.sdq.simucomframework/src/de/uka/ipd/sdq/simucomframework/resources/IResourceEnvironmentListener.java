package de.uka.ipd.sdq.simucomframework.resources;

/**
 * Listener for resource environment changes.
 * 
 * @author Sebastian Lehrig
 */
public interface IResourceEnvironmentListener {

    public void addedResourceContainer(final SimulatedResourceContainer container, long totalContainers);

    public void removedResourceContainer(final SimulatedResourceContainer container, long totalContainers);

}

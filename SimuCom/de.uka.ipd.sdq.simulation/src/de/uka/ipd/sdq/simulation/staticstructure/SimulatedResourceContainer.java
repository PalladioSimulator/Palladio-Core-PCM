package de.uka.ipd.sdq.simulation.staticstructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.resourceenvironment.ContainerOperatingSystem;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceType;
import de.uka.ipd.sdq.simulation.entities.SimActiveResource;
import de.uka.ipd.sdq.simulation.util.PCMEntityHelper;

/**
 * A simulated resource container contains {@link SimActiveResource}s for various
 * {@link ResourceType}s.
 * 
 * @author Philipp Merkle
 * 
 */
public class SimulatedResourceContainer {

    private static Logger logger = Logger.getLogger(SimulatedResourceContainer.class);

    private ResourceContainer resourceContainer;
    private Map<ResourceType, SimActiveResource> typeToResourceMap;

    /**
     * Constructs an empty resource container
     * 
     * @param resourceContainer
     *            the resource container specification
     */
    public SimulatedResourceContainer(ResourceContainer resourceContainer) {
        this.resourceContainer = resourceContainer;
        typeToResourceMap = new HashMap<ResourceType, SimActiveResource>();
    }

    /**
     * Registers a resource for the specified resource type. Only one resource can be registered for
     * each resource type. Thus, providing a resource for an already registered resource type
     * overwrites the existing resource.
     * 
     * @param resource
     *            the resource that is to be registered
     * @param type
     *            the type of the resource
     */
    public void registerResource(SimActiveResource resource, ResourceType type) {
        if (logger.isDebugEnabled()) {
            logger.debug("Registering a " + type.getEntityName() + " resource at "
                    + PCMEntityHelper.toString(resourceContainer));
        }
        if (this.typeToResourceMap.containsKey(type)) {
            logger.warn("Registered a resource of type " + type.getEntityName()
                    + ", but there was already a resource of this type. The existing resource has been overwritten.");
        }

        this.typeToResourceMap.put(type, resource);
    }

    /**
     * Returns the resource that has been registered for the specified type.
     * 
     * @param type
     *            the resource type
     * @return the resource of the specified type, if there is one; null else
     */
    public SimActiveResource getResourceByType(ResourceType type) {
        return typeToResourceMap.get(type);
    }

    /**
     * Returns all resources provided by this resource container.
     * 
     * @return a list of all resources
     */
    public List<SimActiveResource> getResources() {
        List<SimActiveResource> resources = new ArrayList<SimActiveResource>();
        resources.addAll(typeToResourceMap.values());
        return resources;
    }

    /**
     * Returns the operating system type of this resource container.
     * 
     * @return the operating system
     */
    public ContainerOperatingSystem getOperatingSystem() {
        return resourceContainer.getOperatingSystem_ResourceContainer();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return PCMEntityHelper.toString(resourceContainer);
    }

}

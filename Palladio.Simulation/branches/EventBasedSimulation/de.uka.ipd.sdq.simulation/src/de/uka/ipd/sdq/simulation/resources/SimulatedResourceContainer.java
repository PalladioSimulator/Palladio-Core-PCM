package de.uka.ipd.sdq.simulation.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceType;
import de.uka.ipd.sdq.simulation.command.allocation.BuildResourceAllocation;
import de.uka.ipd.sdq.simulation.exceptions.concrete.ResourceInitialisationException;
import de.uka.ipd.sdq.simulation.util.PCMEntityHelper;

public class SimulatedResourceContainer {

    private static Logger logger = Logger.getLogger(BuildResourceAllocation.class);

    private ResourceContainer resourceContainer;
    private Map<ResourceType, SimulatedActiveResource> typeToResourceMap;

    public SimulatedResourceContainer(ResourceContainer resourceContainer) {
        this.resourceContainer = resourceContainer;
        typeToResourceMap = new HashMap<ResourceType, SimulatedActiveResource>();
    }

    public void registerResource(ResourceType type, SimulatedActiveResource resource) {
        if (logger.isDebugEnabled()) {
            logger.debug("Registering a " + type.getEntityName() + " resource at "
                    + PCMEntityHelper.toString(resourceContainer));
        }
        if (this.typeToResourceMap.containsKey(type)) {
            throw new ResourceInitialisationException("Tried to register a resource of type " + type.getEntityName()
                    + ", but there is already a resource of this type.");
        }

        this.typeToResourceMap.put(type, resource);
    }

    public SimulatedActiveResource getResourceByType(ResourceType type) {
        return typeToResourceMap.get(type);
    }

    public List<SimulatedActiveResource> getResources() {
        List<SimulatedActiveResource> resources = new ArrayList<SimulatedActiveResource>();
        resources.addAll(typeToResourceMap.values());
        return resources;
    }

    // public String getId() {
    // return resourceContainer.getId();
    // }

    public ResourceContainer getResourceContainer() {
        return resourceContainer;
    }

}

package edu.kit.ipd.sdq.eventsim.resources.staticstructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceType;
import edu.kit.ipd.sdq.eventsim.resources.entities.SimActiveResource;
import edu.kit.ipd.sdq.eventsim.util.PCMEntityHelper;

/**
 * A simulated resource container contains {@link SimActiveResource}s for various
 * {@link ResourceType}s.
 * 
 * @author Philipp Merkle
 * 
 */
public class SimulatedResourceContainer extends IResourceContainer {

    private static Logger logger = Logger.getLogger(SimulatedResourceContainer.class);

    private ResourceContainer specification;
    private Map<ResourceType, SimActiveResource> typeToResourceMap;
    private SimulatedResourceContainer parent;
    private List<SimulatedResourceContainer> nestedContainers;
    private List<CommunicationLink> communicationLinks;

    /**
     * Constructs an empty resource container, i.e. the container does not yet contain any
     * resources.
     * 
     * @param specification
     *            the resource container specification
     */
    public SimulatedResourceContainer(ResourceContainer specification) {
        this(specification, null);
    }

    /**
     * Constructs an empty resource container as a child (e.g. a virtual machine) of the specified
     * parent container (e.g. the physical host machine).
     * 
     * @param specification
     *            the resource container specification
     * @param parent
     *            the parent resource container
     */
    public SimulatedResourceContainer(ResourceContainer specification, SimulatedResourceContainer parent) {
        this.specification = specification;
        this.parent = parent;
        this.typeToResourceMap = new HashMap<ResourceType, SimActiveResource>();
        this.nestedContainers = new ArrayList<SimulatedResourceContainer>();
        this.communicationLinks = new ArrayList<CommunicationLink>();
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
                    + PCMEntityHelper.toString(specification));
        }
        if (this.typeToResourceMap.containsKey(type)) {
        	if(logger.isEnabledFor(Level.WARN))
        		logger.warn("Registered a resource of type " + type.getEntityName()
                    + ", but there was already a resource of this type. The existing resource has been overwritten.");
        }

        this.typeToResourceMap.put(type, resource);
    }

    public void registerCommunicationLink(CommunicationLink link) {
        if (logger.isDebugEnabled()) {
            logger.debug("Registering a communication link at " + PCMEntityHelper.toString(specification));
        }
        if (this.communicationLinks.contains(link)) {
        	if(logger.isEnabledFor(Level.WARN))
        		logger.warn("The communication link " + link + " has been registered multiple times.");
        }

        this.communicationLinks.add(link);
    }

    /**
     * Finds the resource that has been registered for the specified type. If no resource of the
     * specified type can be found, the search continues with the parent resource container.
     * 
     * @param type
     *            the resource type
     * @return the resource of the specified type, if there is one; null else
     */
    public SimActiveResource findResource(ResourceType type) {
        if (typeToResourceMap.containsKey(type)) {
            return typeToResourceMap.get(type);
        } else {
            if (parent != null) {
                return parent.findResource(type);
            } else {
                return null;
            }
        }
    }

    /**
     * Finds the communication link that connects this resource container to the specified target
     * resource container.
     * 
     * @param communicationTarget
     *            the target resource container
     * @return the communication link between the resource containers, if there is one; null else
     */
    public CommunicationLink findCommunicationLink(SimulatedResourceContainer communicationTarget) {
        for (CommunicationLink link : communicationLinks) {
            if (link.connects(this, communicationTarget)) {
                return link;
            }
        }

        // no communication link could be found
        return null;
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
     * Returns the parent resource container. For example, if this resource container represents a
     * virtual machine (VM), the parent resource container could represent the VM's physical host
     * machine.
     * 
     * @return the parent, if there is a parent; null else
     */
    public SimulatedResourceContainer getParent() {
        return parent;
    }

    public void addNestedContainer(SimulatedResourceContainer container) {
        this.nestedContainers.add(container);
    }

    public List<SimulatedResourceContainer> getNestedContainers() {
        return nestedContainers;
    }

    public ResourceContainer getSpecification() {
        return specification;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return PCMEntityHelper.toString(specification);
    }

}

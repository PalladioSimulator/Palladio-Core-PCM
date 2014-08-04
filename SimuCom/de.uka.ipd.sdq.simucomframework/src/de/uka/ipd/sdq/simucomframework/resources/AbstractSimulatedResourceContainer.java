package de.uka.ipd.sdq.simucomframework.resources;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.uka.ipd.sdq.simucomframework.SimuComSimProcess;
import de.uka.ipd.sdq.simucomframework.exceptions.ResourceContainerIsMissingRequiredResourceType;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

/**
 * Base class for simulated resource container. A resource container corresponds to PCM resource
 * container in such that they contain an arbitrary amount of active resources.
 * 
 * @author Steffen Becker, Sebastian Lehrig
 */
public abstract class AbstractSimulatedResourceContainer {

    protected static final Logger LOGGER = Logger.getLogger(AbstractSimulatedResourceContainer.class.getName());
    protected final SimuComModel myModel;
    protected final String myContainerID;

    // TODO: Multiple Resources with Scheduler
    protected final HashMap<String, AbstractScheduledResource> activeResources = new HashMap<String, AbstractScheduledResource>();

    // Resources can also be lookup by the provided resource interface id
    protected final HashMap<String, String> activeResourceProvidedInterfaces = new HashMap<String, String>();

    public AbstractSimulatedResourceContainer(final SimuComModel myModel, final String myContainerID) {
        super();
        this.myModel = myModel;
        this.myContainerID = myContainerID;
        if (LOGGER.isEnabledFor(Level.INFO)) {
            LOGGER.info("Simulated Resource Container created. ContainerID " + myContainerID);
        }
    }

    /**
     * Demand processing of a resource demand by a given type of active resources In future versions
     * this has to control schedulers of resource types which exist in multiple instances
     * 
     * @param requestingProcess
     *            The thread requesting the processing of a resource demand
     * @param typeID
     *            ID of the resource type to which the demand is directed. Same as the PCM resource
     *            type IDs
     * @param demand
     *            The demand in units processable by the resource. The resource is responsible
     *            itself for converting this demand into time spans
     */
    public void loadActiveResource(final SimuComSimProcess requestingProcess, final String typeID, final double demand) {
        AbstractScheduledResource resource = activeResources.get(typeID);
        if (resource == null) {
            throw new ResourceContainerIsMissingRequiredResourceType(typeID);
        }
        resource.consumeResource(requestingProcess, 1, Collections.<String, Serializable> emptyMap(), demand);
    }

    /**
     * Demand processing of a resource demand by a given type of active resource and a resource
     * interface operation
     * 
     * @param requestingProcess
     *            The thread requesting the processing of a resource demand
     * @param typeID
     *            ID of the resource provided interface to which the demand is directed.
     * @param resourceServiceID
     *            the id of the resource service to be called.
     * @param demand
     *            The demand in units processable by the resource. The resource is responsible
     *            itself for converting this demand into time spans
     */
    public void loadActiveResource(SimuComSimProcess requestingProcess, String providedInterfaceID,
            int resourceServiceID, double demand) {
        AbstractScheduledResource resource = null;
        String typeID = activeResourceProvidedInterfaces.get(providedInterfaceID);
        if (typeID != null) {
            resource = activeResources.get(typeID);
        }
        if (resource == null) {
            throw new ResourceContainerIsMissingRequiredResourceType(typeID);
        }
        resource.consumeResource(requestingProcess, resourceServiceID, Collections.<String, Serializable> emptyMap(),
                demand);
    }

    /**
     * Demand processing of a resource demand by a given type of active resource and a resource
     * interface operation and additional parameters which can be used in an active resource
     * 
     * @param requestingProcess
     *            The thread requesting the processing of a resource demand
     * @param providedInterfaceID
     *            ID of the resource provided interface to which the demand is directed.
     * @param resourceServiceID
     *            the id of the resource service to be called.
     * @param parameterMap
     *            Additional Parameters usable in an active resource. Parameters represented as
     *            <parameterName, specification>
     * @param demand
     *            The demand in units processable by the resource. The resource is responsible
     *            itself for converting this demand into time spans
     */
    public void loadActiveResource(final SimuComSimProcess requestingProcess, final String providedInterfaceID,
            final int resourceServiceID, final Map<String, Serializable> parameterMap, final double demand) {
        AbstractScheduledResource resource = null;
        String typeID = activeResourceProvidedInterfaces.get(providedInterfaceID);
        if (typeID != null) {
            resource = activeResources.get(typeID);
        }
        if (resource == null) {
            throw new ResourceContainerIsMissingRequiredResourceType(typeID);
        }
        resource.consumeResource(requestingProcess, resourceServiceID, parameterMap, demand);
    }

    /**
     * Retrieves all active resources in this resource container.
     * 
     * @return all active resources
     */
    public Collection<AbstractScheduledResource> getActiveResources() {
        return activeResources.values();
    }

    /**
     * Retrieves the HashMap with all all active resources in this resource container.
     * 
     * @return all active resources
     */
    public HashMap<String, AbstractScheduledResource> getAllActiveResources() {
        return activeResources;
    }

    /**
     * Retrieves all active resources in this resource container which are currently unavailable.
     * 
     * @return all unavailable active resources
     */
    public List<AbstractScheduledResource> getFailedResources() {
        List<AbstractScheduledResource> resultList = new ArrayList<AbstractScheduledResource>();
        Iterator<AbstractScheduledResource> iterator = getActiveResources().iterator();
        while (iterator.hasNext()) {
            AbstractScheduledResource resource = iterator.next();
            if (!resource.isAvailable() && resource.isRequiredByContainer()) {
                resultList.add(resource);
            }
        }
        return resultList;
    }

    /**
     * @return The ID of the resource container itself
     */
    public String getResourceContainerID() {
        return myContainerID;
    }

}

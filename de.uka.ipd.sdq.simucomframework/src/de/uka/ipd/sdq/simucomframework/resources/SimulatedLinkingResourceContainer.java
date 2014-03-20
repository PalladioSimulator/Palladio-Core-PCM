package de.uka.ipd.sdq.simucomframework.resources;

import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map.Entry;

import de.uka.ipd.sdq.simucomframework.SimuComSimProcess;
import de.uka.ipd.sdq.simucomframework.exceptions.ResourceContainerIsMissingRequiredResourceType;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public class SimulatedLinkingResourceContainer extends
AbstractSimulatedResourceContainer {

    public SimulatedLinkingResourceContainer(final SimuComModel myModel, final String id) {
        super(myModel, id);
    }

    public void addActiveResource(final String id, final String typeID,
            final String resourceContainerID, final String resourceTypeID,
            final String description, final String throughput, final String latencySpec,
            final Double failureProbability) {
        final SimulatedLinkingResource r = new SimulatedLinkingResource(id, myModel,
                typeID, resourceContainerID, resourceTypeID, description,
                throughput, latencySpec, failureProbability);
        activeResources.put(typeID, r);

        // setup calculators
        // TODO: setup waiting time calculator
        // CalculatorHelper.setupWaitingTimeCalculator(r);
        CalculatorHelper.setupDemandCalculator(r, this.myModel);
        CalculatorHelper.setupStateCalculator(r, this.myModel);
    }

    /**
     * Retrieves the id of the first (i.e. the one and only) communication link
     * resource specification.
     * 
     * @return the id of the communication link resource specification
     */
    public String getLinkingResourceId() {
        final Iterator<Entry<String, AbstractScheduledResource>> iterator = activeResources
                .entrySet().iterator();
        while (iterator.hasNext()) {
            final Entry<String, AbstractScheduledResource> entry = iterator.next();
            final SimulatedLinkingResource resource = (SimulatedLinkingResource) entry
                    .getValue();
            return resource.getId();
        }
        return null;
    }

    public void loadActiveResource(final SimuComSimProcess requestingProcess, final String originResourceContainerID, final String typeID, final double demand) {
        final AbstractScheduledResource resource = activeResources.get(typeID);
        if (resource == null) {
            throw new ResourceContainerIsMissingRequiredResourceType(typeID);
        }
        resource.consumeResource(requestingProcess, 1, Collections.<String, Serializable> emptyMap(), demand);
    }

    /**
     * Retrieves the id of the resource type of the first (i.e. the one and
     * only) communication link resource specification.
     * 
     * @return the resource type id
     */
    public String getLinkingResourceTypeId() {
        final Iterator<Entry<String, AbstractScheduledResource>> iterator = activeResources
                .entrySet().iterator();
        while (iterator.hasNext()) {
            final Entry<String, AbstractScheduledResource> entry = iterator.next();
            final SimulatedLinkingResource resource = (SimulatedLinkingResource) entry
                    .getValue();
            return resource.getResourceTypeId();
        }
        return null;
    }

    /**
     * Retrieves the resource type name of the first (i.e. the one and only)
     * communication link resource specification.
     * 
     * @return the resource type name of the communication link resource
     *         specification
     */
    public String getLinkingResourceTypeName() {
        final Iterator<Entry<String, AbstractScheduledResource>> iterator = activeResources
                .entrySet().iterator();
        while (iterator.hasNext()) {
            final Entry<String, AbstractScheduledResource> entry = iterator.next();
            final SimulatedLinkingResource resource = (SimulatedLinkingResource) entry
                    .getValue();
            return resource.getName();
        }
        return null;
    }
}

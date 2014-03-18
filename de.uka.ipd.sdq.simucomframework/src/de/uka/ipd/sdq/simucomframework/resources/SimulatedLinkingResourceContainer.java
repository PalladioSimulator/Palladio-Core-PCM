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

	public SimulatedLinkingResourceContainer(SimuComModel myModel, String id) {
		super(myModel, id);
	}

	public void addActiveResource(String id, String typeID,
			String resourceContainerID, String resourceTypeID,
			String description, String throughput, String latencySpec,
			Double failureProbability) {
		SimulatedLinkingResource r = new SimulatedLinkingResource(id, myModel,
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
		Iterator<Entry<String, AbstractScheduledResource>> iterator = activeResources
				.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, AbstractScheduledResource> entry = iterator.next();
			SimulatedLinkingResource resource = (SimulatedLinkingResource) entry
					.getValue();
			return resource.getId();
		}
		return null;
	}
	
	public void loadActiveResource(SimuComSimProcess requestingProcess, String originResourceContainerID, String typeID, double demand) {
		AbstractScheduledResource resource = activeResources.get(typeID);
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
		Iterator<Entry<String, AbstractScheduledResource>> iterator = activeResources
				.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, AbstractScheduledResource> entry = iterator.next();
			SimulatedLinkingResource resource = (SimulatedLinkingResource) entry
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
		Iterator<Entry<String, AbstractScheduledResource>> iterator = activeResources
				.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, AbstractScheduledResource> entry = iterator.next();
			SimulatedLinkingResource resource = (SimulatedLinkingResource) entry
					.getValue();
			return resource.getName();
		}
		return null;
	}
}

package de.uka.ipd.sdq.pcmsolver.transformations.pcm2markov;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.repository.FailureType;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.seff.performance.ParametricResourceDemand;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.transformations.ContextWrapper;

public class PCMInformationProvider {
	/**
	 * A logger to give detailed information about the PCM instance traversal.
	 */
	private static Logger logger = Logger.getLogger(PCMInformationProvider.class.getName());

	private PCMInstance model;

	public PCMInstance getModel() {
		return model;
	}

	private List<ProcessingResourceDescriptor> resourceDescriptors;
	public List<ProcessingResourceDescriptor> getResourceDescriptors() {
		return resourceDescriptors;
	}

	public List<FailureType> getFailureTypes(){
		return model.getRepository().getFailuretype();
	}
	
	public PCMInformationProvider(PCMInstance model) {
		this.model = model;
		this.resourceDescriptors = buildResourceDescriptors(model);
	}

	/**
	 * Builds a list of resource descriptors based on a given PCM instance.
	 * 
	 * @param model
	 *            the given PCM instance
	 * @return the list of resource descriptors
	 */
	private List<ProcessingResourceDescriptor> buildResourceDescriptors(final PCMInstance model) {

		// Create the result list:
		ArrayList<ProcessingResourceDescriptor> resultList = new ArrayList<ProcessingResourceDescriptor>();

		// Get the PCM resource containers, but only the ones that are used in
		// the ComputedAllocation
		Collection<ResourceContainer> resourceContainers = model.getUsedResourceContainer();

		// Go through the resource container list:
		for (ResourceContainer container : resourceContainers) {

			// Special case: ignore resource containers with the name
			// "SystemExternalResourceContainer", as they have been internally
			// created by the dependency solver:
			if (container.getEntityName().equals("SystemExternalResourceContainer")) {
				continue;
			}

			// Go through the list of resources in the container:
			for (ProcessingResourceSpecification resource : container.getActiveResourceSpecifications_ResourceContainer()) {

				// Special case: Ignore resource specifications

				// Each resource has a type and MTTF/MTTR values:
				Double resourceMTTF = resource.getMTTF();
				Double resourceMTTR = resource.getMTTR();
				ProcessingResourceType type = resource.getActiveResourceType_ActiveResourceSpecification();

				// Check the proper MTTF/MTTR specification:
				if ((resourceMTTF <= 0.0) || (resourceMTTR <= 0.0)) {
					logger.warn("Improper MTTF/MTTR specification for resource " + type.getEntityName() + " in container " + container.getEntityName()
							+ ": Both values should be positive. Assuming that resource is always ok");
					resourceMTTF = 1.0;
					resourceMTTR = 0.0;
				}

				// Generate a new descriptor:
				ProcessingResourceDescriptor descriptor = new ProcessingResourceDescriptor();
				descriptor.setContainerId(container.getId());
				descriptor.setTypeId(type.getId());
				descriptor.setContainerName(container.getEntityName());
				descriptor.setTypeName(type.getEntityName());
				descriptor.setStateProbability(ProcessingResourceState.OK, resourceMTTF / (resourceMTTF + resourceMTTR));
				descriptor.setStateProbability(ProcessingResourceState.NA, resourceMTTR / (resourceMTTF + resourceMTTR));
				resultList.add(descriptor);
			}
		}

		// Return the result:
		return resultList;
	}
	
	/**
	 * Retrieves a resource descriptor corresponding to the given resource
	 * demand.
	 * 
	 * @param demand
	 *            the resource demand
	 * @return the descriptor
	 */
	public ProcessingResourceDescriptor getDescriptor(
			final ParametricResourceDemand demand, ContextWrapper contextWrapper) {

		// Map the resource demand to a concrete resource:
		ProcessingResourceSpecification resource = contextWrapper
				.getConcreteProcessingResource(demand);
		if (resource == null) {
			return null;
		}

		// Get the IDs of the resource type and resource container:
		String resourceTypeId = resource
				.getActiveResourceType_ActiveResourceSpecification().getId();
		String containerId = contextWrapper.getAllCtx()
				.getResourceContainer_AllocationContext().getId();

		// Search for the right descriptor:
		for (ProcessingResourceDescriptor descriptor : resourceDescriptors) {

			// Compare the IDs to those of the descriptor:
			if ((descriptor.getProcessingResourceTypeId()
.equals(resourceTypeId)) && (descriptor.getResourceContainerId().equals(containerId))) {
				return descriptor;
			}
		}

		// No descriptor found:
		return null;
	}

}

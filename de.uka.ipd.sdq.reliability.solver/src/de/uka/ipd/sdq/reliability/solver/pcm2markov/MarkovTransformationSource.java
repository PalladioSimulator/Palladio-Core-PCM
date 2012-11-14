package de.uka.ipd.sdq.reliability.solver.pcm2markov;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.transformations.ContextWrapper;

/**
 * Holds state information required during the PCM2Markov transformation.
 * 
 * Holds a PCM instance as basis for the transformation, and keeps track of the physical system
 * states (i.e., states of processing resources) that are considered during the transformation.
 * 
 * @author brosch
 * 
 */
public class MarkovTransformationSource {

    /**
     * A logger to give detailed information about the PCM instance traversal.
     */
    private static Logger logger = Logger.getLogger(MarkovTransformationSource.class.getName());

    /**
     * The PCM instance.
     */
    private PCMInstance model;

    /**
     * The list of descriptors for processing resources.
     */
    private List<ProcessingResourceDescriptor> resourceDescriptors;

    /**
     * The list of descriptors for processing resources which have a failure probability greater
     * than zero.
     */
    private List<ProcessingResourceDescriptor> unreliableResourceDescriptors;

    /**
     * Initializes a PCMInformationProvider and creates the corresponding resource descriptors.
     * 
     * @param model
     *            the PCM instance
     * @param sortDescriptors
     *            indicates if the list of resource descriptors shall be sorted
     */
    public MarkovTransformationSource(final PCMInstance model, final boolean sortDescriptors) {
        this.model = model;
        this.resourceDescriptors = buildResourceDescriptors(sortDescriptors);
        this.unreliableResourceDescriptors = buildUnreliableResourceDescriptors();
    }

    /**
     * Builds a list of resource descriptors based on the given PCM instance.
     * 
     * @param sort
     *            indicates if the result list shall be sorted according to state probabilities
     * @return the list of resource descriptors
     */
    private List<ProcessingResourceDescriptor> buildResourceDescriptors(final boolean sort) {

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
            for (ProcessingResourceSpecification resource : container
                    .getActiveResourceSpecifications_ResourceContainer()) {

                // Special case: Ignore resource specifications

                // Each resource has a type and MTTF/MTTR values:
                Double resourceMTTF = resource.getMTTF();
                Double resourceMTTR = resource.getMTTR();
                ProcessingResourceType type = resource.getActiveResourceType_ActiveResourceSpecification();

                // Check the proper MTTF/MTTR specification:
                if ((resourceMTTF <= 0.0) || (resourceMTTR <= 0.0)) {
                    logger.warn("Improper MTTF/MTTR specification for resource " + type.getEntityName()
                            + " in container " + container.getEntityName()
                            + ": Both values should be positive. Assuming that resource is always ok");
                    resourceMTTF = 1.0;
                    resourceMTTR = 0.0;
                }

                // Generate a new descriptor:
                ProcessingResourceDescriptor descriptor = new ProcessingResourceDescriptor();
                descriptor.setContainerId(container.getId());
                descriptor.setId(type.getId());
                descriptor.setContainerName(container.getEntityName());
                descriptor.setName(type.getEntityName());
                descriptor.setRequiredByContainer(resource.isRequiredByContainer());
                descriptor.setStateProbability(MarkovResourceState.OK, resourceMTTF / (resourceMTTF + resourceMTTR));
                descriptor.setStateProbability(MarkovResourceState.NA, resourceMTTR / (resourceMTTF + resourceMTTR));
                descriptor.setCurrentState(descriptor.getDefaultState());
                resultList.add(descriptor);
            }
        }

        // Sort the descriptors if required:
        if (sort) {
            sort(resultList);
        }

        // Return the result:
        return resultList;
    }

    /**
     * Builds a list of resource descriptors whose resources can fail, i.e., have a greater than 0
     * probability for the N/A state .
     * 
     * @return the list of such resource descriptors
     */
    private List<ProcessingResourceDescriptor> buildUnreliableResourceDescriptors() {
        List<ProcessingResourceDescriptor> unreliableResourceDescriptorsList = new ArrayList<ProcessingResourceDescriptor>(
                resourceDescriptors.size());
        for (int i = 0; i < resourceDescriptors.size(); i++) {
            // consider only resources that can fail (i.e., whose N/A state
            // probability is greater than 0)
            if (resourceDescriptors.get(i).getStateProbability(MarkovResourceState.NA) != 0d) {
                unreliableResourceDescriptorsList.add(resourceDescriptors.get(i));
            }
        }

        return unreliableResourceDescriptorsList;
    }

    /**
     * Retrieves a resource descriptor corresponding to the given resource demand.
     * 
     * @param demand
     *            the resource demand
     * @param contextWrapper
     *            a contextWrapper providing a link to the actual resource
     * @return the descriptor; NULL if no corresponding descriptor could be found
     */
    public ProcessingResourceDescriptor getDescriptor(final ParametricResourceDemand demand,
            final ContextWrapper contextWrapper) {

        // Map the resource demand to a concrete resource:
        ProcessingResourceSpecification resource = contextWrapper.getConcreteProcessingResource(demand);
        if (resource == null) {
            return null;
        }

        // Get the IDs of the resource type and resource container:
        String resourceTypeId = resource.getActiveResourceType_ActiveResourceSpecification().getId();
        String containerId = contextWrapper.getAllCtx().getResourceContainer_AllocationContext().getId();

        // Search for the right descriptor:
        for (ProcessingResourceDescriptor descriptor : resourceDescriptors) {

            // Compare the IDs to those of the descriptor:
            if ((descriptor.getType().getId().equals(resourceTypeId))
                    && (descriptor.getResourceContainerId().equals(containerId))) {
                return descriptor;
            }
        }

        // No descriptor found:
        return null;
    }

    /**
     * Retrieves a resource descriptor corresponding to the given processing resource specification.
     * 
     * @param resource
     *            the processing resource specification
     * @return the descriptor; NULL if no corresponding descriptor could be found
     */
    public ProcessingResourceDescriptor getDescriptor(final ProcessingResourceSpecification resource) {

        // Search for the right descriptor:
        for (ProcessingResourceDescriptor descriptor : resourceDescriptors) {

            // Compare the IDs to those of the descriptor:
            if (descriptor.getResourceContainerId().equals(
                    resource.getResourceContainer_ProcessingResourceSpecification().getId())
                    && descriptor.getType().getId()
                            .equals(resource.getActiveResourceType_ActiveResourceSpecification().getId())) {
                return descriptor;
            }
        }

        // No descriptor found:
        return null;
    }

    /**
     * Retrieves the PCM instance.
     * 
     * @return the PCM instance
     */
    public PCMInstance getModel() {
        return model;
    }

    /**
     * Returns a list of resource descriptors whose resources can fail, i.e., whose N/A state
     * probability is greater than 0.
     * 
     * @return the list of resource descriptors whose resources can fail, i.e., whose N/A state
     *         probability is greater than 0
     */
    public List<ProcessingResourceDescriptor> getUnreliableResourceDescriptors() {
        return unreliableResourceDescriptors;
    }

    /**
     * Prints the current permutation for debugging purposes.
     * 
     * @param descriptors
     *            the list of resource descriptors
     */
    public void printCurrentResourceStates() {
        for (int i = 0; i < unreliableResourceDescriptors.size(); i++) {
            System.out.print(unreliableResourceDescriptors.get(i).getCurrentState() == MarkovResourceState.OK ? "1"
                    : "0");
        }
        System.out.println();
    }

    /**
     * Sorts a list of resource descriptors.
     * 
     * @param descriptors
     *            the list to sort
     */
    private void sort(final List<ProcessingResourceDescriptor> descriptors) {
        /*
         * Sort the list of descriptors in a way that states, whose failure probabilities are
         * higher, appear first in the list, successively succeeded by those, whose failure
         * probabilities are lower. I.e., the list is sorted in descending order according to
         * failure probabilities.
         */
        Collections.sort(descriptors, new Comparator<ProcessingResourceDescriptor>() {
            public int compare(final ProcessingResourceDescriptor o1, final ProcessingResourceDescriptor o2) {
                if (o1.getStateProbability(MarkovResourceState.NA) > o2.getStateProbability(MarkovResourceState.NA)) {
                    return -1;
                } else if (o1.getStateProbability(MarkovResourceState.NA) < o2
                        .getStateProbability(MarkovResourceState.NA)) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
    }
}

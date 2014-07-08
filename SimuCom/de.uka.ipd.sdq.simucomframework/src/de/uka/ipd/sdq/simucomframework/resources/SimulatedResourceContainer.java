package de.uka.ipd.sdq.simucomframework.resources;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.scheduler.IPassiveResource;
import de.uka.ipd.sdq.simucomframework.ModelsAtRuntime;
import de.uka.ipd.sdq.simucomframework.SimuComSimProcess;
import de.uka.ipd.sdq.simucomframework.exceptions.ResourceContainerIsMissingRequiredResourceType;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

/**
 * TODO Get rid of heavy argument passing. Model elements are often enough as they contain
 * information like ID and name. [Lehrig]
 * 
 * TODO Find original author ;)
 * 
 * @author ???, Sebastian Lehrig
 */
public class SimulatedResourceContainer extends AbstractSimulatedResourceContainer {

    private final List<SimulatedResourceContainer> nestedResourceContainers;

    private SimulatedResourceContainer parentResourceContainer = null;

    public SimulatedResourceContainer(final SimuComModel myModel, final String containerID) {
        super(myModel, containerID);
        nestedResourceContainers = new ArrayList<SimulatedResourceContainer>();
    }

    public IPassiveResource createPassiveResource(final PassiveResource resource,
            final AssemblyContext assemblyContext, final long capacity) {
        final IPassiveResource newPassiveResource = getSimplePassiveResource(resource, assemblyContext, this.myModel,
                capacity);

        // setup calculators
        CalculatorHelper.setupPassiveResourceStateCalculator(newPassiveResource, this.myModel);
        CalculatorHelper.setupWaitingTimeCalculator(newPassiveResource, this.myModel);
        CalculatorHelper.setupHoldTimeCalculator(newPassiveResource, this.myModel);

        return newPassiveResource;
    }

    public List<SimulatedResourceContainer> getNestedResourceContainers() {
        return nestedResourceContainers;
    }

    public SimulatedResourceContainer getParentResourceContainer() {
        return parentResourceContainer;
    }

    public void addNestedResourceContainer(final String nestedResourceContainerId) {
        final AbstractSimulatedResourceContainer resourceContainer = myModel.getResourceRegistry()
                .getResourceContainer(nestedResourceContainerId);
        if ((resourceContainer == null) || (!(resourceContainer instanceof SimulatedResourceContainer))) {
            throw new RuntimeException("Could not initialize resouce container " + this.myContainerID
                    + ": Nested resource container " + nestedResourceContainerId + " is not available.");
        }
        nestedResourceContainers.add((SimulatedResourceContainer) resourceContainer);
    }

    public void setParentResourceContainer(final String parentResourceContainerId) {
        final AbstractSimulatedResourceContainer resourceContainer = myModel.getResourceRegistry()
                .getResourceContainer(parentResourceContainerId);
        if ((resourceContainer == null) || (!(resourceContainer instanceof SimulatedResourceContainer))) {
            throw new RuntimeException("Could not initialize resouce container " + this.myContainerID
                    + ": Parent resource container " + parentResourceContainerId + " is not available.");
        }
        parentResourceContainer = (SimulatedResourceContainer) resourceContainer;
    }

    public void addActiveResource(final String activeResourceURI, final String[] providedInterfaceIds,
            final String resourceContainerID, final String schedulingStrategyID) {
        final ProcessingResourceSpecification activeResource = (ProcessingResourceSpecification) ModelsAtRuntime
                .loadModel(activeResourceURI);
        final ScheduledResource r = new ScheduledResource(activeResource, myModel, resourceContainerID,
                schedulingStrategyID);
        final String resourceType = activeResource.getActiveResourceType_ActiveResourceSpecification().getId();
        activeResources.put(resourceType, r);

        // Currently, resources can also be looked up by the provided interface id
        if (providedInterfaceIds != null) {
            for (final String providedInterfaceId : providedInterfaceIds) {
                activeResourceProvidedInterfaces.put(providedInterfaceId, resourceType);
            }
        }

        // setup calculators
        // TODO: setup waiting time calculator
        // CalculatorHelper.setupWaitingTimeCalculator(r, this.myModel);
        CalculatorHelper.setupDemandCalculator(r, this.myModel);

        // setup utilization calculators depending on their scheduling strategy
        // and number of cores
        if (schedulingStrategyID.equals(SchedulingStrategy.PROCESSOR_SHARING)) {
            if (r.getNumberOfInstances() == 1) {
                CalculatorHelper.setupActiveResourceStateCalculator(r, this.myModel);
            } else {
                CalculatorHelper.setupOverallUtilizationCalculator(r, this.myModel);
            }
        } else if (schedulingStrategyID.equals(SchedulingStrategy.DELAY)
                || schedulingStrategyID.equals(SchedulingStrategy.FCFS)) {
            assert (r.getNumberOfInstances() == 1) : "DELAY and FCFS resources are expected to "
                    + "have exactly one core";
            CalculatorHelper.setupActiveResourceStateCalculator(r, this.myModel);
        } else {
            // Use an OverallUtilizationCalculator by default.
            CalculatorHelper.setupOverallUtilizationCalculator(r, this.myModel);
        }
    }

    private IPassiveResource getSimplePassiveResource(final PassiveResource resource,
            final AssemblyContext assemblyContext, final SimuComModel simuComModel,
            final long capacity) {
        // return new SimFairPassiveResource(capacity, name, name, null,null);
        return new SimSimpleFairPassiveResource(resource, assemblyContext, simuComModel, myModel, capacity,
                myModel.getConfiguration().getSimulateFailures());
    }

    /**
     * Demand processing of a resource demand by a given type of active resources. If the resource
     * container has no own resources, look in parent resource container.
     * 
     * @param requestingProcess
     *            The thread requesting the processing of a resouce demand
     * @param typeID
     *            ID of the resource type to which the demand is directed. Same as the PCM resource
     *            type IDs
     * @param demand
     *            The demand in units processable by the resource. The resource is responsible
     *            itself for converting this demand into time spans
     */
    @Override
    public void loadActiveResource(final SimuComSimProcess requestingProcess, final String typeID, final double demand) {
        try {
            super.loadActiveResource(requestingProcess, typeID, demand);
        } catch (final ResourceContainerIsMissingRequiredResourceType e) {
            if (parentResourceContainer == null) {
                if (LOGGER.isEnabledFor(Level.ERROR)) {
                    LOGGER.error("Resource container is missing a resource which was attempted to be loaded"
                            + " by a component and has no parent Resource Container to look in. ID of resource type was: "
                            + typeID);
                }
                throw new ResourceContainerIsMissingRequiredResourceType(typeID);
            } else {
                parentResourceContainer.loadActiveResource(requestingProcess, typeID, demand);
            }
        }
    }

    /**
     * Demand processing of a resource demand by a given type of active resource and a resource
     * interface operation. If the resource container has no own resources, look in parent resource
     * container.
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
    @Override
    public void loadActiveResource(final SimuComSimProcess requestingProcess, final String providedInterfaceID,
            final int resourceServiceID, final double demand) {
        try {
            super.loadActiveResource(requestingProcess, providedInterfaceID, resourceServiceID, demand);
        } catch (final ResourceContainerIsMissingRequiredResourceType e) {
            if (parentResourceContainer == null) {
                if (LOGGER.isEnabledFor(Level.ERROR)) {
                    LOGGER.error("Resource container is missing a resource which was attempted to be loaded"
                            + " by a component and has no parent Resource Container to look in. ID of resource type was: "
                            + e.getTypeID());
                }
                throw new ResourceContainerIsMissingRequiredResourceType(e.getTypeID());
            } else {
                parentResourceContainer.loadActiveResource(requestingProcess, providedInterfaceID, resourceServiceID,
                        demand);
            }
        }
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
     *            the id of the resource service to be called. itself for converting this demand
     *            into time spans
     * @param parameterMap
     *            Additional Parameters usable in an active resource. Parameters represented as
     *            <parameterName, specification>
     * @param demand
     *            The demand in units processable by the resource. The resource is responsible
     * 
     */
    @Override
    public void loadActiveResource(final SimuComSimProcess requestingProcess, final String providedInterfaceID,
            final int resourceServiceID, final Map<String, Serializable> parameterMap, final double demand) {
        try {
            super.loadActiveResource(requestingProcess, providedInterfaceID, resourceServiceID, parameterMap, demand);
        } catch (final ResourceContainerIsMissingRequiredResourceType e) {
            if (parentResourceContainer == null) {
                if (LOGGER.isEnabledFor(Level.ERROR)) {
                    LOGGER.error("Resource container is missing a resource which was attempted to be loaded"
                            + " by a component and has no parent Resource Container to look in. ID of resource type was: "
                            + e.getTypeID());
                }
                throw new ResourceContainerIsMissingRequiredResourceType(e.getTypeID());
            } else {
                parentResourceContainer.loadActiveResource(requestingProcess, providedInterfaceID, resourceServiceID,
                        parameterMap, demand);
            }
        }
    }
}

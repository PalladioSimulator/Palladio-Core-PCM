package de.uka.ipd.sdq.simucomframework.resources;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;

import de.uka.ipd.sdq.scheduler.IPassiveResource;
import de.uka.ipd.sdq.simucomframework.SimuComSimProcess;
import de.uka.ipd.sdq.simucomframework.exceptions.ResourceContainerIsMissingRequiredResourceType;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public class SimulatedResourceContainer extends
		AbstractSimulatedResourceContainer {

	protected SimulatedResourceContainer parentResourceContainer = null;
	protected List<SimulatedResourceContainer> nestedResourceContainers = null;

	public SimulatedResourceContainer(SimuComModel myModel, String containerID) {
		super(myModel, containerID);
		nestedResourceContainers = new ArrayList<SimulatedResourceContainer>();
	}
	
	public IPassiveResource createPassiveResource(String name,
			String passiveResourceID, String assemblyContextID,
			String combinedID, long capacity) {
		IPassiveResource r = getSimplePassiveResource(name, passiveResourceID,
				assemblyContextID, combinedID, capacity);

		// setup calculators
		//FIXME
//		CalculatorHelper.setupStateCalculator(r, this.myModel);
//		CalculatorHelper.setupWaitingTimeCalculator(r, this.myModel);
//		CalculatorHelper.setupHoldTimeCalculator(r, this.myModel); 
		
		return r;
	}

	/*public IPassiveResource createPassiveResource(String name,
			String passiveResourceID, String assemblyContextID,
			String combinedID, int capacity) {
		IPassiveResource r = null;
		if (managingResource == null) {
			r = getSimplePassiveResource(name, passiveResourceID,
					assemblyContextID, combinedID, capacity);
		} else {
			if (operatingSystem.equals(SchedulingStrategy.WINDOWS_SERVER_2003) ||
					operatingSystem.equals(SchedulingStrategy.WINDOWS_XP) || 
					operatingSystem.equals(SchedulingStrategy.WINDOWS_VISTA) || 
					operatingSystem.equals(SchedulingStrategy.WINDOWS_7)) {
				r = getPassiveResourceWindows(name, passiveResourceID,
						capacity, 1, true, true, managingResource
								.getScheduledResource());
			} else if(operatingSystem.equals(SchedulingStrategy.LINUX_2_6_O1)) {
				r = getPassiveResourceLinux(name, passiveResourceID, capacity,
						true, managingResource.getScheduledResource());
			} else if(operatingSystem.equals(SchedulingStrategy.LINUX_2_6_CFS)) {
				// Use the same passive resource as for a processor sharing scheduler.
				r = getSimplePassiveResource(name, passiveResourceID,
						assemblyContextID, combinedID, capacity);
			}
		}

		// setup calculators
		CalculatorHelper.setupStateCalculator(r, this.myModel);
		CalculatorHelper.setupWaitingTimeCalculator(r, this.myModel);
		CalculatorHelper.setupHoldTimeCalculator(r, this.myModel); 
		
		return r;
	}*/
	
	public List<SimulatedResourceContainer> getNestedResourceContainers() {
		return nestedResourceContainers;
	}
	
	public SimulatedResourceContainer getParentResourceContainer() {
		return parentResourceContainer;
	}
	
	public void addNestedResourceContainer(String nestedResourceContainerId) {
		AbstractSimulatedResourceContainer resourceContainer = myModel.getResourceRegistry().getResourceContainer(nestedResourceContainerId);
		if ((resourceContainer == null) || (!(resourceContainer instanceof SimulatedResourceContainer))) {
			throw new RuntimeException(
					"Could not initialize resouce container " + this.myContainerID + ": Nested resource container " + nestedResourceContainerId + " is not available.");
		}
		nestedResourceContainers.add((SimulatedResourceContainer)resourceContainer);
	}
	
	public void setParentResourceContainer(String parentResourceContainerId) {
		AbstractSimulatedResourceContainer resourceContainer = myModel.getResourceRegistry().getResourceContainer(parentResourceContainerId);
		if ((resourceContainer == null) || (!(resourceContainer instanceof SimulatedResourceContainer))) {
			throw new RuntimeException(
					"Could not initialize resouce container " + this.myContainerID + ": Parent resource container " + parentResourceContainerId + " is not available.");
		}
		parentResourceContainer = (SimulatedResourceContainer)resourceContainer;
	}

	public void addActiveResource(
			String typeID,
			String[] providedInterfaceIds,
			String resourceContainerID,
			String resourceTypeID,
			String description,
			String processingRate,
			Double mttf,
			Double mttr,
			String units,
			String schedulingStrategyID,
			int numberOfReplicas,
			boolean requiredByContainer){
		ScheduledResource r = new ScheduledResource(
				myModel,
				typeID,
				resourceContainerID,
				resourceTypeID,
				description,
				processingRate,
				mttf,
				mttr,
				schedulingStrategyID,
				numberOfReplicas,
				requiredByContainer);
		activeResources.put(typeID, r);
		
		// Currently, resources can also be looked up by the provided interface id
		if (providedInterfaceIds != null) {
			for (String providedInterfaceId : providedInterfaceIds) {
				activeResourceProvidedInterfaces.put(providedInterfaceId, typeID);
			}
		}
		
		/*if (schedulingStrategyID.equals(SchedulingStrategy.LINUX_2_6_CFS) || 
				schedulingStrategyID.equals(SchedulingStrategy.LINUX_2_6_O1) || 
				schedulingStrategyID.equals(SchedulingStrategy.SPECIAL_LINUXO1) || 
				schedulingStrategyID.equals(SchedulingStrategy.SPECIAL_WINDOWS) || 
				schedulingStrategyID.equals(SchedulingStrategy.WINDOWS_7) || 
				schedulingStrategyID.equals(SchedulingStrategy.WINDOWS_SERVER_2003) || 
				schedulingStrategyID.equals(SchedulingStrategy.WINDOWS_VISTA) || 
				schedulingStrategyID.equals(SchedulingStrategy.WINDOWS_XP)) {
				assert this.managingResource == null;
				this.operatingSystem = schedulingStrategyID;
				this.managingResource = activeResources.get(typeID);
		}*/

		// setup calculators
		// TODO: setup waiting time calculator
		// CalculatorHelper.setupWaitingTimeCalculator(r);
		// FIXME
		// CalculatorHelper.setupDemandCalculator(r, this.myModel);

		// setup utilization calculators depending on their scheduling strategy
		// and number of cores
		if (schedulingStrategyID.equals(SchedulingStrategy.PROCESSOR_SHARING)) {
			if (r.getNumberOfInstances() == 1) {
				//FIXME
			    //CalculatorHelper.setupStateCalculator(r, this.myModel);	
			} else {
				//FIXME
			    //CalculatorHelper.setupOverallUtilizationCalculator(r, this.myModel);				
			}
		} else if (schedulingStrategyID.equals(SchedulingStrategy.DELAY)
				|| schedulingStrategyID.equals(SchedulingStrategy.FCFS)) {
			assert (r.getNumberOfInstances() == 1) : "DELAY and FCFS resources are expected to "
					+ "have exactly one core";
			//FIXME
			//CalculatorHelper.setupStateCalculator(r, this.myModel);
		} else {
			// Use an OverallUtilizationCalculator by default.
			//FIXME
		    //CalculatorHelper.setupOverallUtilizationCalculator(r, this.myModel);
			/*throw new RuntimeException(
					"Could not setup utilization calculator at resource "
							+ description
							+ " as it is unknown how to handle the scheduling strategy "
							+ strategy.name() + ".");*/
		}
	}

	/*private IPassiveResource getPassiveResourceWindows(String name, String id,
			int capacity, int bonus, boolean resetTimeSlice, boolean isFair,
			IActiveResource managingResource) {
		IPriorityUpdateStrategy update = new DecayToBaseUpdate();
		IPriorityBoost boost = new StaticPriorityBoost(update, bonus, 0,
				resetTimeSlice);

		if (isFair) {
			return new SimFairPassiveResource(myModel, capacity, name, id, boost,
					(SimActiveResource) managingResource);
		} else {
			return new SimUnfairPassiveResource(myModel, capacity, name, id, boost,
					(SimActiveResource) managingResource, 0.1, true);
		}
	}

	private IPassiveResource getPassiveResourceLinux(String name, String id,
			int capacity, boolean isFair, IActiveResource managingResource) {
		if (isFair) {
			return new SimFairPassiveResource(myModel, capacity, name, id, null,
					(SimActiveResource) managingResource);
		} else {
			return new SimUnfairPassiveResource(myModel, capacity, name, id, null,
					(SimActiveResource) managingResource, 0.1, true);
		}
	}*/

	private IPassiveResource getSimplePassiveResource(String name,
			String passiveResourceID, String assemblyContextID,
			String combinedID, long capacity) {
		// return new SimFairPassiveResource(capacity, name, name, null,null);
        return new SimSimpleFairPassiveResource(myModel, capacity, name, passiveResourceID,
                assemblyContextID, combinedID, myModel.getConfiguration().getSimulateFailures());
	}
	
	/**
	 * Demand processing of a resource demand by a given type of active resources.
	 * If the resource container has no own resources, look in parent resource container.
	 * @param requestingProcess The thread requesting the processing of a resouce demand
	 * @param typeID ID of the resource type to which the demand is directed. Same as the
	 * PCM resource type IDs
	 * @param demand The demand in units processable by the resource. The resource is
	 * responsible itself for converting this demand into time spans
	 */
	@Override
	public void loadActiveResource(SimuComSimProcess requestingProcess, String typeID, double demand) {
		try {
			super.loadActiveResource(requestingProcess, typeID, demand);
		} catch (ResourceContainerIsMissingRequiredResourceType e) {
			if (parentResourceContainer == null) {
				if(logger.isEnabledFor(Level.ERROR))
					logger.error("Resource container is missing a resource which was attempted to be loaded"+
						" by a component and has no parent Resource Container to look in. ID of resource type was: "+typeID);
				throw new ResourceContainerIsMissingRequiredResourceType(typeID);
			} else {
				parentResourceContainer.loadActiveResource(requestingProcess, typeID, demand);
			}
		}
	}
	
	/**
	 * Demand processing of a resource demand by a given type of active resource and a resource interface operation.
	 * If the resource container has no own resources, look in parent resource container.
	 * @param requestingProcess The thread requesting the processing of a resource demand
	 * @param typeID ID of the resource provided interface to which the demand is directed.
	 * @param resourceServiceID the id of the resource service to be called.
	 * @param demand The demand in units processable by the resource. The resource is
	 * responsible itself for converting this demand into time spans
	 */
	@Override
	public void loadActiveResource(SimuComSimProcess requestingProcess, String providedInterfaceID, int resourceServiceID, double demand) {
		try {
			super.loadActiveResource(requestingProcess, providedInterfaceID, resourceServiceID, demand);
		} catch (ResourceContainerIsMissingRequiredResourceType e) {
			if (parentResourceContainer == null) {
				if(logger.isEnabledFor(Level.ERROR))
					logger.error("Resource container is missing a resource which was attempted to be loaded"+
						" by a component and has no parent Resource Container to look in. ID of resource type was: "+e.getTypeID());
				throw new ResourceContainerIsMissingRequiredResourceType(e.getTypeID());
			} else {
				parentResourceContainer.loadActiveResource(requestingProcess, providedInterfaceID, resourceServiceID, demand);
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
	public void loadActiveResource(SimuComSimProcess requestingProcess, String providedInterfaceID,
            int resourceServiceID, Map<String, Serializable> parameterMap, double demand) {
        try {
            super.loadActiveResource(requestingProcess, providedInterfaceID, resourceServiceID, parameterMap, demand);
        } catch (ResourceContainerIsMissingRequiredResourceType e) {
            if (parentResourceContainer == null) {
                if (logger.isEnabledFor(Level.ERROR))
                    logger.error("Resource container is missing a resource which was attempted to be loaded"
                            + " by a component and has no parent Resource Container to look in. ID of resource type was: "
                            + e.getTypeID());
                throw new ResourceContainerIsMissingRequiredResourceType(e.getTypeID());
            } else {
                parentResourceContainer.loadActiveResource(requestingProcess, providedInterfaceID, resourceServiceID,
                        parameterMap, demand);
            }
        }
    }
	

	public AbstractScheduledResource getResourceInResourceContainerOrParentResourceContainer(String resourceTypeID) {
		AbstractScheduledResource resource = activeResources.get(resourceTypeID);
		if (resource == null) {
			if (parentResourceContainer != null) {
				return parentResourceContainer.getResourceInResourceContainerOrParentResourceContainer(resourceTypeID);
			}
		}
		return resource;
	}
	
}

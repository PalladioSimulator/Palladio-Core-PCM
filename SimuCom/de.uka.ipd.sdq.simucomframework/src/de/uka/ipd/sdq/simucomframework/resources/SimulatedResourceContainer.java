package de.uka.ipd.sdq.simucomframework.resources;

import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.IPassiveResource;
import de.uka.ipd.sdq.scheduler.priority.IPriorityBoost;
import de.uka.ipd.sdq.scheduler.priority.IPriorityUpdateStrategy;
import de.uka.ipd.sdq.scheduler.priority.boost.StaticPriorityBoost;
import de.uka.ipd.sdq.scheduler.priority.update.DecayToBaseUpdate;
import de.uka.ipd.sdq.scheduler.resources.active.SimActiveResource;
import de.uka.ipd.sdq.scheduler.resources.passive.SimFairPassiveResource;
import de.uka.ipd.sdq.scheduler.resources.passive.SimUnfairPassiveResource;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public class SimulatedResourceContainer extends
		AbstractSimulatedResourceContainer {

	private SchedulingStrategy operatingSystem;
	private AbstractScheduledResource managingResource = null;

	public SimulatedResourceContainer(SimuComModel myModel, String containerID) {
		super(myModel, containerID);
	}

	public IPassiveResource createPassiveResource(String name,
			String passiveResourceID, String assemblyContextID,
			String combinedID, int capacity) {
		IPassiveResource r = null;
		if (managingResource == null) {
			r = getSimplePassiveResource(name, passiveResourceID,
					assemblyContextID, combinedID, capacity);
		} else {
			switch (operatingSystem) {
			case WINDOWS_SERVER_2003:
			case WINDOWS_XP:
			case WINDOWS_VISTA:
			case WINDOWS_7:
				r = getPassiveResourceWindows(name, passiveResourceID,
						capacity, 1, true, true, managingResource
								.getScheduledResource());
				break;
			case LINUX_2_6_O1:
				r = getPassiveResourceLinux(name, passiveResourceID, capacity,
						true, managingResource.getScheduledResource());
				break;
			case LINUX_2_6_CFS:
				// Use the same passive resource as for a processor sharing scheduler.
				r = getSimplePassiveResource(name, passiveResourceID,
						assemblyContextID, combinedID, capacity);
				break;
			}
		}

		// setup calculators
		CalculatorHelper.setupStateCalculator(r, this.myModel);
		CalculatorHelper.setupWaitingTimeCalculator(r, this.myModel);
		CalculatorHelper.setupHoldTimeCalculator(r, this.myModel); 
		
		return r;
	}

	public void addActiveResource(String typeID, String[] providedInterfaceIds, String resourceContainerID,
			String resourceTypeID, String description, String processingRate,
			Double mttf, Double mttr, String units,
			SchedulingStrategy strategy, int numberOfReplicas) {
		ScheduledResource r = new ScheduledResource(myModel, typeID,
				resourceContainerID, resourceTypeID, description,
				processingRate, mttf, mttr, strategy, numberOfReplicas);
		activeResources.put(typeID, r);
		
		// Currently, resources can also be looked up by the provided interface id
		if (providedInterfaceIds != null) {
			for (String providedInterfaceId : providedInterfaceIds) {
				activeResourceProvidedInterfaces.put(providedInterfaceId, typeID);
			}
		}

		if (SchedulingStrategyHelper.isExactSchedulingStrategy(strategy)) {
			assert this.managingResource == null;
			this.operatingSystem = strategy;
			this.managingResource = activeResources.get(typeID);
		}

		// setup calculators
		// TODO: setup waiting time calculator
		// CalculatorHelper.setupWaitingTimeCalculator(r);
		CalculatorHelper.setupDemandCalculator(r, this.myModel);

		// setup utilization calculators depending on their scheduling strategy
		// and number of cores
		if (strategy.equals(SchedulingStrategy.PROCESSOR_SHARING)) {
			if (r.getNumberOfInstances() == 1) {
				CalculatorHelper.setupStateCalculator(r, this.myModel);	
			} else {
				CalculatorHelper.setupOverallUtilizationCalculator(r, this.myModel);				
			}
		} else if (strategy.equals(SchedulingStrategy.DELAY)
				|| strategy.equals(SchedulingStrategy.FCFS)) {
			assert (r.getNumberOfInstances() == 1) : "DELAY and FCFS resources are expected to "
					+ "have exactly one core";
			CalculatorHelper.setupStateCalculator(r, this.myModel);
		} else if (strategy.equals(SchedulingStrategy.GINPEX_DISK)) {
			CalculatorHelper.setupOverallUtilizationCalculator(r, this.myModel);
		} else if (SchedulingStrategyHelper.isExactSchedulingStrategy(strategy)) {
			CalculatorHelper.setupOverallUtilizationCalculator(r, this.myModel);
		} else {
			throw new RuntimeException(
					"Could not setup utilization calculator at resource "
							+ description
							+ " as it is unknown how to handle the scheduling strategy "
							+ strategy.name() + ".");
		}
	}

	private IPassiveResource getPassiveResourceWindows(String name, String id,
			int capacity, int bonus, boolean resetTimeSlice, boolean isFair,
			IActiveResource managingResource) {
		IPriorityUpdateStrategy update = new DecayToBaseUpdate();
		IPriorityBoost boost = new StaticPriorityBoost(update, bonus, 0,
				resetTimeSlice);

		if (isFair) {
			return new SimFairPassiveResource(capacity, name, id, boost,
					(SimActiveResource) managingResource);
		} else {
			return new SimUnfairPassiveResource(capacity, name, id, boost,
					(SimActiveResource) managingResource, 0.1, true);
		}
	}

	private IPassiveResource getPassiveResourceLinux(String name, String id,
			int capacity, boolean isFair, IActiveResource managingResource) {
		if (isFair) {
			return new SimFairPassiveResource(capacity, name, id, null,
					(SimActiveResource) managingResource);
		} else {
			return new SimUnfairPassiveResource(capacity, name, id, null,
					(SimActiveResource) managingResource, 0.1, true);
		}
	}

	private IPassiveResource getSimplePassiveResource(String name,
			String passiveResourceID, String assemblyContextID,
			String combinedID, int capacity) {
		// return new SimFairPassiveResource(capacity, name, name, null,null);
		return new SimSimpleFairPassiveResource(myModel, capacity, name,
				passiveResourceID, assemblyContextID, combinedID);
	}
}

package de.uka.ipd.sdq.simucomframework.resources;

import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.IPassiveResource;
import de.uka.ipd.sdq.scheduler.priority.IPriorityBoost;
import de.uka.ipd.sdq.scheduler.priority.IPriorityUpdateStrategy;
import de.uka.ipd.sdq.scheduler.priority.boost.StaticPriorityBoost;
import de.uka.ipd.sdq.scheduler.priority.update.DecayToBaseUpdate;
import de.uka.ipd.sdq.scheduler.resources.active.SimActiveResource;
import de.uka.ipd.sdq.scheduler.resources.passive.SimFairPassiveResource;
import de.uka.ipd.sdq.scheduler.resources.passive.SimSimpleFairPassiveResource;
import de.uka.ipd.sdq.scheduler.resources.passive.SimUnfairPassiveResource;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public class SimulatedResourceContainer extends AbstractSimulatedResourceContainer {
	
	private SchedulingStrategy operatingSystem;
	private AbstractScheduledResource managingResource = null;

	public SimulatedResourceContainer(SimuComModel myModel, String containerID) {
		super(myModel, containerID);
	}

		
	public IPassiveResource createPassiveResource(String name, String id, int capacity) {
		IPassiveResource r = null;
		if (managingResource == null){
			r = getSimplePassiveResource(name, id, capacity);
		} else {
			switch (operatingSystem) {
			case WINDOWS_SERVER_2003:
			case WINDOWS_XP:
			case WINDOWS_VISTA:
			case WINDOWS_7:
				r = getPassiveResourceWindows(name, id, capacity,1, true, true, managingResource.getScheduledResource());
				break;
			case LINUX_2_6_O1:
			case LINUX_2_6_CFS:
				r = getPassiveResourceLinux(name, id, capacity, true, managingResource.getScheduledResource());
				break;
			}
		}
		
		// setup calculators
		CalculatorHelper.setupStateCalculator(r, super.myModel
				.getSimulationControl());
		CalculatorHelper.setupWaitingTimeCalculator(r, super.myModel
				.getSimulationControl());
		CalculatorHelper.setupHoldTimeCalculator(r, super.myModel
				.getSimulationControl()); 
		
		return r;
	}

	public void addActiveResource(String typeID, String description, String processingRate, Double mttf, Double mttr, String units, SchedulingStrategy strategy, int numberOfReplicas) {
		ScheduledResource r = new ScheduledResource(myModel, typeID, description, processingRate, mttf, mttr, strategy, numberOfReplicas);
		activeResources.put(typeID, r);
		
		if (SchedulingStrategyHelper.isExactSchedulingStrategy(strategy)) {
			assert this.managingResource == null;
			this.operatingSystem = strategy;
			this.managingResource = activeResources.get(typeID);
		}

		// setup calculators
//		TODO: setup waiting time calculator
//		CalculatorHelper.setupWaitingTimeCalculator(r);
		CalculatorHelper.setupDemandCalculator(r);
		
		// setup utilization calculators depending on their scheduling strategy and number of cores 
		if (strategy.equals(SchedulingStrategy.PROCESSOR_SHARING)) {
			if (r.getNumberOfInstances() == 1) {
				CalculatorHelper.setupStateCalculator(r);	
			} else {
				CalculatorHelper.setupOverallUtilizationCalculator(r);				
			}
		} else if (strategy.equals(SchedulingStrategy.DELAY) || 
				strategy.equals(SchedulingStrategy.FCFS)) {
			assert(r.getNumberOfInstances() == 1) : "DELAY and FCFS resources are expected to " +
					"have exactly one core";
			CalculatorHelper.setupStateCalculator(r);
		} else if (SchedulingStrategyHelper.isExactSchedulingStrategy(strategy)) {
			CalculatorHelper.setupOverallUtilizationCalculator(r);
		} else {
			throw new RuntimeException("Could not setup utilization calculator at resource " + 
					description + " as it is unknown how to handle the scheduling strategy " + 
					strategy.name() + ".");
		}
	}
	  private IPassiveResource getPassiveResourceWindows(String name,
	           String id, int capacity, int bonus, boolean resetTimeSlice, boolean isFair, IActiveResource managingResource) {
	       IPriorityUpdateStrategy update = new DecayToBaseUpdate();
	       IPriorityBoost boost = new StaticPriorityBoost(update, bonus, 0,
	               resetTimeSlice);
	       
	       if (isFair){
		       return new SimFairPassiveResource(capacity, name, id, boost,
		               (SimActiveResource) managingResource);
	       } else {
		       return new SimUnfairPassiveResource(capacity, name, id, boost,
		               (SimActiveResource) managingResource,0.1,true);
	       }
	   }

	  private IPassiveResource getPassiveResourceLinux(String name, String id, int capacity, boolean isFair, IActiveResource managingResource) {
		  if (isFair){
		       return new SimFairPassiveResource(capacity, name, id, null,
		               (SimActiveResource) managingResource);
		  } else {
	       return new SimUnfairPassiveResource(capacity, name, id, null,
	               (SimActiveResource) managingResource,0.1,true);
		  }
	   }

	  private IPassiveResource getSimplePassiveResource(String name, String id, int capacity) {
		  //return new SimFairPassiveResource(capacity, name, name, null,null);
		  return new SimSimpleFairPassiveResource(capacity, name, id);
	  }
}

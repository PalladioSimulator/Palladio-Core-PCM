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

public class SimulatedResourceContainer extends AbstractSimulatedResourceContainer {
	
	// ResourceTypeID -> SimulatedPassiveResource
	// TODO: Becomes soon deprecated
	
	private SchedulingStrategy operatingSystem;
	private AbstractScheduledResource managingResource = null;

	public SimulatedResourceContainer(SimuComModel myModel, String containerID) {
		super(myModel,containerID);
	}

		
	public IPassiveResource createPassiveResource(String typeID, int capacity) {
		if (managingResource == null){
			return getPassiveResource(typeID, capacity);
		} else {
			switch (operatingSystem) {
			case WINDOWS_SERVER_2003:
			case WINDOWS_XP:
			case WINDOWS_VISTA:
			case WINDOWS_7:
				return getPassiveResourceWindows(typeID, capacity,1, true, true, managingResource.getScheduledResource());
			case LINUX_2_6_O1:
			case LINUX_2_6_CFS:
				return getPassiveResourceLinux(typeID, capacity, true, managingResource.getScheduledResource());
			default:
				return null;
			}
		}
	}

	public void addActiveResource(String typeID, String description, String processingRate, Double mttf, Double mttr, String units, SchedulingStrategy strategy, int numberOfReplicas) {
		activeResources.put(typeID, 
				new ScheduledResource(myModel, typeID, description, processingRate, mttf, mttr, units, strategy, numberOfReplicas));
		
		if ( strategy == SchedulingStrategy.LINUX_2_6_O1 || strategy == SchedulingStrategy.LINUX_2_6_CFS || strategy == SchedulingStrategy.WINDOWS_SERVER_2003 || strategy == SchedulingStrategy.WINDOWS_XP || strategy == SchedulingStrategy.WINDOWS_VISTA || strategy == SchedulingStrategy.WINDOWS_7) {
			assert this.managingResource == null;
			this.operatingSystem = strategy;
			this.managingResource = activeResources.get(typeID);
		}
	}
	
	  private IPassiveResource getPassiveResourceWindows(String name,
	           int capacity, int bonus, boolean resetTimeSlice, boolean isFair, IActiveResource managingResource) {
	       IPriorityUpdateStrategy update = new DecayToBaseUpdate();
	       IPriorityBoost boost = new StaticPriorityBoost(update, bonus, 0,
	               resetTimeSlice);
	       
	       if (isFair){
		       return new SimFairPassiveResource(capacity, name, name, boost,
		               (SimActiveResource) managingResource);
	       } else {
		       return new SimUnfairPassiveResource(capacity, name, name, boost,
		               (SimActiveResource) managingResource,0.1,true);
	       }
	   }

	  private IPassiveResource getPassiveResourceLinux(String name, int capacity, boolean isFair, IActiveResource managingResource) {
		  if (isFair){
		       return new SimFairPassiveResource(capacity, name, name, null,
		               (SimActiveResource) managingResource);
		  } else {
	       return new SimUnfairPassiveResource(capacity, name, name, null,
	               (SimActiveResource) managingResource,0.1,true);
		  }
	   }

	  private IPassiveResource getPassiveResource(String name, int capacity) {
		       return new SimFairPassiveResource(capacity, name, name, null,null);
	   }
}

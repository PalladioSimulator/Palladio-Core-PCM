package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.jobs;

import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.IPassiveResource;
import de.uka.ipd.sdq.simucomframework.SimuComSimProcess;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.resources.AbstractSimulatedResourceContainer;
import de.uka.ipd.sdq.simucomframework.resources.CalculatorHelper;
import de.uka.ipd.sdq.simucomframework.resources.SchedulingStrategy;
import de.uka.ipd.sdq.simucomframework.resources.SimulatedResourceContainer;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.SimActiveResource;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.priority.IPriorityBoost;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.priority.IPriorityUpdateStrategy;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.priority.boost.StaticPriorityBoost;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.priority.update.DecayToBaseUpdate;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.resources.passive.SimFairPassiveResource;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.resources.passive.SimUnfairPassiveResource;

public class ResourceContainerWrapper extends SimulatedResourceContainer {
	
	
	public static final String SCHEDULING_STRATEGY_EXACT_WINXP = "edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.winxp";
	public static final String SCHEDULING_STRATEGY_EXACT_WIN7 = "edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.win7";
	public static final String SCHEDULING_STRATEGY_EXACT_WINVISTA = "edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.winvista";
	public static final String SCHEDULING_STRATEGY_EXACT_WINSERVER2003 = "edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.winserver2003";
	public static final String SCHEDULING_STRATEGY_EXACT_LINUX26O1 = "edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.linux26o1";
	public static final String SCHEDULING_STRATEGY_EXACT_LINUXCFS= "edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.linux26cfs";
	
	AbstractSimulatedResourceContainer originalResourceContainer = null;
	
	private String cpuSchedulingStrategy = null;
	private String cpuResourceId = null;

	public ResourceContainerWrapper(SimuComModel myModel, String myContainerID, AbstractSimulatedResourceContainer originalResourceContainer, String cpuResourceId, String cpuSchedulingStrategy) {
		super(myModel, myContainerID);
		this.cpuSchedulingStrategy = cpuSchedulingStrategy;
		this.cpuResourceId = cpuResourceId;
		this.originalResourceContainer = originalResourceContainer;
		this.activeResources = originalResourceContainer.getAllActiveResources();
		this.nestedResourceContainers = ((SimulatedResourceContainer)originalResourceContainer).getNestedResourceContainers();
		this.parentResourceContainer = ((SimulatedResourceContainer)originalResourceContainer).getParentResourceContainer();
		/*for (Entry<String,AbstractScheduledResource> r : this.activeResources.entrySet()) {
			r.getValue().addDemandListener(new IDemandListener() {
				public void demand(double demand) {
		            	// Do nothing.
		        }
				
				public void demandCompleted(ISchedulableProcess thread) {
					consumeResourceCompleted(thread);
				}
			});
		}*/
	}
	
	@Override
	public void loadActiveResource(SimuComSimProcess requestingProcess, String typeID, double demand) {
		originalResourceContainer.loadActiveResource(requestingProcess, typeID, demand);
	}
	
	@Override
	public void loadActiveResource(SimuComSimProcess requestingProcess, String providedInterfaceID, int resourceServiceID, double demand) {
		originalResourceContainer.loadActiveResource(requestingProcess, providedInterfaceID, resourceServiceID, demand);
	}
	
	@Override
	public IPassiveResource createPassiveResource(String name,
			String passiveResourceID, String assemblyContextID,
			String combinedID, int capacity) {
		IPassiveResource r = null;
		if (cpuSchedulingStrategy.equals(SCHEDULING_STRATEGY_EXACT_WINXP) || 
				cpuSchedulingStrategy.equals(SCHEDULING_STRATEGY_EXACT_WINXP) ||
				cpuSchedulingStrategy.equals(SCHEDULING_STRATEGY_EXACT_WINXP) ||
				cpuSchedulingStrategy.equals(SCHEDULING_STRATEGY_EXACT_WINXP)) {
			r = getPassiveResourceWindows(name, passiveResourceID,
					capacity, 1, true, true, activeResources.get(cpuResourceId)
							.getScheduledResource());
			// setup calculators
			CalculatorHelper.setupStateCalculator(r, this.myModel);
			CalculatorHelper.setupWaitingTimeCalculator(r, this.myModel);
			CalculatorHelper.setupHoldTimeCalculator(r, this.myModel);
			return r;
		} else if (cpuSchedulingStrategy.equals(SCHEDULING_STRATEGY_EXACT_LINUX26O1)) {
			r = getPassiveResourceLinux(name, passiveResourceID, capacity,
					true, activeResources.get(cpuResourceId).getScheduledResource());
			// setup calculators
			CalculatorHelper.setupStateCalculator(r, this.myModel);
			CalculatorHelper.setupWaitingTimeCalculator(r, this.myModel);
			CalculatorHelper.setupHoldTimeCalculator(r, this.myModel);
			return r;
		} else {
			return super.createPassiveResource(name, passiveResourceID, assemblyContextID, combinedID, capacity);
		}

	}
	
	private IPassiveResource getPassiveResourceWindows(String name, String id,
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
	}
	
}

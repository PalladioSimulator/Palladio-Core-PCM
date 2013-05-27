package de.uka.ipd.sdq.simucom.overhead.virtualizationoverhead;

import java.util.HashMap;
import java.util.Map.Entry;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.simucomframework.SimuComSimProcess;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.resources.AbstractScheduledResource;
import de.uka.ipd.sdq.simucomframework.resources.AbstractSimulatedResourceContainer;
import de.uka.ipd.sdq.simucomframework.resources.IDemandListener;
import de.uka.ipd.sdq.simucomframework.resources.SimulatedResourceContainer;

public class LoadDependentResourceContainer extends SimulatedResourceContainer{
	
	AbstractSimulatedResourceContainer originalResourceContainer = null;
	
	private double cpuOverhead = 0.0;

	public LoadDependentResourceContainer(SimuComModel myModel, String myContainerID, AbstractSimulatedResourceContainer originalResourceContainer, double cpuOverhead) {
		super(myModel, myContainerID);
		this.cpuOverhead= cpuOverhead;
		this.originalResourceContainer = originalResourceContainer;
		this.activeResources = originalResourceContainer.getAllActiveResources();
		this.nestedResourceContainers = ((SimulatedResourceContainer)originalResourceContainer).getNestedResourceContainers();
		this.parentResourceContainer = ((SimulatedResourceContainer)originalResourceContainer).getParentResourceContainer();
		for (Entry<String,AbstractScheduledResource> r : this.activeResources.entrySet()) {
			r.getValue().addDemandListener(new IDemandListener() {
				public void demand(double demand) {
		            	// Do nothing.
		        }
				
				public void demandCompleted(ISchedulableProcess thread) {
					consumeResourceCompleted(thread);
				}
			});
		}
	}
	
	public void consumeResourceCompleted(ISchedulableProcess thread) {
		if (processesWaitingOnCpuResource.containsKey(thread)) {
			//System.out.println("CPU DEMAND COMPLETED!");
			processesWaitingOnCpuResource.remove(thread);
		
			// Update demand overheads for all resources of this container and for all
			// sibling resource containers
			updateDemands();
			/*if (allMachines != null) {
				for (int i=0; i<allMachines.size(); i++) {
					Machine machine = allMachines.get(i);
					if (!machine.getMachineId().equals(getResourceContainerID())) {
						AbstractSimulatedResourceContainer otherVM = LoadDependentResourceContainer.this.myModel.getResourceRegistry().getResourceContainer(machine.getMachineId());
						if (!(otherVM instanceof LoadDependentResourceContainer)) {
							throw new RuntimeException("Cannot calculate multi machine overhead, ResourceContainer " + otherVM.getResourceContainerID() + " is not of type LoadDependentResourceContainer!");
						}
						((LoadDependentResourceContainer)otherVM).updateDemands();
					}
				}
			}*/
		}
	}
	
	
	
	public void loadActiveResource(SimuComSimProcess requestingProcess, String typeID, double demand) {
		//logger.info("LOADING DEMAND process " + requestingProcess.getId() + " " + typeID + ": " + demand);
		AbstractScheduledResource cpuResource = getResourceInResourceContainerOrParentResourceContainer("CPU");
		int numberOfCpuProcesses = 0;
		if (typeID.equals("CPU")) {
			int cpuQueueLength = cpuResource.getScheduledResource().getQueueLengthFor(null);
			cpuQueueLength = cpuQueueLength+1;
		}
		
		double demandOverhead = 1.0;
		if (typeID.equals("CPU")) {
			demandOverhead = calculateCpuOverhead(numberOfCpuProcesses);
		}
		if (demandOverhead < 0) {
			demandOverhead = 1.0;
		}
		super.loadActiveResource(requestingProcess, typeID, demandOverhead*demand);
		if (typeID.equals("CPU")) {
			processesWaitingOnCpuResource.put(requestingProcess, demandOverhead);
	
		
			// Update demand overheads for all resources of this container and for all
			// sibling resource containers
			updateDemands();
			/*if (allMachines != null) {
				for (int i=0; i<allMachines.size(); i++) {
					Machine machine = allMachines.get(i);
					if (!machine.getMachineId().equals(getResourceContainerID())) {
						AbstractSimulatedResourceContainer otherVM = myModel.getResourceRegistry().getResourceContainer(machine.getMachineId());
						if (!(otherVM instanceof LoadDependentResourceContainer)) {
							throw new RuntimeException("Cannot calculate multi machine overhead, ResourceContainer " + otherVM.getResourceContainerID() + " is not of type LoadDependentResourceContainer!");
						}
						((LoadDependentResourceContainer)otherVM).updateDemands();
					}
				}
			}*/
			
		}
	}
	
	HashMap<SimuComSimProcess, Double> processesWaitingOnCpuResource = new HashMap<SimuComSimProcess, Double>();
	
	public void updateDemands() {
		AbstractScheduledResource cpuResource = getResourceInResourceContainerOrParentResourceContainer("CPU");
		int numberOfCpuProcesses = getNumberOfCpuProcesses();
		
		double newCpuDemandOverhead = calculateCpuOverhead(numberOfCpuProcesses);
				
		if ((cpuResource != null) && (newCpuDemandOverhead > 0)) {
			for (Entry<SimuComSimProcess, Double> entrySet : processesWaitingOnCpuResource.entrySet()) {
				double currentDemand = cpuResource.getRemainingDemandForProcess(entrySet.getKey());
				if (currentDemand > 0) {
					currentDemand = currentDemand / entrySet.getValue();
					currentDemand = currentDemand * newCpuDemandOverhead;
					cpuResource.updateDemand(entrySet.getKey(), currentDemand);
				}
				entrySet.setValue(newCpuDemandOverhead);
			}

		}
		
	}
	
	public int getNumberOfCpuProcesses() {
		AbstractScheduledResource cpuResource = getResourceInResourceContainerOrParentResourceContainer("CPU");
		if (cpuResource != null) {
			return processesWaitingOnCpuResource.size();
		} else {
			return 0;
		}
	}
	
	
	public double calculateCpuOverhead(int numberOfCpuProcesses) {
		double newCpuDemandOverhead = 1.0;
		if (numberOfCpuProcesses > 1) {
			newCpuDemandOverhead = cpuOverhead;
		}

		return newCpuDemandOverhead;
	}
	
	

}

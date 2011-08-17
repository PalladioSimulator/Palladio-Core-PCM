package de.uka.ipd.sdq.scheduler.processes.impl;

import java.util.Hashtable;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.active.SimActiveResource;


public class ProcessRegistry {
	
	private Hashtable<ISchedulableProcess, IActiveProcess> registry;
	
	public ProcessRegistry(SimActiveResource resource) {
		super();
		this.registry = new Hashtable<ISchedulableProcess, IActiveProcess>();
	}

	public void registerProcess(IActiveProcess process){
		registry.put(process.getSchedulableProcess(), process);
	}
	
	public IActiveProcess lookUp(ISchedulableProcess process){
		return registry.get(process);
	}
	
	public void unregisterProcess(ISchedulableProcess process){
		registry.remove(process);
	}

	public IActiveProcess findProcess(String processName) {
		for (IActiveProcess p: registry.values()){
			if (p.getName().startsWith(processName))
				return p;
		}
		assert false : "Cannot find process: " + processName;  
		return null;
	}

	public boolean isRegistered(IActiveProcess p) {
		return registry.containsKey(p.getSchedulableProcess());
	}
	
}

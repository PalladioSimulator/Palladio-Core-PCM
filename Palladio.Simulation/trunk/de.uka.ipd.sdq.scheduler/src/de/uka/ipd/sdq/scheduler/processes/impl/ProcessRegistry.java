package de.uka.ipd.sdq.scheduler.processes.impl;

import java.util.Hashtable;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;


public class ProcessRegistry {
	
	private Hashtable<ISchedulableProcess, ActiveProcess> registry;
	
	public ProcessRegistry() {
		super();
		this.registry = new Hashtable<ISchedulableProcess, ActiveProcess>();
	}

	public void registerProcess(ActiveProcess process){
		registry.put(process.getSchedulableProcess(), process);
	}
	
	public ActiveProcess lookUp(ISchedulableProcess process){
		return registry.get(process);
	}
	
	public void unregisterProcess(ISchedulableProcess process){
		registry.remove(process);
	}
	
}

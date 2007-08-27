package de.uka.ipd.sdq.scheduler.processes.impl;

import java.util.Hashtable;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;


public class ProcessRegistry {
	
	private Hashtable<ISchedulableProcess, IActiveProcess> registry;
	
	public ProcessRegistry() {
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
	
}

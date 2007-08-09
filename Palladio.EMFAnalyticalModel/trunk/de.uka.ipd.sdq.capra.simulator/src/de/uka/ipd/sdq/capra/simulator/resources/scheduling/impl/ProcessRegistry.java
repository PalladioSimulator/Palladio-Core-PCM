package de.uka.ipd.sdq.capra.simulator.resources.scheduling.impl;

import java.util.Hashtable;

import de.uka.ipd.sdq.capra.simulator.CapraSim;
import de.uka.ipd.sdq.capra.simulator.expressions.SimCapraProcess;

public class ProcessRegistry {
	
	protected Hashtable<SimCapraProcess, PreemptiveProcess> processTable = new Hashtable<SimCapraProcess, PreemptiveProcess>();
	
	public PreemptiveProcess getPreemptiveProcess(SimCapraProcess capraProcess) {
		PreemptiveProcess result = processTable.get(capraProcess);
		if (result == null){
			CapraSim.logger.error("Unregistered Process: " + capraProcess.getName());
			registerProcess(capraProcess);
			result = processTable.get(capraProcess);
		}
		return result;
	}

	public void registerProcess(SimCapraProcess capraProcess) {
		PreemptiveProcess preemptiveProcess = new PreemptiveProcess(capraProcess);
		processTable.put(capraProcess, preemptiveProcess);
	}
	
	public void unregisterProcess(SimCapraProcess capraProcess){
		processTable.remove(capraProcess);
	}
	
	public boolean allProcessesReady() {
		for (SimCapraProcess process : processTable.keySet()) {
			if (!process.isReady())
				return false;
		}
		return true;
	}
}

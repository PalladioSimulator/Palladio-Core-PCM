package de.uka.ipd.sdq.qnm.simulator.resources;

import java.util.HashMap;


import desmoj.core.simulator.SimProcess;

public class SimulatedResources {

	private HashMap<String,SimProcess> resources;
	
	public SimulatedResources(){
		this.resources = new HashMap<String, SimProcess>();
	}

	public HashMap<String, SimProcess> getResources() {
		return resources;
	}

	public void setResources(HashMap<String, SimProcess> resources) {
		this.resources = resources;
	}
	
}

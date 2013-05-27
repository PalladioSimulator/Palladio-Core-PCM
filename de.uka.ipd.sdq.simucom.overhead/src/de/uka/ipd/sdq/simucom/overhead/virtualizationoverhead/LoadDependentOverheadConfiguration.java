package de.uka.ipd.sdq.simucom.overhead.virtualizationoverhead;

import java.util.HashMap;
import java.util.Set;

public class LoadDependentOverheadConfiguration {

	private HashMap<String, Double> cpuOverheadForResourceContainer = null;
	
	public LoadDependentOverheadConfiguration() {
		cpuOverheadForResourceContainer = new HashMap<String, Double>();
	}
	
	public double getOverhead(String resourceContainerId) {
		return cpuOverheadForResourceContainer.get(resourceContainerId);
	}
	
	public void addOverhead(String resourceContainerId, double overhead) {
		cpuOverheadForResourceContainer.put(resourceContainerId, new Double(overhead));
	}
	
	public Set<String> getResourceContainerIds() {
		return cpuOverheadForResourceContainer.keySet();
	}

}

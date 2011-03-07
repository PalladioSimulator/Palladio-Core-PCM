package de.uka.ipd.sdq.probespec.framework.probes.example;

import java.util.HashMap;
import java.util.Map;

public class SimpleDemandingComponent implements ISimpleDemanding {

	private Map<ASimpleActiveResource, Double> demandMap;
	
	public SimpleDemandingComponent() {
		super();
		demandMap = new HashMap<ASimpleActiveResource, Double>();
	}

	@Override
	public double getDemand(ASimpleActiveResource resource) {
		if (!demandMap.containsKey(resource)) return 0;
		return demandMap.get(resource);
	}

	@Override
	public void setDemand(ASimpleActiveResource resource, double demand) {
		demandMap.put(resource, demand);
	}

}

package de.uka.ipd.sdq.probespec.framework.probes.example;

public interface ISimpleDemanding {

	double getDemand(ASimpleActiveResource resource);
	
	void setDemand(ASimpleActiveResource resource, double demand);
	
}

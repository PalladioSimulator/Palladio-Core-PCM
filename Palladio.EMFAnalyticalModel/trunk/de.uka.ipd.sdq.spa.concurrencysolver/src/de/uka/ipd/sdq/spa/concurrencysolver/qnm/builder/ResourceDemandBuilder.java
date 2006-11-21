package de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder;

import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.ManagedPDF;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder.exceptions.ResourceNotDeviceException;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder.exceptions.ResourceNotLogicalServerException;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder.exceptions.UnknownServerException;

public interface ResourceDemandBuilder {
	
	void addDeviceDemand(String resourceName, ManagedPDF demandTime) throws UnknownServerException, ResourceNotDeviceException;
	
	ResourceDemandBuilder addLogicalDemand(String resourceName) throws ResourceNotLogicalServerException, UnknownServerException;

	ResourceDemandBuilder getParentBuilder();
}

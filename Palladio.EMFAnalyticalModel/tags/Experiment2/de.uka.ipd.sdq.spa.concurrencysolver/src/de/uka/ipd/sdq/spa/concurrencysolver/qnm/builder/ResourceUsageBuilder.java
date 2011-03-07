package de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder;

import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.ManagedPDF;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder.exceptions.ResourceNotDeviceException;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder.exceptions.ResourceNotPassiveException;
import de.uka.ipd.sdq.spa.concurrencysolver.qnm.builder.exceptions.UnknownResourceException;

public interface ResourceUsageBuilder {
	
	void addResourceUsage(String resourceName, ManagedPDF demandTime) throws UnknownResourceException, ResourceNotDeviceException;
	
	ResourceUsageBuilder addSequentialResourceUsage(String resourceName) throws ResourceNotPassiveException, UnknownResourceException;

	ResourceUsageBuilder getParentBuilder();
}

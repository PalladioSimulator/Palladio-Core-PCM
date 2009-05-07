package de.uka.ipd.sdq.jvmbenchmark2model.pcm.resourcedemand;

import de.uka.ipd.sdq.pcm.resourcetype.ResourceRequiredRole;
import de.uka.ipd.sdq.pcm.seff.performance.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.performance.PerformanceFactory;


public abstract class ResourceDemandFactory {

	protected ParametricResourceDemand demand;
	protected PerformanceFactory performanceFactory;

	public ResourceDemandFactory() {
		this.performanceFactory = PerformanceFactory.eINSTANCE;
	}

	public abstract ParametricResourceDemand createResourceDemand(
			String serviceName, String specification, ResourceRequiredRole role);

}
package de.uka.ipd.sdq.jvmbenchmark2model.pcm.resourcedemand;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.core.CoreFactory;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRequiredRole;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceService;
import de.uka.ipd.sdq.pcm.seff.performance.ParametricResourceDemand;

/**
 * Encapsulates a {@link DefaultResourceDemandFactory} of an internal action,
 * including the decision which type of demand the underlying method invocation
 * is associated with.
 * 
 * @author thomas
 */
public class DefaultResourceDemandFactory extends ResourceDemandFactory {

	//private static final String DEFAULT_SPECIFICATION = "0"; // in PCM 3.x no more a string
	private static final PCMRandomVariable DEFAULT_SPECIFICATION =
		CoreFactory.eINSTANCE.createPCMRandomVariable();
	
	private static Logger logger = Logger.getLogger(DefaultResourceDemandFactory.class);


	public DefaultResourceDemandFactory() {
		super();


	}


	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.code2model.pcm.resourcedemands.ResourceDemandFactory#createResourceDemand(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	@Override
	public ParametricResourceDemand createResourceDemand(String serviceName, String specification, ResourceRequiredRole role) {
		demand = this.performanceFactory.createParametricResourceDemand();
		if (specification == null) {
			demand.setSpecification_ParametericResourceDemand(DEFAULT_SPECIFICATION);
		} else {
			PCMRandomVariable variable = CoreFactory.eINSTANCE.createPCMRandomVariable();
			variable.setSpecification(specification);
			demand.setSpecification_ParametericResourceDemand(variable);
		}
		demand.setResourceRequiredRole_ParametricResourceDemand(role);
		demand.setCalledResourceService_ParametricResourceDemand(getResourceService(role, serviceName));

		return demand;
	}

	/**
	 * Lookup the ResourceService of the ResourceInterface referenced a 
	 * ResourceRequiredRole that matches the given service name string.
	 * 
	 * @param methodName
	 *            the name of service
	 * @return the resource service
	 */
	private ResourceService getResourceService(ResourceRequiredRole role, String serviceName) {
		for (ResourceService service: role.getRequiredResourceInterface_ResourceRequiredRole().getResourceServices_ResourceInterface()) {
			if (service.getServiceName().equals(serviceName)) {
				return service;
			}
		}
		logger.error("No Resource Service found for service name '" + serviceName + "'!");
		return null;
	}
}

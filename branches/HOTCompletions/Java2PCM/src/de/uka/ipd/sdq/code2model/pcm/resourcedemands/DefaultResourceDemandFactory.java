package de.uka.ipd.sdq.code2model.pcm.resourcedemands;

import java.util.Hashtable;
import java.util.List;

import de.uka.ipd.sdq.code2model.pcm.Code2ModelRepository;
import de.uka.ipd.sdq.pcm.core.CoreFactory;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand;

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

	private static final String METHOD_WILDCARD = "";

	Hashtable<ProcessingResourceType, String> resourcetypeToUnit;
	Hashtable<String, ProcessingResourceType> internalActionMethodToResource;

	public DefaultResourceDemandFactory() {
		super();

		resourcetypeToUnit = new Hashtable<ProcessingResourceType, String>();
		resourcetypeToUnit.put(Code2ModelRepository.IO_RESOURCETYPE, "bytes");
		resourcetypeToUnit.put(Code2ModelRepository.OUTPUT_RESOURCETYPE,
				"characters");
		resourcetypeToUnit.put(Code2ModelRepository.CPU_RESOURCETYPE, "ms");

		internalActionMethodToResource = new Hashtable<String, ProcessingResourceType>();
		internalActionMethodToResource.put(
				createKey("java.io", "print"),
				Code2ModelRepository.OUTPUT_RESOURCETYPE);
		internalActionMethodToResource.put(
				createKey("java.io", "println"),
				Code2ModelRepository.OUTPUT_RESOURCETYPE);
		internalActionMethodToResource.put(
				createKey("java.io", METHOD_WILDCARD),
				Code2ModelRepository.IO_RESOURCETYPE);
		internalActionMethodToResource.put(
				createKey("java.net", METHOD_WILDCARD),
				Code2ModelRepository.IO_RESOURCETYPE);
		internalActionMethodToResource.put(
				createKey("java.sql", METHOD_WILDCARD),
				Code2ModelRepository.IO_RESOURCETYPE);
		internalActionMethodToResource.put(
				createKey("java.util.logging", METHOD_WILDCARD),
				Code2ModelRepository.IO_RESOURCETYPE);
		internalActionMethodToResource.put(
				createKey("java.util.zip", METHOD_WILDCARD),
				Code2ModelRepository.IO_RESOURCETYPE);
		internalActionMethodToResource.put(
				createKey("javax.imageio", METHOD_WILDCARD),
				Code2ModelRepository.IO_RESOURCETYPE);
		internalActionMethodToResource.put(
				createKey("javax.net", METHOD_WILDCARD),
				Code2ModelRepository.IO_RESOURCETYPE);
		internalActionMethodToResource.put(
				createKey("javax.sql", METHOD_WILDCARD),
				Code2ModelRepository.IO_RESOURCETYPE);
	}

	/**
	 * Create a key for a method regarded as an internal, resource demanding
	 * action on the PCM side. The key is used to retrieve the resource to use
	 * in the {@link InternalAction}s.
	 * 
	 * @param pkg
	 *            the method's package
	 * @param method
	 *            the method
	 * @return the key as String
	 */
	private String createKey(String pkg, String method) {
		return pkg + "." + method;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.code2model.pcm.resourcedemands.ResourceDemandFactory#createResourceDemand(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	@Override
	public ParametricResourceDemand createResourceDemand(List<String> args,
			String packageName, String methodName) {
		demand = this.seffFactory.createParametricResourceDemand();
		demand.setSpecification_ParametericResourceDemand(DEFAULT_SPECIFICATION);
		
		String key = createKey(packageName, methodName);
		ProcessingResourceType resourceType = internalActionMethodToResource.get(key);
		if (resourceType == null) {
			key = createKey(packageName, METHOD_WILDCARD);
			resourceType = internalActionMethodToResource.get(key);
		}
		if (resourceType != null) {			
			demand.setRequiredResource_ParametricResourceDemand(resourceType);
			//String unit = resourcetypeToUnit.get(resourceType);		
			//demand.setUnit(unit); //unit unused in PCM 3.x
		}

		return demand;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.code2model.pcm.resourcedemands.ResourceDemandFactory#getNewCPUDemand()
	 */
	@Override
	public ParametricResourceDemand getNewCPUDemand() {
		demand = this.seffFactory.createParametricResourceDemand();
		demand.setSpecification_ParametericResourceDemand(DEFAULT_SPECIFICATION);		
		demand.setRequiredResource_ParametricResourceDemand(Code2ModelRepository.CPU_RESOURCETYPE);		
		//String unit = resourcetypeToUnit.get(Code2ModelRepository.CPU_RESOURCETYPE);
		//demand.setUnit(unit); //unit unused in PCM 3.x
		return demand;
	}

	/**
	 * Build a String representation of a method call in the form
	 * <code>package.methodName(argExpression1, argExpression2)</code>.
	 * 
	 * @param args
	 *            the list of argument expressions
	 * @param packageName
	 *            the name of the method's package
	 * @param methodName
	 *            the name of the method
	 * @return the representation
	 */
	private String getStringRepresentationOfCall(List<String> args,
			String packageName, String methodName) {
		return packageName + "." + methodName + "(" + args.toString() + ")";
	}
}

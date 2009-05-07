/**
 * 
 */
package de.uka.ipd.sdq.code2model.pcm.resourcedemands;

import java.util.List;

import de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.SeffFactory;

/**
 * @author thomas
 * 
 */
public abstract class ResourceDemandFactory {

	protected ParametricResourceDemand demand;
	protected SeffFactory seffFactory;

	public ResourceDemandFactory() {
		this.seffFactory = SeffFactory.eINSTANCE;
	}

	public abstract ParametricResourceDemand createResourceDemand(
			List<String> args, String packageName, String methodName);
	
	/**
	 * Create a "default" resource demand independent of certain code
	 * constructs, using the CPU resource.
	 * 
	 * @return the new CPU-using resource demand
	 */
	public abstract ParametricResourceDemand getNewCPUDemand();
}
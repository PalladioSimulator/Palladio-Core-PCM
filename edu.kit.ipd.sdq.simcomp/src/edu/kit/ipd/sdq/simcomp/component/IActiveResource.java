package edu.kit.ipd.sdq.simcomp.component;

import de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand;

public interface IActiveResource extends IResource {

	/**
	 * TODO (SimComp): check if we have to integrate ISchedulableProcess as parameter
	 * 
	 * @param abstractDemand
	 */
	public void consume(IRequest request, ParametricResourceDemand abstractDemand);

}

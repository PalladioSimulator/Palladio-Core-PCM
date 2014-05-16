package edu.kit.ipd.sdq.simcomp.component;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceType;

public interface IActiveResource extends IResource {

	/**
	 * TODO (SimComp): check if we have to integrate ISchedulableProcess as parameter
	 * 
	 * @param abstractDemand
	 */
//	public void consume(IRequest request, ParametricResourceDemand abstractDemand);

	void consume(IRequest request, ResourceContainer resourceContainer, ResourceType resourceType, double absoluteDemand);

}

package edu.kit.ipd.sdq.simcomp.resource.active.component;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceType;
import edu.kit.ipd.sdq.simcomp.component.IRequest;
import edu.kit.ipd.sdq.simcomp.component.ISimulationComponent;

/**
 * Represents an active resource simulation component which can be consumed.
 * 
 * @author Christoph Föhrdes
 *
 */
public interface IActiveResource extends ISimulationComponent {

	/**
	 * Consumes a specific demand of the active resource.
	 * 
	 * @param request
	 * @param resourceContainer
	 * @param resourceType
	 * @param absoluteDemand
	 */
	void consume(IRequest request, ResourceContainer resourceContainer, ResourceType resourceType, double absoluteDemand);

}

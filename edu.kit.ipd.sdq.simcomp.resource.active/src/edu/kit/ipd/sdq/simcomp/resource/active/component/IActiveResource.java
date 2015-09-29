package edu.kit.ipd.sdq.simcomp.resource.active.component;

import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;
import org.palladiosimulator.pcm.resourcetype.ResourceType;

import edu.kit.ipd.sdq.simcomp.component.IRequest;
import edu.kit.ipd.sdq.simcomp.component.ISimulationComponent;

/**
 * Represents an active resource simulation component which can be consumed.
 * 
 * TODO (SimComp) Introduce active resource simulation events
 * 
 * @author Christoph Föhrdes
 * 
 */
public interface IActiveResource extends ISimulationComponent {

	/**
	 * Consumes a specific demand of this active resource.
	 * 
	 * @param request
	 * @param resourceContainer
	 * @param resourceType
	 * @param absoluteDemand
	 */
	void consume(IRequest request, ResourceContainer resourceContainer, ResourceType resourceType, double absoluteDemand);

}

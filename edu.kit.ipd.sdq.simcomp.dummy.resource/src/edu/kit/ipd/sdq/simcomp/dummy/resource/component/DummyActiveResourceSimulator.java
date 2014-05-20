package edu.kit.ipd.sdq.simcomp.dummy.resource.component;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceType;
import edu.kit.ipd.sdq.simcomp.component.IRequest;
import edu.kit.ipd.sdq.simcomp.resource.active.component.IActiveResource;

/**
 * Dummy implementation of an active resource simulation component.
 * Intended to demonstrate the advanced simulator configuration.
 * 
 * @author Christoph Föhrdes
 *
 */
public class DummyActiveResourceSimulator implements IActiveResource {

	@Override
	public void consume(IRequest request, ResourceContainer resourceContainer, ResourceType resourceType, double absoluteDemand) {
		// we do nothing as this is a dummy implementation
	}

}

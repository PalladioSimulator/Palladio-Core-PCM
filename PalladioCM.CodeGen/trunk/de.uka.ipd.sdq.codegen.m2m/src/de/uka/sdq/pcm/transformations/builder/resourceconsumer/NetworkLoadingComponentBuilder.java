package de.uka.sdq.pcm.transformations.builder.resourceconsumer;

import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentFactory;
import de.uka.ipd.sdq.pcm.resourcetype.CommunicationLinkResourceType;
import de.uka.sdq.pcm.transformations.builder.abstractbuilder.BasicComponentBuilder;
import de.uka.sdq.pcm.transformations.builder.seff.DelegatorComponentSeffBuilder;
import de.uka.sdq.pcm.transformations.builder.seff.StaticInternalActionDescriptor;
import de.uka.sdq.pcm.transformations.builder.util.PCMAndCompletionModelHolder;

/**
 * Generates a BasicComponent which determines and loads the underlying network resource with the message's size of the message to transmit.
 * Respects both requesting service and returning from service.
 * 
 * @author Steffen
 *
 */
public class NetworkLoadingComponentBuilder extends BasicComponentBuilder {

	private CommunicationLinkResourceType typeOfLink;

	/**
	 * Constructor of the network load simulator component
	 * @param models Container for the PCM model instance to modify
	 * @param interf Interface of the component, used to delgate the method calls to its target
	 * @param linkingRes The linking resource on which the load is created
	 */
	public NetworkLoadingComponentBuilder(
			PCMAndCompletionModelHolder models,
			Interface interf, 
			LinkingResource linkingRes) {
		super(models, interf, null);
		
		typeOfLink = linkingRes.getCommunicationLinkResourceSpecifications_LinkingResource().getCommunicationLinkResourceType_CommunicationLinkResourceSpecification();
		ResourceContainer dummyContainer = ResourceenvironmentFactory.eINSTANCE.createResourceContainer();
		dummyContainer.setId(linkingRes.getId());
		
		this.container = dummyContainer;
	}

	/**
	 * Returns a SEFF builder which adds a network demand depending on the parameters passed
	 */
	@Override
	protected DelegatorComponentSeffBuilder getSeffBuilder() {
		DelegatorComponentSeffBuilder builder = new DelegatorComponentSeffBuilder(getProvidedRole(),getRequiredRole());

		// Network demand for the Request
		builder.appendPreAction(new StaticInternalActionDescriptor("stream.BYTESIZE", typeOfLink));
		
		// Network demand for the Reply
		builder.appendPostAction(new StaticInternalActionDescriptor("stream.BYTESIZE", typeOfLink));
		return builder;
	}
}

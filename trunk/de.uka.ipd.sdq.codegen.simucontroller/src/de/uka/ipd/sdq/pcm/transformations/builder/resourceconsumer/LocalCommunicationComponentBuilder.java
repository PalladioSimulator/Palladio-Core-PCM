package de.uka.ipd.sdq.pcm.transformations.builder.resourceconsumer;

import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.transformations.builder.abstractbuilder.BasicComponentBuilder;
import de.uka.ipd.sdq.pcm.transformations.builder.seff.DelegatorComponentSeffBuilder;
import de.uka.ipd.sdq.pcm.transformations.builder.util.PCMAndCompletionModelHolder;

/**
 * Generates a BasicComponent which determines and loads the underlying network resource with the message's size of the message to transmit.
 * Respects both requesting service and returning from service.
 * 
 * @author Steffen
 *
 */
public class LocalCommunicationComponentBuilder extends BasicComponentBuilder {

	/**
	 * Constructor of the network load simulator component
	 * @param models Container for the PCM model instance to modify
	 * @param interf Interface of the component, used to delegate the method calls to its target
	 * @param linkingRes The linking resource on which the load is created
	 */
	public LocalCommunicationComponentBuilder(
			PCMAndCompletionModelHolder models,
			OperationInterface interf) {
		super(models, interf, null, "LocalCommunicationComponent");
	}

	/**
	 * Returns a SEFF builder which adds a network demand depending on the parameters passed
	 */
	@Override
	protected DelegatorComponentSeffBuilder getSeffBuilder() {
		DelegatorComponentSeffBuilder builder = new DelegatorComponentSeffBuilder(getOperationProvidedRole(),getOperationRequiredRole());
		return builder;
	}
}

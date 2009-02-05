package de.uka.sdq.pcm.transformations.builder.infrastructure;

import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.sdq.pcm.transformations.builder.seff.DelegatorComponentSeffBuilder;
import de.uka.sdq.pcm.transformations.builder.seff.MarshallerComponentSeffBuilder;
import de.uka.sdq.pcm.transformations.builder.util.PCMAndCompletionModelHolder;

public class MarshallingComponentBuilder extends
		BasicMiddlewareComponentBuilder {
	
	public enum MarshallerSide {
		CLIENT,
		SERVER
	}

	private MarshallerSide side;
	
	public MarshallingComponentBuilder(
			PCMAndCompletionModelHolder models, 
			Interface providedIf,
			Interface requiredIf, 
			Interface middlewareInterface,
			ResourceContainer container,
			 MarshallerSide side) {
		super(models, providedIf, requiredIf, middlewareInterface, container);
		this.side = side;
	}

	@Override
	protected DelegatorComponentSeffBuilder getSeffBuilder() {
		MarshallerComponentSeffBuilder builder = new MarshallerComponentSeffBuilder(getProvidedRole(),getRequiredRole(),getMiddlewareRole(),side);
		return builder;
	}

}

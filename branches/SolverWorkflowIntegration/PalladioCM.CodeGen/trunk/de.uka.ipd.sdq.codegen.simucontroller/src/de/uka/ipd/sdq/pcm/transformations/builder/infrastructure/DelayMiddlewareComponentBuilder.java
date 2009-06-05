package de.uka.ipd.sdq.pcm.transformations.builder.infrastructure;

import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.transformations.builder.seff.DelegatorComponentSeffBuilder;
import de.uka.ipd.sdq.pcm.transformations.builder.seff.StaticInternalActionDescriptor;
import de.uka.ipd.sdq.pcm.transformations.builder.util.PCMAndCompletionModelHolder;

public class DelayMiddlewareComponentBuilder extends
		BasicMiddlewareComponentBuilder {

	private String demandStoEx;

	public DelayMiddlewareComponentBuilder(PCMAndCompletionModelHolder models,
			Interface providedIf, Interface requiredIf,
			Interface middlewareInterface, ResourceContainer container,
			String demandStoEx) {
		super(models, providedIf, requiredIf, middlewareInterface, container);
		if (demandStoEx == null)
			throw new IllegalArgumentException("Stoex cannot be null");
		this.demandStoEx = demandStoEx;
	}

	@Override
	protected DelegatorComponentSeffBuilder getSeffBuilder() {
		DelegatorComponentSeffBuilder builder = super.getSeffBuilder();
		builder.appendPreAction(new StaticInternalActionDescriptor(demandStoEx,findResourceType("cpu")));
		builder.appendPostAction(new StaticInternalActionDescriptor(demandStoEx,findResourceType("cpu")));
		return builder;
	}

}

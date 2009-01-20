package de.uka.sdq.pcm.transformations.builder.infrastructure;

import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.sdq.pcm.transformations.builder.seff.DelegatorComponentSeffBuilder;
import de.uka.sdq.pcm.transformations.builder.seff.StaticInternalActionDescriptor;
import de.uka.sdq.pcm.transformations.builder.util.PCMAndCompletionModelHolder;

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
	// Hauck 2008.12.23: Do not use ProcessingResourceType, but ResourceRequiredRole and ResourceService
	protected DelegatorComponentSeffBuilder getSeffBuilder() {
		DelegatorComponentSeffBuilder builder = super.getSeffBuilder();
		builder.appendPreAction(new StaticInternalActionDescriptor(demandStoEx,findResourceRequiredRole(findResourceType("cpu")), findResourceService(findResourceType("cpu"), "process")));
		builder.appendPostAction(new StaticInternalActionDescriptor(demandStoEx,findResourceRequiredRole(findResourceType("cpu")), findResourceService(findResourceType("cpu"), "process")));
		return builder;
	}

}

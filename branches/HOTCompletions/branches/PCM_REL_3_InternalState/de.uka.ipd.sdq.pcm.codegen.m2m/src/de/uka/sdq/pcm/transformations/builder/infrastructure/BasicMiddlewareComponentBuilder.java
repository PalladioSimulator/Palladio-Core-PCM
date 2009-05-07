package de.uka.sdq.pcm.transformations.builder.infrastructure;

import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.sdq.pcm.transformations.builder.abstractbuilder.BasicComponentBuilder;
import de.uka.sdq.pcm.transformations.builder.seff.DelegatorComponentSeffBuilder;
import de.uka.sdq.pcm.transformations.builder.seff.MiddlewareComponentSeffBuilder;
import de.uka.sdq.pcm.transformations.builder.util.PCMAndCompletionModelHolder;

public class BasicMiddlewareComponentBuilder extends BasicComponentBuilder
		implements IMiddlewareInteractingComponentBuilder {

	protected Interface middleware;
	private RequiredRole myRequiredMiddlewareInterface;


	public BasicMiddlewareComponentBuilder(PCMAndCompletionModelHolder models,
			Interface providedIf, Interface requiredIf, Interface middlewareInterface,
			ResourceContainer container) {
		super(models, providedIf, requiredIf, container);
		
		middleware = middlewareInterface;
	}

	@Override
	public void build() {
		myRequiredMiddlewareInterface = addRequiredRole(middleware,"Middleware");
		super.build();
	}

	@Override
	protected DelegatorComponentSeffBuilder getSeffBuilder(){
		return new MiddlewareComponentSeffBuilder(getProvidedRole(),getRequiredRole(),getMiddlewareRole());
	}
	
	public RequiredRole getMiddlewareRole() {
		return myRequiredMiddlewareInterface;
	}

}

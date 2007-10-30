package de.uka.sdq.pcm.transformations.builder.connectors;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;
import de.uka.sdq.pcm.transformations.builder.IComponentBuilder;
import de.uka.sdq.pcm.transformations.builder.infrastructure.IMiddlewareInteractingComponentBuilder;
import de.uka.sdq.pcm.transformations.builder.util.PCMAndCompletionModelHolder;

public abstract class AbstractClientServerConnectorCompletionBuilder
extends AbstractConnectorCompletionBuilder
implements IClientServerConnectorCompletionComponentBuilder {

	protected Interface middlewareInterface;
	private RequiredRole myClientRole;
	private RequiredRole myServerRole;
	protected LinkingResource myLinkingResource;
	private IComponentBuilder innerBuilder;

	public AbstractClientServerConnectorCompletionBuilder(
			PCMAndCompletionModelHolder models, 
			AssemblyConnector connector,
			LinkingResource linkingResource,
			IComponentBuilder innerBuilder) {
		super(models, connector);
		
		middlewareInterface = models.getMiddlewareRepository().getInterfaces__Repository().get(0);
		this.myLinkingResource = linkingResource;
		this.innerBuilder = innerBuilder;
	}
	
	public RequiredRole getClientSideMiddlewareRole() {
		return myClientRole;
	}

	public RequiredRole getServerSideMiddlewareRole() {
		return myServerRole;
	}

	protected abstract IMiddlewareInteractingComponentBuilder getClientSideBuilder();
	protected abstract IMiddlewareInteractingComponentBuilder getServerSideBuilder();

	public void build() {
		super.build();
		
		innerBuilder.build();
		getComposedStructure().getChildComponentContexts_ComposedStructure().add(innerBuilder.getAssemblyContext());
		
		myClientRole = addRequiredRole(middlewareInterface,"ClientMiddleware");
		myServerRole = addRequiredRole(middlewareInterface,"ServerMiddleware");
		
		getClientSideBuilder().build();
		this.getComposedStructure().getChildComponentContexts_ComposedStructure().add(getClientSideBuilder().getAssemblyContext());
		getServerSideBuilder().build();
		this.getComposedStructure().getChildComponentContexts_ComposedStructure().add(getServerSideBuilder().getAssemblyContext());
				
		addProvidedDelegationConnector(getClientSideBuilder().getProvidedRole(), getClientSideBuilder().getAssemblyContext(), myComponent.getProvidedRoles_InterfaceProvidingEntity().get(0));
		addRequiredDelegationConnector(getServerSideBuilder().getRequiredRole(),getServerSideBuilder().getAssemblyContext(),myComponent.getRequiredRoles_InterfaceRequiringEntity().get(0));
		
		addAssemblyConnector(getClientSideBuilder().getRequiredRole(), getClientSideBuilder().getAssemblyContext(), 
				innerBuilder.getProvidedRole(), innerBuilder.getAssemblyContext());
		addAssemblyConnector(innerBuilder.getRequiredRole(),innerBuilder.getAssemblyContext(),
				getServerSideBuilder().getProvidedRole(), getServerSideBuilder().getAssemblyContext());
		
		if (innerBuilder instanceof IClientServerConnectorCompletionComponentBuilder) {
			IClientServerConnectorCompletionComponentBuilder csBuilder = (IClientServerConnectorCompletionComponentBuilder) innerBuilder;
			addRequiredDelegationConnector(csBuilder.getClientSideMiddlewareRole(), csBuilder.getAssemblyContext(), getClientSideMiddlewareRole());
			addRequiredDelegationConnector(csBuilder.getServerSideMiddlewareRole(), csBuilder.getAssemblyContext(), getServerSideMiddlewareRole());
		}

		addRequiredDelegationConnector(getClientSideBuilder().getMiddlewareRole(), getClientSideBuilder().getAssemblyContext(), getClientSideMiddlewareRole());
		addRequiredDelegationConnector(getServerSideBuilder().getMiddlewareRole(), getServerSideBuilder().getAssemblyContext(), getServerSideMiddlewareRole());
	}
}

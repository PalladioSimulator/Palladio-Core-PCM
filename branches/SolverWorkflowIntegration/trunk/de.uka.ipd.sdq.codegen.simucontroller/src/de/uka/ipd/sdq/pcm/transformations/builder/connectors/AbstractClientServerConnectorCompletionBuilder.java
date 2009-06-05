package de.uka.ipd.sdq.pcm.transformations.builder.connectors;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.transformations.builder.IComponentBuilder;
import de.uka.ipd.sdq.pcm.transformations.builder.infrastructure.IMiddlewareInteractingComponentBuilder;
import de.uka.ipd.sdq.pcm.transformations.builder.util.PCMAndCompletionModelHolder;

public abstract class AbstractClientServerConnectorCompletionBuilder
extends AbstractConnectorCompletionBuilder
implements IClientServerConnectorCompletionComponentBuilder {

	protected Interface middlewareInterface;
	private RequiredRole myClientRole;
	private RequiredRole myServerRole;
	private IComponentBuilder innerBuilder;

	private IMiddlewareInteractingComponentBuilder serverBuilder;
	private IMiddlewareInteractingComponentBuilder clientBuilder;

	protected ResourceContainer fromResourceContainer;
	protected ResourceContainer toResourceContainer;
	
	public AbstractClientServerConnectorCompletionBuilder(
			PCMAndCompletionModelHolder models, 
			AssemblyConnector connector,
			ResourceContainer fromResourceContainer,
			ResourceContainer toResourceContainer,
			IComponentBuilder innerBuilder) {
		super(models, connector);
		
		middlewareInterface = models.getMiddlewareRepository().getInterfaces__Repository().get(0);
		this.fromResourceContainer = fromResourceContainer;
		this.toResourceContainer = toResourceContainer;
		this.innerBuilder = innerBuilder;
	}
	
	public RequiredRole getClientSideMiddlewareRole() {
		return myClientRole;
	}

	public RequiredRole getServerSideMiddlewareRole() {
		return myServerRole;
	}

	protected IMiddlewareInteractingComponentBuilder getClientSideBuilder() {
		return clientBuilder;
	}

	protected IMiddlewareInteractingComponentBuilder getServerSideBuilder() {
		return serverBuilder;
	}

	protected abstract IMiddlewareInteractingComponentBuilder createClientSideBuilder();
	protected abstract IMiddlewareInteractingComponentBuilder createServerSideBuilder();
	
	@Override
	public void build() {
		super.build();
		this.clientBuilder = createClientSideBuilder();
		this.serverBuilder = createServerSideBuilder();
		
		innerBuilder.build();
		getComposedStructure().getAssemblyContexts_ComposedStructure().add(innerBuilder.getAssemblyContext());
		
		myClientRole = addRequiredRole(middlewareInterface,"ClientMiddleware");
		myServerRole = addRequiredRole(middlewareInterface,"ServerMiddleware");
		
		getClientSideBuilder().build();
		this.getComposedStructure().getAssemblyContexts_ComposedStructure().add(getClientSideBuilder().getAssemblyContext());
		getServerSideBuilder().build();
		this.getComposedStructure().getAssemblyContexts_ComposedStructure().add(getServerSideBuilder().getAssemblyContext());
				
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

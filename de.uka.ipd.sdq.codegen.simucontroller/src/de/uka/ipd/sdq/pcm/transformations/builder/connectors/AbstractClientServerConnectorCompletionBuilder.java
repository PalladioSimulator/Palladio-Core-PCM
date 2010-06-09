package de.uka.ipd.sdq.pcm.transformations.builder.connectors;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.transformations.builder.IComponentBuilder;
import de.uka.ipd.sdq.pcm.transformations.builder.infrastructure.IMiddlewareInteractingComponentBuilder;
import de.uka.ipd.sdq.pcm.transformations.builder.util.PCMAndCompletionModelHolder;

public abstract class AbstractClientServerConnectorCompletionBuilder
extends AbstractConnectorCompletionBuilder
implements IClientServerConnectorCompletionComponentBuilder {

	protected OperationInterface middlewareOperationInterface;
	private OperationRequiredRole myClientRole;
	private OperationRequiredRole myServerRole;
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
		
		// TODO due to metamodel changes, I am using an ugly cast here to ensure that the returned interface is an OperationInterface.
		// As the builder currently only works with OperationInterfaces, this works, but it should be done in a cleaner way. 
		middlewareOperationInterface = (OperationInterface)models.getMiddlewareRepository().getInterfaces__Repository().get(0);
		this.fromResourceContainer = fromResourceContainer;
		this.toResourceContainer = toResourceContainer;
		this.innerBuilder = innerBuilder;
	}
	
	public OperationRequiredRole getClientSideMiddlewareRole() {
		return myClientRole;
	}

	public OperationRequiredRole getServerSideMiddlewareRole() {
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
		
		myClientRole = addOperationRequiredRole(middlewareOperationInterface,"ClientMiddleware");
		myServerRole = addOperationRequiredRole(middlewareOperationInterface,"ServerMiddleware");
		
		getClientSideBuilder().build();
		this.getComposedStructure().getAssemblyContexts_ComposedStructure().add(getClientSideBuilder().getAssemblyContext());
		getServerSideBuilder().build();
		this.getComposedStructure().getAssemblyContexts_ComposedStructure().add(getServerSideBuilder().getAssemblyContext());
				
		// TODO due to metamodel changes, I am using an ugly cast here to ensure that the returned RequiredRole is an OperationProvidedRole.
		// As the builder currently only works with OperationProvidedRoles, this works, but it should be done in a cleaner way.
		addProvidedDelegationConnector(getClientSideBuilder().getOperationProvidedRole(), getClientSideBuilder().getAssemblyContext(), (OperationProvidedRole)myComponent.getProvidedRoles_InterfaceProvidingEntity().get(0));
		// TODO due to metamodel changes, I am using an ugly cast here to ensure that the returned RequiredRole is an OperationRequiredRole.
		// As the builder currently only works with OperationRequiredRoles, this works, but it should be done in a cleaner way.
		addRequiredDelegationConnector(getServerSideBuilder().getOperationRequiredRole(),getServerSideBuilder().getAssemblyContext(), (OperationRequiredRole)myComponent.getRequiredRoles_InterfaceRequiringEntity().get(0));
		
		addAssemblyConnector(getClientSideBuilder().getOperationRequiredRole(), getClientSideBuilder().getAssemblyContext(), 
				innerBuilder.getOperationProvidedRole(), innerBuilder.getAssemblyContext());
		addAssemblyConnector(innerBuilder.getOperationRequiredRole(),innerBuilder.getAssemblyContext(),
				getServerSideBuilder().getOperationProvidedRole(), getServerSideBuilder().getAssemblyContext());
		
		if (innerBuilder instanceof IClientServerConnectorCompletionComponentBuilder) {
			IClientServerConnectorCompletionComponentBuilder csBuilder = (IClientServerConnectorCompletionComponentBuilder) innerBuilder;
			addRequiredDelegationConnector(csBuilder.getClientSideMiddlewareRole(), csBuilder.getAssemblyContext(), getClientSideMiddlewareRole());
			addRequiredDelegationConnector(csBuilder.getServerSideMiddlewareRole(), csBuilder.getAssemblyContext(), getServerSideMiddlewareRole());
		}

		addRequiredDelegationConnector(getClientSideBuilder().getMiddlewareRole(), getClientSideBuilder().getAssemblyContext(), getClientSideMiddlewareRole());
		addRequiredDelegationConnector(getServerSideBuilder().getMiddlewareRole(), getServerSideBuilder().getAssemblyContext(), getServerSideMiddlewareRole());
	}
}

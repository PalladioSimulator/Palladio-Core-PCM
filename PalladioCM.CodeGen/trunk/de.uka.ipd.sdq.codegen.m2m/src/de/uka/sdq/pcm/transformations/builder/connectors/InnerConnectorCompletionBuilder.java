package de.uka.sdq.pcm.transformations.builder.connectors;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;
import de.uka.sdq.pcm.transformations.builder.IComponentBuilder;
import de.uka.sdq.pcm.transformations.builder.infrastructure.BasicMiddlewareComponentBuilder;
import de.uka.sdq.pcm.transformations.builder.infrastructure.IMiddlewareInteractingComponentBuilder;
import de.uka.sdq.pcm.transformations.builder.util.PCMAndCompletionModelHolder;

public class InnerConnectorCompletionBuilder
extends AbstractClientServerConnectorCompletionBuilder {

	private BasicMiddlewareComponentBuilder serverBuilder;
	private BasicMiddlewareComponentBuilder clientBuilder;

	public InnerConnectorCompletionBuilder(
			PCMAndCompletionModelHolder models,
			AssemblyConnector connector,
			LinkingResource linkingRes,
			IComponentBuilder innerBuilder) {
		super(models, connector, linkingRes, innerBuilder);
		clientBuilder = 
			new BasicMiddlewareComponentBuilder(
					myModels, 
					this.connectorToReplace.getRequiredRole_CompositeAssemblyConnector().getRequiredInterface__RequiredRole(),
					this.connectorToReplace.getRequiredRole_CompositeAssemblyConnector().getRequiredInterface__RequiredRole(),
					this.middlewareInterface,
					linkingRes.getFromResourceContainer_LinkingResource().get(0));
		serverBuilder = 
			new BasicMiddlewareComponentBuilder(
					myModels, 
					this.connectorToReplace.getRequiredRole_CompositeAssemblyConnector().getRequiredInterface__RequiredRole(),
					this.connectorToReplace.getRequiredRole_CompositeAssemblyConnector().getRequiredInterface__RequiredRole(),
					this.middlewareInterface,
					linkingRes.getToResourceContainer_LinkingResource().get(0));
	}

	protected IMiddlewareInteractingComponentBuilder getClientSideBuilder() {
		return clientBuilder;
	}

	protected IMiddlewareInteractingComponentBuilder getServerSideBuilder() {
		return serverBuilder;
	}

	
}

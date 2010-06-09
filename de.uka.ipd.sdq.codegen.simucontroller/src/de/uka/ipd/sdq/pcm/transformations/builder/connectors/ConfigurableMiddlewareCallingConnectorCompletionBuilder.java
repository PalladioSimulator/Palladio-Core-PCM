package de.uka.ipd.sdq.pcm.transformations.builder.connectors;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.transformations.builder.IComponentBuilder;
import de.uka.ipd.sdq.pcm.transformations.builder.infrastructure.IMiddlewareInteractingComponentBuilder;
import de.uka.ipd.sdq.pcm.transformations.builder.infrastructure.MiddlewareCallingComponentBuilder;
import de.uka.ipd.sdq.pcm.transformations.builder.util.PCMAndCompletionModelHolder;

public class ConfigurableMiddlewareCallingConnectorCompletionBuilder extends
		AbstractClientServerConnectorCompletionBuilder {

	private String clientSideBeforeCall;
	private String clientSideAfterCall;
	private String serverSideBeforeCall;
	private String serverSideAfterCall;

	public ConfigurableMiddlewareCallingConnectorCompletionBuilder(
			PCMAndCompletionModelHolder models, AssemblyConnector connector,
			ResourceContainer fromResourceContainer,
			ResourceContainer toResourceContainer,
			IComponentBuilder innerBuilder,
			String clientSideBeforeCall, String serverSideBeforeCall,
			String serverSideAfterCall, String clientSideAfterCall) {
		super(models, connector, fromResourceContainer, toResourceContainer, innerBuilder);
		this.clientSideBeforeCall = clientSideBeforeCall;
		this.clientSideAfterCall = clientSideAfterCall;
		this.serverSideBeforeCall = serverSideBeforeCall;
		this.serverSideAfterCall = serverSideAfterCall;
	}

	@Override
	protected IMiddlewareInteractingComponentBuilder createClientSideBuilder() {
		MiddlewareCallingComponentBuilder builder = new MiddlewareCallingComponentBuilder
				(myModels, 
				this.connectorToReplace.getRequiredRole__AssemblyConnector().getRequiredInterface__OperationRequiredRole(),
				this.connectorToReplace.getRequiredRole__AssemblyConnector().getRequiredInterface__OperationRequiredRole(),
				this.middlewareOperationInterface,
				this.fromResourceContainer,
				clientSideBeforeCall,
				clientSideAfterCall);
		return builder;
	}

	@Override
	protected IMiddlewareInteractingComponentBuilder createServerSideBuilder() {
		MiddlewareCallingComponentBuilder builder = new MiddlewareCallingComponentBuilder
				(myModels, 
				this.connectorToReplace.getRequiredRole__AssemblyConnector().getRequiredInterface__OperationRequiredRole(),
				this.connectorToReplace.getRequiredRole__AssemblyConnector().getRequiredInterface__OperationRequiredRole(),
				this.middlewareOperationInterface,
				this.toResourceContainer,
				serverSideBeforeCall,
				serverSideAfterCall);
		return builder;
	}
}

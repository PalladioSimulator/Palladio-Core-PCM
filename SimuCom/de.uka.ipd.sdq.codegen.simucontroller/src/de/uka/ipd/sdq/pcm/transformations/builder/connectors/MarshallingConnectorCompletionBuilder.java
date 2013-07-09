package de.uka.ipd.sdq.pcm.transformations.builder.connectors;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.transformations.builder.IComponentBuilder;
import de.uka.ipd.sdq.pcm.transformations.builder.infrastructure.IMiddlewareInteractingComponentBuilder;
import de.uka.ipd.sdq.pcm.transformations.builder.infrastructure.MarshallingComponentBuilder;
import de.uka.ipd.sdq.pcm.transformations.builder.util.PCMAndCompletionModelHolder;

/**
 * Implementation of an InnerConnectorCompletionBuilder which adds the impact of marshalling parameters
 * @author Snowball
 *
 */
public class MarshallingConnectorCompletionBuilder
extends AbstractClientServerConnectorCompletionBuilder {

	public MarshallingConnectorCompletionBuilder(
			PCMAndCompletionModelHolder models,
			AssemblyConnector connector,
			ResourceContainer fromResourceContainer,
			ResourceContainer toResourceContainer,
			IComponentBuilder innerBuilder) {
		super(models, connector, fromResourceContainer, toResourceContainer, innerBuilder, "MarshallingConnectorComponen");
	}

	/**
	 * By default, a dummy component is created which does nothing besides delegating the call.
	 * Override if more actions are needed
	 * @return
	 */
	@Override
	protected IMiddlewareInteractingComponentBuilder createClientSideBuilder() {
		return 	new MarshallingComponentBuilder(
				myModels, 
				this.connectorToReplace.getRequiredRole_AssemblyConnector().getRequiredInterface__OperationRequiredRole(),
				this.connectorToReplace.getRequiredRole_AssemblyConnector().getRequiredInterface__OperationRequiredRole(),
				this.middlewareInterface,
				fromResourceContainer,
				MarshallingComponentBuilder.MarshallerSide.CLIENT);
	}
	
	/**
	 * By default, a dummy component is created which does nothing besides delegating the call.
	 * Override if more actions are needed
	 * @return
	 */
	@Override
	protected IMiddlewareInteractingComponentBuilder createServerSideBuilder() {
		return new MarshallingComponentBuilder(
				myModels, 
				this.connectorToReplace.getRequiredRole_AssemblyConnector().getRequiredInterface__OperationRequiredRole(),
				this.connectorToReplace.getRequiredRole_AssemblyConnector().getRequiredInterface__OperationRequiredRole(),
				this.middlewareInterface,
				toResourceContainer,
				MarshallingComponentBuilder.MarshallerSide.SERVER);
	}
}

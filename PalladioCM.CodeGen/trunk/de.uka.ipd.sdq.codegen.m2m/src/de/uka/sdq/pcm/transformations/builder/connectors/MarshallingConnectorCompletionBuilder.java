package de.uka.sdq.pcm.transformations.builder.connectors;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;
import de.uka.sdq.pcm.transformations.builder.IComponentBuilder;
import de.uka.sdq.pcm.transformations.builder.infrastructure.IMiddlewareInteractingComponentBuilder;
import de.uka.sdq.pcm.transformations.builder.infrastructure.MarshallingComponentBuilder;
import de.uka.sdq.pcm.transformations.builder.util.PCMAndCompletionModelHolder;

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
			LinkingResource linkingRes,
			IComponentBuilder innerBuilder) {
		super(models, connector, linkingRes, innerBuilder);
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
				this.connectorToReplace.getRequiredRole_CompositeAssemblyConnector().getRequiredInterface__RequiredRole(),
				this.connectorToReplace.getRequiredRole_CompositeAssemblyConnector().getRequiredInterface__RequiredRole(),
				this.middlewareInterface,
				this.myLinkingResource.getFromResourceContainer_LinkingResource().get(0),
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
				this.connectorToReplace.getRequiredRole_CompositeAssemblyConnector().getRequiredInterface__RequiredRole(),
				this.connectorToReplace.getRequiredRole_CompositeAssemblyConnector().getRequiredInterface__RequiredRole(),
				this.middlewareInterface,
				this.myLinkingResource.getToResourceContainer_LinkingResource().get(0),
				MarshallingComponentBuilder.MarshallerSide.SERVER);
	}
}

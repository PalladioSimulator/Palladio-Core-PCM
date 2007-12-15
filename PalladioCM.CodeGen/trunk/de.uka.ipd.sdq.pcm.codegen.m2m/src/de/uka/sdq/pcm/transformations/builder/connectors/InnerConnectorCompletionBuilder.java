package de.uka.sdq.pcm.transformations.builder.connectors;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;
import de.uka.sdq.pcm.transformations.builder.IComponentBuilder;
import de.uka.sdq.pcm.transformations.builder.infrastructure.BasicMiddlewareComponentBuilder;
import de.uka.sdq.pcm.transformations.builder.infrastructure.IMiddlewareInteractingComponentBuilder;
import de.uka.sdq.pcm.transformations.builder.util.PCMAndCompletionModelHolder;

/**
 * Implementation of an InnerConnectorCompletionBuilder which adds dummy components on both sides doing nothing else than delegating the
 * call to the next component in the chain
 * @author Snowball
 *
 */
public class InnerConnectorCompletionBuilder
extends AbstractClientServerConnectorCompletionBuilder {

	public InnerConnectorCompletionBuilder(
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
		return 	new BasicMiddlewareComponentBuilder(
				myModels, 
				this.connectorToReplace.getRequiredRole_CompositeAssemblyConnector().getRequiredInterface__RequiredRole(),
				this.connectorToReplace.getRequiredRole_CompositeAssemblyConnector().getRequiredInterface__RequiredRole(),
				this.middlewareInterface,
				this.myLinkingResource.getFromResourceContainer_LinkingResource().get(0));
	}
	
	/**
	 * By default, a dummy component is created which does nothing besides delegating the call.
	 * Override if more actions are needed
	 * @return
	 */
	@Override
	protected IMiddlewareInteractingComponentBuilder createServerSideBuilder() {
		return new BasicMiddlewareComponentBuilder(
				myModels, 
				this.connectorToReplace.getRequiredRole_CompositeAssemblyConnector().getRequiredInterface__RequiredRole(),
				this.connectorToReplace.getRequiredRole_CompositeAssemblyConnector().getRequiredInterface__RequiredRole(),
				this.middlewareInterface,
				this.myLinkingResource.getToResourceContainer_LinkingResource().get(0));
	}
}

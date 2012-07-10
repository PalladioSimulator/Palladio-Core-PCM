package de.uka.ipd.sdq.pcm.transformations.builder.connectors;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.transformations.builder.IComponentBuilder;
import de.uka.ipd.sdq.pcm.transformations.builder.infrastructure.DelayMiddlewareComponentBuilder;
import de.uka.ipd.sdq.pcm.transformations.builder.infrastructure.IMiddlewareInteractingComponentBuilder;
import de.uka.ipd.sdq.pcm.transformations.builder.util.PCMAndCompletionModelHolder;

/**
 * Implementation of an InnerConnectorCompletionBuilder which adds dummy components on both sides 
 * causing themselfs a CPU demand according to the passed StoEx.
 * @author Snowball
 *
 */
public class DelayInnerConnectorCompletionBuilder
extends AbstractClientServerConnectorCompletionBuilder {

	private String delaySpec;

	public DelayInnerConnectorCompletionBuilder(
			PCMAndCompletionModelHolder models,
			AssemblyConnector connector,
			ResourceContainer fromResourceContainer,
			ResourceContainer toResourceContainer,
			IComponentBuilder innerBuilder,
			String delaySpec) {
		super(models, connector, fromResourceContainer, toResourceContainer, innerBuilder,  "DelayInnerConnectorCompletion");
		if (delaySpec == null)
			throw new IllegalArgumentException("Stoex cannot be null");
		this.delaySpec = delaySpec;
	}

	/**
	 * By default, a dummy component is created which does nothing besides delegating the call.
	 * Override if more actions are needed
	 * @return
	 */
	@Override
	protected IMiddlewareInteractingComponentBuilder createClientSideBuilder() {
		return 	new DelayMiddlewareComponentBuilder(
				myModels, 
				this.connectorToReplace.getRequiredRole_AssemblyConnector().getRequiredInterface__OperationRequiredRole(),
				this.connectorToReplace.getRequiredRole_AssemblyConnector().getRequiredInterface__OperationRequiredRole(),
				this.middlewareInterface,
				this.fromResourceContainer,
				delaySpec);
	}
	
	/**
	 * By default, a dummy component is created which does nothing besides delegating the call.
	 * Override if more actions are needed
	 * @return
	 */
	@Override
	protected IMiddlewareInteractingComponentBuilder createServerSideBuilder() {
		return new DelayMiddlewareComponentBuilder(
				myModels, 
				this.connectorToReplace.getRequiredRole_AssemblyConnector().getRequiredInterface__OperationRequiredRole(),
				this.connectorToReplace.getRequiredRole_AssemblyConnector().getRequiredInterface__OperationRequiredRole(),
				this.middlewareInterface,
				this.toResourceContainer,
				delaySpec);
	}
}

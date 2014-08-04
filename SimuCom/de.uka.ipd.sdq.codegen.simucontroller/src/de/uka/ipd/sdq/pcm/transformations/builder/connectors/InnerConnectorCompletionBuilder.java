package de.uka.ipd.sdq.pcm.transformations.builder.connectors;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.transformations.builder.IComponentBuilder;
import de.uka.ipd.sdq.pcm.transformations.builder.infrastructure.BasicMiddlewareComponentBuilder;
import de.uka.ipd.sdq.pcm.transformations.builder.infrastructure.IMiddlewareInteractingComponentBuilder;
import de.uka.ipd.sdq.pcm.transformations.builder.util.PCMAndCompletionModelHolder;

/**
 * Implementation of an InnerConnectorCompletionBuilder which adds dummy components on both sides
 * doing nothing else than delegating the call to the next component in the chain
 * 
 * @author Snowball
 *
 */
public class InnerConnectorCompletionBuilder extends AbstractClientServerConnectorCompletionBuilder {

    public InnerConnectorCompletionBuilder(PCMAndCompletionModelHolder models, AssemblyConnector connector,
            ResourceContainer fromResourceContainer, ResourceContainer toResourceContainer,
            IComponentBuilder innerBuilder) {
        super(models, connector, fromResourceContainer, toResourceContainer, innerBuilder, "InnerConnectorCompletion");
    }

    /**
     * By default, a dummy component is created which does nothing besides delegating the call.
     * Override if more actions are needed
     * 
     * @return
     */
    @Override
    protected IMiddlewareInteractingComponentBuilder createClientSideBuilder() {
        return new BasicMiddlewareComponentBuilder(myModels, this.connectorToReplace
                .getRequiredRole_AssemblyConnector().getRequiredInterface__OperationRequiredRole(),
                this.connectorToReplace.getRequiredRole_AssemblyConnector()
                        .getRequiredInterface__OperationRequiredRole(), this.middlewareInterface,
                this.fromResourceContainer, "BasicMiddlewareComponent_ClientSide");
    }

    /**
     * By default, a dummy component is created which does nothing besides delegating the call.
     * Override if more actions are needed
     * 
     * @return
     */
    @Override
    protected IMiddlewareInteractingComponentBuilder createServerSideBuilder() {
        return new BasicMiddlewareComponentBuilder(myModels, this.connectorToReplace
                .getRequiredRole_AssemblyConnector().getRequiredInterface__OperationRequiredRole(),
                this.connectorToReplace.getRequiredRole_AssemblyConnector()
                        .getRequiredInterface__OperationRequiredRole(), this.middlewareInterface,
                this.toResourceContainer, "BasicMiddlewareComponent_ServerSide");
    }
}

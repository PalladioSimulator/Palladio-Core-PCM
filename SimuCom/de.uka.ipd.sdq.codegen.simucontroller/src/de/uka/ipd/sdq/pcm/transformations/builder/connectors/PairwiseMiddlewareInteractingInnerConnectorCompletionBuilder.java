package de.uka.ipd.sdq.pcm.transformations.builder.connectors;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.transformations.builder.IComponentBuilder;
import de.uka.ipd.sdq.pcm.transformations.builder.infrastructure.IMiddlewareInteractingComponentBuilder;
import de.uka.ipd.sdq.pcm.transformations.builder.infrastructure.MiddlewareCallingComponentBuilder;
import de.uka.ipd.sdq.pcm.transformations.builder.util.PCMAndCompletionModelHolder;

/**
 * Implementation of an InnerConnectorCompletionBuilder which calls a process service on the client
 * side, forwards the message, calls deprocess on the server side, and does the same in reverse
 * order for the reply
 * 
 * @author Snowball
 *
 */
public class PairwiseMiddlewareInteractingInnerConnectorCompletionBuilder extends
        AbstractClientServerConnectorCompletionBuilder {

    private String processCallSignature;
    private String unprocessCallSignature;

    public PairwiseMiddlewareInteractingInnerConnectorCompletionBuilder(PCMAndCompletionModelHolder models,
            AssemblyConnector connector, ResourceContainer fromResourceContainer,
            ResourceContainer toResourceContainer, IComponentBuilder innerBuilder, String processCallSignature,
            String unprocessCallSignature) {
        super(models, connector, fromResourceContainer, toResourceContainer, innerBuilder,
                "PairwiseMiddlewareInteractingInnerConnectorCompletion");
        this.processCallSignature = processCallSignature;
        this.unprocessCallSignature = unprocessCallSignature;
    }

    /**
     * By default, a dummy component is created which does nothing besides delegating the call.
     * Override if more actions are needed
     * 
     * @return
     */
    @Override
    protected IMiddlewareInteractingComponentBuilder createClientSideBuilder() {
        MiddlewareCallingComponentBuilder builder = new MiddlewareCallingComponentBuilder(myModels,
                this.connectorToReplace.getRequiredRole_AssemblyConnector()
                        .getRequiredInterface__OperationRequiredRole(), this.connectorToReplace
                        .getRequiredRole_AssemblyConnector().getRequiredInterface__OperationRequiredRole(),
                this.middlewareInterface, this.fromResourceContainer, processCallSignature, unprocessCallSignature);

        return builder;
    }

    /**
     * By default, a dummy component is created which does nothing besides delegating the call.
     * Override if more actions are needed
     * 
     * @return
     */
    @Override
    protected IMiddlewareInteractingComponentBuilder createServerSideBuilder() {
        MiddlewareCallingComponentBuilder builder = new MiddlewareCallingComponentBuilder(myModels,
                this.connectorToReplace.getRequiredRole_AssemblyConnector()
                        .getRequiredInterface__OperationRequiredRole(), this.connectorToReplace
                        .getRequiredRole_AssemblyConnector().getRequiredInterface__OperationRequiredRole(),
                this.middlewareInterface, this.toResourceContainer, unprocessCallSignature, processCallSignature);

        return builder;
    }
}

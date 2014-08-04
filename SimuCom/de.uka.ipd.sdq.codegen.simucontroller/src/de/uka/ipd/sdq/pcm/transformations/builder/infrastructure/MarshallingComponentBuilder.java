package de.uka.ipd.sdq.pcm.transformations.builder.infrastructure;

import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.transformations.builder.seff.DelegatorComponentSeffBuilder;
import de.uka.ipd.sdq.pcm.transformations.builder.seff.MarshallerComponentSeffBuilder;
import de.uka.ipd.sdq.pcm.transformations.builder.util.PCMAndCompletionModelHolder;

public class MarshallingComponentBuilder extends BasicMiddlewareComponentBuilder {

    public enum MarshallerSide {
        CLIENT, SERVER
    }

    private MarshallerSide side;

    public MarshallingComponentBuilder(PCMAndCompletionModelHolder models, OperationInterface providedIf,
            OperationInterface requiredIf, OperationInterface middlewareInterface, ResourceContainer container,
            MarshallerSide side) {
        super(models, providedIf, requiredIf, middlewareInterface, container, "MarshallingComponent_" + side);
        this.side = side;
    }

    @Override
    protected DelegatorComponentSeffBuilder getSeffBuilder() {
        MarshallerComponentSeffBuilder builder = new MarshallerComponentSeffBuilder(getOperationProvidedRole(),
                getOperationRequiredRole(), getMiddlewareRole(), side);
        return builder;
    }

}

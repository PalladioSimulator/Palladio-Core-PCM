package de.uka.ipd.sdq.pcm.transformations.builder.seff;

import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SeffFactory;

public class AbstractSeffBuilder {

    public AbstractSeffBuilder() {
        super();
    }

    protected ResourceDemandingSEFF buildSeff(OperationSignature signature) {
        ResourceDemandingSEFF seff = SeffFactory.eINSTANCE.createResourceDemandingSEFF();
        seff.setDescribedService__SEFF(signature);

        return seff;
    }

    protected AbstractAction createControlFlow(AbstractAction a, AbstractAction b) {
        a.setSuccessor_AbstractAction(b);
        return b;
    }

}
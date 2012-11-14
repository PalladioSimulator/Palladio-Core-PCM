package de.uka.ipd.sdq.pcm.dialogs.resource;

import de.uka.ipd.sdq.pcm.dialogs.OpenStoExDialog;
import de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification;
import de.uka.ipd.sdq.stoex.RandomVariable;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;

import org.eclipse.emf.ecore.EObject;

// Manually written open policy to open the StoEx Dialog. It's
// called via a CustomBehaviour in the genmap
public class OpenLatencyDialog extends OpenStoExDialog {

    @Override
    protected RandomVariable getRandomVariable(EObject parent) {
        // Default Implementation. Override as necessary
        if (randomVariableFeature == null && parent instanceof RandomVariable) {
            return (RandomVariable) parent;
        } else if (randomVariableFeature == null && parent instanceof CommunicationLinkResourceSpecification) {
            return ((CommunicationLinkResourceSpecification) parent)
                    .getLatency_CommunicationLinkResourceSpecification();
        } else {
            return (RandomVariable) parent.eGet(randomVariableFeature);
        }
    }

    @Override
    protected TypeEnum getExpectedType(RandomVariable rv) {
        return TypeEnum.DOUBLE;
    }

}

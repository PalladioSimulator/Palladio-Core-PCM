package de.uka.ipd.sdq.pcm.dialogs.resource;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.dialogs.OpenStoExDialog;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.stoex.RandomVariable;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;

// Manually written open policy to open the StoEx Dialog. It's
// called via a CustomBehaviour in the genmap
public class OpenProcessingRateDialog extends OpenStoExDialog {

    @Override
    protected RandomVariable getRandomVariable(EObject parent) {
        // Default Implementation. Override as necessary
        if (randomVariableFeature == null && parent instanceof RandomVariable) {
            return (RandomVariable) parent;
        } else if (randomVariableFeature == null && parent instanceof ProcessingResourceSpecification) {
            return ((ProcessingResourceSpecification) parent).getProcessingRate_ProcessingResourceSpecification();
        } else {
            return (RandomVariable) parent.eGet(randomVariableFeature);
        }

        // ProcessingResourceSpecification resourceSpecification = (ProcessingResourceSpecification)
        // parent;
        // RandomVariable rv =
        // resourceSpecification.getProcessingRate_ProcessingResourceSpecification();
        // return rv;
    }

    @Override
    protected TypeEnum getExpectedType(RandomVariable rv) {
        return TypeEnum.DOUBLE;
    }

}

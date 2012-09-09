package de.uka.ipd.sdq.pcm.dialogs.usage;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.stoex.RandomVariable;

// Manually written open policy to open the StoEx Dialog. It's
// called via a CustomBehaviour in the genmap
public class OpenVariableCharacterisationDialog extends OpenStoExDialog {

    @Override
    protected RandomVariable getRandomVariable(EObject parent) {
        VariableCharacterisation cw = (VariableCharacterisation) parent;
        RandomVariable rv = cw.getSpecification_VariableCharacterisation();
        return rv;
    }
}

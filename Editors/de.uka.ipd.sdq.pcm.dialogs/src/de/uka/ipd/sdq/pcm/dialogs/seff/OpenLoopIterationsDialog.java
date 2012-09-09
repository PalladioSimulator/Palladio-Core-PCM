package de.uka.ipd.sdq.pcm.dialogs.seff;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.dialogs.OpenStoExDialog;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.seff.seff_performance.InfrastructureCall;
import de.uka.ipd.sdq.stoex.RandomVariable;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;

// Manually written open policy to open the StoEx Dialog. It's
// called via a CustomBehaviour in the genmap
public class OpenLoopIterationsDialog extends OpenStoExDialog {

    @Override
    protected RandomVariable getRandomVariable(EObject parent) {
        LoopAction loop = (LoopAction) parent;
        RandomVariable rv = loop.getIterationCount_LoopAction();
        return rv;
    }

    @Override
    protected TypeEnum getExpectedType(RandomVariable rv) {
        return TypeEnum.INT;
    }

}

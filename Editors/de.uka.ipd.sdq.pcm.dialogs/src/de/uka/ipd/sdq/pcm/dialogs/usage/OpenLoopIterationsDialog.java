package de.uka.ipd.sdq.pcm.dialogs.usage;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.usagemodel.Loop;
import de.uka.ipd.sdq.stoex.RandomVariable;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;

// Manually written open policy to open the StoEx Dialog. It's
// called via a CustomBehaviour in the genmap
public class OpenLoopIterationsDialog extends OpenStoExDialog {

    @Override
    protected RandomVariable getRandomVariable(EObject parent) {
        Loop loop = (Loop) parent;
        RandomVariable rv = loop.getLoopIteration_Loop();
        return rv;
    }

    @Override
    protected TypeEnum getExpectedType(RandomVariable rv) {
        return TypeEnum.INT;
    }

}

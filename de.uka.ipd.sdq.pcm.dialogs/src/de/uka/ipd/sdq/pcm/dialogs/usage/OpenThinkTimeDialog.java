package de.uka.ipd.sdq.pcm.dialogs.usage;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.usagemodel.ClosedWorkload;
import de.uka.ipd.sdq.stoex.RandomVariable;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;

// Manually written open policy to open the StoEx Dialog. It's
// called via a CustomBehaviour in the genmap
public class OpenThinkTimeDialog extends OpenStoExDialog {

    @Override
    protected RandomVariable getRandomVariable(EObject parent) {
        ClosedWorkload cw = (ClosedWorkload) parent;
        RandomVariable rv = cw.getThinkTime_ClosedWorkload();
        return rv;
    }

    @Override
    protected TypeEnum getExpectedType(RandomVariable rv) {
        return TypeEnum.DOUBLE;
    }

}

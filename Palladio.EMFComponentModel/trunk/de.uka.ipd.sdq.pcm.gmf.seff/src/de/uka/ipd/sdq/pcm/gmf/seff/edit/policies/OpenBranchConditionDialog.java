package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.seff.GuardedBranchTransition;
import de.uka.ipd.sdq.stoex.RandomVariable;

// Manually written open policy to open the StoEx Dialog. It's
// called via a CustomBehaviour in the genmap
public class OpenBranchConditionDialog extends OpenStoExDialog {

	
	@Override
	protected RandomVariable getRandomVariable(EObject parent) {
		GuardedBranchTransition transition = (GuardedBranchTransition) parent;
		RandomVariable rv = transition.getBranchCondition_BranchTransition();
		return rv;
	}
}

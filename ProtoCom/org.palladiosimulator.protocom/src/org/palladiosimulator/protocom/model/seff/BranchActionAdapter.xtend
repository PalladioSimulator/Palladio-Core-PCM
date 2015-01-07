package org.palladiosimulator.protocom.model.seff

import de.uka.ipd.sdq.pcm.seff.BranchAction
import de.uka.ipd.sdq.pcm.seff.ProbabilisticBranchTransition
import de.uka.ipd.sdq.pcm.seff.GuardedBranchTransition
import java.util.List
import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition

/**
 * @author Christian Klaussner
 */
class BranchActionAdapter extends ActionAdapter<BranchAction> {
	new(BranchAction entity) {
		super(entity)
	}
	
	def List<BranchTransitionAdapter<? extends AbstractBranchTransition>> getBranchTransitions() {
		entity.branches_Branch.map[
			switch it {
				ProbabilisticBranchTransition:
					new ProbabilisticBranchTransitionAdapter(it)
					
				GuardedBranchTransition:
					new GuardedBranchTransitionAdapter(it)
			}
		]
	}
}

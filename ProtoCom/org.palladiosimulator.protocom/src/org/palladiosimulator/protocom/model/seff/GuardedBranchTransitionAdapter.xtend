package org.palladiosimulator.protocom.model.seff

import de.uka.ipd.sdq.pcm.seff.GuardedBranchTransition

/**
 * @author Christian Klaussner
 */
class GuardedBranchTransitionAdapter extends BranchTransitionAdapter<GuardedBranchTransition> {
	new(GuardedBranchTransition entity) {
		super(entity)
	}
	
	def getCondition() {
		entity.branchCondition_GuardedBranchTransition.specification
	}
}

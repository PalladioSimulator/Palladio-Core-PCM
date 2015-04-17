package org.palladiosimulator.protocom.model.seff

import de.uka.ipd.sdq.pcm.seff.ForkAction

/**
 * @author Sebastian Lehrig
 */
class ForkActionAdapter extends ActionAdapter<ForkAction> {
	
	new(ForkAction entity) {
		super(entity)
		entity.asynchronousForkedBehaviours_ForkAction
		entity.synchronisingBehaviours_ForkAction
	}
	
	def getAsynchronousForkedBehaviours() {
		entity.asynchronousForkedBehaviours_ForkAction
	}
	
}

package org.palladiosimulator.protocom.model.seff

import de.uka.ipd.sdq.pcm.seff.InternalAction

/**
 * @author Christian Klaussner
 */
class InternalActionAdapter extends ActionAdapter<InternalAction> {
	new(InternalAction entity) {
		super(entity)
	}
	
	def getResourceDemands() {
		entity.resourceDemand_Action.map[
			new ParametricResourceDemandAdapter(it)
		]
	}
}

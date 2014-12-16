package org.palladiosimulator.protocom.model.usage

import de.uka.ipd.sdq.pcm.usagemodel.Delay

/**
 * Adapter class for PCM Delay user actions.
 * @author Christian Klaussner
 */
class DelayAdapter extends UserActionAdapter<Delay> {
	new(Delay entity) {
		super(entity)
	}
	
	def getDelay() {
		entity.timeSpecification_Delay.specification
	}
}

package org.palladiosimulator.protocom.model.usage

import de.uka.ipd.sdq.pcm.usagemodel.ClosedWorkload

/**
 * Adapter class for PCM ClosedWorkload entities.
 * @author Christian Klaussner
 */
class ClosedWorkloadAdapter extends WorkloadAdapter<ClosedWorkload> {
	new(ClosedWorkload entity) {
		super(entity)
	}
	
	def getThinkTime() {
		entity.thinkTime_ClosedWorkload.specification
	}
}

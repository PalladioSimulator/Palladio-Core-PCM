package org.palladiosimulator.protocom.model.usage

import de.uka.ipd.sdq.pcm.usagemodel.OpenWorkload

/**
 * Adapter class for PCM OpenWorkload entities.
 * @author Christian Klaussner
 */
class OpenWorkloadAdapter extends WorkloadAdapter<OpenWorkload> {
	new(OpenWorkload entity) {
		super(entity)
	}
}

package org.palladiosimulator.protocom.model.usage

import de.uka.ipd.sdq.pcm.usagemodel.Start

/**
 * Adapter class for PCM Start user actions.
 * @author Christian Klaussner
 */
class StartAdapter extends UserActionAdapter<Start> {
	new(Start entity) {
		super(entity)
	}
}

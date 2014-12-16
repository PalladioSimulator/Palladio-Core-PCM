package org.palladiosimulator.protocom.model.usage

import org.palladiosimulator.protocom.model.ModelAdapter
import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction

/**
 * Abstract base class for PCM user actions.
 * @author Christian Klaussner
 */
class UserActionAdapter<E extends AbstractUserAction> extends ModelAdapter<E> {
	new(E entity) {
		super(entity)
	}
}

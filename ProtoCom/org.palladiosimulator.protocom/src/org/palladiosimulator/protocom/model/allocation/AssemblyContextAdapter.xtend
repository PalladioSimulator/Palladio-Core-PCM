package org.palladiosimulator.protocom.model.allocation

import org.palladiosimulator.protocom.model.ModelAdapter
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext

/**
 * Adapter class for PCM AssemblyContext entities.
 * @author Christian Klaussner
 */
class AssemblyContextAdapter extends ModelAdapter<AssemblyContext> {
	new(AssemblyContext entity) {
		super(entity)
	}
	
	/**
	 * Gets the ID.
	 * @return a string containing the ID
	 */
	def getId() {
		entity.id
	}
}

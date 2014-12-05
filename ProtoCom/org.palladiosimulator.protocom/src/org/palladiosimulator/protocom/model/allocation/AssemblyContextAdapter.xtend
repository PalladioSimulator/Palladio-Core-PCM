package org.palladiosimulator.protocom.model.allocation

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext
import de.uka.ipd.sdq.pcm.repository.BasicComponent
import org.palladiosimulator.protocom.model.ModelAdapter
import org.palladiosimulator.protocom.model.repository.BasicComponentAdapter

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
	
	def getEncapsulatedComponent() {
		// TODO: Add support for CompositeComponent
		new BasicComponentAdapter(entity.encapsulatedComponent__AssemblyContext as BasicComponent)
	}
}

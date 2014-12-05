package org.palladiosimulator.protocom.model.system

import org.palladiosimulator.protocom.model.ModelAdapter
import de.uka.ipd.sdq.pcm.system.System
import org.palladiosimulator.protocom.model.allocation.AssemblyContextAdapter

class SystemAdapter extends ModelAdapter<System> {
	new(System entity) {
		super(entity)
	}
	
	def getAssemblyContexts() {
		entity.assemblyContexts__ComposedStructure.map[
			new AssemblyContextAdapter(it)
		]
	}
	
	// Translation methods
	
	def getInterfaceName() {
		"I" + entity.safeName
	}
}

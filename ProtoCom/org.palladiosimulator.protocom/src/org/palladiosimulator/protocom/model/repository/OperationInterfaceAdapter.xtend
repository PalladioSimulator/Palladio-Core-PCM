package org.palladiosimulator.protocom.model.repository

import org.palladiosimulator.protocom.model.ModelAdapter
import de.uka.ipd.sdq.pcm.repository.OperationInterface

class OperationInterfaceAdapter extends ModelAdapter<OperationInterface> {
	new(OperationInterface entity) {
		super(entity)
	}
	
	// Translation methods
	
	def getInterfaceFqn() {
		entity.repository__Interface.basePackageName + "." + entity.safeName
	}
	
}

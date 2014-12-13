package org.palladiosimulator.protocom.model.repository

import de.uka.ipd.sdq.pcm.repository.BasicComponent
import de.uka.ipd.sdq.pcm.repository.InfrastructureProvidedRole
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole
import org.palladiosimulator.protocom.model.ModelAdapter
import org.palladiosimulator.protocom.model.seff.ServiceEffectSpecificationAdapter

/**
 * Adapter class for PCM BasicComponent entities.
 * TODO: Super class -> InterfaceProvidingRequiringEntityAdapter
 * @author Christian Klaussner
 */
class BasicComponentAdapter extends InterfaceProvidingRequiringEntityAdapter<BasicComponent> {
	new(BasicComponent entity) {
		super(entity)
	}
	
	/**
	 * Get the 'Service Effect Specifications'.
	 * @return a list of adapters for the 'Service Effect Specifications'
	 */
	def getServiceEffectSpecifications() {
		entity.serviceEffectSpecifications__BasicComponent.map[
			new ServiceEffectSpecificationAdapter(it)
		]
	}
	
	// Translation methods
	
	def getClassFqn() {
		classPackageFqn + "." + entity.safeName
	}
	
	def getClassPackageFqn() {
		entity.repository__RepositoryComponent.basePackageName + ".impl"
	}
	
	def getInterfaceName() {
		"I" + entity.safeName
	}
	
	def getContextPackageName() {
	}
	
	def getContextPackageFqn() {
		entity.repository__RepositoryComponent.basePackageName + ".impl.contexts"
	}
	
	def getContextClassName() {
		entity.safeName + "Context"
	}
	
	def getContextInterfaceName() {
		"I" + contextClassName
	}
	
	def getContextInterfaceFqn() {
		contextPackageFqn + ".I" + contextClassName
	}
}

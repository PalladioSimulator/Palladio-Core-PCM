package org.palladiosimulator.protocom.tech.rmi.repository

import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole
import org.palladiosimulator.protocom.lang.java.impl.JMethod
import org.palladiosimulator.protocom.lang.java.util.JavaNames
import de.uka.ipd.sdq.pcm.core.entity.InterfaceRequiringEntity
import org.palladiosimulator.protocom.tech.rmi.PojoInterface

/**
 * @author Thomas Zolynski, Sebastian Lehrig
 */
class PojoComposedStructureContextInterface extends PojoInterface<InterfaceRequiringEntity> {
	
	new(InterfaceRequiringEntity pcmEntity) {
		super(pcmEntity)
	}
	
	override packageName() {
		JavaNames::fqnContextPackage(pcmEntity)
	}
	
	override compilationUnitName() {
		JavaNames::contextInterfaceName(pcmEntity)
	}
	
	override methods() {
		val results = newLinkedList
		
		// Role getter
		results += pcmEntity.requiredRoles_InterfaceRequiringEntity.filter[OperationRequiredRole.isInstance(it)].map[
			
			new JMethod()
				.withName("getRole" + JavaNames::javaName(it))  
				.withReturnType(JavaNames::fqn((it as OperationRequiredRole).requiredInterface__OperationRequiredRole))
			
		]
		
		// Role setter
		results += pcmEntity.requiredRoles_InterfaceRequiringEntity.filter[OperationRequiredRole.isInstance(it)].map[
			
			new JMethod()
				.withName("setRole" + JavaNames::javaName(it))  
				.withParameters(JavaNames::fqn((it as OperationRequiredRole).requiredInterface__OperationRequiredRole) + " newValue")
			
		]
		
		results
	}
	
	override filePath() {
		JavaNames::fqnToDirectoryPath(JavaNames::fqnContextInterface(pcmEntity)) + ".java"
	}
		
}
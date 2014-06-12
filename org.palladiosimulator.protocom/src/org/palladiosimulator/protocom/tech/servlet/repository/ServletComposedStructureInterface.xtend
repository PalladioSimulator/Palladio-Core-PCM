package org.palladiosimulator.protocom.tech.servlet.repository

import org.palladiosimulator.protocom.tech.ConceptMapping
import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity
import org.palladiosimulator.protocom.lang.java.util.JavaNames
import org.palladiosimulator.protocom.lang.java.IJInterface
import org.palladiosimulator.protocom.lang.java.impl.JMethod
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole

class ServletComposedStructureInterface extends ConceptMapping<InterfaceProvidingEntity> implements IJInterface {
	new(InterfaceProvidingEntity pcmEntity) {
		super(pcmEntity)
	}
		
	override packageName() {
		JavaNames::implementationPackage(pcmEntity)
	}
	
	override compilationUnitName() {
		JavaNames::interfaceName(pcmEntity)
	}
	
	override interfaces() {
	}
	
	override methods() {
		var result = newLinkedList
		
		// Provided port getters for OperationProvidedRoles.
//		result += pcmEntity.providedRoles_InterfaceProvidingEntity.filter[OperationProvidedRole.isInstance(it)].map[
//			new JMethod()
//				.withName(JavaNames::portGetter(it))
//				.withReturnType(JavaNames::fqn((it as OperationProvidedRole).providedInterface__OperationProvidedRole))
//		]
		
		result
	}
	
	override fields() {
	}
	
	override projectName() {
	}
	
	override filePath() {
		"/src/" + JavaNames::fqnToDirectoryPath(JavaNames::fqnInterface(pcmEntity)) + ".java"
	}
}
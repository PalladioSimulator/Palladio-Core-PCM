package org.palladiosimulator.protocom.tech.servlet.repository

import org.palladiosimulator.protocom.tech.servlet.ServletClass
import de.uka.ipd.sdq.pcm.repository.BasicComponent
import org.palladiosimulator.protocom.lang.java.util.JavaNames
import org.palladiosimulator.protocom.lang.java.impl.JMethod
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole
import org.palladiosimulator.protocom.lang.java.impl.JField

class ServletBasicComponentContextClass extends ServletClass<BasicComponent> {
	new(BasicComponent pcmEntity) {
		super(pcmEntity)
	}
	
	override packageName() {
		JavaNames::fqnContextPackage(pcmEntity)
	}
	
	override compilationUnitName() {
		JavaNames::contextClassName(pcmEntity)	
	}
	
	override fields() {
		val result = newLinkedList
			
		result += pcmEntity.requiredRoles_InterfaceRequiringEntity.filter[OperationRequiredRole.isInstance(it)].map[
			new JField()
				.withType(JavaNames::fqn((it as OperationRequiredRole).requiredInterface__OperationRequiredRole))
				.withName(JavaNames::javaName(it).toFirstLower)
		]
		
		result
	}
	
	override constructors() {
		#[ 
			new JMethod()
				.withParameters('''
					«FOR role : pcmEntity.requiredRoles_InterfaceRequiringEntity.filter[OperationRequiredRole.isInstance(it)].map[it as OperationRequiredRole] SEPARATOR ", "»
						«JavaNames::fqn(role.requiredInterface__OperationRequiredRole)»	«JavaNames::javaName(role).toFirstLower»
					«ENDFOR»
				''')
				.withImplementation('''
					«FOR role : pcmEntity.requiredRoles_InterfaceRequiringEntity.filter[OperationRequiredRole.isInstance(it)].map[it as OperationRequiredRole]»
						this.«JavaNames::javaName(role).toFirstLower» = «JavaNames::javaName(role).toFirstLower»;
					«ENDFOR»
				''')
		]
	}
	
	override methods() {
		var result = newLinkedList
		
		result += pcmEntity.requiredRoles_InterfaceRequiringEntity.filter[OperationRequiredRole.isInstance(it)].map[
			new JMethod()
				.withName("getRole" + JavaNames::javaName(it))
				.withReturnType(JavaNames::fqn((it as OperationRequiredRole).requiredInterface__OperationRequiredRole))
				.withImplementation('''
					if («JavaNames::javaName(it).toFirstLower» == null) {
						throw new RuntimeException("Attempt to retrieve unbound port. Role «it.entityName» <«it.id»> RequiringEntity «it.requiringEntity_RequiredRole.entityName»");
					}
					return «JavaNames::javaName(it).toFirstLower»;
				''')
		]
		
		result
	}
	
	override filePath() {
		"/src/" + JavaNames::fqnToDirectoryPath(JavaNames::fqnContext(pcmEntity)) + ".java"
	}
}

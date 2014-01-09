package com.palladio_simulator.protocom.tech.rmi

import de.uka.ipd.sdq.pcm.repository.BasicComponent
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole
import com.palladio_simulator.protocom.lang.java.impl.JField
import com.palladio_simulator.protocom.lang.java.util.JavaNames
import com.palladio_simulator.protocom.lang.java.impl.JMethod
import com.palladio_simulator.protocom.lang.java.util.JavaConstants

class PojoBasicComponentContextClass extends PojoClass<BasicComponent> {
	
	new(BasicComponent pcmEntity) {
		super(pcmEntity)
	}
	
	override fields() {
		val results = newLinkedList
			
		results += pcmEntity.requiredRoles_InterfaceRequiringEntity.filter[OperationRequiredRole.isInstance(it)].map[
	
			new JField()
				.withType(JavaNames::fqn((it as OperationRequiredRole).requiredInterface__OperationRequiredRole))
				.withName(JavaNames::javaName(it).toFirstLower)
		]
		
		results
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
	
	override packageName() {
		JavaNames::fqnContextPackage(pcmEntity)
	}
	
	override compilationUnitName() {
		JavaNames::contextClassName(pcmEntity)	
	}
	
	override interfaces() {
		#[ JavaNames::contextInterfaceName(pcmEntity), JavaConstants::SERIALIZABLE_INTERFACE ]
	}
	
	override methods() {
		val results = newLinkedList
		
		results += pcmEntity.requiredRoles_InterfaceRequiringEntity.filter[OperationRequiredRole.isInstance(it)].map[
			
			new JMethod()
				.withName("getRole" + JavaNames::javaName(it))  
				.withReturnType(JavaNames::fqn((it as OperationRequiredRole).requiredInterface__OperationRequiredRole))
				.withImplementation(
					'''
					if («JavaNames::javaName(it).toFirstLower» == null) {
						throw new RuntimeException("Attempt to retrieve unbounded port. Check your architecture! Role «it.entityName» <«it.id»> RequiringEntity «it.requiringEntity_RequiredRole.entityName»");
					}
					return «JavaNames::javaName(it).toFirstLower»;
					''')
					
		]
		
		results += pcmEntity.requiredRoles_InterfaceRequiringEntity.filter[OperationRequiredRole.isInstance(it)].map[
			
			new JMethod()
				.withName("setRole" + JavaNames::javaName(it))  
				.withParameters(JavaNames::fqn((it as OperationRequiredRole).requiredInterface__OperationRequiredRole) + " newValue")
				.withImplementation('''this.«JavaNames::javaName(it).toFirstLower» = newValue;''')
					
		]
		
		results
		
	}
	
	override filePath() {
		JavaNames::fqnToDirectoryPath(JavaNames::fqnContext(pcmEntity)) + ".java"
	}
	
	
}
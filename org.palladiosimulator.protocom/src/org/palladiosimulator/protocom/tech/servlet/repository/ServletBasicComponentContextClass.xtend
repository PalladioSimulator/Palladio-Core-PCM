package org.palladiosimulator.protocom.tech.servlet.repository

import org.palladiosimulator.protocom.tech.servlet.ServletClass
import de.uka.ipd.sdq.pcm.repository.BasicComponent
import org.palladiosimulator.protocom.lang.java.util.JavaNames
import org.palladiosimulator.protocom.lang.java.impl.JMethod
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole
import org.palladiosimulator.protocom.lang.java.impl.JField
import org.palladiosimulator.protocom.lang.java.impl.JAnnotation

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
	
	override interfaces() {
		#[JavaNames::contextInterfaceName(pcmEntity)]
	}
	
	override annotations() {
		#[
			new JAnnotation()
				.withName("com.fasterxml.jackson.annotation.JsonAutoDetect")
				.withValues(#["fieldVisibility = com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY"])
		]
	}
	
	override fields() {
		val result = newLinkedList
		
		// Port ID.
		result += pcmEntity.requiredRoles_InterfaceRequiringEntity.filter[OperationRequiredRole.isInstance(it)].map[
			new JField()
				.withType("String")
				.withName(JavaNames::javaName(it).toFirstLower)
		]
		
		// Port class.
		result += pcmEntity.requiredRoles_InterfaceRequiringEntity.filter[OperationRequiredRole.isInstance(it)].map[
			new JField()
				.withType(JavaNames::fqn((it as OperationRequiredRole).requiredInterface__OperationRequiredRole))
				.withName("portFor_" + JavaNames::javaName(it).toFirstLower)
		]
		
		result
	}
	
	override constructors() {
		var result = newLinkedList
		
		result +=
			new JMethod()
				.withImplementation('''
				''')
		
		if (pcmEntity.requiredRoles_InterfaceRequiringEntity.filter[OperationRequiredRole.isInstance(it)].length > 0) {
			result +=
				new JMethod()
					.withParameters('''
						«FOR role : pcmEntity.requiredRoles_InterfaceRequiringEntity.filter[OperationRequiredRole.isInstance(it)].map[it as OperationRequiredRole] SEPARATOR ", "»
							String «JavaNames::javaName(role).toFirstLower»
						«ENDFOR»
					''')
					.withImplementation('''
						«FOR role : pcmEntity.requiredRoles_InterfaceRequiringEntity.filter[OperationRequiredRole.isInstance(it)].map[it as OperationRequiredRole]»
							this.«JavaNames::javaName(role).toFirstLower» = «JavaNames::javaName(role).toFirstLower»;
						«ENDFOR»
					''')
		}
		
		result
	}
	
	override methods() {
		var result = newLinkedList
		
		result += pcmEntity.requiredRoles_InterfaceRequiringEntity.filter[OperationRequiredRole.isInstance(it)].map[
			new JMethod()
				.withName("get" + JavaNames::javaName(it))
				.withReturnType("String")
				.withImplementation('''
					return «JavaNames::javaName(it).toFirstLower»;
				''')
		]
		
		result += pcmEntity.requiredRoles_InterfaceRequiringEntity.filter[OperationRequiredRole.isInstance(it)].map[
			new JMethod()
			  	.withName("set" + JavaNames::javaName(it))
			  	.withParameters("String port")
			  	.withImplementation('''
			  		«JavaNames::javaName(it).toFirstLower» = port;
			  	''')
		]
		
		result += pcmEntity.requiredRoles_InterfaceRequiringEntity.filter[OperationRequiredRole.isInstance(it)].map[
			new JMethod()
				.withName("getPortFor" + JavaNames::javaName(it))
				.withReturnType(JavaNames::fqn((it as OperationRequiredRole).requiredInterface__OperationRequiredRole))
				.withAnnotations(#[
					new JAnnotation()
						.withName("com.fasterxml.jackson.annotation.JsonIgnore") 
				])
				.withImplementation('''
					try {
						portFor_«JavaNames::javaName(it).toFirstLower» = («JavaNames::fqn((it as OperationRequiredRole).requiredInterface__OperationRequiredRole)») «frameworkBase».registry.Registry.lookup(«JavaNames::javaName(it).toFirstLower»);
					} catch («frameworkBase».registry.RegistryException e) {
						e.printStackTrace();
					}
					
					return portFor_«JavaNames::javaName(it).toFirstLower»;
				''')
		]
		
		result
	}
	
	override filePath() {
		"/src/" + JavaNames::fqnToDirectoryPath(JavaNames::fqnContext(pcmEntity)) + ".java"
	}
}

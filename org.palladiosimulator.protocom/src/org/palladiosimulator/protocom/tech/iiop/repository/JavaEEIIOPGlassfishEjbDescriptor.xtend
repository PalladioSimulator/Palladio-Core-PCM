package org.palladiosimulator.protocom.tech.iiop.repository

import de.uka.ipd.sdq.pcm.repository.BasicComponent
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole
import org.palladiosimulator.protocom.lang.java.util.JavaNames
import org.palladiosimulator.protocom.tech.iiop.JavaEEIIOPDescriptor

class JavaEEIIOPGlassfishEjbDescriptor extends JavaEEIIOPDescriptor<BasicComponent>  {
	
	new(BasicComponent pcmEntity) {
		super(pcmEntity)
	}
	
	override ejbName() {
		JavaNames::javaName(pcmEntity)
	}
	
	override ejbRefName() {
		requiredInterfaces
	}
	
	override jndiName() {
		"Package of the required Component"
	}
	
	override filePath() {
		JavaNames::fqnJavaEEDescriptorPath(pcmEntity)+"glassfish-ejb-jar.xml"
	}
	
	override projectName(){
		JavaNames::fqnJavaEEDescriptorProjectName(pcmEntity)
	}
	
	def requiredInterfaces() {
	 	val results = newLinkedList

		for(required : pcmEntity.requiredRoles_InterfaceRequiringEntity.filter[OperationRequiredRole.isInstance(it)].map[it as OperationRequiredRole]){
			results+= #[
			JavaNames::javaName(required.requiredInterface__OperationRequiredRole)
			]
		}
		results
	}
}
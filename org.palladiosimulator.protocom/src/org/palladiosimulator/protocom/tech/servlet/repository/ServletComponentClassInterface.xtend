package org.palladiosimulator.protocom.tech.servlet.repository

import de.uka.ipd.sdq.pcm.repository.BasicComponent
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole
import org.palladiosimulator.protocom.lang.java.impl.JMethod
import org.palladiosimulator.protocom.lang.java.util.JavaNames
import org.palladiosimulator.protocom.tech.servlet.ServletInterface

class ServletComponentClassInterface extends ServletInterface<BasicComponent> {
	new(BasicComponent pcmEntity) {
		super(pcmEntity)
	}
	
	override compilationUnitName() {
		JavaNames::interfaceName(pcmEntity)
	}
	
	override interfaces() {
		// #['''«frameworkBase».common.IComponent''']
	}
	
		override methods() {
		val results = newLinkedList
		
		// Context & ComponentFrame
		results += #[
			new JMethod()
				.withName("setContext")
				.withParameters("Object myContext")
		]
			
		// From operation interfaces
		results += pcmEntity.serviceEffectSpecifications__BasicComponent.map[
			new JMethod()
				.withName(JavaNames::serviceName(it.describedService__SEFF))
				.withReturnType('''«frameworkBase».stubs.SimulatedStackframe<Object>''')
				.withParameters('''«frameworkBase».stubs.StackContext ctx''')
		]
				
		// TODO: Never called!?
//			
//			new JMethod()
//				.withName("setComponentFrame")
//				.withParameters('''«frameworkBase».stubs.SimulatedStackframe<Object> stackframe''')
//			]
//		
//		// Provided ports getter for OperationProvidedRoles
//		results += pcmEntity.providedRoles_InterfaceProvidingEntity.filter[OperationProvidedRole.isInstance(it)].map[it as OperationProvidedRole].map[
//			new JMethod()
//				.withName(JavaNames::portGetter(it))
//				.withReturnType(JavaNames::fqn(it.providedInterface__OperationProvidedRole))
		
		results
	}
	
	override filePath() {
		"/src/" + JavaNames::fqnToDirectoryPath(JavaNames::fqnInterface(pcmEntity)) + ".java"
	}
}

package org.palladiosimulator.protocom.tech.rmi.system

import org.palladiosimulator.protocom.tech.rmi.PojoClass
import org.palladiosimulator.protocom.lang.java.IJClass
import de.uka.ipd.sdq.pcm.system.System
import org.palladiosimulator.protocom.lang.java.impl.JMethod
import org.palladiosimulator.protocom.lang.java.impl.JField
import org.palladiosimulator.protocom.lang.java.util.JavaNames
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole
import org.palladiosimulator.protocom.lang.java.util.PcmCommons

class PojoWebUsageScenario extends PojoClass<System> implements IJClass {
	new(System pcmEntity) {
		super(pcmEntity)
	}
	
	override packageName() {
		"ProtoComBootstrap"
	}
	
	override compilationUnitName() {
		"WebUsageScenario"
	}
	
	override superClass() {
		'''org.palladiosimulator.protocom.framework.NanoHTTPD'''
	}
	
	override fields() {
		var result = newLinkedList
		
		result += pcmEntity.providedRoles_InterfaceProvidingEntity.filter[OperationProvidedRole.isInstance(it)].map[
				new JField()
					.withName('''port_«JavaNames::portClassName(it)»''')
		]
		
		return result
	}
	
	override constructors() {
		#[
			new JMethod()
				.withImplementation('''
					super(8081);
				''')
		]
	}
	
	override methods() {
		var result = newLinkedList
		
		var x = pcmEntity.providedRoles_InterfaceProvidingEntity.filter[OperationProvidedRole.isInstance(it)].map[
			var role = it as OperationProvidedRole
			println("X: " + role.providedInterface__OperationProvidedRole.signatures__OperationInterface.length);
			
			role.providedInterface__OperationProvidedRole.signatures__OperationInterface.map[
				new JMethod()
					.withName(JavaNames::javaSignature(it))
					.withReturnType(PcmCommons::stackframeType)
					.withParameters(PcmCommons::stackContextParameterList)
					.withImplementation('''
					''')
			]
		]
		
		result.addAll(x.get(0))
		
		result += 
			new JMethod()
				.withVisibilityModifier("public")
				.withReturnType("Response")
				.withName("serve")
				.withImplementation('''
					return new org.palladiosimulator.protocom.framework.NanoHTTPD.Response("text/plain");
				''')
		
		return result
	}
	
	override filePath() {
		"/src/ProtoComBootstrap/WebUsageScenario.java"
	}
}

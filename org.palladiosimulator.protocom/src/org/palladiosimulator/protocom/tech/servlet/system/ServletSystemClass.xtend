package org.palladiosimulator.protocom.tech.servlet.system

import de.uka.ipd.sdq.pcm.core.entity.ComposedProvidingRequiringEntity
import org.palladiosimulator.protocom.tech.servlet.ServletClass
import org.palladiosimulator.protocom.lang.java.IJClass
import org.palladiosimulator.protocom.lang.java.impl.JMethod
import org.palladiosimulator.protocom.lang.java.util.JavaNames
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole
import org.palladiosimulator.protocom.lang.java.impl.JField
import org.palladiosimulator.protocom.lang.java.util.PcmCalls
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole
import org.palladiosimulator.protocom.lang.java.util.PcmCommons

class ServletSystemClass<E extends ComposedProvidingRequiringEntity> extends ServletClass<E> implements IJClass {
	new(E pcmEntity) {
		super(pcmEntity)
	}
	
	override fields() {
		var result = newLinkedList
		
		result += pcmEntity.assemblyContexts__ComposedStructure.map[
			new JField()
				.withName(JavaNames::javaName(it))
				.withType(JavaNames::fqn(it.encapsulatedComponent__AssemblyContext))
		]
		
		result
	}
	
	override constructors() {
		#[
			new JMethod()
				.withParameters("String assemblyContextID")
				.withImplementation(
					'''
					//this.assemblyContextID = assemblyContextID;
					
					initInnerComponents();
					
					«FOR role : pcmEntity.providedRoles_InterfaceProvidingEntity.filter[OperationProvidedRole.isInstance(it)].map[it as OperationProvidedRole]»
						«JavaNames::portMemberVar(role)» = new «JavaNames::fqnPort(role)»((«JavaNames::fqn(role.providedInterface__OperationProvidedRole)») «JavaNames::javaName(PcmCommons::getProvidedDelegationConnector(pcmEntity, role).assemblyContext_ProvidedDelegationConnector)», this, assemblyContextID);
					«ENDFOR»
					''' 
				)
		]
	}
	
	override methods() {
		var result = newLinkedList
		
		// Assembly init methods.
		result += pcmEntity.assemblyContexts__ComposedStructure.map[
			new JMethod()
				.withName("init" + JavaNames::javaName(it))
				.withVisibilityModifier("private")
				.withImplementation('''
					«JavaNames::fqnContext(it.encapsulatedComponent__AssemblyContext)» context = new «JavaNames::fqnContext(it.encapsulatedComponent__AssemblyContext)»(
						«FOR requiredRole : it.encapsulatedComponent__AssemblyContext.requiredRoles_InterfaceRequiringEntity.filter[OperationRequiredRole.isInstance(it)].map[it as OperationRequiredRole] SEPARATOR ", \n"»
							«PcmCalls::portQuery(requiredRole, pcmEntity, it)»«ENDFOR»
					);
					
					// «frameworkBase».stubs.SimulatedStackframe<Object> componentStackFrame = new «frameworkBase».stubs.SimulatedStackframe<Object>();
					// my«JavaNames::javaName(it)».setComponentFrame(componentStackFrame);
					«JavaNames::javaName(it)».setContext(context);
				''')
		]
		
		// System init method.
		result += 
			new JMethod()
				.withName("initInnerComponents")
				.withVisibilityModifier("private")
				.withImplementation('''
					try {
						«FOR assemblyContext : pcmEntity.assemblyContexts__ComposedStructure»
							«IF assemblyContext.encapsulatedComponent__AssemblyContext.providedRoles_InterfaceProvidingEntity.filter[OperationProvidedRole.isInstance(it)].size > 0»
								«JavaNames::javaName(assemblyContext)» = («JavaNames::fqn(assemblyContext.encapsulatedComponent__AssemblyContext)») «frameworkBase».registry.Registry.lookup("«JavaNames::portClassName(assemblyContext.encapsulatedComponent__AssemblyContext.providedRoles_InterfaceProvidingEntity.filter[OperationProvidedRole.isInstance(it)].get(0) as OperationProvidedRole)»_«assemblyContext.id»");
							«ENDIF»
						«ENDFOR»
						
						«FOR assemblyContext : pcmEntity.assemblyContexts__ComposedStructure»
							init«JavaNames::javaName(assemblyContext)»();
						«ENDFOR»
					} catch («frameworkBase».registry.RegistryException e) {
						e.printStackTrace();
					}
				''')
				
			result
	}
}
package org.palladiosimulator.protocom.tech.servlet.system

import de.uka.ipd.sdq.pcm.core.entity.ComposedProvidingRequiringEntity
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole
import org.palladiosimulator.protocom.lang.java.IJClass
import org.palladiosimulator.protocom.lang.java.impl.JField
import org.palladiosimulator.protocom.lang.java.impl.JMethod
import org.palladiosimulator.protocom.lang.java.util.JavaNames
import org.palladiosimulator.protocom.lang.java.util.PcmCalls
import org.palladiosimulator.protocom.tech.servlet.ServletClass
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext
import org.palladiosimulator.protocom.lang.java.impl.JAnnotation
import org.palladiosimulator.protocom.lang.java.util.PcmCommons
import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector
import org.palladiosimulator.protocom.model.system.SystemAdapter

class ServletSystemClass<E extends ComposedProvidingRequiringEntity> extends ServletClass<E> implements IJClass {
	private val SystemAdapter entity
	
	new(SystemAdapter entity, E pcmEntity) {
		super(pcmEntity)
		this.entity = entity
	}
	
	override interfaces() {
		#[entity.interfaceName]
	}
	
	override fields() {
		var result = newLinkedList
		
		// Port classes.
		result += pcmEntity.assemblyContexts__ComposedStructure.map[
			new JField()
				.withName("my" + JavaNames::javaName(it))
				.withType('''«frameworkBase».common.IPort<«JavaNames::fqn(it.encapsulatedComponent__AssemblyContext)»>''')
		]
		
		// Port IDs.
		for (assemblyContext : entity.assemblyContexts) {
			result += new JField()
				.withName(assemblyContext.safeName + "ID")
				.withType("String")
				.withInitialization('''"«JavaNames::portClassName(assemblyContext.encapsulatedComponent.entity.providedRoles_InterfaceProvidingEntity.filter[OperationProvidedRole.isInstance(it)].get(0) as OperationProvidedRole)»_«assemblyContext.id»"''')
		}
		
		result
	}
	
	override constructors() {
		#[
			new JMethod()
				.withParameters("String location, String id")
				.withThrows('''«frameworkBase».registry.RegistryException''')
				.withImplementation(
					'''
					«frameworkBase».common.LocalComponentRegistry.getInstance().addComponent(id, this);
					
					initInnerComponents();
					
					«FOR role : pcmEntity.providedRoles_InterfaceProvidingEntity.filter[OperationProvidedRole.isInstance(it)].map[it as OperationProvidedRole]»
						startPort(location, "«JavaNames::portClassName(role)»", id, «JavaNames::javaName(PcmCommons::getProvidedDelegationConnector(pcmEntity, role).assemblyContext_ProvidedDelegationConnector)»ID);
					«ENDFOR»
					'''
				)
		]
	}
	
	override methods() {
		var result = newLinkedList
		
		// Port starting helper method.
		result +=
			new JMethod()
				.withVisibilityModifier("private")
				.withName("startPort")
				.withParameters("String location, String portName, String id, String innerId")
				.withImplementation('''
					java.util.ArrayList<«frameworkBase».http.Parameter> params = new java.util.ArrayList<«frameworkBase».http.Parameter>(4);
					params.add(new «frameworkBase».http.Parameter("action", "start"));
					params.add(new «frameworkBase».http.Parameter("location", location));
					params.add(new «frameworkBase».http.Parameter("assemblyContext", id));
					params.add(new «frameworkBase».http.Parameter("componentId", innerId));
					
					«frameworkBase».http.Request.get(location, "/" + portName, params);
				''')
		
		// Assembly init methods.
		//result += pcmEntity.assemblyContexts__ComposedStructure.map[
		result += entity.assemblyContexts.map[
			val x = it.entity
			new JMethod()
				.withName("init" + it.safeName)
				.withVisibilityModifier("private")
				.withImplementation('''
					«JavaNames::fqnContext(x.encapsulatedComponent__AssemblyContext)» context = new «JavaNames::fqnContext(x.encapsulatedComponent__AssemblyContext)»(
						«FOR requiredRole : x.encapsulatedComponent__AssemblyContext.requiredRoles_InterfaceRequiringEntity.filter[OperationRequiredRole.isInstance(x)].map[it as OperationRequiredRole] SEPARATOR ", \n"»
							«JavaNames::javaName((PcmCalls::getConnector(pcmEntity, x, requiredRole) as AssemblyConnector).providingAssemblyContext_AssemblyConnector)»ID
						«ENDFOR»
					);
					
					my«JavaNames::javaName(x)».setContext(context);
				''')
		]
		
		// System init method.
		result += 
			new JMethod()
				.withName("initInnerComponents")
				.withVisibilityModifier("private")
				.withThrows('''«frameworkBase».registry.RegistryException''')
				.withAnnotations(#[
					new JAnnotation()
						.withName("SuppressWarnings")
						.withValues(#['''"unchecked"'''])
				])
				.withImplementation('''
					try {
						«FOR assemblyContext : pcmEntity.assemblyContexts__ComposedStructure»
							«IF assemblyContext.encapsulatedComponent__AssemblyContext.providedRoles_InterfaceProvidingEntity.filter[OperationProvidedRole.isInstance(it)].size > 0»
								my«JavaNames::javaName(assemblyContext)» = («frameworkBase».common.IPort<«JavaNames::fqn(assemblyContext.encapsulatedComponent__AssemblyContext)»>) «frameworkBase».registry.Registry.getInstance().lookup("«JavaNames::portClassName(assemblyContext.encapsulatedComponent__AssemblyContext.providedRoles_InterfaceProvidingEntity.filter[OperationProvidedRole.isInstance(it)].get(0) as OperationProvidedRole)»_«assemblyContext.id»");
							«ENDIF»
						«ENDFOR»
						
						«FOR assemblyContext : pcmEntity.assemblyContexts__ComposedStructure»
							init«JavaNames::javaName(assemblyContext)»();
						«ENDFOR»
					} catch («frameworkBase».registry.RegistryException e) {
						throw e;
					}
				''')
				
			result
	}
}

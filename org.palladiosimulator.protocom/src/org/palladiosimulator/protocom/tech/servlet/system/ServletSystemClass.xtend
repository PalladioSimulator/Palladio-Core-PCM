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

class ServletSystemClass<E extends ComposedProvidingRequiringEntity> extends ServletClass<E> implements IJClass {
	new(E pcmEntity) {
		super(pcmEntity)
	}
	
	
	override interfaces() {
		#[JavaNames::interfaceName(pcmEntity)]
	}
	
	override fields() {
		var result = newLinkedList
		
		// Port classes.
		result += pcmEntity.assemblyContexts__ComposedStructure.map[
			new JField()
				.withName(JavaNames::javaName(it))
				.withType('''«frameworkBase».common.IPort<«JavaNames::fqn(it.encapsulatedComponent__AssemblyContext)»>''')
		]
		
		// Port IDs.
		/*result += pcmEntity.assemblyContexts__ComposedStructure.map[
			new JField()
				.withName(JavaNames::javaName(it))
				.withType("String")
		]*/
		
		for (AssemblyContext assemblyContext : pcmEntity.assemblyContexts__ComposedStructure) {
			result += new JField()
				.withName(JavaNames::javaName(assemblyContext) + "ID")
				.withType("String")
				.withInitialization('''"«JavaNames::portClassName(assemblyContext.encapsulatedComponent__AssemblyContext.providedRoles_InterfaceProvidingEntity.filter[OperationProvidedRole.isInstance(it)].get(0) as OperationProvidedRole)»_«assemblyContext.id»"''')
		}
		
		result
	}
	
	override constructors() {
		#[
			new JMethod()
				.withParameters("String location, String id")
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
		result += pcmEntity.assemblyContexts__ComposedStructure.map[
			new JMethod()
				.withName("init" + JavaNames::javaName(it))
				.withVisibilityModifier("private")
				.withImplementation('''
					«JavaNames::fqnContext(it.encapsulatedComponent__AssemblyContext)» context = new «JavaNames::fqnContext(it.encapsulatedComponent__AssemblyContext)»(
						«FOR requiredRole : it.encapsulatedComponent__AssemblyContext.requiredRoles_InterfaceRequiringEntity.filter[OperationRequiredRole.isInstance(it)].map[it as OperationRequiredRole] SEPARATOR ", \n"»
							«JavaNames::javaName((PcmCalls::getConnector(pcmEntity, it, requiredRole) as AssemblyConnector).providingAssemblyContext_AssemblyConnector)»ID
						«ENDFOR»
					);
					
					// «frameworkBase».stubs.SimulatedStackframe<Object> componentStackFrame = new «frameworkBase».stubs.SimulatedStackframe<Object>();
					// my«JavaNames::javaName(it)».setComponentFrame(componentStackFrame);
					«JavaNames::javaName(it)».setContext(context);
				''')
				
				// «JavaNames::javaName(it) + "ID"»
				// «PcmCalls::portQuery(requiredRole, pcmEntity, it)»
		]
		
		// System init method.
		result += 
			new JMethod()
				.withName("initInnerComponents")
				.withVisibilityModifier("private")
				.withAnnotations(#[
					new JAnnotation()
						.withName("SuppressWarnings")
						.withValues(#['''"unchecked"'''])
				])
				.withImplementation('''
					try {
						«FOR assemblyContext : pcmEntity.assemblyContexts__ComposedStructure»
							«IF assemblyContext.encapsulatedComponent__AssemblyContext.providedRoles_InterfaceProvidingEntity.filter[OperationProvidedRole.isInstance(it)].size > 0»
								«JavaNames::javaName(assemblyContext)» = («frameworkBase».common.IPort<«JavaNames::fqn(assemblyContext.encapsulatedComponent__AssemblyContext)»>) «frameworkBase».registry.Registry.lookup("«JavaNames::portClassName(assemblyContext.encapsulatedComponent__AssemblyContext.providedRoles_InterfaceProvidingEntity.filter[OperationProvidedRole.isInstance(it)].get(0) as OperationProvidedRole)»_«assemblyContext.id»");
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
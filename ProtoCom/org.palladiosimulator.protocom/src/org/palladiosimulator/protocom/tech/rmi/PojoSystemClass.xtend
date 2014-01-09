package org.palladiosimulator.protocom.tech.rmi

import de.uka.ipd.sdq.pcm.system.System
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole
import org.palladiosimulator.protocom.lang.java.util.JavaNames
import org.palladiosimulator.protocom.lang.java.impl.JMethod
import org.palladiosimulator.protocom.lang.java.util.PcmCommons
import org.palladiosimulator.protocom.lang.java.impl.JField
import org.palladiosimulator.protocom.lang.java.util.JavaConstants
import de.uka.ipd.sdq.pcm.repository.InfrastructureProvidedRole

class PojoSystemClass extends PojoComposedStructureClass<System> {
	
	new(System pcmEntity) {
		super(pcmEntity)
	}
	
	override interfaces() {
		#[ JavaNames::interfaceName(pcmEntity), JavaConstants::SERIALIZABLE_INTERFACE ]
	}
	
	override constructors() {
		#[
			new JMethod()
				.withParameters("String assemblyContextID")
				.withImplementation(
					'''
					this.assemblyContextID = assemblyContextID;
					
					initInnerComponents();
										
					«FOR role : pcmEntity.providedRoles_InterfaceProvidingEntity.filter[OperationProvidedRole.isInstance(it)].map[it as OperationProvidedRole] BEFORE "try {" AFTER "} catch (java.rmi.RemoteException e) {  }"»
						«JavaNames::portMemberVar(role)» = new «JavaNames::fqnPort(role)»(
						(«JavaNames::fqn(role.providedInterface__OperationProvidedRole)») my«JavaNames::javaName(PcmCommons::getProvidedDelegationConnector(pcmEntity, role).assemblyContext_ProvidedDelegationConnector)»,
						«««() my«JavaNames::javaName(PcmCommons::getProvidedDelegationConnector(pcmEntity, role).assemblyContext_ProvidedDelegationConnector)», 
						«««.getComponent().«JavaNames::portGetter(PcmCommons::getProvidedDelegationConnector(pcmEntity, role).innerProvidedRole_ProvidedDelegationConnector)»(),
					
						this, assemblyContextID);
					«ENDFOR»
					''' 
				)
		]
	}
	

	override fields() {
		val results = newLinkedList
		results += super.fields
		
		// Assembly
		results +=  pcmEntity.assemblyContexts__ComposedStructure.map[  //  PcmCommons::getProvidedDelegationConnector(pcmEntity).map[
			new JField()
				.withName("my" + JavaNames::javaName(it))
				.withType("org.palladiosimulator.protocom.framework.port.IPort<" + JavaNames::fqn(it.encapsulatedComponent__AssemblyContext) + ">")
		]
		
//		results += PcmCommons::getRequiredDelegationConnector(pcmEntity).map[
//			new JField()
//				.withName("my" + JavaNames::javaName((it as RequiredDelegationConnector).assemblyContext_RequiredDelegationConnector))
//				.withType("org.palladiosimulator.protocom.framework.port.IPort<" + JavaNames::fqn((it as RequiredDelegationConnector).assemblyContext_RequiredDelegationConnector.encapsulatedComponent__AssemblyContext) + ">")
//		]

		results
	}
	
	override methods() {
		val results = newLinkedList
		results += super.methods
		
		// Init method
		results += #[
			new JMethod()
				.withName("initInnerComponents")
				.withVisibilityModifier(JavaConstants::VISIBILITY_PRIVATE)
				.withImplementation('''
					try {
«««						NOTE! This might go horribly wrong when a component provides InfrastructureProvided *AND* OperationProvidedRoles at the same time!
						«FOR assemblyContext : pcmEntity.assemblyContexts__ComposedStructure»
							«IF assemblyContext.encapsulatedComponent__AssemblyContext.providedRoles_InterfaceProvidingEntity.filter[OperationProvidedRole.isInstance(it)].size > 0»
								my«JavaNames::javaName(assemblyContext)» = (org.palladiosimulator.protocom.framework.port.IPort<«JavaNames::fqn(assemblyContext.encapsulatedComponent__AssemblyContext)»>) org.palladiosimulator.protocom.framework.registry.RmiRegistry.lookup("«JavaNames::portClassName(assemblyContext.encapsulatedComponent__AssemblyContext.providedRoles_InterfaceProvidingEntity.filter[OperationProvidedRole.isInstance(it)].get(0) as OperationProvidedRole)»_«assemblyContext.id»");
							«ENDIF»
						«ENDFOR»
						
						«FOR assemblyContext : pcmEntity.assemblyContexts__ComposedStructure»
							«IF assemblyContext.encapsulatedComponent__AssemblyContext.providedRoles_InterfaceProvidingEntity.filter[InfrastructureProvidedRole.isInstance(it)].size > 0»
								my«JavaNames::javaName(assemblyContext)» = (org.palladiosimulator.protocom.framework.port.IPort<«JavaNames::fqn(assemblyContext.encapsulatedComponent__AssemblyContext)»>) org.palladiosimulator.protocom.framework.registry.RmiRegistry.lookup("«JavaNames::portClassName(assemblyContext.encapsulatedComponent__AssemblyContext.providedRoles_InterfaceProvidingEntity.filter[InfrastructureProvidedRole.isInstance(it)].get(0) as InfrastructureProvidedRole)»_«assemblyContext.id»");
							«ENDIF»
						«ENDFOR»
						
						«FOR assemblyContext : pcmEntity.assemblyContexts__ComposedStructure»
							init«JavaNames::javaName(assemblyContext)»();
						«ENDFOR»
						
					} catch (java.rmi.RemoteException e) {
						e.printStackTrace();
					}
				''')
		]
		
		// Main method
		results += #[
			new JMethod()
				.withName("main")
				.withParameters("String... args")
				.withStaticModifier		
				.withImplementation('''
					String ip = org.palladiosimulator.protocom.framework.registry.RmiRegistry.getIpFromArguments(args);
					int port = org.palladiosimulator.protocom.framework.registry.RmiRegistry.getPortFromArguments(args);
					
					String assemblyContext = org.palladiosimulator.protocom.framework.AbstractMain.getAssemblyContextFromArguments(args);
					
					org.palladiosimulator.protocom.framework.registry.RmiRegistry.setRemoteAddress(ip);
					org.palladiosimulator.protocom.framework.registry.RmiRegistry.setRegistryPort(port);
					
					new «JavaNames::fqn(pcmEntity)»(assemblyContext);
				''')
			]
		
		results	
	}
	
}
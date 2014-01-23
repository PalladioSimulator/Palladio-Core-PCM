package org.palladiosimulator.protocom.tech.iiop.repository

import de.uka.ipd.sdq.pcm.repository.BasicComponent
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour
import org.palladiosimulator.protocom.lang.java.impl.JField
import org.palladiosimulator.protocom.lang.java.impl.JMethod
import org.palladiosimulator.protocom.lang.java.util.JavaNames
import org.palladiosimulator.protocom.lang.java.util.PcmCommons
import org.palladiosimulator.protocom.tech.iiop.JavaEEIIOPClass
import org.palladiosimulator.protocom.tech.iiop.util.PcmIIOPProtoAction

class JavaEEIIOPBasicComponentClass extends JavaEEIIOPClass<BasicComponent>{
	
	new(BasicComponent pcmEntity) {
		super(pcmEntity)
	}
	
	override interfaces() {
		#[ JavaNames::interfaceName(pcmEntity) ]
	}
	
	override constructors() {
		#[	new JMethod(),
			new JMethod()
				.withParameters("String assemblyContextID")
				.withImplementation(
					'''
					this.assemblyContextID = assemblyContextID;
					
					«FOR resource : pcmEntity.passiveResource_BasicComponent»
					passive_resource_«JavaNames::javaVariableName(resource.entityName)» = new java.util.concurrent.Semaphore(de.uka.ipd.sdq.simucomframework.variables.StackContext.evaluateStatic("«JavaNames::specificationString(resource.capacity_PassiveResource.specification)»", Integer.class), true);
					«ENDFOR»
					'''
				)
		]
	}
	
	override fields() {
		val results = newLinkedList

		// ComponentFrame
		results += #[
			new JField()
				.withName("myComponentStackFrame")
				.withType(PcmCommons::stackframeType),
				
			new JField()
				.withName("myDefaultComponentStackFrame")
				.withType(PcmCommons::stackframeType)
		]
		
		// Assembly context
		results += #[
			new JField()
				.withName("assemblyContextID")
				.withType("String")
		]
		
		// Passive resources
		results += pcmEntity.passiveResource_BasicComponent.map[
			new JField()
				.withName("passive_resource_" + JavaNames::javaVariableName(it.entityName))
				.withType("java.util.concurrent.Semaphore")
		]

		results
	}
	
	override methods() {
		val results = newLinkedList
		
		// ComponentFrame
		results += #[				
			new JMethod()
				.withName("setComponentFrame")
				.withParameters(PcmCommons::stackframeParameterList)
				.withImplementation("this.myComponentStackFrame = myComponentStackFrame; this.myDefaultComponentStackFrame = new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>();")
		]

		// SEFFs
		results += pcmEntity.serviceEffectSpecifications__BasicComponent.map[
			new JMethod()
				.withName(JavaNames::serviceName(it.describedService__SEFF))
				.withReturnType(PcmCommons::stackframeType)
				.withParameters(PcmCommons::stackContextParameterList)
				.withImplementation('''
					«new PcmIIOPProtoAction().actions((it as ResourceDemandingBehaviour).steps_Behaviour.get(0))»
					return null;
					''')
		]
				
		results	
	}
	
		override jeeClassDependencyInjection(){
		val results = newLinkedList

		for(required : pcmEntity.requiredRoles_InterfaceRequiringEntity.filter[OperationRequiredRole.isInstance(it)].map[it as OperationRequiredRole]){
			results+= #[
			new JField().withName(JavaNames::javaName(required).toFirstLower).withType(JavaNames::javaName(required.requiredInterface__OperationRequiredRole))
			]
		}
		results
	}
	
	
}
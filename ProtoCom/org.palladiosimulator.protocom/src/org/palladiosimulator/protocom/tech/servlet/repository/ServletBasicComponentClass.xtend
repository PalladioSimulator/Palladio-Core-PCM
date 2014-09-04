package org.palladiosimulator.protocom.tech.servlet.repository

import de.uka.ipd.sdq.pcm.repository.BasicComponent
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole
import org.palladiosimulator.protocom.lang.java.impl.JField
import org.palladiosimulator.protocom.lang.java.impl.JMethod
import org.palladiosimulator.protocom.lang.java.util.JavaNames
import org.palladiosimulator.protocom.tech.servlet.ServletClass
import org.palladiosimulator.protocom.tech.servlet.util.PcmServletProtoAction
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour

class ServletBasicComponentClass extends ServletClass<BasicComponent> {
	new(BasicComponent pcmEntity) {
		super(pcmEntity)
	}
	
	override interfaces() {
		#[JavaNames::interfaceName(pcmEntity)]
	}
	
	override constructors() {
		#[
			new JMethod()
				.withParameters("String location, String assemblyContext")
				.withImplementation('''
					«frameworkBase».common.LocalComponentRegistry.getInstance().addComponent(assemblyContext, this);
					
					java.util.ArrayList<«frameworkBase».http.Parameter> params = new java.util.ArrayList<«frameworkBase».http.Parameter>(3);
					params.add(new «frameworkBase».http.Parameter("action", "start"));
					params.add(new «frameworkBase».http.Parameter("location", location));
					params.add(new «frameworkBase».http.Parameter("assemblyContext", assemblyContext));
					
					«FOR role : pcmEntity.providedRoles_InterfaceProvidingEntity.filter[OperationProvidedRole.isInstance(it)].map[it as OperationProvidedRole]»
						«frameworkBase».http.Request.get(location, "/«JavaNames::portClassName(role)»", params);
					«ENDFOR»
				''')
		]
	}
	
	override fields() {
		var result = newLinkedList
		
		result += #[
			new JField()
				.withName("context")
				.withType(JavaNames::fqnContextInterface(pcmEntity))
		]
		
		result
	}
	
	override methods() {
		var result = newLinkedList
		
		result +=
			new JMethod()
				.withName("setContext")
				.withParameters("Object context")
				.withImplementation("this.context = (" + JavaNames::fqnContextInterface(pcmEntity) + ") context;")
		
		// Generate SEFFs.
		result += pcmEntity.serviceEffectSpecifications__BasicComponent.map[
			new JMethod()
				.withName(JavaNames::serviceName(it.describedService__SEFF))
				.withReturnType('''«frameworkBase».stubs.SimulatedStackframe<Object>''')
				.withParameters('''«frameworkBase».stubs.StackContext ctx''')
				.withImplementation('''
					org.apache.log4j.Logger.getRootLogger().info("Invoke '«JavaNames::serviceName(it.describedService__SEFF)»'");
					«new PcmServletProtoAction().actions((it as ResourceDemandingBehaviour).steps_Behaviour.get(0))»
					return null;
				''')
		]
		
		result
	}
}

package org.palladiosimulator.protocom.tech.servlet.repository

import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole
import de.uka.ipd.sdq.pcm.repository.ProvidedRole
import org.palladiosimulator.protocom.lang.java.impl.JAnnotation
import org.palladiosimulator.protocom.lang.java.impl.JField
import org.palladiosimulator.protocom.lang.java.impl.JMethod
import org.palladiosimulator.protocom.lang.java.util.JavaNames
import org.palladiosimulator.protocom.tech.servlet.ServletClass

class ServletBasicComponentPortClass extends ServletClass<ProvidedRole> {
	new(ProvidedRole pcmEntity) {
		super(pcmEntity)
	}
	
	override packageName() {
		JavaNames::fqnPortPackage(pcmEntity)
	}
	
	override compilationUnitName() {
		JavaNames::portClassName(pcmEntity)
	}
	
	override superClass() {
		'''«frameworkBase».common.PortServlet<«JavaNames::fqnInterface(pcmEntity.providingEntity_ProvidedRole)»>'''
	}
	
	override interfaces() {
		if (pcmEntity instanceof OperationProvidedRole) {
			#[JavaNames::fqn(pcmEntity.providedInterface__OperationProvidedRole)]
		}
	}
	
	override annotations() {
		#[
			/*new JAnnotation()
				.withName("javax.servlet.annotation.WebServlet")
				.withValues(#['''urlPatterns = "/«compilationUnitName»"''', "loadOnStartup = 0"])*/
			
			/*new JAnnotation()
				.withName("javax.inject.Singleton")*/
		]
	}
	
	override fields() {
		#[
			new JField()
				.asDefaultSerialVersionUID()
		]
	}
	
	override methods() {
		var String iface
		
		if (pcmEntity instanceof OperationProvidedRole) {
			iface = JavaNames::fqn(pcmEntity.providedInterface__OperationProvidedRole)
		}
		
		var result = newLinkedList
		
		result += 
			new JMethod()
				.withVisibilityModifier("public")
				.withParameters("String componentId, String assemblyContext")
				.withName("start")
				.withThrows('''«frameworkBase».modules.ModuleStartException''')
				.withImplementation('''
					this.component = («JavaNames::fqnInterface(pcmEntity.providingEntity_ProvidedRole)») «frameworkBase».common.LocalComponentRegistry.getInstance().getComponent(assemblyContext);
					
					try {
						Class<?>[] interfaces = new Class<?>[] {«iface».class, «frameworkBase».common.IPort.class};
						«frameworkBase».registry.Registry.getInstance().register("«JavaNames::portClassName(pcmEntity)»" + "_" + assemblyContext, interfaces, location, "/«JavaNames::portClassName(pcmEntity)»");
					} catch («frameworkBase».registry.RegistryException e) {
						throw new «frameworkBase».modules.ModuleStartException();
					}
				''')
				
		result += 
			new JMethod()
				.withVisibilityModifier("public")
				.withParameters("Object context")
				.withName("setContext")
				.withImplementation('''
					this.component.setContext(context);
				''')
		
		if (pcmEntity instanceof OperationProvidedRole) {
			result += providedRoleMethods(pcmEntity)
		}
		
		result
	}
	
	override filePath() {
		"/src/" + JavaNames::fqnToDirectoryPath(JavaNames::fqnPortPackage(pcmEntity)) + "/" + JavaNames::portClassName(pcmEntity) + ".java"
	}
	
	def providedRoleMethods(OperationProvidedRole role) {
		role.providedInterface__OperationProvidedRole.signatures__OperationInterface.map[
			new JMethod()
				.withName(JavaNames::javaSignature(it))
				.withReturnType('''«frameworkBase».stubs.SimulatedStackframe<Object>''')
				.withParameters('''«frameworkBase».stubs.StackContext ctx''')
				.withImplementation('''
					preCall("«JavaNames::serviceName(it)»");
					«frameworkBase».stubs.SimulatedStackframe<Object> result = component.«JavaNames::serviceName(it)»(ctx);
					postCall("«JavaNames::serviceName(it)»");
					
					return result;
				''')
		] 
	}
}

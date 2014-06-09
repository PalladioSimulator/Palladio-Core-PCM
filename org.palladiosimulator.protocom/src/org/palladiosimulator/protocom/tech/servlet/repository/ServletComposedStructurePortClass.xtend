package org.palladiosimulator.protocom.tech.servlet.repository

import org.palladiosimulator.protocom.tech.servlet.ServletClass
import de.uka.ipd.sdq.pcm.repository.ProvidedRole
import org.palladiosimulator.protocom.lang.java.util.JavaNames
import org.palladiosimulator.protocom.lang.java.impl.JMethod
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole
import org.palladiosimulator.protocom.lang.java.impl.JField
import org.palladiosimulator.protocom.lang.java.impl.JAnnotation

class ServletComposedStructurePortClass extends ServletClass<ProvidedRole> {
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
	
	override annotations() {
		#[
			new JAnnotation()
				.withName("javax.servlet.annotation.WebServlet")
				.withValues(#['''urlPatterns = "/«compilationUnitName»"''', "loadOnStartup = 0"])
		]
	}
	
	override fields() {
		#[
			new JField()
				.asDefaultSerialVersionUID(), 
			
			new JField()
				.withName("compositeComponentOrSystem")
				.withType(JavaNames::fqnInterface(pcmEntity.providingEntity_ProvidedRole)),
			
			new JField()
				.withName("innerPort")
				.withType(JavaNames::fqn((pcmEntity as OperationProvidedRole).providedInterface__OperationProvidedRole))
		]
	}
	
	override constructors() {
		#[
			new JMethod()
				.withParameters(JavaNames::fqn((pcmEntity as OperationProvidedRole).providedInterface__OperationProvidedRole) + " innerPort, " + JavaNames::fqnInterface(pcmEntity.providingEntity_ProvidedRole) + " compositeComponentOrSystem, String assemblyContext")
				.withImplementation('''
					this.innerPort = innerPort;
					this.compositeComponentOrSystem = compositeComponentOrSystem;
					
					//«frameworkBase».registry.Registry.register();
					
					//org.palladiosimulator.protocom.framework.registry.RmiRegistry.registerPort(org.palladiosimulator.protocom.framework.registry.RmiRegistry.getRemoteAddress(),
					//org.palladiosimulator.protocom.framework.registry.RmiRegistry.getRegistryPort(), this, "«JavaNames::portClassName(pcmEntity)»_" + assemblyContext);
				''')
		]
	}
	
	override filePath() {
		"/src/" + JavaNames::fqnToDirectoryPath(JavaNames::fqnPortPackage(pcmEntity)) + "/" + JavaNames::portClassName(pcmEntity) + ".java"
	}
}
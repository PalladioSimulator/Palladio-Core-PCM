package com.palladio_simulator.protocom.tech.rmi

import de.uka.ipd.sdq.pcm.repository.ProvidedRole
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole

import de.uka.ipd.sdq.pcm.repository.InfrastructureProvidedRole
import com.palladio_simulator.protocom.lang.java.util.JavaNames
import com.palladio_simulator.protocom.lang.java.impl.JMethod
import com.palladio_simulator.protocom.lang.java.util.PcmCommons
import com.palladio_simulator.protocom.lang.java.util.JavaConstants

/**
 * Provider for port classes based on provided roles. Please not that InfrastructureProvidedRoles
 * were - to some degree - hacked into the PCM such that cumbersome case distinction for
 * Operation and Infrastructure is necessary.
 * 
 * Possible TODO is to split PojoBasicComponentPortClass into two classes with a common super type.
 * Keep in mind though that InfrastructureComponents in ProtoCom are not generated, but rather calls 
 * to the real infrastructure!
 * 
 * @author Thomas Zolynski
 */
class PojoBasicComponentPortClass extends PojoClass<ProvidedRole> {
	
	new(ProvidedRole pcmEntity) {
		super(pcmEntity)
	}
	
	override superClass() {
		'''com.palladio_simulator.protocom.framework.port.AbstractBasicPort<«JavaNames::fqnInterface(pcmEntity.providingEntity_ProvidedRole)»>'''
	}
	
	override packageName() {
		JavaNames::fqnPortPackage(pcmEntity)
	}
	
	override compilationUnitName() {
		JavaNames::portClassName(pcmEntity)
	}
	
	override interfaces() {
		#[ providedRoleInterface(pcmEntity)	]
	}
	
	override constructors() {
		#[
			new JMethod()
				.withParameters(JavaNames::fqnInterface(pcmEntity.providingEntity_ProvidedRole) + " myComponent, String assemblyContext")
				.withThrows("java.rmi.RemoteException")
				.withImplementation('''
					addVisitor(com.palladio_simulator.protocom.framework.visitor.SensorFrameworkVisitor.getInstance());
				
					this.myComponent = myComponent;
					com.palladio_simulator.protocom.framework.registry.RmiRegistry.registerPort(com.palladio_simulator.protocom.framework.registry.RmiRegistry.getRemoteAddress(),
					com.palladio_simulator.protocom.framework.registry.RmiRegistry.getRegistryPort(), this, "«JavaNames::portClassName(pcmEntity)»_" + assemblyContext);
					''')
		]
	}
	
	override methods() {
		providedRoleMethods(pcmEntity)
	}
	
	override filePath() {
		JavaNames::fqnToDirectoryPath(JavaNames::fqnPortPackage(pcmEntity)) + "/" + JavaNames::portClassName(pcmEntity) + ".java"
	}
	
	
	def dispatch providedRoleMethods(OperationProvidedRole role) {
		role.providedInterface__OperationProvidedRole.signatures__OperationInterface.map[
			new JMethod()
				.withName(JavaNames::javaSignature(it))
				.withReturnType(PcmCommons::stackframeType)
				.withParameters(PcmCommons::stackContextParameterList)
				.withImplementation('''
					preCallVisitor(ctx, "«JavaNames::serviceName(it)»");
					de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> result = myComponent.«JavaNames::serviceName(it)»(ctx);
					postCallVisitor(ctx, "«JavaNames::serviceName(it)»");

					return result;
				''')
				.withThrows(JavaConstants::RMI_REMOTE_EXCEPTION)
		] 
	}
	
	def dispatch providedRoleMethods(InfrastructureProvidedRole role) {
		role.providedInterface__InfrastructureProvidedRole.infrastructureSignatures__InfrastructureInterface.map[	
			new JMethod()
				.withName(JavaNames::javaSignature(it))
				.withReturnType(PcmCommons::stackframeType)
				.withParameters(PcmCommons::stackContextParameterList)
				.withImplementation("return null;")
				.withThrows(JavaConstants::RMI_REMOTE_EXCEPTION)
		] 
	}
	
	def dispatch providedRoleInterface(OperationProvidedRole role) {
		JavaNames::fqn(role.providedInterface__OperationProvidedRole)
	}
	
	def dispatch providedRoleInterface(InfrastructureProvidedRole role) {
		JavaNames::fqn(role.providedInterface__InfrastructureProvidedRole)
	}
	
}
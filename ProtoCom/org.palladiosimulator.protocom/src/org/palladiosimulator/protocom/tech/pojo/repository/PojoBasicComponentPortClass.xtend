package org.palladiosimulator.protocom.tech.pojo.repository

import de.uka.ipd.sdq.pcm.repository.InfrastructureProvidedRole
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole
import de.uka.ipd.sdq.pcm.repository.ProvidedRole
import org.palladiosimulator.protocom.lang.java.impl.JMethod
import org.palladiosimulator.protocom.lang.java.util.DataTypes
import org.palladiosimulator.protocom.lang.java.util.JavaConstants
import org.palladiosimulator.protocom.lang.java.util.JavaNames
import org.palladiosimulator.protocom.lang.java.util.Parameters
import org.palladiosimulator.protocom.tech.rmi.PojoClass

/**
 * Provider for port classes based on provided roles. Please note that InfrastructureProvidedRoles
 * were - to some degree - hacked into the PCM such that cumbersome case distinction for
 * Operation and Infrastructure is necessary.
 * 
 * Possible TODO is to split PojoBasicComponentPortClass into two classes with a common super type.
 * Keep in mind though that InfrastructureComponents in ProtoCom are not generated, but rather calls 
 * to the real infrastructure!
 * 
 * TODO Code stubs may also use CallVistitors like the performance prototype implementation. 
 *      Note that, in this case, the ctx object might simply be removed. 
 * 
 * @author Sebastian Lehrig
 */
class PojoBasicComponentPortClass extends PojoClass<ProvidedRole> {

	new(ProvidedRole pcmEntity) {
		super(pcmEntity)
	}

	override superClass() {
		'''org.palladiosimulator.protocom.framework.port.AbstractBasicPort<«JavaNames::fqnInterface(
			pcmEntity.providingEntity_ProvidedRole)»>'''
	}

	override packageName() {
		JavaNames::fqnPortPackage(pcmEntity)
	}

	override compilationUnitName() {
		JavaNames::portClassName(pcmEntity)
	}

	override interfaces() {
		#[providedRoleInterface(pcmEntity)]
	}

	override constructors() {
		#[
			new JMethod().withParameters(
				JavaNames::fqnInterface(pcmEntity.providingEntity_ProvidedRole) + " myComponent, String assemblyContext").
				withThrows("java.rmi.RemoteException").withImplementation(
					'''
						this.myComponent = myComponent;
						org.palladiosimulator.protocom.framework.registry.RmiRegistry.registerPort(org.palladiosimulator.protocom.framework.registry.RmiRegistry.getRemoteAddress(),
						org.palladiosimulator.protocom.framework.registry.RmiRegistry.getRegistryPort(), this, "«JavaNames::
							portClassName(pcmEntity)»_" + assemblyContext);
					''')
		]
	}

	override methods() {
		providedRoleMethods(pcmEntity)
	}

	override filePath() {
		JavaNames::fqnToDirectoryPath(JavaNames::fqnPortPackage(pcmEntity)) + "/" + JavaNames::portClassName(pcmEntity) +
			".java"
	}

	def dispatch providedRoleMethods(OperationProvidedRole role) {
		role.providedInterface__OperationProvidedRole.signatures__OperationInterface.map [
			new JMethod().withName(JavaNames::javaName(it)).withReturnType(
				DataTypes::getDataType(it.returnType__OperationSignature)).withParameters(Parameters::getParameterList(it)).
				withImplementation(
					'''
						«IF (!DataTypes::getReturnDataType(it).equals("void"))»
							return 
						«ENDIF»
							myComponent.«JavaNames::serviceNameStub(it)»(«Parameters::getParameterUsageList(it)»);
					''').withThrows(JavaConstants::RMI_REMOTE_EXCEPTION)
		]
	}

	def dispatch providedRoleMethods(InfrastructureProvidedRole role) {
		role.providedInterface__InfrastructureProvidedRole.infrastructureSignatures__InfrastructureInterface.map [
			new JMethod().withName(JavaNames::javaName(it)).withReturnType("void").withParameters(
				Parameters::getParameterList(it)).withImplementation("return null;").withThrows(
				JavaConstants::RMI_REMOTE_EXCEPTION)
		]
	}

	def dispatch providedRoleInterface(OperationProvidedRole role) {
		JavaNames::fqn(role.providedInterface__OperationProvidedRole)
	}

	def dispatch providedRoleInterface(InfrastructureProvidedRole role) {
		JavaNames::fqn(role.providedInterface__InfrastructureProvidedRole)
	}

}

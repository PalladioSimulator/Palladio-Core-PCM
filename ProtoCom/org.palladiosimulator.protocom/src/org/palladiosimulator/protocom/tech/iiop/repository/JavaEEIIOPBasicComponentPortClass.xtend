package org.palladiosimulator.protocom.tech.iiop.repository

import de.uka.ipd.sdq.pcm.repository.InfrastructureProvidedRole
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole
import de.uka.ipd.sdq.pcm.repository.ProvidedRole
import org.palladiosimulator.protocom.lang.java.impl.JField
import org.palladiosimulator.protocom.lang.java.impl.JMethod
import org.palladiosimulator.protocom.lang.java.util.JavaNames
import org.palladiosimulator.protocom.lang.java.util.PcmCommons
import org.palladiosimulator.protocom.tech.iiop.JavaEEIIOPClass

class JavaEEIIOPBasicComponentPortClass extends JavaEEIIOPClass<ProvidedRole> {
	
	new(ProvidedRole pcmEntity) {
		super(pcmEntity)
	}
	
	override superClass() {
		'''org.palladiosimulator.protocom.framework.port.AbstractPerformancePrototypeBasicPort<«JavaNames::fqnJavaEEComponentPortSuperClass(pcmEntity.providingEntity_ProvidedRole)»>'''
	}
	
	override packageName() {
		JavaNames::fqnJavaEEPortPackage(pcmEntity)
	}
	
	override compilationUnitName() {
		JavaNames::portClassName(pcmEntity)
	}
	
	override interfaces() {
		#[ providedRoleInterface(pcmEntity)	]
	}
	
	override constructors() {
		#[ 	new JMethod()
			.withThrows("java.rmi.RemoteException"),
			new JMethod()
				.withParameters("String assemblyContext")
				.withImplementation('''
					addVisitor(org.palladiosimulator.protocom.framework.visitor.SensorFrameworkVisitor.getInstance());
					''')
				.withThrows("java.rmi.RemoteException")
		]
	}
	
	override methods() {
		providedRoleMethods(pcmEntity)
	}
	
	
	override filePath() {
	//	JavaNames::fqnToDirectoryPath(JavaNames::fqnPortPackage(pcmEntity)) + "/" + JavaNames::portClassName(pcmEntity) + ".java"
		JavaNames::fqnJavaEEBasicComponentPortClassPath(pcmEntity)
	}
	
	override projectName(){
		JavaNames::fqnJavaEEBasicComponentPortProjectName(pcmEntity)
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
		] 
	}
	
	def dispatch providedRoleMethods(InfrastructureProvidedRole role) {
		role.providedInterface__InfrastructureProvidedRole.infrastructureSignatures__InfrastructureInterface.map[	
			new JMethod()
				.withName(JavaNames::javaSignature(it))
				.withReturnType(PcmCommons::stackframeType)
				.withParameters(PcmCommons::stackContextParameterList)
				.withImplementation("return null;")
		] 
	}
	
	def dispatch providedRoleInterface(OperationProvidedRole role) {
		JavaNames::fqnJavaEEComponentPortInterface(role)
	}
	
	def dispatch providedRoleInterface(InfrastructureProvidedRole role) {
		JavaNames::fqnJavaEEComponentPortInterface(role)
	}
	
	override jeeClassDependencyInjection(){
		val results = newLinkedList
		
		results+= #[
			new JField().withName("myComponent").withType(JavaNames::javaName(pcmEntity.providingEntity_ProvidedRole))
			
		]
		
		results
	}
	
}
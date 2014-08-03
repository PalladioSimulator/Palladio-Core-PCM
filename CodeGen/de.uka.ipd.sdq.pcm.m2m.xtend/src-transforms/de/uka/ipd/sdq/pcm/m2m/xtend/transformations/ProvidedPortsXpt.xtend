package de.uka.ipd.sdq.pcm.m2m.xtend.transformations

import com.google.inject.Inject
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure
import de.uka.ipd.sdq.pcm.core.entity.ComposedProvidingRequiringEntity
import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity
import de.uka.ipd.sdq.pcm.m2m.xtend.helper.M2TFileSystemAccess
import de.uka.ipd.sdq.pcm.repository.InfrastructureInterface
import de.uka.ipd.sdq.pcm.repository.InfrastructureProvidedRole
import de.uka.ipd.sdq.pcm.repository.InfrastructureSignature
import de.uka.ipd.sdq.pcm.repository.OperationInterface
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole
import de.uka.ipd.sdq.pcm.repository.OperationSignature
import edu.kit.student.dwerle.xtendfw.annotations.ModelIn

@ModelIn(#[
	"pcm.core.composition.ComposedStructure",
	"pcm.core.entity.ComposedProvidingRequiringEntity",
	"pcm.core.entity.InterfaceProvidingEntity",
	"pcm.repository.InfrastructureInterface",
	"pcm.repository.InfrastructureProvidedRole",
	"pcm.repository.InfrastructureSignature",
	"pcm.repository.OperationInterface",
	"pcm.repository.OperationProvidedRole",
	"pcm.repository.OperationSignature"
])
abstract class ProvidedPortsXpt {
	@Inject M2TFileSystemAccess fsa

	@Inject extension JavaNamesExt
	@Inject extension JavaCoreXpt

	// Generate a class for each provided role implementing the interface of that role
	// This so called port delegates to implementations in the main component class
	// Additionally, generate a local member variable for my provided roles/ports and a
	// respective getter
	def dispatch providedPorts(InterfaceProvidingEntity entity) '''
		«val operationProvidedRoles =
			entity.providedRoles_InterfaceProvidingEntity.filter(typeof(OperationProvidedRole))»
		«val infrastructureProvidedRoles =
			entity.providedRoles_InterfaceProvidingEntity.filter(typeof(InfrastructureProvidedRole))»
		«FOR role : operationProvidedRoles»«role.portImplFile»«ENDFOR»
		«FOR role : infrastructureProvidedRoles»«role.portImplFile»«ENDFOR»
		«FOR role : operationProvidedRoles»«role.portMemberVars»«ENDFOR»
		«FOR role : infrastructureProvidedRoles»«role.portMemberVars»«ENDFOR»
		«FOR role : operationProvidedRoles»«role.portGetter»«ENDFOR»
		«FOR role : infrastructureProvidedRoles»«role.portGetter»«ENDFOR»
	'''
	
	def dispatch providedPorts(ComposedProvidingRequiringEntity entity) '''
		«val operationProvidedRoles =
			entity.providedRoles_InterfaceProvidingEntity.filter(typeof(OperationProvidedRole))»
		«val infrastructureProvidedRoles =
			entity.providedRoles_InterfaceProvidingEntity.filter(typeof(InfrastructureProvidedRole))»
		«FOR role : operationProvidedRoles»«role.composedStructurePortImplFile(entity)»«ENDFOR»
		«FOR role : infrastructureProvidedRoles»«role.composedStructurePortImplFile(entity)»«ENDFOR»
		«FOR role : operationProvidedRoles»«role.contextPortGetter(entity)»«ENDFOR»
		«FOR role : infrastructureProvidedRoles»«role.contextPortGetter(entity)»«ENDFOR»
		«FOR role : operationProvidedRoles»«role.portGetter»«ENDFOR»
		«FOR role : infrastructureProvidedRoles»«role.portGetter»«ENDFOR»
	'''
	
	def dispatch portImplFile(OperationProvidedRole role) {
		val fileName = role.fqnPortPackage.fqnToDirectoryPath+"/"+role.portClassName+".java"
		val fileContent = '''
			package «role.fqnPortPackage»;
			«role.portImpl»
		'''
		
		fsa.generateFile(fileName, fileContent)
	}

	def dispatch portImplFile(InfrastructureProvidedRole role) {
		val fileName = role.fqnPortPackage.fqnToDirectoryPath+"/"+role.portClassName+".java"
		val fileContent = '''
			package «role.fqnPortPackage»;
			«role.portImpl»
		'''
		
		fsa.generateFile(fileName, fileContent)
	}
	
	def dispatch composedStructurePortImplFile(OperationProvidedRole role,
		ComposedProvidingRequiringEntity cs) {
		
		val fileName = role.fqnPortPackage.fqnToDirectoryPath+"/"+role.portClassName+".java"
		val fileContent = '''
			package «role.fqnPortPackage»;
			«role.composedStructurePortImpl(cs)»
		'''

		fsa.generateFile(fileName, fileContent)
	}

	def dispatch composedStructurePortImplFile(InfrastructureProvidedRole role,
		ComposedProvidingRequiringEntity cs) {
		
		val fileName = role.fqnPortPackage.fqnToDirectoryPath+"/"+role.portClassName+".java"
		val fileContent = '''
			package «role.fqnPortPackage»;
			«role.composedStructurePortImpl(cs)»
		'''

		fsa.generateFile(fileName, fileContent)
	}
	
	def dispatch portImpl(OperationProvidedRole role) '''
		// Port class for «role.portClassName»
		public class «role.portClassName» implements «role.providedInterface__OperationProvidedRole.fqn», java.io.Serializable
		{
		     protected «role.providingEntity_ProvidedRole.fqnInterface» myComponent = null;
		     
		     public «role.portClassName»(){}
		     
		     public «role.portClassName»(«role.providingEntity_ProvidedRole.fqnInterface» myComponent){
		        this.myComponent = myComponent;
		     }
		     
		     «role.componentPortHelperMethodsTM»
		     «FOR signature : role.providedInterface__OperationProvidedRole.signatures__OperationInterface»
		     	«signature.portDelegator»
		     «ENDFOR»
		}
	'''

	def dispatch portImpl(InfrastructureProvidedRole role) '''
		// Port class for «role.portClassName»
		public class «role.portClassName» implements «role.providedInterface__InfrastructureProvidedRole.fqn»
		{
		     protected «role.providingEntity_ProvidedRole.fqnInterface» myComponent = null;
		     
		     public «role.portClassName»(){}
		     
		     public «role.portClassName»(«role.providingEntity_ProvidedRole.fqnInterface» myComponent){
		        this.myComponent = myComponent;
		     }
		     
		     «role.componentPortHelperMethodsTM»
		     «FOR signature : role.providedInterface__InfrastructureProvidedRole.infrastructureSignatures__InfrastructureInterface»
		     	«signature.portDelegator»
		     «ENDFOR»
		}
	'''
		
	def dispatch componentPortHelperMethodsTM(OperationProvidedRole role) ''''''
	def dispatch componentPortHelperMethodsTM(InfrastructureProvidedRole role) ''''''
	
	def dispatch composedStructurePortImpl(OperationProvidedRole role, ComposedProvidingRequiringEntity cs) '''
		// Port class for «role.portClassName»
		public class «role.portClassName» implements «role.providedInterface__OperationProvidedRole.fqn», java.io.Serializable
		{
			private static org.apache.log4j.Logger logger = 
				org.apache.log4j.Logger.getLogger(«role.portClassName».class.getName());

			protected «role.providedInterface__OperationProvidedRole.fqn» myInnerPort = null;

			public «role.portClassName»(«role.providedInterface__OperationProvidedRole.fqn» myInnerPort){
				this.myInnerPort = myInnerPort;
			}

			«role.providedInterface__OperationProvidedRole.composedComponentPortHelperMethodsTM»
	     	«FOR signature : role.providedInterface__OperationProvidedRole.signatures__OperationInterface»
	     		«signature.composedStructurePortDelegator(cs)»
	     	«ENDFOR»
		}
	'''

	def dispatch composedStructurePortImpl(InfrastructureProvidedRole role, ComposedProvidingRequiringEntity cs) '''
		// Port class for «role.portClassName»
		public class «role.portClassName» implements «role.providedInterface__InfrastructureProvidedRole.fqn», java.io.Serializable
		{
			private static org.apache.log4j.Logger logger = 
				org.apache.log4j.Logger.getLogger(«role.portClassName».class.getName());

			protected «role.providedInterface__InfrastructureProvidedRole.fqn» myInnerPort = null;

			public «role.portClassName»(«role.providedInterface__InfrastructureProvidedRole.fqn» myInnerPort){
				this.myInnerPort = myInnerPort;
			}

	     	«role.providedInterface__InfrastructureProvidedRole.composedComponentPortHelperMethodsTM»
	     	«FOR signature : role.providedInterface__InfrastructureProvidedRole.infrastructureSignatures__InfrastructureInterface»
	     		«signature.composedStructurePortDelegator(cs)»
	     	«ENDFOR»
		}
	'''
	
	def dispatch composedComponentPortHelperMethodsTM(OperationInterface iface) ''''''
	def dispatch composedComponentPortHelperMethodsTM(InfrastructureInterface iface) ''''''

	def dispatch portDelegator(OperationSignature signature) '''
		public «signature.operationSignature» {
			«signature.portDelegationDelegatingCallTM»
		}
	'''

	def dispatch portDelegator(InfrastructureSignature signature) '''
		public «signature.infrastructureSignature» {
			«signature.portDelegationDelegatingCallTM»
		}
	'''
	
	def dispatch composedStructurePortDelegator(OperationSignature signature,
		ComposedProvidingRequiringEntity cs) '''
		public «signature.operationSignature» {
			«signature.composedStructurePortDelegationDelegatingCallTM(cs)»
		}
	'''

	def dispatch composedStructurePortDelegator(InfrastructureSignature signature,
		ComposedProvidingRequiringEntity cs) '''
		public «signature.infrastructureSignature» {
			«signature.composedStructurePortDelegationDelegatingCallTM(cs)»
		}
	'''
	
	def dispatch portDelegationDelegatingCallTM(OperationSignature signature) '''«/* error */»'''
	def dispatch portDelegationDelegatingCallTM(InfrastructureSignature signature) '''«/* error */»'''

	def dispatch composedStructurePortDelegationDelegatingCallTM(OperationSignature signature,
		ComposedProvidingRequiringEntity cs) '''«/* error */»'''
	def dispatch composedStructurePortDelegationDelegatingCallTM(InfrastructureSignature signature,
		ComposedProvidingRequiringEntity cs) '''«/* error */»'''
		
	def dispatch portMemberVars(OperationProvidedRole role) '''
		protected «role.fqnPort» «role.portMemberVar» = new «role.fqnPort»(this);
	'''

	def dispatch portMemberVars(InfrastructureProvidedRole role) '''
		protected «role.fqnPort» «role.portMemberVar» = new «role.fqnPort»(this);
	'''
	
	def dispatch contextPortGetter(OperationProvidedRole role, ComposedStructure cs) '''
		protected «role.fqnPort» «role.portMemberVar» = null;
	'''

	def dispatch contextPortGetter(InfrastructureProvidedRole role, ComposedStructure cs) '''
		protected «role.fqnPort» «role.portMemberVar» = null;
	'''
	
	def dispatch portGetter(OperationProvidedRole role) '''
		public «role.providedInterface__OperationProvidedRole.fqn» «role.portGetterName»() {
			return «role.portMemberVar»;
		}
	'''

	def dispatch portGetter(InfrastructureProvidedRole role) '''
		public «role.providedInterface__InfrastructureProvidedRole.fqn» «role.portGetterName»() {
			return «role.portMemberVar»;
		}
	'''
	
	def dispatch portGetterDefinition(OperationProvidedRole role) '''
	«/* Definition of port getter which is generated by provided_ports.xpt#PortGetter. Need this in interface to access component on EJB Server. */»
		public «role.providedInterface__OperationProvidedRole.fqn» «role.portGetterName»();
	'''	

	def dispatch portGetterDefinition(InfrastructureProvidedRole role) '''
	«/* Definition of port getter which is generated by provided_ports.xpt#PortGetter. Need this in interface to access component on EJB Server. */»
		public «role.providedInterface__InfrastructureProvidedRole.fqn» «role.portGetterName»();
	'''
	
	// Generate method signatures for basic component port getters
	def dispatch componentPortGetter(OperationProvidedRole role) '''
		public «role.providedInterface__OperationProvidedRole.fqn» «role.portGetterName»();
	'''

	// Generate method signatures for basic component port getters
	def dispatch componentPortGetter(InfrastructureProvidedRole role) '''
		public «role.providedInterface__InfrastructureProvidedRole.fqn» «role.portGetterName»();
	'''
}
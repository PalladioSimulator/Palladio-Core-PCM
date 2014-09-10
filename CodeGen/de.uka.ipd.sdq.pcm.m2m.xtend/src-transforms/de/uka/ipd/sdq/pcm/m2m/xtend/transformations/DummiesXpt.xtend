package de.uka.ipd.sdq.pcm.m2m.xtend.transformations

import com.google.inject.Inject
import de.uka.ipd.sdq.pcm.m2m.xtend.helper.M2TFileSystemAccess
import de.uka.ipd.sdq.pcm.repository.InfrastructureInterface
import de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole
import de.uka.ipd.sdq.pcm.repository.InfrastructureSignature
import de.uka.ipd.sdq.pcm.repository.OperationInterface
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole
import de.uka.ipd.sdq.pcm.repository.OperationSignature
import de.uka.ipd.sdq.pcm.system.System
import edu.kit.ipd.sdq.xtend2m.annotations.ModelIn

@ModelIn(#[
	"pcm.system.System",
	"pcm.repository.InfrastructureInterface",
	"pcm.repository.InfrastructureRequiredRole",
	"pcm.repository.InfrastructureSignature",
	"pcm.repository.OperationInterface",
	"pcm.repository.OperationRequiredRole",
	"pcm.repository.OperationSignature"
])
abstract class DummiesXpt {
	@Inject M2TFileSystemAccess fsa
	
	@Inject extension JavaNamesExt
	@Inject extension JavaCoreXpt
	
	def dispatch void dummyComponent(OperationRequiredRole orr, System s) {
		val fileName = (s.implementationPackage()+"."+orr.fqnDummyComponent()).fqnToDirectoryPath()+".java"
		val fileContent = '''
			package «s.implementationPackage()».«orr.fqnDummyComponentPackage()»;
					
			public class «orr.dummyComponentName()» 
			implements «orr.requiredInterface__OperationRequiredRole.fqn()» {
				private static org.apache.log4j.Logger logger = 
					org.apache.log4j.Logger.getLogger(«orr.dummyComponentName()».class.getName());
				«orr.requiredInterface__OperationRequiredRole.dummyComponentPortHelperMethodTM»
				«FOR signature : orr.requiredInterface__OperationRequiredRole.signatures__OperationInterface»
				«signature.dummyMethod(s, orr)»
				«ENDFOR»
			}
		'''
		
		fsa.generateFile(fileName, fileContent)
	}
	
	def dispatch void dummyComponent(InfrastructureRequiredRole irr, System s) {
		val fileName = (s.implementationPackage()+"."+irr.fqnDummyComponent()).fqnToDirectoryPath()+".java"
		val fileContent = '''
			package «s.implementationPackage()».«irr.fqnDummyComponentPackage()»;
			
			public class «irr.dummyComponentName()» 
			implements «irr.requiredInterface__InfrastructureRequiredRole.fqn()» {
				private static org.apache.log4j.Logger logger = 
					org.apache.log4j.Logger.getLogger(«irr.dummyComponentName()».class.getName());
				«irr.requiredInterface__InfrastructureRequiredRole.dummyComponentPortHelperMethodTM»
				«FOR signature : irr.requiredInterface__InfrastructureRequiredRole.infrastructureSignatures__InfrastructureInterface»
				«signature.dummyMethod(s, irr)»
				«ENDFOR»
			}
		'''
		
		fsa.generateFile(fileName, fileContent)
	}
	
	def CharSequence dummyComponentPortHelperMethodTM(OperationInterface oi)
	
	def CharSequence dummyComponentPortHelperMethodTM(InfrastructureInterface oi)
	
	def dispatch dummyMethod(OperationSignature os, System s, OperationRequiredRole r) '''
		public «os.operationSignature» {
			«os.dummyMethodBodyTM(s, r)»
		}
	'''
	
	def dispatch dummyMethod(InfrastructureSignature is, System s, InfrastructureRequiredRole r) '''
		public «is.infrastructureSignature» {
			«is.dummyMethodBodyTM(s, r)»
		}
	'''
	
	//---------------------------------------------
	// Template method to generate code for the body
	// of dummy components attached to the unbound
	// system required roles
	//---------------------------------------------
	def CharSequence dummyMethodBodyTM(OperationSignature os, System s, OperationRequiredRole r)
	
	def CharSequence dummyMethodBodyTM(InfrastructureSignature os, System s, InfrastructureRequiredRole r)
}
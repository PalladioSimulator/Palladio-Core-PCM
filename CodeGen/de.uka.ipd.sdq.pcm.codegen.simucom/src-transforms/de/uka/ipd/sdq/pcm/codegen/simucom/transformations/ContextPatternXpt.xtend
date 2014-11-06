package de.uka.ipd.sdq.pcm.codegen.simucom.transformations

import com.google.inject.Inject
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure
import de.uka.ipd.sdq.pcm.core.entity.InterfaceRequiringEntity
import de.uka.ipd.sdq.pcm.codegen.simucom.helper.M2TFileSystemAccess
import de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole

abstract class ContextPatternXpt {
	@Inject M2TFileSystemAccess fsa
	
	@Inject extension JavaNamesExt


	def requiredInterfaces(InterfaceRequiringEntity entity) '''
		«entity.componentContextInterface»
		«entity.componentContextImpl»
		«entity.componentContextMemberVar»
		«entity.componentContextSetter»
	'''
	
	private def componentContextInterface(InterfaceRequiringEntity entity) {
		val fileName = entity.fqnContextInterface.fqnToDirectoryPath+".java"
		val fileContent = '''
			package «entity.fqnContextPackage»;

			// Component context interface for «entity.javaName»
			public interface «entity.contextInterfaceName»
			{
				«val operationRequiredRoles = entity.requiredRoles_InterfaceRequiringEntity.filter(typeof(OperationRequiredRole))»
				«val infrastructureRequiredRoles = entity.requiredRoles_InterfaceRequiringEntity.filter(typeof(InfrastructureRequiredRole))»
				«FOR role : operationRequiredRoles»«role.contextInterfaceGetterSignature»«ENDFOR»
				«FOR role : infrastructureRequiredRoles»«role.contextInterfaceGetterSignature»«ENDFOR»
				«FOR role : operationRequiredRoles»«role.contextInterfaceSetterSignature»«ENDFOR»
				«FOR role : infrastructureRequiredRoles»«role.contextInterfaceSetterSignature»«ENDFOR»
				
				«entity.contextInterfaceAdditionsTM»
			}
		'''
		
		fsa.generateFile(fileName, fileContent)
	}
	
	private def componentContextImpl(InterfaceRequiringEntity entity) {
		val fileName = entity.fqnContext.fqnToDirectoryPath+".java"
		val fileContent = '''
			package «entity.fqnContextPackage»;
			
			// Component context class for «entity.javaName»
			public class «entity.contextClassName» implements «entity.fqnContextInterface», java.io.Serializable
			{
				«val operationRequiredRoles = entity.requiredRoles_InterfaceRequiringEntity.filter(typeof(OperationRequiredRole))»
				«val infrastructureRequiredRoles = entity.requiredRoles_InterfaceRequiringEntity.filter(typeof(InfrastructureRequiredRole))»				
				«FOR role : operationRequiredRoles»«role.contextInterfaceMemberVar»«ENDFOR»
				«FOR role : infrastructureRequiredRoles»«role.contextInterfaceMemberVar»«ENDFOR»
				«FOR role : operationRequiredRoles»«role.contextInterfaceGetter»«ENDFOR»
				«FOR role : infrastructureRequiredRoles»«role.contextInterfaceGetter»«ENDFOR»
				«FOR role : operationRequiredRoles»«role.contextInterfaceSetter»«ENDFOR»
				«FOR role : infrastructureRequiredRoles»«role.contextInterfaceSetter»«ENDFOR»
			
			
				public «entity.contextClassName» () {
				}

				«IF entity.requiredRoles_InterfaceRequiringEntity.size > 0»			
				public «entity.contextClassName» (
					«FOR role : operationRequiredRoles SEPARATOR ","»«role.contextInterfaceVar»«ENDFOR»
					«IF (infrastructureRequiredRoles.size > 0)»
						«IF operationRequiredRoles.size > 0», «ENDIF»
						«FOR role : infrastructureRequiredRoles SEPARATOR ","»«role.contextInterfaceVar»«ENDFOR»
					«ENDIF»
					) {
					«FOR role : operationRequiredRoles»«role.contextInterfaceInitialisation»«ENDFOR»
					«FOR role : infrastructureRequiredRoles»«role.contextInterfaceInitialisation»«ENDFOR»
				}
				«ENDIF»
				
				«entity.componentContextImplAdditionsTM»
			}
		'''
		
		fsa.generateFile(fileName, fileContent)
	}
	
	private def componentContextMemberVar(InterfaceRequiringEntity entity) '''
		protected «entity.fqnContextInterface» myContext = null;
	'''
	
	private def componentContextSetter(InterfaceRequiringEntity entity) '''
		public void setContext(«entity.fqnContextInterface» myContext) {
			this.myContext = myContext;
			«IF entity instanceof ComposedStructure»
				initInnerComponents();
			«ENDIF»
		}
	'''
	
	def componentContextSetterDefinition(InterfaceRequiringEntity entity) '''
		public void setContext(«entity.fqnContextInterface» myContext);
	'''
	
	def dispatch contextInterfaceVar(OperationRequiredRole role) '''
		«role.requiredInterface__OperationRequiredRole.fqn» «role.javaName.toFirstLower»
	'''
	
	def dispatch contextInterfaceVar(InfrastructureRequiredRole role) '''
		«role.requiredInterface__InfrastructureRequiredRole.fqn» «role.javaName.toFirstLower»
	'''
	
	def dispatch contextInterfaceInitialisation(OperationRequiredRole role) '''
		this.«role.javaName.toFirstLower» = «role.javaName.toFirstLower»;
	'''

	def dispatch contextInterfaceInitialisation(InfrastructureRequiredRole role) '''
		this.«role.javaName.toFirstLower» = «role.javaName.toFirstLower»;
	'''
	
	def dispatch contextInterfaceMemberVar(OperationRequiredRole role) '''
		protected «role.requiredInterface__OperationRequiredRole.fqn» «role.javaName.toFirstLower» = null;
	'''
	
	def dispatch contextInterfaceMemberVar(InfrastructureRequiredRole role) '''
		protected «role.requiredInterface__InfrastructureRequiredRole.fqn» «role.javaName.toFirstLower» = null;
	'''

	def dispatch contextInterfaceGetter(OperationRequiredRole role) '''
		public «role.requiredInterface__OperationRequiredRole.fqn» getRole«role.javaName»() {
			if («role.javaName.toFirstLower» == null) {
				throw new RuntimeException("Attempt to retrieve unbounded port. Check your architecture! "+
					"Role «role.entityName» <«role.id»> RequiringEntity «role.requiringEntity_RequiredRole.entityName»");
			}
			return «role.javaName.toFirstLower»;
		}
	'''

	def dispatch contextInterfaceGetter(InfrastructureRequiredRole role) '''
		public «role.requiredInterface__InfrastructureRequiredRole.fqn» getRole«role.javaName»() {
			if («role.javaName.toFirstLower» == null) {
				throw new RuntimeException("Attempt to retrieve unbounded port. Check your architecture! "+
					"Role «role.entityName» <«role.id»> RequiringEntity «role.requiringEntity_RequiredRole.entityName»");
			}
			return «role.javaName.toFirstLower»;
		}
	'''
	
	def dispatch contextInterfaceSetter(OperationRequiredRole role) '''
		public void setRole«role.javaName»(«role.requiredInterface__OperationRequiredRole.fqn» newValue) {
			this.«role.javaName.toFirstLower» = newValue;
		}
	'''

	def dispatch contextInterfaceSetter(InfrastructureRequiredRole role) '''
		public void setRole«role.javaName»(«role.requiredInterface__InfrastructureRequiredRole.fqn» newValue) {
			this.«role.javaName.toFirstLower» = newValue;
		}
	'''
	
	def dispatch contextInterfaceGetterSignature(OperationRequiredRole role) '''
		«role.requiredInterface__OperationRequiredRole.fqn» getRole«role.javaName»();
	'''

	def dispatch contextInterfaceGetterSignature(InfrastructureRequiredRole role) '''
		«role.requiredInterface__InfrastructureRequiredRole.fqn» getRole«role.javaName»();
	'''
	
	def dispatch contextInterfaceSetterSignature(OperationRequiredRole role) '''
		void setRole«role.javaName»(«role.requiredInterface__OperationRequiredRole.fqn» newValue);
	'''

	def dispatch contextInterfaceSetterSignature(InfrastructureRequiredRole role) '''
		void setRole«role.javaName»(«role.requiredInterface__InfrastructureRequiredRole.fqn» newValue);
	'''
	
	// ----------------------------------
	// Template method to add information to the component context
	// (here: to the interface)
	// ----------------------------------
	def contextInterfaceAdditionsTM(InterfaceRequiringEntity entity) {
	}
	
	// ----------------------------------
	// Template method to add information to the component context
	// ----------------------------------
	def componentContextImplAdditionsTM(InterfaceRequiringEntity entity) {
	}
}